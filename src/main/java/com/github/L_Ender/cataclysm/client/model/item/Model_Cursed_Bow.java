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

public class Model_Cursed_Bow extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox bow;
	private final AdvancedModelBox arm1;
	private final AdvancedModelBox arm2;
	private final AdvancedModelBox bow_string;
	private final AdvancedModelBox string;
	private final AdvancedModelBox string2;

	public Model_Cursed_Bow() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		bow = new AdvancedModelBox(this);
		bow.setRotationPoint(0.0005F, -17.0644F, -6.2737F);
		root.addChild(bow);
		bow.setTextureOffset(40, 2).addBox(-1.0F, -11.4356F, -1.2263F, 2.0F, 18.0F, 3.0F, 0.0F, false);
		bow.setTextureOffset(20, 0).addBox(0.0F, -8.4356F, -9.2263F, 0.0F, 12.0F, 8.0F, 0.0F, false);

		arm1 = new AdvancedModelBox(this);
		arm1.setRotationPoint(-0.0005F, -7.5162F, -0.7263F);
		bow.addChild(arm1);
		setRotationAngle(arm1, -0.5672F, 0.0F, 0.0F);
		arm1.setTextureOffset(0, 0).addBox(-2.4995F, -15.6119F, -3.9929F, 5.0F, 18.0F, 4.0F, 0.0F, false);
		arm1.setTextureOffset(14, 18).addBox(0.0005F, -22.846F, -2.9929F, 0.0F, 23.0F, 5.0F, 0.0F, false);

		arm2 = new AdvancedModelBox(this);
		arm2.setRotationPoint(-0.0005F, 2.6838F, -1.0263F);
		bow.addChild(arm2);
		setRotationAngle(arm2, 0.5672F, 0.0F, 0.0F);
		arm2.setTextureOffset(0, 23).addBox(0.0005F, -0.0933F, -2.6868F, 0.0F, 23.0F, 5.0F, 0.0F, false);
		arm2.setTextureOffset(25, 21).addBox(-1.4995F, -2.0933F, -3.6868F, 3.0F, 18.0F, 4.0F, 0.0F, false);

		bow_string = new AdvancedModelBox(this);
		bow_string.setRotationPoint(-0.0005F, -1.5F, 10.0F);
		bow.addChild(bow_string);


		string = new AdvancedModelBox(this);
		string.setRotationPoint(0.5005F, 0.0F, 0.0F);
		bow_string.addChild(string);
		string.setTextureOffset(37, 0).addBox(-1.001F, 0.0859F, -0.2263F, 1.0F, 19.0F, 0.0F, 0.0F, false);

		string2 = new AdvancedModelBox(this);
		string2.setRotationPoint(-0.4995F, 0.0F, -0.0485F);
		bow_string.addChild(string2);
		string2.setTextureOffset(11, 23).addBox(-0.001F, -18.9142F, -0.1778F, 1.0F, 19.0F, 0.0F, 0.0F, false);this.updateDefaultPose();
	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

	@Override
	public void setupAnim(Entity entity, float pullAmount, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();
		this.bow_string.rotationPointZ += pullAmount * 13;
		this.string2.rotateAngleX += (float) Math.toRadians(pullAmount * 25);
		this.string.rotateAngleX += (float) Math.toRadians(pullAmount * -25);
		this.arm1.rotateAngleX += (float) Math.toRadians(pullAmount * -15);
		this.arm2.rotateAngleX += (float) Math.toRadians(pullAmount * 15);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, bow_string, bow, arm1, arm2, string, string2);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}