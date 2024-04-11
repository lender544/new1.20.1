package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.capabilities.Gone_With_SandstormCapability;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageGoneWithSandstorm {
    private final int entityID;
    private final boolean sandstorm;
    private final int Timer;

    public MessageGoneWithSandstorm(int id, Gone_With_SandstormCapability.IGone_With_SandstormCapability cap, int Timer) {
        this.entityID = id;
        this.sandstorm = cap.isSandstorm();
        this.Timer = Timer;
    }


    public MessageGoneWithSandstorm(FriendlyByteBuf buf) {
        this.entityID = buf.readInt();
        this.sandstorm = buf.readBoolean();
        this.Timer = buf.readInt();
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeInt(this.entityID);
        buf.writeBoolean(this.sandstorm);
        buf.writeInt(this.Timer);
    }

    public static class Handler {

        public static boolean onMessage(MessageGoneWithSandstorm message, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                Entity entity = Minecraft.getInstance().level.getEntity(message.entityID);
                if (entity instanceof LivingEntity) {
                    entity.getCapability(ModCapabilities.GONE_WITH_SANDSTORM_CAPABILITY).ifPresent(cap -> {
                        cap.setSandstorm(message.sandstorm);
                        cap.setSandstormTimer(message.Timer);
                    });
                }
            });

            ctx.get().setPacketHandled(true);
            return true;
        }
    }

}
