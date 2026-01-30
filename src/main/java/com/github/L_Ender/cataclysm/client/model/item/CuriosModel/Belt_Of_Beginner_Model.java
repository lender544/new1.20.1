package com.github.L_Ender.cataclysm.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class Belt_Of_Beginner_Model extends HumanoidModel<LivingEntity> {

    public Belt_Of_Beginner_Model(ModelPart root) {
        super(root);
    }
    public static LayerDefinition createBodyLayer(CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partdefinition = meshDefinition.getRoot();
        PartDefinition body = partdefinition.getChild("body");

        PartDefinition belt = body.addOrReplaceChild("belt", CubeListBuilder.create().texOffs(63, 0).addBox(-4.0F, -1.5F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.offset(0.0F, 9.5F, 0.0F));

        PartDefinition cube_r1 = belt.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(63, 8).mirror().addBox(-1.5F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 0.25F, -2.8F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r2 = belt.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(63, 8).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.25F, -2.8F, 0.0F, 0.0F, 0.1745F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.body);
    }
}
