package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.inventory.MinistrostiyMenu;
import com.github.L_Ender.cataclysm.inventory.WeaponfusionMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenu {

    public static final DeferredRegister<MenuType<?>> DEF_REG = DeferredRegister.create(Registries.MENU, Cataclysm.MODID);

    public static final DeferredHolder<MenuType<?>,MenuType<WeaponfusionMenu>> WEAPON_FUSION = DEF_REG.register("weapon_fusion", () -> new MenuType<WeaponfusionMenu>(WeaponfusionMenu::new, FeatureFlags.DEFAULT_FLAGS));


}
