package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.AnimationMonster.Koboleton_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelPart;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;

public class ModelKoboleton extends AdvancedEntityModel<Koboleton_Entity> {
	public final AdvancedModelPart root;
	private final AdvancedModelPart legs;
	private final AdvancedModelPart right_leg;
	private final AdvancedModelPart right_fore_leg;
	private final AdvancedModelPart right_foot;
	private final AdvancedModelPart left_leg;
	private final AdvancedModelPart left_fore_leg;
	private final AdvancedModelPart left_foot;
	public final AdvancedModelPart pelvis;
	private final AdvancedModelPart pelvis_cube;
	public final AdvancedModelPart lower_body;
	public final AdvancedModelPart body;
	public final AdvancedModelPart right_arm;
	public final AdvancedModelPart right_weapon;
	public final AdvancedModelPart left_arm;
	public final AdvancedModelPart left_weapon;
	private final AdvancedModelPart neck;
	private final AdvancedModelPart head;
	private final AdvancedModelPart nose;
	private final AdvancedModelPart right_eyebrow;
	private final AdvancedModelPart left_eyebrow;
	private final AdvancedModelPart skull;
	private final AdvancedModelPart jaw;
	private final AdvancedModelPart tail1;
	private final AdvancedModelPart tail2;
	
	private ModelAnimator animator;

	public ModelKoboleton() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelPart(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);

		legs = new AdvancedModelPart(this);
		legs.setRotationPoint(0.0F, -16.1231F, 2.3724F);
		root.addChild(legs);
		setRotationAngle(legs, -0.1745F, 0.0F, 0.0F);


		right_leg = new AdvancedModelPart(this);
		right_leg.setRotationPoint(-1.4F, 0.9227F, -1.2917F);
		legs.addChild(right_leg);
		setRotationAngle(right_leg, -0.7338F, 0.1309F, 0.0218F);
		right_leg.setTextureOffset(25, 28).addBox(-4.0F, -0.9024F, -1.4616F, 5.0F, 8.0F, 6.0F, 0.0F, false);

		right_fore_leg = new AdvancedModelPart(this);
		right_fore_leg.setRotationPoint(-1.5F, 4.0976F, 1.5384F);
		right_leg.addChild(right_fore_leg);
		setRotationAngle(right_fore_leg, 0.9425F, -0.0001F, 0.0007F);
		right_fore_leg.setTextureOffset(19, 52).addBox(-2.0027F, 2.8653F, -0.8643F, 4.0F, 8.0F, 3.0F, 0.0F, false);

		right_foot = new AdvancedModelPart(this);
		right_foot.setRotationPoint(0.0F, 11.0F, -1.0F);
		right_fore_leg.addChild(right_foot);
		setRotationAngle(right_foot, -0.1745F, 0.0F, 0.0F);
		right_foot.setTextureOffset(0, 0).addBox(1.5005F, -2.398F, -3.6296F, 0.0F, 4.0F, 5.0F, 0.0F, false);
		right_foot.setTextureOffset(0, 0).addBox(-1.4995F, -2.398F, -3.6296F, 0.0F, 4.0F, 5.0F, 0.0F, false);
		right_foot.setTextureOffset(0, 0).addBox(0.0005F, -2.398F, -3.6296F, 0.0F, 4.0F, 5.0F, 0.0F, false);

		left_leg = new AdvancedModelPart(this);
		left_leg.setRotationPoint(1.4F, 0.9227F, -1.2917F);
		legs.addChild(left_leg);
		setRotationAngle(left_leg, -0.7338F, -0.1309F, -0.0218F);
		left_leg.setTextureOffset(25, 28).addBox(-1.0F, -0.9024F, -1.4616F, 5.0F, 8.0F, 6.0F, 0.0F, true);

		left_fore_leg = new AdvancedModelPart(this);
		left_fore_leg.setRotationPoint(1.5F, 4.0976F, 1.5384F);
		left_leg.addChild(left_fore_leg);
		setRotationAngle(left_fore_leg, 0.9425F, 0.0001F, -0.0007F);
		left_fore_leg.setTextureOffset(19, 52).addBox(-1.9973F, 2.8653F, -0.8643F, 4.0F, 8.0F, 3.0F, 0.0F, true);

