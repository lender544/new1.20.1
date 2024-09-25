package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Netherite_Monstrosity_Entity;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class Netherite_Monstrosity_Model extends AdvancedEntityModel<Netherite_Monstrosity_Entity> {

	private final AdvancedModelBox root;
	private final AdvancedModelBox lowerbody;
	private final AdvancedModelBox upperbody;
	public final AdvancedModelBox head;
	private final AdvancedModelBox horns;
	private final AdvancedModelBox jaw;
	private final AdvancedModelBox leftarmjoint;
	private final AdvancedModelBox leftarm;
	private final AdvancedModelBox leftarm2;
	private final AdvancedModelBox lefthand;
	private final AdvancedModelBox leftfinger1;
	private final AdvancedModelBox leftfinger2;
	private final AdvancedModelBox leftfinger3;
	private final AdvancedModelBox rightarmjoint;
	private final AdvancedModelBox rightarm;
	private final AdvancedModelBox rightarm2;
	private final AdvancedModelBox righthand;
	private final AdvancedModelBox rightfinger1;
	private final AdvancedModelBox rightfinger2;
	private final AdvancedModelBox rightfinger3;
	private final AdvancedModelBox rightleg;
	private final AdvancedModelBox leftleg;
	private ModelAnimator animator;

	public Netherite_Monstrosity_Model() {
		texWidth = 512;
		texHeight = 512;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		lowerbody = new AdvancedModelBox(this);
		lowerbody.setRotationPoint(0.0F, -24.0F, 2.0F);
		root.addChild(lowerbody);
		lowerbody.setTextureOffset(175, 193).addBox(-14.0F, -11.0F, -10.5F, 28.0F, 11.0F, 21.0F, 0.0F, false);

		upperbody = new AdvancedModelBox(this);
		upperbody.setRotationPoint(0.0F, -11.0F, 0.0F);
		lowerbody.addChild(upperbody);
		upperbody.setTextureOffset(0, 0).addBox(-37.0F, -57.0F, -15.0F, 74.0F, 57.0F, 30.0F, 0.0F, false);
		upperbody.setTextureOffset(209, 226).addBox(-14.0F, -51.0F, 15.0F, 28.0F, 16.0F, 11.0F, 0.0F, false);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, -33.0F, -15.5F);
		upperbody.addChild(head);
		head.setTextureOffset(0, 139).addBox(-14.0F, -18.0F, -20.5F, 28.0F, 31.0F, 22.0F, 0.0F, false);
		head.setTextureOffset(246, 112).addBox(-34.0F, -12.5F, -16.0F, 20.0F, 13.0F, 13.0F, 0.0F, false);
		head.setTextureOffset(246, 112).addBox(14.0F, -12.5F, -16.0F, 20.0F, 13.0F, 13.0F, 0.0F, true);
		head.setTextureOffset(253, 184).addBox(-34.0F, -27.5F, -16.0F, 8.0F, 15.0F, 13.0F, 0.0F, false);
		head.setTextureOffset(169, 171).addBox(26.0F, -15.5F, -16.0F, 8.0F, 3.0F, 13.0F, 0.0F, false);
		head.setTextureOffset(12, 0).addBox(-3.0F, -2.0F, -20.7F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(17, 5).addBox(-14.25F, 1.5F, -20.7F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(17, 5).addBox(10.25F, 1.5F, -20.7F, 4.0F, 4.0F, 1.0F, 0.0F, false);

		horns = new AdvancedModelBox(this);
		horns.setRotationPoint(-4.5F, 47.0F, -3.5F);
		head.addChild(horns);
		setRotationAngle(horns, 1.0472F, 0.0F, 0.0F);


		jaw = new AdvancedModelBox(this);
		jaw.setRotationPoint(0.0F, 12.0F, 0.5F);
		head.addChild(jaw);
		setRotationAngle(jaw, 0.0f, 0.0F, 0.0F);
		jaw.setTextureOffset(209, 0).addBox(-13.5F, -5.0F, -20.9F, 27.0F, 10.0F, 21.0F, 0.0F, false);
		jaw.setTextureOffset(209, 32).addBox(-13.5F, 2.0F, -20.9F, 27.0F, 0.0F, 21.0F, 0.0F, false);

		leftarmjoint = new AdvancedModelBox(this);
		leftarmjoint.setRotationPoint(37.0F, -38.5F, -2.5F);
		upperbody.addChild(leftarmjoint);


		leftarm = new AdvancedModelBox(this);
		leftarm.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftarmjoint.addChild(leftarm);
		leftarm.setTextureOffset(101, 163).addBox(0.0F, -33.5F, -13.5F, 20.0F, 23.0F, 27.0F, 0.0F, false);
		leftarm.setTextureOffset(0, 88).addBox(0.0F, -10.5F, -13.5F, 37.0F, 23.0F, 27.0F, 0.0F, false);

		leftarm2 = new AdvancedModelBox(this);
		leftarm2.setRotationPoint(18.0F, 12.0F, 0.0F);
		leftarm.addChild(leftarm2);
		setRotationAngle(leftarm2, -0.1309F, 0.0F, 0.0F);
		leftarm2.setTextureOffset(132, 226).addBox(-11.0F, -4.5F, -8.0F, 22.0F, 22.0F, 16.0F, 0.0F, false);

		lefthand = new AdvancedModelBox(this);
		lefthand.setRotationPoint(0.0F, 17.0F, 0.0F);
		leftarm2.addChild(lefthand);
		setRotationAngle(lefthand, -0.0873F, 0.0F, 0.0F);
		lefthand.setTextureOffset(57, 214).addBox(-15.0F, 0.0F, -15.0F, 7.0F, 20.0F, 30.0F, 0.0F, false);
		lefthand.setTextureOffset(201, 133).addBox(8.0F, 0.0F, -15.0F, 7.0F, 20.0F, 30.0F, 0.0F, false);
		lefthand.setTextureOffset(250, 54).addBox(-8.0F, 0.0F, 8.0F, 16.0F, 20.0F, 7.0F, 0.0F, false);
		lefthand.setTextureOffset(0, 242).addBox(-8.0F, 0.0F, -15.0F, 16.0F, 20.0F, 7.0F, 0.0F, false);
		lefthand.setTextureOffset(102, 88).addBox(-8.0F, 17.0F, -8.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
		lefthand.setTextureOffset(246, 139).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, 0.0F, false);

		leftfinger1 = new AdvancedModelBox(this);
		leftfinger1.setRotationPoint(10.0F, 20.0F, 6.0F);
		lefthand.addChild(leftfinger1);
		leftfinger1.setTextureOffset(0, 0).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, 0.0F, false);

		leftfinger2 = new AdvancedModelBox(this);
		leftfinger2.setRotationPoint(10.0F, 20.0F, -8.0F);
		lefthand.addChild(leftfinger2);
		leftfinger2.setTextureOffset(0, 0).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, 0.0F, false);

		leftfinger3 = new AdvancedModelBox(this);
		leftfinger3.setRotationPoint(-10.0F, 20.0F, -1.5F);
		lefthand.addChild(leftfinger3);
		leftfinger3.setTextureOffset(0, 0).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, 0.0F, false);

		rightarmjoint = new AdvancedModelBox(this);
		rightarmjoint.setRotationPoint(-37.0F, -38.5F, -2.5F);
		upperbody.addChild(rightarmjoint);


		rightarm = new AdvancedModelBox(this);
		rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightarmjoint.addChild(rightarm);
		rightarm.setTextureOffset(182, 61).addBox(-20.0F, -33.5F, -13.5F, 20.0F, 23.0F, 27.0F, 0.0F, false);
		rightarm.setTextureOffset(102, 112).addBox(-37.0F, -10.5F, -13.5F, 37.0F, 23.0F, 27.0F, 0.0F, false);

		rightarm2 = new AdvancedModelBox(this);
		rightarm2.setRotationPoint(-19.0F, 12.0F, 0.0F);
		rightarm.addChild(rightarm2);
		setRotationAngle(rightarm2, -0.1309F, 0.0F, 0.0F);
		rightarm2.setTextureOffset(132, 226).addBox(-11.0F, -4.5F, -8.0F, 22.0F, 22.0F, 16.0F, 0.0F, false);

		righthand = new AdvancedModelBox(this);
		righthand.setRotationPoint(0.0F, 17.0F, 0.0F);
		rightarm2.addChild(righthand);
		setRotationAngle(righthand, -0.0873F, 0.0F, 0.0F);
		righthand.setTextureOffset(57, 214).addBox(-15.0F, 0.0F, -15.0F, 7.0F, 20.0F, 30.0F, 0.0F, false);
		righthand.setTextureOffset(201, 133).addBox(8.0F, 0.0F, -15.0F, 7.0F, 20.0F, 30.0F, 0.0F, false);
		righthand.setTextureOffset(250, 54).addBox(-8.0F, 0.0F, 8.0F, 16.0F, 20.0F, 7.0F, 0.0F, false);
		righthand.setTextureOffset(0, 242).addBox(-8.0F, 0.0F, -15.0F, 16.0F, 20.0F, 7.0F, 0.0F, false);
		righthand.setTextureOffset(102, 88).addBox(-8.0F, 17.0F, -8.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
		righthand.setTextureOffset(246, 139).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, 0.0F, false);

		rightfinger1 = new AdvancedModelBox(this);
		rightfinger1.setRotationPoint(-10.0F, 20.0F, 6.0F);
		righthand.addChild(rightfinger1);
		rightfinger1.setTextureOffset(0, 0).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, 0.0F, false);

		rightfinger2 = new AdvancedModelBox(this);
		rightfinger2.setRotationPoint(-10.0F, 20.0F, -8.0F);
		righthand.addChild(rightfinger2);
		rightfinger2.setTextureOffset(0, 0).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, 0.0F, false);

		rightfinger3 = new AdvancedModelBox(this);
		rightfinger3.setRotationPoint(10.0F, 20.0F, -1.5F);
		righthand.addChild(rightfinger3);
		rightfinger3.setTextureOffset(0, 0).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, 0.0F, false);

		rightleg = new AdvancedModelBox(this);
		rightleg.setRotationPoint(-14.0F, -27.0F, 0.0F);
		root.addChild(rightleg);
		rightleg.setTextureOffset(0, 193).addBox(-19.0F, -2.0F, -9.5F, 24.0F, 29.0F, 19.0F, 0.0F, false);

		leftleg = new AdvancedModelBox(this);
		leftleg.setRotationPoint(14.0F, -27.0F, 0.0F);
		root.addChild(leftleg);
		leftleg.setTextureOffset(0, 193).addBox(-5.0F, -2.0F, -9.5F, 24.0F, 29.0F, 19.0F, 0.0F, true);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);

		animator.setAnimation(Netherite_Monstrosity_Entity.MONSTROSITY_CHARGE);
		animator.startKeyframe(15);
		animator.move(rightarm, -11, -5, 0);
		animator.rotate(rightarm, 0,  (float)Math.toRadians(-90F), 0);
		animator.rotate(rightarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(5F), 0, 0);
		animator.move(leftarm, 11, -5, 0);
		animator.rotate(leftarm, 0,  (float)Math.toRadians(90F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(lefthand, (float)Math.toRadians(5F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(15);

		animator.startKeyframe(5);
		animator.rotate(lowerbody, (float)Math.toRadians(50F), 0, 0);
		animator.rotate(leftleg, (float)Math.toRadians(65F), 0, 0);
		animator.move(leftleg, 0, 7, 0);
		animator.rotate(head, (float)Math.toRadians(-60F), 0, 0);
		animator.move(rightarm, -11, 15, 0);
		animator.rotate(rightarmjoint, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(rightarm, 0,  (float)Math.toRadians(-90F), 0);
		animator.rotate(rightarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(5F), 0, 0);
		animator.move(leftarm, 11, 15, 0);
		animator.rotate(leftarmjoint, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(leftarm, 0,  (float)Math.toRadians(90F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(lefthand, (float)Math.toRadians(5F), 0, 0);
		animator.endKeyframe();

		animator.startKeyframe(12);
		animator.rotate(lowerbody, (float)Math.toRadians(50F), 0, 0);
		animator.rotate(leftleg, (float)Math.toRadians(65F), 0, 0);
		animator.move(leftleg, 0, 7, 0);
		animator.rotate(head, (float)Math.toRadians(-40F), 0, 0);
		animator.move(rightarm, -11, 15, 0);
		animator.move(righthand, 0,-10,0);
		animator.rotate(rightarmjoint, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(rightarm, 0,  (float)Math.toRadians(-90F), 0);
		animator.rotate(rightarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(5F), 0, 0);
		animator.move(leftarm, 11, 15, 0);
		animator.move(lefthand, 0,-10,0);
		animator.rotate(leftarmjoint, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(leftarm, 0,  (float)Math.toRadians(90F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(lefthand, (float)Math.toRadians(5F), 0, 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(15);
		animator.startKeyframe(10);
		animator.move(rightarm, -11, -5, 0);
		animator.rotate(rightarm, 0,  (float)Math.toRadians(-90F), 0);
		animator.rotate(rightarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(5F), 0, 0);
		animator.move(leftarm, 11, -5, 0);
		animator.rotate(leftarm, 0,  (float)Math.toRadians(90F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(lefthand, (float)Math.toRadians(5F), 0, 0);
		animator.endKeyframe();
		animator.resetKeyframe(10);

		animator.setAnimation(Netherite_Monstrosity_Entity.MONSTROSITY_ERUPTIONATTACK);
		animator.startKeyframe(10);
		animator.move(rightarm, -11, -5, -4);
		animator.rotate(rightarm, 0,  (float)Math.toRadians(90F), 0);
		animator.rotate(rightarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(5F), 0, 0);
		animator.move(leftarm, 11, -5, -4);
		animator.rotate(leftarm, 0,  (float)Math.toRadians(-90F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(lefthand, (float)Math.toRadians(5F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(5);

		animator.startKeyframe(8);
		animator.rotate(upperbody, (float)Math.toRadians(-40F), 0, 0);
		animator.rotate(head, (float)Math.toRadians(-40F), 0, 0);
		animator.move(rightarm, -11, 13, -4);
		animator.move(rightarm2, 0,4,0);
		animator.rotate(rightarmjoint, (float)Math.toRadians(40F), 0, 0);
		animator.rotate(rightarm, 0,  (float)Math.toRadians(90F), 0);
		animator.rotate(rightarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(5F), 0, 0);
		animator.move(leftarm, 11, 13, -4);
		animator.move(leftarm2, 0,4,0);
		animator.rotate(leftarmjoint, (float)Math.toRadians(40F), 0, 0);
		animator.rotate(leftarm, 0,  (float)Math.toRadians(-90F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(lefthand, (float)Math.toRadians(5F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(5);

		animator.startKeyframe(6);
		animator.rotate(upperbody, (float)Math.toRadians(-70F), 0, 0);
		animator.rotate(head, (float)Math.toRadians(30F), 0, 0);
		animator.rotate(jaw, (float)Math.toRadians(67.5f), 0, 0);
		animator.move(rightarm, -11, 12, -14);
		animator.move(rightarm2, 0,-9,0);
		animator.rotate(rightarmjoint, (float)Math.toRadians(70F), 0, 0);
		animator.rotate(rightarm, 0,  (float)Math.toRadians(90F), 0);
		animator.rotate(rightarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(5F), 0, 0);
		animator.move(leftarm, 11, 12, -14);
		animator.move(leftarm2, 0,-9,0);
		animator.rotate(leftarmjoint, (float)Math.toRadians(70F), 0, 0);
		animator.rotate(leftarm, 0,  (float)Math.toRadians(-90F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(lefthand, (float)Math.toRadians(5F), 0, 0);
		animator.endKeyframe();

		animator.startKeyframe(6);
		animator.rotate(upperbody, (float)Math.toRadians(-40F), 0, 0);
		animator.rotate(head, (float)Math.toRadians(-40F), 0, 0);
		animator.move(rightarm, -11, 12, -4);
		animator.move(rightarm2, 0,4,0);
		animator.rotate(rightarmjoint, (float)Math.toRadians(40F), 0, 0);
		animator.rotate(rightarm, 0,  (float)Math.toRadians(90F), 0);
		animator.rotate(rightarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(5F), 0, 0);
		animator.move(leftarm, 11, 12, -4);
		animator.move(leftarm2, 0,4,0);
		animator.rotate(leftarmjoint, (float)Math.toRadians(40F), 0, 0);
		animator.rotate(leftarm, 0,  (float)Math.toRadians(-90F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(lefthand, (float)Math.toRadians(5F), 0, 0);
		animator.endKeyframe();
		animator.resetKeyframe(15);

		animator.setAnimation(Netherite_Monstrosity_Entity.MONSTROSITY_EARTHQUAKE);
		animator.startKeyframe(20);
		animator.rotate(upperbody, (float)Math.toRadians(-15F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(-25F), 0, 0);
		animator.rotate(jaw, (float)Math.toRadians(25f), 0, 0);
		animator.move(rightleg, 0, -6, -6);
		animator.rotate(leftleg, 0, (float)Math.toRadians(-25F), 0);
		animator.rotate(leftarm, (float)Math.toRadians(-160F), (float)Math.toRadians(20F), (float)Math.toRadians(-10F));
		animator.rotate(rightarm, (float)Math.toRadians(-160F), (float)Math.toRadians(-20F), (float)Math.toRadians(10F));
		animator.rotate(rightarm2, (float)Math.toRadians(-20F), 0, 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-20F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(10);

		animator.startKeyframe(5);
		animator.rotate(upperbody, (float)Math.toRadians(30F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(40F), 0, 0);
		animator.rotate(leftleg, (float)Math.toRadians(65F), 0, 0);
		animator.move(leftleg, 0, 7, 0);
		animator.rotate(head, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(leftarm, (float)Math.toRadians(-100F), (float)Math.toRadians(20F), (float)Math.toRadians(-10F));
		animator.rotate(rightarm, (float)Math.toRadians(-100F), (float)Math.toRadians(-20F), (float)Math.toRadians(10F));
		animator.rotate(rightarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(15);
		animator.resetKeyframe(25);

		animator.setAnimation(Netherite_Monstrosity_Entity.MONSTROSITY_EARTHQUAKE2);
		animator.startKeyframe(13);
		animator.rotate(upperbody, (float)Math.toRadians(-15F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(-25F), 0, 0);
		animator.rotate(jaw, (float)Math.toRadians(25f), 0, 0);
		animator.move(rightleg, 0, -6, -6);
		animator.rotate(leftleg, 0, (float)Math.toRadians(-25F), 0);
		animator.rotate(leftarm, (float)Math.toRadians(-160F), (float)Math.toRadians(20F), (float)Math.toRadians(-10F));
		animator.rotate(rightarm, (float)Math.toRadians(-160F), (float)Math.toRadians(-20F), (float)Math.toRadians(10F));
		animator.rotate(rightarm2, (float)Math.toRadians(-20F), 0, 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-20F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(7);

		animator.startKeyframe(5);
		animator.rotate(upperbody, (float)Math.toRadians(30F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(40F), 0, 0);
		animator.rotate(leftleg, (float)Math.toRadians(65F), 0, 0);
		animator.move(leftleg, 0, 7, 0);
		animator.rotate(head, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(leftarm, (float)Math.toRadians(-100F), (float)Math.toRadians(20F), (float)Math.toRadians(-10F));
		animator.rotate(rightarm, (float)Math.toRadians(-100F), (float)Math.toRadians(-20F), (float)Math.toRadians(10F));
		animator.rotate(rightarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(15);
		animator.resetKeyframe(25);

		animator.setAnimation(Netherite_Monstrosity_Entity.MONSTROSITY_EARTHQUAKE3);
		animator.startKeyframe(16);
		animator.rotate(upperbody, (float)Math.toRadians(-15F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(-25F), 0, 0);
		animator.rotate(jaw, (float)Math.toRadians(25f), 0, 0);
		animator.move(rightleg, 0, -6, -6);
		animator.rotate(leftleg, 0, (float)Math.toRadians(-25F), 0);
		animator.rotate(leftarm, (float)Math.toRadians(-160F), (float)Math.toRadians(20F), (float)Math.toRadians(-10F));
		animator.rotate(rightarm, (float)Math.toRadians(-160F), (float)Math.toRadians(-20F), (float)Math.toRadians(10F));
		animator.rotate(rightarm2, (float)Math.toRadians(-20F), 0, 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-20F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(9);

		animator.startKeyframe(5);
		animator.rotate(upperbody, (float)Math.toRadians(30F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(40F), 0, 0);
		animator.rotate(leftleg, (float)Math.toRadians(65F), 0, 0);
		animator.move(leftleg, 0, 7, 0);
		animator.rotate(head, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(leftarm, (float)Math.toRadians(-100F), (float)Math.toRadians(20F), (float)Math.toRadians(-10F));
		animator.rotate(rightarm, (float)Math.toRadians(-100F), (float)Math.toRadians(-20F), (float)Math.toRadians(10F));
		animator.rotate(rightarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(15);
		animator.resetKeyframe(25);

		animator.setAnimation(Netherite_Monstrosity_Entity.MONSTROSITY_BERSERK);
		animator.startKeyframe(16);
		animator.rotate(upperbody, (float)Math.toRadians(-15F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(-25F), 0, 0);
		animator.move(rightleg, 0, -6, -6);
		animator.rotate(leftleg, 0, (float)Math.toRadians(-25F), 0);
		animator.rotate(leftarm, (float)Math.toRadians(-160F), 0, (float)Math.toRadians(-5F));
		animator.rotate(rightarm, (float)Math.toRadians(-160F), 0, (float)Math.toRadians(5F));
		animator.rotate(rightarm2, (float)Math.toRadians(-20F), 0, 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-20F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(9);

		animator.startKeyframe(5);
		animator.rotate(upperbody, (float)Math.toRadians(15F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(30F), 0, 0);
		animator.move(head,0,-3,0);
		animator.rotate(head, (float)Math.toRadians(-60F), 0, 0);
		animator.move(leftarm, 0, 7, -15);
		animator.move(rightarm, 0, 7, -15);
		animator.move(leftarm2, 0, 3, 0);
		animator.move(rightarm2, 0, 3, 0);
		animator.rotate(rightarm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(leftarm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(rightarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(-40F), 0, 0);
		animator.rotate(lefthand, (float)Math.toRadians(-40F), 0, 0);
		animator.endKeyframe();

		animator.startKeyframe(10);
		animator.rotate(upperbody, (float)Math.toRadians(15F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(30F), 0, 0);
		animator.rotate(head, (float)Math.toRadians(-50F), (float)Math.toRadians(-10F), (float)Math.toRadians(10F));
		animator.rotate(jaw, (float)Math.toRadians(32.5f), 0, 0);
		animator.move(leftarm, 0, 7, -15);
		animator.move(rightarm, 0, 7, -15);
		animator.move(leftarm2, 0, 3, 0);
		animator.move(rightarm2, 0, 3, 0);
		animator.rotate(rightarm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(leftarm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(rightarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(-40F), 0, 0);
		animator.rotate(lefthand, (float)Math.toRadians(-40F), 0, 0);
		animator.endKeyframe();

		animator.startKeyframe(10);
		animator.rotate(upperbody, (float)Math.toRadians(15F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(30F), 0, 0);
		animator.rotate(head, (float)Math.toRadians(-50F), (float)Math.toRadians(10F), (float)Math.toRadians(-10F));
		animator.rotate(jaw, (float)Math.toRadians(32.5f), 0, 0);
		animator.move(leftarm, 0, 7, -15);
		animator.move(rightarm, 0, 7, -15);
		animator.move(leftarm2, 0, 3, 0);
		animator.move(rightarm2, 0, 3, 0);
		animator.rotate(rightarm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(leftarm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(rightarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(-40F), 0, 0);
		animator.rotate(lefthand, (float)Math.toRadians(-40F), 0, 0);
		animator.endKeyframe();

		animator.startKeyframe(5);
		animator.rotate(upperbody, (float)Math.toRadians(15F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(30F), 0, 0);
		animator.move(head,0,-3,0);
		animator.rotate(head, (float)Math.toRadians(-60F), 0, 0);
		animator.rotate(jaw, (float)Math.toRadians(22.5f), 0, 0);
		animator.move(leftarm, 0, 7, -15);
		animator.move(rightarm, 0, 7, -15);
		animator.move(leftarm2, 0, 3, 0);
		animator.move(rightarm2, 0, 3, 0);
		animator.rotate(rightarm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(leftarm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(rightarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(-40F), 0, 0);
		animator.rotate(lefthand, (float)Math.toRadians(-40F), 0, 0);
		animator.endKeyframe();

		animator.startKeyframe(5);
		animator.rotate(upperbody, (float)Math.toRadians(15F), 0, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(30F), 0, 0);
		animator.move(head,0,-3,0);
		animator.rotate(head, (float)Math.toRadians(-40F), 0, 0);
		animator.move(leftarm, 0, 7, -15);
		animator.move(rightarm, 0, 7, -15);
		animator.move(leftarm2, 0, 3, 0);
		animator.move(rightarm2, 0, 3, 0);
		animator.rotate(rightarm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(leftarm, (float)Math.toRadians(-50F), 0, 0);
		animator.rotate(rightarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-30F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(-40F), 0, 0);
		animator.rotate(lefthand, (float)Math.toRadians(-40F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(5);
		animator.resetKeyframe(15);

		animator.setAnimation(Netherite_Monstrosity_Entity.MONSTROSITY_DEATH);
		animator.startKeyframe(7);
		animator.rotate(upperbody, (float)Math.toRadians(-5F), (float)Math.toRadians(-10F), 0);
		animator.rotate(leftarm, (float)Math.toRadians(-10f), (float)Math.toRadians(-30F), 0);
		animator.rotate(rightarm, (float)Math.toRadians(-10f), (float)Math.toRadians(30F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-15f), 0, 0);
		animator.rotate(rightarm2, (float)Math.toRadians(-15f), 0, 0);
		animator.rotate(righthand, 0, (float)Math.toRadians(-25f), 0);
		animator.rotate(lefthand, 0, (float)Math.toRadians(25f), 0);
		animator.rotate(head, (float)Math.toRadians(-5F), (float)Math.toRadians(-20F), 0);
		animator.rotate(jaw, (float)Math.toRadians(17.5f), 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(7);
		animator.rotate(upperbody, (float)Math.toRadians(-5F), (float)Math.toRadians(10F), 0);
		animator.rotate(leftarm, (float)Math.toRadians(-10f), (float)Math.toRadians(-30F), 0);
		animator.rotate(rightarm, (float)Math.toRadians(-10f), (float)Math.toRadians(30F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-10f), 0, 0);
		animator.rotate(rightarm2, (float)Math.toRadians(-10f), 0, 0);
		animator.rotate(righthand, 0, (float)Math.toRadians(-25f), 0);
		animator.rotate(lefthand, 0, (float)Math.toRadians(25f), 0);
		animator.rotate(head, (float)Math.toRadians(-5F), (float)Math.toRadians(20F), 0);
		animator.rotate(jaw, (float)Math.toRadians(27.5f), 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(7);
		animator.rotate(upperbody, (float)Math.toRadians(-5F), (float)Math.toRadians(-10F), 0);
		animator.rotate(leftarm, (float)Math.toRadians(-10f), (float)Math.toRadians(-30F), 0);
		animator.rotate(rightarm, (float)Math.toRadians(-10f), (float)Math.toRadians(30F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-15f), 0, 0);
		animator.rotate(rightarm2, (float)Math.toRadians(-15f), 0, 0);
		animator.rotate(righthand, 0, (float)Math.toRadians(-25f), 0);
		animator.rotate(lefthand, 0, (float)Math.toRadians(25f), 0);
		animator.rotate(head, (float)Math.toRadians(-5F), (float)Math.toRadians(-20F), 0);
		animator.rotate(jaw, (float)Math.toRadians(17.5f), 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(7);
		animator.rotate(upperbody, (float)Math.toRadians(-5F), (float)Math.toRadians(10F), 0);
		animator.rotate(leftarm, (float)Math.toRadians(-10f), (float)Math.toRadians(-30F), 0);
		animator.rotate(rightarm, (float)Math.toRadians(-10f), (float)Math.toRadians(30F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-10f), 0, 0);
		animator.rotate(rightarm2, (float)Math.toRadians(-10f), 0, 0);
		animator.rotate(righthand, 0, (float)Math.toRadians(-25f), 0);
		animator.rotate(lefthand, 0, (float)Math.toRadians(25f), 0);
		animator.rotate(head, (float)Math.toRadians(-5F), (float)Math.toRadians(20F), 0);
		animator.rotate(jaw, (float)Math.toRadians(27.5f), 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(7);
		animator.rotate(upperbody, (float)Math.toRadians(-5F), (float)Math.toRadians(-10F), 0);
		animator.rotate(leftarm, (float)Math.toRadians(-10f), (float)Math.toRadians(-30F), 0);
		animator.rotate(rightarm, (float)Math.toRadians(-10f), (float)Math.toRadians(30F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-15f), 0, 0);
		animator.rotate(rightarm2, (float)Math.toRadians(-15f), 0, 0);
		animator.rotate(righthand, 0, (float)Math.toRadians(-25f), 0);
		animator.rotate(lefthand, 0, (float)Math.toRadians(25f), 0);
		animator.rotate(head, (float)Math.toRadians(-5F), (float)Math.toRadians(-10F), 0);
		animator.rotate(jaw, (float)Math.toRadians(17.5f), 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(7);
		animator.rotate(upperbody, (float)Math.toRadians(-5F), (float)Math.toRadians(10F), 0);
		animator.rotate(leftarm, (float)Math.toRadians(-10f), (float)Math.toRadians(-30F), 0);
		animator.rotate(rightarm, (float)Math.toRadians(-10f), (float)Math.toRadians(30F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-10f), 0, 0);
		animator.rotate(rightarm2, (float)Math.toRadians(-10f), 0, 0);
		animator.rotate(righthand, 0, (float)Math.toRadians(-25f), 0);
		animator.rotate(lefthand, 0, (float)Math.toRadians(25f), 0);
		animator.rotate(head, (float)Math.toRadians(-5F), (float)Math.toRadians(20F), 0);
		animator.rotate(jaw, (float)Math.toRadians(27.5f), 0, 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(8);
		animator.rotate(root, (float)Math.toRadians(-35F), 0, 0);
		animator.move(root, 0, -5, 0);
		animator.rotate(lowerbody, (float)Math.toRadians(40F), 0, 0);
		animator.rotate(leftleg, (float)Math.toRadians(35F), 0, 0);
		animator.rotate(jaw, (float)Math.toRadians(20f), 0, 0);
		animator.rotate(leftarm, (float)Math.toRadians(-7.5F), (float)Math.toRadians(-35F), 0);
		animator.rotate(rightarm, (float)Math.toRadians(-7.5F), (float)Math.toRadians(35F), 0);
		animator.rotate(leftarm2, (float)Math.toRadians(-15f), 0, 0);
		animator.rotate(rightarm2, (float)Math.toRadians(-15f), 0, 0);
		animator.rotate(righthand, 0, (float)Math.toRadians(-25f), 0);
		animator.rotate(lefthand, 0, (float)Math.toRadians(25f), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(5);
		animator.rotate(root, (float)Math.toRadians(-90F), 0, 0);
		animator.move(root, 0, -9, 0);
		animator.move(lowerbody, 0, 0,-3);
		animator.rotate(lowerbody, (float)Math.toRadians(80F), 0, 0);
		animator.rotate(head, (float)Math.toRadians(5F), 0, (float)Math.toRadians(-7.5f));
		animator.rotate(jaw, (float)Math.toRadians(25f), 0, 0);
		animator.move(leftleg,0,5,0);
		animator.move(rightleg,0,5,0);
		animator.rotate(leftleg, 0, 0, (float)Math.toRadians(-15F));
		animator.rotate(rightleg, 0, 0, (float)Math.toRadians(15F));
		animator.move(leftarm, 0,5,0);
		animator.move(rightarm, 0,5,0);
		animator.rotate(leftarm, (float)Math.toRadians(-15F), (float)Math.toRadians(-40F), 0);
		animator.rotate(rightarm, (float)Math.toRadians(-15F), (float)Math.toRadians(40F), 0);
		animator.rotate(leftarm, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(rightarm, (float)Math.toRadians(7.5F), 0, 0);
		animator.rotate(righthand, (float)Math.toRadians(-5F), (float)Math.toRadians(-12.5f), 0);
		animator.rotate(lefthand, (float)Math.toRadians(-5F), (float)Math.toRadians(12.5f), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(110);
	}

	@Override
	public void setupAnim(Netherite_Monstrosity_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		float walkSpeed = 0.35F;
		float walkDegree = 0.5F;
		float jawSpeed = 0.2F;


		this.faceTarget(netHeadYaw, headPitch, 1, head);
		this.walk(leftleg, walkSpeed, walkDegree * 1.0F, false, -25F, 0F, limbSwing, limbSwingAmount);
		this.flap(root, walkSpeed, walkDegree * 0.1F, false, 0F, 0F, limbSwing, limbSwingAmount);
		this.walk(rightleg, walkSpeed, walkDegree * 1.0F, true, -25F, 0F, limbSwing, limbSwingAmount);
		float leftLegS = (float) (Math.sin((double) (limbSwing * walkSpeed) - 2.5F) * (double) limbSwingAmount * (double) walkDegree - (double) (limbSwingAmount * walkDegree));
		float rightLegS = (float) (Math.sin(-(double) (limbSwing * walkSpeed) + 2.5F) * (double) limbSwingAmount * (double) walkDegree - (double) (limbSwingAmount * walkDegree));
		this.leftleg.rotationPointY += 6F * leftLegS;
		this.rightleg.rotationPointY += 6F * rightLegS;
		this.leftleg.rotationPointZ += 8F * leftLegS;
		this.rightleg.rotationPointZ += 8F * rightLegS;
		this.walk(leftarm, walkSpeed, walkDegree * 0.5F, false, 0F, 0F, limbSwing, limbSwingAmount);
		this.walk(rightarm, walkSpeed, walkDegree * 0.5F, true, 0F, 0F, limbSwing, limbSwingAmount);
		this.walk(jaw, jawSpeed, walkDegree * 0.8F, true, 0F, -0.4F, limbSwing, limbSwingAmount);

		float partialTick = Minecraft.getInstance().getFrameTime();
		float deactivateProgress = entityIn.prevdeactivateProgress + (entityIn.deactivateProgress - entityIn.prevdeactivateProgress) * partialTick;

		progressRotationPrev(lowerbody,deactivateProgress,(float)Math.toRadians(50F), 0, 0, 40f);
		progressRotationPrev(leftleg, deactivateProgress,(float)Math.toRadians(65F), 0, 0, 40f);
		progressPositionPrev(leftleg, deactivateProgress,0, 7, 0, 40f);
		progressRotationPrev(jaw, deactivateProgress,(float)Math.toRadians(-7.5f), 0, 0, 40f);
		progressPositionPrev(rightarm, deactivateProgress,-11, 15, 0, 40f);
		progressPositionPrev(righthand, deactivateProgress,0,-10,0, 40f);
		progressRotationPrev(rightarmjoint, deactivateProgress,(float)Math.toRadians(-50F), 0, 0, 40f);
		progressRotationPrev(rightarm, deactivateProgress,0,  (float)Math.toRadians(-90F), 0, 40f);
		progressRotationPrev(rightarm2, deactivateProgress,(float)Math.toRadians(7.5F), 0, 0, 40f);
		progressRotationPrev(righthand, deactivateProgress,(float)Math.toRadians(5F), 0, 0, 40f);
		progressPositionPrev(leftarm, deactivateProgress,11, 15, 0, 40f);
		progressPositionPrev(lefthand, deactivateProgress,0,-10,0, 40f);
		progressRotationPrev(leftarmjoint, deactivateProgress,(float)Math.toRadians(-50F), 0, 0, 40f);
		progressRotationPrev(leftarm, deactivateProgress,0,  (float)Math.toRadians(90F), 0, 40f);
		progressRotationPrev(leftarm2, deactivateProgress,(float)Math.toRadians(7.5F), 0, 0, 40f);
		progressRotationPrev(lefthand, deactivateProgress,(float)Math.toRadians(5F), 0, 0, 40f);


	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				leftarmjoint,
				rightarmjoint,
				leftarm,
				rightarm,
				leftarm2,
				rightarm2,
				lefthand,
				righthand,
				leftfinger1,
				rightfinger1,
				leftfinger2,
				rightfinger2,
				leftfinger3,
				rightfinger3,
				leftleg,
				rightleg,
				head,
				jaw,
				lowerbody,
				upperbody);
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