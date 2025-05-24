package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Symbiocto_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Symbiocto_Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class Symbiocto_Model extends HierarchicalModel<Symbiocto_Entity> {
	private final ModelPart root;
	private final ModelPart everything;
	private final ModelPart octo_head;
	private final ModelPart back_tentacle1;
	private final ModelPart face_tentacle2;
	private final ModelPart face_tentacle1;
	private final ModelPart face_tentacle3;
	private final ModelPart teeth2;
	private final ModelPart teeth;
	private final ModelPart teeth3;
	private final ModelPart teeth4;
	private final ModelPart left_tentacle1;
	private final ModelPart right_tentacle1;
	private final ModelPart left_tentacle2;
	private final ModelPart right_tentacle2;
	private final ModelPart left_tentacle3;
	private final ModelPart right_tentacle3;
	private final ModelPart back_tentacle2;
	private final ModelPart back_tentacle3;


	public Symbiocto_Model(ModelPart root) {
		this.root = root;
		this.everything = this.root.getChild("everything");
		this.octo_head = this.everything.getChild("octo_head");
		this.back_tentacle1 = this.octo_head.getChild("back_tentacle1");
		this.face_tentacle2 = this.octo_head.getChild("face_tentacle2");
		this.face_tentacle1 = this.octo_head.getChild("face_tentacle1");
		this.face_tentacle3 = this.octo_head.getChild("face_tentacle3");
		this.teeth2 = this.octo_head.getChild("teeth2");
		this.teeth = this.octo_head.getChild("teeth");
		this.teeth3 = this.octo_head.getChild("teeth3");
		this.teeth4 = this.octo_head.getChild("teeth4");
		this.left_tentacle1 = this.octo_head.getChild("left_tentacle1");
		this.right_tentacle1 = this.octo_head.getChild("right_tentacle1");
		this.left_tentacle2 = this.octo_head.getChild("left_tentacle2");
		this.right_tentacle2 = this.octo_head.getChild("right_tentacle2");
		this.left_tentacle3 = this.octo_head.getChild("left_tentacle3");
		this.right_tentacle3 = this.octo_head.getChild("right_tentacle3");
		this.back_tentacle2 = this.octo_head.getChild("back_tentacle2");
		this.back_tentacle3 = this.octo_head.getChild("back_tentacle3");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition octo_head = everything.addOrReplaceChild("octo_head", CubeListBuilder.create().texOffs(40, 58).addBox(4.5F, -3.0F, -2.5F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(41, 18).addBox(6.5F, -6.0F, -3.5F, 0.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-4.5F, -5.0F, -4.5F, 9.0F, 9.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(100, 119).addBox(-3.5F, 2.0F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 21).addBox(-4.5F, -5.0F, -4.5F, 9.0F, 9.0F, 11.0F, new CubeDeformation(0.2F))
				.texOffs(0, 55).addBox(-2.5F, -9.0F, -4.5F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(41, 0).addBox(4.5F, -7.0F, 0.5F, 0.0F, 7.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(41, 0).mirror().addBox(-4.5F, -7.0F, 0.5F, 0.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(40, 58).mirror().addBox(-6.5F, -3.0F, -2.5F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(41, 18).mirror().addBox(-6.5F, -6.0F, -3.5F, 0.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -4.0F, -0.5F));

		PartDefinition back_tentacle1 = octo_head.addOrReplaceChild("back_tentacle1", CubeListBuilder.create().texOffs(19, 53).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(60, 33).mirror().addBox(-1.0F, -4.0F, 6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, 3.0F, 4.5F));

		PartDefinition face_tentacle2 = octo_head.addOrReplaceChild("face_tentacle2", CubeListBuilder.create().texOffs(40, 47).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(58, 27).mirror().addBox(-1.0F, -4.0F, -8.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, -4.5F));

		PartDefinition face_tentacle1 = octo_head.addOrReplaceChild("face_tentacle1", CubeListBuilder.create().texOffs(19, 42).mirror().addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(58, 27).mirror().addBox(-1.0F, -4.0F, -8.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, 3.0F, -4.5F));

		PartDefinition face_tentacle3 = octo_head.addOrReplaceChild("face_tentacle3", CubeListBuilder.create().texOffs(19, 42).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(58, 27).addBox(-1.0F, -4.0F, -8.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 3.0F, -4.5F));

		PartDefinition teeth2 = octo_head.addOrReplaceChild("teeth2", CubeListBuilder.create().texOffs(0, 42).addBox(0.0F, 0.0F, -4.5F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 4.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition teeth = octo_head.addOrReplaceChild("teeth", CubeListBuilder.create().texOffs(41, 34).addBox(0.0F, 0.0F, -4.5F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 4.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition teeth3 = octo_head.addOrReplaceChild("teeth3", CubeListBuilder.create().texOffs(58, 23).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -4.5F, 0.6981F, 0.0F, 0.0F));

		PartDefinition teeth4 = octo_head.addOrReplaceChild("teeth4", CubeListBuilder.create().texOffs(58, 23).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 4.5F, -0.6981F, 0.0F, 0.0F));

		PartDefinition left_tentacle1 = octo_head.addOrReplaceChild("left_tentacle1", CubeListBuilder.create().texOffs(58, 18).addBox(0.0F, -0.95F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(53, 58).addBox(6.0F, -3.95F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 2.95F, -3.5F));

		PartDefinition right_tentacle1 = octo_head.addOrReplaceChild("right_tentacle1", CubeListBuilder.create().texOffs(58, 18).mirror().addBox(-8.0F, -0.95F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(53, 58).mirror().addBox(-8.0F, -3.95F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, 2.95F, -3.5F));

		PartDefinition left_tentacle2 = octo_head.addOrReplaceChild("left_tentacle2", CubeListBuilder.create().texOffs(58, 18).addBox(0.0F, -0.95F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(53, 58).addBox(6.0F, -3.95F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 2.95F, 0.0F));

		PartDefinition right_tentacle2 = octo_head.addOrReplaceChild("right_tentacle2", CubeListBuilder.create().texOffs(58, 18).mirror().addBox(-8.0F, -0.95F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(53, 58).mirror().addBox(-8.0F, -3.95F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, 2.95F, 0.0F));

		PartDefinition left_tentacle3 = octo_head.addOrReplaceChild("left_tentacle3", CubeListBuilder.create().texOffs(58, 18).addBox(0.0F, -0.95F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(53, 58).addBox(6.0F, -3.95F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 2.95F, 3.5F));

		PartDefinition right_tentacle3 = octo_head.addOrReplaceChild("right_tentacle3", CubeListBuilder.create().texOffs(58, 18).mirror().addBox(-8.0F, -0.95F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(53, 58).mirror().addBox(-8.0F, -3.95F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, 2.95F, 3.5F));

		PartDefinition back_tentacle2 = octo_head.addOrReplaceChild("back_tentacle2", CubeListBuilder.create().texOffs(19, 53).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(60, 33).addBox(-1.0F, -4.0F, 6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 4.5F));

		PartDefinition back_tentacle3 = octo_head.addOrReplaceChild("back_tentacle3", CubeListBuilder.create().texOffs(19, 53).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(60, 33).addBox(-1.0F, -4.0F, 6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 3.0F, 4.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Symbiocto_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		this.animateWalk(Symbiocto_Animation.WALK, limbSwing, limbSwingAmount, 2.0F, 4.0F);
		this.animate(entity.getAnimationState("idle"), Symbiocto_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attack"), Symbiocto_Animation.ATTACK, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("spit"), Symbiocto_Animation.INK, ageInTicks, 1.0F);
		if (this.riding) {
			this.octo_head.z += 1;
			this.octo_head.xRot -= (float) Math.toRadians(22.5F);
			this.right_tentacle1.zRot -= (float) Math.toRadians(52.5F);
			this.left_tentacle1.zRot += (float) Math.toRadians(52.5F);
			this.right_tentacle2.zRot -= (float) Math.toRadians(20F);
			this.left_tentacle2.zRot += (float) Math.toRadians(20F);
			this.right_tentacle3.zRot -= (float) Math.toRadians(7.5F);
			this.left_tentacle3.zRot += (float) Math.toRadians(7.5F);

			this.face_tentacle1.xRot += (float) Math.toRadians(105);
			this.face_tentacle2.xRot += (float) Math.toRadians(105);
			this.face_tentacle3.xRot += (float) Math.toRadians(105);

			this.back_tentacle1.xRot -= (float) Math.toRadians(75);
			this.back_tentacle2.xRot -= (float) Math.toRadians(75);
			this.back_tentacle3.xRot -= (float) Math.toRadians(75);
		}
	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.everything.yRot = yRot * ((float) Math.PI / 180F);
	}

	public ModelPart root() {
		return this.root;
	}

}