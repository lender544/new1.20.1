package com.github.L_Ender.cataclysm.init;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class ModKeybind {

    public static final KeyMapping KEY_ABILITY = new KeyMapping("key.cataclysm.ability", InputConstants.KEY_X, "key.categories.cataclysm");

    public static final KeyMapping HELMET_KEY_ABILITY = new KeyMapping("key.cataclysm.helmet_ability", InputConstants.KEY_C, "key.categories.cataclysm");

    public static final KeyMapping CHESTPLATE_KEY_ABILITY = new KeyMapping("key.cataclysm.chestplate_ability", InputConstants.KEY_Y, "key.categories.cataclysm");

    public static final KeyMapping BOOTS_KEY_ABILITY = new KeyMapping("key.cataclysm.boots_ability", InputConstants.KEY_V, "key.categories.cataclysm");
}
