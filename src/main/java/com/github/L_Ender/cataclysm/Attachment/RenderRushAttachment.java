package com.github.L_Ender.cataclysm.Attachment;

import com.github.L_Ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Wall_Watcher_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class RenderRushAttachment {

	private boolean charge;
	public int Timer;
	public float damage;

	public void tick(LivingEntity entity) {
		if(isRush()) {
			int standingOnY = Mth.floor(entity.getY()) - 3;
			double headY = entity.getY() + 2.0D;
			float yawRadians = (float) (Math.toRadians(90 + entity.getYRot()));
			int temp = getTimer();

			setTimer(temp - 1);
			//Deal with rocket punch is valid
			if (temp > 0) {
				double yaw = Math.toRadians(entity.getYRot() + 90);
				double xExpand = 3 * Math.cos(yaw);
				double zExpand = 3 * Math.sin(yaw);
				AABB attackRange = entity.getBoundingBox().expandTowards(xExpand, 0, zExpand);
				for (LivingEntity target : entity.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
					if (!target.isAlliedTo(entity) && target != entity) {
						target.hurt(entity.damageSources().mobAttack(entity), getdamage());

					}
				}


				if(temp % 2 ==0){
					this.spawnFangs(entity.getX(), headY, entity.getZ(), standingOnY, yawRadians, 1, entity.level(), entity);
					double x = entity.getX();
					double y = entity.getY() + entity.getBbHeight() / 2;
					double z = entity.getZ();
					float yaw2 = (float) Math.toRadians(-entity.getYRot());
					float yaw3 = (float) Math.toRadians(-entity.getYRot() + 180);
					entity.level().addParticle(new RingParticleOptions(yaw2, 0, 20, 86, 236, 204, 1.0f, 30f, false, 2), x, y, z, 0, 0, 0);

					entity.level().addParticle(new RingParticleOptions(yaw3, 0, 20, 86, 236, 204, 1.0f, 30f, false, 2), x, y, z, 0, 0, 0);
				}
			}

			if (temp == 0) {
				setRush(false);

			}
		}
	}


	private void spawnFangs(double x, double y, double z, int lowestYCheck, float yRot, int warmupDelayTicks, Level world, LivingEntity player) {
		BlockPos blockpos = BlockPos.containing(x, y, z);
		boolean flag = false;
		double d0 = 0.0D;

		do {
			BlockPos blockpos1 = blockpos.below();
			BlockState blockstate = world.getBlockState(blockpos1);
			if (blockstate.isFaceSturdy(world, blockpos1, Direction.UP)) {
				if (!world.isEmptyBlock(blockpos)) {
					BlockState blockstate1 = world.getBlockState(blockpos);
					VoxelShape voxelshape = blockstate1.getCollisionShape(world, blockpos);
					if (!voxelshape.isEmpty()) {
						d0 = voxelshape.max(Direction.Axis.Y);
					}
				}

				flag = true;
				break;
			}

			blockpos = blockpos.below();
		} while (blockpos.getY() >= lowestYCheck);

		if (flag) {
			world.addFreshEntity(new Phantom_Halberd_Entity(world, x, (double) blockpos.getY() + d0, z, yRot, warmupDelayTicks, player,(float) CMConfig.PhantomHalberddamage));
		}
	}

	
	public void setRush(boolean charge) {
		this.charge = charge;
	}

	
	public boolean isRush() {
		return this.charge;
	}


	
	public void setdamage(float damage) {
		this.damage = damage;
	}

	
	public float getdamage() {
		return this.damage;
	}




	
	public void setTimer(int timer) {
		this.Timer = timer;
	}

	
	public int getTimer() {
		return Timer;
	}
}
