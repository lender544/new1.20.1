package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.items.Components.ChargeAnimationComponent;
import com.mojang.serialization.Codec;

import net.minecraft.core.UUIDUtil;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class ModDataComponents {
	public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE,Cataclysm.MODID);


	public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> LASER_GATLING =
			COMPONENTS.register("laser_gatling", () -> DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());

	public static final DeferredHolder<DataComponentType<?>, DataComponentType<ChargeAnimationComponent>> CHARGE_ANIMATION = COMPONENTS.register("charge_animation", () -> DataComponentType.<ChargeAnimationComponent>builder().persistent(ChargeAnimationComponent.CODEC).networkSynchronized(ChargeAnimationComponent.STREAM_CODEC).build());

	public static final DeferredHolder<DataComponentType<?>, DataComponentType<UUID>> THROWN_ANCHOR = COMPONENTS.register("thrown_anchor", () -> DataComponentType.<UUID>builder().persistent(UUIDUtil.CODEC).networkSynchronized(UUIDUtil.STREAM_CODEC).build());


	private static @NotNull <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name, final Codec<T> codec) {
		return register2(name, codec, null);
	}

	private static @NotNull <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register2(String name, final Codec<T> codec, @Nullable final StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
		if (streamCodec == null) {
			return COMPONENTS.register(name, () -> DataComponentType.<T>builder().persistent(codec).build());
		} else {
			return COMPONENTS.register(name, () -> DataComponentType.<T>builder().persistent(codec).networkSynchronized(streamCodec).build());
		}
	}
}
