package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Ignited_Berserker_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Ignited_Berserker_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class Ignited_Berserker_Model<T extends Ignited_Berserker_Entity> extends HierarchicalModel<T> {

	private final ModelPart root;

	private final ModelPart everything;
	private final ModelPart mid_root;
	private final ModelPart rod;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart right_shoulder;
	private final ModelPart left_shoulder;
	private final ModelPart edges;
	private final ModelPart right_f_blade;
	private final ModelPart right_b_blade;
	private final ModelPart left_b_blade;
	private final ModelPart left_f_blade;

	public Ignited_Berserker_Model(ModelPart root) {
		this.root = root;
		this.everything = root.getChild("everything");
		this.mid_root = this.everything.getChild("mid_root");
		this.rod = this.mid_root.getChild("rod");
		this.body = this.rod.getChild("body");
		this.head = this.body.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.right_shoulder = this.body.getChild("right_shoulder");
		this.left_shoulder = this.body.getChild("left_shoulder");
		this.edges = this.body.getChild("edges");
		this.right_f_blade = this.edges.getChild("right_f_blade");
		this.right_b_blade = this.edges.getChild("right_b_blade");
		this.left_b_blade = this.edges.getChild("left_b_blade");
		this.left_f_blade = this.edges.getChild("left_f_blade");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition mid_root = everything.addOrReplaceChild("mid_root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rod = mid_root.addOrReplaceChild("rod", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, -0.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition guard1 = rod.addOrReplaceChild("guard1", CubeListBuilder.create().texOffs(13, 40).addBox(-1.5F, -9.0F, -1.5F, 3.0F, 19.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, -0.7854F, 0.0F));

		PartDefinition body = rod.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 17).addBox(-4.0F, -5.0F, -3.5F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 2.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -1.5F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(46, 47).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition right_shoulder = body.addOrReplaceChild("right_shoulder", CubeListBuilder.create().texOffs(51, 31).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -4.0F, -2.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition left_shoulder = body.addOrReplaceChild("left_shoulder", CubeListBuilder.create().texOffs(51, 24).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, -2.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition edges = body.addOrReplaceChild("edges", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, -1.5F));

		PartDefinition right_f_blade = edges.addOrReplaceChild("right_f_blade", CubeListBuilder.create().texOffs(26, 57).addBox(-0.9899F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(38, 26).addBox(-2.5F, -25.25F, -0.5F, 5.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -2.0F, -11.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition guard2 = right_f_blade.addOrReplaceChild("guard2", CubeListBuilder.create().texOffs(18, 64).addBox(-2.4F, 3.0F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 60).addBox(-3.4F, 4.0F, -0.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9899F, -4.0F, -0.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition guard3 = right_f_blade.addOrReplaceChild("guard3", CubeListBuilder.create().texOffs(60, 38).addBox(0.4F, 4.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(64, 22).addBox(0.4F, 3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(64, 63).addBox(-1.6F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition guard4 = right_f_blade.addOrReplaceChild("guard4", CubeListBuilder.create().texOffs(50, 64).addBox(-0.4F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition guard5 = right_f_blade.addOrReplaceChild("guard5", CubeListBuilder.create().texOffs(51, 16).addBox(0.4F, -1.0F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition right_b_blade = edges.addOrReplaceChild("right_b_blade", CubeListBuilder.create().texOffs(48, 55).addBox(-0.9899F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(38, 0).addBox(-2.5F, -25.25F, -0.5F, 5.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -2.0F, 11.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition guard6 = right_b_blade.addOrReplaceChild("guard6", CubeListBuilder.create().texOffs(64, 6).addBox(-2.4F, 3.0F, -1.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(57, 55).addBox(-3.4F, 4.0F, -1.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9899F, -4.0F, 0.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition guard7 = right_b_blade.addOrReplaceChild("guard7", CubeListBuilder.create().texOffs(57, 59).addBox(0.4F, 4.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(64, 14).addBox(0.4F, 3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(64, 46).addBox(-1.6F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition guard8 = right_b_blade.addOrReplaceChild("guard8", CubeListBuilder.create().texOffs(45, 64).addBox(-0.4F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition guard9 = right_b_blade.addOrReplaceChild("guard9", CubeListBuilder.create().texOffs(51, 8).addBox(0.4F, -1.0F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition left_b_blade = edges.addOrReplaceChild("left_b_blade", CubeListBuilder.create().texOffs(39, 55).addBox(-1.0101F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 34).addBox(-2.5F, -25.25F, -0.5F, 5.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -2.0F, 11.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition guard10 = left_b_blade.addOrReplaceChild("guard10", CubeListBuilder.create().texOffs(55, 63).addBox(0.4F, 3.0F, -1.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(13, 34).addBox(0.4F, 4.0F, -1.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9899F, -4.0F, 0.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition guard11 = left_b_blade.addOrReplaceChild("guard11", CubeListBuilder.create().texOffs(26, 43).addBox(-3.4F, 4.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 64).addBox(-2.4F, 3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(40, 64).addBox(-0.4F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition guard12 = left_b_blade.addOrReplaceChild("guard12", CubeListBuilder.create().texOffs(35, 64).addBox(-1.6F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition guard13 = left_b_blade.addOrReplaceChild("guard13", CubeListBuilder.create().texOffs(51, 0).addBox(-4.4F, -1.0F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition left_f_blade = edges.addOrReplaceChild("left_f_blade", CubeListBuilder.create().texOffs(51, 38).addBox(-1.0101F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(25, 17).addBox(-2.5F, -25.25F, -0.5F, 5.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -2.0F, -11.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition guard14 = left_f_blade.addOrReplaceChild("guard14", CubeListBuilder.create().texOffs(60, 42).addBox(0.4F, 3.0F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(25, 0).addBox(0.4F, 4.0F, -0.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9899F, -4.0F, -0.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition guard15 = left_f_blade.addOrReplaceChild("guard15", CubeListBuilder.create().texOffs(25, 4).addBox(-3.4F, 4.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 63).addBox(-2.4F, 3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(33, 8).addBox(-0.4F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition guard16 = left_f_blade.addOrReplaceChild("guard16", CubeListBuilder.create().texOffs(0, 0).addBox(-1.6F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition guard17 = left_f_blade.addOrReplaceChild("guard17", CubeListBuilder.create().texOffs(26, 49).addBox(-4.4F, -1.0F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateHeadLookTarget(netHeadYaw, headPitch);
		if(entity.getAttackState() == 0) {
			this.animateWalk(Ignited_Berserker_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 2.0F);
			edges.yRot -= ageInTicks * 0.1F;
		}

		this.animate(entity.getAnimationState("idle"), Ignited_Berserker_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("x_slash"), Ignited_Berserker_Animation.X_SLASH, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("mixer_start"), Ignited_Berserker_Animation.MIXER_START, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("mixer_idle"), Ignited_Berserker_Animation.MIXER_IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("mixer_finish"), Ignited_Berserker_Animation.MIXER_FINISH, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("sword_dance_left"), Ignited_Berserker_Animation.SWORD_DANCE_LEFT, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("sword_dance_right"), Ignited_Berserker_Animation.SWORD_DANCE_RIGHT, ageInTicks, 1.0F);

	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot = xRot * ((float) Math.PI / 180F);
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}

	public ModelPart root() {
		return this.root;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, alpha);
	}
}