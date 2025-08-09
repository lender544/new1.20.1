# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

L_Ender's Cataclysm is a Minecraft mod built with MinecraftForge for Minecraft 1.20.1. It's a boss and structure mod that adds challenging dungeons, powerful bosses, and associated items and mechanics to the game.

## Development Commands

### Build and Test Commands
- `./gradlew build` - Build the mod JAR file
- `./gradlew clean` - Clean build artifacts
- `./gradlew --refresh-dependencies` - Refresh local dependency cache
- `./gradlew genEclipseRuns` - Generate Eclipse run configurations
- `./gradlew genIntellijRuns` - Generate IntelliJ IDEA run configurations

### Development Environment Setup
- For Eclipse: Run `gradlew genEclipseRuns` then import as Gradle project
- For IntelliJ: Import build.gradle file then run `gradlew genIntellijRuns`

### Running the Mod
The build.gradle defines several run configurations:
- Client: Runs Minecraft client with the mod loaded
- Server: Runs dedicated server with the mod loaded  
- Data: Runs data generation for recipes, loot tables, etc.

## Architecture Overview

### Core Structure
- **Main Mod Class**: `com.github.L_Ender.cataclysm.Cataclysm` - Central mod initialization and networking
- **Proxy Pattern**: Uses `ClientProxy` and `CommonProxy` for side-specific initialization
- **Mixins**: Uses Mixin framework for code injection (configured in `cataclysm.mixins.json`)

### Key Packages
- `blocks/` - Custom blocks including altars, traps, and dungeon blocks
- `entity/` - Boss entities, mobs, projectiles, and effects
- `items/` - Weapons, armor, tools, and special items
- `client/` - Client-side rendering, models, animations, and GUI
- `init/` - Registration classes for all mod content
- `structures/` - Dungeon and structure generation
- `config/` - Configuration system using Forge's config framework

### Entity System
The mod uses a sophisticated animation system:
- **Animation_Monster**: Base class for animated entities
- **Internal_Animation_Monster**: Advanced animation system for complex bosses
- **Boss entities** include: Ancient Remnant, Ender Guardian, Ignis, Maledictus, Leviathan, and others
- **Part entities**: Multi-part bosses use `Cm_Part_Entity` for hit detection

### Item System
- **Weapon tiers**: Custom material tiers (Ancient Metal, Cursium, Ignitium, Witherite)
- **Special weapons**: Unique boss drops with custom abilities
- **Armor sets**: Themed armor with set bonuses
- **Curios integration**: Accessories using the Curios API

### World Generation
- **Structures**: Multiple dungeon types (Burning Arena, Cursed Pyramid, Sunken City, etc.)
- **Jigsaw system**: Uses custom jigsaw manager for complex structure assembly
- **Biome modifiers**: Custom spawn rules for mobs in specific biomes/structures

## Dependencies

### Required Dependencies
- **MinecraftForge**: 47.3.22+ for Minecraft 1.20.1
- **LionfishAPI**: 2.4+ (mandatory dependency)
- **Java**: 17+ (specified in build.gradle)

### Optional Integration
- **JEI**: Recipe viewing integration
- **Curios**: Accessory slots for special items

## Configuration
- Main config file: `cataclysm.toml` (generated in config folder)
- Biome configuration system for controlling mob spawns
- Structure generation can be controlled via config

## Resource Generation
- Uses Minecraft's data generation system
- Recipes, loot tables, and tags are defined in `src/main/resources/data/`
- Client assets (models, textures) in `src/main/resources/assets/`

## Development Notes
- The mod uses official Minecraft mappings
- Mixin is used extensively for vanilla behavior modification
- Network messages use Forge's SimpleChannel system
- Sound system includes custom boss music and sound effects
- Particle system includes many custom particle effects for visual flair