package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.capabilities.Gone_With_SandstormCapability;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import com.github.L_Ender.cataclysm.util.SandstormUtils;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageToggleSandstorm {

    private final boolean toggle;

    public MessageToggleSandstorm(boolean toggle) {
        this.toggle = toggle;
    }


    public MessageToggleSandstorm(FriendlyByteBuf buf) {
        this.toggle = buf.readBoolean();
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeBoolean(this.toggle);
    }


    public static class Handler {

        public Handler() {
        }

        public static void handle(MessageToggleSandstorm message, Supplier<NetworkEvent.Context> context) {
            context.get().setPacketHandled(true);
            context.get().enqueueWork(() -> {
                Player player = context.get().getSender();
                if (player != null) {
                    SandstormUtils.toggleFlight(player,message.toggle);
                    Gone_With_SandstormCapability.IGone_With_SandstormCapability SandstormCapability = ModCapabilities.getCapability(player, ModCapabilities.GONE_WITH_SANDSTORM_CAPABILITY);
                    if (SandstormCapability != null) {
                        SandstormCapability.setSandstorm(message.toggle);
                    }
                }
            });
        }
    }

}
