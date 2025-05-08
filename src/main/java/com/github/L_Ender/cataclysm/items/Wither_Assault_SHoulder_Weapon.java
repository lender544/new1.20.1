package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Wither_Howitzer_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Wither_Missile_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


import java.util.List;

public class Wither_Assault_SHoulder_Weapon extends Item {

    public Wither_Assault_SHoulder_Weapon(Properties group) {
        super(group);
    }


    public UseAnim getUseAnimation(ItemStack p_77661_1_) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public void releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof Player player) {
            int i = this.getUseDuration(p_43394_,p_43396_) - p_43397_;
            float f = getPowerForTime(i);
            if (!((double) f < 0.5D)) {
                p_43395_.playSound((Player)null, player.getX(), player.getY(), player.getZ(), ModSounds.ROCKET_LAUNCH.get(), SoundSource.PLAYERS,1.0F, 0.7F);
                if(p_43396_.isShiftKeyDown()) {
                    player.getCooldowns().addCooldown(this, CMConfig.WASWHowitzerCooldown);
                    if (!p_43395_.isClientSide) {
                        Wither_Howitzer_Entity rocket = new Wither_Howitzer_Entity(ModEntities.WITHER_HOWITZER.get(), p_43395_, player);
                        rocket.setRadius(3.5F);
                        rocket.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 1.0F, 1.0F);
                        p_43395_.addFreshEntity(rocket);
                    }
                }else {
                    player.getCooldowns().addCooldown(this, CMConfig.WASWMissileCooldown);
                    if (!p_43395_.isClientSide) {
                        float d7 = p_43396_.getYRot();
                        float d = p_43396_.getXRot();
                        float d1 = -Mth.sin(d7 * ((float) Math.PI / 180F)) * Mth.cos(d * ((float) Math.PI / 180F));
                        float d2 = -Mth.sin(d * ((float) Math.PI / 180F));
                        float d3 = Mth.cos(d7 * ((float) Math.PI / 180F)) * Mth.cos(d * ((float) Math.PI / 180F));
                        double theta = d7 * (Math.PI / 180);
                        theta += Math.PI / 2;
                        double vecX = Math.cos(theta);
                        double vecZ = Math.sin(theta);
                        double x = p_43396_.getX() + vecX;
                        double Z = p_43396_.getZ() + vecZ;
                        Vec3 vec3 = new Vec3(d1, d2, d3).normalize();
                        float yRot = (float) (Mth.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;
                        float xRot = (float) -(Mth.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));
                        Wither_Missile_Entity witherskull = new Wither_Missile_Entity(player, vec3.normalize(),p_43395_,(float) CMConfig.WASWMissileDamage);
                        witherskull.setYRot(yRot);
                        witherskull.setXRot(xRot);
                        witherskull.setPosRaw(x, p_43396_.getEyeY(), Z);
                        p_43395_.addFreshEntity(witherskull);



                    }
                }
            }
        }

    }

    public static float getPowerForTime(int p_40662_) {
        float f = (float)p_40662_ / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }


 

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add(Component.translatable("item.cataclysm.wither_assault_shoulder_weapon.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add(Component.translatable("item.cataclysm.wither_assault_shoulder_weapon.desc2").withStyle(ChatFormatting.DARK_GREEN));
    }
}
