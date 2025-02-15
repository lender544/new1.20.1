package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Netherite_Ministrosity_Animation;
import com.github.L_Ender.cataclysm.client.animation.Netherite_Monstrosity_Animation;
import com.github.L_Ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class Netherite_Ministrosity_Model extends HierarchicalModel<Netherite_Ministrosity_Entity> {

	private final ModelPart root;
	private final ModelPart roots;
	private final ModelPart mid_root;
	private final ModelPart legs;
	private final ModelPart body;
	private final ModelPart jaw;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public Netherite_Ministrosity_Model(ModelPart root) {
		this.root = root;
		this.roots = this.root.getChild("roots");
		this.mid_root = this.roots.getChild("mid_root");
		this.legs = this.mid_root.getChild("legs");
		this.body = this.legs.getChild("body");
		this.jaw = this.body.getChild("jaw");
		this.right_arm = this.body.getChild("right_arm");
		this.left_arm = this.body.getChild("left_arm");
		this.right_leg = this.legs.getChild("right_leg");
		this.left_leg = this.legs.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition roots = partdefinition.addOrReplaceChild("roots", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition mid_root = roots.addOrReplaceChild("mid_root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs = mid_root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition body = legs.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -5.0F, -3.5F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(1, 28).addBox(-3.5F, -6.0F, -3.5F, 7.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jaw = body.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 14).addBox(-3.5F, -6.0F, -7.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(44, 16).addBox(-1.0F, -3.0F, -7.1F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(30, 10).addBox(-6.5F, -6.0F, -3.5F, 13.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(29, 0).addBox(-3.5F, -1.0F, -7.0F, 7.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 3.5F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(29, 16).addBox(-4.5F, -1.0F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 34).addBox(-5.5F, -1.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(29, 25).addBox(-0.5F, -1.0F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(41, 34).addBox(4.5F, -1.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 36).addBox(-1.475F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(15, 37).addBox(-1.525F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Netherite_Ministrosity_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		this.animate(entity.getAnimationState("idle"), Netherite_Ministrosity_Animation.IDLE, ageInTicks, 1.0F);
		this.animateWalk(Netherite_Ministrosity_Animation.WALK, limbSwing, limbSwingAmount, 2.0F, 2.0F);
		this.animate(entity.getAnimationState("sleep"), Netherite_Ministrosity_Animation.SLEEP, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("operation"), Netherite_Ministrosity_Animation.OPERATION, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("chest_open"), Netherite_Ministrosity_Animation.CHEST_OPEN, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("chest_loop"), Netherite_Ministrosity_Animation.CHEST_LOOP, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("chest_close"), Netherite_Ministrosity_Animation.CHEST_CLOSE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("sit_start"), Netherite_Ministrosity_Animation.SIT, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("sit_end"), Netherite_Ministrosity_Animation.SIT_END, ageInTicks, 1.0F);
	}


	private void animateHeadLookTarget(float yRot, float xRot) {
		//this.mid_root.xRot = xRot * ((float) Math.PI / 180F);
		this.roots.yRot += yRot * ((float) Math.PI / 180F);
	}


	public ModelPart root() {
		return this.root;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}