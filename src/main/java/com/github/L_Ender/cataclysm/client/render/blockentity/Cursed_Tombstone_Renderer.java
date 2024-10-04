package com.github.L_Ender.cataclysm.client.render.blockentity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blockentities.Cursed_tombstone_Entity;
import com.github.L_Ender.cataclysm.blockentities.Door_Of_Seal_BlockEntity;
import com.github.L_Ender.cataclysm.blocks.Cursed_Tombstone_Block;
import com.github.L_Ender.cataclysm.blocks.Door_of_Seal_Block;
import com.github.L_Ender.cataclysm.client.model.block.Cursed_Tombstone_Model;
import com.github.L_Ender.cataclysm.client.model.block.Door_Of_Seal_Model;
import com.github.L_Ender.cataclysm.client.render.entity.The_Harbinger_Renderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

public class Cursed_Tombstone_Renderer implements BlockEntityRenderer<Cursed_tombstone_Entity> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/cursed_tombstone_off.png");
    private static final ResourceLocation TEXTURE2 = new ResourceLocation(Cataclysm.MODID,"textures/block/cursed_tombstone_on.png");
   private static final Cursed_Tombstone_Model MODEL = new Cursed_Tombstone_Model();
    private final RandomSource rnd = RandomSource.create();
    private static final float HALF_SQRT_3 = (float)(Math.sqrt(3.0D) / 2.0D);
    public Cursed_Tombstone_Renderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
    }



    @Override
    public void render(Cursed_tombstone_Entity entity, float delta, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int overlay) {
        poseStack.pushPose();
        Direction dir = entity.getBlockState().getValue(Cursed_Tombstone_Block.FACING);
        poseStack.translate(0.5F, 1.5F, 0.5F);
        poseStack.mulPose(dir.getRotation());
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
        MODEL.renderToBuffer(poseStack,entity.getBlockState().getValue(Cursed_Tombstone_Block.POWERED) ? buffer.getBuffer(RenderType.entityCutoutNoCull(TEXTURE2)) :  buffer.getBuffer(RenderType.entityCutoutNoCull(TEXTURE)), packedLight, overlay, 1, 1F, 1, 1);

        if (entity.tickCount > 0) {
            float f5 = ((float)entity.tickCount + delta) / 63;
            float f7 = Math.min(f5 > 0.8F ? (f5 - 0.8F) / 0.2F : 0.0F, 1.0F);
            RandomSource randomsource = RandomSource.create(432L);
            VertexConsumer vertexconsumer2 = buffer.getBuffer(RenderType.lightning());
            poseStack.pushPose();
            poseStack.translate(0.0D, 0.0D, 0.0D);

            for(int i = 0; (float)i < (f5 + f5 * f5) / 2.0F * 30.0F; ++i) {
                poseStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                poseStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                poseStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                poseStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                poseStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                poseStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F + f5 * 90.0F));
                float f3 = randomsource.nextFloat() * 5.0F + 5F + f7 * 5.0F;
                float f4 = randomsource.nextFloat() * 0.5F + 1F + f7 * 2.0F;
                Matrix4f matrix4f = poseStack.last().pose();
                int j = (int)(255.0F * (1.0F - f7));
                vertex01(vertexconsumer2, matrix4f, j);
                vertex2(vertexconsumer2, matrix4f, f3, f4);
                vertex3(vertexconsumer2, matrix4f, f3, f4);
                vertex01(vertexconsumer2, matrix4f, j);
                vertex3(vertexconsumer2, matrix4f, f3, f4);
                vertex4(vertexconsumer2, matrix4f, f3, f4);
                vertex01(vertexconsumer2, matrix4f, j);
                vertex4(vertexconsumer2, matrix4f, f3, f4);
                vertex2(vertexconsumer2, matrix4f, f3, f4);
            }

            poseStack.popPose();
        }


        poseStack.popPose();
    }


    private static void vertex01(VertexConsumer p_114220_, Matrix4f p_114221_, int p_114222_) {
        p_114220_.vertex(p_114221_, 0.0F, 0.0F, 0.0F).color(57,210,178, p_114222_).endVertex();
    }

    private static void vertex2(VertexConsumer p_114215_, Matrix4f p_114216_, float p_114217_, float p_114218_) {
        p_114215_.vertex(p_114216_, -HALF_SQRT_3 * p_114218_, p_114217_, -0.5F * p_114218_).color(57,210,178, 0).endVertex();
    }

    private static void vertex3(VertexConsumer p_114224_, Matrix4f p_114225_, float p_114226_, float p_114227_) {
        p_114224_.vertex(p_114225_, HALF_SQRT_3 * p_114227_, p_114226_, -0.5F * p_114227_).color(57,210,178, 0).endVertex();
    }

    private static void vertex4(VertexConsumer p_114229_, Matrix4f p_114230_, float p_114231_, float p_114232_) {
        p_114229_.vertex(p_114230_, 0.0F, p_114231_, 1.0F * p_114232_).color(57,210,178, 0).endVertex();
    }

}
