package com.github.L_Ender.cataclysm.client.model.block;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Goddess_Statue_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox body;
	private final AdvancedModelBox cube_r1;
	private final AdvancedModelBox cube_r2;
	private final AdvancedModelBox cube_r3;
	private final AdvancedModelBox cube_r4;
	private final AdvancedModelBox cube_r5;
	private final AdvancedModelBox r_leg;
	private final AdvancedModelBox l_leg;
	private final AdvancedModelBox head;
	private final AdvancedModelBox helmet;
	private final AdvancedModelBox cube_r6;
	private final AdvancedModelBox cube_r7;
	private final AdvancedModelBox cube_r8;
	private final AdvancedModelBox hair;
	private final AdvancedModelBox cube_r9;
	private final AdvancedModelBox cube_r10;
	private final AdvancedModelBox cube_r11;
	private final AdvancedModelBox cube_r12;
	private final AdvancedModelBox cube_r13;

	public Goddess_Statue_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		body = new AdvancedModelBox(this);
		body.setRotationPoint(-2.5F, -15.0F, 3.0F);
		root.addChild(body);
		body.setTextureOffset(54, 66).addBox(-1.0F, -9.0F, -5.0F, 7.0F, 7.0F, 6.0F, 0.0F, false);

		cube_r1 = new AdvancedModelBox(this);
		cube_r1.setRotationPoint(2.5F, 1.229F, 3.2595F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0611F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(54, 79).addBox(-5.5F, 0.05F, 0.1F, 11.0F, 14.0F, 0.0F, 0.0F, false);

		cube_r2 = new AdvancedModelBox(this);
		cube_r2.setRotationPoint(3.0F, -1.8467F, -5.5308F);
		body.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.0873F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(74, 0).addBox(-6.0F, 0.0F, 0.0F, 11.0F, 17.0F, 0.0F, 0.0F, false);

		cube_r3 = new AdvancedModelBox(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.2182F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(36, 0).addBox(-3.0F, -5.0F, -5.0F, 11.0F, 7.0F, 8.0F, 0.0F, false);

		cube_r4 = new AdvancedModelBox(this);
		cube_r4.setRotationPoint(-1.0F, -12.1F, -4.0F);
		body.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.8727F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(74, 17).addBox(-1.0F, -3.0F, -3.0F, 9.0F, 6.0F, 4.0F, 0.0F, false);

		cube_r5 = new AdvancedModelBox(this);
		cube_r5.setRotationPoint(-2.0F, -13.0F, -2.0F);
		body.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.1745F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(26, 56).addBox(-3.0F, -4.0F, -1.0F, 15.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r5.setTextureOffset(41, 16).addBox(0.0F, -4.0F, -3.0F, 9.0F, 9.0F, 7.0F, 0.005F, false);

		r_leg = new AdvancedModelBox(this);
		r_leg.setRotationPoint(-3.0F, -15.0F, 3.0F);
		root.addChild(r_leg);
		setRotationAngle(r_leg, 0.0037F, -0.089F, -0.0836F);
		r_leg.setTextureOffset(40, 32).addBox(-4.5F, -2.0F, -5.0F, 6.0F, 17.0F, 7.0F, 0.0F, false);

		l_leg = new AdvancedModelBox(this);
		l_leg.setRotationPoint(3.0F, -15.0F, 3.0F);
		root.addChild(l_leg);
		setRotationAngle(l_leg, 0.0106F, 0.0375F, 0.0926F);
		l_leg.setTextureOffset(0, 54).addBox(-1.5F, -2.0F, -5.0F, 6.0F, 17.0F, 7.0F, 0.0F, false);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, -34.0F, 3.0F);
		root.addChild(head);
		head.setTextureOffset(76, 79).addBox(-2.0F, -3.0F, -2.5F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		helmet = new AdvancedModelBox(this);
		helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(helmet);
		helmet.setTextureOffset(66, 32).addBox(-3.0F, -8.0F, -5.0F, 6.0F, 8.0F, 7.0F, 0.0F, false);

		cube_r6 = new AdvancedModelBox(this);
		cube_r6.setRotationPoint(3.5F, -5.0F, -3.9F);
		helmet.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0504F, 0.523F, 0.0252F);
		cube_r6.setTextureOffset(38, 80).addBox(0.0F, -3.9706F, 0.0281F, 0.0F, 8.0F, 6.0F, 0.005F, false);

		cube_r7 = new AdvancedModelBox(this);
		cube_r7.setRotationPoint(-3.5F, -5.0F, -3.9F);
		helmet.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0517F, -0.5666F, -0.0278F);
		cube_r7.setTextureOffset(26, 80).addBox(0.0F, -3.9706F, 0.0281F, 0.0F, 8.0F, 6.0F, 0.005F, false);

		cube_r8 = new AdvancedModelBox(this);
		cube_r8.setRotationPoint(0.0F, -8.0F, -3.0F);
		helmet.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0436F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(0, 78).addBox(-3.5F, 1.0F, -3.0F, 7.0F, 7.0F, 6.0F, 0.005F, false);

		hair = new AdvancedModelBox(this);
		hair.setRotationPoint(-7.0F, 11.0F, 3.0F);
		head.addChild(hair);


		cube_r9 = new AdvancedModelBox(this);
		cube_r9.setRotationPoint(-2.0793F, -0.0236F, 5.4038F);
		hair.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0854F, -0.0189F, -0.0011F);
		cube_r9.setTextureOffset(106, 5).addBox(-4.9983F, -8.3334F, -0.0112F, 5.0F, 16.0F, 0.0F, 0.0F, false);

		cube_r10 = new AdvancedModelBox(this);
		cube_r10.setRotationPoint(5.0F, -6.0F, 1.0F);
		hair.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0854F, -0.0189F, -0.0011F);
		cube_r10.setTextureOffset(0, 0).addBox(-7.0F, -5.0F, -1.0F, 13.0F, 24.0F, 5.0F, 0.0F, false);

		cube_r11 = new AdvancedModelBox(this);
		cube_r11.setRotationPoint(7.25F, 5.0F, 2.0F);
		hair.addChild(cube_r11);
		setRotationAngle(cube_r11, -0.2606F, -0.028F, -0.7372F);
		cube_r11.setTextureOffset(92, 27).addBox(4.2194F, 3.0464F, -1.0664F, 4.0F, 15.0F, 0.0F, 0.0F, false);
		cube_r11.setTextureOffset(0, 29).addBox(-7.7806F, 1.0464F, -1.0664F, 12.0F, 17.0F, 8.0F, 0.0F, false);

		cube_r12 = new AdvancedModelBox(this);
		cube_r12.setRotationPoint(2.0F, -10.0F, -5.0F);
		hair.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.1265F, 0.0338F, -0.2597F);
		cube_r12.setTextureOffset(26, 66).addBox(-3.0F, -1.0F, -4.0F, 5.0F, 5.0F, 9.0F, 0.0F, false);

		cube_r13 = new AdvancedModelBox(this);
		cube_r13.setRotationPoint(8.25F, -16.5F, -1.0F);
		hair.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.3853F, -0.1193F, 0.0443F);
		cube_r13.setTextureOffset(66, 47).addBox(-5.5593F, -0.341F, -3.4177F, 8.0F, 10.0F, 5.0F, 0.0F, false);

		this.updateDefaultPose();
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				body,
				cube_r1,
				cube_r2,
				cube_r3,
				cube_r4,
				cube_r5,
				r_leg,
				l_leg,
				head,
				helmet,
				cube_r6,
				cube_r7,
				cube_r8,
				hair,
				cube_r9,
				cube_r10,
				cube_r11,
				cube_r12,
				cube_r13
		);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();
	}

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}