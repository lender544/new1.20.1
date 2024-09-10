package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.projectile.ThrownCoral_Spear_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class ModelCoral_Bardiche extends AdvancedEntityModel<ThrownCoral_Spear_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox spear_head;
	private final AdvancedModelBox blade;

	public ModelCoral_Bardiche() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		spear_head = new AdvancedModelBox(this);
		spear_head.setRotationPoint(0.0F, -19.0F, 0.0F);
		root.addChild(spear_head);
		spear_head.setTextureOffset(0, 0).addBox(-1.0F, -17.0F, -1.0F, 2.0F, 42.0F, 2.0F, 0.0F, false);
		spear_head.setTextureOffset(9, 24).addBox(-1.0F, -17.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.25F, false);
		spear_head.setTextureOffset(9, 24).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.25F, false);
		spear_head.setTextureOffset(23, 24).addBox(-1.0F, 22.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.25F, false);

		blade = new AdvancedModelBox(this);
		blade.setRotationPoint(0.0F, 0.0F, 0.0F);
		spear_head.addChild(blade);
		blade.setTextureOffset(22, 0).addBox(-5.0F, -17.0F, -0.5F, 3.0F, 12.0F, 1.0F, 0.0F, false);
		blade.setTextureOffset(9, 0).addBox(-7.0F, -23.0F, 0.0F, 6.0F, 23.0F, 0.0F, 0.0F, false);
		blade.setTextureOffset(22, 14).addBox(-2.0F, -17.0F, 0.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, spear_head,blade);
	}

	@Override
	public void setupAnim(ThrownCoral_Spear_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){

	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}