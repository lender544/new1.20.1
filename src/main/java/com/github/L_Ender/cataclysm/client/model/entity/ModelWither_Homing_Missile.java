package com.github.L_Ender.cataclysm.client.model.entity;


import com.github.L_Ender.cataclysm.entity.projectile.Wither_Homing_Missile_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelPart;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class ModelWither_Homing_Missile extends AdvancedEntityModel<Wither_Homing_Missile_Entity> {
	private final AdvancedModelPart root;

	public ModelWither_Homing_Missile() {
		texWidth = 32;
		texHeight = 32;

		root = new AdvancedModelPart(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.setRotationPoint(0.0F, -2.0F, 0.0F);
		root.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -4.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		root.setTextureOffset(0, 2).addBox(0.0F, -3.0F, 0.5F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		root.setTextureOffset(0, 0).addBox(0.0F, 1.0F, 0.5F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		root.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 1.0F, 0.1F, false);
		root.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, 3.5F, 2.0F, 2.0F, 1.0F, 0.1F, false);
	}


	@Override
	public Iterable<AdvancedModelPart> getAllParts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}


	public void setRotationAngle(AdvancedModelPart AdvancedModelPart, float x, float y, float z) {
		AdvancedModelPart.rotateAngleX = x;
		AdvancedModelPart.rotateAngleY = y;
		AdvancedModelPart.rotateAngleZ = z;
	}

	@Override
	public void setupAnim(Wither_Homing_Missile_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.root.rotateAngleX = headPitch * ((float) Math.PI / 180F);
	}
}