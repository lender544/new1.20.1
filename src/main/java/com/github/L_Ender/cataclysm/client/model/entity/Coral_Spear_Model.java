package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.projectile.ThrownCoral_Spear_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Coral_Spear_Model extends AdvancedEntityModel<ThrownCoral_Spear_Entity> {
	private final AdvancedModelBox coral_spear;
	private final AdvancedModelBox coral;
	private final AdvancedModelBox coral2;
	private final AdvancedModelBox head;
	private final AdvancedModelBox head2;

	public Coral_Spear_Model() {
		texWidth = 32;
		texHeight = 32;

		coral_spear = new AdvancedModelBox(this);
		coral_spear.setRotationPoint(0.0F, 24.0F, 0.0F);
		coral_spear.setTextureOffset(0, 0).addBox(-0.5F, -23.0F, -0.5F, 1.0F, 23.0F, 1.0F, 0.0F, false);

		coral = new AdvancedModelBox(this);
		coral.setRotationPoint(0.0F, 0.0F, 0.0F);
		coral_spear.addChild(coral);
		setRotationAngle(coral, 0.0F, 0.7854F, 0.0F);
		coral.setTextureOffset(4, 13).addBox(0.0F, -13.0F, -6.0F, 0.0F, 5.0F, 6.0F, 0.0F, false);

		coral2 = new AdvancedModelBox(this);
		coral2.setRotationPoint(4.0F, -5.0F, 4.0F);
		coral_spear.addChild(coral2);
		setRotationAngle(coral2, 0.0F, 0.7854F, 0.0F);
		coral2.setTextureOffset(4, 8).addBox(0.0F, -13.0F, -6.0F, 0.0F, 5.0F, 6.0F, 0.0F, false);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, -29.0F, 0.0F);
		coral_spear.addChild(head);
		setRotationAngle(head, 0.0F, 0.7854F, 0.0F);
		head.setTextureOffset(16, 10).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 10.0F, 0.0F, 0.0F, false);

		head2 = new AdvancedModelBox(this);
		head2.setRotationPoint(0.0F, -29.0F, 0.0F);
		coral_spear.addChild(head2);
		setRotationAngle(head2, 0.0F, -0.7854F, 0.0F);
		head2.setTextureOffset(16, 0).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 10.0F, 0.0F, 0.0F, false);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(coral_spear);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(coral_spear, head,head2,coral,coral2);
	}

	@Override
	public void setupAnim(ThrownCoral_Spear_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){

	}


	public void setRotationAngle(AdvancedModelBox modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}