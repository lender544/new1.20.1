package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Tidal_Tentacle_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox tonguePivot;
	private final AdvancedModelBox tongue;
	private float stretch;
	public static boolean HIDE = false;

	public Tidal_Tentacle_Model() {
		texWidth = 32;
		texHeight = 32;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 12.0F, 0.0F);


		tonguePivot = new AdvancedModelBox(this);
		tonguePivot.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(tonguePivot);


		tongue = new AdvancedModelBox(this);
		tongue.setRotationPoint(0.0F, 0.0F, 0.0F);
		tonguePivot.addChild(tongue);
		tongue.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 16.0F, 2.0F, 0.0F, false);
		this.updateDefaultPose();
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, tonguePivot, tongue);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	public void setAttributes(float f, float rotX, float rotY, float additionalYaw){
		this.resetToDefaultPose();
		this.stretch = f;
		float f1 =  1.0F;
		this.tongue.setScale(f1, this.stretch, f1);
		this.tonguePivot.rotateAngleX = (float)Math.toRadians(rotX);
		this.tonguePivot.rotateAngleY = (float)Math.toRadians(rotY);
		this.tongue.rotateAngleY = (float)Math.toRadians(-additionalYaw);
		this.tonguePivot.showModel = !HIDE;
		this.root.showModel = !HIDE;
		this.tongue.showModel = !HIDE;
	}
}