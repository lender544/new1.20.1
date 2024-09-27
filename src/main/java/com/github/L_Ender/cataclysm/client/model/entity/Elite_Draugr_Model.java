package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.0
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.entity.Entity;

public class Elite_Draugr_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox body;
	private final AdvancedModelBox front_cloth1;
	private final AdvancedModelBox front_cloth2;
	private final AdvancedModelBox back_cloth1;
	private final AdvancedModelBox back_cloth2;
	private final AdvancedModelBox waist;
	private final AdvancedModelBox chest;
	private final AdvancedModelBox neck;
	private final AdvancedModelBox head;
	private final AdvancedModelBox maw;
	private final AdvancedModelBox l_arm;
	private final AdvancedModelBox cube_r1;
	private final AdvancedModelBox l_arm2;
	private final AdvancedModelBox r_arm;
	private final AdvancedModelBox cube_r2;
	private final AdvancedModelBox r_arm2;
	private final AdvancedModelBox right_leg;
	private final AdvancedModelBox left_leg;

	public Elite_Draugr_Model() {
		texWidth = 128;
		texHeight = 128;
		
		root = new AdvancedModelBox(this,"root");
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		body = new AdvancedModelBox(this,"body");
		body.setRotationPoint(0.0F, -12.0F, 0.0F);
		root.addChild(body);
		body.setTextureOffset(52, 0).addBox(-5.0F, -4.0F, -2.0F, 10.0F, 4.0F, 4.0F, 0.0F, false);

		front_cloth1 = new AdvancedModelBox(this,"front_cloth1");
		front_cloth1.setRotationPoint(0.0F, 0.0F, -2.0F);
		body.addChild(front_cloth1);
		setRotationAngle(front_cloth1, -0.0436F, 0.0F, 0.0F);
		front_cloth1.setTextureOffset(60, 8).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, 0.0F, false);

		front_cloth2 = new AdvancedModelBox(this,"front_cloth2");
		front_cloth2.setRotationPoint(0.0F, 4.0F, 0.0F);
		front_cloth1.addChild(front_cloth2);
		setRotationAngle(front_cloth2, 0.0873F, 0.0F, 0.0F);
		front_cloth2.setTextureOffset(56, 44).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, 0.0F, false);

		back_cloth1 = new AdvancedModelBox(this,"back_cloth1");
		back_cloth1.setRotationPoint(0.0F, 0.0F, 2.0F);
		body.addChild(back_cloth1);
		setRotationAngle(back_cloth1, 0.0873F, 0.0F, 0.0F);
		back_cloth1.setTextureOffset(38, 16).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, 0.0F, false);

		back_cloth2 = new AdvancedModelBox(this,"back_cloth2");
		back_cloth2.setRotationPoint(0.0F, 4.0F, 0.0F);
		back_cloth1.addChild(back_cloth2);
		back_cloth2.setTextureOffset(0, 18).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, 0.0F, false);

		waist = new AdvancedModelBox(this,"waist");
		waist.setRotationPoint(0.0F, -4.0F, 1.0F);
		body.addChild(waist);
		waist.setTextureOffset(80, 50).addBox(-1.5F, -8.0F, -1.0F, 3.0F, 8.0F, 2.0F, 0.0F, false);

		chest = new AdvancedModelBox(this,"chest");
		chest.setRotationPoint(0.0F, -8.0F, 0.0F);
		waist.addChild(chest);
		chest.setTextureOffset(80, 60).addBox(-1.5F, -8.0F, -1.0F, 3.0F, 8.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(32, 50).addBox(-6.0F, -8.0F, -4.0F, 12.0F, 10.0F, 4.0F, 0.0F, false);
		chest.setTextureOffset(96, 0).addBox(-6.0F, -8.0F, -4.0F, 12.0F, 10.0F, 4.0F, 0.1F, false);

		neck = new AdvancedModelBox(this,"neck");
		neck.setRotationPoint(0.0F, -8.0F, 0.0F);
		chest.addChild(neck);
		neck.setTextureOffset(16, 18).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		head = new AdvancedModelBox(this,"head");
		head.setRotationPoint(0.0F, -2.0F, -1.0F);
		neck.addChild(head);
		head.setTextureOffset(0, 48).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(96, 112).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.1F, false);
		head.setTextureOffset(0, 64).addBox(-11.0F, -15.0F, 0.0F, 9.0F, 11.0F, 0.0F, 0.0F, false);
		head.setTextureOffset(80, 0).addBox(4.0F, -12.0F, 0.0F, 6.0F, 8.0F, 0.0F, 0.0F, false);
		head.setTextureOffset(28, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.4F, false);

		maw = new AdvancedModelBox(this,"maw");
		maw.setRotationPoint(0.5F, 0.5F, -3.0F);
		head.addChild(maw);
		setRotationAngle(maw, 0.2102F, 0.0504F, -0.3014F);
		maw.setTextureOffset(60, 60).addBox(-3.0F, -2.5F, -2.0F, 6.0F, 5.0F, 4.0F, 0.0F, false);

		l_arm = new AdvancedModelBox(this,"l_arm");
		l_arm.setRotationPoint(7.0F, -6.0F, -1.0F);
		chest.addChild(l_arm);
		l_arm.setTextureOffset(72, 32).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		l_arm.setTextureOffset(26, 76).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.3F, false);

		cube_r1 = new AdvancedModelBox(this);
		cube_r1.setRotationPoint(0.5F, -2.0F, 0.0F);
		l_arm.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.2618F);
		cube_r1.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, -2.5F, 6.0F, 4.0F, 5.0F, 0.0F, false);

		l_arm2 = new AdvancedModelBox(this,"l_arm2");
		l_arm2.setRotationPoint(0.0F, 6.0F, 0.0F);
		l_arm.addChild(l_arm2);
		l_arm2.setTextureOffset(52, 69).addBox(-2.0F, 2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.2F, false);
		l_arm2.setTextureOffset(68, 69).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, true);

		r_arm = new AdvancedModelBox(this,"r_arm");
		r_arm.setRotationPoint(-7.0F, -6.0F, -1.0F);
		chest.addChild(r_arm);
		r_arm.setTextureOffset(72, 20).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		r_arm.setTextureOffset(64, 50).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.3F, false);

		cube_r2 = new AdvancedModelBox(this);
		cube_r2.setRotationPoint(-0.5F, -2.0F, 0.0F);
		r_arm.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.2618F);
		cube_r2.setTextureOffset(0, 12).addBox(-4.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(17, 11).addBox(-5.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(17, 9).addBox(0.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 9).addBox(-2.0F, -4.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 9).addBox(-3.0F, -2.0F, -2.5F, 6.0F, 4.0F, 5.0F, 0.0F, false);

		r_arm2 = new AdvancedModelBox(this,"r_arm2");
		r_arm2.setRotationPoint(0.0F, 6.0F, 0.0F);
		r_arm.addChild(r_arm2);
		r_arm2.setTextureOffset(68, 69).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		r_arm2.setTextureOffset(36, 64).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.2F, false);

		right_leg = new AdvancedModelBox(this,"right_leg");
		right_leg.setRotationPoint(-3.0F, -12.0F, 0.0F);
		root.addChild(right_leg);
		right_leg.setTextureOffset(56, 28).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		left_leg = new AdvancedModelBox(this,"left_leg");
		left_leg.setRotationPoint(3.0F, -12.0F, 0.0F);
		root.addChild(left_leg);
		left_leg.setTextureOffset(56, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		this.updateDefaultPose();
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.resetToDefaultPose();

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
				body,
				front_cloth1,
				front_cloth2,
				back_cloth1,
				back_cloth2,
				waist,
				chest,
				neck,
				head,
				maw,
				l_arm,
				cube_r1,
				l_arm2,
				r_arm,
				cube_r2,
				r_arm2,
				right_leg,
				left_leg
		);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}