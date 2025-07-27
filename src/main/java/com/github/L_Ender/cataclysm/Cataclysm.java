package com.github.L_Ender.cataclysm;


import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.config.BiomeConfig;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.config.ConfigHolder;
import com.github.L_Ender.cataclysm.event.ServerEventHandler;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.cataclysm.message.*;
import com.github.L_Ender.cataclysm.world.CMMobSpawnBiomeModifier;
import com.github.L_Ender.cataclysm.world.CMMobSpawnStructureModifier;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.StructureModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import com.github.L_Ender.cataclysm.init.ModStructures;

@Mod(Cataclysm.MODID)
@Mod.EventBusSubscriber(modid = Cataclysm.MODID)
public class Cataclysm {
    public static final String MODID = "cataclysm";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final SimpleChannel NETWORK_WRAPPER;
    private static final String PROTOCOL_VERSION = Integer.toString(1);
    public static CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    private static int packetsRegistered;


    static {
        NetworkRegistry.ChannelBuilder channel = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(MODID, "main_channel"));
        String version = PROTOCOL_VERSION;
        version.getClass();
        channel = channel.clientAcceptedVersions(version::equals);
        version = PROTOCOL_VERSION;
        version.getClass();
        NETWORK_WRAPPER = channel.serverAcceptedVersions(version::equals).networkProtocolVersion(() -> {
            return PROTOCOL_VERSION;
        }).simpleChannel();
    }

    public Cataclysm() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::setupClient);
        bus.addListener(this::onModConfigEvent);
        ModGroup.DEF_REG.register(bus);
        bus.addListener(this::setupEntityModelLayers);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC, "cataclysm.toml");
        ModItems.ITEMS.register(bus);
        ModEffect.EFFECTS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModParticle.PARTICLE.register(bus);
        ModStructures.STRUCTURE_PIECE_DEF_REG.register(bus);
        ModStructures.STRUCTURE_TYPE_DEF_REG.register(bus);
        Modfeatures.FEATURES.register(bus);
        ModTileentites.TILE_ENTITY_TYPES.register(bus);
        ModEntities.ENTITY_TYPE.register(bus);
        ModSounds.SOUNDS.register(bus);
        ModRecipeSerializers.RECIPE_SERIALIZERS.register(bus);
        ModRecipeTypes.RECIPE_TYPES.register(bus);
        ModMenu.DEF_REG.register(bus);
        ModStructurePlacementType.STRUCTURE_PLACEMENT_TYPE.register(bus);
        ModStructureProcessor.STRUCTURE_PROCESSOR.register(bus);
        PROXY.init();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ServerEventHandler());
        MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, ModCapabilities::attachEntityCapability);
        bus.addListener(ModCapabilities::registerCapabilities);

        final DeferredRegister<Codec<? extends BiomeModifier>> biomeModifiers = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Cataclysm.MODID);
        biomeModifiers.register(bus);
        biomeModifiers.register("cataclysm_mob_spawns", CMMobSpawnBiomeModifier::makeCodec);
        final DeferredRegister<Codec<? extends StructureModifier>> structureModifiers = DeferredRegister.create(ForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS, Cataclysm.MODID);
        structureModifiers.register(bus);
        structureModifiers.register("cataclysm_structure_spawns", CMMobSpawnStructureModifier::makeCodec);
    }

    private void setupEntityModelLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        CMModelLayers.register(event);
    }

    @SubscribeEvent
    public void onModConfigEvent(final ModConfigEvent event) {
        final ModConfig config = event.getConfig();
        // Rebake the configs when they change
        if (config.getSpec() == ConfigHolder.COMMON_SPEC) {
            CMConfig.bake(config);
        }
        BiomeConfig.init();
    }

    public static <MSG> void sendMSGToServer(MSG message) {
        NETWORK_WRAPPER.sendToServer(message);
    }

    public static <MSG> void sendMSGToAll(MSG message) {
        for (ServerPlayer player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
            sendNonLocal(message, player);
        }
    }

    public static <MSG> void sendNonLocal(MSG msg, ServerPlayer player) {
        NETWORK_WRAPPER.sendTo(msg, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }

    private void setupClient(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            PROXY.clientInit();
        });
    }


    private void setup(final FMLCommonSetupEvent event) {
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageCMMultipart.class, MessageCMMultipart::encode, MessageCMMultipart::new, MessageCMMultipart.Handler::onMessage);
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageUpdateblockentity.class, MessageUpdateblockentity::write, MessageUpdateblockentity::read, MessageUpdateblockentity.Handler::handle);
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageSwingArm.class, MessageSwingArm::write, MessageSwingArm::read, MessageSwingArm.Handler::handle);
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageHookFalling.class, MessageHookFalling::encode, MessageHookFalling::new, MessageHookFalling.Handler::onMessage);
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageTidalTentacle.class, MessageTidalTentacle::encode, MessageTidalTentacle::new, MessageTidalTentacle.Handler::onMessage);
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageCharge.class, MessageCharge::encode, MessageCharge::new, MessageCharge.Handler::onMessage);
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageUpdateBossBar.class, MessageUpdateBossBar::write, MessageUpdateBossBar::read, MessageUpdateBossBar::handle);
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageArmorKey.class, MessageArmorKey::write, MessageArmorKey::read, MessageArmorKey::handle);
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageParticle.class, MessageParticle::encode, MessageParticle::new, MessageParticle.Handler::onMessage);
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageRenderRush.class, MessageRenderRush::encode, MessageRenderRush::new, MessageRenderRush.Handler::onMessage);
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageMusic.class, MessageMusic::write, MessageMusic::read, MessageMusic.Handler::onMessage);
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageParryFrame.class, MessageParryFrame::encode, MessageParryFrame::new, MessageParryFrame.Handler::onMessage);
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageMiniinventory.class, MessageMiniinventory::write, MessageMiniinventory::read, MessageMiniinventory.Handler::handle);
        NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageEntityCamera.class, MessageEntityCamera::encode, MessageEntityCamera::new, MessageEntityCamera.Handler::onMessage);


        event.enqueueWork(ModItems::initDispenser);
        event.enqueueWork(ModJigsaw::registerJigsawElements);
    }
}



