package com.github.L_Ender.cataclysm.client.render.item.CuriosItemREnderer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.item.CuriosModel.Chitin_Claw_Model;
import com.github.L_Ender.cataclysm.client.model.item.CuriosModel.Sticky_Gloves_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import top.theillusivec4.curios.api.client.ICurioRenderer;

import javax.annotation.Nullable;

public class Chitin_Claw_Renderer implements ICurioRenderer {
    private final Chitin_Claw_Model model;


    private final Chitin_Claw_Model slimModel;
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/curiositem/chitin_claw.png");

    public Chitin_Claw_Renderer() {
        this.model = new Chitin_Claw_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.CHITIN_CLAW_MODEL));
        this.slimModel = new Chitin_Claw_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.CHITIN_CLAW_SLIM_MODEL));
    }

    @Nullable
    public static Chitin_Claw_Renderer getGloveRenderer(ItemStack stack) {
        if (!stack.isEmpty()) {
            return CuriosRendererRegistry.getRenderer(stack.getItem())
                    .filter(Chitin_Claw_Renderer.class::isInstance)
                    .map(Chitin_Claw_Renderer.class::cast)
                    .orElse(null);
        }
        return null;
    }

    protected Chitin_Claw_Model getModel(boolean hasSlimArms) {
        return hasSlimArms ? slimModel : model;
    }

    protected static boolean hasSlimArms(Entity entity) {
        return entity instanceof AbstractClientPlayer player && player.getSkin().model() == PlayerSkin.Model.SLIM;
    }

    public ResourceLocation getCuriosTexture() {
        return TEXTURE;
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack,
            SlotContext slotContext,
            PoseStack poseStack,
            RenderLayerParent<T, M> renderLayerParent,
            MultiBufferSource multiBufferSource,
            int light,
            float limbSwing,
            float limbSwingAmount,
            float partialTicks,
            float ageInTicks,
            float netHeadYaw,
            float headPitch
    ) {
        boolean hasSlimArms = hasSlimArms(slotContext.entity());
        Chitin_Claw_Model model = getModel(hasSlimArms);
        InteractionHand hand = slotContext.index() % 2 == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        HumanoidArm handSide = hand == InteractionHand.MAIN_HAND ? slotContext.entity().getMainArm() : slotContext.entity().getMainArm().getOpposite();

        model.setupAnim(slotContext.entity(), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        model.prepareMobModel(slotContext.entity(), limbSwing, limbSwingAmount, partialTicks);
        ICurioRenderer.followBodyRotations(slotContext.entity(), model);

        renderArm(model, poseStack, multiBufferSource, handSide, light, stack.hasFoil());
    }

    protected void renderArm(Chitin_Claw_Model model, PoseStack matrixStack, MultiBufferSource buffer, HumanoidArm handSide, int light, boolean hasFoil) {
        RenderType renderType = model.renderType(getCuriosTexture());
        VertexConsumer vertexBuilder = ItemRenderer.getFoilBuffer(buffer, renderType, false, hasFoil);
        model.renderArm(handSide, matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY);
    }

    public final void renderFirstPersonArm(PoseStack matrixStack, MultiBufferSource buffer, int light, AbstractClientPlayer player, HumanoidArm side, boolean hasFoil) {
        if (!player.isSpectator()) {
            boolean hasSlimArms = hasSlimArms(player);
            Chitin_Claw_Model model = getModel(hasSlimArms);

            ModelPart arm = side == HumanoidArm.LEFT ? model.leftArm : model.rightArm;

            model.setAllVisible(false);
            arm.visible = true;

            model.crouching = false;
            model.attackTime = model.swimAmount = 0;
            model.setupAnim(player, 0, 0, 0, 0, 0);
            arm.xRot = 0;

            renderFirstPersonArm(model, arm, matrixStack, buffer, light, hasFoil);
        }
    }

    protected void renderFirstPersonArm(Chitin_Claw_Model model, ModelPart arm, PoseStack matrixStack, MultiBufferSource buffer, int light, boolean hasFoil) {
        RenderType renderType = model.renderType(getCuriosTexture());
        VertexConsumer builder = ItemRenderer.getFoilBuffer(buffer, renderType, false, hasFoil);
        arm.render(matrixStack, builder, light, OverlayTexture.NO_OVERLAY);
    }

}
