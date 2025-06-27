package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.items.KeybindUsingArmor;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageArmorKey {

    public int equipmentSlot;
    public int playerId;
    public int type;

    public MessageArmorKey(int equipmentSlot, int playerId,int type) {
        this.equipmentSlot = equipmentSlot;
        this.playerId = playerId;
        this.type = type;
    }


    public MessageArmorKey() {
    }

    public static MessageArmorKey read(FriendlyByteBuf buf) {
        return new MessageArmorKey(buf.readInt(), buf.readInt(), buf.readInt());
    }

    public static void write(MessageArmorKey message, FriendlyByteBuf buf) {
        buf.writeInt(message.equipmentSlot);
        buf.writeInt(message.playerId);
        buf.writeInt(message.type);
    }

    public static void handle(MessageArmorKey message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            Player player = context.get().getSender();
            if(player != null){
                EquipmentSlot equipmentSlot1 = EquipmentSlot.values()[Mth.clamp(message.equipmentSlot, 0, EquipmentSlot.values().length - 1)];

                ItemStack stack = player.getItemBySlot(equipmentSlot1);
                if(stack.getItem() instanceof KeybindUsingArmor armor){
                    armor.onKeyPacket(player, stack, message.type);
                }


            }
        });
        context.get().setPacketHandled(true);
    }
}