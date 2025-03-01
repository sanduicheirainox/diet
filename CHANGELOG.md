# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).
Prior to version 2.0.0, this project used MCVERSION-MAJORMOD.MAJORAPI.MINOR.PATCH.

## [2.0.0-beta+1.19.2] - 2023.06.26
### Added
- Added Fabric and Quilt support
- Added Diet Suites, collections of groups and effects that exist on a per-player basis and can be changed
### Changed
- Updated to Minecraft 1.19.2
- Changed to Semantic Versioning
- Configuration system is now provided by SpectreLib
- Configuration files are now located in the root folder's `config` folder
- Moved diet groups and effects to new datapack system, see [here](https://docs.illusivesoulworks.com/category/diet) for
details
### Removed
- Removed `diet-groups.toml` and `diet-effects.toml` configuration files, replaced by datapacks
- Removed Origins compatibility features, to be re-added later

## [1.18.2-1.3.2.1] - 2023.06.06
### Added
- Added 5-food-group support for:
    - Delightful [#143](https://github.com/TheIllusiveC4/Diet/issues/143)
    - Large Meals [#144](https://github.com/TheIllusiveC4/Diet/issues/144)
    - Ender's Delight [#145](https://github.com/TheIllusiveC4/Diet/issues/145)

## [1.18.2-1.3.2.0] - 2022.10.11
### Added
- Added 5-food-group support for:
    - Ecologics [#129](https://github.com/TheIllusiveC4/Diet/issues/129)
    - Alex's Delight [#130](https://github.com/TheIllusiveC4/Diet/issues/130)
    - Butcher's Delight [#131](https://github.com/TheIllusiveC4/Diet/issues/131)
    - Cultural Delights [#141](https://github.com/TheIllusiveC4/Diet/issues/141)
    - Corn Delight [#140](https://github.com/TheIllusiveC4/Diet/issues/140)
- Added `increment` field to Diet status effects and attribute modifiers configurations to control how much to increment
  amounts when used with the `every` match method
- Added Swedish `sv_se` localization (thanks Regnander!) [#132](https://github.com/TheIllusiveC4/Diet/pull/132)
### Changed
- When used with the `every` match method, status effects now increment at least one level for each match even if the
  power is initially set to 0 [#139](https://github.com/TheIllusiveC4/Diet/issues/139)

## [1.18.2-1.3.1.0] - 2022.04.18
### Added
- Added `generateGroupsForEmptyItems` configuration option for enabling and disabling Diet generating food groups for
  unclassified food items [#128](https://github.com/TheIllusiveC4/Diet/issues/128)

## [1.18.2-1.3.0.1] - 2022.04.17
### Fixed
- Fixed Bread sometimes dropping out of the default Grains group [#126](https://github.com/TheIllusiveC4/Diet/issues/126)
- Fixed possible NoClassDefFoundError crashes at the cost of potentially (marginally) longer load times [#127](https://github.com/TheIllusiveC4/Diet/issues/127)

## [1.18.2-1.3.0.0] - 2022.04.14
### Added
- Added 5-food-group support for:
    - Goat Food [#125](https://github.com/TheIllusiveC4/Diet/issues/125)
- [API] Added `IDietTracker#consume(List, int, float)` for directly adding values to a player's diet through a list of
  representative or component stacks and food values
### Changed
- Updated to and requires Forge 40.0.47+

## [1.18.2-1.2.1.0] - 2022.04.04
### Added
- Added `diet:natural_regeneration` attribute for controlling natural regeneration through Diet effects [#122](https://github.com/TheIllusiveC4/Diet/issues/122)
- Added `/diet export trails` command to export data about which items are being used to generate food groups for all
  items
### Changed
- Revamped Diet value generation algorithm to be more performant and address more edge-case issues. Be aware of changes
  to food groups for existing items and report discrepancies to the issue tracker
  [#120](https://github.com/TheIllusiveC4/Diet/issues/120)
  [#83](https://github.com/TheIllusiveC4/Diet/issues/83)

## [1.18.2-1.2.0.5] - 2022.03.02
### Changed
- Updated to Minecraft 1.18.2

## [1.18.1-1.2.0.4] - 2022.02.16
### Added
- Added config option `addButton` to `diet-client.toml` for enabling/disabling the Diet button in the inventory screen

## [1.18.1-1.2.0.3] - 2022.02.10
### Added
- Added 5-food-group support for:
    - Thermal Series [#115](https://github.com/TheIllusiveC4/Diet/issues/115)
    - Minecolonies [#106](https://github.com/TheIllusiveC4/Diet/issues/106)
### Fixed
- Fixed Diet capability resetting when dying or moving dimension [#112](https://github.com/TheIllusiveC4/Diet/issues/112) [#113](https://github.com/TheIllusiveC4/Diet/issues/113)

## [1.18.1-1.2.0.2] - 2022.01.31
### Fixed
- Fixed NPE crash [#111](https://github.com/TheIllusiveC4/Diet/issues/111)
- Fixed Diet preventing certain blocks from being placed/activated [#110](https://github.com/TheIllusiveC4/Diet/issues/110)

## [1.18.1-1.2.0.1] - 2022.01.28
### Fixed
- Fixed NPE crash [#107](https://github.com/TheIllusiveC4/Diet/issues/107)
- Fixed tooltip overlays [#108](https://github.com/TheIllusiveC4/Diet/issues/108)
- Fixed fractional add amounts in attribute modifiers not being shown in the tooltip correctly

## [1.18.1-1.2.0.0] - 2022.01.27
### Changed
- Updated to Minecraft 1.18.1
- Updated to Forge 39.0+

## [1.17.1-1.1.0.0] - 2022.01.26
### Added
- Added Glow Berries to the `diet:fruits` tag.
### Changed
- Updated to Minecraft 1.17.1
- Updated to Forge 37.0+

## [1.16.5-1.0.4.1] - 2023.06.06
### Fixed
- Fixed Refined Pipes extractor attachments being unable to be placed while Diet is installed [#110](https://github.com/TheIllusiveC4/Diet/issues/110)

## [1.16.5-1.0.4.0] - 2022.04.18
### Added
- Added `generateGroupsForEmptyItems` configuration option for enabling and disabling Diet generating food groups for
  unclassified food items [#128](https://github.com/TheIllusiveC4/Diet/issues/128)

## [1.16.5-1.0.3.2] - 2022.04.17
### Fixed
- Fixed Bread sometimes dropping out of the default Grains group [#126](https://github.com/TheIllusiveC4/Diet/issues/126)
- Fixed possible NoClassDefFoundError crashes at the cost of potentially (marginally) longer load times [#127](https://github.com/TheIllusiveC4/Diet/issues/127)

## [1.16.5-1.0.3.1] - 2022.04.06
### Fixed
- Fixed mixin crash when loaded with Tough as Nails [#123](https://github.com/TheIllusiveC4/Diet/issues/123)

## [1.16.5-1.0.3.0] - 2022.04.04
### Added
- Added `diet:natural_regeneration` attribute for controlling natural regeneration through Diet effects [#122](https://github.com/TheIllusiveC4/Diet/issues/122)
- Added `/diet export trails` command to export data about which items are being used to generate food groups for all
  items
### Changed
- Revamped Diet value generation algorithm to be more performant and address more edge-case issues. Be aware of changes
  to food groups for existing items and report discrepancies to the issue tracker
  [#120](https://github.com/TheIllusiveC4/Diet/issues/120)
  [#83](https://github.com/TheIllusiveC4/Diet/issues/83)

## [1.16.5-1.0.2.3] - 2022.02.16
### Added
- Added config option `addButton` to `diet-client.toml` for enabling/disabling the Diet button in the inventory screen

## [1.16.5-1.0.2.2] - 2022.02.10
### Added
- Added 5-food-group support for:
    - Thermal Series [#115](https://github.com/TheIllusiveC4/Diet/issues/115)
    - Minecolonies [#106](https://github.com/TheIllusiveC4/Diet/issues/106)

## [1.16.5-1.0.2.1] - 2022.01.28
### Fixed
- Fixed fractional add amounts in attribute modifiers not being shown in the tooltip correctly

## [1.16.5-1.0.2.0] - 2022.01.17
### Added
- Added 5-food-group support for:
    - Modest Roses [#100](https://github.com/TheIllusiveC4/Diet/issues/100)
    - Project Rankine [#102](https://github.com/TheIllusiveC4/Diet/issues/102)
- Added optional `beneficial` field to groups in `diet-groups.toml` to distinguish beneficial and harmful effects, with
  red tooltips instead of green for harmful food groups [#104](https://github.com/TheIllusiveC4/Diet/issues/104)
### Changed
- Adjusted GUI sizing logic to better accommodate larger number of groups [#97](https://github.com/TheIllusiveC4/Diet/issues/97)
### Fixed
- Fixed potential NPE when eating food [#105](https://github.com/TheIllusiveC4/Diet/issues/105)

## [1.16.5-1.0.1.1] - 2021.11.24
### Added
- Added 5-food-group support for:
    - Habitat [#96](https://github.com/TheIllusiveC4/Diet/issues/96)
- Added Korean localization (thanks PixVoxel!) [#95](https://github.com/TheIllusiveC4/Diet/pull/95)

## [1.16.5-1.0.1.0] - 2021.11.13
### Added
- Added optional lang key `groups.diet.groupname.tooltip` for adding tooltips when hovering over the group's icon in the
  Diet screen
- Added 5-food-group support for:
    - Create Confectionary [#93](https://github.com/TheIllusiveC4/Diet/issues/93)
### Fixed
- Fixed Chinese localization not working correctly

## [1.16.5-1.0.0.0] - 2021.10.15
### Added
- Added 5-food-group support for:
    - Simple Corn

## [1.16.5-0.43] - 2021.09.26
### Changed
- Added mixins again
### Fixed
- Fixed item uses being triggered erroneously [#87](https://github.com/TheIllusiveC4/Diet/issues/87)

## [1.16.5-0.42] - 2021.09.22
### Fixed
- Fixed default Diet configs not respecting `defaultConfigPath` in `fml.toml`

## [1.16.5-0.41] - 2021.09.18
### Changed
- Removed mixins
### Fixed
- Fixed diet values not being synced to players on dedicated servers [#86](https://github.com/TheIllusiveC4/Diet/issues/86)

## [1.16.5-0.40] - 2021.09.15
### Added
- Added 5-food-group support for:
    - Improved Berries
    - Nourished End
    - Project Vibrant Journeys
    - Roots Classic
    - Shulkered
    - Simple Delights
    - Trick O'Creeps
- Added configuration option for hiding diet food group tooltips for a player until that food has been eaten at least once [#85](https://github.com/TheIllusiveC4/Diet/issues/85)
### Changed
- Revamped tagging system to include automatic tagging for foods without a group tag
    - Existing groupings for foods may have changed or disappeared due to migrating to the new system, please report an issue if this happened in error
    - New tags:
        - `diet:ingredients` for items that should not add their own food groups to foods they are a part of (such as salt)
        - `diet:special_food` for items that do not have food values but should still display food group tooltips (such as cake)

## [1.16.5-0.39] - 2021.08.12
### Added
- [API] Added ApplyEffect event for modders to cancel the effects from Diet
- Added 5-food-group support for:
    - Infernal Expansion
    - Unique Crops
### Changed
- Updated 5-food-group support for:
    - Ars Noveau
    - Cookielicious

## [1.16.5-0.38] - 2021.08.03
### Fixed
- Fixed Russian localization

## [1.16.5-0.37] - 2021.08.02
### Added
- Added 5-food-group support for:
    - Atum 2
    - Create Crafts & Additions
    - Extended Caves
    - Extra Food Recipes
    - Nef's Medieval decoration
- Updated 5-food-group support for:
    - Blue Skies
    - Oh The Biomes You'll Go
- Added Japanese localization (thanks Lazialize!)
- Added Russian localization (thanks LEDshade!)

## [1.16.5-0.36] - 2021.07.22
### Added
- Added 5-food-group support for:
    - Comfortable Nether
    - Immersive Cooking
    - Ginger's Drinks+
    - Nether's Delight
    - Nourished Nether
    - NoCube's Wilderness
    - Odd Water Mobs
    - Water Source
- Updated 5-food-group support for:
    - BetterEnd (Forge)

## [1.16.5-0.35] - 2021.07.15
### Added
- Added 5-food-group support for:
    - Blue Skies
### Changed
- Updated 5-food-group support for:
    - Tinkers' Construct
    - Pam's HarvestCraft 2: Food Extended

## [1.16.5-0.34] - 2021.07.04
### Added
- Added Italian translation (thanks simcosmico!) [#58](https://github.com/TheIllusiveC4/Diet/pull/58)
### Changed
- Updated 5-food-group support for:
    - Alex's Mobs
    - Fins and Tails
### Fixed
- Fixed diet being paused randomly [#40](https://github.com/TheIllusiveC4/Diet/issues/40)
- Fixed diet values increasing to `deathPenaltyMin` when lower [#62](https://github.com/TheIllusiveC4/Diet/issues/62)

## [1.16.5-0.33] - 2021.06.17
### Added
- Added client config option in `diet-client.toml` for GUI text color [#57](https://github.com/TheIllusiveC4/Diet/issues/57)

## [1.16.5-0.32] - 2021.06.15
### Fixed
- Fixed possible crashes related to tagging logic [#56](https://github.com/TheIllusiveC4/Diet/issues/56)

## [1.16.5-0.31] - 2021.06.12
### Added
- Added 5-food-group support for:
    - Food Expansion: Reimagined
### Fixed
- Fixed Origins integrations bug with testing conditions [#55](https://github.com/TheIllusiveC4/Diet/issues/55)

## [1.16.5-0.30] - 2021.06.03
### Changed
- Updated 5-food-group support for:
    - Simply Tea
    - Bloom and Gloom (project name changed to Habitat)
    - Pam's HarvestCraft 2 - Food Extended
### Fixed
- Fixed stuttering issue with Nausea as a dietary effect

## [1.16.5-0.29] - 2021.06.03
### Added
- Added Curios GUI integration [#48](https://github.com/TheIllusiveC4/Diet/issues/48)
- Added exit button to the Diet GUI [#47](https://github.com/TheIllusiveC4/Diet/issues/47)
- Added Origins integration for Diet Effect conditions:
    - `origins` - A list of origins by identifier
    - `originsMatch` - `any`, `all`, or `none` - The match method for the origins list
    - `powers` - A list of powers by identifier
    - `powersMatch` - `any`, `all`, or `none` - The match method for the powers list

## [1.16.5-0.28] - 2021.05.06
### Added
- Added 5-food-group support for:
    - Fluffy's Farming

## [1.16.5-0.27] - 2021.05.03
### Added
- Added 5-food-group support for:
    - Tea Kettle

## [1.16.5-0.26] - 2021.04.20
### Added
- Added 5-food-group support for:
    - Advent of Ascension (Nevermine)

## [1.16.5-0.25] - 2021.04.20
### Added
- Added 5-food-group support for:
    - Charcoal Pit
    - Fruitful
- Updated 5-food-group support for:
    - Alex's Mobs

## [1.16.5-0.24] - 2021.04.12
### Added
- Added 5-food-group support for:
    - Delicate and Dainty
- Added `/diet export` for logging diet information for foods

## [1.16.5-0.23] - 2021.04.05
### Added
- Added 5-food-group support for:
    - Gilded Ingot
    - Supplementaries
    - Tinkers' Construct
    - Turkish Meals
    - Twilight Forest
### Changed
- Updated 5-food-group support for:
    - Create

## [1.16.5-0.22] - 2021.04.02
### Added
- Added Russian localization (thanks LEDshade!) [#32](https://github.com/TheIllusiveC4/Diet/pull/32)

## [1.16.5-0.21] - 2021.04.01
### Added
- Added five-food-group support for:
    - Endless Oceans: Adventure
    - EvilCraft
    - Gaia Dimension
    - Glow Bats
    - Greek Fantasy
    - Kray's Magic Candles
    - Mowzie's Mobs
    - Nether Soups Mob
    - Turtlemancy
### Changed
- Updated five-food-group support for:
    - Fins and Tails
    - Terrain Incognita

## [1.16.5-0.20] - 2021.03.31
### Added
- Added five-food-group support for:
    - ForageCraft
### Changed
- Updated five-food-group support for:
    - Abnormal's Delight
    - Alex's Mobs
    - Farmer's Delight

## [1.16.5-0.19] - 2021.03.30
### Added
- Added five-food-group support for:
    - Conjurer's Cookbook
    - Silent's Gems (Experimental)
- More API methods
### Fixed
- Fixed Chinese localization not appearing correctly

## [1.16.5-0.18] - 2021.03.23
### Fixed
- Fixed players not gaining diet values when eating food to maximum fullness [#27](https://github.com/TheIllusiveC4/Diet/issues/27)

## [1.16.5-0.17] - 2021.03.16
### Added
- Added five-food-group support for:
    - Food Enhancements
- Added "RESET" to config option for death penalties to reset values to defaults
### Changed
- Updated five-food-group support for:
    - Autumnity
    - Bloom and Gloom
- Players no longer gain diet values when full

## [1.16.5-0.16] - 2021.03.13
### Added
- Partial Taiwanese translation (thanks Pancakes0228!) [#22](https://github.com/TheIllusiveC4/Diet/pull/22)
- Added five-food-group support for:
    - Forbidden and Arcanus
    - Good Night's Sleep
    - Silent's Mechanisms
    - Untitled Duck Mod
### Fixed
- Fixed potential NPE crashes [#23](https://github.com/TheIllusiveC4/Diet/issues/23)

## [1.16.5-0.15] - 2021.03.10
### Added
- Added five-food-group support for:
    - Pandoras Creatures
### Fixed
- Fixed potential NPE crashes [#21](https://github.com/TheIllusiveC4/Diet/issues/21)

## [1.16.5-0.14] - 2021.03.08
### Added
- Added five-food-group support for:
    - Abundance
    - Bayou Blues
    - Blueberry
    - Drop the Meat
    - Golden Beetroot Mod
- Added percentage-based death penalty config option [#17](https://github.com/TheIllusiveC4/Diet/issues/17)
- Added food quality overrides list config option
### Changed
- Increased overall gain rate of all foods for every food group by 20%

## [1.16.5-0.13] - 2021.03.03
### Fixed
- Fixed GUI cross-mod compatibility issues [#16](https://github.com/TheIllusiveC4/Diet/issues/16)
- Fixed food blocks not giving diet values [#6](https://github.com/TheIllusiveC4/Diet/issues/6)

## [1.16.5-0.12] - 2021.03.02
### Changed
- Polished up dietary effects tooltip
### Fixed
- [API] Fixed potential infinite loop in IMC calls [#15](https://github.com/TheIllusiveC4/Diet/issues/15)

## [1.16.5-0.11] - 2021.03.01
### Added
- Added five-food-group support for:
    - Abnormals Delight
    - Better Default Biomes
    - Creatures and Beasts
    - Environmental
    - Neapolitan (new foods)
    - Netherite Spuds
    - Pumpkin Spice Everything
    - Survival Plus
    - Trail Mix
    - VanillaTweaks
    - XercaMod
### Changed
- Doubled overall gain rate of all foods for every food group
### Fixed
- Fixed Pam's HarvestCraft 2 - Trees bug where nutmegs were showing a diet tooltip erroneously

## [1.16.5-0.10] - 2021.02.27
### Added
- Added five-food-group support for:
    - Bettas
    - Fins and Tails
    - Frozen Up
    - Omni

## [1.16.5-0.9] - 2021.02.27
### Fixed
- Categorized missing item from Resourceful Bees

## [1.16.5-0.8] - 2021.02.27
### Added
- Added five-food-group support for:
    - Ars Nouveau
    - Better End (Forge)
    - Integrated Dynamics
    - Meet Your Fight
    - PneumaticCraft: Repressurized
    - Resourceful Bees
    - Oh The Biomes You'll Go
    - Undergarden
### Fixed
- Fixed diet values not syncing when changing dimensions [#9](https://github.com/TheIllusiveC4/Diet/issues/9)

## [1.16.5-0.7] - 2021.02.21
### Changed
- [API] Streamlined items/blocks API
- Removed Enchanted Golden Apple from most default food groups
- Updated tooltips for non-food items
### Fixed
- Fixed diet values updating on cake blocks even when players did not actually eat it

## [1.16.5-0.6] - 2021.02.20
### Added
- Added five-food-group support for:
    - Caves and Cliffs Backport
    - Caves and Cliffs Mod
    - Create
    - Cyclic
    - Fantasy Mounts
    - Pickle Tweaks
    - Silent Gear
    - Terra Incognita
    - The Bumblezone
    - Wyrmroost

## [1.16.5-0.5] - 2021.02.20
### Fixed
- Fixed missing items in Crock Pot for the default five food groups
- Fixed crash with cake item/block

## [1.16.5-0.4] - 2021.02.20
### Added
- [API] Added cancelable events: DietEvent.ConsumeItem, DietEvent.ConsumeBlock, DietEvent.ApplyDecay
### Changed
- Updated some integration classifications for the default five food groups

## [1.16.5-0.3] - 2021.02.19
### Fixed
- Attempted fix for config race condition [#7](https://github.com/TheIllusiveC4/Diet/issues/7)

## [1.16.5-0.2] - 2021.02.18
### Added
- Added five-food-group support for:
    - Artifacts
    - Alex's Mobs
    - Berry Good
    - Bloom and Gloom
    - Cookielicious
    - Crockpot
    - Druidcraft
    - Eidolon
    - Enhanced Mushrooms
    - Extra Foods
    - Jellyfishing
    - The Endergetic Expansion
    - The Outer End
    - Peculiars
    - Seasonals
    - Upgrade Aquatic
    - Vanilla Cookbook

## [1.16.5-0.1] - 2021.02.18
Initial beta release
