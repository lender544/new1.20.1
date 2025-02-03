package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.Deepling.Coral_Golem_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class Coral_Golem_Model extends AdvancedEntityModel<Coral_Golem_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox lower_body;
	private final AdvancedModelBox upper_body;
	private final AdvancedModelBox helmet;
	private final AdvancedModelBox chest;
	private final AdvancedModelBox table_coral;
	private final AdvancedModelBox blue_table_coral;
	private final AdvancedModelBox red_table_coral;
	private final AdvancedModelBox right_arm;
	private final AdvancedModelBox right_fist;
	private final AdvancedModelBox right_coral;
	private final AdvancedModelBox left_arm;
	private final AdvancedModelBox left_fist;
	private final AdvancedModelBox left_coral;
	private final AdvancedModelBox coral_shoulder;
	private final AdvancedModelBox head;
	private final AdvancedModelBox right_leg;
	private final AdvancedModelBox left_leg;
	private ModelAnimator animator;

	public Coral_Golem_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		lower_body = new AdvancedModelBox(this);
		lower_body.setRotationPoint(0.0F, -6.3F, -1.8F);
		root.addChild(lower_body);
		setRotationAngle(lower_body, 0.1745F, 0.0F, 0.0F);
		lower_body.setTextureOffset(0, 21).addBox(-6.0F, -8.0F, -4.0F, 12.0F, 8.0F, 8.0F, 0.0F, false);

		upper_body = new AdvancedModelBox(this);
		upper_body.setRotationPoint(0.0F, -6.2F, 2.8F);
		lower_body.addChild(upper_body);
		setRotationAngle(upper_body, 0.6981F, 0.0F, 0.0F);


		helmet = new AdvancedModelBox(this);
		helmet.setRotationPoint(-0.5F, -11.0F, -6.5F);
		upper_body.addChild(helmet);
		setRotationAngle(helmet, -0.6109F, 0.0F, 0.0F);
		helmet.setTextureOffset(54, 59).addBox(-3.5F, -7.5F, -3.5F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		helmet.setTextureOffset(89, 31).addBox(4.5F, -6.5F, -2.5F, 1.0F, 6.0F, 6.0F, 0.0F, false);
		helmet.setTextureOffset(87, 66).addBox(-4.5F, -6.5F, -2.5F, 1.0F, 6.0F, 6.0F, 0.0F, false);
		helmet.setTextureOffset(35, 32).addBox(-6.5F, -0.5F, -2.5F, 14.0F, 7.0F, 6.0F, 0.0F, false);
		helmet.setTextureOffset(21, 78).addBox(5.5F, -1.5F, -3.5F, 2.0F, 5.0F, 8.0F, 0.0F, false);
		helmet.setTextureOffset(65, 76).addBox(-6.5F, -1.5F, -3.5F, 2.0F, 5.0F, 8.0F, 0.0F, false);
		helmet.setTextureOffset(47, 0).addBox(-1.5F, -8.5F, -1.5F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		helmet.setTextureOffset(86, 0).addBox(0.5F, -14.25F, 0.5F, 9.0F, 9.0F, 0.0F, 0.0F, false);

		chest = new AdvancedModelBox(this);
		chest.setRotationPoint(0.0F, -3.5F, -3.0F);
		upper_body.addChild(chest);
		chest.setTextureOffset(0, 0).addBox(-9.0F, -6.5F, -4.75F, 18.0F, 10.0F, 10.0F, 0.0F, false);

		table_coral = new AdvancedModelBox(this);
		table_coral.setRotationPoint(8.0F, -2.0F, 5.0F);
		chest.addChild(table_coral);
		table_coral.setTextureOffset(46, 24).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		table_coral.setTextureOffset(59, 23).addBox(-1.0F, 1.0F, -2.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		blue_table_coral = new AdvancedModelBox(this);
		blue_table_coral.setRotationPoint(-5.0F, -3.0F, 0.0F);
		table_coral.addChild(blue_table_coral);
		blue_table_coral.setTextureOffset(44, 76).addBox(0.0F, -5.5F, -1.75F, 0.0F, 10.0F, 10.0F, 0.0F, false);

		red_table_coral = new AdvancedModelBox(this);
		red_table_coral.setRotationPoint(-3.0F, -3.0F, 0.0F);
		table_coral.addChild(red_table_coral);
		red_table_coral.setTextureOffset(78, 82).addBox(0.0F, -4.5F, 0.25F, 0.0F, 8.0F, 8.0F, 0.0F, false);

		right_arm = new AdvancedModelBox(this);
		right_arm.setRotationPoint(-9.0F, -6.7F, -1.7F);
		chest.addChild(right_arm);
		setRotationAngle(right_arm, -0.6109F, 0.0F, 0.0F);
		right_arm.setTextureOffset(57, 0).addBox(-6.0F, -4.0F, -4.0F, 6.0F, 14.0F, 8.0F, 0.0F, false);
		right_arm.setTextureOffset(29, 46).addBox(-7.1F, 2.0F, -5.0F, 9.0F, 2.0F, 10.0F, 0.0F, false);
		right_arm.setTextureOffset(76, 13).addBox(-0.1F, -5.0F, -5.0F, 2.0F, 7.0F, 10.0F, 0.0F, false);

		right_fist = new AdvancedModelBox(this);
		right_fist.setRotationPoint(-3.0F, 6.6F, -2.0F);
		right_arm.addChild(right_fist);
		setRotationAngle(right_fist, -0.2618F, 0.0F, 0.0F);
		right_fist.setTextureOffset(21, 59).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 9.0F, 8.0F, 0.0F, false);

		right_coral = new AdvancedModelBox(this);
		right_coral.setRotationPoint(-4.0F, 6.0F, 0.0F);
		right_fist.addChild(right_coral);
		right_coral.setTextureOffset(0, 86).addBox(-8.0F, -8.0F, 0.0F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		left_arm = new AdvancedModelBox(this);
		left_arm.setRotationPoint(9.0F, -6.7F, -1.7F);
		chest.addChild(left_arm);
		setRotationAngle(left_arm, -0.6109F, 0.0F, 0.0F);
		left_arm.setTextureOffset(0, 0).addBox(-1.0F, 8.0F, -4.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		left_arm.setTextureOffset(0, 38).addBox(0.0F, -4.0F, -4.0F, 6.0F, 14.0F, 8.0F, 0.0F, false);
		left_arm.setTextureOffset(33, 21).addBox(3.0F, -1.0F, -5.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		left_arm.setTextureOffset(21, 38).addBox(5.0F, 2.0F, -5.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		left_fist = new AdvancedModelBox(this);
		left_fist.setRotationPoint(3.0F, 6.6F, -2.0F);
		left_arm.addChild(left_fist);
		setRotationAngle(left_fist, -0.2618F, 0.0F, 0.0F);
		left_fist.setTextureOffset(21, 59).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 9.0F, 8.0F, 0.0F, true);

		left_coral = new AdvancedModelBox(this);
		left_coral.setRotationPoint(4.0F, 6.0F, 0.0F);
		left_fist.addChild(left_coral);
		left_coral.setTextureOffset(0, 86).addBox(0.0F, -8.0F, 0.0F, 8.0F, 11.0F, 0.0F, 0.0F, true);

		coral_shoulder = new AdvancedModelBox(this);
		coral_shoulder.setRotationPoint(-1.0F, -1.0F, 0.0F);
		left_arm.addChild(coral_shoulder);
		coral_shoulder.setTextureOffset(79, 55).addBox(4.0F, -10.0F, -1.0F, 9.0F, 10.0F, 0.0F, 0.0F, false);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, 2.5F, 1.0F);
		upper_body.addChild(head);


		right_leg = new AdvancedModelBox(this);
		right_leg.setRotationPoint(-6.0F, -8.0F, 0.0F);
		root.addChild(right_leg);
		right_leg.setTextureOffset(0, 69).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 8.0F, 8.0F, 0.0F, false);

		left_leg = new AdvancedModelBox(this);
		left_leg.setRotationPoint(6.0F, -8.0F, 0.0F);
		root.addChild(left_leg);
		left_leg.setTextureOffset(68, 38).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 8.0F, 8.0F, 0.0F, false);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	public void animate(Coral_Golem_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(Coral_Golem_Entity.CORAL_GOLEM_LEAP);
		animator.setStaticKeyframe(5);
		animator.startKeyframe(15);
		animator.move(lower_body,0, 2f, 0);
		animator.rotate(upper_body, (float)Math.toRadians(7.5F),0, 0);
		animator.rotate(helmet, (float)Math.toRadians(-12.5F),0, 0);
		animator.rotate(right_arm, (float)Math.toRadians(-65F),(float)Math.toRadians(5F), (float)Math.toRadians(2.5F));
		animator.rotate(right_fist, (float)Math.toRadians(12.5F),0, 0);
		animator.rotate(left_arm, (float)Math.toRadians(-65F),(float)Math.toRadians(-5F), (float)Math.toRadians(-2F));
		animator.rotate(left_fist, (float)Math.toRadians(15F),0, 0);
		animator.move(right_leg, 0,0, 3);
		animator.move(left_leg, 0,0, -3);
		animator.endKeyframe();

		animator.startKeyframe(10);
		animator.rotate(lower_body, (float)Math.toRadians(-15F),0, 0);
		animator.rotate(upper_body, (float)Math.toRadians(-52.5F),0, 0);
		animator.rotate(helmet, (float)Math.toRadians(45F),0, 0);
		animator.rotate(right_arm, (float)Math.toRadians(-187.5F),(float)Math.toRadians(-2.5F), (float)Math.toRadians(-5F));
		animator.rotate(right_fist, (float)Math.toRadians(12.5F),0, 0);
		animator.rotate(left_arm, (float)Math.toRadians(-185F),(float)Math.toRadians(5F), (float)Math.toRadians(5F));
		animator.rotate(left_fist, (float)Math.toRadians(15F),0, 0);
		animator.move(right_leg, 0,0, 1);
		animator.move(left_leg, 0,-2, -5);
		animator.endKeyframe();

		animator.setStaticKeyframe(60);

		animator.resetKeyframe(10);


		animator.setAnimation(Coral_Golem_Entity.CORAL_GOLEM_SMASH);
		animator.startKeyframe(0);
		animator.rotate(lower_body, (float)Math.toRadians(-15F),0, 0);
		animator.rotate(upper_body, (float)Math.toRadians(-52.5F),0, 0);
		animator.rotate(helmet, (float)Math.toRadians(45F),0, 0);
		animator.rotate(right_arm, (float)Math.toRadians(-187.5F),(float)Math.toRadians(-2.5F), (float)Math.toRadians(-5F));
		animator.rotate(right_fist, (float)Math.toRadians(12.5F),0, 0);
		animator.rotate(left_arm, (float)Math.toRadians(-185F),(float)Math.toRadians(5F), (float)Math.toRadians(5F));
		animator.rotate(left_fist, (float)Math.toRadians(15F),0, 0);
		animator.move(right_leg, 0,0, 1);
		animator.move(left_leg, 0,-2, -5);
		animator.endKeyframe();


		animator.startKeyframe(3);
		animator.rotate(lower_body, (float)Math.toRadians(7.5F),0, 0);
		animator.rotate(helmet, (float)Math.toRadians(27.5F),0, 0);
		animator.rotate(right_arm, (float)Math.toRadians(-55F),(float)Math.toRadians(-7.5F), 0);
		animator.rotate(right_fist, (float)Math.toRadians(12.5F),0, 0);
		animator.rotate(left_arm, (float)Math.toRadians(-55F),0, (float)Math.toRadians(7.5F));
		animator.rotate(left_fist, (float)Math.toRadians(15F),0, 0);
		animator.move(right_leg, 0,0, -4);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.resetKeyframe(10);

		animator.setAnimation(Coral_Golem_Entity.CORAL_GOLEM_LEFT_SMASH);
		animator.startKeyframe(10);
		animator.rotate(lower_body,(float)Math.toRadians(-7.5F), 0, 0);
		animator.rotate(upper_body, (float)Math.toRadians(-17.5F),(float)Math.toRadians(-10F), (float)Math.toRadians(-5F));
		animator.rotate(helmet, (float)Math.toRadians(12.5F),(float)Math.toRadians(5F), (float)Math.toRadians(-2.5F));
		animator.move(right_arm, -1,3,-2);
		animator.rotate(right_arm, (float)Math.toRadians(10F),(float)Math.toRadians(7.5F), (float)Math.toRadians(5F));
		animator.rotate(right_fist, (float)Math.toRadians(7.5F),0, 0);
		animator.move(left_arm, -1,0,3);
		animator.rotate(left_arm, (float)Math.toRadians(-142.5F),(float)Math.toRadians(-5F), (float)Math.toRadians(5F));
		animator.rotate(left_fist, (float)Math.toRadians(-25F),0, 0);
		animator.move(right_leg, 0,0, -4);
		animator.move(left_leg, 0,0, 1);
		animator.endKeyframe();
		animator.setStaticKeyframe(5);

		animator.startKeyframe(1);
		animator.rotate(lower_body,(float)Math.toRadians(5F), (float)Math.toRadians(5F), 0);
		animator.rotate(upper_body, (float)Math.toRadians(-15F),(float)Math.toRadians(10F), (float)Math.toRadians(2.5F));
		animator.rotate(helmet, (float)Math.toRadians(2.5F),(float)Math.toRadians(5F), (float)Math.toRadians(-2.5F));
		animator.move(right_arm, 0,3,0);
		animator.rotate(right_arm, (float)Math.toRadians(25F),(float)Math.toRadians(-10F), (float)Math.toRadians(-2.5F));
		animator.rotate(right_fist, (float)Math.toRadians(-15F),0, 0);
		animator.move(left_arm, -2,2,-1);
		animator.rotate(left_arm, (float)Math.toRadians(-10F),(float)Math.toRadians(2.5F), (float)Math.toRadians(12.5F));
		animator.rotate(left_fist, (float)Math.toRadians(-25F),0, 0);
		animator.move(left_leg, 0,0, -3);
		animator.endKeyframe();
		animator.setStaticKeyframe(10);

		animator.resetKeyframe(10);

		animator.setAnimation(Coral_Golem_Entity.CORAL_GOLEM_RIGHT_SMASH);
		animator.startKeyframe(10);
		animator.rotate(lower_body,(float)Math.toRadians(-7.5F), 0, 0);
		animator.rotate(upper_body, (float)Math.toRadians(-17.5F),(float)Math.toRadians(10F), (float)Math.toRadians(5F));
		animator.rotate(helmet, (float)Math.toRadians(12.5F),(float)Math.toRadians(-5F), (float)Math.toRadians(2.5F));

		animator.move(left_arm, 0,3,-2);
		animator.rotate(left_arm, (float)Math.toRadians(10F),(float)Math.toRadians(-7.5F), (float)Math.toRadians(-5F));

		animator.rotate(left_fist, (float)Math.toRadians(7.5F),0, 0);

		animator.move(right_arm, 1,0,3);
		animator.rotate(right_arm, (float)Math.toRadians(-142.5F),(float)Math.toRadians(5F), (float)Math.toRadians(-5F));
		animator.rotate(right_fist, (float)Math.toRadians(-25F),0, 0);
		animator.move(left_leg, 0,0, -4);
		animator.move(right_leg, 0,0, 1);
		animator.endKeyframe();
		animator.setStaticKeyframe(5);

		animator.startKeyframe(1);
		animator.rotate(lower_body,(float)Math.toRadians(5F), (float)Math.toRadians(-5F), 0);
		animator.rotate(upper_body, (float)Math.toRadians(-15F),(float)Math.toRadians(-10F), (float)Math.toRadians(-2.5F));
		animator.rotate(helmet, (float)Math.toRadians(2.5F),(float)Math.toRadians(-5F), (float)Math.toRadians(2.5F));
		animator.move(left_arm, 0,3,0);
		animator.rotate(left_arm, (float)Math.toRadians(25F),(float)Math.toRadians(10F), (float)Math.toRadians(2.5F));
		animator.rotate(left_fist, (float)Math.toRadians(-15F),0, 0);
		animator.move(right_arm, 2,2,-1);
		animator.rotate(right_arm, (float)Math.toRadians(-10F),(float)Math.toRadians(-2.5F), (float)Math.toRadians(-12.5F));
		animator.rotate(right_fist, (float)Math.toRadians(-25F),0, 0);
		animator.move(right_leg, 0,0, -3);
		animator.endKeyframe();
		animator.setStaticKeyframe(10);

		animator.resetKeyframe(10);

	}

	@Override
	public void setupAnim(Coral_Golem_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		float walkSpeed = 0.5F;
		float walkDegree = 0.5F;
		float partialTick = Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);
		float swim = entityIn.getSwimAmount(partialTick);
		float swimSpeed = 0.25F;
		float swimDegree = 0.5F;
		float swimAmount = limbSwingAmount * swim;


		this.faceTarget(netHeadYaw, headPitch, 1, head);
		this.walk(left_leg, walkSpeed, walkDegree * 1.2F, true, 0F, 0F, limbSwing, limbSwingAmount);
		this.flap(root, walkSpeed, walkDegree * 0.2F, false, 0F, 0F, limbSwing, limbSwingAmount);
		this.walk(right_leg, walkSpeed, walkDegree * 1.2F, false, 0F, 0F, limbSwing, limbSwingAmount);
		this.walk(left_arm, walkSpeed, walkDegree * 1.2F, false, 0F, 0F, limbSwing, limbSwingAmount);
		this.walk(right_arm, walkSpeed, walkDegree * 1.2F, true, 0F, 0F, limbSwing, limbSwingAmount);


		progressRotationPrev(root, swim, 0, 0, (float) Math.toRadians(-10), 1F);
		progressRotationPrev(lower_body, swim, (float) Math.toRadians(17.5F), 0, 0, 1F);
		progressRotationPrev(head,swim,(float)Math.toRadians(-22.5F), 0, 0, 1f);
		progressRotationPrev(right_arm,swim,(float)Math.toRadians(35F), 0, (float)Math.toRadians(50F), 1f);
		progressRotationPrev(left_arm,swim,(float)Math.toRadians(35F), 0, (float)Math.toRadians(-50F), 1f);
		progressRotationPrev(right_leg,swim,(float)Math.toRadians(90F), 0, 0, 1f);
		progressRotationPrev(left_leg,swim,(float)Math.toRadians(117.5F), 0, 0, 1f);


		this.flap(root, swimSpeed, swimDegree * 1F, true, 0F, 0F, limbSwing, swimAmount);

		this.flap(left_arm, swimSpeed, swimDegree * 2.75F, true, -0.5F, 1.5F, limbSwing, swimAmount);
		this.flap(right_arm, swimSpeed, swimDegree * 2.75F, false, -0.5F, 1.5F, limbSwing, swimAmount);

		this.walk(right_leg, swimSpeed * 1.5F, swimDegree * 1F, true, 2F, 0.0F, limbSwing, swimAmount);
		this.walk(left_leg, swimSpeed * 1.5F, swimDegree * 1F, false, 2F, 0.0F, limbSwing, swimAmount);

	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				lower_body,
				upper_body,
				helmet,
				chest,
				table_coral,
				blue_table_coral,
				red_table_coral,
				right_arm,
				right_fist,
				right_coral,
				left_arm,
				left_fist,
				left_coral,
				coral_shoulder,
				head,
				right_leg,
				left_leg);
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