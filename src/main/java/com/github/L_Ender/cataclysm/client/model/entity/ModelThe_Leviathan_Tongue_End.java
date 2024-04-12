package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class ModelThe_Leviathan_Tongue_End extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox tongue;

	public ModelThe_Leviathan_Tongue_End() {
		texWidth = 256;
		texHeight = 256;


		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 12.0F, 0.0F);


		tongue = new AdvancedModelBox(this);
		tongue.setRotationPoint(0.0F, 70.0F, -4.2F);
		root.addChild(tongue);
		tongue.setTextureOffset(74, 93).addBox(-3.0F, -73.0F, -0.3F, 6.0F, 6.0F, 9.0F, 0.0F, false);
		tongue.setTextureOffset(190, 106).addBox(0.0F, -76.0F, 0.7F, 0.0F, 12.0F, 7.0F, 0.0F, false);
		tongue.setTextureOffset(139, 9).addBox(-6.0F, -70.0F, 0.7F, 12.0F, 0.0F, 7.0F, 0.0F, false);
		this.updateDefaultPose();
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, tongue);
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