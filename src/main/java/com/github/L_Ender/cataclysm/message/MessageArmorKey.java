package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.items.KeybindUsingArmor;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageArmorKey(int equipmentSlot, int playerId, int typ) implements CustomPacketPayload {

    public static final Type<MessageArmorKey> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"armor_key"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageArmorKey> STREAM_CODEC = CustomPacketPayload.codec(MessageArmorKey::write, MessageArmorKey::new);

    public MessageArmorKey(FriendlyByteBuf buf) {
        this(buf.readInt(), buf.readInt(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.equipmentSlot());
        buf.writeInt(this.playerId());
        buf.writeInt(this.typ());
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MessageArmorKey message, IPayloadContext context) {
        if (context.flow().isServerbound()) {
            context.enqueueWork(() -> {
                Player player = context.player();
                    EquipmentSlot equipmentSlot1 = EquipmentSlot.values()[Mth.clamp(message.equipmentSlot, 0, EquipmentSlot.values().length - 1)];

                    ItemStack stack = player.getItemBySlot(equipmentSlot1);
                    if (stack.getItem() instanceof KeybindUsingArmor armor) {
                        armor.onKeyPacket(player, stack, message.typ);
                    }


            });
        }
    }
}