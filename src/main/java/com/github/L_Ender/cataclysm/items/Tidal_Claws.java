package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Attachment.TidalTentacleAttachment;
import com.github.L_Ender.cataclysm.entity.projectile.Storm_Bringer_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Tidal_Hook_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Tidal_Tentacle_Entity;
import com.github.L_Ender.cataclysm.entity.util.TidalTentacleUtil;
import com.github.L_Ender.cataclysm.init.ModDataAttachments;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.message.MessageHookFalling;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;


import java.util.List;

public class Tidal_Claws extends Item implements ILeftClick {


    public Tidal_Claws(Properties group) {
        super(group);

    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 7.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.4F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
                )
                .build();
    }

    public UseAnim getUseAnimation(ItemStack p_77661_1_) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }


    public boolean hurtEnemy(ItemStack stack, LivingEntity entity, LivingEntity player) {
        launchTendonsAt(stack, player, entity);
        return super.hurtEnemy(stack, entity, player);
    }

    private boolean isCharged(Player player, ItemStack stack){
        return player.getAttackStrengthScale(0.5F) > 0.9F;
    }

    public boolean onLeftClick(ItemStack stack, LivingEntity playerIn){
        if(stack.is(ModItems.TIDAL_CLAWS.get()) && (!(playerIn instanceof Player) || isCharged((Player)playerIn, stack))){
            Level worldIn = playerIn.level();
            Entity closestValid = null;
            Vec3 playerEyes = playerIn.getEyePosition(1.0F);
            HitResult hitresult = worldIn.clip(new ClipContext(playerEyes, playerEyes.add(playerIn.getLookAngle().scale(16.0D)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, playerIn));
            if (hitresult instanceof EntityHitResult) {
                Entity entity = ((EntityHitResult) hitresult).getEntity();
                if (!entity.equals(playerIn) && !playerIn.isAlliedTo(entity) && !entity.isAlliedTo(playerIn) && entity instanceof Mob && playerIn.hasLineOfSight(entity)) {
                    closestValid = entity;
                }
            } else {
                for (Entity entity : worldIn.getEntitiesOfClass(LivingEntity.class, playerIn.getBoundingBox().inflate(16.0D))) {
                    if (!entity.equals(playerIn) && !playerIn.isAlliedTo(entity) && !entity.isAlliedTo(playerIn) && entity instanceof Mob && playerIn.hasLineOfSight(entity)) {
                        if (closestValid == null || playerIn.distanceTo(entity) < playerIn.distanceTo(closestValid)) {
                            closestValid = entity;
                        }
                    }
                }
            }
            return launchTendonsAt(stack, playerIn, closestValid);
        }
        return false;
    }

    public boolean launchTendonsAt(ItemStack stack, LivingEntity playerIn, Entity closestValid) {
        Level worldIn = playerIn.level();

        TidalTentacleAttachment charge = playerIn.getData(ModDataAttachments.TIDAL_TENTACLE_ATTACHMENT);
        if(!charge.hasTentacle()) {
            if (TidalTentacleUtil.canLaunchTentacles(worldIn, playerIn)) {
                TidalTentacleUtil.retractFarTentacles(worldIn, playerIn);
                if (!worldIn.isClientSide) {
                    if (closestValid != null) {
                        Tidal_Tentacle_Entity segment = ModEntities.TIDAL_TENTACLE.get().create(worldIn);
                        segment.copyPosition(playerIn);
                        worldIn.addFreshEntity(segment);
                        segment.setCreatorEntityUUID(playerIn.getUUID());
                        segment.setFromEntityID(playerIn.getId());
                        segment.setToEntityID(closestValid.getId());
                        segment.copyPosition(playerIn);
                        segment.setProgress(0.0F);
                        TidalTentacleUtil.setLastTentacle(playerIn, segment);
                        return true;
                    }
                }
            }
        }

        return false;
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player user, InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);
        boolean flag = user.getData(ModDataAttachments.HOOK_FALLING);
        if(!level.isClientSide) {
            if(!flag) {
                double maxRange = 30;
                double maxSpeed = 12;

                Tidal_Hook_Entity hookshot = new Tidal_Hook_Entity(level, user, ItemStack.EMPTY);
                hookshot.setProperties(stack, maxRange, maxSpeed, user.getXRot(), user.getYRot(), 0f, 1.5f * (float) (maxSpeed / 10));
                level.addFreshEntity(hookshot);


            }

        }
        user.startUsingItem(hand);
        user.setData(ModDataAttachments.HOOK_FALLING, true);
        return super.use(level, user, hand);
    }

    public ItemStack finishUsingItem(ItemStack p_40712_, Level p_40713_, LivingEntity p_40714_) {
        boolean flag = p_40714_.getData(ModDataAttachments.HOOK_FALLING);

        if(flag){
            p_40714_.setData(ModDataAttachments.HOOK_FALLING, false);
        }
        return super.finishUsingItem(p_40712_, p_40713_, p_40714_);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        boolean flag = user.getData(ModDataAttachments.HOOK_FALLING);
        if(flag){
            user.setData(ModDataAttachments.HOOK_FALLING, false);
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

    public boolean canAttackBlock(BlockState state, Level worldIn, BlockPos pos, Player player) {
        return !player.isCreative();
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add(Component.translatable("item.cataclysm.tidal_claws.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add(Component.translatable("item.cataclysm.tidal_claws.desc2").withStyle(ChatFormatting.DARK_GREEN));
    }
}