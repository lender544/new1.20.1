package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Arrow_Entity;
import com.github.L_Ender.cataclysm.init.ModDataComponents;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.items.Components.CursedBowComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Cursed_bow extends ProjectileWeaponItem  {


    public Cursed_bow(Properties group) {
        super(group);

    }

    
    public InteractionResultHolder<ItemStack> use(Level p_40672_, Player p_40673_, InteractionHand p_40674_) {
        ItemStack itemstack = p_40673_.getItemInHand(p_40674_);
        boolean flag = !p_40673_.getProjectile(itemstack).isEmpty();

        InteractionResultHolder<ItemStack> ret = EventHooks.onArrowNock(itemstack, p_40672_, p_40673_, p_40674_, flag);
        if (ret != null) {
            return ret;
        } else if (!p_40673_.hasInfiniteMaterials() && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            p_40673_.startUsingItem(p_40674_);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public int getUseDuration(ItemStack stack, LivingEntity pEntity) {
        return 72000;
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        boolean using = entity instanceof LivingEntity living && living.getUseItem().equals(stack);
        int useTime = getUseTime(stack);
        CursedBowComponent flaskContents = stack.getOrDefault(ModDataComponents.CURSED_BOW, CursedBowComponent.EMPTY);

            if (flaskContents.PrevUseTime() != flaskContents.UseTime()) {
                stack.update(ModDataComponents.CURSED_BOW, flaskContents, component -> component.tryAddDose(useTime,getUseTime(stack)));
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
        CursedBowComponent flaskContents = stack.getOrDefault(ModDataComponents.CURSED_BOW, CursedBowComponent.EMPTY);
        return flaskContents.UseTime();
    }

    public static void setUseTime(ItemStack stack, int useTime) {
        CursedBowComponent flaskContents = stack.getOrDefault(ModDataComponents.CURSED_BOW, CursedBowComponent.EMPTY);
        stack.update(ModDataComponents.CURSED_BOW, flaskContents, component -> component.tryAddDose(useTime,getUseTime(stack)));
    }

    public static float getLerpedUseTime(ItemStack stack, float f) {
        CursedBowComponent flaskContents = stack.getOrDefault(ModDataComponents.CURSED_BOW, CursedBowComponent.EMPTY);
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
        float f = (float) i / (float)getMaxLoadTime();
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
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player) {
            ItemStack itemstack = player.getProjectile(stack);
            Entity pointedEntity = getPlayerLookTarget(level, entityLiving);
            if (!itemstack.isEmpty()) {
                int i = this.getUseDuration(stack, entityLiving) - timeLeft;
                i = EventHooks.onArrowLoose(stack, level, player, i, !itemstack.isEmpty());
                if (i < 0) {
                    return;
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.1)) {
                    List<ItemStack> list = draw(stack, itemstack, player);
                    if (level instanceof ServerLevel) {
                        ServerLevel serverlevel = (ServerLevel)level;
                        if (!list.isEmpty()) {
                            this.shoot(serverlevel, player, player.getUsedItemHand(), stack, list, f, 1.0F, f == 1.0F,pointedEntity);
                        }
                    }

                    level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }

    }

    protected void shoot(ServerLevel level, LivingEntity shooter, InteractionHand hand, ItemStack weapon, List<ItemStack> projectileItems, float velocity, float inaccuracy, boolean isCrit, @Nullable Entity target) {
        float f = EnchantmentHelper.processProjectileSpread(level, weapon, shooter, 0.0F);
        float f1 = projectileItems.size() == 1 ? 0.0F : 2.0F * f / (float)(projectileItems.size() - 1);
        float f2 = (float)((projectileItems.size() - 1) % 2) * f1 / 2.0F;
        float f3 = 1.0F;

        for(int i = 0; i < projectileItems.size(); ++i) {
            ItemStack itemstack = (ItemStack)projectileItems.get(i);
            if (!itemstack.isEmpty()) {
                boolean hommingArrows = itemstack.is(Items.ARROW);
                int arrowcount = itemstack.is(Items.ARROW) ? 3 : 2 ;
                float offsetangle = itemstack.is(Items.ARROW) ? 12 : 3;
                boolean flag1 = shooter.hasInfiniteMaterials() || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, weapon, shooter));
                for (int j = 0; j < arrowcount; j++) {

                    //AbstractArrow abstractarrow = arrowItem.createArrow(level, itemstack, player);
                    AbstractArrow abstractarrow =  this.createArrow(level, shooter, weapon, itemstack, isCrit);
                    abstractarrow = customArrow(abstractarrow);

                    if (hommingArrows) {
                        if (target instanceof LivingEntity tango && !target.isAlliedTo(shooter)) {
                            Phantom_Arrow_Entity hommingArrowEntity = new Phantom_Arrow_Entity(level, shooter, tango);
                            hommingArrowEntity.setBaseDamage(CMConfig.PlayerPhantomArrowbasedamage * velocity);

                            abstractarrow = hommingArrowEntity;
                        } else {
                            Phantom_Arrow_Entity hommingArrowEntity = new Phantom_Arrow_Entity(level, shooter);
                            hommingArrowEntity.setBaseDamage(CMConfig.PlayerPhantomArrowbasedamage * velocity);

                            abstractarrow = hommingArrowEntity;
                        }
                    } else {
                        abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + 0.5D);
                    }
                    if (j != 1) {
                        abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                    } else if (flag1 || shooter.hasInfiniteMaterials()  && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
                        abstractarrow.pickup = AbstractArrow.Pickup.ALLOWED;
                    }
                    abstractarrow.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + (j - (arrowcount - 1) / 2.0F) * offsetangle, 0.0F, velocity * 3, inaccuracy);
                    if (f == 1.0F) {
                        abstractarrow.setCritArrow(true);
                    }

                    level.addFreshEntity(abstractarrow);
                    if (weapon.isEmpty()) {
                        break;
                    }
                }
            }


        }



    }

    protected AbstractArrow createArrow(Level level, LivingEntity shooter, ItemStack weapon, ItemStack ammo, boolean isCrit) {
        Item var8 = ammo.getItem();
        ArrowItem var10000;
        if (var8 instanceof ArrowItem arrowitem1) {
            var10000 = arrowitem1;
        } else {
            var10000 = (ArrowItem)Items.ARROW;
        }



        ArrowItem arrowitem = var10000;
        AbstractArrow abstractarrow = arrowitem.createArrow(level, ammo, shooter, weapon);
        if (isCrit) {
            abstractarrow.setCritArrow(true);
        }

        return this.customArrow(abstractarrow, ammo, weapon);
    }


    public AbstractArrow customArrow(AbstractArrow arrow) {
        return arrow;
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
        return !oldStack.is(ModItems.CURSED_BOW.get()) || !newStack.is(ModItems.CURSED_BOW.get());
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 64;
    }

    protected void shootProjectile(LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target) {
        projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, velocity, inaccuracy);
    }



    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add(Component.translatable("item.cataclysm.cursed_bow.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add(Component.translatable("item.cataclysm.cursed_bow2.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}
