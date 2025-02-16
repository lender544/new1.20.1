package com.github.L_Ender.cataclysm.client.model.entity;
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.github.L_Ender.cataclysm.client.animation.Hippocamtus_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Hippocamtus_Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class Hippocamtus_Model extends HierarchicalModel<Hippocamtus_Entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart root;
	private final ModelPart everything;
	private final ModelPart tail;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart tail4;
	private final ModelPart tail5;
	private final ModelPart body;
	private final ModelPart chest;
	private final ModelPart l_arm;
	private final ModelPart l_arm2;
	private final ModelPart r_arm;
	private final ModelPart r_arm2;
	private final ModelPart spear;
	private final ModelPart head;

	public Hippocamtus_Model(ModelPart root) {
		this.root = root;
		this.everything = this.root.getChild("everything");
		this.tail = this.everything.getChild("tail");
		this.tail2 = this.tail.getChild("tail2");
		this.tail3 = this.tail2.getChild("tail3");
		this.tail4 = this.tail3.getChild("tail4");
		this.tail5 = this.tail4.getChild("tail5");
		this.body = this.everything.getChild("body");
		this.chest = this.body.getChild("chest");
		this.l_arm = this.chest.getChild("l_arm");
		this.l_arm2 = this.l_arm.getChild("l_arm2");
		this.r_arm = this.chest.getChild("r_arm");
		this.r_arm2 = this.r_arm.getChild("r_arm2");
		this.spear = this.r_arm2.getChild("spear");
		this.head = this.chest.getChild("head");

	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition tail = everything.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 87).addBox(-5.0F, 0.0F, -3.0F, 10.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(137, 105).addBox(-10.0F, -4.0F, 0.0F, 5.0F, 11.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(15, 137).addBox(5.0F, -4.0F, 0.0F, 5.0F, 11.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(74, 130).addBox(3.0F, -3.0F, -3.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(132, 56).addBox(-5.0F, -3.0F, -3.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(38, 90).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -2.0F, -3.0F, 0.0F, -0.7418F, 0.0F));

		PartDefinition cube_r2 = tail.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 96).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -2.0F, 3.0F, 0.0F, 0.7418F, 0.0F));

		PartDefinition cube_r3 = tail.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(38, 93).addBox(0.0F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -2.0F, 3.0F, 0.0F, -0.7418F, 0.0F));

		PartDefinition cube_r4 = tail.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(38, 87).addBox(0.0F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -2.0F, -3.0F, 0.0F, 0.7418F, 0.0F));

		PartDefinition cube_r5 = tail.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(124, 23).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -3.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(93, 33).addBox(-4.5F, -1.5F, -2.5F, 9.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.5F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 102).addBox(-4.0F, -0.5F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(92, 113).addBox(0.0F, 0.5F, 2.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(113, 64).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(15, 127).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.3F))
				.texOffs(25, 102).addBox(0.0F, 1.0F, 2.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition tail5 = tail4.addOrReplaceChild("tail5", CubeListBuilder.create().texOffs(128, 43).addBox(-2.0F, 0.0F, -1.5F, 4.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(93, 0).addBox(-2.0F, 9.0F, -1.5F, 4.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(33, 87).addBox(0.0F, 9.0F, 7.5F, 0.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(122, 93).addBox(0.0F, 18.0F, -1.5F, 0.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(64, 135).addBox(0.0F, 3.0F, -3.5F, 0.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 1.0036F, 0.0F, 0.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(101, 93).addBox(-3.0F, -9.5F, -2.0F, 6.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.5F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(124, 14).addBox(-3.0F, -1.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.3F))
				.texOffs(132, 66).addBox(-2.0F, -10.0F, -2.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(122, 33).addBox(-2.5F, -10.0F, -3.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.5F, 0.0F));

		PartDefinition cube_r6 = chest.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(120, 109).addBox(6.0F, -3.0F, -6.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(120, 0).addBox(17.0F, -3.0F, -6.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.5F, -7.0F, 3.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r7 = chest.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(113, 46).addBox(0.0F, -4.5F, 3.0F, 0.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(41, 84).addBox(-6.0F, -3.5F, -4.0F, 12.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 1.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition l_arm = chest.addOrReplaceChild("l_arm", CubeListBuilder.create().texOffs(69, 140).addBox(3.0F, -5.0F, -2.5F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(123, 76).addBox(-1.0F, -3.0F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(139, 117).addBox(3.0F, -7.0F, 0.0F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(121, 134).addBox(1.0F, 2.0F, -2.5F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 114).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -5.0F, 0.0F, -0.1745F, 0.0F, -0.2618F));

		PartDefinition l_arm2 = l_arm.addOrReplaceChild("l_arm2", CubeListBuilder.create().texOffs(77, 113).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(41, 47).addBox(1.5F, -4.0F, -9.0F, 2.0F, 18.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(0, 131).addBox(2.5F, -8.0F, -1.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(91, 132).addBox(2.5F, 14.0F, -1.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(25, 112).addBox(-2.0F, -2.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(106, 134).addBox(0.0F, 9.0F, -2.5F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r8 = l_arm2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(141, 96).addBox(0.0F, -2.0F, -2.5F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition r_arm = chest.addOrReplaceChild("r_arm", CubeListBuilder.create().texOffs(141, 87).addBox(-3.0F, -5.0F, -2.5F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(120, 123).addBox(-3.0F, -3.0F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(34, 135).addBox(-3.0F, 2.0F, -2.5F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(44, 118).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, -5.0F, 0.0F, -0.1745F, 0.0F, 0.2618F));

		PartDefinition r_arm2 = r_arm.addOrReplaceChild("r_arm2", CubeListBuilder.create().texOffs(101, 109).addBox(-2.0F, -2.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(142, 75).addBox(-6.9F, -2.0F, 0.0F, 5.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(59, 118).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(106, 134).mirror().addBox(-2.0F, 9.0F, -2.5F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r9 = r_arm2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(141, 96).mirror().addBox(0.0F, -2.0F, -2.5F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 9.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition spear = r_arm2.addOrReplaceChild("spear", CubeListBuilder.create().texOffs(44, 112).addBox(-1.5F, -1.5143F, -23.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(49, 135).addBox(-1.0F, -1.0143F, -22.2F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(44, 112).addBox(-1.5F, -1.5143F, -17.2F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(136, 134).addBox(0.0F, 0.9857F, -22.2F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(137, 0).addBox(0.0F, -6.9143F, -22.2F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-0.5F, -0.5143F, -17.2F, 1.0F, 1.0F, 45.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).addBox(0.0F, -9.5143F, -43.0F, 0.0F, 19.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(33, 99).addBox(-0.5F, -0.5143F, -34.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.5143F, 0.2F, 0.3054F, 0.0F, 0.0F));

		PartDefinition head = chest.addOrReplaceChild("head", CubeListBuilder.create().texOffs(82, 47).addBox(-0.5F, -10.9086F, -4.2305F, 0.0F, 13.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(58, 99).addBox(0.0F, -12.9086F, -13.1305F, 3.0F, 12.0F, 6.0F, new CubeDeformation(0.2F))
				.texOffs(82, 76).addBox(-3.0F, -2.9086F, -12.1305F, 6.0F, 2.0F, 14.0F, new CubeDeformation(0.001F))
				.texOffs(93, 19).addBox(-3.0F, -6.9086F, -7.1305F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.001F))
				.texOffs(80, 93).addBox(-3.0F, -15.9086F, -8.1305F, 0.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(92, 124).addBox(-2.0F, -1.9086F, -18.1305F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.5F, -0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);

	}

	@Override
	public void setupAnim(Hippocamtus_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateHeadLookTarget(netHeadYaw, headPitch);

		this.animateWalk(Hippocamtus_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 1.5F);
		this.animate(entity.getAnimationState("idle"), Hippocamtus_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("stab"), Hippocamtus_Animation.STAB, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("swing1"), Hippocamtus_Animation.SWING, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("swing2"), Hippocamtus_Animation.SWING2, ageInTicks, 1.0F);

		this.animate(entity.getAnimationState("guard"), Hippocamtus_Animation.GUARD, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("guardcounter"), Hippocamtus_Animation.GUARD_COUNTER, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("parry"), Hippocamtus_Animation.PARRYING, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("death"), Hippocamtus_Animation.DEATH, ageInTicks, 1.0F);
	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot += xRot * ((float) Math.PI / 180F);
		this.head.yRot += yRot * ((float) Math.PI / 180F);
	}

	public ModelPart root() {
		return this.root;
	}

}