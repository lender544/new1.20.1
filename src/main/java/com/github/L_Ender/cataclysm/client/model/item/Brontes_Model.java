package com.github.L_Ender.cataclysm.client.model.item;// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.projectile.Brontes_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Brontes_Model extends AdvancedEntityModel<Brontes_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox hammer_head;
	private final AdvancedModelBox back;
	private final AdvancedModelBox handle;
	private final AdvancedModelBox handle2;

	public Brontes_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 11.0F, 0.0F);
		

		hammer_head = new AdvancedModelBox(this);
		hammer_head.setRotationPoint(0.0F, 20.0F, -1.0F);
		root.addChild(hammer_head);
		hammer_head.setTextureOffset(36, 0).addBox(-3.0F, -38.0F, -2.0F, 6.0F, 7.0F, 6.0F, 0.0F, false);
		hammer_head.setTextureOffset(6, 51).addBox(3.25F, -33.5F, -2.0F, 0.0F, 2.0F, 6.0F, 0.0F, false);
		hammer_head.setTextureOffset(56, 52).addBox(-3.25F, -33.5F, -2.0F, 0.0F, 2.0F, 6.0F, 0.0F, false);
		hammer_head.setTextureOffset(52, 36).addBox(-3.25F, -37.5F, -2.0F, 0.0F, 2.0F, 6.0F, 0.0F, false);
		hammer_head.setTextureOffset(56, 44).addBox(3.25F, -37.5F, -2.0F, 0.0F, 2.0F, 6.0F, 0.0F, false);
		hammer_head.setTextureOffset(36, 13).addBox(-3.5F, -38.5F, 2.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		hammer_head.setTextureOffset(18, 51).addBox(-3.5F, -33.5F, 2.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		hammer_head.setTextureOffset(18, 56).addBox(0.5F, -38.5F, 2.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		hammer_head.setTextureOffset(42, 58).addBox(0.5F, -38.5F, -2.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		hammer_head.setTextureOffset(6, 59).addBox(0.5F, -33.5F, -2.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		hammer_head.setTextureOffset(60, 0).addBox(0.5F, -33.5F, 2.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		hammer_head.setTextureOffset(56, 13).addBox(-3.5F, -33.5F, -2.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		hammer_head.setTextureOffset(46, 13).addBox(-3.5F, -38.5F, -2.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		hammer_head.setTextureOffset(0, 19).addBox(-4.0F, -39.0F, -10.0F, 8.0F, 9.0F, 8.0F, 0.0F, false);
		hammer_head.setTextureOffset(28, 36).addBox(-4.5F, -39.5F, -11.0F, 9.0F, 10.0F, 3.0F, 0.0F, false);
		hammer_head.setTextureOffset(32, 19).addBox(-4.0F, -39.0F, -9.0F, 8.0F, 9.0F, 8.0F, 0.3F, false);

		back = new AdvancedModelBox(this);
		back.setRotationPoint(0.0F, -35.0F, 9.0F);
		hammer_head.addChild(back);
		back.setTextureOffset(0, 36).addBox(-4.0F, -4.0F, -5.0F, 8.0F, 9.0F, 6.0F, 0.0F, false);
		back.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -5.0F, 8.0F, 9.0F, 10.0F, 0.3F, false);

		handle = new AdvancedModelBox(this);
		handle.setRotationPoint(0.0F, 12.0F, 0.5F);
		root.addChild(handle);
		handle.setTextureOffset(0, 51).addBox(-0.5F, -18.0F, -1.5F, 1.0F, 14.0F, 2.0F, 0.0F, false);
		handle.setTextureOffset(28, 49).addBox(0.0F, 0.0F, -4.0F, 0.0F, 8.0F, 7.0F, 0.0F, false);
		handle.setTextureOffset(60, 5).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 4.0F, 2.0F, 0.2F, false);
		handle.setTextureOffset(52, 60).addBox(-0.5F, -17.0F, -1.5F, 1.0F, 1.0F, 2.0F, 0.2F, false);

		handle2 = new AdvancedModelBox(this);
		handle2.setRotationPoint(0.0F, 7.0F, 0.5F);
		root.addChild(handle2);
		handle2.setTextureOffset(42, 49).addBox(-1.5F, -18.0F, -2.5F, 3.0F, 5.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Brontes_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
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
				hammer_head,
				back,
				handle,
				handle2
		);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

}