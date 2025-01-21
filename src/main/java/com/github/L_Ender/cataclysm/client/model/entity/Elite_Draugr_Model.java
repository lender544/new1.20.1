package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Elite_Draugr_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Elite_Draugr_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.HumanoidArm;

public class Elite_Draugr_Model extends HierarchicalModel<Elite_Draugr_Entity> implements ArmedModel {

	private final ModelPart everything;
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart front_cloth1;
	private final ModelPart front_cloth2;
	private final ModelPart back_cloth1;
	private final ModelPart back_cloth2;
	private final ModelPart waist;
	private final ModelPart chest;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart maw;
	private final ModelPart l_arm;
	private final ModelPart cube_r1;
	private final ModelPart l_arm2;
	private final ModelPart r_arm;
	private final ModelPart cube_r2;
	private final ModelPart r_arm2;
	private final ModelPart right_leg;
	private final ModelPart left_leg;


	public Elite_Draugr_Model(ModelPart root) {
		this.everything = root;
		this.root = this.everything.getChild("root");
		this.body = this.root.getChild("body");
		this.front_cloth1 = this.body.getChild("front_cloth1");
		this.front_cloth2 = this.front_cloth1.getChild("front_cloth2");
		this.back_cloth1 = this.body.getChild("back_cloth1");
		this.back_cloth2 = this.back_cloth1.getChild("back_cloth2");
		this.waist = this.body.getChild("waist");
		this.chest = this.waist.getChild("chest");
		this.neck = this.chest.getChild("neck");
		this.head = this.neck.getChild("head");
		this.maw = this.head.getChild("maw");
		this.l_arm = this.chest.getChild("l_arm");
		this.cube_r1 = this.l_arm.getChild("cube_r1");
		this.l_arm2 = this.l_arm.getChild("l_arm2");
		this.r_arm = this.chest.getChild("r_arm");
		this.cube_r2 = this.r_arm.getChild("cube_r2");
		this.r_arm2 = this.r_arm.getChild("r_arm2");
		this.right_leg = this.root.getChild("right_leg");
		this.left_leg = this.root.getChild("left_leg");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(52, 0).addBox(-5.0F, -4.0F, -2.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition front_cloth1 = body.addOrReplaceChild("front_cloth1", CubeListBuilder.create().texOffs(60, 8).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition front_cloth2 = front_cloth1.addOrReplaceChild("front_cloth2", CubeListBuilder.create().texOffs(56, 44).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition back_cloth1 = body.addOrReplaceChild("back_cloth1", CubeListBuilder.create().texOffs(38, 16).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition back_cloth2 = back_cloth1.addOrReplaceChild("back_cloth2", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition waist = body.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(80, 50).addBox(-1.5F, -8.0F, -1.0F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 1.0F));

		PartDefinition chest = waist.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(80, 60).addBox(-1.5F, -8.0F, -1.0F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 50).addBox(-6.0F, -8.0F, -4.0F, 12.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(-6.0F, -8.0F, -4.0F, 12.0F, 10.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(16, 18).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 48).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(96, 112).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.1F))
		.texOffs(0, 64).addBox(-11.0F, -15.0F, 0.0F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(80, 0).addBox(4.0F, -12.0F, 0.0F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.4F)), PartPose.offset(0.0F, -2.0F, -1.0F));

		PartDefinition maw = head.addOrReplaceChild("maw", CubeListBuilder.create().texOffs(60, 60).addBox(-3.0F, -2.5F, -2.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.5F, -3.0F, 0.2102F, 0.0504F, -0.3014F));

		PartDefinition l_arm = chest.addOrReplaceChild("l_arm", CubeListBuilder.create().texOffs(72, 32).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(26, 76).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(7.0F, -6.0F, -1.0F));

		PartDefinition cube_r1 = l_arm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -2.5F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition l_arm2 = l_arm.addOrReplaceChild("l_arm2", CubeListBuilder.create().texOffs(52, 69).addBox(-2.0F, 2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.2F))
		.texOffs(68, 69).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition r_arm = chest.addOrReplaceChild("r_arm", CubeListBuilder.create().texOffs(72, 20).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(64, 50).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-7.0F, -6.0F, -1.0F));

		PartDefinition cube_r2 = r_arm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(17, 11).addBox(-5.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(17, 9).addBox(0.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-2.0F, -4.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -5.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-3.0F, -2.0F, -2.5F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition r_arm2 = r_arm.addOrReplaceChild("r_arm2", CubeListBuilder.create().texOffs(68, 69).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(36, 64).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(56, 28).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -12.0F, 0.0F));

		PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(56, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Elite_Draugr_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateHeadLookTarget(netHeadYaw, headPitch);

		this.animateWalk(Elite_Draugr_Animation.WALK, limbSwing, limbSwingAmount, 2.0F, 2.0F);
		this.animate(entity.getAnimationState("idle"), Elite_Draugr_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("re_load"), Elite_Draugr_Animation.RE_LOAD, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("shoot"), Elite_Draugr_Animation.SHOOT, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("shoot2"), Elite_Draugr_Animation.SHOOT2, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("swing"), Elite_Draugr_Animation.SWING, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attack"), Elite_Draugr_Animation.ATTACK, ageInTicks, 1.5F);
		this.animate(entity.getAnimationState("attack2"), Elite_Draugr_Animation.ATTACK2, ageInTicks, 1.5F);
	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot = xRot * ((float) Math.PI / 180F);
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}

	@Override
	public void translateToHand(HumanoidArm arm, PoseStack poseStack) {
		root.translateAndRotate(poseStack);
		body.translateAndRotate(poseStack);
		waist.translateAndRotate(poseStack);
		chest.translateAndRotate(poseStack);
		if (arm == HumanoidArm.RIGHT) {
			r_arm.translateAndRotate(poseStack);
			r_arm2.translateAndRotate(poseStack);
			poseStack.translate(0.0F, 0.0F, 0.0F);
		} else {
			l_arm.translateAndRotate(poseStack);
			l_arm2.translateAndRotate(poseStack);
			poseStack.translate(0.0F, 0.0F, 0.0F);
		}
	}

	public ModelPart root() {
		return this.root;
	}

}