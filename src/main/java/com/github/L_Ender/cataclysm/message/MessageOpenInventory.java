package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.gui.MinistrosityInventoryScreen;
import com.github.L_Ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import com.github.L_Ender.cataclysm.inventory.MinistrostiyMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.HorseInventoryScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.HorseInventoryMenu;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.network.handling.IPayloadContext;


public record MessageOpenInventory(int id, int size, int entityId) implements CustomPacketPayload {
    public static final Type<MessageOpenInventory> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "open_inventory"));

    public static final StreamCodec<FriendlyByteBuf, MessageOpenInventory> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, MessageOpenInventory::id,
            ByteBufCodecs.INT, MessageOpenInventory::size,
            ByteBufCodecs.INT, MessageOpenInventory::entityId,
            MessageOpenInventory::new
    );

    public static void handle(MessageOpenInventory payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            openGuardInventory(payload);
        });
    }
    @OnlyIn(Dist.CLIENT)
    public static void openGuardInventory(MessageOpenInventory packet) {

        Player player = Minecraft.getInstance().player;
        if (player != null) {
            Entity entity = player.level().getEntity(packet.entityId());
            if (entity instanceof Netherite_Ministrosity_Entity guard) {
                LocalPlayer clientplayerentity = Minecraft.getInstance().player;
                int i = guard.getInventoryColumns();
                MinistrostiyMenu container = new MinistrostiyMenu(packet.id(), player.getInventory(), guard.miniInventory, guard);
                clientplayerentity.containerMenu = container;
                Minecraft.getInstance().setScreen(new MinistrosityInventoryScreen(container, player.getInventory(), guard,i));
            }
        }

    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}