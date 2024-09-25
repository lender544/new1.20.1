package com.github.L_Ender.cataclysm.client.model.block;// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.blockentities.TileEntityAltarOfAbyss;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Altar_of_Abyss_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox tentacle;
	private final AdvancedModelBox skul;
	private final AdvancedModelBox maw;

	public Altar_of_Abyss_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		root.setTextureOffset(0, 20).addBox(-8.0F, -3.0F, -8.0F, 16.0F, 3.0F, 16.0F, 0.0F, false);
		root.setTextureOffset(0, 0).addBox(-8.0F, -11.0F, -8.0F, 16.0F, 3.0F, 16.0F, 0.0F, false);
		root.setTextureOffset(0, 40).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 5.0F, 12.0F, 0.0F, false);
		root.setTextureOffset(73, 16).addBox(-9.0F, -2.0F, 5.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		root.setTextureOffset(59, 70).addBox(-9.0F, -2.0F, -9.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		root.setTextureOffset(42, 69).addBox(5.0F, -2.0F, -9.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		root.setTextureOffset(13, 58).addBox(5.0F, -2.0F, 5.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		tentacle = new AdvancedModelBox(this);
		tentacle.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(tentacle);
		tentacle.setTextureOffset(0, 75).addBox(0.0F, -4.0F, -10.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		tentacle.setTextureOffset(30, 74).addBox(-4.0F, -4.0F, 8.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		tentacle.setTextureOffset(17, 74).addBox(8.0F, -6.0F, 0.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);
		tentacle.setTextureOffset(72, 73).addBox(-10.0F, -6.0F, -4.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);
		tentacle.setTextureOffset(0, 58).addBox(8.0F, -14.0F, -4.0F, 2.0F, 8.0F, 8.0F, 0.0F, false);
		tentacle.setTextureOffset(41, 52).addBox(-10.0F, -14.0F, -4.0F, 2.0F, 8.0F, 8.0F, 0.0F, false);
		tentacle.setTextureOffset(65, 32).addBox(-4.0F, -12.0F, -10.0F, 8.0F, 8.0F, 2.0F, 0.0F, false);
		tentacle.setTextureOffset(62, 59).addBox(-4.0F, -12.0F, 8.0F, 8.0F, 8.0F, 2.0F, 0.0F, false);

		skul = new AdvancedModelBox(this);
		skul.setRotationPoint(0.0F, -11.0F, 2.0F);
		root.addChild(skul);
		setRotationAngle(skul, -0.5236F, 0.0F, 0.0F);
		skul.setTextureOffset(49, 0).addBox(-6.0F, -9.0F, 0.0F, 12.0F, 9.0F, 6.0F, 0.0F, false);
		skul.setTextureOffset(0, 20).addBox(4.0F, -9.0F, -4.0F, 2.0F, 7.0F, 4.0F, 0.0F, false);
		skul.setTextureOffset(0, 0).addBox(-6.0F, -9.0F, -4.0F, 2.0F, 7.0F, 4.0F, 0.0F, false);
		skul.setTextureOffset(37, 40).addBox(-4.0F, -13.0F, -1.0F, 8.0F, 4.0F, 7.0F, 0.0F, false);
		skul.setTextureOffset(54, 52).addBox(-4.0F, -13.0F, -5.0F, 8.0F, 2.0F, 4.0F, 0.0F, false);

		maw = new AdvancedModelBox(this);
		maw.setRotationPoint(0.0F, -11.0F, -2.0F);
		root.addChild(maw);
		setRotationAngle(maw, 0.5236F, 0.0F, 0.0F);
		maw.setTextureOffset(49, 20).addBox(-5.0F, -8.0F, -3.0F, 10.0F, 8.0F, 3.0F, 0.0F, false);
		maw.setTextureOffset(43, 76).addBox(-5.0F, -8.0F, 0.0F, 1.0F, 6.0F, 3.0F, 0.0F, false);
		maw.setTextureOffset(0, 40).addBox(4.0F, -8.0F, 0.0F, 1.0F, 6.0F, 3.0F, 0.0F, false);
		maw.setTextureOffset(68, 43).addBox(-3.0F, -12.0F, -4.0F, 6.0F, 4.0F, 4.0F, 0.0F, false);
		maw.setTextureOffset(21, 65).addBox(-3.0F, -12.0F, 0.0F, 6.0F, 4.0F, 4.0F, 0.0F, false);
		this.updateDefaultPose();
	}

	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, tentacle, skul,maw);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	public void animate(TileEntityAltarOfAbyss beak, float partialTick) {
		this.resetToDefaultPose();
		float amount = beak.getChompProgress(partialTick);
		progressRotationPrev(skul, amount,(float)Math.toRadians(30F), 0f, 0, 30F);
		progressRotationPrev(maw, amount,(float)Math.toRadians(-30F), 0f, 0, 30F);
	}

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}