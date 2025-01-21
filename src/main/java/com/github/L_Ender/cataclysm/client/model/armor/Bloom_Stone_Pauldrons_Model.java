package com.github.L_Ender.cataclysm.client.model.armor;


import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Bloom_Stone_Pauldrons_Model extends HumanoidModel {

    public Bloom_Stone_Pauldrons_Model(ModelPart p_170677_) {
        super(p_170677_);


    }

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition rightArm = partdefinition.getChild("right_arm");
        PartDefinition leftArm = partdefinition.getChild("left_arm");

        rightArm.addOrReplaceChild("RightShoulder", CubeListBuilder.create().texOffs(52, 76).addBox(-5.5F, 0.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.75F, -2.5F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition LeftShoulder = leftArm.addOrReplaceChild("LeftShoulder", CubeListBuilder.create().texOffs(65, 25).addBox(0.5F, 0.5F, -3.5F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.5F))
                .texOffs(28, 65).addBox(6.5F, 0.5F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(63, 87).addBox(1.5F, -4.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.5F, 0.0F, 0.0F, 0.0F, 0.1309F));

        LeftShoulder.addOrReplaceChild("Amethyst", CubeListBuilder.create().texOffs(22, 79).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.3054F));

        LeftShoulder.addOrReplaceChild("Amethyst2", CubeListBuilder.create().texOffs(12, 83).addBox(-1.1F, 0.0F, -2.5F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.5F))
                .texOffs(0, 65).addBox(1.3F, 0.7F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3F, 5.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition Chest = body.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(65, 38).addBox(-5.0F, -3.0F, -2.0F, 10.0F, 6.0F, 4.0F, new CubeDeformation(0.5F))
                .texOffs(60, 60).addBox(-6.0F, -4.0F, -2.0F, 12.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(73, 76).addBox(-2.0F, -3.0F, 2.5F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 79).addBox(-2.0F, -3.0F, 2.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F))
                .texOffs(48, 87).addBox(-1.5F, 2.0F, 2.5F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 4.0F, 0.1745F, 0.0F, 0.0F));


        Chest.addOrReplaceChild("Chest_lush", CubeListBuilder.create().texOffs(31, 76).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.8F, -6.4F, 0.1309F, 0.0F, 0.0F));

        Chest.addOrReplaceChild("Chest2", CubeListBuilder.create().texOffs(0, 65).addBox(-5.0F, 0.5F, -8.0F, 10.0F, 6.0F, 7.0F, new CubeDeformation(0.6F))
                .texOffs(65, 49).addBox(-5.0F, 7.1F, -8.0F, 10.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(65, 0).addBox(-4.0F, -3.9F, -6.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(0.0F, -3.9F, -1.4F, 0.1309F, 0.0F, 0.0F));

        PartDefinition Waist = body.addOrReplaceChild("Waist", CubeListBuilder.create().texOffs(35, 65).addBox(-4.0F, -0.3F, 0.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 5.0F, 2.3F, -0.1745F, 0.0F, 0.0F));

        Waist.addOrReplaceChild("Waist_Lush", CubeListBuilder.create().texOffs(65, 13).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

}
