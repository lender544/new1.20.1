package com.github.L_Ender.cataclysm.client.model.block;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.blockentities.TileEntityEMP;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelPart;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Model_EMP extends AdvancedEntityModel<Entity> {
	private final AdvancedModelPart root;
	private final AdvancedModelPart down;
	private final AdvancedModelPart inner;
	private final AdvancedModelPart up;

	public Model_EMP() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelPart(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		down = new AdvancedModelPart(this);
		down.setRotationPoint(0.0F, -7.0F, 0.0F);
		root.addChild(down);
		down.setTextureOffset(0, 23).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 7.0F, 16.0F, 0.0F, false);
		down.setTextureOffset(48, 23).addBox(-7.0F, -1.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);

		inner = new AdvancedModelPart(this);
		inner.setRotationPoint(0.0F, -8.0F, 0.0F);
		root.addChild(inner);
		inner.setTextureOffset(0, 46).addBox(-6.0F, -14.0F, -6.0F, 12.0F, 14.0F, 12.0F, 0.0F, false);
		inner.setTextureOffset(0, 72).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 3.0F, 12.0F, 0.3F, false);

		up = new AdvancedModelPart(this);
		up.setRotationPoint(0.0F, -15.0F, 0.0F);
		inner.addChild(up);
		up.setTextureOffset(0, 0).addBox(-8.0F, -7.0F, -8.0F, 16.0F, 7.0F, 16.0F, 0.0F, false);
		up.setTextureOffset(48, 0).addBox(-7.0F, 0.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
		this.updateDefaultPose();
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelPart> getAllParts() {
		return ImmutableList.of(root, down, inner,up);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	public void animate(TileEntityEMP beak, float partialTick) {
		this.resetToDefaultPose();
		float amount = beak.getChompProgress(partialTick);
		progressPositionPrev(inner, amount,0, 5, 0, 15f);
		progressPositionPrev(up, amount,0, 5.5F, 0, 15f);
	}
}