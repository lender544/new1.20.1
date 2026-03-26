package com.github.L_Ender.cataclysm.client.model.item;// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.entity.Entity;

public class Azure_Sea_Shield_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox plate;
	private final AdvancedModelBox handle;

	public Azure_Sea_Shield_Model() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		plate = new AdvancedModelBox(this);
		plate.setRotationPoint(0.0F, -24.0F, -0.5F);
		root.addChild(plate);
		plate.setTextureOffset(0, 0).addBox(-9.0F, -9.0F, -2.0F, 18.0F, 18.0F, 2.0F, 0.0F, false);
		plate.setTextureOffset(27, 29).addBox(-13.0F, 0.0F, -1.0F, 4.0F, 6.0F, 0.0F, 0.0F, false);
		plate.setTextureOffset(27, 29).addBox(9.0F, 0.0F, -1.0F, 4.0F, 6.0F, 0.0F, 0.0F, true);

		handle = new AdvancedModelBox(this);
		handle.setRotationPoint(0.0F, -24.0F, 0.5F);
		root.addChild(handle);
		handle.setTextureOffset(27, 21).addBox(-8.0F, -2.5F, -1.5F, 4.0F, 5.0F, 2.0F, 0.0F, false);
		handle.setTextureOffset(0, 21).addBox(-1.0F, -2.5F, -1.5F, 9.0F, 5.0F, 4.0F, 0.0F, false);
	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				plate,
				handle
		);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}