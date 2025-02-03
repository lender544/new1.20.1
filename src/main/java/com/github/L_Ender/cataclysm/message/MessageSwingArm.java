package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.items.ILeftClick;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageSwingArm(InteractionHand hand) implements CustomPacketPayload {
    public static final Type<MessageSwingArm> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"swing_arm"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageSwingArm> STREAM_CODEC = CustomPacketPayload.codec(MessageSwingArm::write, MessageSwingArm::new);

    public MessageSwingArm(FriendlyByteBuf buf) {
        this(buf.readBoolean() ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeBoolean(this.hand() == InteractionHand.MAIN_HAND);
    }
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MessageSwingArm message, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            Player player = ctx.player();
            ItemStack leftItem = player.getItemInHand(message.hand);
            if(leftItem.getItem() instanceof ILeftClick){
                ((ILeftClick)leftItem.getItem()).onLeftClick(leftItem, player);
            }

        });
    }
}
