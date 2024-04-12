package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Prowler_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;

public class ModelThe_Prowler extends AdvancedEntityModel<The_Prowler_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox upperbody;
	private final AdvancedModelBox chestplate;
	private final AdvancedModelBox eye_blow;
	private final AdvancedModelBox chestplate2;
	private final AdvancedModelBox rocket_luncher;
	private final AdvancedModelBox missile;
	private final AdvancedModelBox missile2;
	private final AdvancedModelBox missile3;
	private final AdvancedModelBox right_arm;
	private final AdvancedModelBox right_arm_joint;
	private final AdvancedModelBox sholder_pad;
	private final AdvancedModelBox sholder_pad2;
	private final AdvancedModelBox right_arm2;
	private final AdvancedModelBox right_joint;
	private final AdvancedModelBox chainsaw;
	private final AdvancedModelBox saw;
	private final AdvancedModelBox blade5;
	private final AdvancedModelBox blade6;
	private final AdvancedModelBox blade7;
	private final AdvancedModelBox blade8;
	private final AdvancedModelBox blade;
	private final AdvancedModelBox blade2;
	private final AdvancedModelBox blade3;
	private final AdvancedModelBox blade4;
	private final AdvancedModelBox pelvis;
	private final AdvancedModelBox catapiller;
	private final AdvancedModelBox catapiller2;
	private final AdvancedModelBox pipe2;
	private final AdvancedModelBox pipe;
	private ModelAnimator animator;

	public ModelThe_Prowler() {
		texWidth = 256;
		texHeight = 256;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		upperbody = new AdvancedModelBox(this);
		upperbody.setRotationPoint(0.0F, -23.5F, 0.0F);
		root.addChild(upperbody);


		chestplate = new AdvancedModelBox(this);
		chestplate.setRotationPoint(0.0F, 0.5F, -7.0F);
		upperbody.addChild(chestplate);
		chestplate.setTextureOffset(0, 0).addBox(-7.0F, -13.0F, -3.0F, 14.0F, 13.0F, 21.0F, 0.0F, false);

		eye_blow = new AdvancedModelBox(this);
		eye_blow.setRotationPoint(0.0F, -9.0F, -3.25F);
		chestplate.addChild(eye_blow);
		eye_blow.setTextureOffset(2, 172).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 4.0F, 0.0F, 0.0F, false);

		chestplate2 = new AdvancedModelBox(this);
		chestplate2.setRotationPoint(-3.0F, 25.0F, 0.0F);
		chestplate.addChild(chestplate2);
		chestplate2.setTextureOffset(114, 110).addBox(-10.0F, -40.0F, 0.0F, 6.0F, 13.0F, 15.0F, 0.0F, false);

		rocket_luncher = new AdvancedModelBox(this);
		rocket_luncher.setRotationPoint(7.0F, -6.5F, 1.0F);
		upperbody.addChild(rocket_luncher);
		rocket_luncher.setTextureOffset(48, 45).addBox(6.0F, -17.0F, -11.0F, 6.0F, 20.0F, 16.0F, 0.0F, false);
		rocket_luncher.setTextureOffset(0, 61).addBox(6.0F, -17.0F, -12.0F, 6.0F, 13.0F, 17.0F, 0.3F, false);
		rocket_luncher.setTextureOffset(37, 41).addBox(0.0F, -2.0F, 5.0F, 10.0F, 0.0F, 7.0F, 0.0F, false);
		rocket_luncher.setTextureOffset(0, 34).addBox(9.0F, -13.0F, 5.0F, 0.0F, 12.0F, 7.0F, 0.0F, false);
		rocket_luncher.setTextureOffset(14, 50).addBox(8.0F, -3.0F, 5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		rocket_luncher.setTextureOffset(14, 47).addBox(2.0F, -3.0F, 7.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		rocket_luncher.setTextureOffset(14, 44).addBox(8.0F, -13.0F, 5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		rocket_luncher.setTextureOffset(0, 118).addBox(0.0F, -8.0F, -8.0F, 6.0F, 13.0F, 15.0F, 0.0F, false);

		missile = new AdvancedModelBox(this);
		missile.setRotationPoint(9.0F, -14.0F, -7.6F);
		rocket_luncher.addChild(missile);
		missile.setTextureOffset(76, 2).addBox(-1.0F, -1.0F, -5.9F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		missile.setTextureOffset(44, 30).addBox(0.0F, -3.0F, -0.9F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		missile.setTextureOffset(0, 2).addBox(0.0F, 1.0F, -0.9F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		missile.setTextureOffset(14, 41).addBox(-1.0F, -1.0F, -3.9F, 2.0F, 2.0F, 1.0F, 0.1F, false);
		missile.setTextureOffset(7, 16).addBox(-1.0F, -1.0F, 2.1F, 2.0F, 2.0F, 1.0F, 0.1F, false);

		missile2 = new AdvancedModelBox(this);
		missile2.setRotationPoint(9.0F, -7.0F, -7.6F);
		rocket_luncher.addChild(missile2);
		missile2.setTextureOffset(76, 2).addBox(-1.0F, -1.0F, -5.9F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		missile2.setTextureOffset(44, 30).addBox(0.0F, -3.0F, -0.9F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		missile2.setTextureOffset(0, 2).addBox(0.0F, 1.0F, -0.9F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		missile2.setTextureOffset(14, 41).addBox(-1.0F, -1.0F, -3.9F, 2.0F, 2.0F, 1.0F, 0.1F, false);
		missile2.setTextureOffset(7, 16).addBox(-1.0F, -1.0F, 2.1F, 2.0F, 2.0F, 1.0F, 0.1F, false);

		missile3 = new AdvancedModelBox(this);
		missile3.setRotationPoint(9.0F, 0.0F, -7.6F);
		rocket_luncher.addChild(missile3);
		missile3.setTextureOffset(76, 2).addBox(-1.0F, -1.0F, -5.9F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		missile3.setTextureOffset(44, 30).addBox(0.0F, -3.0F, -0.9F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		missile3.setTextureOffset(0, 2).addBox(0.0F, 1.0F, -0.9F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		missile3.setTextureOffset(14, 41).addBox(-1.0F, -1.0F, -3.9F, 2.0F, 2.0F, 1.0F, 0.1F, false);
		missile3.setTextureOffset(7, 16).addBox(-1.0F, -1.0F, 2.1F, 2.0F, 2.0F, 1.0F, 0.1F, false);

		right_arm = new AdvancedModelBox(this);
		right_arm.setRotationPoint(-13.0F, -13.5F, 1.0F);
		upperbody.addChild(right_arm);


		right_arm_joint = new AdvancedModelBox(this);
		right_arm_joint.setRotationPoint(0.0F, 0.0F, 0.0F);
		right_arm.addChild(right_arm_joint);
		right_arm_joint.setTextureOffset(67, 125).addBox(-11.0F, -6.0F, -5.0F, 11.0F, 16.0F, 10.0F, 0.0F, false);
		right_arm_joint.setTextureOffset(44, 48).addBox(-5.0F, 5.0F, -7.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		right_arm_joint.setTextureOffset(0, 0).addBox(-5.0F, 5.0F, 5.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);

		sholder_pad = new AdvancedModelBox(this);
		sholder_pad.setRotationPoint(-9.0F, 4.5F, 0.0F);
		right_arm_joint.addChild(sholder_pad);
		setRotationAngle(sholder_pad, 0.0F, 0.0F, 0.3054F);
		sholder_pad.setTextureOffset(0, 151).addBox(-4.0F, -2.5F, -6.0F, 8.0F, 5.0F, 12.0F, 0.0F, false);

		sholder_pad2 = new AdvancedModelBox(this);
		sholder_pad2.setRotationPoint(1.0F, 5.0F, 0.0F);
		sholder_pad.addChild(sholder_pad2);
		sholder_pad2.setTextureOffset(0, 151).addBox(-4.0F, -2.5F, -6.0F, 8.0F, 5.0F, 12.0F, 0.0F, false);

		right_arm2 = new AdvancedModelBox(this);
		right_arm2.setRotationPoint(-5.0F, 7.0F, 0.0F);
		right_arm_joint.addChild(right_arm2);
		right_arm2.setTextureOffset(96, 63).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 16.0F, 2.0F, 0.0F, false);
		right_arm2.setTextureOffset(0, 91).addBox(-3.0F, -8.0F, 1.0F, 6.0F, 16.0F, 2.0F, 0.0F, false);

		right_joint = new AdvancedModelBox(this);
		right_joint.setRotationPoint(0.0F, 11.0F, 0.0F);
		right_arm2.addChild(right_joint);
		right_joint.setTextureOffset(76, 41).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		right_joint.setTextureOffset(0, 70).addBox(-4.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		right_joint.setTextureOffset(62, 104).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 6.0F, 6.0F, 0.3F, false);
		right_joint.setTextureOffset(49, 0).addBox(3.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		chainsaw = new AdvancedModelBox(this);
		chainsaw.setRotationPoint(0.0F, 0.0F, -3.0F);
		right_joint.addChild(chainsaw);
		chainsaw.setTextureOffset(93, 78).addBox(-3.0F, -3.0F, -21.0F, 2.0F, 6.0F, 21.0F, 0.0F, false);
		chainsaw.setTextureOffset(0, 91).addBox(1.0F, -3.0F, -21.0F, 2.0F, 6.0F, 21.0F, 0.0F, false);

		saw = new AdvancedModelBox(this);
		saw.setRotationPoint(0.0714F, 0.0F, -18.0F);
		chainsaw.addChild(saw);
		saw.setTextureOffset(74, 63).addBox(-1.0714F, -9.0F, -9.0F, 2.0F, 18.0F, 18.0F, 0.0F, false);
		saw.setTextureOffset(0, 25).addBox(-0.0714F, -16.0F, -4.5F, 0.0F, 7.0F, 9.0F, 0.0F, false);
		saw.setTextureOffset(0, 0).addBox(-0.0714F, 9.0F, -4.5F, 0.0F, 7.0F, 9.0F, 0.0F, false);
		saw.setTextureOffset(0, 54).addBox(-0.0714F, -4.5F, -16.0F, 0.0F, 9.0F, 7.0F, 0.0F, false);
		saw.setTextureOffset(49, 4).addBox(-0.0714F, -4.5F, 9.0F, 0.0F, 9.0F, 7.0F, 0.0F, false);
		saw.setTextureOffset(64, 41).addBox(-4.0714F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		saw.setTextureOffset(44, 36).addBox(1.9286F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		blade5 = new AdvancedModelBox(this);
		blade5.setRotationPoint(0.0F, 0.0F, 0.0F);
		saw.addChild(blade5);
		setRotationAngle(blade5, -0.0873F, 0.0F, 0.0F);
		blade5.setTextureOffset(0, 0).addBox(-0.8214F, 8.0F, -9.0F, 0.0F, 7.0F, 9.0F, 0.0F, false);

		blade6 = new AdvancedModelBox(this);
		blade6.setRotationPoint(0.0F, 1.0F, 0.0F);
		saw.addChild(blade6);
		setRotationAngle(blade6, 0.1309F, 0.0F, 0.0F);
		blade6.setTextureOffset(0, 0).addBox(0.6786F, 8.0F, 0.0F, 0.0F, 7.0F, 9.0F, 0.0F, false);

		blade7 = new AdvancedModelBox(this);
		blade7.setRotationPoint(0.0F, 0.0F, 0.0F);
		saw.addChild(blade7);
		setRotationAngle(blade7, -0.0873F, 0.0F, 0.0F);
		blade7.setTextureOffset(49, 4).addBox(-0.8214F, 0.0F, 8.0F, 0.0F, 9.0F, 7.0F, 0.0F, false);

		blade8 = new AdvancedModelBox(this);
		blade8.setRotationPoint(0.0F, 0.0F, 1.0F);
		saw.addChild(blade8);
		setRotationAngle(blade8, 0.1309F, 0.0F, 0.0F);
		blade8.setTextureOffset(49, 4).addBox(0.6786F, -9.0F, 8.0F, 0.0F, 9.0F, 7.0F, 0.0F, false);

		blade = new AdvancedModelBox(this);
		blade.setRotationPoint(0.0F, 0.0F, 0.0F);
		saw.addChild(blade);
		setRotationAngle(blade, -0.0873F, 0.0F, 0.0F);
		blade.setTextureOffset(0, 25).addBox(-0.8214F, -15.0F, 0.0F, 0.0F, 7.0F, 9.0F, 0.0F, false);

		blade2 = new AdvancedModelBox(this);
		blade2.setRotationPoint(0.0F, -1.0F, 0.0F);
		saw.addChild(blade2);
		setRotationAngle(blade2, 0.1309F, 0.0F, 0.0F);
		blade2.setTextureOffset(0, 25).addBox(0.6786F, -15.0F, -9.0F, 0.0F, 7.0F, 9.0F, 0.0F, false);

		blade3 = new AdvancedModelBox(this);
		blade3.setRotationPoint(0.0F, 0.0F, 0.0F);
		saw.addChild(blade3);
		setRotationAngle(blade3, -0.0873F, 0.0F, 0.0F);
		blade3.setTextureOffset(0, 54).addBox(-0.8214F, -9.0F, -15.0F, 0.0F, 9.0F, 7.0F, 0.0F, false);

		blade4 = new AdvancedModelBox(this);
		blade4.setRotationPoint(0.0F, 0.0F, -1.0F);
		saw.addChild(blade4);
		setRotationAngle(blade4, 0.1309F, 0.0F, 0.0F);
		blade4.setTextureOffset(0, 54).addBox(0.6786F, 0.0F, -15.0F, 0.0F, 9.0F, 7.0F, 0.0F, false);

		pelvis = new AdvancedModelBox(this);
		pelvis.setRotationPoint(0.0F, -23.0F, 1.0F);
		root.addChild(pelvis);
		pelvis.setTextureOffset(0, 34).addBox(-6.0F, 12.0F, -11.0F, 12.0F, 7.0F, 20.0F, 0.0F, false);
		pelvis.setTextureOffset(34, 138).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 16.0F, 8.0F, 0.0F, false);
		pelvis.setTextureOffset(49, 0).addBox(-4.0F, 7.0F, -5.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
		pelvis.setTextureOffset(98, 0).addBox(-5.0F, -1.0F, -7.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
		pelvis.setTextureOffset(66, 81).addBox(3.0F, -1.0F, -7.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
		pelvis.setTextureOffset(37, 61).addBox(2.0F, -1.0F, 4.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
		pelvis.setTextureOffset(29, 61).addBox(-4.0F, -1.0F, 4.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
		pelvis.setTextureOffset(54, 18).addBox(-6.0F, 2.0F, -9.0F, 12.0F, 7.0F, 16.0F, 0.0F, false);

		catapiller = new AdvancedModelBox(this);
		catapiller.setRotationPoint(-6.0F, 15.0F, -0.5F);
		pelvis.addChild(catapiller);
		catapiller.setTextureOffset(31, 104).addBox(-9.0F, -4.0F, -14.5F, 8.0F, 12.0F, 15.0F, 0.0F, false);
		catapiller.setTextureOffset(92, 41).addBox(-10.0F, -5.0F, -15.5F, 10.0F, 5.0F, 17.0F, 0.0F, false);
		catapiller.setTextureOffset(129, 35).addBox(-9.0F, 0.0F, 0.5F, 8.0F, 8.0F, 12.0F, 0.0F, false);
		catapiller.setTextureOffset(118, 63).addBox(-10.0F, -1.0F, -1.5F, 10.0F, 4.0F, 15.0F, 0.0F, false);

		catapiller2 = new AdvancedModelBox(this);
		catapiller2.setRotationPoint(6.0F, 15.0F, -0.5F);
		pelvis.addChild(catapiller2);
		catapiller2.setTextureOffset(94, 0).addBox(1.0F, -4.0F, -14.5F, 8.0F, 12.0F, 15.0F, 0.0F, false);
		catapiller2.setTextureOffset(29, 82).addBox(0.0F, -5.0F, -15.5F, 10.0F, 5.0F, 17.0F, 0.0F, false);
		catapiller2.setTextureOffset(77, 105).addBox(0.0F, -1.0F, -2.5F, 10.0F, 4.0F, 16.0F, 0.0F, false);
		catapiller2.setTextureOffset(128, 15).addBox(1.0F, 0.0F, 0.5F, 8.0F, 8.0F, 12.0F, 0.0F, false);

		pipe2 = new AdvancedModelBox(this);
		pipe2.setRotationPoint(5.0F, 11.0F, 8.0F);
		pelvis.addChild(pipe2);
		setRotationAngle(pipe2, -0.1745F, 0.0F, 0.0F);
		pipe2.setTextureOffset(56, 48).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		pipe2.setTextureOffset(8, 2).addBox(-1.0F, -3.0F, 1.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		pipe2.setTextureOffset(0, 16).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 2.0F, 3.0F, 0.3F, false);

		pipe = new AdvancedModelBox(this);
		pipe.setRotationPoint(-5.0F, 11.0F, 8.0F);
		pelvis.addChild(pipe);
		setRotationAngle(pipe, -0.1745F, 0.0F, 0.0F);
		pipe.setTextureOffset(75, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		pipe.setTextureOffset(63, 11).addBox(-1.0F, -3.0F, 1.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		pipe.setTextureOffset(10, 16).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 2.0F, 3.0F, 0.3F, false);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	public void animate(The_Prowler_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(The_Prowler_Entity.PROWLER_MISSILE);
		animator.startKeyframe(5);
		animator.move(eye_blow, 0, 1, 0);
		animator.endKeyframe();


		animator.startKeyframe(10);
		animator.move(eye_blow, 0, 1, 0);
		animator.rotate(rocket_luncher, (float) Math.toRadians(-370F), 0, 0);
		animator.move(rocket_luncher, 0, 0, 2);
		animator.endKeyframe();

		animator.startKeyframe(0);
		animator.move(eye_blow, 0, 1, 0);
		animator.rotate(rocket_luncher, (float) Math.toRadians(-10F), 0, 0);
		animator.move(rocket_luncher, 0, 0, 2);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.rotate(upperbody, (float) Math.toRadians(-5F), 0, 0);
		animator.move(upperbody, 0, 0, 1);
		animator.move(eye_blow, 0, 1, 0);
		animator.move(missile, 0, 0, -2);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(eye_blow, 0, 1, 0);
		animator.move(missile2, 0, 0, -2);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(eye_blow, 0, 1, 0);
		animator.move(missile3, 0, 0, -2);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(eye_blow, 0, 1, 0);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(missile3, 0, 0, 3);
		animator.move(rocket_luncher, 0, 0, 2);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(missile3, 0, 0, 3);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(missile3, 0, 0, 3);
		animator.move(missile2, 0, 0, 3);
		animator.move(rocket_luncher, 0, 0, 2);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(missile3, 0, 0, 3);
		animator.move(missile2, 0, 0, 3);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(missile3, 0, 0, 3);
		animator.move(missile2, 0, 0, 3);
		animator.move(missile, 0, 0, 3);
		animator.move(rocket_luncher, 0, 0, 2);
		animator.endKeyframe();

		animator.setStaticKeyframe(12);

		animator.resetKeyframe(12);


		animator.setAnimation(The_Prowler_Entity.PROWLER_ATTACK);
		animator.startKeyframe(5);
		animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(32.5F), 0);
		animator.move(upperbody, 0, 0, 2);
		animator.rotate(right_arm, (float) Math.toRadians(-112.5F), 0, 0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(32.5F), 0);
		animator.rotate(right_arm, (float) Math.toRadians(-112.5F), 0, 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(2);
		animator.move(root, 0, 2, 0);
		animator.rotate(upperbody, (float) Math.toRadians(2.5F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(right_arm, (float) Math.toRadians(-112.5F), 0, 0);
		animator.move(right_arm_joint, 0, 0, 2);
		animator.rotate(right_arm_joint, (float) Math.toRadians(125F), 0, 0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(upperbody, (float) Math.toRadians(2.5F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(right_arm, (float) Math.toRadians(-112.5F), 0, 0);
		animator.rotate(right_arm_joint, (float) Math.toRadians(125F), 0, 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(8);
		animator.move(root, 0, 0, -2);
		animator.rotate(upperbody, (float) Math.toRadians(3.5F), (float) Math.toRadians(-50F), (float) Math.toRadians(1.5F));
		animator.rotate(right_arm, (float) Math.toRadians(-112.5F), 0, 0);
		animator.rotate(right_arm_joint, (float) Math.toRadians(82.5F), 0, (float) Math.toRadians(2.5F));
		animator.rotate(right_joint, (float) Math.toRadians(35F), (float) Math.toRadians(40F), (float) Math.toRadians(25F));
		animator.rotate(chainsaw, 0, 0, (float) Math.toRadians(90F));
		animator.endKeyframe();


		animator.setStaticKeyframe(8);

		animator.startKeyframe(5);
		animator.rotate(upperbody, (float) Math.toRadians(5F), (float) Math.toRadians(-57.5F), (float) Math.toRadians(-2.5F));
		animator.rotate(right_arm, (float) Math.toRadians(-110F), (float) Math.toRadians(10F), (float) Math.toRadians(-1.5F));
		animator.rotate(right_arm_joint, (float) Math.toRadians(82.5F), 0, (float) Math.toRadians(2.5F));
		animator.rotate(right_joint, (float) Math.toRadians(30F), (float) Math.toRadians(-25F), (float) Math.toRadians(-15F));
		animator.rotate(chainsaw, 0, 0, (float) Math.toRadians(270F));
		animator.endKeyframe();

		animator.setStaticKeyframe(8);

		animator.startKeyframe(3);
		animator.move(root, 0, 0, 2);
		animator.rotate(upperbody, (float) Math.toRadians(3F), (float) Math.toRadians(45F), (float) Math.toRadians(3.5F));
		animator.rotate(right_arm, (float) Math.toRadians(-90F), (float) Math.toRadians(15F), (float) Math.toRadians(-5F));
		animator.move(right_arm, 2, 0, -2);
		animator.rotate(right_arm_joint, (float) Math.toRadians(82.5F), 0, (float) Math.toRadians(2.5F));
		animator.rotate(right_joint, 0, (float) Math.toRadians(102.5F), 0);
		animator.rotate(chainsaw, 0, 0, (float) Math.toRadians(270F));
		animator.endKeyframe();


		animator.startKeyframe(1);
		animator.rotate(upperbody, (float) Math.toRadians(3F), (float) Math.toRadians(45F), (float) Math.toRadians(3.5F));
		animator.rotate(right_arm, (float) Math.toRadians(-90F), (float) Math.toRadians(15F), (float) Math.toRadians(-5F));
		animator.move(right_arm, 2, 0, -2);
		animator.rotate(right_arm_joint, (float) Math.toRadians(82.5F), 0, (float) Math.toRadians(2.5F));
		animator.rotate(right_joint, 0, (float) Math.toRadians(102.5F), 0);
		animator.rotate(chainsaw, 0, 0, (float) Math.toRadians(270F));
		animator.endKeyframe();

		animator.setStaticKeyframe(8);

		animator.resetKeyframe(12);


		animator.setAnimation(The_Prowler_Entity.PROWLER_SPIN_ATTACK);
		animator.startKeyframe(8);
		animator.rotate(upperbody, 0, (float) Math.toRadians(15F), 0);
		animator.move(eye_blow, 0, -1, 0);
		animator.rotate(right_arm, 0, 0, (float) Math.toRadians(10F));
		animator.endKeyframe();

		animator.startKeyframe(6);
		animator.rotate(upperbody, 0, (float) Math.toRadians(-32.5F), 0);
		animator.move(upperbody, -1, 1, 0);
		animator.move(eye_blow, 0, 1, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-25F), (float) Math.toRadians(55F));
		animator.rotate(chainsaw, 0, 0, (float) Math.toRadians(45F));
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(upperbody, 0, (float) Math.toRadians(-27.5F), 0);
		animator.move(eye_blow, 0, 1, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-25F), (float) Math.toRadians(55F));
		animator.rotate(chainsaw, 0, 0, (float) Math.toRadians(45F));
		animator.endKeyframe();

		animator.startKeyframe(8);
		animator.move(root, 0, 0, 2);
		animator.rotate(upperbody, 0, (float) Math.toRadians(407.5F), 0);
		animator.move(upperbody, 0, 1, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-25F), (float) Math.toRadians(55F));
		animator.rotate(right_arm2, 0, 0, (float) Math.toRadians(42.5F));
		animator.rotate(right_joint, (float) Math.toRadians(87.5F), 0,0);
		animator.rotate(chainsaw, (float) Math.toRadians(87.5F), 0, 0);
		animator.endKeyframe();

		animator.startKeyframe(0);
		animator.move(root, 0, 0, 2);
		animator.rotate(upperbody, 0, (float) Math.toRadians(47.5F), 0);
		animator.move(upperbody, 0, 1, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-25F), (float) Math.toRadians(55F));
		animator.rotate(right_arm2, 0, 0, (float) Math.toRadians(42.5F));
		animator.rotate(right_joint, (float) Math.toRadians(87.5F), 0, 0);
		animator.rotate(chainsaw, (float) Math.toRadians(87.5F), 0, 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(8);

		animator.resetKeyframe(12);


		animator.setAnimation(The_Prowler_Entity.PROWLER_STUN);
		animator.startKeyframe(15);
		animator.rotate(upperbody,(float)Math.toRadians(40F),0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(30);

		animator.resetKeyframe(15);
	}

	@Override
	public void setupAnim(The_Prowler_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		this.upperbody.rotateAngleY += netHeadYaw * 0.6F * Mth.DEG_TO_RAD;
		float globalSpeed = 0.15f;
		float globalDegree = 0.5F;

		float sawspeed = 0;
		if(entityIn.getIsAwaken() && entityIn.getAnimation() != The_Prowler_Entity.PROWLER_STUN){
			sawspeed = 0.75f;
		}

		saw.rotateAngleX -= ageInTicks * sawspeed;

		this.catapiller.rotationPointZ += Mth.cos(limbSwing * globalSpeed ) * limbSwingAmount * 5;

		this.catapiller2.rotationPointZ += Mth.cos(limbSwing * globalSpeed ) * limbSwingAmount * 5;

		float partialTick = Minecraft.getInstance().getFrameTime();
		float deactivateProgress = entityIn.prevdeactivateProgress + (entityIn.deactivateProgress - entityIn.prevdeactivateProgress) * partialTick;

		progressRotationPrev(upperbody,deactivateProgress,(float)Math.toRadians(40F), 0, 0, 15f);

	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				upperbody,
				chestplate,
				eye_blow,
				chestplate2,
				rocket_luncher,
				missile,
				missile2,
				missile3,
				right_arm,
				right_arm_joint,
				sholder_pad,
				sholder_pad2,
				right_arm2,
				right_joint,
				chainsaw,
				saw,
				blade5,
				blade6,
				blade7,
				blade8,
				blade,
				blade2,
				blade3,
				blade4,
				pelvis,catapiller,catapiller2,pipe2,
				pipe);
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