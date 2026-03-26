package com.github.L_Ender.cataclysm.client.model.entity;
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.github.L_Ender.cataclysm.client.animation.Aptrgangr_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class Aptrgangr_Model extends HierarchicalModel<Aptrgangr_Entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart root;
	private final ModelPart roots;
	private final ModelPart l_leg;
	private final ModelPart l_leg_armor;
	private final ModelPart left_leg_r1;
	private final ModelPart left_leg_r2;
	private final ModelPart r_leg;
	private final ModelPart r_leg_armor;
	private final ModelPart right_leg_r1;
	private final ModelPart right_leg_r2;
	private final ModelPart body;
	private final ModelPart chest;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart helmet;
	private final ModelPart head_r1;
	private final ModelPart head_r2;
	private final ModelPart head_r3;
	private final ModelPart head_r4;
	private final ModelPart head_r5;
	private final ModelPart head_r6;
	private final ModelPart jaw;
	private final ModelPart head_r7;
	private final ModelPart chestplate;
	private final ModelPart body_r1;
	private final ModelPart body_r2;
	private final ModelPart body_r3;
	private final ModelPart body_r4;
	private final ModelPart body_r5;
	private final ModelPart body_r6;
	private final ModelPart body_r7;
	private final ModelPart l_arm;
	private final ModelPart l_arm_armor;
	private final ModelPart right_arm_r1;
	private final ModelPart right_arm_r2;
	private final ModelPart right_arm_r3;
	private final ModelPart right_arm_r4;
	private final ModelPart right_arm_r5;
	private final ModelPart right_arm_r6;
	private final ModelPart arrow;
	private final ModelPart arrow2;
	private final ModelPart left_arm2;
	private final ModelPart l_arm_cloth;
	private final ModelPart hold;
	private final ModelPart r_arm;
	private final ModelPart right_arm2;
	private final ModelPart r_arm_cloth;
	private final ModelPart axe;
	private final ModelPart cube_r1;
	private final ModelPart cube_r2;
	private final ModelPart axe_head;
	private final ModelPart cube_r3;
	private final ModelPart cube_r4;
	private final ModelPart cube_r5;
	private final ModelPart cube_r6;
	private final ModelPart cube_r7;
	private final ModelPart cube_r8;
	private final ModelPart emblem3;
	private final ModelPart right_arm_r7;
	private final ModelPart emblem4;
	private final ModelPart r_arm_armor;
	private final ModelPart left_arm_r1;
	private final ModelPart left_arm_r2;
	private final ModelPart left_arm_r3;
	private final ModelPart left_arm_r4;
	private final ModelPart left_arm_r5;
	private final ModelPart left_arm_r6;
	private final ModelPart belt;
	private final ModelPart body_r8;
	private final ModelPart emblem2;
	private final ModelPart emblem;
	private final ModelPart cloth2;
	private final ModelPart cloth;

	public Aptrgangr_Model(ModelPart root) {
		this.root = root;
		this.roots = this.root.getChild("roots");
		this.l_leg = this.roots.getChild("l_leg");
		this.l_leg_armor = this.l_leg.getChild("l_leg_armor");
		this.left_leg_r1 = this.l_leg_armor.getChild("left_leg_r1");
		this.left_leg_r2 = this.l_leg_armor.getChild("left_leg_r2");
		this.r_leg = this.roots.getChild("r_leg");
		this.r_leg_armor = this.r_leg.getChild("r_leg_armor");
		this.right_leg_r1 = this.r_leg_armor.getChild("right_leg_r1");
		this.right_leg_r2 = this.r_leg_armor.getChild("right_leg_r2");
		this.body = this.roots.getChild("body");
		this.chest = this.body.getChild("chest");
		this.neck = this.chest.getChild("neck");
		this.head = this.neck.getChild("head");
		this.helmet = this.head.getChild("helmet");
		this.head_r1 = this.helmet.getChild("head_r1");
		this.head_r2 = this.helmet.getChild("head_r2");
		this.head_r3 = this.helmet.getChild("head_r3");
		this.head_r4 = this.helmet.getChild("head_r4");
		this.head_r5 = this.helmet.getChild("head_r5");
		this.head_r6 = this.helmet.getChild("head_r6");
		this.jaw = this.head.getChild("jaw");
		this.head_r7 = this.jaw.getChild("head_r7");
		this.chestplate = this.chest.getChild("chestplate");
		this.body_r1 = this.chestplate.getChild("body_r1");
		this.body_r2 = this.chestplate.getChild("body_r2");
		this.body_r3 = this.chestplate.getChild("body_r3");
		this.body_r4 = this.chestplate.getChild("body_r4");
		this.body_r5 = this.chestplate.getChild("body_r5");
		this.body_r6 = this.chestplate.getChild("body_r6");
		this.body_r7 = this.chestplate.getChild("body_r7");
		this.l_arm = this.chest.getChild("l_arm");
		this.l_arm_armor = this.l_arm.getChild("l_arm_armor");
		this.right_arm_r1 = this.l_arm_armor.getChild("right_arm_r1");
		this.right_arm_r2 = this.l_arm_armor.getChild("right_arm_r2");
		this.right_arm_r3 = this.l_arm_armor.getChild("right_arm_r3");
		this.right_arm_r4 = this.l_arm_armor.getChild("right_arm_r4");
		this.right_arm_r5 = this.l_arm_armor.getChild("right_arm_r5");
		this.right_arm_r6 = this.l_arm_armor.getChild("right_arm_r6");
		this.arrow = this.l_arm_armor.getChild("arrow");
		this.arrow2 = this.l_arm_armor.getChild("arrow2");
		this.left_arm2 = this.l_arm.getChild("left_arm2");
		this.l_arm_cloth = this.left_arm2.getChild("l_arm_cloth");
		this.hold = this.l_arm_cloth.getChild("hold");
		this.r_arm = this.chest.getChild("r_arm");
		this.right_arm2 = this.r_arm.getChild("right_arm2");
		this.r_arm_cloth = this.right_arm2.getChild("r_arm_cloth");
		this.axe = this.right_arm2.getChild("axe");
		this.cube_r1 = this.axe.getChild("cube_r1");
		this.cube_r2 = this.axe.getChild("cube_r2");
		this.axe_head = this.axe.getChild("axe_head");
		this.cube_r3 = this.axe_head.getChild("cube_r3");
		this.cube_r4 = this.axe_head.getChild("cube_r4");
		this.cube_r5 = this.axe_head.getChild("cube_r5");
		this.cube_r6 = this.axe_head.getChild("cube_r6");
		this.cube_r7 = this.axe_head.getChild("cube_r7");
		this.cube_r8 = this.axe_head.getChild("cube_r8");
		this.emblem3 = this.axe_head.getChild("emblem3");
		this.right_arm_r7 = this.emblem3.getChild("right_arm_r7");
		this.emblem4 = this.axe_head.getChild("emblem4");
		this.r_arm_armor = this.r_arm.getChild("r_arm_armor");
		this.left_arm_r1 = this.r_arm_armor.getChild("left_arm_r1");
		this.left_arm_r2 = this.r_arm_armor.getChild("left_arm_r2");
		this.left_arm_r3 = this.r_arm_armor.getChild("left_arm_r3");
		this.left_arm_r4 = this.r_arm_armor.getChild("left_arm_r4");
		this.left_arm_r5 = this.r_arm_armor.getChild("left_arm_r5");
		this.left_arm_r6 = this.r_arm_armor.getChild("left_arm_r6");
		this.belt = this.body.getChild("belt");
		this.body_r8 = this.belt.getChild("body_r8");
		this.emblem2 = this.belt.getChild("emblem2");
		this.emblem = this.belt.getChild("emblem");
		this.cloth2 = this.belt.getChild("cloth2");
		this.cloth = this.belt.getChild("cloth");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition roots = partdefinition.addOrReplaceChild("roots", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition l_leg = roots.addOrReplaceChild("l_leg", CubeListBuilder.create().texOffs(0, 69).addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -13.0F, 0.0F));

		PartDefinition l_leg_armor = l_leg.addOrReplaceChild("l_leg_armor", CubeListBuilder.create().texOffs(39, 91).addBox(-3.5F, -1.0F, -3.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.4F))
		.texOffs(0, 90).addBox(-3.5F, 7.0F, -3.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.4F))
		.texOffs(0, 109).addBox(-0.5F, 3.0F, -6.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 141).mirror().addBox(-4.5F, 11.0F, -4.0F, 8.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition left_leg_r1 = l_leg_armor.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(0, 105).addBox(-1.0F, -1.0F, -1.5F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 99).addBox(-2.0F, -2.0F, -1.9F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 6.0F, -2.6F, 0.0F, 0.0F, 0.7854F));

		PartDefinition left_leg_r2 = l_leg_armor.addOrReplaceChild("left_leg_r2", CubeListBuilder.create().texOffs(0, 128).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.5F, -0.5F, 0.0F, 0.0F, -0.0873F));

		PartDefinition r_leg = roots.addOrReplaceChild("r_leg", CubeListBuilder.create().texOffs(22, 72).addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -13.0F, 0.0F));

		PartDefinition r_leg_armor = r_leg.addOrReplaceChild("r_leg_armor", CubeListBuilder.create().texOffs(90, 71).addBox(-3.0F, -1.0F, 2.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.4F))
		.texOffs(88, 62).addBox(-3.0F, 7.0F, 2.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.4F))
		.texOffs(0, 141).addBox(-4.0F, 11.0F, 1.0F, 8.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 109).mirror().addBox(0.0F, 3.0F, -1.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, -2.0F, -5.0F));

		PartDefinition right_leg_r1 = r_leg_armor.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(0, 105).mirror().addBox(-5.0F, -1.0F, -1.5F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 99).mirror().addBox(-2.0F, -2.0F, -1.9F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.0F, 2.4F, 0.0F, 0.0F, -0.7854F));

		PartDefinition right_leg_r2 = r_leg_armor.addOrReplaceChild("right_leg_r2", CubeListBuilder.create().texOffs(0, 128).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -1.5F, 4.5F, 0.0F, 0.0F, 0.0873F));

		PartDefinition body = roots.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 60).addBox(-5.5F, -6.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -14.0F, -6.0F, 18.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(80, 165).addBox(-2.5F, -4.0F, -2.55F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(80, 165).addBox(-2.5F, 0.0F, -2.55F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(100, 168).addBox(0.0F, -4.0F, 2.45F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, -2.45F, 0.4363F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 111).addBox(-4.0F, -7.0F, -5.5F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -0.55F, -0.3927F, 0.0F, 0.0F));

		PartDefinition helmet = head.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(32, 113).addBox(-4.0F, -2.0F, -3.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.5F))
		.texOffs(102, 110).addBox(-1.5F, -2.8F, -4.3F, 3.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(64, 120).mirror().addBox(-5.5F, -2.0F, -1.5F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(116, 20).addBox(-10.5F, -3.5F, 0.5F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(64, 120).addBox(4.5F, -2.0F, -1.5F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(116, 0).addBox(4.5F, -9.5F, 0.5F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(88, 98).addBox(-5.0F, 3.2F, -4.3F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.001F))
		.texOffs(62, 91).addBox(-4.0F, 5.0F, -3.5F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -2.0F));

		PartDefinition head_r1 = helmet.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(28, 104).mirror().addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.4F, 3.5F, -3.8F, 0.0F, 0.0F, -0.7854F));

		PartDefinition head_r2 = helmet.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(42, 111).mirror().addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 106).mirror().addBox(0.0F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(43, 109).mirror().addBox(-1.0F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(29, 115).mirror().addBox(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.4F, 3.5F, -4.1F, 0.0F, 0.0F, -0.2618F));

		PartDefinition head_r3 = helmet.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(43, 108).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 104).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, 3.5F, -4.1F, 0.0F, 0.0F, 0.2618F));

		PartDefinition head_r4 = helmet.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(25, 108).mirror().addBox(-0.5F, -1.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.8F, -4.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition head_r5 = helmet.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(31, 108).mirror().addBox(-0.5F, -1.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.2F, -4.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition head_r6 = helmet.addOrReplaceChild("head_r6", CubeListBuilder.create().texOffs(30, 111).mirror().addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.7F, -3.9F, 0.0F, 0.0F, -0.7854F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(34, 26).addBox(-3.0F, 0.0F, -2.5F, 6.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(3.0F, 3.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 5).addBox(3.0F, -2.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 5).mirror().addBox(-5.0F, -2.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(48, 0).mirror().addBox(-9.0F, 3.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(84, 1).addBox(3.0F, 8.0F, -2.5F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(84, 1).mirror().addBox(-8.0F, 8.0F, -2.5F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 33).addBox(-3.0F, 0.0F, 0.5F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -3.0F));

		PartDefinition head_r7 = jaw.addOrReplaceChild("head_r7", CubeListBuilder.create().texOffs(92, 12).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -2.5F, -0.3491F, 0.0F, 0.0F));

		PartDefinition chestplate = chest.addOrReplaceChild("chestplate", CubeListBuilder.create().texOffs(0, 150).addBox(-6.0F, -3.0F, -9.0F, 12.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 159).addBox(-4.0F, 4.0F, -9.0F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 180).addBox(-9.0F, 3.0F, -7.0F, 18.0F, 2.0F, 12.0F, new CubeDeformation(0.2F))
		.texOffs(68, 174).addBox(-5.0F, -5.0F, -7.0F, 10.0F, 6.0F, 12.0F, new CubeDeformation(0.1F))
		.texOffs(0, 165).addBox(-6.0F, -3.0F, -9.0F, 12.0F, 7.0F, 2.0F, new CubeDeformation(-0.1F))
		.texOffs(0, 174).addBox(-4.0F, 4.0F, -9.0F, 8.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, -9.0F, 1.0F));

		PartDefinition body_r1 = chestplate.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(48, 182).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 6.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition body_r2 = chestplate.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(0, 188).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 4.0F, -7.3F, 0.0F, 0.2618F, 0.1309F));

		PartDefinition body_r3 = chestplate.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(0, 188).mirror().addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, 4.0F, -7.3F, 0.0F, -0.2618F, -0.1309F));

		PartDefinition body_r4 = chestplate.addOrReplaceChild("body_r4", CubeListBuilder.create().texOffs(0, 188).mirror().addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, -3.0F, -7.3F, 0.0F, -0.2618F, 0.5236F));

		PartDefinition body_r5 = chestplate.addOrReplaceChild("body_r5", CubeListBuilder.create().texOffs(0, 194).mirror().addBox(-0.5F, -1.0F, -6.0F, 9.0F, 2.0F, 12.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -4.5F, -1.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition body_r6 = chestplate.addOrReplaceChild("body_r6", CubeListBuilder.create().texOffs(0, 188).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -3.0F, -7.3F, 0.0F, 0.2618F, -0.5236F));

		PartDefinition body_r7 = chestplate.addOrReplaceChild("body_r7", CubeListBuilder.create().texOffs(0, 194).addBox(-8.5F, -1.0F, -6.0F, 9.0F, 2.0F, 12.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(9.0F, -4.5F, -1.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition l_arm = chest.addOrReplaceChild("l_arm", CubeListBuilder.create().texOffs(0, 49).addBox(-3.0F, -2.5F, -4.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -12.5F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition l_arm_armor = l_arm.addOrReplaceChild("l_arm_armor", CubeListBuilder.create().texOffs(112, 56).mirror().addBox(-4.5086F, -5.3695F, -7.0F, 2.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(130, 66).mirror().addBox(-4.5086F, 4.6305F, -7.0F, 12.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 26).mirror().addBox(-4.5086F, -4.3695F, -6.0F, 11.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(138, 36).mirror().addBox(6.4914F, -3.3695F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(106, 36).mirror().addBox(-1.5086F, -4.3695F, -6.0F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(154, 40).mirror().addBox(0.4914F, -3.3695F, -7.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(166, 38).mirror().addBox(2.4914F, -4.3695F, -11.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(162, 46).mirror().addBox(1.4914F, -1.3695F, -11.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(142, 55).mirror().addBox(8.4914F, -0.3695F, -2.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(146, 49).mirror().addBox(8.4914F, -4.3695F, 0.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition right_arm_r1 = l_arm_armor.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(168, 68).mirror().addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(168, 74).mirror().addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(182, 75).mirror().addBox(-6.5F, -0.5F, 0.5F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0086F, 5.1305F, -8.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition right_arm_r2 = l_arm_armor.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(130, 82).mirror().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.4914F, 6.6305F, 6.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition right_arm_r3 = l_arm_armor.addOrReplaceChild("right_arm_r3", CubeListBuilder.create().texOffs(130, 82).mirror().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.4914F, 6.6305F, -6.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition right_arm_r4 = l_arm_armor.addOrReplaceChild("right_arm_r4", CubeListBuilder.create().texOffs(154, 68).mirror().addBox(0.0F, 0.0F, -7.0F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.4914F, 6.6305F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition right_arm_r5 = l_arm_armor.addOrReplaceChild("right_arm_r5", CubeListBuilder.create().texOffs(162, 46).mirror().addBox(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(166, 38).mirror().addBox(0.0F, -3.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.4914F, -1.3695F, 9.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition right_arm_r6 = l_arm_armor.addOrReplaceChild("right_arm_r6", CubeListBuilder.create().texOffs(154, 40).mirror().addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.4914F, -1.3695F, 6.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition arrow = l_arm_armor.addOrReplaceChild("arrow", CubeListBuilder.create().texOffs(128, 100).addBox(-8.0F, -2.5F, 0.0F, 16.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(128, 100).addBox(-7.0F, -2.5F, -2.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(123, 100).addBox(-8.0F, 0.0F, -2.5F, 16.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -3.0F, -5.0F, 0.0F, -0.4363F, 1.7453F));

		PartDefinition arrow2 = l_arm_armor.addOrReplaceChild("arrow2", CubeListBuilder.create().texOffs(128, 100).addBox(-8.0F, -2.5F, 0.0F, 16.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(128, 100).addBox(-7.0F, -2.5F, -2.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(123, 100).addBox(-8.0F, 0.0F, -2.5F, 16.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -6.0F, 1.0F, 0.0385F, 0.2148F, 1.924F));

		PartDefinition left_arm2 = l_arm.addOrReplaceChild("left_arm2", CubeListBuilder.create().texOffs(70, 75).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(80, 49).addBox(-4.0F, 10.0F, -3.0F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 9.5F, 0.0F));

		PartDefinition l_arm_cloth = left_arm2.addOrReplaceChild("l_arm_cloth", CubeListBuilder.create().texOffs(88, 31).addBox(-3.5F, -4.25F, -3.0F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.5F))
		.texOffs(109, 129).mirror().addBox(-4.5F, 0.75F, -4.0F, 9.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 7.25F, 0.0F));

		PartDefinition hold = l_arm_cloth.addOrReplaceChild("hold", CubeListBuilder.create(), PartPose.offset(10.5F, -2.0F, 2.0F));

		PartDefinition r_arm = chest.addOrReplaceChild("r_arm", CubeListBuilder.create().texOffs(60, 0).addBox(-5.0F, -2.5F, -4.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -12.5F, 0.0F, -1.044F, 0.2117F, 0.25F));

		PartDefinition right_arm2 = r_arm.addOrReplaceChild("right_arm2", CubeListBuilder.create().texOffs(44, 75).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(68, 36).addBox(-3.0F, 10.0F, -3.0F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 9.5F, 0.0F, -1.9635F, 0.0F, 0.0F));

		PartDefinition r_arm_cloth = right_arm2.addOrReplaceChild("r_arm_cloth", CubeListBuilder.create().texOffs(84, 20).addBox(-3.5F, -4.25F, -3.0F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.5F))
		.texOffs(109, 129).addBox(-4.5F, 0.75F, -4.0F, 9.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 7.25F, 0.0F));

		PartDefinition axe = right_arm2.addOrReplaceChild("axe", CubeListBuilder.create().texOffs(3, 205).addBox(-1.5F, -1.5F, -32.0F, 3.0F, 3.0F, 48.0F, new CubeDeformation(0.0F))
		.texOffs(56, 241).addBox(-3.5F, 0.0F, -31.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 205).addBox(-1.5F, -1.5F, -32.0F, 3.0F, 3.0F, 48.0F, new CubeDeformation(0.0F))
		.texOffs(26, 241).addBox(-1.5F, -1.5F, -25.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.2F))
		.texOffs(26, 241).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.2F))
		.texOffs(25, 245).addBox(-1.5F, -1.5F, -18.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.4F))
		.texOffs(25, 245).addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.4F))
		.texOffs(25, 245).addBox(-1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.4F))
		.texOffs(57, 245).addBox(-2.5F, -2.5F, -28.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(57, 245).addBox(-2.5F, -2.5F, 15.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(60, 228).addBox(-3.5F, 0.0F, 17.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(64, 228).addBox(1.4F, 0.0F, 17.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(60, 231).addBox(-0.1F, 1.5F, 17.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(60, 233).addBox(-0.1F, -3.5F, 17.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(60, 241).addBox(1.5F, 0.0F, -31.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 13.5F, 0.0F));

		PartDefinition cube_r1 = axe.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(60, 241).addBox(1.5F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 241).addBox(-3.5F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -29.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r2 = axe.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(68, 231).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition axe_head = axe.addOrReplaceChild("axe_head", CubeListBuilder.create().texOffs(111, 249).addBox(-1.5F, -1.5F, -14.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.2F))
		.texOffs(68, 231).addBox(-1.5F, -1.5F, -13.8F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(122, 203).addBox(-0.5F, 7.4F, -8.8F, 1.0F, 10.0F, 9.0F, new CubeDeformation(-0.001F))
		.texOffs(0, 236).addBox(-1.5F, -5.5F, -5.8F, 3.0F, 11.0F, 6.0F, new CubeDeformation(0.3F))
		.texOffs(97, 232).addBox(-1.5F, -7.5F, -9.6F, 3.0F, 15.0F, 6.0F, new CubeDeformation(0.2F))
		.texOffs(73, 229).addBox(-1.5F, -7.5F, -8.8F, 3.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -32.2F));

		PartDefinition cube_r3 = axe_head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(81, 211).addBox(-0.5F, -3.5F, -5.5F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -10.5F, -4.3F, 0.48F, 0.0F, 0.0F));

		PartDefinition cube_r4 = axe_head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(156, 198).addBox(0.5F, -18.5F, -7.0F, 0.0F, 33.0F, 14.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-0.5F, 19.1267F, -0.0182F, -1.0036F, 0.0F, 0.0F));

		PartDefinition cube_r5 = axe_head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(142, 206).addBox(-0.5F, -13.5F, -1.0F, 1.0F, 16.0F, 6.0F, new CubeDeformation(0.001F))
		.texOffs(104, 208).addBox(-0.5F, 2.5F, -9.0F, 1.0F, 6.0F, 14.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, 14.0647F, -3.2431F, -1.0036F, 0.0F, 0.0F));

		PartDefinition cube_r6 = axe_head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(109, 214).addBox(0.5F, 2.5F, -9.0F, 0.0F, 6.0F, 14.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-0.5F, 17.2895F, -8.3051F, -1.0036F, 0.0F, 0.0F));

		PartDefinition cube_r7 = axe_head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(64, 228).addBox(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -15.8F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r8 = axe_head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(64, 228).addBox(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -15.8F, 0.0F, 0.0F, 0.7854F));

		PartDefinition emblem3 = axe_head.addOrReplaceChild("emblem3", CubeListBuilder.create().texOffs(168, 74).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(168, 68).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -5.3F, 1.5708F, -0.7854F, 1.5708F));

		PartDefinition right_arm_r7 = emblem3.addOrReplaceChild("right_arm_r7", CubeListBuilder.create().texOffs(169, 204).mirror().addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 0.5F, -0.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition emblem4 = axe_head.addOrReplaceChild("emblem4", CubeListBuilder.create().texOffs(168, 74).mirror().addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(169, 204).mirror().addBox(-4.5F, -3.5F, -0.5F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(168, 68).mirror().addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, -5.3F, 1.5708F, 0.7854F, -1.5708F));

		PartDefinition r_arm_armor = r_arm.addOrReplaceChild("r_arm_armor", CubeListBuilder.create().texOffs(112, 56).addBox(2.5086F, -5.3695F, -7.0F, 2.0F, 10.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(130, 86).addBox(2.5086F, -3.3695F, -7.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(130, 66).addBox(-7.4914F, 4.6305F, -7.0F, 12.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-6.4914F, -4.3695F, -6.0F, 11.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(138, 36).addBox(-8.4914F, -3.3695F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(106, 36).addBox(-6.4914F, -4.3695F, -6.0F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.2F))
		.texOffs(154, 40).addBox(-4.4914F, -3.3695F, -7.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(166, 38).addBox(-2.4914F, -4.3695F, -11.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(162, 46).addBox(-3.4914F, -1.3695F, -11.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(142, 55).addBox(-14.4914F, -0.3695F, -2.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(146, 49).addBox(-14.4914F, -4.3695F, 0.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition left_arm_r1 = r_arm_armor.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(168, 68).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(168, 74).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(182, 75).addBox(-0.5F, -0.5F, 0.5F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0086F, 5.1305F, -8.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition left_arm_r2 = r_arm_armor.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(130, 82).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4914F, 6.6305F, 6.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition left_arm_r3 = r_arm_armor.addOrReplaceChild("left_arm_r3", CubeListBuilder.create().texOffs(130, 82).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4914F, 6.6305F, -6.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition left_arm_r4 = r_arm_armor.addOrReplaceChild("left_arm_r4", CubeListBuilder.create().texOffs(154, 68).addBox(0.0F, 0.0F, -7.0F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4914F, 6.6305F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition left_arm_r5 = r_arm_armor.addOrReplaceChild("left_arm_r5", CubeListBuilder.create().texOffs(162, 46).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(166, 38).addBox(0.0F, -3.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4914F, -1.3695F, 9.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition left_arm_r6 = r_arm_armor.addOrReplaceChild("left_arm_r6", CubeListBuilder.create().texOffs(154, 40).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4914F, -1.3695F, 6.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition belt = body.addOrReplaceChild("belt", CubeListBuilder.create().texOffs(95, 131).addBox(3.5F, -19.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(100, 144).addBox(6.5F, -17.0F, -2.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(100, 144).mirror().addBox(-9.5F, -17.0F, -2.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(95, 131).mirror().addBox(-6.5F, -19.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(60, 66).addBox(-5.5F, -17.0F, -3.0F, 11.0F, 3.0F, 6.0F, new CubeDeformation(0.5F))
		.texOffs(157, 86).addBox(-5.5F, -19.0F, -3.0F, 11.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition body_r8 = belt.addOrReplaceChild("body_r8", CubeListBuilder.create().texOffs(100, 144).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(100, 144).mirror().addBox(-17.5F, 0.0F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, -17.0F, -0.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition emblem2 = belt.addOrReplaceChild("emblem2", CubeListBuilder.create().texOffs(168, 74).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(168, 68).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -15.5F, 3.5F, 3.1416F, 0.0F, 2.3562F));

		PartDefinition emblem = belt.addOrReplaceChild("emblem", CubeListBuilder.create().texOffs(168, 74).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(168, 68).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -15.5F, -3.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cloth2 = belt.addOrReplaceChild("cloth2", CubeListBuilder.create().texOffs(46, 127).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.5F, 3.5F));

		PartDefinition cloth = belt.addOrReplaceChild("cloth", CubeListBuilder.create().texOffs(46, 127).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.5F, -3.5F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}
	@Override
	public void setupAnim(Aptrgangr_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		if(entity.getAttackState() != 4) {
			this.animateWalk(Aptrgangr_Animation.WALK, limbSwing, limbSwingAmount, 2.5F, 4.0F);
		}
		this.animate(entity.getAnimationState("idle"), Aptrgangr_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("swing_right"), Aptrgangr_Animation.SWING_RIGHT, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("smash"), Aptrgangr_Animation.SMASH, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("charge_start"), Aptrgangr_Animation.RUSH_START, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("charge"), Aptrgangr_Animation.RUSHING, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("charge_end"), Aptrgangr_Animation.RUSH_END, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("charge_hit"), Aptrgangr_Animation.RUSH_HIT, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("death"), Aptrgangr_Animation.DEATH, ageInTicks, 1.0F);
	}



	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot += xRot * ((float) Math.PI / 180F);
		this.head.yRot += yRot * ((float) Math.PI / 180F);
	}

	public void translateToHand(PoseStack matrixStack) {
		this.root.translateAndRotate(matrixStack);
		this.roots.translateAndRotate(matrixStack);
		this.body.translateAndRotate(matrixStack);
		this.chest.translateAndRotate(matrixStack);
		this.l_arm.translateAndRotate(matrixStack);
		this.left_arm2.translateAndRotate(matrixStack);
		this.l_arm_cloth.translateAndRotate(matrixStack);
		this.hold.translateAndRotate(matrixStack);
	}



	public ModelPart root() {
		return this.root;
	}

}