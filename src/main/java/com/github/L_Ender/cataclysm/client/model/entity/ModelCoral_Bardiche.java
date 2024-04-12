package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.projectile.ThrownCoral_Spear_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class ModelCoral_Bardiche extends AdvancedEntityModel<ThrownCoral_Spear_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox spear_head;
	private final AdvancedModelBox blade;

	public ModelCoral_Bardiche() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		root.setTextureOffset(34, 20).addBox(-1.0F, 5.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(14, 34).addBox(-1.0F, 5.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(14, 17).addBox(-1.5F, 4.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		root.setTextureOffset(14, 12).addBox(-1.5F, -27.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		spear_head = new AdvancedModelBox(this);
		spear_head.setRotationPoint(0.0F, -19.0F, 0.0F);
		root.addChild(spear_head);
		spear_head.setTextureOffset(9, 0).addBox(-1.0F, -17.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
		spear_head.setTextureOffset(14, 12).addBox(-1.5F, -16.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		spear_head.setTextureOffset(0, 0).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, false);

		blade = new AdvancedModelBox(this);
		blade.setRotationPoint(-12.0F, -14.0F, 0.0F);
		spear_head.addChild(blade);
		setRotationAngle(blade, 0.0F, 0.0F, 0.7854F);
		blade.setTextureOffset(32, 10).addBox(-2.75F, -14.5F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(23, 34).addBox(-3.75F, -11.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(9, 25).addBox(-1.75F, -15.5F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(24, 22).addBox(-0.75F, -14.5F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(23, 0).addBox(0.25F, -13.5F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(19, 22).addBox(1.25F, -12.5F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(14, 22).addBox(2.25F, -11.5F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(29, 22).addBox(3.25F, -9.5F, -0.5F, 1.0F, 9.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(28, 0).addBox(4.25F, -8.5F, -0.5F, 1.0F, 9.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(27, 11).addBox(5.25F, -7.5F, -0.5F, 1.0F, 9.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(18, 0).addBox(6.25F, -7.5F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(9, 12).addBox(7.25F, -8.5F, -0.5F, 1.0F, 11.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(34, 24).addBox(8.25F, -8.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(0, 33).addBox(8.25F, -4.5F, -0.5F, 1.0F, 7.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(33, 32).addBox(9.25F, -3.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(28, 33).addBox(10.25F, -4.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(33, 0).addBox(11.25F, -5.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, true);
		blade.setTextureOffset(34, 28).addBox(12.25F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		this.updateDefaultPose();
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, spear_head,blade);
	}

	@Override
	public void setupAnim(ThrownCoral_Spear_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){

	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}