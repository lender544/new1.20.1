package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.Pet.The_Baby_Leviathan_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class The_Baby_Leviathan_Model extends AdvancedEntityModel<The_Baby_Leviathan_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox body;
	private final AdvancedModelBox main_belly;
	private final AdvancedModelBox r_tentacle;
	private final AdvancedModelBox r_tentacle2;
	private final AdvancedModelBox r_hook1;
	private final AdvancedModelBox r_hook4;
	private final AdvancedModelBox r_hook2;
	private final AdvancedModelBox r_hook3;
	private final AdvancedModelBox l_tentacle;
	private final AdvancedModelBox l_tentacle2;
	private final AdvancedModelBox l_hook1;
	private final AdvancedModelBox l_hook2;
	private final AdvancedModelBox l_hook3;
	private final AdvancedModelBox l_hook4;
	private final AdvancedModelBox belly;
	private final AdvancedModelBox r_down_fin;
	private final AdvancedModelBox l_down_fin;
	private final AdvancedModelBox tail;
	private final AdvancedModelBox tail_back;
	private final AdvancedModelBox r_spike2;
	private final AdvancedModelBox l_spike2;
	private final AdvancedModelBox head;
	private final AdvancedModelBox maw;
	private final AdvancedModelBox skul;
	private final AdvancedModelBox main_mouth;
	private final AdvancedModelBox mouth1;
	private final AdvancedModelBox mouth1_e;
	private final AdvancedModelBox mouth2;
	private final AdvancedModelBox mouth2_e;
	private final AdvancedModelBox mouth3;
	private final AdvancedModelBox mouth3_e;
	private final AdvancedModelBox mouth4;
	private final AdvancedModelBox mouth4_e;
	private final AdvancedModelBox r_fin;
	private final AdvancedModelBox l_fin;
	private final AdvancedModelBox r_spike1;
	private final AdvancedModelBox l_spike1;
	private ModelAnimator animator;

	public The_Baby_Leviathan_Model() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, -2.4F, -5.9F);
		root.addChild(head);


		maw = new AdvancedModelBox(this);
		maw.setRotationPoint(0.0F, 0.75F, 0.0F);
		head.addChild(maw);
		maw.setTextureOffset(34, 20).addBox(-1.5F, -1.15F, -3.1F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		maw.setTextureOffset(10, 0).addBox(-1.5F, -0.15F, -3.1F, 3.0F, 0.0F, 3.0F, 0.0F, false);
		maw.setTextureOffset(10, 4).addBox(-1.0F, -1.05F, -3.9F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		maw.setTextureOffset(0, 7).addBox(-1.0F, -0.05F, -3.9F, 2.0F, 0.0F, 1.0F, 0.0F, false);

		skul = new AdvancedModelBox(this);
		skul.setRotationPoint(0.0F, -1.1F, -0.1F);
		head.addChild(skul);
		skul.setTextureOffset(6, 28).addBox(-1.0F, -1.0F, -3.8F, 2.0F, 2.0F, 1.0F, -0.1F, false);
		skul.setTextureOffset(34, 26).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 2.0F, 3.0F, -0.1F, false);

		main_mouth = new AdvancedModelBox(this);
		main_mouth.setRotationPoint(0.0F, -0.1F, -0.1F);
		head.addChild(main_mouth);


		mouth1 = new AdvancedModelBox(this);
		mouth1.setRotationPoint(-1.5F, 0.9064F, 0.0717F);
		main_mouth.addChild(mouth1);
		setRotationAngle(mouth1, 0.0F, 0.0F, 0.0F);
		mouth1.setTextureOffset(11, 31).addBox(-1.5F, -0.9064F, -3.0717F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		mouth1_e = new AdvancedModelBox(this);
		mouth1_e.setRotationPoint(0.0F, 1.0936F, -3.0717F);
		mouth1.addChild(mouth1_e);
		setRotationAngle(mouth1_e, -0.0873F, 0.0F, 0.0F);
		mouth1_e.setTextureOffset(0, 17).addBox(-1.51F, -2.01F, -3.01F, 3.0F, 2.0F, 3.0F, 0.01F, false);

		mouth2 = new AdvancedModelBox(this);
		mouth2.setRotationPoint(1.5F, 0.9064F, 0.0717F);
		main_mouth.addChild(mouth2);
		setRotationAngle(mouth2, 0.0F, 0.0F, 0.0F);
		mouth2.setTextureOffset(11, 31).addBox(-1.5F, -0.9064F, -3.0717F, 3.0F, 2.0F, 3.0F, 0.0F, true);

		mouth2_e = new AdvancedModelBox(this);
		mouth2_e.setRotationPoint(0.0F, 1.0936F, -3.0717F);
		mouth2.addChild(mouth2_e);
		setRotationAngle(mouth2_e, -0.0873F, 0.0F, 0.0F);
		mouth2_e.setTextureOffset(0, 17).addBox(-1.49F, -2.01F, -3.01F, 3.0F, 2.0F, 3.0F, 0.01F, true);

		mouth3 = new AdvancedModelBox(this);
		mouth3.setRotationPoint(-1.5F, -0.9064F, 0.0717F);
		main_mouth.addChild(mouth3);
		mouth3.setTextureOffset(32, 10).addBox(-1.5F, -1.0936F, -3.0717F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		mouth3_e = new AdvancedModelBox(this);
		mouth3_e.setRotationPoint(0.0F, -1.0936F, -3.0717F);
		mouth3.addChild(mouth3_e);
		setRotationAngle(mouth3_e, 0.0873F, 0.0F, 0.0F);
		mouth3_e.setTextureOffset(24, 31).addBox(-1.515F, 0.015F, -3.015F, 3.0F, 2.0F, 3.0F, 0.015F, false);

		mouth4 = new AdvancedModelBox(this);
		mouth4.setRotationPoint(1.5F, -0.9064F, 0.0717F);
		main_mouth.addChild(mouth4);
		mouth4.setTextureOffset(32, 10).addBox(-1.5F, -1.0936F, -3.0717F, 3.0F, 2.0F, 3.0F, 0.0F, true);

		mouth4_e = new AdvancedModelBox(this);
		mouth4_e.setRotationPoint(0.0F, -1.0936F, -3.0717F);
		mouth4.addChild(mouth4_e);
		setRotationAngle(mouth4_e, 0.0873F, 0.0F, 0.0F);
		mouth4_e.setTextureOffset(24, 31).addBox(-1.485F, 0.015F, -3.015F, 3.0F, 2.0F, 3.0F, 0.015F, true);

		body = new AdvancedModelBox(this);
		body.setRotationPoint(0.0F, 0.4F, 8.8F);
		head.addChild(body);
		body.setTextureOffset(14, 12).addBox(-3.0F, -3.0F, -8.9F, 6.0F, 5.0F, 5.0F, 0.0F, false);
		body.setTextureOffset(0, 28).addBox(0.0F, -6.0F, -8.9F, 0.0F, 3.0F, 5.0F, 0.0F, false);

		main_belly = new AdvancedModelBox(this);
		main_belly.setRotationPoint(-0.9512F, 0.0F, -3.9F);
		body.addChild(main_belly);
		main_belly.setTextureOffset(19, 0).addBox(-1.5488F, -3.0F, 0.0F, 5.0F, 5.0F, 4.0F, 0.0F, false);
		main_belly.setTextureOffset(0, 0).addBox(0.9512F, -5.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);

		r_tentacle = new AdvancedModelBox(this);
		r_tentacle.setRotationPoint(-1.5488F, -1.5F, 2.5F);
		main_belly.addChild(r_tentacle);
		setRotationAngle(r_tentacle, 0.0F, -0.6109F, 0.0F);
		r_tentacle.setTextureOffset(36, 36).addBox(-6.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		r_tentacle2 = new AdvancedModelBox(this);
		r_tentacle2.setRotationPoint(-6.0F, 0.0F, 0.0F);
		r_tentacle.addChild(r_tentacle2);
		setRotationAngle(r_tentacle2, 0.0F, -0.9599F, 0.0F);
		r_tentacle2.setTextureOffset(34, 0).addBox(-6.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		r_hook1 = new AdvancedModelBox(this);
		r_hook1.setRotationPoint(-6.0F, 0.0F, 0.5F);
		r_tentacle2.addChild(r_hook1);
		setRotationAngle(r_hook1, 0.0F, 0.7854F, 0.0F);
		r_hook1.setTextureOffset(0, 0).addBox(-1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		r_hook4 = new AdvancedModelBox(this);
		r_hook4.setRotationPoint(-6.0F, 0.0F, -0.5F);
		r_tentacle2.addChild(r_hook4);
		setRotationAngle(r_hook4, 0.0F, -0.7854F, 0.0F);
		r_hook4.setTextureOffset(0, 0).addBox(-1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		r_hook2 = new AdvancedModelBox(this);
		r_hook2.setRotationPoint(-6.0F, -0.5F, 0.0F);
		r_tentacle2.addChild(r_hook2);
		setRotationAngle(r_hook2, 0.0F, 0.0F, 0.7854F);
		r_hook2.setTextureOffset(19, 10).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		r_hook3 = new AdvancedModelBox(this);
		r_hook3.setRotationPoint(-6.0F, 0.5F, 0.0F);
		r_tentacle2.addChild(r_hook3);
		setRotationAngle(r_hook3, 0.0F, 0.0F, -0.7854F);
		r_hook3.setTextureOffset(19, 10).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		l_tentacle = new AdvancedModelBox(this);
		l_tentacle.setRotationPoint(3.4512F, -1.5F, 2.5F);
		main_belly.addChild(l_tentacle);
		setRotationAngle(l_tentacle, 0.0F, 0.6109F, 0.0F);
		l_tentacle.setTextureOffset(36, 36).addBox(0.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		l_tentacle2 = new AdvancedModelBox(this);
		l_tentacle2.setRotationPoint(6.0F, 0.0F, 0.0F);
		l_tentacle.addChild(l_tentacle2);
		setRotationAngle(l_tentacle2, 0.0F, 0.9599F, 0.0F);
		l_tentacle2.setTextureOffset(34, 0).addBox(0.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		l_hook1 = new AdvancedModelBox(this);
		l_hook1.setRotationPoint(6.0F, 0.0F, 0.5F);
		l_tentacle2.addChild(l_hook1);
		setRotationAngle(l_hook1, 0.0F, -0.7854F, 0.0F);
		l_hook1.setTextureOffset(0, 0).addBox(0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);

		l_hook2 = new AdvancedModelBox(this);
		l_hook2.setRotationPoint(6.0F, 0.0F, -0.5F);
		l_tentacle2.addChild(l_hook2);
		setRotationAngle(l_hook2, 0.0F, 0.7854F, 0.0F);
		l_hook2.setTextureOffset(0, 0).addBox(0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);

		l_hook3 = new AdvancedModelBox(this);
		l_hook3.setRotationPoint(6.0F, -0.5F, 0.0F);
		l_tentacle2.addChild(l_hook3);
		setRotationAngle(l_hook3, 0.0F, 0.0F, -0.7854F);
		l_hook3.setTextureOffset(19, 10).addBox(0.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, 0.0F, true);

		l_hook4 = new AdvancedModelBox(this);
		l_hook4.setRotationPoint(6.0F, 0.5F, 0.0F);
		l_tentacle2.addChild(l_hook4);
		setRotationAngle(l_hook4, 0.0F, 0.0F, 0.7854F);
		l_hook4.setTextureOffset(19, 10).addBox(0.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, 0.0F, true);

		belly = new AdvancedModelBox(this);
		belly.setRotationPoint(0.9512F, -1.0F, 4.0F);
		main_belly.addChild(belly);
		belly.setTextureOffset(19, 23).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 3.0F, 0.0F, false);
		belly.setTextureOffset(42, 42).addBox(0.0F, -4.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, false);

		r_down_fin = new AdvancedModelBox(this);
		r_down_fin.setRotationPoint(-2.0F, 2.0F, 1.0F);
		belly.addChild(r_down_fin);
		setRotationAngle(r_down_fin, 0.0F, 0.0F, -0.5236F);
		r_down_fin.setTextureOffset(37, 16).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 0.0F, 3.0F, 0.0F, false);

		l_down_fin = new AdvancedModelBox(this);
		l_down_fin.setRotationPoint(2.0F, 2.0F, 1.0F);
		belly.addChild(l_down_fin);
		setRotationAngle(l_down_fin, 0.0F, 0.0F, 0.5236F);
		l_down_fin.setTextureOffset(37, 16).addBox(0.0F, 0.0F, -1.0F, 2.0F, 0.0F, 3.0F, 0.0F, true);

		tail = new AdvancedModelBox(this);
		tail.setRotationPoint(0.0F, -0.5F, 3.0F);
		belly.addChild(tail);
		tail.setTextureOffset(11, 37).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		tail.setTextureOffset(38, 39).addBox(0.0F, -3.5F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, false);
		tail.setTextureOffset(31, 37).addBox(0.0F, 1.5F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, false);

		tail_back = new AdvancedModelBox(this);
		tail_back.setRotationPoint(0.0F, -0.25F, 3.0F);
		tail.addChild(tail_back);
		tail_back.setTextureOffset(38, 3).addBox(-0.5F, -1.25F, 0.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		tail_back.setTextureOffset(0, 0).addBox(0.0F, -3.25F, 0.0F, 0.0F, 7.0F, 9.0F, 0.0F, false);

		r_spike2 = new AdvancedModelBox(this);
		r_spike2.setRotationPoint(-1.5488F, -3.0F, 2.0F);
		main_belly.addChild(r_spike2);
		setRotationAngle(r_spike2, 0.0F, 0.0F, -0.7854F);
		r_spike2.setTextureOffset(22, 37).addBox(0.0F, -1.0F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, false);

		l_spike2 = new AdvancedModelBox(this);
		l_spike2.setRotationPoint(3.4512F, -3.0F, 2.0F);
		main_belly.addChild(l_spike2);
		setRotationAngle(l_spike2, 0.0F, 0.0F, 0.7854F);
		l_spike2.setTextureOffset(22, 37).addBox(0.0F, -1.0F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, true);

		r_fin = new AdvancedModelBox(this);
		r_fin.setRotationPoint(-3.0F, 1.75F, -6.9F);
		body.addChild(r_fin);
		setRotationAngle(r_fin, 0.0F, 0.0F, -0.0436F);
		r_fin.setTextureOffset(0, 23).addBox(-5.0F, 0.0F, -2.0F, 5.0F, 0.0F, 4.0F, 0.0F, false);

		l_fin = new AdvancedModelBox(this);
		l_fin.setRotationPoint(3.0F, 1.75F, -6.9F);
		body.addChild(l_fin);
		setRotationAngle(l_fin, 0.0F, 0.0F, 0.0436F);
		l_fin.setTextureOffset(0, 23).addBox(0.0F, 0.0F, -2.0F, 5.0F, 0.0F, 4.0F, 0.0F, true);

		r_spike1 = new AdvancedModelBox(this);
		r_spike1.setRotationPoint(-3.0F, -3.0F, -6.4F);
		body.addChild(r_spike1);
		setRotationAngle(r_spike1, 0.0F, 0.0F, -0.7854F);
		r_spike1.setTextureOffset(0, 37).addBox(0.0F, -1.0F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, false);

		l_spike1 = new AdvancedModelBox(this);
		l_spike1.setRotationPoint(3.0F, -3.0F, -6.4F);
		body.addChild(l_spike1);
		setRotationAngle(l_spike1, 0.0F, 0.0F, 0.7854F);
		l_spike1.setTextureOffset(0, 37).addBox(0.0F, -1.0F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, true);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	public void animate(The_Baby_Leviathan_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(The_Baby_Leviathan_Entity.BABY_LEVIATHAN_BITE);
		animator.startKeyframe(5);
		animator.rotate(root,(float)Math.toRadians(-10f),0,0);
		animator.rotate(belly,(float)Math.toRadians(-15f),0,0);
		animator.rotate(tail,(float)Math.toRadians(-17.5f),0,0);
		animator.rotate(maw,(float)Math.toRadians(20f),0,0);
		animator.rotate(skul,(float)Math.toRadians(-30f),0,0);
		animator.rotate(mouth1,(float)Math.toRadians(22.5f),(float)Math.toRadians(15f),(float)Math.toRadians(10f));
		animator.rotate(mouth2,(float)Math.toRadians(22.5f),(float)Math.toRadians(-20f),(float)Math.toRadians(-12.5f));
		animator.rotate(mouth3,(float)Math.toRadians(-22.5f),(float)Math.toRadians(22.5f),(float)Math.toRadians(-2.5f));
		animator.rotate(mouth4,(float)Math.toRadians(-25f),(float)Math.toRadians(-22.5f),(float)Math.toRadians(2.5f));
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.rotate(root,(float)Math.toRadians(-1.25f),0,0);
		animator.move(root,0,0,-2);
		animator.rotate(belly,(float)Math.toRadians(37.5f),0,0);
		animator.rotate(tail,(float)Math.toRadians(-1.25f),0,0);
		animator.rotate(maw,(float)Math.toRadians(30f),0,0);
		animator.rotate(skul,(float)Math.toRadians(-47.5f),0,0);
		animator.rotate(mouth1,(float)Math.toRadians(32.5f),(float)Math.toRadians(22.5f),(float)Math.toRadians(15f));
		animator.rotate(mouth2,(float)Math.toRadians(35f),(float)Math.toRadians(-30f),(float)Math.toRadians(-17.5f));
		animator.rotate(mouth3,(float)Math.toRadians(-35f),(float)Math.toRadians(35f),(float)Math.toRadians(-5f));
		animator.rotate(mouth4,(float)Math.toRadians(-37.5f),(float)Math.toRadians(-35f),(float)Math.toRadians(5f));
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.rotate(root,(float)Math.toRadians(7.5f),0,0);
		animator.move(root,0,0,-4);
		animator.rotate(belly,(float)Math.toRadians(22.5f),0,0);
		animator.rotate(tail,(float)Math.toRadians(15f),0,0);
		animator.endKeyframe();

		animator.resetKeyframe(5);

		animator.setAnimation(The_Baby_Leviathan_Entity.BABY_LEVIATHAN_ABYSS_BLAST);
		animator.startKeyframe(20);
		animator.rotate(mouth1,(float)Math.toRadians(2.5f),(float)Math.toRadians(5f),0);
		animator.rotate(mouth2,(float)Math.toRadians(2.5f),(float)Math.toRadians(-5f),0);
		animator.rotate(mouth3,(float)Math.toRadians(-15f),(float)Math.toRadians(7.5f),0);
		animator.rotate(mouth4,(float)Math.toRadians(-15f),(float)Math.toRadians(-7.5f),0);
		animator.rotate(maw,(float)Math.toRadians(10f),0,0);
		animator.rotate(skul,(float)Math.toRadians(-10f),0,0);
		animator.rotate(tail,(float)Math.toRadians(15f),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(35);

		animator.startKeyframe(2);
		animator.rotate(mouth1,(float)Math.toRadians(37.5f),(float)Math.toRadians(40f),0);
		animator.rotate(mouth2,(float)Math.toRadians(37.5f),(float)Math.toRadians(-40f),0);
		animator.rotate(mouth3,(float)Math.toRadians(-37.5f),(float)Math.toRadians(40f),0);
		animator.rotate(mouth4,(float)Math.toRadians(-37.5f),(float)Math.toRadians(-40f),0);
		animator.rotate(maw,(float)Math.toRadians(17.5f),0,0);
		animator.rotate(skul,(float)Math.toRadians(-20f),0,0);
		animator.rotate(tail,(float)Math.toRadians(25f),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(80);

		animator.resetKeyframe(20);
	}

	@Override
	public void setupAnim(The_Baby_Leviathan_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		float swimSpeed = 0.1F;
		float swimDegree = 0.4F;
		float finspeed = 0.1F;
		float finDegree = 0.2F;
		AdvancedModelBox[] tailBoxes = new AdvancedModelBox[]{tail, tail_back};
		AdvancedModelBox[] rt = new AdvancedModelBox[]{r_tentacle, r_tentacle};

		AdvancedModelBox[] lt = new AdvancedModelBox[]{l_tentacle, l_tentacle2};
		float partialTick = Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);
		float sitProgress = entityIn.prevSitProgress + (entityIn.sitProgress - entityIn.prevSitProgress) * partialTick;
		float swimProgress = entityIn.prevSwimProgress + (entityIn.SwimProgress - entityIn.prevSwimProgress) * partialTick;

		progressRotationPrev(r_fin,swimProgress,0, 0, (float)Math.toRadians(2.5F), 5f);
		progressRotationPrev(l_fin,swimProgress,0, 0, (float)Math.toRadians(-2.5F), 5f);
		progressRotationPrev(r_down_fin,swimProgress,0, 0, (float)Math.toRadians(30F), 5f);
		progressRotationPrev(l_down_fin,swimProgress,0, 0, (float)Math.toRadians(-30F), 5f);

		progressRotationPrev(main_belly,sitProgress,0, (float)Math.toRadians(20F), 0, 5f);
		progressRotationPrev(r_tentacle,sitProgress,0, 0, (float)Math.toRadians(-35F), 5f);
		progressRotationPrev(l_tentacle,sitProgress,(float)Math.toRadians(-2.5F), (float)Math.toRadians(-22.5F), (float)Math.toRadians(25F), 5f);
		progressRotationPrev(belly,sitProgress,0, (float)Math.toRadians(30F), 0, 5f);
		progressRotationPrev(tail,sitProgress,0, (float)Math.toRadians(32.5F), 0, 5f);
		progressRotationPrev(tail_back,sitProgress,0, (float)Math.toRadians(35F), 0, 5f);
		progressRotationPrev(skul,sitProgress, (float)Math.toRadians(7.5F), (float)Math.toRadians(-22.5F), 0, 5f);
		progressRotationPrev(maw,sitProgress, (float)Math.toRadians(7.5F), (float)Math.toRadians(-22.5F), 0, 5f);
		progressRotationPrev(main_mouth,sitProgress, (float)Math.toRadians(7.5F), (float)Math.toRadians(-22.5F), 0, 5f);

		this.flap(l_hook3, swimSpeed * 0.2F, 0.35F, true, 0F, -0.35F, ageInTicks, 1.0f);
		this.swing(l_hook1, swimSpeed * 0.2F, 0.35F, true, 0F, -0.35F, ageInTicks, 1.0f);
		this.swing(l_hook1, swimSpeed * 0.2F, 0.35F, false, 0F, -0.35F, ageInTicks, 1.0f);
		this.flap(l_hook4, swimSpeed * 0.2F, 0.35F, false, 0F, -0.35F, ageInTicks, 1.0f);
		this.flap(l_hook3, swimSpeed * 1.3F, 0.35F, true, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.swing(l_hook2, swimSpeed * 1.3F, 0.35F, true, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.swing(l_hook2, swimSpeed * 1.3F, 0.35F, false, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.flap(l_hook4, swimSpeed * 1.3F, 0.35F, false, 0F, -0.35F, limbSwing, limbSwingAmount);


		float walkSwingAmount = limbSwingAmount * (1F - 0.2F * swimProgress);
		float swimSwingAmount = limbSwingAmount * 0.2F * swimProgress;


		this.flap(r_fin, finspeed * 4.0F, finDegree, false, 0F, -0.2F, limbSwing, swimSwingAmount);
		this.flap(l_fin, finspeed * 4.0F, finDegree, true, 0F, -0.2F, limbSwing, swimSwingAmount);

		this.flap(r_down_fin, finspeed * 4.0F, finDegree * 1.5F, false, 0F, -0.3F, limbSwing, swimSwingAmount);
		this.flap(l_down_fin, finspeed * 4.0F, finDegree * 1.5F, true, 0F, -0.3F, limbSwing, swimSwingAmount);

		float walkSpeed = 1f;
		float walkDegree = 0.7f;
		float f1 = walkDegree * 0.15F;
		float headUp = 1.6F * Math.min(0, (float) (Math.sin(limbSwing * walkSpeed) * (double) walkSwingAmount * (double) f1 * 9D - (walkSwingAmount * f1 * 9D)));
		this.head.rotationPointY += headUp;
		this.head.rotationPointZ += (float) (Math.sin(limbSwing * walkSpeed - 1.5F) * (double) walkSwingAmount * (double) f1 * 9D - (walkSwingAmount * f1 * 9D));
		this.r_fin.rotationPointY += headUp;
		this.l_fin.rotationPointY += headUp;
		this.r_down_fin.rotationPointY += headUp;
		this.l_down_fin.rotationPointY += headUp;
		this.walk(tail, walkSpeed, walkDegree * 0.5F, true, 1F, 0.04F, limbSwing, walkSwingAmount);
		this.walk(tail_back, walkSpeed, walkDegree * 0.65F, false, 2F, -0.04F, limbSwing, walkSwingAmount);
		this.walk(head, walkSpeed, walkDegree * 0.5F, false, 0F, 0.04F, limbSwing, walkSwingAmount);
		this.flap(r_fin, walkSpeed, walkDegree, true, 3F, -0.3F, limbSwing, walkSwingAmount);
		this.flap(l_fin, walkSpeed, walkDegree, false, 3F, -0.3F, limbSwing, walkSwingAmount);
		this.swing(r_fin, walkSpeed, walkDegree, false, 2F, -0.3F, limbSwing, walkSwingAmount);
		this.swing(l_fin, walkSpeed, walkDegree, true, 2F, -0.3F, limbSwing, walkSwingAmount);
		this.flap(r_down_fin, walkSpeed, walkDegree  * 0.5F, true, 3F, -0.15F, limbSwing, walkSwingAmount);
		this.flap(l_down_fin, walkSpeed, walkDegree  * 0.5F, false, 3F, -0.15F, limbSwing, walkSwingAmount);
		this.swing(r_down_fin, walkSpeed, walkDegree, false, 2F, -0.3F, limbSwing, walkSwingAmount);
		this.swing(l_down_fin, walkSpeed, walkDegree, true, 2F, -0.3F, limbSwing, walkSwingAmount);


		this.chainSwing(tailBoxes, swimSpeed * 0.4F, swimDegree * 0.45F, -1, ageInTicks , 1.0f);
		this.chainSwing(tailBoxes, swimSpeed * 4F, swimDegree * 0.6F, -1, limbSwing,limbSwingAmount);

		this.chainWave(rt, 0.03F, -0.1F, -3, ageInTicks, 1.0f);
		this.chainSwing(rt, 0.03F, -0.1F, -3, ageInTicks, 1.0f);

		this.chainWave(lt, 0.03F, 0.1F, -3, ageInTicks, 1.0f);
		this.chainSwing(lt, 0.03F, 0.1F, -3, ageInTicks, 1.0f);

		this.root.rotateAngleX += headPitch * ((float) Math.PI / 180F);
		this.root.rotateAngleY += netHeadYaw * ((float) Math.PI / 180F);

	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				body,
				main_belly,
				r_tentacle,
				r_tentacle2,
				r_hook1,
				r_hook2,
				r_hook3,
				r_hook4,
				l_tentacle,
				l_tentacle2,
				l_hook1,
				l_hook2,
				l_hook3,
				l_hook4,
				belly,
				r_down_fin,
				l_down_fin,
				tail,
				tail_back,
				r_spike1,
				r_spike2,
				head,
				maw,
				skul,
				main_mouth,
				mouth1,
				mouth1_e,
				mouth2,
				mouth2_e,
				mouth3,
				mouth3_e,
				mouth4,
				mouth4_e,
				r_fin,
				l_fin,
				l_spike1,
				l_spike2);
	}

	@Override
    public Iterable<BasicModelPart> parts() {
        return ImmutableList.of(root);
    }

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}