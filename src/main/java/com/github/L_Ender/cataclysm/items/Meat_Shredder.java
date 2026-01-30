package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.Options.ParryParticleOptions;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;

import java.util.List;
import java.util.Optional;

public class Meat_Shredder extends Cataclysm_Weapon {

	public Meat_Shredder(Properties properties) {
		super(properties);

	}

	public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
		ItemStack item = p_77659_2_.getItemInHand(p_77659_3_);
		InteractionHand otherhand = p_77659_3_ == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
		ItemStack otheritem = p_77659_2_.getItemInHand(otherhand);
		if (otheritem.canPerformAction(ItemAbilities.SHIELD_BLOCK) && !p_77659_2_.getCooldowns().isOnCooldown(otheritem.getItem())) {
			return InteractionResultHolder.fail(item);
		}else{
			p_77659_2_.startUsingItem(p_77659_3_);
			p_77659_1_.playSound(null, p_77659_2_.getX(), p_77659_2_.getY(), p_77659_2_.getZ(), ModSounds.SHREDDER_START.get(), SoundSource.PLAYERS, 1.5f, 1F / (p_77659_2_.getRandom().nextFloat() * 0.4F + 0.8F));
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

	@Override
	public void onUseTick(Level level, LivingEntity living, ItemStack stack, int count) {
		double range = 2.5D;
		Vec3 srcVec = living.getEyePosition();
		Vec3 lookVec = living.getViewVector(1.0F);
		Vec3 destVec = srcVec.add(lookVec.x() * range, lookVec.y() * range, lookVec.z() * range);
		float var9 = 1.0F;
		List<Entity> possibleList = level.getEntities(living, living.getBoundingBox().expandTowards(lookVec.x() * range, lookVec.y() * range, lookVec.z() * range).inflate(var9, var9, var9));

		boolean flag = false;
		Cataclysm.PROXY.playWorldSound(living, (byte) 1);
		for (Entity entity : possibleList) {
			if (entity instanceof LivingEntity) {
				float borderSize = 0.5F;
				AABB collisionBB = entity.getBoundingBox().inflate(borderSize, borderSize, borderSize);
				Optional<Vec3> interceptPos = collisionBB.clip(srcVec, destVec);
				if (collisionBB.contains(srcVec)) {
					flag =true;
				} else if (interceptPos.isPresent()) {
					flag =true;
				}

				if (flag) {
					if(!level.isClientSide()) {
						if (entity.hurt(CMDamageTypes.causeShredderDamage(living), (float) living.getAttributeValue(Attributes.ATTACK_DAMAGE) / 8.5F)) {
							double d0 = (level.getRandom().nextFloat() - 0.5F) + entity.getDeltaMovement().x;
							double d1 = (level.getRandom().nextFloat() - 0.5F) + entity.getDeltaMovement().y;
							double d2 = (level.getRandom().nextFloat() - 0.5F) + entity.getDeltaMovement().z;
							if (level instanceof ServerLevel serverLevel) {
								serverLevel.sendParticles(new ParryParticleOptions(255 / 255F, 106 / 255F, 0 / 255F), entity.getX(), entity.getY(0.5), entity.getZ(), 2, entity.getDeltaMovement().x, entity.getDeltaMovement().y, entity.getDeltaMovement().z, (level.getRandom().nextFloat() - 0.5F));
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void releaseUsing(ItemStack stack, Level world, LivingEntity living, int remainingUseTicks) {
		world.playSound(null, living.getX(), living.getY(), living.getZ(), ModSounds.SHREDDER_END.get(), SoundSource.PLAYERS, 1.5f, 1F / (living.getRandom().nextFloat() * 0.4F + 0.8F));
		Cataclysm.PROXY.clearSoundCacheFor(living);
	}

	public float getDestroySpeed(ItemStack p_41004_, BlockState p_41005_) {
		float speed = 15;

		return p_41005_.is(BlockTags.MINEABLE_WITH_AXE) ? speed : 1.0F;
	}

	@Override
	public int getUseDuration(ItemStack p_43419_, LivingEntity p_345001_) {
		return 72000;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}


	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
		tooltips.add(Component.translatable("item.cataclysm.meat_shredder.desc").withStyle(ChatFormatting.DARK_GREEN));
	}
}