package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.ModelThe_Prowler;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.entity.RendererThe_Prowler;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Prowler_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.WalkAnimationState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class The_Prowler_Layer extends RenderLayer<The_Prowler_Entity, ModelThe_Prowler> {
    private static final ResourceLocation PROWLER_LAYER_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/factory/the_prowler_layer.png");

    private static final ResourceLocation[] TEXTURE_PROGRESS = new ResourceLocation[4];

    public The_Prowler_Layer(RendererThe_Prowler renderIn) {
        super(renderIn);
        for(int i = 0; i < 4; i++){
            TEXTURE_PROGRESS[i] = new ResourceLocation(Cataclysm.MODID,"textures/entity/factory/the_prowler_layer_" + i + ".png");
        }
    }

    public ResourceLocation getTextureLocation(The_Prowler_Entity entity) {
        WalkAnimationState walkanimationstate = entity.walkAnimation;
        int f3 = (int) walkanimationstate.position(entity.tickCount);
        return getGrowingTexture(entity, (int) ((f3 * 0.5F) % 4));
    }

    public ResourceLocation getGrowingTexture(The_Prowler_Entity entity, int age) {
        return TEXTURE_PROGRESS[Mth.clamp(age, 0, 4)];
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Prowler_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            //need rework
        float f = 1.0F - entity.deathTime / (float) entity.deathtimer();
        RenderType eyes = CMRenderTypes.CMEyes(this.getTextureLocation(entity));
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, f, f, f, 1.0F);

    }
}


