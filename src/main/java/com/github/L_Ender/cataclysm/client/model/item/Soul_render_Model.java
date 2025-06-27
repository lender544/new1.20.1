package com.github.L_Ender.cataclysm.client.model.item;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Soul_render_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox halberd;
	private final AdvancedModelBox halberd2;

	public Soul_render_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		halberd = new AdvancedModelBox(this);
		halberd.setRotationPoint(0.0F, -37.0F, 0.0F);
		root.addChild(halberd);
		halberd.setTextureOffset(0, 0).addBox(-0.9406F, -28.0F, -0.75F, 2.0F, 65.0F, 2.0F, 0.0F, false);
		halberd.setTextureOffset(9, 5).addBox(-0.4406F, -33.0F, -0.25F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		halberd.setTextureOffset(40, 0).addBox(0.0594F, -49.0F, -2.25F, 0.0F, 17.0F, 5.0F, 0.0F, false);
		halberd.setTextureOffset(41, 23).addBox(-1.4406F, -27.0F, -1.25F, 3.0F, 12.0F, 3.0F, 0.0F, false);
		halberd.setTextureOffset(25, 6).addBox(2.0594F, -12.5F, -0.25F, 2.0F, 0.0F, 1.0F, 0.0F, false);
		halberd.setTextureOffset(14, 11).addBox(-0.4406F, -12.5F, 2.25F, 1.0F, 0.0F, 2.0F, 0.0F, false);
		halberd.setTextureOffset(50, 35).addBox(-1.9406F, -13.0F, -1.75F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		halberd.setTextureOffset(14, 8).addBox(-0.4406F, -12.5F, -3.75F, 1.0F, 0.0F, 2.0F, 0.0F, false);
		halberd.setTextureOffset(25, 4).addBox(-4.0594F, -12.5F, -0.25F, 2.0F, 0.0F, 1.0F, 0.0F, false);
		halberd.setTextureOffset(9, 0).addBox(0.0594F, -33.0F, -16.25F, 0.0F, 25.0F, 15.0F, 0.0F, false);
		halberd.setTextureOffset(30, 31).addBox(0.0594F, -29.0F, 1.75F, 0.0F, 19.0F, 10.0F, 0.0F, false);
		halberd.setTextureOffset(9, 41).addBox(-2.4406F, -47.0F, 0.25F, 5.0F, 17.0F, 0.0F, 0.0F, false);

		halberd2 = new AdvancedModelBox(this);
		halberd2.setRotationPoint(0.0594F, -29.412F, 0.25F);
		halberd.addChild(halberd2);
		setRotationAngle(halberd2, 0.0F, -0.7854F, 0.0F);
		halberd2.setTextureOffset(25, 2).addBox(1.4937F, -0.088F, -0.5F, 2.0F, 0.0F, 1.0F, 0.0F, false);
		halberd2.setTextureOffset(9, 0).addBox(-1.5F, -0.588F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		halberd2.setTextureOffset(25, 0).addBox(-3.5063F, -0.088F, -0.5F, 2.0F, 0.0F, 1.0F, 0.0F, false);
		halberd2.setTextureOffset(14, 5).addBox(-0.5F, -0.088F, -3.4857F, 1.0F, 0.0F, 2.0F, 0.0F, false);
		halberd2.setTextureOffset(9, 12).addBox(-0.5F, -0.088F, 1.5143F, 1.0F, 0.0F, 2.0F, 0.0F, false);
		this.updateDefaultPose();
	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

	@Override
	public void setupAnim(Entity entity, float pullAmount, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();

	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, halberd, halberd2);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}