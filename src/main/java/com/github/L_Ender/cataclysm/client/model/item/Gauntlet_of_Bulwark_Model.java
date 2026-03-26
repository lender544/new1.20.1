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

public class Gauntlet_of_Bulwark_Model extends AdvancedEntityModel<Entity> {

	private final AdvancedModelBox root;
	private final AdvancedModelBox gauntlet_fist;
	private final AdvancedModelBox fist_guard;
	private final AdvancedModelBox void_stone_knuckle;
	private final AdvancedModelBox spike;
	private final AdvancedModelBox void_spike;
	private final AdvancedModelBox void_spike4;
	private final AdvancedModelBox void_spike2;
	private final AdvancedModelBox void_spike3;
	private final AdvancedModelBox thumb;
	private final AdvancedModelBox gauntlet_arm;
	private final AdvancedModelBox gauntlet_arm2;
	private final AdvancedModelBox gauntlet_shoulder;
	private final AdvancedModelBox big_void_stone;
	private final AdvancedModelBox flame_spike;
	private final AdvancedModelBox cube_r1;
	private final AdvancedModelBox flame_spike2;
	private final AdvancedModelBox cube_r2;
	private final AdvancedModelBox arm_pad;

	public Gauntlet_of_Bulwark_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 19.0F, 0.0F);


		gauntlet_fist = new AdvancedModelBox(this);
		gauntlet_fist.setRotationPoint(0.0F, 0.0F, -3.5F);
		root.addChild(gauntlet_fist);
		gauntlet_fist.setTextureOffset(40, 0).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.25F, false);

		fist_guard = new AdvancedModelBox(this);
		fist_guard.setRotationPoint(-2.0F, 0.5F, -6.5F);
		gauntlet_fist.addChild(fist_guard);
		setRotationAngle(fist_guard, 0.0F, -0.9163F, 0.0F);
		fist_guard.setTextureOffset(81, 0).addBox(-4.0F, -6.0F, -4.0F, 5.0F, 11.0F, 7.0F, 0.0F, false);
		fist_guard.setTextureOffset(82, 18).addBox(-4.0F, -6.0F, -4.5F, 5.0F, 11.0F, 7.0F, 0.3F, false);

		void_stone_knuckle = new AdvancedModelBox(this);
		void_stone_knuckle.setRotationPoint(-5.25F, -2.5F, -6.0F);
		gauntlet_fist.addChild(void_stone_knuckle);
		void_stone_knuckle.setTextureOffset(56, 56).addBox(0.0F, 0.5F, 0.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		spike = new AdvancedModelBox(this);
		spike.setRotationPoint(-4.0F, -1.5F, -8.0F);
		gauntlet_fist.addChild(spike);


		void_spike = new AdvancedModelBox(this);
		void_spike.setRotationPoint(0.0F, 1.5F, -1.0F);
		spike.addChild(void_spike);
		setRotationAngle(void_spike, 0.0F, 0.0436F, 0.0F);
		void_spike.setTextureOffset(56, 38).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 0.0F, 8.0F, 0.0F, false);

		void_spike4 = new AdvancedModelBox(this);
		void_spike4.setRotationPoint(6.5F, -4.25F, 0.5F);
		spike.addChild(void_spike4);
		setRotationAngle(void_spike4, 0.0161F, 0.2628F, 1.5416F);
		void_spike4.setTextureOffset(56, 38).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 0.0F, 8.0F, 0.0F, false);

		void_spike2 = new AdvancedModelBox(this);
		void_spike2.setRotationPoint(0.0F, 5.0F, 0.0F);
		spike.addChild(void_spike2);
		setRotationAngle(void_spike2, 0.1162F, 0.0468F, -0.0553F);
		void_spike2.setTextureOffset(56, 38).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 0.0F, 8.0F, 0.0F, false);

		void_spike3 = new AdvancedModelBox(this);
		void_spike3.setRotationPoint(0.0F, -2.0F, 0.0F);
		spike.addChild(void_spike3);
		setRotationAngle(void_spike3, -0.1548F, 0.0493F, 0.0735F);
		void_spike3.setTextureOffset(56, 38).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 0.0F, 8.0F, 0.0F, false);

		thumb = new AdvancedModelBox(this);
		thumb.setRotationPoint(3.0F, -4.5F, -4.5F);
		gauntlet_fist.addChild(thumb);
		setRotationAngle(thumb, 0.2618F, 0.0F, 0.0F);
		thumb.setTextureOffset(101, 11).addBox(-3.0F, -3.0F, -6.0F, 5.0F, 4.0F, 7.0F, 0.0F, false);
		thumb.setTextureOffset(75, 37).addBox(-3.0F, -3.0F, -6.0F, 5.0F, 4.0F, 7.0F, 0.3F, false);

		gauntlet_arm = new AdvancedModelBox(this);
		gauntlet_arm.setRotationPoint(0.0F, 0.0F, 2.5F);
		root.addChild(gauntlet_arm);
		gauntlet_arm.setTextureOffset(0, 45).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		gauntlet_arm2 = new AdvancedModelBox(this);
		gauntlet_arm2.setRotationPoint(0.0F, 0.0F, -3.5F);
		root.addChild(gauntlet_arm2);
		gauntlet_arm2.setTextureOffset(56, 16).addBox(-4.0F, -4.0F, 0.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);
		gauntlet_arm2.setTextureOffset(110, 0).addBox(-3.5F, -4.0F, 2.0F, 6.0F, 8.0F, 3.0F, 0.3F, false);

		gauntlet_shoulder = new AdvancedModelBox(this);
		gauntlet_shoulder.setRotationPoint(2.0F, 0.0F, 9.0F);
		gauntlet_arm2.addChild(gauntlet_shoulder);
		setRotationAngle(gauntlet_shoulder, 0.0F, 0.6109F, 0.0F);
		gauntlet_shoulder.setTextureOffset(0, 0).addBox(-8.0F, -5.0F, -6.0F, 8.0F, 10.0F, 12.0F, 0.0F, false);
		gauntlet_shoulder.setTextureOffset(32, 45).addBox(-9.0F, -6.0F, -7.0F, 9.0F, 12.0F, 3.0F, 0.0F, false);
		gauntlet_shoulder.setTextureOffset(30, 22).addBox(-2.0F, -6.0F, -4.0F, 2.0F, 12.0F, 11.0F, 0.0F, false);
		gauntlet_shoulder.setTextureOffset(0, 69).addBox(-2.0F, -7.0F, -8.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		gauntlet_shoulder.setTextureOffset(0, 69).addBox(-2.0F, 6.0F, -8.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		big_void_stone = new AdvancedModelBox(this);
		big_void_stone.setRotationPoint(-8.0F, 0.0F, -2.0F);
		gauntlet_shoulder.addChild(big_void_stone);
		setRotationAngle(big_void_stone, 0.0F, 0.6109F, 0.0F);
		big_void_stone.setTextureOffset(56, 30).addBox(-8.0F, -2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
		big_void_stone.setTextureOffset(0, 61).addBox(-8.0F, -2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.3F, false);

		flame_spike = new AdvancedModelBox(this);
		flame_spike.setRotationPoint(-6.682F, 0.0F, 3.182F);
		gauntlet_shoulder.addChild(flame_spike);


		cube_r1 = new AdvancedModelBox(this);
		cube_r1.setRotationPoint(0.182F, 0.0F, -0.182F);
		flame_spike.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.7854F, 0.0F);
		cube_r1.setTextureOffset(-9, 80).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 0.0F, 9.0F, 0.0F, false);

		flame_spike2 = new AdvancedModelBox(this);
		flame_spike2.setRotationPoint(-9.682F, 0.0F, -1.818F);
		gauntlet_shoulder.addChild(flame_spike2);
		setRotationAngle(flame_spike2, 0.0F, -0.7854F, 0.0F);


		cube_r2 = new AdvancedModelBox(this);
		cube_r2.setRotationPoint(1.182F, 0.0F, -2.182F);
		flame_spike2.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.7854F, 0.0F);
		cube_r2.setTextureOffset(-9, 80).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 0.0F, 9.0F, 0.0F, false);

		arm_pad = new AdvancedModelBox(this);
		arm_pad.setRotationPoint(-4.5F, 0.0F, 0.0F);
		gauntlet_arm2.addChild(arm_pad);
		setRotationAngle(arm_pad, 0.0F, -0.48F, 0.0F);
		arm_pad.setTextureOffset(0, 22).addBox(-1.5F, -5.0F, -2.0F, 5.0F, 10.0F, 10.0F, 0.0F, false);
		arm_pad.setTextureOffset(40, 16).addBox(-3.5F, -6.0F, -3.0F, 5.0F, 4.0F, 2.0F, 0.0F, false);
		arm_pad.setTextureOffset(56, 46).addBox(-3.5F, -4.0F, -1.0F, 5.0F, 8.0F, 2.0F, 0.0F, false);
		arm_pad.setTextureOffset(40, 16).addBox(-3.5F, 2.0F, -3.0F, 5.0F, 4.0F, 2.0F, 0.0F, false);
		arm_pad.setTextureOffset(32, 60).addBox(1.5F, -6.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		arm_pad.setTextureOffset(32, 60).addBox(1.5F, 4.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
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
		return ImmutableList.of(root,
				gauntlet_fist,
				fist_guard,
				void_stone_knuckle,
				spike,
				void_spike,
				void_spike4,
		void_spike2,
		void_spike3,
		thumb,
		gauntlet_arm,
		gauntlet_arm2,
		gauntlet_shoulder,
		big_void_stone,
	flame_spike,
		 cube_r1,
		flame_spike2,
		cube_r2,
		arm_pad
		);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}