		left_foot = new AdvancedModelPart(this);
		left_foot.setRotationPoint(0.0F, 11.0F, -1.0F);
		left_fore_leg.addChild(left_foot);
		setRotationAngle(left_foot, -0.1745F, 0.0F, 0.0F);
		left_foot.setTextureOffset(0, 0).addBox(-1.5005F, -2.398F, -3.6296F, 0.0F, 4.0F, 5.0F, 0.0F, true);
		left_foot.setTextureOffset(0, 0).addBox(1.4995F, -2.398F, -3.6296F, 0.0F, 4.0F, 5.0F, 0.0F, true);
		left_foot.setTextureOffset(0, 0).addBox(-0.0005F, -2.398F, -3.6296F, 0.0F, 4.0F, 5.0F, 0.0F, true);

		pelvis = new AdvancedModelPart(this);
		pelvis.setRotationPoint(0.0F, -18.1231F, -1.6276F);
		root.addChild(pelvis);
		setRotationAngle(pelvis, -0.1745F, 0.0F, 0.0F);


		pelvis_cube = new AdvancedModelPart(this);
		pelvis_cube.setRotationPoint(-1.0F, 0.0F, 1.0F);
		pelvis.addChild(pelvis_cube);
		setRotationAngle(pelvis_cube, 0.0436F, 0.0F, 0.0F);
		pelvis_cube.setTextureOffset(21, 43).addBox(-3.0F, 0.6977F, -0.5221F, 8.0F, 4.0F, 4.0F, 0.0F, false);

		lower_body = new AdvancedModelPart(this);
		lower_body.setRotationPoint(0.0F, 0.9281F, 2.6476F);
		pelvis.addChild(lower_body);
		setRotationAngle(lower_body, 1.0036F, 0.0F, 0.0F);
		lower_body.setTextureOffset(0, 46).addBox(-3.0F, -4.9281F, -1.6476F, 6.0F, 7.0F, 3.0F, 0.0F, false);

		body = new AdvancedModelPart(this);
		body.setRotationPoint(0.0895F, -3.9281F, 1.7524F);
		lower_body.addChild(body);
		setRotationAngle(body, 0.2611F, 0.0F, 0.0F);
		body.setTextureOffset(0, 34).addBox(-3.5895F, -6.0F, -5.0F, 7.0F, 6.0F, 5.0F, 0.0F, false);

		right_arm = new AdvancedModelPart(this);
		right_arm.setRotationPoint(-5.2895F, -4.5769F, -0.7724F);
		body.addChild(right_arm);
		setRotationAngle(right_arm, 0.2618F, 0.0F, 0.3491F);
		right_arm.setTextureOffset(0, 0).addBox(-1.5F, -1.5F, -12.0F, 3.0F, 3.0F, 13.0F, 0.0F, false);
		right_arm.setTextureOffset(19, 21).addBox(-2.0F, -1.0F, -17.0F, 4.0F, 0.0F, 5.0F, 0.0F, false);
		right_arm.setTextureOffset(19, 21).addBox(-2.0F, 0.0F, -17.0F, 4.0F, 0.0F, 5.0F, 0.0F, false);
		right_arm.setTextureOffset(19, 21).addBox(-2.0F, 1.0F, -17.0F, 4.0F, 0.0F, 5.0F, 0.0F, false);

		right_weapon = new AdvancedModelPart(this);
		right_weapon.setRotationPoint(0.0F, 0.0F, -14.5F);
		right_arm.addChild(right_weapon);


		left_arm = new AdvancedModelPart(this);
		left_arm.setRotationPoint(5.1105F, -4.5769F, -0.7724F);
		body.addChild(left_arm);
		setRotationAngle(left_arm, 0.2182F, 0.0F, -0.3491F);
		left_arm.setTextureOffset(0, 0).addBox(-1.5F, -1.5F, -12.0F, 3.0F, 3.0F, 13.0F, 0.0F, true);
		left_arm.setTextureOffset(19, 21).addBox(-2.0F, -1.0F, -17.0F, 4.0F, 0.0F, 5.0F, 0.0F, true);
		left_arm.setTextureOffset(19, 21).addBox(-2.0F, 0.0F, -17.0F, 4.0F, 0.0F, 5.0F, 0.0F, true);
		left_arm.setTextureOffset(19, 21).addBox(-2.0F, 1.0F, -17.0F, 4.0F, 0.0F, 5.0F, 0.0F, true);

