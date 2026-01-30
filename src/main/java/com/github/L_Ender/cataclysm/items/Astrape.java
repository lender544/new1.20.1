package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.config.CMCommonConfig;
import com.github.L_Ender.cataclysm.entity.projectile.Lightning_Spear_Entity;
import com.github.L_Ender.cataclysm.init.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class Astrape extends Cataclysm_Weapon  {


    public Astrape(Properties group) {
        super(group);

    }


    @Override
    public boolean canAttackBlock(BlockState p_43409_, Level p_43410_, BlockPos p_43411_, Player p_43412_) {
        return !p_43412_.isCreative();
    }

    public UseAnim getUseAnimation(ItemStack p_43417_) {
        return UseAnim.SPEAR;
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
                p_43395_.playSound((Player)null, player.getX(), player.getY(), player.getZ(), ModSounds.EMP_ACTIVATED.get(), SoundSource.PLAYERS,1.0F, 0.8F);
                if (!p_43395_.isClientSide) {

                    Vec3 lookDirection = player.getLookAngle();

                        Vec3 vec3 = new Vec3(lookDirection.x, lookDirection.y, lookDirection.z).normalize();
                        float yRot = (float) (Mth.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;
                        float xRot = (float) -(Mth.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));


                        Lightning_Spear_Entity lightning = new Lightning_Spear_Entity(player, vec3.normalize(),p_43395_,(float)CMCommonConfig.Astrape.damage,2.5D);
                        lightning.setYRot(yRot);
                        lightning.setXRot(xRot);
                        lightning.setPos(lightning.getX(), player.getY(0.75), lightning.getZ());
                        lightning.setAreaDamage((float)CMCommonConfig.Astrape.areaDamage);
                        lightning.setAreaRadius(1);
                        boolean flag = p_43395_.addFreshEntity(lightning);
                        if(flag){
                            player.getCooldowns().addCooldown(this, CMCommonConfig.Astrape.cooldown);
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
    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
        return net.neoforged.neoforge.common.ItemAbilities.DEFAULT_TRIDENT_ACTIONS.contains(itemAbility);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add(Component.translatable("item.cataclysm.astrape.desc").withStyle(ChatFormatting.DARK_GREEN));
    }

}
