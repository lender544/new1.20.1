package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Axe_Blade_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.projectile.Axe_Blade_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Axe_Blade_Renderer extends EntityRenderer<Axe_Blade_Entity>
{
    private static final ResourceLocation[] TEXTURE_PROGRESS = new ResourceLocation[5];

    public Axe_Blade_Model model;

    public Axe_Blade_Renderer(EntityRendererProvider.Context manager)
    {
        super(manager);
        this.model = new Axe_Blade_Model();
        for(int i = 0; i < 5; i++){
            TEXTURE_PROGRESS[i] = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/draugar/axe_blade_" + i + ".png");
        }
    }

    @Override
    protected int getBlockLightLevel(Axe_Blade_Entity entity, BlockPos pos)
    {
        return 15;
    }

    @Override
    public void render(Axe_Blade_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        matrixStackIn.translate(0, 0F, 0);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(entityIn.getYRot() + 180));
        VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(this.getTextureLocation(entityIn)));
        model.setupAnim(entityIn, 0, 0, entityIn.tickCount + partialTicks, 0, 0);
        float hide = ((float) entityIn.getTransparency() / 80);
        float alpha = (1F - hide) ;

        int i = FastColor.ARGB32.color(Mth.floor(alpha * 255.0F), -1);


        this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY,i);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getTextureLocation(Axe_Blade_Entity entity)
    {
        return getGrowingTexture(entity,(int) ((entity.tickCount * 0.5F) % 4));
    }

    public ResourceLocation getGrowingTexture(Axe_Blade_Entity entity, int age) {
        return  TEXTURE_PROGRESS[Mth.clamp(age, 0, 4)];
    }

}
