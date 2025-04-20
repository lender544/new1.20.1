package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Wave_Animation;
import com.github.L_Ender.cataclysm.entity.effect.Wave_Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class Wave_Model extends HierarchicalModel<Wave_Entity> {


	private final ModelPart root;
	private final ModelPart everything;
	private final ModelPart projectile;

	public Wave_Model(ModelPart root) {
		this.root = root;
		this.everything = this.root.getChild("everything");
		this.projectile = this.everything.getChild("projectile");
	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition projectile = root.addOrReplaceChild("projectile", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -44.5F, -9.0F, 32.0F, 45.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(0, 61).addBox(-16.0F, -44.5F, 6.0F, 32.0F, 13.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 1.0F, 0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


	@Override
	public void setupAnim(Wave_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.getAnimationState("spawn"), Wave_Animation.SPAWN, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("idle"), Wave_Animation.LOOP, ageInTicks, 0.75F);
		this.animate(entity.getAnimationState("despawn"), Wave_Animation.END, ageInTicks, 1.0F);

	}

	@Override
	public ModelPart root() {
		return this.root;
	}


}