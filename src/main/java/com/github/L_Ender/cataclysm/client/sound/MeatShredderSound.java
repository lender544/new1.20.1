package com.github.L_Ender.cataclysm.client.sound;

import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModSounds;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class MeatShredderSound extends ItemTickableSound {

    public MeatShredderSound(LivingEntity user) {
        super(user, ModSounds.SHREDDER_LOOP.get());
    }

    public void tickVolume(ItemStack itemStack) {
        this.volume = 0.4f;
        this.pitch = 1.0f;
    }

    @Override
    public boolean isValidItem(ItemStack itemStack) {
        return itemStack.is(ModItems.MEAT_SHREDDER.get());
    }
}
