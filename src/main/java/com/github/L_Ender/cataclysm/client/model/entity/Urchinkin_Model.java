package com.github.L_Ender.cataclysm.client.model.entity;
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.github.L_Ender.cataclysm.client.animation.Draugar_Animation;
import com.github.L_Ender.cataclysm.client.animation.Hippocamtus_Animation;
import com.github.L_Ender.cataclysm.client.animation.Urchinkin_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Hippocamtus_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Urchinkin_Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class Urchinkin_Model extends HierarchicalModel<Urchinkin_Entity> {

	private final ModelPart root;
	private final ModelPart everything;
	private final ModelPart mid_root;
	private final ModelPart legs;
	private final ModelPart body;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public Urchinkin_Model(ModelPart root) {
		this.root = root;
		this.everything = this.root.getChild("everything");
		this.mid_root = this.everything.getChild("mid_root");
		this.legs = this.mid_root.getChild("legs");
		this.body = this.legs.getChild("body");
		this.right_arm = this.body.getChild("right_arm");
		this.left_arm = this.body.getChild("left_arm");
		this.right_leg = this.legs.getChild("right_leg");
		this.left_leg = this.legs.getChild("left_leg");

	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition mid_root = everything.addOrReplaceChild("mid_root", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition legs = mid_root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition body = legs.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -7.0F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(18, 20).addBox(-8.5F, -12.0F, 0.0F, 17.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 20).mirror().addBox(-8.5F, -7.0F, 0.0F, 17.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(18, 20).addBox(-8.5F, -7.0F, 0.0F, 17.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 15).addBox(-4.2668F, -1.1426F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4F, -3.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(15, 15).addBox(-0.7332F, -1.1426F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, -3.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 20).addBox(-0.975F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(9, 20).addBox(-1.025F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		return LayerDefinition.create(meshdefinition, 64, 64);

	}

	@Override
	public void setupAnim(Urchinkin_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateHeadLookTarget(netHeadYaw, headPitch);

		this.animateWalk(Urchinkin_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 4.0F);
		this.animate(entity.getAnimationState("idle"), Urchinkin_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("roll"), Urchinkin_Animation.ROLL, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attack"), Urchinkin_Animation.ATTACK, ageInTicks, 1.0F);
	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.body.xRot += xRot * ((float) Math.PI / 180F);
		this.everything.yRot = yRot * ((float) Math.PI / 180F);

	}

	public ModelPart root() {
		return this.root;
	}

}