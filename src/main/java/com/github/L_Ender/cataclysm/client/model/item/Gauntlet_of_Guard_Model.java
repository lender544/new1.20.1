package com.github.L_Ender.cataclysm.client.model.item;// Made with Blockbench 4.0.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports



import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.entity.Entity;


public class Gauntlet_of_Guard_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox gauntlet_fist;
	private final AdvancedModelBox void_stone_knuckle;
	private final AdvancedModelBox gauntlet_arm;
	private final AdvancedModelBox gauntlet_arm2;
	private final AdvancedModelBox gauntlet_shoulder;
	private final AdvancedModelBox big_void_stone;

	public Gauntlet_of_Guard_Model() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 19.0F, 0.0F);


		gauntlet_fist = new AdvancedModelBox(this);
		gauntlet_fist.setRotationPoint(0.0F, 0.0F, -3.5F);
		root.addChild(gauntlet_fist);
		gauntlet_fist.setTextureOffset(24, 30).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.25F, false);

		void_stone_knuckle = new AdvancedModelBox(this);
		void_stone_knuckle.setRotationPoint(-5.25F, -2.5F, -6.0F);
		gauntlet_fist.addChild(void_stone_knuckle);
		void_stone_knuckle.setTextureOffset(0, 0).addBox(0.0F, 0.5F, 0.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		gauntlet_arm = new AdvancedModelBox(this);
		gauntlet_arm.setRotationPoint(0.0F, 0.0F, 2.5F);
		root.addChild(gauntlet_arm);
		gauntlet_arm.setTextureOffset(0, 22).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		gauntlet_arm2 = new AdvancedModelBox(this);
		gauntlet_arm2.setRotationPoint(0.0F, 0.0F, -3.5F);
		root.addChild(gauntlet_arm2);
		gauntlet_arm2.setTextureOffset(34, 16).addBox(-4.0F, -4.0F, 0.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);

		gauntlet_shoulder = new AdvancedModelBox(this);
		gauntlet_shoulder.setRotationPoint(2.0F, 0.0F, 9.0F);
		gauntlet_arm2.addChild(gauntlet_shoulder);
		setRotationAngle(gauntlet_shoulder, 0.0F, 0.6109F, 0.0F);
		gauntlet_shoulder.setTextureOffset(0, 0).addBox(-8.0F, -5.0F, -6.0F, 8.0F, 10.0F, 12.0F, 0.0F, false);

		big_void_stone = new AdvancedModelBox(this);
		big_void_stone.setRotationPoint(-8.0F, 0.0F, -2.0F);
		gauntlet_shoulder.addChild(big_void_stone);
		setRotationAngle(big_void_stone, 0.0F, 0.6109F, 0.0F);
		big_void_stone.setTextureOffset(28, 0).addBox(-8.0F, -2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
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
				big_void_stone
				);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}