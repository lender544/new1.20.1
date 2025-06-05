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
		texWidth = 32;
		texHeight = 32;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 20.0F, 0.0F);
		root.setTextureOffset(18, 11).addBox(-0.5F, -10.0F, -0.25F, 1.0F, 2.0F, 1.0F, 0.1F, false);
		root.setTextureOffset(18, 14).addBox(-0.5F, -32.0F, -0.25F, 1.0F, 2.0F, 1.0F, 0.1F, false);
		root.setTextureOffset(14, 0).addBox(-0.5F, -30.0F, -0.25F, 1.0F, 20.0F, 1.0F, 0.0F, false);
		root.setTextureOffset(18, 0).addBox(-0.5F, -38.0F, -0.25F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		root.setTextureOffset(18, 7).addBox(-0.5F, -36.0F, -1.25F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		root.setTextureOffset(18, 17).addBox(-0.5F, -34.0F, 0.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		root.setTextureOffset(0, 0).addBox(0.0F, -42.0F, -3.25F, 0.0F, 12.0F, 7.0F, 0.0F, false);
		root.setTextureOffset(0, 12).addBox(0.0F, -8.0F, -3.25F, 0.0F, 12.0F, 7.0F, 0.0F, false);
		root.setTextureOffset(24, -4).addBox(0.0F, -30.0F, 0.75F, 0.0F, 12.0F, 4.0F, 0.0F, false);

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