package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Coralssus_Animation;
import com.github.L_Ender.cataclysm.client.animation.Wadjet_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Wadjet_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.github.L_Ender.lionfishapi.client.model.tools.DynamicChain;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.WalkAnimationState;

public class ModelWadjet extends AdvancedEntityModel<Wadjet_Entity> {
	private final AdvancedModelBox everything;
	private final AdvancedModelBox mid_root;
	private final AdvancedModelBox upper_body1;
	private final AdvancedModelBox pelvis;
	private final AdvancedModelBox upper_body2;
	private final AdvancedModelBox body;
	private final AdvancedModelBox neck1;
	private final AdvancedModelBox neck2;
	private final AdvancedModelBox face;
	private final AdvancedModelBox head;
	private final AdvancedModelBox cube_r1;
	private final AdvancedModelBox cube_r2;
	private final AdvancedModelBox cube_r3;
	private final AdvancedModelBox cube_r4;
	private final AdvancedModelBox jaw;
	private final AdvancedModelBox right_arm;
	private final AdvancedModelBox right_fore_arm;
	private final AdvancedModelBox right_finger3;
	private final AdvancedModelBox right_finger2;
	private final AdvancedModelBox right_finger1;
	private final AdvancedModelBox right_finger4;
	private final AdvancedModelBox wand;
	private final AdvancedModelBox cube_r5;
	private final AdvancedModelBox left_arm;
	private final AdvancedModelBox left_fore_arm;
	private final AdvancedModelBox left_finger3;
	private final AdvancedModelBox left_finger2;
	private final AdvancedModelBox left_finger1;
	private final AdvancedModelBox left_finger4;
	private final AdvancedModelBox tail1;
	private final AdvancedModelBox tail2;
	private final AdvancedModelBox tail3;
	private final AdvancedModelBox tail4;
	private final AdvancedModelBox tail5;
	private final AdvancedModelBox tailend;

	private DynamicChain tail;

	public AdvancedModelBox[] tailOriginal;
	public AdvancedModelBox[] tailDynamic;

	public ModelWadjet() {
		texWidth = 256;
		texHeight = 256;


		everything = new AdvancedModelBox(this,"everything");
		everything.setRotationPoint(0.0F, 18.1769F, -2.6276F);


		mid_root = new AdvancedModelBox(this,"mid_root");
		mid_root.setRotationPoint(0.0F, 5.8231F, 2.6276F);
		everything.addChild(mid_root);


		upper_body1 = new AdvancedModelBox(this,"upper_body1");
		upper_body1.setRotationPoint(0.0F, -4.8231F, -0.6276F);
		mid_root.addChild(upper_body1);
		setRotationAngle(upper_body1, -0.2618F, 0.0F, 0.0F);
		upper_body1.setTextureOffset(0, 63).addBox(-5.5F, -17.8375F, -3.68F, 11.0F, 20.0F, 6.0F, 0.0F, false);

		pelvis = new AdvancedModelBox(this,"pelvis");
		pelvis.setRotationPoint(-0.0798F, -17.8375F, 2.02F);
		upper_body1.addChild(pelvis);
		setRotationAngle(pelvis, 0.5716F, 0.0F, 0.0F);
		pelvis.setTextureOffset(0, 47).addBox(-4.5076F, -3.0225F, -5.0839F, 9.0F, 4.0F, 6.0F, 0.0F, false);

		upper_body2 = new AdvancedModelBox(this,"upper_body2");
		upper_body2.setRotationPoint(-0.0076F, -2.9878F, 0.5324F);
		pelvis.addChild(upper_body2);
		setRotationAngle(upper_body2, -0.1814F, 0.0F, 0.0F);
		upper_body2.setTextureOffset(79, 63).addBox(-8.5403F, -15.7808F, -5.6395F, 17.0F, 7.2F, 8.0F, 0.0F, false);
		upper_body2.setTextureOffset(37, 0).addBox(-3.5403F, -13.7808F, -3.6395F, 7.0F, 14.2F, 4.0F, 0.0F, false);

		body = new AdvancedModelBox(this,"body");
		body.setRotationPoint(0.0492F, -6.6808F, 0.7605F);
		upper_body2.addChild(body);
		setRotationAngle(body, 0.0429F, 0.0F, 0.0F);
		

		neck1 = new AdvancedModelBox(this,"neck1");
		neck1.setRotationPoint(0.0F, -8.5F, 0.0F);
		body.addChild(neck1);
		setRotationAngle(neck1, -0.2593F, 0.0F, 0.0F);
		neck1.setTextureOffset(112, 79).addBox(-4.3316F, -7.2976F, 0.0584F, 9.0F, 8.0F, 0.0F, 0.0F, false);
		neck1.setTextureOffset(0, 0).addBox(-2.3316F, -7.3252F, -3.9267F, 5.0F, 8.0F, 4.0F, 0.0F, false);

		neck2 = new AdvancedModelBox(this,"neck2");
		neck2.setRotationPoint(0.3579F, -7.4995F, 1.0809F);
		neck1.addChild(neck2);
		setRotationAngle(neck2, 0.7854F, 0.0F, 0.0F);
		neck2.setTextureOffset(38, 63).addBox(-2.1895F, -8.4892F, -4.7357F, 4.0F, 8.0F, 4.0F, -0.1F, false);
		neck2.setTextureOffset(31, 26).addBox(-7.1895F, -7.5444F, -0.8563F, 14.0F, 9.0F, 0.0F, 0.0F, false);

		face = new AdvancedModelBox(this,"face");
		face.setRotationPoint(-0.0895F, -6.8719F, -1.2524F);
		neck2.addChild(face);


		head = new AdvancedModelBox(this,"head");
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		face.addChild(head);
		setRotationAngle(head, -0.4363F, 0.0F, 0.0F);


		cube_r1 = new AdvancedModelBox(this);
		cube_r1.setRotationPoint(-1.6F, 8.0116F, -1.3235F);
		head.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.1745F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(103, 0).addBox(-1.0F, -9.9F, -3.0F, 5.0F, 3.0F, 6.0F, 0.0F, false);

		cube_r2 = new AdvancedModelBox(this);
		cube_r2.setRotationPoint(1.4F, 1.0116F, -6.3235F);
		head.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.7195F, 0.4166F, 0.2315F);
		cube_r2.setTextureOffset(31, 47).addBox(-2.2863F, -1.9404F, -0.9425F, 3.0F, 3.0F, 8.0F, 0.0F, false);

