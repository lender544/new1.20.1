package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.projectile.Sandstorm_Projectile;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.message.MessageMusic;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.network.PacketDistributor;


import java.util.List;
import java.util.Optional;

public class Meat_Shredder extends Item {

	public Meat_Shredder(Properties properties) {
		super(properties);

	}

	public static ItemAttributeModifiers createAttributes() {
		return ItemAttributeModifiers.builder()
				.add(
						Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 7.5D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
				)
				.add(
						Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.6F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
				)
				.build();
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
					if (entity.hurt(CMDamageTypes.causeShredderDamage(living), (float) living.getAttributeValue(Attributes.ATTACK_DAMAGE) / 8.5F)) {
					}
					double d0 = (level.getRandom().nextFloat() - 0.5F) + entity.getDeltaMovement().x;
					double d1 = (level.getRandom().nextFloat() - 0.5F) + entity.getDeltaMovement().y;
					double d2 = (level.getRandom().nextFloat() - 0.5F) + entity.getDeltaMovement().z;
					double dist = 1F + level.getRandom().nextFloat() * 0.2F;
					double d3 = d0 * dist;
					double d4 = d1 * dist;
					double d5 = d2 * dist;
					entity.level().addParticle(ModParticle.SPARK.get(), entity.getX(), living.getEyeY() - 0.1D + (entity.getEyePosition().y - living.getEyeY()), entity.getZ(), d3, d4, d5);
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