package com.github.L_Ender.cataclysm.client.model.item;// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.entity.Entity;

public class ModelBulwark_of_the_flame extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox shield;
	private final AdvancedModelBox left_side;
	private final AdvancedModelBox right_side;
	private final AdvancedModelBox handle;

	public ModelBulwark_of_the_flame() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, -0.5F);


		shield = new AdvancedModelBox(this);
		shield.setRotationPoint(0.0F, -14.0F, -2.0F);
		root.addChild(shield);
		shield.setTextureOffset(0, 0).addBox(-3.0F, -11.0F, -1.5F, 6.0F, 22.0F, 1.0F, 0.0F, false);
		shield.setTextureOffset(0, 28).addBox(-3.5F, 9.0F, -2.0F, 7.0F, 5.0F, 2.0F, 0.0F, false);
		shield.setTextureOffset(15, 19).addBox(-3.5F, -14.0F, -2.0F, 7.0F, 6.0F, 2.0F, 0.0F, false);
		shield.setTextureOffset(34, 18).addBox(-2.0F, -2.0F, -2.25F, 4.0F, 4.0F, 1.0F, 0.0F, false);

		left_side = new AdvancedModelBox(this);
		left_side.setRotationPoint(5.33F, -12.8316F, -2.1F);
		root.addChild(left_side);
		setRotationAngle(left_side, 0.0F, -0.2182F, 0.0436F);
		left_side.setTextureOffset(15, 0).addBox(-3.0F, -9.1667F, -0.5F, 5.0F, 17.0F, 1.0F, 0.0F, false);
		left_side.setTextureOffset(28, 11).addBox(-3.5F, 7.8333F, -1.0F, 6.0F, 4.0F, 2.0F, 0.0F, false);
		left_side.setTextureOffset(19, 28).addBox(-3.5F, -13.1667F, -1.0F, 6.0F, 4.0F, 2.0F, 0.0F, false);

		right_side = new AdvancedModelBox(this);
		right_side.setRotationPoint(-5.33F, -12.8316F, -2.1F);
		root.addChild(right_side);
		setRotationAngle(right_side, 0.0F, 0.2182F, -0.0436F);
		right_side.setTextureOffset(15, 0).addBox(-2.0F, -9.1667F, -0.5F, 5.0F, 17.0F, 1.0F, 0.0F, true);
		right_side.setTextureOffset(28, 11).addBox(-2.5F, 7.8333F, -1.0F, 6.0F, 4.0F, 2.0F, 0.0F, true);
		right_side.setTextureOffset(19, 28).addBox(-2.5F, -13.1667F, -1.0F, 6.0F, 4.0F, 2.0F, 0.0F, true);

		handle = new AdvancedModelBox(this);
		handle.setRotationPoint(6.0F, -8.0F, -8.0F);
		root.addChild(handle);
		handle.setTextureOffset(28, 0).addBox(-7.0F, -8.5F, 5.5F, 2.0F, 6.0F, 6.0F, 0.0F, false);
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
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				shield,
				root,
				left_side,
				right_side,
				handle

		);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}