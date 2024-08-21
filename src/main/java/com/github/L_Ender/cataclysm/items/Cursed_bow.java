package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Arrow_Entity;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Cursed_bow extends ProjectileWeaponItem  {


    public Cursed_bow(Properties group) {
        super(group);
    }

    @Override
    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        ItemStack ammo = player.getProjectile(itemstack);
        boolean flag = player.isCreative();
        if(flag || !ammo.isEmpty()){
            AbstractArrow lastArrow = createArrow(player, itemstack, ItemStack.EMPTY);
            EntityType lastArrowType = lastArrow == null ? EntityType.ARROW : lastArrow.getType();
            itemstack.getOrCreateTag().putString("LastUsedArrowType", ForgeRegistries.ENTITY_TYPES.getKey(lastArrowType).toString());
            player.startUsingItem(interactionHand);
            return InteractionResultHolder.consume(itemstack);
        }else{
            return InteractionResultHolder.fail(itemstack);
        }
    }

    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        boolean using = entity instanceof LivingEntity living && living.getUseItem().equals(stack);
        int useTime = getUseTime(stack);
        if (level.isClientSide) {
            CompoundTag tag = stack.getOrCreateTag();
            if (tag.getInt("PrevUseTime") != tag.getInt("UseTime")) {
                tag.putInt("PrevUseTime", getUseTime(stack));
            }

            int maxLoadTime = getMaxLoadTime(stack);
            if (using && useTime < maxLoadTime) {
                int set = useTime +  1;
                setUseTime(stack, set);
                //Cataclysm.sendMSGToServer(new MessageUpdateItemTag(entity.getId(), stack));
                }
            }
            if (!using && useTime > 0.0F) {
                setUseTime(stack, Math.max(0, useTime - 5));
            }
        }


    private static int getMaxLoadTime(ItemStack stack) {
        return 20;
    }

    public static int getUseTime(ItemStack stack) {
        CompoundTag compoundtag = stack.getTag();
        return compoundtag != null ? compoundtag.getInt("UseTime") : 0;
    }

    public static void setUseTime(ItemStack stack, int useTime) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putInt("PrevUseTime", getUseTime(stack));
        tag.putInt("UseTime", useTime);
    }

    public static float getLerpedUseTime(ItemStack stack, float f) {
        CompoundTag compoundtag = stack.getTag();
        float prev = compoundtag != null ? (float) compoundtag.getInt("PrevUseTime") : 0F;
        float current = compoundtag != null ? (float) compoundtag.getInt("UseTime") : 0F;
        return prev + f * (current - prev);
    }

    public static float getPullingAmount(ItemStack itemStack, float partialTicks){
        return Math.min(getLerpedUseTime(itemStack, partialTicks) / (float) getMaxLoadTime(itemStack), 1F);
    }


    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    public static float getPowerForTime(int i, ItemStack itemStack) {
        float f = (float) i / (float)getMaxLoadTime(itemStack);
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    private Entity getPlayerLookTarget(Level level, LivingEntity living) {
        Entity pointedEntity = null;
        double range = 30.0D;
        Vec3 srcVec = living.getEyePosition();
        Vec3 lookVec = living.getViewVector(1.0F);
        Vec3 destVec = srcVec.add(lookVec.x() * range, lookVec.y() * range, lookVec.z() * range);
        float var9 = 2.0F;
        List<Entity> possibleList = level.getEntities(living, living.getBoundingBox().expandTowards(lookVec.x() * range, lookVec.y() * range, lookVec.z() * range).inflate(var9, var9, var9));
        double hitDist = 0;

        for (Entity possibleEntity : possibleList) {

            if (possibleEntity.isPickable()) {
                float borderSize = possibleEntity.getPickRadius();
                AABB collisionBB = possibleEntity.getBoundingBox().inflate(borderSize, borderSize, borderSize);
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
        }
        return pointedEntity;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity living, int timeLeft) {
        if (living instanceof Player player) {
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getTagEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
            ItemStack itemstack = player.getProjectile(stack);

            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, level, player, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;
            ItemStack ammoStack = player.getProjectile(stack);
            AbstractArrow abstractArrow = createArrow(player, stack, ammoStack);
            Entity pointedEntity = getPlayerLookTarget(level, living);
            if (abstractArrow != null) {

                if (!itemstack.isEmpty() || flag) {
                    if (itemstack.isEmpty()) itemstack = new ItemStack(Items.ARROW);

                    float f = getPowerForTime(i, stack);
                    if (f >= 0.1D) {
                        boolean flag1 = player.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem arrowItem && arrowItem.isInfinite(itemstack, stack, player));
                        if (!level.isClientSide()) {
                            boolean darkArrows = isConvertibleArrow(abstractArrow);
                            abstractArrow.pickup = AbstractArrow.Pickup.ALLOWED;

                            for (int j = -1; j < 2; j++) {

                                if (darkArrows) {
                                    if (pointedEntity instanceof LivingEntity target && !target.isAlliedTo(living)) {
                                        Phantom_Arrow_Entity darkArrowEntity = new Phantom_Arrow_Entity(level, living, target);
                                        abstractArrow = darkArrowEntity;
                                    } else {
                                        Phantom_Arrow_Entity darkArrowEntity = new Phantom_Arrow_Entity(level, living);
                                        abstractArrow = darkArrowEntity;
                                    }
                                }

                                abstractArrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * (3.0F - Math.abs(j)), 1.0F);
                                abstractArrow.setDeltaMovement(abstractArrow.getDeltaMovement().add(0.0D, 0.0075 * 20F * j, 0.0D));

                                if (j != 0) {
                                    abstractArrow.setPos(abstractArrow.getX(), abstractArrow.getY() + 0.025F, abstractArrow.getZ());
                                    abstractArrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                                } else if (flag1 || player.getAbilities().instabuild && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
                                    abstractArrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                                }

                                if (f == 1.0F) abstractArrow.setCritArrow(true);

                                int p = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
                                if (p > 0) abstractArrow.setBaseDamage(abstractArrow.getBaseDamage() + j * 0.5D + 0.5D);

                                int k = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
                                if (k > 0) abstractArrow.setKnockback(k);

                                if (EnchantmentHelper.getTagEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0)
                                    abstractArrow.setSecondsOnFire(100);

                                level.addFreshEntity(abstractArrow);
                            }

                        }

                        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                        if (!flag1 && !player.getAbilities().instabuild) {
                            itemstack.shrink(1);
                            if (itemstack.isEmpty()) player.getInventory().removeItem(itemstack);
                        }

                        player.awardStat(Stats.ITEM_USED.get(this));
                    }
                }
            }
        }
    }


    private AbstractArrow createArrow(Player player, ItemStack bowStack, ItemStack ammoIn) {
        ItemStack ammo = ammoIn.isEmpty() ? player.getProjectile(bowStack) : ammoIn;
        ArrowItem arrowitem = (ArrowItem)(ammo.getItem() instanceof ArrowItem ? ammo.getItem() : Items.ARROW);
        AbstractArrow abstractArrow =  arrowitem.createArrow(player.level(), ammo, player);
        return abstractArrow;
    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return !oldStack.is(ModItems.CURSED_BOW.get()) || !newStack.is(ModItems.CURSED_BOW.get());
    }
    public static boolean isConvertibleArrow(Entity arrowEntity){
        return arrowEntity instanceof Arrow arrow && arrow.getColor() == -1;
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 64;
    }
}
