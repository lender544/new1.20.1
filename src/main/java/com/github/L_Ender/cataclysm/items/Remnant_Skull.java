package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.entity.Pet.Modern_Remnant_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class Remnant_Skull extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);

    public Remnant_Skull(Properties properties) {
        super(properties);
    }



    public InteractionResultHolder<ItemStack> use(Level p_40622_, Player p_40623_, InteractionHand p_40624_) {
        ItemStack itemstack = p_40623_.getItemInHand(p_40624_);
        HitResult hitresult = getPlayerPOVHitResult(p_40622_, p_40623_, ClipContext.Fluid.ANY);
        if (hitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            Vec3 vec3 = p_40623_.getViewVector(1.0F);
            Vec3 vec31 = hitresult.getLocation();
            double d0 = 5.0D;
            List<Entity> list = p_40622_.getEntities(p_40623_, p_40623_.getBoundingBox().expandTowards(vec3.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
            if (!list.isEmpty()) {
                for(Entity entity : list) {
                    AABB aabb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
                    if (aabb.contains(vec31)) {
                        return InteractionResultHolder.pass(itemstack);
                    }
                }
            }

            if (hitresult.getType() == HitResult.Type.BLOCK) {
                Modern_Remnant_Entity remnantEntity = ModEntities.MODERN_REMNANT.get().create(p_40622_);
                remnantEntity.setPos(vec31.x, vec31.y, vec31.z);
                if (!p_40622_.noCollision(remnantEntity, remnantEntity.getBoundingBox())) {
                    return InteractionResultHolder.fail(itemstack);
                } else {
                    if (!p_40622_.isClientSide) {
                        p_40622_.addFreshEntity(remnantEntity);
                        p_40622_.gameEvent(p_40623_, GameEvent.ENTITY_PLACE, vec31);
                        if (!p_40623_.getAbilities().instabuild) {
                            itemstack.shrink(1);
                        }
                    }
                    p_40623_.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(itemstack, p_40622_.isClientSide());
                }
            } else {
                return InteractionResultHolder.pass(itemstack);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add(Component.translatable("item.cataclysm.remnant_skull.desc").withStyle(ChatFormatting.DARK_GREEN));
    }

}
