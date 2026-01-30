package com.github.L_Ender.cataclysm.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class Belt_Of_Monstrosity_Model extends HumanoidModel<LivingEntity> {

    public Belt_Of_Monstrosity_Model(ModelPart root) {
        super(root);
    }
    public static LayerDefinition createBodyLayer(CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partdefinition = meshDefinition.getRoot();
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition belt = body.addOrReplaceChild("belt", CubeListBuilder.create().texOffs(63, 0).addBox(-4.0F, -1.5F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.3F))
                .texOffs(63, 15).addBox(0.5F, 0.25F, -1.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(63, 22).addBox(1.75F, -2.25F, -0.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(63, 22).mirror().addBox(-4.75F, -2.25F, -0.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(63, 15).mirror().addBox(-4.5F, 0.25F, -1.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 9.5F, 0.0F));

        PartDefinition cube_r1 = belt.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(63, 8).mirror().addBox(-1.5F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 1.25F, -2.5F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r2 = belt.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(63, 8).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 1.25F, -2.5F, 0.0F, 0.0F, 0.1745F));

        PartDefinition left_side = belt.addOrReplaceChild("left_side", CubeListBuilder.create(), PartPose.offset(0.125F, 0.0F, 0.125F));

        PartDefinition scale = left_side.addOrReplaceChild("scale", CubeListBuilder.create(), PartPose.offsetAndRotation(4.375F, -1.25F, 1.125F, -0.3065F, -0.0832F, 0.0263F));

        PartDefinition scale2 = left_side.addOrReplaceChild("scale2", CubeListBuilder.create(), PartPose.offsetAndRotation(4.625F, 1.25F, 0.875F, -0.3155F, -0.2494F, 0.0804F));

        PartDefinition right_side = belt.addOrReplaceChild("right_side", CubeListBuilder.create(), PartPose.offset(-0.125F, 0.0F, 0.125F));

        PartDefinition scale5 = right_side.addOrReplaceChild("scale5", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.375F, -1.25F, 1.125F, -0.3065F, 0.0832F, -0.0263F));

        PartDefinition scale6 = right_side.addOrReplaceChild("scale6", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.625F, 1.25F, 0.875F, -0.3155F, 0.2494F, -0.0804F));

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
