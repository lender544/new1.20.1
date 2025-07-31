package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.effect.Wave_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Player_Ceraunus_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Spark_Entity;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class Ceraunus extends Item implements More_Tool_Attribute {
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    private static final String THROWN_UUID_KEY = "thrown_anchor";

    public Ceraunus(Properties group) {
        super(group);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 15.0D, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", (double)-3.3F, AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, "Tool modifier", 0.5F, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }


    @Override
    public boolean canAttackBlock(BlockState p_43409_, Level p_43410_, BlockPos p_43411_, Player p_43412_) {
        return !p_43412_.isCreative();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity holder, int slot, boolean isSelected) {
        if (!level.isClientSide() && getThrownUuid(stack) != null && this.getThrownEntity(level, stack) == null) {
            stack.getTag().remove(THROWN_UUID_KEY);
        }
    }

    public UseAnim getUseAnimation(ItemStack p_43417_) {
        return UseAnim.SPEAR;
    }

    public int getUseDuration(ItemStack p_43419_) {
        return 72000;
    }


    public void releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof Player player) {
            int i = this.getUseDuration(p_43394_) - p_43397_;
            float f = getPowerForTime(i);
            if (!((double) f < 0.5D)) {
                if (!p_43395_.isClientSide) {
                    float yawRadians = (float) (Math.toRadians(90 + player.getYRot()));
                    double vecX = Math.cos(yawRadians);
                    double vecZ = Math.sin(yawRadians);
                    double vec = 2.0D;
                    double spawnX = p_43396_.getX() + vecX * vec;
                    double spawnY = p_43396_.getY();
                    double spawnZ = p_43396_.getZ() + vecZ * vec;
                    int numberOfWaves = 4;
                    float angleStep = 25.0f;
                    double firstAngleOffset = (numberOfWaves - 1) / 2.0 * angleStep;

                    if (p_43396_.isShiftKeyDown()) {
                        player.getCooldowns().addCooldown(this, CMConfig.CeraunusCooldown);
                        p_43395_.playSound((Player) null, player.getX(), player.getY(), player.getZ(), ModSounds.HEAVY_SMASH.get(), SoundSource.PLAYERS, 0.6F, 1.0F);
                        for (int k = 0; k < numberOfWaves; k++) {
                            double angle = player.getYRot() - firstAngleOffset + (k * angleStep);
                            double rad = Math.toRadians(angle);
                            double dx = -Math.sin(rad);
                            double dz = Math.cos(rad);

                            Wave_Entity WaveEntity = new Wave_Entity(p_43395_, p_43396_, 60, (float) CMConfig.CeraunusWaveDamage);
                            WaveEntity.setPos(spawnX, spawnY, spawnZ);
                            WaveEntity.setState(1);
                            WaveEntity.setYRot(-(float) (Mth.atan2(dx, dz) * (180F / Math.PI)));
                            p_43396_.level().addFreshEntity(WaveEntity);
                        }
                    } else {
                        if (getThrownUuid(p_43394_) == null){
                            Player_Ceraunus_Entity launchedBlock = new Player_Ceraunus_Entity(p_43395_, player);
                            launchedBlock.setBaseDamage((float) player.getAttributeValue(Attributes.ATTACK_DAMAGE));
                            launchedBlock.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
                            if (p_43395_.addFreshEntity(launchedBlock)) {
                                this.setThrownEntity(p_43394_, launchedBlock);
                            }
                        }
                    }
                }
            }
        }

    }

    public static float getPowerForTime(int p_40662_) {
        float f = (float)p_40662_ / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Nullable
    public static UUID getThrownUuid(ItemStack stack) {
        if (stack.hasTag() && stack.getTag().hasUUID(THROWN_UUID_KEY)) {
            return stack.getTag().getUUID(THROWN_UUID_KEY);
        }

        return null;
    }

    @Nullable
    private Player_Ceraunus_Entity getThrownEntity(Level level, ItemStack stack) {
        if (level instanceof ServerLevel server) {
            UUID id = getThrownUuid(stack);
            if (id != null) {
                Entity e = server.getEntity(id);
                if (e instanceof Player_Ceraunus_Entity ceraunus_entity) {
                    return ceraunus_entity;
                }
            }
        }

        return null;
    }

    private void setThrownEntity(ItemStack stack, Player_Ceraunus_Entity cube) {
        stack.getOrCreateTag().putUUID(THROWN_UUID_KEY, cube.getUUID());
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return 16;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || enchantment != Enchantments.SWEEPING_EDGE && enchantment.category == EnchantmentCategory.WEAPON;
    }

    @Override
    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot p_43383_) {
        return p_43383_ == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(p_43383_);
    }

    @Override
    public void appendHoverText(ItemStack stack, @javax.annotation.Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("item.cataclysm.ceraunus.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add(Component.translatable("item.cataclysm.ceraunus2.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}
