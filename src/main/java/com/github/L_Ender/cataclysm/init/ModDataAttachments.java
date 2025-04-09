package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Attachment.*;
import com.github.L_Ender.cataclysm.Cataclysm;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModDataAttachments {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, Cataclysm.MODID);

	public static final DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> HOOK_FALLING = ATTACHMENT_TYPES.register("hook_falling", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).build());


	public static final DeferredHolder<AttachmentType<?>, AttachmentType<ChargeAttachment>> CHARGE_ATTACHMENT = ATTACHMENT_TYPES.register("charge_attachment", () -> AttachmentType.builder(ChargeAttachment::new).build());

	public static final DeferredHolder<AttachmentType<?>, AttachmentType<RenderRushAttachment>> RENDER_RUSH_ATTACHMENT = ATTACHMENT_TYPES.register("render_rush_attachment", () -> AttachmentType.builder(RenderRushAttachment::new).build());

	public static final DeferredHolder<AttachmentType<?>, AttachmentType<TidalTentacleAttachment>> TIDAL_TENTACLE_ATTACHMENT = ATTACHMENT_TYPES.register("tidal_tentacle_attachment", () -> AttachmentType.builder(TidalTentacleAttachment::new).build());

	public static final DeferredHolder<AttachmentType<?>, AttachmentType<ParryAttachment>> PARRY_ATTACHMENT = ATTACHMENT_TYPES.register("parry_attachment", () -> AttachmentType.builder(ParryAttachment::new).build());

}
