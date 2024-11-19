package com.github.L_Ender.cataclysm.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class Blazing_Grips_Model extends HumanoidModel<LivingEntity> {
    public Blazing_Grips_Model(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer(CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition rightArm = partDefinition.getChild("right_arm");
        PartDefinition leftArm = partDefinition.getChild("left_arm");


        rightArm.addOrReplaceChild("right_gauntlet", CubeListBuilder.create().texOffs(63, 6).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.4F))
                .texOffs(63, 18).addBox(-2.0F, 0.1F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.55F)), PartPose.offset(0.0F, 3.0F, 0.0F));

        leftArm.addOrReplaceChild("left_gauntlet", CubeListBuilder.create().texOffs(63, 6).mirror().addBox(-2.0F, 1.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.4F)).mirror(false)
                .texOffs(63, 18).mirror().addBox(-2.0F, 0.1F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.55F)).mirror(false), PartPose.offset(0.0F, 3.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);

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
