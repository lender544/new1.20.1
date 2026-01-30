package com.github.L_Ender.cataclysm.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class Unbreakable_Skull_Model extends HumanoidModel<LivingEntity> {

    public Unbreakable_Skull_Model(ModelPart root) {
        super(root);
    }
    public static LayerDefinition createBodyLayer(CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partdefinition = meshDefinition.getRoot();
        PartDefinition body = partdefinition.getChild("body");

        PartDefinition belt = body.addOrReplaceChild("belt", CubeListBuilder.create(),PartPose.offset(4.0F, 12.0F, 0.0F));

        PartDefinition metal_plated_skull = belt.addOrReplaceChild("metal_plated_skull", CubeListBuilder.create().texOffs(63, 24).addBox(-1.0F, -3.0F, -3.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(63, 32).addBox(3.0F, -1.0F, -3.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(76, 36).addBox(-1.0F, -3.5F, -3.2F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(76, 36).addBox(-1.0F, -3.5F, 1.2F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(68, 39).addBox(0.75F, -2.0F, 1.05F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(68, 39).addBox(0.75F, -2.0F, -3.05F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition jaw = metal_plated_skull.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(63, 17).addBox(-1.0F, -1.0F, -2.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.25F, -0.25F, -1.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition tilt = metal_plated_skull.addOrReplaceChild("tilt", CubeListBuilder.create().texOffs(76, 32).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -3.5F, -1.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition horns = metal_plated_skull.addOrReplaceChild("horns", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, -3.25F, -1.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition left_horn = horns.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(80, 24).addBox(-0.5F, -2.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(63, 38).addBox(-1.5F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.1F, 0.0F, 0.1745F, 0.0F));

        PartDefinition right_horn = horns.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(80, 24).addBox(-0.5F, -2.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(63, 38).addBox(-1.5F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.1F, 0.0F, -0.1745F, 0.0F));

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
