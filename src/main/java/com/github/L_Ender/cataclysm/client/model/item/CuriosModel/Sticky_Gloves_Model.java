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

public class Sticky_Gloves_Model extends HumanoidModel<LivingEntity> {
    public Sticky_Gloves_Model(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer(boolean slim,CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition rightArm = partDefinition.getChild("right_arm");
        PartDefinition leftArm = partDefinition.getChild("left_arm");

        float slimornot = slim ? 1.0F : 0.0f;

        rightArm.addOrReplaceChild("right_glove", CubeListBuilder.create().texOffs(63, 11).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-3.0F, 7.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(slimornot, 0.0F, 0.0F));

         leftArm.addOrReplaceChild("left_glove", CubeListBuilder.create().texOffs(63, 11).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                 .texOffs(75, 23).mirror().addBox(-1.0F, 7.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offset(-slimornot, 0.0F, 0.0F));

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
