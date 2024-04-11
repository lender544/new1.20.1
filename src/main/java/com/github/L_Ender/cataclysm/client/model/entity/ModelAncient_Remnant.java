package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ancient_Remnant_Entity;
import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelPart;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.github.L_Ender.lionfishapi.server.animation.LegSolver;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;

public class ModelAncient_Remnant extends AdvancedEntityModel<Ancient_Remnant_Entity> {
	private final AdvancedModelPart root;
	private final AdvancedModelPart mid_pivot;
	private final AdvancedModelPart pelvis;
	private final AdvancedModelPart left_long_bone;
	private final AdvancedModelPart right_long_bone;
	private final AdvancedModelPart spine_sail2;
	private final AdvancedModelPart left_bone;
	private final AdvancedModelPart right_bone;
	private final AdvancedModelPart left_big_bone;
	private final AdvancedModelPart right_big_bone;
	private final AdvancedModelPart tail1;
	private final AdvancedModelPart tail2;
	private final AdvancedModelPart tail3;
	private final AdvancedModelPart tail4;
	private final AdvancedModelPart spine1;
	private final AdvancedModelPart spine2;
	private final AdvancedModelPart spine_sail1;
	private final AdvancedModelPart right_shoulder;
	private final AdvancedModelPart left_shoulder;
	private final AdvancedModelPart neck1;
	private final AdvancedModelPart neck2;
	private final AdvancedModelPart head;
	private final AdvancedModelPart jaw;
	private final AdvancedModelPart crown;
	private final AdvancedModelPart under_crown;
	private final AdvancedModelPart right_crown1;
	private final AdvancedModelPart right_crown2;
	private final AdvancedModelPart left_crown;
	private final AdvancedModelPart left_crown2;
	private final AdvancedModelPart snake;
	private final AdvancedModelPart upper_crown;
	private final AdvancedModelPart desert_necklace;
	private final AdvancedModelPart chain1;
	private final AdvancedModelPart chain2;
	private final AdvancedModelPart chain3;
	private final AdvancedModelPart chain4;
	private final AdvancedModelPart chain5;
	private final AdvancedModelPart desert_eye;
	private final AdvancedModelPart eye;
	private final AdvancedModelPart left_arm;
	private final AdvancedModelPart left_front_arm;
	private final AdvancedModelPart left_hand;
	private final AdvancedModelPart left_finger3;
	private final AdvancedModelPart left_finger1;
	private final AdvancedModelPart left_finger2;
	private final AdvancedModelPart right_arm;
	private final AdvancedModelPart right_front_arm;
	private final AdvancedModelPart right_hand;
	private final AdvancedModelPart right_finger1;
	private final AdvancedModelPart right_finger2;
	private final AdvancedModelPart right_finger3;
	private final AdvancedModelPart spine_deco;
	private final AdvancedModelPart legs;
	private final AdvancedModelPart left_leg;
	private final AdvancedModelPart left_deco1;
	private final AdvancedModelPart left_front_leg;
	private final AdvancedModelPart left_ankel_joint;
	private final AdvancedModelPart left_mini_bone;
	private final AdvancedModelPart left_deco2;
	private final AdvancedModelPart left_deco3;
	private final AdvancedModelPart left_ankel;
	private final AdvancedModelPart left_foot;
	private final AdvancedModelPart left_toe;
	private final AdvancedModelPart left_toe2;
	private final AdvancedModelPart left_toe3;
	private final AdvancedModelPart right_leg;
	private final AdvancedModelPart right_deco1;
	private final AdvancedModelPart right_front_leg;
	private final AdvancedModelPart right_ankel_joint;
	private final AdvancedModelPart right_mini_bone;
	private final AdvancedModelPart right_deco2;
	private final AdvancedModelPart right_deco3;
	private final AdvancedModelPart right_ankel;
	private final AdvancedModelPart right_foot;
	private final AdvancedModelPart right_toe;
	private final AdvancedModelPart right_toe2;
	private final AdvancedModelPart right_toe3;
	private ModelAnimator animator;

	public ModelAncient_Remnant() {
		texWidth = 512;
		texHeight = 512;

		root = new AdvancedModelPart(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		mid_pivot = new AdvancedModelPart(this);
		mid_pivot.setRotationPoint(0.0F, -69.0F, -10.0F);
		root.addChild(mid_pivot);


		pelvis = new AdvancedModelPart(this);
		pelvis.setRotationPoint(0.0F, 0.0F, 2.0F);
		mid_pivot.addChild(pelvis);
		setRotationAngle(pelvis, -0.2182F, 0.0F, 0.0F);
		pelvis.setTextureOffset(111, 42).addBox(-5.0F, -4.2211F, -9.2432F, 10.0F, 12.0F, 24.0F, 0.0F, false);

		left_long_bone = new AdvancedModelPart(this);
		left_long_bone.setRotationPoint(6.5F, -0.2211F, -8.2432F);
		pelvis.addChild(left_long_bone);
		setRotationAngle(left_long_bone, -0.4185F, 0.1274F, 0.2783F);
		left_long_bone.setTextureOffset(50, 0).addBox(0.0F, -4.0F, 6.0F, 5.0F, 28.0F, 7.0F, 0.0F, false);

		right_long_bone = new AdvancedModelPart(this);
		right_long_bone.setRotationPoint(-6.5F, -0.2211F, -8.2432F);
		pelvis.addChild(right_long_bone);
		setRotationAngle(right_long_bone, -0.4185F, -0.1274F, -0.2783F);
		right_long_bone.setTextureOffset(50, 0).addBox(-5.0F, -4.0F, 6.0F, 5.0F, 28.0F, 7.0F, 0.0F, true);

		spine_sail2 = new AdvancedModelPart(this);
		spine_sail2.setRotationPoint(0.0F, -0.2211F, 12.7568F);
		pelvis.addChild(spine_sail2);
		setRotationAngle(spine_sail2, 0.1745F, 0.0F, 0.0F);
		spine_sail2.setTextureOffset(65, 50).addBox(0.0F, -28.916F, -25.98F, 0.0F, 30.0F, 32.0F, 0.01F, false);

		left_bone = new AdvancedModelPart(this);
		left_bone.setRotationPoint(3.5F, -0.2211F, -8.2432F);
		pelvis.addChild(left_bone);
		setRotationAngle(left_bone, 0.7811F, -0.0924F, 0.0928F);
		left_bone.setTextureOffset(194, 215).addBox(1.0F, 3.0F, 0.0F, 7.0F, 33.0F, 7.0F, 0.0F, false);

		right_bone = new AdvancedModelPart(this);
		right_bone.setRotationPoint(-3.5F, -0.2211F, -8.2432F);
		pelvis.addChild(right_bone);
		setRotationAngle(right_bone, 0.7811F, 0.0924F, -0.0928F);
		right_bone.setTextureOffset(194, 215).addBox(-8.0F, 3.0F, 0.0F, 7.0F, 33.0F, 7.0F, 0.0F, true);

		left_big_bone = new AdvancedModelPart(this);
		left_big_bone.setRotationPoint(0.0F, -0.2211F, -8.2432F);
		pelvis.addChild(left_big_bone);
		setRotationAngle(left_big_bone, 0.3186F, 0.1451F, -0.413F);
		left_big_bone.setTextureOffset(112, 124).addBox(1.0F, -2.0F, -1.0F, 9.0F, 14.0F, 27.0F, 0.0F, false);

		right_big_bone = new AdvancedModelPart(this);
		right_big_bone.setRotationPoint(0.0F, -0.2211F, -8.2432F);
		pelvis.addChild(right_big_bone);
		setRotationAngle(right_big_bone, 0.3186F, -0.1451F, 0.413F);
		right_big_bone.setTextureOffset(112, 124).addBox(-10.0F, -2.0F, -1.0F, 9.0F, 14.0F, 27.0F, 0.0F, true);

		tail1 = new AdvancedModelPart(this);
		tail1.setRotationPoint(0.0F, 6.7789F, 10.7568F);
		pelvis.addChild(tail1);
		setRotationAngle(tail1, 0.0436F, 0.0F, 0.0F);
		tail1.setTextureOffset(98, 81).addBox(-4.0F, -5.916F, 1.02F, 8.0F, 10.0F, 32.0F, 0.0F, false);
		tail1.setTextureOffset(47, 117).addBox(0.0F, -24.916F, -0.98F, 0.0F, 19.0F, 32.0F, 0.0F, false);
		tail1.setTextureOffset(114, 197).addBox(0.0F, 4.084F, 6.02F, 0.0F, 6.0F, 25.0F, 0.0F, false);

		tail2 = new AdvancedModelPart(this);
		tail2.setRotationPoint(0.0F, -2.8F, 32.0F);
		tail1.addChild(tail2);
		setRotationAngle(tail2, 0.0873F, 0.0F, 0.0F);
		tail2.setTextureOffset(0, 109).addBox(-3.5F, -3.7067F, -0.3098F, 7.0F, 7.0F, 32.0F, 0.0F, false);
		tail2.setTextureOffset(148, 47).addBox(0.0F, 3.2933F, -0.3098F, 0.0F, 4.0F, 32.0F, 0.0F, false);
		tail2.setTextureOffset(0, 149).addBox(0.0F, -6.7067F, -0.3098F, 0.0F, 3.0F, 32.0F, 0.0F, false);

		tail3 = new AdvancedModelPart(this);
		tail3.setRotationPoint(0.0F, -1.5762F, 31.5254F);
		tail2.addChild(tail3);
		setRotationAngle(tail3, -0.0436F, 0.0F, 0.0F);
		tail3.setTextureOffset(0, 0).addBox(-3.0F, -2.7686F, -0.1825F, 6.0F, 6.0F, 37.0F, 0.0F, false);
		tail3.setTextureOffset(156, 13).addBox(0.0F, -6.7686F, -0.1825F, 0.0F, 4.0F, 29.0F, 0.0F, false);
		tail3.setTextureOffset(28, 198).addBox(0.0F, 3.2314F, -0.1825F, 0.0F, 4.0F, 25.0F, 0.0F, false);

		tail4 = new AdvancedModelPart(this);
		tail4.setRotationPoint(0.5F, 1.3649F, 34.6065F);
		tail3.addChild(tail4);
		setRotationAngle(tail4, -0.2618F, 0.0F, 0.0F);
		tail4.setTextureOffset(50, 7).addBox(-3.0F, -2.8005F, 0.2055F, 5.0F, 5.0F, 37.0F, 0.0F, false);

		spine1 = new AdvancedModelPart(this);
		spine1.setRotationPoint(0.0F, 5.0F, -5.0F);
		pelvis.addChild(spine1);
		spine1.setTextureOffset(162, 143).addBox(-4.5F, -5.0F, -19.0F, 9.0F, 8.0F, 23.0F, 0.0F, false);
		spine1.setTextureOffset(0, 185).addBox(3.0F, -3.0F, -19.0F, 11.0F, 18.0F, 15.0F, 0.0F, false);
		spine1.setTextureOffset(145, 175).addBox(-14.0F, -3.0F, -19.0F, 11.0F, 18.0F, 15.0F, 0.0F, false);

		spine2 = new AdvancedModelPart(this);
		spine2.setRotationPoint(0.0F, 0.0F, -19.0F);
		spine1.addChild(spine2);
		setRotationAngle(spine2, 0.3491F, 0.0F, 0.0F);
		spine2.setTextureOffset(158, 101).addBox(-4.5F, -5.0F, -23.0F, 9.0F, 8.0F, 23.0F, 0.0F, false);
		spine2.setTextureOffset(200, 73).addBox(3.0F, -3.0F, -18.0F, 10.0F, 16.0F, 15.0F, 0.0F, false);
		spine2.setTextureOffset(88, 190).addBox(-13.0F, -3.0F, -18.0F, 10.0F, 16.0F, 15.0F, 0.0F, false);
		spine2.setTextureOffset(128, 229).addBox(1.8F, -7.1199F, -17.5887F, 4.0F, 5.0F, 13.0F, 0.0F, false);
		spine2.setTextureOffset(93, 229).addBox(-5.8F, -7.1199F, -17.5887F, 4.0F, 5.0F, 13.0F, 0.0F, false);

		spine_sail1 = new AdvancedModelPart(this);
		spine_sail1.setRotationPoint(0.0F, -5.2211F, 36.7568F);
		spine2.addChild(spine_sail1);
		setRotationAngle(spine_sail1, -0.0436F, 0.0F, 0.0F);
		spine_sail1.setTextureOffset(0, 44).addBox(0.0F, -18.916F, -52.98F, 0.0F, 32.0F, 32.0F, 0.0F, false);

		right_shoulder = new AdvancedModelPart(this);
		right_shoulder.setRotationPoint(0.0F, 0.0F, 0.0F);
		spine2.addChild(right_shoulder);
		setRotationAngle(right_shoulder, 0.5314F, -0.5844F, -0.3136F);
		right_shoulder.setTextureOffset(176, 187).addBox(-23.0F, -3.0F, -17.0F, 5.0F, 5.0F, 22.0F, 0.0F, true);

		left_shoulder = new AdvancedModelPart(this);
		left_shoulder.setRotationPoint(0.0F, 0.0F, 0.0F);
		spine2.addChild(left_shoulder);
		setRotationAngle(left_shoulder, 0.5314F, 0.5844F, 0.3136F);
		left_shoulder.setTextureOffset(176, 187).addBox(18.0F, -3.0F, -17.0F, 5.0F, 5.0F, 22.0F, 0.0F, false);

		neck1 = new AdvancedModelPart(this);
		neck1.setRotationPoint(-0.5F, -1.0F, -20.0F);
		spine2.addChild(neck1);
		setRotationAngle(neck1, -0.4363F, 0.0F, 0.0F);
		neck1.setTextureOffset(204, 137).addBox(-3.5F, -4.0937F, -15.5774F, 8.0F, 9.0F, 16.0F, 0.0F, false);
		neck1.setTextureOffset(186, 0).addBox(-3.5F, -4.0937F, -17.5774F, 8.0F, 18.0F, 16.0F, 0.7F, false);
		neck1.setTextureOffset(235, 0).addBox(0.5F, -10.0937F, -15.5774F, 0.0F, 6.0F, 12.0F, 0.0F, false);

		neck2 = new AdvancedModelPart(this);
		neck2.setRotationPoint(0.0F, -0.0937F, -17.5774F);
		neck1.addChild(neck2);
		setRotationAngle(neck2, 0.0873F, 0.0F, 0.0F);
		neck2.setTextureOffset(217, 35).addBox(-3.0F, -4.0038F, -10.0872F, 7.0F, 8.0F, 13.0F, 0.0F, false);
		neck2.setTextureOffset(33, 157).addBox(0.5F, -10.0038F, -10.0872F, 0.0F, 6.0F, 12.0F, 0.0F, false);

		head = new AdvancedModelPart(this);
		head.setRotationPoint(0.0F, -1.0F, -8.0F);
		neck2.addChild(head);
		setRotationAngle(head, 0.3054F, 0.0F, 0.0F);
		head.setTextureOffset(80, 124).addBox(-6.0F, -10.0F, -14.0F, 13.0F, 10.0F, 14.0F, 0.0F, false);
		head.setTextureOffset(209, 175).addBox(-6.0F, -9.0F, -14.0F, 13.0F, 2.0F, 14.0F, 0.5F, false);
		head.setTextureOffset(44, 169).addBox(-3.5F, -7.0F, -35.0F, 8.0F, 7.0F, 21.0F, 0.0F, false);
		head.setTextureOffset(0, 222).addBox(-3.5F, -7.0F, -20.0F, 8.0F, 32.0F, 6.0F, 0.5F, false);
		head.setTextureOffset(33, 50).addBox(-3.5F, 0.0F, -35.0F, 8.0F, 4.0F, 21.0F, 0.0F, false);

		jaw = new AdvancedModelPart(this);
		jaw.setRotationPoint(0.0F, 2.0F, -7.0F);
		head.addChild(jaw);
		jaw.setTextureOffset(29, 228).addBox(-4.0F, -2.0F, -6.0F, 9.0F, 7.0F, 11.0F, 0.0F, false);
		jaw.setTextureOffset(181, 47).addBox(-3.0F, 0.0F, -27.0F, 7.0F, 4.0F, 21.0F, 0.0F, false);
		jaw.setTextureOffset(216, 198).addBox(-3.0F, 4.0F, -27.0F, 7.0F, 2.0F, 17.0F, 0.0F, false);
		jaw.setTextureOffset(202, 112).addBox(-2.5F, -3.0F, -27.0F, 6.0F, 3.0F, 21.0F, 0.0F, false);

		crown = new AdvancedModelPart(this);
		crown.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(crown);


		under_crown = new AdvancedModelPart(this);
		under_crown.setRotationPoint(0.5F, -7.9063F, 1.5774F);
		crown.addChild(under_crown);
		setRotationAngle(under_crown, -0.3054F, 0.0F, 0.0F);
		under_crown.setTextureOffset(223, 218).addBox(-7.5F, 0.0F, -4.0F, 15.0F, 17.0F, 4.0F, 0.0F, false);

		right_crown1 = new AdvancedModelPart(this);
		right_crown1.setRotationPoint(12.5F, 2.0F, -7.0F);
		under_crown.addChild(right_crown1);
		right_crown1.setTextureOffset(13, 149).addBox(-5.0F, -2.0F, 0.0F, 6.0F, 8.0F, 3.0F, 0.0F, false);
		right_crown1.setTextureOffset(23, 0).addBox(-5.0F, -4.0F, 1.5F, 4.0F, 2.0F, 0.0F, 0.0F, false);
		right_crown1.setTextureOffset(29, 19).addBox(1.0F, 0.0F, 1.5F, 2.0F, 6.0F, 0.0F, 0.0F, false);
		right_crown1.setTextureOffset(158, 133).addBox(-5.0F, 6.0F, 0.0F, 9.0F, 9.0F, 3.0F, 0.0F, false);
		right_crown1.setTextureOffset(80, 113).addBox(-5.0F, 15.0F, 0.0F, 5.0F, 4.0F, 3.0F, 0.0F, false);
		right_crown1.setTextureOffset(0, 0).addBox(0.0F, 15.0F, 1.5F, 2.0F, 3.0F, 0.0F, 0.0F, false);

		right_crown2 = new AdvancedModelPart(this);
		right_crown2.setRotationPoint(-3.5F, 19.0F, 3.0F);
		right_crown1.addChild(right_crown2);
		setRotationAngle(right_crown2, -0.2618F, 0.0F, 0.0F);
		right_crown2.setTextureOffset(84, 50).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		left_crown = new AdvancedModelPart(this);
		left_crown.setRotationPoint(-12.5F, 2.0F, -7.0F);
		under_crown.addChild(left_crown);
		left_crown.setTextureOffset(13, 149).addBox(-1.0F, -2.0F, 0.0F, 6.0F, 8.0F, 3.0F, 0.0F, true);
		left_crown.setTextureOffset(23, 0).addBox(1.0F, -4.0F, 1.5F, 4.0F, 2.0F, 0.0F, 0.0F, true);
		left_crown.setTextureOffset(29, 19).addBox(-3.0F, 0.0F, 1.5F, 2.0F, 6.0F, 0.0F, 0.0F, true);
		left_crown.setTextureOffset(158, 133).addBox(-4.0F, 6.0F, 0.0F, 9.0F, 9.0F, 3.0F, 0.0F, true);
		left_crown.setTextureOffset(80, 113).addBox(0.0F, 15.0F, 0.0F, 5.0F, 4.0F, 3.0F, 0.0F, true);
		left_crown.setTextureOffset(0, 0).addBox(-2.0F, 15.0F, 1.5F, 2.0F, 3.0F, 0.0F, 0.0F, true);

		left_crown2 = new AdvancedModelPart(this);
		left_crown2.setRotationPoint(3.5F, 19.0F, 3.0F);
		left_crown.addChild(left_crown2);
		setRotationAngle(left_crown2, -0.2618F, 0.0F, 0.0F);
		left_crown2.setTextureOffset(84, 50).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, 0.0F, true);

		snake = new AdvancedModelPart(this);
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

		upper_crown = new AdvancedModelPart(this);
		upper_crown.setRotationPoint(0.0F, -7.9063F, 1.5774F);
		crown.addChild(upper_crown);
		setRotationAngle(upper_crown, -0.1309F, 0.0F, 0.0F);
		upper_crown.setTextureOffset(95, 166).addBox(-7.0F, -6.0F, -17.0F, 15.0F, 6.0F, 17.0F, 0.01F, false);

		desert_necklace = new AdvancedModelPart(this);
		desert_necklace.setRotationPoint(0.5F, -4.9063F, -0.9226F);
		neck2.addChild(desert_necklace);
		setRotationAngle(desert_necklace, 0.2182F, 0.0F, 0.0F);
		desert_necklace.setTextureOffset(82, 169).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 4.0F, 3.0F, 0.0F, false);

		chain1 = new AdvancedModelPart(this);
		chain1.setRotationPoint(0.0F, 4.0F, 0.0F);
		desert_necklace.addChild(chain1);
		chain1.setTextureOffset(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, 0.0F, false);

		chain2 = new AdvancedModelPart(this);
		chain2.setRotationPoint(0.0F, 5.0F, 0.0F);
		chain1.addChild(chain2);
		chain2.setTextureOffset(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, 0.0F, false);

		chain3 = new AdvancedModelPart(this);
		chain3.setRotationPoint(0.0F, 5.0F, 0.0F);
		chain2.addChild(chain3);
		chain3.setTextureOffset(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, 0.0F, false);

		chain4 = new AdvancedModelPart(this);
		chain4.setRotationPoint(0.0F, 5.0F, 0.0F);
		chain3.addChild(chain4);
		chain4.setTextureOffset(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, 0.0F, false);

		chain5 = new AdvancedModelPart(this);
		chain5.setRotationPoint(0.0F, 5.0F, 0.0F);
		chain4.addChild(chain5);
		chain5.setTextureOffset(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, 0.0F, false);

		desert_eye = new AdvancedModelPart(this);
		desert_eye.setRotationPoint(0.0F, 8.7811F, -0.2836F);
		chain5.addChild(desert_eye);
		desert_eye.setTextureOffset(167, 0).addBox(-12.0F, -7.1811F, 0.2836F, 11.0F, 11.0F, 0.0F, 0.0F, true);
		desert_eye.setTextureOffset(167, 0).addBox(1.0F, -7.1811F, 0.2836F, 11.0F, 11.0F, 0.0F, 0.0F, false);

		eye = new AdvancedModelPart(this);
		eye.setRotationPoint(0.0F, -0.7811F, 0.2836F);
		desert_eye.addChild(eye);
		setRotationAngle(eye, 0.0F, 0.0F, 0.7854F);
		eye.setTextureOffset(98, 50).addBox(-5.0F, -5.0F, -1.0F, 10.0F, 10.0F, 2.0F, 0.0F, false);

