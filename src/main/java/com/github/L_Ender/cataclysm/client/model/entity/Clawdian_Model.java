package com.github.L_Ender.cataclysm.client.model.entity;
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.github.L_Ender.cataclysm.client.animation.Clawdian_Animation;
import com.github.L_Ender.cataclysm.client.animation.Clawdian_Skill_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AcropolisMonsters.Clawdian_Entity;
import com.github.L_Ender.lionfishapi.server.animation.LegSolverQuadruped;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class Clawdian_Model extends HierarchicalModel<Clawdian_Entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart root;
	private final ModelPart everything;
	private final ModelPart mid_root;
	private final ModelPart lower_body;
	private final ModelPart pelvis;
	private final ModelPart body;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart right_down_antenna;
	private final ModelPart left_down_antenna;
	private final ModelPart head_tail;
	private final ModelPart left_arm;
	private final ModelPart left_front_arm_rotator;
	private final ModelPart left_front_arm;
	private final ModelPart left_claw;
	private final ModelPart block;
	private final ModelPart right_arm;
	private final ModelPart right_front_arm_rotator;
	private final ModelPart right_front_arm;
	private final ModelPart right_claw;
	private final ModelPart right_hammer;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart legs;
	private final ModelPart left_f_leg_joint;
	private final ModelPart left_f_leg;
	private final ModelPart left_f_leg_solver;
	private final ModelPart left_f_fore_leg;
	private final ModelPart left_f_fore_leg_solver;
	private final ModelPart right_f_leg_joint;
	private final ModelPart right_f_leg;
	private final ModelPart right_f_leg_solver;
	private final ModelPart right_f_fore_leg;
	private final ModelPart right_f_fore_leg_solver;
	private final ModelPart right_b_leg_joint;
	private final ModelPart right_b_leg;
	private final ModelPart right_b_leg_solver;
	private final ModelPart right_b_fore_leg;
	private final ModelPart right_b_fore_leg_solver;
	private final ModelPart left_b_leg_joint;
	private final ModelPart left_b_leg;
	private final ModelPart left_b_leg_solver;
	private final ModelPart left_b_fore_leg;
	private final ModelPart left_b_fore_leg_solver;


	public Clawdian_Model(ModelPart root) {
		this.root = root;
		this.everything = this.root.getChild("everything");
		this.mid_root = this.everything.getChild("mid_root");
		this.lower_body = this.mid_root.getChild("lower_body");
		this.pelvis = this.lower_body.getChild("pelvis");
		this.body = this.pelvis.getChild("body");
		this.neck = this.body.getChild("neck");
		this.head = this.neck.getChild("head");
		this.right_down_antenna = this.head.getChild("right_down_antenna");
		this.left_down_antenna = this.head.getChild("left_down_antenna");
		this.head_tail = this.head.getChild("head_tail");
		this.left_arm = this.body.getChild("left_arm");
		this.left_front_arm_rotator = this.left_arm.getChild("left_front_arm_rotator");
		this.left_front_arm = this.left_front_arm_rotator.getChild("left_front_arm");
		this.left_claw = this.left_front_arm.getChild("left_claw");
		this.block = this.left_front_arm.getChild("block");
		this.right_arm = this.body.getChild("right_arm");
		this.right_front_arm_rotator = this.right_arm.getChild("right_front_arm_rotator");
		this.right_front_arm = this.right_front_arm_rotator.getChild("right_front_arm");
		this.right_claw = this.right_front_arm.getChild("right_claw");
		this.right_hammer = this.right_front_arm.getChild("right_hammer");
		this.tail1 = this.lower_body.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.legs = this.lower_body.getChild("legs");
		this.left_f_leg_joint = this.legs.getChild("left_f_leg_joint");
		this.left_f_leg = this.left_f_leg_joint.getChild("left_f_leg");
		this.left_f_leg_solver = this.left_f_leg.getChild("left_f_leg_solver");
		this.left_f_fore_leg = this.left_f_leg_solver.getChild("left_f_fore_leg");
		this.left_f_fore_leg_solver = this.left_f_fore_leg.getChild("left_f_fore_leg_solver");
		this.right_f_leg_joint = this.legs.getChild("right_f_leg_joint");
		this.right_f_leg = this.right_f_leg_joint.getChild("right_f_leg");
		this.right_f_leg_solver = this.right_f_leg.getChild("right_f_leg_solver");
		this.right_f_fore_leg = this.right_f_leg_solver.getChild("right_f_fore_leg");
		this.right_f_fore_leg_solver = this.right_f_fore_leg.getChild("right_f_fore_leg_solver");
		this.right_b_leg_joint = this.legs.getChild("right_b_leg_joint");
		this.right_b_leg = this.right_b_leg_joint.getChild("right_b_leg");
		this.right_b_leg_solver = this.right_b_leg.getChild("right_b_leg_solver");
		this.right_b_fore_leg = this.right_b_leg_solver.getChild("right_b_fore_leg");
		this.right_b_fore_leg_solver = this.right_b_fore_leg.getChild("right_b_fore_leg_solver");
		this.left_b_leg_joint = this.legs.getChild("left_b_leg_joint");
		this.left_b_leg = this.left_b_leg_joint.getChild("left_b_leg");
		this.left_b_leg_solver = this.left_b_leg.getChild("left_b_leg_solver");
		this.left_b_fore_leg = this.left_b_leg_solver.getChild("left_b_fore_leg");
		this.left_b_fore_leg_solver = this.left_b_fore_leg.getChild("left_b_fore_leg_solver");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition mid_root = everything.addOrReplaceChild("mid_root", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -26.4F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition lower_body = mid_root.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(83, 122).addBox(-8.0F, -7.1839F, -9.7571F, 16.0F, 10.0F, 24.0F, new CubeDeformation(0.0F))
				.texOffs(171, 0).addBox(-8.5F, -7.6839F, -4.7571F, 17.0F, 8.0F, 17.0F, new CubeDeformation(0.25F))
				.texOffs(51, 157).addBox(-8.0F, 2.8161F, -9.7571F, 16.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4161F, -0.2429F, -0.1745F, 0.6545F, 0.0F));

		PartDefinition pelvis = lower_body.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(197, 149).addBox(-6.5F, -19.6954F, -4.5741F, 13.0F, 21.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(197, 180).addBox(-6.5F, -18.6954F, -4.5741F, 13.0F, 21.0F, 9.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -0.4885F, -8.1831F, -0.1294F, -0.1289F, -0.0229F));

		PartDefinition body = pelvis.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.3925F, -1.078F, 0.0025F, -0.1248F, -0.0396F));

		PartDefinition armor_r1 = body.addOrReplaceChild("armor_r1", CubeListBuilder.create().texOffs(168, 86).addBox(-5.5F, -13.2F, -19.5F, 20.0F, 15.0F, 14.0F, new CubeDeformation(0.25F))
				.texOffs(171, 55).addBox(-4.7F, -13.0F, -19.0F, 19.0F, 15.0F, 13.0F, new CubeDeformation(0.25F))
				.texOffs(171, 26).addBox(-4.7F, -13.0F, -19.0F, 19.0F, 15.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8F, -7.3029F, 12.504F, 0.4363F, 0.0F, 0.0F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(213, 236).addBox(-3.2494F, -8.0043F, -4.0847F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2494F, -15.2986F, -0.4113F, 0.1755F, -0.0034F, 0.0186F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.1053F, -2.8262F, 0.5659F, 0.0836F, -0.0147F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(132, 155).addBox(1.0F, -34.0F, -36.0F, 0.0F, 11.0F, 32.0F, new CubeDeformation(0.0F))
				.texOffs(236, 66).addBox(-1.0F, -29.0F, -29.0F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2494F, 25.101F, 3.7415F, -0.2269F, 0.0F, 0.0F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(51, 205).addBox(-5.0F, -4.0F, -12.0F, 7.0F, 7.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2506F, -2.899F, 2.7415F, -0.2269F, 0.0F, 0.0F));

		PartDefinition right_down_antenna = head.addOrReplaceChild("right_down_antenna", CubeListBuilder.create().texOffs(0, 86).addBox(0.7506F, -25.1128F, -21.7043F, 0.0F, 26.0F, 41.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -3.7862F, -12.5542F, -0.1018F, 0.2523F, -0.8635F));

		PartDefinition left_down_antenna = head.addOrReplaceChild("left_down_antenna", CubeListBuilder.create().texOffs(0, 86).mirror().addBox(-0.7506F, -25.1128F, -21.7043F, 0.0F, 26.0F, 41.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5013F, -3.7862F, -12.5542F, -0.1018F, -0.2523F, 0.8635F));

		PartDefinition head_tail = head.addOrReplaceChild("head_tail", CubeListBuilder.create().texOffs(236, 50).addBox(-2.5192F, -2.0716F, -1.1109F, 5.0F, 5.0F, 10.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.2763F, -2.8274F, 5.8524F, -0.8286F, 0.0102F, -0.0072F));

		PartDefinition cube_r3 = head_tail.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(238, 236).addBox(31.0F, -3.0F, -2.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-35.0787F, 2.9284F, 7.8891F, -0.5236F, 0.0F, 0.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 218).addBox(-1.2027F, -3.0687F, -3.1026F, 6.0F, 22.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(188, 211).addBox(-3.2027F, -4.0687F, -5.1026F, 11.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.2027F, -13.2342F, 0.6065F, 0.1706F, -0.5977F, -0.5657F));

		PartDefinition left_front_arm_rotator = left_arm.addOrReplaceChild("left_front_arm_rotator", CubeListBuilder.create(), PartPose.offsetAndRotation(1.95F, 15.3903F, 0.4874F, -0.2618F, 0.0F, 0.0F));

		PartDefinition left_front_arm = left_front_arm_rotator.addOrReplaceChild("left_front_arm", CubeListBuilder.create().texOffs(112, 201).addBox(-6.1527F, -2.459F, -6.59F, 8.0F, 19.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(58, 228).addBox(-5.1527F, 16.541F, -6.59F, 6.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, 1.0F, -0.2967F, 0.0F, 0.0F));

		PartDefinition left_claw = left_front_arm.addOrReplaceChild("left_claw", CubeListBuilder.create().texOffs(236, 26).addBox(-2.8527F, -2.559F, -4.89F, 6.0F, 17.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-2.3F, 15.1F, 4.3F, 0.5236F, 0.0F, 0.0F));

		PartDefinition block = left_front_arm.addOrReplaceChild("block", CubeListBuilder.create(), PartPose.offset(-2.3F, 23.1F, 1.3F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(87, 228).addBox(-4.7973F, -3.0687F, -3.1026F, 6.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.2027F, -13.2342F, 0.6065F, -0.4334F, 0.9184F, 0.2283F));

		PartDefinition right_front_arm_rotator = right_arm.addOrReplaceChild("right_front_arm_rotator", CubeListBuilder.create(), PartPose.offset(-1.95F, 15.3903F, 0.5874F));

		PartDefinition right_front_arm = right_front_arm_rotator.addOrReplaceChild("right_front_arm", CubeListBuilder.create().texOffs(25, 228).addBox(-3.8473F, -0.459F, -4.59F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(146, 157).addBox(-3.8473F, 11.541F, -3.59F, 5.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.525F, -0.3051F, -0.0138F));

		PartDefinition right_claw = right_front_arm.addOrReplaceChild("right_claw", CubeListBuilder.create().texOffs(125, 157).addBox(-0.1473F, 0.441F, -4.89F, 4.0F, 12.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.3F, 10.1F, 1.3F, 0.0F, 0.0F, -0.2182F));

		PartDefinition right_hammer = right_front_arm.addOrReplaceChild("right_hammer", CubeListBuilder.create().texOffs(153, 201).addBox(-5.8473F, -10.459F, -57.59F, 7.0F, 25.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 154).addBox(-2.3473F, -19.459F, -62.59F, 0.0F, 38.0F, 25.0F, new CubeDeformation(0.0F))
				.texOffs(112, 186).addBox(-4.3473F, -2.959F, 15.51F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0368F, 19.2741F, -0.4526F, -0.5296F, 0.3024F, 0.3881F));

		PartDefinition cube_r4 = right_hammer.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(112, 186).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3473F, -0.959F, -60.69F, 3.1416F, 0.0F, 0.0F));

		PartDefinition cube_r5 = right_hammer.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.5F, -41.0F, 3.0F, 3.0F, 82.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3473F, -0.959F, -21.59F, 0.0F, 0.0F, 1.5708F));

		PartDefinition tail1 = lower_body.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(83, 86).addBox(-7.0F, -4.4682F, -4.9412F, 14.0F, 7.0F, 28.0F, new CubeDeformation(0.0F))
				.texOffs(164, 122).addBox(-7.0F, 2.5318F, -2.9412F, 14.0F, 3.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.2843F, 14.1841F, -0.044F, 0.1308F, -0.0057F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(51, 186).addBox(-9.0F, -2.6682F, -0.9412F, 18.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.2F, 21.0F, -0.1286F, 0.3641F, 0.1243F));

		PartDefinition legs = lower_body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_f_leg_joint = legs.addOrReplaceChild("left_f_leg_joint", CubeListBuilder.create(), PartPose.offset(8.0981F, 2.9884F, -10.2377F));

		PartDefinition left_f_leg = left_f_leg_joint.addOrReplaceChild("left_f_leg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1759F, 0.7161F, -0.6623F));

		PartDefinition left_f_leg_solver = left_f_leg.addOrReplaceChild("left_f_leg_solver", CubeListBuilder.create().texOffs(231, 211).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.3756F, -2.8562F, 1.8591F));

		PartDefinition left_f_fore_leg = left_f_leg_solver.addOrReplaceChild("left_f_fore_leg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.4148F, 16.6562F, -1.2591F, -0.1396F, 0.0F, 1.0472F));

		PartDefinition left_f_fore_leg_solver = left_f_fore_leg.addOrReplaceChild("left_f_fore_leg_solver", CubeListBuilder.create().texOffs(148, 237).addBox(-2.3683F, -4.4072F, -0.648F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(137, 233).addBox(-1.3683F, -12.4072F, 1.352F, 5.0F, 30.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_f_leg_joint = legs.addOrReplaceChild("right_f_leg_joint", CubeListBuilder.create(), PartPose.offset(-7.2371F, 2.7935F, -9.1327F));

		PartDefinition right_f_leg = right_f_leg_joint.addOrReplaceChild("right_f_leg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1759F, -0.7161F, 0.6623F));

		PartDefinition right_f_leg_solver = right_f_leg.addOrReplaceChild("right_f_leg_solver", CubeListBuilder.create().texOffs(112, 233).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.902F, -2.1723F, 0.4805F));

		PartDefinition right_f_fore_leg = right_f_leg_solver.addOrReplaceChild("right_f_fore_leg", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1373F, 15.9723F, 0.1195F, -0.1396F, 0.0F, -1.0472F));

		PartDefinition right_f_fore_leg_solver = right_f_fore_leg.addOrReplaceChild("right_f_fore_leg_solver", CubeListBuilder.create().texOffs(165, 237).addBox(-2.8627F, -4.9723F, -2.1194F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(237, 81).addBox(-4.8627F, -12.9723F, -0.1194F, 5.0F, 30.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_b_leg_joint = legs.addOrReplaceChild("right_b_leg_joint", CubeListBuilder.create(), PartPose.offset(-7.746F, 0.3722F, 5.0641F));

		PartDefinition right_b_leg = right_b_leg_joint.addOrReplaceChild("right_b_leg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5717F, 0.4999F, 0.953F));

		PartDefinition right_b_leg_solver = right_b_leg.addOrReplaceChild("right_b_leg_solver", CubeListBuilder.create().texOffs(188, 234).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.254F, -2.5409F, -0.9948F));

		PartDefinition right_b_fore_leg = right_b_leg_solver.addOrReplaceChild("right_b_fore_leg", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.7853F, 16.3409F, 0.3948F, 0.1384F, 0.0182F, -1.1768F));

		PartDefinition right_b_fore_leg_solver = right_b_fore_leg.addOrReplaceChild("right_b_fore_leg_solver", CubeListBuilder.create().texOffs(165, 237).addBox(-2.2147F, -3.3409F, -2.3949F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(237, 81).addBox(-4.2147F, -11.3409F, -0.3949F, 5.0F, 30.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_b_leg_joint = legs.addOrReplaceChild("left_b_leg_joint", CubeListBuilder.create(), PartPose.offset(7.746F, 0.3722F, 5.0641F));

		PartDefinition left_b_leg = left_b_leg_joint.addOrReplaceChild("left_b_leg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5717F, -0.4999F, -0.953F));

		PartDefinition left_b_leg_solver = left_b_leg.addOrReplaceChild("left_b_leg_solver", CubeListBuilder.create().texOffs(188, 234).mirror().addBox(-3.0F, -1.0F, -3.0F, 6.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.254F, -2.5409F, -0.9948F));

		PartDefinition left_b_fore_leg = left_b_leg_solver.addOrReplaceChild("left_b_fore_leg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.7853F, 16.3409F, 0.3948F, 0.1384F, -0.0182F, 1.1768F));

		PartDefinition left_b_fore_leg_solver = left_b_fore_leg.addOrReplaceChild("left_b_fore_leg_solver", CubeListBuilder.create().texOffs(165, 237).mirror().addBox(-1.7853F, -3.3409F, -2.3949F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(237, 81).mirror().addBox(-0.7853F, -11.3409F, -0.3949F, 5.0F, 30.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}


	@Override
	public void setupAnim(Clawdian_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		if(entity.getAttackState() != 5 && entity.getAttackState() != 2 && entity.getAttackState() != 10) {
			this.animateWalk(Clawdian_Animation.WALK, limbSwing, limbSwingAmount, 2.0F, 1.5F);
		}
		this.animate(entity.getAnimationState("idle"), Clawdian_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("vertical_swing"), Clawdian_Animation.VERTICAL_SWING, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("horizontal_swing"), Clawdian_Animation.HORIZONTAL_SWING, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("death"), Clawdian_Animation.DEATH, ageInTicks, 1.0F);

		this.animate(entity.getAnimationState("charge_ready"), Clawdian_Skill_Animation.CHARGE_READY, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("charge_loop"), Clawdian_Skill_Animation.CHARGE_LOOP, ageInTicks, 1.5F);
		this.animate(entity.getAnimationState("charge_end"), Clawdian_Skill_Animation.CHARGE_END, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("wave_stomp"), Clawdian_Skill_Animation.WAVE_STOMP, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("claw_punch"), Clawdian_Animation.CLAW_PUNCH, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("grab_and_throw"), Clawdian_Animation.GRAB_AND_THROW, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("backstep"), Clawdian_Animation.BACKSTEP, ageInTicks, 1.0F);
		float partialTick = Minecraft.getInstance().getFrameTime();

		articulateLegs(entity.legSolver, partialTick);
	}

	public void translateToHand(PoseStack matrixStack) {
		this.root.translateAndRotate(matrixStack);
		this.everything.translateAndRotate(matrixStack);
		this.mid_root.translateAndRotate(matrixStack);
		this.lower_body.translateAndRotate(matrixStack);
		this.pelvis.translateAndRotate(matrixStack);
		this.body.translateAndRotate(matrixStack);
		this.left_arm.translateAndRotate(matrixStack);
		this.left_front_arm_rotator.translateAndRotate(matrixStack);
		this.left_front_arm.translateAndRotate(matrixStack);
		this.block.translateAndRotate(matrixStack);





	}

	private void articulateLegs(LegSolverQuadruped legs, float partialTick) {
		float heightBackLeft = legs.backLeft.getHeight(partialTick);
		float heightBackRight = legs.backRight.getHeight(partialTick);
		float heightFrontLeft = legs.frontLeft.getHeight(partialTick);
		float heightFrontRight = legs.frontRight.getHeight(partialTick);
		//float max = (1F - smin(1F - heightBackLeft, 1F - heightBackRight, 0.1F)) * 0.8F;
		float max = Math.max(Math.max(heightBackLeft, heightBackRight), Math.max(heightFrontLeft, heightFrontRight)) * 0.8F;
		everything.y += max * 16;

		//right_f_leg_joint.y += (heightBackRight - max) * 16;

		right_f_leg_joint.y += (heightFrontRight - max) * 3;
		right_f_leg_solver.zRot += (heightFrontRight - max) * Math.toRadians(-45F);
		right_b_leg_joint.y += (heightBackRight - max) * 3;
		right_b_leg_solver.zRot += (heightBackRight - max) * Math.toRadians(-45F);

		right_f_fore_leg_solver.zRot += (heightFrontRight - max) * Math.toRadians(45F);
		right_b_fore_leg_solver.zRot += (heightBackRight - max) * Math.toRadians(45F);



		left_f_leg_joint.y += (heightFrontLeft - max) * 3;
		left_f_leg_solver.zRot += (heightFrontLeft - max) * Math.toRadians(45F);
		left_b_leg_joint.y += (heightBackLeft - max) * 3;
		left_b_leg_solver.zRot += (heightBackLeft - max) * Math.toRadians(45F);

		left_f_fore_leg_solver.zRot += (heightFrontLeft - max) * Math.toRadians(-45F);
		left_b_fore_leg_solver.zRot += (heightBackLeft - max) * Math.toRadians(-45F);


	}


	private void animateHeadLookTarget(float yRot, float xRot) {
		this.neck.xRot += xRot * ((float) Math.PI / 180F) * 1/2;
		this.neck.yRot += yRot * ((float) Math.PI / 180F) * 1/2;
		this.head.xRot += xRot * ((float) Math.PI / 180F) * 1/2;
		this.head.yRot += yRot * ((float) Math.PI / 180F) * 1/2;
	}

	public ModelPart root() {
		return this.root;
	}

}