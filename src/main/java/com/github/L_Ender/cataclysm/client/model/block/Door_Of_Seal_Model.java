package com.github.L_Ender.cataclysm.client.model.block;// Made with Blockbench 4.11.0
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.blockentities.Door_Of_Seal_BlockEntity;
import com.github.L_Ender.cataclysm.client.animation.Door_Of_Seal_Animation;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Door_Of_Seal_Model extends AdvancedEntityModel<Entity> {
	public final AdvancedModelBox roots;
	public final AdvancedModelBox left_door;
	public final AdvancedModelBox right_door;
	public final AdvancedModelBox lock;
	public final AdvancedModelBox cube_r1;

	public Door_Of_Seal_Model() {
		texWidth = 256;
		texHeight = 256;

		roots = new AdvancedModelBox(this,"roots");
		roots.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		left_door = new AdvancedModelBox(this,"left_door");
		left_door.setRotationPoint(40.0F, -64.0F, 0.0F);
		roots.addChild(left_door);
		left_door.setTextureOffset(0, 0).addBox(-40.0F, -64.0F, -8.0F, 40.0F, 128.0F, 16.0F, 0.0F, true);

		right_door = new AdvancedModelBox(this,"right_door");
		right_door.setRotationPoint(-40.0F, -64.0F, 0.0F);
		roots.addChild(right_door);
		right_door.setTextureOffset(0, 0).addBox(0.0F, -64.0F, -8.0F, 40.0F, 128.0F, 16.0F, 0.0F, false);

		lock = new AdvancedModelBox(this,"lock");
		lock.setRotationPoint(0.0F, -24.0F, -9.0F);
		roots.addChild(lock);
		

		cube_r1 = new AdvancedModelBox(this,"cube_r1");
		cube_r1.setRotationPoint(0.0F, 7.9F, 0.0F);
		lock.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
		cube_r1.setTextureOffset(0, 144).addBox(-21.6F, -21.6F, -1.0F, 32.0F, 32.0F, 2.0F, 0.0F, false);
		this.updateDefaultPose();
	}

	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(roots);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(roots, left_door, right_door,lock,cube_r1);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();

	}

	public void animate(Door_Of_Seal_BlockEntity entity, float partialTick) {
		this.resetToDefaultPose();
		float ageInTicks = entity.tickCount + partialTick;
		this.animate(entity.getAnimationState("opening"), Door_Of_Seal_Animation.OPEN, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("open"), Door_Of_Seal_Animation.OPEN_IDLE, ageInTicks, 1.0F);
	}



	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}