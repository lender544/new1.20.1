package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Tidal_Tentacle_Claws_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox claw1;
	private final AdvancedModelBox claw2;
	private final AdvancedModelBox claw3;
	private final AdvancedModelBox claw4;

	public Tidal_Tentacle_Claws_Model() {
		texWidth = 32;
		texHeight = 32;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 11.0F, 0.0F);


		claw1 = new AdvancedModelBox(this);
		claw1.setRotationPoint(0.0F, 0.0F, 0.7F);
		root.addChild(claw1);
		setRotationAngle(claw1, 0.48F, 0.0F, 0.0F);
		claw1.setTextureOffset(9, 10).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		claw2 = new AdvancedModelBox(this);
		claw2.setRotationPoint(0.0F, 2.0F, 0.7F);
		root.addChild(claw2);
		setRotationAngle(claw2, -0.48F, 0.0F, 0.0F);
		claw2.setTextureOffset(0, 10).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		claw3 = new AdvancedModelBox(this);
		claw3.setRotationPoint(1.0F, 1.0F, 0.7F);
		root.addChild(claw3);
		setRotationAngle(claw3, 0.0F, 0.48F, 0.0F);
		claw3.setTextureOffset(0, 5).addBox(0.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		claw4 = new AdvancedModelBox(this);
		claw4.setRotationPoint(-1.0F, 1.0F, 0.7F);
		root.addChild(claw4);
		setRotationAngle(claw4, 0.0F, -0.48F, 0.0F);
		claw4.setTextureOffset(0, 0).addBox(-6.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);
		this.updateDefaultPose();
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, claw1, claw2, claw3,claw4);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.resetToDefaultPose();
	}

	public void setAttributes(float rotX, float rotY){
		this.resetToDefaultPose();
		this.resetToDefaultPose();
		this.root.rotateAngleX = (float)Math.toRadians(rotX);
		this.root.rotateAngleY = (float)Math.toRadians(rotY);
	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

}