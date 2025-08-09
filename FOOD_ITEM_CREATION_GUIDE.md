# Food Item Creation Guide for Cataclysm Mod

A comprehensive guide for efficiently creating food items in the Cataclysm mod, based on successful implementations of Bacon, Bacon Toast, and Golden Bacon Toast.

## 📋 Quick Reference Checklist

- [ ] Item definition in ModItems.java
- [ ] Texture asset (16x16 PNG)
- [ ] Item model JSON
- [ ] Localization entry
- [ ] Crafting recipe JSON
- [ ] Recipe advancement JSON (for recipe book visibility)
- [ ] Build test and validation

## 🛠️ Step-by-Step Implementation

### 1. Item Definition (ModItems.java)

**Location**: `/src/main/java/com/github/L_Ender/cataclysm/init/ModItems.java`

```java
public static final RegistryObject<Item> YOUR_FOOD_ITEM = ITEMS.register("your_food_item",
        () -> new Item(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder()
                .nutrition(HUNGER_POINTS)
                .saturationMod(SATURATION_MULTIPLIER)
                .effect(new MobEffectInstance(MobEffects.EFFECT_NAME, DURATION_TICKS, LEVEL), PROBABILITY)
                .build())));
```

**Key Parameters**:
- `nutrition`: Hunger points restored (each point = 2 hunger bars)
- `saturationMod`: Saturation multiplier (0.1F to 1.2F typical range)
- `effect`: Optional status effects with duration in ticks (20 ticks = 1 second)
- `stacksTo(64)`: Standard stack size for food items

**Effect Levels** (amplifier values):
- Level I = 0, Level II = 1, Level III = 2, Level IV = 3

**Common Effect Durations**:
- 30 seconds = 600 ticks
- 1 minute = 1200 ticks  
- 5 minutes = 6000 ticks

### 2. Texture Asset

**Location**: `/src/main/resources/assets/cataclysm/textures/item/your_food_item.png`

**Requirements**:
- 16x16 pixels (can be larger but 16x16 is standard)
- PNG format with transparency support
- Follow mod's art style and color palette

### 3. Item Model

**Location**: `/src/main/resources/assets/cataclysm/models/item/your_food_item.json`

```json
{
  "parent": "minecraft:item/generated",
  "textures": {
    "layer0": "cataclysm:item/your_food_item"
  }
}
```

### 4. Localization

**Location**: `/src/main/resources/assets/cataclysm/lang/en_us.json`

Add entry in alphabetical order:
```json
"item.cataclysm.your_food_item": "Your Food Item Display Name",
```

### 5. Crafting Recipe

**Location**: `/src/main/resources/data/cataclysm/recipes/your_food_item.json`

**Shapeless Recipe** (ingredients in any order):
```json
{
  "type": "minecraft:crafting_shapeless",
  "category": "food",
  "group": "food",
  "ingredients": [
    {
      "item": "minecraft:ingredient1"
    },
    {
      "item": "minecraft:ingredient2"
    }
  ],
  "result": {
    "count": 1,
    "item": "cataclysm:your_food_item"
  }
}
```

**Using Tags** (for multiple valid ingredients):
```json
{
  "tag": "minecraft:coals"
}
```

### 6. Recipe Advancement (Critical for Recipe Book)

**Location**: `/src/main/resources/data/cataclysm/advancements/recipes/your_food_item.json`

```json
{
  "parent": "minecraft:recipes/root",
  "criteria": {
    "has_ingredient1": {
      "trigger": "minecraft:inventory_changed",
      "conditions": {
        "items": [
          {
            "items": ["minecraft:ingredient1"]
          }
        ]
      }
    },
    "has_ingredient2": {
      "trigger": "minecraft:inventory_changed",
      "conditions": {
        "items": [
          {
            "items": ["minecraft:ingredient2"]
          }
        ]
      }
    },
    "has_the_recipe": {
      "trigger": "minecraft:recipe_unlocked",
      "conditions": {
        "recipe": "cataclysm:your_food_item"
      }
    }
  },
  "requirements": [
    ["has_ingredient1", "has_ingredient2"],
    ["has_the_recipe"]
  ],
  "rewards": {
    "recipes": ["cataclysm:your_food_item"]
  }
}
```

**⚠️ Critical**: The recipe advancement is essential for recipe book visibility. Without it, players won't see the recipe in the crafting table.

### 7. Build Validation

```bash
# Test compilation
./gradlew compileJava --console=plain

# Validate JSON syntax
python3 -m json.tool recipe_file.json > /dev/null && echo "Valid JSON"

# Full build test  
./gradlew build --console=plain
```

