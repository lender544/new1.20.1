package com.github.L_Ender.cataclysm.client.model.block;// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.github.L_Ender.cataclysm.client.animation.Boss_Respawn_Spawner_Animation;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Boss_Respawn_Spawner_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox bone;
	private final AdvancedModelBox one;
	private final AdvancedModelBox two;
	private final AdvancedModelBox three;
	private final AdvancedModelBox four;
	private final AdvancedModelBox bone2;
	private final AdvancedModelBox bone3;
	
	public Boss_Respawn_Spawner_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this,"root");
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		root.setTextureOffset(33, 0).addBox(-4.0F, -18.0F, -4.0F, 8.0F, 14.0F, 8.0F, 0.0F, false);

		bone = new AdvancedModelBox(this,"bone");
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(bone);


		one = new AdvancedModelBox(this,"one");
		one.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(one);
		one.setTextureOffset(0, 0).addBox(-8.0F, -18.0F, 0.0F, 8.0F, 18.0F, 8.0F, 0.0F, false);

		two = new AdvancedModelBox(this,"two");
		two.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(two);
		two.setTextureOffset(0, 0).addBox(0.0F, -18.0F, 0.0F, 8.0F, 18.0F, 8.0F, 0.0F, true);

		three = new AdvancedModelBox(this,"three");
		three.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(three);
		three.setTextureOffset(0, 27).addBox(0.0F, -18.0F, -8.0F, 8.0F, 18.0F, 8.0F, 0.0F, true);

		four = new AdvancedModelBox(this,"four");
		four.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(four);
		four.setTextureOffset(0, 27).addBox(-8.0F, -18.0F, -8.0F, 8.0F, 18.0F, 8.0F, 0.0F, false);

		bone2 = new AdvancedModelBox(this,"bone2");
		bone2.setRotationPoint(0.0F, -18.0F, 7.0F);
		root.addChild(bone2);
		bone2.setTextureOffset(33, 23).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 4.0F, 6.0F, 0.0F, false);
		bone2.setTextureOffset(33, 41).addBox(-3.0F, -4.0F, -7.0F, 6.0F, 0.0F, 1.0F, 0.0F, false);

		bone3 = new AdvancedModelBox(this,"bone3");
		bone3.setRotationPoint(0.0F, -18.0F, -7.0F);
		root.addChild(bone3);
		bone3.setTextureOffset(33, 34).addBox(-4.0F, -4.0F, 1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		this.updateDefaultPose();
	}

	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root,bone,
		one,
		two,
		three,
		four,
		bone2,
		bone3);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();

	}

	public void animate(Boss_Respawn_Spawner_Block_Entity entity, float partialTick) {
		this.resetToDefaultPose();
		float ageInTicks = entity.tickCount + partialTick;
		this.animate(entity.getAnimationState("opening"), Boss_Respawn_Spawner_Animation.SPAWNING, ageInTicks, 1.0F);
	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}