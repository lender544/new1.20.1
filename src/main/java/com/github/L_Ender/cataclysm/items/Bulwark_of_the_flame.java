package com.github.L_Ender.cataclysm.items;


import com.github.L_Ender.cataclysm.Attachment.ChargeAttachment;
import com.github.L_Ender.cataclysm.Attachment.TidalTentacleAttachment;
import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModDataAttachments;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


import javax.annotation.Nullable;
import java.util.List;

public class Bulwark_of_the_flame extends Item {
    public Bulwark_of_the_flame(Properties group) {
        super(group);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
        return net.neoforged.neoforge.common.ItemAbilities.DEFAULT_SHIELD_ACTIONS.contains(itemAbility);
    }

    public UseAnim getUseAnimation(ItemStack p_77661_1_) {
        return UseAnim.BLOCK;
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if(entityLiving.isShiftKeyDown()) {
            if(!entityLiving.isFallFlying()) {
                int i = this.getUseDuration(stack,entityLiving) - timeLeft;
                int t = Mth.clamp(i, 1, 4);
                float f7 = entityLiving.getYRot();
                float f = entityLiving.getXRot();

                float f1 = -Mth.sin(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));
                float f2 = -Mth.sin(f * ((float) Math.PI / 180F));
                float f3 = Mth.cos(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));
                float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
                float f5 = 3.0F * (t / 6.0F);
                f1 *= f5 / f4;
                f3 *= f5 / f4;
                entityLiving.push((double) f1, (double) 0, (double) f3);
                if (entityLiving.onGround()) {
                    float f6 = 1.1999999F;
                    entityLiving.move(MoverType.SELF, new Vec3(0.0D, (double) f6 / 2, 0.0D));
                }

                ChargeAttachment charge = entityLiving.getData(ModDataAttachments.CHARGE_ATTACHMENT);
                charge.setCharge(true);
                charge.setTimer(t * 2);
                charge.seteffectiveChargeTime(t * 2);
                charge.setknockbackSpeedIndex(t * 2);
                charge.setdamagePerEffectiveCharge(0.6F);
                charge.setdx(f1 * 0.1F);
                charge.setdZ(f3 * 0.1F);

                if (!level.isClientSide) {
                    ((Player) entityLiving).getCooldowns().addCooldown(this, CMConfig.BulwarkOfTheFlameCooldown);
                }
            }
        }
    }

    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        ItemStack lvt_4_1_ = p_77659_2_.getItemInHand(p_77659_3_);
        p_77659_2_.startUsingItem(p_77659_3_);
        return InteractionResultHolder.consume(lvt_4_1_);
    }

 

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add(Component.translatable("item.cataclysm.bulwark_of_the_flame.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltips.add(Component.translatable("item.cataclysm.bulwark_of_the_flame2.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}