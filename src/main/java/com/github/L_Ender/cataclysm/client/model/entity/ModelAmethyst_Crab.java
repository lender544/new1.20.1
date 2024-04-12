package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Amethyst_Crab_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class ModelAmethyst_Crab extends AdvancedEntityModel<Amethyst_Crab_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox body;
	private final AdvancedModelBox big_amethyst;
	private final AdvancedModelBox small_amethyst;
	private final AdvancedModelBox small_amethyst2;
	private final AdvancedModelBox amethyst_1;
	private final AdvancedModelBox small_amethyst3;
	private final AdvancedModelBox small_amethyst4;
	private final AdvancedModelBox left_body;
	private final AdvancedModelBox big_amethyst2;
	private final AdvancedModelBox right_body;
	private final AdvancedModelBox stomach;
	private final AdvancedModelBox head;
	private final AdvancedModelBox left_eye;
	private final AdvancedModelBox right_eye;
	private final AdvancedModelBox small_amethyst5;
	private final AdvancedModelBox small_amethyst6;
	private final AdvancedModelBox left_leg;
	private final AdvancedModelBox left_joint;
	private final AdvancedModelBox right_leg;
	private final AdvancedModelBox right_joint;
	private final AdvancedModelBox left_leg2;
	private final AdvancedModelBox left_joint2;
	private final AdvancedModelBox right_leg2;
	private final AdvancedModelBox right_joint2;
	private final AdvancedModelBox left_leg3;
	private final AdvancedModelBox left_joint3;
	private final AdvancedModelBox right_leg3;
	private final AdvancedModelBox right_joint3;
	private final AdvancedModelBox right_leg4;
	private final AdvancedModelBox left_leg4;
	private final AdvancedModelBox right_tong_leg;
	private final AdvancedModelBox right_Tong;
	private final AdvancedModelBox upper_claw2;
	private final AdvancedModelBox under_claw2;
	private final AdvancedModelBox left_tong_leg;
	private final AdvancedModelBox left_Tong;
	private final AdvancedModelBox upper_claw;
	private final AdvancedModelBox under_claw;
	private ModelAnimator animator;

	public ModelAmethyst_Crab() {
		texWidth = 256;
		texHeight = 256;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		body = new AdvancedModelBox(this);
		body.setRotationPoint(-0.4889F, -19.1765F, 3.4113F);
		root.addChild(body);
		setRotationAngle(body, -0.48F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-7.5111F, -8.8235F, -18.4113F, 16.0F, 10.0F, 32.0F, 0.0F, false);
		body.setTextureOffset(0, 139).addBox(-6.5111F, -22.8235F, 0.5887F, 14.0F, 14.0F, 13.0F, 0.0F, false);

		big_amethyst = new AdvancedModelBox(this);
		big_amethyst.setRotationPoint(-8.0111F, -19.3235F, 5.0887F);
		body.addChild(big_amethyst);
		setRotationAngle(big_amethyst, 0.0F, 0.2182F, 0.0F);
		big_amethyst.setTextureOffset(0, 138).addBox(-6.5F, -11.5F, -6.5F, 13.0F, 24.0F, 14.0F, 0.0F, false);

		small_amethyst = new AdvancedModelBox(this);
		small_amethyst.setRotationPoint(0.0F, -11.5F, 0.5F);
		big_amethyst.addChild(small_amethyst);
		setRotationAngle(small_amethyst, 0.0F, 0.7854F, 0.0F);
		small_amethyst.setTextureOffset(71, 90).addBox(-5.5F, -10.0F, 0.0F, 11.0F, 10.0F, 0.0F, 0.0F, false);

		small_amethyst2 = new AdvancedModelBox(this);
		small_amethyst2.setRotationPoint(0.0F, -11.5F, 0.5F);
		big_amethyst.addChild(small_amethyst2);
		setRotationAngle(small_amethyst2, 0.0F, -0.7854F, 0.0F);
		small_amethyst2.setTextureOffset(132, 60).addBox(-5.5F, -10.0F, 0.0F, 11.0F, 10.0F, 0.0F, 0.0F, false);

		amethyst_1 = new AdvancedModelBox(this);
		amethyst_1.setRotationPoint(-8.0111F, -10.3235F, 0.5887F);
		body.addChild(amethyst_1);
		setRotationAngle(amethyst_1, 0.0F, 0.2182F, 0.0F);
		amethyst_1.setTextureOffset(102, 126).addBox(-7.5F, -5.5F, -11.0F, 9.0F, 9.0F, 9.0F, 0.0F, false);

		small_amethyst3 = new AdvancedModelBox(this);
		small_amethyst3.setRotationPoint(-3.0F, -5.5F, -7.0F);
		amethyst_1.addChild(small_amethyst3);
		setRotationAngle(small_amethyst3, 0.0F, -0.7854F, 0.0F);
		small_amethyst3.setTextureOffset(144, 29).addBox(-5.5F, -10.0F, 0.0F, 11.0F, 10.0F, 0.0F, 0.0F, false);

		small_amethyst4 = new AdvancedModelBox(this);
		small_amethyst4.setRotationPoint(-3.0F, -5.5F, -7.0F);
		amethyst_1.addChild(small_amethyst4);
		setRotationAngle(small_amethyst4, 0.0F, 0.7854F, 0.0F);
		small_amethyst4.setTextureOffset(144, 29).addBox(-5.5F, -10.0F, 0.0F, 11.0F, 10.0F, 0.0F, 0.0F, false);

		left_body = new AdvancedModelBox(this);
		left_body.setRotationPoint(8.9889F, -0.3235F, 0.0887F);
		body.addChild(left_body);
		setRotationAngle(left_body, -0.0289F, -0.2163F, 0.134F);
		left_body.setTextureOffset(0, 73).addBox(-5.5F, -3.5F, -16.5F, 21.0F, 0.0F, 28.0F, 0.0F, false);
		left_body.setTextureOffset(0, 102).addBox(-4.5F, -7.5F, -15.5F, 13.0F, 8.0F, 27.0F, 0.0F, false);

		big_amethyst2 = new AdvancedModelBox(this);
		big_amethyst2.setRotationPoint(6.5F, -7.5F, 4.0F);
		left_body.addChild(big_amethyst2);
		setRotationAngle(big_amethyst2, 0.0F, 0.0F, -0.1309F);
		big_amethyst2.setTextureOffset(101, 60).addBox(-8.0F, -4.0F, -10.5F, 7.0F, 4.0F, 8.0F, 0.0F, false);
		big_amethyst2.setTextureOffset(92, 159).addBox(-8.0F, -8.0F, -2.5F, 8.0F, 8.0F, 9.0F, 0.0F, false);

		right_body = new AdvancedModelBox(this);
		right_body.setRotationPoint(-8.0111F, -0.3235F, 0.0887F);
		body.addChild(right_body);
		setRotationAngle(right_body, -0.0289F, 0.2163F, -0.134F);
		right_body.setTextureOffset(65, 0).addBox(-16.5F, -3.5F, -16.5F, 21.0F, 0.0F, 28.0F, 0.0F, false);
		right_body.setTextureOffset(72, 90).addBox(-8.5F, -7.5F, -15.5F, 13.0F, 8.0F, 27.0F, 0.0F, false);

		stomach = new AdvancedModelBox(this);
		stomach.setRotationPoint(0.4889F, 2.6765F, 0.0887F);
		body.addChild(stomach);
		setRotationAngle(stomach, 0.0873F, 0.0F, 0.0F);
		stomach.setTextureOffset(0, 43).addBox(-14.0F, -4.5F, -13.5F, 28.0F, 7.0F, 22.0F, 0.0F, false);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.4889F, 7.1765F, -19.4113F);
		body.addChild(head);


		left_eye = new AdvancedModelBox(this);
		left_eye.setRotationPoint(4.5F, -11.5F, 1.0F);
		head.addChild(left_eye);
		setRotationAngle(left_eye, 0.5672F, -0.2618F, 0.3491F);
		left_eye.setTextureOffset(71, 73).addBox(-0.5F, -9.5F, -2.0F, 3.0F, 9.0F, 2.0F, 0.0F, false);

		right_eye = new AdvancedModelBox(this);
		right_eye.setRotationPoint(-4.5F, -13.5F, 1.0F);
		head.addChild(right_eye);
		setRotationAngle(right_eye, 0.5672F, 0.2618F, -0.3491F);
		right_eye.setTextureOffset(14, 73).addBox(-2.5F, -7.5F, -2.0F, 3.0F, 9.0F, 2.0F, 0.0F, false);

		small_amethyst5 = new AdvancedModelBox(this);
		small_amethyst5.setRotationPoint(2.9889F, -26.8235F, 5.5887F);
		body.addChild(small_amethyst5);
		setRotationAngle(small_amethyst5, 0.0F, 0.7854F, 0.0F);
		small_amethyst5.setTextureOffset(0, 118).addBox(-5.5F, -6.0F, 0.0F, 11.0F, 10.0F, 0.0F, 0.0F, false);

		small_amethyst6 = new AdvancedModelBox(this);
		small_amethyst6.setRotationPoint(2.9889F, -21.8235F, 5.5887F);
		body.addChild(small_amethyst6);
		setRotationAngle(small_amethyst6, 0.0F, -0.7854F, 0.0F);
		small_amethyst6.setTextureOffset(71, 90).addBox(-5.5F, -10.0F, 0.0F, 11.0F, 10.0F, 0.0F, 0.0F, false);

		left_tong_leg = new AdvancedModelBox(this);
		left_tong_leg.setRotationPoint(14.4889F, 4.1765F, -13.4113F);
		body.addChild(left_tong_leg);
		setRotationAngle(left_tong_leg, 0.6545F, -0.7418F, 0.0F);
		left_tong_leg.setTextureOffset(136, 0).addBox(-4.0F, -3.0F, -16.0F, 8.0F, 7.0F, 20.0F, 0.0F, false);
		left_tong_leg.setTextureOffset(153, 90).addBox(0.0F, -9.0F, -16.0F, 0.0F, 13.0F, 20.0F, 0.0F, false);

		left_Tong = new AdvancedModelBox(this);
		left_Tong.setRotationPoint(0.0F, 0.5F, -14.5F);
		left_tong_leg.addChild(left_Tong);
		setRotationAngle(left_Tong, 0.0F, 1.1781F, 0.0F);
		left_Tong.setTextureOffset(55, 159).addBox(-3.0F, -6.5F, -11.0F, 6.0F, 13.0F, 12.0F, 0.0F, false);

		upper_claw = new AdvancedModelBox(this);
		upper_claw.setRotationPoint(0.0F, 1.0F, -11.0F);
		left_Tong.addChild(upper_claw);
		setRotationAngle(upper_claw, -0.4363F, 0.0F, 0.0F);
		upper_claw.setTextureOffset(0, 43).addBox(-2.0F, -21.5F, -6.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		upper_claw.setTextureOffset(54, 114).addBox(-3.0F, -14.5F, -5.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		upper_claw.setTextureOffset(0, 73).addBox(0.0F, -17.5F, -7.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		upper_claw.setTextureOffset(79, 102).addBox(-2.0F, -16.5F, -12.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		upper_claw.setTextureOffset(122, 126).addBox(-5.0F, -11.5F, -20.0F, 10.0F, 12.0F, 20.0F, 0.3F, false);
		upper_claw.setTextureOffset(61, 126).addBox(-5.0F, -11.5F, -20.0F, 10.0F, 12.0F, 20.0F, 0.0F, false);

		under_claw = new AdvancedModelBox(this);
		under_claw.setRotationPoint(0.0F, 1.5F, -11.0F);
		left_Tong.addChild(under_claw);
		setRotationAngle(under_claw, 0.5236F, 0.0F, 0.0F);
		under_claw.setTextureOffset(158, 60).addBox(-4.0F, 0.0F, -17.0F, 8.0F, 5.0F, 17.0F, 0.0F, false);

		right_tong_leg = new AdvancedModelBox(this);
		right_tong_leg.setRotationPoint(-10.5111F, 6.1765F, -11.4113F);
		body.addChild(right_tong_leg);
		setRotationAngle(right_tong_leg, 0.3927F, 0.5236F, -0.0873F);
		right_tong_leg.setTextureOffset(126, 90).addBox(-3.8F, -2.5F, -13.0F, 6.0F, 4.0F, 13.0F, 0.0F, false);
		right_tong_leg.setTextureOffset(0, 73).addBox(-0.8F, -6.5F, -13.0F, 0.0F, 8.0F, 13.0F, 0.0F, false);

		right_Tong = new AdvancedModelBox(this);
		right_Tong.setRotationPoint(-1.0F, 0.0F, -13.0F);
		right_tong_leg.addChild(right_Tong);
		setRotationAngle(right_Tong, 0.0F, -1.1781F, 0.0F);
		right_Tong.setTextureOffset(0, 102).addBox(-1.8F, -3.5F, -4.0F, 4.0F, 6.0F, 9.0F, 0.0F, false);

		upper_claw2 = new AdvancedModelBox(this);
		upper_claw2.setRotationPoint(0.1F, 1.0F, -4.0F);
		right_Tong.addChild(upper_claw2);
		setRotationAngle(upper_claw2, -0.4363F, 0.0F, 0.0F);
		upper_claw2.setTextureOffset(127, 159).addBox(-2.9F, -6.5F, -10.0F, 6.0F, 7.0F, 10.0F, 0.0F, false);

		under_claw2 = new AdvancedModelBox(this);
		under_claw2.setRotationPoint(0.2F, 1.5F, -4.0F);
		right_Tong.addChild(under_claw2);
		setRotationAngle(under_claw2, 0.5672F, 0.0F, 0.0F);
		under_claw2.setTextureOffset(54, 102).addBox(-2.0F, 0.0F, -8.0F, 4.0F, 3.0F, 8.0F, 0.0F, false);

		left_leg = new AdvancedModelBox(this);
		left_leg.setRotationPoint(12.0F, -17.0F, -2.5F);
		root.addChild(left_leg);
		setRotationAngle(left_leg, -0.1309F, 0.6109F, -0.0873F);
		left_leg.setTextureOffset(97, 29).addBox(0.0F, -2.0F, -2.0F, 19.0F, 4.0F, 4.0F, 0.0F, false);

		left_joint = new AdvancedModelBox(this);
		left_joint.setRotationPoint(18.3F, -0.1F, 0.0F);
		left_leg.addChild(left_joint);
		setRotationAngle(left_joint, -0.1309F, 0.0F, 0.0F);
		left_joint.setTextureOffset(187, 28).addBox(-0.3F, -8.4F, 0.0F, 12.0F, 27.0F, 0.0F, 0.0F, false);
		left_joint.setTextureOffset(65, 0).addBox(-0.3F, -2.4F, -3.0F, 6.0F, 21.0F, 6.0F, 0.0F, false);

		right_leg = new AdvancedModelBox(this);
		right_leg.setRotationPoint(-12.0F, -17.0F, -2.5F);
		root.addChild(right_leg);
		setRotationAngle(right_leg, -0.1309F, -0.6109F, 0.0873F);
		right_leg.setTextureOffset(97, 29).addBox(-19.0F, -2.0F, -2.0F, 19.0F, 4.0F, 4.0F, 0.0F, true);

		right_joint = new AdvancedModelBox(this);
		right_joint.setRotationPoint(-18.3F, -0.1F, 0.0F);
		right_leg.addChild(right_joint);
		setRotationAngle(right_joint, -0.1309F, 0.0F, 0.0F);
		right_joint.setTextureOffset(0, 0).addBox(-11.7F, -8.4F, 0.0F, 12.0F, 27.0F, 0.0F, 0.0F, true);
		right_joint.setTextureOffset(65, 0).addBox(-5.7F, -2.4F, -3.0F, 6.0F, 21.0F, 6.0F, 0.0F, true);

		left_leg2 = new AdvancedModelBox(this);
		left_leg2.setRotationPoint(12.0F, -16.0F, 2.5F);
		root.addChild(left_leg2);
		setRotationAngle(left_leg2, 0.0F, 0.0F, -0.0873F);
		left_leg2.setTextureOffset(97, 29).addBox(0.0F, -2.0F, -2.0F, 19.0F, 4.0F, 4.0F, 0.0F, false);

		left_joint2 = new AdvancedModelBox(this);
		left_joint2.setRotationPoint(14.3F, 0.9F, 0.0F);
		left_leg2.addChild(left_joint2);
		setRotationAngle(left_joint2, -0.1309F, -0.0873F, -0.4363F);
		left_joint2.setTextureOffset(0, 0).addBox(-0.3F, -8.4F, 0.0F, 12.0F, 27.0F, 0.0F, 0.0F, false);
		left_joint2.setTextureOffset(66, 0).addBox(-0.3F, -2.4F, -3.0F, 6.0F, 21.0F, 6.0F, 0.0F, false);

		right_leg2 = new AdvancedModelBox(this);
		right_leg2.setRotationPoint(-12.0F, -16.0F, 2.5F);
		root.addChild(right_leg2);
		setRotationAngle(right_leg2, 0.0F, 0.0F, 0.0873F);
		right_leg2.setTextureOffset(97, 29).addBox(-19.0F, -2.0F, -2.0F, 19.0F, 4.0F, 4.0F, 0.0F, true);

		right_joint2 = new AdvancedModelBox(this);
		right_joint2.setRotationPoint(-14.3F, 0.9F, 0.0F);
		right_leg2.addChild(right_joint2);
		setRotationAngle(right_joint2, -0.1309F, 0.0873F, 0.4363F);
		right_joint2.setTextureOffset(187, 28).addBox(-11.7F, -8.4F, 0.0F, 12.0F, 27.0F, 0.0F, 0.0F, true);
		right_joint2.setTextureOffset(65, 0).addBox(-5.7F, -2.4F, -3.0F, 6.0F, 21.0F, 6.0F, 0.0F, true);

		left_leg3 = new AdvancedModelBox(this);
		left_leg3.setRotationPoint(12.0F, -13.0F, 9.5F);
		root.addChild(left_leg3);
		setRotationAngle(left_leg3, 0.2618F, -0.3927F, -0.2182F);
		left_leg3.setTextureOffset(97, 29).addBox(0.0F, -2.0F, -2.0F, 19.0F, 4.0F, 4.0F, 0.0F, false);

		left_joint3 = new AdvancedModelBox(this);
		left_joint3.setRotationPoint(14.3F, 0.9F, 0.0F);
		left_leg3.addChild(left_joint3);
		setRotationAngle(left_joint3, -0.1309F, -0.0873F, -0.3927F);
		left_joint3.setTextureOffset(187, 28).addBox(-0.3F, -8.4F, 0.0F, 12.0F, 27.0F, 0.0F, 0.0F, false);
		left_joint3.setTextureOffset(65, 0).addBox(-0.3F, -2.4F, -3.0F, 6.0F, 21.0F, 6.0F, 0.0F, false);

		right_leg3 = new AdvancedModelBox(this);
		right_leg3.setRotationPoint(-12.0F, -13.0F, 9.5F);
		root.addChild(right_leg3);
		setRotationAngle(right_leg3, 0.2618F, 0.3927F, 0.2182F);
		right_leg3.setTextureOffset(97, 29).addBox(-19.0F, -2.0F, -2.0F, 19.0F, 4.0F, 4.0F, 0.0F, true);

		right_joint3 = new AdvancedModelBox(this);
		right_joint3.setRotationPoint(-14.3F, 0.9F, 0.0F);
		right_leg3.addChild(right_joint3);
		setRotationAngle(right_joint3, -0.1309F, 0.0873F, 0.3927F);
		right_joint3.setTextureOffset(0, 0).addBox(-11.7F, -8.4F, 0.0F, 12.0F, 27.0F, 0.0F, 0.0F, true);
		right_joint3.setTextureOffset(65, 0).addBox(-5.7F, -2.4F, -3.0F, 6.0F, 21.0F, 6.0F, 0.0F, true);

		right_leg4 = new AdvancedModelBox(this);
		right_leg4.setRotationPoint(-10.5F, -15.0F, 14.5F);
		root.addChild(right_leg4);
		setRotationAngle(right_leg4, -0.576F, 0.6981F, -0.6109F);
		right_leg4.setTextureOffset(79, 43).addBox(-31.5F, 1.0F, -7.5F, 35.0F, 0.0F, 16.0F, 0.0F, false);

		left_leg4 = new AdvancedModelBox(this);
		left_leg4.setRotationPoint(10.5F, -15.0F, 14.5F);
		root.addChild(left_leg4);
		setRotationAngle(left_leg4, -0.6109F, -0.7418F, 0.6109F);
		left_leg4.setTextureOffset(71, 73).addBox(-3.5F, 1.0F, -7.5F, 35.0F, 0.0F, 16.0F, 0.0F, false);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
		}


	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				body,
				big_amethyst,
				small_amethyst,
				small_amethyst2,
				amethyst_1,
				small_amethyst3,
				small_amethyst4,
				left_body,
				big_amethyst2,
				right_body,
				stomach,
				head,
				left_eye,
				right_eye,
				small_amethyst5,
				small_amethyst6,
				left_leg,
				left_joint,
				right_leg,
				left_joint2,
				left_leg2,
				right_joint,
				left_leg2,
				left_joint2,
				right_leg2,
				right_joint2,
				left_leg3,
				left_joint3,
				right_leg3,
				right_joint3,
				right_leg4,
				left_leg4,
				right_tong_leg,
				right_Tong,
				upper_claw2,
				under_claw2,
				left_tong_leg,
				left_Tong,
				upper_claw,
				under_claw);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	public void animate(Amethyst_Crab_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(Amethyst_Crab_Entity.CRAB_SMASH);
		animator.startKeyframe(12);
		animator.rotate(body,(float)Math.toRadians(5F),0,(float)Math.toRadians(-5F));
		animator.rotate(left_body,0,0,(float)Math.toRadians(-5F));
		animator.rotate(right_body,0,0,(float)Math.toRadians(5F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(2.5F));
		animator.rotate(left_joint,0,0,(float)Math.toRadians(-7.5F));
		animator.rotate(left_leg4,0,(float)Math.toRadians(7.5F),0);

		animator.rotate(right_leg,0,(float)Math.toRadians(-5F),0);
		animator.rotate(right_joint,0,0,(float)Math.toRadians(10F));
		animator.rotate(right_leg2,0,0,(float)Math.toRadians(-7.5F));
		animator.rotate(right_joint2,0,0,(float)Math.toRadians(-2.5F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(5F));
		animator.rotate(right_joint3,0,0,(float)Math.toRadians(-10F));
		animator.rotate(right_leg4,(float)Math.toRadians(-15F),(float)Math.toRadians(10F),(float)Math.toRadians(-12.5F));
		animator.rotate(right_tong_leg,0,(float)Math.toRadians(5F),0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(5F),0);

		animator.rotate(upper_claw2,(float)Math.toRadians(32.5F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-27.5F),0,0);

		animator.rotate(left_tong_leg,(float)Math.toRadians(-60F),(float)Math.toRadians(22.5F),(float)Math.toRadians(20F));
		animator.move(left_tong_leg,0,-4,0);
		animator.rotate(left_Tong,(float)Math.toRadians(-67.5F),(float)Math.toRadians(-32.5F),(float)Math.toRadians(-25F));

		animator.rotate(upper_claw,(float)Math.toRadians(16.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-57.5F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(8);

		animator.startKeyframe(3);
		animator.move(root,0,2,0);
		animator.rotate(body,(float)Math.toRadians(40F),(float)Math.toRadians(20F),0);
		animator.rotate(left_body,0,0,(float)Math.toRadians(-5F));
		animator.rotate(right_body,0,0,(float)Math.toRadians(5F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(10F));
		animator.rotate(left_joint,0,0,(float)Math.toRadians(-17.5F));
		animator.rotate(left_leg4,(float)Math.toRadians(-12.5F),0,(float)Math.toRadians(17.5F));
		animator.move(left_leg4,0,-6,0);

		animator.rotate(right_leg,(float)Math.toRadians(-20F),(float)Math.toRadians(-5F),(float)Math.toRadians(-30F));
		animator.rotate(right_joint,0,0,(float)Math.toRadians(57.5F));
		animator.rotate(right_leg2,0,0,(float)Math.toRadians(-7.5F));
		animator.rotate(right_joint2,0,0,(float)Math.toRadians(-20F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(5F));
		animator.rotate(right_joint3,0,0,(float)Math.toRadians(-7.5F));
		animator.rotate(right_leg4,(float)Math.toRadians(-25F),0,(float)Math.toRadians(-22.5F));
		animator.move(right_leg4,-3,-7,0);
		animator.rotate(right_tong_leg,(float)Math.toRadians(-15F),(float)Math.toRadians(-20F),0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(30F),0);

		animator.rotate(upper_claw2,(float)Math.toRadians(32.5F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-27.5F),0,0);

		animator.rotate(left_tong_leg,(float)Math.toRadians(-47.5F),(float)Math.toRadians(10F),(float)Math.toRadians(10F));
		animator.move(left_tong_leg,0,-4,0);
		animator.rotate(left_Tong,(float)Math.toRadians(80F),(float)Math.toRadians(-57.5F),(float)Math.toRadians(67.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(25F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-32.5F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(20);

		animator.resetKeyframe(10);

		animator.setAnimation(Amethyst_Crab_Entity.CRAB_SMASH_THREE);
		animator.startKeyframe(10);
		animator.rotate(body,(float)Math.toRadians(-27.5F),0,0);
		animator.rotate(left_body,0,0,(float)Math.toRadians(-10F));
		animator.rotate(right_body,0,0,(float)Math.toRadians(10F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(-15F));
		animator.rotate(left_joint,(float)Math.toRadians(12.5F),0,(float)Math.toRadians(-12.5F));

		animator.rotate(right_leg,0,0,(float)Math.toRadians(2.5F));
		animator.rotate(right_joint,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(5F));
		animator.rotate(left_joint2,0,0,(float)Math.toRadians(2.5F));

		animator.rotate(right_leg2,0,0,(float)Math.toRadians(5F));
		animator.rotate(right_joint2,0,0,(float)Math.toRadians(-12.5F));

		animator.rotate(left_leg3,0,0,(float)Math.toRadians(-10F));
		animator.rotate(left_joint3,0,0,(float)Math.toRadians(22.5F));

		animator.rotate(right_leg3,0,0,(float)Math.toRadians(7.5F));
		animator.rotate(right_joint3,0,0,(float)Math.toRadians(-22.5F));

		animator.rotate(left_leg4,(float)Math.toRadians(10F),(float)Math.toRadians(-2.5F),(float)Math.toRadians(-7.5F));
		animator.rotate(right_leg4,(float)Math.toRadians(20F),(float)Math.toRadians(15F),(float)Math.toRadians(12.5F));
		animator.move(right_leg4,0,6,0);

		animator.rotate(right_tong_leg,(float)Math.toRadians(-32.5F),(float)Math.toRadians(-25F),(float)Math.toRadians(-30F));
		animator.rotate(right_Tong,(float)Math.toRadians(12.5F),(float)Math.toRadians(37.5F),(float)Math.toRadians(-60F));

		animator.rotate(upper_claw2,(float)Math.toRadians(22.5F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-22.5F),0,0);

		animator.rotate(left_tong_leg,(float)Math.toRadians(-62.5F),(float)Math.toRadians(25F),(float)Math.toRadians(20F));
		animator.rotate(left_Tong,(float)Math.toRadians(42.5F),(float)Math.toRadians(-20F),(float)Math.toRadians(62.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-25F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(4);

		animator.startKeyframe(3);
		animator.move(root,0,2,0);
		animator.rotate(body,(float)Math.toRadians(55F),0,0);
		animator.rotate(left_body,0,0,(float)Math.toRadians(-2.5F));
		animator.rotate(right_body,0,0,(float)Math.toRadians(2.5F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(7.5F));
		animator.rotate(left_joint,(float)Math.toRadians(17.5F),0,(float)Math.toRadians(-17.5F));

		animator.rotate(right_leg,0,(float)Math.toRadians(-7.5F),(float)Math.toRadians(20F));
		animator.move(right_leg,0,7,0);
		animator.rotate(right_joint,(float)Math.toRadians(12.5F),0,(float)Math.toRadians(5F));
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(12.5F));
		animator.rotate(left_joint2,0,0,(float)Math.toRadians(-17.5F));

		animator.rotate(right_leg2,0,0,(float)Math.toRadians(-5F));

		animator.rotate(left_leg3,0,0,(float)Math.toRadians(25F));
		animator.move(left_leg3,0,-7,0);
		animator.rotate(left_joint3,0,0,(float)Math.toRadians(-7.5F));

		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-27.5F));
		animator.move(right_leg3,0,-7,0);
		animator.rotate(right_joint3,0,0,(float)Math.toRadians(10F));

		animator.rotate(left_leg4,0,0,(float)Math.toRadians(22.5F));
		animator.move(left_leg4,0,-8,0);
		animator.rotate(right_leg4,0,0,(float)Math.toRadians(-25F));
		animator.move(right_leg4,0,-7,0);

		animator.rotate(right_tong_leg,(float)Math.toRadians(-25F),(float)Math.toRadians(-20F),(float)Math.toRadians(-5F));
		animator.rotate(right_Tong,(float)Math.toRadians(17.5F),(float)Math.toRadians(55F),(float)Math.toRadians(-92.5F));

		animator.rotate(upper_claw2,(float)Math.toRadians(32.5F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-35F),0,0);

		animator.rotate(left_tong_leg,(float)Math.toRadians(-32.5F),(float)Math.toRadians(30F),(float)Math.toRadians(5F));
		animator.rotate(left_Tong,(float)Math.toRadians(65F),(float)Math.toRadians(-30F),(float)Math.toRadians(92.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(27.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-37.5F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(3);

		animator.startKeyframe(10);
		animator.rotate(root,0,(float)Math.toRadians(32.5F),0);
		animator.rotate(body,(float)Math.toRadians(-27.5F),0,0);
		animator.rotate(left_body,0,0,(float)Math.toRadians(-10F));
		animator.rotate(right_body,0,0,(float)Math.toRadians(10F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(-15F));
		animator.rotate(left_joint,(float)Math.toRadians(17.5F),0,(float)Math.toRadians(-17.5F));

		animator.rotate(right_leg,0,0,(float)Math.toRadians(2.5F));
		animator.rotate(right_joint,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(5F));
		animator.rotate(left_joint2,0,0,(float)Math.toRadians(2.5F));

		animator.rotate(right_leg2,0,0,(float)Math.toRadians(5F));
		animator.rotate(right_joint2,0,0,(float)Math.toRadians(-12.5F));

		animator.rotate(left_leg3,0,0,(float)Math.toRadians(-10F));
		animator.rotate(left_joint3,0,0,(float)Math.toRadians(22.5F));

		animator.rotate(right_leg3,0,0,(float)Math.toRadians(7.5F));
		animator.rotate(right_joint3,0,0,(float)Math.toRadians(-22.5F));

		animator.rotate(left_leg4,(float)Math.toRadians(10F),(float)Math.toRadians(-2.5F),(float)Math.toRadians(-7.5F));
		animator.move(left_leg4,0,4,0);
		animator.rotate(right_leg4,(float)Math.toRadians(20F),(float)Math.toRadians(15F),(float)Math.toRadians(12.5F));
		animator.move(right_leg4,0,6,0);

		animator.rotate(right_tong_leg,(float)Math.toRadians(-32.5F),(float)Math.toRadians(-25F),(float)Math.toRadians(-30F));
		animator.rotate(right_Tong,(float)Math.toRadians(17.5F),(float)Math.toRadians(55F),(float)Math.toRadians(-92.5F));

		animator.rotate(upper_claw2,(float)Math.toRadians(32.5F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-35F),0,0);

		animator.rotate(left_tong_leg,(float)Math.toRadians(-62.5F),(float)Math.toRadians(25F),(float)Math.toRadians(20F));
		animator.rotate(left_Tong,(float)Math.toRadians(65F),(float)Math.toRadians(-30F),(float)Math.toRadians(92.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(27.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-37.5F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(4);

		animator.startKeyframe(3);
		animator.rotate(root,0,(float)Math.toRadians(45F),0);
		animator.move(root,0,2,0);
		animator.rotate(body,(float)Math.toRadians(55F),0,0);
		animator.rotate(left_body,0,0,(float)Math.toRadians(2.5F));
		animator.rotate(right_body,0,0,(float)Math.toRadians(2.5F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(-7.5F));
		animator.rotate(left_joint,(float)Math.toRadians(17.5F),0,(float)Math.toRadians(-17.5F));

		animator.rotate(right_leg,0,(float)Math.toRadians(-7.5F),(float)Math.toRadians(20F));
		animator.move(right_leg,0,7,0);
		animator.rotate(right_joint,(float)Math.toRadians(12.5F),0,(float)Math.toRadians(5F));
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(12.5F));
		animator.rotate(left_joint2,0,0,(float)Math.toRadians(-17.5F));

		animator.rotate(right_leg2,0,0,(float)Math.toRadians(-5F));
		//animator.rotate(right_joint2,0,0,(float)Math.toRadians(-12.5F));

		animator.rotate(left_leg3,0,0,(float)Math.toRadians(25F));
		animator.move(left_leg3,0,-7,0);
		animator.rotate(left_joint3,0,0,(float)Math.toRadians(-7.5F));

		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-27.5F));
		animator.move(right_leg3,0,-7,0);
		animator.rotate(right_joint3,0,0,(float)Math.toRadians(10F));

		animator.rotate(left_leg4,0,0,(float)Math.toRadians(22.5F));
		animator.move(left_leg4,0,-8,0);
		animator.rotate(right_leg4,0,0,(float)Math.toRadians(-25F));
		animator.move(right_leg4,0,-7,0);

		animator.rotate(right_tong_leg,(float)Math.toRadians(-25F),(float)Math.toRadians(-20F),(float)Math.toRadians(-5F));
		animator.rotate(right_Tong,(float)Math.toRadians(20F),(float)Math.toRadians(55F),(float)Math.toRadians(-92.5F));

		animator.rotate(upper_claw2,(float)Math.toRadians(32.5F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-35F),0,0);

		animator.rotate(left_tong_leg,(float)Math.toRadians(-32.5F),(float)Math.toRadians(30F),(float)Math.toRadians(5F));
		animator.rotate(left_Tong,(float)Math.toRadians(65F),(float)Math.toRadians(-30F),(float)Math.toRadians(92.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(27.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-37.5F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(3);

		animator.startKeyframe(10);
		animator.rotate(body,(float)Math.toRadians(-27.5F),0,0);
		animator.rotate(left_body,0,0,(float)Math.toRadians(-10F));
		animator.rotate(right_body,0,0,(float)Math.toRadians(10F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(-15F));
		animator.rotate(left_joint,(float)Math.toRadians(17.5F),0,(float)Math.toRadians(-17.5F));

		animator.rotate(right_leg,0,0,(float)Math.toRadians(2.5F));
		animator.rotate(right_joint,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(5F));
		animator.rotate(left_joint2,0,0,(float)Math.toRadians(2.5F));

		animator.rotate(right_leg2,0,0,(float)Math.toRadians(5F));
		animator.rotate(right_joint2,0,0,(float)Math.toRadians(-12.5F));

		animator.rotate(left_leg3,0,0,(float)Math.toRadians(-10F));
		animator.rotate(left_joint3,0,0,(float)Math.toRadians(22.5F));

		animator.rotate(right_leg3,0,0,(float)Math.toRadians(7.5F));
		animator.rotate(right_joint3,0,0,(float)Math.toRadians(-22.5F));

		animator.rotate(left_leg4,(float)Math.toRadians(10F),(float)Math.toRadians(-2.5F),(float)Math.toRadians(-7.5F));
		animator.move(left_leg4,0,4,0);
		animator.rotate(right_leg4,(float)Math.toRadians(20F),(float)Math.toRadians(15F),(float)Math.toRadians(12.5F));
		animator.move(right_leg4,0,6,0);

		animator.rotate(right_tong_leg,(float)Math.toRadians(-35F),(float)Math.toRadians(-25F),(float)Math.toRadians(-30F));
		animator.rotate(right_Tong,(float)Math.toRadians(17.5F),(float)Math.toRadians(55F),(float)Math.toRadians(-92.5F));

		animator.rotate(upper_claw2,(float)Math.toRadians(32.5F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-35F),0,0);

		animator.rotate(left_tong_leg,(float)Math.toRadians(-62.5F),(float)Math.toRadians(25F),(float)Math.toRadians(20F));
		animator.rotate(left_Tong,(float)Math.toRadians(65F),(float)Math.toRadians(-30F),(float)Math.toRadians(92.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(27.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-37.5F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(4);

		animator.startKeyframe(3);
		animator.rotate(root,0,(float)Math.toRadians(-25F),0);
		animator.move(root,0,2,0);
		animator.rotate(body,(float)Math.toRadians(55F),0,0);
		animator.rotate(left_body,0,0,(float)Math.toRadians(2.5F));
		animator.rotate(right_body,0,0,(float)Math.toRadians(2.5F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(7.5F));
		animator.rotate(left_joint,(float)Math.toRadians(17.5F),0,(float)Math.toRadians(-17.5F));

		animator.rotate(right_leg,0,(float)Math.toRadians(-7.5F),(float)Math.toRadians(20F));
		animator.move(right_leg,0,7,0);
		animator.rotate(right_joint,(float)Math.toRadians(12.5F),0,(float)Math.toRadians(5F));
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(12.5F));
		animator.rotate(left_joint2,0,0,(float)Math.toRadians(-17.5F));

		animator.rotate(right_leg2,0,0,(float)Math.toRadians(-5F));
		//animator.rotate(right_joint2,0,0,(float)Math.toRadians(-12.5F));

		animator.rotate(left_leg3,0,0,(float)Math.toRadians(25F));
		animator.move(left_leg3,0,-7,0);
		animator.rotate(left_joint3,0,0,(float)Math.toRadians(-7.5F));

		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-27.5F));
		animator.move(right_leg3,0,-7,0);
		animator.rotate(right_joint3,0,0,(float)Math.toRadians(10F));

		animator.rotate(left_leg4,0,0,(float)Math.toRadians(22.5F));
		animator.move(left_leg4,0,-8,0);
		animator.rotate(right_leg4,0,0,(float)Math.toRadians(-25F));
		animator.move(right_leg4,0,-7,0);

		animator.rotate(right_tong_leg,(float)Math.toRadians(-25F),(float)Math.toRadians(-20F),(float)Math.toRadians(-5F));
		animator.rotate(right_Tong,(float)Math.toRadians(20F),(float)Math.toRadians(55F),(float)Math.toRadians(-92.5F));

		animator.rotate(upper_claw2,(float)Math.toRadians(32.5F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-35F),0,0);

		animator.rotate(left_tong_leg,(float)Math.toRadians(-32.5F),(float)Math.toRadians(30F),(float)Math.toRadians(5F));
		animator.rotate(left_Tong,(float)Math.toRadians(65F),(float)Math.toRadians(-30F),(float)Math.toRadians(92.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(27.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-37.5F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.resetKeyframe(10);


		animator.setAnimation(Amethyst_Crab_Entity.CRAB_DEATH);
		animator.startKeyframe(8);
		animator.rotate(root,(float)Math.toRadians(-150F),0,0);
		animator.move(root,0,-26,-9);
		animator.rotate(body,(float)Math.toRadians(-10F),0,0);
		animator.rotate(left_eye,0,0,(float)Math.toRadians(55F));
		animator.rotate(right_eye,0,0,(float)Math.toRadians(-62.5F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(45F));
		//animator.rotate(left_joint,0,0,0);

		animator.rotate(right_leg,0,0,(float)Math.toRadians(-7.5F));
		//animator.rotate(right_joint,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(32.5F));
		//animator.rotate(left_joint2,0,0,(float)Math.toRadians(2.5F));

		animator.rotate(right_leg2,0,0,(float)Math.toRadians(-32.5F));
		//animator.rotate(right_joint2,0,0,(float)Math.toRadians(-12.5F));

		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		//animator.rotate(left_joint3,0,0,(float)Math.toRadians(22.5F));

		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-30F));
		//animator.rotate(right_joint3,0,0,(float)Math.toRadians(-22.5F));

		animator.rotate(right_leg4,0,0,(float)Math.toRadians(-20F));
		animator.rotate(left_leg4,(float)Math.toRadians(-30F),(float)Math.toRadians(27.5F),(float)Math.toRadians(45F));

		animator.rotate(right_tong_leg,(float)Math.toRadians(-25F),0,0);
		//animator.rotate(right_Tong,(float)Math.toRadians(12.5F),(float)Math.toRadians(37.5F),(float)Math.toRadians(-60F));

		animator.rotate(upper_claw2,(float)Math.toRadians(32.5F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-32.5F),0,0);

		animator.rotate(left_tong_leg,0,(float)Math.toRadians(-17.5F),0);
		animator.rotate(left_Tong,(float)Math.toRadians(-37.5F),(float)Math.toRadians(-47.5F),(float)Math.toRadians(-67.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-22.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(root,(float)Math.toRadians(-150F),0,0);
		animator.move(root,0,-26,-9);
		animator.rotate(body,(float)Math.toRadians(-2.5F),0,0);
		animator.rotate(left_eye,0,0,(float)Math.toRadians(55F));
		animator.rotate(right_eye,0,0,(float)Math.toRadians(-62.5F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(27.5F));
		//animator.rotate(left_joint,0,0,0);

		animator.rotate(right_leg,0,0,(float)Math.toRadians(15F));
		//animator.rotate(right_joint,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(15F));
		//animator.rotate(left_joint2,0,0,(float)Math.toRadians(2.5F));

		animator.rotate(right_leg2,0,0,(float)Math.toRadians(-22.5F));
		//animator.rotate(right_joint2,0,0,(float)Math.toRadians(-12.5F));

		animator.rotate(left_leg3,0,0,(float)Math.toRadians(17.5F));
		//animator.rotate(left_joint3,0,0,(float)Math.toRadians(22.5F));

		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-22.5F));
		//animator.rotate(right_joint3,0,0,(float)Math.toRadians(-22.5F));

		animator.rotate(right_leg4,0,(float)Math.toRadians(2.5F),(float)Math.toRadians(-7.5F));
		animator.rotate(left_leg4,(float)Math.toRadians(-22.5F),(float)Math.toRadians(15F),(float)Math.toRadians(35F));

		animator.rotate(right_tong_leg,(float)Math.toRadians(-17.5F),0,0);
		//animator.rotate(right_Tong,(float)Math.toRadians(12.5F),(float)Math.toRadians(37.5F),(float)Math.toRadians(-60F));

		animator.rotate(upper_claw2,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-25F),0,0);

		animator.rotate(left_tong_leg,0,(float)Math.toRadians(-7.5F),0);
		animator.rotate(left_Tong,(float)Math.toRadians(-37.5F),(float)Math.toRadians(-47.5F),(float)Math.toRadians(-67.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-25F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(root,(float)Math.toRadians(-150F),(float)Math.toRadians(2.5F),(float)Math.toRadians(1.25F));
		animator.move(root,0,-25,-9);
		animator.rotate(body,(float)Math.toRadians(-2.5F),0,0);
		animator.rotate(left_eye,0,0,(float)Math.toRadians(55F));
		animator.rotate(right_eye,0,0,(float)Math.toRadians(-62.5F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(62.5F));
		//animator.rotate(left_joint,0,0,0);

		animator.rotate(right_leg,0,0,(float)Math.toRadians(-32.5F));
		//animator.rotate(right_joint,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(47.5F));
		//animator.rotate(left_joint2,0,0,(float)Math.toRadians(2.5F));

		animator.rotate(right_leg2,0,0,(float)Math.toRadians(-42.5F));
		//animator.rotate(right_joint2,0,0,(float)Math.toRadians(-12.5F));

		animator.rotate(left_leg3,0,0,(float)Math.toRadians(42.5F));
		//animator.rotate(left_joint3,0,0,(float)Math.toRadians(22.5F));

		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-37.5F));
		//animator.rotate(right_joint3,0,0,(float)Math.toRadians(-22.5F));

		animator.rotate(right_leg4,0,(float)Math.toRadians(7.5F),(float)Math.toRadians(15F));
		animator.rotate(left_leg4,(float)Math.toRadians(-7.5F),(float)Math.toRadians(-12.5F),(float)Math.toRadians(10F));

		//animator.rotate(right_tong_leg,(float)Math.toRadians(-17.5F),0,0);
		//animator.rotate(right_Tong,(float)Math.toRadians(12.5F),(float)Math.toRadians(37.5F),(float)Math.toRadians(-60F));

		animator.rotate(upper_claw2,(float)Math.toRadians(-10F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-7.5F),0,0);

		animator.rotate(left_tong_leg,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_Tong,(float)Math.toRadians(-37.5F),(float)Math.toRadians(-47.5F),(float)Math.toRadians(-67.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-32.5F),0,0);
		animator.endKeyframe();


		animator.startKeyframe(3);
		animator.rotate(root,(float)Math.toRadians(-150F),(float)Math.toRadians(2.5F),(float)Math.toRadians(1.25F));
		animator.move(root,0,-25,-9);
		//animator.rotate(body,(float)Math.toRadians(-2.5F),0,0);
		animator.rotate(left_eye,0,0,(float)Math.toRadians(55F));
		animator.rotate(right_eye,0,0,(float)Math.toRadians(-62.5F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(62.5F));
		//animator.rotate(left_joint,0,0,0);

		animator.rotate(right_leg,0,0,(float)Math.toRadians(-32.5F));
		//animator.rotate(right_joint,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(47.5F));
		//animator.rotate(left_joint2,0,0,(float)Math.toRadians(2.5F));

		animator.rotate(right_leg2,0,0,(float)Math.toRadians(-42.5F));
		//animator.rotate(right_joint2,0,0,(float)Math.toRadians(-12.5F));

		animator.rotate(left_leg3,0,0,(float)Math.toRadians(42.5F));
		//animator.rotate(left_joint3,0,0,(float)Math.toRadians(22.5F));

		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-37.5F));
		//animator.rotate(right_joint3,0,0,(float)Math.toRadians(-22.5F));

		animator.rotate(right_leg4,0,(float)Math.toRadians(2.5F),(float)Math.toRadians(-7.5F));
		animator.rotate(left_leg4,(float)Math.toRadians(-22.5F),(float)Math.toRadians(15F),(float)Math.toRadians(35F));

		animator.rotate(right_tong_leg,(float)Math.toRadians(-17.5F),0,0);
		//animator.rotate(right_Tong,(float)Math.toRadians(12.5F),(float)Math.toRadians(37.5F),(float)Math.toRadians(-60F));

		animator.rotate(upper_claw2,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-25F),0,0);

		animator.rotate(left_tong_leg,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_Tong,(float)Math.toRadians(-37.5F),(float)Math.toRadians(-47.5F),(float)Math.toRadians(-67.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(root,(float)Math.toRadians(-150F),(float)Math.toRadians(2.5F),(float)Math.toRadians(1.25F));
		animator.move(root,0,-25,-9);
		//animator.rotate(body,(float)Math.toRadians(-2.5F),0,0);
		animator.rotate(left_eye,0,0,(float)Math.toRadians(55F));
		animator.rotate(right_eye,0,0,(float)Math.toRadians(-62.5F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(27.5F));
		//animator.rotate(left_joint,0,0,0);

		animator.rotate(right_leg,0,0,(float)Math.toRadians(15F));
		//animator.rotate(right_joint,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(15F));
		//animator.rotate(left_joint2,0,0,(float)Math.toRadians(2.5F));

		animator.rotate(right_leg2,0,0,(float)Math.toRadians(-22.5F));
		//animator.rotate(right_joint2,0,0,(float)Math.toRadians(-12.5F));

		animator.rotate(left_leg3,0,0,(float)Math.toRadians(17.5F));
		//animator.rotate(left_joint3,0,0,(float)Math.toRadians(22.5F));

		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-22.5F));
		//animator.rotate(right_joint3,0,0,(float)Math.toRadians(-22.5F));

		animator.rotate(right_leg4,0,(float)Math.toRadians(7.5F),(float)Math.toRadians(15F));
		animator.rotate(left_leg4,(float)Math.toRadians(-7.5F),(float)Math.toRadians(-12.5F),(float)Math.toRadians(10F));

		//animator.rotate(right_tong_leg,(float)Math.toRadians(-17.5F),0,0);
		//animator.rotate(right_Tong,(float)Math.toRadians(12.5F),(float)Math.toRadians(37.5F),(float)Math.toRadians(-60F));

		animator.rotate(upper_claw2,(float)Math.toRadians(-10F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-7.5F),0,0);

		animator.rotate(left_tong_leg,0,(float)Math.toRadians(-17.5F),0);
		animator.rotate(left_Tong,(float)Math.toRadians(-37.5F),(float)Math.toRadians(-47.5F),(float)Math.toRadians(-67.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-32.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(root,(float)Math.toRadians(-150F),(float)Math.toRadians(2.5F),(float)Math.toRadians(1.25F));
		animator.move(root,0,-25,-9);
		//animator.rotate(body,(float)Math.toRadians(-2.5F),0,0);
		animator.rotate(left_eye,0,0,(float)Math.toRadians(55F));
		animator.rotate(right_eye,0,0,(float)Math.toRadians(-62.5F));
		animator.rotate(left_leg,0,0,(float)Math.toRadians(50F));
		//animator.rotate(left_joint,0,0,0);

		animator.rotate(right_leg,0,0,(float)Math.toRadians(-2.5F));
		//animator.rotate(right_joint,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(47.5F));
		//animator.rotate(left_joint2,0,0,(float)Math.toRadians(2.5F));

		animator.rotate(right_leg2,0,0,(float)Math.toRadians(-45F));
		//animator.rotate(right_joint2,0,0,(float)Math.toRadians(-12.5F));

		animator.rotate(left_leg3,0,0,(float)Math.toRadians(42.5F));
		//animator.rotate(left_joint3,0,0,(float)Math.toRadians(22.5F));

		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-42.5F));
		//animator.rotate(right_joint3,0,0,(float)Math.toRadians(-22.5F));

		animator.rotate(right_leg4,0,0,(float)Math.toRadians(-20F));
		animator.rotate(left_leg4,(float)Math.toRadians(-30F),(float)Math.toRadians(27.5F),(float)Math.toRadians(45F));

		animator.rotate(right_tong_leg,(float)Math.toRadians(-25F),0,0);
		animator.rotate(right_Tong,(float)Math.toRadians(7.5F),(float)Math.toRadians(57.5F),(float)Math.toRadians(-27.5F));

		animator.rotate(upper_claw2,(float)Math.toRadians(32.5F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-32.5F),0,0);

		animator.rotate(left_tong_leg,0,(float)Math.toRadians(5F),0);
		animator.rotate(left_Tong,(float)Math.toRadians(-37.5F),(float)Math.toRadians(-47.5F),(float)Math.toRadians(-67.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(10F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(15);
		animator.rotate(root,(float)Math.toRadians(-150F),0,0);
		animator.move(root,0,-25,-9);
		animator.rotate(left_eye,0,0,(float)Math.toRadians(55F));
		animator.rotate(right_eye,0,0,(float)Math.toRadians(-62.5F));
		animator.rotate(left_leg,(float)Math.toRadians(-25F),(float)Math.toRadians(-30F),(float)Math.toRadians(-30F));
		animator.rotate(left_joint,0,0,(float)Math.toRadians(-60F));

		animator.rotate(right_leg,(float)Math.toRadians(-25F),(float)Math.toRadians(17.5F),(float)Math.toRadians(35F));
		animator.rotate(right_joint,0,0,(float)Math.toRadians(77.5F));
		animator.rotate(left_leg2,(float)Math.toRadians(-12.5F),0,(float)Math.toRadians(-12.5F));
		animator.rotate(left_joint2,0,0,(float)Math.toRadians(-65F));

		animator.rotate(right_leg2,0,0,(float)Math.toRadians(27.5F));
		animator.rotate(right_joint2,0,0,(float)Math.toRadians(27.5F));

		animator.rotate(left_leg3,(float)Math.toRadians(-22.5F),(float)Math.toRadians(-10F),(float)Math.toRadians(7.5F));
		animator.rotate(left_joint3,0,0,(float)Math.toRadians(-50F));

		animator.rotate(right_leg3,0,(float)Math.toRadians(10F),(float)Math.toRadians(-10F));
		animator.rotate(right_joint3,0,0,(float)Math.toRadians(40F));

		animator.rotate(right_leg4,(float)Math.toRadians(2.5F),(float)Math.toRadians(10F),(float)Math.toRadians(17.5F));
		animator.rotate(left_leg4,(float)Math.toRadians(2.5F),(float)Math.toRadians(-17.5F),(float)Math.toRadians(-2.5F));

		animator.rotate(right_tong_leg,(float)Math.toRadians(-80F),(float)Math.toRadians(2.5F),(float)Math.toRadians(2.5F));
		animator.rotate(right_Tong,(float)Math.toRadians(17.5F),(float)Math.toRadians(112.5F),(float)Math.toRadians(-55F));

		animator.rotate(upper_claw2,(float)Math.toRadians(32.5F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-32.5F),0,0);

		animator.rotate(left_tong_leg,(float)Math.toRadians(2.5F),(float)Math.toRadians(-32.5F),(float)Math.toRadians(-72.5F));
		animator.rotate(left_Tong,(float)Math.toRadians(-30F),(float)Math.toRadians(-47.5F),(float)Math.toRadians(-67.5F));

		animator.rotate(upper_claw,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(7.5F),(float)Math.toRadians(12.5F),(float)Math.toRadians(-15F));
		animator.endKeyframe();


		animator.setStaticKeyframe(80);



		animator.setAnimation(Amethyst_Crab_Entity.CRAB_BURROW);
		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(5F),0,0);
		animator.move(root,-2,4,0);
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-2.5F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(12.5F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(10F),0,(float)Math.toRadians(-12.5F));
		animator.rotate(upper_claw,(float)Math.toRadians(17.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(10F),0,0);
		animator.move(root,1.5F,7.5F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(2.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(2.5F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-5F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(12.5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(22.5F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(20F),0,(float)Math.toRadians(-25F));
		animator.rotate(upper_claw,(float)Math.toRadians(32.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(15F),0,0);
		animator.move(root,-2F,9F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(2.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(5F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-7.5F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(35F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(30F),(float)Math.toRadians(2.5F),(float)Math.toRadians(-37.5F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(20F),0,0);
		animator.move(root,1.5F,12.5F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(5F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-7.5F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(35F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(30F),(float)Math.toRadians(2.5F),(float)Math.toRadians(-37.5F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(25F),0,0);
		animator.move(root,-2F,17.5F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(7.5F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-10F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(35F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(30F),(float)Math.toRadians(2.5F),(float)Math.toRadians(-35F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),0,0);
		animator.move(root,0,23F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(7.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(7.5F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-12.5F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(17.5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(32.5F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(27.5F),(float)Math.toRadians(2.5F),(float)Math.toRadians(-35F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(root,(float)Math.toRadians(30F),0,0);
		animator.move(root,0,23F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(27.5F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(7.5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(12.5F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(10F),0,(float)Math.toRadians(-12.5F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(30);

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),0,0);
		animator.move(root,0,23F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(7.5F),0,(float)Math.toRadians(-10F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),(float)Math.toRadians(2.5F),(float)Math.toRadians(1.25F));
		animator.move(root,0,23F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(7.5F),0,(float)Math.toRadians(-10F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),(float)Math.toRadians(-2.5F),(float)Math.toRadians(-1.25F));
		animator.move(root,0,22.5F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(7.5F),0,(float)Math.toRadians(-10F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),(float)Math.toRadians(2.5F),(float)Math.toRadians(1.25F));
		animator.move(root,0,22F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(7.5F),0,(float)Math.toRadians(-10F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),(float)Math.toRadians(-2.5F),(float)Math.toRadians(-1.25F));
		animator.move(root,0,21.5F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(7.5F),0,(float)Math.toRadians(-10F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),(float)Math.toRadians(2.5F),(float)Math.toRadians(1.25F));
		animator.move(root,0,21F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(7.5F),0,(float)Math.toRadians(-10F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),(float)Math.toRadians(-2.5F),(float)Math.toRadians(-1.25F));
		animator.move(root,0,20.5F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(7.5F),0,(float)Math.toRadians(-10F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),(float)Math.toRadians(2.5F),(float)Math.toRadians(1.25F));
		animator.move(root,0,20F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(7.5F),0,(float)Math.toRadians(-10F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),(float)Math.toRadians(-2.5F),(float)Math.toRadians(-1.25F));
		animator.move(root,0,19.5F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(7.5F),0,(float)Math.toRadians(-10F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),(float)Math.toRadians(2.5F),(float)Math.toRadians(1.25F));
		animator.move(root,0,19F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(7.5F),0,(float)Math.toRadians(-10F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),(float)Math.toRadians(-2.5F),(float)Math.toRadians(-1.25F));
		animator.move(root,0,18.5F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(7.5F),0,(float)Math.toRadians(-10F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),(float)Math.toRadians(2.5F),(float)Math.toRadians(1.25F));
		animator.move(root,0,18F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(7.5F),0,(float)Math.toRadians(-10F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(1);
		animator.rotate(root,(float)Math.toRadians(30F),0,0);
		animator.move(root,0,17.5F,0);
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(30F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-35F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(10F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(7.5F),0,(float)Math.toRadians(-10F));
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(root,(float)Math.toRadians(5F),0,(float)Math.toRadians(1.5F));
		animator.move(root,0,-30F,0);
		animator.rotate(left_leg,0,0,(float)Math.toRadians(32.5F));
		animator.rotate(left_joint,0,0,(float)Math.toRadians(-40F));
		animator.rotate(right_leg,0,0,(float)Math.toRadians(35F));
		animator.rotate(left_leg2,0,0,(float)Math.toRadians(2.5F));
		animator.rotate(right_leg2,0,0,(float)Math.toRadians(-7.5F));
		animator.rotate(left_leg3,0,0,(float)Math.toRadians(-20F));
		animator.rotate(right_leg3,0,0,(float)Math.toRadians(-42.5F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(-47.5F),0,0);
		animator.rotate(right_Tong,0,(float)Math.toRadians(32.5F),0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(55F),0,0);
		animator.rotate(left_Tong,(float)Math.toRadians(37.5F),0,0);
		animator.rotate(upper_claw,(float)Math.toRadians(50F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();


		animator.resetKeyframe(10);



		animator.setAnimation(Amethyst_Crab_Entity.CRAB_BITE);
		animator.startKeyframe(12);
		animator.rotate(root,(float)Math.toRadians(7.5F),(float)Math.toRadians(-25F),0);
		animator.rotate(body,(float)Math.toRadians(15F),0,(float)Math.toRadians(7.5F));
		animator.rotate(left_eye,0,0,(float)Math.toRadians(-10F));
		animator.rotate(right_eye,0,0,(float)Math.toRadians(-15F));
		animator.rotate(left_leg,(float)Math.toRadians(12.5F),(float)Math.toRadians(-27.5F),(float)Math.toRadians(2.5F));
		animator.rotate(left_joint,0,0,(float)Math.toRadians(-25F));
		animator.rotate(right_leg,(float)Math.toRadians(-17.5F),(float)Math.toRadians(5F),(float)Math.toRadians(27.5F));
		animator.rotate(right_joint,0,0,(float)Math.toRadians(17.5F));
		animator.rotate(left_leg2,(float)Math.toRadians(7.5F),(float)Math.toRadians(-12.5F),(float)Math.toRadians(-15F));
		animator.rotate(left_joint2,0,0,(float)Math.toRadians(-2.5F));
		animator.rotate(right_leg2,(float)Math.toRadians(-2.5F),(float)Math.toRadians(-7.5F),(float)Math.toRadians(-12.5F));
		animator.rotate(right_joint2,0,0,(float)Math.toRadians(22.5F));
		animator.rotate(left_leg3,(float)Math.toRadians(20F),(float)Math.toRadians(-12.5F),(float)Math.toRadians(-27.5F));
		//animator.rotate(left_joint3,0,0,(float)Math.toRadians(-5F));
		animator.rotate(right_leg3,(float)Math.toRadians(-2.5F),(float)Math.toRadians(-15F),(float)Math.toRadians(-7.5F));
		animator.rotate(right_joint3,0,0,(float)Math.toRadians(-17.5F));
		animator.rotate(left_leg4,(float)Math.toRadians(-22.5F),(float)Math.toRadians(-17.5F),(float)Math.toRadians(25F));
		animator.rotate(right_leg4,(float)Math.toRadians(-10F),(float)Math.toRadians(10F),(float)Math.toRadians(-12.5F));
		animator.rotate(right_tong_leg,(float)Math.toRadians(7.5F),(float)Math.toRadians(-52.5F),(float)Math.toRadians(-27.5F));
		animator.rotate(right_Tong,(float)Math.toRadians(-2.5F),(float)Math.toRadians(2.5F),(float)Math.toRadians(5F));
		animator.rotate(upper_claw2,(float)Math.toRadians(45F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-17.5F),0,0);
		animator.rotate(left_tong_leg,(float)Math.toRadians(-52.5F),(float)Math.toRadians(-40F),(float)Math.toRadians(27.5F));
		animator.rotate(left_Tong,0,(float)Math.toRadians(12.5F),0);
		//animator.rotate(upper_claw,0,0,0);
		animator.rotate(under_claw,(float)Math.toRadians(7.5F),0,0);
		animator.rotate(left_body,0,(float)Math.toRadians(-5F),0);
		animator.rotate(right_body,0,(float)Math.toRadians(-7.5F),0);
		animator.endKeyframe();

		animator.setStaticKeyframe(3);

		animator.startKeyframe(3);
		animator.rotate(root,(float)Math.toRadians(5F),(float)Math.toRadians(32.5F),(float)Math.toRadians(-5F));
		animator.rotate(body,0,(float)Math.toRadians(5F),(float)Math.toRadians(2.5F));
		animator.rotate(left_eye,0,(float)Math.toRadians(5F),(float)Math.toRadians(17.5F));
		animator.rotate(right_eye,0,0,(float)Math.toRadians(12.5F));
		animator.rotate(left_leg,(float)Math.toRadians(-17.5F),(float)Math.toRadians(20F),(float)Math.toRadians(-37.5F));
		animator.rotate(left_joint,0,0,(float)Math.toRadians(-20F));
		animator.rotate(right_leg,(float)Math.toRadians(-2.5F),(float)Math.toRadians(-17.5F),(float)Math.toRadians(7.5F));
		animator.rotate(right_joint,0,0,(float)Math.toRadians(32.5F));
		animator.rotate(left_leg2,(float)Math.toRadians(2.5F),(float)Math.toRadians(17.5F),(float)Math.toRadians(2.5F));
		animator.rotate(left_joint2,0,0,(float)Math.toRadians(7.5F));
		animator.rotate(right_leg2,(float)Math.toRadians(-2.5F),(float)Math.toRadians(-20F),(float)Math.toRadians(2.5F));
		animator.rotate(right_joint2,0,0,(float)Math.toRadians(7.5F));
		animator.rotate(left_leg3,(float)Math.toRadians(2.5F),(float)Math.toRadians(7.5F),(float)Math.toRadians(-15F));
		animator.rotate(left_joint3,0,0,(float)Math.toRadians(35F));
		animator.rotate(right_leg3,(float)Math.toRadians(-7.5F),(float)Math.toRadians(5F),(float)Math.toRadians(7.5F));
		animator.rotate(right_joint3,0,0,(float)Math.toRadians(5F));
		animator.rotate(left_leg4,(float)Math.toRadians(-36.5F),(float)Math.toRadians(-17.5F),(float)Math.toRadians(37.5F));
		animator.rotate(right_leg4,0,(float)Math.toRadians(7.5F),0);
		animator.rotate(right_tong_leg,(float)Math.toRadians(7.5F),(float)Math.toRadians(-5F),(float)Math.toRadians(-2.5F));
		animator.rotate(right_Tong,(float)Math.toRadians(-2.5F),(float)Math.toRadians(35F),(float)Math.toRadians(7.5F));
		animator.rotate(upper_claw2,(float)Math.toRadians(30F),0,0);
		animator.rotate(under_claw2,(float)Math.toRadians(-27.5F),0,0);
		animator.rotate(left_tong_leg,0,(float)Math.toRadians(50F),(float)Math.toRadians(22.5F));
		animator.rotate(left_Tong,(float)Math.toRadians(50F),(float)Math.toRadians(-12.5F),(float)Math.toRadians(72.5F));
		animator.rotate(upper_claw,(float)Math.toRadians(32.5F),0,0);
		animator.rotate(under_claw,(float)Math.toRadians(-35F),0,0);
		animator.rotate(left_body,0,(float)Math.toRadians(5F),0);
		animator.rotate(right_body,0,(float)Math.toRadians(2.5F),0);
		animator.endKeyframe();

		animator.setStaticKeyframe(15);

		animator.resetKeyframe(15);

	}

	@Override
	public void setupAnim(Amethyst_Crab_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	//	faceTarget(netHeadYaw, headPitch, 1, root);
		float globalSpeed = 0.35f;
		float Speed = 0.1f;
		float globalDegree = 0.5f;
		float Degree = 0.1f;

		this.bob(body, globalSpeed * 0.2F, globalDegree, false, ageInTicks, 1.0f);
		this.bob(body, globalSpeed, globalDegree * 1.6f, false, limbSwing, limbSwingAmount);

		this.flap(body, globalSpeed, globalDegree * 0.2F, false, 0F, 0F, limbSwing, limbSwingAmount);

		swing(right_tong_leg, Speed * 3, Degree, false, 0, 0f, limbSwing, limbSwingAmount);
		swing(left_tong_leg, Speed * 3, Degree, false, 0, 0f, limbSwing, limbSwingAmount);

		swing(right_Tong, Speed * 3, globalDegree, true, 0, 0.5f, limbSwing, limbSwingAmount);
		swing(left_Tong, Speed * 3, Degree * 0.5F, false, 0, 0.05f, limbSwing, limbSwingAmount);

		walk(upper_claw, globalSpeed * 0.1F, Degree * 2, false, 0, 0.1f, ageInTicks, 1.0f);
		walk(under_claw, globalSpeed * 0.1F, Degree  * 2, true, 0, 0.1f, ageInTicks, 1.0f);

		walk(upper_claw2, globalSpeed * 0.1F, Degree * 2, false, 0, 0.1f, ageInTicks, 1.0f);
		walk(under_claw2, globalSpeed * 0.1F, Degree  * 2, true, 0, 0.1f, ageInTicks, 1.0f);
		//flap(left_leg, globalSpeed , globalDegree * 0.5f, false, 0, -0.25f, limbSwing, limbSwingAmount);

		flap(left_eye, Speed, globalDegree * 0.4f, false, 0, -0.1f, ageInTicks, 1.0f);
		flap(right_eye, Speed, globalDegree * 0.4f, true, 0, -0.1f, ageInTicks, 1.0f);

		swing(left_leg, globalSpeed, globalDegree * 1.6f, false, 0, 0.1f, limbSwing, limbSwingAmount);
		flap(left_leg, globalSpeed , globalDegree * 0.6f, false, 0, -0.25f, limbSwing, limbSwingAmount);

		swing(left_leg2, globalSpeed, globalDegree * 1.6f, false, 0 + 1.57f, 0.1f, limbSwing, limbSwingAmount);
		flap(left_leg2, globalSpeed, globalDegree * 0.6f, false, 0 + 1.57f, -0.25f, limbSwing, limbSwingAmount);

		swing(left_leg3, globalSpeed, globalDegree * 1.6f, false, 0 + 1.57f*2, 0.1f, limbSwing, limbSwingAmount);
		flap(left_leg3, globalSpeed, globalDegree * 0.6f, false, 0 + 1.57f*2, -0.25f, limbSwing, limbSwingAmount);

		swing(left_leg4, globalSpeed, globalDegree * 1.6f, false, 0 + 1.57f*3, 0.1f, limbSwing, limbSwingAmount);

		swing(right_leg, globalSpeed, globalDegree * 1.6f, false, 0, -0.1f, limbSwing, limbSwingAmount);
		flap(right_leg, globalSpeed, globalDegree * 0.6f, false, 0, 0.25f, limbSwing, limbSwingAmount);

		swing(right_leg2, globalSpeed, globalDegree * 1.6f, false, 0 + 1.57f, -0.1f, limbSwing, limbSwingAmount);
		flap(right_leg2, globalSpeed, globalDegree * 0.6f, false, 0 + 1.57f, 0.25f, limbSwing, limbSwingAmount);

		swing(right_leg3, globalSpeed, globalDegree * 1.6f, false, 0 + 1.57f*2, -0.1f, limbSwing, limbSwingAmount);
		flap(right_leg3, globalSpeed, globalDegree * 0.6f, false, 0 + 1.57f*2, 0.25f, limbSwing, limbSwingAmount);

		swing(right_leg4, globalSpeed, globalDegree * 1.6f, false, 0 + 1.57f*3, -0.1f, limbSwing, limbSwingAmount);



	}

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}