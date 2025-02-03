package com.github.L_Ender.cataclysm.Attachment;

import com.github.L_Ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.UUID;

public class TidalTentacleAttachment {

	private UUID lastTentacle;
	private boolean tentacle;
	public int id;

	public void setHasTentacle(boolean Tentacle) {
		this.tentacle = Tentacle;
	}

	public boolean hasTentacle() {
		return this.tentacle;
	}

	public void setLastTentacleID(int frozenPitch) {
		this.id = frozenPitch;
	}

	public int getLastTentacleID() {
		return id;
	}

	public void setLastTentacleUUID(UUID livingEntity) {
		lastTentacle = livingEntity;
	}

	public UUID getLastTentacleUUID() {
		return lastTentacle;
	}
}
