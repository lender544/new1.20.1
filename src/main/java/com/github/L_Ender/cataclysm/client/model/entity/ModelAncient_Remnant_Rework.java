package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Ancient_Remnant_Animation;
import com.github.L_Ender.cataclysm.client.animation.Ancient_Remnant_Power_Animation;
import com.github.L_Ender.cataclysm.client.animation.Kobolediator_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.github.L_Ender.lionfishapi.server.animation.LegSolver;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;

public class ModelAncient_Remnant_Rework extends AdvancedEntityModel<Ancient_Remnant_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox mid_pivot;
	private final AdvancedModelBox pelvis;
	private final AdvancedModelBox left_long_bone;
	private final AdvancedModelBox right_long_bone;
	private final AdvancedModelBox spine_sail2;
	private final AdvancedModelBox left_bone;
	private final AdvancedModelBox right_bone;
	private final AdvancedModelBox left_big_bone;
	private final AdvancedModelBox right_big_bone;
	private final AdvancedModelBox tail1;
	private final AdvancedModelBox tail2;
	private final AdvancedModelBox tail3;
	private final AdvancedModelBox tail4;
	private final AdvancedModelBox spine1;
	private final AdvancedModelBox spine2;
	private final AdvancedModelBox spine_sail1;
	private final AdvancedModelBox right_shoulder;
	private final AdvancedModelBox left_shoulder;
	private final AdvancedModelBox neck1;
	private final AdvancedModelBox neck2;
	private final AdvancedModelBox head;
	private final AdvancedModelBox jaw;
	private final AdvancedModelBox crown;
	private final AdvancedModelBox under_crown;
	private final AdvancedModelBox right_crown1;
	private final AdvancedModelBox right_crown2;
	private final AdvancedModelBox left_crown;
	private final AdvancedModelBox left_crown2;
	private final AdvancedModelBox snake;
	private final AdvancedModelBox upper_crown;
	private final AdvancedModelBox desert_necklace;
	private final AdvancedModelBox chain1;
	private final AdvancedModelBox chain2;
	private final AdvancedModelBox chain3;
	private final AdvancedModelBox chain4;
	private final AdvancedModelBox chain5;
	private final AdvancedModelBox desert_eye;
	private final AdvancedModelBox eye;
	private final AdvancedModelBox left_arm;
	private final AdvancedModelBox left_front_arm;
	private final AdvancedModelBox left_hand;
	private final AdvancedModelBox left_finger3;
	private final AdvancedModelBox left_finger1;
	private final AdvancedModelBox left_finger2;
	private final AdvancedModelBox right_arm;
	private final AdvancedModelBox right_front_arm;
	private final AdvancedModelBox right_hand;
	private final AdvancedModelBox right_finger1;
	private final AdvancedModelBox right_finger2;
	private final AdvancedModelBox right_finger3;
	private final AdvancedModelBox spine_deco;
	private final AdvancedModelBox legs;
	private final AdvancedModelBox left_leg;
	private final AdvancedModelBox left_deco1;
	private final AdvancedModelBox left_front_leg;
	private final AdvancedModelBox left_ankel_joint;
	private final AdvancedModelBox left_mini_bone;
	private final AdvancedModelBox left_deco2;
	private final AdvancedModelBox left_deco3;
	private final AdvancedModelBox left_ankel;
	private final AdvancedModelBox left_foot;
	private final AdvancedModelBox left_toe;
	private final AdvancedModelBox left_toe2;
	private final AdvancedModelBox left_toe3;
	private final AdvancedModelBox right_leg;
	private final AdvancedModelBox right_deco1;
	private final AdvancedModelBox right_front_leg;
	private final AdvancedModelBox right_ankel_joint;
	private final AdvancedModelBox right_mini_bone;
	private final AdvancedModelBox right_deco2;
	private final AdvancedModelBox right_deco3;
	private final AdvancedModelBox right_ankel;
	private final AdvancedModelBox right_foot;
	private final AdvancedModelBox right_toe;
	private final AdvancedModelBox right_toe2;
	private final AdvancedModelBox right_toe3;
	private ModelAnimator animator;

	public ModelAncient_Remnant_Rework() {
		texWidth = 512;
		texHeight = 512;

		root = new AdvancedModelBox(this,"root");
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		mid_pivot = new AdvancedModelBox(this,"mid_pivot");
		mid_pivot.setRotationPoint(0.0F, -69.0F, -10.0F);
		root.addChild(mid_pivot);


		pelvis = new AdvancedModelBox(this,"pelvis");
		pelvis.setRotationPoint(0.0F, 0.0F, 2.0F);
		mid_pivot.addChild(pelvis);
		setRotationAngle(pelvis, -0.2182F, 0.0F, 0.0F);
		pelvis.setTextureOffset(111, 42).addBox(-5.0F, -4.2211F, -9.2432F, 10.0F, 12.0F, 24.0F, 0.0F, false);

		left_long_bone = new AdvancedModelBox(this,"left_long_bone");
		left_long_bone.setRotationPoint(6.5F, -0.2211F, -8.2432F);
		pelvis.addChild(left_long_bone);
		setRotationAngle(left_long_bone, -0.4185F, 0.1274F, 0.2783F);
		left_long_bone.setTextureOffset(50, 0).addBox(0.0F, -4.0F, 6.0F, 5.0F, 28.0F, 7.0F, 0.0F, false);

		right_long_bone = new AdvancedModelBox(this,"right_long_bone");
		right_long_bone.setRotationPoint(-6.5F, -0.2211F, -8.2432F);
		pelvis.addChild(right_long_bone);
		setRotationAngle(right_long_bone, -0.4185F, -0.1274F, -0.2783F);
		right_long_bone.setTextureOffset(50, 0).addBox(-5.0F, -4.0F, 6.0F, 5.0F, 28.0F, 7.0F, 0.0F, true);

		spine_sail2 = new AdvancedModelBox(this,"spine_sail2");
		spine_sail2.setRotationPoint(0.0F, -0.2211F, 12.7568F);
		pelvis.addChild(spine_sail2);
		setRotationAngle(spine_sail2, 0.1745F, 0.0F, 0.0F);
		spine_sail2.setTextureOffset(65, 50).addBox(0.0F, -28.916F, -25.98F, 0.0F, 30.0F, 32.0F, 0.01F, false);

		left_bone = new AdvancedModelBox(this,"left_bone");
		left_bone.setRotationPoint(3.5F, -0.2211F, -8.2432F);
		pelvis.addChild(left_bone);
		setRotationAngle(left_bone, 0.7811F, -0.0924F, 0.0928F);
		left_bone.setTextureOffset(194, 215).addBox(1.0F, 3.0F, 0.0F, 7.0F, 33.0F, 7.0F, 0.0F, false);

		right_bone = new AdvancedModelBox(this,"right_bone");
		right_bone.setRotationPoint(-3.5F, -0.2211F, -8.2432F);
		pelvis.addChild(right_bone);
		setRotationAngle(right_bone, 0.7811F, 0.0924F, -0.0928F);
		right_bone.setTextureOffset(194, 215).addBox(-8.0F, 3.0F, 0.0F, 7.0F, 33.0F, 7.0F, 0.0F, true);

		left_big_bone = new AdvancedModelBox(this,"left_big_bone");
		left_big_bone.setRotationPoint(0.0F, -0.2211F, -8.2432F);
		pelvis.addChild(left_big_bone);
		setRotationAngle(left_big_bone, 0.3186F, 0.1451F, -0.413F);
		left_big_bone.setTextureOffset(112, 124).addBox(1.0F, -2.0F, -1.0F, 9.0F, 14.0F, 27.0F, 0.0F, false);

		right_big_bone = new AdvancedModelBox(this,"right_big_bone");
		right_big_bone.setRotationPoint(0.0F, -0.2211F, -8.2432F);
		pelvis.addChild(right_big_bone);
		setRotationAngle(right_big_bone, 0.3186F, -0.1451F, 0.413F);
		right_big_bone.setTextureOffset(112, 124).addBox(-10.0F, -2.0F, -1.0F, 9.0F, 14.0F, 27.0F, 0.0F, true);

		tail1 = new AdvancedModelBox(this,"tail1");
		tail1.setRotationPoint(0.0F, 6.7789F, 10.7568F);
		pelvis.addChild(tail1);
		setRotationAngle(tail1, 0.0436F, 0.0F, 0.0F);
		tail1.setTextureOffset(98, 81).addBox(-4.0F, -5.916F, 1.02F, 8.0F, 10.0F, 32.0F, 0.0F, false);
		tail1.setTextureOffset(47, 117).addBox(0.0F, -24.916F, -0.98F, 0.0F, 19.0F, 32.0F, 0.0F, false);
		tail1.setTextureOffset(114, 197).addBox(0.0F, 4.084F, 6.02F, 0.0F, 6.0F, 25.0F, 0.0F, false);

		tail2 = new AdvancedModelBox(this,"tail2");
		tail2.setRotationPoint(0.0F, -2.8F, 32.0F);
		tail1.addChild(tail2);
		setRotationAngle(tail2, 0.0873F, 0.0F, 0.0F);
		tail2.setTextureOffset(0, 109).addBox(-3.5F, -3.7067F, -0.3098F, 7.0F, 7.0F, 32.0F, 0.0F, false);
		tail2.setTextureOffset(148, 47).addBox(0.0F, 3.2933F, -0.3098F, 0.0F, 4.0F, 32.0F, 0.0F, false);
		tail2.setTextureOffset(0, 149).addBox(0.0F, -6.7067F, -0.3098F, 0.0F, 3.0F, 32.0F, 0.0F, false);

		tail3 = new AdvancedModelBox(this,"tail3");
		tail3.setRotationPoint(0.0F, -1.5762F, 31.5254F);
		tail2.addChild(tail3);
		setRotationAngle(tail3, -0.0436F, 0.0F, 0.0F);
		tail3.setTextureOffset(0, 0).addBox(-3.0F, -2.7686F, -0.1825F, 6.0F, 6.0F, 37.0F, 0.0F, false);
		tail3.setTextureOffset(156, 13).addBox(0.0F, -6.7686F, -0.1825F, 0.0F, 4.0F, 29.0F, 0.0F, false);
		tail3.setTextureOffset(28, 198).addBox(0.0F, 3.2314F, -0.1825F, 0.0F, 4.0F, 25.0F, 0.0F, false);

		tail4 = new AdvancedModelBox(this,"tail4");
		tail4.setRotationPoint(0.5F, 1.3649F, 34.6065F);
		tail3.addChild(tail4);
		setRotationAngle(tail4, -0.2618F, 0.0F, 0.0F);
		tail4.setTextureOffset(50, 7).addBox(-3.0F, -2.8005F, 0.2055F, 5.0F, 5.0F, 37.0F, 0.0F, false);

		spine1 = new AdvancedModelBox(this,"spine1");
		spine1.setRotationPoint(0.0F, 5.0F, -5.0F);
		pelvis.addChild(spine1);
		spine1.setTextureOffset(162, 143).addBox(-4.5F, -5.0F, -19.0F, 9.0F, 8.0F, 23.0F, 0.0F, false);
		spine1.setTextureOffset(0, 185).addBox(3.0F, -3.0F, -19.0F, 11.0F, 18.0F, 15.0F, 0.0F, false);
		spine1.setTextureOffset(145, 175).addBox(-14.0F, -3.0F, -19.0F, 11.0F, 18.0F, 15.0F, 0.0F, false);

		spine2 = new AdvancedModelBox(this,"spine2");
		spine2.setRotationPoint(0.0F, 0.0F, -19.0F);
		spine1.addChild(spine2);
		setRotationAngle(spine2, 0.3491F, 0.0F, 0.0F);
		spine2.setTextureOffset(158, 101).addBox(-4.5F, -5.0F, -23.0F, 9.0F, 8.0F, 23.0F, 0.0F, false);
		spine2.setTextureOffset(200, 73).addBox(3.0F, -3.0F, -18.0F, 10.0F, 16.0F, 15.0F, 0.0F, false);
		spine2.setTextureOffset(88, 190).addBox(-13.0F, -3.0F, -18.0F, 10.0F, 16.0F, 15.0F, 0.0F, false);
		spine2.setTextureOffset(128, 229).addBox(1.8F, -7.1199F, -17.5887F, 4.0F, 5.0F, 13.0F, 0.0F, false);
		spine2.setTextureOffset(93, 229).addBox(-5.8F, -7.1199F, -17.5887F, 4.0F, 5.0F, 13.0F, 0.0F, false);

		spine_sail1 = new AdvancedModelBox(this,"spine_sail1");
		spine_sail1.setRotationPoint(0.0F, -5.2211F, 36.7568F);
		spine2.addChild(spine_sail1);
		setRotationAngle(spine_sail1, -0.0436F, 0.0F, 0.0F);
		spine_sail1.setTextureOffset(0, 44).addBox(0.0F, -18.916F, -52.98F, 0.0F, 32.0F, 32.0F, 0.0F, false);

		right_shoulder = new AdvancedModelBox(this,"right_shoulder");
		right_shoulder.setRotationPoint(0.0F, 0.0F, 0.0F);
		spine2.addChild(right_shoulder);
		setRotationAngle(right_shoulder, 0.5314F, -0.5844F, -0.3136F);
		right_shoulder.setTextureOffset(176, 187).addBox(-23.0F, -3.0F, -17.0F, 5.0F, 5.0F, 22.0F, 0.0F, true);

		left_shoulder = new AdvancedModelBox(this,"left_shoulder");
		left_shoulder.setRotationPoint(0.0F, 0.0F, 0.0F);
		spine2.addChild(left_shoulder);
		setRotationAngle(left_shoulder, 0.5314F, 0.5844F, 0.3136F);
		left_shoulder.setTextureOffset(176, 187).addBox(18.0F, -3.0F, -17.0F, 5.0F, 5.0F, 22.0F, 0.0F, false);

		neck1 = new AdvancedModelBox(this,"neck1");
		neck1.setRotationPoint(-0.5F, -1.0F, -20.0F);
		spine2.addChild(neck1);
		setRotationAngle(neck1, -0.4363F, 0.0F, 0.0F);
		neck1.setTextureOffset(204, 137).addBox(-3.5F, -4.0937F, -15.5774F, 8.0F, 9.0F, 16.0F, 0.0F, false);
		neck1.setTextureOffset(186, 0).addBox(-3.5F, -4.0937F, -17.5774F, 8.0F, 18.0F, 16.0F, 0.7F, false);
		neck1.setTextureOffset(235, 0).addBox(0.5F, -10.0937F, -15.5774F, 0.0F, 6.0F, 12.0F, 0.0F, false);

		neck2 = new AdvancedModelBox(this,"neck2");
		neck2.setRotationPoint(0.0F, -0.0937F, -17.5774F);
		neck1.addChild(neck2);
		setRotationAngle(neck2, 0.0873F, 0.0F, 0.0F);
		neck2.setTextureOffset(217, 35).addBox(-3.0F, -4.0038F, -10.0872F, 7.0F, 8.0F, 13.0F, 0.0F, false);
		neck2.setTextureOffset(33, 157).addBox(0.5F, -10.0038F, -10.0872F, 0.0F, 6.0F, 12.0F, 0.0F, false);

		head = new AdvancedModelBox(this,"head");
		head.setRotationPoint(0.0F, -1.0F, -8.0F);
		neck2.addChild(head);
		setRotationAngle(head, 0.3054F, 0.0F, 0.0F);
		head.setTextureOffset(80, 124).addBox(-6.0F, -10.0F, -14.0F, 13.0F, 10.0F, 14.0F, 0.0F, false);
		head.setTextureOffset(209, 175).addBox(-6.0F, -9.0F, -14.0F, 13.0F, 2.0F, 14.0F, 0.5F, false);
		head.setTextureOffset(44, 169).addBox(-3.5F, -7.0F, -35.0F, 8.0F, 7.0F, 21.0F, 0.0F, false);
		head.setTextureOffset(0, 222).addBox(-3.5F, -7.0F, -20.0F, 8.0F, 32.0F, 6.0F, 0.5F, false);
		head.setTextureOffset(33, 50).addBox(-3.5F, 0.0F, -35.0F, 8.0F, 4.0F, 21.0F, 0.0F, false);

		jaw = new AdvancedModelBox(this,"jaw");
		jaw.setRotationPoint(0.0F, 2.0F, -7.0F);
		head.addChild(jaw);
		jaw.setTextureOffset(29, 228).addBox(-4.0F, -2.0F, -6.0F, 9.0F, 7.0F, 11.0F, 0.0F, false);
		jaw.setTextureOffset(181, 47).addBox(-3.0F, 0.0F, -27.0F, 7.0F, 4.0F, 21.0F, 0.0F, false);
		jaw.setTextureOffset(216, 198).addBox(-3.0F, 4.0F, -27.0F, 7.0F, 2.0F, 17.0F, 0.0F, false);
		jaw.setTextureOffset(202, 112).addBox(-2.5F, -3.0F, -27.0F, 6.0F, 3.0F, 21.0F, 0.0F, false);

		crown = new AdvancedModelBox(this,"crown");
		crown.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(crown);


		under_crown = new AdvancedModelBox(this,"under_crown");
		under_crown.setRotationPoint(0.5F, -7.9063F, 1.5774F);
		crown.addChild(under_crown);
		setRotationAngle(under_crown, -0.3054F, 0.0F, 0.0F);
		under_crown.setTextureOffset(223, 218).addBox(-7.5F, 0.0F, -4.0F, 15.0F, 17.0F, 4.0F, 0.0F, false);

		right_crown1 = new AdvancedModelBox(this,"right_crown1");
		right_crown1.setRotationPoint(12.5F, 2.0F, -7.0F);
		under_crown.addChild(right_crown1);
		right_crown1.setTextureOffset(13, 149).addBox(-5.0F, -2.0F, 0.0F, 6.0F, 8.0F, 3.0F, 0.0F, false);
		right_crown1.setTextureOffset(23, 0).addBox(-5.0F, -4.0F, 1.5F, 4.0F, 2.0F, 0.0F, 0.0F, false);
		right_crown1.setTextureOffset(29, 19).addBox(1.0F, 0.0F, 1.5F, 2.0F, 6.0F, 0.0F, 0.0F, false);
		right_crown1.setTextureOffset(158, 133).addBox(-5.0F, 6.0F, 0.0F, 9.0F, 9.0F, 3.0F, 0.0F, false);
		right_crown1.setTextureOffset(80, 113).addBox(-5.0F, 15.0F, 0.0F, 5.0F, 4.0F, 3.0F, 0.0F, false);
		right_crown1.setTextureOffset(0, 0).addBox(0.0F, 15.0F, 1.5F, 2.0F, 3.0F, 0.0F, 0.0F, false);

		right_crown2 = new AdvancedModelBox(this,"right_crown2");
		right_crown2.setRotationPoint(-3.5F, 19.0F, 3.0F);
		right_crown1.addChild(right_crown2);
		setRotationAngle(right_crown2, -0.2618F, 0.0F, 0.0F);
		right_crown2.setTextureOffset(84, 50).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		left_crown = new AdvancedModelBox(this,"left_crown");
		left_crown.setRotationPoint(-12.5F, 2.0F, -7.0F);
		under_crown.addChild(left_crown);
		left_crown.setTextureOffset(13, 149).addBox(-1.0F, -2.0F, 0.0F, 6.0F, 8.0F, 3.0F, 0.0F, true);
		left_crown.setTextureOffset(23, 0).addBox(1.0F, -4.0F, 1.5F, 4.0F, 2.0F, 0.0F, 0.0F, true);
		left_crown.setTextureOffset(29, 19).addBox(-3.0F, 0.0F, 1.5F, 2.0F, 6.0F, 0.0F, 0.0F, true);
		left_crown.setTextureOffset(158, 133).addBox(-4.0F, 6.0F, 0.0F, 9.0F, 9.0F, 3.0F, 0.0F, true);
		left_crown.setTextureOffset(80, 113).addBox(0.0F, 15.0F, 0.0F, 5.0F, 4.0F, 3.0F, 0.0F, true);
		left_crown.setTextureOffset(0, 0).addBox(-2.0F, 15.0F, 1.5F, 2.0F, 3.0F, 0.0F, 0.0F, true);

		left_crown2 = new AdvancedModelBox(this,"left_crown2");
		left_crown2.setRotationPoint(3.5F, 19.0F, 3.0F);
		left_crown.addChild(left_crown2);
		setRotationAngle(left_crown2, -0.2618F, 0.0F, 0.0F);
		left_crown2.setTextureOffset(84, 50).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, 0.0F, true);

		snake = new AdvancedModelBox(this,"snake");
		snake.setRotationPoint(0.5F, 66.0937F, 77.5774F);
		crown.addChild(snake);
		snake.setTextureOffset(172, 84).addBox(0.0F, -83.0937F, -99.5774F, 0.0F, 7.0F, 9.0F, 0.0F, false);
		snake.setTextureOffset(29, 10).addBox(-4.5F, -81.5937F, -93.5774F, 3.0F, 8.0F, 0.0F, 0.0F, true);
		snake.setTextureOffset(29, 10).addBox(1.5F, -81.5937F, -93.5774F, 3.0F, 8.0F, 0.0F, 0.0F, false);
		snake.setTextureOffset(26, 32).addBox(1.0F, -80.0937F, -96.5774F, 1.0F, 1.0F, 3.0F, 0.5F, false);
		snake.setTextureOffset(71, 50).addBox(-1.0F, -81.0937F, -94.5774F, 2.0F, 8.0F, 2.0F, 0.5F, false);
		snake.setTextureOffset(29, 26).addBox(-1.5F, -77.5937F, -100.0774F, 3.0F, 2.0F, 0.0F, 0.0F, false);
		snake.setTextureOffset(26, 32).addBox(-2.0F, -80.0937F, -96.5774F, 1.0F, 1.0F, 3.0F, 0.5F, false);
		snake.setTextureOffset(98, 0).addBox(-1.0F, -81.0937F, -99.5774F, 2.0F, 3.0F, 4.0F, 0.5F, false);

		upper_crown = new AdvancedModelBox(this,"upper_crown");
		upper_crown.setRotationPoint(0.0F, -7.9063F, 1.5774F);
		crown.addChild(upper_crown);
		setRotationAngle(upper_crown, -0.1309F, 0.0F, 0.0F);
		upper_crown.setTextureOffset(95, 166).addBox(-7.0F, -6.0F, -17.0F, 15.0F, 6.0F, 17.0F, 0.01F, false);

		desert_necklace = new AdvancedModelBox(this,"desert_necklace");
		desert_necklace.setRotationPoint(0.5F, -4.9063F, -0.9226F);
		neck2.addChild(desert_necklace);
		setRotationAngle(desert_necklace, 0.2182F, 0.0F, 0.0F);
		desert_necklace.setTextureOffset(82, 169).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 4.0F, 3.0F, 0.0F, false);

		chain1 = new AdvancedModelBox(this,"chain1");
		chain1.setRotationPoint(0.0F, 4.0F, 0.0F);
		desert_necklace.addChild(chain1);
		chain1.setTextureOffset(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, 0.0F, false);

		chain2 = new AdvancedModelBox(this,"chain2");
		chain2.setRotationPoint(0.0F, 5.0F, 0.0F);
		chain1.addChild(chain2);
		chain2.setTextureOffset(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, 0.0F, false);

		chain3 = new AdvancedModelBox(this,"chain3");
		chain3.setRotationPoint(0.0F, 5.0F, 0.0F);
		chain2.addChild(chain3);
		chain3.setTextureOffset(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, 0.0F, false);

		chain4 = new AdvancedModelBox(this,"chain4");
		chain4.setRotationPoint(0.0F, 5.0F, 0.0F);
		chain3.addChild(chain4);
		chain4.setTextureOffset(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, 0.0F, false);

		chain5 = new AdvancedModelBox(this,"chain5");
		chain5.setRotationPoint(0.0F, 5.0F, 0.0F);
		chain4.addChild(chain5);
		chain5.setTextureOffset(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, 0.0F, false);

		desert_eye = new AdvancedModelBox(this,"desert_eye");
		desert_eye.setRotationPoint(0.0F, 8.7811F, -0.2836F);
		chain5.addChild(desert_eye);
		desert_eye.setTextureOffset(167, 0).addBox(-12.0F, -7.1811F, 0.2836F, 11.0F, 11.0F, 0.0F, 0.0F, true);
		desert_eye.setTextureOffset(167, 0).addBox(1.0F, -7.1811F, 0.2836F, 11.0F, 11.0F, 0.0F, 0.0F, false);

		eye = new AdvancedModelBox(this,"eye");
		eye.setRotationPoint(0.0F, -0.7811F, 0.2836F);
		desert_eye.addChild(eye);
		setRotationAngle(eye, 0.0F, 0.0F, 0.7854F);
		eye.setTextureOffset(98, 50).addBox(-5.0F, -5.0F, -1.0F, 10.0F, 10.0F, 2.0F, 0.0F, false);

		left_arm = new AdvancedModelBox(this,"left_arm");
		left_arm.setRotationPoint(13.2F, 10.0F, -17.0F);
		spine2.addChild(left_arm);
		setRotationAngle(left_arm, 0.3491F, 0.0F, 0.0F);
		left_arm.setTextureOffset(47, 109).addBox(-6.0F, -4.0637F, -3.0436F, 6.0F, 20.0F, 5.0F, 0.0F, false);
		left_arm.setTextureOffset(0, 109).addBox(-6.0F, -4.0637F, -3.0436F, 6.0F, 20.0F, 5.0F, 0.5F, false);

		left_front_arm = new AdvancedModelBox(this,"left_front_arm");
		left_front_arm.setRotationPoint(-4.0F, 15.2977F, -1.9036F);
		left_arm.addChild(left_front_arm);
		setRotationAngle(left_front_arm, -0.829F, 0.0F, 0.0F);
		left_front_arm.setTextureOffset(156, 47).addBox(-3.0F, -0.1465F, -2.2077F, 6.0F, 11.0F, 5.0F, 0.0F, false);
		left_front_arm.setTextureOffset(0, 169).addBox(-3.0F, 2.8535F, -2.2077F, 6.0F, 5.0F, 5.0F, 0.5F, false);

		left_hand = new AdvancedModelBox(this,"left_hand");
		left_hand.setRotationPoint(1.0F, 10.1551F, -0.5133F);
		left_front_arm.addChild(left_hand);
		setRotationAngle(left_hand, 1.6144F, 0.0F, 0.0F);


		left_finger3 = new AdvancedModelBox(this,"left_finger3");
		left_finger3.setRotationPoint(1.0F, 0.0049F, 0.3079F);
		left_hand.addChild(left_finger3);
		setRotationAngle(left_finger3, -0.7216F, -0.2324F, 0.2F);
		left_finger3.setTextureOffset(0, 149).addBox(-0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, 0.0F, false);

		left_finger1 = new AdvancedModelBox(this,"left_finger1");
		left_finger1.setRotationPoint(-3.0F, 0.0049F, 0.3079F);
		left_hand.addChild(left_finger1);
		setRotationAngle(left_finger1, -0.7216F, 0.2324F, -0.2F);
		left_finger1.setTextureOffset(147, 84).addBox(0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, 0.0F, false);

		left_finger2 = new AdvancedModelBox(this,"left_finger2");
		left_finger2.setRotationPoint(-1.0F, 0.0049F, 0.3079F);
		left_hand.addChild(left_finger2);
		setRotationAngle(left_finger2, -0.7258F, 0.0F, 0.0F);
		left_finger2.setTextureOffset(0, 149).addBox(-0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, 0.0F, false);

		right_arm = new AdvancedModelBox(this,"right_arm");
		right_arm.setRotationPoint(-13.2F, 10.0F, -17.0F);
		spine2.addChild(right_arm);
		setRotationAngle(right_arm, 0.3491F, 0.0F, 0.0F);
		right_arm.setTextureOffset(47, 109).addBox(0.0F, -4.0637F, -3.0436F, 6.0F, 20.0F, 5.0F, 0.0F, true);

		right_front_arm = new AdvancedModelBox(this,"right_front_arm");
		right_front_arm.setRotationPoint(4.0F, 15.2977F, -1.9036F);
		right_arm.addChild(right_front_arm);
		setRotationAngle(right_front_arm, -0.829F, 0.0F, 0.0F);
		right_front_arm.setTextureOffset(156, 47).addBox(-3.0F, -0.1465F, -2.2077F, 6.0F, 11.0F, 5.0F, 0.0F, true);
		right_front_arm.setTextureOffset(0, 169).addBox(-3.0F, 2.8535F, -2.2077F, 6.0F, 5.0F, 5.0F, 0.5F, true);

		right_hand = new AdvancedModelBox(this,"right_hand");
		right_hand.setRotationPoint(-1.0F, 10.1551F, -0.5133F);
		right_front_arm.addChild(right_hand);
		setRotationAngle(right_hand, 1.6144F, 0.0F, 0.0F);


		right_finger1 = new AdvancedModelBox(this,"right_finger1");
		right_finger1.setRotationPoint(-1.0F, 0.0049F, 0.3079F);
		right_hand.addChild(right_finger1);
		setRotationAngle(right_finger1, -0.7216F, 0.2324F, -0.2F);
		right_finger1.setTextureOffset(0, 149).addBox(0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, 0.0F, true);

		right_finger2 = new AdvancedModelBox(this,"right_finger2");
		right_finger2.setRotationPoint(1.0F, 0.0049F, 0.3079F);
		right_hand.addChild(right_finger2);
		setRotationAngle(right_finger2, -0.7258F, 0.0F, 0.0F);
		right_finger2.setTextureOffset(0, 149).addBox(0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, 0.0F, true);

		right_finger3 = new AdvancedModelBox(this,"right_finger3");
		right_finger3.setRotationPoint(3.0F, 0.0049F, 0.3079F);
		right_hand.addChild(right_finger3);
		setRotationAngle(right_finger3, -0.7216F, -0.2324F, 0.2F);
		right_finger3.setTextureOffset(147, 84).addBox(-0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, 0.0F, true);

		spine_deco = new AdvancedModelBox(this,"spine_deco");
		spine_deco.setRotationPoint(0.0F, -7.3F, -6.7F);
		spine2.addChild(spine_deco);
		setRotationAngle(spine_deco, -0.1309F, 0.0F, 0.0F);
		spine_deco.setTextureOffset(98, 0).addBox(-13.2F, 0.0F, -16.5F, 26.0F, 25.0F, 16.0F, 0.5F, false);

		legs = new AdvancedModelBox(this,"legs");
		legs.setRotationPoint(0.0F, 4.0F, 7.0F);
		mid_pivot.addChild(legs);


		left_leg = new AdvancedModelBox(this,"left_leg");
		left_leg.setRotationPoint(15.0F, 0.0F, 6.0F);
		legs.addChild(left_leg);
		setRotationAngle(left_leg, -0.3927F, 0.0F, 0.0F);
		left_leg.setTextureOffset(165, 215).addBox(-6.0F, -2.0261F, -4.1809F, 8.0F, 34.0F, 6.0F, 0.0F, false);

		left_deco1 = new AdvancedModelBox(this,"left_deco1");
		left_deco1.setRotationPoint(2.0F, 10.9739F, -8.1809F);
		left_leg.addChild(left_deco1);
		setRotationAngle(left_deco1, 0.0959F, -0.4349F, -0.0329F);
		left_deco1.setTextureOffset(0, 0).addBox(-3.0F, -8.0F, 1.0F, 8.0F, 28.0F, 6.0F, 0.0F, false);

		left_front_leg = new AdvancedModelBox(this,"left_front_leg");
		left_front_leg.setRotationPoint(-2.0F, 32.9739F, -2.1809F);
		left_leg.addChild(left_front_leg);
		setRotationAngle(left_front_leg, 1.0908F, 0.0F, 0.0F);
		left_front_leg.setTextureOffset(0, 44).addBox(-5.0F, -2.5649F, -1.6913F, 8.0F, 24.0F, 5.0F, 0.0F, false);

		left_ankel_joint = new AdvancedModelBox(this,"left_ankel_joint");
		left_ankel_joint.setRotationPoint(-1.0F, 20.6148F, 1.661F);
		left_front_leg.addChild(left_ankel_joint);


		left_mini_bone = new AdvancedModelBox(this,"left_mini_bone");
		left_mini_bone.setRotationPoint(-1.0F, 11.0F, -6.0F);
		left_ankel_joint.addChild(left_mini_bone);
		setRotationAngle(left_mini_bone, -0.3928F, -0.0035F, 0.0001F);
		left_mini_bone.setTextureOffset(29, 0).addBox(0.0209F, -3.1113F, 0.0913F, 0.0F, 6.0F, 3.0F, 0.0F, false);

		left_deco2 = new AdvancedModelBox(this,"left_deco2");
		left_deco2.setRotationPoint(0.0F, 6.0F, -4.9602F);
		left_ankel_joint.addChild(left_deco2);
		setRotationAngle(left_deco2, 0.5236F, 0.0F, 0.0F);
		left_deco2.setTextureOffset(61, 210).addBox(-2.0F, -2.7487F, 0.1981F, 4.0F, 6.0F, 18.0F, 0.0F, false);

		left_deco3 = new AdvancedModelBox(this,"left_deco3");
		left_deco3.setRotationPoint(-2.0F, 9.0F, -7.0F);
		left_ankel_joint.addChild(left_deco3);
		setRotationAngle(left_deco3, -0.3927F, 0.0F, 0.0F);
		left_deco3.setTextureOffset(33, 45).addBox(-0.2F, -11.7017F, -4.0722F, 4.0F, 13.0F, 5.0F, 0.0F, false);

		left_ankel = new AdvancedModelBox(this,"left_ankel");
		left_ankel.setRotationPoint(0.0F, -1.0F, 0.0F);
		left_ankel_joint.addChild(left_ankel);
		setRotationAngle(left_ankel, -0.5672F, 0.0F, 0.0F);
		left_ankel.setTextureOffset(54, 198).addBox(-3.0F, -0.2489F, -2.0393F, 6.0F, 15.0F, 5.0F, 0.0F, false);

		left_foot = new AdvancedModelBox(this,"left_foot");
		left_foot.setRotationPoint(0.0F, 12.0F, -8.0F);
		left_ankel_joint.addChild(left_foot);


		left_toe = new AdvancedModelBox(this,"left_toe");
		left_toe.setRotationPoint(0.0F, -1.8218F, -0.2377F);
		left_foot.addChild(left_toe);
		setRotationAngle(left_toe, -0.6981F, 0.0F, 0.0F);
		left_toe.setTextureOffset(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, 0.0F, false);

		left_toe2 = new AdvancedModelBox(this,"left_toe2");
		left_toe2.setRotationPoint(-2.0F, -1.8218F, -0.2377F);
		left_foot.addChild(left_toe2);
		setRotationAngle(left_toe2, -0.7216F, 0.2324F, -0.2F);
		left_toe2.setTextureOffset(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, 0.0F, false);

		left_toe3 = new AdvancedModelBox(this,"left_toe3");
		left_toe3.setRotationPoint(2.0F, -1.8218F, -0.2377F);
		left_foot.addChild(left_toe3);
		setRotationAngle(left_toe3, -0.7216F, -0.2324F, 0.2F);
		left_toe3.setTextureOffset(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, 0.0F, false);

		right_leg = new AdvancedModelBox(this,"right_leg");
		right_leg.setRotationPoint(-15.0F, 0.0F, 6.0F);
		legs.addChild(right_leg);
		setRotationAngle(right_leg, -0.3927F, 0.0F, 0.0F);
		right_leg.setTextureOffset(165, 215).addBox(-2.0F, -2.0261F, -4.1809F, 8.0F, 34.0F, 6.0F, 0.0F, true);

		right_deco1 = new AdvancedModelBox(this,"right_deco1");
		right_deco1.setRotationPoint(-2.0F, 10.9739F, -8.1809F);
		right_leg.addChild(right_deco1);
		setRotationAngle(right_deco1, 0.0959F, 0.4349F, 0.0329F);
		right_deco1.setTextureOffset(0, 0).addBox(-5.0F, -8.0F, 1.0F, 8.0F, 28.0F, 6.0F, 0.0F, true);

		right_front_leg = new AdvancedModelBox(this,"right_front_leg");
		right_front_leg.setRotationPoint(2.0F, 32.9739F, -2.1809F);
		right_leg.addChild(right_front_leg);
		setRotationAngle(right_front_leg, 1.0908F, 0.0F, 0.0F);
		right_front_leg.setTextureOffset(0, 44).addBox(-3.0F, -2.5649F, -1.6913F, 8.0F, 24.0F, 5.0F, 0.0F, true);

		right_ankel_joint = new AdvancedModelBox(this,"right_ankel_joint");
		right_ankel_joint.setRotationPoint(1.0F, 20.6148F, 1.661F);
		right_front_leg.addChild(right_ankel_joint);


		right_mini_bone = new AdvancedModelBox(this,"right_mini_bone");
		right_mini_bone.setRotationPoint(1.0F, 11.0F, -6.0F);
		right_ankel_joint.addChild(right_mini_bone);
		setRotationAngle(right_mini_bone, -0.3928F, 0.0035F, -0.0001F);
		right_mini_bone.setTextureOffset(29, 0).addBox(-0.0209F, -3.1113F, 0.0913F, 0.0F, 6.0F, 3.0F, 0.0F, true);

		right_deco2 = new AdvancedModelBox(this,"right_deco2");
		right_deco2.setRotationPoint(0.0F, 6.0F, -4.9602F);
		right_ankel_joint.addChild(right_deco2);
		setRotationAngle(right_deco2, 0.5236F, 0.0F, 0.0F);
		right_deco2.setTextureOffset(61, 210).addBox(-2.0F, -2.7487F, 0.1981F, 4.0F, 6.0F, 18.0F, 0.0F, true);

		right_deco3 = new AdvancedModelBox(this,"right_deco3");
		right_deco3.setRotationPoint(2.0F, 9.0F, -7.0F);
		right_ankel_joint.addChild(right_deco3);
		setRotationAngle(right_deco3, -0.3927F, 0.0F, 0.0F);
		right_deco3.setTextureOffset(33, 45).addBox(-3.8F, -11.7017F, -4.0722F, 4.0F, 13.0F, 5.0F, 0.0F, true);

		right_ankel = new AdvancedModelBox(this,"right_ankel");
		right_ankel.setRotationPoint(0.0F, -1.0F, 0.0F);
		right_ankel_joint.addChild(right_ankel);
		setRotationAngle(right_ankel, -0.5672F, 0.0F, 0.0F);
		right_ankel.setTextureOffset(54, 198).addBox(-3.0F, -0.2489F, -2.0393F, 6.0F, 15.0F, 5.0F, 0.0F, true);

		right_foot = new AdvancedModelBox(this,"right_foot");
		right_foot.setRotationPoint(0.0F, 12.0F, -8.0F);
		right_ankel_joint.addChild(right_foot);


		right_toe = new AdvancedModelBox(this,"right_toe");
		right_toe.setRotationPoint(0.0F, -1.8218F, -0.2377F);
		right_foot.addChild(right_toe);
		setRotationAngle(right_toe, -0.6981F, 0.0F, 0.0F);
		right_toe.setTextureOffset(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, 0.0F, true);

		right_toe2 = new AdvancedModelBox(this,"right_toe2");
		right_toe2.setRotationPoint(2.0F, -1.8218F, -0.2377F);
		right_foot.addChild(right_toe2);
		setRotationAngle(right_toe2, -0.7216F, -0.2324F, 0.2F);
		right_toe2.setTextureOffset(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, 0.0F, true);

		right_toe3 = new AdvancedModelBox(this,"right_toe3");
		right_toe3.setRotationPoint(-2.0F, -1.8218F, -0.2377F);
		right_foot.addChild(right_toe3);
		setRotationAngle(right_toe3, -0.7216F, 0.2324F, -0.2F);
		right_toe3.setTextureOffset(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, 0.0F, true);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}


	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,mid_pivot,pelvis,tail1,tail2,tail3,tail4,spine1,spine2,neck1,neck2,head,jaw,left_arm,left_front_arm,left_hand,left_finger1,left_finger2,left_finger3,right_arm,right_hand,right_finger1,right_finger2,right_finger3,
				right_front_arm,legs,left_leg,left_front_leg,left_ankel,left_ankel_joint,left_foot,left_toe,left_toe2,left_toe3,right_leg,right_front_leg,right_ankel,right_ankel_joint,right_foot,right_toe,right_toe2,right_toe3,desert_necklace,chain1,chain2,chain3,chain4,chain5);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}


	@Override
	public void setupAnim(Ancient_Remnant_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.resetToDefaultPose();
		faceTarget(netHeadYaw, headPitch, 1, head);
		//groinJoint.rotationPointY -= 1 * limbSwingAmount;


		if(entityIn.getAttackState() != 10 && entityIn.getAttackState() != 11 && entityIn.getAttackState() != 12 && !entityIn.isSleep()) {
			this.animateWalk(Ancient_Remnant_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 4.0F);
		}


		this.animate(entityIn.getAnimationState("idle"), Ancient_Remnant_Animation.IDLE, ageInTicks, entityIn.getNecklace() ? 1.0f : 0.15F);
		this.animate(entityIn.getAnimationState("death"), Ancient_Remnant_Animation.DEATH, ageInTicks, 1.0F);
		this.animate(entityIn.getAnimationState("right_bite"), Ancient_Remnant_Animation.RIGHT_BITE, ageInTicks, 1.0F);
		this.animate(entityIn.getAnimationState("sandstorm_roar"), Ancient_Remnant_Animation.SAND_STORM_ROAR, ageInTicks, 1.0F);
		this.animate(entityIn.getAnimationState("phase_roar"), Ancient_Remnant_Animation.PHASE_ROAR, ageInTicks, 1.0F);
		this.animate(entityIn.getAnimationState("charge"), Ancient_Remnant_Animation.CHARGE, ageInTicks, 1.0F);
		this.animate(entityIn.getAnimationState("sleep"), Ancient_Remnant_Animation.SLEEP, ageInTicks, 1.0F);
		this.animate(entityIn.getAnimationState("awaken"), Ancient_Remnant_Animation.AWAKEN, ageInTicks, 1.0F);
			this.animate(entityIn.getAnimationState("left_double_stomp"), Ancient_Remnant_Power_Animation.DOUBLE_STOMP2, ageInTicks, 1.0F);
			this.animate(entityIn.getAnimationState("right_double_stomp"), Ancient_Remnant_Power_Animation.DOUBLE_STOMP1, ageInTicks, 1.0F);
			this.animate(entityIn.getAnimationState("ground_tail"), Ancient_Remnant_Power_Animation.GROUND_TAIL, ageInTicks, 1.0F);
			this.animate(entityIn.getAnimationState("tail_swing"), Ancient_Remnant_Power_Animation.TAIL_SWING, ageInTicks, 1.0F);
			this.animate(entityIn.getAnimationState("monolith"), Ancient_Remnant_Power_Animation.MONOLITH, ageInTicks, 1.0F);

		this.animate(entityIn.getAnimationState("right_stomp"), Ancient_Remnant_Animation.STOMP1, ageInTicks, 1.0F);
		this.animate(entityIn.getAnimationState("left_stomp"), Ancient_Remnant_Animation.STOMP2, ageInTicks, 1.0F);
		this.animate(entityIn.getAnimationState("charge_prepare"), Ancient_Remnant_Animation.CHARGE_PREPARE, ageInTicks, 1.0F);
		this.animate(entityIn.getAnimationState("charge_stun"), Ancient_Remnant_Animation.CHARGE_STUN, ageInTicks, 1.0F);
		float partialTick = Minecraft.getInstance().getFrameTime();

		if (!entityIn.isSleep()) {
			articulateLegs(entityIn.legSolver, partialTick);
		}

		desert_necklace.showModel = entityIn.getNecklace();

	}

	private void articulateLegs(LegSolver legs, float partialTick) {
		float heightBackLeft = legs.legs[0].getHeight(partialTick);
		float heightBackRight = legs.legs[1].getHeight(partialTick);
		float max = (1F - smin(1F - heightBackLeft, 1F - heightBackRight, 0.1F)) * 0.8F;
		root.rotationPointY += max * 16;
		right_leg.rotationPointY += (heightBackRight - max) * 16;
		left_leg.rotationPointY += (heightBackLeft - max) * 16;
	}

	private static float smin(float a, float b, float k) {
		float h = Math.max(k - Math.abs(a - b), 0.0F) / k;
		return Math.min(a, b) - h * h * k * (1.0F / 4.0F);
	}

	private float calculateRotation(float speed, float degree, boolean invert, float offset, float weight, float limbswing, float limbSwingAmount) {
		float rotation = Mth.cos(limbswing * speed + offset) * degree * limbSwingAmount + weight * limbSwingAmount;
		return invert ? -rotation : rotation;
	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

}