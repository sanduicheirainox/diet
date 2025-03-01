/*
 * Copyright (C) 2021-2023 Illusive Soulworks
 *
 * Diet is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * Diet is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Diet.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.illusivesoulworks.diet.common.command;

import com.illusivesoulworks.diet.DietConstants;
import com.illusivesoulworks.diet.api.type.IDietGroup;
import com.illusivesoulworks.diet.common.data.suite.DietSuites;
import com.illusivesoulworks.diet.platform.Services;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;

public class DietCommand {

  public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
    final int opPermissionLevel = 2;
    LiteralArgumentBuilder<CommandSourceStack> dietCommand =
        Commands.literal("diet").requires(player -> player.hasPermission(opPermissionLevel));

    dietCommand.then(Commands.literal("get")
        .then(Commands.argument("player", EntityArgument.player())
            .then(Commands.argument("group", DietGroupArgument.group())
                .executes(ctx -> get(ctx.getSource(), EntityArgument.getPlayer(ctx, "player"),
                    DietGroupArgument.getGroup(ctx, "group"))))));

    dietCommand.then(Commands.literal("set")
        .then(Commands.argument("player", EntityArgument.player())
            .then(Commands.argument("group", DietGroupArgument.group())
                .then(Commands.argument("value", FloatArgumentType.floatArg(0.0f, 1.0f))
                    .executes(ctx -> set(ctx.getSource(), EntityArgument.getPlayer(ctx, "player"),
                        FloatArgumentType.getFloat(ctx, "value"),
                        DietGroupArgument.getGroup(ctx, "group")))))));

    dietCommand.then(Commands.literal("add")
        .then(Commands.argument("player", EntityArgument.player())
            .then(Commands.argument("group", DietGroupArgument.group())
                .then(Commands.argument("value", FloatArgumentType.floatArg(0.0f, 1.0f))
                    .executes(
                        ctx -> modify(ctx.getSource(), EntityArgument.getPlayer(ctx, "player"),
                            FloatArgumentType.getFloat(ctx, "value"),
                            DietGroupArgument.getGroup(ctx, "group")))))));

    dietCommand.then(Commands.literal("subtract")
        .then(Commands.argument("player", EntityArgument.player())
            .then(Commands.argument("group", DietGroupArgument.group())
                .then(Commands.argument("value", FloatArgumentType.floatArg(0.0f, 1.0f))
                    .executes(
                        ctx -> modify(ctx.getSource(), EntityArgument.getPlayer(ctx, "player"),
                            -1 * FloatArgumentType.getFloat(ctx, "value"),
                            DietGroupArgument.getGroup(ctx, "group")))))));

    dietCommand.then(Commands.literal("reset")
        .then(Commands.argument("player", EntityArgument.player())
            .executes(ctx -> reset(ctx.getSource(), EntityArgument.getPlayer(ctx, "player")))));

    dietCommand.then(Commands.literal("pause")
        .then(Commands.argument("player", EntityArgument.player())
            .executes(
                ctx -> active(ctx.getSource(), EntityArgument.getPlayer(ctx, "player"), false))));

    dietCommand.then(Commands.literal("resume")
        .then(Commands.argument("player", EntityArgument.player())
            .executes(
                ctx -> active(ctx.getSource(), EntityArgument.getPlayer(ctx, "player"), true))));

    dietCommand.then(Commands.literal("clear")
        .then(Commands.argument("player", EntityArgument.player())
            .executes(ctx -> clear(ctx.getSource(), EntityArgument.getPlayer(ctx, "player")))));

    LiteralArgumentBuilder<CommandSourceStack> exportArg =
        Commands.literal("export").executes(ctx -> export(ctx.getSource(), DietCsv.ExportMode.ALL));

    exportArg.then(Commands.literal("group").then(
        Commands.argument("group", DietGroupArgument.group()).executes(
            ctx -> export(ctx.getSource(), DietGroupArgument.getGroup(ctx, "group")))));

    exportArg.then(Commands.literal("mod_id").then(
        Commands.argument("mod_id", Services.REGISTRY.getModIdArgument())
            .executes(ctx -> export(ctx.getSource(), DietCsv.ExportMode.MOD_ID,
                StringArgumentType.getString(ctx, "mod_id")))));

    exportArg.then(Commands.literal("uncategorized")
        .executes(ctx -> export(ctx.getSource(), DietCsv.ExportMode.UNCATEGORIZED)));

    exportArg.then(Commands.literal("trails")
        .executes(ctx -> export(ctx.getSource(), DietCsv.ExportMode.TRAILS)));

    dietCommand.then(exportArg);

    dispatcher.register(dietCommand);
  }

  private static int get(CommandSourceStack sender, ServerPlayer player, IDietGroup group) {
    Services.CAPABILITY.get(player).ifPresent(diet -> {
      float amount = diet.getValue(group.getName());
      sender.sendSuccess(
          Component.translatable("commands." + DietConstants.MOD_ID + ".get.success",
              Component.translatable(
                  "groups." + DietConstants.MOD_ID + "." + group.getName() + ".name"), amount * 100,
              player.getName()), true);
    });
    return Command.SINGLE_SUCCESS;
  }

  private static int set(CommandSourceStack sender, ServerPlayer player, float value,
                         IDietGroup group) {
    Services.CAPABILITY.get(player).ifPresent(diet -> {
      if (diet.getValues().containsKey(group.getName())) {
        diet.setValue(group.getName(), value);
        diet.sync();
        sender.sendSuccess(
            Component.translatable("commands." + DietConstants.MOD_ID + ".set.success",
                Component.translatable(
                    "groups." + DietConstants.MOD_ID + "." + group.getName() + ".name"),
                value * 100, player.getName()), true);
      }
    });
    return Command.SINGLE_SUCCESS;
  }

  private static int modify(CommandSourceStack sender, ServerPlayer player, float amount,
                            IDietGroup group) {

    if (amount != 0) {
      Services.CAPABILITY.get(player).ifPresent(diet -> {
        if (diet.getValues().containsKey(group.getName())) {
          diet.setValue(group.getName(), diet.getValue(group.getName()) + amount);
          diet.sync();
          String arg = amount > 0 ? "add" : "remove";
          sender.sendSuccess(
              Component.translatable("commands." + DietConstants.MOD_ID + "." + arg + ".success",
                  Component.translatable(
                      "groups." + DietConstants.MOD_ID + "." + group.getName() + ".name"),
                  amount * 100, player.getName()), true);
        }
      });
    }
    return Command.SINGLE_SUCCESS;
  }

  private static int reset(CommandSourceStack sender, ServerPlayer player) {
    Services.CAPABILITY.get(player).ifPresent(diet -> {
      DietSuites.getSuite(player.getLevel(), diet.getSuite()).ifPresent(suite -> {

        for (IDietGroup group : suite.getGroups()) {
          diet.setValue(group.getName(), group.getDefaultValue());
        }
      });
      diet.sync();
      sender.sendSuccess(
          Component.translatable("commands." + DietConstants.MOD_ID + ".reset.success",
              player.getName()), true);
    });
    return Command.SINGLE_SUCCESS;
  }

  private static int active(CommandSourceStack sender, ServerPlayer player, boolean flag) {
    Services.CAPABILITY.get(player).ifPresent(diet -> {
      diet.setActive(flag);
      diet.sync();
      String arg = flag ? "resume" : "pause";
      sender.sendSuccess(
          Component.translatable("commands." + DietConstants.MOD_ID + "." + arg + ".success",
              player.getName()), true);
    });
    return Command.SINGLE_SUCCESS;
  }

  private static int clear(CommandSourceStack sender, ServerPlayer player) {

    for (AttributeInstance instance : player.getAttributes().getDirtyAttributes()) {

      for (AttributeModifier attributeModifier : instance.getModifiers()) {

        if (attributeModifier.getName().equals("Diet group effect")) {
          instance.removeModifier(attributeModifier.getId());
        }
      }
    }
    sender.sendSuccess(Component.translatable("commands." + DietConstants.MOD_ID + ".clear.success",
        player.getName()), true);
    return Command.SINGLE_SUCCESS;
  }

  private static int export(CommandSourceStack sender, IDietGroup group) {

    if (sender.getEntity() instanceof Player) {
      sender.sendSuccess(
          Component.translatable("commands." + DietConstants.MOD_ID + ".export.started"), true);
      DietCsv.writeGroup((Player) sender.getEntity(), group);
      sender.sendSuccess(
          Component.translatable("commands." + DietConstants.MOD_ID + ".export.finished"), true);
    }
    return Command.SINGLE_SUCCESS;
  }

  private static int export(CommandSourceStack sender, DietCsv.ExportMode mode, String... args) {

    if (sender.getEntity() instanceof Player player) {
      sender.sendSuccess(
          Component.translatable("commands." + DietConstants.MOD_ID + ".export.started"), true);

      if (mode == DietCsv.ExportMode.ALL) {
        DietCsv.write(player, "");
      } else if (mode == DietCsv.ExportMode.MOD_ID) {
        DietCsv.write(player, args[0]);
      } else if (mode == DietCsv.ExportMode.UNCATEGORIZED) {
        DietCsv.writeUncategorized(player);
      } else if (mode == DietCsv.ExportMode.TRAILS) {
        DietCsv.writeTrails(player);
      }
      sender.sendSuccess(
          Component.translatable("commands." + DietConstants.MOD_ID + ".export.finished"), true);
    }
    return Command.SINGLE_SUCCESS;
  }
}
