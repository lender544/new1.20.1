package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.0
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


public class Elite_Draugr_Model extends EntityModel<Entity> {
	private final ModelRenderer roots;
	private final ModelRenderer body;
	private final ModelRenderer front_cloth1;
	private final ModelRenderer front_cloth2;
	private final ModelRenderer back_cloth1;
	private final ModelRenderer back_cloth2;
	private final ModelRenderer waist;
	private final ModelRenderer chest;
	private final ModelRenderer neck;
	private final ModelRenderer head;
	private final ModelRenderer maw;
	private final ModelRenderer l_arm;
	private final ModelRenderer cube_r1;
	private final ModelRenderer l_arm2;
	private final ModelRenderer r_arm;
	private final ModelRenderer cube_r2;
	private final ModelRenderer r_arm2;
	private final ModelRenderer right_leg;
	private final ModelRenderer left_leg;

	public Elite_Draugr_Model() {
		textureWidth = 128;
		textureHeight = 128;

		roots = new ModelRenderer(this);
		roots.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -12.0F, 0.0F);
		roots.addChild(body);
		body.setTextureOffset(52, 0).addBox(-5.0F, -4.0F, -2.0F, 10.0F, 4.0F, 4.0F, 0.0F, false);

		front_cloth1 = new ModelRenderer(this);
		front_cloth1.setRotationPoint(0.0F, 0.0F, -2.0F);
		body.addChild(front_cloth1);
		setRotationAngle(front_cloth1, -0.0436F, 0.0F, 0.0F);
		front_cloth1.setTextureOffset(60, 8).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, 0.0F, false);

		front_cloth2 = new ModelRenderer(this);
		front_cloth2.setRotationPoint(0.0F, 4.0F, 0.0F);
		front_cloth1.addChild(front_cloth2);
		setRotationAngle(front_cloth2, 0.0873F, 0.0F, 0.0F);
		front_cloth2.setTextureOffset(56, 44).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, 0.0F, false);

		back_cloth1 = new ModelRenderer(this);
		back_cloth1.setRotationPoint(0.0F, 0.0F, 2.0F);
		body.addChild(back_cloth1);
		setRotationAngle(back_cloth1, 0.0873F, 0.0F, 0.0F);
		back_cloth1.setTextureOffset(38, 16).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, 0.0F, false);

		back_cloth2 = new ModelRenderer(this);
		back_cloth2.setRotationPoint(0.0F, 4.0F, 0.0F);
		back_cloth1.addChild(back_cloth2);
		back_cloth2.setTextureOffset(0, 18).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, 0.0F, false);

		waist = new ModelRenderer(this);
		waist.setRotationPoint(0.0F, -4.0F, 1.0F);
		body.addChild(waist);
		waist.setTextureOffset(80, 50).addBox(-1.5F, -8.0F, -1.0F, 3.0F, 8.0F, 2.0F, 0.0F, false);

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, -8.0F, 0.0F);
		waist.addChild(chest);
		chest.setTextureOffset(80, 60).addBox(-1.5F, -8.0F, -1.0F, 3.0F, 8.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(32, 50).addBox(-6.0F, -8.0F, -4.0F, 12.0F, 10.0F, 4.0F, 0.0F, false);
		chest.setTextureOffset(96, 0).addBox(-6.0F, -8.0F, -4.0F, 12.0F, 10.0F, 4.0F, 0.1F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, -8.0F, 0.0F);
		chest.addChild(neck);
		neck.setTextureOffset(16, 18).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -2.0F, -1.0F);
		neck.addChild(head);
		head.setTextureOffset(0, 48).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(96, 112).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.1F, false);
		head.setTextureOffset(0, 64).addBox(-11.0F, -15.0F, 0.0F, 9.0F, 11.0F, 0.0F, 0.0F, false);
		head.setTextureOffset(80, 0).addBox(4.0F, -12.0F, 0.0F, 6.0F, 8.0F, 0.0F, 0.0F, false);
		head.setTextureOffset(28, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.4F, false);

		maw = new ModelRenderer(this);
		maw.setRotationPoint(0.5F, 0.5F, -3.0F);
		head.addChild(maw);
		setRotationAngle(maw, 0.2102F, 0.0504F, -0.3014F);
		maw.setTextureOffset(60, 60).addBox(-3.0F, -2.5F, -2.0F, 6.0F, 5.0F, 4.0F, 0.0F, false);

		l_arm = new ModelRenderer(this);
		l_arm.setRotationPoint(7.0F, -6.0F, -1.0F);
		chest.addChild(l_arm);
		l_arm.setTextureOffset(72, 32).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		l_arm.setTextureOffset(26, 76).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.3F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.5F, -2.0F, 0.0F);
		l_arm.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.2618F);
		cube_r1.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, -2.5F, 6.0F, 4.0F, 5.0F, 0.0F, false);

		l_arm2 = new ModelRenderer(this);
		l_arm2.setRotationPoint(0.0F, 6.0F, 0.0F);
		l_arm.addChild(l_arm2);
		l_arm2.setTextureOffset(52, 69).addBox(-2.0F, 2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.2F, false);
		l_arm2.setTextureOffset(68, 69).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, true);

		r_arm = new ModelRenderer(this);
		r_arm.setRotationPoint(-7.0F, -6.0F, -1.0F);
		chest.addChild(r_arm);
		r_arm.setTextureOffset(72, 20).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		r_arm.setTextureOffset(64, 50).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.3F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-0.5F, -2.0F, 0.0F);
		r_arm.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.2618F);
		cube_r2.setTextureOffset(0, 12).addBox(-4.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(17, 11).addBox(-5.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(17, 9).addBox(0.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 9).addBox(-2.0F, -4.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 9).addBox(-3.0F, -2.0F, -2.5F, 6.0F, 4.0F, 5.0F, 0.0F, false);

		r_arm2 = new ModelRenderer(this);
		r_arm2.setRotationPoint(0.0F, 6.0F, 0.0F);
		r_arm.addChild(r_arm2);
		r_arm2.setTextureOffset(68, 69).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		r_arm2.setTextureOffset(36, 64).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.2F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-3.0F, -12.0F, 0.0F);
		roots.addChild(right_leg);
		right_leg.setTextureOffset(56, 28).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(3.0F, -12.0F, 0.0F);
		roots.addChild(left_leg);
		left_leg.setTextureOffset(56, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		roots.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}