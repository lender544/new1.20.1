package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Coralssus_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Coralssus_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class Coralssus_Model extends AdvancedEntityModel<Coralssus_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox body;
	private final AdvancedModelBox chest;
	private final AdvancedModelBox cube_r1;
	private final AdvancedModelBox neck;
	private final AdvancedModelBox head;
	private final AdvancedModelBox cube_r2;
	private final AdvancedModelBox cube_r3;
	private final AdvancedModelBox cube_r4;
	private final AdvancedModelBox eye;
	private final AdvancedModelBox right_arm_joint;
	private final AdvancedModelBox right_arm;
	private final AdvancedModelBox cube_r5;
	private final AdvancedModelBox cube_r6;
	private final AdvancedModelBox right_arm2;
	private final AdvancedModelBox left_arm_joint;
	private final AdvancedModelBox left_arm;
	private final AdvancedModelBox cube_r7;
	private final AdvancedModelBox left_arm_coral;
	private final AdvancedModelBox left_arm2;
	private final AdvancedModelBox coral;
	private final AdvancedModelBox cube_r8;
	private final AdvancedModelBox coral2;
	private final AdvancedModelBox right_leg;
	private final AdvancedModelBox left_leg;

	public Coralssus_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this,"root");
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		body = new AdvancedModelBox(this,"body");
		body.setRotationPoint(0.0F, -13.0F, 0.0F);
		root.addChild(body);
		body.setTextureOffset(72, 0).addBox(-7.0F, -5.0F, -4.0F, 14.0F, 8.0F, 8.0F, 0.0F, false);

		chest = new AdvancedModelBox(this,"chest");
		chest.setRotationPoint(0.0F, -3.0186F, -0.0484F);
		body.addChild(chest);
		setRotationAngle(chest, 0.829F, 0.0F, 0.0F);
		chest.setTextureOffset(0, 0).addBox(-14.0F, -19.9814F, -8.9516F, 28.0F, 20.0F, 16.0F, 0.0F, false);
		chest.setTextureOffset(108, 3).addBox(-11.0F, -17.9814F, -10.9516F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(108, 3).addBox(-12.0F, -12.9814F, -10.5516F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(111, 16).addBox(-7.0F, -13.9814F, -9.8516F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(116, 8).addBox(-11.0F, -17.9814F, -10.9516F, 3.0F, 3.0F, 2.0F, 0.2F, false);

		cube_r1 = new AdvancedModelBox(this);
		cube_r1.setRotationPoint(11.0F, -16.9814F, 16.0484F);
		chest.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.7777F, 0.1231F, 0.124F);
		cube_r1.setTextureOffset(37, 115).addBox(-8.0F, -6.0F, -8.0F, 16.0F, 13.0F, 0.0F, 0.0F, false);

		neck = new AdvancedModelBox(this,"neck");
		neck.setRotationPoint(0.0F, -19.8814F, -3.3516F);
		chest.addChild(neck);
		setRotationAngle(neck, -0.829F, 0.0F, 0.0F);
		

		head = new AdvancedModelBox(this,"head");
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		neck.addChild(head);
		head.setTextureOffset(78, 52).addBox(-5.0F, -5.0F, -8.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
		head.setTextureOffset(88, 20).addBox(5.0F, -4.0F, -7.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(88, 16).addBox(5.0F, 0.0F, -7.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(98, 20).addBox(5.0F, -4.0F, -7.0F, 2.0F, 3.0F, 3.0F, 0.2F, false);
		head.setTextureOffset(100, 74).addBox(-4.0F, -11.0F, -6.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(110, 84).addBox(1.0F, -7.0F, -7.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(96, 114).addBox(-5.0F, 5.0F, -8.0F, 10.0F, 8.0F, 6.0F, 0.0F, false);

		cube_r2 = new AdvancedModelBox(this);
		cube_r2.setRotationPoint(-2.0F, -14.0F, -4.0F);
		head.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.7854F, 0.0F);
		cube_r2.setTextureOffset(116, 78).addBox(-0.5F, -3.0F, 0.0F, 2.0F, 6.0F, 0.0F, 0.0F, false);

		cube_r3 = new AdvancedModelBox(this);
		cube_r3.setRotationPoint(2.5F, -8.5F, -5.5F);
		head.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -0.7854F, 0.0F);
		cube_r3.setTextureOffset(120, 78).addBox(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r4 = new AdvancedModelBox(this);
		cube_r4.setRotationPoint(2.0F, -5.0F, -3.0F);
		head.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.3927F, 0.6545F, 0.0F);
		cube_r4.setTextureOffset(0, 112).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);

		eye = new AdvancedModelBox(this,"eye");
		eye.setRotationPoint(2.0F, -0.5F, -8.1F);
		head.addChild(eye);
		eye.setTextureOffset(110, 99).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		right_arm_joint = new AdvancedModelBox(this,"right_arm_joint");
		right_arm_joint.setRotationPoint(-13.3F, -11.7814F, -1.9516F);
		chest.addChild(right_arm_joint);
		setRotationAngle(right_arm_joint, -0.829F, 0.0F, 0.0F);
		

		right_arm = new AdvancedModelBox(this,"right_arm");
		right_arm.setRotationPoint(0.0F, 0.0F, 0.0F);
		right_arm_joint.addChild(right_arm);
		setRotationAngle(right_arm, 0.0F, 0.0F, 0.3927F);
		right_arm.setTextureOffset(74, 74).addBox(-8.0F, -3.0F, -5.0F, 8.0F, 16.0F, 10.0F, 0.0F, false);

		cube_r5 = new AdvancedModelBox(this);
		cube_r5.setRotationPoint(-6.9021F, 3.8612F, 0.0F);
		right_arm.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 0.0436F);
		cube_r5.setTextureOffset(36, 84).addBox(-3.0F, -2.0F, -5.5F, 8.0F, 8.0F, 11.0F, 0.0F, false);

		cube_r6 = new AdvancedModelBox(this);
		cube_r6.setRotationPoint(-6.0F, 1.0F, 0.0F);
		right_arm.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, 0.3054F);
		cube_r6.setTextureOffset(0, 62).addBox(-5.0F, -6.0F, -6.0F, 10.0F, 8.0F, 12.0F, 0.0F, false);

		right_arm2 = new AdvancedModelBox(this,"right_arm2");
		right_arm2.setRotationPoint(-4.0F, 11.0F, 0.0F);
		right_arm.addChild(right_arm2);
		setRotationAngle(right_arm2, 0.0F, 0.0F, -0.3927F);
		right_arm2.setTextureOffset(0, 36).addBox(-5.0F, 0.0F, -6.0F, 10.0F, 14.0F, 12.0F, 0.0F, false);
		right_arm2.setTextureOffset(76, 114).addBox(-15.0F, -4.0F, 0.0F, 10.0F, 14.0F, 0.0F, 0.0F, true);

		left_arm_joint = new AdvancedModelBox(this,"left_arm_joint");
		left_arm_joint.setRotationPoint(-13.3F, -11.7814F, -1.9516F);
		chest.addChild(left_arm_joint);
		setRotationAngle(left_arm_joint, -0.829F, 0.0F, 0.0F);
		

		left_arm = new AdvancedModelBox(this,"left_arm");
		left_arm.setRotationPoint(26.6F, 0.0F, 0.0F);
		left_arm_joint.addChild(left_arm);
		setRotationAngle(left_arm, 0.0F, 0.0F, -0.3927F);
		left_arm.setTextureOffset(0, 82).addBox(0.0F, -3.0F, -5.0F, 8.0F, 16.0F, 10.0F, 0.0F, false);
		left_arm.setTextureOffset(37, 103).addBox(2.0F, 1.0F, -7.0F, 8.0F, 2.0F, 8.0F, 0.0F, false);
		left_arm.setTextureOffset(37, 103).addBox(4.0F, 5.0F, -9.0F, 8.0F, 2.0F, 8.0F, 0.0F, false);

		cube_r7 = new AdvancedModelBox(this);
		cube_r7.setRotationPoint(6.4663F, 5.5491F, -0.0767F);
		left_arm.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, 0.9599F);
		cube_r7.setTextureOffset(0, 112).addBox(-12.7F, -20.8F, 0.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);

		left_arm_coral = new AdvancedModelBox(this,"left_arm_coral");
		left_arm_coral.setRotationPoint(1.0F, 12.8F, 20.0F);
		left_arm.addChild(left_arm_coral);
		

		left_arm2 = new AdvancedModelBox(this,"left_arm2");
		left_arm2.setRotationPoint(4.0F, 11.0F, 0.0F);
		left_arm.addChild(left_arm2);
		setRotationAngle(left_arm2, 0.0F, 0.0F, 0.3927F);
		left_arm2.setTextureOffset(44, 36).addBox(-5.0F, 0.0F, -6.0F, 10.0F, 14.0F, 12.0F, 0.0F, false);
		left_arm2.setTextureOffset(76, 114).addBox(5.0F, -4.0F, 0.0F, 10.0F, 14.0F, 0.0F, 0.0F, false);

		coral = new AdvancedModelBox(this,"coral");
		coral.setRotationPoint(-9.9F, -19.0F, 4.7F);
		chest.addChild(coral);
		setRotationAngle(coral, -0.9579F, -0.3942F, 0.0159F);
		

		cube_r8 = new AdvancedModelBox(this);
		cube_r8.setRotationPoint(0.0F, 0.3459F, 0.0319F);
		coral.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0872F, -0.0038F, 0.0435F);
		cube_r8.setTextureOffset(0, 112).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);

		coral2 = new AdvancedModelBox(this,"coral2");
		coral2.setRotationPoint(-6.0F, -7.3F, 7.0F);
		chest.addChild(coral2);
		setRotationAngle(coral2, 0.6262F, -0.0765F, -0.3687F);
		coral2.setTextureOffset(-16, 112).addBox(-7.9236F, 0.0929F, 0.3748F, 16.0F, 0.0F, 16.0F, 0.0F, false);

		right_leg = new AdvancedModelBox(this,"right_leg");
		right_leg.setRotationPoint(-9.0F, -9.0F, 0.0F);
		root.addChild(right_leg);
		right_leg.setTextureOffset(44, 62).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 12.0F, 10.0F, 0.0F, false);
		right_leg.setTextureOffset(60, 100).addBox(-7.0F, 9.0F, -7.0F, 14.0F, 0.0F, 14.0F, 0.0F, true);

		left_leg = new AdvancedModelBox(this,"left_leg");
		left_leg.setRotationPoint(9.0F, -9.0F, 0.0F);
		root.addChild(left_leg);
		left_leg.setTextureOffset(78, 26).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 12.0F, 10.0F, 0.0F, false);
		left_leg.setTextureOffset(60, 100).addBox(-7.0F, 9.0F, -7.0F, 14.0F, 0.0F, 14.0F, 0.0F, false);
		updateDefaultPose();
	}

	@Override
	public void setupAnim(Coralssus_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();
		this.faceTarget(netHeadYaw, headPitch, 1, head);
		float partialTick = Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);
		float swim = entity.getSwimAmount(partialTick);
		float swimAmount = limbSwingAmount * swim;
		if(entity.getAttackState() != 6 && entity.getAttackState() != 2 && entity.getAttackState() != 7) {
			if(entity.getSwim()) {
				this.animateWalk(Coralssus_Animation.SWIM, limbSwing, swimAmount, 1.0F, 2.0F);
			}else{
				this.animateWalk(Coralssus_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 2.0F);
			}
		}
		progressRotationPrev(head,swim,(float)Math.toRadians(-22.5F), 0, 0, 1f);
		progressRotationPrev(body, swim, (float) Math.toRadians(50), 0, 0, 1F);
		progressRotationPrev(chest,swim,(float)Math.toRadians(-20F), 0, 0, 1f);
		progressRotationPrev(right_arm,swim,(float)Math.toRadians(-115F), 0, 0, 1f);
		progressRotationPrev(left_arm,swim,(float)Math.toRadians(-115F), 0, 0, 1f);
		progressRotationPrev(right_leg,swim,(float)Math.toRadians(57.5F), 0, 0, 1f);
		progressRotationPrev(left_leg,swim,(float)Math.toRadians(57.5F), 0, 0, 1f);

		this.animate(entity.getAnimationState("idle"), Coralssus_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("death"), Coralssus_Animation.DEATH, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("angry"), Coralssus_Animation.ANGRY, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("nanta"), Coralssus_Animation.NANTA, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("right_fist"), Coralssus_Animation.RIGHT_FIST, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("left_fist"), Coralssus_Animation.LEFT_FIST, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("jumping_prepare"), Coralssus_Animation.JUMPING_READY, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("jumping"), Coralssus_Animation.JUMPING_LOOP, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("jumping_end"), Coralssus_Animation.JUMPING_FISH, ageInTicks, 1.0F);

	}

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of( root,
				body,
				chest,
				cube_r1,
				neck,
				head,
				cube_r2,
				cube_r3,
				cube_r4,
				eye,
				right_arm_joint,
				right_arm,
				cube_r5,
				cube_r6,
				right_arm2,
				left_arm_joint,
				left_arm,
				cube_r7,
				left_arm_coral,
				left_arm2,
				coral,
				cube_r8,
				coral2,
				right_leg,
				left_leg
		);
	}

}