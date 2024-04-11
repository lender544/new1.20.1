package com.github.L_Ender.cataclysm.client.model.item;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelPart;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.entity.Entity;

public class ModelVoid_Forge extends AdvancedEntityModel<Entity> {
	private final AdvancedModelPart root;
	private final AdvancedModelPart handle;
	private final AdvancedModelPart voidspike;
	private final AdvancedModelPart voidspike2;
	private final AdvancedModelPart voidspike3;
	private final AdvancedModelPart voidspike4;

	public ModelVoid_Forge() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelPart(this);
		root.setRotationPoint(0.011F, 10.0F, 0.0F);
		root.setTextureOffset(0, 0).addBox(-3.011F, -13.25F, -3.5F, 6.0F, 6.0F, 8.0F, 0.0F, false);
		root.setTextureOffset(22, 24).addBox(-3.511F, -14.0F, 2.3F, 7.0F, 7.0F, 5.0F, 0.0F, false);
		root.setTextureOffset(15, 37).addBox(-2.511F, -14.0F, -8.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
		root.setTextureOffset(21, 0).addBox(-2.511F, -8.0F, -8.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
		root.setTextureOffset(0, 29).addBox(2.489F, -14.0F, -8.0F, 1.0F, 7.0F, 6.0F, 0.0F, false);
		root.setTextureOffset(0, 29).addBox(-3.511F, -14.0F, -8.0F, 1.0F, 7.0F, 6.0F, 0.0F, false);
		root.setTextureOffset(42, 20).addBox(-2.511F, -13.0F, -6.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		root.setTextureOffset(0, 15).addBox(-3.511F, -14.0F, -8.25F, 7.0F, 7.0F, 6.0F, 0.25F, false);
		root.setTextureOffset(0, 43).addBox(-2.5F, -13.0F, -5.0F, 5.0F, 5.0F, 0.0F, 0.0F, false);
		root.setTextureOffset(22, 8).addBox(-2.011F, -12.5F, 7.0F, 4.0F, 4.0F, 7.0F, 0.0F, false);

		handle = new AdvancedModelPart(this);
		handle.setRotationPoint(-18.5F, -8.0F, 7.0F);
		root.addChild(handle);
		handle.setTextureOffset(37, 0).addBox(17.989F, 0.0F, -8.0F, 1.0F, 2.0F, 2.0F, 0.25F, false);
		handle.setTextureOffset(36, 37).addBox(17.989F, 0.0F, -8.0F, 1.0F, 17.0F, 2.0F, 0.0F, false);
		handle.setTextureOffset(0, 0).addBox(17.989F, 17.25F, -8.0F, 1.0F, 4.0F, 2.0F, 0.25F, false);

		voidspike = new AdvancedModelPart(this);
		voidspike.setRotationPoint(-0.286F, -14.9249F, 7.1558F);
		root.addChild(voidspike);
		setRotationAngle(voidspike, 0.7854F, 0.0F, 0.0F);
		voidspike.setTextureOffset(38, 1).addBox(-1.0F, -0.5F, -1.75F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		voidspike.setTextureOffset(9, 29).addBox(-1.75F, -1.5F, -2.75F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		voidspike2 = new AdvancedModelPart(this);
		voidspike2.setRotationPoint(-0.186F, -6.0751F, 7.1558F);
		root.addChild(voidspike2);
		setRotationAngle(voidspike2, -0.829F, 0.0F, 0.0F);
		voidspike2.setTextureOffset(38, 1).addBox(-1.0F, -1.5F, -1.75F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		voidspike2.setTextureOffset(9, 29).addBox(-1.75F, -0.5F, -2.75F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		voidspike3 = new AdvancedModelPart(this);
		voidspike3.setRotationPoint(3.739F, -10.0751F, 7.1558F);
		root.addChild(voidspike3);
		setRotationAngle(voidspike3, 0.0F, 0.7854F, 0.0F);
		voidspike3.setTextureOffset(38, 1).addBox(-0.5F, -1.5F, -1.75F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		voidspike3.setTextureOffset(9, 29).addBox(-0.75F, -0.5F, -2.75F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		voidspike4 = new AdvancedModelPart(this);
		voidspike4.setRotationPoint(-3.75F, -10.0751F, 7.1558F);
		root.addChild(voidspike4);
		setRotationAngle(voidspike4, 0.0F, -0.829F, 0.0F);
		voidspike4.setTextureOffset(38, 1).addBox(-1.5F, -1.5F, -1.75F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		voidspike4.setTextureOffset(9, 29).addBox(-2.25F, -0.5F, -2.75F, 3.0F, 2.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		root.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(AdvancedModelPart AdvancedModelPart, float x, float y, float z) {
		AdvancedModelPart.rotateAngleX = x;
		AdvancedModelPart.rotateAngleY = y;
		AdvancedModelPart.rotateAngleZ = z;
	}

	@Override
	public Iterable<AdvancedModelPart> getAllParts() {
		return ImmutableList.of(
				root,
				handle,
				voidspike,
				voidspike2,
				voidspike3,
				voidspike4
		);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}