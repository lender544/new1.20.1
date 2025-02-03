package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.0.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.AnimationMonster.Endermaptera_Entity;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Endermaptera_Model extends AdvancedEntityModel<Endermaptera_Entity> {
	public final AdvancedModelBox root;
	public final AdvancedModelBox body;
	public final AdvancedModelBox abdomen;
	public final AdvancedModelBox head;
	public final AdvancedModelBox head_left;
	public final AdvancedModelBox head_right;
	public final AdvancedModelBox head_top;
	public final AdvancedModelBox left_antenna;
	public final AdvancedModelBox right_antenna;
	public final AdvancedModelBox right_jaw;
	public final AdvancedModelBox left_jaw;
	public final AdvancedModelBox right_leg_front;
	public final AdvancedModelBox left_leg_front;
	public final AdvancedModelBox right_leg_mid;
	public final AdvancedModelBox left_leg_mid;
	public final AdvancedModelBox right_leg_back;
	public final AdvancedModelBox left_leg_back;
	private ModelAnimator animator;


	public Endermaptera_Model() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);

		body = new AdvancedModelBox(this);
		body.setRotationPoint(0.0F, -1.0F, 0.0F);
		root.addChild(body);
		body.setTextureOffset(22, 15).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 4.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(0.0F, -7.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);

		abdomen = new AdvancedModelBox(this);
		abdomen.setRotationPoint(0.0F, -2.0F, 1.0F);
		body.addChild(abdomen);
		setRotationAngle(abdomen, 0.2618F, 0.0F, 0.0F);
		abdomen.setTextureOffset(0, 15).addBox(-3.0F, -2.5F, 0.5F, 6.0F, 5.0F, 9.0F, 0.5F, false);
		abdomen.setTextureOffset(0, 0).addBox(-3.0F, -2.5F, 0.5F, 6.0F, 5.0F, 9.0F, 0.25F, false);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, -0.85F, -4.5F);
		body.addChild(head);
		head.setTextureOffset(29, 34).addBox(-1.5F, -2.15F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		head_left = new AdvancedModelBox(this);
		head_left.setRotationPoint(2.0F, -0.15F, 1.0F);
		head.addChild(head_left);
		setRotationAngle(head_left, 0.2618F, 0.2618F, 0.2618F);
		head_left.setTextureOffset(0, 37).addBox(-1.5F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, 0.25F, false);

		head_right = new AdvancedModelBox(this);
		head_right.setRotationPoint(-2.0F, -0.15F, 1.0F);
		head.addChild(head_right);
		setRotationAngle(head_right, 0.2618F, -0.2618F, -0.2618F);
		head_right.setTextureOffset(0, 37).addBox(-0.5F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, 0.25F, true);

		head_top = new AdvancedModelBox(this);
		head_top.setRotationPoint(0.0F, -3.95F, 1.0F);
		head.addChild(head_top);
		setRotationAngle(head_top, 0.5236F, 0.0F, 0.0F);
		head_top.setTextureOffset(0, 30).addBox(-2.0F, 0.8F, -3.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		left_antenna = new AdvancedModelBox(this);
		left_antenna.setRotationPoint(-1.0F, -1.15F, -0.5F);
		head.addChild(left_antenna);
		setRotationAngle(left_antenna, 0.0F, 0.48F, 0.0F);
		left_antenna.setTextureOffset(24, 24).addBox(-1.0F, -2.0F, -6.0F, 1.0F, 2.0F, 7.0F, 0.0F, false);

		right_antenna = new AdvancedModelBox(this);
		right_antenna.setRotationPoint(1.0F, -1.15F, -0.5F);
		head.addChild(right_antenna);
		setRotationAngle(right_antenna, 0.0F, -0.48F, 0.0F);
		right_antenna.setTextureOffset(24, 24).addBox(0.0F, -2.0F, -6.0F, 1.0F, 2.0F, 7.0F, 0.0F, true);

		right_jaw = new AdvancedModelBox(this);
		right_jaw.setRotationPoint(-1.5F, 0.65F, 1.5F);
		head.addChild(right_jaw);
		right_jaw.setTextureOffset(12, 32).addBox(-2.0F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, 0.0F, false);

		left_jaw = new AdvancedModelBox(this);
		left_jaw.setRotationPoint(1.5F, 0.65F, 1.5F);
		head.addChild(left_jaw);
		left_jaw.setTextureOffset(31, 9).addBox(-1.0F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, 0.0F, false);

		right_leg_front = new AdvancedModelBox(this);
		right_leg_front.setRotationPoint(-3.0F, -1.0F, -1.0F);
		body.addChild(right_leg_front);
		setRotationAngle(right_leg_front, 0.0F, -0.5672F, 0.0F);
		right_leg_front.setTextureOffset(34, 24).addBox(-7.0F, -4.0F, 0.0F, 7.0F, 6.0F, 0.0F, 0.0F, true);

		left_leg_front = new AdvancedModelBox(this);
		left_leg_front.setRotationPoint(3.0F, -1.0F, -1.0F);
		body.addChild(left_leg_front);
		setRotationAngle(left_leg_front, 0.0F, 0.5672F, 0.0F);
		left_leg_front.setTextureOffset(34, 24).addBox(0.0F, -4.0F, 0.0F, 7.0F, 6.0F, 0.0F, 0.0F, false);

		right_leg_mid = new AdvancedModelBox(this);
		right_leg_mid.setRotationPoint(-3.0F, -1.0F, 0.0F);
		body.addChild(right_leg_mid);
		right_leg_mid.setTextureOffset(34, 24).addBox(-7.0F, -4.0F, 0.0F, 7.0F, 6.0F, 0.0F, 0.0F, true);

		left_leg_mid = new AdvancedModelBox(this);
		left_leg_mid.setRotationPoint(3.0F, -1.0F, 0.0F);
		body.addChild(left_leg_mid);
		left_leg_mid.setTextureOffset(34, 24).addBox(0.0F, -4.0F, 0.0F, 7.0F, 6.0F, 0.0F, 0.0F, false);

		right_leg_back = new AdvancedModelBox(this);
		right_leg_back.setRotationPoint(-3.0F, -1.0F, 1.0F);
		body.addChild(right_leg_back);
		setRotationAngle(right_leg_back, 0.0F, 0.5672F, 0.0F);
		right_leg_back.setTextureOffset(22, 0).addBox(-10.0F, -6.0F, 0.0F, 10.0F, 8.0F, 0.0F, 0.0F, true);

		left_leg_back = new AdvancedModelBox(this);
		left_leg_back.setRotationPoint(3.0F, -1.0F, 1.0F);
		body.addChild(left_leg_back);
		setRotationAngle(left_leg_back, 0.0F, -0.5672F, 0.0F);
		left_leg_back.setTextureOffset(22, 0).addBox(0.0F, -6.0F, 0.0F, 10.0F, 8.0F, 0.0F, 0.0F, false);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);

		animator.setAnimation(Endermaptera_Entity.JAW_ATTACK);
		animator.startKeyframe(5);
		animator.rotate(right_jaw, 0, (float)Math.toRadians(30F), 0);
		animator.rotate(left_jaw, 0, (float)Math.toRadians(-30F), 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(5);
		animator.resetKeyframe(3);

		animator.setAnimation(Endermaptera_Entity.HEADBUTT_ATTACK);
		animator.startKeyframe(5);
		animator.move(body, 0, 0, -5);
		animator.rotate(head, (float)Math.toRadians(-25), 0, 0);
		animator.rotate(abdomen, (float)Math.toRadians(25), 0, 0);
		animator.rotate(left_antenna, (float)Math.toRadians(-25), (float)Math.toRadians(-25), 0);
		animator.rotate(right_antenna, (float)Math.toRadians(-25), (float)Math.toRadians(25), 0);
		animator.endKeyframe();
		animator.startKeyframe(5);
		animator.move(body, 0, 0, 2);
		animator.rotate(head, (float)Math.toRadians(25), 0, 0);
		animator.endKeyframe();
		animator.resetKeyframe(3);

	}

	@Override
	public void setupAnim(Endermaptera_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		//float upsideDownProgress = entity.prevUpsideDownProgress + (entity.upsideDownProgress - entity.prevUpsideDownProgress) * (ageInTicks - entity.ticksExisted);
		float idleSpeed = 0.25F;
		float idleDegree = 0.25F;
		float walkSpeed = 1F;
		float walkDegree = 1F;
		float offsetleft = 2F;
		//progressPositionPrev(body, upsideDownProgress, 0, -13, 0, 5f);
		//progressRotationPrev(body, upsideDownProgress, 0, 0, (float) Math.toRadians(180) * (entity.fallRotation ? -1F : 1F), 5f);
		this.swing(left_antenna, idleSpeed, idleDegree, true, 1, 0.1F, ageInTicks, 1);
		this.swing(right_antenna, idleSpeed, idleDegree, false, 1, 0.1F, ageInTicks, 1);
		this.walk(left_antenna, idleSpeed, idleDegree * 0.25F, false, -1, -0.05F, ageInTicks, 1);
		this.walk(right_antenna, idleSpeed, idleDegree * 0.25F, false, -1, -0.05F, ageInTicks, 1);
		this.swing(left_leg_back, walkSpeed, walkDegree, false, 0, -0.5F, limbSwing, limbSwingAmount);
		this.swing(right_leg_front, walkSpeed, walkDegree, false, 0, -0.3F, limbSwing, limbSwingAmount);
		this.flap(right_leg_front, walkSpeed, walkDegree * 0.8F, false, -1.5F, 0.4F, limbSwing, limbSwingAmount);
		this.swing(left_leg_mid, walkSpeed, walkDegree, false, 0, 0F, limbSwing, limbSwingAmount);
		this.flap(left_leg_mid, walkSpeed, walkDegree * 0.8F, false, -1.5F, -0.4F, limbSwing, limbSwingAmount);
		this.swing(right_leg_back, walkSpeed, -walkDegree, false, offsetleft,0.5f, limbSwing, limbSwingAmount);
		this.swing(left_leg_front, walkSpeed, -walkDegree, false, offsetleft,0.3F, limbSwing, limbSwingAmount);
		this.flap(left_leg_front, walkSpeed, walkDegree * 0.8F, false, offsetleft + 1.5F, -0.4F, limbSwing, limbSwingAmount);
		this.swing(right_leg_mid, walkSpeed, -walkDegree, false, offsetleft, 0, limbSwing, limbSwingAmount);
		this.flap(right_leg_mid, walkSpeed, walkDegree * 0.8F, false, offsetleft-1.5F, 0.4F, limbSwing, limbSwingAmount);
		this.swing(abdomen, walkSpeed, walkDegree * 0.2F, false, 3, 0, limbSwing, limbSwingAmount);
		this.faceTarget(netHeadYaw, headPitch, 1.0F, head);
		right_jaw.showModel = entity.getHasJaws();
		left_jaw.showModel = entity.getHasJaws();
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				head,
				body,
				abdomen,
				left_antenna,
				right_antenna,
				left_jaw,
				right_jaw,
				left_leg_front,
				right_leg_front,
				left_leg_mid,
				right_leg_mid,
				left_leg_back,
				right_leg_back

		);
	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}