package com.github.L_Ender.cataclysm;


import com.github.L_Ender.cataclysm.client.event.ClientEvent;
import com.github.L_Ender.cataclysm.client.event.ClientSetup;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.config.CMClientConfig;
import com.github.L_Ender.cataclysm.config.CMCommonConfig;
import com.github.L_Ender.cataclysm.config.ConfigHolder;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.cataclysm.items.Armortier;
import com.github.L_Ender.cataclysm.message.*;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(Cataclysm.MODID)
public class Cataclysm {
    public static final String MODID = "cataclysm";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static ServerProxy PROXY;


    public Cataclysm(IEventBus bus, Dist dist, ModContainer modContainer) {
        bus.addListener(this::setup);
        bus.addListener(this::setupPackets);
        PROXY = FMLLoader.getDist().isClient() ? new ClientProxy() : new ServerProxy();
        ModGroup.DEF_REG.register(bus);
        bus.addListener(this::setupEntityModelLayers);
        bus.addListener(ConfigHolder::onModConfigLoadingEvent);
        bus.addListener(ConfigHolder::onModConfigReloadEvent);

      //  ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC, "cataclysm.toml");
        if (dist.isClient()) {
            ClientSetup.ClientSetupevent(bus);
            ClientEvent.ClientEvent();
        }
        PROXY.init();


       // ServerEventHandler.ServerSetupevent(bus);
        bus.addListener(ModItems::modifyComponents);
        ModDataAttachments.ATTACHMENT_TYPES.register(bus);
        ModDataComponents.COMPONENTS.register(bus);
        ModEntityDataSerializers.DEF_REG.register(bus);
        ModItems.ITEMS.register(bus);
        Armortier.ARMOR_MATERIALS.register(bus);
        ModEffect.EFFECTS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModParticle.PARTICLE.register(bus);
        ModStructures.STRUCTURE_PIECE_DEF_REG.register(bus);
        ModStructures.STRUCTURE_TYPE_DEF_REG.register(bus);
        ModStructureProcessor.STRUCTURE_PROCESSOR.register(bus);
        ModTileentites.TILE_ENTITY_TYPES.register(bus);
        ModEntities.ENTITY_TYPE.register(bus);
        ModAttribute.ATTRIBUTES.register(bus);
        ModSounds.SOUNDS.register(bus);
        ModRecipeSerializers.RECIPE_SERIALIZERS.register(bus);
        ModRecipeTypes.RECIPE_TYPES.register(bus);
        ModBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(bus);
        ModStructureModifiers.STRUCTURE_MODIFIER_SERIALIZERS.register(bus);
        ModMenu.DEF_REG.register(bus);
        ModStructurePlacementType.STRUCTURE_PLACEMENT_TYPES.register(bus);
        modContainer.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC, String.format("%s-client.toml", Cataclysm.MODID));
        modContainer.registerConfig(ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC, String.format("%s-common.toml", Cataclysm.MODID));
    }



    private void setupEntityModelLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        CMModelLayers.register(event);
    }

    private void setup(final FMLCommonSetupEvent event) {

        event.enqueueWork(ModItems::initDispenser);
        event.enqueueWork(ModJigsaw::new);
    }


    public void setupPackets(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(MODID).versioned("1.0.0").optional();
        registrar.playToServer(MessageSwingArm.TYPE, MessageSwingArm.STREAM_CODEC, MessageSwingArm::handle);
        registrar.playToServer(MessageArmorKey.TYPE, MessageArmorKey.STREAM_CODEC, MessageArmorKey::handle);
        registrar.playToClient(MessageHookFalling.TYPE, MessageHookFalling.STREAM_CODEC, MessageHookFalling::handle);
        registrar.playToClient(MessageCharge.TYPE, MessageCharge.STREAM_CODEC, MessageCharge::handle);
        registrar.playToClient(MessageRenderRush.TYPE, MessageRenderRush.STREAM_CODEC, MessageRenderRush::handle);
        registrar.playToClient(MessageParticle.TYPE, MessageParticle.STREAM_CODEC, MessageParticle::handle);
        registrar.playToClient(MessageTidalTentacle.TYPE, MessageTidalTentacle.STREAM_CODEC, MessageTidalTentacle::handle);
        registrar.playToClient(MessageBossBar.Display.TYPE, MessageBossBar.Display.STREAM_CODEC, MessageBossBar.Display::execute);
        registrar.playToClient(MessageBossBar.Remove.TYPE, MessageBossBar.Remove.STREAM_CODEC, MessageBossBar.Remove::execute);

        registrar.playToClient(MessageEntityCameraSwitch.FirstPerson.TYPE, MessageEntityCameraSwitch.FirstPerson.STREAM_CODEC, MessageEntityCameraSwitch.FirstPerson::execute);
        registrar.playToClient(MessageEntityCameraSwitch.ThridPerson.TYPE, MessageEntityCameraSwitch.ThridPerson.STREAM_CODEC, MessageEntityCameraSwitch.ThridPerson::execute);

        registrar.playToClient(MessageCMMultipart.TYPE, MessageCMMultipart.STREAM_CODEC, MessageCMMultipart::handle);

        registrar.playToClient(MessageOpenInventory.TYPE, MessageOpenInventory.STREAM_CODEC, MessageOpenInventory::handle);
        registrar.playToClient(MessageMusic.TYPE, MessageMusic.STREAM_CODEC, MessageMusic::handle);
        registrar.playToClient(MessageMeatShredder.TYPE, MessageMeatShredder.STREAM_CODEC, MessageMeatShredder::handle);

        registrar.playToClient(MessageMovePlayer.TYPE, MessageMovePlayer.STREAM_CODEC, MessageMovePlayer::handle);

        registrar.playToClient(MessageCameraZoom.TYPE, MessageCameraZoom.STREAM_CODEC, MessageCameraZoom::execute);

    }

}



