package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blockentities.AltarOfAbyss_Block_Entity;
import com.github.L_Ender.cataclysm.blockentities.AltarOfAmethyst_Block_Entity;
import com.github.L_Ender.cataclysm.blockentities.AltarOfFire_Block_Entity;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageUpdateblockentity {

    public long blockPos;
    public ItemStack heldStack;

    public MessageUpdateblockentity(long blockPos, ItemStack heldStack) {
        this.blockPos = blockPos;
        this.heldStack = heldStack;

    }

    public MessageUpdateblockentity() {
    }

    public static MessageUpdateblockentity read(FriendlyByteBuf buf) {
        return new MessageUpdateblockentity(buf.readLong(), readItemStack(buf));
    }

    public static void write(MessageUpdateblockentity message, FriendlyByteBuf buf) {
        buf.writeLong(message.blockPos);
        writeItemStack(buf, message.heldStack);
    }

    public static void writeItemStack(ByteBuf to, ItemStack stack) {
        FriendlyByteBuf pb = new FriendlyByteBuf(to);
        pb.writeItem(stack);
    }

    /**
     * Read an {@link ItemStack} from the byte buffer provided. It uses the minecraft encoding.
     *
     * @param from The buffer to read from
     * @return The itemstack read
     */
    public static ItemStack readItemStack(ByteBuf from) {
        FriendlyByteBuf pb = new FriendlyByteBuf(from);
        try {
            return pb.readItem();
        } catch (Exception e) {
            // Unpossible?
            throw new RuntimeException(e);
        }
    }

    public static class Handler {
        public Handler() {
        }

        public static void handle(MessageUpdateblockentity message, Supplier<NetworkEvent.Context> context) {
            context.get().setPacketHandled(true);
            Player player = context.get().getSender();
            if(context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT){
                player = Cataclysm.PROXY.getClientSidePlayer();
            }
            if (player != null) {
                if (player.level() != null) {
                    BlockPos pos = BlockPos.of(message.blockPos);
                    if (player.level().getBlockEntity(pos) != null) {
                        if (player.level().getBlockEntity(pos) instanceof AltarOfFire_Block_Entity) {
                            AltarOfFire_Block_Entity podium = (AltarOfFire_Block_Entity) player.level().getBlockEntity(pos);
                            podium.setItem(0, message.heldStack);
                        }
                        if (player.level().getBlockEntity(pos) instanceof AltarOfAmethyst_Block_Entity) {
                            AltarOfAmethyst_Block_Entity podium = (AltarOfAmethyst_Block_Entity) player.level().getBlockEntity(pos);
                            podium.setItem(0, message.heldStack);
                        }
                        if (player.level().getBlockEntity(pos) instanceof AltarOfAbyss_Block_Entity) {
                            AltarOfAbyss_Block_Entity podium = (AltarOfAbyss_Block_Entity) player.level().getBlockEntity(pos);
                            podium.setItem(0, message.heldStack);
                        }
                    }
                }
            }
        }
    }

}