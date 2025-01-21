package com.github.L_Ender.cataclysm.client.model.entity;
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Ancient_Remnant_Animation;
import com.github.L_Ender.cataclysm.client.animation.Ancient_Remnant_Power_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.github.L_Ender.lionfishapi.server.animation.LegSolver;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class Ancient_Remnant_Rework_Model extends HierarchicalModel<Ancient_Remnant_Entity> {

	private final ModelPart root;
	private final ModelPart roots;
	private final ModelPart mid_pivot;
	private final ModelPart pelvis;
	private final ModelPart left_long_bone;
	private final ModelPart right_long_bone;
	private final ModelPart spine_sail2;
	private final ModelPart left_bone;
	private final ModelPart right_bone;
	private final ModelPart left_big_bone;
	private final ModelPart right_big_bone;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart tail4;
	private final ModelPart spine1;
	private final ModelPart spine2;
	private final ModelPart spine_sail1;
	private final ModelPart right_shoulder;
	private final ModelPart left_shoulder;
	private final ModelPart neck1;
	private final ModelPart neck2;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart crown;
	private final ModelPart under_crown;
	private final ModelPart right_crown1;
	private final ModelPart right_crown2;
	private final ModelPart left_crown;
	private final ModelPart left_crown2;
	private final ModelPart snake;
	private final ModelPart upper_crown;
	private final ModelPart desert_necklace;
	private final ModelPart chain1;
	private final ModelPart chain2;
	private final ModelPart chain3;
	private final ModelPart chain4;
	private final ModelPart chain5;
	private final ModelPart desert_eye;
	private final ModelPart eye;
	private final ModelPart left_arm;
	private final ModelPart left_front_arm;
	private final ModelPart left_hand;
	private final ModelPart left_finger3;
	private final ModelPart left_finger1;
	private final ModelPart left_finger2;
	private final ModelPart right_arm;
	private final ModelPart right_front_arm;
	private final ModelPart right_hand;
	private final ModelPart right_finger1;
	private final ModelPart right_finger2;
	private final ModelPart right_finger3;
	private final ModelPart spine_deco;
	private final ModelPart legs;
	private final ModelPart left_leg;
	private final ModelPart left_deco1;
	private final ModelPart left_front_leg;
	private final ModelPart left_ankel_joint;
	private final ModelPart left_mini_bone;
	private final ModelPart left_deco2;
	private final ModelPart left_deco3;
	private final ModelPart left_ankel;
	private final ModelPart left_foot;
	private final ModelPart left_toe;
	private final ModelPart left_toe2;
	private final ModelPart left_toe3;
	private final ModelPart right_leg;
	private final ModelPart right_deco1;
	private final ModelPart right_front_leg;
	private final ModelPart right_ankel_joint;
	private final ModelPart right_mini_bone;
	private final ModelPart right_deco2;
	private final ModelPart right_deco3;
	private final ModelPart right_ankel;
	private final ModelPart right_foot;
	private final ModelPart right_toe;
	private final ModelPart right_toe2;
	private final ModelPart right_toe3;

	public Ancient_Remnant_Rework_Model(ModelPart root) {
		this.root = root;
		this.roots = this.root.getChild("roots");
		this.mid_pivot = this.roots.getChild("mid_pivot");
		this.pelvis = this.mid_pivot.getChild("pelvis");
		this.left_long_bone = this.pelvis.getChild("left_long_bone");
		this.right_long_bone = this.pelvis.getChild("right_long_bone");
		this.spine_sail2 = this.pelvis.getChild("spine_sail2");
		this.left_bone = this.pelvis.getChild("left_bone");
		this.right_bone = this.pelvis.getChild("right_bone");
		this.left_big_bone = this.pelvis.getChild("left_big_bone");
		this.right_big_bone = this.pelvis.getChild("right_big_bone");
		this.tail1 = this.pelvis.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.tail3 = this.tail2.getChild("tail3");
		this.tail4 = this.tail3.getChild("tail4");
		this.spine1 = this.pelvis.getChild("spine1");
		this.spine2 = this.spine1.getChild("spine2");
		this.spine_sail1 = this.spine2.getChild("spine_sail1");
		this.right_shoulder = this.spine2.getChild("right_shoulder");
		this.left_shoulder = this.spine2.getChild("left_shoulder");
		this.neck1 = this.spine2.getChild("neck1");
		this.neck2 = this.neck1.getChild("neck2");
		this.head = this.neck2.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.crown = this.head.getChild("crown");
		this.under_crown = this.crown.getChild("under_crown");
		this.right_crown1 = this.under_crown.getChild("right_crown1");
		this.right_crown2 = this.right_crown1.getChild("right_crown2");
		this.left_crown = this.under_crown.getChild("left_crown");
		this.left_crown2 = this.left_crown.getChild("left_crown2");
		this.snake = this.crown.getChild("snake");
		this.upper_crown = this.crown.getChild("upper_crown");
		this.desert_necklace = this.neck2.getChild("desert_necklace");
		this.chain1 = this.desert_necklace.getChild("chain1");
		this.chain2 = this.chain1.getChild("chain2");
		this.chain3 = this.chain2.getChild("chain3");
		this.chain4 = this.chain3.getChild("chain4");
		this.chain5 = this.chain4.getChild("chain5");
		this.desert_eye = this.chain5.getChild("desert_eye");
		this.eye = this.desert_eye.getChild("eye");
		this.left_arm = this.spine2.getChild("left_arm");
		this.left_front_arm = this.left_arm.getChild("left_front_arm");
		this.left_hand = this.left_front_arm.getChild("left_hand");
		this.left_finger3 = this.left_hand.getChild("left_finger3");
		this.left_finger1 = this.left_hand.getChild("left_finger1");
		this.left_finger2 = this.left_hand.getChild("left_finger2");
		this.right_arm = this.spine2.getChild("right_arm");
		this.right_front_arm = this.right_arm.getChild("right_front_arm");
		this.right_hand = this.right_front_arm.getChild("right_hand");
		this.right_finger1 = this.right_hand.getChild("right_finger1");
		this.right_finger2 = this.right_hand.getChild("right_finger2");
		this.right_finger3 = this.right_hand.getChild("right_finger3");
		this.spine_deco = this.spine2.getChild("spine_deco");
		this.legs = this.mid_pivot.getChild("legs");
		this.left_leg = this.legs.getChild("left_leg");
		this.left_deco1 = this.left_leg.getChild("left_deco1");
		this.left_front_leg = this.left_leg.getChild("left_front_leg");
		this.left_ankel_joint = this.left_front_leg.getChild("left_ankel_joint");
		this.left_mini_bone = this.left_ankel_joint.getChild("left_mini_bone");
		this.left_deco2 = this.left_ankel_joint.getChild("left_deco2");
		this.left_deco3 = this.left_ankel_joint.getChild("left_deco3");
		this.left_ankel = this.left_ankel_joint.getChild("left_ankel");
		this.left_foot = this.left_ankel_joint.getChild("left_foot");
		this.left_toe = this.left_foot.getChild("left_toe");
		this.left_toe2 = this.left_foot.getChild("left_toe2");
		this.left_toe3 = this.left_foot.getChild("left_toe3");
		this.right_leg = this.legs.getChild("right_leg");
		this.right_deco1 = this.right_leg.getChild("right_deco1");
		this.right_front_leg = this.right_leg.getChild("right_front_leg");
		this.right_ankel_joint = this.right_front_leg.getChild("right_ankel_joint");
		this.right_mini_bone = this.right_ankel_joint.getChild("right_mini_bone");
		this.right_deco2 = this.right_ankel_joint.getChild("right_deco2");
		this.right_deco3 = this.right_ankel_joint.getChild("right_deco3");
		this.right_ankel = this.right_ankel_joint.getChild("right_ankel");
		this.right_foot = this.right_ankel_joint.getChild("right_foot");
		this.right_toe = this.right_foot.getChild("right_toe");
		this.right_toe2 = this.right_foot.getChild("right_toe2");
		this.right_toe3 = this.right_foot.getChild("right_toe3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition roots = partdefinition.addOrReplaceChild("roots", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition mid_pivot = roots.addOrReplaceChild("mid_pivot", CubeListBuilder.create(), PartPose.offset(0.0F, -69.0F, -10.0F));

		PartDefinition pelvis = mid_pivot.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(111, 42).addBox(-5.0F, -4.2211F, -9.2432F, 10.0F, 12.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition left_long_bone = pelvis.addOrReplaceChild("left_long_bone", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, -4.0F, 6.0F, 5.0F, 28.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -0.2211F, -8.2432F, -0.4185F, 0.1274F, 0.2783F));

		PartDefinition right_long_bone = pelvis.addOrReplaceChild("right_long_bone", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(-5.0F, -4.0F, 6.0F, 5.0F, 28.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, -0.2211F, -8.2432F, -0.4185F, -0.1274F, -0.2783F));

		PartDefinition spine_sail2 = pelvis.addOrReplaceChild("spine_sail2", CubeListBuilder.create().texOffs(65, 50).addBox(0.0F, -28.916F, -25.98F, 0.0F, 30.0F, 32.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -0.2211F, 12.7568F, 0.1745F, 0.0F, 0.0F));

		PartDefinition left_bone = pelvis.addOrReplaceChild("left_bone", CubeListBuilder.create().texOffs(194, 215).addBox(1.0F, 3.0F, 0.0F, 7.0F, 33.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -0.2211F, -8.2432F, 0.7811F, -0.0924F, 0.0928F));

		PartDefinition right_bone = pelvis.addOrReplaceChild("right_bone", CubeListBuilder.create().texOffs(194, 215).mirror().addBox(-8.0F, 3.0F, 0.0F, 7.0F, 33.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -0.2211F, -8.2432F, 0.7811F, 0.0924F, -0.0928F));

		PartDefinition left_big_bone = pelvis.addOrReplaceChild("left_big_bone", CubeListBuilder.create().texOffs(112, 124).addBox(1.0F, -2.0F, -1.0F, 9.0F, 14.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2211F, -8.2432F, 0.3186F, 0.1451F, -0.413F));

		PartDefinition right_big_bone = pelvis.addOrReplaceChild("right_big_bone", CubeListBuilder.create().texOffs(112, 124).mirror().addBox(-10.0F, -2.0F, -1.0F, 9.0F, 14.0F, 27.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.2211F, -8.2432F, 0.3186F, -0.1451F, 0.413F));

		PartDefinition tail1 = pelvis.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(98, 81).addBox(-4.0F, -5.916F, 1.02F, 8.0F, 10.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(47, 117).addBox(0.0F, -24.916F, -0.98F, 0.0F, 19.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(114, 197).addBox(0.0F, 4.084F, 6.02F, 0.0F, 6.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.7789F, 10.7568F, 0.0436F, 0.0F, 0.0F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 109).addBox(-3.5F, -3.7067F, -0.3098F, 7.0F, 7.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(148, 47).addBox(0.0F, 3.2933F, -0.3098F, 0.0F, 4.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(0, 149).addBox(0.0F, -6.7067F, -0.3098F, 0.0F, 3.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.8F, 32.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.7686F, -0.1825F, 6.0F, 6.0F, 37.0F, new CubeDeformation(0.0F))
		.texOffs(156, 13).addBox(0.0F, -6.7686F, -0.1825F, 0.0F, 4.0F, 29.0F, new CubeDeformation(0.0F))
		.texOffs(28, 198).addBox(0.0F, 3.2314F, -0.1825F, 0.0F, 4.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5762F, 31.5254F, -0.0436F, 0.0F, 0.0F));

		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(50, 7).addBox(-3.0F, -2.8005F, 0.2055F, 5.0F, 5.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.3649F, 34.6065F, -0.2618F, 0.0F, 0.0F));

		PartDefinition spine1 = pelvis.addOrReplaceChild("spine1", CubeListBuilder.create().texOffs(162, 143).addBox(-4.5F, -5.0F, -19.0F, 9.0F, 8.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(0, 185).addBox(3.0F, -3.0F, -19.0F, 11.0F, 18.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(145, 175).addBox(-14.0F, -3.0F, -19.0F, 11.0F, 18.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -5.0F));

		PartDefinition spine2 = spine1.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(158, 101).addBox(-4.5F, -5.0F, -23.0F, 9.0F, 8.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(200, 73).addBox(3.0F, -3.0F, -18.0F, 10.0F, 16.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(88, 190).addBox(-13.0F, -3.0F, -18.0F, 10.0F, 16.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(128, 229).addBox(1.8F, -7.1199F, -17.5887F, 4.0F, 5.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(93, 229).addBox(-5.8F, -7.1199F, -17.5887F, 4.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -19.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition spine_sail1 = spine2.addOrReplaceChild("spine_sail1", CubeListBuilder.create().texOffs(0, 44).addBox(0.0F, -18.916F, -52.98F, 0.0F, 32.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.2211F, 36.7568F, -0.0436F, 0.0F, 0.0F));

		PartDefinition right_shoulder = spine2.addOrReplaceChild("right_shoulder", CubeListBuilder.create().texOffs(176, 187).mirror().addBox(-23.0F, -3.0F, -17.0F, 5.0F, 5.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5314F, -0.5844F, -0.3136F));

		PartDefinition left_shoulder = spine2.addOrReplaceChild("left_shoulder", CubeListBuilder.create().texOffs(176, 187).addBox(18.0F, -3.0F, -17.0F, 5.0F, 5.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5314F, 0.5844F, 0.3136F));

		PartDefinition neck1 = spine2.addOrReplaceChild("neck1", CubeListBuilder.create().texOffs(204, 137).addBox(-3.5F, -4.0937F, -15.5774F, 8.0F, 9.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(186, 0).addBox(-3.5F, -4.0937F, -17.5774F, 8.0F, 18.0F, 16.0F, new CubeDeformation(0.7F))
		.texOffs(235, 0).addBox(0.5F, -10.0937F, -15.5774F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, -20.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition neck2 = neck1.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(217, 35).addBox(-3.0F, -4.0038F, -10.0872F, 7.0F, 8.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(33, 157).addBox(0.5F, -10.0038F, -10.0872F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0937F, -17.5774F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = neck2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(80, 124).addBox(-6.0F, -10.0F, -14.0F, 13.0F, 10.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(209, 175).addBox(-6.0F, -9.0F, -14.0F, 13.0F, 2.0F, 14.0F, new CubeDeformation(0.5F))
		.texOffs(44, 169).addBox(-3.5F, -7.0F, -35.0F, 8.0F, 7.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(0, 222).addBox(-3.5F, -7.0F, -20.0F, 8.0F, 32.0F, 6.0F, new CubeDeformation(0.5F))
		.texOffs(33, 50).addBox(-3.5F, 0.0F, -35.0F, 8.0F, 4.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -8.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(29, 228).addBox(-4.0F, -2.0F, -6.0F, 9.0F, 7.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(181, 47).addBox(-3.0F, 0.0F, -27.0F, 7.0F, 4.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(216, 198).addBox(-3.0F, 4.0F, -27.0F, 7.0F, 2.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(202, 112).addBox(-2.5F, -3.0F, -27.0F, 6.0F, 3.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -7.0F));

		PartDefinition crown = head.addOrReplaceChild("crown", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition under_crown = crown.addOrReplaceChild("under_crown", CubeListBuilder.create().texOffs(223, 218).addBox(-7.5F, 0.0F, -4.0F, 15.0F, 17.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -7.9063F, 1.5774F, -0.3054F, 0.0F, 0.0F));

		PartDefinition right_crown1 = under_crown.addOrReplaceChild("right_crown1", CubeListBuilder.create().texOffs(13, 149).addBox(-5.0F, -2.0F, 0.0F, 6.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(23, 0).addBox(-5.0F, -4.0F, 1.5F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(29, 19).addBox(1.0F, 0.0F, 1.5F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(158, 133).addBox(-5.0F, 6.0F, 0.0F, 9.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(80, 113).addBox(-5.0F, 15.0F, 0.0F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, 15.0F, 1.5F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(12.5F, 2.0F, -7.0F));

		PartDefinition right_crown2 = right_crown1.addOrReplaceChild("right_crown2", CubeListBuilder.create().texOffs(84, 50).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 19.0F, 3.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition left_crown = under_crown.addOrReplaceChild("left_crown", CubeListBuilder.create().texOffs(13, 149).mirror().addBox(-1.0F, -2.0F, 0.0F, 6.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(23, 0).mirror().addBox(1.0F, -4.0F, 1.5F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(29, 19).mirror().addBox(-3.0F, 0.0F, 1.5F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(158, 133).mirror().addBox(-4.0F, 6.0F, 0.0F, 9.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(80, 113).mirror().addBox(0.0F, 15.0F, 0.0F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(-2.0F, 15.0F, 1.5F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.5F, 2.0F, -7.0F));

		PartDefinition left_crown2 = left_crown.addOrReplaceChild("left_crown2", CubeListBuilder.create().texOffs(84, 50).mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 19.0F, 3.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition snake = crown.addOrReplaceChild("snake", CubeListBuilder.create().texOffs(172, 84).addBox(0.0F, -83.0937F, -99.5774F, 0.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(29, 10).mirror().addBox(-4.5F, -81.5937F, -93.5774F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(29, 10).addBox(1.5F, -81.5937F, -93.5774F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(26, 32).addBox(1.0F, -80.0937F, -96.5774F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.5F))
		.texOffs(71, 50).addBox(-1.0F, -81.0937F, -94.5774F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.5F))
		.texOffs(29, 26).addBox(-1.5F, -77.5937F, -100.0774F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(26, 32).addBox(-2.0F, -80.0937F, -96.5774F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.5F))
		.texOffs(98, 0).addBox(-1.0F, -81.0937F, -99.5774F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(0.5F, 66.0937F, 77.5774F));

		PartDefinition upper_crown = crown.addOrReplaceChild("upper_crown", CubeListBuilder.create().texOffs(95, 166).addBox(-7.0F, -6.0F, -17.0F, 15.0F, 6.0F, 17.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -7.9063F, 1.5774F, -0.1309F, 0.0F, 0.0F));

		PartDefinition desert_necklace = neck2.addOrReplaceChild("desert_necklace", CubeListBuilder.create().texOffs(82, 169).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.9063F, -0.9226F, 0.2182F, 0.0F, 0.0F));

		PartDefinition chain1 = desert_necklace.addOrReplaceChild("chain1", CubeListBuilder.create().texOffs(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition chain2 = chain1.addOrReplaceChild("chain2", CubeListBuilder.create().texOffs(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition chain3 = chain2.addOrReplaceChild("chain3", CubeListBuilder.create().texOffs(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition chain4 = chain3.addOrReplaceChild("chain4", CubeListBuilder.create().texOffs(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition chain5 = chain4.addOrReplaceChild("chain5", CubeListBuilder.create().texOffs(147, 104).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition desert_eye = chain5.addOrReplaceChild("desert_eye", CubeListBuilder.create().texOffs(167, 0).mirror().addBox(-12.0F, -7.1811F, 0.2836F, 11.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(167, 0).addBox(1.0F, -7.1811F, 0.2836F, 11.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.7811F, -0.2836F));

		PartDefinition eye = desert_eye.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(98, 50).addBox(-5.0F, -5.0F, -1.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7811F, 0.2836F, 0.0F, 0.0F, 0.7854F));

		PartDefinition left_arm = spine2.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(47, 109).addBox(-6.0F, -4.0637F, -3.0436F, 6.0F, 20.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 109).addBox(-6.0F, -4.0637F, -3.0436F, 6.0F, 20.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(13.2F, 10.0F, -17.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition left_front_arm = left_arm.addOrReplaceChild("left_front_arm", CubeListBuilder.create().texOffs(156, 47).addBox(-3.0F, -0.1465F, -2.2077F, 6.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 169).addBox(-3.0F, 2.8535F, -2.2077F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-4.0F, 15.2977F, -1.9036F, -0.829F, 0.0F, 0.0F));

		PartDefinition left_hand = left_front_arm.addOrReplaceChild("left_hand", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 10.1551F, -0.5133F, 1.6144F, 0.0F, 0.0F));

		PartDefinition left_finger3 = left_hand.addOrReplaceChild("left_finger3", CubeListBuilder.create().texOffs(0, 149).addBox(-0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0049F, 0.3079F, -0.7216F, -0.2324F, 0.2F));

		PartDefinition left_finger1 = left_hand.addOrReplaceChild("left_finger1", CubeListBuilder.create().texOffs(147, 84).addBox(0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0049F, 0.3079F, -0.7216F, 0.2324F, -0.2F));

		PartDefinition left_finger2 = left_hand.addOrReplaceChild("left_finger2", CubeListBuilder.create().texOffs(0, 149).addBox(-0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0049F, 0.3079F, -0.7258F, 0.0F, 0.0F));

		PartDefinition right_arm = spine2.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(47, 109).mirror().addBox(0.0F, -4.0637F, -3.0436F, 6.0F, 20.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.2F, 10.0F, -17.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition right_front_arm = right_arm.addOrReplaceChild("right_front_arm", CubeListBuilder.create().texOffs(156, 47).mirror().addBox(-3.0F, -0.1465F, -2.2077F, 6.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 169).mirror().addBox(-3.0F, 2.8535F, -2.2077F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(4.0F, 15.2977F, -1.9036F, -0.829F, 0.0F, 0.0F));

		PartDefinition right_hand = right_front_arm.addOrReplaceChild("right_hand", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 10.1551F, -0.5133F, 1.6144F, 0.0F, 0.0F));

		PartDefinition right_finger1 = right_hand.addOrReplaceChild("right_finger1", CubeListBuilder.create().texOffs(0, 149).mirror().addBox(0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0049F, 0.3079F, -0.7216F, 0.2324F, -0.2F));

		PartDefinition right_finger2 = right_hand.addOrReplaceChild("right_finger2", CubeListBuilder.create().texOffs(0, 149).mirror().addBox(0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.0049F, 0.3079F, -0.7258F, 0.0F, 0.0F));

		PartDefinition right_finger3 = right_hand.addOrReplaceChild("right_finger3", CubeListBuilder.create().texOffs(147, 84).mirror().addBox(-0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 0.0049F, 0.3079F, -0.7216F, -0.2324F, 0.2F));

		PartDefinition spine_deco = spine2.addOrReplaceChild("spine_deco", CubeListBuilder.create().texOffs(98, 0).addBox(-13.2F, 0.0F, -16.5F, 26.0F, 25.0F, 16.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, -7.3F, -6.7F, -0.1309F, 0.0F, 0.0F));

		PartDefinition legs = mid_pivot.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 7.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(165, 215).addBox(-6.0F, -2.0261F, -4.1809F, 8.0F, 34.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.0F, 6.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition left_deco1 = left_leg.addOrReplaceChild("left_deco1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -8.0F, 1.0F, 8.0F, 28.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 10.9739F, -8.1809F, 0.0959F, -0.4349F, -0.0329F));

		PartDefinition left_front_leg = left_leg.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 44).addBox(-5.0F, -2.5649F, -1.6913F, 8.0F, 24.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 32.9739F, -2.1809F, 1.0908F, 0.0F, 0.0F));

		PartDefinition left_ankel_joint = left_front_leg.addOrReplaceChild("left_ankel_joint", CubeListBuilder.create(), PartPose.offset(-1.0F, 20.6148F, 1.661F));

		PartDefinition left_mini_bone = left_ankel_joint.addOrReplaceChild("left_mini_bone", CubeListBuilder.create().texOffs(29, 0).addBox(0.0209F, -3.1113F, 0.0913F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 11.0F, -6.0F, -0.3928F, -0.0035F, 0.0001F));

		PartDefinition left_deco2 = left_ankel_joint.addOrReplaceChild("left_deco2", CubeListBuilder.create().texOffs(61, 210).addBox(-2.0F, -2.7487F, 0.1981F, 4.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -4.9602F, 0.5236F, 0.0F, 0.0F));

		PartDefinition left_deco3 = left_ankel_joint.addOrReplaceChild("left_deco3", CubeListBuilder.create().texOffs(33, 45).addBox(-0.2F, -11.7017F, -4.0722F, 4.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 9.0F, -7.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition left_ankel = left_ankel_joint.addOrReplaceChild("left_ankel", CubeListBuilder.create().texOffs(54, 198).addBox(-3.0F, -0.2489F, -2.0393F, 6.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition left_foot = left_ankel_joint.addOrReplaceChild("left_foot", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, -8.0F));

		PartDefinition left_toe = left_foot.addOrReplaceChild("left_toe", CubeListBuilder.create().texOffs(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.8218F, -0.2377F, -0.6981F, 0.0F, 0.0F));

		PartDefinition left_toe2 = left_foot.addOrReplaceChild("left_toe2", CubeListBuilder.create().texOffs(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.8218F, -0.2377F, -0.7216F, 0.2324F, -0.2F));

		PartDefinition left_toe3 = left_foot.addOrReplaceChild("left_toe3", CubeListBuilder.create().texOffs(71, 50).addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.8218F, -0.2377F, -0.7216F, -0.2324F, 0.2F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(165, 215).mirror().addBox(-2.0F, -2.0261F, -4.1809F, 8.0F, 34.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.0F, 0.0F, 6.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition right_deco1 = right_leg.addOrReplaceChild("right_deco1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, -8.0F, 1.0F, 8.0F, 28.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 10.9739F, -8.1809F, 0.0959F, 0.4349F, 0.0329F));

		PartDefinition right_front_leg = right_leg.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-3.0F, -2.5649F, -1.6913F, 8.0F, 24.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 32.9739F, -2.1809F, 1.0908F, 0.0F, 0.0F));

		PartDefinition right_ankel_joint = right_front_leg.addOrReplaceChild("right_ankel_joint", CubeListBuilder.create(), PartPose.offset(1.0F, 20.6148F, 1.661F));

		PartDefinition right_mini_bone = right_ankel_joint.addOrReplaceChild("right_mini_bone", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(-0.0209F, -3.1113F, 0.0913F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 11.0F, -6.0F, -0.3928F, 0.0035F, -0.0001F));

		PartDefinition right_deco2 = right_ankel_joint.addOrReplaceChild("right_deco2", CubeListBuilder.create().texOffs(61, 210).mirror().addBox(-2.0F, -2.7487F, 0.1981F, 4.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.0F, -4.9602F, 0.5236F, 0.0F, 0.0F));

		PartDefinition right_deco3 = right_ankel_joint.addOrReplaceChild("right_deco3", CubeListBuilder.create().texOffs(33, 45).mirror().addBox(-3.8F, -11.7017F, -4.0722F, 4.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 9.0F, -7.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition right_ankel = right_ankel_joint.addOrReplaceChild("right_ankel", CubeListBuilder.create().texOffs(54, 198).mirror().addBox(-3.0F, -0.2489F, -2.0393F, 6.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition right_foot = right_ankel_joint.addOrReplaceChild("right_foot", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, -8.0F));

		PartDefinition right_toe = right_foot.addOrReplaceChild("right_toe", CubeListBuilder.create().texOffs(71, 50).mirror().addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.8218F, -0.2377F, -0.6981F, 0.0F, 0.0F));

		PartDefinition right_toe2 = right_foot.addOrReplaceChild("right_toe2", CubeListBuilder.create().texOffs(71, 50).mirror().addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -1.8218F, -0.2377F, -0.7216F, -0.2324F, 0.2F));

		PartDefinition right_toe3 = right_foot.addOrReplaceChild("right_toe3", CubeListBuilder.create().texOffs(71, 50).mirror().addBox(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -1.8218F, -0.2377F, -0.7216F, 0.2324F, -0.2F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(Ancient_Remnant_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateHeadLookTarget(netHeadYaw, headPitch);

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
		float partialTick = Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);

		if (!entityIn.isSleep()) {
			articulateLegs(entityIn.legSolver, partialTick);
		}

		desert_necklace.visible = entityIn.getNecklace();

	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot += xRot * ((float) Math.PI / 180F);
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}


	private void articulateLegs(LegSolver legs, float partialTick) {
		float heightBackLeft = legs.legs[0].getHeight(partialTick);
		float heightBackRight = legs.legs[1].getHeight(partialTick);
		float max = (1F - smin(1F - heightBackLeft, 1F - heightBackRight, 0.1F)) * 0.8F;
		roots.y += max * 16;
		right_leg.y += (heightBackRight - max) * 16;
		left_leg.y += (heightBackLeft - max) * 16;
	}

	private static float smin(float a, float b, float k) {
		float h = Math.max(k - Math.abs(a - b), 0.0F) / k;
		return Math.min(a, b) - h * h * k * (1.0F / 4.0F);
	}

	public ModelPart root() {
		return this.root;
	}


}