## 🎯 Food Item Examples

### Basic Food Item (Simple)
```java
// 2 hunger, 0.3 saturation, no effects
public static final RegistryObject<Item> SIMPLE_FOOD = ITEMS.register("simple_food",
        () -> new Item(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder()
                .nutrition(2).saturationMod(0.3F).build())));
```

### Moderate Food Item (With Effects)
```java
// 4 hunger, 0.6 saturation, 30-second speed boost
public static final RegistryObject<Item> MODERATE_FOOD = ITEMS.register("moderate_food",
        () -> new Item(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder()
                .nutrition(4).saturationMod(0.6F)
                .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0F)
                .build())));
```

### Ultimate Food Item (Multiple Effects)
```java
// 9 hunger, high saturation, multiple 5-minute effects + golden hearts
public static final RegistryObject<Item> ULTIMATE_FOOD = ITEMS.register("ultimate_food",
        () -> new Item(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder()
                .nutrition(9).saturationMod(0.53F)
                .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 1), 1.0F)
                .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 1), 1.0F)
                .effect(new MobEffectInstance(MobEffects.REGENERATION, 6000, 1), 1.0F)
                .effect(new MobEffectInstance(MobEffects.ABSORPTION, 6000, 3), 1.0F)
                .build())));
```

## 📊 Common Effect References

| Effect | ID | Levels | Notes |
|--------|----|---------| ------|
| Speed | `MobEffects.MOVEMENT_SPEED` | I-II | Faster movement |
| Haste | `MobEffects.DIG_SPEED` | I-II | Faster mining |
| Strength | `MobEffects.DAMAGE_BOOST` | I-II | More melee damage |
| Jump Boost | `MobEffects.JUMP` | I-II | Higher jumping |
| Regeneration | `MobEffects.REGENERATION` | I-II | Health over time |
| Resistance | `MobEffects.DAMAGE_RESISTANCE` | I-II | Damage reduction |
| Fire Resistance | `MobEffects.FIRE_RESISTANCE` | I only | Fire immunity |
| Water Breathing | `MobEffects.WATER_BREATHING` | I only | No drowning |
| Night Vision | `MobEffects.NIGHT_VISION` | I only | See in dark |
| Absorption | `MobEffects.ABSORPTION` | I-IV | Golden hearts |

## 🚨 Common Pitfalls & Solutions

### Recipe Not Showing in Crafting Table
**Problem**: Recipe doesn't appear when ingredients are placed  
**Solution**: Ensure recipe advancement JSON exists and is properly formatted

### Item Not Rendering
**Problem**: Item shows as purple/black cube  
**Solution**: Check texture path matches model JSON and file exists

### Build Failures
**Problem**: Compilation errors  
**Solution**: Verify all imports, check syntax, ensure proper brackets/semicolons

### Effect Not Working
**Problem**: Status effect doesn't apply when eaten  
**Solution**: Check effect ID spelling, duration > 0, probability = 1.0F

## 💡 Pro Tips

1. **Effect Stacking**: Multiple food effects can stack if they're different types
2. **Saturation Balance**: Higher saturation = longer until hunger depletes again
3. **Duration Scaling**: 5 minutes (6000 ticks) is ideal for exploration/combat
4. **Recipe Complexity**: More expensive ingredients = more powerful effects
5. **Testing**: Always test in-game to verify effect durations and intensities

## 🔄 Workflow Summary

1. **Plan** → Define hunger, saturation, effects, recipe
2. **Code** → Add item definition to ModItems.java  
3. **Assets** → Create texture, model, localization
4. **Recipe** → Create recipe + advancement JSONs
5. **Test** → Build, validate, test in-game
6. **Commit** → Git commit with detailed description

## 📁 File Structure Reference

```
src/main/
├── java/com/github/L_Ender/cataclysm/init/
│   └── ModItems.java                          # Item definitions
└── resources/
    ├── assets/cataclysm/
    │   ├── lang/
    │   │   └── en_us.json                     # Localization
    │   ├── models/item/
    │   │   └── your_food_item.json            # Item model
    │   └── textures/item/
    │       └── your_food_item.png             # Texture asset
    └── data/cataclysm/
        ├── recipes/
        │   └── your_food_item.json            # Crafting recipe
        └── advancements/recipes/
            └── your_food_item.json            # Recipe advancement
```

---

*This guide was developed through the successful implementation of the bacon item series in the Cataclysm mod. Follow this procedure for consistent, error-free food item creation.*