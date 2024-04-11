package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Wadjet_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Wadjet_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class Model_Wadjet<T extends Wadjet_Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor

	private final ModelPart root;
	private final ModelPart everything;
	private final ModelPart upper_body1;
	private final ModelPart pelvis;
	private final ModelPart upper_body2;
	private final ModelPart body;
	private final ModelPart neck1;
	private final ModelPart neck2;
	private final ModelPart head;
	private final ModelPart face;
	private final ModelPart jaw;

	private final ModelPart right_arm;
	private final ModelPart right_fore_arm;
	private final ModelPart right_finger1;
	private final ModelPart right_finger2;
	private final ModelPart right_finger3;
	private final ModelPart right_finger4;

	private final ModelPart wand;
	private final ModelPart left_arm;
	private final ModelPart left_fore_arm;
	private final ModelPart left_finger1;
	private final ModelPart left_finger2;
	private final ModelPart left_finger3;
	private final ModelPart left_finger4;

	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart tail4;
	private final ModelPart tail5;



	public Model_Wadjet(ModelPart root) {
		this.root = root;
		this.everything = root.getChild("everything");
		this.upper_body1 = this.everything.getChild("upper_body1");
		this.pelvis = this.upper_body1.getChild("pelvis");
		this.upper_body2 = this.pelvis.getChild("upper_body2");
		this.body = this.upper_body2.getChild("body");
		this.neck1 = this.body.getChild("neck1");
		this.neck2 = this.neck1.getChild("neck2");
		this.head = this.neck2.getChild("head");
		this.face = this.head.getChild("face");
		this.jaw = this.face.getChild("jaw");

		this.right_arm = this.body.getChild("right_arm");
		this.right_fore_arm = this.right_arm.getChild("right_fore_arm");
		this.wand = this.right_fore_arm.getChild("wand");
		this.right_finger1 = this.right_fore_arm.getChild("right_finger1");
		this.right_finger2 = this.right_fore_arm.getChild("right_finger2");
		this.right_finger3 = this.right_fore_arm.getChild("right_finger3");
		this.right_finger4 = this.right_fore_arm.getChild("right_finger4");

		this.left_arm = this.body.getChild("left_arm");
		this.left_fore_arm = this.left_arm.getChild("left_fore_arm");
		this.left_finger1 = this.left_fore_arm.getChild("left_finger1");
		this.left_finger2 = this.left_fore_arm.getChild("left_finger2");
		this.left_finger3 = this.left_fore_arm.getChild("left_finger3");
		this.left_finger4 = this.left_fore_arm.getChild("left_finger4");

		this.tail1 = this.everything.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.tail3 = this.tail2.getChild("tail3");
		this.tail4 = this.tail3.getChild("tail4");
		this.tail5 = this.tail4.getChild("tail5");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 18.1769F, -2.6276F));

		PartDefinition upper_body1 = everything.addOrReplaceChild("upper_body1", CubeListBuilder.create().texOffs(0, 63).addBox(-5.5F, -17.8375F, -3.68F, 11.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 2.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition pelvis = upper_body1.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(0, 47).addBox(-4.5076F, -3.0225F, -5.0839F, 9.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.8375F, 2.02F, 0.5716F, 0.0F, 0.0F));

		PartDefinition upper_body2 = pelvis.addOrReplaceChild("upper_body2", CubeListBuilder.create().texOffs(79, 63).addBox(-8.5403F, -15.7808F, -5.6395F, 17.0F, 7.2F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(37, 0).addBox(-3.5403F, -13.7808F, -3.6395F, 7.0F, 14.2F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0076F, -2.9878F, 0.5324F, -0.1814F, 0.0F, 0.0F));

		PartDefinition body = upper_body2.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0492F, -6.6808F, 0.7605F, 0.0429F, 0.0F, 0.0F));

		PartDefinition neck1 = body.addOrReplaceChild("neck1", CubeListBuilder.create().texOffs(112, 79).addBox(-4.3316F, -7.2976F, 0.0584F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.3316F, -7.3252F, -3.9267F, 5.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 0.0F, -0.2593F, 0.0F, 0.0F));

		PartDefinition neck2 = neck1.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(38, 63).addBox(-2.1895F, -8.4892F, -4.7357F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.1F))
		.texOffs(31, 26).addBox(-7.1895F, -7.5444F, -0.8563F, 14.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3579F, -7.4995F, 1.0809F, 0.7854F, 0.0F, 0.0F));

		PartDefinition head = neck2.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0895F, -6.8719F, -1.2524F, -0.4363F, 0.0F, 0.0F));

		PartDefinition face = head.addOrReplaceChild("face", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = face.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(103, 0).addBox(-1.0F, -9.9F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, 8.0116F, -1.3235F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r2 = face.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(31, 47).addBox(-2.2863F, -1.9404F, -0.9425F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, 1.0116F, -6.3235F, 0.7195F, 0.4166F, 0.2315F));

		PartDefinition cube_r3 = face.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(99, 99).addBox(-0.7137F, -1.9404F, -0.9425F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, 1.0116F, -6.3235F, 0.7195F, -0.4166F, -0.2315F));

		PartDefinition cube_r4 = face.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(103, 20).addBox(-1.0F, -10.0F, -4.8F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 8.0116F, -1.3235F, 0.3491F, 0.0F, 0.0F));

		PartDefinition jaw = face.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(103, 10).addBox(-2.1895F, -1.0797F, -6.0886F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5895F, 0.9632F, -2.4564F, 0.3927F, 0.0F, 0.0F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(65, 25).addBox(-10.2F, -1.9395F, -1.9186F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3F, -5.8F, -2.4F, 0.0F, 0.5672F, -1.2654F));

		PartDefinition right_fore_arm = right_arm.addOrReplaceChild("right_fore_arm", CubeListBuilder.create().texOffs(0, 90).addBox(-11.0F, -0.4395F, -1.9186F, 11.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(65, 0).addBox(-12.0F, -0.9395F, -2.4186F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.2F, -1.475F, 0.0F, 0.0F, -0.6545F, 0.0F));

		PartDefinition right_finger1 = right_fore_arm.addOrReplaceChild("right_finger1", CubeListBuilder.create().texOffs(0, 35).addBox(-6.0211F, -0.936F, 0.3767F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 1.1F, -2.3F));

		PartDefinition right_finger2 = right_fore_arm.addOrReplaceChild("right_finger2", CubeListBuilder.create().texOffs(31, 36).addBox(-6.0211F, -0.936F, 0.3767F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 1.1F, -0.3F));

		PartDefinition right_finger3 = right_fore_arm.addOrReplaceChild("right_finger3", CubeListBuilder.create().texOffs(0, 38).addBox(-6.0211F, -0.936F, 0.3767F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 1.1F, 1.7F));

		PartDefinition right_finger4 = right_fore_arm.addOrReplaceChild("right_finger4", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0211F, 0.164F, -0.7233F, 6.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, 2.5F, -2.7F));

		PartDefinition wand = right_fore_arm.addOrReplaceChild("wand", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -25.0F, 2.0F, 2.0F, 60.0F, new CubeDeformation(0.0F))
		.texOffs(65, 0).addBox(0.0F, -7.0F, -45.0F, 0.0F, 16.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0F, 1.0F, 0.0F));

		PartDefinition cube_r5 = wand.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 63).addBox(-2.0F, -20.0F, -45.0F, 0.0F, 16.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(65, 16).addBox(-0.8F, -1.9395F, -1.9186F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.121F, -5.8F, -2.4F, 0.0F, -0.2618F, 1.2654F));

		PartDefinition left_fore_arm = left_arm.addOrReplaceChild("left_fore_arm", CubeListBuilder.create().texOffs(38, 90).addBox(0.0F, -0.4395F, -1.9186F, 11.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(65, 8).addBox(1.0F, -0.9395F, -2.4186F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.2F, -1.475F, 0.0F, 0.0F, 0.6545F, 0.0F));

		PartDefinition left_finger1 = left_fore_arm.addOrReplaceChild("left_finger1", CubeListBuilder.create().texOffs(0, 32).addBox(0.0211F, -0.936F, 0.3767F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 1.1F, -2.3F));

		PartDefinition left_finger2 = left_fore_arm.addOrReplaceChild("left_finger2", CubeListBuilder.create().texOffs(0, 29).addBox(0.0211F, -0.936F, 0.3767F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 1.1F, -0.3F));

		PartDefinition left_finger3 = left_fore_arm.addOrReplaceChild("left_finger3", CubeListBuilder.create().texOffs(0, 26).addBox(0.0211F, -0.936F, 0.3767F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 1.1F, 1.7F));

		PartDefinition left_finger4 = left_fore_arm.addOrReplaceChild("left_finger4", CubeListBuilder.create().texOffs(0, 13).addBox(-0.9789F, 0.164F, -0.7233F, 6.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 2.5F, -2.7F));

		PartDefinition tail1 = everything.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(38, 63).addBox(-5.0F, -3.0F, 0.0F, 10.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.8231F, 0.6276F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 18.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 26).addBox(-3.5F, -2.0F, 0.0F, 7.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 18.0F));

		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(83, 79).addBox(-2.5F, -2.0F, 0.0F, 6.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 1.0F, 15.0F));

		PartDefinition tail5 = tail4.addOrReplaceChild("tail5", CubeListBuilder.create().texOffs(75, 99).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, 15.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		ModelPart[] tailOriginal = new ModelPart[]{tail1, tail2, tail3, tail4, tail5};
		float swimSpeed = 0.1F;
		float swimDegree = 0.5F;

		this.animateHeadLookTarget(netHeadYaw, headPitch);
		if(entity.getAttackState() != 6) {
			this.animateWalk(Wadjet_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 5.0F);
		}
		this.animate(entity.getAnimationState("idle"), Wadjet_Animation.IDLE, ageInTicks, 1.0F);
		this.chainSwing(tailOriginal, swimSpeed * 4F, swimDegree * 1F, -3, limbSwing,limbSwingAmount);
		this.chainSwing(tailOriginal, swimSpeed * 0.6F, swimDegree * 0.5F, -3, ageInTicks,1.0F);
	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		float yawAmount = yRot / 57.295776F;
		float pitchAmount = xRot / 57.295776F;
		this.neck1.xRot += pitchAmount * 0.5F;
		this.neck1.yRot += yawAmount * 0.5F;
		this.neck2.xRot += pitchAmount * 0.5F;
		this.neck2.yRot += yawAmount * 0.5F;
		this.face.xRot += pitchAmount * 0.5F;
		this.face.yRot += yawAmount * 0.5F;

	}


	public void chainSwing(ModelPart[] boxes, float speed, float degree, double rootOffset, float swing, float swingAmount) {
		float offset = this.calculateChainOffset(rootOffset, boxes);

		for(int index = 0; index < boxes.length; ++index) {
			boxes[index].yRot += this.calculateChainRotation(speed, degree, swing, swingAmount, offset, index);
		}

	}

	private float calculateChainRotation(float speed, float degree, float swing, float swingAmount, float offset, int boxIndex) {
		return Mth.cos(swing * speed * 1.0F + offset * (float)boxIndex) * swingAmount * degree * 1.0F;
	}

	private float calculateChainOffset(double rootOffset, ModelPart... boxes) {
		return (float)(rootOffset * Math.PI / (double)(2 * boxes.length));
	}


	public ModelPart root() {
		return this.root;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}