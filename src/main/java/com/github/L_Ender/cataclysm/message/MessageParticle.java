package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MessageParticle implements CustomPacketPayload {

	public static final Type<MessageParticle> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"particle_queue"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MessageParticle> STREAM_CODEC = CustomPacketPayload.codec(MessageParticle::write, MessageParticle::new);

	private final List<QueuedParticle> queuedParticles = new ArrayList<>();

	public MessageParticle() {
	}

	public MessageParticle(RegistryFriendlyByteBuf buf) {
		int size = buf.readInt();
		for (int i = 0; i < size; i++) {
			ParticleType<?> type = BuiltInRegistries.PARTICLE_TYPE.byId(buf.readInt());
			if (type == null)
				break; // Fail silently and end execution entirely. Due to Type serialization we now have completely unknown data in the pipeline without any way to safely read it all
			this.queuedParticles.add(new QueuedParticle(ParticleTypes.STREAM_CODEC.decode(buf), buf.readBoolean(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble()));
		}
	}

	public void write(RegistryFriendlyByteBuf buf) {
		buf.writeInt(this.queuedParticles.size());
		for (QueuedParticle queuedParticle : this.queuedParticles) {
			int d = BuiltInRegistries.PARTICLE_TYPE.getId(queuedParticle.particleOptions.getType());
			buf.writeInt(d);
			ParticleTypes.STREAM_CODEC.encode(buf, queuedParticle.particleOptions);
			buf.writeBoolean(queuedParticle.b);
			buf.writeDouble(queuedParticle.x);
			buf.writeDouble(queuedParticle.y);
			buf.writeDouble(queuedParticle.z);
			buf.writeDouble(queuedParticle.x2);
			buf.writeDouble(queuedParticle.y2);
			buf.writeDouble(queuedParticle.z2);
		}
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}

	public void queueParticle(ParticleOptions particleOptions, boolean b, double x, double y, double z, double x2, double y2, double z2) {
		this.queuedParticles.add(new QueuedParticle(particleOptions, b, x, y, z, x2, y2, z2));
	}

	public void queueParticle(ParticleOptions particleOptions, boolean b, Vec3 xyz, Vec3 xyz2) {
		this.queuedParticles.add(new QueuedParticle(particleOptions, b, xyz.x, xyz.y, xyz.z, xyz2.x, xyz2.y, xyz2.z));
	}

	private record QueuedParticle(ParticleOptions particleOptions, boolean b, double x, double y, double z, double x2,
								  double y2, double z2) {
	}

	public static void handle(MessageParticle message, IPayloadContext ctx) {
		ctx.enqueueWork(() -> {
			for (QueuedParticle queuedParticle : message.queuedParticles) {
				ctx.player().level().addParticle(queuedParticle.particleOptions, queuedParticle.b, queuedParticle.x, queuedParticle.y, queuedParticle.z, queuedParticle.x2, queuedParticle.y2, queuedParticle.z2);
			}
		});
	}
}

