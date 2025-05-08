package com.github.L_Ender.cataclysm.client.model.item;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class Lightning_Spear_Model extends AdvancedEntityModel<Entity> {

	private final AdvancedModelBox root;
	private final AdvancedModelBox rot;
	private final AdvancedModelBox root_r1;


	public Lightning_Spear_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, -4.0F, 0.0F);


		rot = new AdvancedModelBox(this);
		rot.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(rot);
		rot.setTextureOffset(0, -64).addBox(0.0F, -7.5F, -23.0F, 0.0F, 15.0F, 64.0F, 0.0F, false);

		root_r1 = new AdvancedModelBox(this);
		root_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rot.addChild(root_r1);
		setRotationAngle(root_r1, 0.0F, 0.0F, 1.5708F);
		root_r1.setTextureOffset(0, -64).addBox(0.0F, -7.5F, -23.0F, 0.0F, 15.0F, 64.0F, 0.0F, false);

		this.updateDefaultPose();
	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;

	}

	@Override
	public void setupAnim(Entity entity, float pullAmount, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();

	}


	public void animateStack(ItemStack itemStackIn) {

	}


	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				rot,root_r1);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}