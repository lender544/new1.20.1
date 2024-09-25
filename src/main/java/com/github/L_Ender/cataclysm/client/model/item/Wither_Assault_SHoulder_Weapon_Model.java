package com.github.L_Ender.cataclysm.client.model.item;// Made with Blockbench 4.6.0
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.entity.Entity;

public class Wither_Assault_SHoulder_Weapon_Model extends AdvancedEntityModel<Entity> {

	private final AdvancedModelBox root;
	private final AdvancedModelBox handle2;
	private final AdvancedModelBox handle;
	private final AdvancedModelBox trigger;
	private final AdvancedModelBox cube1;
	private final AdvancedModelBox cube2;
	private final AdvancedModelBox cube3;
	private final AdvancedModelBox cube4;
	private final AdvancedModelBox cap;
	private final AdvancedModelBox cap2;
	private final AdvancedModelBox cap3;

	public Wither_Assault_SHoulder_Weapon_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 23.75F, 0.0F);
		root.setTextureOffset(0, 0).addBox(-4.0F, -16.0F, -22.0F, 8.0F, 8.0F, 39.0F, 0.0F, false);
		root.setTextureOffset(0, 31).addBox(-3.0F, -7.0F, 18.0F, 6.0F, 6.0F, 0.0F, 0.0F, false);
		root.setTextureOffset(18, 30).addBox(-3.0F, -7.0F, -21.0F, 6.0F, 6.0F, 0.0F, 0.0F, false);
		root.setTextureOffset(0, 12).addBox(-4.0F, -16.0F, -16.0F, 8.0F, 8.0F, 2.0F, 0.2F, false);
		root.setTextureOffset(0, 22).addBox(-4.0F, -16.0F, -13.0F, 8.0F, 8.0F, 1.0F, 0.2F, false);

		handle2 = new AdvancedModelBox(this);
		handle2.setRotationPoint(0.0F, 0.0F, 13.0F);
		root.addChild(handle2);
		handle2.setTextureOffset(21, 9).addBox(-1.0F, -7.0F, -29.0F, 2.0F, 7.0F, 3.0F, 0.0F, false);
		handle2.setTextureOffset(30, 30).addBox(-1.0F, -8.0F, -29.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		handle2.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -31.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);

		handle = new AdvancedModelBox(this);
		handle.setRotationPoint(0.0F, 0.0F, -7.0F);
		root.addChild(handle);
		handle.setTextureOffset(24, 0).addBox(-1.0F, -5.75F, -1.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);
		handle.setTextureOffset(27, 33).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 2.0F, 3.0F, 0.3F, false);

		trigger = new AdvancedModelBox(this);
		trigger.setRotationPoint(-0.5F, -6.75F, -1.25F);
		handle.addChild(trigger);
		setRotationAngle(trigger, -0.48F, 0.0F, 0.0F);
		trigger.setTextureOffset(31, 0).addBox(0.0F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube1 = new AdvancedModelBox(this);
		cube1.setRotationPoint(0.0F, 0.0F, -18.5F);
		root.addChild(cube1);
		cube1.setTextureOffset(28, 9).addBox(-1.0F, -17.0F, -3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		cube2 = new AdvancedModelBox(this);
		cube2.setRotationPoint(0.0F, -17.0F, -3.0F);
		cube1.addChild(cube2);
		setRotationAngle(cube2, -0.3491F, 0.0F, 0.0F);
		cube2.setTextureOffset(18, 0).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);

		cube3 = new AdvancedModelBox(this);
		cube3.setRotationPoint(0.0F, 0.0F, 13.5F);
		root.addChild(cube3);
		cube3.setTextureOffset(29, 17).addBox(-1.0F, -17.0F, 1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		cube4 = new AdvancedModelBox(this);
		cube4.setRotationPoint(0.0F, -17.0F, 3.0F);
		cube3.addChild(cube4);
		setRotationAngle(cube4, 0.3491F, 0.0F, 0.0F);
		cube4.setTextureOffset(18, 2).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);

		cap = new AdvancedModelBox(this);
		cap.setRotationPoint(0.0F, 0.0F, 3.0F);
		root.addChild(cap);
		cap.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -25.0F, 8.0F, 8.0F, 4.0F, 0.0F, false);

		cap2 = new AdvancedModelBox(this);
		cap2.setRotationPoint(0.0F, -8.0F, 17.0F);
		root.addChild(cap2);
		setRotationAngle(cap2, 3.1416F, 0.0F, 0.0F);


		cap3 = new AdvancedModelBox(this);
		cap3.setRotationPoint(0.0F, -4.0F, -1.0F);
		cap2.addChild(cap3);
		setRotationAngle(cap3, 0.0F, 0.0F, -3.1416F);
		cap3.setTextureOffset(18, 20).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F, 0.0F, false);
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
				handle,
				handle2,
				trigger,
				cube1,
				cube2,
				cube3,
				cube4,
				cap,
				cap2,
				cap3
		);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}