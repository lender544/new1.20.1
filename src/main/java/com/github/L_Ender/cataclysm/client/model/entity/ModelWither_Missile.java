package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class ModelWither_Missile extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox head;
	private final AdvancedModelBox jaw;

	public ModelWither_Missile() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, -5.0F, 0.0F);
		root.setTextureOffset(22, 24).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 6.0F, 3.0F, 0.0F, false);
		root.setTextureOffset(24, 0).addBox(-3.0F, -2.0F, 2.0F, 6.0F, 6.0F, 2.0F, 0.3F, false);
		root.setTextureOffset(0, 24).addBox(-4.0F, -3.0F, 4.0F, 8.0F, 8.0F, 3.0F, 0.0F, false);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, -0.25F, -6.25F);
		root.addChild(head);
		setRotationAngle(head, -0.2182F, 0.0F, 0.0F);
		head.setTextureOffset(36, 30).addBox(0.0F, -10.75F, -7.0F, 0.0F, 12.0F, 14.0F, 0.0F, false);
		head.setTextureOffset(0, 49).addBox(-4.0F, -4.25F, -1.0F, 8.0F, 7.0F, 8.0F, 0.25F, false);
		head.setTextureOffset(0, 0).addBox(-4.0F, -4.75F, -1.0F, 8.0F, 6.0F, 8.0F, 0.0F, false);

		jaw = new AdvancedModelBox(this);
		jaw.setRotationPoint(0.0F, 4.0F, 1.0F);
		head.addChild(jaw);
		setRotationAngle(jaw, 0.5236F, 0.0F, 0.0F);
		jaw.setTextureOffset(0, 14).addBox(-4.0F, 0.25F, -1.0F, 8.0F, 2.0F, 8.0F, 0.0F, false);

	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root,jaw,head);
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
	public void setupAnim(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.root.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.root.rotateAngleX = headPitch * ((float) Math.PI / 180F);
	}
}