package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Draugar_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;

public class Model_Royal_Draugr extends AdvancedEntityModel<Royal_Draugr_Entity>  implements ArmedModel {
	private final AdvancedModelBox root;
	private final AdvancedModelBox right_leg;
	private final AdvancedModelBox left_leg;
	private final AdvancedModelBox body;
	private final AdvancedModelBox left_arm;
	private final AdvancedModelBox left_arm_r1;
	private final AdvancedModelBox left_arm_r2;
	private final AdvancedModelBox right_arm;
	private final AdvancedModelBox right_arm_r1;
	private final AdvancedModelBox head;
	private final AdvancedModelBox maw;
	private final AdvancedModelBox body_r1;

	public Model_Royal_Draugr() {
		texWidth = 128;
		texHeight = 64;

		root = new AdvancedModelBox(this,"root");
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		right_leg = new AdvancedModelBox(this,"right_leg");
		right_leg.setRotationPoint(-2.0F, -12.0F, 0.1F);
		root.addChild(right_leg);
		right_leg.setTextureOffset(0, 16).addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		right_leg.setTextureOffset(84, 0).addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, 0.2F, false);

		left_leg = new AdvancedModelBox(this,"left_leg");
		left_leg.setRotationPoint(2.0F, -12.0F, 0.1F);
		root.addChild(left_leg);
		left_leg.setTextureOffset(0, 16).addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, 0.0F, true);
		left_leg.setTextureOffset(76, 0).addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, 0.2F, true);

		body = new AdvancedModelBox(this,"body");
		body.setRotationPoint(0.0F, -12.0F, 0.0F);
		root.addChild(body);
		setRotationAngle(body, 0.0873F, 0.0F, 0.0436F);
		body.setTextureOffset(16, 16).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(52, 0).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.2F, false);
		body.setTextureOffset(104, 26).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.4F, false);
		body.setTextureOffset(32, 36).addBox(-4.0F, -3.0F, -2.0F, 8.0F, 11.0F, 4.0F, 0.5F, false);

		left_arm = new AdvancedModelBox(this,"left_arm");
		left_arm.setRotationPoint(5.0F, -9.0F, 0.0F);
		body.addChild(left_arm);
		setRotationAngle(left_arm, -0.0873F, 0.0F, -0.0873F);
		left_arm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, true);
		left_arm.setTextureOffset(76, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.2F, true);
		left_arm.setTextureOffset(0, 48).addBox(-1.0F, 3.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.5F, true);
		left_arm.setTextureOffset(118, 42).addBox(0.0F, 2.0F, -1.5F, 2.0F, 7.0F, 3.0F, 0.2F, true);
		left_arm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, true);

		left_arm_r1 = new AdvancedModelBox(this,"left_arm_r1");
		left_arm_r1.setRotationPoint(1.9763F, -0.7164F, 0.0F);
		left_arm.addChild(left_arm_r1);
		setRotationAngle(left_arm_r1, 0.0F, 0.0F, -0.2182F);
		left_arm_r1.setTextureOffset(58, 17).addBox(-1.0F, -2.0F, -3.5F, 0.0F, 6.0F, 7.0F, 0.0F, true);

		left_arm_r2 = new AdvancedModelBox(this,"left_arm_r2");
		left_arm_r2.setRotationPoint(1.0F, -0.5F, 0.0F);
		left_arm.addChild(left_arm_r2);
		setRotationAngle(left_arm_r2, 0.0F, 0.0F, -0.2182F);
		left_arm_r2.setTextureOffset(48, 23).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 4.0F, 3.0F, 0.0F, true);

		right_arm = new AdvancedModelBox(this,"right_arm");
		right_arm.setRotationPoint(-5.0F, -8.0F, 0.0F);
		body.addChild(right_arm);
		setRotationAngle(right_arm, -0.0873F, 0.0F, 0.0F);
		right_arm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		right_arm.setTextureOffset(84, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.2F, false);
		right_arm.setTextureOffset(0, 48).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.5F, false);

		right_arm_r1 = new AdvancedModelBox(this,"right_arm_r1");
		right_arm_r1.setRotationPoint(-1.0F, -0.5F, -0.5F);
		right_arm.addChild(right_arm_r1);
		setRotationAngle(right_arm_r1, 0.0F, 0.0F, 0.2182F);
		right_arm_r1.setTextureOffset(104, 52).addBox(-3.0F, -4.0F, -2.5F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		head = new AdvancedModelBox(this,"head");
		head.setRotationPoint(0.0F, -12.0F, -1.0F);
		body.addChild(head);
		setRotationAngle(head, 0.1309F, 0.0F, 0.1745F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(92, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.2F, false);
		head.setTextureOffset(0, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);
		head.setTextureOffset(58, 36).addBox(0.0F, -16.0F, 0.0F, 10.0F, 11.0F, 0.0F, 0.0F, false);
		head.setTextureOffset(0, 55).addBox(-10.0F, -13.0F, 0.0F, 6.0F, 8.0F, 0.0F, 0.0F, true);

		maw = new AdvancedModelBox(this,"maw");
		maw.setRotationPoint(0.0F, -2.5F, -1.0F);
		head.addChild(maw);
		setRotationAngle(maw, 0.346F, -0.0636F, -0.1737F);


		body_r1 = new AdvancedModelBox(this,"body_r1");
		body_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		maw.addChild(body_r1);
		setRotationAngle(body_r1, -0.1309F, 0.0F, 0.0F);
		body_r1.setTextureOffset(32, 6).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 5.0F, 4.0F, 0.0F, false);

		this.updateDefaultPose();
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root,
		 right_leg,
		 left_leg,
		 body,
		 left_arm,
		 left_arm_r1,
		 left_arm_r2,
		 right_arm,
		 right_arm_r1,
		 head,
		 maw,
		 body_r1);
	}

	@Override
	public void setupAnim(Royal_Draugr_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.resetToDefaultPose();
		this.faceTarget(netHeadYaw, headPitch, 1, head);
		this.animateWalk(Draugar_Animation.WALK, limbSwing, limbSwingAmount, 2.0F, 2.0F);
		this.animate(entity.getAnimationState("idle"), Draugar_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attack"), Draugar_Animation.ATTACK, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attack2"), Draugar_Animation.ATTACK2, ageInTicks, 1.0F);

		boolean flag2 = entity.getMainArm() == HumanoidArm.RIGHT;
		if (entity.isUsingItem()) {
			boolean flag3 = entity.getUsedItemHand() == InteractionHand.MAIN_HAND;
			if (flag3 == flag2) {
				this.right_arm.rotateAngleX = this.right_arm.rotateAngleX * 0.5F - 0.9424779F;
				this.right_arm.rotateAngleY = (-(float)Math.PI / 6F);
			} else {
				this.left_arm.rotateAngleX = this.left_arm.rotateAngleX * 0.5F - 0.9424779F;
				this.left_arm.rotateAngleY = ((float)Math.PI / 6F);
			}
		}
	}

	@Override
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

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}