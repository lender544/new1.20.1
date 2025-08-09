package com.github.L_Ender.cataclysm;

import com.github.L_Ender.cataclysm.blocks.Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.client.event.ClientEvent;
import com.github.L_Ender.cataclysm.client.gui.GUIWeponfusion;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.block.AptrgangrHeadModel;
import com.github.L_Ender.cataclysm.client.model.block.DraugrHeadModel;
import com.github.L_Ender.cataclysm.client.model.block.KobolediatorHeadModel;
import com.github.L_Ender.cataclysm.client.particle.*;
import com.github.L_Ender.cataclysm.client.render.CMItemstackRenderer;
import com.github.L_Ender.cataclysm.client.render.blockentity.*;
import com.github.L_Ender.cataclysm.client.render.entity.*;
import com.github.L_Ender.cataclysm.client.render.etc.CurioHeadRenderer;
import com.github.L_Ender.cataclysm.client.render.item.CMItemRenderProperties;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemRenderer.Blazing_Grips_Renderer;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemRenderer.Chitin_Claw_Renderer;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemRenderer.RendererSandstorm_In_A_Bottle;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemRenderer.RendererSticky_Gloves;
import com.github.L_Ender.cataclysm.client.render.item.CustomArmorRenderProperties;
import com.github.L_Ender.cataclysm.client.sound.MeatShredderSound;
import com.github.L_Ender.cataclysm.client.sound.SandstormSound;
import com.github.L_Ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.cataclysm.items.Ceraunus;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.Callable;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Cataclysm.MODID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {
    public static final Int2ObjectMap<AbstractTickableSoundInstance> ENTITY_SOUND_INSTANCE_MAP = new Int2ObjectOpenHashMap<>();
    public static final Map<BlockEntity, AbstractTickableSoundInstance> BLOCK_ENTITY_SOUND_INSTANCE_MAP = new HashMap<>();
    public static Map<UUID, Integer> bossBarRenderTypes = new HashMap<>();
    public static List<UUID> blockedEntityRenders = new ArrayList<>();
    private Entity referencedMob = null;
    public void init() {
       // FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientLayerEvent::onAddLayers);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupParticles);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerKeybinds);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::createSkullModels);
    }

    public void setupParticles(RegisterParticleProvidersEvent registry) {
        Cataclysm.LOGGER.debug("Registered particle factories");
        registry.registerSpriteSet(ModParticle.SPARK.get(), SparkParticle.Factory::new);
        registry.registerSpriteSet(ModParticle.SOUL_LAVA.get(), SoulLavaParticle.Factory::new);
        registry.registerSpriteSet(ModParticle.CURSED_FLAME.get(), CursedFlameParticle.Provider::new);
        registry.registerSpriteSet(ModParticle.SMALL_CURSED_FLAME.get(), CursedFlameParticle.SmallFlameProvider::new);
        registry.registerSpriteSet(ModParticle.PHANTOM_WING_FLAME.get(), Phantom_Wing_FlameParticle.EmissiveProvider::new);
        registry.registerSpriteSet(ModParticle.CUSTOM_POOF.get(), Custom_Poof_Particle.Provider::new);
        registry.registerSpriteSet(ModParticle.LIGHTNING_ZAP.get(), Lightning_Zap_Particle.Provider::new);
        registry.registerSpecial(ModParticle.EM_PULSE.get(), new EM_PulseParticle.Factory());
        registry.registerSpecial(ModParticle.SHOCK_WAVE.get(), new Shock_WaveParticle.Factory());
        registry.registerSpecial(ModParticle.LIGHTNING.get(), new LightningParticle.OrbFactory());
        registry.registerSpecial(ModParticle.SPARK_TRAIL.get(), new SparkTrailParticle.Factory());
        registry.registerSpecial(ModParticle.TRACK_LIGHTNING.get(), new TrackLightningParticle.OrbFactory());
        registry.registerSpecial(ModParticle.SPIN_TRAIL_PARTICLE.get(), new SpinTrailParticle.Factory());
        registry.registerSpecial(ModParticle.CIRCLE_LIGHTNING.get(), new CircleLightningParticle.Factory());
        registry.registerSpecial(ModParticle.GATHERING_WATER.get(), new Gathering_Water_Particle.Factory());
        registry.registerSpecial(ModParticle.STORM.get(), new StormParticle.OrbFactory());
        registry.registerSpriteSet(ModParticle.RING.get(), RingParticle.RingFactory::new);
        registry.registerSpriteSet(ModParticle.ROAR.get(), RoarParticle.RoarFactory::new);
        registry.registerSpriteSet(ModParticle.SCYLLA_SWING.get(), Scylla_Swing_Particle.Provider::new);
        registry.registerSpriteSet(ModParticle.RAIN_CLOUD.get(), RainCloudParticle.Factory::new);
        registry.registerSpriteSet(ModParticle.TRAP_FLAME.get(), TrapFlameParticle.Factory::new);
        registry.registerSpecial(ModParticle.LIGHT_TRAIL.get(), new LightTrailParticle.OrbFactory());
        registry.registerSpriteSet(ModParticle.FLAME_JET.get(), FlameJetParticle.Factory::new);
        registry.registerSpriteSet(ModParticle.LIGHTNING_STORM.get(), LightningStormParticle.Factory::new);
        registry.registerSpriteSet(ModParticle.FLARE_EXPLODE.get(), CustomExplodeParticle.FlareFactory::new);
        registry.registerSpriteSet(ModParticle.IGNIS_EXPLODE.get(), CustomExplodeParticle.IgnisFactory::new);
        registry.registerSpriteSet(ModParticle.IGNIS_ABYSS_EXPLODE.get(), CustomExplodeParticle.IgnisFactory::new);
        registry.registerSpriteSet(ModParticle.IGNIS_SOUL_EXPLODE.get(), CustomExplodeParticle.IgnisFactory::new);
        registry.registerSpriteSet(ModParticle.DESERT_GLYPH.get(), Desert_Glyph_Particle.GlyphFactory::new);
        registry.registerSpriteSet(ModParticle.RAIN_FOG.get(), Rain_Fog_Particle.Factory::new);
        registry.registerSpriteSet(ModParticle.LIGHTNING_EXPLODE.get(), LightningExplodeParticle.FlareFactory::new);
        registry.registerSpecial(ModParticle.DUST_PILLAR.get(), new Dust_Pillar_Particle.DustPillarProvider());
        registry.registerSpecial(ModParticle.NOT_SPIN_PARTICLE.get(), new Not_Spin_TrailParticle.Factory());

        registry.registerSpriteSet(ModParticle.DUST_BLAST.get(), Dust_Blast_Particle.Factory::new);
    }


    public void createSkullModels(EntityRenderersEvent.CreateSkullModels event) {
        event.registerSkullModel(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, new KobolediatorHeadModel(event.getEntityModelSet().bakeLayer(CMModelLayers.KOBOLEDIATOR_HEAD_MODEL)));
        event.registerSkullModel(Cataclysm_Skull_Block.Types.APTRGANGR, new AptrgangrHeadModel(event.getEntityModelSet().bakeLayer(CMModelLayers.APTRGANGR_HEAD_MODEL)));
        event.registerSkullModel(Cataclysm_Skull_Block.Types.DRAUGR, new DraugrHeadModel(event.getEntityModelSet().bakeLayer(CMModelLayers.DRAUGR_HEAD_MODEL)));
    }


    public void clientInit() {
        ItemRenderer itemRendererIn = Minecraft.getInstance().getItemRenderer();
        EntityRenderers.register(ModEntities.ENDER_GOLEM.get(), Ender_Golem_Renderer::new);
        EntityRenderers.register(ModEntities.NETHERITE_MONSTROSITY.get(), New_Netherite_Monstrosity_Renderer::new);
        EntityRenderers.register(ModEntities.NETHERITE_MINISTROSITY.get(), Netherite_Ministrosity_Renderer::new);
        EntityRenderers.register(ModEntities.OLD_NETHERITE_MONSTROSITY.get(), Netherite_Monstrosity_Renderer::new);
        EntityRenderers.register(ModEntities.LAVA_BOMB.get(), Lava_Bomb_Renderer::new);
        EntityRenderers.register(ModEntities.FLARE_BOMB.get(), Flare_Bomb_Renderer::new);
        EntityRenderers.register(ModEntities.FLAME_JET.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.LIGHTNING_STORM.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.NAMELESS_SORCERER.get(), Nameless_Sorcerer_Renderer::new);
        EntityRenderers.register(ModEntities.IGNIS.get(), Ignis_Renderer::new);
        EntityRenderers.register(ModEntities.ENDER_GUARDIAN.get(), Ender_Guardian_Renderer::new);
        EntityRenderers.register(ModEntities.ENDER_GUARDIAN_BULLET.get(), Ender_Guardian_bullet_Renderer::new);
        EntityRenderers.register(ModEntities.VOID_RUNE.get(), Void_Rune_Renderer::new);
        EntityRenderers.register(ModEntities.ENDERMAPTERA.get(), Endermaptera_Renderer::new);
        EntityRenderers.register(ModEntities.IGNITED_REVENANT.get(), Ignited_Revenant_Renderer::new);
        EntityRenderers.register(ModEntities.IGNITED_BERSERKER.get(), Ignited_Berserker_Renderer::new);
        EntityRenderers.register(ModEntities.THE_HARBINGER.get(), The_Harbinger_Renderer::new);
        EntityRenderers.register(ModEntities.VOID_SCATTER_ARROW.get(), Void_Scatter_Arrow_Renderer::new);

        EntityRenderers.register(ModEntities.POISON_DART.get(), Poison_Dart_Renderer::new);

        EntityRenderers.register(ModEntities.PHANTOM_ARROW.get(), Phantom_Arrow_Renderer::new);
        EntityRenderers.register(ModEntities.SCREEN_SHAKE.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.WITHER_SMOKE_EFFECT.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.LIGHTNING_AREA_EFFECT.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.ASHEN_BREATH.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.WALL_WATCHER.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.FLAME_STRIKE.get(), Flame_Strike_Renderer::new);

        EntityRenderers.register(ModEntities.BOLT_STRIKE.get(), Boltstrike_Renderer::new);

        EntityRenderers.register(ModEntities.CM_FALLING_BLOCK.get(), Cm_Falling_Block_Renderer::new);
        EntityRenderers.register(ModEntities.IGNIS_FIREBALL.get(), Ignis_Fireball_Renderer::new);
        EntityRenderers.register(ModEntities.IGNIS_ABYSS_FIREBALL.get(), Ignis_Abyss_Fireball_Renderer::new);
        EntityRenderers.register(ModEntities.DEATH_LASER_BEAM.get(), Death_Laser_beam_Renderer::new);
        EntityRenderers.register(ModEntities.ABYSS_BLAST.get(), Abyss_Blast_Renderer::new);
        EntityRenderers.register(ModEntities.MINI_ABYSS_BLAST.get(), Mini_Abyss_Blast_Renderer::new);
        EntityRenderers.register(ModEntities.LASER_BEAM.get(), Laser_Beam_Renderer::new);
        EntityRenderers.register(ModEntities.WITHER_MISSILE.get(), Wither_Missile_Renderer::new);
        EntityRenderers.register(ModEntities.WITHER_HOMING_MISSILE.get(), Wither_Homing_Missile_Renderer::new);
        EntityRenderers.register(ModEntities.WITHER_HOWITZER.get(), Wither_Howitzer_Renderer::new);
        EntityRenderers.register(ModEntities.VOID_HOWITZER.get(), Void_Howitzer_Renderer::new);
        EntityRenderers.register(ModEntities.VOID_VORTEX.get(), Void_Vortex_Renderer::new);
        EntityRenderers.register(ModEntities.THE_LEVIATHAN.get(), The_Leviathan_Renderer::new);
        EntityRenderers.register(ModEntities.THE_BABY_LEVIATHAN.get(), The_Baby_Leviathan_Renderer::new);
        EntityRenderers.register(ModEntities.TEDDY_BEAR.get(), Teddy_Bear_Renderer::new);
        EntityRenderers.register(ModEntities.ABYSS_PORTAL.get(), Abyss_Portal_Renderer::new);
        EntityRenderers.register(ModEntities.ABYSS_ORB.get(), Abyss_Orb_Renderer::new);
        EntityRenderers.register(ModEntities.ABYSS_BLAST_PORTAL.get(), Abyss_Blast_Portal_Renderer::new);
        EntityRenderers.register(ModEntities.PORTAL_ABYSS_BLAST.get(), Portal_Abyss_Blast_Renderer::new);
        EntityRenderers.register(ModEntities.DEEPLING.get(), Deepling_Renderer::new);
        EntityRenderers.register(ModEntities.ABYSS_MINE.get(), Abyss_Mine_Renderer::new);
        EntityRenderers.register(ModEntities.CORAL_SPEAR.get(), Thrown_Coral_Spear_Renderer::new);
        EntityRenderers.register(ModEntities.CORAL_BARDICHE.get(), Thrown_Coral_Bardiche_Renderer::new);
        EntityRenderers.register(ModEntities.DEEPLING_BRUTE.get(), Deepling_Brute_Renderer::new);
        EntityRenderers.register(ModEntities.DEEPLING_PRIEST.get(), Deepling_Priest_Renderer::new);
        EntityRenderers.register(ModEntities.DIMENSIONAL_RIFT.get(), Dimensional_Rift_Renderer::new);
        EntityRenderers.register(ModEntities.DEEPLING_ANGLER.get(), Deepling_Angler_Renderer::new);
        EntityRenderers.register(ModEntities.DEEPLING_WARLOCK.get(), Deepling_Warlock_Renderer::new);
        EntityRenderers.register(ModEntities.ABYSS_MARK.get(), Abyss_Mark_Renderer::new);
        EntityRenderers.register(ModEntities.CORAL_GOLEM.get(), Coral_Golem_Renderer::new);
        EntityRenderers.register(ModEntities.CORALSSUS.get(), Coralssus_Renderer::new);
        EntityRenderers.register(ModEntities.LIONFISH.get(), Lionfish_Renderer::new);
        EntityRenderers.register(ModEntities.TIDAL_HOOK.get(), Tidal_Hook_Renderer::new);
        EntityRenderers.register(ModEntities.AMETHYST_CRAB.get(), Amethyst_Crab_Renderer::new);
        EntityRenderers.register(ModEntities.ANCIENT_ANCIENT_REMNANT.get(), Ancient_Remnant_Renderer::new);
        EntityRenderers.register(ModEntities.ANCIENT_REMNANT.get(), Ancient_Remnant_Rework_Renderer::new);
        EntityRenderers.register(ModEntities.MODERN_REMNANT.get(), Modern_Remnant_Renderer::new);
        EntityRenderers.register(ModEntities.SANDSTORM.get(), Sandstorm_Renderer::new);
        EntityRenderers.register(ModEntities.SANDSTORM_PROJECTILE.get(), Sandstorm_Projectile_Renderer::new);
        EntityRenderers.register(ModEntities.CURSED_SANDSTORM.get(), Cursed_Sandstorm_Renderer::new);
        EntityRenderers.register(ModEntities.THE_WATCHER.get(), The_Watcher_Renderer::new);
        EntityRenderers.register(ModEntities.THE_PROWLER.get(), The_Prowler_Renderer::new);
        EntityRenderers.register(ModEntities.KOBOLETON.get(), Koboleton_Renderer::new);
        EntityRenderers.register(ModEntities.KOBOLEDIATOR.get(), Kobolediator_Renderer::new);
        EntityRenderers.register(ModEntities.WADJET.get(), Wadjet_Renderer::new);
        EntityRenderers.register(ModEntities.MALEDICTUS.get(), Maledictus_Renderer::new);
        EntityRenderers.register(ModEntities.DRAUGR.get(), Draugr_Renderer::new);
        EntityRenderers.register(ModEntities.ROYAL_DRAUGR.get(), Royal_Draugr_Renderer::new);
        EntityRenderers.register(ModEntities.ELITE_DRAUGR.get(), Elite_Draugr_Renderer::new);
        EntityRenderers.register(ModEntities.APTRGANGR.get(), Aptrgangr_Renderer::new);
        EntityRenderers.register(ModEntities.AXE_BLADE.get(), Axe_Blade_Renderer::new);
        EntityRenderers.register(ModEntities.PHANTOM_HALBERD.get(), Phantom_Halberd_Renderer::new);
        EntityRenderers.register(ModEntities.EARTHQUAKE.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.ANCIENT_DESERT_STELE.get(), Ancient_Desert_Stele_Renderer::new);
        EntityRenderers.register(ModEntities.AMETHYST_CLUSTER_PROJECTILE.get(), Amethyst_Cluster_Projectile_Renderer::new);
        EntityRenderers.register(ModEntities.THE_LEVIATHAN_TONGUE.get(), RendererNull::new);

        EntityRenderers.register(ModEntities.ACCRETION.get(), Accretion_Renderer::new);
        EntityRenderers.register(ModEntities.HIPPOCAMTUS.get(), Hippocamtus_Renderer::new);
        EntityRenderers.register(ModEntities.SCYLLA.get(), Scylla_Renderer::new);
        EntityRenderers.register(ModEntities.CLAWDIAN.get(), Clawdian_Renderer::new);
        EntityRenderers.register(ModEntities.URCHINKIN.get(), Urchinkin_Renderer::new);
        EntityRenderers.register(ModEntities.WATER_SPEAR.get(), Water_Spear_Renderer::new);
        EntityRenderers.register(ModEntities.LIGHTNING_SPEAR.get(), Lightning_Spear_Renderer::new);
        EntityRenderers.register(ModEntities.CINDARIA.get(), Cindaria_Renderer::new);
        EntityRenderers.register(ModEntities.SCYLLA_CERAUNUS.get(), Scylla_Ceraunus_Renderer::new);
        EntityRenderers.register(ModEntities.PLAYER_CERAUNUS.get(), Player_Ceraunus_Renderer::new);
        EntityRenderers.register(ModEntities.URCHIN_SPIKE.get(), Urchin_Spike_Renderer::new);
        EntityRenderers.register(ModEntities.SPARK.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.WAVE.get(), Wave_Renderer::new);
        EntityRenderers.register(ModEntities.STORM_SERPENT.get(), Storm_Serpent_Renderer::new);
        EntityRenderers.register(ModEntities.VOID_SHARD.get(), (render) -> {
            return new ThrownItemRenderer<>(render, 0.75F, true);
        });

        EntityRenderers.register(ModEntities.DROWNED_HOST.get(), Drowned_Host_Renderer::new);
        EntityRenderers.register(ModEntities.SYMBIOCTO.get(), Symbiocto_Renderer::new);
        EntityRenderers.register(ModEntities.OCTO_INK.get(), Octo_Ink_Renderer::new);
        EntityRenderers.register(ModEntities.EYE_OF_DUNGEON.get(), Eye_Of_Dungeon_Renderer::new);
        EntityRenderers.register(ModEntities.BLAZING_BONE.get(), Blazing_Bone_Renderer::new);
        EntityRenderers.register(ModEntities.LIONFISH_SPIKE.get(), Lionfish_Spike_Renderer::new);
        EntityRenderers.register(ModEntities.TIDAL_TENTACLE.get(), Tidal_Tentacle_Renderer::new);
        MinecraftForge.EVENT_BUS.register(new ClientEvent());
        try {
            ItemProperties.register(ModItems.BULWARK_OF_THE_FLAME.get(), new ResourceLocation("blocking"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
            ItemProperties.register(ModItems.SOUL_RENDER.get(), new ResourceLocation("blocking"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
            ItemProperties.register(ModItems.CORAL_SPEAR.get(), new ResourceLocation("throwing"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
            ItemProperties.register(ModItems.CORAL_BARDICHE.get(), new ResourceLocation("throwing"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
            ItemProperties.register(ModItems.MEAT_SHREDDER.get(), new ResourceLocation("using"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
            ItemProperties.register(Items.CROSSBOW, new ResourceLocation(Cataclysm.MODID, "void_scatter_arrow"), (stack, world, entity, j) -> entity != null && CrossbowItem.isCharged(stack) && CrossbowItem.containsChargedProjectile(stack, ModItems.VOID_SCATTER_ARROW.get()) ? 1.0F : 0.0F);
            ItemProperties.register(ModItems.CORAL_CHUNK.get(), new ResourceLocation("chunk"), (stack, level, living, j) -> (stack.getCount() % 3 == 0) ? 0.0F : (stack.getCount() % 3 == 1) ? 0.5F : 1.0F);
            ItemProperties.register(ModItems.BLACK_STEEL_TARGE.get(), new ResourceLocation("blocking"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
            ItemProperties.register(ModItems.AZURE_SEA_SHIELD.get(), new ResourceLocation("blocking"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
            ItemProperties.register(ModItems.CERAUNUS.get(), new ResourceLocation("throwing"), (stack, p_239421_1_, p_239421_2_, j) -> Ceraunus.getThrownUuid(stack) != null ? 1 : 0);
            ItemProperties.register(ModItems.ASTRAPE.get(), new ResourceLocation("throwing"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);

        } catch (Exception e) {
            Cataclysm.LOGGER.warn("Could not load item models for weapons");
        }
        BlockEntityRenderers.register(ModTileentites.ALTAR_OF_FIRE.get(), RendererAltar_of_Fire::new);
        BlockEntityRenderers.register(ModTileentites.ALTAR_OF_VOID.get(), RendererAltar_of_Void::new);
        BlockEntityRenderers.register(ModTileentites.DOOR_OF_SEAL.get(), Door_Of_Seal_Renderer::new);
        BlockEntityRenderers.register(ModTileentites.CURSED_TOMBSTONE.get(), Cursed_Tombstone_Renderer::new);
        BlockEntityRenderers.register(ModTileentites.BOSS_RESPAWNER.get(), Boss_Respawn_Spawn_Renderer::new);
        BlockEntityRenderers.register(ModTileentites.EMP.get(), RendererEMP::new);
        BlockEntityRenderers.register(ModTileentites.MECHANICAL_FUSION_ANVIL.get(), RendererMechanical_fusion_anvil::new);
        BlockEntityRenderers.register(ModTileentites.ALTAR_OF_AMETHYST.get(), RendererAltar_of_Amethyst::new);
        BlockEntityRenderers.register(ModTileentites.CATACLYSM_SKULL.get(), SkullBlockRenderer::new);
        BlockEntityRenderers.register(ModTileentites.ALTAR_OF_ABYSS.get(), RendererAltar_of_Abyss::new);
        BlockEntityRenderers.register(ModTileentites.ABYSSAL_EGG.get(), RendererAbyssal_Egg::new);
        BlockEntityRenderers.register(ModTileentites.GODDESS_STATUE.get(), Goddess_Statue_Renderer::new);
        MenuScreens.register(ModMenu.WEAPON_FUSION.get(), GUIWeponfusion::new);
        CuriosRendererRegistry.register(ModItems.SANDSTORM_IN_A_BOTTLE.get(), RendererSandstorm_In_A_Bottle::new);
        CuriosRendererRegistry.register(ModItems.STICKY_GLOVES.get(), RendererSticky_Gloves::new);
        CuriosRendererRegistry.register(ModItems.KOBOLEDIATOR_SKULL.get(), CurioHeadRenderer::new);
        CuriosRendererRegistry.register(ModItems.APTRGANGR_HEAD.get(), CurioHeadRenderer::new);
        CuriosRendererRegistry.register(ModItems.DRAUGR_HEAD.get(), CurioHeadRenderer::new);
        CuriosRendererRegistry.register(ModItems.BLAZING_GRIPS.get(), Blazing_Grips_Renderer::new);
        CuriosRendererRegistry.register(ModItems.CHITIN_CLAW.get(), Chitin_Claw_Renderer::new);
    }

    @OnlyIn(Dist.CLIENT)
    public static Callable<BlockEntityWithoutLevelRenderer> getTEISR() {
        return CMItemstackRenderer::new;
    }


    public Player getClientSidePlayer() {
        return Minecraft.getInstance().player;
    }

    public void blockRenderingEntity(UUID id) {
        blockedEntityRenders.add(id);
    }

    public void releaseRenderingEntity(UUID id) {
        blockedEntityRenders.remove(id);
    }

    public boolean isFirstPersonPlayer(Entity entity) {
        return entity.equals(Minecraft.getInstance().cameraEntity) && Minecraft.getInstance().options.getCameraType().isFirstPerson();
    }

    @Override
    public Object getISTERProperties() {
        return new CMItemRenderProperties();
    }

    @Override
    public Object getArmorRenderProperties() {
        return new CustomArmorRenderProperties();
    }

    public void clearSoundCacheFor(Entity entity) {
        ENTITY_SOUND_INSTANCE_MAP.remove(entity.getId());
    }

    public void clearSoundCacheFor(BlockEntity entity) {
        BLOCK_ENTITY_SOUND_INSTANCE_MAP.remove(entity);
    }

    public float getPartialTicks() {
        return Minecraft.getInstance().getPartialTick();
    }

    public boolean isKeyDown(int keyType) {
        if (keyType == -1) {
            return Minecraft.getInstance().options.keyLeft.isDown() || Minecraft.getInstance().options.keyRight.isDown() || Minecraft.getInstance().options.keyUp.isDown() || Minecraft.getInstance().options.keyDown.isDown() || Minecraft.getInstance().options.keyJump.isDown();
        }
        if (keyType == 0) {
            return Minecraft.getInstance().options.keyJump.isDown();
        }
        if (keyType == 1) {
            return Minecraft.getInstance().options.keySprint.isDown();
        }
        if (keyType == 2) {
            return ModKeybind.KEY_ABILITY.consumeClick();
        }
        if (keyType == 3) {
            return Minecraft.getInstance().options.keyAttack.isDown();
        }
        if (keyType == 4) {
            return Minecraft.getInstance().options.keyShift.isDown();
        }
        if (keyType == 5) {
            return ModKeybind.HELMET_KEY_ABILITY.isDown();
        }
        if (keyType == 6) {
            return ModKeybind.CHESTPLATE_KEY_ABILITY.isDown();
        }
        if (keyType == 7) {
            return ModKeybind.BOOTS_KEY_ABILITY.isDown();
        }
        return false;
    }


    @Override
    public void playWorldSound(@Nullable Object soundEmitter, byte type) {
        if (soundEmitter instanceof Entity entity && !entity.level().isClientSide) {
            return;
        }
        switch (type) {
            case 1:
                if (soundEmitter instanceof LivingEntity livingEntity) {
                    MeatShredderSound sound;
                    AbstractTickableSoundInstance old = ENTITY_SOUND_INSTANCE_MAP.get(livingEntity.getId());
                    if (old == null || !(old instanceof MeatShredderSound shredderSound && shredderSound.isSameEntity(livingEntity))) {
                        sound = new MeatShredderSound(livingEntity);
                        ENTITY_SOUND_INSTANCE_MAP.put(livingEntity.getId(), sound);
                    } else {
                        sound = (MeatShredderSound) old;
                    }
                    if (!Minecraft.getInstance().getSoundManager().isActive(sound) && sound.canPlaySound()) {
                        Minecraft.getInstance().getSoundManager().queueTickingSound(sound);
                    }
                }
                break;
            case 2:
                if (soundEmitter instanceof Sandstorm_Entity sandstom) {
                    SandstormSound sound;
                    AbstractTickableSoundInstance old = ENTITY_SOUND_INSTANCE_MAP.get(sandstom.getId());
                    if (old == null || !(old instanceof SandstormSound sandstomSound && sandstomSound.isSameEntity(sandstom))) {
                        sound = new SandstormSound(sandstom);
                        ENTITY_SOUND_INSTANCE_MAP.put(sandstom.getId(), sound);
                    } else {
                        sound = (SandstormSound) old;
                    }
                    if (!Minecraft.getInstance().getSoundManager().isActive(sound) && sound.canPlaySound()) {
                        Minecraft.getInstance().getSoundManager().queueTickingSound(sound);
                    }
                }
                break;
        }
    }

    private void registerKeybinds(RegisterKeyMappingsEvent e) {
        e.register(ModKeybind.KEY_ABILITY);
        e.register(ModKeybind.HELMET_KEY_ABILITY);
        e.register(ModKeybind.CHESTPLATE_KEY_ABILITY);
        e.register(ModKeybind.BOOTS_KEY_ABILITY);
    }


    public void removeBossBarRender(UUID bossBar) {
        this.bossBarRenderTypes.remove(bossBar);
    }

    public void setBossBarRender(UUID bossBar, int renderType) {
        this.bossBarRenderTypes.put(bossBar, renderType);
    }

}