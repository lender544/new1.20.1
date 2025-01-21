package com.github.L_Ender.cataclysm.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class ModFishBucket extends MobBucketItem {
    private final EntityType<?> type;
    public ModFishBucket(EntityType<?> fishTypeIn, Fluid fluid, Properties builder) {
        super(fishTypeIn,  fluid, SoundEvents.BUCKET_EMPTY_FISH, builder.stacksTo(1));
        this.type = fishTypeIn;
    }
    
    @Override
    public void checkExtraContent(@Nullable Player player, Level level, ItemStack stack, BlockPos pos) {
        if (level instanceof ServerLevel) {
            this.spawn((ServerLevel)level, stack, pos);
            level.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
        }
    }

    private void spawn(ServerLevel p_151142_, ItemStack p_151143_, BlockPos p_151144_) {
        if (this.type.spawn(p_151142_, p_151143_, null, p_151144_, MobSpawnType.BUCKET, true, false) instanceof Bucketable bucketable) {
            CustomData customdata = p_151143_.getOrDefault(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY);
            bucketable.loadFromBucketTag(customdata.copyTag());
            bucketable.setFromBucket(true);
        }
    }

}
