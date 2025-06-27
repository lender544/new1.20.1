package com.github.L_Ender.cataclysm.client.event;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.ClientProxy;
import com.github.L_Ender.cataclysm.client.gui.CustomBossBar;
import com.github.L_Ender.cataclysm.client.model.entity.PlayerSandstorm_Model;
import com.github.L_Ender.cataclysm.client.render.CMItemstackRenderer;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemRenderer.Blazing_Grips_Renderer;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemRenderer.Chitin_Claw_Renderer;
import com.github.L_Ender.cataclysm.client.render.item.CuriosItemRenderer.RendererSticky_Gloves;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Tongue_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.IHoldEntity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.LiquidBlockRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class ClientEvent {
    public static final ResourceLocation FLAME_STRIKE = new ResourceLocation(Cataclysm.MODID,"textures/entity/soul_flame_strike_sigil.png");
    public static final ResourceLocation NORMAL_FLAME_STRIKE = new ResourceLocation(Cataclysm.MODID,"textures/entity/flame_strike_sigil.png");
    private boolean previousLavaVision = false;
    private LiquidBlockRenderer previousFluidRenderer;
    private static final ResourceLocation SANDSTORM_ICON = new ResourceLocation(Cataclysm.MODID,"textures/gui/sandstorm_icons.png");
    private static final ResourceLocation EFFECT_HEART = new ResourceLocation(Cataclysm.MODID,"textures/gui/effect_heart.png");
    private static final ResourceLocation SANDSTORM_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/entity/ancient_remnant/sandstorm.png");
    private static final PlayerSandstorm_Model SANDSTORM_MODEL = new PlayerSandstorm_Model();
    private final Random random = new Random();
    private int lastHealth;
    private int displayHealth;
    private long lastHealthTime;
    private long healthBlinkTime;

    @SubscribeEvent
    public void onCameraSetup(ViewportEvent.ComputeCameraAngles event) {
        Player player = Minecraft.getInstance().player;
        float delta = Minecraft.getInstance().getFrameTime();
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

            if (Minecraft.getInstance().player.getEffect(ModEffect.EFFECTSTUN.get()) != null) {
                MobEffectInstance effectinstance1 = Minecraft.getInstance().player.getEffect(ModEffect.EFFECTSTUN.get());
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



    @SubscribeEvent
    public void MovementInput(MovementInputUpdateEvent event) {
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            if (player.hasEffect(ModEffect.EFFECTCURSE_OF_DESERT.get())) {
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

    @SubscribeEvent
    public void onPreRenderHUD(RenderGuiOverlayEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            Minecraft mc = Minecraft.getInstance();
            ForgeGui gui = (ForgeGui)mc.gui;
            if (player.isPassenger()) {
                if (player.getVehicle() instanceof The_Leviathan_Tongue_Entity || player.getVehicle() instanceof IHoldEntity) {
                    if (event.getOverlay().id().equals(VanillaGuiOverlay.HELMET.id())) {
                        Minecraft.getInstance().gui.setOverlayMessage(Component.translatable("entity.cataclysm.you_cant_escape"), false);
                    }
                }
            }
            if (event.getOverlay() == VanillaGuiOverlay.PLAYER_HEALTH.type() && !mc.options.hideGui && gui.shouldDrawSurvivalElements()) {
                if (player.hasEffect(ModEffect.EFFECTABYSSAL_BURN.get()) || player.hasEffect(ModEffect.EFFECTABYSSAL_CURSE.get())) {
                    CustomHealth(event, 25);
                }
            }
        }
    }

    @SubscribeEvent
    public void onPostRenderHUD(RenderGuiOverlayEvent.Post event) {
        Player player = Minecraft.getInstance().player;
    }


    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onPreRenderEntity(RenderLivingEvent.Pre event) {
        LivingEntity player = (LivingEntity) event.getEntity();
        boolean usingIncinerator = player.isUsingItem() && (player.getUseItem().is(ModItems.THE_INCINERATOR.get()));
        boolean usingImmolator = player.isUsingItem() && player.getUseItem().is(ModItems.THE_IMMOLATOR.get());
        if(usingIncinerator){
            int i = player.getTicksUsingItem();
            float f2 = (float) player.tickCount + event.getPartialTick();
            PoseStack matrixStackIn = event.getPoseStack();
            float f3 = Mth.clamp(i, 1, 60);
            matrixStackIn.pushPose();
            VertexConsumer ivertexbuilder = ItemRenderer.getArmorFoilBuffer(event.getMultiBufferSource(),RenderType.entityTranslucentEmissive(FLAME_STRIKE),false, true);
            matrixStackIn.translate(0.0D, 0.001, 0.0D);
            matrixStackIn.scale(f3 * 0.05f, f3 * 0.05f, f3 * 0.05f);
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0F + f2));
            PoseStack.Pose lvt_19_1_ = matrixStackIn.last();
            Matrix4f lvt_20_1_ = lvt_19_1_.pose();
            Matrix3f lvt_21_1_ = lvt_19_1_.normal();
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
            matrixStackIn.popPose();
        }

        if(usingImmolator){
            int i = player.getTicksUsingItem();
            float f2 = (float) player.tickCount + event.getPartialTick();
            PoseStack matrixStackIn = event.getPoseStack();
            float f3 = Mth.clamp(i, 1, 45);
            matrixStackIn.pushPose();
            VertexConsumer ivertexbuilder = ItemRenderer.getArmorFoilBuffer(event.getMultiBufferSource(),RenderType.entityTranslucentEmissive(NORMAL_FLAME_STRIKE),false, true);
            matrixStackIn.translate(0.0D, 0.001, 0.0D);
            matrixStackIn.scale(f3 * 0.05f, f3 * 0.05f, f3 * 0.05f);
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0F + f2));
            PoseStack.Pose lvt_19_1_ = matrixStackIn.last();
            Matrix4f lvt_20_1_ = lvt_19_1_.pose();
            Matrix3f lvt_21_1_ = lvt_19_1_.normal();
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
            matrixStackIn.popPose();
        }

        if (ClientProxy.blockedEntityRenders.contains(event.getEntity().getUUID())) {
            if (!Cataclysm.PROXY.isFirstPersonPlayer(event.getEntity())) {
                MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Post(event.getEntity(), event.getRenderer(), event.getPartialTick(), event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight()));
                event.setCanceled(true);
            }
            ClientProxy.blockedEntityRenders.remove(event.getEntity().getUUID());
        }

    }



    public void drawVertex(Matrix4f p_229039_1_, Matrix3f p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.vertex(p_229039_1_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).color(255, 255, 255, 255).uv(p_229039_7_, p_229039_8_).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(p_229039_12_).normal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_).endVertex();
    }

    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            CMItemstackRenderer.incrementTick();
        }

    }

    private void updateAllChunks() {
        if (Minecraft.getInstance().levelRenderer.viewArea != null) {
            int length = Minecraft.getInstance().levelRenderer.viewArea.chunks.length;
            for (int i = 0; i < length; i++) {
                Minecraft.getInstance().levelRenderer.viewArea.chunks[i].dirty = true;
            }
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onPoseHand(EventPosePlayerHand event) {
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
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onRenderArm(RenderArmEvent event) {
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
                    Chitin_Claw_Renderer clawrenderer = Chitin_Claw_Renderer.getGloveRenderer(stack);
                    if (clawrenderer != null) {
                        clawrenderer.renderFirstPersonArm(event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight(), event.getPlayer(), event.getArm(), stack.hasFoil());
                    }
                }
            }
        });
    }


    private void CustomHealth(RenderGuiOverlayEvent.Pre event,int back){
        Player player = Minecraft.getInstance().player;
        Minecraft mc = Minecraft.getInstance();
        ForgeGui gui = (ForgeGui)mc.gui;
        GuiGraphics stack = event.getGuiGraphics();
        gui.setupOverlayRenderState(true, false);
        int width = event.getWindow().getGuiScaledWidth();
        int height = event.getWindow().getGuiScaledHeight();
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
        int top = height - gui.leftHeight;
        gui.leftHeight += healthRows * rowHeight;
        if (rowHeight != 10) {
            gui.leftHeight += 10 - rowHeight;
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

    /**
    private void renderSandstormOverlay(RenderGuiOverlayEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        Minecraft mc = Minecraft.getInstance();
        ForgeGui gui = (ForgeGui) mc.gui;
        GuiGraphics stack = event.getGuiGraphics();
        gui.setupOverlayRenderState(true, false);
        int width = event.getWindow().getGuiScaledWidth();
        int height = event.getWindow().getGuiScaledHeight();
        if ((minecraft.getCameraEntity() instanceof LivingEntity player)) {
            Gone_With_SandstormCapability.IGone_With_SandstormCapability SandstormCapability = ModCapabilities.getCapability(player, ModCapabilities.GONE_WITH_SANDSTORM_CAPABILITY);
            if (SandstormCapability != null) {
                int left = width / 2 + 91;
                int top = height - gui.rightHeight;

                int flytime = Math.abs(SandstormCapability.getSandstormTimer());
                int maxProgressTime = CMConfig.Sandstorm_In_A_Bottle_Timer;

                if (flytime == 0) {
                    return;
                }

                float progress = 1 - flytime / (float) maxProgressTime;

                int full = Mth.ceil((progress - 2D / maxProgressTime) * 10);
                int partial = Mth.ceil(progress * 10) - full;

                for (int i = 0; i < full + partial; ++i) {
                    stack.blit(SANDSTORM_ICON, left - i * 8 - 9, top, -90, (i < full ? 0 : 9), 0, 9, 9, 32, 16);
                }
                gui.rightHeight += 10;

                RenderSystem.disableBlend();
            }
        }
    }
     */


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void renderBossOverlay(CustomizeGuiOverlayEvent.BossEventProgress event){
        if(CMConfig.custombossbar) {
            if (ClientProxy.bossBarRenderTypes.containsKey(event.getBossEvent().getId())) {
                int renderTypeFor = ClientProxy.bossBarRenderTypes.get(event.getBossEvent().getId());

                CustomBossBar customBossBar = CustomBossBar.customBossBars.getOrDefault(renderTypeFor, null);
                if (customBossBar == null) return;

                event.setCanceled(true);
                customBossBar.renderBossBar(event);
            }
        }
    }
}
