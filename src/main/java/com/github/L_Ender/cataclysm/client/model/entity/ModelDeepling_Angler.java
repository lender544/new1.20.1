package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.Deepling.Deepling_Angler_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class ModelDeepling_Angler extends AdvancedEntityModel<Deepling_Angler_Entity> {
	public final AdvancedModelBox root;
	public final AdvancedModelBox left_leg;
	public final AdvancedModelBox right_leg;
	public final AdvancedModelBox body;
	private final AdvancedModelBox thorns;
	private final AdvancedModelBox thorns2;
	private final AdvancedModelBox thorns3;
	private final AdvancedModelBox thorns4;
	public final AdvancedModelBox head;
	public final AdvancedModelBox head2;
	public final AdvancedModelBox r_fin;
	public final AdvancedModelBox l_fin;
	public final AdvancedModelBox headwear;
	public final AdvancedModelBox right_arm;
	public final AdvancedModelBox left_arm;
	public ModelAnimator animator;

	public ModelDeepling_Angler() {
		texWidth = 128;
		texHeight = 128;


		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		left_leg = new AdvancedModelBox(this);
		left_leg.setRotationPoint(2.0F, -20.0F, 0.0F);
		root.addChild(left_leg);
		left_leg.setTextureOffset(40, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 20.0F, 2.0F, 0.0F, false);
		left_leg.setTextureOffset(44, 58).addBox(0.0F, 1.0F, -2.0F, 0.0F, 17.0F, 1.0F, 0.0F, false);
		left_leg.setTextureOffset(44, 58).addBox(0.0F, 0.0F, 1.0F, 0.0F, 17.0F, 1.0F, 0.0F, false);

		right_leg = new AdvancedModelBox(this);
		right_leg.setRotationPoint(-2.0F, -20.0F, 0.0F);
		root.addChild(right_leg);
		right_leg.setTextureOffset(44, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 20.0F, 2.0F, 0.0F, false);
		right_leg.setTextureOffset(44, 58).addBox(0.0F, 1.0F, -2.0F, 0.0F, 17.0F, 1.0F, 0.0F, false);
		right_leg.setTextureOffset(44, 58).addBox(0.0F, 0.0F, 1.0F, 0.0F, 17.0F, 1.0F, 0.0F, false);

		body = new AdvancedModelBox(this);
		body.setRotationPoint(0.0F, -20.0F, 0.0F);
		root.addChild(body);
		body.setTextureOffset(0, 32).addBox(-5.0F, -11.0F, -2.0F, 10.0F, 11.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(52, 25).addBox(0.0F, -11.0F, 2.0F, 0.0F, 11.0F, 8.0F, 0.0F, false);

		thorns = new AdvancedModelBox(this);
		thorns.setRotationPoint(-3.0F, -5.5F, 2.0F);
		body.addChild(thorns);
		setRotationAngle(thorns, 0.0F, -0.6545F, 0.0F);
		thorns.setTextureOffset(52, 37).addBox(0.0F, -5.5F, 0.0F, 0.0F, 11.0F, 8.0F, 0.0F, false);

		thorns2 = new AdvancedModelBox(this);
		thorns2.setRotationPoint(3.0F, -5.5F, 2.0F);
		body.addChild(thorns2);
		setRotationAngle(thorns2, 0.0F, 0.6545F, 0.0F);
		thorns2.setTextureOffset(52, 37).addBox(0.0F, -5.5F, 0.0F, 0.0F, 11.0F, 8.0F, 0.0F, false);

		thorns3 = new AdvancedModelBox(this);
		thorns3.setRotationPoint(-5.0F, -4.5F, -2.0F);
		body.addChild(thorns3);
		setRotationAngle(thorns3, 0.0F, -0.9599F, 0.0F);
		thorns3.setTextureOffset(18, 57).addBox(0.0F, -5.5F, -4.0F, 0.0F, 11.0F, 4.0F, 0.0F, false);

		thorns4 = new AdvancedModelBox(this);
		thorns4.setRotationPoint(5.0F, -4.5F, -2.0F);
		body.addChild(thorns4);
		setRotationAngle(thorns4, 0.0F, 0.9599F, 0.0F);
		thorns4.setTextureOffset(18, 57).addBox(0.0F, -5.5F, -4.0F, 0.0F, 11.0F, 4.0F, 0.0F, false);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, -11.0F, 0.0F);
		body.addChild(head);


		head2 = new AdvancedModelBox(this);
		head2.setRotationPoint(0.0F, -3.0F, 0.0F);
		head.addChild(head2);
		head2.setTextureOffset(25, 94).addBox(-6.0F, -4.0F, -4.0F, 12.0F, 8.0F, 8.0F, -0.2F, false);
		head2.setTextureOffset(0, 16).addBox(-6.0F, -4.0F, -4.0F, 12.0F, 8.0F, 8.0F, 0.0F, false);
		head2.setTextureOffset(37, 74).addBox(-6.0F, -8.0F, -4.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);
		head2.setTextureOffset(37, 74).addBox(4.0F, -8.0F, -4.0F, 2.0F, 4.0F, 0.0F, 0.0F, true);

		r_fin = new AdvancedModelBox(this);
		r_fin.setRotationPoint(-6.0F, 0.0F, 0.0F);
		head2.addChild(r_fin);
		r_fin.setTextureOffset(44, 44).addBox(-6.0F, -7.0F, 0.0F, 6.0F, 8.0F, 0.0F, 0.0F, false);

		l_fin = new AdvancedModelBox(this);
		l_fin.setRotationPoint(6.0F, 0.0F, 0.0F);
		head2.addChild(l_fin);
		l_fin.setTextureOffset(0, 47).addBox(0.0F, -7.0F, 0.0F, 6.0F, 8.0F, 0.0F, 0.0F, false);

		headwear = new AdvancedModelBox(this);
		headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(headwear);
		headwear.setTextureOffset(0, 0).addBox(-6.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, -0.5F, false);
		headwear.setTextureOffset(17, 78).addBox(-6.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, -0.7F, false);

		right_arm = new AdvancedModelBox(this);
		right_arm.setRotationPoint(-6.0F, -10.0F, 0.0F);
		body.addChild(right_arm);
		right_arm.setTextureOffset(36, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 24.0F, 2.0F, 0.0F, false);
		right_arm.setTextureOffset(52, 24).addBox(-0.5F, 23.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		right_arm.setTextureOffset(44, 58).addBox(0.0F, 1.0F, -2.0F, 0.0F, 17.0F, 1.0F, 0.0F, false);
		right_arm.setTextureOffset(44, 58).addBox(0.0F, 1.0F, 1.0F, 0.0F, 17.0F, 1.0F, 0.0F, false);
		right_arm.setTextureOffset(36, 58).addBox(0.0F, 20.0F, 1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		right_arm.setTextureOffset(36, 56).addBox(0.0F, 20.0F, -3.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		right_arm.setTextureOffset(38, 64).addBox(-3.0F, 20.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		right_arm.setTextureOffset(38, 62).addBox(1.0F, 20.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		right_arm.setTextureOffset(28, 58).addBox(-5.0F, 13.0F, 0.0F, 4.0F, 7.0F, 0.0F, 0.0F, true);
		right_arm.setTextureOffset(18, 47).addBox(-6.0F, -1.0F, 0.0F, 5.0F, 14.0F, 0.0F, 0.0F, true);

		left_arm = new AdvancedModelBox(this);
		left_arm.setRotationPoint(6.0F, -10.0F, 0.0F);
		body.addChild(left_arm);
		left_arm.setTextureOffset(28, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 24.0F, 2.0F, 0.0F, false);
		left_arm.setTextureOffset(52, 24).addBox(-0.5F, 23.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		left_arm.setTextureOffset(44, 58).addBox(0.0F, 1.0F, 1.0F, 0.0F, 17.0F, 1.0F, 0.0F, false);
		left_arm.setTextureOffset(44, 58).addBox(0.0F, 1.0F, -2.0F, 0.0F, 17.0F, 1.0F, 0.0F, false);
		left_arm.setTextureOffset(36, 56).addBox(0.0F, 20.0F, -3.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		left_arm.setTextureOffset(38, 62).addBox(1.0F, 20.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		left_arm.setTextureOffset(38, 64).addBox(-3.0F, 20.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		left_arm.setTextureOffset(36, 58).addBox(0.0F, 20.0F, 1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		left_arm.setTextureOffset(18, 47).addBox(1.0F, -1.0F, 0.0F, 5.0F, 14.0F, 0.0F, 0.0F, false);
		left_arm.setTextureOffset(28, 58).addBox(1.0F, 13.0F, 0.0F, 4.0F, 7.0F, 0.0F, 0.0F, false);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, left_leg,right_leg,body,headwear,head,head2,r_fin,l_fin,right_arm,left_arm,thorns,thorns2,thorns3,thorns4);
	}

	public void animate(Deepling_Angler_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(Deepling_Angler_Entity.DEEPLING_MELEE);
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

		animator.setAnimation(Deepling_Angler_Entity.DEEPLING_HUG);

		animator.startKeyframe(5);
		animator.rotate(body, (float) Math.toRadians(-17.5F),0,0);
		animator.rotate(head, (float) Math.toRadians(32.5F),0,0);
		animator.rotate(right_arm, (float) Math.toRadians(-37.5F),0,(float) Math.toRadians(55F));
		animator.rotate(left_arm, (float) Math.toRadians(-37.5F),0,(float) Math.toRadians(-55));
		animator.endKeyframe();

		animator.startKeyframe(5);
		animator.rotate(body, (float) Math.toRadians(40F),0,0);
		animator.rotate(head, (float) Math.toRadians(82.5F),0,0);
		animator.rotate(right_arm, (float) Math.toRadians(-130F),(float) Math.toRadians(-37.5F),(float) Math.toRadians(80F));
		animator.rotate(left_arm, (float) Math.toRadians(-130F),(float) Math.toRadians(37.5F),(float) Math.toRadians(-80F));
		animator.endKeyframe();

		animator.resetKeyframe(10);


	}

	@Override
	public void setupAnim(Deepling_Angler_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
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
