package com.github.L_Ender.cataclysm.client.model.armor;


import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MonstrousHelm_Model extends HumanoidModel {
    public ModelPart helmet;

    public MonstrousHelm_Model(ModelPart p_170677_) {
        super(p_170677_);
        this.helmet = p_170677_.getChild("head").getChild("helmet");

    }

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.getChild("head");

        PartDefinition helmet = head.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.6F)), PartPose.offset(0.0F, 1.0F, 0.0F));
        helmet.addOrReplaceChild("lefthorn", CubeListBuilder.create().texOffs(0, 28).addBox(4.0F, -6.0F, -3.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(6.0F, -9.0F, -3.0F, 3.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        helmet.addOrReplaceChild("righthorn", CubeListBuilder.create().texOffs(0, 28).mirror().addBox(-6.0F, -6.0F, -3.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 16).mirror().addBox(-9.0F, -9.0F, -3.0F, 3.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

}
