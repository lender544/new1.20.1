package com.github.L_Ender.cataclysm.util;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;

public class EffectUtil {
    private static final Holder<MobEffect> type = null;

    public EffectUtil(Holder<MobEffect> type) {
       type = type;
    }

    public static boolean is(TagKey<MobEffect> p_270890_) {
        return type.is(p_270890_);
    }

    public static boolean is(ResourceKey<MobEffect> p_276108_) {
        return type.is(p_276108_);
    }

    public static MobEffect type() {
        return type.value();
    }

    public static Holder<MobEffect> typeHolder() {
        return type;
    }

}
