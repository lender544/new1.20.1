package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Phantom_Halberd_Animation;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Model_Phantom_Halberd extends AdvancedEntityModel<Phantom_Halberd_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox mid_root;
	private final AdvancedModelBox halberd;
	private final AdvancedModelBox cube_r1;
	private final AdvancedModelBox halberd2;
	private final AdvancedModelBox cube_r2;
	private final AdvancedModelBox cube_r3;

	public Model_Phantom_Halberd() {
		texWidth = 256;
		texHeight = 256;

		root = new AdvancedModelBox(this,"root");
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		mid_root = new AdvancedModelBox(this,"mid_root");
		mid_root.setRotationPoint(-0.0005F, 2.3477F, -0.2083F);
		root.addChild(mid_root);


		halberd = new AdvancedModelBox(this,"halberd");
		halberd.setRotationPoint(0.0F, 0.0F, 0.0F);
		mid_root.addChild(halberd);
		setRotationAngle(halberd, -1.5708F, 0.0F, 0.0F);
		halberd.setTextureOffset(0, 0).addBox(-0.9901F, -1.2083F, -53.9583F, 2.0F, 2.0F, 65.0F, 0.0F, false);
		halberd.setTextureOffset(0, 0).addBox(-0.4901F, -0.7083F, -58.9583F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		halberd.setTextureOffset(26, 0).addBox(0.0099F, -2.7083F, -74.9583F, 0.0F, 5.0F, 17.0F, 0.0F, false);
		halberd.setTextureOffset(0, 41).addBox(-1.4901F, -1.7083F, -52.9583F, 3.0F, 3.0F, 12.0F, 0.0F, false);
		halberd.setTextureOffset(11, 7).addBox(2.0099F, -0.7083F, -38.4583F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		halberd.setTextureOffset(11, 12).addBox(-0.4901F, -4.2083F, -38.4583F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		halberd.setTextureOffset(0, 7).addBox(-1.9901F, -2.2083F, -38.9583F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		halberd.setTextureOffset(11, 9).addBox(-0.4901F, 1.7917F, -38.4583F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		halberd.setTextureOffset(11, 7).addBox(-4.1089F, -0.7083F, -38.4583F, 2.0F, 1.0F, 0.0F, 0.0F, true);
		halberd.setTextureOffset(0, 0).addBox(0.0099F, 1.2917F, -58.9583F, 0.0F, 15.0F, 25.0F, 0.0F, false);
		halberd.setTextureOffset(0, 68).addBox(0.0099F, -11.7083F, -54.9583F, 0.0F, 10.0F, 19.0F, 0.0F, false);

		cube_r1 = new AdvancedModelBox(this);
		cube_r1.setRotationPoint(0.0099F, -0.2083F, -64.4583F);
		halberd.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -1.5708F);
		cube_r1.setTextureOffset(26, 0).addBox(0.0F, -2.5F, -8.5F, 0.0F, 5.0F, 17.0F, 0.0F, false);

		halberd2 = new AdvancedModelBox(this,"halberd2");
		halberd2.setRotationPoint(-0.0139F, -0.2083F, -55.4583F);
		halberd.addChild(halberd2);
		setRotationAngle(halberd2, 0.0F, 0.0F, -0.7854F);
		halberd2.setTextureOffset(0, 0).addBox(1.5238F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		halberd2.setTextureOffset(8, 0).addBox(-1.4762F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		halberd2.setTextureOffset(0, 0).addBox(-3.595F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, true);

		cube_r2 = new AdvancedModelBox(this);
		cube_r2.setRotationPoint(0.0238F, 5.0F, 0.0F);
		halberd2.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -1.5708F);
		cube_r2.setTextureOffset(0, 2).addBox(1.5F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r3 = new AdvancedModelBox(this);
		cube_r3.setRotationPoint(0.0238F, 0.0F, 0.0F);
		halberd2.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -1.5708F);
		cube_r3.setTextureOffset(0, 0).addBox(1.5F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		this.updateDefaultPose();
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, mid_root,halberd,halberd2,cube_r1,cube_r2,cube_r3);
	}

	@Override
	public void setupAnim(Phantom_Halberd_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.resetToDefaultPose();

		root.showModel = entity.getState() != 0;

		this.animate(entity.getAnimationState("one"), Phantom_Halberd_Animation.ONE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("two"), Phantom_Halberd_Animation.TWO, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("three"), Phantom_Halberd_Animation.THREE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("four"), Phantom_Halberd_Animation.FOUR, ageInTicks, 1.0F);
	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}