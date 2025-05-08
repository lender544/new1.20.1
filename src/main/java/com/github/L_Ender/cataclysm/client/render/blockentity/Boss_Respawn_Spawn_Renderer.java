package com.github.L_Ender.cataclysm.client.render.blockentity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blockentities.AltarOfAmethyst_Block_Entity;
import com.github.L_Ender.cataclysm.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.github.L_Ender.cataclysm.client.model.block.Boss_Respawn_Spawner_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;

public class Boss_Respawn_Spawn_Renderer implements BlockEntityRenderer<Boss_Respawn_Spawner_Block_Entity> {
    private final EntityRenderDispatcher entityRenderer;
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/block/boss_respawner.png");
    private static final Boss_Respawn_Spawner_Model MODEL = new Boss_Respawn_Spawner_Model();
    private final ItemRenderer itemRenderer;
    public Boss_Respawn_Spawn_Renderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        this.entityRenderer = rendererDispatcherIn.getEntityRenderer();
        this.itemRenderer = rendererDispatcherIn.getItemRenderer();
    }


    @Override
    public void render(Boss_Respawn_Spawner_Block_Entity entity, float delta, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int overlay) {
        poseStack.pushPose();
        poseStack.translate(0.5F, 1.501F, 0.5F);
        poseStack.scale(1.0F, -1.0F, -1.0F);
        MODEL.animate(entity, delta);
        MODEL.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutoutNoCull(TEXTURE)), packedLight, overlay);
        poseStack.popPose();
        poseStack.pushPose();
        Entity currentEntity = entity.getDisplayEntity(Minecraft.getInstance().level);
        if (currentEntity != null) {
            float f = 0.53125F;
            float f1 = Math.max(currentEntity.getBbWidth(), currentEntity.getBbHeight());
            if ((double)f1 > 1.0D) {
                f /= f1;
            }
            poseStack.translate(0.5F, 0.1F, 0.5F);
            poseStack.scale(f, f, f);
            this.entityRenderer.render(currentEntity, 0.0D, 0.0D, 0.0D, 0.0F, delta, poseStack, buffer, packedLight);
        }
        poseStack.popPose();
        renderItem(entity, delta,poseStack,buffer,packedLight);
    }


    public void renderItem(Boss_Respawn_Spawner_Block_Entity tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn) {

        int posLong = (int) tileEntityIn.getBlockPos().asLong();
        ItemStack stack = tileEntityIn.getTheItem();
        if (stack != ItemStack.EMPTY) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5D, 1.15F, 0.5D);
            matrixStackIn.scale(0.5F, 0.5F, 0.5F);
            if (tileEntityIn.getLevel() != null) {
                matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0F));
                this.itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, combinedLightIn, OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn, tileEntityIn.getLevel(), posLong);
            }
            matrixStackIn.popPose();
        }
    }
}
