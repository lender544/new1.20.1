package com.github.L_Ender.cataclysm.client.model.armor;


import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelIgnitium_Armor extends HumanoidModel {

    public ModelIgnitium_Armor(ModelPart p_170677_) {
        super(p_170677_);


    }

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.getChild("head");
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition rightArm = partdefinition.getChild("right_arm");
        PartDefinition leftArm = partdefinition.getChild("left_arm");

        head.addOrReplaceChild("right_helmet", CubeListBuilder.create()
                .texOffs(0, 35)
                .addBox(0.0F, -1.5F, -4.0F, 0.0F, 3.0F, 6.0F,
                        new CubeDeformation(0.0F)), PartPose
                .offsetAndRotation(-4.75F, 0.3F, -4.75F, 0.0F, -0.829F, 0.0F));

        head.addOrReplaceChild("left_helmet", CubeListBuilder.create()
                .texOffs(0, 35)
                        .addBox(0.0F, -1.5F, -4.0F, 0.0F, 3.0F, 6.0F,
                                new CubeDeformation(0.0F))
                        .mirror(false), PartPose
                .offsetAndRotation(4.75F, 0.3F, -4.75F, 0.0F, 0.829F, 0.0F));

        head.addOrReplaceChild("headplate", CubeListBuilder.create()
                .texOffs(48, 34)
                .addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 1.0F,
                        new CubeDeformation(0.0F)), PartPose
                .offsetAndRotation(0.0F, -5.5F, -4.25F, -0.2618F, 0.0F, 0.0F));

        PartDefinition right_horn = head.addOrReplaceChild("right_horn", CubeListBuilder.create()
                .texOffs(54, 43)
                .addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose
                .offsetAndRotation(-3.6F, -6.5F, -3.6F, 0.3927F, 0.2182F, -0.1309F));

        PartDefinition right_horn2 = right_horn.addOrReplaceChild("right_horn2", CubeListBuilder.create()
                .texOffs(13, 41)
                .addBox(-0.5F, -7.0F, 0.0F, 1.0F, 7.0F, 2.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose
                .offsetAndRotation(0.0F, -5.0F, -1.0F, -1.3526F, 0.0F, 0.0F));

        right_horn2.addOrReplaceChild("right_horn3", CubeListBuilder.create()
                .texOffs(53, 37)
                .addBox(-0.5F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F,
                        new CubeDeformation(-0.01F))
                .mirror(false), PartPose
                .offsetAndRotation(0.0F, -7.0F, 2.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition left_horn = head.addOrReplaceChild("left_horn", CubeListBuilder.create()
                .texOffs(54, 43)
                .addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F,
                        new CubeDeformation(0.0F)), PartPose
                .offsetAndRotation(3.6F, -6.5F, -3.6F, 0.3927F, -0.2182F, 0.1309F));

        PartDefinition left_horn2 = left_horn.addOrReplaceChild("left_horn2", CubeListBuilder.create()
                .texOffs(13, 41)
                .addBox(-0.5F, -7.0F, 0.0F, 1.0F, 7.0F, 2.0F,
                        new CubeDeformation(0.0F)), PartPose
                .offsetAndRotation(0.0F, -5.0F, -1.0F, -1.3526F, 0.0F, 0.0F));

        left_horn2.addOrReplaceChild("left_horn3", CubeListBuilder.create()
                .texOffs(53, 37)
                .addBox(-0.5F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F,
                        new CubeDeformation(-0.01F)), PartPose
                .offsetAndRotation(0.0F, -7.0F, 2.0F, -0.5236F, 0.0F, 0.0F));

        body.addOrReplaceChild("outer_body", CubeListBuilder.create()
                .texOffs(30, 47)
                .addBox(-4.5F, 1.0F, -2.5F, 9.0F, 12.0F, 5.0F,
                        new CubeDeformation(0.4F)), PartPose
                .offset(0.0F, -1.0F, 0.0F));

        body.addOrReplaceChild("inner_body", CubeListBuilder.create()
                .texOffs(0, 51)
                .addBox(-4.0F, -6.0F, -2.0F, 8.0F, 9.0F, 4.0F,
                        new CubeDeformation(0.5F)), PartPose
                .offset(0.0F, 11.0F, 0.0F));

        PartDefinition left_shoulderpad = leftArm.addOrReplaceChild("left_shoulderpad", CubeListBuilder.create()
                .texOffs(30, 33)
                .addBox(-6.0F, -7.0F, -3.0F, 5.0F, 7.0F, 6.0F,
                        new CubeDeformation(0.3F)), PartPose
                .offset(5.0F, 4.0F, 0.0F));

        PartDefinition left_spike = left_shoulderpad.addOrReplaceChild("left_spike", CubeListBuilder.create()
                .texOffs(21, 43)
                .addBox(-1.0F, -3.5F, 0.0F, 4.0F, 7.0F, 0.0F,
                        new CubeDeformation(0.0F)), PartPose
                .offsetAndRotation(-1.0F, -8.5F, 0.0F, 0.0F, 0.0F, 0.6109F));

        left_spike.addOrReplaceChild("left_side_spike", CubeListBuilder.create()
                .texOffs(30, 47)
                .addBox(0.5F, -3.5F, -0.5F, 2.0F, 4.0F, 0.0F,
                        new CubeDeformation(0.0F)), PartPose
                .offsetAndRotation(2.5F, 3.0F, 0.5F, 0.0F, 0.0F, 0.829F));

        PartDefinition right_shoulderpad = rightArm.addOrReplaceChild("right_shoulderpad", CubeListBuilder.create()
                .texOffs(30, 33)
                .mirror()
                .addBox(0.0F, -7.0F, -3.0F, 5.0F, 7.0F, 6.0F,
                        new CubeDeformation(0.3F)).mirror(false), PartPose
                .offset(-4.0F, 4.0F, 0.0F));

        PartDefinition right_spike = right_shoulderpad.addOrReplaceChild("right_spike", CubeListBuilder.create()
                .texOffs(21, 43)
                .mirror()
                .addBox(-3.0F, -3.5F, 0.0F, 4.0F, 7.0F, 0.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose
                .offsetAndRotation(0.0F, -8.5F, 0.0F, 0.0F, 0.0F, -0.6109F));

        right_spike.addOrReplaceChild("right_side_spike", CubeListBuilder.create()
                .texOffs(30, 47)
                .mirror()
                .addBox(-2.5F, -3.5F, -0.5F, 2.0F, 4.0F, 0.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose
                .offsetAndRotation(-2.5F, 3.0F, 0.5F, 0.0F, 0.0F, -0.829F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

}
