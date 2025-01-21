package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Draugar_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Draugr_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.WardenModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.HumanoidArm;

public class Draugr_Model extends HierarchicalModel<Draugr_Entity> implements ArmedModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart everything;
	private final ModelPart root;
	private final ModelPart right_leg;
	private final ModelPart left_leg;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart left_arm_r1;
	private final ModelPart left_arm_r2;
	private final ModelPart right_arm;
	private final ModelPart right_arm_r1;
	private final ModelPart right_arm_r2;
	private final ModelPart head;
	private final ModelPart maw;
	private final ModelPart body_r1;

	public Draugr_Model(ModelPart root) {
		this.everything = root;
		this.root = this.everything.getChild("root");
		this.right_leg = this.root.getChild("right_leg");
		this.left_leg = this.root.getChild("left_leg");
		this.body = this.root.getChild("body");
		this.left_arm = this.body.getChild("left_arm");
		this.left_arm_r1 = this.left_arm.getChild("left_arm_r1");
		this.left_arm_r2 = this.left_arm.getChild("left_arm_r2");
		this.right_arm = this.body.getChild("right_arm");
		this.right_arm_r1 = this.right_arm.getChild("right_arm_r1");
		this.right_arm_r2 = this.right_arm.getChild("right_arm_r2");
		this.head = this.body.getChild("head");
		this.maw = this.head.getChild("maw");
		this.body_r1 = this.maw.getChild("body_r1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(84, 0).addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offset(-2.0F, -12.0F, 0.1F));

		PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(76, 0).mirror().addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.1F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(52, 0).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.2F))
		.texOffs(32, 36).addBox(-4.0F, -3.0F, -2.0F, 8.0F, 11.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, -0.0873F, -0.2182F, 0.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(76, 0).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(0, 48).mirror().addBox(-1.0F, 3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.5F)).mirror(false)
		.texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, -9.0F, 0.0F, 0.1309F, 0.0F, -0.0436F));

		PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(58, 17).mirror().addBox(-1.0F, -2.0F, -3.5F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9763F, -0.7164F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition left_arm_r2 = left_arm.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(48, 23).mirror().addBox(-1.0F, -2.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -0.5F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(84, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.2F))
		.texOffs(0, 48).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-5.0F, -8.0F, 0.0F, 0.1309F, 0.0F, 0.0436F));

		PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(48, 18).addBox(-1.0F, -3.0F, -1.5F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7526F, -1.3329F, 1.5F, 0.0F, 0.0F, 0.2182F));

		PartDefinition right_arm_r2 = right_arm.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(58, 23).addBox(0.0F, -2.0F, -3.5F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(48, 23).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(92, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(0, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F))
		.texOffs(58, 36).addBox(0.0F, -16.0F, 0.0F, 10.0F, 11.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 55).mirror().addBox(-10.0F, -13.0F, 0.0F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.0F, -1.0F, 0.5079F, 0.1287F, -0.137F));

		PartDefinition maw = head.addOrReplaceChild("maw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.5F, -1.0F, -0.0873F, 0.0F, 0.2182F));

		PartDefinition body_r1 = maw.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(32, 6).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(Draugr_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateHeadLookTarget(netHeadYaw, headPitch);
		this.animateWalk(Draugar_Animation.WALK, limbSwing, limbSwingAmount, 2.0F, 2.0F);
		this.animate(entity.getAnimationState("idle"), Draugar_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attack"), Draugar_Animation.ATTACK, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attack2"), Draugar_Animation.ATTACK2, ageInTicks, 1.0F);

	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot = xRot * ((float) Math.PI / 180F);
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}

	public void translateToHand(HumanoidArm arm, PoseStack poseStack) {
		root.translateAndRotate(poseStack);
		body.translateAndRotate(poseStack);
		if (arm == HumanoidArm.RIGHT) {
			right_arm.translateAndRotate(poseStack);
			poseStack.translate(0.0F, 0.0F, 0.0F);
		} else {
			left_arm.translateAndRotate(poseStack);
			poseStack.translate(0.0F, 0.0F, 0.0F);
		}
	}


	public ModelPart root() {
		return this.root;
	}

}