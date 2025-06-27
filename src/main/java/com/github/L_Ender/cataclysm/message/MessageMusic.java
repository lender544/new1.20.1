package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.client.sound.BossMusicPlayer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.github.L_Ender.cataclysm.entity.etc.Animation_Monsters;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

public class MessageMusic {
	private final int entityID;
	private final boolean play;

	public MessageMusic(int entityID, boolean play) {
		this.entityID = entityID;
		this.play = play;
	}


	public static MessageMusic read(FriendlyByteBuf buf) {
		return new MessageMusic(buf.readInt(), buf.readBoolean());
	}

	public static void write(MessageMusic message, FriendlyByteBuf buf) {
		buf.writeInt(message.entityID);
		buf.writeBoolean(message.play);
	}

	public static class Handler {
		public Handler() {
		}
		public static boolean onMessage(MessageMusic message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				Entity entity = Minecraft.getInstance().level.getEntity(message.entityID);
				if (entity instanceof Animation_Monsters am) {
					if(message.play){
						BossMusicPlayer.playBossMusic(am);
					}else{
						BossMusicPlayer.stopBossMusic(am);
					}
				}
			});
			ctx.get().setPacketHandled(true);
			return true;
		}
	}
}
