package com.github.L_Ender.cataclysm.items.Dungeon_Eye;

import com.github.L_Ender.cataclysm.entity.projectile.Eye_Of_Dungeon_Entity;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.structure.Structure;

public class DungeonEyeItem extends Item {
    private final TagKey<Structure> Structure;
    private final int Red;
    private final int Green;
    private final int Blue;

    public DungeonEyeItem(Properties group, TagKey<Structure> structureTag, int r, int g, int b) {
        super(group);
        this.Structure = structureTag;
        this.Red = r;
        this.Green = g;
        this.Blue = b;
    }


    public InteractionResultHolder<ItemStack> use(Level p_41184_, Player p_41185_, InteractionHand p_41186_) {
        ItemStack itemstack = p_41185_.getItemInHand(p_41186_);
        p_41185_.startUsingItem(p_41186_);
        if (p_41184_ instanceof ServerLevel) {
            ServerLevel serverlevel = (ServerLevel) p_41184_;
            BlockPos blockpos = serverlevel.findNearestMapStructure(Structure, p_41185_.blockPosition(), 100, false);
            if (blockpos != null) {
                Eye_Of_Dungeon_Entity eyeofender = new Eye_Of_Dungeon_Entity(p_41184_, p_41185_.getX(), p_41185_.getY(0.5D), p_41185_.getZ());
                eyeofender.setItem(itemstack);
                eyeofender.setR(Red);
                eyeofender.setG(Green);
                eyeofender.setB(Blue);
                eyeofender.signalTo(blockpos);
                p_41184_.gameEvent(GameEvent.PROJECTILE_SHOOT, eyeofender.position(), GameEvent.Context.of(p_41185_));
                p_41184_.addFreshEntity(eyeofender);
                if (p_41185_ instanceof ServerPlayer) {
                    CriteriaTriggers.USED_ENDER_EYE.trigger((ServerPlayer) p_41185_, blockpos);
                }

                p_41184_.playSound((Player) null, p_41185_.getX(), p_41185_.getY(), p_41185_.getZ(), SoundEvents.ENDER_EYE_LAUNCH, SoundSource.NEUTRAL, 0.5F, 0.4F / (p_41184_.getRandom().nextFloat() * 0.4F + 0.8F));
                p_41184_.levelEvent((Player) null, 1003, p_41185_.blockPosition(), 0);
                p_41185_.getCooldowns().addCooldown(this, 60);
                p_41185_.awardStat(Stats.ITEM_USED.get(this));
                p_41185_.swing(p_41186_, true);
                return InteractionResultHolder.success(itemstack);
            }
        }

        return InteractionResultHolder.consume(itemstack);
    }
}