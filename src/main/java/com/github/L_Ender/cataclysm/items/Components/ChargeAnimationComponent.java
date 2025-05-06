package com.github.L_Ender.cataclysm.items.Components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record ChargeAnimationComponent(int UseTime, int PrevUseTime) {
	public static final ChargeAnimationComponent EMPTY = new ChargeAnimationComponent(0, 0);


	public static final Codec<ChargeAnimationComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
		Codec.INT.optionalFieldOf("UseTime", 0).forGetter(ChargeAnimationComponent::UseTime),
		Codec.INT.optionalFieldOf("PrevUseTime", 0).forGetter(ChargeAnimationComponent::PrevUseTime)
	).apply(instance, ChargeAnimationComponent::new));

	public static final StreamCodec<RegistryFriendlyByteBuf, ChargeAnimationComponent> STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.INT, ChargeAnimationComponent::UseTime,
		ByteBufCodecs.INT, ChargeAnimationComponent::PrevUseTime,
			ChargeAnimationComponent::new);

	public ChargeAnimationComponent tryAddDose(int use, int prevUseTime) {
		return new ChargeAnimationComponent(use, prevUseTime);
	}

}
