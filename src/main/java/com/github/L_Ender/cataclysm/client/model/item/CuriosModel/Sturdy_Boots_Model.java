package com.github.L_Ender.cataclysm.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class Sturdy_Boots_Model extends HumanoidModel<LivingEntity> {

    public Sturdy_Boots_Model(ModelPart root) {
        super(root);
    }
    public static LayerDefinition createBodyLayer(CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partdefinition = meshDefinition.getRoot();
        PartDefinition right_leg = partdefinition.getChild("right_leg");
        PartDefinition left_leg = partdefinition.getChild("left_leg");
        PartDefinition right_boot = right_leg.addOrReplaceChild("right_boot", CubeListBuilder.create().texOffs(63, 35).addBox(-2.0F, -3.25F, -2.0F, 4.0F, 3.0F, 4.0F, deformation.extend(0.27F))
                .texOffs(89, 41).addBox(-1.5F, -3.75F, -2.35F, 3.0F, 2.0F, 0.0F,  deformation.extend(0.0F))
                .texOffs(63, 48).addBox(-2.0F, -1.75F, -4.5F, 4.0F, 2.0F, 2.0F, deformation.extend(0.27F))
                .texOffs(75, 32).addBox(-2.5F, -5.5F, -2.5F, 5.0F, 2.0F, 5.0F, deformation.extend(0.0F))
                .texOffs(75, 53).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 2.0F, 5.0F, deformation.extend(0.1F))
                .texOffs(63, 42).addBox(-2.0F, -1.75F, -1.5F, 4.0F, 2.0F, 4.0F, deformation.extend(0.3F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition left_boot = left_leg.addOrReplaceChild("left_boot", CubeListBuilder.create().texOffs(63, 35).mirror().addBox(-2.0F, -3.25F, -2.0F, 4.0F, 3.0F, 4.0F, deformation.extend(0.27F)).mirror(false)
                .texOffs(89, 41).mirror().addBox(-1.5F, -3.75F, -2.35F, 3.0F, 2.0F, 0.0F, deformation.extend(0.0F)).mirror(false)
                .texOffs(63, 48).mirror().addBox(-2.0F, -1.75F, -4.5F, 4.0F, 2.0F, 2.0F, deformation.extend(0.27F)).mirror(false)
                .texOffs(75, 32).mirror().addBox(-2.5F, -5.5F, -2.5F, 5.0F, 2.0F, 5.0F, deformation.extend(0.0F)).mirror(false)
                .texOffs(75, 53).mirror().addBox(-2.5F, -6.0F, -2.5F, 5.0F, 2.0F, 5.0F, deformation.extend(0.1F)).mirror(false)
                .texOffs(63, 42).mirror().addBox(-2.0F, -1.75F, -1.5F, 4.0F, 2.0F, 4.0F, deformation.extend(0.3F)).mirror(false), PartPose.offset(0.0F, 12.0F, 0.0F));


        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(leftLeg, rightLeg);
    }
}
