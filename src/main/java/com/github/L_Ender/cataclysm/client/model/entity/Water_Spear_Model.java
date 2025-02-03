package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.projectile.Water_Spear_Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.WitherSkullRenderer;

public class Water_Spear_Model extends HierarchicalModel<Water_Spear_Entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor

	private final ModelPart root;

	public Water_Spear_Model(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();


		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, -64).addBox(0.0F, -7.5F, -23.0F, 0.0F, 15.0F, 64.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition root_r1 = root.addOrReplaceChild("root_r1", CubeListBuilder.create().texOffs(0, -64).addBox(0.0F, -7.5F, -23.0F, 0.0F, 15.0F, 64.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Water_Spear_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	public void setupAnim( float yRot, float xRot) {
		this.root.yRot = yRot * ((float)Math.PI / 180F);
		this.root.xRot = xRot * ((float)Math.PI / 180F);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

}