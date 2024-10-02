package com.github.L_Ender.cataclysm.client.render.blockentity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blockentities.Cursed_tombstone_Entity;
import com.github.L_Ender.cataclysm.blockentities.Door_Of_Seal_BlockEntity;
import com.github.L_Ender.cataclysm.blocks.Cursed_Tombstone_Block;
import com.github.L_Ender.cataclysm.blocks.Door_of_Seal_Block;
import com.github.L_Ender.cataclysm.client.model.block.Cursed_Tombstone_Model;
import com.github.L_Ender.cataclysm.client.model.block.Door_Of_Seal_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

public class Cursed_Tombstone_Renderer implements BlockEntityRenderer<Cursed_tombstone_Entity> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/cursed_tombstone_off.png");
    private static final ResourceLocation TEXTURE2 = new ResourceLocation(Cataclysm.MODID,"textures/block/cursed_tombstone_on.png");
   private static final Cursed_Tombstone_Model MODEL = new Cursed_Tombstone_Model();

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
        poseStack.popPose();
    }
}
