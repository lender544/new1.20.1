package com.github.L_Ender.cataclysm.client.model.block;// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelPart;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Model_Altar_of_Void extends AdvancedEntityModel<Entity> {
	private final AdvancedModelPart root;
	private final AdvancedModelPart edge1;
	private final AdvancedModelPart edge2;
	private final AdvancedModelPart edge3;
	private final AdvancedModelPart edge4;

	public Model_Altar_of_Void() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelPart(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		root.setTextureOffset(0, 21).addBox(-7.0F, -4.0F, -7.0F, 14.0F, 4.0F, 14.0F, 0.0F, false);
		root.setTextureOffset(0, 0).addBox(-8.0F, -14.0F, -8.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
		root.setTextureOffset(0, 40).addBox(-6.0F, -10.0F, -6.0F, 12.0F, 6.0F, 12.0F, 0.0F, false);
		root.setTextureOffset(0, 67).addBox(-3.0F, -3.0F, 7.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(49, 10).addBox(-3.0F, -3.0F, -9.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(36, 66).addBox(-9.0F, -3.0F, -3.0F, 2.0F, 3.0F, 6.0F, 0.0F, false);
		root.setTextureOffset(65, 43).addBox(7.0F, -3.0F, -3.0F, 2.0F, 3.0F, 6.0F, 0.0F, false);
		root.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		edge1 = new AdvancedModelPart(this);
		edge1.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(edge1);
		edge1.setTextureOffset(65, 4).addBox(-9.0F, -12.0F, -9.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		edge1.setTextureOffset(60, 61).addBox(-9.0F, -18.0F, -9.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		edge1.setTextureOffset(49, 49).addBox(-9.0F, -16.0F, -9.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);

		edge2 = new AdvancedModelPart(this);
		edge2.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(edge2);
		edge2.setTextureOffset(60, 16).addBox(-9.0F, -12.0F, 4.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		edge2.setTextureOffset(49, 0).addBox(-9.0F, -16.0F, 4.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);
		edge2.setTextureOffset(59, 25).addBox(-9.0F, -18.0F, 4.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);

		edge3 = new AdvancedModelPart(this);
		edge3.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(edge3);
		edge3.setTextureOffset(21, 59).addBox(4.0F, -12.0F, -9.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		edge3.setTextureOffset(43, 21).addBox(4.0F, -16.0F, -9.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);
		edge3.setTextureOffset(0, 59).addBox(4.0F, -18.0F, -9.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);

		edge4 = new AdvancedModelPart(this);
		edge4.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(edge4);
		edge4.setTextureOffset(44, 58).addBox(4.0F, -12.0F, 4.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		edge4.setTextureOffset(37, 40).addBox(4.0F, -16.0F, 4.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);
		edge4.setTextureOffset(53, 35).addBox(4.0F, -18.0F, 4.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		this.updateDefaultPose();
	}

	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelPart> getAllParts() {
		return ImmutableList.of(root, edge1, edge2,edge3,edge4);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();
	}


	public void setRotationAngle(AdvancedModelPart AdvancedModelPart, float x, float y, float z) {
		AdvancedModelPart.rotateAngleX = x;
		AdvancedModelPart.rotateAngleY = y;
		AdvancedModelPart.rotateAngleZ = z;
	}
}