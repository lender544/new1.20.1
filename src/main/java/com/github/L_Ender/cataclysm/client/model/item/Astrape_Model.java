package com.github.L_Ender.cataclysm.client.model.item;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Astrape_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;

	public Astrape_Model() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		root.setTextureOffset(38, 0).addBox(-1.0F, -40.0F, -1.0F, 2.0F, 40.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(56, 48).addBox(0.0F, -40.0F, 1.0F, 0.0F, 12.0F, 4.0F, 0.0F, false);
		root.setTextureOffset(46, 35).addBox(-1.0F, -43.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.2F, false);
		root.setTextureOffset(52, 23).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.2F, false);
		root.setTextureOffset(52, 26).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.2F, false);
		root.setTextureOffset(4, 54).addBox(-0.5F, -47.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		root.setTextureOffset(46, 0).addBox(-0.5F, -51.0F, -3.5F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		root.setTextureOffset(38, 42).addBox(0.0F, 0.0F, -4.5F, 0.0F, 10.0F, 9.0F, 0.0F, false);
		root.setTextureOffset(0, 0).addBox(0.0F, -70.0F, -9.5F, 0.0F, 35.0F, 19.0F, 0.0F, false);
		root.setTextureOffset(52, 8).addBox(-0.5F, -57.0F, -1.5F, 1.0F, 6.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(52, 16).addBox(-0.5F, -63.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		root.setTextureOffset(46, 29).addBox(-0.5F, -50.0F, 0.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		root.setTextureOffset(46, 40).addBox(-0.5F, -43.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		root.setTextureOffset(46, 19).addBox(-0.5F, -50.0F, 3.5F, 1.0F, 8.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(46, 8).addBox(-0.5F, -51.0F, -5.5F, 1.0F, 9.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(0, 54).addBox(-0.5F, -42.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
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
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}