		left_arm = new AdvancedModelPart(this);
		left_arm.setRotationPoint(13.2F, 10.0F, -17.0F);
		spine2.addChild(left_arm);
		setRotationAngle(left_arm, 0.3491F, 0.0F, 0.0F);
		left_arm.setTextureOffset(47, 109).addBox(-6.0F, -4.0637F, -3.0436F, 6.0F, 20.0F, 5.0F, 0.0F, false);
		left_arm.setTextureOffset(0, 109).addBox(-6.0F, -4.0637F, -3.0436F, 6.0F, 20.0F, 5.0F, 0.5F, false);

		left_front_arm = new AdvancedModelPart(this);
		left_front_arm.setRotationPoint(-4.0F, 15.2977F, -1.9036F);
		left_arm.addChild(left_front_arm);
		setRotationAngle(left_front_arm, -0.829F, 0.0F, 0.0F);
		left_front_arm.setTextureOffset(156, 47).addBox(-3.0F, -0.1465F, -2.2077F, 6.0F, 11.0F, 5.0F, 0.0F, false);
		left_front_arm.setTextureOffset(0, 169).addBox(-3.0F, 2.8535F, -2.2077F, 6.0F, 5.0F, 5.0F, 0.5F, false);

		left_hand = new AdvancedModelPart(this);
		left_hand.setRotationPoint(1.0F, 10.1551F, -0.5133F);
		left_front_arm.addChild(left_hand);
		setRotationAngle(left_hand, 1.6144F, 0.0F, 0.0F);


		left_finger3 = new AdvancedModelPart(this);
		left_finger3.setRotationPoint(1.0F, 0.0049F, 0.3079F);
		left_hand.addChild(left_finger3);
		setRotationAngle(left_finger3, -0.7216F, -0.2324F, 0.2F);
		left_finger3.setTextureOffset(0, 149).addBox(-0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, 0.0F, false);

		left_finger1 = new AdvancedModelPart(this);
		left_finger1.setRotationPoint(-3.0F, 0.0049F, 0.3079F);
		left_hand.addChild(left_finger1);
		setRotationAngle(left_finger1, -0.7216F, 0.2324F, -0.2F);
		left_finger1.setTextureOffset(147, 84).addBox(0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, 0.0F, false);

		left_finger2 = new AdvancedModelPart(this);
		left_finger2.setRotationPoint(-1.0F, 0.0049F, 0.3079F);
		left_hand.addChild(left_finger2);
		setRotationAngle(left_finger2, -0.7258F, 0.0F, 0.0F);
		left_finger2.setTextureOffset(0, 149).addBox(-0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, 0.0F, false);

		right_arm = new AdvancedModelPart(this);
		right_arm.setRotationPoint(-13.2F, 10.0F, -17.0F);
		spine2.addChild(right_arm);
		setRotationAngle(right_arm, 0.3491F, 0.0F, 0.0F);
		right_arm.setTextureOffset(47, 109).addBox(0.0F, -4.0637F, -3.0436F, 6.0F, 20.0F, 5.0F, 0.0F, true);

		right_front_arm = new AdvancedModelPart(this);
		right_front_arm.setRotationPoint(4.0F, 15.2977F, -1.9036F);
		right_arm.addChild(right_front_arm);
		setRotationAngle(right_front_arm, -0.829F, 0.0F, 0.0F);
		right_front_arm.setTextureOffset(156, 47).addBox(-3.0F, -0.1465F, -2.2077F, 6.0F, 11.0F, 5.0F, 0.0F, true);
		right_front_arm.setTextureOffset(0, 169).addBox(-3.0F, 2.8535F, -2.2077F, 6.0F, 5.0F, 5.0F, 0.5F, true);

		right_hand = new AdvancedModelPart(this);
		right_hand.setRotationPoint(-1.0F, 10.1551F, -0.5133F);
		right_front_arm.addChild(right_hand);
		setRotationAngle(right_hand, 1.6144F, 0.0F, 0.0F);


		right_finger1 = new AdvancedModelPart(this);
		right_finger1.setRotationPoint(-1.0F, 0.0049F, 0.3079F);
		right_hand.addChild(right_finger1);
		setRotationAngle(right_finger1, -0.7216F, 0.2324F, -0.2F);
		right_finger1.setTextureOffset(0, 149).addBox(0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, 0.0F, true);

		right_finger2 = new AdvancedModelPart(this);
		right_finger2.setRotationPoint(1.0F, 0.0049F, 0.3079F);
		right_hand.addChild(right_finger2);
		setRotationAngle(right_finger2, -0.7258F, 0.0F, 0.0F);
		right_finger2.setTextureOffset(0, 149).addBox(0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, 0.0F, true);

		right_finger3 = new AdvancedModelPart(this);
		right_finger3.setRotationPoint(3.0F, 0.0049F, 0.3079F);
		right_hand.addChild(right_finger3);
		setRotationAngle(right_finger3, -0.7216F, -0.2324F, 0.2F);
		right_finger3.setTextureOffset(147, 84).addBox(-0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, 0.0F, true);

		spine_deco = new AdvancedModelPart(this);
		spine_deco.setRotationPoint(0.0F, -7.3F, -6.7F);
		spine2.addChild(spine_deco);
		setRotationAngle(spine_deco, -0.1309F, 0.0F, 0.0F);
		spine_deco.setTextureOffset(98, 0).addBox(-13.2F, 0.0F, -16.5F, 26.0F, 25.0F, 16.0F, 0.5F, false);

		legs = new AdvancedModelPart(this);
		legs.setRotationPoint(0.0F, 4.0F, 7.0F);
		mid_pivot.addChild(legs);


		left_leg = new AdvancedModelPart(this);
		left_leg.setRotationPoint(15.0F, 0.0F, 6.0F);
		legs.addChild(left_leg);
		setRotationAngle(left_leg, -0.3927F, 0.0F, 0.0F);
		left_leg.setTextureOffset(165, 215).addBox(-6.0F, -2.0261F, -4.1809F, 8.0F, 34.0F, 6.0F, 0.0F, false);

		left_deco1 = new AdvancedModelPart(this);
		left_deco1.setRotationPoint(2.0F, 10.9739F, -8.1809F);
		left_leg.addChild(left_deco1);
		setRotationAngle(left_deco1, 0.0959F, -0.4349F, -0.0329F);
		left_deco1.setTextureOffset(0, 0).addBox(-3.0F, -8.0F, 1.0F, 8.0F, 28.0F, 6.0F, 0.0F, false);

		left_front_leg = new AdvancedModelPart(this);
		left_front_leg.setRotationPoint(-2.0F, 32.9739F, -2.1809F);
		left_leg.addChild(left_front_leg);
		setRotationAngle(left_front_leg, 1.0908F, 0.0F, 0.0F);
		left_front_leg.setTextureOffset(0, 44).addBox(-5.0F, -2.5649F, -1.6913F, 8.0F, 24.0F, 5.0F, 0.0F, false);

		left_ankel_joint = new AdvancedModelPart(this);
		left_ankel_joint.setRotationPoint(-1.0F, 20.6148F, 1.661F);
		left_front_leg.addChild(left_ankel_joint);


		left_mini_bone = new AdvancedModelPart(this);
		left_mini_bone.setRotationPoint(-1.0F, 11.0F, -6.0F);
		left_ankel_joint.addChild(left_mini_bone);
		setRotationAngle(left_mini_bone, -0.3928F, -0.0035F, 0.0001F);
		left_mini_bone.setTextureOffset(29, 0).addBox(0.0209F, -3.1113F, 0.0913F, 0.0F, 6.0F, 3.0F, 0.0F, false);

		left_deco2 = new AdvancedModelPart(this);
		left_deco2.setRotationPoint(0.0F, 6.0F, -4.9602F);
		left_ankel_joint.addChild(left_deco2);
		setRotationAngle(left_deco2, 0.5236F, 0.0F, 0.0F);
		left_deco2.setTextureOffset(61, 210).addBox(-2.0F, -2.7487F, 0.1981F, 4.0F, 6.0F, 18.0F, 0.0F, false);

		left_deco3 = new AdvancedModelPart(this);
		left_deco3.setRotationPoint(-2.0F, 9.0F, -7.0F);
		left_ankel_joint.addChild(left_deco3);
		setRotationAngle(left_deco3, -0.3927F, 0.0F, 0.0F);
		left_deco3.setTextureOffset(33, 45).addBox(-0.2F, -11.7017F, -4.0722F, 4.0F, 13.0F, 5.0F, 0.0F, false);

		left_ankel = new AdvancedModelPart(this);
		left_ankel.setRotationPoint(0.0F, -1.0F, 0.0F);
		left_ankel_joint.addChild(left_ankel);
		setRotationAngle(left_ankel, -0.5672F, 0.0F, 0.0F);
		left_ankel.setTextureOffset(54, 198).addBox(-3.0F, -0.2489F, -2.0393F, 6.0F, 15.0F, 5.0F, 0.0F, false);

		left_foot = new AdvancedModelPart(this);
		left_foot.setRotationPoint(0.0F, 12.0F, -8.0F);
		left_ankel_joint.addChild(left_foot);


		left_toe = new AdvancedModelPart(this);
		left_toe.setRotationPoint(0.0F, -1.8218F, -0.2377F);
		left_foot.addChild(left_toe);
		setRotationAngle(left_toe, -0.6981F, 0.0F, 0.0F);
		left_toe.setTextureOffset(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, 0.0F, false);

		left_toe2 = new AdvancedModelPart(this);
		left_toe2.setRotationPoint(-2.0F, -1.8218F, -0.2377F);
		left_foot.addChild(left_toe2);
		setRotationAngle(left_toe2, -0.7216F, 0.2324F, -0.2F);
		left_toe2.setTextureOffset(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, 0.0F, false);

		left_toe3 = new AdvancedModelPart(this);
		left_toe3.setRotationPoint(2.0F, -1.8218F, -0.2377F);
		left_foot.addChild(left_toe3);
		setRotationAngle(left_toe3, -0.7216F, -0.2324F, 0.2F);
		left_toe3.setTextureOffset(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, 0.0F, false);

		right_leg = new AdvancedModelPart(this);
		right_leg.setRotationPoint(-15.0F, 0.0F, 6.0F);
		legs.addChild(right_leg);
		setRotationAngle(right_leg, -0.3927F, 0.0F, 0.0F);
		right_leg.setTextureOffset(165, 215).addBox(-2.0F, -2.0261F, -4.1809F, 8.0F, 34.0F, 6.0F, 0.0F, true);

		right_deco1 = new AdvancedModelPart(this);
		right_deco1.setRotationPoint(-2.0F, 10.9739F, -8.1809F);
		right_leg.addChild(right_deco1);
		setRotationAngle(right_deco1, 0.0959F, 0.4349F, 0.0329F);
		right_deco1.setTextureOffset(0, 0).addBox(-5.0F, -8.0F, 1.0F, 8.0F, 28.0F, 6.0F, 0.0F, true);

		right_front_leg = new AdvancedModelPart(this);
		right_front_leg.setRotationPoint(2.0F, 32.9739F, -2.1809F);
		right_leg.addChild(right_front_leg);
		setRotationAngle(right_front_leg, 1.0908F, 0.0F, 0.0F);
		right_front_leg.setTextureOffset(0, 44).addBox(-3.0F, -2.5649F, -1.6913F, 8.0F, 24.0F, 5.0F, 0.0F, true);

		right_ankel_joint = new AdvancedModelPart(this);
		right_ankel_joint.setRotationPoint(1.0F, 20.6148F, 1.661F);
		right_front_leg.addChild(right_ankel_joint);


		right_mini_bone = new AdvancedModelPart(this);
		right_mini_bone.setRotationPoint(1.0F, 11.0F, -6.0F);
		right_ankel_joint.addChild(right_mini_bone);
		setRotationAngle(right_mini_bone, -0.3928F, 0.0035F, -0.0001F);
		right_mini_bone.setTextureOffset(29, 0).addBox(-0.0209F, -3.1113F, 0.0913F, 0.0F, 6.0F, 3.0F, 0.0F, true);

		right_deco2 = new AdvancedModelPart(this);
		right_deco2.setRotationPoint(0.0F, 6.0F, -4.9602F);
		right_ankel_joint.addChild(right_deco2);
		setRotationAngle(right_deco2, 0.5236F, 0.0F, 0.0F);
		right_deco2.setTextureOffset(61, 210).addBox(-2.0F, -2.7487F, 0.1981F, 4.0F, 6.0F, 18.0F, 0.0F, true);

		right_deco3 = new AdvancedModelPart(this);
		right_deco3.setRotationPoint(2.0F, 9.0F, -7.0F);
		right_ankel_joint.addChild(right_deco3);
		setRotationAngle(right_deco3, -0.3927F, 0.0F, 0.0F);
		right_deco3.setTextureOffset(33, 45).addBox(-3.8F, -11.7017F, -4.0722F, 4.0F, 13.0F, 5.0F, 0.0F, true);

		right_ankel = new AdvancedModelPart(this);
		right_ankel.setRotationPoint(0.0F, -1.0F, 0.0F);
		right_ankel_joint.addChild(right_ankel);
		setRotationAngle(right_ankel, -0.5672F, 0.0F, 0.0F);
		right_ankel.setTextureOffset(54, 198).addBox(-3.0F, -0.2489F, -2.0393F, 6.0F, 15.0F, 5.0F, 0.0F, true);

		right_foot = new AdvancedModelPart(this);
		right_foot.setRotationPoint(0.0F, 12.0F, -8.0F);
		right_ankel_joint.addChild(right_foot);


		right_toe = new AdvancedModelPart(this);
		right_toe.setRotationPoint(0.0F, -1.8218F, -0.2377F);
		right_foot.addChild(right_toe);
		setRotationAngle(right_toe, -0.6981F, 0.0F, 0.0F);
		right_toe.setTextureOffset(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, 0.0F, true);

		right_toe2 = new AdvancedModelPart(this);
		right_toe2.setRotationPoint(2.0F, -1.8218F, -0.2377F);
		right_foot.addChild(right_toe2);
		setRotationAngle(right_toe2, -0.7216F, -0.2324F, 0.2F);
		right_toe2.setTextureOffset(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, 0.0F, true);

