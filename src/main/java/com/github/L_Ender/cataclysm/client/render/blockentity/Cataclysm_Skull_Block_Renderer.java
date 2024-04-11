package com.github.L_Ender.cataclysm.client.render.blockentity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blockentities.Cataclysm_Skull_BlockEntity;
import com.github.L_Ender.cataclysm.blocks.Abstract_Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.blocks.Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.blocks.Wall_Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.block.Cataclysm_Skull_Model_Base;
import com.github.L_Ender.cataclysm.client.model.block.KobolediatorHeadModel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class Cataclysm_Skull_Block_Renderer implements BlockEntityRenderer<Cataclysm_Skull_BlockEntity> {
    private final Map<Cataclysm_Skull_Block.Type, Cataclysm_Skull_Model_Base> modelByType;
    public static final Map<Cataclysm_Skull_Block.Type, ResourceLocation> SKIN_BY_TYPE = Util.make(Maps.newHashMap(), (p_261388_) -> {
        p_261388_.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, new ResourceLocation(Cataclysm.MODID,"textures/entity/koboleton/kobolediator.png"));
    });

    public static Map<Cataclysm_Skull_Block.Type, Cataclysm_Skull_Model_Base> createSkullRenderers(EntityModelSet p_173662_) {
        ImmutableMap.Builder<Cataclysm_Skull_Block.Type, Cataclysm_Skull_Model_Base> builder = ImmutableMap.builder();
        builder.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, new KobolediatorHeadModel(p_173662_.bakeLayer(CMModelLayers.KOBOLEDIATOR_HEAD_MODEL)));
        return builder.build();
    }

    public Cataclysm_Skull_Block_Renderer(BlockEntityRendererProvider.Context p_173660_) {
        this.modelByType = createSkullRenderers(p_173660_.getModelSet());
    }

    public void render(Cataclysm_Skull_BlockEntity p_112534_, float p_112535_, PoseStack p_112536_, MultiBufferSource p_112537_, int p_112538_, int p_112539_) {
        float f = p_112534_.getAnimation(p_112535_);
        BlockState blockstate = p_112534_.getBlockState();
        boolean flag = blockstate.getBlock() instanceof Wall_Cataclysm_Skull_Block;
        Direction direction = flag ? blockstate.getValue(Wall_Cataclysm_Skull_Block.FACING) : null;
        int i = flag ? RotationSegment.convertToSegment(direction.getOpposite()) : blockstate.getValue(Cataclysm_Skull_Block.ROTATION);
        float f1 = RotationSegment.convertToDegrees(i);
        Cataclysm_Skull_Block.Type Cataclysm_Skull_Block$type = ((Abstract_Cataclysm_Skull_Block)blockstate.getBlock()).getType();
        Cataclysm_Skull_Model_Base Cataclysm_Skull_Model_Base = this.modelByType.get(Cataclysm_Skull_Block$type);

        ResourceLocation resourcelocation = SKIN_BY_TYPE.get(Cataclysm_Skull_Block$type);
        RenderType rendertype = RenderType.entityCutoutNoCullZOffset(resourcelocation);
        renderSkull(direction, f1, f, p_112536_, p_112537_, p_112538_, Cataclysm_Skull_Model_Base, rendertype);
    }

    public static void renderSkull(@Nullable Direction p_173664_, float p_173665_, float p_173666_, PoseStack p_173667_, MultiBufferSource p_173668_, int p_173669_, Cataclysm_Skull_Model_Base p_173670_, RenderType p_173671_) {
        p_173667_.pushPose();
        if (p_173664_ == null) {
            p_173667_.translate(0.5F, 0.0F, 0.5F);
        } else {
            float f = 0.25F;
            p_173667_.translate(0.5F - (float)p_173664_.getStepX() * 0.25F, 0.25F, 0.5F - (float)p_173664_.getStepZ() * 0.25F);
        }

        p_173667_.scale(-1.0F, -1.0F, 1.0F);
        VertexConsumer vertexconsumer = p_173668_.getBuffer(p_173671_);
        p_173670_.setupAnim(p_173666_, p_173665_, 0.0F);
        p_173670_.renderToBuffer(p_173667_, vertexconsumer, p_173669_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        p_173667_.popPose();
    }
}
