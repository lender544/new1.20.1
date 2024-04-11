package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.AnimationMonster.The_Watcher_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelPart;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class ModelThe_Watcher extends AdvancedEntityModel<The_Watcher_Entity> {
	private final AdvancedModelPart root;
	private final AdvancedModelPart pivot;
	private final AdvancedModelPart head;
	private final AdvancedModelPart jaw;
	private final AdvancedModelPart cannon;
	private final AdvancedModelPart bone;
	private final AdvancedModelPart headgear;
	private final AdvancedModelPart right_wing;
	private final AdvancedModelPart sail;
	private final AdvancedModelPart left_wing;
	private final AdvancedModelPart sail2;
	private final AdvancedModelPart booster;
	private final AdvancedModelPart upper_sub_booster;
	private final AdvancedModelPart lower_sub_booster;
	private ModelAnimator animator;

	public ModelThe_Watcher() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelPart(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		pivot = new AdvancedModelPart(this);
		pivot.setRotationPoint(0.0F, -5.0F, 0.0F);
		root.addChild(pivot);


		head = new AdvancedModelPart(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		pivot.addChild(head);
		head.setTextureOffset(32, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(0, 8).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 0.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(0, 20).addBox(-3.0F, -3.0F, -3.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		jaw = new AdvancedModelPart(this);
		jaw.setRotationPoint(0.0F, -1.0F, 2.5F);
		head.addChild(jaw);
		setRotationAngle(jaw, 0.3054F, 0.0F, 0.0F);
		jaw.setTextureOffset(37, 17).addBox(-4.0F, -1.0F, -6.0F, 8.0F, 3.0F, 8.0F, 0.0F, false);
		jaw.setTextureOffset(0, 0).addBox(-4.0F, 1.0F, -6.0F, 8.0F, 0.0F, 8.0F, 0.0F, false);

		cannon = new AdvancedModelPart(this);
		cannon.setRotationPoint(0.0F, -5.0F, 3.0F);
		head.addChild(cannon);
		cannon.setTextureOffset(56, 28).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		cannon.setTextureOffset(56, 34).addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		bone = new AdvancedModelPart(this);
		bone.setRotationPoint(0.0F, 0.0F, -3.0F);
		cannon.addChild(bone);
		bone.setTextureOffset(13, 54).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, false);

		headgear = new AdvancedModelPart(this);
		headgear.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(headgear);
		headgear.setTextureOffset(0, 25).addBox(0.0F, -15.0F, -10.0F, 0.0F, 9.0F, 15.0F, 0.0F, false);
		headgear.setTextureOffset(45, 10).addBox(-3.0F, -7.0F, -7.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		headgear.setTextureOffset(0, 25).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 5.0F, 10.0F, 0.0F, false);

		right_wing = new AdvancedModelPart(this);
		right_wing.setRotationPoint(0.0F, -4.0F, 4.0F);
		headgear.addChild(right_wing);
		right_wing.setTextureOffset(14, 20).addBox(-6.0F, -1.0F, -5.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		sail = new AdvancedModelPart(this);
		sail.setRotationPoint(-5.0F, 0.0F, -4.0F);
		right_wing.addChild(sail);
		setRotationAngle(sail, 0.0F, 0.3491F, -0.4363F);
		sail.setTextureOffset(0, 0).addBox(-7.0F, 0.0F, -15.0F, 10.0F, 0.0F, 25.0F, 0.0F, false);

		left_wing = new AdvancedModelPart(this);
		left_wing.setRotationPoint(0.0F, -4.0F, 4.0F);
		headgear.addChild(left_wing);
		left_wing.setTextureOffset(14, 20).addBox(3.0F, -1.0F, -5.0F, 3.0F, 2.0F, 2.0F, 0.0F, true);

		sail2 = new AdvancedModelPart(this);
		sail2.setRotationPoint(5.0F, 0.0F, -4.0F);
		left_wing.addChild(sail2);
		setRotationAngle(sail2, 0.0F, -0.3491F, 0.4363F);
		sail2.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -15.0F, 10.0F, 0.0F, 25.0F, 0.0F, true);

		booster = new AdvancedModelPart(this);
		booster.setRotationPoint(0.0F, -4.0F, 4.0F);
		pivot.addChild(booster);
		booster.setTextureOffset(43, 56).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		booster.setTextureOffset(27, 48).addBox(-3.0F, -3.0F, 2.0F, 6.0F, 6.0F, 3.0F, 0.0F, false);
		booster.setTextureOffset(45, 0).addBox(-3.0F, -3.0F, 2.75F, 6.0F, 6.0F, 4.0F, 0.3F, false);
		booster.setTextureOffset(0, 0).addBox(0.0F, -6.0F, 1.0F, 0.0F, 12.0F, 4.0F, 0.0F, false);

		upper_sub_booster = new AdvancedModelPart(this);
		upper_sub_booster.setRotationPoint(0.0F, -5.0F, 3.0F);
		booster.addChild(upper_sub_booster);
		setRotationAngle(upper_sub_booster, 0.3054F, 0.0F, 0.0F);
		upper_sub_booster.setTextureOffset(0, 49).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);

		lower_sub_booster = new AdvancedModelPart(this);
		lower_sub_booster.setRotationPoint(0.0F, 5.0F, 3.0F);
		booster.addChild(lower_sub_booster);
		setRotationAngle(lower_sub_booster, -0.3054F, 0.0F, 0.0F);
		lower_sub_booster.setTextureOffset(45, 48).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	public void animate(The_Watcher_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(The_Watcher_Entity.WATCHER_BITE);
		animator.startKeyframe(5);
		animator.rotate(jaw, (float) Math.toRadians(-5F), 0, 0);
		animator.rotate(sail, 0, (float) Math.toRadians(-5F), 0);
		animator.move(sail, 0, 0, -1);
		animator.rotate(sail2, 0, (float) Math.toRadians(5F), 0);
		animator.move(sail2, 0, 0, -1);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(pivot, 0, 0, 3);
		animator.rotate(jaw, (float) Math.toRadians(5F), 0, 0);
		animator.rotate(sail, 0, (float) Math.toRadians(30F), 0);
		animator.move(sail, 0, 0, 3);
		animator.rotate(sail2, 0, (float) Math.toRadians(-30F), 0);
		animator.move(sail2, 0, 0, 3);
		animator.endKeyframe();

		animator.startKeyframe(5);
		animator.move(pivot, 0, 0, 3);
		animator.rotate(jaw, (float) Math.toRadians(5F), 0, 0);
		animator.rotate(sail, 0, (float) Math.toRadians(20F), 0);
		animator.move(sail, 0, 0, 2);
		animator.rotate(sail2, 0, (float) Math.toRadians(-20F), 0);
		animator.move(sail2, 0, 0, 2);
		animator.endKeyframe();


		animator.startKeyframe(2);
		animator.move(pivot, 0, 0, -2);
		animator.rotate(jaw, (float) Math.toRadians(-20F), 0, 0);
		animator.move(jaw, 0, -1, 0);
		animator.rotate(sail, (float) Math.toRadians(7.5F), (float) Math.toRadians(-30F), 0);
		animator.rotate(sail2, (float) Math.toRadians(7.5F), (float) Math.toRadians(30F), 0);
		animator.endKeyframe();

		animator.resetKeyframe(5);

		animator.setStaticKeyframe(3);


		animator.setAnimation(The_Watcher_Entity.WATCHER_EXTRA_SHOT);
		animator.startKeyframe(0);
		animator.move(bone, 0, 0, -1.5f);
		animator.rotate(pivot, (float) Math.toRadians(-15F), 0, 0);
		animator.move(pivot, 0, -4, 0);
		animator.rotate(jaw, (float) Math.toRadians(7.5F), 0, 0);
		animator.move(jaw,0,0.5F,0);
		animator.move(cannon, 0, 3.5F, -1);
		animator.rotate(cannon, (float) Math.toRadians(17.5F), 0, 0);
		animator.rotate(sail2, 0, (float) Math.toRadians(5F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(5);

		animator.startKeyframe(2);
		animator.move(bone, 0, 0, 0.5f);
		animator.rotate(pivot, (float) Math.toRadians(-15F), 0, 0);
		animator.move(pivot, 0, -4, 3);
		animator.rotate(jaw, (float) Math.toRadians(17.5F), 0, 0);
		animator.move(jaw,0,0.5F,0);
		animator.move(cannon, 0, 3.5F, -1);
		animator.rotate(cannon, (float) Math.toRadians(17.5F), 0, 0);
		animator.rotate(sail, 0, (float) Math.toRadians(12.5F), 0);
		animator.move(sail, 0, 0, 1);
		animator.rotate(sail2, 0, (float) Math.toRadians(-7.5F), 0);
		animator.move(sail2, 0, 0, 1);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(bone, 0, 0, -1.5f);
		animator.rotate(pivot, (float) Math.toRadians(-15F), 0, 0);
		animator.move(pivot, 0, -4, 0);
		animator.rotate(jaw, (float) Math.toRadians(7.5F), 0, 0);
		animator.move(jaw,0,0.5F,0);
		animator.move(cannon, 0, 3.5F, -1);
		animator.rotate(cannon, (float) Math.toRadians(17.5F), 0, 0);
		animator.rotate(sail2, 0, (float) Math.toRadians(5F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(3);

		animator.resetKeyframe(5);


		animator.setAnimation(The_Watcher_Entity.WATCHER_SHOT);
		animator.startKeyframe(7);
		animator.rotate(pivot, (float) Math.toRadians(32.5F), 0, 0);
		animator.rotate(jaw, (float) Math.toRadians(-22.5F), 0, 0);
		animator.endKeyframe();

		animator.startKeyframe(10);
		animator.rotate(pivot, (float) Math.toRadians(-372.5F), 0, 0);
		animator.rotate(jaw, (float) Math.toRadians(-22.5F), 0, 0);
		animator.move(jaw, 0, -1, 0);
		animator.rotate(sail, 0, (float) Math.toRadians(10F), 0);
		animator.rotate(sail2, 0, (float) Math.toRadians(-10F), 0);
		animator.endKeyframe();


		animator.startKeyframe(0);
		animator.rotate(pivot, (float) Math.toRadians(-12.5F), 0, 0);
		animator.rotate(jaw, (float) Math.toRadians(-22.5F), 0, 0);
		animator.move(jaw, 0, -1, 0);
		animator.rotate(sail, 0, (float) Math.toRadians(10F), 0);
		animator.rotate(sail2, 0, (float) Math.toRadians(-10F), 0);
		animator.endKeyframe();

		animator.startKeyframe(5);
		animator.rotate(pivot, (float) Math.toRadians(-15F), 0, 0);
		animator.rotate(jaw, (float) Math.toRadians(-22.5F), 0, 0);
		animator.move(jaw, 0, -1, 0);
		animator.rotate(sail, 0, (float) Math.toRadians(15F), 0);
		animator.rotate(sail2, 0, (float) Math.toRadians(-15F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(3);

		animator.startKeyframe(2);
		animator.rotate(pivot, (float) Math.toRadians(-15F), 0, 0);
		animator.rotate(jaw, (float) Math.toRadians(-22.5F), 0, 0);
		animator.move(jaw, 0, -1, 0);
		animator.rotate(sail, 0, (float) Math.toRadians(10F), 0);
		animator.rotate(sail2, 0, (float) Math.toRadians(-10F), 0);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.rotate(pivot, (float) Math.toRadians(-15F), 0, 0);
		animator.rotate(jaw, (float) Math.toRadians(-22.5F), 0, 0);
		animator.move(jaw, 0, -1, 0);
		animator.rotate(sail, 0, (float) Math.toRadians(30F), 0);
		animator.rotate(sail2, 0, (float) Math.toRadians(-32.5F), 0);
		animator.endKeyframe();

		animator.startKeyframe(5);
		animator.rotate(pivot, (float) Math.toRadians(-15F), 0, 0);
		animator.rotate(jaw, (float) Math.toRadians(-22.5F), 0, 0);
		animator.move(jaw, 0, -1, 0);
		animator.rotate(cannon, (float) Math.toRadians(17.5F), 0, 0);
		animator.move(cannon, 0, 4, 0);
		animator.rotate(sail, 0, (float) Math.toRadians(35F), 0);
		animator.move(sail, 0,0, 2.5f);
		animator.rotate(sail2, 0, (float) Math.toRadians(-33.3F), 0);
		animator.move(sail2, 0,0, 2.5f);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.rotate(pivot, (float) Math.toRadians(-15F), 0, 0);
		animator.rotate(jaw, (float) Math.toRadians(-22.5F), 0, 0);
		animator.move(jaw, 0, -1, 0);
		animator.rotate(cannon, (float) Math.toRadians(17.5F), 0, 0);
		animator.move(cannon, 0, 5, -2);
		animator.move(bone, 0, 0, -2);
		animator.rotate(sail, 0, (float) Math.toRadians(37.5F), 0);
		animator.move(sail, 0,0, 4f);
		animator.rotate(sail2, 0, (float) Math.toRadians(-35F), 0);
		animator.move(sail2, 0,0, 4f);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.rotate(pivot, (float) Math.toRadians(-15F), 0, 0);
		animator.rotate(jaw, (float) Math.toRadians(-22.5F), 0, 0);
		animator.move(jaw, 0, -1, 0);
		animator.rotate(cannon, (float) Math.toRadians(17.5F), 0, 0);
		animator.move(cannon, 0, 3.5f, -1);
		animator.move(bone, 0, 0, -1.5f);
		animator.rotate(sail, 0, (float) Math.toRadians(37.5F), 0);
		animator.move(sail, 0,0, -2f);
		animator.rotate(sail2, 0, (float) Math.toRadians(-35F), 0);
		animator.move(sail2, 0,0, -2f);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(bone, 0, 0, -1.5f);
		animator.rotate(pivot, (float) Math.toRadians(-15F), 0, 0);
		animator.move(pivot, 0, -4, 0);
		animator.rotate(jaw, (float) Math.toRadians(7.5F), 0, 0);
		animator.move(jaw,0,0.5F,0);
		animator.move(cannon, 0, 3.5F, -1);
		animator.rotate(cannon, (float) Math.toRadians(17.5F), 0, 0);
		animator.rotate(sail2, 0, (float) Math.toRadians(5F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.resetKeyframe(5);

	}

	@Override
	public void setupAnim(The_Watcher_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		this.faceTarget(netHeadYaw, headPitch, 1, pivot);
		float globalSpeed = 0.15f;
		float globalDegree = 0.5F;
		this.bob(pivot, globalSpeed, globalDegree * 5, false, ageInTicks, 1);
		this.bob(pivot, globalSpeed, globalDegree * 5, false, limbSwing, limbSwingAmount);
	}

	@Override
	public Iterable<AdvancedModelPart> getAllParts() {
		return ImmutableList.of(
				root,
				pivot,
				head,
				jaw,
				cannon,
				bone,
				headgear,
				right_wing,
				sail,
				head,
				left_wing,
				sail2,
				booster,
				upper_sub_booster,
				lower_sub_booster);
	}

	@Override
    public Iterable<BasicModelPart> parts() {
        return ImmutableList.of(root);
    }

	public void setRotationAngle(AdvancedModelPart AdvancedModelPart, float x, float y, float z) {
		AdvancedModelPart.rotateAngleX = x;
		AdvancedModelPart.rotateAngleY = y;
		AdvancedModelPart.rotateAngleZ = z;
	}
}