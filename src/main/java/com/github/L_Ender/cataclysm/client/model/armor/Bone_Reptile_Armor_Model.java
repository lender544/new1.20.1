package com.github.L_Ender.cataclysm.client.model.armor;


import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Bone_Reptile_Armor_Model extends HumanoidModel {

    public Bone_Reptile_Armor_Model(ModelPart p_170677_) {
        super(p_170677_);


    }

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.getChild("head");
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition rightArm = partdefinition.getChild("right_arm");
        PartDefinition leftArm = partdefinition.getChild("left_arm");

        head.addOrReplaceChild("Helmet_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -1.5F, -4.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offsetAndRotation(2.0F, -6.4224F, -5.7783F, 0.0873F, 0.0F, 0.0F));

        head.addOrReplaceChild("Helmet_r2", CubeListBuilder.create().texOffs(20, 36).mirror().addBox(-3.9F, 1.0F, -6.2F, 3.0F, 4.0F, 5.0F, new CubeDeformation(1.0F)).mirror(false), PartPose.offsetAndRotation(4.9F, -5.0F, 0.2F, 0.2618F, -0.3054F, 0.0F));

        head.addOrReplaceChild("Helmet_r3", CubeListBuilder.create().texOffs(20, 36).addBox(0.9F, 1.0F, -6.2F, 3.0F, 4.0F, 5.0F, new CubeDeformation(1.0F)), PartPose.offsetAndRotation(-4.9F, -5.0F, 0.2F, 0.2618F, 0.3054F, 0.0F));

        head.addOrReplaceChild("Helmet_r4", CubeListBuilder.create().texOffs(0, 45).addBox(-4.5F, -2.4F, -4.0F, 9.0F, 2.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

        head.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(0, 39).mirror().addBox(-3.0F, -3.3F, -2.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(1.0F)).mirror(false)
                .texOffs(8, 40).mirror().addBox(-3.0F, -3.3F, 1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(1.0F)).mirror(false), PartPose.offset(-6.0F, -8.0F, 5.0F));

        head.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(0, 39).addBox(0.0F, -3.3F, -2.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(1.0F))
                .texOffs(8, 40).addBox(0.0F, -3.3F, 1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(1.0F)), PartPose.offset(6.0F, -8.0F, 5.0F));

        head.addOrReplaceChild("mid_horn", CubeListBuilder.create().texOffs(53, 111).addBox(-2.5F, -1.7F, -6.0F, 5.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.8F, 4.4F, 0.5236F, 0.0F, 0.0F));

        body.addOrReplaceChild("body_bone", CubeListBuilder.create().texOffs(0, 108).addBox(-6.0F, 0.0F, -1.85F, 10.0F, 14.0F, 6.0F, new CubeDeformation(0.45F))
                .texOffs(0, 87).addBox(-2.0F, 0.0F, 5.0F, 2.0F, 14.0F, 1.0F, new CubeDeformation(0.5F))
                .texOffs(32, 92).addBox(-1.0F, 0.0F, 6.5F, 0.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, -1.0F));

        rightArm.addOrReplaceChild("right_shoulder", CubeListBuilder.create().texOffs(0, 95).addBox(-8.0F, -4.0F, -4.0F, 9.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 78).addBox(-8.0F, -6.0F, -4.0F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

        rightArm.addOrReplaceChild("right_fist", CubeListBuilder.create().texOffs(44, 105).addBox(-5.5F, -2.0F, -3.0F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 6.0F, -0.5F));

        leftArm.addOrReplaceChild("left_shoulder", CubeListBuilder.create().texOffs(0, 95).mirror().addBox(-1.0F, -4.0F, -4.0F, 9.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 78).mirror().addBox(2.0F, -6.0F, -4.0F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.5F));

        leftArm.addOrReplaceChild("left_fist", CubeListBuilder.create().texOffs(44, 105).mirror().addBox(2.5F, -2.0F, -3.0F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 6.0F, -0.5F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

}
