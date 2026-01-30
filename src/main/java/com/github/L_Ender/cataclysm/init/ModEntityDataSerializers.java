package com.github.L_Ender.cataclysm.init;


import com.github.L_Ender.cataclysm.Attachment.ChargeAttachment;
import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.util.CMByteBufCodecs;
import com.github.L_Ender.cataclysm.util.CMMathUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Optional;

public class ModEntityDataSerializers {

    public static final DeferredRegister<EntityDataSerializer<?>> DEF_REG = DeferredRegister.create(NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, Cataclysm.MODID);

    public static final DeferredHolder<EntityDataSerializer<?>, EntityDataSerializer<Optional<Vec3>>> OPTIONAL_VEC_3 =
            DEF_REG.register("optional_vec_3", () -> EntityDataSerializer.forValueType(CMByteBufCodecs.VEC3.apply(ByteBufCodecs::optional)));


}
