package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Maledictus_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Model_Maledictus extends AdvancedEntityModel<Maledictus_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox berserker;
	private final AdvancedModelBox legs;
	private final AdvancedModelBox right_leg;
	private final AdvancedModelBox cube_r1;
	private final AdvancedModelBox right_front_leg;
	private final AdvancedModelBox cube_r2;
	private final AdvancedModelBox left_leg;
	private final AdvancedModelBox cube_r3;
	private final AdvancedModelBox left_front_leg;
	private final AdvancedModelBox cube_r4;
	private final AdvancedModelBox pelvis;
	private final AdvancedModelBox front_cloth1;
	private final AdvancedModelBox front_cloth2;
	private final AdvancedModelBox body;
	private final AdvancedModelBox right_shoulder;
	private final AdvancedModelBox cube_r5;
	private final AdvancedModelBox cube_r6;
	private final AdvancedModelBox right_arm;
	private final AdvancedModelBox right_front_arm;
	private final AdvancedModelBox bow;
	private final AdvancedModelBox cube_r7;
	private final AdvancedModelBox cube_r8;
	private final AdvancedModelBox cube_r9;
	private final AdvancedModelBox bow_string;
	private final AdvancedModelBox string1;
	private final AdvancedModelBox string2;
	private final AdvancedModelBox right_mace;
	private final AdvancedModelBox cube_r10;
	private final AdvancedModelBox cube_r11;
	private final AdvancedModelBox cube_r12;
	private final AdvancedModelBox halberd;
	private final AdvancedModelBox cube_r13;
	private final AdvancedModelBox halberd2;
	private final AdvancedModelBox cube_r14;
	private final AdvancedModelBox cube_r15;
	public final AdvancedModelBox right_particle;
	private final AdvancedModelBox left_shoulder;
	private final AdvancedModelBox cube_r16;
	private final AdvancedModelBox cube_r17;
	private final AdvancedModelBox left_arm;
	private final AdvancedModelBox left_front_arm;
	private final AdvancedModelBox left_mace;
	private final AdvancedModelBox cube_r18;
	private final AdvancedModelBox cube_r19;
	private final AdvancedModelBox cube_r20;
	public final AdvancedModelBox left_particle;
	private final AdvancedModelBox head;
	private final AdvancedModelBox right_horn;
	private final AdvancedModelBox cube_r21;
	private final AdvancedModelBox left_horn;
	private final AdvancedModelBox cube_r22;
	private final AdvancedModelBox left_wing;
	private final AdvancedModelBox left_wing2;
	private final AdvancedModelBox right_wing;
	private final AdvancedModelBox right_wing2;

	public Model_Maledictus() {
		texWidth = 256;
		texHeight = 256;

		root = new AdvancedModelBox(this,"root");
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		berserker = new AdvancedModelBox(this,"berserker");
		berserker.setRotationPoint(0.0F, -24.0F, -3.0F);
		root.addChild(berserker);


		legs = new AdvancedModelBox(this,"legs");
		legs.setRotationPoint(0.0F, 1.0F, 0.0F);
		berserker.addChild(legs);


		right_leg = new AdvancedModelBox(this,"right_leg");
		right_leg.setRotationPoint(-2.0F, 0.0F, 0.0F);
		legs.addChild(right_leg);
		setRotationAngle(right_leg, 0.0097F, 0.218F, 0.0447F);
		right_leg.setTextureOffset(55, 0).addBox(-4.0F, -0.0428F, -1.3474F, 6.0F, 12.0F, 5.0F, 0.0F, false);

		cube_r1 = new AdvancedModelBox(this);
		cube_r1.setRotationPoint(0.5557F, 14.9936F, -0.8474F);
		right_leg.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.1309F);
		cube_r1.setTextureOffset(146, 0).addBox(-8.0F, -16.0F, -1.5F, 6.0F, 11.0F, 7.0F, 0.0F, false);

		right_front_leg = new AdvancedModelBox(this,"right_front_leg");
		right_front_leg.setRotationPoint(0.0F, 9.9572F, 0.6526F);
		right_leg.addChild(right_front_leg);
		right_front_leg.setTextureOffset(0, 112).addBox(-4.1F, 0.9829F, -1.2611F, 5.0F, 12.0F, 5.0F, 0.0F, false);

		cube_r2 = new AdvancedModelBox(this);
		cube_r2.setRotationPoint(0.0F, -1.0171F, -2.2611F);
		right_front_leg.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.5672F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(157, 157).addBox(-4.5F, 1.0F, -3.0F, 6.0F, 9.0F, 5.0F, 0.0F, false);

		left_leg = new AdvancedModelBox(this,"left_leg");
		left_leg.setRotationPoint(2.0F, 0.0F, 0.0F);
		legs.addChild(left_leg);
		setRotationAngle(left_leg, 0.0097F, -0.218F, -0.0447F);
		left_leg.setTextureOffset(0, 0).addBox(-2.0F, -0.0428F, -1.3474F, 6.0F, 12.0F, 5.0F, 0.0F, false);

		cube_r3 = new AdvancedModelBox(this);
		cube_r3.setRotationPoint(-0.5557F, 14.9936F, -0.8474F);
		left_leg.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.1309F);
		cube_r3.setTextureOffset(22, 29).addBox(2.0F, -16.0F, -1.5F, 6.0F, 11.0F, 7.0F, 0.0F, false);

		left_front_leg = new AdvancedModelBox(this,"left_front_leg");
		left_front_leg.setRotationPoint(0.0F, 9.9572F, 0.6526F);
		left_leg.addChild(left_front_leg);
		left_front_leg.setTextureOffset(81, 0).addBox(-0.9F, 0.9829F, -1.2611F, 5.0F, 12.0F, 5.0F, 0.0F, false);

		cube_r4 = new AdvancedModelBox(this);
		cube_r4.setRotationPoint(0.0F, -1.0171F, -2.2611F);
		left_front_leg.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.5672F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(152, 22).addBox(-1.5F, 1.0F, -3.0F, 6.0F, 9.0F, 5.0F, 0.0F, false);

		pelvis = new AdvancedModelBox(this,"pelvis");
		pelvis.setRotationPoint(0.0F, 2.0F, 0.0F);
		berserker.addChild(pelvis);
		pelvis.setTextureOffset(116, 112).addBox(-6.0F, -3.0F, -2.0F, 12.0F, 3.0F, 6.0F, 0.0F, false);

		front_cloth1 = new AdvancedModelBox(this,"front_cloth1");
		front_cloth1.setRotationPoint(0.0F, -2.0F, -1.6F);
		pelvis.addChild(front_cloth1);
		setRotationAngle(front_cloth1, -0.1309F, 0.0F, 0.0F);
		front_cloth1.setTextureOffset(109, 23).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 9.0F, 0.0F, 0.0F, false);

		front_cloth2 = new AdvancedModelBox(this,"front_cloth2");
		front_cloth2.setRotationPoint(0.0F, 9.0F, 0.0F);
		front_cloth1.addChild(front_cloth2);
		setRotationAngle(front_cloth2, 0.2618F, 0.0F, 0.0F);
		front_cloth2.setTextureOffset(109, 33).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 8.0F, 0.0F, 0.0F, false);

		body = new AdvancedModelBox(this,"body");
		body.setRotationPoint(0.0F, 1.6F, 3.6F);
		pelvis.addChild(body);
		body.setTextureOffset(67, 142).addBox(-5.5F, -15.6F, -6.6743F, 11.0F, 13.0F, 7.0F, 0.0F, false);

		right_shoulder = new AdvancedModelBox(this,"right_shoulder");
		right_shoulder.setRotationPoint(-4.7084F, -16.0F, -1.0743F);
		body.addChild(right_shoulder);
		setRotationAngle(right_shoulder, 0.132F, 0.1298F, 0.1917F);


		cube_r5 = new AdvancedModelBox(this);
		cube_r5.setRotationPoint(5.774F, 6.2586F, -4.9014F);
		right_shoulder.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -1.2217F);
		cube_r5.setTextureOffset(0, 138).addBox(-8.0F, -15.0F, 0.0F, 11.0F, 6.0F, 6.0F, 0.0F, false);

		cube_r6 = new AdvancedModelBox(this);
		cube_r6.setRotationPoint(5.774F, 11.2586F, -4.9014F);
		right_shoulder.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, 0.1309F);
		cube_r6.setTextureOffset(104, 147).addBox(-16.0F, -12.0F, 0.0F, 10.0F, 4.0F, 6.0F, 0.5F, false);

		right_arm = new AdvancedModelBox(this,"right_arm");
		right_arm.setRotationPoint(-4.326F, 2.2586F, -1.9014F);
		right_shoulder.addChild(right_arm);
		right_arm.setTextureOffset(46, 158).addBox(-3.0F, -3.0F, -2.5F, 5.0F, 10.0F, 5.0F, 0.0F, false);

		right_front_arm = new AdvancedModelBox(this,"right_front_arm");
		right_front_arm.setRotationPoint(-0.025F, 7.0F, 1.0F);
		right_arm.addChild(right_front_arm);
		setRotationAngle(right_front_arm, -0.3054F, 0.0F, 0.0F);
		right_front_arm.setTextureOffset(160, 139).addBox(-3.0F, 0.0F, -3.5F, 5.0F, 10.0F, 5.0F, 0.0F, false);
		right_front_arm.setTextureOffset(99, 158).addBox(-4.0F, -3.0F, -3.5F, 5.0F, 10.0F, 5.0F, 0.1F, false);
		right_front_arm.setTextureOffset(120, 158).addBox(-3.0F, 0.0F, -3.5F, 5.0F, 10.0F, 5.0F, 0.0F, true);

		bow = new AdvancedModelBox(this,"bow");
		bow.setRotationPoint(-0.9401F, 9.0F, 0.0F);
		right_front_arm.addChild(bow);
		bow.setTextureOffset(0, 112).addBox(-1.0F, -1.0F, -11.945F, 2.0F, 3.0F, 22.0F, 0.0F, false);
		bow.setTextureOffset(24, 0).addBox(0.0F, 2.0F, -6.945F, 0.0F, 8.0F, 12.0F, 0.0F, false);

		cube_r7 = new AdvancedModelBox(this);
		cube_r7.setRotationPoint(0.0F, 1.0F, 5.0065F);
		bow.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.5672F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(49, 112).addBox(-2.5F, 6.0F, -25.0F, 5.0F, 4.0F, 18.0F, 0.0F, false);

		cube_r8 = new AdvancedModelBox(this);
		cube_r8.setRotationPoint(-0.5F, 0.7688F, 2.6724F);
		bow.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.5672F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(0, 0).addBox(0.5F, 3.0F, -29.9F, 0.0F, 5.0F, 23.0F, 0.0F, false);

		cube_r9 = new AdvancedModelBox(this);
		cube_r9.setRotationPoint(0.0F, 1.0F, -6.945F);
		bow.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.5672F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(105, 23).addBox(0.0F, 4.0F, 9.0F, 0.0F, 5.0F, 23.0F, 0.0F, false);
		cube_r9.setTextureOffset(117, 124).addBox(-1.5F, 6.0F, 7.0F, 3.0F, 4.0F, 18.0F, 0.0F, false);

		bow_string = new AdvancedModelBox(this,"bow_string");
		bow_string.setRotationPoint(0.5F, -9.5F, 0.0F);
		bow.addChild(bow_string);


		string1 = new AdvancedModelBox(this,"string1");
		string1.setRotationPoint(0.0F, 0.0F, -1.0F);
		bow_string.addChild(string1);
		string1.setTextureOffset(87, 23).addBox(-1.001F, -0.1325F, -0.0242F, 1.0F, 0.0F, 19.0F, 0.0F, false);

		string2 = new AdvancedModelBox(this,"string2");
		string2.setRotationPoint(-1.0F, 0.0F, -1.0485F);
		bow_string.addChild(string2);
		string2.setTextureOffset(0, 29).addBox(-0.001F, -0.1325F, -18.9758F, 1.0F, 0.0F, 19.0F, 0.0F, false);

		right_mace = new AdvancedModelBox(this,"right_mace");
		right_mace.setRotationPoint(-1.0F, 8.0F, -1.0F);
		right_front_arm.addChild(right_mace);
		right_mace.setTextureOffset(122, 0).addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 19.0F, 0.0F, true);
		right_mace.setTextureOffset(129, 22).addBox(-1.5F, -1.5F, -27.0F, 3.0F, 3.0F, 16.0F, 0.0F, true);
		right_mace.setTextureOffset(81, 0).addBox(0.5188F, 0.001F, -35.0F, 9.0F, 0.0F, 22.0F, 0.0F, true);
		right_mace.setTextureOffset(81, 0).addBox(0.5188F, 0.001F, -35.0F, 9.0F, 0.0F, 22.0F, 0.0F, true);

		cube_r10 = new AdvancedModelBox(this);
		cube_r10.setRotationPoint(-0.0062F, 0.001F, -20.0F);
		right_mace.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, 1.5708F);
		cube_r10.setTextureOffset(81, 0).addBox(0.525F, 0.0F, -15.0F, 9.0F, 0.0F, 22.0F, 0.0F, true);

		cube_r11 = new AdvancedModelBox(this);
		cube_r11.setRotationPoint(-0.0062F, 0.001F, -20.0F);
		right_mace.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, 3.1416F);
		cube_r11.setTextureOffset(81, 0).addBox(0.525F, 0.0F, -15.0F, 9.0F, 0.0F, 22.0F, 0.0F, true);

		cube_r12 = new AdvancedModelBox(this);
		cube_r12.setRotationPoint(-0.0062F, 0.001F, -20.0F);
		right_mace.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, -1.5708F);
		cube_r12.setTextureOffset(81, 0).addBox(0.525F, 0.0F, -15.0F, 9.0F, 0.0F, 22.0F, 0.0F, true);

		halberd = new AdvancedModelBox(this,"halberd");
		halberd.setRotationPoint(-0.3911F, 8.2083F, -0.6667F);
		right_front_arm.addChild(halberd);
		halberd.setTextureOffset(0, 0).addBox(-0.9901F, -1.2083F, -32.3333F, 2.0F, 2.0F, 50.0F, 0.0F, false);
		halberd.setTextureOffset(37, 0).addBox(-0.4901F, -0.7083F, -37.3333F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		halberd.setTextureOffset(32, 135).addBox(0.0099F, -2.7083F, -53.3333F, 0.0F, 5.0F, 17.0F, 0.0F, false);
		halberd.setTextureOffset(142, 112).addBox(-1.4901F, -1.7083F, -31.3333F, 3.0F, 3.0F, 12.0F, 0.0F, false);
		halberd.setTextureOffset(18, 0).addBox(2.0099F, -0.7083F, -16.8333F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		halberd.setTextureOffset(9, 18).addBox(-0.4901F, -4.2083F, -16.8333F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		halberd.setTextureOffset(84, 43).addBox(-1.9901F, -2.2083F, -17.3333F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		halberd.setTextureOffset(18, 2).addBox(-0.4901F, 1.7917F, -16.8333F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		halberd.setTextureOffset(18, 0).addBox(-4.1089F, -0.7083F, -16.8333F, 2.0F, 1.0F, 0.0F, 0.0F, true);
		halberd.setTextureOffset(55, 0).addBox(0.0099F, 1.2917F, -37.3333F, 0.0F, 15.0F, 25.0F, 0.0F, false);
		halberd.setTextureOffset(96, 112).addBox(0.0099F, -11.7083F, -33.3333F, 0.0F, 10.0F, 19.0F, 0.0F, false);

		cube_r13 = new AdvancedModelBox(this);
		cube_r13.setRotationPoint(0.0099F, -0.2083F, -42.8333F);
		halberd.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, -1.5708F);
		cube_r13.setTextureOffset(32, 135).addBox(0.0F, -2.5F, -8.5F, 0.0F, 5.0F, 17.0F, 0.0F, false);

		halberd2 = new AdvancedModelBox(this,"halberd2");
		halberd2.setRotationPoint(-0.0139F, -0.2083F, -33.8333F);
		halberd.addChild(halberd2);
		setRotationAngle(halberd2, 0.0F, 0.0F, -0.7854F);
		halberd2.setTextureOffset(0, 2).addBox(1.5238F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		halberd2.setTextureOffset(0, 18).addBox(-1.4762F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		halberd2.setTextureOffset(0, 2).addBox(-3.595F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, true);

		cube_r14 = new AdvancedModelBox(this);
		cube_r14.setRotationPoint(0.0238F, 5.0F, 0.0F);
		halberd2.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, -1.5708F);
		cube_r14.setTextureOffset(0, 0).addBox(1.5F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r15 = new AdvancedModelBox(this);
		cube_r15.setRotationPoint(0.0238F, 0.0F, 0.0F);
		halberd2.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, -1.5708F);
		cube_r15.setTextureOffset(0, 2).addBox(1.5F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		right_particle = new AdvancedModelBox(this,"right_particle");
		right_particle.setRotationPoint(-0.8812F, 5.0F, -1.0F);
		right_front_arm.addChild(right_particle);


		left_shoulder = new AdvancedModelBox(this,"left_shoulder");
		left_shoulder.setRotationPoint(4.7084F, -16.0F, -2.0743F);
		body.addChild(left_shoulder);
		setRotationAngle(left_shoulder, 0.132F, -0.1298F, -0.1917F);


		cube_r16 = new AdvancedModelBox(this);
		cube_r16.setRotationPoint(-5.774F, 6.2586F, -3.9014F);
		left_shoulder.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.0F, 1.2217F);
		cube_r16.setTextureOffset(0, 138).addBox(-3.0F, -15.0F, 0.0F, 11.0F, 6.0F, 6.0F, 0.0F, true);

		cube_r17 = new AdvancedModelBox(this);
		cube_r17.setRotationPoint(-5.774F, 11.2586F, -3.9014F);
		left_shoulder.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, -0.1309F);
		cube_r17.setTextureOffset(142, 128).addBox(6.0F, -12.0F, 0.0F, 10.0F, 4.0F, 6.0F, 0.5F, false);

		left_arm = new AdvancedModelBox(this,"left_arm");
		left_arm.setRotationPoint(4.326F, 2.2586F, -0.9014F);
		left_shoulder.addChild(left_arm);
		left_arm.setTextureOffset(25, 158).addBox(-2.0F, -3.0F, -2.5F, 5.0F, 10.0F, 5.0F, 0.0F, false);

		left_front_arm = new AdvancedModelBox(this,"left_front_arm");
		left_front_arm.setRotationPoint(0.025F, 7.0F, 1.0F);
		left_arm.addChild(left_front_arm);
		setRotationAngle(left_front_arm, -0.3054F, 0.0F, 0.0F);
		left_front_arm.setTextureOffset(120, 158).addBox(-2.0F, 0.0F, -3.5F, 5.0F, 10.0F, 5.0F, 0.0F, false);
		left_front_arm.setTextureOffset(99, 158).addBox(-1.0F, -3.0F, -3.5F, 5.0F, 10.0F, 5.0F, 0.1F, true);

		left_mace = new AdvancedModelBox(this,"left_mace");
		left_mace.setRotationPoint(1.0F, 8.0F, -1.0F);
		left_front_arm.addChild(left_mace);
		left_mace.setTextureOffset(122, 0).addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 19.0F, 0.0F, false);
		left_mace.setTextureOffset(129, 22).addBox(-1.5F, -1.5F, -27.0F, 3.0F, 3.0F, 16.0F, 0.0F, false);
		left_mace.setTextureOffset(81, 0).addBox(-9.5188F, 0.001F, -35.0F, 9.0F, 0.0F, 22.0F, 0.0F, false);
		left_mace.setTextureOffset(81, 0).addBox(-9.5188F, 0.001F, -35.0F, 9.0F, 0.0F, 22.0F, 0.0F, false);

		cube_r18 = new AdvancedModelBox(this);
		cube_r18.setRotationPoint(0.0062F, 0.001F, -20.0F);
		left_mace.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.0F, -1.5708F);
		cube_r18.setTextureOffset(81, 0).addBox(-9.525F, 0.0F, -15.0F, 9.0F, 0.0F, 22.0F, 0.0F, false);

		cube_r19 = new AdvancedModelBox(this);
		cube_r19.setRotationPoint(0.0062F, 0.001F, -20.0F);
		left_mace.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 0.0F, -3.1416F);
		cube_r19.setTextureOffset(81, 0).addBox(-9.525F, 0.0F, -15.0F, 9.0F, 0.0F, 22.0F, 0.0F, false);

		cube_r20 = new AdvancedModelBox(this);
		cube_r20.setRotationPoint(0.0062F, 0.001F, -20.0F);
		left_mace.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 0.0F, 1.5708F);
		cube_r20.setTextureOffset(81, 0).addBox(-9.525F, 0.0F, -15.0F, 9.0F, 0.0F, 22.0F, 0.0F, false);

		left_particle = new AdvancedModelBox(this,"left_particle");
		left_particle.setRotationPoint(0.5F, 5.0F, -1.0F);
		left_front_arm.addChild(left_particle);


		head = new AdvancedModelBox(this,"head");
		head.setRotationPoint(0.0F, -16.6F, -4.0F);
		body.addChild(head);
		setRotationAngle(head, 0.1309F, 0.0F, 0.0F);
		head.setTextureOffset(78, 112).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(27, 112).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);
		head.setTextureOffset(0, 151).addBox(-6.5F, -5.5F, -4.0F, 4.0F, 6.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(137, 147).addBox(2.5F, -5.5F, -4.0F, 4.0F, 6.0F, 8.0F, 0.0F, false);

		right_horn = new AdvancedModelBox(this,"right_horn");
		right_horn.setRotationPoint(-6.2F, -10.0F, 0.0F);
		head.addChild(right_horn);
		setRotationAngle(right_horn, -0.2618F, 0.0F, -0.6545F);


		cube_r21 = new AdvancedModelBox(this);
		cube_r21.setRotationPoint(5.0F, 12.0F, 2.0F);
		right_horn.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.1309F, 0.0F, -0.3054F);
		cube_r21.setTextureOffset(55, 18).addBox(-7.811F, -23.4301F, 0.1321F, 12.0F, 6.0F, 0.0F, 0.0F, false);
		cube_r21.setTextureOffset(24, 0).addBox(-9.811F, -17.4301F, 0.1321F, 5.0F, 10.0F, 0.0F, 0.0F, false);
		cube_r21.setTextureOffset(55, 41).addBox(-4.811F, -21.4301F, -1.3679F, 11.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r21.setTextureOffset(0, 29).addBox(-4.811F, -17.4301F, -1.8679F, 4.0F, 9.0F, 4.0F, 0.0F, false);

		left_horn = new AdvancedModelBox(this,"left_horn");
		left_horn.setRotationPoint(6.2F, -10.0F, 0.0F);
		head.addChild(left_horn);
		setRotationAngle(left_horn, -0.2618F, 0.0F, 0.6545F);


		cube_r22 = new AdvancedModelBox(this);
		cube_r22.setRotationPoint(-5.0F, 12.0F, 2.0F);
		left_horn.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.1309F, 0.0F, 0.3054F);
		cube_r22.setTextureOffset(55, 18).addBox(-4.189F, -23.4301F, 0.1321F, 12.0F, 6.0F, 0.0F, 0.0F, true);
		cube_r22.setTextureOffset(24, 0).addBox(4.811F, -17.4301F, 0.1321F, 5.0F, 10.0F, 0.0F, 0.0F, true);
		cube_r22.setTextureOffset(55, 41).addBox(-6.189F, -21.4301F, -1.3679F, 11.0F, 4.0F, 3.0F, 0.0F, true);
		cube_r22.setTextureOffset(0, 29).addBox(0.811F, -17.4301F, -1.8679F, 4.0F, 9.0F, 4.0F, 0.0F, true);

		left_wing = new AdvancedModelBox(this,"left_wing");
		left_wing.setRotationPoint(-3.0F, -10.0F, 1.0F);
		body.addChild(left_wing);
		setRotationAngle(left_wing, -0.0181F, 0.3923F, -0.0472F);
		left_wing.setTextureOffset(95, 53).addBox(-35.0F, -30.0F, 0.0F, 35.0F, 58.0F, 0.0F, 0.0F, false);

		left_wing2 = new AdvancedModelBox(this,"left_wing2");
		left_wing2.setRotationPoint(-35.0F, 8.0F, 0.0F);
		left_wing.addChild(left_wing2);
		left_wing2.setTextureOffset(0, 53).addBox(-47.0F, -38.0F, 0.0F, 47.0F, 58.0F, 0.0F, 0.0F, false);

		right_wing = new AdvancedModelBox(this,"right_wing");
		right_wing.setRotationPoint(3.0F, -2.0F, 1.0F);
		body.addChild(right_wing);
		setRotationAngle(right_wing, -0.0181F, -0.3923F, 0.0472F);
		right_wing.setTextureOffset(95, 53).addBox(0.0F, -38.0F, 0.0F, 35.0F, 58.0F, 0.0F, 0.0F, true);

		right_wing2 = new AdvancedModelBox(this,"right_wing2");
		right_wing2.setRotationPoint(35.0F, 0.0F, 0.0F);
		right_wing.addChild(right_wing2);
		right_wing2.setTextureOffset(0, 53).addBox(0.0F, -38.0F, 0.0F, 47.0F, 58.0F, 0.0F, 0.0F, true);
		updateDefaultPose();
	}

	@Override
	public void setupAnim(Maledictus_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();
		float swimSpeed = 0.1F;
		this.animate(entity.getAnimationState("idle"), Maledictus_Animation.IDLE, ageInTicks, 0.75F);
		this.animate(entity.getAnimationState("swing"), Maledictus_Animation.SWING, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("shoot"), Maledictus_Animation.SHOOT, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("flying_shoot"), Maledictus_Animation.FLYING_SHOOT, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("fall_loop"), Maledictus_Animation.FALL_LOOP, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("fall_end"), Maledictus_Animation.FALL_END, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("mass_effect"), Maledictus_Animation.MASS_EFFECT, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("flying_smash_1"), Maledictus_Animation.FLYING_SMASH_1, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("flying_smash_2"), Maledictus_Animation.FLYING_SMASH_2, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("death"), Maledictus_Animation.DEATH, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("back_step"), Maledictus_Animation.CHARGE_BACKSTEP, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("back_step_charge"), Maledictus_Animation.CHARGE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("charge"), Maledictus_Animation.CHARGE, ageInTicks, 1.0F);

		if(entity.getAttackState() != 10 && entity.getAttackState() != 11 && entity.getAttackState() != 12) {
			this.animateWalk(Maledictus_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 4.0F);
		}

		this.faceTarget(netHeadYaw, headPitch, 1, head);
		right_mace.showModel = entity.getWeapon() == 0;
		left_mace.showModel = entity.getWeapon() == 0;
		bow.showModel = entity.getWeapon() == 1;
		halberd.showModel = entity.getWeapon() == 2;
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
		return ImmutableList.of(
				root,
				berserker,
				legs,
				right_leg,
				cube_r1,
				right_front_leg,
				cube_r2,
				left_leg,
				cube_r3,
				left_front_leg,
				cube_r4,
				pelvis,
				front_cloth1,
				front_cloth2,
				body,
				right_shoulder,
				cube_r5,
				cube_r6,
				right_arm,
				right_front_arm,
				bow,
				cube_r7,
				cube_r8,
				cube_r9,
				bow_string,
				string1,
				string2,
				right_mace,
				cube_r10,
				cube_r11,
				cube_r12,
				left_shoulder,
				cube_r13,
				cube_r14,
				left_arm,
				left_front_arm,
				left_mace,
				cube_r15,
				cube_r16,
				cube_r17,
				head,
				right_particle,
				left_particle,
				right_horn,
				cube_r18,
				left_horn,
				cube_r19,
				halberd,
				halberd2,
				cube_r20,
				cube_r21,
				cube_r22,
				left_wing,
				left_wing2,
				right_wing,
				right_wing2);
	}
}