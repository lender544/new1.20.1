package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.inventory.MinistrostiyMenu;
import com.github.L_Ender.cataclysm.inventory.WeaponfusionMenu;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenu {

    public static final DeferredRegister<MenuType<?>> DEF_REG = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Cataclysm.MODID);

    public static final RegistryObject<MenuType<WeaponfusionMenu>> WEAPON_FUSION = DEF_REG.register("weapon_fusion", () -> new MenuType<WeaponfusionMenu>(WeaponfusionMenu::new, FeatureFlags.DEFAULT_FLAGS));



}
