package com.github.L_Ender.cataclysm.client.model.block;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.blockentities.TileEntityAltarOfFire;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Altar_of_Fire_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox pillar;
	private final AdvancedModelBox flag_ring;
	private final AdvancedModelBox flag1;
	private final AdvancedModelBox flag2;
	private final AdvancedModelBox flag3;
	private final AdvancedModelBox flag4;
	private final AdvancedModelBox edge;
	private final AdvancedModelBox under_edge;
	private final AdvancedModelBox fire;

	public Altar_of_Fire_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		pillar = new AdvancedModelBox(this);
		pillar.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(pillar);
		pillar.setTextureOffset(0, 46).addBox(-8.0F, -12.0F, -8.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
		pillar.setTextureOffset(0, 25).addBox(-8.0F, -4.1F, -8.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
		pillar.setTextureOffset(0, 0).addBox(-8.0F, -20.75F, -8.0F, 16.0F, 8.0F, 16.0F, 0.5F, false);
		pillar.setTextureOffset(53, 13).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 4.0F, 12.0F, 0.0F, false);

		flag_ring = new AdvancedModelBox(this);
		flag_ring.setRotationPoint(0.0F, -0.25F, 0.0F);
		pillar.addChild(flag_ring);


		flag1 = new AdvancedModelBox(this);
		flag1.setRotationPoint(0.0F, -12.0F, -8.75F);
		flag_ring.addChild(flag1);
		flag1.setTextureOffset(49, 0).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		flag2 = new AdvancedModelBox(this);
		flag2.setRotationPoint(8.25F, -12.0F, 0.0F);
		flag_ring.addChild(flag2);
		flag2.setTextureOffset(66, 47).addBox(0.0F, 0.0F, -4.0F, 0.0F, 11.0F, 8.0F, 0.0F, false);

		flag3 = new AdvancedModelBox(this);
		flag3.setRotationPoint(0.0F, -12.0F, 8.25F);
		flag_ring.addChild(flag3);
		flag3.setTextureOffset(49, 0).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		flag4 = new AdvancedModelBox(this);
		flag4.setRotationPoint(-8.25F, -12.0F, 0.0F);
		flag_ring.addChild(flag4);
		flag4.setTextureOffset(66, 47).addBox(0.0F, 0.0F, -4.0F, 0.0F, 11.0F, 8.0F, 0.0F, false);

		edge = new AdvancedModelBox(this);
		edge.setRotationPoint(0.0F, -12.0F, 0.0F);
		pillar.addChild(edge);
		edge.setTextureOffset(66, 0).addBox(6.0F, -1.0F, 6.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		edge.setTextureOffset(0, 67).addBox(6.0F, -1.0F, -10.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		edge.setTextureOffset(0, 67).addBox(-10.0F, -1.0F, -10.0F, 4.0F, 3.0F, 4.0F, 0.0F, true);
		edge.setTextureOffset(66, 0).addBox(-10.0F, -1.0F, 6.0F, 4.0F, 3.0F, 4.0F, 0.0F, true);
		edge.setTextureOffset(0, 7).addBox(-9.0F, 3.0F, 6.0F, 3.0F, 3.0F, 3.0F, 0.0F, true);
		edge.setTextureOffset(0, 7).addBox(6.0F, 3.0F, 6.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		edge.setTextureOffset(0, 0).addBox(6.0F, 3.0F, -9.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		edge.setTextureOffset(0, 0).addBox(-9.0F, 3.0F, -9.0F, 3.0F, 3.0F, 3.0F, 0.0F, true);

		under_edge = new AdvancedModelBox(this);
		under_edge.setRotationPoint(0.0F, 9.0F, 0.0F);
		pillar.addChild(under_edge);
		under_edge.setTextureOffset(0, 67).addBox(5.0F, -12.0F, -9.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		under_edge.setTextureOffset(0, 67).addBox(-9.0F, -12.0F, -9.0F, 4.0F, 3.0F, 4.0F, 0.0F, true);
		under_edge.setTextureOffset(66, 0).addBox(-9.0F, -12.0F, 5.0F, 4.0F, 3.0F, 4.0F, 0.0F, true);
		under_edge.setTextureOffset(66, 0).addBox(5.0F, -12.0F, 5.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		fire = new AdvancedModelBox(this);
		fire.setRotationPoint(0.0F, -12.0F, 0.0F);
		root.addChild(fire);
		setRotationAngle(fire, 0.0F, -0.7854F, 0.0F);
		fire.setTextureOffset(65, 30).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
		fire.setTextureOffset(49, 51).addBox(0.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
		this.updateDefaultPose();
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, pillar, flag_ring,edge,under_edge,fire,flag1,flag2,flag3,flag4);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();
	}

	public void animate(TileEntityAltarOfFire beak, float partialTick) {
		this.resetToDefaultPose();
		float ageInTicks = beak.tickCount + partialTick;
		this.walk(flag1, 0.1F, 0.05F, false, 0F, -0.05F, ageInTicks, 1F);
		this.flap(flag2, 0.1F, 0.05F, false, 0F, -0.05F, ageInTicks, 1F);
		this.walk(flag3, 0.1F, 0.05F, true, 0F, -0.05F, ageInTicks, 1F);
		this.flap(flag4, 0.1F, 0.05F, true, 0F, -0.05F, ageInTicks, 1F);
	}

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}