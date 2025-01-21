package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Prowler_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.The_Prowler_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.WardenModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class The_Prowler_Model extends HierarchicalModel<The_Prowler_Entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart root;
	private final ModelPart roots;
	private final ModelPart upperbody;
	private final ModelPart chestplate;
	private final ModelPart eye_blow;
	private final ModelPart chestplate2;
	private final ModelPart rocket_luncher;
	private final ModelPart missile;
	private final ModelPart missile2;
	private final ModelPart missile3;
	private final ModelPart right_arm;
	private final ModelPart right_arm_joint;
	private final ModelPart sholder_pad;
	private final ModelPart sholder_pad2;
	private final ModelPart right_arm2;
	private final ModelPart right_joint;
	private final ModelPart chainsaw;
	private final ModelPart saw;
	private final ModelPart blade5;
	private final ModelPart blade6;
	private final ModelPart blade7;
	private final ModelPart blade8;
	private final ModelPart blade;
	private final ModelPart blade2;
	private final ModelPart blade3;
	private final ModelPart blade4;
	private final ModelPart pelvis;
	private final ModelPart catapiller;
	private final ModelPart catapiller2;
	private final ModelPart pipe2;
	private final ModelPart pipe;

	public The_Prowler_Model(ModelPart root) {
		this.root = root;
		this.roots = this.root.getChild("roots");
		this.upperbody = this.roots.getChild("upperbody");
		this.chestplate = this.upperbody.getChild("chestplate");
		this.eye_blow = this.chestplate.getChild("eye_blow");
		this.chestplate2 = this.chestplate.getChild("chestplate2");
		this.rocket_luncher = this.upperbody.getChild("rocket_luncher");
		this.missile = this.rocket_luncher.getChild("missile");
		this.missile2 = this.rocket_luncher.getChild("missile2");
		this.missile3 = this.rocket_luncher.getChild("missile3");
		this.right_arm = this.upperbody.getChild("right_arm");
		this.right_arm_joint = this.right_arm.getChild("right_arm_joint");
		this.sholder_pad = this.right_arm_joint.getChild("sholder_pad");
		this.sholder_pad2 = this.sholder_pad.getChild("sholder_pad2");
		this.right_arm2 = this.right_arm_joint.getChild("right_arm2");
		this.right_joint = this.right_arm2.getChild("right_joint");
		this.chainsaw = this.right_joint.getChild("chainsaw");
		this.saw = this.chainsaw.getChild("saw");
		this.blade5 = this.saw.getChild("blade5");
		this.blade6 = this.saw.getChild("blade6");
		this.blade7 = this.saw.getChild("blade7");
		this.blade8 = this.saw.getChild("blade8");
		this.blade = this.saw.getChild("blade");
		this.blade2 = this.saw.getChild("blade2");
		this.blade3 = this.saw.getChild("blade3");
		this.blade4 = this.saw.getChild("blade4");
		this.pelvis = this.roots.getChild("pelvis");
		this.catapiller = this.pelvis.getChild("catapiller");
		this.catapiller2 = this.pelvis.getChild("catapiller2");
		this.pipe2 = this.pelvis.getChild("pipe2");
		this.pipe = this.pelvis.getChild("pipe");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition roots = partdefinition.addOrReplaceChild("roots", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition upperbody = roots.addOrReplaceChild("upperbody", CubeListBuilder.create(), PartPose.offset(0.0F, -23.5F, 0.0F));

		PartDefinition chestplate = upperbody.addOrReplaceChild("chestplate", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -13.0F, -3.0F, 14.0F, 13.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -7.0F));

		PartDefinition eye_blow = chestplate.addOrReplaceChild("eye_blow", CubeListBuilder.create().texOffs(2, 172).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -3.25F));

		PartDefinition chestplate2 = chestplate.addOrReplaceChild("chestplate2", CubeListBuilder.create().texOffs(114, 110).addBox(-10.0F, -40.0F, 0.0F, 6.0F, 13.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 25.0F, 0.0F));

		PartDefinition rocket_luncher = upperbody.addOrReplaceChild("rocket_luncher", CubeListBuilder.create().texOffs(48, 45).addBox(6.0F, -17.0F, -11.0F, 6.0F, 20.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 61).addBox(6.0F, -17.0F, -12.0F, 6.0F, 13.0F, 17.0F, new CubeDeformation(0.3F))
		.texOffs(37, 41).addBox(0.0F, -2.0F, 5.0F, 10.0F, 0.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 34).addBox(9.0F, -13.0F, 5.0F, 0.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(14, 50).addBox(8.0F, -3.0F, 5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 47).addBox(2.0F, -3.0F, 7.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 44).addBox(8.0F, -13.0F, 5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 118).addBox(0.0F, -8.0F, -8.0F, 6.0F, 13.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -6.5F, 1.0F));

		PartDefinition missile = rocket_luncher.addOrReplaceChild("missile", CubeListBuilder.create().texOffs(76, 2).addBox(-1.0F, -1.0F, -5.9F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(44, 30).addBox(0.0F, -3.0F, -0.9F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(0.0F, 1.0F, -0.9F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 41).addBox(-1.0F, -1.0F, -3.9F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(7, 16).addBox(-1.0F, -1.0F, 2.1F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offset(9.0F, -14.0F, -7.6F));

		PartDefinition missile2 = rocket_luncher.addOrReplaceChild("missile2", CubeListBuilder.create().texOffs(76, 2).addBox(-1.0F, -1.0F, -5.9F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(44, 30).addBox(0.0F, -3.0F, -0.9F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(0.0F, 1.0F, -0.9F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 41).addBox(-1.0F, -1.0F, -3.9F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(7, 16).addBox(-1.0F, -1.0F, 2.1F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offset(9.0F, -7.0F, -7.6F));

		PartDefinition missile3 = rocket_luncher.addOrReplaceChild("missile3", CubeListBuilder.create().texOffs(76, 2).addBox(-1.0F, -1.0F, -5.9F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(44, 30).addBox(0.0F, -3.0F, -0.9F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(0.0F, 1.0F, -0.9F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 41).addBox(-1.0F, -1.0F, -3.9F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(7, 16).addBox(-1.0F, -1.0F, 2.1F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offset(9.0F, 0.0F, -7.6F));

		PartDefinition right_arm = upperbody.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-13.0F, -13.5F, 1.0F));

		PartDefinition right_arm_joint = right_arm.addOrReplaceChild("right_arm_joint", CubeListBuilder.create().texOffs(67, 125).addBox(-11.0F, -6.0F, -5.0F, 11.0F, 16.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(44, 48).addBox(-5.0F, 5.0F, -7.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, 5.0F, 5.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition sholder_pad = right_arm_joint.addOrReplaceChild("sholder_pad", CubeListBuilder.create().texOffs(0, 151).addBox(-4.0F, -2.5F, -6.0F, 8.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 4.5F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition sholder_pad2 = sholder_pad.addOrReplaceChild("sholder_pad2", CubeListBuilder.create().texOffs(0, 151).addBox(-4.0F, -2.5F, -6.0F, 8.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 5.0F, 0.0F));

		PartDefinition right_arm2 = right_arm_joint.addOrReplaceChild("right_arm2", CubeListBuilder.create().texOffs(96, 63).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 16.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 91).addBox(-3.0F, -8.0F, 1.0F, 6.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 7.0F, 0.0F));

		PartDefinition right_joint = right_arm2.addOrReplaceChild("right_joint", CubeListBuilder.create().texOffs(76, 41).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 70).addBox(-4.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(62, 104).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.3F))
		.texOffs(49, 0).addBox(3.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition chainsaw = right_joint.addOrReplaceChild("chainsaw", CubeListBuilder.create().texOffs(93, 78).addBox(-3.0F, -3.0F, -21.0F, 2.0F, 6.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(0, 91).addBox(1.0F, -3.0F, -21.0F, 2.0F, 6.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition saw = chainsaw.addOrReplaceChild("saw", CubeListBuilder.create().texOffs(74, 63).addBox(-1.0714F, -9.0F, -9.0F, 2.0F, 18.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(-0.0714F, -16.0F, -4.5F, 0.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-0.0714F, 9.0F, -4.5F, 0.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(-0.0714F, -4.5F, -16.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(49, 4).addBox(-0.0714F, -4.5F, 9.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(64, 41).addBox(-4.0714F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 36).addBox(1.9286F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0714F, 0.0F, -18.0F));

		PartDefinition blade5 = saw.addOrReplaceChild("blade5", CubeListBuilder.create().texOffs(0, 0).addBox(-0.8214F, 8.0F, -9.0F, 0.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition blade6 = saw.addOrReplaceChild("blade6", CubeListBuilder.create().texOffs(0, 0).addBox(0.6786F, 8.0F, 0.0F, 0.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition blade7 = saw.addOrReplaceChild("blade7", CubeListBuilder.create().texOffs(49, 4).addBox(-0.8214F, 0.0F, 8.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition blade8 = saw.addOrReplaceChild("blade8", CubeListBuilder.create().texOffs(49, 4).addBox(0.6786F, -9.0F, 8.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition blade = saw.addOrReplaceChild("blade", CubeListBuilder.create().texOffs(0, 25).addBox(-0.8214F, -15.0F, 0.0F, 0.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition blade2 = saw.addOrReplaceChild("blade2", CubeListBuilder.create().texOffs(0, 25).addBox(0.6786F, -15.0F, -9.0F, 0.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition blade3 = saw.addOrReplaceChild("blade3", CubeListBuilder.create().texOffs(0, 54).addBox(-0.8214F, -9.0F, -15.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition blade4 = saw.addOrReplaceChild("blade4", CubeListBuilder.create().texOffs(0, 54).addBox(0.6786F, 0.0F, -15.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition pelvis = roots.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(0, 34).addBox(-6.0F, 12.0F, -11.0F, 12.0F, 7.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(34, 138).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(49, 0).addBox(-4.0F, 7.0F, -5.0F, 8.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(98, 0).addBox(-5.0F, -1.0F, -7.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(66, 81).addBox(3.0F, -1.0F, -7.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(37, 61).addBox(2.0F, -1.0F, 4.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(29, 61).addBox(-4.0F, -1.0F, 4.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 18).addBox(-6.0F, 2.0F, -9.0F, 12.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -23.0F, 1.0F));

		PartDefinition catapiller = pelvis.addOrReplaceChild("catapiller", CubeListBuilder.create().texOffs(31, 104).addBox(-9.0F, -4.0F, -14.5F, 8.0F, 12.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(92, 41).addBox(-10.0F, -5.0F, -15.5F, 10.0F, 5.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(129, 35).addBox(-9.0F, 0.0F, 0.5F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(118, 63).addBox(-10.0F, -1.0F, -1.5F, 10.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 15.0F, -0.5F));

		PartDefinition catapiller2 = pelvis.addOrReplaceChild("catapiller2", CubeListBuilder.create().texOffs(94, 0).addBox(1.0F, -4.0F, -14.5F, 8.0F, 12.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(29, 82).addBox(0.0F, -5.0F, -15.5F, 10.0F, 5.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(77, 105).addBox(0.0F, -1.0F, -2.5F, 10.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(128, 15).addBox(1.0F, 0.0F, 0.5F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 15.0F, -0.5F));

		PartDefinition pipe2 = pelvis.addOrReplaceChild("pipe2", CubeListBuilder.create().texOffs(56, 48).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 2).addBox(-1.0F, -3.0F, 1.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(5.0F, 11.0F, 8.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition pipe = pelvis.addOrReplaceChild("pipe", CubeListBuilder.create().texOffs(75, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(63, 11).addBox(-1.0F, -3.0F, 1.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(10, 16).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-5.0F, 11.0F, 8.0F, -0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(The_Prowler_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.upperbody.yRot += netHeadYaw * 0.6F * Mth.DEG_TO_RAD;
		float sawspeed = entity.getAttackState() == 3 ? 0F : 0.5f;
		this.animate(entity.getAnimationState("death"), Prowler_Animation.DEATH, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("idle"), Prowler_Animation.IDLE, ageInTicks, 1.0f);
		this.animate(entity.getAnimationState("spin"), Prowler_Animation.SPIN, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("melee"), Prowler_Animation.MELEE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("strong_attack"), Prowler_Animation.STRONG_ATTACK, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("stun"), Prowler_Animation.STUN, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("laser"), Prowler_Animation.LASER, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("pierce"), Prowler_Animation.PIERCE, ageInTicks, 1.0F);
		saw.xRot -= ageInTicks * sawspeed;
	}

	public ModelPart root() {
		return this.root;
	}

}