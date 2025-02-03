package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Attachment.ChargeAttachment;
import com.github.L_Ender.cataclysm.Attachment.RenderRushAttachment;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import com.github.L_Ender.cataclysm.init.ModDataAttachments;
import com.github.L_Ender.cataclysm.init.ModParticle;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.neoforged.neoforge.common.ItemAbilities;


import java.util.List;

public class Soul_Render extends Item implements RangeTool {

	public Soul_Render(Properties properties) {
		super(properties);

	}


	public static ItemAttributeModifiers createAttributes() {
		return ItemAttributeModifiers.builder()
				.add(
						Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 14D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
				)
				.add(
						Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.9F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
				)
				.add(
						Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, 2.0F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
				)
				.add(
						Attributes.BLOCK_INTERACTION_RANGE, new AttributeModifier(BASE_BLOCK_INTERACTION_RANGE_ID, 2.0F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
				)
				.build();
	}

	@Override
	public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeLeft) {
		boolean hasSucceeded = false;
		if (livingEntity instanceof Player player) {
			int i = this.getUseDuration(stack,livingEntity) - timeLeft;
			if(livingEntity.isShiftKeyDown()) {
				StrikeWindmillHalberd(level,player,7, 5, 1.0, 1.0, 0.2, 1);
				if (!level.isClientSide) {
					player.getCooldowns().addCooldown(this, CMConfig.SoulRenderCooldown);
				}
			}else{
				int t = Mth.clamp(i, 0, 60);
				if (t > 0) {
					float f = 0.1F * t;
					Vec3 vec3 = player.getDeltaMovement().add(player.getViewVector(1.0F).normalize().multiply(f, f * 0.15F, f));
					livingEntity.setDeltaMovement(vec3.add(0, (livingEntity.onGround() ? 0.2F : 0), 0));

					RenderRushAttachment charge = livingEntity.getData(ModDataAttachments.RENDER_RUSH_ATTACHMENT);
					charge.setRush(true);
					charge.setTimer(t / 2);
					charge.setdamage((float) player.getAttributeValue(Attributes.ATTACK_DAMAGE));
					hasSucceeded = true;

					if (!level.isClientSide) {
						if (hasSucceeded) {
							player.getCooldowns().addCooldown(this, CMConfig.SoulRenderCooldown);
						}
					}
				}
			}
		}
	}

	private void StrikeWindmillHalberd(Level level,LivingEntity player,int numberOfBranches, int particlesPerBranch, double initialRadius, double radiusIncrement, double curveFactor, int delay) {
		float angleIncrement = (float) (2 * Math.PI / numberOfBranches);
		for (int branch = 0; branch < numberOfBranches; ++branch) {
			float baseAngle = angleIncrement * branch;
			for (int i = 0; i < particlesPerBranch; ++i) {
				double currentRadius = initialRadius + i * radiusIncrement;
				float currentAngle = (float) (baseAngle + i * angleIncrement / initialRadius + (float) (i * curveFactor));

				double xOffset = currentRadius * Math.cos(currentAngle);
				double zOffset = currentRadius * Math.sin(currentAngle);

				double spawnX = player.getX() + xOffset;
				double spawnY = player.getY() + 0.3D;
				double spawnZ = player.getZ() + zOffset;
				int d3 = delay * (i + 1);
				double deltaX = level.getRandom().nextGaussian() * 0.007D;
				double deltaY = level.getRandom().nextGaussian() * 0.007D;
				double deltaZ = level.getRandom().nextGaussian() * 0.007D;
				if (level.isClientSide) {
					level.addParticle(ModParticle.PHANTOM_WING_FLAME.get(), spawnX, spawnY, spawnZ, deltaX, deltaY, deltaZ);
				}
				this.spawnHalberd(spawnX, spawnZ, player.getY() -5, player.getY() + 3, currentAngle, d3,level,player);

			}
		}
	}

	private void spawnHalberd(double x, double z, double minY, double maxY, float rotation, int delay, Level world, LivingEntity player) {
		BlockPos blockpos = BlockPos.containing(x, maxY, z);
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
		} while(blockpos.getY() >= Mth.floor(minY) - 1);
		if (flag) {
			world.addFreshEntity(new Phantom_Halberd_Entity(world, x, (double)blockpos.getY() + d0, z, rotation, delay, player,(float)CMConfig.PhantomHalberddamage));
		}
	}

	public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
		ItemStack item = p_77659_2_.getItemInHand(p_77659_3_);
		InteractionHand otherhand = p_77659_3_ == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;

		ItemStack otheritem = p_77659_2_.getItemInHand(otherhand);

		if (otheritem.canPerformAction(ItemAbilities.SHIELD_BLOCK) && !p_77659_2_.getCooldowns().isOnCooldown(otheritem.getItem())) {
			return InteractionResultHolder.fail(item);
		}else{
			p_77659_2_.startUsingItem(p_77659_3_);
			return InteractionResultHolder.consume(item);
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

	public float getDestroySpeed(ItemStack p_41004_, BlockState p_41005_) {
		float speed = 15;
		return p_41005_.is(BlockTags.MINEABLE_WITH_AXE) ? speed : 1.0F;
	}

	public static float getPowerForTime(int i) {
		float f = (float) i / (float)getMaxLoadTime();
		f = (f * f + f * 2.0F) / 3.0F;
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	private static int getMaxLoadTime() {
		return 20;
	}

	@Override
	public int getUseDuration(ItemStack p_43419_, LivingEntity p_345001_) {
		return 72000;
	}
	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BLOCK;
	}


	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
		tooltips.add(Component.translatable("item.cataclysm.soul_render.desc").withStyle(ChatFormatting.DARK_GREEN));
		tooltips.add(Component.translatable("item.cataclysm.soul_render2.desc").withStyle(ChatFormatting.DARK_GREEN));
	}
}