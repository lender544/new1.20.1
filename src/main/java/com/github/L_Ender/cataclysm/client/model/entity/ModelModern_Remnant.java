package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.Pet.Modern_Remnant_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class ModelModern_Remnant extends AdvancedEntityModel<Modern_Remnant_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox body;
	private final AdvancedModelBox upper_body;
	private final AdvancedModelBox right_arm;
	private final AdvancedModelBox right_hand;
	private final AdvancedModelBox left_arm;
	private final AdvancedModelBox left_hand;
	private final AdvancedModelBox neck;
	private final AdvancedModelBox bandage;
	private final AdvancedModelBox headjoint;
	private final AdvancedModelBox head;
	private final AdvancedModelBox helmet;
	private final AdvancedModelBox helmet2;
	private final AdvancedModelBox jaw;
	private final AdvancedModelBox tail;
	private final AdvancedModelBox tail2;
	private final AdvancedModelBox tail3;
	private final AdvancedModelBox right_leg;
	private final AdvancedModelBox right_leg_armor;
	private final AdvancedModelBox right_leg2;
	private final AdvancedModelBox right_leg_armor2;
	private final AdvancedModelBox right_leg_armor3;
	private final AdvancedModelBox left_leg;
	private final AdvancedModelBox left_leg_armor;
	private final AdvancedModelBox left_leg2;
	private final AdvancedModelBox left_leg_armor2;
	private final AdvancedModelBox left_leg_armor3;
	private ModelAnimator animator;

	public ModelModern_Remnant() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		body = new AdvancedModelBox(this);
		body.setRotationPoint(0.0F, -8.0F, -1.0F);
		root.addChild(body);
		body.setTextureOffset(0, 0).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 5.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(14, 14).addBox(0.0F, -6.0F, -3.0F, 0.0F, 4.0F, 7.0F, 0.0F, false);

		upper_body = new AdvancedModelBox(this);
		upper_body.setRotationPoint(0.0F, -1.9F, -2.4F);
		body.addChild(upper_body);
		setRotationAngle(upper_body, -0.1745F, 0.0F, 0.0F);
		upper_body.setTextureOffset(0, 30).addBox(-2.5F, 0.0F, -3.3F, 5.0F, 4.0F, 3.0F, 0.0F, false);
		upper_body.setTextureOffset(25, 0).addBox(-2.5F, 0.0F, -3.3F, 5.0F, 4.0F, 3.0F, 0.3F, false);
		upper_body.setTextureOffset(0, 0).addBox(0.0F, -3.0F, -3.3F, 0.0F, 3.0F, 3.0F, 0.0F, false);

		right_arm = new AdvancedModelBox(this);
		right_arm.setRotationPoint(-3.0F, 2.5F, -2.8F);
		upper_body.addChild(right_arm);
		setRotationAngle(right_arm, 0.1745F, 0.0F, 0.0F);
		right_arm.setTextureOffset(16, 13).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		right_hand = new AdvancedModelBox(this);
		right_hand.setRotationPoint(0.0F, 2.0F, -0.5F);
		right_arm.addChild(right_hand);
		right_hand.setTextureOffset(18, 0).addBox(0.0F, -0.5F, -3.0F, 0.0F, 3.0F, 3.0F, 0.0F, false);

		left_arm = new AdvancedModelBox(this);
		left_arm.setRotationPoint(3.0F, 2.5F, -2.8F);
		upper_body.addChild(left_arm);
		setRotationAngle(left_arm, 0.1745F, 0.0F, 0.0F);
		left_arm.setTextureOffset(16, 13).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);

		left_hand = new AdvancedModelBox(this);
		left_hand.setRotationPoint(0.0F, 2.0F, -0.5F);
		left_arm.addChild(left_hand);
		left_hand.setTextureOffset(18, 0).addBox(0.0F, -0.5F, -3.0F, 0.0F, 3.0F, 3.0F, 0.0F, true);

		neck = new AdvancedModelBox(this);
		neck.setRotationPoint(0.0F, 0.0F, -3.3F);
		upper_body.addChild(neck);
		neck.setTextureOffset(22, 8).addBox(-1.5F, 0.0F, -5.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		neck.setTextureOffset(48, 7).addBox(0.0F, -1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 0.0F, false);

		bandage = new AdvancedModelBox(this);
		bandage.setRotationPoint(0.0F, 0.0F, -2.5F);
		neck.addChild(bandage);
		setRotationAngle(bandage, 0.1745F, 0.0F, 0.0F);
		bandage.setTextureOffset(30, 30).addBox(-1.5F, -1.1F, -1.0F, 3.0F, 8.0F, 2.0F, 0.2F, false);

		headjoint = new AdvancedModelBox(this);
		headjoint.setRotationPoint(0.0F, 0.0F, -4.6F);
		neck.addChild(headjoint);
		setRotationAngle(headjoint, 0.1745F, 0.0F, 0.0F);


		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		headjoint.addChild(head);
		head.setTextureOffset(37, 37).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 3.0F, 4.0F, 0.1F, false);
		head.setTextureOffset(50, 40).addBox(0.0F, -4.0F, -6.3F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(15, 40).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 8.0F, 2.0F, 0.2F, false);
		head.setTextureOffset(24, 41).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 4.0F, 0.1F, false);
		head.setTextureOffset(25, 22).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		helmet = new AdvancedModelBox(this);
		helmet.setRotationPoint(0.0F, -2.0F, -2.0F);
		head.addChild(helmet);
		setRotationAngle(helmet, -0.1745F, 0.0F, 0.0F);
		helmet.setTextureOffset(0, 13).addBox(-2.5F, -1.4F, -2.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		helmet.setTextureOffset(0, 50).addBox(-4.0F, -1.4F, 0.5F, 2.0F, 7.0F, 0.0F, 0.0F, false);
		helmet.setTextureOffset(0, 50).addBox(2.0F, -1.4F, 0.5F, 2.0F, 7.0F, 0.0F, 0.0F, true);

		helmet2 = new AdvancedModelBox(this);
		helmet2.setRotationPoint(0.0F, -1.3F, -2.7F);
		helmet.addChild(helmet2);
		setRotationAngle(helmet2, -0.2618F, 0.0F, 0.0F);
		helmet2.setTextureOffset(0, 13).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);

		jaw = new AdvancedModelBox(this);
		jaw.setRotationPoint(0.0F, 1.0F, -1.5F);
		head.addChild(jaw);
		jaw.setTextureOffset(0, 38).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 1.0F, 3.0F, 0.0F, false);
		jaw.setTextureOffset(41, 26).addBox(-1.0F, 0.0F, -6.5F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		jaw.setTextureOffset(38, 20).addBox(-1.0F, -1.0F, -6.5F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		tail = new AdvancedModelBox(this);
		tail.setRotationPoint(0.0F, 0.0F, 4.0F);
		body.addChild(tail);
		tail.setTextureOffset(0, 21).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		tail.setTextureOffset(32, 45).addBox(0.0F, -2.0F, 1.0F, 0.0F, 1.0F, 5.0F, 0.0F, false);
		tail.setTextureOffset(45, 0).addBox(0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 5.0F, 0.0F, false);

		tail2 = new AdvancedModelBox(this);
		tail2.setRotationPoint(0.0F, 0.5F, 6.0F);
		tail.addChild(tail2);
		tail2.setTextureOffset(34, 12).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 5.0F, 0.0F, false);
		tail2.setTextureOffset(0, 43).addBox(0.0F, -2.0F, 0.0F, 0.0F, 1.0F, 5.0F, 0.0F, false);
		tail2.setTextureOffset(42, 10).addBox(0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 5.0F, 0.0F, false);

		tail3 = new AdvancedModelBox(this);
		tail3.setRotationPoint(0.0F, 0.0F, 5.0F);
		tail2.addChild(tail3);
		tail3.setTextureOffset(37, 3).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		tail3.setTextureOffset(47, 17).addBox(0.0F, -1.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, false);
		tail3.setTextureOffset(7, 47).addBox(0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, false);

		right_leg = new AdvancedModelBox(this);
		right_leg.setRotationPoint(-3.5F, -8.0F, -1.0F);
		root.addChild(right_leg);
		right_leg.setTextureOffset(17, 30).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 5.0F, 4.0F, 0.0F, false);

		right_leg_armor = new AdvancedModelBox(this);
		right_leg_armor.setRotationPoint(0.0F, 2.5F, -1.0F);
		right_leg.addChild(right_leg_armor);
		setRotationAngle(right_leg_armor, 0.3054F, 0.0F, 0.0F);
		right_leg_armor.setTextureOffset(43, 45).addBox(-1.0F, -3.5F, -1.3F, 2.0F, 4.0F, 2.0F, 0.2F, true);

		right_leg2 = new AdvancedModelBox(this);
		right_leg2.setRotationPoint(0.0F, 4.0F, 1.55F);
		right_leg.addChild(right_leg2);
		right_leg2.setTextureOffset(46, 33).addBox(-1.0F, 0.0F, -1.05F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		right_leg2.setTextureOffset(22, 17).addBox(-1.0F, 3.0F, -2.05F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		right_leg_armor2 = new AdvancedModelBox(this);
		right_leg_armor2.setRotationPoint(0.0F, 1.5F, 0.95F);
		right_leg2.addChild(right_leg_armor2);
		setRotationAngle(right_leg_armor2, -0.48F, 0.0F, 0.0F);
		right_leg_armor2.setTextureOffset(24, 48).addBox(-0.5F, -2.5F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		right_leg_armor3 = new AdvancedModelBox(this);
		right_leg_armor3.setRotationPoint(0.0F, 2.0F, -1.15F);
		right_leg2.addChild(right_leg_armor3);
		setRotationAngle(right_leg_armor3, 0.4363F, 0.0F, 0.0F);
		right_leg_armor3.setTextureOffset(0, 21).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		left_leg = new AdvancedModelBox(this);
		left_leg.setRotationPoint(3.5F, -8.0F, -1.0F);
		root.addChild(left_leg);
		left_leg.setTextureOffset(17, 30).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 5.0F, 4.0F, 0.0F, true);

		left_leg_armor = new AdvancedModelBox(this);
		left_leg_armor.setRotationPoint(0.0F, 2.5F, -1.0F);
		left_leg.addChild(left_leg_armor);
		setRotationAngle(left_leg_armor, 0.3054F, 0.0F, 0.0F);
		left_leg_armor.setTextureOffset(43, 45).addBox(-1.0F, -3.5F, -1.3F, 2.0F, 4.0F, 2.0F, 0.2F, false);

		left_leg2 = new AdvancedModelBox(this);
		left_leg2.setRotationPoint(0.0F, 4.0F, 1.55F);
		left_leg.addChild(left_leg2);
		left_leg2.setTextureOffset(46, 33).addBox(-1.0F, 0.0F, -1.05F, 2.0F, 4.0F, 2.0F, 0.0F, true);
		left_leg2.setTextureOffset(22, 17).addBox(-1.0F, 3.0F, -2.05F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		left_leg_armor2 = new AdvancedModelBox(this);
		left_leg_armor2.setRotationPoint(0.0F, 1.5F, 0.95F);
		left_leg2.addChild(left_leg_armor2);
		setRotationAngle(left_leg_armor2, -0.48F, 0.0F, 0.0F);
		left_leg_armor2.setTextureOffset(24, 48).addBox(-0.5F, -2.5F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, true);

		left_leg_armor3 = new AdvancedModelBox(this);
		left_leg_armor3.setRotationPoint(0.0F, 2.0F, -1.15F);
		left_leg2.addChild(left_leg_armor3);
		setRotationAngle(left_leg_armor3, 0.4363F, 0.0F, 0.0F);
		left_leg_armor3.setTextureOffset(0, 21).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	public void animate(Modern_Remnant_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(Modern_Remnant_Entity.MODERN_REMNANT_BITE);
		animator.startKeyframe(3);
		animator.rotate(root,0,(float)Math.toRadians(-12.5f),0);
		animator.rotate(body,(float)Math.toRadians(-10f),0,(float)Math.toRadians(7.5f));
		animator.rotate(upper_body,(float)Math.toRadians(-5f),0,0);
		animator.rotate(right_arm,(float)Math.toRadians(-22.5f),(float)Math.toRadians(5f),(float)Math.toRadians(20f));
		animator.rotate(right_hand,(float)Math.toRadians(30f),0,0);
		animator.rotate(left_arm,(float)Math.toRadians(-25f),(float)Math.toRadians(-5f),(float)Math.toRadians(-20f));
		animator.rotate(left_hand,(float)Math.toRadians(32.5f),0,0);
		animator.rotate(neck,(float)Math.toRadians(-15f),0,0);
		animator.rotate(head,(float)Math.toRadians(-22.5f),0,0);
		animator.rotate(jaw,(float)Math.toRadians(70f),0,0);
		animator.rotate(tail,(float)Math.toRadians(-7.5f),(float)Math.toRadians(-2.5f),0);
		animator.rotate(tail2,0,(float)Math.toRadians(-12.5f),0);
		animator.rotate(tail3,0,(float)Math.toRadians(-15f),0);

		animator.move(left_leg,0,-1.5f,-1);
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.move(root,0,0.2F,0);
		animator.rotate(root,0,(float)Math.toRadians(12.5f),0);
		animator.rotate(body,0,(float)Math.toRadians(7.5f),(float)Math.toRadians(-6.66f));
		animator.rotate(upper_body,(float)Math.toRadians(-5f),(float)Math.toRadians(10f),(float)Math.toRadians(-2.5f));
		animator.rotate(right_arm,(float)Math.toRadians(-17.5f),(float)Math.toRadians(5f),(float)Math.toRadians(20f));
		animator.rotate(right_hand,(float)Math.toRadians(22.5f),0,0);
		animator.rotate(left_arm,(float)Math.toRadians(-15f),(float)Math.toRadians(-5f),(float)Math.toRadians(-20f));
		animator.rotate(left_hand,(float)Math.toRadians(22.5f),0,0);
		animator.rotate(neck,(float)Math.toRadians(27.5f),(float)Math.toRadians(3.5f),(float)Math.toRadians(10f));
		animator.rotate(head,(float)Math.toRadians(-2.5f),(float)Math.toRadians(50f),(float)Math.toRadians(-5f));
		animator.rotate(tail,(float)Math.toRadians(-20f),(float)Math.toRadians(15f),0);
		animator.rotate(tail2,0,(float)Math.toRadians(10f),0);
		animator.rotate(tail3,0,(float)Math.toRadians(7.5f),0);
		animator.rotate(right_leg,(float)Math.toRadians(5f),0,0);
		animator.move(right_leg,0,0,2);
		animator.rotate(left_leg,0,(float)Math.toRadians(-22.5f),0);
		animator.move(left_leg,0,0,-1.5F);
		animator.endKeyframe();

		animator.resetKeyframe(5);
	}

	@Override
	public void setupAnim(Modern_Remnant_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		float walkSpeed = 0.8F;
		float walkDegree = 0.85F;
		float idleSpeed = 0.1F;
		float idleDegree = 0.4F;
		float partialTick = Minecraft.getInstance().getFrameTime();

		AdvancedModelBox[] tailBoxes = new AdvancedModelBox[]{tail, tail2,tail3};

		this.walk(root, walkSpeed * 2F, walkDegree * 0.05F, false, -2, 0.0F, limbSwing, limbSwingAmount);
		this.bob(root, -walkSpeed, walkDegree * -4, true, limbSwing, limbSwingAmount);
		this.chainSwing(tailBoxes, idleSpeed, idleDegree * 0.3F, -2F, ageInTicks, 1.0F);
		this.walk(left_leg, walkSpeed, walkDegree * 1, true, 0, 0.2F, limbSwing, limbSwingAmount);
		this.walk(left_leg2, walkSpeed, walkDegree * 0.5F, true, -1F, -0.2F, limbSwing, limbSwingAmount);
		this.swing(left_leg2, walkSpeed, walkDegree * -0.5F, true, -1F, 0F, limbSwing, limbSwingAmount);
		this.walk(right_leg, walkSpeed, walkDegree * 1, false, 0, 0.2F, limbSwing, limbSwingAmount);
		this.walk(right_leg2, walkSpeed, walkDegree * 0.5F, false, -1F, -0.2F, limbSwing, limbSwingAmount);
		this.swing(right_leg2, walkSpeed, walkDegree * -0.5F, false, -1F, 0F, limbSwing, limbSwingAmount);
		this.walk(neck, walkSpeed * 2F, walkDegree * 0.3F, false, -1F, -0.5F, limbSwing, limbSwingAmount);
		this.walk(head, walkSpeed * 2F, walkDegree * 0.3F, true, -1F, -0.5F, limbSwing, limbSwingAmount);
		this.walk(left_arm, walkSpeed * 2F, walkDegree * 0.3F, false, 1F, -0.1F, limbSwing, limbSwingAmount);
		this.walk(right_arm, walkSpeed * 2F, walkDegree * 0.3F, false, 1F, -0.1F, limbSwing, limbSwingAmount);

		this.walk(right_arm, 0.1F, 0.1F, false, 3F, 0.1F, ageInTicks, 1);
		this.walk(left_arm, 0.1F, 0.1F, false, 3F, 0.1F, ageInTicks, 1);
		this.swing(right_hand, 0.1F, 0.1F, true, 3F, 0.1F, ageInTicks, 1);
		this.swing(left_hand, 0.1F, 0.1F, false, 3F, 0.1F, ageInTicks, 1);
		this.walk(neck, 0.1F, 0.05F, false, 4F, 0.1F, ageInTicks, 1);
		this.walk(head, 0.1F, 0.05F, true, 4F, 0.1F, ageInTicks, 1);

		this.walk(jaw, 0.1F * idleSpeed, idleDegree * 0.25F, true, 0.2f, -idleDegree * 0.25F, ageInTicks, 1);

		this.bob(body, 0.4F * idleSpeed, idleDegree * 2, false, ageInTicks, 1);

		float sitProgress = entityIn.prevSitProgress + (entityIn.sitProgress - entityIn.prevSitProgress) * partialTick;
		this.faceTarget(netHeadYaw, headPitch, 1.0F, head, neck);

		progressPositionPrev(root,sitProgress,0, 5, 0, 10f);
		progressRotationPrev(neck,sitProgress,(float)Math.toRadians(30F), 0, 0, 10f);
		progressRotationPrev(head,sitProgress,(float)Math.toRadians(-25F), 0, 0, 10f);
		progressRotationPrev(tail,sitProgress,(float)Math.toRadians(-10F), 0, 0, 10f);
		progressRotationPrev(tail2,sitProgress,(float)Math.toRadians(2.5F), 0, 0, 10f);
		progressRotationPrev(tail3,sitProgress,(float)Math.toRadians(15F), 0, 0, 10f);
		progressRotationPrev(right_leg,sitProgress, (float)Math.toRadians(-90F), (float)Math.toRadians(15F), 0, 10f);
		progressPositionPrev(right_leg,sitProgress,0, 1, 0, 10f);
		progressRotationPrev(left_leg,sitProgress, (float)Math.toRadians(-90F), (float)Math.toRadians(-15F), 0, 10f);
		progressPositionPrev(left_leg,sitProgress,0, 1, 0, 10f);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,body,upper_body,right_arm,right_hand,left_arm,left_hand,neck,bandage,headjoint,head,helmet,helmet2,jaw,tail,tail2,tail3,right_leg,right_leg2,left_leg,left_leg2
				);
	}

	@Override
    public Iterable<BasicModelPart> parts() {
        return ImmutableList.of(root);
    }

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}