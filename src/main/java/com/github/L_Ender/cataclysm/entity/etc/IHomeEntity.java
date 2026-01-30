package com.github.L_Ender.cataclysm.entity.etc;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;

import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public interface IHomeEntity {


	default void addAdditionalHomePoint(CompoundTag tag) {
		if (this.getHomePos() != null) {
			GlobalPos.CODEC.encodeStart(NbtOps.INSTANCE, this.getHomePos()).resultOrPartial(Cataclysm.LOGGER::error).ifPresent(tag1 -> tag.put("HomePos", tag1));
		}
	}

	default void readAdditionalHomePoint(CompoundTag tag) {
		if (tag.contains("Home", 9)) {
			ListTag nbttaglist = tag.getList("Home", 6);
			double hx = nbttaglist.getDouble(0);
			double hy = nbttaglist.getDouble(1);
			double hz = nbttaglist.getDouble(2);
			this.setHomePos(GlobalPos.of(Level.OVERWORLD, BlockPos.containing(hx, hy, hz)));
		} else {
			if (tag.contains("HomePos")) {
				this.setHomePos(GlobalPos.CODEC.parse(NbtOps.INSTANCE, tag.get("HomePos")).resultOrPartial(Cataclysm.LOGGER::error).orElse(null));
			}
		}
	}


	@Nullable
	GlobalPos getHomePos();

	void setHomePos(@Nullable GlobalPos pos);

}
