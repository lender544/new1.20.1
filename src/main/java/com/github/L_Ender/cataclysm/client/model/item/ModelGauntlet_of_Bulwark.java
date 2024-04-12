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

public class ModelGauntlet_of_Bulwark extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox gauntlet_fist;
	private final AdvancedModelBox void_stone_knuckle;
	private final AdvancedModelBox small_spike2;
	private final AdvancedModelBox gauntlet_arm;
	private final AdvancedModelBox gauntlet_arm2;
	private final AdvancedModelBox gauntlet_shoulder;
	private final AdvancedModelBox sholder_deco;
	private final AdvancedModelBox big_spike;
	private final AdvancedModelBox small_spike;
	private final AdvancedModelBox sholder_deco2;

	public ModelGauntlet_of_Bulwark() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 19.0F, -3.5F);


		gauntlet_fist = new AdvancedModelBox(this);
		gauntlet_fist.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(gauntlet_fist);
		gauntlet_fist.setTextureOffset(24, 30).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.25F, false);

		void_stone_knuckle = new AdvancedModelBox(this);
		void_stone_knuckle.setRotationPoint(-5.25F, -2.5F, -6.0F);
		gauntlet_fist.addChild(void_stone_knuckle);
		void_stone_knuckle.setTextureOffset(0, 0).addBox(0.0F, 0.5F, 0.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		small_spike2 = new AdvancedModelBox(this);
		small_spike2.setRotationPoint(-7.0F, -1.0F, -6.75F);
		gauntlet_fist.addChild(small_spike2);
		setRotationAngle(small_spike2, 0.0F, -1.1345F, 0.0F);
		small_spike2.setTextureOffset(46, 60).addBox(-4.0F, -1.25F, -5.5F, 7.0F, 0.0F, 4.0F, 0.0F, false);
		small_spike2.setTextureOffset(46, 60).addBox(-4.0F, 3.25F, -5.5F, 7.0F, 0.0F, 4.0F, 0.0F, false);

		gauntlet_arm = new AdvancedModelBox(this);
		gauntlet_arm.setRotationPoint(0.0F, 0.0F, 6.0F);
		root.addChild(gauntlet_arm);
		gauntlet_arm.setTextureOffset(0, 22).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		gauntlet_arm2 = new AdvancedModelBox(this);
		gauntlet_arm2.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(gauntlet_arm2);
		gauntlet_arm2.setTextureOffset(34, 16).addBox(-4.0F, -4.0F, 0.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);

		gauntlet_shoulder = new AdvancedModelBox(this);
		gauntlet_shoulder.setRotationPoint(2.0F, 0.0F, 10.0F);
		gauntlet_arm2.addChild(gauntlet_shoulder);
		setRotationAngle(gauntlet_shoulder, 0.0F, 0.3927F, 0.0F);
		gauntlet_shoulder.setTextureOffset(0, 0).addBox(-8.0F, -5.0F, -6.0F, 8.0F, 10.0F, 12.0F, 0.0F, false);

		sholder_deco = new AdvancedModelBox(this);
		sholder_deco.setRotationPoint(6.5F, -7.0F, 0.0F);
		gauntlet_shoulder.addChild(sholder_deco);
		sholder_deco.setTextureOffset(20, 46).addBox(-8.5F, 1.0F, -5.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		big_spike = new AdvancedModelBox(this);
		big_spike.setRotationPoint(-6.0F, 0.0F, 4.0F);
		gauntlet_shoulder.addChild(big_spike);
		setRotationAngle(big_spike, 0.0F, 2.3998F, 0.0F);
		big_spike.setTextureOffset(-11, 53).addBox(-3.0F, 0.0F, -10.0F, 6.0F, 0.0F, 11.0F, 0.0F, false);

		small_spike = new AdvancedModelBox(this);
		small_spike.setRotationPoint(-9.0F, 2.0F, -1.0F);
		gauntlet_shoulder.addChild(small_spike);
		small_spike.setTextureOffset(46, 60).addBox(-6.0F, -2.0F, -3.0F, 7.0F, 0.0F, 4.0F, 0.0F, false);

		sholder_deco2 = new AdvancedModelBox(this);
		sholder_deco2.setRotationPoint(0.0F, 5.0F, -3.0F);
		gauntlet_shoulder.addChild(sholder_deco2);
		sholder_deco2.setTextureOffset(20, 46).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
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
				gauntlet_fist,
				void_stone_knuckle,
				gauntlet_arm,
				gauntlet_arm2,
				gauntlet_shoulder,
				small_spike2,
				sholder_deco,
				big_spike,
				small_spike,
				sholder_deco2
		);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}