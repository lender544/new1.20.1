package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.capabilities.ChargeCapability;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import javax.annotation.Nullable;
import java.util.List;

public class Gauntlet_of_Bulwark extends Item implements More_Tool_Attribute {
    private final Multimap<Attribute, AttributeModifier> guantletAttributes;

    public Gauntlet_of_Bulwark(Properties group) {
        super(group);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 10.0D, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2.4F, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR, new AttributeModifier(BASE_ARMOR_ID, "Tool modifier", 3.0F, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(BASE_ARMOR_TOUGHNESS_ID, "Tool modifier", 3F, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(BASE_KNOCKBACK_RESISTANCE_ID, "Tool modifier", 0.15F, AttributeModifier.Operation.ADDITION));
        this.guantletAttributes = builder.build();
    }


    public UseAnim getUseAnimation(ItemStack p_77661_1_) {
        return UseAnim.BOW;
    }

    public int getUseDuration(ItemStack p_77626_1_) {
        return 72000;
    }


    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        ItemStack item = p_77659_2_.getItemInHand(p_77659_3_);
        InteractionHand otherhand = p_77659_3_ == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;

        ItemStack otheritem = p_77659_2_.getItemInHand(otherhand);

        if (otheritem.canPerformAction(net.minecraftforge.common.ToolActions.SHIELD_BLOCK) && !p_77659_2_.getCooldowns().isOnCooldown(otheritem.getItem())) {
            return InteractionResultHolder.fail(item);
        }else{
            p_77659_2_.startUsingItem(p_77659_3_);
            return InteractionResultHolder.consume(item);
        }
    }

    public void onUseTick(Level worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        double radius = 4.5D;
        Level world = livingEntityIn.level();
        List<Entity> list = world.getEntities(livingEntityIn, livingEntityIn.getBoundingBox().inflate(radius));
        int c = this.getUseDuration(stack) - count;
        if (c == 20) {
            livingEntityIn.playSound(ModSounds.FLAME_BURST.get(), 1.0F, 1.0f);
            for (Entity entity : list) {
                if (entity instanceof LivingEntity) {
                    if (entity instanceof Player && ((Player) entity).getAbilities().invulnerable) continue;
                    ((LivingEntity) entity).addEffect(new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), 40));
                    if (entity.onGround()) {
                        double d0 = entity.getX() - livingEntityIn.getX();
                        double d1 = entity.getZ() - livingEntityIn.getZ();
                        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                        float f = 1.5F;
                        entity.push(d0 / d2 * f, 0.1F, d1 / d2 * f);
                    }
                }

            }
            if (world.isClientSide) {
                for (int i = 0; i < 20; i++) {
                    final float velocity = 0.2F;
                    float yaw = i * ((float) (2 * StrictMath.PI) / 20);
                    float vy = world.getRandom().nextFloat() * 0.1F - 0.05f;
                    float vx = velocity * Mth.cos(yaw);
                    float vz = velocity * Mth.sin(yaw);
                    world.addParticle(ParticleTypes.FLAME, livingEntityIn.getX(), livingEntityIn.getY() + 1, livingEntityIn.getZ(), vx, vy, vz);

                }
            }
        }

    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if(!entityLiving.isShiftKeyDown()) {
            if(!entityLiving.isFallFlying()) {
            int i = this.getUseDuration(stack) - timeLeft;
            int t = Mth.clamp(i, 1, 5);
            float f7 = entityLiving.getYRot();
            float f = entityLiving.getXRot();
            if (!(i < 20)) {
                float f1 = -Mth.sin(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));
                float f2 = -Mth.sin(f * ((float) Math.PI / 180F));
                float f3 = Mth.cos(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));
                float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
                float f5 = 3.0F * (t / 6.0F);
                f1 *= f5 / f4;
                f3 *= f5 / f4;
                entityLiving.push((double) f1, (double) 0, (double) f3);
                if (entityLiving.onGround()) {
                    float f6 = 1.1999999F;
                    entityLiving.move(MoverType.SELF, new Vec3(0.0D, (double) f6 / 2, 0.0D));
                }

                ChargeCapability.IChargeCapability ChargeCapability = ModCapabilities.getCapability(entityLiving, ModCapabilities.CHARGE_CAPABILITY);
                if (ChargeCapability != null) {
                    ChargeCapability.setCharge(true);
                    ChargeCapability.setTimer(t * 2);
                    ChargeCapability.seteffectiveChargeTime(t * 2);
                    ChargeCapability.setknockbackSpeedIndex(t * 0.35F);
                    ChargeCapability.setdamagePerEffectiveCharge(1.2F);
                    ChargeCapability.setdx(f1 * 0.5F);
                    ChargeCapability.setdZ(f3 * 0.5F);
                }

                if (!level.isClientSide) {
                    ((Player) entityLiving).getCooldowns().addCooldown(this, CMConfig.GauntletOfBulwarkCooldown);
                }
            }
        }
        }
    }

    @Override
    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true;
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
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || enchantment.category != EnchantmentCategory.BREAKABLE && enchantment.category == EnchantmentCategory.WEAPON && enchantment != Enchantments.SWEEPING_EDGE;
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? this.guantletAttributes : super.getDefaultAttributeModifiers(equipmentSlot);
    }

    @Override
    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("item.cataclysm.gauntlet_of_bulwark.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add(Component.translatable("item.cataclysm.gauntlet_of_bulwark.desc2").withStyle(ChatFormatting.DARK_GREEN));
    }
}