package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Kobolediator_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class ModelKobolediator<T extends Kobolediator_Entity> extends HierarchicalModel<T> {

	private final ModelPart root;

	private final ModelPart everything;
	private final ModelPart mid_root;
	private final ModelPart pelvis;
	private final ModelPart lower_body;
	private final ModelPart body;
	private final ModelPart right_shoulder;
	private final ModelPart right_arm;
	private final ModelPart right_front_arm;
	private final ModelPart golden_greatsword;
	private final ModelPart left_shoulder;
	private final ModelPart left_arm;
	private final ModelPart left_front_arm;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart legs;
	private final ModelPart right_leg;
	private final ModelPart right_front_leg;
	private final ModelPart left_leg;
	private final ModelPart left_front_leg;


	public ModelKobolediator(ModelPart root) {
		this.root = root;
		this.everything = root.getChild("everything");
		this.mid_root = this.everything.getChild("mid_root");
		this.pelvis = this.mid_root.getChild("pelvis");
		this.lower_body = this.pelvis.getChild("lower_body");
		this.body = this.lower_body.getChild("body");
		this.right_shoulder = this.body.getChild("right_shoulder");
		this.right_arm = this.right_shoulder.getChild("right_arm");
		this.right_front_arm = this.right_arm.getChild("right_front_arm");
		this.golden_greatsword = this.right_front_arm.getChild("golden_greatsword");
		this.left_shoulder = this.body.getChild("left_shoulder");
		this.left_arm = this.left_shoulder.getChild("left_arm");
		this.left_front_arm = this.left_arm.getChild("left_front_arm");

		this.head = this.body.getChild("head");
		this.jaw = this.head.getChild("jaw");

		this.tail1 = this.pelvis.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");

		this.legs = this.mid_root.getChild("legs");
		this.right_leg = this.legs.getChild("right_leg");
		this.right_front_leg = this.right_leg.getChild("right_front_leg");
		this.left_leg = this.legs.getChild("left_leg");
		this.left_front_leg = this.left_leg.getChild("left_front_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, -1.0F));

		PartDefinition mid_root = everything.addOrReplaceChild("mid_root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition pelvis = mid_root.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(94, 72).addBox(-9.0F, -3.0F, -6.0513F, 18.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, 0.1745F, 0.1309F, 0.0F));

		PartDefinition lower_body = pelvis.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(86, 0).addBox(-6.2168F, -14.0F, -15.0F, 14.0F, 14.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(56, 146).addBox(-2.2168F, -14.0F, -3.0F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.7832F, 0.0F, 8.9487F));

		PartDefinition body = lower_body.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.2168F, -21.0F, -19.0F, 24.0F, 21.0F, 19.0F, new CubeDeformation(0.0F))
				.texOffs(126, 130).addBox(-3.2168F, -21.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 40).addBox(-10.2168F, -21.0F, -21.0F, 4.0F, 16.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(5.7832F, -21.0F, -21.0F, 4.0F, 16.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 40).addBox(-13.2168F, -21.0F, -19.0F, 26.0F, 7.0F, 19.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(1.0F, -14.0F, 0.0F, 0.1372F, -0.3027F, -0.0411F));

		PartDefinition right_shoulder = body.addOrReplaceChild("right_shoulder", CubeListBuilder.create().texOffs(0, 66).addBox(-16.0F, -4.0F, -9.0F, 17.0F, 15.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -20.0F, -8.0F, -0.6109F, 0.2618F, 0.2182F));

		PartDefinition right_arm = right_shoulder.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(94, 124).addBox(-5.0F, -1.0F, -4.0F, 8.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 9.0F, 2.0F, -0.4904F, 0.0334F, 0.0769F));

		PartDefinition right_front_arm = right_arm.addOrReplaceChild("right_front_arm", CubeListBuilder.create().texOffs(0, 100).addBox(-6.025F, 0.0F, -6.5F, 9.0F, 22.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 93).addBox(-8.025F, 2.0F, -8.5F, 8.0F, 18.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(67, 0).addBox(1.0F, 16.0F, -1.5F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(53, 69).addBox(1.0F, 17.0F, 1.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(53, 69).addBox(1.0F, 17.0F, -4.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.0F, 2.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition golden_greatsword = right_front_arm.addOrReplaceChild("golden_greatsword", CubeListBuilder.create().texOffs(80, 146).addBox(-2.2168F, -12.0F, -2.1F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(72, 72).addBox(-1.7168F, -78.0F, -4.1F, 3.0F, 66.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(71, 40).addBox(-2.2168F, -12.0F, 1.9F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 66).addBox(-2.2168F, -12.0F, -7.1F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 18.9F, 1.0F, 1.3963F, 0.0F, 0.0F));

		PartDefinition left_shoulder = body.addOrReplaceChild("left_shoulder", CubeListBuilder.create().texOffs(0, 66).mirror().addBox(-1.0F, -4.0F, -9.0F, 17.0F, 15.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.5663F, -20.0F, -8.0F, 0.0436F, -0.0873F, -0.1309F));

		PartDefinition left_arm = left_shoulder.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(94, 124).mirror().addBox(-3.0F, -1.0F, -4.0F, 8.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 9.0F, 2.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition left_front_arm = left_arm.addOrReplaceChild("left_front_arm", CubeListBuilder.create().texOffs(0, 100).mirror().addBox(-2.975F, 0.0F, -6.5F, 9.0F, 22.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(94, 93).mirror().addBox(0.025F, 2.0F, -8.5F, 8.0F, 18.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(53, 69).mirror().addBox(-5.0F, 17.0F, -4.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(67, 0).mirror().addBox(-5.0F, 16.0F, -1.5F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(53, 69).mirror().addBox(-5.0F, 17.0F, 1.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 13.0F, 2.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 119).addBox(-4.2168F, -3.0F, -10.0F, 10.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -30.0F, -9.0F, 0.0F, 0.1309F, 0.0F));

		PartDefinition head_cube1 = head.addOrReplaceChild("head_cube1", CubeListBuilder.create().texOffs(36, 100).addBox(0.8F, -5.0F, -8.0F, 6.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5663F, -2.0F, -2.0F, 0.1616F, 0.1866F, -0.0568F));

		PartDefinition head_cube2 = head.addOrReplaceChild("head_cube2", CubeListBuilder.create().texOffs(62, 38).addBox(1.0F, -6.0F, -12.0F, 6.0F, 6.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2168F, -3.0F, -2.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition head_cube3 = head.addOrReplaceChild("head_cube3", CubeListBuilder.create().texOffs(125, 113).addBox(-6.8F, -5.0F, -8.0F, 6.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -2.0F, 0.1616F, -0.1866F, 0.0568F));

		PartDefinition head_cube4 = head.addOrReplaceChild("head_cube4", CubeListBuilder.create().texOffs(102, 49).addBox(-3.0F, -34.0F, -23.0F, 9.0F, 7.0F, 10.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.7168F, 30.0F, 5.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition right_horn = head.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(148, 105).addBox(-9.2168F, -9.0F, 4.0513F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(148, 40).addBox(-9.2168F, -9.0F, -1.9487F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(129, 0).addBox(-9.2168F, -3.0F, -1.9487F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -5.0F, -3.0F));

		PartDefinition left_horn = head.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(148, 52).addBox(4.2168F, -9.0F, 4.0513F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(96, 146).addBox(3.2168F, -9.0F, -1.9487F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(123, 93).addBox(-2.7832F, -3.0F, -1.9487F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5663F, -5.0F, -3.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(102, 29).addBox(-2.7168F, -4.0F, -12.0F, 7.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -6.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition tail1 = pelvis.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(130, 54).addBox(-1.5F, -2.0F, -1.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1231F, 11.3724F, -0.3927F, 0.0F, 0.0F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(67, 0).addBox(-2.0F, -1.1888F, -1.1585F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.5F, 10.0F, 0.4799F, 0.0F, 0.0F));

		PartDefinition legs = mid_root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, -22.0F, 0.0F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(145, 70).addBox(-3.2168F, -2.0F, -3.0F, 7.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7832F, 4.0F, 0.9487F, -0.1295F, 0.5275F, 0.3306F));

		PartDefinition right_front_leg = right_leg.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(137, 22).addBox(-2.2168F, 0.0F, -1.0F, 7.0F, 11.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(53, 62).addBox(-1.2168F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(53, 62).addBox(3.7832F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(53, 62).addBox(1.2832F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.975F, 8.0F, -2.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(28, 138).addBox(-3.7832F, -2.0F, -3.0F, 7.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7832F, 3.0F, 0.9487F, -0.1295F, -0.5275F, -0.3306F));

		PartDefinition left_front_leg = left_leg.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 131).addBox(-4.7832F, 0.0F, -1.0F, 7.0F, 11.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(53, 62).mirror().addBox(1.2168F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(53, 62).mirror().addBox(-1.2832F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(53, 62).mirror().addBox(-3.7832F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.975F, 8.0F, -2.0F, 0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateHeadLookTarget(netHeadYaw, headPitch);
		if(entity.getAttackState() != 6 && !entity.isSleep()) {
			this.animateWalk(Kobolediator_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 4.0F);
		}
		this.animate(entity.getAnimationState("idle"), Kobolediator_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("sleep"), Kobolediator_Animation.SLEEP, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("awake"), Kobolediator_Animation.AWAKE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("sword1"), Kobolediator_Animation.SWORD1, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("sword2"), Kobolediator_Animation.SWORD2, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("charge"), Kobolediator_Animation.CHARGE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("charge_prepare"), Kobolediator_Animation.CHARGE_PREPARE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("charge_end"), Kobolediator_Animation.CHARGE_END, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("death"), Kobolediator_Animation.DEATH, ageInTicks, 1.0F);
	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot = xRot * ((float) Math.PI / 180F);
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}

	public ModelPart root() {
		return this.root;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}