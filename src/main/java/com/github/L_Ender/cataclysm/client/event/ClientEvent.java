package com.github.L_Ender.cataclysm.client.event;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.ClientProxy;
import com.github.L_Ender.cataclysm.capabilities.Bloom_Stone_PauldronsCapability;
import com.github.L_Ender.cataclysm.capabilities.Gone_With_SandstormCapability;
import com.github.L_Ender.cataclysm.client.model.entity.Model_PlayerSandstorm;
import com.github.L_Ender.cataclysm.client.render.CMItemstackRenderer;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.etc.LavaVisionFluidRenderer;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Tongue_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Hold_Attack_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.lionfishapi.client.event.EventGetFluidRenderType;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FogType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class ClientEvent {
    public static final ResourceLocation FLAME_STRIKE = new ResourceLocation("cataclysm:textures/entity/soul_flame_strike_sigil.png");
    private boolean previousLavaVision = false;
    private LiquidBlockRenderer previousFluidRenderer;
    private static final ResourceLocation SANDSTORM_ICON = new ResourceLocation("cataclysm:textures/gui/sandstorm_icons.png");
    private static final ResourceLocation EFFECT_HEART = new ResourceLocation("cataclysm:textures/gui/effect_heart.png");
    private static final ResourceLocation SANDSTORM_TEXTURE = new ResourceLocation("cataclysm:textures/entity/ancient_remnant/sandstorm.png");
    protected static final ResourceLocation BOSS_BAR_HUD_OVERLAYSTEXTURE = new ResourceLocation(Cataclysm.MODID, "textures/gui/boss_bar_frames.png");
    private static final ResourceLocation GUI_BARS_LOCATION = new ResourceLocation(Cataclysm.MODID, "textures/gui/boss_bar.png");
    private static final Model_PlayerSandstorm SANDSTORM_MODEL = new Model_PlayerSandstorm();
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

    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onFogDensity(ViewportEvent.RenderFog event) {
        FogType fogType = event.getCamera().getFluidInCamera();
        ItemStack itemstack = Minecraft.getInstance().player.getInventory().getArmor(3);
        if (itemstack.is(ModItems.IGNITIUM_HELMET.get()) && fogType == FogType.LAVA) {
            RenderSystem.setShaderFogStart(-8.0F);
            RenderSystem.setShaderFogEnd(50.0F);
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
                if (player.getVehicle() instanceof The_Leviathan_Tongue_Entity || player.getVehicle() instanceof Hold_Attack_Entity) {
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
        if (player != null) {
            Minecraft mc = Minecraft.getInstance();
            ForgeGui gui = (ForgeGui)mc.gui;
            if (event.getOverlay() == VanillaGuiOverlay.AIR_LEVEL.type() && !mc.options.hideGui && gui.shouldDrawSurvivalElements()) {
                renderSandstormOverlay(event);
            }
        }
    }


    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onPreRenderEntity(RenderLivingEvent.Pre event) {
        LivingEntity player = (LivingEntity) event.getEntity();
        boolean usingIncinerator = player.isUsingItem() && player.getUseItem().is(ModItems.THE_INCINERATOR.get());
        Gone_With_SandstormCapability.IGone_With_SandstormCapability SandstormCapability = ModCapabilities.getCapability(player, ModCapabilities.GONE_WITH_SANDSTORM_CAPABILITY);
        if (SandstormCapability != null) {
            if(SandstormCapability.isSandstorm()){
                event.setCanceled(true);
                event.getPoseStack().pushPose();
                float limbSwing = event.getEntity().walkAnimation.position() - event.getEntity().walkAnimation.speed() * (1.0F - event.getPartialTick());
                float limbSwingAmount = event.getEntity().walkAnimation.speed(event.getPackedLight());
                VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(event.getMultiBufferSource(), RenderType.armorCutoutNoCull(SANDSTORM_TEXTURE), false, event.getEntity().getItemBySlot(EquipmentSlot.CHEST).hasFoil());
                event.getPoseStack().translate(0.0D, event.getEntity().getBbHeight(), 0.0D);
                event.getPoseStack().mulPose(Axis.ZP.rotationDegrees(180.0F));
                SANDSTORM_MODEL.setupAnim(event.getEntity(), limbSwing, limbSwingAmount, event.getEntity().tickCount + event.getPartialTick(), 0, 0);
                SANDSTORM_MODEL.renderToBuffer(event.getPoseStack(), vertexconsumer, event.getPackedLight(), OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
                event.getPoseStack().popPose();
                MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Post(event.getEntity(), event.getRenderer(), event.getPartialTick(), event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight()));
                return;
            }
        }
        if(usingIncinerator){
            int i = player.getTicksUsingItem();
            float f2 = (float) player.tickCount + event.getPartialTick();
            PoseStack matrixStackIn = event.getPoseStack();
            float f3 = Mth.clamp(i, 1, 60);
            matrixStackIn.pushPose();
            VertexConsumer ivertexbuilder = ItemRenderer.getArmorFoilBuffer(event.getMultiBufferSource(),CMRenderTypes.getGlowingEffect(FLAME_STRIKE),false, true);
            matrixStackIn.translate(0.0D, 0.001, 0.0D);
            matrixStackIn.scale(f3 * 0.05f, f3 * 0.05f, f3 * 0.05f);
            matrixStackIn.mulPose(Axis.ZP.rotationDegrees(180.0F));
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
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onPreRenderPlayer(RenderPlayerEvent.Pre event) {
        Player player = event.getEntity();
        Bloom_Stone_PauldronsCapability.IBloom_Stone_PauldronsCapability chargeCapability = ModCapabilities.getCapability(player, ModCapabilities.BLOOM_STONE_PAULDRONS_CAPABILITY_CAPABILITY);
        Gone_With_SandstormCapability.IGone_With_SandstormCapability SandstormCapability = ModCapabilities.getCapability(player, ModCapabilities.GONE_WITH_SANDSTORM_CAPABILITY);
        if (SandstormCapability != null) {
            if (SandstormCapability.isSandstorm()) {
                return;
            }
        }
        if (chargeCapability != null) {
            if(chargeCapability.isBurrow()) {
                event.getPoseStack().pushPose();
                event.getPoseStack().translate(0.0D, -event.getEntity().getBbHeight(), 0.0D);
            }
        }

    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onPostRenderPlayer(RenderPlayerEvent.Post event) {
        Player player = event.getEntity();
        Bloom_Stone_PauldronsCapability.IBloom_Stone_PauldronsCapability chargeCapability = ModCapabilities.getCapability(player, ModCapabilities.BLOOM_STONE_PAULDRONS_CAPABILITY_CAPABILITY);
        if (chargeCapability != null) {
            if(chargeCapability.isBurrow()) {
                event.getPoseStack().popPose();
            }
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
    public void onRenderWorldLastEvent(RenderLevelStageEvent event) {
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

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onGetFluidRenderType(EventGetFluidRenderType event) {
        if (Minecraft.getInstance().player.getInventory().getArmor(3).is(ModItems.IGNITIUM_HELMET.get()) && (event.getFluidState().is(Fluids.LAVA) || event.getFluidState().is(Fluids.FLOWING_LAVA))) {
            event.setRenderType(RenderType.translucent());
            event.setResult(Event.Result.ALLOW);
        }
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


    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void renderBossOverlay(CustomizeGuiOverlayEvent.BossEventProgress event){
        if(CMConfig.custombossbar) {
            if (ClientProxy.bossBarRenderTypes.containsKey(event.getBossEvent().getId())) {
                int renderTypeFor = ClientProxy.bossBarRenderTypes.get(event.getBossEvent().getId());
                int g = event.getGuiGraphics().guiWidth();
                int pX = g / 2 - 94;
                int pY = event.getY() - 2;
                Component component = event.getBossEvent().getName();
                int i = (int) (event.getBossEvent().getProgress() * 182.0F);
                int l = Minecraft.getInstance().font.width(component);
                //N.M
                if (renderTypeFor == 0) {
                    event.setCanceled(true);
                    event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 2, 0, 0, 182, 5, 256, 256);
                    if (i > 0) {
                        event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 3, 0, 6, i, 5, 256, 256);
                    }
                    event.getGuiGraphics().blit(BOSS_BAR_HUD_OVERLAYSTEXTURE, pX, pY, 0, 0, 188, 9, 256, 256);
                    int i1 = g / 2 - l / 2;
                    int j1 = pY - 9;
                    PoseStack poseStack = event.getGuiGraphics().pose();
                    poseStack.pushPose();
                    poseStack.translate(i1, j1, 0);
                    Minecraft.getInstance().font.drawInBatch8xOutline(component.getVisualOrderText(), 0.0F, 0.0F, 0Xec3500, 0X3c3947, poseStack.last().pose(), event.getGuiGraphics().bufferSource(), 240);
                    poseStack.popPose();
                    event.setIncrement(event.getIncrement() + 7);
                }
                //E.G
                if (renderTypeFor == 1) {
                    event.setCanceled(true);
                    event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 2, 0, 10, 182, 5, 256, 256);
                    if (i > 0) {
                        event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 3, 0, 16, i, 5, 256, 256);
                    }
                    event.getGuiGraphics().blit(BOSS_BAR_HUD_OVERLAYSTEXTURE, pX, pY, 0, 9, 188, 9, 256, 256);
                    int i1 = g / 2 - l / 2;
                    int j1 = pY - 9;
                    PoseStack poseStack = event.getGuiGraphics().pose();
                    poseStack.pushPose();
                    poseStack.translate(i1, j1, 0);
                    Minecraft.getInstance().font.drawInBatch8xOutline(component.getVisualOrderText(), 0.0F, 0.0F, 0Xa472a3,0X754576, poseStack.last().pose(), event.getGuiGraphics().bufferSource(), 240);
                    poseStack.popPose();
                    event.setIncrement(event.getIncrement() + 7);
                }
                //Ignis 1 Phase
                if (renderTypeFor == 2) {
                    event.setCanceled(true);

                    event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 2, 0, 30, 182, 5, 256, 256);
                    if (i > 0) {
                        event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 3, 0, 36, i, 5, 256, 256);
                    }
                    event.getGuiGraphics().blit(BOSS_BAR_HUD_OVERLAYSTEXTURE, pX, pY, 0, 27, 188, 9, 256, 256);

                    int i1 = g / 2 - l / 2;
                    int j1 = pY - 9;
                    PoseStack poseStack = event.getGuiGraphics().pose();
                    poseStack.pushPose();
                    poseStack.translate(i1, j1, 0);
                    Minecraft.getInstance().font.drawInBatch8xOutline(component.getVisualOrderText(), 0.0F, 0.0F, 0Xe9ec00,0X733b45, poseStack.last().pose(), event.getGuiGraphics().bufferSource(), 240);
                    poseStack.popPose();
                    event.setIncrement(event.getIncrement() + 7);
                }
                //Ignis 2,3 Phase
                if (renderTypeFor == 3) {
                    event.setCanceled(true);

                    event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 2, 0, 39, 182, 5, 256, 256);
                    if (i > 0) {
                        event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 3, 0, 45, i, 5, 256, 256);
                    }
                    event.getGuiGraphics().blit(BOSS_BAR_HUD_OVERLAYSTEXTURE, pX, pY, 0, 36, 188, 9, 256, 256);

                    int i1 = g / 2 - l / 2;
                    int j1 = pY - 9;
                    PoseStack poseStack = event.getGuiGraphics().pose();
                    poseStack.pushPose();
                    poseStack.translate(i1, j1, 0);
                    Minecraft.getInstance().font.drawInBatch8xOutline(component.getVisualOrderText(), 0.0F, 0.0F, 0X00b7ec,0X003a4a, poseStack.last().pose(), event.getGuiGraphics().bufferSource(), 240);
                    poseStack.popPose();
                    event.setIncrement(event.getIncrement() + 7);
                }
                //Harbinger
                if (renderTypeFor == 4) {
                    event.setCanceled(true);

                    event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 2, 0, 20, 182, 5, 256, 256);
                    if (i > 0) {
                        event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 3, 0, 26, i, 5, 256, 256);
                    }
                    event.getGuiGraphics().blit(BOSS_BAR_HUD_OVERLAYSTEXTURE, pX, pY, 0, 18, 188, 9, 256, 256);

                    int i1 = g / 2 - l / 2;
                    int j1 = pY - 9;
                    PoseStack poseStack = event.getGuiGraphics().pose();
                    poseStack.pushPose();
                    poseStack.translate(i1, j1, 0);
                    Minecraft.getInstance().font.drawInBatch8xOutline(component.getVisualOrderText(), 0.0F, 0.0F, 0Xec3500, 0X1e2021, poseStack.last().pose(), event.getGuiGraphics().bufferSource(), 240);
                    poseStack.popPose();
                    event.setIncrement(event.getIncrement() + 7);
                }
                //Leviathan 1
                if (renderTypeFor == 5) {
                    event.setCanceled(true);
                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                    event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 5, 0, 50, 182, 5, 256, 256);
                    if (i > 0) {
                        event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 6, 0, 56, (int) i, 5, 256, 256);
                    }
                    event.getGuiGraphics().blit(BOSS_BAR_HUD_OVERLAYSTEXTURE, pX, pY, 0, 45, 188, 13, 256, 256);


                    int i1 = g / 2 - l / 2;
                    int j1 = pY - 9;
                    PoseStack poseStack = event.getGuiGraphics().pose();
                    poseStack.pushPose();
                    poseStack.translate(i1, j1, 0);
                    Minecraft.getInstance().font.drawInBatch8xOutline(component.getVisualOrderText(), 0.0F, 0.0F, 0X7b00ec, 0X26004a, poseStack.last().pose(), event.getGuiGraphics().bufferSource(), 240);
                    poseStack.popPose();
                    event.setIncrement(event.getIncrement() + 7);
                }
                //Leviathan 2
                if (renderTypeFor == 6) {
                    event.setCanceled(true);
                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                    event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 6, 0, 50, 182, 5, 256, 256);
                    if (i > 0) {
                        event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 7, 0, 56, i, 5, 256, 256);
                    }
                    event.getGuiGraphics().blit(BOSS_BAR_HUD_OVERLAYSTEXTURE, pX, pY, 0, 62, 188, 16, 256, 256);
                    int i1 = g / 2 - l / 2;
                    int j1 = pY - 9;
                    PoseStack poseStack = event.getGuiGraphics().pose();
                    poseStack.pushPose();
                    poseStack.translate(i1, j1, 0);
                    Minecraft.getInstance().font.drawInBatch8xOutline(component.getVisualOrderText(), 0.0F, 0.0F, 0X7b00ec, 0X26004a, poseStack.last().pose(), event.getGuiGraphics().bufferSource(), 240);
                    poseStack.popPose();
                    event.setIncrement(event.getIncrement() + 7);
                }
                //Remnant
                if (renderTypeFor == 7) {
                    event.setCanceled(true);
                    event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 10, 0, 60, 182, 5, 256, 256);
                    if (i > 0) {
                        event.getGuiGraphics().blit(GUI_BARS_LOCATION, pX + 3, pY + 11, 0, 66, i, 5, 256, 256);
                    }
                    event.getGuiGraphics().blit(BOSS_BAR_HUD_OVERLAYSTEXTURE, pX, pY, 0, 79, 188, 26, 256, 256);
                    int i1 = g / 2 - l / 2;
                    int j1 = pY - 9;
                    PoseStack poseStack = event.getGuiGraphics().pose();
                    poseStack.pushPose();
                    poseStack.translate(i1, j1, 0);
                    Minecraft.getInstance().font.drawInBatch8xOutline(component.getVisualOrderText(), 0.0F, 0.0F, 0Xececec,0X682e22, poseStack.last().pose(), event.getGuiGraphics().bufferSource(), 240);
                    poseStack.popPose();
                    event.setIncrement(event.getIncrement() + 12);
                }
            }
        }
    }
}
