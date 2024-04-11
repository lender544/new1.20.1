package com.github.L_Ender.cataclysm.client.model.block;// Made with Blockbench 4.6.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.blockentities.TileEntityMechanical_fusion_Anvil;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelPart;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Model_Mechanical_Anvil extends AdvancedEntityModel<Entity> {

	private final AdvancedModelPart root;
	private final AdvancedModelPart gear;

	public Model_Mechanical_Anvil() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelPart(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		root.setTextureOffset(0, 23).addBox(-6.0F, -4.0F, -6.0F, 12.0F, 4.0F, 12.0F, 0.0F, false);
		root.setTextureOffset(37, 0).addBox(-4.0F, -5.0F, -5.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
		root.setTextureOffset(0, 40).addBox(-2.0F, -10.0F, -4.0F, 4.0F, 5.0F, 8.0F, 0.0F, false);
		root.setTextureOffset(0, 0).addBox(-5.0F, -16.0F, -8.0F, 10.0F, 6.0F, 16.0F, 0.0F, false);

		gear = new AdvancedModelPart(this);
		gear.setRotationPoint(5.0F, -13.0F, 0.0F);
		root.addChild(gear);
		gear.setTextureOffset(0, 0).addBox(-0.5F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		gear.setTextureOffset(0, 7).addBox(0.25F, 1.5F, -1.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		gear.setTextureOffset(0, 7).addBox(0.25F, -2.5F, -1.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		gear.setTextureOffset(0, 7).addBox(0.25F, 1.5F, 0.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		gear.setTextureOffset(0, 7).addBox(0.25F, -2.5F, 0.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		gear.setTextureOffset(0, 7).addBox(0.25F, 0.3F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		gear.setTextureOffset(0, 7).addBox(0.25F, 0.3F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		gear.setTextureOffset(0, 7).addBox(0.25F, -1.3F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		gear.setTextureOffset(0, 7).addBox(0.25F, -1.3F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		this.updateDefaultPose();
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelPart> getAllParts() {
		return ImmutableList.of(root,gear);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();
	}

	public void animate(TileEntityMechanical_fusion_Anvil beak, float partialTick) {
		this.resetToDefaultPose();
		float ageInTicks = beak.tickCount + partialTick;
		gear.rotateAngleX -= ageInTicks * 0.025F;

	}

	public void setRotationAngle(AdvancedModelPart AdvancedModelPart, float x, float y, float z) {
		AdvancedModelPart.rotateAngleX = x;
		AdvancedModelPart.rotateAngleY = y;
		AdvancedModelPart.rotateAngleZ = z;
	}
}