		left_weapon = new AdvancedModelPart(this);
		left_weapon.setRotationPoint(0.0F, 0.0F, -14.5F);
		left_arm.addChild(left_weapon);


		neck = new AdvancedModelPart(this);
		neck.setRotationPoint(0.0F, -8.0F, -3.5F);
		body.addChild(neck);
		setRotationAngle(neck, -1.1345F, 0.0F, 0.0F);


		head = new AdvancedModelPart(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		neck.addChild(head);


		nose = new AdvancedModelPart(this);
		nose.setRotationPoint(-0.0895F, 7.0F, 0.0F);
		head.addChild(nose);
		setRotationAngle(nose, 0.3491F, 0.0F, 0.0F);
		nose.setTextureOffset(46, 46).addBox(-2.0F, -11.0F, -5.0F, 4.0F, 4.0F, 5.0F, 0.0F, false);

		right_eyebrow = new AdvancedModelPart(this);
		right_eyebrow.setRotationPoint(-1.5895F, -1.0F, -6.0F);
		head.addChild(right_eyebrow);
		setRotationAngle(right_eyebrow, 0.3386F, -0.283F, 0.0405F);
		right_eyebrow.setTextureOffset(38, 0).addBox(-0.8137F, -1.9404F, 0.0575F, 3.0F, 2.0F, 8.0F, 0.0F, false);

		left_eyebrow = new AdvancedModelPart(this);
		left_eyebrow.setRotationPoint(1.4105F, -1.0F, -6.0F);
		head.addChild(left_eyebrow);
		setRotationAngle(left_eyebrow, 0.3386F, 0.283F, -0.0405F);
		left_eyebrow.setTextureOffset(38, 0).addBox(-2.1863F, -1.9404F, 0.0575F, 3.0F, 2.0F, 8.0F, 0.0F, true);

		skull = new AdvancedModelPart(this);
		skull.setRotationPoint(-0.5895F, 7.0F, 0.0F);
		head.addChild(skull);
		setRotationAngle(skull, 0.1745F, 0.0F, 0.0F);
		skull.setTextureOffset(42, 21).addBox(-2.0F, -10.9F, -3.0F, 5.0F, 4.0F, 6.0F, 0.0F, false);

		jaw = new AdvancedModelPart(this);
		jaw.setRotationPoint(0.0F, 0.0F, -1.0F);
		head.addChild(jaw);
		setRotationAngle(jaw, 0.3927F, 0.0F, 0.0F);
		jaw.setTextureOffset(42, 36).addBox(-1.5895F, -0.7753F, -6.2929F, 3.0F, 2.0F, 7.0F, 0.0F, false);

		tail1 = new AdvancedModelPart(this);
		tail1.setRotationPoint(1.0F, 1.0F, 4.0F);
		pelvis.addChild(tail1);
		tail1.setTextureOffset(0, 17).addBox(-2.5F, -2.0F, 0.0F, 3.0F, 4.0F, 12.0F, 0.0F, false);

		tail2 = new AdvancedModelPart(this);
		tail2.setRotationPoint(0.0F, -0.5F, 11.0F);
		tail1.addChild(tail2);
		setRotationAngle(tail2, 0.1745F, 0.0F, 0.0F);
		tail2.setTextureOffset(21, 5).addBox(-2.0F, -1.1888F, -1.1585F, 2.0F, 3.0F, 12.0F, 0.0F, false);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	public void animate(Koboleton_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(Koboleton_Entity.COBOLETON_ATTACK);
		if(!entity.getIsAngry()) {
			if (entity.isLeftHanded()) {
				animator.startKeyframe(8);
				animator.rotate(root, 0, (float) Math.toRadians(-20F), 0);
				animator.rotate(left_leg, (float) Math.toRadians(10f), (float) Math.toRadians(-7.5f), (float) Math.toRadians(-5f));
				animator.move(left_leg, 1, -1, 1);
				animator.rotate(right_leg, 0, (float) Math.toRadians(7.5f), (float) Math.toRadians(5f));
				animator.rotate(lower_body, (float) Math.toRadians(-5f), (float) Math.toRadians(10f), (float) Math.toRadians(10f));
				animator.rotate(body, (float) Math.toRadians(10f), (float) Math.toRadians(-2.5f), (float) Math.toRadians(5f));
				animator.rotate(left_arm, (float) Math.toRadians(115f), (float) Math.toRadians(7.5f), (float) Math.toRadians(-10f));
				animator.rotate(right_arm, (float) Math.toRadians(20f), (float) Math.toRadians(25f), (float) Math.toRadians(12.5f));
				animator.rotate(left_weapon, (float) Math.toRadians(90f), (float) Math.toRadians(-2.5f), (float) Math.toRadians(-90f));
				animator.rotate(neck, 0, (float) Math.toRadians(7.5f), 0);
				animator.rotate(jaw, (float) Math.toRadians(22.5f), 0, 0);
				animator.rotate(tail1, (float) Math.toRadians(-2.5f), (float) Math.toRadians(-17.5f), 0);
				animator.rotate(tail2, (float) Math.toRadians(17.5f), (float) Math.toRadians(-7.5f), (float) Math.toRadians(-2.5f));
				animator.endKeyframe();

				animator.startKeyframe(4);
				animator.rotate(root, (float) Math.toRadians(22.5F), (float) Math.toRadians(40F), (float) Math.toRadians(20F));
				animator.rotate(left_leg, (float) Math.toRadians(20f), (float) Math.toRadians(-12.5f), (float) Math.toRadians(-25f));
				animator.move(left_leg, 1, -2, 1);
				animator.rotate(right_leg, (float) Math.toRadians(-7.5f), (float) Math.toRadians(12.5f), 0);
				animator.rotate(pelvis, 0, (float) Math.toRadians(42.5f), 0);
				animator.rotate(lower_body, (float) Math.toRadians(-5f), (float) Math.toRadians(17.5f), (float) Math.toRadians(10f));
				animator.rotate(body, (float) Math.toRadians(20f), (float) Math.toRadians(35f), (float) Math.toRadians(-7.5f));
				animator.rotate(left_arm, (float) Math.toRadians(-5f), (float) Math.toRadians(-35f), (float) Math.toRadians(-90f));
				animator.rotate(right_arm, (float) Math.toRadians(112.5f), (float) Math.toRadians(12.5), (float) Math.toRadians(32.5f));
				animator.rotate(left_weapon, (float) Math.toRadians(92.5f), 0, (float) Math.toRadians(-180f));
				animator.rotate(neck, (float) Math.toRadians(-10f), (float) Math.toRadians(5f), (float) Math.toRadians(10f));
				animator.rotate(jaw, (float) Math.toRadians(22.5f), 0, 0);
				animator.rotate(tail1, (float) Math.toRadians(10f), (float) Math.toRadians(30f), (float) Math.toRadians(7.5f));
				animator.rotate(tail2, (float) Math.toRadians(17.5f), (float) Math.toRadians(-7.5f), (float) Math.toRadians(-5f));
				animator.endKeyframe();

				animator.resetKeyframe(7);

			}else{
				animator.startKeyframe(8);
				animator.rotate(root, 0, (float) Math.toRadians(20F), 0);
				animator.rotate(right_leg, (float) Math.toRadians(10f), (float) Math.toRadians(7.5f), (float) Math.toRadians(5f));
				animator.move(right_leg, -1, -1, 1);
				animator.rotate(left_leg, 0, (float) Math.toRadians(-7.5f), (float) Math.toRadians(-5f));
				animator.rotate(lower_body, (float) Math.toRadians(-5f), (float) Math.toRadians(-10f), (float) Math.toRadians(-10f));
				animator.rotate(body, (float) Math.toRadians(10f), (float) Math.toRadians(2.5f), (float) Math.toRadians(-5f));
				animator.rotate(right_arm, (float) Math.toRadians(115f), (float) Math.toRadians(-7.5f), (float) Math.toRadians(10f));
				animator.rotate(right_weapon, (float) Math.toRadians(90f), (float) Math.toRadians(2.5f), (float) Math.toRadians(90f));
				animator.rotate(left_arm, (float) Math.toRadians(20f), (float) Math.toRadians(-25f), (float) Math.toRadians(-12.5f));
				animator.rotate(neck, 0, (float) Math.toRadians(-7.5f), 0);
				animator.rotate(jaw, (float) Math.toRadians(22.5f), 0, 0);
				animator.rotate(tail1, (float) Math.toRadians(-2.5f), (float) Math.toRadians(17.5f), 0);
				animator.rotate(tail2, (float) Math.toRadians(17.5f), (float) Math.toRadians(7.5f), (float) Math.toRadians(2.5f));
				animator.endKeyframe();

				animator.startKeyframe(4);
				animator.rotate(root, (float) Math.toRadians(22.5F), (float) Math.toRadians(-40F), (float) Math.toRadians(-20F));
				animator.rotate(right_leg, (float) Math.toRadians(20f), (float) Math.toRadians(12.5f), (float) Math.toRadians(25f));
				animator.move(right_leg, -1, -2, 1);
				animator.rotate(left_leg, (float) Math.toRadians(-7.5f), (float) Math.toRadians(-12.5f), 0);
				animator.rotate(pelvis, 0, (float) Math.toRadians(-42.5f), 0);
				animator.rotate(lower_body, (float) Math.toRadians(-5f), (float) Math.toRadians(-17.5f), (float) Math.toRadians(-10f));
				animator.rotate(body, (float) Math.toRadians(20f), (float) Math.toRadians(-35f), (float) Math.toRadians(7.5f));
				animator.rotate(right_arm, (float) Math.toRadians(-5f), (float) Math.toRadians(35f), (float) Math.toRadians(90f));
				animator.rotate(right_weapon, (float) Math.toRadians(92.5f), 0, (float) Math.toRadians(180f));
				animator.rotate(left_arm, (float) Math.toRadians(112.5f), (float) Math.toRadians(-12.5), (float) Math.toRadians(-32.5f));
				animator.rotate(neck, (float) Math.toRadians(-10f), (float) Math.toRadians(-5f), (float) Math.toRadians(-10f));
				animator.rotate(jaw, (float) Math.toRadians(22.5f), 0, 0);
				animator.rotate(tail1, (float) Math.toRadians(10f), (float) Math.toRadians(-30f), (float) Math.toRadians(-7.5f));
				animator.rotate(tail2, (float) Math.toRadians(17.5f), (float) Math.toRadians(7.5f), (float) Math.toRadians(5f));
				animator.endKeyframe();

				animator.resetKeyframe(7);
			}
		}else{
			if (entity.isLeftHanded()) {
				animator.startKeyframe(8);
				animator.rotate(root, 0, (float) Math.toRadians(-20F), 0);
				animator.rotate(legs, (float) Math.toRadians(-7.5F), 0, 0);
				animator.rotate(left_leg, (float) Math.toRadians(10f), (float) Math.toRadians(-7.5f), (float) Math.toRadians(-5f));
				animator.move(left_leg, 1, -1, 1);
				animator.rotate(right_leg, 0, (float) Math.toRadians(7.5f), (float) Math.toRadians(5f));
				animator.rotate(lower_body, (float) Math.toRadians(-5f), (float) Math.toRadians(10f), (float) Math.toRadians(10f));
				animator.rotate(body, (float) Math.toRadians(10f), (float) Math.toRadians(-10f), (float) Math.toRadians(5f));
				animator.rotate(left_arm, (float) Math.toRadians(22.5f), (float) Math.toRadians(2.5f), (float) Math.toRadians(2.5f));
				animator.rotate(left_weapon, (float) Math.toRadians(90f), (float) Math.toRadians(-2.5f), (float) Math.toRadians(-90f));
				animator.rotate(right_arm, (float) Math.toRadians(-45f), (float) Math.toRadians(25f), (float) Math.toRadians(12.5f));
				animator.rotate(neck, (float) Math.toRadians(-7.5f), (float) Math.toRadians(7.5f), 0);
				animator.rotate(jaw, (float) Math.toRadians(15f), 0, 0);
				animator.rotate(tail1, (float) Math.toRadians(-32.5f), (float) Math.toRadians(-17.5f), 0);
				animator.rotate(tail2, (float) Math.toRadians(52.5f), (float) Math.toRadians(-7.5f), (float) Math.toRadians(-2.5f));
				animator.endKeyframe();

				animator.startKeyframe(4);
				animator.rotate(root, (float) Math.toRadians(22.5F), (float) Math.toRadians(40F), (float) Math.toRadians(20F));
				animator.rotate(legs, (float) Math.toRadians(-7.5F), 0, 0);
				animator.rotate(left_leg, (float) Math.toRadians(20f), (float) Math.toRadians(-12.5f), (float) Math.toRadians(-25f));
				animator.move(left_leg, 1, -2, 1);
				animator.rotate(right_leg, (float) Math.toRadians(-7.5f), (float) Math.toRadians(12.5f), 0);
				animator.rotate(pelvis, 0, (float) Math.toRadians(42.5f), 0);
				animator.rotate(lower_body, (float) Math.toRadians(-5f), (float) Math.toRadians(17.5f), (float) Math.toRadians(10f));
				animator.rotate(body, (float) Math.toRadians(20f), (float) Math.toRadians(27.5f), (float) Math.toRadians(-7.5f));
				animator.rotate(left_arm, (float) Math.toRadians(-97.5f), (float) Math.toRadians(-40f), (float) Math.toRadians(-77.5f));
				animator.rotate(left_weapon, (float) Math.toRadians(92.5f), 0, (float) Math.toRadians(-180f));
				animator.rotate(right_arm, (float) Math.toRadians(47.5f), (float) Math.toRadians(12.5), (float) Math.toRadians(32.5f));
				animator.rotate(neck, (float) Math.toRadians(-17.5f), (float) Math.toRadians(5f), (float) Math.toRadians(10f));
				animator.rotate(jaw, (float) Math.toRadians(25f), 0, 0);
				animator.rotate(tail1, (float) Math.toRadians(-20f), (float) Math.toRadians(30f), (float) Math.toRadians(7.5f));
				animator.rotate(tail2, (float) Math.toRadians(52.5f), (float) Math.toRadians(-7.5f), (float) Math.toRadians(-5f));
				animator.endKeyframe();

				animator.resetKeyframe(7);

			}else{
				animator.startKeyframe(8);
				animator.rotate(root, 0, (float) Math.toRadians(20F), 0);
				animator.rotate(legs, (float) Math.toRadians(-7.5F), 0, 0);
				animator.rotate(right_leg, (float) Math.toRadians(10f), (float) Math.toRadians(7.5f), (float) Math.toRadians(5f));
				animator.move(right_leg, -1, -1, 1);
				animator.rotate(left_leg, 0, (float) Math.toRadians(-7.5f), (float) Math.toRadians(-5f));
				animator.rotate(lower_body, (float) Math.toRadians(-5f), (float) Math.toRadians(-10f), (float) Math.toRadians(-10f));
				animator.rotate(body, (float) Math.toRadians(10f), (float) Math.toRadians(10f), (float) Math.toRadians(-5f));
				animator.rotate(right_arm, (float) Math.toRadians(22.5f), (float) Math.toRadians(-2.5f), (float) Math.toRadians(-2.5f));
				animator.rotate(right_weapon, (float) Math.toRadians(90f), (float) Math.toRadians(2.5f), (float) Math.toRadians(90f));
				animator.rotate(left_arm, (float) Math.toRadians(-45f), (float) Math.toRadians(-25f), (float) Math.toRadians(-12.5f));
				animator.rotate(neck, (float) Math.toRadians(-7.5f), (float) Math.toRadians(-7.5f), 0);
				animator.rotate(jaw, (float) Math.toRadians(15f), 0, 0);
				animator.rotate(tail1, (float) Math.toRadians(-32.5f), (float) Math.toRadians(17.5f), 0);
				animator.rotate(tail2, (float) Math.toRadians(52.5f), (float) Math.toRadians(7.5f), (float) Math.toRadians(2.5f));
				animator.endKeyframe();

				animator.startKeyframe(4);
				animator.rotate(root, (float) Math.toRadians(22.5F), (float) Math.toRadians(-40F), (float) Math.toRadians(-20F));
				animator.rotate(legs, (float) Math.toRadians(-7.5F), 0, 0);
				animator.rotate(right_leg, (float) Math.toRadians(20f), (float) Math.toRadians(12.5f), (float) Math.toRadians(25f));
				animator.move(right_leg, -1, -2, 1);
				animator.rotate(left_leg, (float) Math.toRadians(-7.5f), (float) Math.toRadians(-12.5f), 0);
				animator.rotate(pelvis, 0, (float) Math.toRadians(-42.5f), 0);
				animator.rotate(lower_body, (float) Math.toRadians(-5f), (float) Math.toRadians(-17.5f), (float) Math.toRadians(-10f));
				animator.rotate(body, (float) Math.toRadians(20f), (float) Math.toRadians(-27.5f), (float) Math.toRadians(7.5f));
				animator.rotate(right_arm, (float) Math.toRadians(-97.5f), (float) Math.toRadians(40f), (float) Math.toRadians(77.5f));
				animator.rotate(right_weapon, (float) Math.toRadians(92.5f), 0, (float) Math.toRadians(180f));
				animator.rotate(left_arm, (float) Math.toRadians(47.5f), (float) Math.toRadians(-12.5), (float) Math.toRadians(-32.5f));
				animator.rotate(neck, (float) Math.toRadians(-17.5f), (float) Math.toRadians(-5f), (float) Math.toRadians(-10f));
				animator.rotate(jaw, (float) Math.toRadians(25f), 0, 0);
				animator.rotate(tail1, (float) Math.toRadians(-20f), (float) Math.toRadians(-30f), (float) Math.toRadians(-7.5f));
				animator.rotate(tail2, (float) Math.toRadians(52.5f), (float) Math.toRadians(7.5f), (float) Math.toRadians(5f));
				animator.endKeyframe();

				animator.resetKeyframe(7);
			}
		}
	}

	@Override
	public void setupAnim(Koboleton_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		float walkSpeed = 0.5F;
		float runSpeed = 0.8F;
		float walkDegree = 0.5F;

		float partialTick = Minecraft.getInstance().getFrameTime();
		float angryProgress = entityIn.prevangryProgress + (entityIn.angryProgress - entityIn.prevangryProgress) * partialTick;

		this.faceTarget(netHeadYaw, headPitch, 1, head);
		this.walk(lower_body, walkSpeed * 0.1F, walkDegree * 0.2F, false, 0F, walkDegree * 0.0625F, ageInTicks, 1);
		this.walk(jaw, walkSpeed * 0.1F, walkDegree * 0.2F, false, 0F, walkDegree * 0.2F, ageInTicks, 1);

		this.right_arm.rotationPointY -= Mth.cos(ageInTicks * walkSpeed * 0.1F+ 1F) * 0.5F + 0.5F;
		this.left_arm.rotationPointY -= Mth.cos(ageInTicks * walkSpeed * 0.1F+ 1F) * 0.5F + 0.5F;

		this.right_arm.rotationPointZ += Mth.cos(ageInTicks * walkSpeed * 0.1F) * 1.0F - 1.0F;
		this.left_arm.rotationPointZ += Mth.cos(ageInTicks * walkSpeed * 0.1F) * 1.0F - 1.0F;


		if (angryProgress <= 0F) {
			this.walk(left_leg, walkSpeed, walkDegree * 1.2f, true, 0, -0.2F, limbSwing, limbSwingAmount);
			this.walk(left_arm, walkSpeed, walkDegree * 1.2f, false, 0, 0.0F, limbSwing, limbSwingAmount);
			this.walk(left_fore_leg, walkSpeed, walkDegree * 0.5F, true, -1F, -0.2F, limbSwing, limbSwingAmount);
			this.walk(left_foot, walkSpeed, walkDegree * -1F, true, -1.5F, 0.0F, limbSwing, limbSwingAmount);
			left_foot.rotationPointY -= Math.abs((float) (Math.cos(limbSwing * walkSpeed - 1.5F) * walkDegree * 1.5F * limbSwingAmount));

			this.walk(right_leg, walkSpeed, walkDegree * 1.2f, false, 0, 0.2F, limbSwing, limbSwingAmount);
			this.walk(right_arm, walkSpeed, walkDegree * 1.2f, true, 0, 0.0F, limbSwing, limbSwingAmount);
			this.walk(right_fore_leg, walkSpeed, walkDegree * 0.5F, false, -1F, -0.2F, limbSwing, limbSwingAmount);
			this.walk(right_foot, walkSpeed, walkDegree * -1F, false, -1.5F, 0.0F, limbSwing, limbSwingAmount);
			right_foot.rotationPointY -= Math.abs((float) (Math.cos(limbSwing * walkSpeed - 1.5F) * walkDegree * 1.5F * limbSwingAmount));

			this.walk(tail1, walkSpeed * 0.1F, walkDegree * 0.8F, true, 0F,  walkDegree * 0.35F, ageInTicks, 1);
			this.walk(tail2, walkSpeed * 0.1F, walkDegree * 0.8F, false, 1F, 0f, ageInTicks, 1);

		}else{
			this.walk(left_leg, runSpeed, walkDegree * 3f, true, 0, -0.5F, limbSwing, limbSwingAmount);
			left_foot.rotationPointY -= Math.abs((float) (Math.cos(limbSwing * walkSpeed - 1.5F) * walkDegree * 1.5F * limbSwingAmount));
			this.walk(right_leg, runSpeed, walkDegree * 3f, false, 0, 0.5F, limbSwing, limbSwingAmount);

			if(entityIn.isLeftHanded()) {
				this.walk(right_arm, runSpeed, walkDegree * 1.6f, false, 0, -walkDegree * 1.6f, limbSwing, limbSwingAmount);
				this.walk(left_arm, runSpeed, walkDegree * 0.6f, true, 0, -walkDegree * 0.6f, limbSwing, limbSwingAmount);
			}else{
				this.walk(left_arm, runSpeed, walkDegree * 1.6f, false, 0, -walkDegree * 1.6f, limbSwing, limbSwingAmount);
				this.walk(right_arm, runSpeed, walkDegree * 0.6f, true, 0, -walkDegree * 0.6f, limbSwing, limbSwingAmount);
			}

			right_foot.rotationPointY -= Math.abs((float) (Math.cos(limbSwing * walkSpeed - 1.5F) * walkDegree * 1.5F * limbSwingAmount));

			this.walk(tail1, runSpeed, walkDegree * 1.6F, true, 0F,  walkDegree * 0.8F,limbSwing, limbSwingAmount);
			this.walk(tail2, runSpeed, walkDegree * 1.6F, false, 0F, walkDegree * 0.8F, limbSwing, limbSwingAmount);

			this.bob(root, -runSpeed, walkDegree * -6, true, limbSwing, limbSwingAmount);

		}

		this.bob(pelvis,walkSpeed * 0.1F, walkDegree * 0.4F, false, ageInTicks, 1);

		progressRotationPrev(legs,angryProgress,(float)Math.toRadians(7.5F), 0, 0, 10F);
		progressRotationPrev(body,angryProgress,0, (float)Math.toRadians(-7.5F), 0, 10F);

		if(entityIn.isLeftHanded()) {
			progressRotationPrev(left_arm, angryProgress, (float) Math.toRadians(92.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-12.5F), 10F);
			progressRotationPrev(right_arm, angryProgress, (float) Math.toRadians(65F), 0, 0, 10F);
		}else{
			progressRotationPrev(right_arm, angryProgress, (float) Math.toRadians(92.5F), (float) Math.toRadians(-5F), (float) Math.toRadians(12.5F), 10F);
			progressRotationPrev(left_arm, angryProgress, (float) Math.toRadians(65F), 0, 0, 10F);
		}


		progressRotationPrev(neck,angryProgress,(float)Math.toRadians(7.5F), 0, 0, 10F);
		progressRotationPrev(jaw,angryProgress,(float)Math.toRadians(7.5F), 0, 0, 10F);
		progressRotationPrev(tail1,angryProgress,(float)Math.toRadians(30F), 0, 0, 10F);
		progressRotationPrev(tail2,angryProgress,(float)Math.toRadians(-35F), 0, 0, 10F);
	}

	private float walkValue(float limbSwing, float limbSwingAmount, float speed, float offset, float degree, boolean inverse) {
		return (float) ((Math.cos(limbSwing * speed + offset) * degree * limbSwingAmount) * (inverse ? -1 : 1));
	}

	@Override
	public Iterable<AdvancedModelPart> getAllParts() {
		return ImmutableList.of(
				root,
				legs,
				right_leg,
				right_fore_leg,
				right_foot,
				left_leg,
				left_fore_leg,
				left_foot,
				pelvis,
				pelvis_cube,
				lower_body,
				body,
				right_arm,
				right_weapon,
				left_arm,
				left_weapon,
				head,
				nose,
				right_eyebrow,
				left_eyebrow,
				skull,
				jaw,
				neck,
				tail1,
				tail2);
	}

	@Override
    public Iterable<BasicModelPart> parts() {
        return ImmutableList.of(root);
    }


	public void setRotationAngle(AdvancedModelPart AdvancedModelPart, float x, float y, float z) {
		AdvancedModelPart.rotateAngleX = x;
		AdvancedModelPart.rotateAngleY = y;
		AdvancedModelPart.rotateAngleZ = z;
	}
}