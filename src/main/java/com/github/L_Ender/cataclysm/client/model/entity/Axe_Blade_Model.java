package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Axe_blade_Animation;
import com.github.L_Ender.cataclysm.entity.projectile.Axe_Blade_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Axe_Blade_Model extends AdvancedEntityModel<Axe_Blade_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox blade;
	private final AdvancedModelBox vfx;
	private final AdvancedModelBox cube_r1;
	private final AdvancedModelBox cube_r2;

	public Axe_Blade_Model() {
		texWidth = 256;
		texHeight = 256;

		root = new AdvancedModelBox(this,"root");
		root.setRotationPoint(0.0F, -1.0F, 0.0F);


		blade = new AdvancedModelBox(this,"blade");
		blade.setRotationPoint(0.0F, -16.0F, 0.0F);
		root.addChild(blade);
		blade.setTextureOffset(41, 39).addBox(-1.0F, -16.0F, -14.0F, 2.0F, 32.0F, 28.0F, 0.0F, false);

		vfx = new AdvancedModelBox(this,"vfx");
		vfx.setRotationPoint(0.0F, 0.0F, -14.0F);
		blade.addChild(vfx);


		cube_r1 = new AdvancedModelBox(this,"cube_r1");
		cube_r1.setRotationPoint(0.0F, 16.0F, 11.0F);
		vfx.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.9599F);
		cube_r1.setTextureOffset(0, 70).addBox(-1.0F, -10.0F, -11.0F, 0.0F, 10.0F, 30.0F, 0.0F, false);

		cube_r2 = new AdvancedModelBox(this,"cube_r2");
		cube_r2.setRotationPoint(0.0F, 16.0F, 11.0F);
		vfx.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.9599F);
		cube_r2.setTextureOffset(72, 70).addBox(1.0F, -10.0F, -11.0F, 0.0F, 10.0F, 30.0F, 0.0F, false);
		this.updateDefaultPose();

	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root,blade,vfx,cube_r1,cube_r2);
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
	public void setupAnim(Axe_Blade_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetToDefaultPose();
		this.root.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.root.rotateAngleX = headPitch * ((float) Math.PI / 180F);

		float randomValue = (float) (0.1f + (Math.random() * (1.0f - 0.1f)));
		this.vfx.rotationPointZ += randomValue * 2;
		this.blade.rotationPointZ += randomValue * 6;

		this.blade.setScale(1F , 1F, 1F + randomValue * 0.2F);
	//	this.animate(entityIn.getAnimationState("idle"), Axe_blade_Animation.IDLE, ageInTicks, 1.0F);
	}
}