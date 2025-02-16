package com.github.L_Ender.cataclysm.client.model.entity;

import com.github.L_Ender.cataclysm.client.animation.Hippocamtus_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Hippocamtus_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Storm_Bringer_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Storm_Bringer_Model extends EntityModel<Storm_Bringer_Entity> {
    private final ModelPart root;
    private final ModelPart anchor;
    private final ModelPart chain;


    public Storm_Bringer_Model(ModelPart root) {
        this.root = root;
        this.anchor = this.root.getChild("anchor");
        this.chain = this.anchor.getChild("chain");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition anchor = partdefinition.addOrReplaceChild("anchor", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -37.3F, -9.0F, 0.0F, 11.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(79, 51).addBox(-1.0F, -32.3F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(37, 19).addBox(-3.0F, -35.3F, 0.0F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-2.0F, -22.3F, -3.0F, 4.0F, 32.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = anchor.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(70, 0).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 7.7F, 0.0F, -2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r2 = anchor.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(79, 38).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -25.5F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r3 = anchor.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(50, 38).addBox(-1.0F, -3.0F, -6.0F, 2.0F, 6.0F, 12.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -20.5732F, 15.6944F, -0.7418F, 0.0F, 0.0F));

        PartDefinition cube_r4 = anchor.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(37, 0).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -25.3F, 2.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r5 = anchor.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(50, 57).addBox(-1.0F, -3.0F, -6.0F, 2.0F, 6.0F, 12.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -20.5732F, -15.6944F, 0.7418F, 0.0F, 0.0F));

        PartDefinition cube_r6 = anchor.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(50, 19).addBox(-2.0F, -3.0F, -11.0F, 4.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -25.3F, -2.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r7 = anchor.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(67, 76).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.7693F, 3.0963F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r8 = anchor.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(42, 76).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.7693F, -3.0963F, -0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r9 = anchor.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(83, 17).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(88, 64).addBox(-1.0F, 5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 69).addBox(0.0F, 3.0F, -5.0F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0353F, 19.5093F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r10 = anchor.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(79, 64).addBox(-1.0F, 5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0353F, -19.5093F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r11 = anchor.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(21, 59).addBox(0.0F, -5.0F, -5.0F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.1037F, -18.4651F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r12 = anchor.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(21, 80).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0353F, -19.5093F, 0.1309F, 0.0F, 0.0F));

        PartDefinition chain = anchor.addOrReplaceChild("chain", CubeListBuilder.create(), PartPose.offset(0.0F, 21.3F, 0.0F));

        PartDefinition cube_r13 = chain.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(21, 30).addBox(1.0F, -10.0F, -4.0F, 0.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -10.6F, 0.0F, -2.3562F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public ModelPart root() {
        return this.root;
    }

    public void translateToHand(PoseStack matrixStack) {
        this.root.translateAndRotate(matrixStack);
        this.anchor.translateAndRotate(matrixStack);
        this.chain.translateAndRotate(matrixStack);
    }

    public void setupAnim(Storm_Bringer_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
    }
}

