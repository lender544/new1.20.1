package com.github.L_Ender.cataclysm.client.model.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KobolediatorHeadModel extends Cataclysm_Skull_Model_Base {
    private final ModelPart head;
    private final ModelPart jaw;

    public KobolediatorHeadModel(ModelPart p_171097_) {
        this.head = p_171097_.getChild("head");
        this.jaw = this.head.getChild("jaw");
    }

    public static LayerDefinition createHeadLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 119).addBox(-5.0F, -9.0F, -6.0513F, 10.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

        PartDefinition head_cube1 = head.addOrReplaceChild("head_cube1", CubeListBuilder.create().texOffs(36, 100).addBox(0.8F, -5.0F, -8.0F, 6.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7831F, -8.0F, 1.9487F, 0.1616F, 0.1866F, -0.0568F));

        PartDefinition head_cube2 = head.addOrReplaceChild("head_cube2", CubeListBuilder.create().texOffs(62, 38).addBox(1.0F, -6.0F, -12.0F, 6.0F, 6.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -9.0F, 1.9487F, 0.48F, 0.0F, 0.0F));

        PartDefinition head_cube3 = head.addOrReplaceChild("head_cube3", CubeListBuilder.create().texOffs(125, 113).addBox(-6.8F, -5.0F, -8.0F, 6.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7832F, -8.0F, 1.9487F, 0.1616F, -0.1866F, 0.0568F));

        PartDefinition head_cube4 = head.addOrReplaceChild("head_cube4", CubeListBuilder.create().texOffs(102, 49).addBox(-3.0F, -34.0F, -23.0F, 9.0F, 7.0F, 10.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-1.5F, 24.0F, 8.9487F, 0.0436F, 0.0F, 0.0F));

        PartDefinition right_horn = head.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(148, 105).addBox(-9.2168F, -9.0F, 4.0513F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(148, 40).addBox(-9.2168F, -9.0F, -1.9487F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(129, 0).addBox(-9.2168F, -3.0F, -1.9487F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.7832F, -11.0F, 0.9487F));

        PartDefinition left_horn = head.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(148, 52).addBox(4.2168F, -9.0F, 4.0513F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(96, 146).addBox(3.2168F, -9.0F, -1.9487F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(123, 93).addBox(-2.7832F, -3.0F, -1.9487F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.7831F, -11.0F, 0.9487F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(102, 29).addBox(-2.7168F, -4.0F, -12.0F, 7.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.7832F, 0.0F, -2.0513F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }


    public KobolediatorHeadModel withAnimations(LivingEntity entity){
        float partialTick = Minecraft.getInstance().getFrameTime();
        float limbSwingAmount = entity.walkAnimation.speed(partialTick);
        float limbSwing = entity.walkAnimation.position() + partialTick;
        setupAnim(entity.tickCount + partialTick, 0, 0);
        return  this;
    }

    public void setupAnim(float p_104188_, float p_104189_, float p_104190_) {
        this.jaw.xRot = (float)(Math.sin((double)(p_104188_ * (float)Math.PI * 0.2F)) + 1.0D) * 0.2F;
        this.head.yRot = p_104189_ * ((float)Math.PI / 180F);
        this.head.xRot = p_104190_ * ((float)Math.PI / 180F);
    }

    public void renderToBuffer(PoseStack p_104192_, VertexConsumer p_104193_, int p_104194_, int p_104195_, float p_104196_, float p_104197_, float p_104198_, float p_104199_) {
        p_104192_.pushPose();
        p_104192_.translate(0.0F, -0.374375F, 0.0F);
        p_104192_.scale(0.75F, 0.75F, 0.75F);
        this.head.render(p_104192_, p_104193_, p_104194_, p_104195_, p_104196_, p_104197_, p_104198_, p_104199_);
        p_104192_.popPose();
    }


}
