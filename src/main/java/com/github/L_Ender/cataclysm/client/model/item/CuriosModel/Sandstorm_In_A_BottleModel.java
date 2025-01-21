package com.github.L_Ender.cataclysm.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class Sandstorm_In_A_BottleModel extends HumanoidModel<LivingEntity> {
    public Sandstorm_In_A_BottleModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer(CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition body = partDefinition.getChild("body");

        PartDefinition root = body.addOrReplaceChild("root", CubeListBuilder.create().texOffs(65, 10).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(63, 16).addBox(-1.0F, 1.0F, -2.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

        root.addOrReplaceChild("bottle", CubeListBuilder.create().texOffs(75, 24).mirror().addBox(-1.5F, -0.5F, -1.45F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false)
                .texOffs(63, 24).mirror().addBox(-1.5F, -1.0F, -1.45F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(71, 33).mirror().addBox(-1.5F, 4.0F, -1.45F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(63, 35).mirror().addBox(-1.0F, 0.7F, -1.05F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false)
                .texOffs(63, 32).mirror().addBox(-1.0F, -2.0F, -1.05F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 0.0F, 3.55F, 0.0F, 0.0F, 0.0436F));

        root.addOrReplaceChild("bottle2", CubeListBuilder.create().texOffs(75, 24).addBox(-1.5F, -0.5F, -1.45F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.1F))
                .texOffs(63, 24).addBox(-1.5F, -1.0F, -1.45F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(63, 35).addBox(-1.0F, 0.7F, -1.05F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.2F))
                .texOffs(63, 32).addBox(-1.0F, -2.0F, -1.05F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 33).addBox(-1.5F, 4.0F, -1.45F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 3.55F, 0.0F, 0.0F, -0.0436F));

        root.addOrReplaceChild("belt", CubeListBuilder.create().texOffs(63, 19).addBox(-0.9412F, -2.0F, -0.1341F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -2.0F, 0.0F, -0.2618F, 0.0F));
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
