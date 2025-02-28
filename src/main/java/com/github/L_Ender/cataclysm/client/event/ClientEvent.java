package com.github.L_Ender.cataclysm.client.event;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.gui.CustomBossBar;
import com.github.L_Ender.cataclysm.client.model.entity.PlayerSandstorm_Model;
import com.github.L_Ender.cataclysm.client.render.CMItemstackRenderer;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.etc.LavaVisionFluidRenderer;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemREnderer.Blazing_Grips_Renderer;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemREnderer.RendererSticky_Gloves;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Tongue_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.IHoldEntity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.lionfishapi.client.event.EventGetFluidRenderType;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import net.minecraft.Util;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.LiquidBlockRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FogType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import net.neoforged.neoforge.common.NeoForge;
import org.joml.Matrix4f;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

import java.util.Random;

public class ClientEvent {
    public static final ResourceLocation FLAME_STRIKE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/soul_flame_strike_sigil.png");
    private static boolean previousLavaVision = false;
    private static LiquidBlockRenderer previousFluidRenderer;
    private static final ResourceLocation SANDSTORM_ICON = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/gui/sandstorm_icons.png");
    private static final ResourceLocation EFFECT_HEART = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/gui/effect_heart.png");
    private static final ResourceLocation FLASH_OUT = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/gui/flash_out.png");
    private static final ResourceLocation SANDSTORM_TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/ancient_remnant/sandstorm.png");
    private static final PlayerSandstorm_Model SANDSTORM_MODEL = new PlayerSandstorm_Model();
    private final Random random = new Random();
    private int lastHealth;
    private int displayHealth;
    private long lastHealthTime;
    private long healthBlinkTime;

    private int leftHeight = 39;
    private int rightHeight = 39;