		cube_r3 = new AdvancedModelBox(this);
		cube_r3.setRotationPoint(-1.6F, 1.0116F, -6.3235F);
		head.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.7195F, -0.4166F, -0.2315F);
		cube_r3.setTextureOffset(99, 99).addBox(-0.7137F, -1.9404F, -0.9425F, 3.0F, 3.0F, 8.0F, 0.0F, false);

		cube_r4 = new AdvancedModelBox(this);
		cube_r4.setRotationPoint(-1.1F, 8.0116F, -1.3235F);
		head.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.3491F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(103, 20).addBox(-1.0F, -10.0F, -4.8F, 4.0F, 3.0F, 5.0F, 0.0F, false);

		jaw = new AdvancedModelBox(this,"jaw");
		jaw.setRotationPoint(0.5895F, 0.9632F, -2.4564F);
		head.addChild(jaw);
		setRotationAngle(jaw, 0.3927F, 0.0F, 0.0F);
		jaw.setTextureOffset(103, 10).addBox(-2.1895F, -1.0797F, -6.0886F, 3.0F, 2.0F, 7.0F, 0.0F, false);

		right_arm = new AdvancedModelBox(this,"right_arm");
		right_arm.setRotationPoint(-4.3F, -5.8F, -2.4F);
		body.addChild(right_arm);
		setRotationAngle(right_arm, 0.0F, 0.5672F, -1.2654F);
		right_arm.setTextureOffset(65, 25).addBox(-10.2F, -1.9395F, -1.9186F, 11.0F, 4.0F, 4.0F, 0.0F, false);

		right_fore_arm = new AdvancedModelBox(this,"right_fore_arm");
		right_fore_arm.setRotationPoint(-10.2F, -1.475F, 0.0F);
		right_arm.addChild(right_fore_arm);
		setRotationAngle(right_fore_arm, 0.0F, -0.6545F, 0.0F);
		right_fore_arm.setTextureOffset(0, 90).addBox(-11.0F, -0.4395F, -1.9186F, 11.0F, 3.0F, 4.0F, 0.0F, false);
		right_fore_arm.setTextureOffset(65, 0).addBox(-12.0F, -0.9395F, -2.4186F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		right_finger3 = new AdvancedModelBox(this,"right_finger3");
		right_finger3.setRotationPoint(-11.0F, 1.1F, -2.3F);
		right_fore_arm.addChild(right_finger3);
		right_finger3.setTextureOffset(0, 35).addBox(-6.0211F, -0.936F, 0.3767F, 6.0F, 2.0F, 0.0F, 0.0F, false);

		right_finger2 = new AdvancedModelBox(this,"right_finger2");
		right_finger2.setRotationPoint(-11.0F, 1.1F, -0.3F);
		right_fore_arm.addChild(right_finger2);
		right_finger2.setTextureOffset(31, 36).addBox(-6.0211F, -0.936F, 0.3767F, 6.0F, 2.0F, 0.0F, 0.0F, false);

		right_finger1 = new AdvancedModelBox(this,"right_finger1");
		right_finger1.setRotationPoint(-11.0F, 1.1F, 1.7F);
		right_fore_arm.addChild(right_finger1);
		right_finger1.setTextureOffset(0, 38).addBox(-6.0211F, -0.936F, 0.3767F, 6.0F, 2.0F, 0.0F, 0.0F, false);

		right_finger4 = new AdvancedModelBox(this,"right_finger4");
		right_finger4.setRotationPoint(-10.0F, 2.5F, -2.7F);
		right_fore_arm.addChild(right_finger4);
		right_finger4.setTextureOffset(0, 16).addBox(-5.0211F, 0.164F, -0.7233F, 6.0F, 0.0F, 2.0F, 0.0F, false);

		wand = new AdvancedModelBox(this,"wand");
		wand.setRotationPoint(-13.0F, 1.0F, 0.0F);
		right_fore_arm.addChild(wand);
		wand.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -25.0F, 2.0F, 2.0F, 60.0F, 0.0F, false);
		wand.setTextureOffset(65, 0).addBox(0.0F, -7.0F, -45.0F, 0.0F, 16.0F, 37.0F, 0.0F, false);

		cube_r5 = new AdvancedModelBox(this);
		cube_r5.setRotationPoint(13.0F, -1.0F, 0.0F);
		wand.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -1.5708F);
		cube_r5.setTextureOffset(0, 63).addBox(-2.0F, -20.0F, -45.0F, 0.0F, 16.0F, 37.0F, 0.0F, false);

		left_arm = new AdvancedModelBox(this,"left_arm");
		left_arm.setRotationPoint(4.121F, -5.8F, -2.4F);
		body.addChild(left_arm);
		setRotationAngle(left_arm, 0.0F, -0.2618F, 1.2654F);
		left_arm.setTextureOffset(65, 16).addBox(-0.8F, -1.9395F, -1.9186F, 11.0F, 4.0F, 4.0F, 0.0F, false);

		left_fore_arm = new AdvancedModelBox(this,"left_fore_arm");
		left_fore_arm.setRotationPoint(10.2F, -1.475F, 0.0F);
		left_arm.addChild(left_fore_arm);
		setRotationAngle(left_fore_arm, 0.0F, 0.6545F, 0.0F);
		left_fore_arm.setTextureOffset(38, 90).addBox(0.0F, -0.4395F, -1.9186F, 11.0F, 3.0F, 4.0F, 0.0F, false);
		left_fore_arm.setTextureOffset(65, 8).addBox(1.0F, -0.9395F, -2.4186F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		left_finger3 = new AdvancedModelBox(this,"left_finger3");
		left_finger3.setRotationPoint(11.0F, 1.1F, -2.3F);
		left_fore_arm.addChild(left_finger3);
		left_finger3.setTextureOffset(0, 32).addBox(0.0211F, -0.936F, 0.3767F, 6.0F, 2.0F, 0.0F, 0.0F, false);

		left_finger2 = new AdvancedModelBox(this,"left_finger2");
		left_finger2.setRotationPoint(11.0F, 1.1F, -0.3F);
		left_fore_arm.addChild(left_finger2);
		left_finger2.setTextureOffset(0, 29).addBox(0.0211F, -0.936F, 0.3767F, 6.0F, 2.0F, 0.0F, 0.0F, false);

		left_finger1 = new AdvancedModelBox(this,"left_finger1");
		left_finger1.setRotationPoint(11.0F, 1.1F, 1.7F);
		left_fore_arm.addChild(left_finger1);
		left_finger1.setTextureOffset(0, 26).addBox(0.0211F, -0.936F, 0.3767F, 6.0F, 2.0F, 0.0F, 0.0F, false);

		left_finger4 = new AdvancedModelBox(this,"left_finger4");
		left_finger4.setRotationPoint(10.0F, 2.5F, -2.7F);
		left_fore_arm.addChild(left_finger4);
		left_finger4.setTextureOffset(0, 13).addBox(-0.9789F, 0.164F, -0.7233F, 6.0F, 0.0F, 2.0F, 0.0F, false);

		tail1 = new AdvancedModelBox(this,"tail1");
		tail1.setRotationPoint(0.0F, -3.0F, -2.0F);
		everything.addChild(tail1);
		tail1.setTextureOffset(38, 63).addBox(-5.0F, -3.0F, 0.0F, 10.0F, 6.0F, 20.0F, 0.0F, false);

		tail2 = new AdvancedModelBox(this,"tail2");
		tail2.setRotationPoint(0.0F, 0.5F, 18.0F);
		tail1.addChild(tail2);
		tail2.setTextureOffset(0, 0).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 5.0F, 20.0F, 0.0F, false);

		tail3 = new AdvancedModelBox(this,"tail3");
		tail3.setRotationPoint(0.0F, 0.5F, 18.0F);
		tail2.addChild(tail3);
		tail3.setTextureOffset(0, 26).addBox(-3.5F, -2.0F, 0.0F, 7.0F, 4.0F, 16.0F, 0.0F, false);

		tail4 = new AdvancedModelBox(this,"tail4");
		tail4.setRotationPoint(-0.5F, 1.0F, 15.0F);
		tail3.addChild(tail4);
		tail4.setTextureOffset(83, 79).addBox(-2.5F, -2.0F, 0.0F, 6.0F, 3.0F, 16.0F, 0.0F, false);

		tail5 = new AdvancedModelBox(this,"tail5");
		tail5.setRotationPoint(0.5F, 0.0F, 15.0F);
		tail4.addChild(tail5);
		tail5.setTextureOffset(75, 99).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 15.0F, 0.0F, false);

		tailend = new AdvancedModelBox(this,"tailend");
		tailend.setRotationPoint(0.0F, 0.0F, 15.0F);
		tail5.addChild(tailend);
		updateDefaultPose();

		tailOriginal = new AdvancedModelBox[]{tail1, tail2, tail3, tail4, tail5, tailend};
		tailDynamic = new AdvancedModelBox[tailOriginal.length];

	}

	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		this.everything.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		if (tail != null) tail.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha, tailDynamic);
		for (AdvancedModelBox AdvancedModelBox : tailOriginal) {
			AdvancedModelBox.showModel = false;
		}
	}

	@Override
	public void setupAnim(Wadjet_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		tail = entity.dc;
		entity.dc.updateChain(Minecraft.getInstance().getFrameTime(), tailOriginal, tailDynamic, 0.4f, 1.5f, 1.8f, 0.87f, 20, true);

		this.resetToDefaultPose();
		float swimSpeed = 0.1F;
		float swimDegree = 0.5F;
		float partialTick = Minecraft.getInstance().getFrameTime();
		float attackProgress = entity.getAttackProgress(partialTick);
		float attackAmount = attackProgress * limbSwingAmount * 1.5F;

		this.animateHeadLookTarget(netHeadYaw, headPitch);
		this.animateWalk(Wadjet_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 1.0F);
		progressRotationPrev(upper_body1,attackAmount,(float)Math.toRadians(23.1591F), 0, 0, 10F);
		this.animate(entity.getAnimationState("idle"), Wadjet_Animation.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("sleep"), Wadjet_Animation.SLEEP, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("awake"), Wadjet_Animation.AWAKE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("charge"), Wadjet_Animation.SPEAR_CHARGE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("magic"), Wadjet_Animation.MAGIC, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("death"), Wadjet_Animation.DEATH, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("doubleswing"), Wadjet_Animation.DOUBLE_SWING, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("stabnswing"), Wadjet_Animation.STAB_N_SWING, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("block"), Wadjet_Animation.BLOCK, ageInTicks, 1.0F);
		this.chainSwing(tailOriginal, swimSpeed * 4F, swimDegree * 1F, -3, limbSwing,limbSwingAmount);
		this.chainSwing(tailOriginal, swimSpeed * 0.6F, swimDegree * 0.15F, -3, ageInTicks,1.0F);

	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		float yawAmount = yRot / 57.295776F;
		float pitchAmount = xRot / 57.295776F;
		this.neck2.rotateAngleX += pitchAmount * 0.5F;
		this.neck2.rotateAngleY += yawAmount * 0.5F;
		this.face.rotateAngleX += pitchAmount * 0.5F;
		this.face.rotateAngleY += yawAmount * 0.5F;

	}

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(everything);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				everything,
				upper_body1,
				mid_root,
				pelvis,
				upper_body2,
				body,
				neck1,
				neck2,
				face,
				head,
				cube_r1,
				cube_r2,
				cube_r3,
				cube_r4,
				jaw,
				right_arm,
				right_fore_arm,
				right_finger3,
				right_finger2,
				right_finger1,
				right_finger4,
				wand,
				cube_r5,
				left_arm,
				left_fore_arm,
				left_finger3,
				left_finger2,
				left_finger1,
				left_finger4,
				tail1,
				tail2,
				tail3,
				tail4,
				tail5,
				tailend);
	}
}