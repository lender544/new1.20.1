package com.github.L_Ender.cataclysm.message;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MessageParticle {
	private final List<QueuedParticle> queuedParticles = new ArrayList<>();

	public MessageParticle() {
	}

	public MessageParticle(FriendlyByteBuf buf) {
		int size = buf.readInt();
		for (int i = 0; i < size; i++) {
			ParticleType<?> type = BuiltInRegistries.PARTICLE_TYPE.byId(buf.readInt());
			if (type == null) {
				break; // Fail silently and end execution entirely. Due to Type serialization we now have completely unknown data in the pipeline without any way to safely read it all
			}
			this.queuedParticles.add(new QueuedParticle(readParticle(type, buf), buf.readBoolean(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble()));
		}
	}

	private <T extends ParticleOptions> T readParticle(ParticleType<T> particleType, FriendlyByteBuf buf) {
		return particleType.getDeserializer().fromNetwork(particleType, buf);
	}

	public void encode(FriendlyByteBuf buf) {
		buf.writeInt(this.queuedParticles.size());
		for (QueuedParticle queuedParticle : this.queuedParticles) {
			int d = BuiltInRegistries.PARTICLE_TYPE.getId(queuedParticle.particleOptions.getType());
			buf.writeInt(d);
			queuedParticle.particleOptions.writeToNetwork(buf);
			buf.writeBoolean(queuedParticle.b);
			buf.writeDouble(queuedParticle.x);
			buf.writeDouble(queuedParticle.y);
			buf.writeDouble(queuedParticle.z);
			buf.writeDouble(queuedParticle.x2);
			buf.writeDouble(queuedParticle.y2);
			buf.writeDouble(queuedParticle.z2);
		}
	}

	public void queueParticle(ParticleOptions particleOptions, boolean b, double x, double y, double z, double x2, double y2, double z2) {
		this.queuedParticles.add(new QueuedParticle(particleOptions, b, x, y, z, x2, y2, z2));
	}

	public void queueParticle(ParticleOptions particleOptions, boolean b, Vec3 xyz, Vec3 xyz2) {
		this.queuedParticles.add(new QueuedParticle(particleOptions, b, xyz.x, xyz.y, xyz.z, xyz2.x, xyz2.y, xyz2.z));
	}

	private record QueuedParticle(ParticleOptions particleOptions, boolean b, double x, double y, double z, double x2, double y2, double z2) {
		private QueuedParticle(ParticleOptions particleOptions, boolean b, double x, double y, double z, double x2, double y2, double z2) {
			this.particleOptions = particleOptions;
			this.b = b;
			this.x = x;
			this.y = y;
			this.z = z;
			this.x2 = x2;
			this.y2 = y2;
			this.z2 = z2;
		}

		public ParticleOptions particleOptions() {
			return this.particleOptions;
		}

		public boolean b() {
			return this.b;
		}

		public double x() {
			return this.x;
		}

		public double y() {
			return this.y;
		}

		public double z() {
			return this.z;
		}

		public double x2() {
			return this.x2;
		}

		public double y2() {
			return this.y2;
		}

		public double z2() {
			return this.z2;
		}
	}

	public static class Handler {
		public Handler() {
		}
		public static boolean onMessage(MessageParticle message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				ClientLevel level = Minecraft.getInstance().level;
				if (level != null) {

					for (QueuedParticle queuedParticle : message.queuedParticles) {
						level.addParticle(queuedParticle.particleOptions, queuedParticle.b, queuedParticle.x, queuedParticle.y, queuedParticle.z, queuedParticle.x2, queuedParticle.y2, queuedParticle.z2);
					}
				}
			});
			ctx.get().setPacketHandled(true);
			return true;
		}
	}
}
