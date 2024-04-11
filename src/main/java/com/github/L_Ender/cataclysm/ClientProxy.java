package com.github.L_Ender.cataclysm;

import com.github.L_Ender.cataclysm.client.event.ClientEvent;
import com.github.L_Ender.cataclysm.client.gui.GUIWeponfusion;
import com.github.L_Ender.cataclysm.client.particle.*;
import com.github.L_Ender.cataclysm.client.render.CMItemstackRenderer;
import com.github.L_Ender.cataclysm.client.render.blockentity.*;
import com.github.L_Ender.cataclysm.client.render.entity.*;
import com.github.L_Ender.cataclysm.client.render.etc.CurioHeadRenderer;
import com.github.L_Ender.cataclysm.client.render.item.CMItemRenderProperties;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemREnderer.RendererSandstorm_In_A_Bottle;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemREnderer.RendererSticky_Gloves;
import com.github.L_Ender.cataclysm.client.render.item.CustomArmorRenderProperties;
import com.github.L_Ender.cataclysm.client.sound.MeatShredderSound;
import com.github.L_Ender.cataclysm.client.sound.SandstormSound;
import com.github.L_Ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.github.L_Ender.cataclysm.init.*;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
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
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Cataclysm.MODID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {
    public static final Int2ObjectMap<AbstractTickableSoundInstance> ENTITY_SOUND_INSTANCE_MAP = new Int2ObjectOpenHashMap<>();
    public static final Map<BlockEntity, AbstractTickableSoundInstance> BLOCK_ENTITY_SOUND_INSTANCE_MAP = new HashMap<>();
    public static Map<UUID, Integer> bossBarRenderTypes = new HashMap<>();

    public void init() {
       // FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientLayerEvent::onAddLayers);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupParticles);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerKeybinds);
    }

    public void setupParticles(RegisterParticleProvidersEvent registry) {
        Cataclysm.LOGGER.debug("Registered particle factories");
        registry.registerSpriteSet(ModParticle.SOUL_LAVA.get(), SoulLavaParticle.Factory::new);
        registry.registerSpecial(ModParticle.EM_PULSE.get(), new EM_PulseParticle.Factory());
        registry.registerSpecial(ModParticle.SHOCK_WAVE.get(), new Shock_WaveParticle.Factory());
        registry.registerSpecial(ModParticle.LIGHTNING.get(), new LightningParticle.OrbFactory());
        registry.registerSpecial(ModParticle.STORM.get(), new StormParticle.OrbFactory());
        registry.registerSpriteSet(ModParticle.SANDSTORM.get(), SandStormParticle.Factory::new);
    }

    public void clientInit() {
        ItemRenderer itemRendererIn = Minecraft.getInstance().getItemRenderer();
        EntityRenderers.register(ModEntities.ENDER_GOLEM.get(), RendererEnder_Golem::new);
        EntityRenderers.register(ModEntities.NETHERITE_MONSTROSITY.get(), RendererNetherite_Monstrosity::new);
        EntityRenderers.register(ModEntities.LAVA_BOMB.get(), RendererLava_Bomb::new);
        EntityRenderers.register(ModEntities.NAMELESS_SORCERER.get(), RendererNameless_Sorcerer::new);
        EntityRenderers.register(ModEntities.IGNIS.get(), RendererIgnis::new);
        EntityRenderers.register(ModEntities.ENDER_GUARDIAN.get(), RendererEnder_Guardian::new);
        EntityRenderers.register(ModEntities.ENDER_GUARDIAN_BULLET.get(), RendererEnder_Guardian_bullet::new);
        EntityRenderers.register(ModEntities.VOID_RUNE.get(), RendererVoid_Rune::new);
        EntityRenderers.register(ModEntities.ENDERMAPTERA.get(), RendererEndermaptera::new);
        EntityRenderers.register(ModEntities.IGNITED_REVENANT.get(), RendererIgnited_Revenant::new);
        EntityRenderers.register(ModEntities.IGNITED_BERSERKER.get(), RendererIgnited_Berserker::new);
        EntityRenderers.register(ModEntities.THE_HARBINGER.get(), RendererThe_Harbinger::new);
        EntityRenderers.register(ModEntities.VOID_SCATTER_ARROW.get(), RendererVoid_Scatter_Arrow::new);

        EntityRenderers.register(ModEntities.POISON_DART.get(), RendererPoison_Dart::new);
        EntityRenderers.register(ModEntities.SCREEN_SHAKE.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.HOLD_ATTACK.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.WITHER_SMOKE_EFFECT.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.ASHEN_BREATH.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.WALL_WATCHER.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.FLAME_STRIKE.get(), RendererFlame_Strike::new);
        EntityRenderers.register(ModEntities.CM_FALLING_BLOCK.get(), RendererCm_Falling_Block::new);
        EntityRenderers.register(ModEntities.IGNIS_FIREBALL.get(), RendererIgnis_Fireball::new);
        EntityRenderers.register(ModEntities.IGNIS_ABYSS_FIREBALL.get(), RendererIgnis_Abyss_Fireball::new);
        EntityRenderers.register(ModEntities.DEATH_LASER_BEAM.get(), RendererDeath_Laser_beam::new);
        EntityRenderers.register(ModEntities.ABYSS_BLAST.get(), RendererAbyss_Blast::new);
        EntityRenderers.register(ModEntities.MINI_ABYSS_BLAST.get(), RendererMini_Abyss_Blast::new);
        EntityRenderers.register(ModEntities.LASER_BEAM.get(), RendererLaser_Beam::new);
        EntityRenderers.register(ModEntities.WITHER_MISSILE.get(), RendererWither_Missile::new);
        EntityRenderers.register(ModEntities.WITHER_HOMING_MISSILE.get(), RendererWither_Homing_Missile::new);
        EntityRenderers.register(ModEntities.WITHER_HOWITZER.get(), RendererWither_Howitzer::new);
        EntityRenderers.register(ModEntities.VOID_HOWITZER.get(), RendererVoid_Howitzer::new);
        EntityRenderers.register(ModEntities.VOID_VORTEX.get(), RendererVoid_Vortex::new);
        EntityRenderers.register(ModEntities.THE_LEVIATHAN.get(), RendererThe_Leviathan::new);
        EntityRenderers.register(ModEntities.THE_BABY_LEVIATHAN.get(), RendererThe_Baby_Leviathan::new);
        EntityRenderers.register(ModEntities.ABYSS_PORTAL.get(), RendererAbyss_Portal::new);
        EntityRenderers.register(ModEntities.ABYSS_ORB.get(), RendererAbyss_Orb::new);
        EntityRenderers.register(ModEntities.ABYSS_BLAST_PORTAL.get(), RendererAbyss_Blast_Portal::new);
        EntityRenderers.register(ModEntities.PORTAL_ABYSS_BLAST.get(), RendererPortal_Abyss_Blast::new);
        EntityRenderers.register(ModEntities.DEEPLING.get(), RendererDeepling::new);
        EntityRenderers.register(ModEntities.ABYSS_MINE.get(), RendererAbyss_Mine::new);
        EntityRenderers.register(ModEntities.CORAL_SPEAR.get(), RendererThrown_Coral_Spear::new);
        EntityRenderers.register(ModEntities.CORAL_BARDICHE.get(), RendererThrown_Coral_Bardiche::new);
        EntityRenderers.register(ModEntities.DEEPLING_BRUTE.get(), RendererDeepling_Brute::new);
        EntityRenderers.register(ModEntities.DEEPLING_PRIEST.get(), RendererDeepling_Priest::new);
        EntityRenderers.register(ModEntities.DIMENSIONAL_RIFT.get(), RendererDimensional_Rift::new);
        EntityRenderers.register(ModEntities.DEEPLING_ANGLER.get(), RendererDeepling_Angler::new);
        EntityRenderers.register(ModEntities.DEEPLING_WARLOCK.get(), RendererDeepling_Warlock::new);
        EntityRenderers.register(ModEntities.ABYSS_MARK.get(), RendererAbyss_Mark::new);
        EntityRenderers.register(ModEntities.CORAL_GOLEM.get(), RendererCoral_Golem::new);
        EntityRenderers.register(ModEntities.CORALSSUS.get(), RendererCoralssus::new);
        EntityRenderers.register(ModEntities.LIONFISH.get(), RendererLionfish::new);
        EntityRenderers.register(ModEntities.TIDAL_HOOK.get(), RendererTidal_Hook::new);
        EntityRenderers.register(ModEntities.AMETHYST_CRAB.get(), RendererAmethyst_Crab::new);
        EntityRenderers.register(ModEntities.ANCIENT_REMNANT.get(), RendererAncient_Remnant::new);
        EntityRenderers.register(ModEntities.MODERN_REMNANT.get(), RendererModern_Remnant::new);
        EntityRenderers.register(ModEntities.SANDSTORM.get(), RenderSandstorm::new);
        EntityRenderers.register(ModEntities.THE_WATCHER.get(), RendererThe_Watcher::new);
        EntityRenderers.register(ModEntities.THE_PROWLER.get(), RendererThe_Prowler::new);
        EntityRenderers.register(ModEntities.KOBOLETON.get(), RendererKoboleton::new);
        EntityRenderers.register(ModEntities.KOBOLEDIATOR.get(), RendererKobolediator::new);
        EntityRenderers.register(ModEntities.WADJET.get(), RendererWadjet::new);
        EntityRenderers.register(ModEntities.EARTHQUAKE.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.ANCIENT_DESERT_STELE.get(), RendererAncient_Desert_Stele::new);
        EntityRenderers.register(ModEntities.AMETHYST_CLUSTER_PROJECTILE.get(), RendererAmethyst_Cluster_Projectile::new);
        EntityRenderers.register(ModEntities.THE_LEVIATHAN_TONGUE.get(), RendererNull::new);
        EntityRenderers.register(ModEntities.VOID_SHARD.get(), (render) -> {
            return new ThrownItemRenderer<>(render, 0.75F, true);
        });
        EntityRenderers.register(ModEntities.EYE_OF_DUNGEON.get(), (render) -> {
            return new ThrownItemRenderer<>(render, 1.0F, true);
        });
        EntityRenderers.register(ModEntities.BLAZING_BONE.get(), RendererBlazing_Bone::new);
        EntityRenderers.register(ModEntities.LIONFISH_SPIKE.get(), RendererLionfish_Spike::new);
        EntityRenderers.register(ModEntities.TIDAL_TENTACLE.get(), RendererTidal_Tentacle::new);
        MinecraftForge.EVENT_BUS.register(new ClientEvent());
        try {
            ItemProperties.register(ModItems.BULWARK_OF_THE_FLAME.get(), new ResourceLocation("blocking"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
            ItemProperties.register(ModItems.CORAL_SPEAR.get(), new ResourceLocation("throwing"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
            ItemProperties.register(ModItems.CORAL_BARDICHE.get(), new ResourceLocation("throwing"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
            ItemProperties.register(ModItems.MEAT_SHREDDER.get(), new ResourceLocation("using"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == stack ? 1.0F : 0.0F);
            ItemProperties.register(Items.CROSSBOW, new ResourceLocation(Cataclysm.MODID, "void_scatter_arrow"), (stack, world, entity, j) -> entity != null && CrossbowItem.isCharged(stack) && CrossbowItem.containsChargedProjectile(stack, ModItems.VOID_SCATTER_ARROW.get()) ? 1.0F : 0.0F);
        } catch (Exception e) {
            Cataclysm.LOGGER.warn("Could not load item models for weapons");

        }
        BlockEntityRenderers.register(ModTileentites.ALTAR_OF_FIRE.get(), RendererAltar_of_Fire::new);
        BlockEntityRenderers.register(ModTileentites.ALTAR_OF_VOID.get(), RendererAltar_of_Void::new);
        BlockEntityRenderers.register(ModTileentites.EMP.get(), RendererEMP::new);
        BlockEntityRenderers.register(ModTileentites.MECHANICAL_FUSION_ANVIL.get(), RendererMechanical_fusion_anvil::new);
        BlockEntityRenderers.register(ModTileentites.ALTAR_OF_AMETHYST.get(), RendererAltar_of_Amethyst::new);
        BlockEntityRenderers.register(ModTileentites.CATACLYSM_SKULL.get(), Cataclysm_Skull_Block_Renderer::new);
        BlockEntityRenderers.register(ModTileentites.ALTAR_OF_ABYSS.get(), RendererAltar_of_Abyss::new);
        BlockEntityRenderers.register(ModTileentites.ABYSSAL_EGG.get(), RendererAbyssal_Egg::new);
        MenuScreens.register(ModMenu.WEAPON_FUSION.get(), GUIWeponfusion::new);
        CuriosRendererRegistry.register(ModItems.SANDSTORM_IN_A_BOTTLE.get(), RendererSandstorm_In_A_Bottle::new);
        CuriosRendererRegistry.register(ModItems.STICKY_GLOVES.get(), RendererSticky_Gloves::new);
        CuriosRendererRegistry.register(ModItems.KOBOLEDIATOR_SKULL.get(), CurioHeadRenderer::new);
    }


    @OnlyIn(Dist.CLIENT)
    public static Callable<BlockEntityWithoutLevelRenderer> getTEISR() {
        return CMItemstackRenderer::new;
    }


    public Player getClientSidePlayer() {
        return Minecraft.getInstance().player;
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
    }

    public void removeBossBarRender(UUID bossBar) {
        this.bossBarRenderTypes.remove(bossBar);
    }

    public void setBossBarRender(UUID bossBar, int renderType) {
        this.bossBarRenderTypes.put(bossBar, renderType);
    }

}