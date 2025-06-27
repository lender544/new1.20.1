package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Golem_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class Ender_Golem_Model extends AdvancedEntityModel<Ender_Golem_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox lowerbody;
	private final AdvancedModelBox upperbody;
	private final AdvancedModelBox voidstone;
	private final AdvancedModelBox right_arm;
	private final AdvancedModelBox right_arm2;
	private final AdvancedModelBox right_finger;
	private final AdvancedModelBox left_arm;
	private final AdvancedModelBox left_arm2;
	private final AdvancedModelBox left_finger;
	private final AdvancedModelBox head;
	private final AdvancedModelBox right_leg;
	private final AdvancedModelBox left_leg;
	private ModelAnimator animator;

	public Ender_Golem_Model() {
		texWidth = 256;
		texHeight = 256;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		lowerbody = new AdvancedModelBox(this);
		lowerbody.setRotationPoint(0.0F, -20.0F, 0.0F);
		root.addChild(lowerbody);
		lowerbody.setTextureOffset(64, 52).addBox(-11.0F, -8.0F, -7.0F, 22.0F, 8.0F, 14.0F, 0.0F, false);

		upperbody = new AdvancedModelBox(this);
		upperbody.setRotationPoint(0.0F, -7.0F, 0.0F);
		lowerbody.addChild(upperbody);
		upperbody.setTextureOffset(0, 0).addBox(-20.0F, -32.0F, -10.0F, 40.0F, 32.0F, 20.0F, 0.0F, false);

		voidstone = new AdvancedModelBox(this);
		voidstone.setRotationPoint(0.0F, -12.0F, 9.0F);
		upperbody.addChild(voidstone);
		voidstone.setTextureOffset(0, 52).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

		right_arm = new AdvancedModelBox(this);
		right_arm.setRotationPoint(-20.0F, -25.0F, 0.0F);
		upperbody.addChild(right_arm);
		right_arm.setTextureOffset(52, 74).addBox(-14.0F, -6.0F, -6.0F, 14.0F, 24.0F, 12.0F, 0.0F, false);

		right_arm2 = new AdvancedModelBox(this);
		right_arm2.setRotationPoint(-10.5F, 18.0F, 0.0F);
		right_arm.addChild(right_arm2);
		right_arm2.setTextureOffset(92, 98).addBox(-5.5F, 0.0F, -6.0F, 11.0F, 22.0F, 12.0F, 0.0F, false);
		right_arm2.setTextureOffset(0, 52).addBox(1.5F, 22.0F, -3.0F, 3.0F, 7.0F, 5.0F, 0.0F, false);

		right_finger = new AdvancedModelBox(this);
		right_finger.setRotationPoint(-3.5F, 22.0F, 0.0F);
		right_arm2.addChild(right_finger);
		right_finger.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -5.5F, 3.0F, 8.0F, 5.0F, 0.0F, false);
		right_finger.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, 0.5F, 3.0F, 8.0F, 5.0F, 0.0F, false);

		left_arm = new AdvancedModelBox(this);
		left_arm.setRotationPoint(20.0F, -25.0F, 0.0F);
		upperbody.addChild(left_arm);
		left_arm.setTextureOffset(52, 74).addBox(0.0F, -6.0F, -6.0F, 14.0F, 24.0F, 12.0F, 0.0F, true);

		left_arm2 = new AdvancedModelBox(this);
		left_arm2.setRotationPoint(10.5F, 18.0F, 0.0F);
		left_arm.addChild(left_arm2);
		left_arm2.setTextureOffset(92, 98).addBox(-5.5F, 0.0F, -6.0F, 11.0F, 22.0F, 12.0F, 0.0F, true);
		left_arm2.setTextureOffset(0, 52).addBox(-4.5F, 22.0F, -3.0F, 3.0F, 7.0F, 5.0F, 0.0F, true);

		left_finger = new AdvancedModelBox(this);
		left_finger.setRotationPoint(3.5F, 22.0F, 0.0F);
		left_arm2.addChild(left_finger);
		left_finger.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -5.5F, 3.0F, 8.0F, 5.0F, 0.0F, true);
		left_finger.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, 0.5F, 3.0F, 8.0F, 5.0F, 0.0F, true);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, -25.0F, -10.0F);
		upperbody.addChild(head);
		head.setTextureOffset(0, 98).addBox(-8.0F, -8.0F, -12.0F, 16.0F, 16.0F, 12.0F, 0.0F, false);

		right_leg = new AdvancedModelBox(this);
		right_leg.setRotationPoint(-11.0F, -20.0F, 0.0F);
		root.addChild(right_leg);
		right_leg.setTextureOffset(44, 114).addBox(-8.0F, 0.0F, -6.0F, 12.0F, 20.0F, 12.0F, 0.0F, false);

		left_leg = new AdvancedModelBox(this);
		left_leg.setRotationPoint(11.0F, -20.0F, 0.0F);
		root.addChild(left_leg);
		left_leg.setTextureOffset(44, 114).addBox(-4.0F, 0.0F, -6.0F, 12.0F, 20.0F, 12.0F, 0.0F, true);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	public void animate(Ender_Golem_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(Ender_Golem_Entity.ANIMATION_ATTACK1);
		animator.startKeyframe(10);
		animator.rotate(upperbody,0,  (float)Math.toRadians(50F), 0);
		animator.rotate(right_arm, (float)Math.toRadians(40F),  (float)Math.toRadians(20F), 0);
		animator.rotate(right_arm2, (float)Math.toRadians(-80F), 0, 0);
		animator.rotate(left_arm, (float)Math.toRadians(20F), 0, (float)Math.toRadians(-10F));
		animator.rotate(left_arm2, (float)Math.toRadians(-30F), 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(5);
		animator.rotate(lowerbody,0,  (float)Math.toRadians(-20F), 0);
		animator.rotate(upperbody,0,  (float)Math.toRadians(-40F), 0);
		animator.rotate(head,0,  (float)Math.toRadians(30F), 0);
		animator.rotate(right_arm, (float)Math.toRadians(-20F),  (float)Math.toRadians(20F), (float)Math.toRadians(20F));
		animator.rotate(right_arm2, (float)Math.toRadians(-20F), 0, 0);
		animator.rotate(right_finger,0, 0 ,(float)Math.toRadians(-40F));
		animator.rotate(left_arm2, (float)Math.toRadians(-40F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(5);
		animator.resetKeyframe(5);

		animator.setAnimation(Ender_Golem_Entity.ANIMATION_ATTACK2);
		animator.startKeyframe(10);
		animator.rotate(upperbody,0,  (float)Math.toRadians(-50F), 0);
		animator.rotate(left_arm, (float)Math.toRadians(40F),  (float)Math.toRadians(-20F), 0);
		animator.rotate(left_arm2, (float)Math.toRadians(-80F), 0, 0);
		animator.rotate(right_arm, (float)Math.toRadians(20F), 0, (float)Math.toRadians(10F));
		animator.rotate(right_arm2, (float)Math.toRadians(-30F), 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(5);
		animator.rotate(lowerbody,0,  (float)Math.toRadians(20F), 0);
		animator.rotate(upperbody,0,  (float)Math.toRadians(40F), 0);
		animator.rotate(head,0,  (float)Math.toRadians(-30F), 0);
		animator.rotate(left_arm, (float)Math.toRadians(-20F),  (float)Math.toRadians(-20F), (float)Math.toRadians(-20F));
		animator.rotate(left_arm2, (float)Math.toRadians(-20F), 0, 0);
		animator.rotate(left_finger,0, 0 ,(float)Math.toRadians(40F));
		animator.rotate(right_arm2, (float)Math.toRadians(-40F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(5);
		animator.resetKeyframe(5);

		animator.setAnimation(Ender_Golem_Entity.ANIMATION_EARTHQUAKE);
		animator.startKeyframe(10);
		animator.rotate(upperbody, (float)Math.toRadians(-15F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(-15F), 0, 0);
		animator.rotate(left_arm, (float)Math.toRadians(-160F), (float)Math.toRadians(20F), (float)Math.toRadians(-10F));
		animator.rotate(right_arm, (float)Math.toRadians(-160F), (float)Math.toRadians(-20F), (float)Math.toRadians(10F));
		animator.rotate(right_arm2, (float)Math.toRadians(-20F), 0, 0);
		animator.rotate(left_arm2, (float)Math.toRadians(-20F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(5);
		animator.startKeyframe(5);
		animator.rotate(upperbody, (float)Math.toRadians(30F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(40F), 0, 0);
		animator.rotate(head, (float)Math.toRadians(-60F), 0, 0);
		animator.rotate(left_arm, (float)Math.toRadians(-100F), (float)Math.toRadians(20F), (float)Math.toRadians(-10F));
		animator.rotate(right_arm, (float)Math.toRadians(-100F), (float)Math.toRadians(-20F), (float)Math.toRadians(10F));
		animator.rotate(right_arm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(left_arm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(left_finger,0, 0 ,(float)Math.toRadians(40F));
		animator.rotate(right_finger,0, 0 ,(float)Math.toRadians(-40F));
		animator.endKeyframe();
		animator.setStaticKeyframe(5);
		animator.resetKeyframe(10);

		animator.setAnimation(Ender_Golem_Entity.VOID_RUNE_ATTACK);
		animator.startKeyframe(13);
		animator.rotate(lowerbody, (float)Math.toRadians(-12.5F), 0, 0);
		animator.rotate(upperbody, (float)Math.toRadians(-10F), 0, 0);
		animator.rotate(right_arm, (float)Math.toRadians(-170F), 0, 0);
		animator.rotate(left_arm, (float)Math.toRadians(-180F), 0, 0);
		animator.rotate(right_finger, 0, 0, (float)Math.toRadians(-17.5F));
		animator.rotate(left_finger, 0, 0, (float)Math.toRadians(17.5F));
		animator.endKeyframe();
		animator.setStaticKeyframe(5);

		animator.startKeyframe(5);
		animator.rotate(lowerbody, (float)Math.toRadians(45F), 0, 0);
		animator.rotate(upperbody, (float)Math.toRadians(17.5F), 0, 0);
		animator.rotate(right_arm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(left_arm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(right_arm2, (float)Math.toRadians(-60F), 0, 0);
		animator.rotate(left_arm2, (float)Math.toRadians(-60F), 0, 0);
		animator.rotate(right_finger, 0, 0, (float)Math.toRadians(-17.5F));
		animator.rotate(left_finger, 0, 0, (float)Math.toRadians(17.5F));
		animator.endKeyframe();

		animator.startKeyframe(15);
		animator.rotate(lowerbody, (float)Math.toRadians(45F), 0, 0);
		animator.rotate(upperbody, (float)Math.toRadians(17.5F), 0, 0);
		animator.move(voidstone,0,0,8);
		animator.rotate(right_arm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(left_arm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(right_arm2, (float)Math.toRadians(-60F), 0, 0);
		animator.rotate(left_arm2, (float)Math.toRadians(-60F), 0, 0);
		animator.rotate(right_finger, 0, 0, (float)Math.toRadians(-17.5F));
		animator.rotate(left_finger, 0, 0, (float)Math.toRadians(17.5F));
		animator.endKeyframe();

		animator.startKeyframe(10);
		animator.rotate(lowerbody, (float)Math.toRadians(45F), 0, 0);
		animator.rotate(upperbody, (float)Math.toRadians(17.5F), 0, 0);
		animator.move(voidstone,0,0,-1);
		animator.rotate(right_arm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(left_arm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(right_arm2, (float)Math.toRadians(-60F), 0, 0);
		animator.rotate(left_arm2, (float)Math.toRadians(-60F), 0, 0);
		animator.rotate(right_finger, 0, 0, (float)Math.toRadians(-17.5F));
		animator.rotate(left_finger, 0, 0, (float)Math.toRadians(17.5F));
		animator.endKeyframe();

		animator.startKeyframe(10);
		animator.rotate(upperbody, (float)Math.toRadians(-2.5F), 0, 0);
		animator.move(voidstone,0,0,-1);
		animator.rotate(right_arm, (float)Math.toRadians(-62.5F), 0, 0);
		animator.rotate(left_arm, (float)Math.toRadians(-62.5F), 0, 0);
		animator.rotate(right_arm2, (float)Math.toRadians(-60F), 0, 0);
		animator.rotate(left_arm2, (float)Math.toRadians(-60F), 0, 0);
		animator.rotate(right_finger, 0, 0, (float)Math.toRadians(-17.5F));
		animator.rotate(left_finger, 0, 0, (float)Math.toRadians(-17.5F));
		animator.endKeyframe();
		animator.setStaticKeyframe(10);
		animator.resetKeyframe(15);

		animator.setAnimation(Ender_Golem_Entity.ENDER_GOLEM_DEATH);
		if(entity.getIsAwaken()) {
			animator.startKeyframe(10);
			animator.rotate(right_leg, (float) Math.toRadians(90F), 0, 0);
			animator.rotate(left_leg, (float) Math.toRadians(90F), 0, 0);
			animator.rotate(right_arm2, (float) Math.toRadians(55F), 0, 0);
			animator.rotate(left_arm2, (float) Math.toRadians(55f), 0, 0);
			animator.move(lowerbody, 0, 14, 0);
			animator.move(right_leg, 0, 14, 0);
			animator.move(left_leg, 0, 14, 0);
			animator.endKeyframe();
			animator.setStaticKeyframe(5);

			animator.startKeyframe(20);
			animator.rotate(upperbody, (float) Math.toRadians(-12.5F), 0, 0);
			animator.rotate(right_leg, (float) Math.toRadians(90F), 0, 0);
			animator.rotate(left_leg, (float) Math.toRadians(90F), 0, 0);
			animator.rotate(right_arm, (float) Math.toRadians(15F), 0, 0);
			animator.rotate(left_arm, (float) Math.toRadians(15F), 0, 0);
			animator.rotate(right_arm2, (float) Math.toRadians(55F), 0, 0);
			animator.rotate(left_arm2, (float) Math.toRadians(55f), 0, 0);
			animator.move(lowerbody, 0, 14, 0);
			animator.move(right_leg, 0, 14, 0);
			animator.move(left_leg, 0, 14, 0);
			animator.endKeyframe();
			animator.setStaticKeyframe(5);

			animator.startKeyframe(5);
			animator.rotate(lowerbody, (float) Math.toRadians(62.5F), 0, 0);
			animator.rotate(right_leg, (float) Math.toRadians(90F), 0, 0);
			animator.rotate(left_leg, (float) Math.toRadians(90F), 0, 0);
			animator.rotate(right_arm2, (float) Math.toRadians(10F), 0, 0);
			animator.rotate(left_arm2, (float) Math.toRadians(10f), 0, 0);
			animator.move(lowerbody, 0, 14, 0);
			animator.move(right_leg, 0, 14, 0);
			animator.move(left_leg, 0, 14, 0);
			animator.endKeyframe();
			animator.setStaticKeyframe(50);
		}else{
			animator.startKeyframe(10);
			animator.rotate(lowerbody, (float) Math.toRadians(-30F), 0, 0);
			animator.rotate(upperbody, (float) Math.toRadians(-17.5F), 0, 0);
			animator.rotate(right_leg, (float) Math.toRadians(90F), 0, 0);
			animator.rotate(left_leg, (float) Math.toRadians(90F), 0, 0);
			animator.rotate(right_arm, (float) Math.toRadians(47.5F), 0, 0);
			animator.rotate(left_arm, (float) Math.toRadians(47.5F), 0, 0);
			animator.rotate(right_arm2, (float) Math.toRadians(85F), 0, 0);
			animator.rotate(left_arm2, (float) Math.toRadians(85f), 0, 0);
			animator.rotate(right_finger, 0, 0, (float) Math.toRadians(35f));
			animator.rotate(left_finger, 0, 0, (float) Math.toRadians(35f));
			animator.rotate(head, (float) Math.toRadians(-15f), 0, 0);
			animator.move(lowerbody, 0, 14, 0);
			animator.move(right_leg, 0, 14, 0);
			animator.move(left_leg, 0, 14, 0);
			animator.endKeyframe();
			animator.setStaticKeyframe(5);

			animator.startKeyframe(20);
			animator.rotate(lowerbody, (float) Math.toRadians(-30F), 0, 0);
			animator.rotate(upperbody, (float) Math.toRadians(-30F), 0, 0);
			animator.rotate(right_leg, (float) Math.toRadians(90F), 0, 0);
			animator.rotate(left_leg, (float) Math.toRadians(90F), 0, 0);
			animator.rotate(right_arm, (float) Math.toRadians(62.5F), 0, 0);
			animator.rotate(left_arm, (float) Math.toRadians(62.5F), 0, 0);
			animator.rotate(right_arm2, (float) Math.toRadians(85F), 0, 0);
			animator.rotate(left_arm2, (float) Math.toRadians(85f), 0, 0);
			animator.rotate(right_finger, 0, 0, (float) Math.toRadians(35f));
			animator.rotate(left_finger, 0, 0, (float) Math.toRadians(35f));
			animator.rotate(head, (float) Math.toRadians(-15f), 0, 0);
			animator.move(lowerbody, 0, 14, 0);
			animator.move(right_leg, 0, 14, 0);
			animator.move(left_leg, 0, 14, 0);
			animator.endKeyframe();
			animator.setStaticKeyframe(5);

			animator.startKeyframe(5);
			animator.rotate(lowerbody, (float) Math.toRadians(32.5F), 0, 0);
			animator.rotate(upperbody, (float) Math.toRadians(-17.5F), 0, 0);
			animator.rotate(right_leg, (float) Math.toRadians(90F), 0, 0);
			animator.rotate(left_leg, (float) Math.toRadians(90F), 0, 0);
			animator.rotate(right_arm, (float) Math.toRadians(47.5F), 0, 0);
			animator.rotate(left_arm, (float) Math.toRadians(47.5F), 0, 0);
			animator.rotate(right_arm2, (float) Math.toRadians(40F), 0, 0);
			animator.rotate(left_arm2, (float) Math.toRadians(40f), 0, 0);
			animator.rotate(right_finger, 0, 0, (float) Math.toRadians(35f));
			animator.rotate(left_finger, 0, 0, (float) Math.toRadians(35f));
			animator.rotate(head, (float) Math.toRadians(-15f), 0, 0);
			animator.move(lowerbody, 0, 14, 0);
			animator.move(right_leg, 0, 14, 0);
			animator.move(left_leg, 0, 14, 0);
			animator.endKeyframe();
			animator.setStaticKeyframe(50);
		}
	}

	@Override
	public void setupAnim(Ender_Golem_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		float walkSpeed = 0.5F;
		float walkDegree = 0.5F;

		this.faceTarget(netHeadYaw, headPitch, 1, head);
		this.walk(left_leg, walkSpeed, walkDegree * 1.2F, true, 0F, 0F, limbSwing, limbSwingAmount);
		this.flap(root, walkSpeed, walkDegree * 0.2F, false, 0F, 0F, limbSwing, limbSwingAmount);
		this.walk(right_leg, walkSpeed, walkDegree * 1.2F, false, 0F, 0F, limbSwing, limbSwingAmount);
		this.walk(left_arm, walkSpeed, walkDegree * 1.2F, false, 0F, 0F, limbSwing, limbSwingAmount);
		this.walk(right_arm, walkSpeed, walkDegree * 1.2F, true, 0F, 0F, limbSwing, limbSwingAmount);

		float partialTick = Minecraft.getInstance().getFrameTime();
		float deactivateProgress = entityIn.prevdeactivateProgress + (entityIn.deactivateProgress - entityIn.prevdeactivateProgress) * partialTick;

		progressRotationPrev(lowerbody,deactivateProgress,(float)Math.toRadians(30F), 0, 0, 30f);
		progressRotationPrev(upperbody,deactivateProgress,(float)Math.toRadians(17.5F), 0, 0, 30f);
		progressRotationPrev(right_arm,deactivateProgress,(float)Math.toRadians(-47.5F), 0, 0, 30f);
		progressRotationPrev(left_arm,deactivateProgress,(float)Math.toRadians(-47.5F), 0, 0, 30f);
		progressRotationPrev(right_arm2,deactivateProgress,(float)Math.toRadians(-30F), 0, 0, 30f);
		progressRotationPrev(left_arm2,deactivateProgress,(float)Math.toRadians(-30F), 0, 0, 30f);
		progressRotationPrev(right_finger,deactivateProgress,0, 0, (float)Math.toRadians(-35F), 30f);
		progressRotationPrev(left_finger,deactivateProgress,0, 0, (float)Math.toRadians(35F), 30f);
		progressRotationPrev(head,deactivateProgress,(float)Math.toRadians(15F), 0, 0, 30f);


	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				left_arm,
				right_arm,
				left_arm2,
				right_arm2,
				left_finger,
				right_finger,
				left_leg,
				right_leg,
				head,
				lowerbody,
				upperbody,
				voidstone);
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