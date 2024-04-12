package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class ModelAmethyst_Cluster_Projectile extends AdvancedEntityModel<Amethyst_Cluster_Projectile_Entity> {
	private final AdvancedModelBox roots;
	private final AdvancedModelBox bone;
	private final AdvancedModelBox bone2;
	private final AdvancedModelBox bone4;
	private final AdvancedModelBox bone3;

	public ModelAmethyst_Cluster_Projectile() {
		texWidth = 32;
		texHeight = 32;

		roots = new AdvancedModelBox(this);
		roots.setRotationPoint(0.0F, 0.0F, 0.0F);
		roots.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		roots.setTextureOffset(8, 19).addBox(-2.0F, -12.0F, 0.0F, 4.0F, 10.0F, 0.0F, 0.0F, false);
		roots.setTextureOffset(18, 17).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		roots.setTextureOffset(0, 8).addBox(0.0F, -11.0F, -2.0F, 0.0F, 9.0F, 4.0F, 0.0F, false);
		roots.setTextureOffset(16, 0).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		bone = new AdvancedModelBox(this);
		bone.setRotationPoint(3.0F, 0.875F, -3.0F);
		roots.addChild(bone);
		setRotationAngle(bone, 0.3054F, -0.7418F, 0.0F);
		bone.setTextureOffset(16, 4).addBox(0.0F, -3.875F, -1.5F, 0.0F, 5.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(0, 21).addBox(-1.5F, -3.875F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, false);
		bone.setTextureOffset(20, 10).addBox(-1.0F, -1.875F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(8, 12).addBox(-1.5F, 1.125F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		bone2 = new AdvancedModelBox(this);
		bone2.setRotationPoint(3.0F, 0.875F, 3.0F);
		roots.addChild(bone2);
		setRotationAngle(bone2, -0.3054F, 0.7418F, 0.0F);
		bone2.setTextureOffset(16, 4).addBox(0.0F, -3.875F, -1.5F, 0.0F, 5.0F, 3.0F, 0.0F, false);
		bone2.setTextureOffset(0, 21).addBox(-1.5F, -3.875F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, false);
		bone2.setTextureOffset(20, 10).addBox(-1.0F, -1.875F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(8, 12).addBox(-1.5F, 1.125F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		bone4 = new AdvancedModelBox(this);
		bone4.setRotationPoint(-3.0F, 0.875F, 3.0F);
		roots.addChild(bone4);
		setRotationAngle(bone4, -0.3054F, -0.7418F, 0.0F);
		bone4.setTextureOffset(16, 4).addBox(0.0F, -3.875F, -1.5F, 0.0F, 5.0F, 3.0F, 0.0F, true);
		bone4.setTextureOffset(0, 21).addBox(-1.5F, -3.875F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, true);
		bone4.setTextureOffset(20, 10).addBox(-1.0F, -1.875F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);
		bone4.setTextureOffset(8, 12).addBox(-1.5F, 1.125F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, true);

		bone3 = new AdvancedModelBox(this);
		bone3.setRotationPoint(-3.0F, 0.875F, -3.0F);
		roots.addChild(bone3);
		setRotationAngle(bone3, 0.3054F, 0.7418F, 0.0F);
		bone3.setTextureOffset(16, 4).addBox(0.0F, -3.875F, -1.5F, 0.0F, 5.0F, 3.0F, 0.0F, true);
		bone3.setTextureOffset(0, 21).addBox(-1.5F, -3.875F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, true);
		bone3.setTextureOffset(20, 10).addBox(-1.0F, -1.875F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);
		bone3.setTextureOffset(8, 12).addBox(-1.5F, 1.125F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, true);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(roots,bone,bone2,bone3,bone4);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(roots);
	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

	@Override
	public void setupAnim(Amethyst_Cluster_Projectile_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

}