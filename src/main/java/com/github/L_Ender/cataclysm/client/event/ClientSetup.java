package com.github.L_Ender.cataclysm.client.event;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.gui.GUIWeponfusion;
import com.github.L_Ender.cataclysm.client.particle.*;
import com.github.L_Ender.cataclysm.client.render.CMItemstackRenderer;
import com.github.L_Ender.cataclysm.client.render.blockentity.*;
import com.github.L_Ender.cataclysm.client.render.entity.*;
import com.github.L_Ender.cataclysm.client.render.etc.CurioHeadRenderer;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemREnderer.Blazing_Grips_Renderer;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemREnderer.Chitin_Claw_Renderer;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemREnderer.RendererSticky_Gloves;
import com.github.L_Ender.cataclysm.client.render.item.CustomArmorRenderProperties;
import com.github.L_Ender.cataclysm.init.*;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

public class ClientSetup {


	public static void ClientSetupevent(IEventBus bus) {
		bus.addListener(ClientSetup::registerScreens);
		bus.addListener(ClientSetup::registerEntityRenderers);
		bus.addListener(ClientSetup::registerParticleFactories);
		bus.addListener(ClientSetup::registerClientExtensions);
		bus.addListener(ClientSetup::doClientStuff);
	//	bus.addListener(ClientSetup::addLayers);
	}

	private static void registerScreens(RegisterMenuScreensEvent event) {
		event.register(ModMenu.WEAPON_FUSION.get(), GUIWeponfusion::new);
	}


