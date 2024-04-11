package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Coralssus_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Coralssus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class ModelCoralssus<T extends Coralssus_Entity> extends HierarchicalModel<T> {

	private final ModelPart root;

	private final ModelPart everything;
	private final ModelPart body;
	private final ModelPart chest;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart eye;
	private final ModelPart right_arm_joint;
	private final ModelPart right_arm;
	private final ModelPart right_arm2;
	private final ModelPart left_arm_joint;
	private final ModelPart left_arm;
	private final ModelPart left_arm2;
	private final ModelPart left_arm_coral;
	private final ModelPart coral;
	private final ModelPart coral2;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public ModelCoralssus(ModelPart root) {
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = this.everything.getChild("body");
		this.chest = this.body.getChild("chest");
		this.neck = this.chest.getChild("neck");
		this.head = this.neck.getChild("head");
		this.eye = this.head.getChild("eye");
		this.right_arm_joint = this.chest.getChild("right_arm_joint");
		this.right_arm = this.right_arm_joint.getChild("right_arm");
		this.right_arm2 = this.right_arm.getChild("right_arm2");
		this.left_arm_joint = this.chest.getChild("left_arm_joint");
		this.left_arm = this.left_arm_joint.getChild("left_arm");
		this.left_arm2 = this.left_arm.getChild("left_arm2");
		this.left_arm_coral = this.left_arm.getChild("left_arm_coral");

		this.coral = this.chest.getChild("coral");
		this.coral2 = this.chest.getChild("coral2");

		this.right_leg = this.everything.getChild("right_leg");
		this.left_leg = this.everything.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(72, 0).addBox(-7.0F, -5.0F, -4.0F, 14.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -19.9814F, -8.9516F, 28.0F, 20.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(108, 3).addBox(-11.0F, -17.9814F, -10.9516F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(108, 3).addBox(-12.0F, -12.9814F, -10.5516F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, 16).addBox(-7.0F, -13.9814F, -9.8516F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(116, 8).addBox(-11.0F, -17.9814F, -10.9516F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -3.0186F, -0.0484F, 0.829F, 0.0F, 0.0F));

		PartDefinition cube_1 = chest.addOrReplaceChild("cube_1", CubeListBuilder.create().texOffs(37, 115).addBox(-8.0F, -6.0F, -8.0F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -16.9814F, 16.0484F, -0.7777F, 0.1231F, 0.124F));

		PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -19.8814F, -3.3516F, -0.829F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(78, 52).addBox(-5.0F, -5.0F, -8.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(88, 20).addBox(5.0F, -4.0F, -7.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(88, 16).addBox(5.0F, 0.0F, -7.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(98, 20).addBox(5.0F, -4.0F, -7.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.2F))
				.texOffs(100, 74).addBox(-4.0F, -11.0F, -6.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(110, 84).addBox(1.0F, -7.0F, -7.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(96, 114).addBox(-5.0F, 5.0F, -8.0F, 10.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_2 = head.addOrReplaceChild("cube_2", CubeListBuilder.create().texOffs(116, 78).addBox(-0.5F, -3.0F, 0.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -14.0F, -4.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_3 = head.addOrReplaceChild("cube_3", CubeListBuilder.create().texOffs(120, 78).addBox(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -8.5F, -5.5F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_4 = head.addOrReplaceChild("cube_4", CubeListBuilder.create().texOffs(0, 112).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -5.0F, -3.0F, -0.3927F, 0.6545F, 0.0F));

		PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(110, 99).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -0.5F, -8.1F));

		PartDefinition right_arm_joint = chest.addOrReplaceChild("right_arm_joint", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.3F, -11.7814F, -1.9516F, -0.829F, 0.0F, 0.0F));

		PartDefinition right_arm = right_arm_joint.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(74, 74).addBox(-8.0F, -3.0F, -5.0F, 8.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_5 = right_arm.addOrReplaceChild("cube_5", CubeListBuilder.create().texOffs(36, 84).addBox(-3.0F, -2.0F, -5.5F, 8.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9021F, 3.8612F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition cube_6 = right_arm.addOrReplaceChild("cube_6", CubeListBuilder.create().texOffs(0, 62).addBox(-5.0F, -6.0F, -6.0F, 10.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition right_arm2 = right_arm.addOrReplaceChild("right_arm2", CubeListBuilder.create().texOffs(0, 36).addBox(-5.0F, 0.0F, -6.0F, 10.0F, 14.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(76, 114).mirror().addBox(-15.0F, -4.0F, 0.0F, 10.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 11.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition left_arm_joint = chest.addOrReplaceChild("left_arm_joint", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.3F, -11.7814F, -1.9516F, -0.829F, 0.0F, 0.0F));

		PartDefinition left_arm = left_arm_joint.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 82).addBox(0.0F, -3.0F, -5.0F, 8.0F, 16.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(37, 103).addBox(2.0F, 1.0F, -7.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(37, 103).addBox(4.0F, 5.0F, -9.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.6F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_7 = left_arm.addOrReplaceChild("cube_7", CubeListBuilder.create().texOffs(0, 112).addBox(-12.7F, -20.8F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4663F, 5.5491F, -0.0767F, 0.0F, 0.0F, 0.9599F));

		PartDefinition left_arm_coral = left_arm.addOrReplaceChild("left_arm_coral", CubeListBuilder.create(), PartPose.offset(1.0F, 12.8F, 20.0F));

		PartDefinition left_arm2 = left_arm.addOrReplaceChild("left_arm2", CubeListBuilder.create().texOffs(44, 36).addBox(-5.0F, 0.0F, -6.0F, 10.0F, 14.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(76, 114).addBox(5.0F, -4.0F, 0.0F, 10.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 11.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition coral = chest.addOrReplaceChild("coral", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.9F, -19.0F, 4.7F, -0.9579F, -0.3942F, 0.0159F));

		PartDefinition cube_8 = coral.addOrReplaceChild("cube_8", CubeListBuilder.create().texOffs(0, 112).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3459F, 0.0319F, 0.0872F, -0.0038F, 0.0435F));

		PartDefinition coral2 = chest.addOrReplaceChild("coral2", CubeListBuilder.create().texOffs(-16, 112).addBox(-7.9236F, 0.0929F, 0.3748F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -7.3F, 7.0F, 0.6262F, -0.0765F, -0.3687F));

		PartDefinition right_leg = everything.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(44, 62).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(60, 100).mirror().addBox(-7.0F, 9.0F, -7.0F, 14.0F, 0.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -9.0F, 0.0F));

		PartDefinition left_leg = everything.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(78, 26).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(60, 100).addBox(-7.0F, 9.0F, -7.0F, 14.0F, 0.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -9.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.root().getAllParts().forEach(ModelPart::resetPose);

		if(entity.getAttackState() != 6 && entity.getAttackState() != 2  && entity.getAttackState() != 7) {
			this.animateWalk(Coralssus_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 2.0F);
		}
		this.animate(entity.getAnimationState("idle"), Coralssus_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("death"), Coralssus_Animation.DEATH, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("angry"), Coralssus_Animation.ANGRY, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("nanta"), Coralssus_Animation.NANTA, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("right_fist"), Coralssus_Animation.RIGHT_FIST, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("left_fist"), Coralssus_Animation.LEFT_FIST, ageInTicks, 1.0F);

		this.animate(entity.getAnimationState("jumping_prepare"), Coralssus_Animation.JUMPING_READY, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("jumping"), Coralssus_Animation.JUMPING_LOOP, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("jumping_end"), Coralssus_Animation.JUMPING_FISH, ageInTicks, 1.0F);

		this.animateHeadLookTarget(netHeadYaw, headPitch);
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