    public static void ClientEvent() {
        NeoForge.EVENT_BUS.addListener(ClientEvent::renderBossOverlay);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onCameraSetup);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onFogDensity);
        NeoForge.EVENT_BUS.addListener(ClientEvent::MovementInput);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onPreRenderHUD);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onPostRenderHUD);

        NeoForge.EVENT_BUS.addListener(ClientEvent::onPreRenderEntity);
        NeoForge.EVENT_BUS.addListener(ClientEvent::clientTick);
     //   NeoForge.EVENT_BUS.addListener(ClientEvent::onRenderWorldLastEvent);


        NeoForge.EVENT_BUS.addListener(ClientEvent::onGetFluidRenderType);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onPoseHand);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onRenderArm);
                
    }


    public static void onCameraSetup(ViewportEvent.ComputeCameraAngles event) {
        Player player = Minecraft.getInstance().player;
        float delta = Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);
        float ticksExistedDelta = player.tickCount + delta;
        if (CMConfig.ScreenShake && !Minecraft.getInstance().isPaused()) {
            if (player != null) {
                float shakeAmplitude = 0;
                for (ScreenShake_Entity ScreenShake : player.level().getEntitiesOfClass(ScreenShake_Entity.class, player.getBoundingBox().inflate(20, 20, 20))) {
                    if (ScreenShake.distanceTo(player) < ScreenShake.getRadius()) {
                        shakeAmplitude += ScreenShake.getShakeAmount(player, delta);
                    }
                }
                if (shakeAmplitude > 1.0f) shakeAmplitude = 1.0f;
                event.setPitch((float) (event.getPitch() + shakeAmplitude * Math.cos(ticksExistedDelta * 3 + 2) * 25));
                event.setYaw((float) (event.getYaw() + shakeAmplitude * Math.cos(ticksExistedDelta * 5 + 1) * 25));
                event.setRoll((float) (event.getRoll() + shakeAmplitude * Math.cos(ticksExistedDelta * 4) * 25));
            }

            if (Minecraft.getInstance().player.getEffect(ModEffect.EFFECTSTUN) != null) {
                MobEffectInstance effectinstance1 = Minecraft.getInstance().player.getEffect(ModEffect.EFFECTSTUN);
                float shakeAmplitude = (float) ((1 + effectinstance1.getAmplifier()) * 0.01);
                event.setPitch((float) (event.getPitch() + shakeAmplitude * Math.cos(ticksExistedDelta * 3 + 2) * 25));
                event.setYaw((float) (event.getYaw() + shakeAmplitude * Math.cos(ticksExistedDelta * 5 + 1) * 25));
                event.setRoll((float) (event.getRoll() + shakeAmplitude * Math.cos(ticksExistedDelta * 4) * 25));
            }
        }

        Entity cameraEntity = Minecraft.getInstance().getCameraEntity();
        if (cameraEntity != null && cameraEntity.isPassenger() && cameraEntity.getVehicle() instanceof Maledictus_Entity && event.getCamera().isDetached()) {
            event.getCamera().move(-event.getCamera().getMaxZoom(6F), 0, 0);
        }

        if (cameraEntity != null && cameraEntity.isPassenger() && cameraEntity.getVehicle() instanceof Aptrgangr_Entity && event.getCamera().isDetached()) {
            event.getCamera().move(-event.getCamera().getMaxZoom(3F), 0, 0);
        }

    }


   
    public static void onFogDensity(ViewportEvent.RenderFog event) {
        FogType fogType = event.getCamera().getFluidInCamera();
        ItemStack itemstack = Minecraft.getInstance().player.getInventory().getArmor(3);
        if (itemstack.is(ModItems.IGNITIUM_HELMET.get()) && fogType == FogType.LAVA) {
            RenderSystem.setShaderFogStart(-8.0F);
            RenderSystem.setShaderFogEnd(50.0F);
        }

    }


    public static void MovementInput(MovementInputUpdateEvent event) {
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            if (player.hasEffect(ModEffect.EFFECTCURSE_OF_DESERT)) {
                if (Minecraft.getInstance().options.keyDown.isDown()) {
                    event.getInput().forwardImpulse += 2F;
                }
                if (Minecraft.getInstance().options.keyLeft.isDown()) {
                    event.getInput().leftImpulse -= 2F;
                }
                if (Minecraft.getInstance().options.keyRight.isDown()) {
                    event.getInput().leftImpulse += 2F;
                }
                if (Minecraft.getInstance().options.keyUp.isDown()) {
                    event.getInput().forwardImpulse -= 2F;
                }
            }
        }
    }



    public static void onPreRenderHUD(RenderGuiLayerEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            Minecraft mc = Minecraft.getInstance();
            if (player.isPassenger()) {
                if (player.getVehicle() instanceof The_Leviathan_Tongue_Entity || player.getVehicle() instanceof IHoldEntity) {
                    if (VanillaGuiLayers.VEHICLE_HEALTH == event.getName()) {
                        Minecraft.getInstance().gui.setOverlayMessage(Component.translatable("entity.cataclysm.you_cant_escape"), false);
                    }
                }
            }

        }
    }



    public static void onPostRenderHUD(RenderGuiLayerEvent.Post event) {
        Player player = Minecraft.getInstance().player;
        float delta = Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);
        float screenEffectIntensity = Minecraft.getInstance().options.screenEffectScale().get().floatValue();
        float ticksExistedDelta = player.tickCount + delta;
        Minecraft mc = Minecraft.getInstance();
        if (player != null) {
            if (VanillaGuiLayers.AIR_LEVEL == event.getName() && !mc.options.hideGui && shouldDrawSurvivalElements()) {

            }
        }

        /*
        if (CMConfig.ScreenShake && !Minecraft.getInstance().isPaused()) {
            if (player != null) {

                float shakeAmplitude = 0;
                for (ScreenShake_Entity ScreenShake : player.level().getEntitiesOfClass(ScreenShake_Entity.class, player.getBoundingBox().inflate(20, 20, 20))) {
                    if (ScreenShake.distanceTo(player) < ScreenShake.getRadius()) {
                        shakeAmplitude += ScreenShake.getShakeAmount(player, delta);
                    }
                }
                if (shakeAmplitude > 1.0f) shakeAmplitude = 1.0f;

                Window window = mc.getWindow();
                GuiGraphics graphics = new GuiGraphics(mc, mc.renderBuffers().bufferSource());

                int prog = (int) (255 * shakeAmplitude);
                int white = (prog << 24) | 0xFFFFFF;
                graphics.fill(0, 0, window.getScreenWidth(), window.getScreenHeight(),  white);


            }


        }

         */
    }


    private static boolean shouldDrawSurvivalElements() {
        Minecraft mc = Minecraft.getInstance();
        return mc.gameMode.canHurtPlayer() && mc.getCameraEntity() instanceof Player;
    }


   
    public static void onPreRenderEntity(RenderLivingEvent.Pre event) {
        LivingEntity player = (LivingEntity) event.getEntity();
        boolean usingIncinerator = player.isUsingItem() && player.getUseItem().is(ModItems.THE_INCINERATOR.get());
        if(usingIncinerator){
            int i = player.getTicksUsingItem();
            float f2 = (float) player.tickCount + event.getPartialTick();
            PoseStack matrixStackIn = event.getPoseStack();
            float f3 = Mth.clamp(i, 1, 60);
            matrixStackIn.pushPose();
            VertexConsumer ivertexbuilder = ItemRenderer.getArmorFoilBuffer(event.getMultiBufferSource(),CMRenderTypes.getGlowingEffect(FLAME_STRIKE), true);
            matrixStackIn.translate(0.0D, 0.001, 0.0D);
            matrixStackIn.scale(f3 * 0.05f, f3 * 0.05f, f3 * 0.05f);
            matrixStackIn.mulPose(Axis.ZP.rotationDegrees(180.0F));
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0F + f2));
            PoseStack.Pose lvt_19_1_ = matrixStackIn.last();
           drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
           drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
           drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
          drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
            matrixStackIn.popPose();
        }


        if (ClientHooks.blockedEntityRenders.contains(event.getEntity().getUUID())) {
            if (!ClientHooks.isFirstPersonPlayer(event.getEntity())) {
                NeoForge.EVENT_BUS.post(new RenderLivingEvent.Post(event.getEntity(), event.getRenderer(), event.getPartialTick(), event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight()));
                event.setCanceled(true);
            }
            ClientHooks.blockedEntityRenders.remove(event.getEntity().getUUID());
        }

    }


   
    public static void onPreRenderPlayer(RenderPlayerEvent.Pre event) {

    }

    public static void drawVertex( PoseStack.Pose p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.addVertex(p_229039_2_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).setColor(255, 255, 255, 255).setUv(p_229039_7_, p_229039_8_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_229039_12_).setNormal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_);
    }



    public static void clientTick(ClientTickEvent.Post event) {
        CMItemstackRenderer.incrementTick();
    }

    private static void updateAllChunks() {
        if (Minecraft.getInstance().levelRenderer.viewArea != null) {
            int length = Minecraft.getInstance().levelRenderer.viewArea.sections.length;
            for (int i = 0; i < length; i++) {
                Minecraft.getInstance().levelRenderer.viewArea.sections[i].setDirty(true);
            }
        }
    }


   
    public static void onRenderWorldLastEvent(RenderLevelStageEvent event) {
        if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_SKY) {
            if (!CMConfig.shadersCompat) {
                ItemStack itemstack = Minecraft.getInstance().player.getInventory().getArmor(3);
                if (itemstack.is(ModItems.IGNITIUM_HELMET.get())) {
                    if (!previousLavaVision) {
                        previousFluidRenderer = Minecraft.getInstance().getBlockRenderer().liquidBlockRenderer;
                        Minecraft.getInstance().getBlockRenderer().liquidBlockRenderer = new LavaVisionFluidRenderer();
                        updateAllChunks();
                    }
                } else {
                    if (previousLavaVision) {
                        if (previousFluidRenderer != null) {
                            Minecraft.getInstance().getBlockRenderer().liquidBlockRenderer = previousFluidRenderer;
                        }
                        updateAllChunks();
                    }
                }
                previousLavaVision = itemstack.is(ModItems.IGNITIUM_HELMET.get());
            }
        }
    }


   
    public static void onGetFluidRenderType(EventGetFluidRenderType event) {
        if (Minecraft.getInstance().player.getInventory().getArmor(3).is(ModItems.IGNITIUM_HELMET.get()) && (event.getFluidState().is(Fluids.LAVA) || event.getFluidState().is(Fluids.FLOWING_LAVA))) {
            event.setRenderType(RenderType.translucent());
            event.setResult(EventGetFluidRenderType.Result.ALLOW);
        }
    }


   
    public static void onPoseHand(EventPosePlayerHand event) {
        LivingEntity player = (LivingEntity) event.getEntityIn();
        if (player.getItemInHand(InteractionHand.OFF_HAND).is(ModItems.THE_ANNIHILATOR.get()) && player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.THE_ANNIHILATOR.get()) && player.isUsingItem()){
            if (player.getMainArm() == HumanoidArm.LEFT) {
                event.getModel().rightArm.xRot = event.getModel().rightArm.xRot * 0.5F - 3.1415927F;
                event.getModel().rightArm.yRot = 0.0F;
            } else {
                event.getModel().leftArm.xRot = event.getModel().leftArm.xRot * 0.5F - 3.1415927F;
                event.getModel().leftArm.yRot = 0.0F;

                
            }
        }
        if (player.getItemInHand(InteractionHand.OFF_HAND).is(ModItems.THE_IMMOLATOR.get()) && player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.THE_IMMOLATOR.get()) && player.isUsingItem()){
            if (player.getMainArm() == HumanoidArm.LEFT) {
                event.getModel().rightArm.xRot = event.getModel().rightArm.xRot * 0.5F - 3.1415927F;
                event.getModel().rightArm.yRot = 0.0F;
            } else {
                event.getModel().leftArm.xRot = event.getModel().leftArm.xRot * 0.5F - 3.1415927F;
                event.getModel().leftArm.yRot = 0.0F;
            }
        }

    }


   
    public static void onRenderArm(RenderArmEvent event) {
        InteractionHand hand = event.getArm() == event.getPlayer().getMainArm() ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        CuriosApi.getCuriosHelper().getCuriosHandler(event.getPlayer()).ifPresent(handler -> {
            ICurioStacksHandler stacksHandler = handler.getCurios().get(SlotTypePreset.HANDS.getIdentifier());
            if (stacksHandler != null) {
                IDynamicStackHandler stacks = stacksHandler.getStacks();
                IDynamicStackHandler cosmeticStacks = stacksHandler.getCosmeticStacks();

                for (int slot = hand == InteractionHand.MAIN_HAND ? 0 : 1; slot < stacks.getSlots(); slot += 2) {
                    ItemStack stack = cosmeticStacks.getStackInSlot(slot);
                    if (stack.isEmpty() && stacksHandler.getRenders().get(slot)) {
                        stack = stacks.getStackInSlot(slot);
                    }

                    Blazing_Grips_Renderer gripsrenderer = Blazing_Grips_Renderer.getGloveRenderer(stack);
                    if (gripsrenderer != null) {
                        gripsrenderer.renderFirstPersonArm(event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight(), event.getPlayer(), event.getArm(), stack.hasFoil());
                    }
                    RendererSticky_Gloves stickyrenderer = RendererSticky_Gloves.getGloveRenderer(stack);
                    if (stickyrenderer != null) {
                        stickyrenderer.renderFirstPersonArm(event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight(), event.getPlayer(), event.getArm(), stack.hasFoil());
                    }
                }
            }
        });
    }


    private void CustomHealth(RenderGuiLayerEvent.Pre event,int back){
        Player player = Minecraft.getInstance().player;
        Minecraft mc = Minecraft.getInstance();
        Gui gui = mc.gui;
        GuiGraphics stack = event.getGuiGraphics();
        setupOverlayRenderState(true, false);
        int width = stack.guiWidth();
        int height = stack.guiHeight();
        event.setCanceled(true);
        RenderSystem.setShaderTexture(0, EFFECT_HEART);
        RenderSystem.enableBlend();
        int health = Mth.ceil(player.getHealth());
        int tickCount = gui.getGuiTicks();
        boolean highlight = this.healthBlinkTime > (long) tickCount && (this.healthBlinkTime - (long) tickCount) / 3L % 2L == 1L;
        if (health < this.lastHealth && player.invulnerableTime > 0) {
            this.lastHealthTime = Util.getMillis();
            this.healthBlinkTime = (long) (tickCount + 20);
        } else if (health > this.lastHealth && player.invulnerableTime > 0) {
            this.lastHealthTime = Util.getMillis();
            this.healthBlinkTime = (long) (tickCount + 10);
        }

        if (Util.getMillis() - this.lastHealthTime > 1000L) {
            this.lastHealth = health;
            this.displayHealth = health;
            this.lastHealthTime = Util.getMillis();
        }

        this.lastHealth = health;
        int healthLast = this.displayHealth;
        AttributeInstance maxHealth = player.getAttribute(Attributes.MAX_HEALTH);
        float healthMax = (float) maxHealth.getValue();
        int absorbtion = Mth.ceil(player.getAbsorptionAmount());
        int healthRows = Mth.ceil((healthMax + (float) absorbtion) / 2.0F / 10.0F);
        int rowHeight = Math.max(10 - (healthRows - 2), 3);
        this.random.setSeed((long) (tickCount * 312871L));
        int left = width / 2 - 91;
        int top = height - leftHeight;
        leftHeight += healthRows * rowHeight;
        if (rowHeight != 10) {
           leftHeight += 10 - rowHeight;
        }

        int regen = -1;
        if (player.hasEffect(MobEffects.REGENERATION)) {
            regen = tickCount % Mth.ceil(healthMax + 5.0F);
        }

        int TOP = player.level().getLevelData().isHardcore() ? 9 : 0;
        int BACKGROUND = highlight ? back : 16;
        int margin = 34;
        float absorbtionRemaining = (float) absorbtion;

        for (int i = Mth.ceil((healthMax + (float) absorbtion) / 2.0F) - 1; i >= 0; --i) {
            int row = Mth.ceil((float) (i + 1) / 10.0F) - 1;
            int x = left + i % 10 * 8;
            int y = top - row * rowHeight;
            if (health <= 4) {
                y += this.random.nextInt(2);
            }

            if (i == regen) {
                y -= 2;
            }

            stack.blit(EFFECT_HEART, x, y, BACKGROUND, TOP, 9, 9);
            if (highlight) {
                if (i * 2 + 1 < healthLast) {
                    stack.blit(EFFECT_HEART, x, y, margin, TOP, 9, 9);
                } else if (i * 2 + 1 == healthLast) {
                    stack.blit(EFFECT_HEART, x, y, margin + 9, TOP, 9, 9);
                }
            }

            if (absorbtionRemaining > 0.0F) {
                if (absorbtionRemaining == (float) absorbtion && (float) absorbtion % 2.0F == 1.0F) {
                    stack.blit(EFFECT_HEART, x, y, margin + 9, TOP, 9, 9);
                    --absorbtionRemaining;
                } else {
                    stack.blit(EFFECT_HEART, x, y, margin, TOP, 9, 9);
                    absorbtionRemaining -= 2.0F;
                }
            } else if (i * 2 + 1 < health) {
                stack.blit(EFFECT_HEART, x, y, margin, TOP, 9, 9);
            } else if (i * 2 + 1 == health) {
                stack.blit(EFFECT_HEART, x, y, margin + 9, TOP, 9, 9);
            }
        }

        RenderSystem.disableBlend();
        RenderSystem.setShaderTexture(0, EFFECT_HEART);
    }

    public static void setupOverlayRenderState(boolean blend, boolean depthTest) {
        if (blend)
        {
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
        }
        else
        {
            RenderSystem.disableBlend();
        }

        if (depthTest)
        {
            RenderSystem.enableDepthTest();
        }
        else
        {
            RenderSystem.disableDepthTest();
        }

        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
    }


    private static void renderBossOverlay(CustomizeGuiOverlayEvent.BossEventProgress event){

        if(CMConfig.custombossbar) {
            if (ClientHooks.bossBarRenderTypes.containsKey(event.getBossEvent().getId())) {
                int renderTypeFor = ClientHooks.bossBarRenderTypes.get(event.getBossEvent().getId());

                CustomBossBar customBossBar = CustomBossBar.customBossBars.getOrDefault(renderTypeFor, null);
                if (customBossBar == null) return;

                event.setCanceled(true);
                customBossBar.renderBossBar(event);
            }
        }


    }
}