	private static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ModEntities.ENDER_GOLEM.get(), Ender_Golem_Renderer::new);
		event.registerEntityRenderer(ModEntities.NETHERITE_MONSTROSITY.get(), New_Netherite_Monstrosity_Renderer::new);
		event.registerEntityRenderer(ModEntities.NETHERITE_MINISTROSITY.get(), Netherite_Ministrosity_Renderer::new);
		event.registerEntityRenderer(ModEntities.LAVA_BOMB.get(), Lava_Bomb_Renderer::new);
		event.registerEntityRenderer(ModEntities.FLARE_BOMB.get(), Flare_Bomb_Renderer::new);
		event.registerEntityRenderer(ModEntities.FLAME_JET.get(), RendererNull::new);
		event.registerEntityRenderer(ModEntities.LIGHTNING_STORM.get(), RendererNull::new);
		event.registerEntityRenderer(ModEntities.IGNIS.get(), Ignis_Renderer::new);
		event.registerEntityRenderer(ModEntities.ENDER_GUARDIAN.get(), Ender_Guardian_Renderer::new);
		event.registerEntityRenderer(ModEntities.ENDER_GUARDIAN_BULLET.get(), Ender_Guardian_bullet_Renderer::new);
		event.registerEntityRenderer(ModEntities.VOID_RUNE.get(), Void_Rune_Renderer::new);
		event.registerEntityRenderer(ModEntities.ENDERMAPTERA.get(), Endermaptera_Renderer::new);
		event.registerEntityRenderer(ModEntities.IGNITED_REVENANT.get(), Ignited_Revenant_Renderer::new);
		event.registerEntityRenderer(ModEntities.IGNITED_BERSERKER.get(), Ignited_Berserker_Renderer::new);
		event.registerEntityRenderer(ModEntities.THE_HARBINGER.get(), The_Harbinger_Renderer::new);
		event.registerEntityRenderer(ModEntities.VOID_SCATTER_ARROW.get(), Void_Scatter_Arrow_Renderer::new);

		event.registerEntityRenderer(ModEntities.POISON_DART.get(), Poison_Dart_Renderer::new);

		event.registerEntityRenderer(ModEntities.PHANTOM_ARROW.get(), Phantom_Arrow_Renderer::new);
		event.registerEntityRenderer(ModEntities.SCREEN_SHAKE.get(), RendererNull::new);
		event.registerEntityRenderer(ModEntities.WITHER_SMOKE_EFFECT.get(), RendererNull::new);
		event.registerEntityRenderer(ModEntities.LIGHTNING_AREA_EFFECT.get(), RendererNull::new);
		event.registerEntityRenderer(ModEntities.ASHEN_BREATH.get(), RendererNull::new);
		event.registerEntityRenderer(ModEntities.WALL_WATCHER.get(), RendererNull::new);
		event.registerEntityRenderer(ModEntities.FLAME_STRIKE.get(), Flame_Strike_Renderer::new);

		event.registerEntityRenderer(ModEntities.BOLT_STRIKE.get(), Boltstrike_Renderer::new);

		event.registerEntityRenderer(ModEntities.CM_FALLING_BLOCK.get(), Cm_Falling_Block_Renderer::new);
		event.registerEntityRenderer(ModEntities.IGNIS_FIREBALL.get(), Ignis_Fireball_Renderer::new);
		event.registerEntityRenderer(ModEntities.IGNIS_ABYSS_FIREBALL.get(), Ignis_Abyss_Fireball_Renderer::new);
		event.registerEntityRenderer(ModEntities.DEATH_LASER_BEAM.get(), Death_Laser_beam_Renderer::new);
		event.registerEntityRenderer(ModEntities.ABYSS_BLAST.get(), Abyss_Blast_Renderer::new);
		event.registerEntityRenderer(ModEntities.MINI_ABYSS_BLAST.get(), Mini_Abyss_Blast_Renderer::new);
		event.registerEntityRenderer(ModEntities.LASER_BEAM.get(), Laser_Beam_Renderer::new);
		event.registerEntityRenderer(ModEntities.WITHER_MISSILE.get(), Wither_Missile_Renderer::new);
		event.registerEntityRenderer(ModEntities.WITHER_HOMING_MISSILE.get(), Wither_Homing_Missile_Renderer::new);
		event.registerEntityRenderer(ModEntities.WITHER_HOWITZER.get(), Wither_Howitzer_Renderer::new);
		event.registerEntityRenderer(ModEntities.VOID_HOWITZER.get(), Void_Howitzer_Renderer::new);
		event.registerEntityRenderer(ModEntities.VOID_VORTEX.get(), Void_Vortex_Renderer::new);
		event.registerEntityRenderer(ModEntities.THE_LEVIATHAN.get(), The_Leviathan_Renderer::new);
		event.registerEntityRenderer(ModEntities.THE_BABY_LEVIATHAN.get(), The_Baby_Leviathan_Renderer::new);
		event.registerEntityRenderer(ModEntities.ABYSS_PORTAL.get(), Abyss_Portal_Renderer::new);
		event.registerEntityRenderer(ModEntities.ABYSS_ORB.get(), Abyss_Orb_Renderer::new);
		event.registerEntityRenderer(ModEntities.ABYSS_BLAST_PORTAL.get(), Abyss_Blast_Portal_Renderer::new);
		event.registerEntityRenderer(ModEntities.PORTAL_ABYSS_BLAST.get(), Portal_Abyss_Blast_Renderer::new);
		event.registerEntityRenderer(ModEntities.DEEPLING.get(), Deepling_Renderer::new);
		event.registerEntityRenderer(ModEntities.ABYSS_MINE.get(), Abyss_Mine_Renderer::new);
		event.registerEntityRenderer(ModEntities.CORAL_SPEAR.get(), Thrown_Coral_Spear_Renderer::new);

		event.registerEntityRenderer(ModEntities.CORAL_BARDICHE.get(), Thrown_Coral_Bardiche_Renderer::new);
		event.registerEntityRenderer(ModEntities.DEEPLING_BRUTE.get(), Deepling_Brute_Renderer::new);
		event.registerEntityRenderer(ModEntities.DEEPLING_PRIEST.get(), Deepling_Priest_Renderer::new);
		event.registerEntityRenderer(ModEntities.DIMENSIONAL_RIFT.get(), Dimensional_Rift_Renderer::new);
		event.registerEntityRenderer(ModEntities.DEEPLING_ANGLER.get(), Deepling_Angler_Renderer::new);
		event.registerEntityRenderer(ModEntities.DEEPLING_WARLOCK.get(), Deepling_Warlock_Renderer::new);
		event.registerEntityRenderer(ModEntities.ABYSS_MARK.get(), Abyss_Mark_Renderer::new);
		event.registerEntityRenderer(ModEntities.CORAL_GOLEM.get(), Coral_Golem_Renderer::new);
		event.registerEntityRenderer(ModEntities.CORALSSUS.get(), Coralssus_Renderer::new);
		event.registerEntityRenderer(ModEntities.LIONFISH.get(), Lionfish_Renderer::new);
		event.registerEntityRenderer(ModEntities.TIDAL_HOOK.get(), Tidal_Hook_Renderer::new);
		event.registerEntityRenderer(ModEntities.AMETHYST_CRAB.get(), Amethyst_Crab_Renderer::new);
		event.registerEntityRenderer(ModEntities.ANCIENT_ANCIENT_REMNANT.get(), Ancient_Remnant_Renderer::new);
		event.registerEntityRenderer(ModEntities.ANCIENT_REMNANT.get(), Ancient_Remnant_Rework_Renderer::new);
		event.registerEntityRenderer(ModEntities.MODERN_REMNANT.get(), Modern_Remnant_Renderer::new);
		event.registerEntityRenderer(ModEntities.SANDSTORM.get(), Sandstorm_Renderer::new);
		event.registerEntityRenderer(ModEntities.SANDSTORM_PROJECTILE.get(), Sandstorm_Projectile_Renderer::new);
		event.registerEntityRenderer(ModEntities.CURSED_SANDSTORM.get(), Cursed_Sandstorm_Renderer::new);
		event.registerEntityRenderer(ModEntities.THE_WATCHER.get(), The_Watcher_Renderer::new);
		event.registerEntityRenderer(ModEntities.THE_PROWLER.get(), The_Prowler_Renderer::new);
		event.registerEntityRenderer(ModEntities.KOBOLETON.get(), Koboleton_Renderer::new);
		event.registerEntityRenderer(ModEntities.KOBOLEDIATOR.get(), Kobolediator_Renderer::new);
		event.registerEntityRenderer(ModEntities.WADJET.get(), Wadjet_Renderer::new);
		event.registerEntityRenderer(ModEntities.MALEDICTUS.get(), Maledictus_Renderer::new);
		event.registerEntityRenderer(ModEntities.DRAUGR.get(), Draugr_Renderer::new);
		event.registerEntityRenderer(ModEntities.ROYAL_DRAUGR.get(), Royal_Draugr_Renderer::new);
		event.registerEntityRenderer(ModEntities.ELITE_DRAUGR.get(), Elite_Draugr_Renderer::new);
		event.registerEntityRenderer(ModEntities.APTRGANGR.get(), Aptrgangr_Renderer::new);
		event.registerEntityRenderer(ModEntities.AXE_BLADE.get(), Axe_Blade_Renderer::new);
		event.registerEntityRenderer(ModEntities.PHANTOM_HALBERD.get(), Phantom_Halberd_Renderer::new);
		event.registerEntityRenderer(ModEntities.EARTHQUAKE.get(), RendererNull::new);
		event.registerEntityRenderer(ModEntities.ACCRETION.get(), Accretion_Renderer::new);
		event.registerEntityRenderer(ModEntities.ANCIENT_DESERT_STELE.get(), Ancient_Desert_Stele_Renderer::new);
		event.registerEntityRenderer(ModEntities.AMETHYST_CLUSTER_PROJECTILE.get(), Amethyst_Cluster_Projectile_Renderer::new);
		event.registerEntityRenderer(ModEntities.THE_LEVIATHAN_TONGUE.get(), RendererNull::new);
		event.registerEntityRenderer(ModEntities.VOID_SHARD.get(), (render) -> {
			return new ThrownItemRenderer<>(render, 0.75F, true);
		});
		event.registerEntityRenderer(ModEntities.EYE_OF_DUNGEON.get(), Eye_Of_Dungeon_Renderer::new);
		event.registerEntityRenderer(ModEntities.BLAZING_BONE.get(), Blazing_Bone_Renderer::new);
		event.registerEntityRenderer(ModEntities.LIONFISH_SPIKE.get(), Lionfish_Spike_Renderer::new);
		event.registerEntityRenderer(ModEntities.TIDAL_TENTACLE.get(), Tidal_Tentacle_Renderer::new);

		event.registerEntityRenderer(ModEntities.HIPPOCAMTUS.get(), Hippocamtus_Renderer::new);

		event.registerEntityRenderer(ModEntities.SCYLLA.get(), Scylla_Renderer::new);
		event.registerEntityRenderer(ModEntities.CLAWDIAN.get(), Clawdian_Renderer::new);
		event.registerEntityRenderer(ModEntities.URCHINKIN.get(), Urchinkin_Renderer::new);
		event.registerEntityRenderer(ModEntities.WATER_SPEAR.get(), Water_Spear_Renderer::new);
		event.registerEntityRenderer(ModEntities.LIGHTNING_SPEAR.get(), Lightning_Spear_Renderer::new);
		event.registerEntityRenderer(ModEntities.CINDARIA.get(), Cindaria_Renderer::new);
		event.registerEntityRenderer(ModEntities.STORM_BRINGER.get(), Storm_Bringer_Renderer::new);
		event.registerEntityRenderer(ModEntities.SCYLLA_STORM_BRINGER.get(), Scylla_Storm_Bringer_Renderer::new);
		event.registerEntityRenderer(ModEntities.URCHIN_SPIKE.get(), Urchin_Spike_Renderer::new);
		event.registerEntityRenderer(ModEntities.SPARK.get(), RendererNull::new);
		event.registerEntityRenderer(ModEntities.WAVE.get(), Wave_Renderer::new);
		event.registerEntityRenderer(ModEntities.STORM_SERPENT.get(), Storm_Serpent_Renderer::new);
		// Block Entities
		event.registerBlockEntityRenderer(ModTileentites.ALTAR_OF_FIRE.get(), RendererAltar_of_Fire::new);
		event.registerBlockEntityRenderer(ModTileentites.ALTAR_OF_VOID.get(), RendererAltar_of_Void::new);
		event.registerBlockEntityRenderer(ModTileentites.DOOR_OF_SEAL.get(), Door_Of_Seal_Renderer::new);
		event.registerBlockEntityRenderer(ModTileentites.CURSED_TOMBSTONE.get(), Cursed_Tombstone_Renderer::new);
		event.registerBlockEntityRenderer(ModTileentites.EMP.get(), RendererEMP::new);
		event.registerBlockEntityRenderer(ModTileentites.MECHANICAL_FUSION_ANVIL.get(), RendererMechanical_fusion_anvil::new);
		event.registerBlockEntityRenderer(ModTileentites.ALTAR_OF_AMETHYST.get(), RendererAltar_of_Amethyst::new);
		event.registerBlockEntityRenderer(ModTileentites.CATACLYSM_SKULL.get(), Cataclysm_Skull_Block_Renderer::new);
		event.registerBlockEntityRenderer(ModTileentites.ALTAR_OF_ABYSS.get(), RendererAltar_of_Abyss::new);
		event.registerBlockEntityRenderer(ModTileentites.ABYSSAL_EGG.get(), RendererAbyssal_Egg::new);
		event.registerBlockEntityRenderer(ModTileentites.BOSS_RESPAWNER.get(), Boss_Respawn_Spawn_Renderer::new);
		event.registerBlockEntityRenderer(ModTileentites.GODDESS_STATUE.get(), Goddess_Statue_Renderer::new);
	}

	private static void registerCuriosRenderer() {

	}

	private static void registerParticleFactories(RegisterParticleProvidersEvent registry) {
		registry.registerSpriteSet(ModParticle.SPARK.get(), SparkParticle.Factory::new);
		registry.registerSpriteSet(ModParticle.SOUL_LAVA.get(), SoulLavaParticle.Factory::new);
		registry.registerSpriteSet(ModParticle.CURSED_FLAME.get(), CursedFlameParticle.Provider::new);
		registry.registerSpriteSet(ModParticle.SMALL_CURSED_FLAME.get(), CursedFlameParticle.SmallFlameProvider::new);
		registry.registerSpriteSet(ModParticle.PHANTOM_WING_FLAME.get(), Phantom_Wing_FlameParticle.EmissiveProvider::new);
		registry.registerSpriteSet(ModParticle.CUSTOM_POOF.get(), Custom_Poof_Particle.Provider::new);
		registry.registerSpriteSet(ModParticle.LIGHTNING_ZAP.get(), Lightning_Zap_Particle.Provider::new);
		registry.registerSpecial(ModParticle.EM_PULSE.get(), new EM_PulseParticle.Factory());
		registry.registerSpecial(ModParticle.SHOCK_WAVE.get(), new Shock_WaveParticle.Factory());
		registry.registerSpecial(ModParticle.LIGHTNING.get(), new LightningParticle.Factory());
		registry.registerSpecial(ModParticle.SPARK_TRAIL.get(), new SparkTrailParticle.Factory());
		registry.registerSpecial(ModParticle.TRACK_LIGHTNING.get(), new TrackLightningParticle.Factory());
		registry.registerSpecial(ModParticle.SPIN_TRAIL_PARTICLE.get(), new SpinTrailParticle.Factory());
		registry.registerSpecial(ModParticle.CIRCLE_LIGHTNING.get(), new CircleLightningParticle.Factory());
		registry.registerSpecial(ModParticle.GATHERING_WATER.get(), new Gathering_Water_Particle.Factory());
		registry.registerSpecial(ModParticle.STORM.get(), new StormParticle.Factory());
		registry.registerSpecial(ModParticle.RISING_TRAIL.get(), new Rising_Trail_Particle.Factory());
		registry.registerSpriteSet(ModParticle.RING.get(), RingParticle.RingFactory::new);
		registry.registerSpriteSet(ModParticle.ROAR.get(), RoarParticle.RoarFactory::new);
		registry.registerSpriteSet(ModParticle.SCYLLA_SWING.get(), Scylla_Swing_Particle.Provider::new);
		registry.registerSpriteSet(ModParticle.RAIN_CLOUD.get(), RainCloudParticle.Factory::new);
		registry.registerSpriteSet(ModParticle.TRAP_FLAME.get(), TrapFlameParticle.Factory::new);
		registry.registerSpecial(ModParticle.LIGHT_TRAIL.get(), new LightTrailParticle.Factory());
		registry.registerSpecial(ModParticle.NOT_SPIN_PARTICLE.get(), new Not_Spin_TrailParticle.Factory());
		registry.registerSpriteSet(ModParticle.FLAME_JET.get(), FlameJetParticle.Factory::new);
		registry.registerSpriteSet(ModParticle.LIGHTNING_STORM.get(), LightningStormParticle.Factory::new);
		registry.registerSpriteSet(ModParticle.FLARE_EXPLODE.get(), CustomExplodeParticle.FlareFactory::new);
	}


	private static void doClientStuff(final FMLClientSetupEvent event) {
		try {
			ItemProperties.register(ModItems.BULWARK_OF_THE_FLAME.get(), ResourceLocation.parse("blocking"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
			ItemProperties.register(ModItems.SOUL_RENDER.get(), ResourceLocation.parse("blocking"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
			ItemProperties.register(ModItems.CORAL_SPEAR.get(), ResourceLocation.parse("throwing"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
			ItemProperties.register(ModItems.CORAL_BARDICHE.get(), ResourceLocation.parse("throwing"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
			ItemProperties.register(ModItems.MEAT_SHREDDER.get(), ResourceLocation.parse("using"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
		//	ItemProperties.register(Items.CROSSBOW, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "void_scatter_arrow"), (stack, world, entity, j) -> entity != null && CrossbowItem.isCharged(stack) && CrossbowItem.containsChargedProjectile(stack, ModItems.VOID_SCATTER_ARROW.get()) ? 1.0F : 0.0F);
			ItemProperties.register(ModItems.CORAL_CHUNK.get(), ResourceLocation.parse("chunk"), (stack, level, living, j) -> (stack.getCount() % 3 == 0) ? 0.0F : (stack.getCount() % 3 == 1) ? 0.5F : 1.0F);
			ItemProperties.register(ModItems.BLACK_STEEL_TARGE.get(), ResourceLocation.parse("blocking"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
			ItemProperties.register(ModItems.AZURE_SEA_SHIELD.get(), ResourceLocation.parse("blocking"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
			ItemProperties.register(ModItems.LIGHTNING_SPEAR.get(), ResourceLocation.parse("throwing"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);

		} catch (Exception e) {
			Cataclysm.LOGGER.warn("Could not load item models for weapons");
		}
		CuriosRendererRegistry.register(ModItems.STICKY_GLOVES.get(), RendererSticky_Gloves::new);
		CuriosRendererRegistry.register(ModItems.BLAZING_GRIPS.get(), Blazing_Grips_Renderer::new);
		CuriosRendererRegistry.register(ModItems.KOBOLEDIATOR_SKULL.get(), CurioHeadRenderer::new);
		CuriosRendererRegistry.register(ModItems.APTRGANGR_HEAD.get(), CurioHeadRenderer::new);
		CuriosRendererRegistry.register(ModItems.DRAUGR_HEAD.get(), CurioHeadRenderer::new);
		CuriosRendererRegistry.register(ModItems.CHITIN_CLAW.get(), Chitin_Claw_Renderer::new);
	}


	private static void registerClientExtensions(RegisterClientExtensionsEvent event) {

		event.registerItem(CustomArmorRenderProperties.INSTANCE.get(), ModItems.IGNITIUM_HELMET.get(), ModItems.IGNITIUM_CHESTPLATE.get(), ModItems.IGNITIUM_LEGGINGS.get(), ModItems.IGNITIUM_BOOTS.get());
		event.registerItem(CustomArmorRenderProperties.INSTANCE.get(), ModItems.CURSIUM_HELMET.get(), ModItems.CURSIUM_CHESTPLATE.get(), ModItems.CURSIUM_LEGGINGS.get(), ModItems.CURSIUM_BOOTS.get());
		event.registerItem(CustomArmorRenderProperties.INSTANCE.get(), ModItems.BONE_REPTILE_HELMET.get(), ModItems.BONE_REPTILE_CHESTPLATE.get());
		event.registerItem(CustomArmorRenderProperties.INSTANCE.get(), ModItems.MONSTROUS_HELM.get());
		event.registerItem(CustomArmorRenderProperties.INSTANCE.get(), ModItems.IGNITIUM_ELYTRA_CHESTPLATE.get());
		event.registerItem(CustomArmorRenderProperties.INSTANCE.get(), ModItems.BLOOM_STONE_PAULDRONS.get());

		event.registerItem(CMItemstackRenderer.CLIENT_ITEM_EXTENSION,
				ModItems.BULWARK_OF_THE_FLAME.get(), ModItems.BLACK_STEEL_TARGE.get(), ModItems.GAUNTLET_OF_GUARD.get(), ModItems.GAUNTLET_OF_BULWARK.get(), ModItems.GAUNTLET_OF_MAELSTROM.get(),
				ModItems.THE_INCINERATOR.get(), ModItems.WITHER_ASSULT_SHOULDER_WEAPON.get(), ModItems.VOID_ASSULT_SHOULDER_WEAPON.get(), ModItems.CORAL_SPEAR.get(), ModItems.CORAL_BARDICHE.get(),
				ModItems.VOID_FORGE.get(), ModItems.TIDAL_CLAWS.get(), ModItems.MEAT_SHREDDER.get(), ModItems.LASER_GATLING.get(), ModItems.ANCIENT_SPEAR.get() , ModItems.CURSED_BOW.get(),
				ModItems.WRATH_OF_THE_DESERT.get(), ModItems.SOUL_RENDER.get(), ModItems.THE_ANNIHILATOR.get(), ModItems.THE_IMMOLATOR.get(), ModItems.ALTAR_OF_FIRE.get(), ModItems.ALTAR_OF_VOID.get(),
				ModItems.AZURE_SEA_SHIELD.get(),ModItems.LIGHTNING_SPEAR.get(),
				ModItems.ALTAR_OF_AMETHYST.get(), ModItems.ALTAR_OF_ABYSS.get(), ModItems.EMP.get(), ModItems.MECHANICAL_FUSION_ANVIL.get(), ModItems.ABYSSAL_EGG.get(),
				ModItems.KOBOLEDIATOR_SKULL.get(), ModItems.APTRGANGR_HEAD.get(), ModItems.DRAUGR_HEAD.get(), ModItems.GODDESS_STATUE.get(), ModItems.BOSS_RESPAWNER.get()
		);

	}

}
