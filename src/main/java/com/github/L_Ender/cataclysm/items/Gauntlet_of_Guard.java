package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import javax.annotation.Nullable;
import java.util.List;

public class Gauntlet_of_Guard extends Item implements More_Tool_Attribute {
    private final Multimap<Attribute, AttributeModifier> guantletAttributes;

    public Gauntlet_of_Guard(Properties group) {
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
        double radius = 11.0D;
        Level world = livingEntityIn.level();
        List<LivingEntity> list = world.getEntitiesOfClass(LivingEntity.class, livingEntityIn.getBoundingBox().inflate(radius));
        for (LivingEntity entity : list) {
            if (entity instanceof Player && ((Player) entity).getAbilities().invulnerable) continue;
            Vec3 diff = entity.position().subtract(livingEntityIn.position().add(0,0,0));
            diff = diff.normalize().scale(0.1);
            entity.setDeltaMovement(entity.getDeltaMovement().subtract(diff));

        }

        if (world.isClientSide) {
            for (int i = 0; i < 3; ++i) {
                int j = world.random.nextInt(2) * 2 - 1;
                int k = world.random.nextInt(2) * 2 - 1;
                double d0 = livingEntityIn.getX() + 0.25D * (double) j;
                double d1 = (float) livingEntityIn.getY() + world.random.nextFloat();
                double d2 = livingEntityIn.getZ() + 0.25D * (double) k;
                double d3 = world.random.nextFloat() * (float) j;
                double d4 = ((double) world.random.nextFloat() - 0.5D) * 0.125D;
                double d5 = world.random.nextFloat() * (float) k;
                world.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
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
        tooltip.add(Component.translatable("item.cataclysm.gauntlet_of_guard.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}