package com.github.L_Ender.cataclysm.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class Berserker_Soul_Amulet_Model extends HumanoidModel<LivingEntity> {
    public Berserker_Soul_Amulet_Model(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer(CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition body = partDefinition.getChild("body");

        PartDefinition soul_trimmed_amulet = body.addOrReplaceChild("soul_trimmed_amulet", CubeListBuilder.create().texOffs(64, 28).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(-3.5F, -3.5F, -0.5F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(72, 28).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, -1.6F, 0.0F, 0.0F, 0.7854F));
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
