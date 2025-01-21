package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;

public class Ignited_Revenant_Model extends AdvancedEntityModel<Ignited_Revenant_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox body;
	private final AdvancedModelBox guardingring;
	private final AdvancedModelBox guardingring2;
	private final AdvancedModelBox shieldjoint;
	private final AdvancedModelBox shield;
	private final AdvancedModelBox right_parts;
	private final AdvancedModelBox left_parts;
	private final AdvancedModelBox spike_right;
	private final AdvancedModelBox spike_left;
	private final AdvancedModelBox shieldjoint2;
	private final AdvancedModelBox shield2;
	private final AdvancedModelBox right_parts2;
	private final AdvancedModelBox left_parts2;
	private final AdvancedModelBox spike_right2;
	private final AdvancedModelBox spike_left2;
	private final AdvancedModelBox shieldjoint3;
	private final AdvancedModelBox shield3;
	private final AdvancedModelBox right_parts3;
	private final AdvancedModelBox left_parts3;
	private final AdvancedModelBox spike_right3;
	private final AdvancedModelBox spike_left3;
	private final AdvancedModelBox shieldjoint4;
	private final AdvancedModelBox shield4;
	private final AdvancedModelBox right_parts4;
	private final AdvancedModelBox left_parts4;
	private final AdvancedModelBox spike_right4;
	private final AdvancedModelBox spike_left4;
	private final AdvancedModelBox center;
	private final AdvancedModelBox head;
	private final AdvancedModelBox jaw;
	private final AdvancedModelBox skull;
	private final AdvancedModelBox helmet;
	private final AdvancedModelBox right_horn;
	private final AdvancedModelBox left_horn;
	private ModelAnimator animator;

	public Ignited_Revenant_Model() {
		texWidth = 128;
		texHeight = 128;


		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		body = new AdvancedModelBox(this);
		body.setRotationPoint(0.0F, -6.0F, 0.0F);
		root.addChild(body);


		guardingring = new AdvancedModelBox(this);
		guardingring.setRotationPoint(0.0F, -15.0F, 0.0F);
		body.addChild(guardingring);


		guardingring2 = new AdvancedModelBox(this);
		guardingring2.setRotationPoint(0.0F, 0.0F, 0.0F);
		guardingring.addChild(guardingring2);


		shieldjoint = new AdvancedModelBox(this);
		shieldjoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		guardingring2.addChild(shieldjoint);
		setRotationAngle(shieldjoint, 0.0F, -0.7854F, 0.0F);


		shield = new AdvancedModelBox(this);
		shield.setRotationPoint(0.0F, -4.8F, -12.3F);
		shieldjoint.addChild(shield);
		setRotationAngle(shield, -0.2182F, 0.0F, 0.0F);
		shield.setTextureOffset(33, 0).addBox(-3.5F, -3.0F, -1.0F, 7.0F, 21.0F, 1.0F, 0.0F, false);
		shield.setTextureOffset(69, 61).addBox(-4.0F, -5.0F, -1.5F, 8.0F, 5.0F, 2.0F, 0.0F, false);
		shield.setTextureOffset(63, 15).addBox(-4.0F, 15.0F, -1.25F, 8.0F, 5.0F, 2.0F, 0.0F, false);
		shield.setTextureOffset(34, 66).addBox(-3.0F, 2.0F, -1.5F, 6.0F, 12.0F, 0.0F, 0.0F, false);

		right_parts = new AdvancedModelBox(this);
		right_parts.setRotationPoint(-3.5F, 4.0F, 0.5F);
		shield.addChild(right_parts);
		setRotationAngle(right_parts, 0.0436F, 0.0436F, -0.0873F);
		right_parts.setTextureOffset(60, 23).addBox(-4.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.0F, false);
		right_parts.setTextureOffset(50, 0).addBox(-4.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.3F, false);
		right_parts.setTextureOffset(72, 0).addBox(-4.25F, -8.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);
		right_parts.setTextureOffset(72, 0).addBox(-4.25F, 11.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);

		left_parts = new AdvancedModelBox(this);
		left_parts.setRotationPoint(3.5F, 4.0F, 0.5F);
		shield.addChild(left_parts);
		setRotationAngle(left_parts, 0.0436F, -0.0436F, 0.0873F);
		left_parts.setTextureOffset(47, 43).addBox(-1.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.0F, false);
		left_parts.setTextureOffset(34, 43).addBox(-1.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.3F, false);
		left_parts.setTextureOffset(70, 46).addBox(-2.75F, -8.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);
		left_parts.setTextureOffset(69, 69).addBox(-2.75F, 11.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);

		spike_right = new AdvancedModelBox(this);
		spike_right.setRotationPoint(4.0F, 6.5F, -1.0F);
		shield.addChild(spike_right);
		setRotationAngle(spike_right, 0.0F, -0.3491F, 0.0F);
		spike_right.setTextureOffset(63, 0).addBox(0.0F, -12.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);
		spike_right.setTextureOffset(61, 46).addBox(0.0F, 8.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);

		spike_left = new AdvancedModelBox(this);
		spike_left.setRotationPoint(-4.0F, 6.5F, -1.0F);
		shield.addChild(spike_left);
		setRotationAngle(spike_left, 0.0F, 0.3491F, 0.0F);
		spike_left.setTextureOffset(0, 61).addBox(0.0F, -12.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);
		spike_left.setTextureOffset(52, 58).addBox(0.0F, 8.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);

		shieldjoint2 = new AdvancedModelBox(this);
		shieldjoint2.setRotationPoint(0.0F, 0.0F, 0.0F);
		guardingring2.addChild(shieldjoint2);
		setRotationAngle(shieldjoint2, 0.0F, -2.3562F, 0.0F);


		shield2 = new AdvancedModelBox(this);
		shield2.setRotationPoint(0.0F, -4.8F, -12.3F);
		shieldjoint2.addChild(shield2);
		setRotationAngle(shield2, -0.2182F, 0.0F, 0.0F);
		shield2.setTextureOffset(33, 0).addBox(-3.5F, -3.0F, -1.0F, 7.0F, 21.0F, 1.0F, 0.0F, false);
		shield2.setTextureOffset(69, 61).addBox(-4.0F, -5.0F, -1.5F, 8.0F, 5.0F, 2.0F, 0.0F, false);
		shield2.setTextureOffset(63, 15).addBox(-4.0F, 15.0F, -1.25F, 8.0F, 5.0F, 2.0F, 0.0F, false);
		shield2.setTextureOffset(34, 66).addBox(-3.0F, 2.0F, -1.5F, 6.0F, 12.0F, 0.0F, 0.0F, false);

		right_parts2 = new AdvancedModelBox(this);
		right_parts2.setRotationPoint(-3.5F, 4.0F, 0.5F);
		shield2.addChild(right_parts2);
		setRotationAngle(right_parts2, 0.0436F, 0.0436F, -0.0873F);
		right_parts2.setTextureOffset(60, 23).addBox(-4.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.0F, false);
		right_parts2.setTextureOffset(50, 0).addBox(-4.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.3F, false);
		right_parts2.setTextureOffset(72, 0).addBox(-4.25F, -8.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);
		right_parts2.setTextureOffset(72, 0).addBox(-4.25F, 11.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);

		left_parts2 = new AdvancedModelBox(this);
		left_parts2.setRotationPoint(3.5F, 4.0F, 0.5F);
		shield2.addChild(left_parts2);
		setRotationAngle(left_parts2, 0.0436F, -0.0436F, 0.0873F);
		left_parts2.setTextureOffset(47, 43).addBox(-1.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.0F, false);
		left_parts2.setTextureOffset(34, 43).addBox(-1.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.3F, false);
		left_parts2.setTextureOffset(70, 46).addBox(-2.75F, -8.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);
		left_parts2.setTextureOffset(69, 69).addBox(-2.75F, 11.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);

		spike_right2 = new AdvancedModelBox(this);
		spike_right2.setRotationPoint(4.0F, 6.5F, -1.0F);
		shield2.addChild(spike_right2);
		setRotationAngle(spike_right2, 0.0F, -0.3491F, 0.0F);
		spike_right2.setTextureOffset(63, 0).addBox(0.0F, -12.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);
		spike_right2.setTextureOffset(61, 46).addBox(0.0F, 8.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);

		spike_left2 = new AdvancedModelBox(this);
		spike_left2.setRotationPoint(-4.0F, 6.5F, -1.0F);
		shield2.addChild(spike_left2);
		setRotationAngle(spike_left2, 0.0F, 0.3491F, 0.0F);
		spike_left2.setTextureOffset(0, 61).addBox(0.0F, -12.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);
		spike_left2.setTextureOffset(52, 58).addBox(0.0F, 8.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);

		shieldjoint3 = new AdvancedModelBox(this);
		shieldjoint3.setRotationPoint(0.0F, 0.0F, 0.0F);
		guardingring2.addChild(shieldjoint3);
		setRotationAngle(shieldjoint3, 0.0F, 2.3562F, 0.0F);


		shield3 = new AdvancedModelBox(this);
		shield3.setRotationPoint(0.0F, -4.8F, -12.3F);
		shieldjoint3.addChild(shield3);
		setRotationAngle(shield3, -0.2182F, 0.0F, 0.0F);
		shield3.setTextureOffset(33, 0).addBox(-3.5F, -3.0F, -1.0F, 7.0F, 21.0F, 1.0F, 0.0F, false);
		shield3.setTextureOffset(69, 61).addBox(-4.0F, -5.0F, -1.5F, 8.0F, 5.0F, 2.0F, 0.0F, false);
		shield3.setTextureOffset(63, 15).addBox(-4.0F, 15.0F, -1.25F, 8.0F, 5.0F, 2.0F, 0.0F, false);
		shield3.setTextureOffset(34, 66).addBox(-3.0F, 2.0F, -1.5F, 6.0F, 12.0F, 0.0F, 0.0F, false);

		right_parts3 = new AdvancedModelBox(this);
		right_parts3.setRotationPoint(-3.5F, 4.0F, 0.5F);
		shield3.addChild(right_parts3);
		setRotationAngle(right_parts3, 0.0436F, 0.0436F, -0.0873F);
		right_parts3.setTextureOffset(60, 23).addBox(-4.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.0F, false);
		right_parts3.setTextureOffset(50, 0).addBox(-4.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.3F, false);
		right_parts3.setTextureOffset(72, 0).addBox(-4.25F, -8.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);
		right_parts3.setTextureOffset(72, 0).addBox(-4.25F, 11.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);

		left_parts3 = new AdvancedModelBox(this);
		left_parts3.setRotationPoint(3.5F, 4.0F, 0.5F);
		shield3.addChild(left_parts3);
		setRotationAngle(left_parts3, 0.0436F, -0.0436F, 0.0873F);
		left_parts3.setTextureOffset(47, 43).addBox(-1.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.0F, false);
		left_parts3.setTextureOffset(34, 43).addBox(-1.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.3F, false);
		left_parts3.setTextureOffset(70, 46).addBox(-2.75F, -8.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);
		left_parts3.setTextureOffset(69, 69).addBox(-2.75F, 11.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);

		spike_right3 = new AdvancedModelBox(this);
		spike_right3.setRotationPoint(4.0F, 6.5F, -1.0F);
		shield3.addChild(spike_right3);
		setRotationAngle(spike_right3, 0.0F, -0.3491F, 0.0F);
		spike_right3.setTextureOffset(63, 0).addBox(0.0F, -12.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);
		spike_right3.setTextureOffset(61, 46).addBox(0.0F, 8.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);

		spike_left3 = new AdvancedModelBox(this);
		spike_left3.setRotationPoint(-4.0F, 6.5F, -1.0F);
		shield3.addChild(spike_left3);
		setRotationAngle(spike_left3, 0.0F, 0.3491F, 0.0F);
		spike_left3.setTextureOffset(0, 61).addBox(0.0F, -12.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);
		spike_left3.setTextureOffset(52, 58).addBox(0.0F, 8.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);

		shieldjoint4 = new AdvancedModelBox(this);
		shieldjoint4.setRotationPoint(0.0F, 0.0F, 0.0F);
		guardingring2.addChild(shieldjoint4);
		setRotationAngle(shieldjoint4, 0.0F, 0.7854F, 0.0F);


		shield4 = new AdvancedModelBox(this);
		shield4.setRotationPoint(0.0F, -4.8F, -12.3F);
		shieldjoint4.addChild(shield4);
		setRotationAngle(shield4, -0.2182F, 0.0F, 0.0F);
		shield4.setTextureOffset(33, 0).addBox(-3.5F, -3.0F, -1.0F, 7.0F, 21.0F, 1.0F, 0.0F, false);
		shield4.setTextureOffset(69, 61).addBox(-4.0F, -5.0F, -1.5F, 8.0F, 5.0F, 2.0F, 0.0F, false);
		shield4.setTextureOffset(63, 15).addBox(-4.0F, 15.0F, -1.25F, 8.0F, 5.0F, 2.0F, 0.0F, false);
		shield4.setTextureOffset(34, 66).addBox(-3.0F, 2.0F, -1.5F, 6.0F, 12.0F, 0.0F, 0.0F, false);

		right_parts4 = new AdvancedModelBox(this);
		right_parts4.setRotationPoint(-3.5F, 4.0F, 0.5F);
		shield4.addChild(right_parts4);
		setRotationAngle(right_parts4, 0.0436F, 0.0436F, -0.0873F);
		right_parts4.setTextureOffset(60, 23).addBox(-4.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.0F, false);
		right_parts4.setTextureOffset(50, 0).addBox(-4.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.3F, false);
		right_parts4.setTextureOffset(72, 0).addBox(-4.25F, -8.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);
		right_parts4.setTextureOffset(72, 0).addBox(-4.25F, 11.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);

		left_parts4 = new AdvancedModelBox(this);
		left_parts4.setRotationPoint(3.5F, 4.0F, 0.5F);
		shield4.addChild(left_parts4);
		setRotationAngle(left_parts4, 0.0436F, -0.0436F, 0.0873F);
		left_parts4.setTextureOffset(47, 43).addBox(-1.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.0F, false);
		left_parts4.setTextureOffset(34, 43).addBox(-1.0F, -7.0F, -1.0F, 5.0F, 21.0F, 1.0F, 0.3F, false);
		left_parts4.setTextureOffset(70, 46).addBox(-2.75F, -8.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);
		left_parts4.setTextureOffset(69, 69).addBox(-2.75F, 11.5F, -1.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);

		spike_right4 = new AdvancedModelBox(this);
		spike_right4.setRotationPoint(4.0F, 6.5F, -1.0F);
		shield4.addChild(spike_right4);
		setRotationAngle(spike_right4, 0.0F, -0.3491F, 0.0F);
		spike_right4.setTextureOffset(63, 0).addBox(0.0F, -12.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);
		spike_right4.setTextureOffset(61, 46).addBox(0.0F, 8.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);

		spike_left4 = new AdvancedModelBox(this);
		spike_left4.setRotationPoint(-4.0F, 6.5F, -1.0F);
		shield4.addChild(spike_left4);
		setRotationAngle(spike_left4, 0.0F, 0.3491F, 0.0F);
		spike_left4.setTextureOffset(0, 61).addBox(0.0F, -12.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);
		spike_left4.setTextureOffset(52, 58).addBox(0.0F, 8.5F, -8.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);

		center = new AdvancedModelBox(this);
		center.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(center);
		center.setTextureOffset(17, 43).addBox(-2.0F, -22.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, false);
		center.setTextureOffset(0, 34).addBox(-2.0F, -22.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.3F, false);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, -26.0F, 0.0F);
		center.addChild(head);


		jaw = new AdvancedModelBox(this);
		jaw.setRotationPoint(0.0F, 2.0F, 4.0F);
		head.addChild(jaw);
		jaw.setTextureOffset(0, 0).addBox(-4.0F, -6.0F, -8.0F, 8.0F, 8.0F, 8.0F, -0.1F, false);

		skull = new AdvancedModelBox(this);
		skull.setRotationPoint(0.0F, 2.0F, 4.0F);
		head.addChild(skull);
		skull.setTextureOffset(25, 26).addBox(-4.0F, -5.999F, -8.0436F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		helmet = new AdvancedModelBox(this);
		helmet.setRotationPoint(0.0F, -1.999F, -4.0436F);
		skull.addChild(helmet);
		helmet.setTextureOffset(0, 17).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.3F, false);

		right_horn = new AdvancedModelBox(this);
		right_horn.setRotationPoint(-4.0F, -3.5F, -3.5F);
		helmet.addChild(right_horn);
		setRotationAngle(right_horn, 0.4363F, 0.0F, 0.0F);
		right_horn.setTextureOffset(0, 0).addBox(-1.3F, -5.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		left_horn = new AdvancedModelBox(this);
		left_horn.setRotationPoint(4.3F, -3.5F, -3.5F);
		helmet.addChild(left_horn);
		setRotationAngle(left_horn, 0.4363F, 0.0F, 0.0F);
		left_horn.setTextureOffset(0, 17).addBox(0.0F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	public void animate(Ignited_Revenant_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(Ignited_Revenant_Entity.ASH_BREATH_ATTACK);
		if(!entity.getIsAnger()) {
			animator.startKeyframe(15);
			animator.rotate(guardingring, (float) Math.toRadians(-5F), 0, 0);
			animator.rotate(center, (float) Math.toRadians(-12.5F), 0, 0);
			animator.rotate(head, (float) Math.toRadians(-25F), 0, 0);
			animator.endKeyframe();

			animator.setStaticKeyframe(8);

			animator.startKeyframe(5);
			animator.rotate(guardingring, (float) Math.toRadians(20F), 0, 0);
			animator.rotate(center, (float) Math.toRadians(25F), 0, 0);
			animator.rotate(head, (float) Math.toRadians(-15F), 0, 0);
			animator.move(skull, 0, -3, 0);
			animator.rotate(skull, (float) Math.toRadians(-22.5F), 0, 0);
			animator.endKeyframe();
			animator.setStaticKeyframe(15);
			animator.resetKeyframe(10);
		}else{
			animator.startKeyframe(15);
			animator.rotate(root, (float) Math.toRadians(-12.5F), 0, 0);
			animator.rotate(center, (float) Math.toRadians(-12.5F), 0, 0);
			animator.rotate(head, (float) Math.toRadians(-25F), 0, 0);
			animator.rotate(shield, (float) Math.toRadians(47.5F), 0, 0);
			animator.rotate(shield2, (float) Math.toRadians(47.5F), 0, 0);
			animator.rotate(shield3, (float) Math.toRadians(47.5F), 0, 0);
			animator.rotate(shield4, (float) Math.toRadians(47.5F), 0, 0);
			animator.rotate(skull, (float) Math.toRadians(17.5F), 0, 0);
			animator.rotate(jaw, (float) Math.toRadians(-10F), 0, 0);
			animator.endKeyframe();

			animator.setStaticKeyframe(8);

			animator.startKeyframe(5);
			animator.rotate(guardingring, (float) Math.toRadians(25F), 0, 0);
			animator.rotate(center, (float) Math.toRadians(25F), 0, 0);
			animator.rotate(head, (float) Math.toRadians(-15F), 0, 0);
			animator.move(skull, 0, -3, 0);
			animator.rotate(skull, (float) Math.toRadians(5F), 0, 0);
			animator.rotate(shield, (float) Math.toRadians(47.5F), 0, 0);
			animator.rotate(shield2, (float) Math.toRadians(47.5F), 0, 0);
			animator.rotate(shield3, (float) Math.toRadians(47.5F), 0, 0);
			animator.rotate(shield4, (float) Math.toRadians(47.5F), 0, 0);
			animator.rotate(jaw, (float) Math.toRadians(-10F), 0, 0);
			animator.endKeyframe();
			animator.setStaticKeyframe(15);
			animator.resetKeyframe(10);
		}

		animator.setAnimation(Ignited_Revenant_Entity.BONE_STORM_ATTACK);
		if(!entity.getIsAnger()) {
			animator.startKeyframe(4);
			animator.rotate(shield, (float) Math.toRadians(-57.5F), 0, 0);
			animator.rotate(shield2, (float) Math.toRadians(-57.5F), 0, 0);
			animator.rotate(shield3, (float) Math.toRadians(-57.5F), 0, 0);
			animator.rotate(shield4, (float) Math.toRadians(-57.5F), 0, 0);
			animator.move(skull, 0, -3, 0);
			animator.endKeyframe();
			animator.setStaticKeyframe(30);
			animator.resetKeyframe(15);
		}else{
			animator.startKeyframe(4);
			animator.rotate(root, (float) Math.toRadians(-12.5F), 0, 0);
			animator.rotate(guardingring, (float) Math.toRadians(5F), 0, 0);
			animator.rotate(shield, (float) Math.toRadians(-10F), 0, 0);
			animator.rotate(shield2, (float) Math.toRadians(-10F), 0, 0);
			animator.rotate(shield3, (float) Math.toRadians(-10F), 0, 0);
			animator.rotate(shield4, (float) Math.toRadians(-10F), 0, 0);
			animator.rotate(jaw, (float) Math.toRadians(-10F), 0, 0);
			animator.move(skull, 0, -3, 0);
			animator.endKeyframe();
			animator.setStaticKeyframe(30);
			animator.resetKeyframe(15);
		}
	}

	@Override
	public void setupAnim(Ignited_Revenant_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		float idleSpeed = 0.1F;
		float idleDegree = 1F;
		float walkSpeed = 0.5F;
		float walkDegree = 1F;
		this.faceTarget(netHeadYaw, headPitch, 1, head);
		this.bob(root, idleSpeed, idleDegree * 3, false, ageInTicks, 1);
		this.bob(shield, idleSpeed, idleDegree, false, ageInTicks, 1);
		this.bob(shield2, idleSpeed, idleDegree, false, ageInTicks, 1);
		this.bob(shield3, idleSpeed, idleDegree, false, ageInTicks, 1);
		this.bob(shield4, idleSpeed, idleDegree, false, ageInTicks, 1);
		float spin = 0.05F;
		if(entityIn.getIsAnger()) {
			if (entityIn.getAnimation() == entityIn.NO_ANIMATION) {
				spin = 0.5F;
			}
		}
		guardingring2.rotateAngleY += ageInTicks * spin;
		this.shield.rotationPointY += Mth.cos(ageInTicks * 0.1F);
		this.shield4.rotationPointY += Mth.cos(ageInTicks * 0.1F);
		this.shield2.rotationPointY -= Mth.cos(ageInTicks * 0.1F);
		this.shield3.rotationPointY -= Mth.cos(ageInTicks * 0.1F);
		float partialTick = Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);
		float angerProgress = entityIn.prevangerProgress + (entityIn.angerProgress - entityIn.prevangerProgress) * partialTick;

		progressRotationPrev(root,angerProgress,(float)Math.toRadians(12.5F), 0, 0, 5f);
		progressRotationPrev(guardingring,angerProgress,(float)Math.toRadians(-5F), 0, 0, 5f);
		progressRotationPrev(shield,angerProgress,(float)Math.toRadians(-47.5F), 0, 0, 5f);
		progressRotationPrev(shield2,angerProgress,(float)Math.toRadians(-47.5F), 0, 0, 5f);
		progressRotationPrev(shield3,angerProgress,(float)Math.toRadians(-47.5F), 0, 0, 5f);
		progressRotationPrev(shield4,angerProgress,(float)Math.toRadians(-47.5F), 0, 0, 5f);
		progressRotationPrev(skull,angerProgress,(float)Math.toRadians(-17.5F), 0, 0, 5f);
		progressRotationPrev(jaw,angerProgress,(float)Math.toRadians(10F), 0, 0, 5f);



		shield.showModel = entityIn.getShieldDurability() < 1;
		shield2.showModel = entityIn.getShieldDurability() < 2;
		shield3.showModel = entityIn.getShieldDurability() < 3;
		shield4.showModel = entityIn.getShieldDurability() < 4;

	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				head,
				jaw,
				helmet,
				skull,
				body,
				guardingring,
				guardingring2,
				shield,
				shieldjoint,
				shield2,
				shieldjoint2,
				shield3,
				shieldjoint3,
				shield4,
				shieldjoint4,
				center);
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