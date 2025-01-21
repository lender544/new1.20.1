package com.github.L_Ender.cataclysm.client.model.block;

import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class Cataclysm_Skull_Model_Base extends Model {


    public Cataclysm_Skull_Model_Base() {
        super(RenderType::entityTranslucent);
    }

    public abstract void setupAnim(float p_170950_, float p_170951_, float p_170952_);
}
