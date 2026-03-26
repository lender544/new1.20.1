package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.config.CommonConfig;
import com.google.common.collect.ImmutableMultimap;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public abstract class Cataclysm_Tool_Item extends DiggerItem {

    protected static final UUID BASE_ENTITY_INTERACTION_RANGE_ID = UUID.fromString("0CB612AF-CE7C-4FD2-9647-4BFD75B8D8A0");
    protected static final UUID BASE_BLOCK_INTERACTION_RANGE_ID = UUID.fromString("E7902C57-6C37-41CB-BBC4-F23AB1F287C0");

    protected static final UUID BASE_CRITICAL_ID = UUID.fromString("B5758E73-4C8B-4932-8E06-4D57AB253185");
    protected static final UUID BASE_ARMOR_ID = UUID.fromString("FFB9296F-A5B3-4215-8196-4091D31575C6");
    protected static final UUID BASE_ARMOR_TOUGHNESS_ID = UUID.fromString("4A87FDB4-7CCC-471D-96C4-03AC8515E62F");
    protected static final UUID BASE_KNOCKBACK_RESISTANCE_ID = UUID.fromString("0F9ECB41-87F5-4787-8731-0A6C693B77F3");

    public Cataclysm_Tool_Item(float attackDamageIn, float attackSpeedIn, Tier tier, TagKey<Block> effectiveBlocksIn, Properties builderIn) {
        super(attackDamageIn, attackSpeedIn, tier, effectiveBlocksIn, builderIn);
    }

    public void getAttributesFromConfig() {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", getConfig().attackDamage.get() - 1.0, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", getConfig().attackSpeed.get() - 4.0, AttributeModifier.Operation.ADDITION));
        initAttributes(builder);
        this.defaultModifiers = builder.build();

    }

    protected void initAttributes(ImmutableMultimap.Builder<Attribute, AttributeModifier> builder) {
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public float getAttackDamage() {
        return getConfig().attackDamage.get().floatValue();
    }

    public abstract CommonConfig.ToolConfig getConfig();

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        CompoundTag compoundtag = stack.getTag();
        if(!this.isDamageable(stack) && (compoundtag != null && !compoundtag.getBoolean("Unbreakable"))) {
            tooltip.add(Component.translatable("item.unbreakable").withStyle(ChatFormatting.BLUE));
        }
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }


}
