package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.projectile.Cursed_Sandstorm_Entity;
import com.github.L_Ender.cataclysm.init.ModDataComponents;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.items.Components.ChargeAnimationComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;


import java.util.List;
import java.util.Optional;

public class Wrath_of_the_desert extends Item {


    public Wrath_of_the_desert(Properties group) {
        super(group);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }

    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        boolean using = entity instanceof LivingEntity living && living.getUseItem().equals(stack);
        int useTime = getUseTime(stack);
        ChargeAnimationComponent flaskContents = stack.getOrDefault(ModDataComponents.CHARGE_ANIMATION, ChargeAnimationComponent.EMPTY);

        if (flaskContents.PrevUseTime() != flaskContents.UseTime()) {
            stack.update(ModDataComponents.CHARGE_ANIMATION, flaskContents, component -> component.tryAddDose(useTime,getUseTime(stack)));
        }


        int maxLoadTime = getMaxLoadTime();
        if (using && useTime < maxLoadTime) {
            int set = useTime +  1;
            setUseTime(stack, set);
            //Cataclysm.sendMSGToServer(new MessageUpdateItemTag(entity.getId(), stack));
        }

        if (!using && useTime > 0.0F) {
            setUseTime(stack, Math.max(0, useTime - 5));
        }
    }


    private static int getMaxLoadTime() {
        return 20;
    }

    public static int getUseTime(ItemStack stack) {
        ChargeAnimationComponent flaskContents = stack.getOrDefault(ModDataComponents.CHARGE_ANIMATION, ChargeAnimationComponent.EMPTY);
        return flaskContents.UseTime();
    }

    public static void setUseTime(ItemStack stack, int useTime) {
        ChargeAnimationComponent flaskContents = stack.getOrDefault(ModDataComponents.CHARGE_ANIMATION, ChargeAnimationComponent.EMPTY);
        stack.update(ModDataComponents.CHARGE_ANIMATION, flaskContents, component -> component.tryAddDose(useTime,getUseTime(stack)));
    }

    public static float getLerpedUseTime(ItemStack stack, float f) {
        ChargeAnimationComponent flaskContents = stack.getOrDefault(ModDataComponents.CHARGE_ANIMATION, ChargeAnimationComponent.EMPTY);
        float prev = flaskContents.PrevUseTime();
        float current = flaskContents.UseTime();
        return prev + f * (current - prev);
    }

    public static float getPullingAmount(ItemStack itemStack, float partialTicks){
        return Math.min(getLerpedUseTime(itemStack, partialTicks) / (float) getMaxLoadTime(), 1F);
    }


    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    public static float getPowerForTime(int i) {
        float f = (float) i / (float) getMaxLoadTime();
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    private Entity getPlayerLookTarget(Level level, LivingEntity living) {
        Entity pointedEntity = null;
        double range = 40.0D;
        Vec3 srcVec = living.getEyePosition();
        Vec3 lookVec = living.getViewVector(1.0F);
        Vec3 destVec = srcVec.add(lookVec.x() * range, lookVec.y() * range, lookVec.z() * range);
        float var9 = 2.0F;
        List<Entity> possibleList = level.getEntities(living, living.getBoundingBox().expandTowards(lookVec.x() * range, lookVec.y() * range, lookVec.z() * range).inflate(var9, var9, var9));
        double hitDist = 0;

        for (Entity possibleEntity : possibleList) {
            AABB collisionBB = possibleEntity.getBoundingBox().inflate(1.0d, 1.0d, 1.0d);
            Optional<Vec3> interceptPos = collisionBB.clip(srcVec, destVec);

            if (collisionBB.contains(srcVec)) {
                if (0.0D < hitDist || hitDist == 0.0D) {
                    pointedEntity = possibleEntity;
                    hitDist = 0.0D;
                }
            } else if (interceptPos.isPresent()) {
                double possibleDist = srcVec.distanceTo(interceptPos.get());

                if (possibleDist < hitDist || hitDist == 0.0D) {
                    pointedEntity = possibleEntity;
                    hitDist = possibleDist;
                }
            }

        }
        return pointedEntity;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity living, int timeleft) {
        if (living instanceof Player player) {

            Entity pointedEntity = getPlayerLookTarget(level, living);
            int i = this.getUseDuration(stack,living) - timeleft;
            float f = getPowerForTime(i);
            if (!((double) f < 0.1D)) {
                if (!level.isClientSide) {
                    float baseYaw = player.getYRot();
                    float pitch = player.getXRot();
                    for (int j = -1; j <= 1; j++) {
                        float yaw = baseYaw + (j * 15);
                         float directionX = -Mth.sin(yaw * ((float) Math.PI / 180F)) * Mth.cos(pitch * ((float) Math.PI / 180F));
                         float directionY = -Mth.sin(pitch * ((float) Math.PI / 180F));
                         float directionZ = Mth.cos(yaw * ((float) Math.PI / 180F)) * Mth.cos(pitch * ((float) Math.PI / 180F));
                         double theta = yaw * (Math.PI / 180); theta += Math.PI / 2;
                         double vecX = Math.cos(theta);
                         double vecZ = Math.sin(theta);
                         double x = player.getX() + vecX;
                         double Z = player.getZ() + vecZ;

                        if (pointedEntity instanceof LivingEntity target && !target.isAlliedTo(living)) {
                            Cursed_Sandstorm_Entity largefireball = new Cursed_Sandstorm_Entity(player, directionX, directionY, directionZ, player.level(), (float) CMConfig.CursedSandstormDamage * f, target);
                            largefireball.setPos(x, player.getEyeY() - 0.5D, Z);
                            largefireball.setUp(15);
                            level.addFreshEntity(largefireball);
                        }else{
                            Cursed_Sandstorm_Entity largefireball = new Cursed_Sandstorm_Entity(player, directionX, directionY, directionZ, player.level(), (float) CMConfig.CursedSandstormDamage * f, null);
                            largefireball.setPos(x, player.getEyeY() - 0.5D, Z);
                            largefireball.setUp(15);
                            level.addFreshEntity(largefireball);
                        }
                    }

                    level.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }

    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return 16;
    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return !oldStack.is(ModItems.WRATH_OF_THE_DESERT.get()) || !newStack.is(ModItems.WRATH_OF_THE_DESERT.get());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add(Component.translatable("item.cataclysm.wrath_of_the_desert.desc").withStyle(ChatFormatting.DARK_GREEN));
    }

}
