package com.github.L_Ender.cataclysm.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;

public class Chitin_Claw_Model extends HumanoidModel<LivingEntity> {
    public Chitin_Claw_Model(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer(boolean slim,CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition rightArm = partDefinition.getChild("right_arm");
        PartDefinition leftArm = partDefinition.getChild("left_arm");

        float slimornot = slim ? 0.0F : 1.0f;

        PartDefinition right_gauntlet = rightArm.addOrReplaceChild("right_gauntlet", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition gauntlet3_r1 = right_gauntlet.addOrReplaceChild("gauntlet3_r1", CubeListBuilder.create().texOffs(79, 18).addBox(-1.6F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.55F)), PartPose.offsetAndRotation(-0.428F - slimornot, 7.0523F, 0.0F, 0.0F, 0.0F, 0.0087F));

        PartDefinition gauntlet2_r1 = right_gauntlet.addOrReplaceChild("gauntlet2_r1", CubeListBuilder.create().texOffs(63, 18).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.55F)), PartPose.offsetAndRotation(-slimornot, 6.1F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition gauntlet1_r1 = right_gauntlet.addOrReplaceChild("gauntlet1_r1", CubeListBuilder.create().texOffs(63, 6).mirror().addBox(-2.0F, -3.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.4F)).mirror(false), PartPose.offsetAndRotation(-slimornot, 6.5F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition left_gauntlet = leftArm.addOrReplaceChild("left_gauntlet", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition gauntlet4_r1 = left_gauntlet.addOrReplaceChild("gauntlet4_r1", CubeListBuilder.create().texOffs(79, 18).mirror().addBox(-2.4F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.55F)).mirror(false), PartPose.offsetAndRotation(0.428F + slimornot, 7.0523F, 0.0F, 0.0F, 0.0F, -0.0087F));

        PartDefinition gauntlet3_r2 = left_gauntlet.addOrReplaceChild("gauntlet3_r2", CubeListBuilder.create().texOffs(63, 18).mirror().addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.55F)).mirror(false), PartPose.offsetAndRotation(slimornot, 6.1F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition gauntlet2_r2 = left_gauntlet.addOrReplaceChild("gauntlet2_r2", CubeListBuilder.create().texOffs(63, 6).addBox(-2.0F, -3.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(slimornot, 6.5F, 0.0F, 0.0F, 0.0F, 0.1309F));


        return LayerDefinition.create(meshDefinition, 128, 128);

    }

    public void renderArm(HumanoidArm handSide, PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay) {
        getArm(handSide).visible = true;
        getArm(handSide.getOpposite()).visible = false;
        renderToBuffer(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(leftArm, rightArm);
    }

}
