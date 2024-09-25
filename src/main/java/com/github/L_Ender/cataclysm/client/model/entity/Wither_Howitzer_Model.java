package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.projectile.Wither_Howitzer_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Wither_Howitzer_Model extends AdvancedEntityModel<Wither_Howitzer_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox warhead;

	public Wither_Howitzer_Model() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.setTextureOffset(22, 20).addBox(-3.0F, -3.0F, 2.5F, 6.0F, 6.0F, 3.0F, 0.0F, false);
		root.setTextureOffset(28, 0).addBox(-3.0F, -3.0F, 4.5F, 6.0F, 6.0F, 2.0F, 0.3F, false);
		root.setTextureOffset(0, 20).addBox(-4.0F, -4.0F, 6.5F, 8.0F, 8.0F, 3.0F, 0.0F, false);

		warhead = new AdvancedModelBox(this);
		warhead.setRotationPoint(3.0F, 4.0F, -8.5F);
		root.addChild(warhead);
		warhead.setTextureOffset(0, 0).addBox(-7.0F, -8.0F, -1.0F, 8.0F, 8.0F, 12.0F, 0.0F, false);
		warhead.setTextureOffset(0, 31).addBox(-7.0F, -8.0F, 7.75F, 8.0F, 8.0F, 3.0F, 0.5F, false);
		warhead.setTextureOffset(0, 31).addBox(-7.0F, -8.0F, 1.25F, 8.0F, 8.0F, 3.0F, 0.5F, false);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root,warhead);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

	@Override
	public void setupAnim(Wither_Howitzer_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

}