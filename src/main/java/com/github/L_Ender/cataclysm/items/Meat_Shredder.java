package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.Options.ParryParticleOptions;
import com.github.L_Ender.cataclysm.config.CMCommonConfig;
import com.github.L_Ender.cataclysm.config.CommonConfig;
import com.github.L_Ender.cataclysm.config.ConfigHolder;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.util.AttributeUtils;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class Meat_Shredder extends Cataclysm_Tool_Item {


	public Meat_Shredder(Item.Properties properties) {

		super(-2 + (float) CMCommonConfig.MeatShredder.attackDamage, -4f + (float)CMCommonConfig.MeatShredder.attackSpeed, Tiers.STONE, BlockTags.MINEABLE_WITH_AXE, properties);
	}


	@Override
	public CommonConfig.ToolConfig getConfig() {
		return ConfigHolder.COMMON.TOOLS_AND_ABILITIES.ANNIHILATOR.toolConfig;
	}

	@Override
	public @NotNull ItemStack getDefaultInstance() {
		ItemStack stack = super.getDefaultInstance();
		stack.getOrCreateTag().putBoolean("Unbreakable", true);
		return stack;
	}


	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack item = player.getItemInHand(hand);
		if (hand == InteractionHand.OFF_HAND) {
			player.startUsingItem(hand);
			return InteractionResultHolder.consume(item);
		}
		if (hand == InteractionHand.MAIN_HAND) {
			ItemStack offHandItem = player.getItemInHand(InteractionHand.OFF_HAND);
			if (offHandItem.canPerformAction(net.minecraftforge.common.ToolActions.SHIELD_BLOCK) && !player.getCooldowns().isOnCooldown(offHandItem.getItem())) {
				return InteractionResultHolder.pass(item);
			} else {
				player.startUsingItem(hand);
				return InteractionResultHolder.consume(item);
			}
		}
		return InteractionResultHolder.pass(item);
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
		float finalDamage = AttributeUtils.OriginDamage(living, stack) / 8.5F;
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
						if (entity.hurt(CMDamageTypes.causeShredderDamage(living), finalDamage)) {
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
	public int getUseDuration(ItemStack p_43419_) {
		return 72000;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}

	@Override
	public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
		consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(Component.translatable("item.cataclysm.meat_shredder.desc").withStyle(ChatFormatting.DARK_GREEN));
	}
}