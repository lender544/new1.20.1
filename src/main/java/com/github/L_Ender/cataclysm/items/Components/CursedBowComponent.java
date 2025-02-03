package com.github.L_Ender.cataclysm.items.Components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.alchemy.PotionContents;

public record CursedBowComponent(int UseTime, int PrevUseTime) {
	public static final CursedBowComponent EMPTY = new CursedBowComponent(0, 0);


	public static final Codec<CursedBowComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
		Codec.INT.optionalFieldOf("UseTime", 0).forGetter(CursedBowComponent::UseTime),
		Codec.INT.optionalFieldOf("PrevUseTime", 0).forGetter(CursedBowComponent::PrevUseTime)
	).apply(instance, CursedBowComponent::new));

	public static final StreamCodec<RegistryFriendlyByteBuf, CursedBowComponent> STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.INT, CursedBowComponent::UseTime,
		ByteBufCodecs.INT, CursedBowComponent::PrevUseTime,
			CursedBowComponent::new);

	public CursedBowComponent tryAddDose(int use,int prevUseTime) {
		return new CursedBowComponent(use, prevUseTime);
	}

}
