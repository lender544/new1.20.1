package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.Deepling.Deepling_Warlock_Entity;
import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class Deepling_Warlock_Model extends AdvancedEntityModel<Deepling_Warlock_Entity> {
	public final AdvancedModelBox root;
	private final AdvancedModelBox left_leg;
	private final AdvancedModelBox right_leg;
	public final AdvancedModelBox body;
	private final AdvancedModelBox right_shoulder;
	private final AdvancedModelBox left_shoulder;
	private final AdvancedModelBox neck_back;
	private final AdvancedModelBox right_rib;
	private final AdvancedModelBox left_rib;
	private final AdvancedModelBox neck_forward;
	public final AdvancedModelBox right_arm;
	private final AdvancedModelBox right_finger1;
	private final AdvancedModelBox right_finger2;
	private final AdvancedModelBox right_finger3;
	private final AdvancedModelBox right_finger4;
	public final AdvancedModelBox left_arm;
	private final AdvancedModelBox left_finger1;
	private final AdvancedModelBox left_finger2;
	private final AdvancedModelBox left_finger3;
	private final AdvancedModelBox left_finger4;
	private final AdvancedModelBox head;
	private final AdvancedModelBox head2;
	private final AdvancedModelBox r_fin;
	private final AdvancedModelBox l_fin;
	private final AdvancedModelBox headwear;
	private ModelAnimator animator;

	public Deepling_Warlock_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		left_leg = new AdvancedModelBox(this);
		left_leg.setRotationPoint(2.0F, -20.0F, 0.0F);
		root.addChild(left_leg);
		left_leg.setTextureOffset(41, 8).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 20.0F, 2.0F, 0.0F, true);

		right_leg = new AdvancedModelBox(this);
		right_leg.setRotationPoint(-2.0F, -20.0F, 0.0F);
		root.addChild(right_leg);
		right_leg.setTextureOffset(41, 8).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 20.0F, 2.0F, 0.0F, false);

		body = new AdvancedModelBox(this);
		body.setRotationPoint(0.0F, -20.0F, 0.0F);
		root.addChild(body);
		body.setTextureOffset(0, 34).addBox(-5.0F, -11.0F, -2.0F, 10.0F, 11.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(33, 0).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 3.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(50, 8).addBox(0.0F, -11.0F, 2.0F, 0.0F, 11.0F, 4.0F, 0.0F, false);

		right_shoulder = new AdvancedModelBox(this);
		right_shoulder.setRotationPoint(-5.0F, -11.0F, 0.0F);
		body.addChild(right_shoulder);
		setRotationAngle(right_shoulder, 0.0F, 0.0F, -1.0036F);
		right_shoulder.setTextureOffset(50, 24).addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, true);

		left_shoulder = new AdvancedModelBox(this);
		left_shoulder.setRotationPoint(5.0F, -11.0F, 0.0F);
		body.addChild(left_shoulder);
		setRotationAngle(left_shoulder, 0.0F, 0.0F, 1.0036F);
		left_shoulder.setTextureOffset(50, 24).addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);

		neck_back = new AdvancedModelBox(this);
		neck_back.setRotationPoint(0.0F, -11.0F, 2.0F);
		body.addChild(neck_back);
		setRotationAngle(neck_back, 0.7854F, 0.0F, 0.0F);
		neck_back.setTextureOffset(38, 46).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, false);

		right_rib = new AdvancedModelBox(this);
		right_rib.setRotationPoint(-5.0F, -5.5F, -2.0F);
		body.addChild(right_rib);
		setRotationAngle(right_rib, 0.0F, 0.3927F, 0.0F);
		right_rib.setTextureOffset(13, 50).addBox(0.0F, -2.5F, 0.0F, 5.0F, 11.0F, 0.0F, 0.0F, true);

		left_rib = new AdvancedModelBox(this);
		left_rib.setRotationPoint(5.0F, -5.5F, -2.0F);
		body.addChild(left_rib);
		setRotationAngle(left_rib, 0.0F, -0.3927F, 0.0F);
		left_rib.setTextureOffset(13, 50).addBox(-5.0F, -2.5F, 0.0F, 5.0F, 11.0F, 0.0F, 0.0F, false);

		neck_forward = new AdvancedModelBox(this);
		neck_forward.setRotationPoint(0.0F, -11.0F, -2.0F);
		body.addChild(neck_forward);
		setRotationAngle(neck_forward, -0.6109F, 0.0F, 0.0F);
		neck_forward.setTextureOffset(38, 46).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, false);

		right_arm = new AdvancedModelBox(this);
		right_arm.setRotationPoint(-6.0F, -10.0F, 0.0F);
		body.addChild(right_arm);
		right_arm.setTextureOffset(29, 46).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 24.0F, 2.0F, 0.0F, false);
		right_arm.setTextureOffset(47, 53).addBox(-4.0F, 1.0F, 0.0F, 3.0F, 12.0F, 0.0F, 0.0F, false);

		right_finger1 = new AdvancedModelBox(this);
		right_finger1.setRotationPoint(0.0F, 16.0F, -1.0F);
		right_arm.addChild(right_finger1);
		setRotationAngle(right_finger1, -0.1745F, 0.0F, 0.0F);
		right_finger1.setTextureOffset(0, 17).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F, 0.0F, false);

		right_finger2 = new AdvancedModelBox(this);
		right_finger2.setRotationPoint(-1.0F, 16.0F, 0.0F);
		right_arm.addChild(right_finger2);
		setRotationAngle(right_finger2, 0.0F, 0.0F, 0.1745F);
		right_finger2.setTextureOffset(54, 53).addBox(0.0F, 0.0F, -1.0F, 0.0F, 7.0F, 2.0F, 0.0F, true);

		right_finger3 = new AdvancedModelBox(this);
		right_finger3.setRotationPoint(0.0F, 16.0F, 1.0F);
		right_arm.addChild(right_finger3);
		setRotationAngle(right_finger3, 0.1745F, 0.0F, 0.0F);
		right_finger3.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F, 0.0F, false);

		right_finger4 = new AdvancedModelBox(this);
		right_finger4.setRotationPoint(1.0F, 16.0F, 0.0F);
		right_arm.addChild(right_finger4);
		setRotationAngle(right_finger4, 0.0F, 0.0F, -0.1745F);
		right_finger4.setTextureOffset(24, 50).addBox(0.0F, 0.0F, -1.0F, 0.0F, 7.0F, 2.0F, 0.0F, true);

		left_arm = new AdvancedModelBox(this);
		left_arm.setRotationPoint(6.0F, -10.0F, 0.0F);
		body.addChild(left_arm);
		left_arm.setTextureOffset(29, 46).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 24.0F, 2.0F, 0.0F, true);
		left_arm.setTextureOffset(47, 53).addBox(1.0F, 1.0F, 0.0F, 3.0F, 12.0F, 0.0F, 0.0F, true);

		left_finger1 = new AdvancedModelBox(this);
		left_finger1.setRotationPoint(0.0F, 16.0F, -1.0F);
		left_arm.addChild(left_finger1);
		setRotationAngle(left_finger1, -0.1745F, 0.0F, 0.0F);
		left_finger1.setTextureOffset(0, 17).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F, 0.0F, true);

		left_finger2 = new AdvancedModelBox(this);
		left_finger2.setRotationPoint(1.0F, 16.0F, 0.0F);
		left_arm.addChild(left_finger2);
		setRotationAngle(left_finger2, 0.0F, 0.0F, -0.1745F);
		left_finger2.setTextureOffset(54, 53).addBox(0.0F, 0.0F, -1.0F, 0.0F, 7.0F, 2.0F, 0.0F, false);

		left_finger3 = new AdvancedModelBox(this);
		left_finger3.setRotationPoint(0.0F, 16.0F, 1.0F);
		left_arm.addChild(left_finger3);
		setRotationAngle(left_finger3, 0.1745F, 0.0F, 0.0F);
		left_finger3.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F, 0.0F, true);

		left_finger4 = new AdvancedModelBox(this);
		left_finger4.setRotationPoint(-1.0F, 16.0F, 0.0F);
		left_arm.addChild(left_finger4);
		setRotationAngle(left_finger4, 0.0F, 0.0F, 0.1745F);
		left_finger4.setTextureOffset(24, 50).addBox(0.0F, 0.0F, -1.0F, 0.0F, 7.0F, 2.0F, 0.0F, false);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, -11.0F, 0.0F);
		body.addChild(head);
		

		head2 = new AdvancedModelBox(this);
		head2.setRotationPoint(0.0F, -3.0F, 0.0F);
		head.addChild(head2);
		head2.setTextureOffset(0, 17).addBox(-6.0F, -5.0F, -4.0F, 12.0F, 8.0F, 8.0F, 0.0F, false);
		head2.setTextureOffset(38, 53).addBox(0.0F, -5.0F, 4.0F, 0.0F, 8.0F, 4.0F, 0.0F, false);
		head2.setTextureOffset(29, 34).addBox(-6.0F, -5.0F, -7.0F, 12.0F, 8.0F, 3.0F, 0.0F, false);

		r_fin = new AdvancedModelBox(this);
		r_fin.setRotationPoint(-6.0F, 0.0F, 0.0F);
		head2.addChild(r_fin);
		r_fin.setTextureOffset(0, 50).addBox(-6.0F, -11.0F, 0.0F, 6.0F, 12.0F, 0.0F, 0.0F, false);

		l_fin = new AdvancedModelBox(this);
		l_fin.setRotationPoint(6.0F, 0.0F, 0.0F);
		head2.addChild(l_fin);
		l_fin.setTextureOffset(0, 50).addBox(0.0F, -11.0F, 0.0F, 6.0F, 12.0F, 0.0F, 0.0F, true);

		headwear = new AdvancedModelBox(this);
		headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(headwear);
		headwear.setTextureOffset(0, 0).addBox(-6.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, -0.5F, false);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, left_leg,right_leg,body,headwear,head,head2,r_fin,l_fin,right_arm,left_arm);
	}

	public void animate(Deepling_Warlock_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(Deepling_Warlock_Entity.DEEPLING_MAGIC);
		animator.startKeyframe(10);
		animator.rotate(body, (float) Math.toRadians(47.5F), 0, 0);
		animator.rotate(head, (float) Math.toRadians(15F), 0, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-55F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
		animator.rotate(left_arm, (float) Math.toRadians(-54F), (float) Math.toRadians(6F), (float) Math.toRadians(3.5f));
		animator.endKeyframe();

		animator.startKeyframe(10);
		animator.rotate(body, (float) Math.toRadians(-17.5F), (float) Math.toRadians(2.5F), 0);
		animator.rotate(head, (float) Math.toRadians(-40F), 0, 0);
		animator.move(head2, 0, -6, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-137.5F), (float) Math.toRadians(40F), (float) Math.toRadians(-12.5F));
		animator.rotate(left_arm, (float) Math.toRadians(-137.5F), (float) Math.toRadians(-40F), (float) Math.toRadians(12.5F));
		animator.endKeyframe();

		animator.startKeyframe(20);
		animator.rotate(body, (float) Math.toRadians(-22.5F), 0, 0);
		animator.rotate(head, (float) Math.toRadians(-32.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(-5F));
		animator.move(head2, 0, -5, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-115F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-10F));
		animator.rotate(left_arm, (float) Math.toRadians(-100F), (float) Math.toRadians(-32.5F), (float) Math.toRadians(10F));
		animator.endKeyframe();

		animator.startKeyframe(20);
		animator.rotate(body, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(2.5F));
		animator.rotate(head, (float) Math.toRadians(-22.5F), 0, 0);
		animator.move(head2, 0, -6, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-110F), (float) Math.toRadians(40F), (float) Math.toRadians(-12.5F));
		animator.rotate(left_arm, (float) Math.toRadians(-110F), (float) Math.toRadians(-40F), (float) Math.toRadians(12.5F));
		animator.endKeyframe();

		animator.startKeyframe(20);
		animator.rotate(body, (float) Math.toRadians(-22.5F), 0, 0);
		animator.rotate(head, (float) Math.toRadians(-12.5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(2.5F));
		animator.rotate(right_arm, (float) Math.toRadians(-55F), (float) Math.toRadians(20F), (float) Math.toRadians(-7.5F));
		animator.rotate(left_arm, (float) Math.toRadians(-55F), (float) Math.toRadians(-20F), (float) Math.toRadians(7.5F));
		animator.endKeyframe();

		animator.resetKeyframe(10);



		animator.setAnimation(Deepling_Warlock_Entity.DEEPLING_MELEE);
		if(entity.isLeftHanded()){
			animator.startKeyframe(4);
			animator.rotate(right_arm, (float) Math.toRadians(12.5F), 0, (float) Math.toRadians(10F));
			animator.rotate(left_arm, 0, 0, (float) Math.toRadians(-75f));
			animator.rotate(body, (float) Math.toRadians(-12.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(12.5F));
			animator.endKeyframe();

			animator.startKeyframe(2);
			animator.rotate(right_arm, (float) Math.toRadians(15F), 0, (float) Math.toRadians(10F));
			animator.rotate(left_arm, (float) Math.toRadians(-107.5f), (float) Math.toRadians(12.5f), (float) Math.toRadians(-77.5f));
			animator.rotate(body, (float) Math.toRadians(30f), (float) Math.toRadians(30F), (float) Math.toRadians(7.5F));
			animator.endKeyframe();

			animator.resetKeyframe(14);
		}else {
			animator.startKeyframe(4);
			animator.rotate(left_arm, (float) Math.toRadians(12.5F), 0, (float) Math.toRadians(-10F));
			animator.rotate(right_arm, 0, 0, (float) Math.toRadians(75f));
			animator.rotate(body, (float) Math.toRadians(-12.5F), (float) Math.toRadians(10F), (float) Math.toRadians(-12.5F));
			animator.endKeyframe();

			animator.startKeyframe(2);
			animator.rotate(left_arm, (float) Math.toRadians(15F), 0, (float) Math.toRadians(-10F));
			animator.rotate(right_arm, (float) Math.toRadians(-107.5f), (float) Math.toRadians(-12.5f), (float) Math.toRadians(77.5f));
			animator.rotate(body, (float) Math.toRadians(30f), (float) Math.toRadians(-30F), (float) Math.toRadians(-7.5F));
			animator.endKeyframe();

			animator.resetKeyframe(14);
		}

	}

	@Override
	public void setupAnim(Deepling_Warlock_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);


		this.faceTarget(netHeadYaw, headPitch, 1, head);

		float partialTick = Minecraft.getInstance().getFrameTime();
		float swim = entity.getSwimAmount(partialTick);
		float walkSpeed = 1F;
		float walkDegree = 1F;
		float swimSpeed = 0.25F;
		float swimDegree = 0.5F;
		float swimAmount = limbSwingAmount * swim;

		this.walk(left_leg, walkSpeed, walkDegree * 1.2F, true, 0F, 0F, limbSwing, limbSwingAmount);
		this.walk(right_leg, walkSpeed, walkDegree * 1.2F, false, 0F, 0F, limbSwing, limbSwingAmount);
		this.walk(left_arm, walkSpeed, walkDegree * 1.2F, false, 0F, 0F, limbSwing, limbSwingAmount);
		this.walk(right_arm, walkSpeed, walkDegree * 1.2F, true, 0F, 0F, limbSwing, limbSwingAmount);

		progressRotationPrev(left_arm,swim,0, 0, (float)Math.toRadians(-37.5F), 10f);
		progressRotationPrev(right_arm,swim,0, 0, (float)Math.toRadians(37.5F), 10f);
		progressRotationPrev(root, swim, (float) Math.toRadians(80), 0, 0, 1F);
		progressRotationPrev(head, swim, (float) Math.toRadians(-70), 0, 0, 1F);
		progressPositionPrev(root, swim, 0, -5, 18, 1F);

		this.flap(root, swimSpeed, swimDegree * 1F, true, 0F, 0F, limbSwing, swimAmount);
		this.swing(head, swimSpeed, swimDegree * 1, false, 0.5F, 0F, limbSwing, swimAmount);

		this.flap(left_arm, swimSpeed, swimDegree * 2.75F, true, -0.5F, 1.5F, limbSwing, swimAmount);
		this.swing(left_arm, swimSpeed, swimDegree, true, -1.5F, 0, limbSwing, swimAmount);
		this.walk(left_arm, swimSpeed, swimDegree, true, -2F, -0.2F, limbSwing, swimAmount);
		this.flap(right_arm, swimSpeed, swimDegree * 2.75F, false, -0.5F, 1.5F, limbSwing, swimAmount);
		this.swing(right_arm, swimSpeed, swimDegree, false, -1.5F, 0, limbSwing, swimAmount);
		this.walk(right_arm, swimSpeed, swimDegree, false, -4.5F, -0.2F, limbSwing, swimAmount);

		this.walk(right_leg, swimSpeed * 1.5F, swimDegree * 1F, true, 2F, 0.0F, limbSwing, swimAmount);
		this.walk(left_leg, swimSpeed * 1.5F, swimDegree * 1F, false, 2F, 0.0F, limbSwing, swimAmount);
		if (this.riding) {
			this.root.rotationPointY += 13;
			this.right_arm.rotateAngleX += (-(float)Math.PI / 5F);
			this.left_arm.rotateAngleX += (-(float)Math.PI / 5F);
			this.right_leg.rotateAngleX = -1.4137167F;
			this.right_leg.rotateAngleY = ((float)Math.PI / 10F);
			this.right_leg.rotateAngleZ = 0.07853982F;
			this.left_leg.rotateAngleX = -1.4137167F;
			this.left_leg.rotateAngleY = (-(float)Math.PI / 10F);
			this.left_leg.rotateAngleZ = -0.07853982F;
		}
	}

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

}