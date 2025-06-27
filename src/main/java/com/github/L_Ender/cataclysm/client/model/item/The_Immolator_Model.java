package com.github.L_Ender.cataclysm.client.model.item;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class The_Immolator_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox cube_r1;

	public The_Immolator_Model() {
		texWidth = 128;
		texHeight = 128;


		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		root.setTextureOffset(0, 42).addBox(-1.0F, -19.0F, -1.0F, 2.0F, 19.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(42, 42).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		root.setTextureOffset(54, 42).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 2.0F, 3.0F, -0.2F, false);
		root.setTextureOffset(42, 47).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(39, 23).addBox(-1.5F, -33.0F, -1.5F, 3.0F, 16.0F, 3.0F, 0.0F, false);
		root.setTextureOffset(0, 0).addBox(-1.5F, -20.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.3F, false);
		root.setTextureOffset(0, 5).addBox(0.0F, -20.0F, 1.8F, 0.0F, 5.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(4, 5).addBox(0.0F, -20.0F, -3.8F, 0.0F, 5.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(4, 12).addBox(-3.8F, -20.0F, 0.2F, 2.0F, 5.0F, 0.0F, 0.0F, false);
		root.setTextureOffset(0, 12).addBox(1.8F, -20.0F, 0.2F, 2.0F, 5.0F, 0.0F, 0.0F, false);
		root.setTextureOffset(0, 0).addBox(0.0F, -41.0F, -9.5F, 0.0F, 22.0F, 19.0F, 0.0F, false);
		root.setTextureOffset(39, 0).addBox(-9.5F, -41.0F, 0.0F, 19.0F, 22.0F, 0.0F, 0.0F, false);

		cube_r1 = new AdvancedModelBox(this);
		cube_r1.setRotationPoint(0.0F, 3.0F, 0.0F);
		root.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.7854F);
		cube_r1.setTextureOffset(42, 51).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		this.updateDefaultPose();
	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

	@Override
	public void setupAnim(Entity entity, float pullAmount, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();

	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root,cube_r1);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}