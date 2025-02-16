package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Cindaria_Animation;
import com.github.L_Ender.cataclysm.client.animation.Hippocamtus_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Cindaria_Entity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class Cindaria_Model extends HierarchicalModel<Cindaria_Entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart root;
	private final ModelPart everything;

	private final ModelPart lowerBody;
	private final ModelPart upperBody;
	private final ModelPart head;
	private final ModelPart head2;
	private final ModelPart rightHeadArm;
	private final ModelPart rightHeadArm2;
	private final ModelPart rightHeadArm3;
	private final ModelPart leftHeadArm;
	private final ModelPart leftHeadArm2;
	private final ModelPart leftHeadArm3;
	private final ModelPart rightArm;
	private final ModelPart rightArm2;
	private final ModelPart staff;
	private final ModelPart bone;
	private final ModelPart leftArm;
	private final ModelPart leftArm2;
	private final ModelPart skirt;
	private final ModelPart skirt2;
	private final ModelPart rightLeg;
	private final ModelPart rightLeg2;
	private final ModelPart leftLeg;
	private final ModelPart leftLeg2;

	public Cindaria_Model(ModelPart root) {
		this.root = root;
		this.everything = this.root.getChild("everything");
		this.lowerBody = this.everything.getChild("lowerBody");
		this.upperBody = this.lowerBody.getChild("upperBody");
		this.head = this.upperBody.getChild("head");
		this.head2 = this.head.getChild("head2");
		this.rightHeadArm = this.head2.getChild("rightHeadArm");
		this.rightHeadArm2 = this.rightHeadArm.getChild("rightHeadArm2");
		this.rightHeadArm3 = this.rightHeadArm2.getChild("rightHeadArm3");
		this.leftHeadArm = this.head2.getChild("leftHeadArm");
		this.leftHeadArm2 = this.leftHeadArm.getChild("leftHeadArm2");
		this.leftHeadArm3 = this.leftHeadArm2.getChild("leftHeadArm3");
		this.rightArm = this.upperBody.getChild("rightArm");
		this.rightArm2 = this.rightArm.getChild("rightArm2");
		this.staff = this.rightArm2.getChild("staff");
		this.bone = this.staff.getChild("bone");
		this.leftArm = this.upperBody.getChild("leftArm");
		this.leftArm2 = this.leftArm.getChild("leftArm2");
		this.skirt = this.lowerBody.getChild("skirt");
		this.skirt2 = this.lowerBody.getChild("skirt2");
		this.rightLeg = this.everything.getChild("rightLeg");
		this.rightLeg2 = this.rightLeg.getChild("rightLeg2");
		this.leftLeg = this.everything.getChild("leftLeg");
		this.leftLeg2 = this.leftLeg.getChild("leftLeg2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition lowerBody = everything.addOrReplaceChild("lowerBody", CubeListBuilder.create().texOffs(64, 44).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.0F, 0.0F));

		PartDefinition cube_r1 = lowerBody.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(64, 80).addBox(0.0F, 0.0F, -2.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cube_r2 = lowerBody.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(52, 80).addBox(0.0F, 0.0F, -2.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition cube_r3 = lowerBody.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(72, 0).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 2.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition upperBody = lowerBody.addOrReplaceChild("upperBody", CubeListBuilder.create().texOffs(72, 12).addBox(-3.5F, -10.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(16, 74).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition cube_r4 = upperBody.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(114, 123).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -2.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r5 = upperBody.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(114, 123).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -2.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition head = upperBody.addOrReplaceChild("head", CubeListBuilder.create().texOffs(56, 52).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(64, 28).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.4F)), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(56, 68).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition head2 = head.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -9.0F, -9.0F, 18.0F, 10.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(0, 28).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 8.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 52).addBox(-7.0F, 0.0F, -7.0F, 14.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition rightHeadArm = head2.addOrReplaceChild("rightHeadArm", CubeListBuilder.create().texOffs(22, 94).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition rightHeadArm2 = rightHeadArm.addOrReplaceChild("rightHeadArm2", CubeListBuilder.create().texOffs(42, 86).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition rightHeadArm3 = rightHeadArm2.addOrReplaceChild("rightHeadArm3", CubeListBuilder.create().texOffs(0, 86).addBox(-0.5F, 0.0F, -2.5F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition leftHeadArm = head2.addOrReplaceChild("leftHeadArm", CubeListBuilder.create().texOffs(94, 75).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition leftHeadArm2 = leftHeadArm.addOrReplaceChild("leftHeadArm2", CubeListBuilder.create().texOffs(88, 44).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition leftHeadArm3 = leftHeadArm2.addOrReplaceChild("leftHeadArm3", CubeListBuilder.create().texOffs(30, 86).addBox(-0.5F, 0.0F, -2.5F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition rightArm = upperBody.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(88, 56).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -9.0F, 0.0F, -0.3054F, 0.0F, 0.1745F));

		PartDefinition rightArm2 = rightArm.addOrReplaceChild("rightArm2", CubeListBuilder.create().texOffs(90, 87).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -2.3551F, -0.0262F, -0.0832F));

		PartDefinition staff = rightArm2.addOrReplaceChild("staff", CubeListBuilder.create().texOffs(180, 41).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(152, 48).addBox(0.0F, -24.0F, -4.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(180, 33).addBox(-4.0F, -24.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(128, 33).addBox(0.0F, 6.0F, -6.0F, 0.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(152, 33).addBox(-6.0F, 6.0F, 0.0F, 12.0F, 15.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(168, 48).addBox(-1.0F, -26.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(176, 33).addBox(-0.5F, -20.0F, -0.5F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(180, 47).addBox(-0.5F, -28.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition bone = staff.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(128, 0).addBox(-9.5F, 0.0F, -9.5F, 19.0F, 14.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition leftArm = upperBody.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(94, 12).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -9.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition leftArm2 = leftArm.addOrReplaceChild("leftArm2", CubeListBuilder.create().texOffs(12, 94).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition skirt = lowerBody.addOrReplaceChild("skirt", CubeListBuilder.create().texOffs(0, 110).addBox(-7.0F, 0.0F, -5.0F, 14.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 0.0F));

		PartDefinition skirt2 = lowerBody.addOrReplaceChild("skirt2", CubeListBuilder.create().texOffs(55, 115).addBox(-4.5F, 0.0F, -2.5F, 9.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 74).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -20.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition rightLeg2 = rightLeg.addOrReplaceChild("rightLeg2", CubeListBuilder.create().texOffs(16, 82).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 8.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(36, 74).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -20.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition leftLeg2 = leftLeg.addOrReplaceChild("leftLeg2", CubeListBuilder.create().texOffs(80, 75).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 8.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}


	@Override
	public void setupAnim(Cindaria_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		this.animateWalk(Cindaria_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 1.5F);
		this.animate(entity.getAnimationState("idle"), Cindaria_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("magic1"), Cindaria_Animation.MAGIC, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("melee"), Cindaria_Animation.MELEE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("death"), Cindaria_Animation.DEATH, ageInTicks, 1.0F);
	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot = xRot * ((float) Math.PI / 180F);
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}

	public ModelPart root() {
		return this.root;
	}
}