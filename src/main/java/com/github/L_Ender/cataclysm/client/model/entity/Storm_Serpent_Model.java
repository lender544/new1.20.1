package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Storm_Serpent_Animation;
import com.github.L_Ender.cataclysm.entity.projectile.Storm_Serpent_Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class Storm_Serpent_Model extends HierarchicalModel<Storm_Serpent_Entity> {


	private final ModelPart root;
	private final ModelPart everything;
	private final ModelPart seg6;
	private final ModelPart seg5;
	private final ModelPart seg4;
	private final ModelPart seg3;
	private final ModelPart seg2;
	private final ModelPart seg1;
	private final ModelPart head;
	private final ModelPart upper;
	private final ModelPart teeth;
	private final ModelPart lower;
	private final ModelPart teeth2;


	public Storm_Serpent_Model(ModelPart root) {
		this.root = root;
		this.everything = this.root.getChild("everything");
		this.seg6 = this.everything.getChild("seg6");
		this.seg5 = this.seg6.getChild("seg5");
		this.seg4 = this.seg5.getChild("seg4");
		this.seg3 = this.seg4.getChild("seg3");
		this.seg2 = this.seg3.getChild("seg2");
		this.seg1 = this.seg2.getChild("seg1");
		this.head = this.seg1.getChild("head");
		this.upper = this.head.getChild("upper");
		this.teeth = this.upper.getChild("teeth");
		this.lower = this.head.getChild("lower");
		this.teeth2 = this.lower.getChild("teeth2");
	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition seg6 = everything.addOrReplaceChild("seg6", CubeListBuilder.create().texOffs(46, 70).addBox(-6.0F, -24.0F, -6.0F, 12.0F, 24.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition seg5 = seg6.addOrReplaceChild("seg5", CubeListBuilder.create().texOffs(0, 70).addBox(-6.0F, -24.0F, -6.0F, 12.0F, 24.0F, 11.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition seg4 = seg5.addOrReplaceChild("seg4", CubeListBuilder.create().texOffs(46, 35).addBox(-6.0F, -24.0F, -6.0F, 12.0F, 24.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition seg3 = seg4.addOrReplaceChild("seg3", CubeListBuilder.create().texOffs(46, 0).addBox(-6.0F, -24.0F, -6.0F, 12.0F, 24.0F, 11.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition seg2 = seg3.addOrReplaceChild("seg2", CubeListBuilder.create().texOffs(0, 35).addBox(-6.0F, -24.0F, -6.0F, 12.0F, 24.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition seg1 = seg2.addOrReplaceChild("seg1", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -24.0F, -6.0F, 12.0F, 24.0F, 11.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition head = seg1.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition upper = head.addOrReplaceChild("upper", CubeListBuilder.create().texOffs(92, 0).addBox(-5.0F, -23.7383F, -0.0057F, 10.0F, 24.0F, 7.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition r_1 = upper.addOrReplaceChild("r_1", CubeListBuilder.create().texOffs(92, 31).addBox(-7.0F, 0.0F, -7.0F, 14.0F, 12.0F, 7.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(0.0F, -11.7383F, 6.9943F, 0.0873F, 0.0F, 0.0F));

		PartDefinition teeth = upper.addOrReplaceChild("teeth", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -22.7383F, -0.0057F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r1 = teeth.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(127, 0).addBox(0.0F, 0.0F, -6.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.042F, -0.0397F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r2 = teeth.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(127, -6).addBox(0.0F, 0.0F, -6.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.042F, -0.0397F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition lower = head.addOrReplaceChild("lower", CubeListBuilder.create().texOffs(92, 50).addBox(-5.0F, -20.7819F, -4.9952F, 10.0F, 21.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition teeth2 = lower.addOrReplaceChild("teeth2", CubeListBuilder.create(), PartPose.offset(0.0F, -23.7819F, 1.0048F));

		PartDefinition r_2 = teeth2.addOrReplaceChild("r_2", CubeListBuilder.create().texOffs(128, 12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition r_3 = teeth2.addOrReplaceChild("r_3", CubeListBuilder.create().texOffs(128, 7).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 4.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		return LayerDefinition.create(meshdefinition, 256, 256);

	}


	@Override
	public void setupAnim(Storm_Serpent_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		root.visible = entity.getState() != 0;
		this.animate(entity.getAnimationState("spawn"), Storm_Serpent_Animation.STORM_SERPENT, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("spawn2"), Storm_Serpent_Animation.STORM_SERPENT2, ageInTicks, 1.0F);
		this.root.yRot = netHeadYaw * ((float) Math.PI / 180F);
		this.root.xRot = headPitch * ((float) Math.PI / 180F);


	}

	@Override
	public ModelPart root() {
		return this.root;
	}


}