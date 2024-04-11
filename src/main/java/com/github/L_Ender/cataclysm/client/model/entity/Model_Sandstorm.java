package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelPart;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Model_Sandstorm extends AdvancedEntityModel<Sandstorm_Entity> {
	private final AdvancedModelPart root;
	private final AdvancedModelPart storm;
	private final AdvancedModelPart storm2;
	private final AdvancedModelPart storm3;
	private final AdvancedModelPart storm4;

	public Model_Sandstorm() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelPart(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		storm = new AdvancedModelPart(this);
		storm.setRotationPoint(0.0F, -4.0F, 0.0F);
		root.addChild(storm);
		storm.setTextureOffset(65, 72).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		storm2 = new AdvancedModelPart(this);
		storm2.setRotationPoint(0.0F, -9.0F, 0.0F);
		storm.addChild(storm2);
		storm2.setTextureOffset(0, 72).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 8.0F, 16.0F, 0.0F, false);

		storm3 = new AdvancedModelPart(this);
		storm3.setRotationPoint(0.0F, -9.0F, 0.0F);
		storm2.addChild(storm3);
		storm3.setTextureOffset(0, 39).addBox(-12.0F, -4.0F, -12.0F, 24.0F, 8.0F, 24.0F, 0.0F, false);

		storm4 = new AdvancedModelPart(this);
		storm4.setRotationPoint(0.0F, -9.0F, 0.0F);
		storm3.addChild(storm4);
		storm4.setTextureOffset(0, 0).addBox(-15.0F, -4.0F, -15.0F, 30.0F, 8.0F, 30.0F, 0.0F, false);
		this.updateDefaultPose();
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelPart> getAllParts() {
		return ImmutableList.of(root, storm,storm2,storm3,storm4);
	}

	@Override
	public void setupAnim(Sandstorm_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.resetToDefaultPose();
		AdvancedModelPart[] stormBoxes = new AdvancedModelPart[]{storm, storm2, storm3, storm4};
		float walkSpeed = 0.5F;
		float walkDegree = 1F;
		this.chainFlap(stormBoxes, walkSpeed, walkDegree * 0.1F, -2, ageInTicks, 1);
		storm.rotateAngleY -= ageInTicks * 1F;
		storm2.rotateAngleY -= storm.rotateAngleY + ageInTicks * 0.5F;
		storm3.rotateAngleY -= storm.rotateAngleY + storm2.rotateAngleY + ageInTicks * 0.3F;
		storm4.rotateAngleY -= storm.rotateAngleY + storm2.rotateAngleY + storm3.rotateAngleY + ageInTicks * 0.6F;
	}


	public void setRotationAngle(AdvancedModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}