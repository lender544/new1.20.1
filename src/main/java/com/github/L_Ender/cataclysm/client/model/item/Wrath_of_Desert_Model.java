package com.github.L_Ender.cataclysm.client.model.item;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.render.CMItemstackRenderer;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class Wrath_of_Desert_Model extends AdvancedEntityModel<Entity> {

	private final AdvancedModelBox root;
	private final AdvancedModelBox bow;
	private final AdvancedModelBox bow_r1;
	private final AdvancedModelBox arm1;
	private final AdvancedModelBox cube_r8_r1;
	private final AdvancedModelBox arm2;
	private final AdvancedModelBox bow_string;
	private final AdvancedModelBox string;
	private final AdvancedModelBox string2;
	private final AdvancedModelBox arrow3;
	private final AdvancedModelBox arrow_pivot3;
	private final AdvancedModelBox third_sand3;
	private final AdvancedModelBox third_sand2;
	private final AdvancedModelBox third_sand1;
	private final AdvancedModelBox arrow2;
	private final AdvancedModelBox arrow_pivot2;
	private final AdvancedModelBox second_sand3;
	private final AdvancedModelBox second_sand2;
	private final AdvancedModelBox second_sand1;
	private final AdvancedModelBox arrow1;
	private final AdvancedModelBox arrow_pivot1;
	private final AdvancedModelBox first_sand3;
	private final AdvancedModelBox first_sand2;
	private final AdvancedModelBox first_sand1;
	
	public Wrath_of_Desert_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);

		bow = new AdvancedModelBox(this);
		bow.setRotationPoint(0.0005F, -17.0644F, -6.2737F);
		root.addChild(bow);
		bow.setTextureOffset(26, 49).addBox(-1.0F, -11.4356F, -1.2263F, 2.0F, 18.0F, 3.0F, 0.0F, false);
		bow.setTextureOffset(36, 91).addBox(0.0F, -11.4356F, 1.7737F, 0.0F, 19.0F, 2.0F, 0.0F, false);
		bow.setTextureOffset(0, 0).addBox(0.0F, -8.4356F, -9.2263F, 0.0F, 12.0F, 8.0F, 0.0F, false);

		bow_r1 = new AdvancedModelBox(this);
		bow_r1.setRotationPoint(-1.5F, -2.4356F, 0.2737F);
		bow.addChild(bow_r1);
		setRotationAngle(bow_r1, -0.7854F, 0.0F, 0.0F);
		bow_r1.setTextureOffset(36, 83).addBox(-0.5F, -2.5F, -2.5F, 1.0F, 5.0F, 5.0F, 0.0F, false);
		bow_r1.setTextureOffset(36, 73).addBox(2.5F, -2.5F, -2.5F, 1.0F, 5.0F, 5.0F, 0.0F, false);

		arm1 = new AdvancedModelBox(this);
		arm1.setRotationPoint(-0.0005F, -7.5162F, -0.7263F);
		bow.addChild(arm1);
		setRotationAngle(arm1, -0.5672F, 0.0F, 0.0F);
		arm1.setTextureOffset(43, 22).addBox(-2.4995F, -15.6119F, -3.9929F, 5.0F, 18.0F, 4.0F, 0.0F, false);
		arm1.setTextureOffset(47, 8).addBox(-2.4995F, -0.6119F, -11.9929F, 5.0F, 6.0F, 8.0F, 0.0F, false);
		arm1.setTextureOffset(61, 39).addBox(2.5005F, -15.6119F, -3.9929F, 5.0F, 3.0F, 2.0F, 0.0F, false);
		arm1.setTextureOffset(65, 44).addBox(2.5005F, -10.6119F, -3.9929F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		arm1.setTextureOffset(65, 47).addBox(-6.4995F, -10.6119F, -3.9929F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		arm1.setTextureOffset(61, 34).addBox(-7.4995F, -15.6119F, -3.9929F, 5.0F, 3.0F, 2.0F, 0.0F, false);
		arm1.setTextureOffset(38, 45).addBox(0.0005F, -22.846F, -2.9929F, 0.0F, 23.0F, 5.0F, 0.0F, false);

		cube_r8_r1 = new AdvancedModelBox(this);
		cube_r8_r1.setRotationPoint(0.0005F, -11.1119F, -4.4929F);
		arm1.addChild(cube_r8_r1);
		setRotationAngle(cube_r8_r1, 0.0F, 0.0F, 0.7854F);
		cube_r8_r1.setTextureOffset(61, 28).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, 0.0F, false);

		arm2 = new AdvancedModelBox(this);
		arm2.setRotationPoint(-0.0005F, 2.6838F, -1.0263F);
		bow.addChild(arm2);
		setRotationAngle(arm2, 0.5672F, 0.0F, 0.0F);
		arm2.setTextureOffset(0, 49).addBox(0.0005F, -0.0933F, -2.6868F, 0.0F, 23.0F, 5.0F, 0.0F, false);
		arm2.setTextureOffset(11, 49).addBox(-1.4995F, -2.0933F, -3.6868F, 3.0F, 18.0F, 4.0F, 0.0F, false);
		arm2.setTextureOffset(73, 11).addBox(-1.4995F, -4.0933F, -10.6868F, 3.0F, 4.0F, 7.0F, 0.0F, false);
		arm2.setTextureOffset(11, 77).addBox(-1.4995F, 3.9067F, -3.6868F, 3.0F, 4.0F, 4.0F, 0.3F, false);

		bow_string = new AdvancedModelBox(this);
		bow_string.setRotationPoint(-0.0005F, -1.5F, 10.0F);
		bow.addChild(bow_string);


		string = new AdvancedModelBox(this);
		string.setRotationPoint(0.5005F, 0.0F, 0.0F);
		bow_string.addChild(string);
		string.setTextureOffset(0, 22).addBox(-1.001F, 0.0859F, -0.2263F, 1.0F, 19.0F, 0.0F, 0.0F, false);

		string2 = new AdvancedModelBox(this);
		string2.setRotationPoint(-0.4995F, 0.0F, -0.0485F);
		bow_string.addChild(string2);
		string2.setTextureOffset(17, 0).addBox(-0.001F, -18.9142F, -0.1778F, 1.0F, 19.0F, 0.0F, 0.0F, false);

		arrow1 = new AdvancedModelBox(this);
		arrow1.setRotationPoint(0.3536F, -1.4356F, 0.2737F);
		bow_string.addChild(arrow1);
		setRotationAngle(arrow1, -0.0436F, 0.0F, 0.0F);


		arrow_pivot1 = new AdvancedModelBox(this);
		arrow_pivot1.setRotationPoint(0.0F, 0.0F, 0.0F);
		arrow1.addChild(arrow_pivot1);
		setRotationAngle(arrow_pivot1, 0.0F, 0.0F, -0.7854F);
		arrow_pivot1.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -20.0F, 5.0F, 0.0F, 21.0F, 0.0F, false);
		arrow_pivot1.setTextureOffset(0, 22).addBox(-0.5F, -2.5F, -20.0F, 0.0F, 5.0F, 21.0F, 0.0F, false);
		arrow_pivot1.setTextureOffset(3, 22).addBox(-3.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, 0.0F, false);

		first_sand3 = new AdvancedModelBox(this);
		first_sand3.setRotationPoint(-0.5F, 0.0F, -12.0F);
		arrow_pivot1.addChild(first_sand3);
		setRotationAngle(first_sand3, 0.0F, 0.0F, -1.0036F);
		first_sand3.setTextureOffset(0, 107).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		first_sand2 = new AdvancedModelBox(this);
		first_sand2.setRotationPoint(0.0F, 0.0F, -3.0F);
		first_sand3.addChild(first_sand2);
		setRotationAngle(first_sand2, 0.0F, 0.0F, -0.48F);
		first_sand2.setTextureOffset(0, 112).addBox(-2.5F, -2.5F, -1.0F, 5.0F, 5.0F, 2.0F, 0.0F, false);

		first_sand1 = new AdvancedModelBox(this);
		first_sand1.setRotationPoint(0.0F, 0.0F, -4.0F);
		first_sand2.addChild(first_sand1);
		first_sand1.setTextureOffset(0, 119).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		arrow2 = new AdvancedModelBox(this);
		arrow2.setRotationPoint(0.3536F, -1.4356F, 0.2737F);
		bow_string.addChild(arrow2);
		setRotationAngle(arrow2, 0.0873F, 0.0873F, 0.0F);


		arrow_pivot2 = new AdvancedModelBox(this);
		arrow_pivot2.setRotationPoint(0.0F, 0.0F, 0.0F);
		arrow2.addChild(arrow_pivot2);
		setRotationAngle(arrow_pivot2, 0.0F, 0.0F, -0.7854F);
		arrow_pivot2.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -20.0F, 5.0F, 0.0F, 21.0F, 0.0F, false);
		arrow_pivot2.setTextureOffset(0, 22).addBox(-0.5F, -2.5F, -20.0F, 0.0F, 5.0F, 21.0F, 0.0F, false);
		arrow_pivot2.setTextureOffset(3, 22).addBox(-3.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, 0.0F, false);

		second_sand3 = new AdvancedModelBox(this);
		second_sand3.setRotationPoint(-0.5F, 0.0F, -12.0F);
		arrow_pivot2.addChild(second_sand3);
		setRotationAngle(second_sand3, 0.0F, 0.0F, -1.0036F);
		second_sand3.setTextureOffset(0, 107).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		second_sand2 = new AdvancedModelBox(this);
		second_sand2.setRotationPoint(0.0F, 0.0F, -3.0F);
		second_sand3.addChild(second_sand2);
		setRotationAngle(second_sand2, 0.0F, 0.0F, -0.48F);
		second_sand2.setTextureOffset(0, 112).addBox(-2.5F, -2.5F, -1.0F, 5.0F, 5.0F, 2.0F, 0.0F, false);

		second_sand1 = new AdvancedModelBox(this);
		second_sand1.setRotationPoint(0.0F, 0.0F, -4.0F);
		second_sand2.addChild(second_sand1);
		second_sand1.setTextureOffset(0, 119).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		arrow3 = new AdvancedModelBox(this);
		arrow3.setRotationPoint(0.3536F, -1.4356F, 0.2737F);
		bow_string.addChild(arrow3);
		setRotationAngle(arrow3, 0.0873F, -0.0873F, 0.0F);


		arrow_pivot3 = new AdvancedModelBox(this);
		arrow_pivot3.setRotationPoint(0.0F, 0.0F, 0.0F);
		arrow3.addChild(arrow_pivot3);
		setRotationAngle(arrow_pivot3, 0.0F, 0.0F, -0.7854F);
		arrow_pivot3.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -20.0F, 5.0F, 0.0F, 21.0F, 0.0F, false);
		arrow_pivot3.setTextureOffset(0, 22).addBox(-0.5F, -2.5F, -20.0F, 0.0F, 5.0F, 21.0F, 0.0F, false);
		arrow_pivot3.setTextureOffset(3, 22).addBox(-3.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, 0.0F, false);

		third_sand3 = new AdvancedModelBox(this);
		third_sand3.setRotationPoint(-0.5F, 0.0F, -12.0F);
		arrow_pivot3.addChild(third_sand3);
		setRotationAngle(third_sand3, 0.0F, 0.0F, -1.0036F);
		third_sand3.setTextureOffset(0, 107).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		third_sand2 = new AdvancedModelBox(this);
		third_sand2.setRotationPoint(0.0F, 0.0F, -3.0F);
		third_sand3.addChild(third_sand2);
		setRotationAngle(third_sand2, 0.0F, 0.0F, -0.48F);
		third_sand2.setTextureOffset(0, 112).addBox(-2.5F, -2.5F, -1.0F, 5.0F, 5.0F, 2.0F, 0.0F, false);

		third_sand1 = new AdvancedModelBox(this);
		third_sand1.setRotationPoint(0.0F, 0.0F, -4.0F);
		third_sand2.addChild(third_sand1);
		third_sand1.setTextureOffset(0, 119).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 2.0F, 0.0F, false);
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
		this.bow_string.rotationPointZ += pullAmount * 9;
		float scale = pullAmount * 1.2F;
		arrow_pivot1.setScale(scale, scale, scale);
		arrow_pivot2.setScale(scale, scale, scale);
		arrow_pivot3.setScale(scale, scale, scale);
		first_sand3.setScale(scale, scale, scale);
		second_sand3.setScale(scale, scale, scale);
		third_sand3.setScale(scale, scale, scale);

		first_sand2.setScale(scale, scale, scale);
		second_sand2.setScale(scale, scale, scale);
		third_sand2.setScale(scale, scale, scale);

		first_sand1.setScale(scale, scale, scale);
		second_sand1.setScale(scale, scale, scale);
		third_sand1.setScale(scale, scale, scale);

		this.string2.rotateAngleX += (float) Math.toRadians(pullAmount * 25);
		this.string.rotateAngleX += (float) Math.toRadians(pullAmount * -25);
		this.arm1.rotateAngleX += (float) Math.toRadians(pullAmount * -15);
		this.arm2.rotateAngleX += (float) Math.toRadians(pullAmount * 15);


		first_sand3.rotateAngleZ += ageInTicks * 0.7F;
		first_sand2.rotateAngleZ += -first_sand3.rotateAngleZ + ageInTicks * 0.5F;
		first_sand1.rotateAngleZ += -first_sand3.rotateAngleZ -first_sand2.rotateAngleZ + ageInTicks * 0.3F;

		second_sand3.rotateAngleZ += ageInTicks * 0.7F;
		second_sand2.rotateAngleZ += -second_sand3.rotateAngleZ + ageInTicks * 0.5F;
		second_sand1.rotateAngleZ += -second_sand3.rotateAngleZ -second_sand2.rotateAngleZ + ageInTicks * 0.3F;

		third_sand3.rotateAngleZ += ageInTicks * 0.7F;
		third_sand2.rotateAngleZ += -third_sand3.rotateAngleZ + ageInTicks * 0.5F;
		third_sand1.rotateAngleZ += -third_sand3.rotateAngleZ -third_sand2.rotateAngleZ + ageInTicks * 0.3F;

	}


	public void animateStack(ItemStack itemStackIn) {

	}


	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				bow,
				bow_r1,
				arm1,
				cube_r8_r1,
				arm2,
				bow_string,
				string,
				string2,
				arrow3,
				arrow_pivot3,
				third_sand3,
				third_sand2,
				third_sand1,
				arrow2,
				arrow_pivot2,
				second_sand3,
				second_sand2,
				second_sand1,
				arrow1,
				arrow_pivot1,
				first_sand3,
				first_sand2,
				first_sand1);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}