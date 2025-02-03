package com.github.L_Ender.cataclysm.client.model.block;// Made with Blockbench 4.6.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.blockentities.Mechanical_fusion_Anvil_Block_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Cursed_Tombstone_Model extends AdvancedEntityModel<Entity> {

	public final AdvancedModelBox root;
	private final AdvancedModelBox cube_r1;
	private final AdvancedModelBox cube_r2;
	private final AdvancedModelBox head;
	private final AdvancedModelBox maw;

	public Cursed_Tombstone_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		root.setTextureOffset(0, 0).addBox(-7.0F, -24.0F, -2.0F, 14.0F, 22.0F, 4.0F, 0.0F, false);
		root.setTextureOffset(36, 0).addBox(-1.5F, -22.0F, -3.0F, 3.0F, 5.0F, 1.0F, 0.0F, false);
		root.setTextureOffset(0, 26).addBox(-8.0F, -2.0F, -3.0F, 16.0F, 2.0F, 6.0F, 0.0F, false);

		cube_r1 = new AdvancedModelBox(this);
		cube_r1.setRotationPoint(-7.0F, -21.5F, 0.0F);
		root.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.2618F, 0.2182F);
		cube_r1.setTextureOffset(0, 34).addBox(-1.5F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, 0.2F, true);
		cube_r1.setTextureOffset(16, 34).addBox(-1.5F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, 0.1F, true);

		cube_r2 = new AdvancedModelBox(this);
		cube_r2.setRotationPoint(7.0F, -21.5F, 0.0F);
		root.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.2618F, -0.2182F);
		cube_r2.setTextureOffset(16, 34).addBox(-1.5F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, 0.1F, false);
		cube_r2.setTextureOffset(0, 34).addBox(-1.5F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, 0.2F, false);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, -24.0F, 0.0F);
		root.addChild(head);
		head.setTextureOffset(0, 63).addBox(-4.0F, -7.0F, -5.0F, 8.0F, 7.0F, 8.0F, -0.1F, false);
		head.setTextureOffset(0, 48).addBox(-4.0F, -7.0F, -5.0F, 8.0F, 7.0F, 8.0F, 0.0F, false);

		maw = new AdvancedModelBox(this);
		maw.setRotationPoint(0.0F, -3.5F, -2.0F);
		head.addChild(maw);
		setRotationAngle(maw, 0.0F, 0.0F, 0.0F);
		maw.setTextureOffset(43, 55).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 5.0F, 4.0F, 0.0F, false);
		maw.setTextureOffset(43, 64).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 5.0F, 4.0F, -0.1F, false);
		this.updateDefaultPose();
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root,cube_r1,cube_r2,head,maw);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();
	}

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}