		right_toe3 = new AdvancedModelPart(this);
		right_toe3.setRotationPoint(-2.0F, -1.8218F, -0.2377F);
		right_foot.addChild(right_toe3);
		setRotationAngle(right_toe3, -0.7216F, 0.2324F, -0.2F);
		right_toe3.setTextureOffset(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, 0.0F, true);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}


	@Override
	public Iterable<AdvancedModelPart> getAllParts() {
		return ImmutableList.of(
				root,mid_pivot,pelvis,tail1,tail2,tail3,tail4,spine1,spine2,neck1,neck2,head,jaw,left_arm,left_front_arm,left_hand,left_finger1,left_finger2,left_finger3,right_arm,right_hand,right_finger1,right_finger2,right_finger3,
				right_front_arm,legs,left_leg,left_front_leg,left_ankel,left_ankel_joint,left_foot,left_toe,left_toe2,left_toe3,right_leg,right_front_leg,right_ankel,right_ankel_joint,right_foot,right_toe,right_toe2,right_toe3,desert_necklace,chain1,chain2,chain3,chain4,chain5);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	public void animate(Ancient_Remnant_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_BITE1);
		animator.startKeyframe(15);
		animator.rotate(mid_pivot, (float) Math.toRadians(-2.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(2.5F));
		animator.move(mid_pivot, 0,0.5F, 2);
		animator.rotate(pelvis, (float) Math.toRadians(-22.5F),(float) Math.toRadians(17.5F), 0);
		animator.rotate(tail1, (float) Math.toRadians(5F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(10F),0, 0);
		animator.rotate(tail3, (float) Math.toRadians(17.5F),(float) Math.toRadians(-1.5F), (float) Math.toRadians(1.5F));
		animator.rotate(tail4, (float) Math.toRadians(25F),0, 0);
		animator.rotate(spine1, (float) Math.toRadians(5F),(float) Math.toRadians(15F), 0);
		animator.rotate(spine2, (float) Math.toRadians(15F),(float) Math.toRadians(22.5F), (float) Math.toRadians(10F));
		animator.rotate(neck1, (float) Math.toRadians(-7.5F),(float) Math.toRadians(7.5F), (float) Math.toRadians(-10F));
		animator.rotate(neck2, (float) Math.toRadians(-27.5F),(float) Math.toRadians(-32.5F), (float) Math.toRadians(5F));
		animator.rotate(head, (float) Math.toRadians(-22.5F),(float) Math.toRadians(-12.5F),0);
		animator.rotate(jaw, (float) Math.toRadians(87.5F),0,0);
		animator.rotate(right_leg, 0,0,(float) Math.toRadians(5F));
		animator.rotate(right_front_leg, 0,0,(float) Math.toRadians(-7.5F));
		animator.rotate(right_ankel_joint, (float) Math.toRadians(-7.5F),0,0);
		animator.rotate(right_foot, (float) Math.toRadians(10F),0,0);
		animator.move(left_leg, 0,-5F,-13F);
		animator.rotate(left_leg, 0,0,(float) Math.toRadians(-5F));
		animator.rotate(left_front_leg, (float) Math.toRadians(-22.5F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(7.5F),0,0);
		animator.rotate(left_foot, (float) Math.toRadians(15F),0,0);
		animator.endKeyframe();
		animator.setStaticKeyframe(10);

		animator.startKeyframe(4);
		animator.rotate(mid_pivot, (float) Math.toRadians(62.5F), (float) Math.toRadians(-60F), (float) Math.toRadians(-45F));
		animator.move(mid_pivot, 0, 17, 2);
		animator.rotate(pelvis, (float) Math.toRadians(-22.5F),(float) Math.toRadians(7.5F), (float) Math.toRadians(7.5F));
		animator.rotate(tail1, (float) Math.toRadians(15F),(float) Math.toRadians(-27.5F), (float) Math.toRadians(-2.5F));
		animator.rotate(tail2, (float) Math.toRadians(27.5F),(float) Math.toRadians(-37.5F), (float) Math.toRadians(-12.5F));
		animator.rotate(tail3, (float) Math.toRadians(32.5F),(float) Math.toRadians(-35F), (float) Math.toRadians(-7.5F));
		animator.rotate(tail4, (float) Math.toRadians(35F),(float) Math.toRadians(-30F), (float) Math.toRadians(-2.5F));
		animator.rotate(spine1, (float) Math.toRadians(17.5F),(float) Math.toRadians(-2.5F), (float) Math.toRadians(-5F));
		animator.rotate(spine2, (float) Math.toRadians(20F),(float) Math.toRadians(-20F), (float) Math.toRadians(-17.5F));
		animator.rotate(neck1, (float) Math.toRadians(5F),(float) Math.toRadians(-37.5F), (float) Math.toRadians(5F));
		animator.rotate(neck2, (float) Math.toRadians(37.5F),(float) Math.toRadians(-37.5F), (float) Math.toRadians(2.5F));
		animator.rotate(head, (float) Math.toRadians(-15F),(float) Math.toRadians(-47.5F),(float) Math.toRadians(2.5F));
		animator.rotate(jaw, (float) Math.toRadians(5F),0,0);
		animator.rotate(right_arm, (float) Math.toRadians(-7.5F),(float) Math.toRadians(-15F),(float) Math.toRadians(30F));
		animator.rotate(right_front_arm, (float) Math.toRadians(-70F),0,0);
		animator.rotate(right_hand, (float) Math.toRadians(72.5F),0,0);
		animator.rotate(left_arm, 0,0,(float) Math.toRadians(30F));
		animator.rotate(left_front_arm, (float) Math.toRadians(-17.5F),0,0);
		animator.rotate(left_hand, (float) Math.toRadians(70F),0,0);
		animator.move(right_leg, 0,1,2);
		animator.rotate(right_leg, (float) Math.toRadians(-52.5F),(float) Math.toRadians(10F),(float) Math.toRadians(27.5F));
		animator.rotate(right_front_leg, (float) Math.toRadians(47.5F),0,(float) Math.toRadians(-7.5F));
		animator.rotate(right_ankel_joint, (float) Math.toRadians(-22.5F),0,0);
		animator.rotate(right_foot, (float) Math.toRadians(5F),0,0);
		animator.move(left_leg, 0,-3F,0);
		animator.rotate(left_leg, (float) Math.toRadians(-45F),(float) Math.toRadians(-12.5F),(float) Math.toRadians(22.5F));
		animator.rotate(left_front_leg, (float) Math.toRadians(25F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-5F),0,0);
		animator.rotate(left_foot, (float) Math.toRadians(10F),0,(float) Math.toRadians(17.5F));
		animator.endKeyframe();
		animator.setStaticKeyframe(10);


		animator.startKeyframe(10);
		animator.rotate(mid_pivot, (float) Math.toRadians(27.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-20F));
		animator.move(mid_pivot, 0, 7, 2);
		animator.rotate(pelvis, (float) Math.toRadians(-10F),(float) Math.toRadians(2.5F), (float) Math.toRadians(5F));
		animator.rotate(tail1, (float) Math.toRadians(7.5F),(float) Math.toRadians(-12.5F), (float) Math.toRadians(-2.5F));
		animator.rotate(tail2, (float) Math.toRadians(12.5F),(float) Math.toRadians(-17.5F), (float) Math.toRadians(-5F));
		animator.rotate(tail3, (float) Math.toRadians(20F),(float) Math.toRadians(-15F), (float) Math.toRadians(-5F));
		animator.rotate(tail4, (float) Math.toRadians(27.5F),(float) Math.toRadians(-12.5F), (float) Math.toRadians(-2.5F));
		animator.rotate(spine1, (float) Math.toRadians(7.5F),0, (float) Math.toRadians(-2.5F));
		animator.rotate(spine2, (float) Math.toRadians(10F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(-7.5F));
		animator.rotate(neck1, 0,(float) Math.toRadians(-17.5F), (float) Math.toRadians(2.5F));
		animator.rotate(neck2, (float) Math.toRadians(15F),(float) Math.toRadians(-17.5F), 0);
		animator.rotate(head, (float) Math.toRadians(-7.5F),(float) Math.toRadians(-20F),0);
		animator.rotate(jaw, (float) Math.toRadians(2.5F),0,0);
		animator.rotate(right_arm, (float) Math.toRadians(-2.5F),(float) Math.toRadians(-5F),(float) Math.toRadians(12.5F));
		animator.rotate(right_front_arm, (float) Math.toRadians(-30F),0,0);
		animator.rotate(right_hand, (float) Math.toRadians(30F),0,0);
		animator.rotate(left_arm, 0,0,(float) Math.toRadians(12.5F));
		animator.rotate(left_front_arm, (float) Math.toRadians(-7.5F),0,0);
		animator.rotate(left_hand, (float) Math.toRadians(30F),0,0);
		animator.move(right_leg, 0,-5,1);
		animator.rotate(right_leg, (float) Math.toRadians(-55F),(float) Math.toRadians(10F),(float) Math.toRadians(15F));
		animator.rotate(right_front_leg, (float) Math.toRadians(57.5F),0,(float) Math.toRadians(-5F));
		animator.rotate(right_ankel_joint, (float) Math.toRadians(-25F),0,0);
		animator.rotate(right_foot, (float) Math.toRadians(37.5F),0,0);
		animator.move(left_leg, 0,4F,0);
		animator.rotate(left_leg, (float) Math.toRadians(-20F),(float) Math.toRadians(5F),(float) Math.toRadians(17.5F));
		animator.rotate(left_front_leg, (float) Math.toRadians(10F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-5F),0,0);
		animator.rotate(left_foot, (float) Math.toRadians(-5F),0,(float) Math.toRadians(7.5F));
		animator.endKeyframe();

		animator.resetKeyframe(12);

		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_BITE2);
		animator.startKeyframe(13);
		animator.rotate(mid_pivot, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(-2.5F));
		animator.move(mid_pivot, 0,0.5F, 2);
		animator.rotate(pelvis, (float) Math.toRadians(-22.5F),(float) Math.toRadians(-17.5F), 0);
		animator.rotate(tail1, (float) Math.toRadians(5F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(10F),0, 0);
		animator.rotate(tail3, (float) Math.toRadians(17.5F),(float) Math.toRadians(1.5F), (float) Math.toRadians(-1.5F));
		animator.rotate(tail4, (float) Math.toRadians(25F),0, 0);
		animator.rotate(spine1, (float) Math.toRadians(5F),(float) Math.toRadians(-15F), 0);
		animator.rotate(spine2, (float) Math.toRadians(15F),(float) Math.toRadians(-22.5F), (float) Math.toRadians(-10F));
		animator.rotate(neck1, (float) Math.toRadians(-7.5F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(10F));
		animator.rotate(neck2, (float) Math.toRadians(-27.5F),(float) Math.toRadians(32.5F), (float) Math.toRadians(-5F));
		animator.rotate(head, (float) Math.toRadians(-22.5F),(float) Math.toRadians(12.5F),0);
		animator.rotate(jaw, (float) Math.toRadians(87.5F),0,0);
		animator.rotate(left_leg, 0,0,(float) Math.toRadians(-5F));
		animator.rotate(left_front_leg, 0,0,(float) Math.toRadians(7.5F));
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-7.5F),0,0);
		animator.rotate(left_foot, (float) Math.toRadians(10F),0,0);
		animator.move(right_leg, 0,-5F,-13F);
		animator.rotate(right_leg, 0,0,(float) Math.toRadians(5F));
		animator.rotate(right_front_leg, (float) Math.toRadians(-22.5F),0,0);
		animator.rotate(right_ankel_joint, (float) Math.toRadians(7.5F),0,0);
		animator.rotate(right_foot, (float) Math.toRadians(15F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(8);

		animator.startKeyframe(4);
		animator.rotate(mid_pivot, (float) Math.toRadians(62.5F), (float) Math.toRadians(60F), (float) Math.toRadians(45F));
		animator.move(mid_pivot, 0, 17, 2);
		animator.rotate(pelvis, (float) Math.toRadians(-22.5F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(-7.5F));
		animator.rotate(tail1, (float) Math.toRadians(15F),(float) Math.toRadians(27.5F), (float) Math.toRadians(2.5F));
		animator.rotate(tail2, (float) Math.toRadians(27.5F),(float) Math.toRadians(37.5F), (float) Math.toRadians(12.5F));
		animator.rotate(tail3, (float) Math.toRadians(32.5F),(float) Math.toRadians(35F), (float) Math.toRadians(7.5F));
		animator.rotate(tail4, (float) Math.toRadians(35F),(float) Math.toRadians(30F), (float) Math.toRadians(2.5F));
		animator.rotate(spine1, (float) Math.toRadians(17.5F),(float) Math.toRadians(2.5F), (float) Math.toRadians(5F));
		animator.rotate(spine2, (float) Math.toRadians(20F),(float) Math.toRadians(20F), (float) Math.toRadians(17.5F));
		animator.rotate(neck1, (float) Math.toRadians(5F),(float) Math.toRadians(37.5F), (float) Math.toRadians(-5F));
		animator.rotate(neck2, (float) Math.toRadians(37.5F),(float) Math.toRadians(37.5F), (float) Math.toRadians(-2.5F));
		animator.rotate(head, (float) Math.toRadians(-15F),(float) Math.toRadians(47.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(jaw, (float) Math.toRadians(5F),0,0);
		animator.rotate(left_arm, (float) Math.toRadians(-7.5F),(float) Math.toRadians(15F),(float) Math.toRadians(-30F));
		animator.rotate(left_front_arm, (float) Math.toRadians(-70F),0,0);
		animator.rotate(left_hand, (float) Math.toRadians(72.5F),0,0);
		animator.rotate(right_arm, 0,0,(float) Math.toRadians(-30F));
		animator.rotate(right_front_arm, (float) Math.toRadians(-17.5F),0,0);
		animator.rotate(right_hand, (float) Math.toRadians(70F),0,0);
		animator.move(left_leg, 0,1,2);
		animator.rotate(left_leg, (float) Math.toRadians(-52.5F),(float) Math.toRadians(-10F),(float) Math.toRadians(-27.5F));
		animator.rotate(left_front_leg, (float) Math.toRadians(47.5F),0,(float) Math.toRadians(7.5F));
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-22.5F),0,0);
		animator.rotate(left_foot, (float) Math.toRadians(5F),0,0);
		animator.move(right_leg, 0,-3F,0);
		animator.rotate(right_leg, (float) Math.toRadians(-45F),(float) Math.toRadians(12.5F),(float) Math.toRadians(-22.5F));
		animator.rotate(right_front_leg, (float) Math.toRadians(25F),0,0);
		animator.rotate(right_ankel_joint, (float) Math.toRadians(-5F),0,0);
		animator.rotate(right_foot, (float) Math.toRadians(10F),0,(float) Math.toRadians(-17.5F));
		animator.endKeyframe();
		animator.setStaticKeyframe(10);


		animator.startKeyframe(10);
		animator.rotate(mid_pivot, (float) Math.toRadians(27.5F), (float) Math.toRadians(27.5F), (float) Math.toRadians(20F));
		animator.move(mid_pivot, 0, 7, 2);
		animator.rotate(pelvis, (float) Math.toRadians(-10F),(float) Math.toRadians(-2.5F), (float) Math.toRadians(-5F));
		animator.rotate(tail1, (float) Math.toRadians(7.5F),(float) Math.toRadians(12.5F), (float) Math.toRadians(2.5F));
		animator.rotate(tail2, (float) Math.toRadians(12.5F),(float) Math.toRadians(17.5F), (float) Math.toRadians(5F));
		animator.rotate(tail3, (float) Math.toRadians(20F),(float) Math.toRadians(15F), (float) Math.toRadians(5F));
		animator.rotate(tail4, (float) Math.toRadians(27.5F),(float) Math.toRadians(12.5F), (float) Math.toRadians(2.5F));
		animator.rotate(spine1, (float) Math.toRadians(7.5F),0, (float) Math.toRadians(2.5F));
		animator.rotate(spine2, (float) Math.toRadians(10F),(float) Math.toRadians(7.5F), (float) Math.toRadians(7.5F));
		animator.rotate(neck1, 0,(float) Math.toRadians(17.5F), (float) Math.toRadians(-2.5F));
		animator.rotate(neck2, (float) Math.toRadians(15F),(float) Math.toRadians(17.5F), 0);
		animator.rotate(head, (float) Math.toRadians(-7.5F),(float) Math.toRadians(20F),0);
		animator.rotate(jaw, (float) Math.toRadians(2.5F),0,0);
		animator.rotate(left_arm, (float) Math.toRadians(-2.5F),(float) Math.toRadians(5F),(float) Math.toRadians(-12.5F));
		animator.rotate(left_front_arm, (float) Math.toRadians(-30F),0,0);
		animator.rotate(left_hand, (float) Math.toRadians(30F),0,0);
		animator.rotate(right_arm, 0,0,(float) Math.toRadians(-12.5F));
		animator.rotate(right_front_arm, (float) Math.toRadians(-7.5F),0,0);
		animator.rotate(right_hand, (float) Math.toRadians(30F),0,0);
		animator.move(left_leg, 0,-5,1);
		animator.rotate(left_leg, (float) Math.toRadians(-55F),(float) Math.toRadians(-10F),(float) Math.toRadians(-15F));
		animator.rotate(left_front_leg, (float) Math.toRadians(57.5F),0,(float) Math.toRadians(5F));
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-25F),0,0);
		animator.rotate(left_foot, (float) Math.toRadians(37.5F),0,0);
		animator.move(right_leg, 0,4F,0);
		animator.rotate(right_leg, (float) Math.toRadians(-20F),(float) Math.toRadians(-5F),(float) Math.toRadians(-17.5F));
		animator.rotate(right_front_leg, (float) Math.toRadians(10F),0,0);
		animator.rotate(right_ankel_joint, (float) Math.toRadians(-5F),0,0);
		animator.rotate(right_foot, (float) Math.toRadians(-5F),0,(float) Math.toRadians(-7.5F));
		animator.endKeyframe();

		animator.resetKeyframe(12);

		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_CHARGE_PREPARE);
		animator.startKeyframe(13);
		animator.move(root, 0,5, 2.5F);
		animator.rotate(pelvis, (float) Math.toRadians(10F),(float) Math.toRadians(-5F), 0);
		animator.rotate(tail1, (float) Math.toRadians(-17.5F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(2.5F),(float) Math.toRadians(-5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(15F),(float) Math.toRadians(-5F), 0);
		animator.rotate(tail4, (float) Math.toRadians(25F),(float) Math.toRadians(-5F), 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(spine2, (float) Math.toRadians(2.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(neck1, (float) Math.toRadians(40F),0,0);
		animator.rotate(neck2, (float) Math.toRadians(-10F),0, 0);
		animator.rotate(head, (float) Math.toRadians(-40F),0,0);
		animator.rotate(jaw, (float) Math.toRadians(15F),0,0);
		animator.rotate(right_arm, (float) Math.toRadians(-15F),0,0);
		animator.rotate(right_front_arm, (float) Math.toRadians(-3.3F),0,0);
		animator.rotate(left_arm, (float) Math.toRadians(-15F),0,0);
		animator.rotate(left_front_arm, (float) Math.toRadians(3.3F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-47.5F),0,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(35F),0,0);
		animator.rotate(right_ankel_joint, (float) Math.toRadians(7.5F),0,0);
		animator.rotate(right_foot, (float) Math.toRadians(17.5F),0,0);
		animator.move(right_leg, 0,-4F,0);
		animator.rotate(left_leg, (float) Math.toRadians(-7.5F),0,0);
		animator.rotate(left_front_leg, (float) Math.toRadians(20F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-10F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(root, 0,7, 2);
		animator.rotate(pelvis, (float) Math.toRadians(10F),(float) Math.toRadians(-5F), 0);
		animator.rotate(tail1, (float) Math.toRadians(-17.5F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(2.5F),(float) Math.toRadians(-5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(15F),(float) Math.toRadians(-5F), 0);
		animator.rotate(tail4, (float) Math.toRadians(25F),(float) Math.toRadians(-5F), 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(spine2, (float) Math.toRadians(2.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(neck1, (float) Math.toRadians(37.5F),0,0);
		animator.rotate(neck2, (float) Math.toRadians(-10F),0, 0);
		animator.rotate(head, (float) Math.toRadians(-37.5F),0,0);
		animator.rotate(jaw, (float) Math.toRadians(17.5F),0,0);
		animator.rotate(right_arm, (float) Math.toRadians(-10F),0,0);
		animator.rotate(right_front_arm, (float) Math.toRadians(7.5F),0,0);
		animator.rotate(right_hand, (float) Math.toRadians(2.5F),0,0);
		animator.rotate(left_arm, (float) Math.toRadians(-10F),0,0);
		animator.rotate(left_front_arm, (float) Math.toRadians(7.5F),0,0);
		animator.rotate(left_hand, (float) Math.toRadians(2.5F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-10F),0,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(20F),0,0);
		animator.rotate(right_ankel_joint, (float) Math.toRadians(-52.5F),0,0);
		animator.rotate(right_foot, (float) Math.toRadians(42.5F),0,0);
		animator.move(right_leg, 0,1F,5f);
		animator.rotate(left_leg, (float) Math.toRadians(-7.5F),0,0);
		animator.rotate(left_front_leg, (float) Math.toRadians(25F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-12.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(root, 0,5, 2);
		animator.rotate(pelvis, (float) Math.toRadians(5F),(float) Math.toRadians(-3.5F), 0);
		animator.rotate(tail1, (float) Math.toRadians(-10F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(1.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(15F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(spine2, (float) Math.toRadians(2.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(neck1, (float) Math.toRadians(25F),0,0);
		animator.rotate(neck2, (float) Math.toRadians(-7.5F),0, 0);
		animator.rotate(head, (float) Math.toRadians(-25F),0,0);
		animator.rotate(jaw, (float) Math.toRadians(12.5F),0,0);
		animator.rotate(right_arm, (float) Math.toRadians(5F),0,0);
		animator.rotate(right_front_arm, (float) Math.toRadians(32.5F),0,0);
		animator.rotate(right_hand, (float) Math.toRadians(7.5F),0,0);
		animator.rotate(left_arm, (float) Math.toRadians(5F),0,0);
		animator.rotate(left_front_arm, (float) Math.toRadians(32.5F),0,0);
		animator.rotate(left_hand, (float) Math.toRadians(7.5F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-5F),0,0);
		animator.move(right_leg, 0,1F,6f);
		animator.rotate(right_front_leg,(float) Math.toRadians(5F),0,0);
		animator.rotate(right_ankel_joint, (float) Math.toRadians(-47.5F),0,0);
		animator.rotate(right_foot, (float) Math.toRadians(47.5F),0,0);
		animator.rotate(left_leg, (float) Math.toRadians(-2.5F),0,0);
		animator.rotate(left_front_leg, (float) Math.toRadians(15F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(10);
		animator.move(root, 0,0, 2);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(20F),0, 0);
		animator.endKeyframe();

		animator.startKeyframe(10);
		animator.move(root, 0,3, 3);
		animator.rotate(pelvis, (float) Math.toRadians(10F),(float) Math.toRadians(5F), 0);
		animator.rotate(tail1, (float) Math.toRadians(-17.5F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(2.5F),(float) Math.toRadians(5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(15F),(float) Math.toRadians(5F), 0);
		animator.rotate(tail4, (float) Math.toRadians(25F),(float) Math.toRadians(5F), 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(spine2, (float) Math.toRadians(2.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(neck1, (float) Math.toRadians(35F),0,0);
		animator.rotate(neck2, (float) Math.toRadians(-7.5F),0, 0);
		animator.rotate(head, (float) Math.toRadians(-35F),0,0);
		animator.rotate(jaw, (float) Math.toRadians(10F),0,0);
		animator.rotate(right_arm, (float) Math.toRadians(-17.5F),0,0);
		animator.rotate(right_front_arm, (float) Math.toRadians(-12.5F),0,0);
		animator.rotate(right_hand, (float) Math.toRadians(-2.5F),0,0);
		animator.rotate(left_arm, (float) Math.toRadians(-17.5F),0,0);
		animator.rotate(left_front_arm, (float) Math.toRadians(-12.5F),0,0);
		animator.rotate(left_hand, (float) Math.toRadians(-2.5F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-7.5F),0,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(left_leg, (float) Math.toRadians(-35F),0,0);
		animator.move(left_leg, 0,-3.5f,0);
		animator.rotate(left_front_leg, (float) Math.toRadians(42.5F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-12.5F),0,0);
		animator.rotate(left_foot, (float) Math.toRadians(12.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(root, 0,5, 3);
		animator.rotate(pelvis, (float) Math.toRadians(10F),(float) Math.toRadians(5F), 0);
		animator.rotate(tail1, (float) Math.toRadians(-17.5F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(2.5F),(float) Math.toRadians(5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(15F),(float) Math.toRadians(5F), 0);
		animator.rotate(tail4, (float) Math.toRadians(25F),(float) Math.toRadians(5F), 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(spine2, (float) Math.toRadians(2.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(neck1, (float) Math.toRadians(40F),0,0);
		animator.rotate(neck2, (float) Math.toRadians(-10F),0, 0);
		animator.rotate(head, (float) Math.toRadians(-40F),0,0);
		animator.rotate(jaw, (float) Math.toRadians(15F),0,0);
		animator.rotate(right_arm, (float) Math.toRadians(-15F),0,0);
		animator.rotate(right_front_arm, (float) Math.toRadians(-2.5F),0,0);
		animator.rotate(left_arm, (float) Math.toRadians(-15F),0,0);
		animator.rotate(left_front_arm, (float) Math.toRadians(-2.5F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-7.5F),0,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(20F),0,0);
		animator.rotate(left_leg, (float) Math.toRadians(-40F),0,0);
		animator.move(left_leg, 0,-4f,0);
		animator.rotate(left_front_leg, (float) Math.toRadians(47.5F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-17.5F),0,0);
		animator.rotate(left_foot, (float) Math.toRadians(17.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(root, 0,7, 2);
		animator.rotate(pelvis, (float) Math.toRadians(7.5F),(float) Math.toRadians(5F), 0);
		animator.rotate(tail1, (float) Math.toRadians(-15F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(2.5F),(float) Math.toRadians(5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(15F),(float) Math.toRadians(5F), 0);
		animator.rotate(tail4, (float) Math.toRadians(25F),(float) Math.toRadians(5F), 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(spine2, (float) Math.toRadians(2.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(neck1, (float) Math.toRadians(37.5F),0,0);
		animator.rotate(neck2, (float) Math.toRadians(-10F),0, 0);
		animator.rotate(head, (float) Math.toRadians(-37.5F),0,0);
		animator.rotate(jaw, (float) Math.toRadians(17.5F),0,0);
		animator.rotate(right_arm, (float) Math.toRadians(-7.5F),0,0);
		animator.rotate(right_front_arm, (float) Math.toRadians(12.5F),0,0);
		animator.rotate(right_hand, (float) Math.toRadians(2.5F),0,0);
		animator.rotate(left_arm, (float) Math.toRadians(-7.5F),0,0);
		animator.rotate(left_front_arm, (float) Math.toRadians(12.5F),0,0);
		animator.rotate(left_hand, (float) Math.toRadians(2.5F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-5F),0,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(25F),0,0);
		animator.rotate(left_leg, (float) Math.toRadians(-10F),0,0);
		animator.move(left_leg, 0,1f,5f);
		animator.rotate(left_front_leg, (float) Math.toRadians(25F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-45F),0,0);
		animator.rotate(left_foot, (float) Math.toRadians(35F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.move(root, 0,5, 2);
		animator.rotate(pelvis, (float) Math.toRadians(5F),(float) Math.toRadians(3.3F), 0);
		animator.rotate(tail1, (float) Math.toRadians(-10F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(2.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(15F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(tail4, (float) Math.toRadians(25F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(spine2, (float) Math.toRadians(2.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(neck1, (float) Math.toRadians(27.5F),0,0);
		animator.rotate(neck2, (float) Math.toRadians(-7.5F),0, 0);
		animator.rotate(head, (float) Math.toRadians(-27.5F),0,0);
		animator.rotate(jaw, (float) Math.toRadians(12.5F),0,0);
		animator.rotate(right_arm, (float) Math.toRadians(5F),0,0);
		animator.rotate(right_front_arm, (float) Math.toRadians(32.5F),0,0);
		animator.rotate(right_hand, (float) Math.toRadians(7.5F),0,0);
		animator.rotate(left_arm, (float) Math.toRadians(5F),0,0);
		animator.rotate(left_front_arm, (float) Math.toRadians(32.5F),0,0);
		animator.rotate(left_hand, (float) Math.toRadians(7.5F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-3.5F),0,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(20F),0,0);
		animator.rotate(right_foot,(float) Math.toRadians(-2.5F),0,0);
		animator.rotate(left_leg, (float) Math.toRadians(-7.5F),0,0);
		animator.move(left_leg, 0,1f,6f);
		animator.rotate(left_front_leg, (float) Math.toRadians(20F),(float) Math.toRadians(-2.5F),0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-45F),0,0);
		animator.rotate(left_foot, (float) Math.toRadians(35F),0,0);
		animator.endKeyframe();


		animator.startKeyframe(2);
		animator.move(root, 0,0, 2);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(20F),0, 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(spine2, (float) Math.toRadians(2.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(neck1, (float) Math.toRadians(27.5F),0,0);
		animator.rotate(neck2, (float) Math.toRadians(-7.5F),0, 0);
		animator.rotate(head, (float) Math.toRadians(-27.5F),0,0);
		animator.rotate(jaw, (float) Math.toRadians(12.5F),0,0);
		animator.rotate(right_arm, (float) Math.toRadians(5F),0,0);
		animator.rotate(right_front_arm, (float) Math.toRadians(32.5F),0,0);
		animator.rotate(right_hand, (float) Math.toRadians(7.5F),0,0);
		animator.rotate(left_arm, (float) Math.toRadians(5F),0,0);
		animator.rotate(left_front_arm, (float) Math.toRadians(32.5F),0,0);
		animator.rotate(left_hand, (float) Math.toRadians(7.5F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-3.5F),0,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(20F),0,0);
		animator.rotate(right_foot,(float) Math.toRadians(-2.5F),0,0);
		animator.rotate(left_leg, (float) Math.toRadians(-7.5F),0,0);
		animator.move(left_leg, 0,1f,6f);
		animator.rotate(left_front_leg, (float) Math.toRadians(20F),(float) Math.toRadians(-2.5F),0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-45F),0,0);
		animator.rotate(left_foot, (float) Math.toRadians(35F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(10);
		animator.move(root, 0,1, 2);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(20F),0, 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(60);

		animator.resetKeyframe(10);


		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_TAIL_ATTACK1);
		animator.startKeyframe(13);
		animator.rotate(mid_pivot, 0,(float) Math.toRadians(50F), 0);
		animator.move(mid_pivot, 2,17, 10);
		animator.rotate(tail1, (float) Math.toRadians(-22.5F),(float) Math.toRadians(50F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(30F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(22.5F), (float) Math.toRadians(5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(27.5F), (float) Math.toRadians(5F));
		animator.rotate(spine1, 0,(float) Math.toRadians(-20F),0);
		animator.rotate(spine2, 0,(float) Math.toRadians(-15F),0);
		//animator.rotate(neck1, 0,(float) Math.toRadians(-15F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(-12.5F),0);
		animator.rotate(head, (float) Math.toRadians(7.5F),(float) Math.toRadians(-15F),(float) Math.toRadians(-12.5F));
		animator.rotate(jaw,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(left_arm,0,0,(float) Math.toRadians(-10F));
		animator.rotate(left_front_arm,(float) Math.toRadians(17.5F),0,0);
		animator.rotate(right_arm,0,0,(float) Math.toRadians(-2.5F));
		animator.rotate(right_front_arm,(float) Math.toRadians(7.5F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-15F),(float) Math.toRadians(-22.5F),(float) Math.toRadians(-22.5F));
		animator.move(left_leg,0,-6,0);
		animator.rotate(right_leg,(float) Math.toRadians(-30F),(float) Math.toRadians(22.5F),(float) Math.toRadians(7.5F));
		animator.move(right_leg,0,-4,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(35F),(float) Math.toRadians(-17.5F),(float) Math.toRadians(5F));
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-10F),0,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(32.5F),0,0);
		animator.rotate(right_ankel_joint,0,0,(float) Math.toRadians(-12.5F));
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(-100F), 0);
		animator.move(mid_pivot, 2,-5, 10);
		animator.rotate(tail1, (float) Math.toRadians(-35F),(float) Math.toRadians(-17.5F), (float) Math.toRadians(25F));
		animator.rotate(tail2, 0,(float) Math.toRadians(7.5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(27.5F),(float) Math.toRadians(7.5F), (float) Math.toRadians(7.5F));
		animator.rotate(tail4, (float) Math.toRadians(27.5F),(float) Math.toRadians(2.5F), (float) Math.toRadians(2.5F));
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(-7.5F),0);
		animator.rotate(spine2, (float) Math.toRadians(2.5F),(float) Math.toRadians(12.5F),(float) Math.toRadians(12.5F));
		//animator.rotate(neck1, 0,(float) Math.toRadians(-15F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(22.5F),0);
		animator.rotate(head, (float) Math.toRadians(7.5F),0,(float) Math.toRadians(-7.5F));
		animator.rotate(jaw,(float) Math.toRadians(15F),0,0);
		animator.rotate(left_arm,(float) Math.toRadians(17.5F),0,(float) Math.toRadians(-10F));
		animator.rotate(left_front_arm,(float) Math.toRadians(25F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(22.5F),0,(float) Math.toRadians(17.5F));
		animator.rotate(right_front_arm,(float) Math.toRadians(25F),0,0);
		//animator.rotate(left_leg,(float) Math.toRadians(-15F),(float) Math.toRadians(-22.5F),(float) Math.toRadians(-22.5F));
		//animator.rotate(right_leg,(float) Math.toRadians(-30F),(float) Math.toRadians(22.5F),(float) Math.toRadians(7.5F));
		animator.move(right_leg,0,2,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(30F),(float) Math.toRadians(-17.5F),(float) Math.toRadians(5F));
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-10F),(float) Math.toRadians(1.5F),(float) Math.toRadians(10F));
		animator.rotate(right_front_leg,(float) Math.toRadians(-7.5F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(2.5F),0,(float) Math.toRadians(-12.5F));
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(-200F), 0);
		animator.move(mid_pivot, 2,8, 10);
		animator.rotate(tail1, (float) Math.toRadians(-22.5F),(float) Math.toRadians(-47.5F), (float) Math.toRadians(-10F));
		animator.rotate(tail2, (float) Math.toRadians(-15F),(float) Math.toRadians(-32.5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(10F),(float) Math.toRadians(-15F), (float) Math.toRadians(-5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(-27.5F), (float) Math.toRadians(-5F));
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(-2.5F),0);
		animator.rotate(spine2, (float) Math.toRadians(2.5F),(float) Math.toRadians(12.5F),(float) Math.toRadians(10F));
		animator.rotate(neck1, 0,(float) Math.toRadians(5F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(32.5F),0);
		animator.rotate(head, (float) Math.toRadians(10F),0,(float) Math.toRadians(-7.5F));
		animator.rotate(jaw,(float) Math.toRadians(17.5F),0,0);
		animator.rotate(left_arm,(float) Math.toRadians(15F),(float) Math.toRadians(-2.5F),(float) Math.toRadians(-5F));
		animator.rotate(left_front_arm,(float) Math.toRadians(20F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(25F),(float) Math.toRadians(5F),(float) Math.toRadians(15F));
		animator.rotate(right_front_arm,(float) Math.toRadians(10F),0,0);
		animator.rotate(left_leg,0,0,(float) Math.toRadians(-32.5F));
		animator.rotate(right_leg,(float) Math.toRadians(-20F),(float) Math.toRadians(-7.5F),(float) Math.toRadians(-10F));
		animator.move(right_leg,0,2,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(32.5F),(float) Math.toRadians(-17.5F),(float) Math.toRadians(5F));
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-10F),(float) Math.toRadians(3F),(float) Math.toRadians(17.5F));
		animator.rotate(right_front_leg,(float) Math.toRadians(25F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(2.5F),0,(float) Math.toRadians(2.5F));
		animator.endKeyframe();

		animator.startKeyframe(5);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(-250F), 0);
		animator.move(mid_pivot, 2,15, 10);
		animator.rotate(tail1, (float) Math.toRadians(-7.5F),(float) Math.toRadians(-47.5F), (float) Math.toRadians(-10F));
		animator.rotate(tail2, (float) Math.toRadians(-17.5F),(float) Math.toRadians(-50F), (float) Math.toRadians(5F));
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(-37.5F), (float) Math.toRadians(-7.5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(-32.5F), (float) Math.toRadians(-5F));
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(7.5F),(float) Math.toRadians(1F));
		animator.rotate(spine2, (float) Math.toRadians(1.5F),(float) Math.toRadians(10F),(float) Math.toRadians(7.5F));
		animator.rotate(neck1, 0,(float) Math.toRadians(12.5F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(40F),0);
		animator.rotate(head, (float) Math.toRadians(17.5F),0,(float) Math.toRadians(-7.5F));
		animator.rotate(jaw,(float) Math.toRadians(20F),0,0);
		animator.rotate(left_arm,(float) Math.toRadians(5F),(float) Math.toRadians(-7.5F),(float) Math.toRadians(2.5F));
		animator.rotate(left_front_arm,(float) Math.toRadians(2.5F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(22.5F),(float) Math.toRadians(12.5F),(float) Math.toRadians(5F));
		animator.rotate(right_front_arm,(float) Math.toRadians(-30F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-27.5F),0,(float) Math.toRadians(-32.5F));
		animator.rotate(right_leg,(float) Math.toRadians(-37.5F),(float) Math.toRadians(10F),(float) Math.toRadians(-7.5F));
		animator.move(right_leg,0,1.5f,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(45F),(float) Math.toRadians(-17.5F),(float) Math.toRadians(5F));
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-1.5F),(float) Math.toRadians(2.5F),(float) Math.toRadians(12.5F));
		animator.rotate(right_front_leg,(float) Math.toRadians(35F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(1.5F),0,(float) Math.toRadians(2.5F));
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(8);
		animator.rotate(mid_pivot, (float) Math.toRadians(-3.5F),(float) Math.toRadians(-290F), 0);
		animator.move(mid_pivot, 1,10, 7f);
		animator.rotate(tail1, (float) Math.toRadians(-5F),(float) Math.toRadians(-30F), (float) Math.toRadians(-7.5F));
		animator.rotate(tail2, (float) Math.toRadians(-12.5F),(float) Math.toRadians(-32.5F), (float) Math.toRadians(3.5F));
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(-25F), (float) Math.toRadians(-5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(-22.5F), (float) Math.toRadians(-3.5F));
		animator.rotate(spine1, (float) Math.toRadians(1.5F),(float) Math.toRadians(5F),0);
		animator.rotate(spine2, 0,(float) Math.toRadians(5F),(float) Math.toRadians(5F));
		animator.rotate(neck1, 0,(float) Math.toRadians(10F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(27.5F),0);
		animator.rotate(head, (float) Math.toRadians(12.5F),0,(float) Math.toRadians(-5F));
		animator.rotate(jaw,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(left_arm,(float) Math.toRadians(3F),(float) Math.toRadians(-5F),(float) Math.toRadians(2.5F));
		animator.rotate(right_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(7.5F),(float) Math.toRadians(2.5F));
		animator.rotate(right_front_arm,(float) Math.toRadians(-22.5F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-37.5F),0,(float) Math.toRadians(-20F));
		animator.move(left_leg,0,-5,0);
		animator.rotate(left_foot,(float) Math.toRadians(7.5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-22.5F),(float) Math.toRadians(17.5F),(float) Math.toRadians(5F));
		animator.move(right_leg,0,1f,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(45F),(float) Math.toRadians(-10F),(float) Math.toRadians(3F));
		animator.rotate(left_ankel_joint,(float) Math.toRadians(3.5F),(float) Math.toRadians(1.5F),(float) Math.toRadians(7.5F));
		animator.rotate(right_front_leg,(float) Math.toRadians(22.5F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(1.5F),0,(float) Math.toRadians(2.5F));
		animator.endKeyframe();

		animator.startKeyframe(0);
		animator.rotate(mid_pivot, (float) Math.toRadians(-3.5F),(float) Math.toRadians(70F), 0);
		animator.move(mid_pivot, 1,10, 7f);
		animator.rotate(tail1, (float) Math.toRadians(-5F),(float) Math.toRadians(-30F), (float) Math.toRadians(-7.5F));
		animator.rotate(tail2, (float) Math.toRadians(-12.5F),(float) Math.toRadians(-32.5F), (float) Math.toRadians(3.5F));
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(-25F), (float) Math.toRadians(-5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(-22.5F), (float) Math.toRadians(-3.5F));
		animator.rotate(spine1, (float) Math.toRadians(1.5F),(float) Math.toRadians(5F),0);
		animator.rotate(spine2, 0,(float) Math.toRadians(5F),(float) Math.toRadians(5F));
		animator.rotate(neck1, 0,(float) Math.toRadians(10F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(27.5F),0);
		animator.rotate(head, (float) Math.toRadians(12.5F),0,(float) Math.toRadians(-5F));
		animator.rotate(jaw,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(left_arm,(float) Math.toRadians(3F),(float) Math.toRadians(-5F),(float) Math.toRadians(2.5F));
		animator.rotate(right_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(7.5F),(float) Math.toRadians(2.5F));
		animator.rotate(right_front_arm,(float) Math.toRadians(-22.5F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-37.5F),0,(float) Math.toRadians(-20F));
		animator.move(left_leg,0,-5,0);
		animator.rotate(left_foot,(float) Math.toRadians(7.5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-22.5F),(float) Math.toRadians(17.5F),(float) Math.toRadians(5F));
		animator.move(right_leg,0,1f,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(45F),(float) Math.toRadians(-10F),(float) Math.toRadians(3F));
		animator.rotate(left_ankel_joint,(float) Math.toRadians(3.5F),(float) Math.toRadians(1.5F),(float) Math.toRadians(7.5F));
		animator.rotate(right_front_leg,(float) Math.toRadians(22.5F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(1.5F),0,(float) Math.toRadians(2.5F));
		animator.endKeyframe();


		animator.resetKeyframe(15);



		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_TAIL_ATTACK2);
		animator.startKeyframe(11);
		animator.rotate(mid_pivot, 0,(float) Math.toRadians(-50F), 0);
		animator.move(mid_pivot, -2,17, 10);
		animator.rotate(tail1, (float) Math.toRadians(-22.5F),(float) Math.toRadians(-50F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(-30F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(-22.5F), (float) Math.toRadians(-5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(-27.5F), (float) Math.toRadians(-5F));
		animator.rotate(spine1, 0,(float) Math.toRadians(20F),0);
		animator.rotate(spine2, 0,(float) Math.toRadians(15F),0);
		//animator.rotate(neck1, 0,(float) Math.toRadians(-15F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(12.5F),0);
		animator.rotate(head, (float) Math.toRadians(7.5F),(float) Math.toRadians(15F),(float) Math.toRadians(12.5F));
		animator.rotate(jaw,(float) Math.toRadians(12.5F),0,0);

		animator.rotate(right_arm,0,0,(float) Math.toRadians(10F));
		animator.rotate(right_front_arm,(float) Math.toRadians(17.5F),0,0);
		animator.rotate(left_arm,0,0,(float) Math.toRadians(2.5F));
		animator.rotate(left_front_arm,(float) Math.toRadians(7.5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-15F),(float) Math.toRadians(22.5F),(float) Math.toRadians(22.5F));
		animator.move(right_leg,0,-6,0);
		animator.rotate(left_leg,(float) Math.toRadians(-30F),(float) Math.toRadians(-22.5F),(float) Math.toRadians(-7.5F));
		animator.move(left_leg,0,-4,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(35F),(float) Math.toRadians(17.5F),(float) Math.toRadians(-5F));
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-10F),0,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(32.5F),0,0);
		animator.rotate(left_ankel_joint,0,0,(float) Math.toRadians(12.5F));
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(100F), 0);
		animator.move(mid_pivot, -2,-5, 10);
		animator.rotate(tail1, (float) Math.toRadians(-35F),(float) Math.toRadians(17.5F), (float) Math.toRadians(-25F));
		animator.rotate(tail2, 0,(float) Math.toRadians(-7.5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(27.5F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(-7.5F));
		animator.rotate(tail4, (float) Math.toRadians(27.5F),(float) Math.toRadians(-2.5F), (float) Math.toRadians(-2.5F));
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(7.5F),0);
		animator.rotate(spine2, (float) Math.toRadians(2.5F),(float) Math.toRadians(-12.5F),(float) Math.toRadians(-12.5F));
		//animator.rotate(neck1, 0,(float) Math.toRadians(-15F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(-22.5F),0);
		animator.rotate(head, (float) Math.toRadians(7.5F),0,(float) Math.toRadians(7.5F));
		animator.rotate(jaw,(float) Math.toRadians(15F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(17.5F),0,(float) Math.toRadians(10F));
		animator.rotate(right_front_arm,(float) Math.toRadians(25F),0,0);
		animator.rotate(left_arm,(float) Math.toRadians(22.5F),0,(float) Math.toRadians(-17.5F));
		animator.rotate(left_front_arm,(float) Math.toRadians(25F),0,0);
		//animator.rotate(left_leg,(float) Math.toRadians(-15F),(float) Math.toRadians(-22.5F),(float) Math.toRadians(-22.5F));
		//animator.rotate(right_leg,(float) Math.toRadians(-30F),(float) Math.toRadians(22.5F),(float) Math.toRadians(7.5F));
		animator.move(left_leg,0,2,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(30F),(float) Math.toRadians(17.5F),(float) Math.toRadians(-5F));
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-10F),(float) Math.toRadians(-1.5F),(float) Math.toRadians(-10F));
		animator.rotate(left_front_leg,(float) Math.toRadians(-7.5F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(2.5F),0,(float) Math.toRadians(12.5F));
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(200F), 0);
		animator.move(mid_pivot, -2,8, 10);
		animator.rotate(tail1, (float) Math.toRadians(-22.5F),(float) Math.toRadians(47.5F), (float) Math.toRadians(10F));
		animator.rotate(tail2, (float) Math.toRadians(-15F),(float) Math.toRadians(32.5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(10F),(float) Math.toRadians(15F), (float) Math.toRadians(5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(27.5F), (float) Math.toRadians(5F));
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(2.5F),0);
		animator.rotate(spine2, (float) Math.toRadians(2.5F),(float) Math.toRadians(-12.5F),(float) Math.toRadians(-10F));
		animator.rotate(neck1, 0,(float) Math.toRadians(-5F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(-32.5F),0);
		animator.rotate(head, (float) Math.toRadians(10F),0,(float) Math.toRadians(7.5F));
		animator.rotate(jaw,(float) Math.toRadians(17.5F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(15F),(float) Math.toRadians(2.5F),(float) Math.toRadians(5F));
		animator.rotate(right_front_arm,(float) Math.toRadians(20F),0,0);
		animator.rotate(left_arm,(float) Math.toRadians(25F),(float) Math.toRadians(-5F),(float) Math.toRadians(-15F));
		animator.rotate(left_front_arm,(float) Math.toRadians(10F),0,0);
		animator.rotate(right_leg,0,0,(float) Math.toRadians(32.5F));
		animator.rotate(left_leg,(float) Math.toRadians(-20F),(float) Math.toRadians(7.5F),(float) Math.toRadians(10F));
		animator.move(left_leg,0,2,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(32.5F),(float) Math.toRadians(17.5F),(float) Math.toRadians(-5F));
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-10F),(float) Math.toRadians(-3F),(float) Math.toRadians(-17.5F));
		animator.rotate(left_front_leg,(float) Math.toRadians(25F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(2.5F),0,(float) Math.toRadians(-2.5F));
		animator.endKeyframe();

		animator.startKeyframe(5);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(250F), 0);
		animator.move(mid_pivot, -2,15, 10);
		animator.rotate(tail1, (float) Math.toRadians(-7.5F),(float) Math.toRadians(47.5F), (float) Math.toRadians(10F));
		animator.rotate(tail2, (float) Math.toRadians(-17.5F),(float) Math.toRadians(50F), (float) Math.toRadians(-5F));
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(37.5F), (float) Math.toRadians(7.5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(32.5F), (float) Math.toRadians(5F));
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(-7.5F),(float) Math.toRadians(-1F));
		animator.rotate(spine2, (float) Math.toRadians(1.5F),(float) Math.toRadians(-10F),(float) Math.toRadians(-7.5F));
		animator.rotate(neck1, 0,(float) Math.toRadians(-12.5F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(-40F),0);
		animator.rotate(head, (float) Math.toRadians(17.5F),0,(float) Math.toRadians(7.5F));
		animator.rotate(jaw,(float) Math.toRadians(20F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(5F),(float) Math.toRadians(7.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(right_front_arm,(float) Math.toRadians(2.5F),0,0);
		animator.rotate(left_arm,(float) Math.toRadians(22.5F),(float) Math.toRadians(-12.5F),(float) Math.toRadians(-5F));
		animator.rotate(left_front_arm,(float) Math.toRadians(-30F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-27.5F),0,(float) Math.toRadians(32.5F));
		animator.rotate(left_leg,(float) Math.toRadians(-37.5F),(float) Math.toRadians(-10F),(float) Math.toRadians(7.5F));
		animator.move(left_leg,0,1.5f,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(45F),(float) Math.toRadians(17.5F),(float) Math.toRadians(-5F));
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-1.5F),(float) Math.toRadians(-2.5F),(float) Math.toRadians(-12.5F));
		animator.rotate(left_front_leg,(float) Math.toRadians(35F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(1.5F),0,(float) Math.toRadians(-2.5F));
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(8);
		animator.rotate(mid_pivot, (float) Math.toRadians(-3.5F),(float) Math.toRadians(290F), 0);
		animator.move(mid_pivot, -1,10, 7f);
		animator.rotate(tail1, (float) Math.toRadians(-5F),(float) Math.toRadians(30F), (float) Math.toRadians(7.5F));
		animator.rotate(tail2, (float) Math.toRadians(-12.5F),(float) Math.toRadians(32.5F), (float) Math.toRadians(-3.5F));
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(25F), (float) Math.toRadians(5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(22.5F), (float) Math.toRadians(3.5F));
		animator.rotate(spine1, (float) Math.toRadians(1.5F),(float) Math.toRadians(-5F),0);
		animator.rotate(spine2, 0,(float) Math.toRadians(-5F),(float) Math.toRadians(-5F));
		animator.rotate(neck1, 0,(float) Math.toRadians(-10F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(-27.5F),0);
		animator.rotate(head, (float) Math.toRadians(12.5F),0,(float) Math.toRadians(5F));
		animator.rotate(jaw,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(3F),(float) Math.toRadians(5F),(float) Math.toRadians(-2.5F));
		animator.rotate(left_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(-7.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(left_front_arm,(float) Math.toRadians(-22.5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-37.5F),0,(float) Math.toRadians(20F));
		animator.move(right_leg,0,-5,0);
		animator.rotate(right_foot,(float) Math.toRadians(7.5F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-22.5F),(float) Math.toRadians(-17.5F),(float) Math.toRadians(-5F));
		animator.move(left_leg,0,1f,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(45F),(float) Math.toRadians(10F),(float) Math.toRadians(-3F));
		animator.rotate(right_ankel_joint,(float) Math.toRadians(3.5F),(float) Math.toRadians(-1.5F),(float) Math.toRadians(-7.5F));
		animator.rotate(left_front_leg,(float) Math.toRadians(22.5F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(1.5F),0,(float) Math.toRadians(-2.5F));
		animator.endKeyframe();

		animator.startKeyframe(0);
		animator.rotate(mid_pivot, (float) Math.toRadians(-3.5F),(float) Math.toRadians(-70F), 0);
		animator.move(mid_pivot, -1,10, 7f);
		animator.rotate(tail1, (float) Math.toRadians(-5F),(float) Math.toRadians(30F), (float) Math.toRadians(7.5F));
		animator.rotate(tail2, (float) Math.toRadians(-12.5F),(float) Math.toRadians(32.5F), (float) Math.toRadians(-3.5F));
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(25F), (float) Math.toRadians(5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(22.5F), (float) Math.toRadians(3.5F));
		animator.rotate(spine1, (float) Math.toRadians(1.5F),(float) Math.toRadians(-5F),0);
		animator.rotate(spine2, 0,(float) Math.toRadians(-5F),(float) Math.toRadians(-5F));
		animator.rotate(neck1, 0,(float) Math.toRadians(-10F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(-27.5F),0);
		animator.rotate(head, (float) Math.toRadians(12.5F),0,(float) Math.toRadians(5F));
		animator.rotate(jaw,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(3F),(float) Math.toRadians(5F),(float) Math.toRadians(-2.5F));
		animator.rotate(left_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(-7.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(left_front_arm,(float) Math.toRadians(-22.5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-37.5F),0,(float) Math.toRadians(20F));
		animator.move(right_leg,0,-5,0);
		animator.rotate(right_foot,(float) Math.toRadians(7.5F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-22.5F),(float) Math.toRadians(-17.5F),(float) Math.toRadians(-5F));
		animator.move(left_leg,0,1f,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(45F),(float) Math.toRadians(10F),(float) Math.toRadians(-3F));
		animator.rotate(right_ankel_joint,(float) Math.toRadians(3.5F),(float) Math.toRadians(-1.5F),(float) Math.toRadians(-7.5F));
		animator.rotate(left_front_leg,(float) Math.toRadians(22.5F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(1.5F),0,(float) Math.toRadians(-2.5F));
		animator.endKeyframe();


		animator.resetKeyframe(15);



		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_LEFT_STOMP);
		animator.startKeyframe(12);
		animator.rotate(mid_pivot, (float) Math.toRadians(-7.5F),(float) Math.toRadians(-5F), 0);
		animator.move(mid_pivot, 0,2, 0);
		animator.rotate(tail1, 0,(float) Math.toRadians(5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(7.5F), (float) Math.toRadians(1.5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(5F), (float) Math.toRadians(5F));
		animator.rotate(spine1, 0,(float) Math.toRadians(-5F),0);
		animator.rotate(spine2, 0,(float) Math.toRadians(-5F),0);
		animator.rotate(neck1, 0,(float) Math.toRadians(-10F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(-10F),0);
		animator.rotate(head, (float) Math.toRadians(7.5F),(float) Math.toRadians(15F),0);
		animator.rotate(jaw,(float) Math.toRadians(7.5F),0,0);
		animator.rotate(left_leg,0,0,(float) Math.toRadians(-10F));
		//animator.move(left_leg,0,-6,0);
		animator.rotate(right_leg,(float) Math.toRadians(12.5F),0,0);
		//animator.move(right_leg,0,-4,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(10F),0,0);
		animator.rotate(left_ankel_joint,0,0,(float) Math.toRadians(7.5F));
		animator.rotate(right_front_leg,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-12.5F),0,0);
		animator.endKeyframe();


		animator.startKeyframe(12);
		animator.rotate(mid_pivot, (float) Math.toRadians(-17.5F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(-7.5F));
		animator.move(mid_pivot, 0,-1, 0);
		animator.rotate(tail1, 0,(float) Math.toRadians(-5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(-20F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(-15F), (float) Math.toRadians(-2.5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(-7.5F));
		animator.rotate(spine1, (float) Math.toRadians(10F),(float) Math.toRadians(12.5F),(float) Math.toRadians(2.5F));
		animator.rotate(spine2, (float) Math.toRadians(7.5F),(float) Math.toRadians(-10F),(float) Math.toRadians(-2.5F));
		animator.rotate(neck1, (float) Math.toRadians(7.5F),(float) Math.toRadians(-10F),0);
		animator.rotate(neck2, (float) Math.toRadians(10F),(float) Math.toRadians(-10F),0);
		animator.rotate(head, (float) Math.toRadians(-2.5F),(float) Math.toRadians(15F),0);
		animator.rotate(jaw,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-50F),(float) Math.toRadians(-12.5F),(float) Math.toRadians(-15F));
		animator.move(left_leg,0,-4,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(50F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(15F),0,(float) Math.toRadians(7.5F));
		animator.rotate(right_leg,(float) Math.toRadians(17.5F),0,(float) Math.toRadians(7.5F));
		animator.move(right_leg,0,3,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(20F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-15F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(3);

		animator.startKeyframe(2);
		animator.rotate(mid_pivot, (float) Math.toRadians(-15F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(-6.0F));
		animator.move(mid_pivot, 0,12.4F, 0);
		animator.rotate(pelvis, 0,(float) Math.toRadians(10F), 0);
		animator.rotate(tail1, 0,(float) Math.toRadians(5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(-2.5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(17.5F),(float) Math.toRadians(7.5F));
		animator.rotate(spine2, (float) Math.toRadians(3.5F),(float) Math.toRadians(-12.5F),(float) Math.toRadians(-5F));
		animator.rotate(neck1, (float) Math.toRadians(15F),(float) Math.toRadians(-10F),0);
		animator.rotate(neck2, (float) Math.toRadians(12.5F),(float) Math.toRadians(-10F),0);
		animator.rotate(head, (float) Math.toRadians(2.5F),(float) Math.toRadians(15F),0);
		animator.rotate(jaw,(float) Math.toRadians(2.5F),0,0);
		animator.rotate(left_leg,0,0,(float) Math.toRadians(-5F));
		animator.move(left_leg,0,4,-12.5F);
		animator.rotate(left_front_leg,(float) Math.toRadians(42.5F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-25F),0,(float) Math.toRadians(7.5F));
		animator.rotate(right_leg,(float) Math.toRadians(5F),0,(float) Math.toRadians(7.5F));
		animator.move(right_leg,0,-5f,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(40F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-30F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(8);

		animator.resetKeyframe(10);

		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_RIGHT_STOMP);
		animator.startKeyframe(12);
		animator.rotate(mid_pivot, (float) Math.toRadians(-7.5F),(float) Math.toRadians(5F), 0);
		animator.move(mid_pivot, 0,2, 0);
		animator.rotate(tail1, 0,(float) Math.toRadians(-5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(-5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(-1.5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(-5F), (float) Math.toRadians(-5F));
		animator.rotate(spine1, 0,(float) Math.toRadians(5F),0);
		animator.rotate(spine2, 0,(float) Math.toRadians(5F),0);
		animator.rotate(neck1, 0,(float) Math.toRadians(10F),0);
		animator.rotate(neck2, 0,(float) Math.toRadians(10F),0);
		animator.rotate(head, (float) Math.toRadians(7.5F),(float) Math.toRadians(-15F),0);
		animator.rotate(jaw,(float) Math.toRadians(7.5F),0,0);
		animator.rotate(right_leg,0,0,(float) Math.toRadians(10F));
		//animator.move(left_leg,0,-6,0);
		animator.rotate(left_leg,(float) Math.toRadians(12.5F),0,0);
		//animator.move(right_leg,0,-4,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(10F),0,0);
		animator.rotate(right_ankel_joint,0,0,(float) Math.toRadians(-7.5F));
		animator.rotate(left_front_leg,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(-12.5F),0,0);
		animator.endKeyframe();


		animator.startKeyframe(12);
		animator.rotate(mid_pivot, (float) Math.toRadians(-17.5F),(float) Math.toRadians(7.5F), (float) Math.toRadians(7.5F));
		animator.move(mid_pivot, 0,-1, 0);
		animator.rotate(tail1, 0,(float) Math.toRadians(5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(20F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(15F), (float) Math.toRadians(2.5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(7.5F), (float) Math.toRadians(7.5F));
		animator.rotate(spine1, (float) Math.toRadians(10F),(float) Math.toRadians(-12.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(spine2, (float) Math.toRadians(7.5F),(float) Math.toRadians(10F),(float) Math.toRadians(2.5F));
		animator.rotate(neck1, (float) Math.toRadians(7.5F),(float) Math.toRadians(10F),0);
		animator.rotate(neck2, (float) Math.toRadians(10F),(float) Math.toRadians(10F),0);
		animator.rotate(head, (float) Math.toRadians(-2.5F),(float) Math.toRadians(-15F),0);
		animator.rotate(jaw,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-50F),(float) Math.toRadians(12.5F),(float) Math.toRadians(15F));
		animator.move(right_leg,0,-4,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(50F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(15F),0,(float) Math.toRadians(-7.5F));
		animator.rotate(left_leg,(float) Math.toRadians(17.5F),0,(float) Math.toRadians(-7.5F));
		animator.move(left_leg,0,3,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(20F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-15F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(3);

		animator.startKeyframe(2);
		animator.rotate(mid_pivot, (float) Math.toRadians(-15F),(float) Math.toRadians(7.5F), (float) Math.toRadians(6.0F));
		animator.move(mid_pivot, 0,12.4F, 0);
		animator.rotate(pelvis, 0,(float) Math.toRadians(-10F), 0);
		animator.rotate(tail1, 0,(float) Math.toRadians(-5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(2.5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(-17.5F),(float) Math.toRadians(-7.5F));
		animator.rotate(spine2, (float) Math.toRadians(3.5F),(float) Math.toRadians(12.5F),(float) Math.toRadians(5F));
		animator.rotate(neck1, (float) Math.toRadians(15F),(float) Math.toRadians(10F),0);
		animator.rotate(neck2, (float) Math.toRadians(12.5F),(float) Math.toRadians(10F),0);
		animator.rotate(head, (float) Math.toRadians(2.5F),(float) Math.toRadians(-15F),0);
		animator.rotate(jaw,(float) Math.toRadians(2.5F),0,0);
		animator.rotate(right_leg,0,0,(float) Math.toRadians(5F));
		animator.move(right_leg,0,4,-12.5F);
		animator.rotate(right_front_leg,(float) Math.toRadians(42.5F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-25F),0,(float) Math.toRadians(-7.5F));
		animator.rotate(left_leg,(float) Math.toRadians(5F),0,(float) Math.toRadians(-7.5F));
		animator.move(left_leg,0,-5f,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(40F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-30F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(8);

		animator.resetKeyframe(10);


		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_LEFT_STOMP_EXTRA);
		animator.startKeyframe(0);
		animator.rotate(mid_pivot, (float) Math.toRadians(-15F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(-6.0F));
		animator.move(mid_pivot, 0,12.4F, 0);
		animator.rotate(pelvis, 0,(float) Math.toRadians(10F), 0);
		animator.rotate(tail1, 0,(float) Math.toRadians(5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(-2.5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(17.5F),(float) Math.toRadians(7.5F));
		animator.rotate(spine2, (float) Math.toRadians(3.5F),(float) Math.toRadians(-12.5F),(float) Math.toRadians(-5F));
		animator.rotate(neck1, (float) Math.toRadians(15F),(float) Math.toRadians(-10F),0);
		animator.rotate(neck2, (float) Math.toRadians(12.5F),(float) Math.toRadians(-10F),0);
		animator.rotate(head, (float) Math.toRadians(2.5F),(float) Math.toRadians(15F),0);
		animator.rotate(jaw,(float) Math.toRadians(2.5F),0,0);
		animator.rotate(left_leg,0,0,(float) Math.toRadians(-5F));
		animator.move(left_leg,0,4,-12.5F);
		animator.rotate(left_front_leg,(float) Math.toRadians(42.5F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-25F),0,(float) Math.toRadians(7.5F));
		animator.rotate(right_leg,(float) Math.toRadians(5F),0,(float) Math.toRadians(7.5F));
		animator.move(right_leg,0,-5f,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(40F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-30F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(12);
		animator.rotate(mid_pivot, (float) Math.toRadians(-17.5F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(-7.5F));
		animator.move(mid_pivot, 0,-1, 0);
		animator.rotate(tail1, 0,(float) Math.toRadians(-5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(-20F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(-15F), (float) Math.toRadians(-2.5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(-7.5F));
		animator.rotate(spine1, (float) Math.toRadians(10F),(float) Math.toRadians(12.5F),(float) Math.toRadians(2.5F));
		animator.rotate(spine2, (float) Math.toRadians(7.5F),(float) Math.toRadians(-10F),(float) Math.toRadians(-2.5F));
		animator.rotate(neck1, (float) Math.toRadians(7.5F),(float) Math.toRadians(-10F),0);
		animator.rotate(neck2, (float) Math.toRadians(10F),(float) Math.toRadians(-10F),0);
		animator.rotate(head, (float) Math.toRadians(-2.5F),(float) Math.toRadians(15F),0);
		animator.rotate(jaw,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-50F),(float) Math.toRadians(-12.5F),(float) Math.toRadians(-15F));
		animator.move(left_leg,0,-4,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(50F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(15F),0,(float) Math.toRadians(7.5F));
		animator.rotate(right_leg,(float) Math.toRadians(17.5F),0,(float) Math.toRadians(7.5F));
		animator.move(right_leg,0,3,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(20F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-15F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(6);

		animator.startKeyframe(2);
		animator.rotate(mid_pivot, (float) Math.toRadians(-15F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(-6.0F));
		animator.move(mid_pivot, 0,12.4F, 0);
		animator.rotate(pelvis, 0,(float) Math.toRadians(10F), 0);
		animator.rotate(tail1, 0,(float) Math.toRadians(5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(-2.5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(17.5F),(float) Math.toRadians(7.5F));
		animator.rotate(spine2, (float) Math.toRadians(3.5F),(float) Math.toRadians(-12.5F),(float) Math.toRadians(-5F));
		animator.rotate(neck1, (float) Math.toRadians(15F),(float) Math.toRadians(-10F),0);
		animator.rotate(neck2, (float) Math.toRadians(12.5F),(float) Math.toRadians(-10F),0);
		animator.rotate(head, (float) Math.toRadians(2.5F),(float) Math.toRadians(15F),0);
		animator.rotate(jaw,(float) Math.toRadians(2.5F),0,0);
		animator.rotate(left_leg,0,0,(float) Math.toRadians(-5F));
		animator.move(left_leg,0,4,-12.5F);
		animator.rotate(left_front_leg,(float) Math.toRadians(42.5F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-25F),0,(float) Math.toRadians(7.5F));
		animator.rotate(right_leg,(float) Math.toRadians(5F),0,(float) Math.toRadians(7.5F));
		animator.move(right_leg,0,-5f,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(40F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-30F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(8);

		animator.resetKeyframe(10);

		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_RIGHT_STOMP_EXTRA);
		animator.startKeyframe(0);
		animator.rotate(mid_pivot, (float) Math.toRadians(-15F),(float) Math.toRadians(7.5F), (float) Math.toRadians(6.0F));
		animator.move(mid_pivot, 0,12.4F, 0);
		animator.rotate(pelvis, 0,(float) Math.toRadians(-10F), 0);
		animator.rotate(tail1, 0,(float) Math.toRadians(-5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(2.5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(-17.5F),(float) Math.toRadians(-7.5F));
		animator.rotate(spine2, (float) Math.toRadians(3.5F),(float) Math.toRadians(12.5F),(float) Math.toRadians(5F));
		animator.rotate(neck1, (float) Math.toRadians(15F),(float) Math.toRadians(10F),0);
		animator.rotate(neck2, (float) Math.toRadians(12.5F),(float) Math.toRadians(10F),0);
		animator.rotate(head, (float) Math.toRadians(2.5F),(float) Math.toRadians(-15F),0);
		animator.rotate(jaw,(float) Math.toRadians(2.5F),0,0);
		animator.rotate(right_leg,0,0,(float) Math.toRadians(5F));
		animator.move(right_leg,0,4,-12.5F);
		animator.rotate(right_front_leg,(float) Math.toRadians(42.5F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-25F),0,(float) Math.toRadians(-7.5F));
		animator.rotate(left_leg,(float) Math.toRadians(5F),0,(float) Math.toRadians(-7.5F));
		animator.move(left_leg,0,-5f,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(40F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-30F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(12);
		animator.rotate(mid_pivot, (float) Math.toRadians(-17.5F),(float) Math.toRadians(7.5F), (float) Math.toRadians(7.5F));
		animator.move(mid_pivot, 0,-1, 0);
		animator.rotate(tail1, 0,(float) Math.toRadians(5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(20F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(15F), (float) Math.toRadians(2.5F));
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(7.5F), (float) Math.toRadians(7.5F));
		animator.rotate(spine1, (float) Math.toRadians(10F),(float) Math.toRadians(-12.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(spine2, (float) Math.toRadians(7.5F),(float) Math.toRadians(10F),(float) Math.toRadians(2.5F));
		animator.rotate(neck1, (float) Math.toRadians(7.5F),(float) Math.toRadians(10F),0);
		animator.rotate(neck2, (float) Math.toRadians(10F),(float) Math.toRadians(10F),0);
		animator.rotate(head, (float) Math.toRadians(-2.5F),(float) Math.toRadians(-15F),0);
		animator.rotate(jaw,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-50F),(float) Math.toRadians(12.5F),(float) Math.toRadians(15F));
		animator.move(right_leg,0,-4,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(50F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(15F),0,(float) Math.toRadians(-7.5F));
		animator.rotate(left_leg,(float) Math.toRadians(17.5F),0,(float) Math.toRadians(-7.5F));
		animator.move(left_leg,0,3,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(20F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-15F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(6);

		animator.startKeyframe(2);
		animator.rotate(mid_pivot, (float) Math.toRadians(-15F),(float) Math.toRadians(7.5F), (float) Math.toRadians(6.0F));
		animator.move(mid_pivot, 0,12.4F, 0);
		animator.rotate(pelvis, 0,(float) Math.toRadians(-10F), 0);
		animator.rotate(tail1, 0,(float) Math.toRadians(-5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(2.5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(12.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(spine1, (float) Math.toRadians(2.5F),(float) Math.toRadians(-17.5F),(float) Math.toRadians(-7.5F));
		animator.rotate(spine2, (float) Math.toRadians(3.5F),(float) Math.toRadians(12.5F),(float) Math.toRadians(5F));
		animator.rotate(neck1, (float) Math.toRadians(15F),(float) Math.toRadians(10F),0);
		animator.rotate(neck2, (float) Math.toRadians(12.5F),(float) Math.toRadians(10F),0);
		animator.rotate(head, (float) Math.toRadians(2.5F),(float) Math.toRadians(-15F),0);
		animator.rotate(jaw,(float) Math.toRadians(2.5F),0,0);
		animator.rotate(right_leg,0,0,(float) Math.toRadians(5F));
		animator.move(right_leg,0,4,-12.5F);
		animator.rotate(right_front_leg,(float) Math.toRadians(42.5F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-25F),0,(float) Math.toRadians(-7.5F));
		animator.rotate(left_leg,(float) Math.toRadians(5F),0,(float) Math.toRadians(-7.5F));
		animator.move(left_leg,0,-5f,0);
		animator.rotate(left_front_leg,(float) Math.toRadians(40F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-30F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(8);

		animator.resetKeyframe(10);


		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_ROAR);
		animator.startKeyframe(10);
		animator.rotate(pelvis, (float) Math.toRadians(15F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-55F),(float) Math.toRadians(5F), (float) Math.toRadians(-5F));
		animator.rotate(tail2, (float) Math.toRadians(10F),(float) Math.toRadians(15F), (float) Math.toRadians(5F));
		animator.rotate(tail3, (float) Math.toRadians(22.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(tail4, (float) Math.toRadians(35F),(float) Math.toRadians(15F), (float) Math.toRadians(5F));
		animator.rotate(spine1, (float) Math.toRadians(10F),0,0);
		animator.rotate(spine2, (float) Math.toRadians(12.5F),0,0);
		animator.rotate(neck1, (float) Math.toRadians(45F),(float) Math.toRadians(22.5F),(float) Math.toRadians(7.5F));
		animator.rotate(neck2, 0,(float) Math.toRadians(22.5F),0);
		animator.rotate(head, 0,(float) Math.toRadians(45F),0);
		animator.rotate(left_arm,(float) Math.toRadians(-35F),0,0);
		animator.rotate(left_front_arm,(float) Math.toRadians(-55F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(-35F),0,0);
		animator.rotate(right_front_arm,(float) Math.toRadians(-55F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-30F),0,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(35F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(5);
		animator.move(mid_pivot, 0,7, 0);
		animator.rotate(pelvis, (float) Math.toRadians(-5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-17.5F),0, (float) Math.toRadians(7.5F));
		animator.rotate(tail2, (float) Math.toRadians(-7.5F),(float) Math.toRadians(-27.5F), (float) Math.toRadians(1F));
		animator.rotate(tail3, (float) Math.toRadians(5F),(float) Math.toRadians(-42.5F), 0);
		animator.rotate(tail4, (float) Math.toRadians(27.5F),(float) Math.toRadians(-42.5F), (float) Math.toRadians(-2.5F));
		animator.rotate(spine1, (float) Math.toRadians(-22.5F),0,0);
		animator.rotate(spine2, (float) Math.toRadians(-32.5F),(float) Math.toRadians(-15F),(float) Math.toRadians(2.5F));
		animator.rotate(neck1, (float) Math.toRadians(15F),(float) Math.toRadians(-5F),(float) Math.toRadians(-1.5F));
		animator.rotate(neck2, (float) Math.toRadians(-25F),(float) Math.toRadians(-5F),0);
		animator.rotate(head, (float) Math.toRadians(-15F),(float) Math.toRadians(10F),0);
		animator.rotate(jaw, (float) Math.toRadians(45F),0,0);
		animator.rotate(left_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(20F),(float) Math.toRadians(-27.5F));
		animator.rotate(left_front_arm,(float) Math.toRadians(-15F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(-20F),(float) Math.toRadians(27.5F));
		animator.rotate(right_front_arm,(float) Math.toRadians(-15F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-20F),(float) Math.toRadians(-10F),0);
		animator.rotate(left_front_leg,(float) Math.toRadians(17.5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-20F),(float) Math.toRadians(10F),0);
		animator.rotate(right_front_leg,(float) Math.toRadians(17.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(7);
		animator.move(mid_pivot, 0,7, 0);
		animator.rotate(pelvis, (float) Math.toRadians(2.5F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(1.5F));
		animator.rotate(tail1, (float) Math.toRadians(-17.5F),(float) Math.toRadians(5F), (float) Math.toRadians(7.5F));
		animator.rotate(tail2, (float) Math.toRadians(5F),0, 0);
		animator.rotate(tail3, (float) Math.toRadians(17.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(37.5F),0, 0);
		animator.rotate(spine1, (float) Math.toRadians(-22.5F),(float) Math.toRadians(-10F),(float) Math.toRadians(3.5F));
		animator.rotate(spine2, (float) Math.toRadians(-32.5F),(float) Math.toRadians(-7.5F),(float) Math.toRadians(1.5F));
		animator.rotate(neck1, (float) Math.toRadians(15F),0,(float) Math.toRadians(-2.5F));
		animator.rotate(neck2, (float) Math.toRadians(-25F),(float) Math.toRadians(15F),(float) Math.toRadians(-7.5F));
		animator.rotate(head, (float) Math.toRadians(-20F),(float) Math.toRadians(27.5F),0);
		animator.rotate(jaw, (float) Math.toRadians(60F),0,0);

		animator.rotate(left_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(20F),(float) Math.toRadians(-27.5F));
		animator.rotate(left_front_arm,(float) Math.toRadians(-15F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(-20F),(float) Math.toRadians(27.5F));
		animator.rotate(right_front_arm,(float) Math.toRadians(-15F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-20F),(float) Math.toRadians(-10F),0);
		animator.rotate(left_front_leg,(float) Math.toRadians(17.5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-20F),(float) Math.toRadians(10F),0);
		animator.rotate(right_front_leg,(float) Math.toRadians(17.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(7);
		animator.move(mid_pivot, 0,7, 0);
		animator.rotate(pelvis, (float) Math.toRadians(2.5F),(float) Math.toRadians(-15F), (float) Math.toRadians(2.5F));
		animator.rotate(tail1, (float) Math.toRadians(-42.5F),(float) Math.toRadians(22.5F), (float) Math.toRadians(-12.5F));
		animator.rotate(tail2, (float) Math.toRadians(10F),(float) Math.toRadians(22.5F), (float) Math.toRadians(5F));
		animator.rotate(tail3, (float) Math.toRadians(22.5F),(float) Math.toRadians(27.5F), (float) Math.toRadians(10F));
		animator.rotate(tail4, (float) Math.toRadians(40F),(float) Math.toRadians(27.5F), (float) Math.toRadians(12.5F));
		animator.rotate(spine1, (float) Math.toRadians(-22.5F),(float) Math.toRadians(7.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(spine2, (float) Math.toRadians(-32.5F),(float) Math.toRadians(-2.5F),0);
		animator.rotate(neck1, (float) Math.toRadians(15F),(float) Math.toRadians(2.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(neck2, (float) Math.toRadians(-25F),(float) Math.toRadians(-15F),(float) Math.toRadians(3.5F));
		animator.rotate(head, (float) Math.toRadians(-20F),(float) Math.toRadians(-5F),(float) Math.toRadians(2.5F));
		animator.rotate(jaw, (float) Math.toRadians(45F),0,0);

		animator.rotate(left_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(20F),(float) Math.toRadians(-27.5F));
		animator.rotate(left_front_arm,(float) Math.toRadians(-15F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(-20F),(float) Math.toRadians(27.5F));
		animator.rotate(right_front_arm,(float) Math.toRadians(-15F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-20F),(float) Math.toRadians(-10F),0);
		animator.rotate(left_front_leg,(float) Math.toRadians(17.5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-20F),(float) Math.toRadians(10F),0);
		animator.rotate(right_front_leg,(float) Math.toRadians(17.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(7);
		animator.move(mid_pivot, 0,7, 0);
		animator.rotate(pelvis, (float) Math.toRadians(2.5F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(1.5F));
		animator.rotate(tail1, (float) Math.toRadians(-17.5F),(float) Math.toRadians(5F), (float) Math.toRadians(7.5F));
		animator.rotate(tail2, (float) Math.toRadians(5F),0, 0);
		animator.rotate(tail3, (float) Math.toRadians(17.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(37.5F),0, 0);
		animator.rotate(spine1, (float) Math.toRadians(-22.5F),(float) Math.toRadians(-10F),(float) Math.toRadians(3.5F));
		animator.rotate(spine2, (float) Math.toRadians(-32.5F),(float) Math.toRadians(-7.5F),(float) Math.toRadians(1.5F));
		animator.rotate(neck1, (float) Math.toRadians(15F),0,(float) Math.toRadians(-2.5F));
		animator.rotate(neck2, (float) Math.toRadians(-25F),(float) Math.toRadians(15F),(float) Math.toRadians(-7.5F));
		animator.rotate(head, (float) Math.toRadians(-20F),(float) Math.toRadians(27.5F),0);
		animator.rotate(jaw, (float) Math.toRadians(60F),0,0);

		animator.rotate(left_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(20F),(float) Math.toRadians(-27.5F));
		animator.rotate(left_front_arm,(float) Math.toRadians(-15F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(-20F),(float) Math.toRadians(27.5F));
		animator.rotate(right_front_arm,(float) Math.toRadians(-15F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-20F),(float) Math.toRadians(-10F),0);
		animator.rotate(left_front_leg,(float) Math.toRadians(17.5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-20F),(float) Math.toRadians(10F),0);
		animator.rotate(right_front_leg,(float) Math.toRadians(17.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(7);
		animator.move(mid_pivot, 0,7, 0);
		animator.rotate(pelvis, (float) Math.toRadians(2.5F),(float) Math.toRadians(-15F), (float) Math.toRadians(2.5F));
		animator.rotate(tail1, (float) Math.toRadians(-42.5F),(float) Math.toRadians(22.5F), (float) Math.toRadians(-12.5F));
		animator.rotate(tail2, (float) Math.toRadians(10F),(float) Math.toRadians(22.5F), (float) Math.toRadians(5F));
		animator.rotate(tail3, (float) Math.toRadians(22.5F),(float) Math.toRadians(27.5F), (float) Math.toRadians(10F));
		animator.rotate(tail4, (float) Math.toRadians(40F),(float) Math.toRadians(27.5F), (float) Math.toRadians(12.5F));
		animator.rotate(spine1, (float) Math.toRadians(-22.5F),(float) Math.toRadians(7.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(spine2, (float) Math.toRadians(-32.5F),(float) Math.toRadians(-2.5F),0);
		animator.rotate(neck1, (float) Math.toRadians(15F),(float) Math.toRadians(2.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(neck2, (float) Math.toRadians(-25F),(float) Math.toRadians(-15F),(float) Math.toRadians(3.5F));
		animator.rotate(head, (float) Math.toRadians(-20F),(float) Math.toRadians(-5F),(float) Math.toRadians(2.5F));
		animator.rotate(jaw, (float) Math.toRadians(45F),0,0);

		animator.rotate(left_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(20F),(float) Math.toRadians(-27.5F));
		animator.rotate(left_front_arm,(float) Math.toRadians(-15F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(12.5F),(float) Math.toRadians(-20F),(float) Math.toRadians(27.5F));
		animator.rotate(right_front_arm,(float) Math.toRadians(-15F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-20F),(float) Math.toRadians(-10F),0);
		animator.rotate(left_front_leg,(float) Math.toRadians(17.5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-20F),(float) Math.toRadians(10F),0);
		animator.rotate(right_front_leg,(float) Math.toRadians(17.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(12);
		animator.move(mid_pivot, 0,7, 0);
		animator.rotate(pelvis, (float) Math.toRadians(2.5F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(1.5F));
		animator.rotate(tail1, (float) Math.toRadians(-17.5F),(float) Math.toRadians(5F), (float) Math.toRadians(5F));
		animator.rotate(tail2, (float) Math.toRadians(5F),0, 0);
		animator.rotate(tail3, (float) Math.toRadians(17.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(37.5F),0, 0);
		animator.rotate(spine1, (float) Math.toRadians(-10F),(float) Math.toRadians(3F),(float) Math.toRadians(-1.5F));
		animator.rotate(spine2, (float) Math.toRadians(-32.5F),(float) Math.toRadians(-7.5F),(float) Math.toRadians(1.5F));
		animator.rotate(neck1, (float) Math.toRadians(15F),0,(float) Math.toRadians(-2.5F));
		animator.rotate(neck2, (float) Math.toRadians(-25F),(float) Math.toRadians(15F),(float) Math.toRadians(-7.5F));
		animator.rotate(head, (float) Math.toRadians(-20F),(float) Math.toRadians(27.5F),0);
		animator.rotate(jaw, (float) Math.toRadians(60F),0,0);

		animator.rotate(left_arm,(float) Math.toRadians(10F),(float) Math.toRadians(15F),(float) Math.toRadians(-20F));
		animator.rotate(left_front_arm,(float) Math.toRadians(-10F),0,0);
		animator.rotate(right_arm,(float) Math.toRadians(10F),(float) Math.toRadians(-15F),(float) Math.toRadians(20F));
		animator.rotate(right_front_arm,(float) Math.toRadians(-10F),0,0);
		animator.rotate(left_leg,(float) Math.toRadians(-15F),(float) Math.toRadians(-7.5F),0);
		animator.rotate(left_front_leg,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-15F),(float) Math.toRadians(7.5F),0);
		animator.rotate(right_front_leg,(float) Math.toRadians(12.5F),0,0);
		animator.endKeyframe();

		animator.resetKeyframe(15);



		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_TAIL_THREE);
		animator.startKeyframe(10);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(-170F), 0);
		animator.move(mid_pivot, 0,4, 0);
		animator.rotate(tail1, (float) Math.toRadians(-10F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(2.5F),0, 0);
		animator.rotate(tail3, (float) Math.toRadians(5F),0, 0);
		//animator.rotate(tail4, (float) Math.toRadians(22.5F),(float) Math.toRadians(-32.5F), (float) Math.toRadians(-5F));
		animator.rotate(spine1, (float) Math.toRadians(17.5F),0,0);
		animator.rotate(spine2, (float) Math.toRadians(-12.5F),0,0);
		animator.rotate(neck1, (float) Math.toRadians(32.5F),0,0);
		animator.rotate(neck2, (float) Math.toRadians(2.5F),(float) Math.toRadians(7.5F),(float) Math.toRadians(1.5F));
		animator.rotate(head, (float) Math.toRadians(-1.5F),(float) Math.toRadians(12.5F),(float) Math.toRadians(-1.5F));
		animator.rotate(jaw,(float) Math.toRadians(15F),0,0);
		animator.rotate(left_leg,0,0,(float) Math.toRadians(-7.5F));
		animator.rotate(left_front_leg,(float) Math.toRadians(12.5F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-15F),(float) Math.toRadians(3.5F),(float) Math.toRadians(5F));
		animator.rotate(left_foot,(float) Math.toRadians(5F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-9F),0,(float) Math.toRadians(1.5F));
		animator.move(right_leg,0,-0.75f,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(15F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-10F),0,(float) Math.toRadians(-1.5F));
		animator.rotate(right_foot,(float) Math.toRadians(12.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(10);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(-170F), 0);
		animator.move(mid_pivot, 0,8, 0);
		animator.rotate(pelvis, (float) Math.toRadians(10F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-22.5F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(10F),0, 0);
		animator.rotate(tail3, (float) Math.toRadians(17.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(20F),0, 0);
		animator.rotate(spine1, (float) Math.toRadians(32.5F),0,0);
		animator.rotate(spine2, (float) Math.toRadians(-25F),0,0);
		animator.rotate(neck1, (float) Math.toRadians(25F),(float) Math.toRadians(22.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(neck2, (float) Math.toRadians(5F),(float) Math.toRadians(12.5F),(float) Math.toRadians(2.5F));
		animator.rotate(head, (float) Math.toRadians(-2.5F),(float) Math.toRadians(25F),(float) Math.toRadians(-2.5F));
		animator.rotate(jaw,(float) Math.toRadians(10F),0,0);
		animator.rotate(left_leg,0,0,(float) Math.toRadians(-12.5F));
		animator.rotate(left_front_leg,(float) Math.toRadians(25F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-30F),(float) Math.toRadians(7.5F),(float) Math.toRadians(10F));
		animator.rotate(left_foot,(float) Math.toRadians(10F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-17.5F),0,(float) Math.toRadians(3F));
		animator.move(right_leg,0,-1.5F,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(30F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-20F),(float) Math.toRadians(-1.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(right_foot,(float) Math.toRadians(25F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(15);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(-170F), 0);
		animator.move(mid_pivot, 0,8, 0);
		animator.rotate(pelvis, (float) Math.toRadians(22.5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(35F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(27.5F),0, 0);
		animator.rotate(tail3, (float) Math.toRadians(45F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(57.5F),0, 0);
		animator.rotate(spine1, (float) Math.toRadians(22.5F),0,0);
		animator.rotate(spine2, (float) Math.toRadians(-25F),(float) Math.toRadians(27.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(neck1, (float) Math.toRadians(17.5F),(float) Math.toRadians(47.5F),(float) Math.toRadians(-5F));
		animator.rotate(neck2, (float) Math.toRadians(7.5F),(float) Math.toRadians(20F),(float) Math.toRadians(5F));
		animator.rotate(head, (float) Math.toRadians(-5F),(float) Math.toRadians(50F),(float) Math.toRadians(-5F));
	//	animator.rotate(jaw,(float) Math.toRadians(5F),0,0);
		animator.rotate(left_leg,0,0,(float) Math.toRadians(-12.5F));
		animator.rotate(left_front_leg,(float) Math.toRadians(25F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-30F),(float) Math.toRadians(7.5F),(float) Math.toRadians(10F));
		animator.rotate(left_foot,(float) Math.toRadians(10F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-35F),0,(float) Math.toRadians(6.5F));
		animator.move(right_leg,0,-3F,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(60F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-40F),(float) Math.toRadians(-3.3F),(float) Math.toRadians(-5F));
		animator.rotate(right_foot,(float) Math.toRadians(50F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(-170F), 0);
		animator.move(mid_pivot, 0,8, 0);
		animator.rotate(pelvis, (float) Math.toRadians(5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-45F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(7.5F),0, 0);
		animator.rotate(tail3, (float) Math.toRadians(22.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(35F),0, 0);
		animator.rotate(spine1, (float) Math.toRadians(32.5F),0,0);
		animator.rotate(spine2, (float) Math.toRadians(-35F),(float) Math.toRadians(27.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(neck1, (float) Math.toRadians(12.5F),(float) Math.toRadians(47.5F),(float) Math.toRadians(-5F));
		animator.rotate(neck2, (float) Math.toRadians(3.5F),(float) Math.toRadians(20F),(float) Math.toRadians(5F));
		animator.rotate(head, (float) Math.toRadians(-17.5F),(float) Math.toRadians(50F),(float) Math.toRadians(-5F));
		animator.rotate(jaw,(float) Math.toRadians(25F),0,0);
		animator.rotate(left_leg,0,0,(float) Math.toRadians(-12.5F));
		animator.rotate(left_front_leg,(float) Math.toRadians(25F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-30F),(float) Math.toRadians(7.5F),(float) Math.toRadians(10F));
		animator.rotate(left_foot,(float) Math.toRadians(10F),0,0);
		animator.rotate(right_leg,0,0,(float) Math.toRadians(12.5F));
		animator.move(right_leg,0,1F,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(25F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-30F),(float) Math.toRadians(-6.5F),(float) Math.toRadians(-10F));
		animator.rotate(right_foot,(float) Math.toRadians(7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(15);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(-170F), 0);
		animator.move(mid_pivot, 0,8, 0);
		animator.rotate(pelvis, (float) Math.toRadians(22.5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(35F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(27.5F),0, 0);
		animator.rotate(tail3, (float) Math.toRadians(45F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(57.5F),0, 0);
		animator.rotate(spine1, (float) Math.toRadians(22.5F),0,0);
		animator.rotate(spine2, (float) Math.toRadians(-25F),(float) Math.toRadians(27.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(neck1, (float) Math.toRadians(17.5F),(float) Math.toRadians(47.5F),(float) Math.toRadians(-5F));
		animator.rotate(neck2, (float) Math.toRadians(7.5F),(float) Math.toRadians(20F),(float) Math.toRadians(5F));
		animator.rotate(head, (float) Math.toRadians(-5F),(float) Math.toRadians(50F),(float) Math.toRadians(-5F));
		//	animator.rotate(jaw,(float) Math.toRadians(5F),0,0);
		animator.rotate(left_leg,0,0,(float) Math.toRadians(-12.5F));
		animator.rotate(left_front_leg,(float) Math.toRadians(25F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-30F),(float) Math.toRadians(7.5F),(float) Math.toRadians(10F));
		animator.rotate(left_foot,(float) Math.toRadians(10F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-35F),0,(float) Math.toRadians(6.5F));
		animator.move(right_leg,0,-3F,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(60F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-40F),(float) Math.toRadians(-3.3F),(float) Math.toRadians(-5F));
		animator.rotate(right_foot,(float) Math.toRadians(50F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(-170F), 0);
		animator.move(mid_pivot, 0,8, 0);
		animator.rotate(pelvis, (float) Math.toRadians(5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-45F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(7.5F),0, 0);
		animator.rotate(tail3, (float) Math.toRadians(22.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(35F),0, 0);
		animator.rotate(spine1, (float) Math.toRadians(32.5F),0,0);
		animator.rotate(spine2, (float) Math.toRadians(-35F),(float) Math.toRadians(27.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(neck1, (float) Math.toRadians(12.5F),(float) Math.toRadians(47.5F),(float) Math.toRadians(-5F));
		animator.rotate(neck2, (float) Math.toRadians(3.5F),(float) Math.toRadians(20F),(float) Math.toRadians(5F));
		animator.rotate(head, (float) Math.toRadians(-17.5F),(float) Math.toRadians(50F),(float) Math.toRadians(-5F));
		animator.rotate(jaw,(float) Math.toRadians(25F),0,0);
		animator.rotate(left_leg,0,0,(float) Math.toRadians(-12.5F));
		animator.rotate(left_front_leg,(float) Math.toRadians(25F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-30F),(float) Math.toRadians(7.5F),(float) Math.toRadians(10F));
		animator.rotate(left_foot,(float) Math.toRadians(10F),0,0);
		animator.rotate(right_leg,0,0,(float) Math.toRadians(12.5F));
		animator.move(right_leg,0,1F,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(25F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-30F),(float) Math.toRadians(-6.5F),(float) Math.toRadians(-10F));
		animator.rotate(right_foot,(float) Math.toRadians(7.5F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(15);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(-170F), 0);
		animator.move(mid_pivot, 0,8, 0);
		animator.rotate(pelvis, (float) Math.toRadians(22.5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(35F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(27.5F),0, 0);
		animator.rotate(tail3, (float) Math.toRadians(45F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(57.5F),0, 0);
		animator.rotate(spine1, (float) Math.toRadians(22.5F),0,0);
		animator.rotate(spine2, (float) Math.toRadians(-25F),(float) Math.toRadians(27.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(neck1, (float) Math.toRadians(17.5F),(float) Math.toRadians(47.5F),(float) Math.toRadians(-5F));
		animator.rotate(neck2, (float) Math.toRadians(7.5F),(float) Math.toRadians(20F),(float) Math.toRadians(5F));
		animator.rotate(head, (float) Math.toRadians(-5F),(float) Math.toRadians(50F),(float) Math.toRadians(-5F));
		//	animator.rotate(jaw,(float) Math.toRadians(5F),0,0);
		animator.rotate(left_leg,0,0,(float) Math.toRadians(-12.5F));
		animator.rotate(left_front_leg,(float) Math.toRadians(25F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-30F),(float) Math.toRadians(7.5F),(float) Math.toRadians(10F));
		animator.rotate(left_foot,(float) Math.toRadians(10F),0,0);
		animator.rotate(right_leg,(float) Math.toRadians(-35F),0,(float) Math.toRadians(6.5F));
		animator.move(right_leg,0,-3F,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(60F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-40F),(float) Math.toRadians(-3.3F),(float) Math.toRadians(-5F));
		animator.rotate(right_foot,(float) Math.toRadians(50F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(mid_pivot, (float) Math.toRadians(-5F),(float) Math.toRadians(-170F), 0);
		animator.move(mid_pivot, 0,8, 0);
		animator.rotate(pelvis, (float) Math.toRadians(5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-45F),0, 0);
		animator.rotate(tail2, (float) Math.toRadians(7.5F),0, 0);
		animator.rotate(tail3, (float) Math.toRadians(22.5F),0, 0);
		animator.rotate(tail4, (float) Math.toRadians(35F),0, 0);
		animator.rotate(spine1, (float) Math.toRadians(32.5F),0,0);
		animator.rotate(spine2, (float) Math.toRadians(-35F),(float) Math.toRadians(27.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(neck1, (float) Math.toRadians(12.5F),(float) Math.toRadians(47.5F),(float) Math.toRadians(-5F));
		animator.rotate(neck2, (float) Math.toRadians(3.5F),(float) Math.toRadians(20F),(float) Math.toRadians(5F));
		animator.rotate(head, (float) Math.toRadians(-17.5F),(float) Math.toRadians(50F),(float) Math.toRadians(-5F));
		animator.rotate(jaw,(float) Math.toRadians(25F),0,0);
		animator.rotate(left_leg,0,0,(float) Math.toRadians(-12.5F));
		animator.rotate(left_front_leg,(float) Math.toRadians(25F),0,0);
		animator.rotate(left_ankel_joint,(float) Math.toRadians(-30F),(float) Math.toRadians(7.5F),(float) Math.toRadians(10F));
		animator.rotate(left_foot,(float) Math.toRadians(10F),0,0);
		animator.rotate(right_leg,0,0,(float) Math.toRadians(12.5F));
		animator.move(right_leg,0,1F,0);
		animator.rotate(right_front_leg,(float) Math.toRadians(25F),0,0);
		animator.rotate(right_ankel_joint,(float) Math.toRadians(-30F),(float) Math.toRadians(-6.5F),(float) Math.toRadians(-10F));
		animator.rotate(right_foot,(float) Math.toRadians(7.5F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(15);

		animator.resetKeyframe(15);

		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_ROAR2);
		animator.startKeyframe(8);
		animator.rotate(root, 0,(float) Math.toRadians(10F), 0);
		animator.rotate(mid_pivot, 0,(float) Math.toRadians(1.5F), 0);
		animator.rotate(pelvis, (float) Math.toRadians(3F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-10F),(float) Math.toRadians(12.5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(15F), 0);
		animator.rotate(tail3, 0,(float) Math.toRadians(12.5F), 0);
		animator.rotate(tail4, 0,(float) Math.toRadians(15F), 0);
		//animator.rotate(spine1, 0,(float) Math.toRadians(15F), 0);
		animator.rotate(neck1, (float) Math.toRadians(3F),(float) Math.toRadians(10F), (float) Math.toRadians(-22.5F));
		animator.rotate(neck2, 0,(float) Math.toRadians(-10F), 0);
		animator.rotate(head, 0,(float) Math.toRadians(-17.5F), 0);
		//animator.rotate(jaw, (float) Math.toRadians(7.5F),0, 0);
		animator.rotate(left_arm, (float) Math.toRadians(-55F),(float) Math.toRadians(-5F), (float) Math.toRadians(-17.5F));
		animator.rotate(left_front_arm, (float) Math.toRadians(-47.5F),0, 0);
		animator.rotate(left_hand, (float) Math.toRadians(112.5F),0, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-42.5F),(float) Math.toRadians(5F), (float) Math.toRadians(5F));
		animator.rotate(right_front_arm, (float) Math.toRadians(-27.5F),0, 0);
		animator.rotate(right_hand, (float) Math.toRadians(107.5F),0, 0);
		animator.rotate(left_leg, 0,(float) Math.toRadians(-12.5F), 0);
		//animator.rotate(left_front_leg, 0,(float) Math.toRadians(-7.5F), 0);
		//	animator.rotate(right_leg, 0,0, 0);
		animator.endKeyframe();


		animator.startKeyframe(10);
		animator.rotate(root, 0,(float) Math.toRadians(-7.5F), 0);
		animator.rotate(mid_pivot, 0,0,(float) Math.toRadians(12.5F));
		animator.rotate(pelvis, (float) Math.toRadians(2.5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-20F),(float) Math.toRadians(5F), 0);
		animator.rotate(tail2, (float) Math.toRadians(7.5F),(float) Math.toRadians(5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(7.5F),(float) Math.toRadians(5F), 0);
		animator.rotate(tail4, (float) Math.toRadians(20F),(float) Math.toRadians(5F), 0);
		//animator.rotate(spine1, 0,(float) Math.toRadians(15F), 0);
		animator.rotate(neck1, (float) Math.toRadians(45F),(float) Math.toRadians(1F), (float) Math.toRadians(1F));
		animator.rotate(neck2, (float) Math.toRadians(-17.5F),(float) Math.toRadians(-3F), 0);
		animator.rotate(head, (float) Math.toRadians(-5F),(float) Math.toRadians(-10F), 0);
		//animator.rotate(jaw, (float) Math.toRadians(7.5F),0, 0);
		animator.rotate(left_arm, (float) Math.toRadians(-27.5F),(float) Math.toRadians(-2.5F), (float) Math.toRadians(-7.5F));
		animator.rotate(left_front_arm, (float) Math.toRadians(-62.5F),0, 0);
		animator.rotate(left_hand, (float) Math.toRadians(55F),0, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-20F),(float) Math.toRadians(2.5F), (float) Math.toRadians(2.5F));
		animator.rotate(right_front_arm, (float) Math.toRadians(-37.5F),0, 0);
		animator.rotate(right_hand, (float) Math.toRadians(55F),0, 0);
		animator.rotate(left_leg, (float) Math.toRadians(-37.5F),0, (float) Math.toRadians(-17.5F));
		animator.rotate(left_front_leg, (float) Math.toRadians(52.5F),0, 0);
		animator.rotate(right_leg, 0,0, (float) Math.toRadians(-12.5F));
		animator.move(right_leg, 0,4, 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(5);

		animator.startKeyframe(6);
		animator.rotate(root, 0,(float) Math.toRadians(-11.5F), 0);
		//animator.rotate(mid_pivot, 0,0,(float) Math.toRadians(12.5F));
		animator.rotate(pelvis, (float) Math.toRadians(-5F),(float) Math.toRadians(-1.2F), 0);
		animator.rotate(tail1, (float) Math.toRadians(-12.5F),(float) Math.toRadians(7.5F), 0);
		animator.rotate(tail2, (float) Math.toRadians(12.5F),(float) Math.toRadians(-10F), (float) Math.toRadians(-7.5F));
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(10F), (float) Math.toRadians(5F));
		animator.rotate(tail4, (float) Math.toRadians(5F),(float) Math.toRadians(7.5F), (float) Math.toRadians(-2F));
		animator.rotate(spine1, 0,(float) Math.toRadians(2.5F), 0);
		animator.rotate(neck1, (float) Math.toRadians(17.5F),(float) Math.toRadians(-5F), 0);
		animator.rotate(neck2, (float) Math.toRadians(-27.5F),(float) Math.toRadians(-5F), (float) Math.toRadians(2F));
		animator.rotate(head, (float) Math.toRadians(-25F),0, 0);
		animator.rotate(jaw, (float) Math.toRadians(42.5F),0, 0);
		//animator.rotate(left_arm, (float) Math.toRadians(-12.5F),(float) Math.toRadians(-1.5F), (float) Math.toRadians(-5F));
		animator.rotate(left_front_arm, (float) Math.toRadians(-45F),0, 0);
		animator.rotate(left_hand, (float) Math.toRadians(37.5F),0, 0);
		//	animator.rotate(right_arm, (float) Math.toRadians(-10F),0, (float) Math.toRadians(1.5F));
		animator.rotate(right_front_arm, (float) Math.toRadians(-25F),0, 0);
		animator.rotate(right_hand, (float) Math.toRadians(37.5F),0, 0);
		animator.rotate(left_leg, (float) Math.toRadians(-1F),(float) Math.toRadians(-5F), (float) Math.toRadians(-2.5F));
		//animator.rotate(left_front_leg, (float) Math.toRadians(52.5F),0, 0);
		animator.rotate(right_leg, 0,(float) Math.toRadians(17.5F), 0);
		animator.endKeyframe();

		animator.startKeyframe(30);
		animator.rotate(root, 0,(float) Math.toRadians(-6.66F), 0);
		animator.rotate(pelvis, (float) Math.toRadians(-2.85F),(float) Math.toRadians(-0.7F), 0);
		animator.rotate(tail1, (float) Math.toRadians(-7.5F),(float) Math.toRadians(2.5F), 0);
		animator.rotate(tail2, (float) Math.toRadians(15F),(float) Math.toRadians(5F), (float) Math.toRadians(-2.5F));
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(-3F), (float) Math.toRadians(-1.5F));
		animator.rotate(tail4, (float) Math.toRadians(20F),(float) Math.toRadians(12.5F), (float) Math.toRadians(-2.5F));
		animator.rotate(spine1, 0,(float) Math.toRadians(3.33F), 0);
		animator.rotate(neck1, (float) Math.toRadians(22.5F),(float) Math.toRadians(20F), (float) Math.toRadians(6F));
		animator.rotate(neck2, (float) Math.toRadians(-20F),(float) Math.toRadians(7.5F),(float) Math.toRadians(-2.5F));
		animator.rotate(head, (float) Math.toRadians(-15F),0, 0);
		animator.rotate(jaw, (float) Math.toRadians(50F),0, 0);
		//animator.rotate(left_arm, (float) Math.toRadians(-12.5F),(float) Math.toRadians(-1.5F), (float) Math.toRadians(-5F));
		animator.rotate(left_front_arm, (float) Math.toRadians(-25F),0, 0);
		animator.rotate(left_hand, (float) Math.toRadians(22.5F),0, 0);
		//	animator.rotate(right_arm, (float) Math.toRadians(-10F),0, (float) Math.toRadians(1.5F));
		animator.rotate(right_front_arm, (float) Math.toRadians(-15F),0, 0);
		animator.rotate(right_hand, (float) Math.toRadians(22.5F),0, 0);
		animator.rotate(left_leg, (float) Math.toRadians(-0.5F),(float) Math.toRadians(-2.5F), (float) Math.toRadians(-1.0F));
		//animator.rotate(left_front_leg, (float) Math.toRadians(52.5F),0, 0);
		animator.rotate(right_leg, 0,(float) Math.toRadians(10F), 0);
		animator.endKeyframe();

		animator.resetKeyframe(10);

		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_PHASE_ROAR);
		animator.startKeyframe(8);
		animator.rotate(root, 0,(float) Math.toRadians(-10F), 0);
		animator.rotate(mid_pivot, 0,(float) Math.toRadians(-1.5F), 0);
		animator.rotate(pelvis, (float) Math.toRadians(3F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-10F),(float) Math.toRadians(-12.5F), 0);
		animator.rotate(tail2, 0,(float) Math.toRadians(-15F), 0);
		animator.rotate(tail3, 0,(float) Math.toRadians(-12.5F), 0);
		animator.rotate(tail4, 0,(float) Math.toRadians(-15F), 0);
		animator.rotate(neck1, (float) Math.toRadians(3F),(float) Math.toRadians(-10F), (float) Math.toRadians(22.5F));
		animator.rotate(neck2, 0,(float) Math.toRadians(10F), 0);
		animator.rotate(head, 0,(float) Math.toRadians(17.5F), 0);

		animator.rotate(right_arm, (float) Math.toRadians(-55F),(float) Math.toRadians(5F), (float) Math.toRadians(17.5F));
		animator.rotate(right_front_arm, (float) Math.toRadians(-47.5F),0, 0);
		animator.rotate(right_hand, (float) Math.toRadians(112.5F),0, 0);
		animator.rotate(left_arm, (float) Math.toRadians(-42.5F),(float) Math.toRadians(-5F), (float) Math.toRadians(-5F));
		animator.rotate(left_front_arm, (float) Math.toRadians(-27.5F),0, 0);
		animator.rotate(left_hand, (float) Math.toRadians(107.5F),0, 0);
		animator.rotate(right_leg, 0,(float) Math.toRadians(12.5F), 0);
		animator.endKeyframe();


		animator.startKeyframe(10);
		animator.rotate(root, 0,(float) Math.toRadians(7.5F), 0);
		animator.rotate(mid_pivot, 0,0,(float) Math.toRadians(-12.5F));
		animator.rotate(pelvis, (float) Math.toRadians(2.5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-20F),(float) Math.toRadians(-5F), 0);
		animator.rotate(tail2, (float) Math.toRadians(7.5F),(float) Math.toRadians(-5F), 0);
		animator.rotate(tail3, (float) Math.toRadians(7.5F),(float) Math.toRadians(-5F), 0);
		animator.rotate(tail4, (float) Math.toRadians(20F),(float) Math.toRadians(-5F), 0);
		animator.rotate(neck1, (float) Math.toRadians(45F),(float) Math.toRadians(-1F), (float) Math.toRadians(-1F));
		animator.rotate(neck2, (float) Math.toRadians(-17.5F),(float) Math.toRadians(3F), 0);
		animator.rotate(head, (float) Math.toRadians(-5F),(float) Math.toRadians(10F), 0);

		animator.rotate(right_arm, (float) Math.toRadians(-27.5F),(float) Math.toRadians(2.5F), (float) Math.toRadians(7.5F));
		animator.rotate(right_front_arm, (float) Math.toRadians(-62.5F),0, 0);
		animator.rotate(right_hand, (float) Math.toRadians(55F),0, 0);
		animator.rotate(left_arm, (float) Math.toRadians(-20F),(float) Math.toRadians(-2.5F), (float) Math.toRadians(-2.5F));
		animator.rotate(left_front_arm, (float) Math.toRadians(-37.5F),0, 0);
		animator.rotate(left_hand, (float) Math.toRadians(55F),0, 0);
		animator.rotate(right_leg, (float) Math.toRadians(-37.5F),0, (float) Math.toRadians(17.5F));
		animator.rotate(right_front_leg, (float) Math.toRadians(52.5F),0, 0);
		animator.rotate(left_leg, 0,0, (float) Math.toRadians(12.5F));
		animator.move(left_leg, 0,4, 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(5);

		animator.startKeyframe(6);
		animator.rotate(root, 0,(float) Math.toRadians(11.5F), 0);
		animator.rotate(pelvis, (float) Math.toRadians(-5F),(float) Math.toRadians(1.2F), 0);
		animator.rotate(tail1, (float) Math.toRadians(-12.5F),(float) Math.toRadians(-7.5F), 0);
		animator.rotate(tail2, (float) Math.toRadians(12.5F),(float) Math.toRadians(10F), (float) Math.toRadians(7.5F));
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(-10F), (float) Math.toRadians(-5F));
		animator.rotate(tail4, (float) Math.toRadians(5F),(float) Math.toRadians(-7.5F), (float) Math.toRadians(2F));
		animator.rotate(spine1, 0,(float) Math.toRadians(-2.5F), 0);
		animator.rotate(neck1, (float) Math.toRadians(17.5F),(float) Math.toRadians(5F), 0);
		animator.rotate(neck2, (float) Math.toRadians(-27.5F),(float) Math.toRadians(5F), (float) Math.toRadians(-2F));
		animator.rotate(head, (float) Math.toRadians(-25F),0, 0);
		animator.rotate(jaw, (float) Math.toRadians(42.5F),0, 0);

		animator.rotate(right_front_arm, (float) Math.toRadians(-45F),0, 0);
		animator.rotate(right_hand, (float) Math.toRadians(37.5F),0, 0);
		animator.rotate(left_front_arm, (float) Math.toRadians(-25F),0, 0);
		animator.rotate(left_hand, (float) Math.toRadians(37.5F),0, 0);
		animator.rotate(right_leg, (float) Math.toRadians(-1F),(float) Math.toRadians(5F), (float) Math.toRadians(2.5F));
		animator.rotate(left_leg, 0,(float) Math.toRadians(-17.5F), 0);
		animator.endKeyframe();

		animator.startKeyframe(30);
		animator.rotate(root, 0,(float) Math.toRadians(6.66F), 0);
		animator.rotate(pelvis, (float) Math.toRadians(-2.85F),(float) Math.toRadians(-.7F), 0);
		animator.rotate(tail1, (float) Math.toRadians(-7.5F),(float) Math.toRadians(-2.5F), 0);
		animator.rotate(tail2, (float) Math.toRadians(15F),(float) Math.toRadians(-5F), (float) Math.toRadians(2.5F));
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(3F), (float) Math.toRadians(1.5F));
		animator.rotate(tail4, (float) Math.toRadians(20F),(float) Math.toRadians(-12.5F), (float) Math.toRadians(2.5F));
		animator.rotate(spine1, 0,(float) Math.toRadians(-3.33F), 0);
		animator.rotate(neck1, (float) Math.toRadians(22.5F),(float) Math.toRadians(-20F), (float) Math.toRadians(-6F));
		animator.rotate(neck2, (float) Math.toRadians(-20F),(float) Math.toRadians(-7.5F),(float) Math.toRadians(2.5F));
		animator.rotate(head, (float) Math.toRadians(-15F),0, 0);
		animator.rotate(jaw, (float) Math.toRadians(50F),0, 0);

		animator.rotate(right_front_arm, (float) Math.toRadians(-25F),0, 0);
		animator.rotate(right_hand, (float) Math.toRadians(22.5F),0, 0);
		animator.rotate(left_front_arm, (float) Math.toRadians(-15F),0, 0);
		animator.rotate(left_hand, (float) Math.toRadians(22.5F),0, 0);
		animator.rotate(right_leg, (float) Math.toRadians(-0.5F),(float) Math.toRadians(2.5F), (float) Math.toRadians(1.0F));
		animator.rotate(left_leg, 0,(float) Math.toRadians(-10F), 0);
		animator.endKeyframe();

		animator.resetKeyframe(10);



		animator.setAnimation(Ancient_Remnant_Entity.REMNANT_DEATH);
		animator.startKeyframe(12);
		animator.rotate(root, 0,(float) Math.toRadians(8.5F), 0);
		animator.move(root, 0,4.3F, 0);
		animator.rotate(pelvis, (float) Math.toRadians(-10F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-10F),(float) Math.toRadians(-5F), (float) Math.toRadians(1.5F));
		animator.rotate(tail2, (float) Math.toRadians(10F),(float) Math.toRadians(10F), (float) Math.toRadians(5F));
		animator.rotate(tail3, (float) Math.toRadians(10F),(float) Math.toRadians(7.5F), (float) Math.toRadians(10F));
		animator.rotate(tail4, (float) Math.toRadians(15F),(float) Math.toRadians(10F), (float) Math.toRadians(5F));
		animator.rotate(spine1, 0,(float) Math.toRadians(-7.5F), 0);
		animator.rotate(neck1, (float) Math.toRadians(12.5F),0,0);
		animator.rotate(neck2, (float) Math.toRadians(30F),0, 0);
		animator.rotate(head, (float) Math.toRadians(-10F),(float) Math.toRadians(2.5F), (float) Math.toRadians(-17.5F));
		animator.rotate(jaw, (float) Math.toRadians(12.5F),0, 0);
		animator.rotate(chain1, (float) Math.toRadians(-32.5F),0, 0);
		animator.rotate(chain2, (float) Math.toRadians(5F),0, 0);
		//animator.rotate(chain3, 0,0, 0);
		//animator.rotate(chain4, 0,0, 0);

		animator.rotate(left_arm, (float) Math.toRadians(-10F),(float) Math.toRadians(-37.5F), (float) Math.toRadians(-22.5F));
		animator.rotate(left_front_arm, (float) Math.toRadians(-40F),0, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-22.5F),(float) Math.toRadians(25F),0);
		animator.rotate(right_front_arm, (float) Math.toRadians(-32.5F),0, 0);
		animator.rotate(left_leg, (float) Math.toRadians(-6.5F),0, 0);
		animator.rotate(left_front_leg, (float) Math.toRadians(12.5F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-5F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-10F),(float) Math.toRadians(6F), (float) Math.toRadians(2.5F));
		animator.rotate(right_front_leg, (float) Math.toRadians(12.5F),0,0);
		animator.endKeyframe();


		animator.startKeyframe(4);
		animator.rotate(root, 0,(float) Math.toRadians(12.5F), 0);
		animator.move(root, 0,5.8F, 0);
		animator.rotate(pelvis, (float) Math.toRadians(-12.5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-12.5F),(float) Math.toRadians(-5F), (float) Math.toRadians(2.5F));
		animator.rotate(tail2, (float) Math.toRadians(12.5F),(float) Math.toRadians(12.5F), (float) Math.toRadians(5F));
		animator.rotate(tail3, (float) Math.toRadians(12.5F),(float) Math.toRadians(12.5F), (float) Math.toRadians(12.5F));
		animator.rotate(tail4, (float) Math.toRadians(20F),(float) Math.toRadians(15F), (float) Math.toRadians(5F));
		//animator.rotate(spine1, 0,(float) Math.toRadians(-7.5F), 0);
		animator.rotate(neck1, (float) Math.toRadians(17.5F),0,0);
		animator.rotate(neck2, (float) Math.toRadians(40F),0, 0);
		animator.rotate(head, (float) Math.toRadians(-20F),(float) Math.toRadians(2.5F), (float) Math.toRadians(15F));
		animator.rotate(jaw, (float) Math.toRadians(15F),0, 0);
		animator.rotate(chain1, (float) Math.toRadians(-45F),0, 0);
		animator.rotate(chain2, (float) Math.toRadians(5F),0, 0);
		animator.rotate(chain3, (float) Math.toRadians(-5F),0, 0);
		animator.rotate(chain4, (float) Math.toRadians(-6.25F),0, 0);

		animator.rotate(left_arm, (float) Math.toRadians(-10F),(float) Math.toRadians(-37.5F), (float) Math.toRadians(-22.5F));
		animator.rotate(left_front_arm, (float) Math.toRadians(-40F),0, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-22.5F),(float) Math.toRadians(25F),0);
		animator.rotate(right_front_arm, (float) Math.toRadians(-22.5F),0, 0);
		animator.rotate(left_leg, (float) Math.toRadians(-8.5F),0, 0);
		animator.rotate(left_front_leg, (float) Math.toRadians(17.5F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-7.5F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-12.5F),(float) Math.toRadians(7.5F), (float) Math.toRadians(2.5F));
		animator.rotate(right_front_leg, (float) Math.toRadians(15F),0,0);
		animator.endKeyframe();

		animator.startKeyframe(12);
		animator.rotate(root, 0,(float) Math.toRadians(20F), 0);
		animator.move(root, 0,10F, 0);
		animator.rotate(pelvis, (float) Math.toRadians(-22.5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-22.5F),(float) Math.toRadians(-10F), (float) Math.toRadians(3.5F));
		animator.rotate(tail2, (float) Math.toRadians(25F),(float) Math.toRadians(20F), (float) Math.toRadians(10F));
		animator.rotate(tail3, (float) Math.toRadians(22.5F),(float) Math.toRadians(20F), (float) Math.toRadians(22.5F));
		animator.rotate(tail4, (float) Math.toRadians(35F),(float) Math.toRadians(25F), (float) Math.toRadians(9F));
		animator.rotate(spine1, (float) Math.toRadians(-17.5F),0, 0);
		animator.rotate(neck1, (float) Math.toRadians(-27.5F),0,0);
	//	animator.rotate(neck2, (float) Math.toRadians(40F),0, 0);
		animator.rotate(head, (float) Math.toRadians(-32.5F),0,0);
		animator.rotate(jaw, (float) Math.toRadians(47.5F),0, 0);
		animator.rotate(chain1, (float) Math.toRadians(35F),0, 0);
		animator.rotate(chain2, (float) Math.toRadians(32.5F),0, 0);
		animator.rotate(chain3, (float) Math.toRadians(10F),0, 0);
		animator.rotate(chain4, (float) Math.toRadians(-25F),0, 0);

		animator.rotate(left_arm, (float) Math.toRadians(-25F),(float) Math.toRadians(-37.5F), (float) Math.toRadians(-45F));
		//animator.rotate(left_front_arm, (float) Math.toRadians(-40F),0, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-65F),(float) Math.toRadians(14F),(float) Math.toRadians(12.5F));
		animator.rotate(right_front_arm, (float) Math.toRadians(7.5F),0, 0);
		animator.rotate(left_leg, (float) Math.toRadians(-15F),0, 0);
		animator.rotate(left_front_leg, (float) Math.toRadians(30F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-12.5F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-22.5F),(float) Math.toRadians(13.5F), (float) Math.toRadians(5F));
		animator.rotate(right_front_leg, (float) Math.toRadians(27.5F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(20);

		animator.startKeyframe(5);
		animator.rotate(root, 0,(float) Math.toRadians(20F), 0);
		animator.move(root, 0,10F, 0);
		animator.rotate(pelvis, (float) Math.toRadians(-22.5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-22.5F),(float) Math.toRadians(-10F), (float) Math.toRadians(3.5F));
		animator.rotate(tail2, (float) Math.toRadians(25F),(float) Math.toRadians(20F), (float) Math.toRadians(10F));
		animator.rotate(tail3, (float) Math.toRadians(22.5F),(float) Math.toRadians(20F), (float) Math.toRadians(22.5F));
		animator.rotate(tail4, (float) Math.toRadians(35F),(float) Math.toRadians(25F), (float) Math.toRadians(9F));
		animator.rotate(spine1, (float) Math.toRadians(-17.5F),0, 0);
		animator.rotate(neck1, (float) Math.toRadians(-27.5F),0,0);
		animator.rotate(neck2, (float) Math.toRadians(-5F),(float) Math.toRadians(5F), 0);
		animator.rotate(head, (float) Math.toRadians(-32.5F),0,0);
		animator.rotate(jaw, (float) Math.toRadians(47.5F),0, 0);
		animator.rotate(chain1, (float) Math.toRadians(35F),0, 0);
		animator.rotate(chain2, (float) Math.toRadians(32.5F),0, 0);
		animator.rotate(chain3, (float) Math.toRadians(10F),0, 0);
		animator.rotate(chain4, (float) Math.toRadians(-25F),0, 0);

		animator.rotate(left_arm, (float) Math.toRadians(-25F),(float) Math.toRadians(-37.5F), (float) Math.toRadians(-45F));
		//animator.rotate(left_front_arm, (float) Math.toRadians(-40F),0, 0);
		animator.rotate(right_arm, (float) Math.toRadians(-92.5F),(float) Math.toRadians(60F),(float) Math.toRadians(-12.5F));
		animator.move(right_arm, 0,58,39F);
		animator.rotate(right_front_arm, (float) Math.toRadians(85F),(float) Math.toRadians(-30F), (float) Math.toRadians(-37.5F));
		animator.rotate(left_leg, (float) Math.toRadians(-15F),0, 0);
		animator.rotate(left_front_leg, (float) Math.toRadians(30F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-12.5F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-22.5F),(float) Math.toRadians(13.5F), (float) Math.toRadians(5F));
		animator.rotate(right_front_leg, (float) Math.toRadians(27.5F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(5);

		animator.startKeyframe(5);
		animator.rotate(root, 0,(float) Math.toRadians(20F), 0);
		animator.move(root, 0,10F, 0);
		animator.rotate(pelvis, (float) Math.toRadians(-22.5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-22.5F),(float) Math.toRadians(-10F), (float) Math.toRadians(3.5F));
		animator.rotate(tail2, (float) Math.toRadians(25F),(float) Math.toRadians(20F), (float) Math.toRadians(10F));
		animator.rotate(tail3, (float) Math.toRadians(22.5F),(float) Math.toRadians(20F), (float) Math.toRadians(22.5F));
		animator.rotate(tail4, (float) Math.toRadians(35F),(float) Math.toRadians(25F), (float) Math.toRadians(9F));
		animator.rotate(spine1, (float) Math.toRadians(-17.5F),0, 0);
		animator.rotate(neck1, (float) Math.toRadians(-27.5F),0,0);
		animator.rotate(neck2, (float) Math.toRadians(-10F),(float) Math.toRadians(10F), 0);
		animator.rotate(head, (float) Math.toRadians(-32.5F),0,0);
		animator.rotate(jaw, (float) Math.toRadians(47.5F),0, 0);
		animator.rotate(chain1, (float) Math.toRadians(35F),0, 0);
		animator.rotate(chain2, (float) Math.toRadians(32.5F),0, 0);
		animator.rotate(chain3, (float) Math.toRadians(10F),0, 0);
		animator.rotate(chain4, (float) Math.toRadians(-25F),0, 0);

		animator.rotate(left_arm, (float) Math.toRadians(-42.5F),(float) Math.toRadians(17.5F), (float) Math.toRadians(-70F));
		animator.move(left_arm, -15F,50F, 47F);
		animator.rotate(left_front_arm, (float) Math.toRadians(-1.5F),(float) Math.toRadians(-8F), (float) Math.toRadians(22.5F));
		animator.rotate(right_arm, (float) Math.toRadians(-92.5F),(float) Math.toRadians(60F),(float) Math.toRadians(-12.5F));
		animator.move(right_arm, 0,58,39F);
		animator.rotate(right_front_arm, (float) Math.toRadians(85F),(float) Math.toRadians(-30F), (float) Math.toRadians(-37.5F));
		animator.rotate(left_leg, (float) Math.toRadians(-15F),0, 0);
		animator.rotate(left_front_leg, (float) Math.toRadians(30F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-12.5F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-22.5F),(float) Math.toRadians(13.5F), (float) Math.toRadians(5F));
		animator.rotate(right_front_leg, (float) Math.toRadians(27.5F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(5);
		animator.rotate(root, 0,(float) Math.toRadians(20F), 0);
		animator.move(root, 0,10F, 0);
		animator.rotate(pelvis, (float) Math.toRadians(-22.5F),0, 0);
		animator.rotate(tail1, (float) Math.toRadians(-22.5F),(float) Math.toRadians(-10F), (float) Math.toRadians(3.5F));
		animator.rotate(tail2, (float) Math.toRadians(25F),(float) Math.toRadians(20F), (float) Math.toRadians(10F));
		animator.rotate(tail3, (float) Math.toRadians(22.5F),(float) Math.toRadians(20F), (float) Math.toRadians(22.5F));
		animator.rotate(tail4, (float) Math.toRadians(35F),(float) Math.toRadians(25F), (float) Math.toRadians(9F));
		animator.rotate(spine1, (float) Math.toRadians(-17.5F),0, 0);
		animator.rotate(neck1, (float) Math.toRadians(-32.5F),(float) Math.toRadians(-37.5F),(float) Math.toRadians(82.5F));
		animator.move(neck1, 0,70,40);
		animator.rotate(neck2, (float) Math.toRadians(-15F),(float) Math.toRadians(15F), 0);
		animator.rotate(head, (float) Math.toRadians(-32.5F),0,0);
		animator.rotate(jaw, (float) Math.toRadians(47.5F),0, 0);
		animator.rotate(chain1, (float) Math.toRadians(35F),0, 0);
		animator.rotate(chain2, (float) Math.toRadians(32.5F),0, 0);
		animator.rotate(chain3, (float) Math.toRadians(10F),0, 0);
		animator.rotate(chain4, (float) Math.toRadians(-25F),0, 0);

		animator.rotate(left_arm, (float) Math.toRadians(-42.5F),(float) Math.toRadians(17.5F), (float) Math.toRadians(-70F));
		animator.move(left_arm, -15F,50F, 47F);
		animator.rotate(left_front_arm, (float) Math.toRadians(-2.5F),(float) Math.toRadians(-17.5F), (float) Math.toRadians(47.5F));
		animator.rotate(right_arm, (float) Math.toRadians(-92.5F),(float) Math.toRadians(60F),(float) Math.toRadians(-12.5F));
		animator.move(right_arm, 0,58,39F);
		animator.rotate(right_front_arm, (float) Math.toRadians(85F),(float) Math.toRadians(-30F), (float) Math.toRadians(-37.5F));
		animator.rotate(left_leg, (float) Math.toRadians(-15F),0, 0);
		animator.rotate(left_front_leg, (float) Math.toRadians(30F),0,0);
		animator.rotate(left_ankel_joint, (float) Math.toRadians(-12.5F),0,0);
		animator.rotate(right_leg, (float) Math.toRadians(-22.5F),(float) Math.toRadians(13.5F), (float) Math.toRadians(5F));
		animator.rotate(right_front_leg, (float) Math.toRadians(27.5F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(80);

	}

	@Override
	public void setupAnim(Ancient_Remnant_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		faceTarget(netHeadYaw, headPitch, 1, head);
		float globalSpeed = 0.25f;
		float globalDegree = 0.5F;

		float chargeSpeed = 0.5f;

		AdvancedModelPart[] tailBoxes = new AdvancedModelPart[]{tail1, tail2, tail3,tail4};
		AdvancedModelPart[] neckBoxes = new AdvancedModelPart[]{neck1, neck2, head};
		AdvancedModelPart[] chainBoxes = new AdvancedModelPart[]{chain1, chain2, chain3,chain4,chain5};
		//groinJoint.rotationPointY -= 1 * limbSwingAmount;

		float partialTick = Minecraft.getInstance().getFrameTime();
		float chargeProgress = entityIn.prevchargeProgress + (entityIn.chargeProgress - entityIn.prevchargeProgress) * partialTick;
		float activeProgress = entityIn.prevactiveProgress + (entityIn.activeProgress - entityIn.prevactiveProgress) * partialTick;

		if (chargeProgress <= 0F) {
			this.bob(pelvis, 2 * globalSpeed, globalDegree * 5, false, limbSwing, limbSwingAmount);

			walk(left_leg, 1F * globalSpeed, globalDegree * 1.4f, true, (float) Math.PI * 0.4f, 0F, limbSwing, limbSwingAmount);
			walk(right_leg, 1F * globalSpeed, globalDegree * 1.4f, true, (float) Math.PI * 1.4f, 0F, limbSwing, limbSwingAmount);

			this.left_leg.rotationPointY += Mth.clamp(Mth.sin(limbSwing * globalSpeed) * limbSwingAmount * 10, -Float.POSITIVE_INFINITY, 1);
			this.left_leg.rotationPointZ += Mth.cos(limbSwing * globalSpeed + (float) Math.PI) * limbSwingAmount * 10 + limbSwingAmount * -8;

			this.right_leg.rotationPointY += Mth.clamp(Mth.sin(limbSwing * globalSpeed + (float) Math.PI) * limbSwingAmount * 10, -Float.POSITIVE_INFINITY, 1);
			this.right_leg.rotationPointZ += Mth.cos(limbSwing * globalSpeed) * limbSwingAmount * 10 + limbSwingAmount * -8;
			//this.right_leg.rotationPointZ += Mth.cos(limbSwing * speed + offset) * degree * limbSwingAmount + weight * limbSwingAmount;

			walk(left_front_leg, 1F * globalSpeed, 1.2F * globalDegree, false, (float) Math.PI * 0.4f + 0.1f, 0.6F * globalDegree, limbSwing, limbSwingAmount);
			walk(right_front_leg, 1F * globalSpeed, 1.2F * globalDegree, false, (float) Math.PI * 1.4f + 0.1f, 0.6F * globalDegree, limbSwing, limbSwingAmount);

			walk(left_ankel_joint, 1F * globalSpeed, 1.2F * globalDegree, false, (float) Math.PI * 0.4f + 0.2f, -1.0F * globalDegree, limbSwing, limbSwingAmount);
			walk(right_ankel_joint, 1F * globalSpeed, 1.2F * globalDegree, false, (float) Math.PI * 1.4f + 0.2f, -1.0F * globalDegree, limbSwing, limbSwingAmount);

			walk(left_foot, 1F * globalSpeed, 1F * globalDegree, true, (float) Math.PI * 0.4f + 0.3f, -globalDegree * 1F, limbSwing, limbSwingAmount);
			walk(right_foot, 1F * globalSpeed, 1F * globalDegree, true, (float) Math.PI * 1.4f + 0.3f, -globalDegree * 1F, limbSwing, limbSwingAmount);

			this.walk(neck1, 0.6F * globalSpeed, globalDegree * 0.1F, false, 0.0f, -globalDegree * 0.1F, limbSwing, limbSwingAmount);
			this.walk(neck2, 0.6F * globalSpeed, globalDegree * 0.2F, true, 0.1f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);
			this.walk(head, 0.6F * globalSpeed, globalDegree * 0.1F, true, 0.2f, -globalDegree * 0.1F, limbSwing, limbSwingAmount);
			this.walk(jaw, 0.6F * globalSpeed, globalDegree * 0.25F, true, 0.2f, -globalDegree * 0.25F, limbSwing, limbSwingAmount);


			this.walk(right_arm, 0.6F * globalSpeed, globalDegree, false, (float) Math.PI * 0.4f, -globalDegree, limbSwing, limbSwingAmount);

			this.right_arm.rotationPointZ += Mth.cos(limbSwing * globalSpeed + (float) Math.PI) * limbSwingAmount * 8 + limbSwingAmount * 8;

			this.walk(left_arm, 0.6F * globalSpeed, globalDegree, false, (float) Math.PI * 1.4f, -globalDegree, limbSwing, limbSwingAmount);

			this.left_arm.rotationPointZ += Mth.cos(limbSwing * globalSpeed) * limbSwingAmount * 8 + limbSwingAmount * 8;


			this.walk(right_front_arm, 0.6F * globalSpeed, globalDegree * 0.3F, false, 0.1f, -globalDegree * 0.3F, limbSwing, limbSwingAmount);

			this.walk(left_front_arm, 0.6F * globalSpeed, globalDegree * 0.3F, false, 0.1f, -globalDegree * 0.3F, limbSwing, limbSwingAmount);

			this.walk(right_hand, 0.6F * globalSpeed, globalDegree * 0.4F, false, 0.1f, -globalDegree * 0.4F, limbSwing, limbSwingAmount);

			this.walk(left_hand, 0.6F * globalSpeed, globalDegree * 0.4F, false, 0.1f, -globalDegree * 0.4F, limbSwing, limbSwingAmount);

			this.walk(right_finger1, 0.6F * globalSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);

			this.walk(right_finger2, 0.6F * globalSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);

			this.walk(right_finger3, 0.6F * globalSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);

			this.walk(left_finger1, 0.6F * globalSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);

			this.walk(left_finger2, 0.6F * globalSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);

			this.walk(left_finger3, 0.6F * globalSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);

			this.swing(spine1, 1F * globalSpeed, globalDegree * 0.2F, false, 0.0f, 0, limbSwing, limbSwingAmount);

			this.swing(spine2, 1F * globalSpeed, globalDegree * 0.2F, false, 0.1f, 0, limbSwing, limbSwingAmount);

			this.chainSwing(tailBoxes, 1.2F * globalSpeed, globalDegree * 0.15F, 1, limbSwing, limbSwingAmount);

			this.chainSwing(neckBoxes, 0.6F * globalSpeed, globalDegree * 0.1F, 1, limbSwing, limbSwingAmount);

			this.chainWave(chainBoxes,  globalSpeed, globalDegree * 0.25F, 1, limbSwing, limbSwingAmount);
		}else{

			this.bob(pelvis, 2 * chargeSpeed, globalDegree * 5, false, limbSwing, limbSwingAmount);

			walk(left_leg, 0.75F * chargeSpeed, globalDegree * 1.4f, true, (float) Math.PI * 0.4f, globalDegree * 0.3f, limbSwing, limbSwingAmount);
			walk(right_leg, 0.75F * chargeSpeed, globalDegree * 1.4f, true, (float) Math.PI * 1.4f, globalDegree * 0.3f, limbSwing, limbSwingAmount);

			this.left_leg.rotationPointY += Mth.clamp(Mth.sin(limbSwing * 0.75F * chargeSpeed) * limbSwingAmount * 4, -Float.POSITIVE_INFINITY, 1);
			this.left_leg.rotationPointZ += Mth.cos(limbSwing * 0.75F * chargeSpeed + (float) Math.PI) * limbSwingAmount * 10 + limbSwingAmount * -8;

			this.right_leg.rotationPointY += Mth.clamp(Mth.sin(limbSwing * 0.75F * chargeSpeed + (float) Math.PI) * limbSwingAmount * 4, -Float.POSITIVE_INFINITY, 1);
			this.right_leg.rotationPointZ += Mth.cos(limbSwing * 0.75F * chargeSpeed) * limbSwingAmount * 10 + limbSwingAmount * -8;
			//this.right_leg.rotationPointZ += Mth.cos(limbSwing * speed + offset) * degree * limbSwingAmount + weight * limbSwingAmount;

			walk(left_front_leg, 0.75F * chargeSpeed, 0.8F * globalDegree, false, (float) Math.PI * 0.4f + 0.1f, 0.8F * globalDegree, limbSwing, limbSwingAmount);
			walk(right_front_leg, 0.75F * chargeSpeed, 0.8F * globalDegree, false, (float) Math.PI * 1.4f + 0.1f, 0.8F * globalDegree, limbSwing, limbSwingAmount);

			walk(left_ankel_joint, 0.75F * chargeSpeed, 1.2F * globalDegree, false, (float) Math.PI * 0.4f + 0.2f, -1.0F * globalDegree, limbSwing, limbSwingAmount);
			walk(right_ankel_joint, 0.75F * chargeSpeed, 1.2F * globalDegree, false, (float) Math.PI * 1.4f + 0.2f, -1.0F * globalDegree, limbSwing, limbSwingAmount);

			walk(left_foot, 0.75F * chargeSpeed, 1F * globalDegree, true, (float) Math.PI * 0.4f + 0.3f, -globalDegree * 1F, limbSwing, limbSwingAmount);
			walk(right_foot, 0.75F * chargeSpeed, 1F * globalDegree, true, (float) Math.PI * 1.4f + 0.3f, -globalDegree * 1F, limbSwing, limbSwingAmount);

			this.walk(neck1, 0.6F * chargeSpeed, globalDegree * 0.1F, false, 0.0f, -globalDegree * 0.1F, limbSwing, limbSwingAmount);
			this.walk(neck2, 0.6F * chargeSpeed, globalDegree * 0.2F, true, 0.1f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);
			this.walk(head, 0.6F * chargeSpeed, globalDegree * 0.1F, true, 0.2f, -globalDegree * 0.1F, limbSwing, limbSwingAmount);

			this.walk(right_arm, 2f * chargeSpeed, 0.05f, true, 0, -0.05f, limbSwing, limbSwingAmount);
			this.walk(left_arm, 2f * chargeSpeed, 0.05f, true, 0, -0.05f, limbSwing, limbSwingAmount);


			this.walk(right_front_arm, 2f * chargeSpeed, 0.125f, false, 0.1f, -0.125f, limbSwing, limbSwingAmount);

			this.walk(left_front_arm, 2f * chargeSpeed, 0.125f, false, 0.1f, -0.125f, limbSwing, limbSwingAmount);

			this.walk(right_hand, 2f * chargeSpeed, 0.125f, true, 0.1f, -0.125f, limbSwing, limbSwingAmount);

			this.walk(left_hand, 2f * chargeSpeed, 0.125f, true, 0.1f, -0.125f, limbSwing, limbSwingAmount);

			this.walk(right_finger1, 0.6F * chargeSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);

			this.walk(right_finger2, 0.6F * chargeSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);

			this.walk(right_finger3, 0.6F * chargeSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);

			this.walk(left_finger1, 0.6F * chargeSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);

			this.walk(left_finger2, 0.6F * chargeSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);

			this.walk(left_finger3, 0.6F * chargeSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, limbSwing, limbSwingAmount);

			this.walk(spine1, 2F * chargeSpeed, globalDegree * 0.05F, false, 0.0f, -globalDegree * 0.05F, limbSwing, limbSwingAmount);

			this.walk(spine2, 2F * chargeSpeed, globalDegree * 0.05F, false, 0.1f, -globalDegree * 0.05F, limbSwing, limbSwingAmount);


			this.swing(spine1, 0.35F * chargeSpeed, globalDegree * 0.2F, false, 0.0f, 0, limbSwing, limbSwingAmount);

			this.swing(spine2, 0.35F * chargeSpeed, globalDegree * 0.2F, false, 0.1f, 0, limbSwing, limbSwingAmount);

			this.chainSwing(tailBoxes, 1.2F * chargeSpeed, globalDegree * 0.15F, 1, limbSwing, limbSwingAmount);

			this.chainSwing(neckBoxes, 0.6F * chargeSpeed, globalDegree * 0.1F, 1, limbSwing, limbSwingAmount);

			this.chainWave(chainBoxes,  chargeSpeed, globalDegree * 0.25F, 1, limbSwing, limbSwingAmount);
		}
		if (activeProgress <= 0F) {
			this.walk(tail1, 0.1F * globalSpeed, globalDegree * 0.3F, true, 0, 0, ageInTicks, 1);
			this.walk(tail2, 0.1F * globalSpeed, globalDegree * 0.3F, false, 0.1f, 0, ageInTicks, 1);
			this.walk(tail3, 0.1F * globalSpeed, globalDegree * 0.3F, false, 0.2f, 0, ageInTicks, 1);
			this.walk(tail4, 0.1F * globalSpeed, globalDegree * 0.3F, false, 0.3f, 0, ageInTicks, 1);

			this.walk(neck1, 0.1F * globalSpeed, globalDegree * 0.1F, false, 0.0f, -globalDegree * 0.1F, ageInTicks, 1);
			this.walk(neck2, 0.1F * globalSpeed, globalDegree * 0.2F, true, 0.1f, -globalDegree * 0.2F, ageInTicks, 1);
			this.walk(head, 0.1F * globalSpeed, globalDegree * 0.1F, true, 0.2f, -globalDegree * 0.1F, ageInTicks, 1);
			this.walk(jaw, 0.1F * globalSpeed, globalDegree * 0.25F, true, 0.2f, -globalDegree * 0.25F, ageInTicks, 1);


			this.walk(right_arm, 0.1F * globalSpeed, globalDegree * 0.2F, true, 0.0f, -globalDegree * 0.2F, ageInTicks, 1);

			this.walk(left_arm, 0.1F * globalSpeed, globalDegree * 0.2F, true, 0.0f, -globalDegree * 0.2F, ageInTicks, 1);


			this.walk(right_front_arm, 0.1F * globalSpeed, globalDegree * 0.3F, false, 0.1f, -globalDegree * 0.3F, ageInTicks, 1);

			this.walk(left_front_arm, 0.1F * globalSpeed, globalDegree * 0.3F, false, 0.1f, -globalDegree * 0.3F, ageInTicks, 1);

			this.walk(right_hand, 0.1F * globalSpeed, globalDegree * 0.4F, false, 0.1f, -globalDegree * 0.4F, ageInTicks, 1);

			this.walk(left_hand, 0.1F * globalSpeed, globalDegree * 0.4F, false, 0.1f, -globalDegree * 0.4F, ageInTicks, 1);

			this.walk(right_finger1, 0.1F * globalSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, ageInTicks, 1);

			this.walk(right_finger2, 0.1F * globalSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, ageInTicks, 1);

			this.walk(right_finger3, 0.1F * globalSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, ageInTicks, 1);

			this.walk(left_finger1, 0.1F * globalSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, ageInTicks, 1);

			this.walk(left_finger2, 0.1F * globalSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, ageInTicks, 1);

			this.walk(left_finger3, 0.1F * globalSpeed, globalDegree * 0.2F, false, 0.125f, -globalDegree * 0.2F, ageInTicks, 1);

			this.bob(pelvis, 0.2F * globalSpeed, globalDegree * 2, false, ageInTicks, 1);
		}
		//this.left_leg.rotateAngleX += Mth.cos(limbSwing * cycle + (float) Math.PI * 1.4f) * limbSwingAmount * 0.5f;

		//this.right_leg.rotateAngleX += Mth.cos(limbSwing * cycle + (float) Math.PI * 0.4f) * limbSwingAmount * 0.5f;

		progressRotationPrev(root,chargeProgress,(float) Math.toRadians(-2.5F), 0, 0, 3f);
		progressPositionPrev(root,chargeProgress,0, 1, 2, 3f);
		progressRotationPrev(pelvis,chargeProgress,(float)Math.toRadians(25F), 0, 0, 3f);
		progressRotationPrev(tail1,chargeProgress,(float) Math.toRadians(-12.5F),(float) Math.toRadians(5F), 0, 3f);
		progressRotationPrev(tail2,chargeProgress,0, (float) Math.toRadians(5F), 0, 3f);
		progressRotationPrev(tail3,chargeProgress,(float) Math.toRadians(12.5F),(float) Math.toRadians(7.5F), 0, 3f);
		progressRotationPrev(tail4,chargeProgress,(float) Math.toRadians(20F),(float) Math.toRadians(7.5F), 0, 3f);
		progressRotationPrev(spine1,chargeProgress,(float)Math.toRadians(-10F), (float)Math.toRadians(-5F), 0, 3f);
		progressRotationPrev(spine2,chargeProgress,0, (float)Math.toRadians(5F), 0, 3f);
		progressRotationPrev(neck1,chargeProgress,(float) Math.toRadians(22.5F),(float) Math.toRadians(2.5F), 0, 3f);
		progressRotationPrev(neck2,chargeProgress,(float) Math.toRadians(-15F),(float) Math.toRadians(2.5F), 0, 3f);
		progressRotationPrev(head,chargeProgress,(float) Math.toRadians(-20F),(float) Math.toRadians(-2.5F), 0, 3f);
		progressRotationPrev(jaw,chargeProgress, (float) Math.toRadians(62.5F),0, 0, 3f);
		progressRotationPrev(right_front_arm,chargeProgress, (float) Math.toRadians(-7.5F),0, 0, 3f);
		progressRotationPrev(right_hand,chargeProgress, (float) Math.toRadians(22.5F),0, 0, 3f);
		progressRotationPrev(left_front_arm,chargeProgress, (float) Math.toRadians(-7.5F),0, 0, 3f);
		progressRotationPrev(left_hand,chargeProgress, (float) Math.toRadians(22.5F),0, 0, 3f);
		progressRotationPrev(legs,chargeProgress, (float) Math.toRadians(10F),0, 0, 3f);

		progressPositionPrev(root,activeProgress,0, 14, 0, 30f);
		progressRotationPrev(pelvis,activeProgress,(float) Math.toRadians(20F), 0, 0, 30f);
		progressRotationPrev(tail1,activeProgress,(float) Math.toRadians(10F), 0, 0, 30f);
		progressRotationPrev(tail2,activeProgress,(float) Math.toRadians(-12.5F), (float) Math.toRadians(27.5F), (float) Math.toRadians(12.5F), 30f);
		progressRotationPrev(tail3,activeProgress,(float) Math.toRadians(30F), (float) Math.toRadians(-5F), (float) Math.toRadians(2.5F), 30f);
		progressRotationPrev(tail4,activeProgress,(float) Math.toRadians(67.5F), 0,0, 30f);
		progressRotationPrev(neck1,activeProgress,(float) Math.toRadians(-7.5F), (float) Math.toRadians(5F),(float) Math.toRadians(-2.5F), 30f);
		progressRotationPrev(neck2,activeProgress,0, (float) Math.toRadians(17.5F),0, 30f);
		progressRotationPrev(head,activeProgress,(float) Math.toRadians(-27.5F), (float) Math.toRadians(22.5F),0, 30f);
		progressRotationPrev(jaw,activeProgress,(float) Math.toRadians(40F), (float) Math.toRadians(22.5F),0, 30f);
		progressRotationPrev(left_arm,activeProgress,(float) Math.toRadians(-5F), (float) Math.toRadians(17.5F),(float) Math.toRadians(5F), 30f);
		progressRotationPrev(left_front_arm,activeProgress,(float) Math.toRadians(-47.5F), 0,0, 30f);
		progressRotationPrev(right_arm,activeProgress,(float) Math.toRadians(-7.5F), (float) Math.toRadians(22.5F),(float) Math.toRadians(15F), 30f);
		progressRotationPrev(right_front_arm,activeProgress,(float) Math.toRadians(-32.5F), 0,0, 30f);
		progressRotationPrev(left_leg,activeProgress,(float) Math.toRadians(-35F), (float) Math.toRadians(-17.5F),(float) Math.toRadians(-1.5F), 30f);
		progressRotationPrev(left_front_leg,activeProgress,(float) Math.toRadians(32.5F),0,0, 30f);
		progressRotationPrev(right_leg,activeProgress,(float) Math.toRadians(-15F), (float) Math.toRadians(-2.5F),(float) Math.toRadians(17.5F), 30f);
		progressPositionPrev(right_leg,activeProgress,0, 6, 0, 30f);
		progressRotationPrev(right_front_leg,activeProgress,(float) Math.toRadians(22.5F),0,0, 30f);
		progressRotationPrev(right_ankel_joint,activeProgress,(float) Math.toRadians(-2.5F),0,(float) Math.toRadians(-25F), 30f);


		articulateLegs(entityIn.legSolver, partialTick);

		desert_necklace.showModel = entityIn.getIsAct();

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


	public void setRotationAngle(AdvancedModelPart AdvancedModelPart, float x, float y, float z) {
		AdvancedModelPart.rotateAngleX = x;
		AdvancedModelPart.rotateAngleY = y;
		AdvancedModelPart.rotateAngleZ = z;
	}

}