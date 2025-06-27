package com.github.L_Ender.cataclysm.client.model.item;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.entity.Entity;

public class Tidal_Claws_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox handguard;
	private final AdvancedModelBox jaw;
	private final AdvancedModelBox right_jaw;
	private final AdvancedModelBox left_jaw;
	private final AdvancedModelBox upper_fin;
	private final AdvancedModelBox lower_fin;;

	public Tidal_Claws_Model() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 21.0F, 0.0F);
		root.setTextureOffset(0, 9).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 3.0F, 0.01F, false);

		handguard = new AdvancedModelBox(this);
		handguard.setRotationPoint(-3.0F, 0.0F, 1.5F);
		root.addChild(handguard);
		setRotationAngle(handguard, 0.0F, -0.1745F, 0.0F);
		handguard.setTextureOffset(13, 13).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

		jaw = new AdvancedModelBox(this);
		jaw.setRotationPoint(0.0F, 3.0F, 0.0F);
		root.addChild(jaw);
		jaw.setTextureOffset(23, 0).addBox(-2.0F, -5.5F, -2.0F, 4.0F, 0.0F, 2.0F, 0.0F, false);
		jaw.setTextureOffset(23, 0).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 0.0F, 2.0F, 0.0F, false);

		right_jaw = new AdvancedModelBox(this);
		right_jaw.setRotationPoint(-1.5F, -3.0F, 0.0F);
		jaw.addChild(right_jaw);
		setRotationAngle(right_jaw, 0.0F, 0.2618F, 0.0F);
		right_jaw.setTextureOffset(11, 24).addBox(-2.0F, -3.0F, -3.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);
		right_jaw.setTextureOffset(30, 19).addBox(-2.0F, -2.0F, -4.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		right_jaw.setTextureOffset(24, 9).addBox(0.0F, -3.0F, -3.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);
		right_jaw.setTextureOffset(0, 29).addBox(0.0F, -2.0F, -4.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		left_jaw = new AdvancedModelBox(this);
		left_jaw.setRotationPoint(1.95F, -3.0F, 0.4F);
		jaw.addChild(left_jaw);
		setRotationAngle(left_jaw, 0.0F, -0.3491F, 0.0F);
		left_jaw.setTextureOffset(22, 24).addBox(0.0F, -3.0F, -3.0F, 1.0F, 6.0F, 3.0F, 0.0F, false);
		left_jaw.setTextureOffset(31, 3).addBox(0.0F, -2.0F, -4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		left_jaw.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -4.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		left_jaw.setTextureOffset(0, 19).addBox(-2.0F, -3.0F, -3.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);

		upper_fin = new AdvancedModelBox(this);
		upper_fin.setRotationPoint(0.0F, -3.0F, 0.0F);
		root.addChild(upper_fin);
		setRotationAngle(upper_fin, 0.48F, -0.3054F, 0.0F);
		upper_fin.setTextureOffset(0, 0).addBox(-5.0F, 0.0F, 0.0F, 7.0F, 0.0F, 8.0F, 0.0F, false);

		lower_fin = new AdvancedModelBox(this);
		lower_fin.setRotationPoint(0.0F, 4.0F, 0.0F);
		root.addChild(lower_fin);
		setRotationAngle(lower_fin, -0.48F, -0.3054F, 0.0F);
		lower_fin.setTextureOffset(0, 0).addBox(-5.0F, -1.0F, 0.0F, 7.0F, 0.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		root.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				handguard,
				jaw,
				right_jaw,
				left_jaw,
				upper_fin,
				lower_fin
		);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}