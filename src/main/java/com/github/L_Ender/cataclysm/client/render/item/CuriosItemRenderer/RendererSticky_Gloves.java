package com.github.L_Ender.cataclysm.client.render.item.CuriosItemREnderer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.item.CuriosModel.Blazing_Grips_Model;
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

public class RendererSticky_Gloves implements ICurioRenderer {
    private final Sticky_Gloves_Model model;
    private final Sticky_Gloves_Model slimModel;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Cataclysm.MODID, "textures/curiositem/sticky_gloves.png");

    public RendererSticky_Gloves() {
        this.model = new Sticky_Gloves_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.STICKY_GLOVES_MODEL));
        this.slimModel = new Sticky_Gloves_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.STICKY_GLOVES_SLIM_MODEL));
    }

    @Nullable
    public static RendererSticky_Gloves getGloveRenderer(ItemStack stack) {
        if (!stack.isEmpty()) {
            return CuriosRendererRegistry.getRenderer(stack.getItem())
                    .filter(RendererSticky_Gloves.class::isInstance)
                    .map(RendererSticky_Gloves.class::cast)
                    .orElse(null);
        }
        return null;
    }

    protected Sticky_Gloves_Model getModel(boolean hasSlimArms) {
        return hasSlimArms ? slimModel : model;
    }

    protected static boolean hasSlimArms(Entity entity) {
        return entity instanceof AbstractClientPlayer player && player.getModelName().equals("slim");
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
        Sticky_Gloves_Model model = getModel(hasSlimArms);
        InteractionHand hand = slotContext.index() % 2 == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        HumanoidArm handSide = hand == InteractionHand.MAIN_HAND ? slotContext.entity().getMainArm() : slotContext.entity().getMainArm().getOpposite();

        model.setupAnim(slotContext.entity(), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        model.prepareMobModel(slotContext.entity(), limbSwing, limbSwingAmount, partialTicks);
        ICurioRenderer.followBodyRotations(slotContext.entity(), model);

        renderArm(model, poseStack, multiBufferSource, handSide, light, stack.hasFoil());
    }

    protected void renderArm(Sticky_Gloves_Model model, PoseStack matrixStack, MultiBufferSource buffer, HumanoidArm handSide, int light, boolean hasFoil) {
        RenderType renderType = model.renderType(getCuriosTexture());
        VertexConsumer vertexBuilder = ItemRenderer.getFoilBuffer(buffer, renderType, false, hasFoil);
        model.renderArm(handSide, matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
    }

    public final void renderFirstPersonArm(PoseStack matrixStack, MultiBufferSource buffer, int light, AbstractClientPlayer player, HumanoidArm side, boolean hasFoil) {
        if (!player.isSpectator()) {
            boolean hasSlimArms = hasSlimArms(player);
            Sticky_Gloves_Model model = getModel(hasSlimArms);

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

    protected void renderFirstPersonArm(Sticky_Gloves_Model model, ModelPart arm, PoseStack matrixStack, MultiBufferSource buffer, int light, boolean hasFoil) {
        RenderType renderType = model.renderType(getCuriosTexture());
        VertexConsumer builder = ItemRenderer.getFoilBuffer(buffer, renderType, false, hasFoil);
        arm.render(matrixStack, builder, light, OverlayTexture.NO_OVERLAY);
    }
}
