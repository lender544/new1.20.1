package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Sandstorm_Animation;
import com.github.L_Ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Sandstorm_Model extends AdvancedEntityModel<Sandstorm_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox storm;
	private final AdvancedModelBox storm2;
	private final AdvancedModelBox storm3;
	private final AdvancedModelBox storm4;

	public Sandstorm_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this,"root");
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		storm = new AdvancedModelBox(this,"storm");
		storm.setRotationPoint(0.0F, -4.0F, 0.0F);
		root.addChild(storm);
		storm.setTextureOffset(65, 72).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		storm2 = new AdvancedModelBox(this,"storm2");
		storm2.setRotationPoint(0.0F, -9.0F, 0.0F);
		storm.addChild(storm2);
		storm2.setTextureOffset(0, 72).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 8.0F, 16.0F, 0.0F, false);

		storm3 = new AdvancedModelBox(this,"storm3");
		storm3.setRotationPoint(0.0F, -9.0F, 0.0F);
		storm2.addChild(storm3);
		storm3.setTextureOffset(0, 39).addBox(-12.0F, -4.0F, -12.0F, 24.0F, 8.0F, 24.0F, 0.0F, false);

		storm4 = new AdvancedModelBox(this,"storm4");
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
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, storm,storm2,storm3,storm4);
	}

	@Override
	public void setupAnim(Sandstorm_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.resetToDefaultPose();
		AdvancedModelBox[] stormBoxes = new AdvancedModelBox[]{storm, storm2, storm3, storm4};
		float walkSpeed = 0.5F;
		float walkDegree = 1F;
		this.chainFlap(stormBoxes, walkSpeed, walkDegree * 0.1F, -2, ageInTicks, 1);
		storm.rotateAngleY -= ageInTicks * 1F;
		storm2.rotateAngleY -= storm.rotateAngleY + ageInTicks * 0.5F;
		storm3.rotateAngleY -= storm.rotateAngleY + storm2.rotateAngleY + ageInTicks * 0.3F;
		storm4.rotateAngleY -= storm.rotateAngleY + storm2.rotateAngleY + storm3.rotateAngleY + ageInTicks * 0.6F;

		this.animate(entity.getAnimationState("spawn"), Sandstorm_Animation.SPAWN, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("despawn"), Sandstorm_Animation.DESPAWN, ageInTicks, 1.0F);
	}


	public void setRotationAngle(AdvancedModelBox modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}