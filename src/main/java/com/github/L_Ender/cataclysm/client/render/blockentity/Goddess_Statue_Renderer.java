package com.github.L_Ender.cataclysm.client.render.blockentity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blockentities.Statue_Block_Entity;
import com.github.L_Ender.cataclysm.blocks.Statue_Block;
import com.github.L_Ender.cataclysm.client.model.block.Goddess_Statue_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Goddess_Statue_Renderer implements BlockEntityRenderer<Statue_Block_Entity> {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/block/goddess_statue.png");
    private static final Goddess_Statue_Model MODEL = new Goddess_Statue_Model();

    public Goddess_Statue_Renderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
    }

    public boolean shouldRenderOffScreen(Statue_Block_Entity p_112138_) {
        return true;
    }

    public int getViewDistance() {
        return 256;
    }

    public boolean shouldRender(Statue_Block_Entity p_173531_, Vec3 p_173532_) {
        return Vec3.atCenterOf(p_173531_.getBlockPos()).multiply(1.0D, 0.0D, 1.0D).closerThan(p_173532_.multiply(1.0D, 0.0D, 1.0D), (double)this.getViewDistance());
    }


    @Override
    public void render(Statue_Block_Entity entity, float delta, PoseStack matrixStackIn, MultiBufferSource buffer, int packedLight, int overlay) {

        DoubleBlockHalf doubleblockhalf = entity.getBlockState().getValue(Statue_Block.HALF);
        if (doubleblockhalf == DoubleBlockHalf.LOWER) {
            matrixStackIn.pushPose();
            float f = entity.getBlockState().getValue(Statue_Block.FACING).toYRot();
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(-f + 180));
            matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
            MODEL.renderToBuffer(matrixStackIn, buffer.getBuffer(RenderType.entityCutoutNoCull(TEXTURE)), packedLight, overlay,1, 1F, 1, 1);

            matrixStackIn.popPose();
        }
    }
}
