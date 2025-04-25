package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Aptrgangr_Animation;
import com.github.L_Ender.cataclysm.client.animation.Elemental_Spear_Animation;
import com.github.L_Ender.cataclysm.client.animation.Sandstorm_Animation;
import com.github.L_Ender.cataclysm.entity.projectile.Elemental_Spear_Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class Elemental_Spear_Model extends HierarchicalModel<Elemental_Spear_Entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor


	private final ModelPart root;
	private final ModelPart rot;

	public Elemental_Spear_Model(ModelPart root) {
		this.root = root.getChild("root");
		this.rot = this.root.getChild("rot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition rot = root.addOrReplaceChild("rot", CubeListBuilder.create().texOffs(0, -64).addBox(0.0F, -7.5F, -23.0F, 0.0F, 15.0F, 64.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition root_r1 = rot.addOrReplaceChild("root_r1", CubeListBuilder.create().texOffs(0, -64).addBox(0.0F, -7.5F, -23.0F, 0.0F, 15.0F, 64.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


	@Override
	public void setupAnim(Elemental_Spear_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.root.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.root.xRot = headPitch * ((float)Math.PI / 180F);
		this.animate(entity.getAnimationState("idle"), Elemental_Spear_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("spawn"), Elemental_Spear_Animation.SPAWN, ageInTicks, 1.0F);

	}

	public void setupAnim( float yRot, float xRot) {
		//this.root.yRot = yRot * ((float)Math.PI / 180F);
	//	this.root.xRot = xRot * ((float)Math.PI / 180F);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

}