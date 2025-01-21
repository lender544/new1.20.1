package com.github.L_Ender.cataclysm.client.model.entity;


import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector4f;

public class The_Leviathan_Model extends AdvancedEntityModel<The_Leviathan_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox body;
	private final AdvancedModelBox R_Spike;
	private final AdvancedModelBox L_Spike;
	private final AdvancedModelBox Main_belly;
	private final AdvancedModelBox R_Spike2;
	private final AdvancedModelBox L_Spike2;
	private final AdvancedModelBox R_mini_fin;
	private final AdvancedModelBox L_mini_fin;
	private final AdvancedModelBox Belly;
	private final AdvancedModelBox R_down_fin;
	private final AdvancedModelBox R_down_fin2;
	private final AdvancedModelBox L_down_fin;
	private final AdvancedModelBox L_down_fin2;
	private final AdvancedModelBox Tail;
	private final AdvancedModelBox R_Spike3;
	private final AdvancedModelBox L_Spike3;
	private final AdvancedModelBox Tail2;
	private final AdvancedModelBox R_Spike4;
	private final AdvancedModelBox L_Spike4;
	private final AdvancedModelBox Tail3;
	public final AdvancedModelBox Tail_Particle;
	private final AdvancedModelBox UpperR_Tentacle;
	private final AdvancedModelBox UpperR_Tentacle2;
	private final AdvancedModelBox UpperR_Tentacle3;
	private final AdvancedModelBox UpperR_Tentacle4;
	private final AdvancedModelBox UpperR_Hook;
	private final AdvancedModelBox UpperR_Hook2;
	private final AdvancedModelBox UpperR_Hook3;
	private final AdvancedModelBox UpperR_Hook4;
	private final AdvancedModelBox UpperL_Tentacle;
	private final AdvancedModelBox UpperL_Tentacle2;
	private final AdvancedModelBox UpperL_Tentacle3;
	private final AdvancedModelBox UpperL_Tentacle4;
	private final AdvancedModelBox UpperL_Hook;
	private final AdvancedModelBox UpperL_Hook2;
	private final AdvancedModelBox UpperL_Hook3;
	private final AdvancedModelBox UpperL_Hook4;
	private final AdvancedModelBox LowerR_Tentacle;
	private final AdvancedModelBox LowerR_Tentacle2;
	private final AdvancedModelBox LowerR_Tentacle3;
	private final AdvancedModelBox LowerR_Tentacle4;
	private final AdvancedModelBox LowerR_Hook;
	private final AdvancedModelBox LowerR_Hook2;
	private final AdvancedModelBox LowerR_Hook3;
	private final AdvancedModelBox LowerR_Hook4;
	private final AdvancedModelBox LowerL_Tentacle;
	private final AdvancedModelBox LowerL_Tentacle2;
	private final AdvancedModelBox LowerL_Tentacle3;
	private final AdvancedModelBox LowerL_Tentacle4;
	private final AdvancedModelBox LowerL_Hook;
	private final AdvancedModelBox LowerL_Hook2;
	private final AdvancedModelBox LowerL_Hook3;
	private final AdvancedModelBox LowerL_Hook4;
	private final AdvancedModelBox Head;
	private final AdvancedModelBox Muscle;
	private final AdvancedModelBox Maw;
	private final AdvancedModelBox Skul;
	public final AdvancedModelBox tongue;
	private final AdvancedModelBox R_fin;
	private final AdvancedModelBox R_fin2;
	private final AdvancedModelBox R_fin3;
	private final AdvancedModelBox L_fin;
	private final AdvancedModelBox L_fin2;
	private final AdvancedModelBox L_fin3;
	private final AdvancedModelBox four_mouths;
	private final AdvancedModelBox Mouth4;
	private final AdvancedModelBox Mouth4_e;
	private final AdvancedModelBox Mouth3;
	private final AdvancedModelBox Mouth3_e;
	private final AdvancedModelBox Mouth2;
	private final AdvancedModelBox Mouth2_e;
	private final AdvancedModelBox Mouth;
	private final AdvancedModelBox Mouth1_e;
	private ModelAnimator animator;

	public The_Leviathan_Model() {
		texWidth = 256;
		texHeight = 256;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		body = new AdvancedModelBox(this);
		body.setRotationPoint(0.0F, -13.0F, 0.0F);
		root.addChild(body);
		body.setTextureOffset(67, 50).addBox(-9.0F, -11.0F, -34.0F, 18.0F, 24.0F, 18.0F, 0.0F, false);
		body.setTextureOffset(44, 168).addBox(0.0F, -20.0F, -33.0F, 0.0F, 9.0F, 14.0F, 0.0F, false);

		R_Spike = new AdvancedModelBox(this);
		R_Spike.setRotationPoint(-9.0F, -11.0F, -25.0F);
		body.addChild(R_Spike);
		setRotationAngle(R_Spike, 0.0F, 0.0F, 0.7854F);
		R_Spike.setTextureOffset(0, 135).addBox(-4.0F, 0.0F, -9.0F, 4.0F, 0.0F, 18.0F, 0.0F, true);

		L_Spike = new AdvancedModelBox(this);
		L_Spike.setRotationPoint(9.0F, -11.0F, -25.0F);
		body.addChild(L_Spike);
		setRotationAngle(L_Spike, 0.0F, 0.0F, -0.7854F);
		L_Spike.setTextureOffset(0, 135).addBox(0.0F, 0.0F, -9.0F, 4.0F, 0.0F, 18.0F, 0.0F, false);

		Main_belly = new AdvancedModelBox(this);
		Main_belly.setRotationPoint(0.0F, -1.0F, -16.0F);
		body.addChild(Main_belly);
		Main_belly.setTextureOffset(43, 0).addBox(-8.0F, -9.0F, 0.0F, 16.0F, 19.0F, 16.0F, 0.0F, false);
		Main_belly.setTextureOffset(15, 168).addBox(0.0F, -18.0F, 3.0F, 0.0F, 9.0F, 14.0F, 0.0F, false);

		R_Spike2 = new AdvancedModelBox(this);
		R_Spike2.setRotationPoint(-8.0F, -9.0F, 8.0F);
		Main_belly.addChild(R_Spike2);
		setRotationAngle(R_Spike2, 0.0F, 0.0F, -0.7418F);
		R_Spike2.setTextureOffset(164, 91).addBox(0.0F, -4.0F, -8.0F, 0.0F, 4.0F, 16.0F, 0.0F, true);

		L_Spike2 = new AdvancedModelBox(this);
		L_Spike2.setRotationPoint(8.0F, -9.0F, 8.0F);
		Main_belly.addChild(L_Spike2);
		setRotationAngle(L_Spike2, 0.0F, 0.0F, 0.7418F);
		L_Spike2.setTextureOffset(164, 91).addBox(0.0F, -4.0F, -8.0F, 0.0F, 4.0F, 16.0F, 0.0F, false);

		R_mini_fin = new AdvancedModelBox(this);
		R_mini_fin.setRotationPoint(-8.0F, 10.0F, 13.0F);
		Main_belly.addChild(R_mini_fin);
		R_mini_fin.setTextureOffset(64, 137).addBox(-8.0F, 0.0F, -8.0F, 8.0F, 0.0F, 16.0F, 0.0F, true);

		L_mini_fin = new AdvancedModelBox(this);
		L_mini_fin.setRotationPoint(8.0F, 10.0F, 13.0F);
		Main_belly.addChild(L_mini_fin);
		L_mini_fin.setTextureOffset(64, 137).addBox(0.0F, 0.0F, -8.0F, 8.0F, 0.0F, 16.0F, 0.0F, false);

		Belly = new AdvancedModelBox(this);
		Belly.setRotationPoint(0.0F, 1.0F, 16.0F);
		Main_belly.addChild(Belly);
		Belly.setTextureOffset(0, 68).addBox(-7.0F, -9.0F, 0.0F, 14.0F, 17.0F, 14.0F, 0.0F, false);
		Belly.setTextureOffset(175, 118).addBox(0.0F, -21.0F, 2.0F, 0.0F, 12.0F, 12.0F, 0.0F, false);

		R_down_fin = new AdvancedModelBox(this);
		R_down_fin.setRotationPoint(-7.0F, 8.0F, 8.0F);
		Belly.addChild(R_down_fin);
		R_down_fin.setTextureOffset(31, 126).addBox(-6.0F, -1.0F, -6.0F, 6.0F, 1.0F, 18.0F, 0.0F, false);
		R_down_fin.setTextureOffset(133, 29).addBox(-6.0F, -1.0F, 12.0F, 6.0F, 0.0F, 4.0F, 0.0F, false);

		R_down_fin2 = new AdvancedModelBox(this);
		R_down_fin2.setRotationPoint(-6.0F, -1.0F, 6.0F);
		R_down_fin.addChild(R_down_fin2);
		R_down_fin2.setTextureOffset(155, 169).addBox(-6.0F, 0.0F, -6.0F, 6.0F, 1.0F, 12.0F, 0.0F, false);
		R_down_fin2.setTextureOffset(54, 154).addBox(-6.0F, 0.0F, 6.0F, 6.0F, 0.0F, 7.0F, 0.0F, false);

		L_down_fin = new AdvancedModelBox(this);
		L_down_fin.setRotationPoint(7.0F, 8.0F, 8.0F);
		Belly.addChild(L_down_fin);
		L_down_fin.setTextureOffset(108, 0).addBox(0.0F, -1.0F, -6.0F, 6.0F, 1.0F, 18.0F, 0.0F, false);
		L_down_fin.setTextureOffset(73, 36).addBox(0.0F, -1.0F, 12.0F, 6.0F, 0.0F, 4.0F, 0.0F, false);

		L_down_fin2 = new AdvancedModelBox(this);
		L_down_fin2.setRotationPoint(6.0F, -1.0F, 6.0F);
		L_down_fin.addChild(L_down_fin2);
		L_down_fin2.setTextureOffset(0, 27).addBox(0.0F, 0.0F, -6.0F, 6.0F, 1.0F, 12.0F, 0.0F, false);
		L_down_fin2.setTextureOffset(15, 154).addBox(0.0F, 0.0F, 6.0F, 6.0F, 0.0F, 7.0F, 0.0F, false);

		Tail = new AdvancedModelBox(this);
		Tail.setRotationPoint(0.0F, -0.9F, 14.0F);
		Belly.addChild(Tail);
		Tail.setTextureOffset(41, 93).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 16.0F, 16.0F, 0.0F, false);
		Tail.setTextureOffset(126, 167).addBox(0.0F, -17.0F, 0.0F, 0.0F, 9.0F, 14.0F, 0.0F, false);
		Tail.setTextureOffset(97, 167).addBox(0.0F, 8.0F, 0.0F, 0.0F, 9.0F, 14.0F, 0.0F, false);

		R_Spike3 = new AdvancedModelBox(this);
		R_Spike3.setRotationPoint(-4.0F, -3.0F, 6.5F);
		Tail.addChild(R_Spike3);
		setRotationAngle(R_Spike3, 0.0F, 0.0F, 0.4363F);
		R_Spike3.setTextureOffset(176, 143).addBox(-4.0F, 0.0F, -6.5F, 4.0F, 0.0F, 13.0F, 0.0F, true);

		L_Spike3 = new AdvancedModelBox(this);
		L_Spike3.setRotationPoint(4.0F, -3.0F, 6.5F);
		Tail.addChild(L_Spike3);
		setRotationAngle(L_Spike3, 0.0F, 0.0F, -0.4363F);
		L_Spike3.setTextureOffset(176, 143).addBox(0.0F, 0.0F, -6.5F, 4.0F, 0.0F, 13.0F, 0.0F, false);

		Tail2 = new AdvancedModelBox(this);
		Tail2.setRotationPoint(0.0F, -2.9F, 14.0F);
		Tail.addChild(Tail2);
		Tail2.setTextureOffset(0, 154).addBox(0.0F, 4.9F, 0.0F, 0.0F, 13.0F, 14.0F, 0.0F, false);
		Tail2.setTextureOffset(0, 0).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 10.0F, 16.0F, 0.0F, false);
		Tail2.setTextureOffset(25, 0).addBox(0.0F, -9.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F, false);

		R_Spike4 = new AdvancedModelBox(this);
		R_Spike4.setRotationPoint(-2.0F, 0.0F, 5.0F);
		Tail2.addChild(R_Spike4);
		setRotationAngle(R_Spike4, 0.0F, 0.0F, -0.4363F);
		R_Spike4.setTextureOffset(30, 168).addBox(-3.0F, 0.0F, -5.0F, 3.0F, 0.0F, 10.0F, 0.0F, false);

		L_Spike4 = new AdvancedModelBox(this);
		L_Spike4.setRotationPoint(2.0F, 0.0F, 5.0F);
		Tail2.addChild(L_Spike4);
		setRotationAngle(L_Spike4, 0.0F, 0.0F, 0.4363F);
		L_Spike4.setTextureOffset(112, 167).addBox(0.0F, 0.0F, -5.0F, 3.0F, 0.0F, 10.0F, 0.0F, false);

		Tail3 = new AdvancedModelBox(this);
		Tail3.setRotationPoint(0.0F, -2.5F, 14.0F);
		Tail2.addChild(Tail3);
		Tail3.setTextureOffset(29, 146).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 5.0F, 16.0F, -0.01F, false);
		Tail3.setTextureOffset(0, 0).addBox(0.0F, -7.6F, 0.0F, 0.0F, 25.0F, 42.0F, 0.0F, false);

		Tail_Particle = new AdvancedModelBox(this);
		Tail_Particle.setRotationPoint(0.0F, -14.475F, 77.0F);
		Tail3.addChild(Tail_Particle);


		UpperR_Tentacle = new AdvancedModelBox(this);
		UpperR_Tentacle.setRotationPoint(-8.0F, -2.0F, 6.0F);
		Main_belly.addChild(UpperR_Tentacle);
		setRotationAngle(UpperR_Tentacle, 0.0F, -0.1745F, 0.6109F);
		UpperR_Tentacle.setTextureOffset(139, 0).addBox(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		UpperR_Tentacle2 = new AdvancedModelBox(this);
		UpperR_Tentacle2.setRotationPoint(-24.0F, 0.0F, 0.0F);
		UpperR_Tentacle.addChild(UpperR_Tentacle2);
		setRotationAngle(UpperR_Tentacle2, 0.0F, -0.4363F, 0.0F);
		UpperR_Tentacle2.setTextureOffset(133, 20).addBox(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		UpperR_Tentacle3 = new AdvancedModelBox(this);
		UpperR_Tentacle3.setRotationPoint(-24.0F, 0.0F, 0.0F);
		UpperR_Tentacle2.addChild(UpperR_Tentacle3);
		setRotationAngle(UpperR_Tentacle3, 0.0F, -0.4363F, 0.0F);
		UpperR_Tentacle3.setTextureOffset(133, 20).addBox(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		UpperR_Tentacle4 = new AdvancedModelBox(this);
		UpperR_Tentacle4.setRotationPoint(-24.0F, 0.0F, 0.0F);
		UpperR_Tentacle3.addChild(UpperR_Tentacle4);
		setRotationAngle(UpperR_Tentacle4, 0.0F, -0.6109F, 0.0F);
		UpperR_Tentacle4.setTextureOffset(0, 100).addBox(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		UpperR_Hook = new AdvancedModelBox(this);
		UpperR_Hook.setRotationPoint(-24.0F, 2.0F, 0.0F);
		UpperR_Tentacle4.addChild(UpperR_Hook);
		setRotationAngle(UpperR_Hook, 0.0F, 0.0F, 0.7854F);
		UpperR_Hook.setTextureOffset(111, 0).addBox(-2.0F, 0.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		UpperR_Hook2 = new AdvancedModelBox(this);
		UpperR_Hook2.setRotationPoint(-24.0F, 0.0F, -2.0F);
		UpperR_Tentacle4.addChild(UpperR_Hook2);
		setRotationAngle(UpperR_Hook2, 0.0F, 0.7854F, 0.0F);
		UpperR_Hook2.setTextureOffset(184, 157).addBox(-2.0F, -1.5F, -8.0F, 2.0F, 3.0F, 8.0F, 0.0F, false);

		UpperR_Hook3 = new AdvancedModelBox(this);
		UpperR_Hook3.setRotationPoint(-24.0F, 0.0F, 2.0F);
		UpperR_Tentacle4.addChild(UpperR_Hook3);
		setRotationAngle(UpperR_Hook3, 0.0F, -0.7854F, 0.0F);
		UpperR_Hook3.setTextureOffset(156, 183).addBox(-2.0F, -1.5F, 0.0F, 2.0F, 3.0F, 8.0F, 0.0F, false);

		UpperR_Hook4 = new AdvancedModelBox(this);
		UpperR_Hook4.setRotationPoint(-24.0F, -2.0F, 0.0F);
		UpperR_Tentacle4.addChild(UpperR_Hook4);
		setRotationAngle(UpperR_Hook4, 0.0F, 0.0F, -0.7854F);
		UpperR_Hook4.setTextureOffset(92, 0).addBox(-2.0F, -8.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		UpperL_Tentacle = new AdvancedModelBox(this);
		UpperL_Tentacle.setRotationPoint(8.0F, -2.0F, 6.0F);
		Main_belly.addChild(UpperL_Tentacle);
		setRotationAngle(UpperL_Tentacle, 0.0F, 0.1745F, -0.6109F);
		UpperL_Tentacle.setTextureOffset(139, 0).addBox(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, true);

		UpperL_Tentacle2 = new AdvancedModelBox(this);
		UpperL_Tentacle2.setRotationPoint(24.0F, 0.0F, 0.0F);
		UpperL_Tentacle.addChild(UpperL_Tentacle2);
		setRotationAngle(UpperL_Tentacle2, 0.0F, 0.4363F, 0.0F);
		UpperL_Tentacle2.setTextureOffset(133, 20).addBox(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, true);

		UpperL_Tentacle3 = new AdvancedModelBox(this);
		UpperL_Tentacle3.setRotationPoint(24.0F, 0.0F, 0.0F);
		UpperL_Tentacle2.addChild(UpperL_Tentacle3);
		setRotationAngle(UpperL_Tentacle3, 0.0F, 0.4363F, 0.0F);
		UpperL_Tentacle3.setTextureOffset(133, 20).addBox(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, true);

		UpperL_Tentacle4 = new AdvancedModelBox(this);
		UpperL_Tentacle4.setRotationPoint(24.0F, 0.0F, 0.0F);
		UpperL_Tentacle3.addChild(UpperL_Tentacle4);
		setRotationAngle(UpperL_Tentacle4, 0.0F, 0.6109F, 0.0F);
		UpperL_Tentacle4.setTextureOffset(0, 100).addBox(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, true);

		UpperL_Hook = new AdvancedModelBox(this);
		UpperL_Hook.setRotationPoint(24.0F, 2.0F, 0.0F);
		UpperL_Tentacle4.addChild(UpperL_Hook);
		setRotationAngle(UpperL_Hook, 0.0F, 0.0F, -0.7854F);
		UpperL_Hook.setTextureOffset(111, 0).addBox(0.0F, 0.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, true);

		UpperL_Hook2 = new AdvancedModelBox(this);
		UpperL_Hook2.setRotationPoint(24.0F, 0.0F, -2.0F);
		UpperL_Tentacle4.addChild(UpperL_Hook2);
		setRotationAngle(UpperL_Hook2, 0.0F, -0.7854F, 0.0F);
		UpperL_Hook2.setTextureOffset(184, 157).addBox(0.0F, -1.5F, -8.0F, 2.0F, 3.0F, 8.0F, 0.0F, true);

		UpperL_Hook3 = new AdvancedModelBox(this);
		UpperL_Hook3.setRotationPoint(24.0F, 0.0F, 2.0F);
		UpperL_Tentacle4.addChild(UpperL_Hook3);
		setRotationAngle(UpperL_Hook3, 0.0F, 0.7854F, 0.0F);
		UpperL_Hook3.setTextureOffset(156, 183).addBox(0.0F, -1.5F, 0.0F, 2.0F, 3.0F, 8.0F, 0.0F, true);

		UpperL_Hook4 = new AdvancedModelBox(this);
		UpperL_Hook4.setRotationPoint(24.0F, -2.0F, 0.0F);
		UpperL_Tentacle4.addChild(UpperL_Hook4);
		setRotationAngle(UpperL_Hook4, 0.0F, 0.0F, 0.7854F);
		UpperL_Hook4.setTextureOffset(92, 0).addBox(0.0F, -8.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, true);

		LowerR_Tentacle = new AdvancedModelBox(this);
		LowerR_Tentacle.setRotationPoint(-8.0F, 6.0F, 6.0F);
		Main_belly.addChild(LowerR_Tentacle);
		setRotationAngle(LowerR_Tentacle, 0.0F, -0.1745F, -0.6109F);
		LowerR_Tentacle.setTextureOffset(139, 0).addBox(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		LowerR_Tentacle2 = new AdvancedModelBox(this);
		LowerR_Tentacle2.setRotationPoint(-24.0F, 0.0F, 0.0F);
		LowerR_Tentacle.addChild(LowerR_Tentacle2);
		setRotationAngle(LowerR_Tentacle2, 0.0F, -0.4363F, 0.0F);
		LowerR_Tentacle2.setTextureOffset(133, 20).addBox(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		LowerR_Tentacle3 = new AdvancedModelBox(this);
		LowerR_Tentacle3.setRotationPoint(-24.0F, 0.0F, 0.0F);
		LowerR_Tentacle2.addChild(LowerR_Tentacle3);
		setRotationAngle(LowerR_Tentacle3, 0.0F, -0.48F, 0.0F);
		LowerR_Tentacle3.setTextureOffset(133, 20).addBox(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		LowerR_Tentacle4 = new AdvancedModelBox(this);
		LowerR_Tentacle4.setRotationPoint(-24.0F, 0.0F, 0.0F);
		LowerR_Tentacle3.addChild(LowerR_Tentacle4);
		setRotationAngle(LowerR_Tentacle4, 0.0F, -0.4363F, 0.0F);
		LowerR_Tentacle4.setTextureOffset(0, 100).addBox(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		LowerR_Hook = new AdvancedModelBox(this);
		LowerR_Hook.setRotationPoint(-24.0F, 2.0F, 0.0F);
		LowerR_Tentacle4.addChild(LowerR_Hook);
		setRotationAngle(LowerR_Hook, 0.0F, 0.0F, 0.7854F);
		LowerR_Hook.setTextureOffset(0, 68).addBox(-2.0F, 0.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		LowerR_Hook2 = new AdvancedModelBox(this);
		LowerR_Hook2.setRotationPoint(-24.0F, 0.0F, -2.0F);
		LowerR_Tentacle4.addChild(LowerR_Hook2);
		setRotationAngle(LowerR_Hook2, 0.0F, 0.7854F, 0.0F);
		LowerR_Hook2.setTextureOffset(183, 62).addBox(-2.0F, -1.5F, -8.0F, 2.0F, 3.0F, 8.0F, 0.0F, false);

		LowerR_Hook3 = new AdvancedModelBox(this);
		LowerR_Hook3.setRotationPoint(-24.0F, 0.0F, 2.0F);
		LowerR_Tentacle4.addChild(LowerR_Hook3);
		setRotationAngle(LowerR_Hook3, 0.0F, -0.7854F, 0.0F);
		LowerR_Hook3.setTextureOffset(43, 68).addBox(-2.0F, -1.5F, 0.0F, 2.0F, 3.0F, 8.0F, 0.0F, false);

		LowerR_Hook4 = new AdvancedModelBox(this);
		LowerR_Hook4.setRotationPoint(-24.0F, -2.0F, 0.0F);
		LowerR_Tentacle4.addChild(LowerR_Hook4);
		setRotationAngle(LowerR_Hook4, 0.0F, 0.0F, -0.7854F);
		LowerR_Hook4.setTextureOffset(0, 27).addBox(-2.0F, -8.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		LowerL_Tentacle = new AdvancedModelBox(this);
		LowerL_Tentacle.setRotationPoint(8.0F, 6.0F, 6.0F);
		Main_belly.addChild(LowerL_Tentacle);
		setRotationAngle(LowerL_Tentacle, 0.0F, 0.1745F, 0.6109F);
		LowerL_Tentacle.setTextureOffset(139, 0).addBox(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, true);

		LowerL_Tentacle2 = new AdvancedModelBox(this);
		LowerL_Tentacle2.setRotationPoint(24.0F, 0.0F, 0.0F);
		LowerL_Tentacle.addChild(LowerL_Tentacle2);
		setRotationAngle(LowerL_Tentacle2, 0.0F, 0.4363F, 0.0F);
		LowerL_Tentacle2.setTextureOffset(133, 20).addBox(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, true);

		LowerL_Tentacle3 = new AdvancedModelBox(this);
		LowerL_Tentacle3.setRotationPoint(24.0F, 0.0F, 0.0F);
		LowerL_Tentacle2.addChild(LowerL_Tentacle3);
		setRotationAngle(LowerL_Tentacle3, 0.0F, 0.48F, 0.0F);
		LowerL_Tentacle3.setTextureOffset(133, 20).addBox(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, true);

		LowerL_Tentacle4 = new AdvancedModelBox(this);
		LowerL_Tentacle4.setRotationPoint(24.0F, 0.0F, 0.0F);
		LowerL_Tentacle3.addChild(LowerL_Tentacle4);
		setRotationAngle(LowerL_Tentacle4, 0.0F, 0.4363F, 0.0F);
		LowerL_Tentacle4.setTextureOffset(0, 100).addBox(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, true);

		LowerL_Hook = new AdvancedModelBox(this);
		LowerL_Hook.setRotationPoint(24.0F, 2.0F, 0.0F);
		LowerL_Tentacle4.addChild(LowerL_Hook);
		setRotationAngle(LowerL_Hook, 0.0F, 0.0F, -0.7854F);
		LowerL_Hook.setTextureOffset(0, 68).addBox(0.0F, 0.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, true);

		LowerL_Hook2 = new AdvancedModelBox(this);
		LowerL_Hook2.setRotationPoint(24.0F, 0.0F, -2.0F);
		LowerL_Tentacle4.addChild(LowerL_Hook2);
		setRotationAngle(LowerL_Hook2, 0.0F, -0.7854F, 0.0F);
		LowerL_Hook2.setTextureOffset(183, 62).addBox(0.0F, -1.5F, -8.0F, 2.0F, 3.0F, 8.0F, 0.0F, true);

		LowerL_Hook3 = new AdvancedModelBox(this);
		LowerL_Hook3.setRotationPoint(24.0F, 0.0F, 2.0F);
		LowerL_Tentacle4.addChild(LowerL_Hook3);
		setRotationAngle(LowerL_Hook3, 0.0F, 0.7854F, 0.0F);
		LowerL_Hook3.setTextureOffset(43, 68).addBox(0.0F, -1.5F, 0.0F, 2.0F, 3.0F, 8.0F, 0.0F, true);

		LowerL_Hook4 = new AdvancedModelBox(this);
		LowerL_Hook4.setRotationPoint(24.0F, -2.0F, 0.0F);
		LowerL_Tentacle4.addChild(LowerL_Hook4);
		setRotationAngle(LowerL_Hook4, 0.0F, 0.0F, 0.7854F);
		LowerL_Hook4.setTextureOffset(0, 27).addBox(0.0F, -8.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, true);

		Head = new AdvancedModelBox(this);
		Head.setRotationPoint(0.0F, 2.0F, -34.0F);
		body.addChild(Head);


		Muscle = new AdvancedModelBox(this);
		Muscle.setRotationPoint(0.0F, 0.0F, -2.0F);
		Head.addChild(Muscle);
		Muscle.setTextureOffset(43, 0).addBox(-4.5F, -6.0F, -2.0F, 0.0F, 11.0F, 4.0F, 0.0F, false);
		Muscle.setTextureOffset(43, 0).addBox(4.5F, -6.0F, -2.0F, 0.0F, 11.0F, 4.0F, 0.0F, true);

		Maw = new AdvancedModelBox(this);
		Maw.setRotationPoint(0.0F, 2.0F, 0.25F);
		Head.addChild(Maw);
		Maw.setTextureOffset(171, 50).addBox(-5.0F, 0.0F, -8.25F, 10.0F, 3.0F, 8.0F, 0.0F, false);
		Maw.setTextureOffset(131, 95).addBox(5.0F, -3.0F, -8.25F, 0.0F, 3.0F, 6.0F, 0.0F, false);
		Maw.setTextureOffset(57, 80).addBox(3.0F, -3.0F, -12.25F, 0.0F, 3.0F, 4.0F, 0.0F, false);
		Maw.setTextureOffset(107, 120).addBox(-3.0F, -5.0F, -12.25F, 6.0F, 5.0F, 0.0F, 0.0F, false);
		Maw.setTextureOffset(56, 68).addBox(-3.0F, -3.0F, -12.25F, 0.0F, 3.0F, 4.0F, 0.0F, false);
		Maw.setTextureOffset(25, 0).addBox(3.0F, -3.0F, -8.25F, 2.0F, 3.0F, 0.0F, 0.0F, false);
		Maw.setTextureOffset(10, 11).addBox(-5.0F, -3.0F, -8.25F, 2.0F, 3.0F, 0.0F, 0.0F, false);
		Maw.setTextureOffset(62, 131).addBox(-5.0F, -3.0F, -8.25F, 0.0F, 3.0F, 6.0F, 0.0F, false);
		Maw.setTextureOffset(27, 135).addBox(-3.0F, 0.0F, -12.25F, 6.0F, 4.0F, 4.0F, 0.0F, false);

		Skul = new AdvancedModelBox(this);
		Skul.setRotationPoint(0.0F, -1.0F, 0.0F);
		Head.addChild(Skul);
		Skul.setTextureOffset(141, 169).addBox(-4.0F, -6.0F, -13.0F, 8.0F, 7.0F, 4.0F, 0.0F, false);
		Skul.setTextureOffset(164, 75).addBox(-6.0F, -6.0F, -9.0F, 12.0F, 6.0F, 9.0F, 0.0F, false);
		Skul.setTextureOffset(25, 27).addBox(-6.0F, 0.0F, -9.0F, 0.0F, 3.0F, 7.0F, 0.0F, false);
		Skul.setTextureOffset(5, 11).addBox(-6.0F, 0.0F, -9.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);
		Skul.setTextureOffset(0, 11).addBox(4.0F, 0.0F, -9.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);
		Skul.setTextureOffset(0, 0).addBox(6.0F, 0.0F, -9.0F, 0.0F, 3.0F, 7.0F, 0.0F, false);
		Skul.setTextureOffset(122, 64).addBox(-4.0F, 1.0F, -13.0F, 8.0F, 3.0F, 0.0F, 0.0F, false);
		Skul.setTextureOffset(8, 0).addBox(4.0F, 1.0F, -13.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		Skul.setTextureOffset(0, 0).addBox(-4.0F, 1.0F, -13.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		tongue = new AdvancedModelBox(this);
		tongue.setRotationPoint(0.0F, -1.0F, 0.0F);
		Head.addChild(tongue);

		R_fin = new AdvancedModelBox(this);
		R_fin.setRotationPoint(-9.0F, 9.0F, -24.0F);
		body.addChild(R_fin);
		R_fin.setTextureOffset(90, 93).addBox(-12.0F, -1.0F, -8.0F, 12.0F, 2.0F, 16.0F, 0.0F, false);
		R_fin.setTextureOffset(107, 114).addBox(-12.0F, -1.0F, 8.0F, 12.0F, 0.0F, 5.0F, 0.0F, false);

		R_fin2 = new AdvancedModelBox(this);
		R_fin2.setRotationPoint(-12.0F, 0.0F, 1.0F);
		R_fin.addChild(R_fin2);
		R_fin2.setTextureOffset(131, 96).addBox(-8.0F, 0.0F, -9.0F, 8.0F, 1.0F, 16.0F, 0.0F, false);

		R_fin3 = new AdvancedModelBox(this);
		R_fin3.setRotationPoint(-8.0F, 0.0F, 2.0F);
		R_fin2.addChild(R_fin3);
		R_fin3.setTextureOffset(142, 132).addBox(-9.0F, 0.0F, -9.0F, 9.0F, 1.0F, 14.0F, 0.0F, false);
		R_fin3.setTextureOffset(140, 64).addBox(-11.0F, 0.0F, 5.0F, 16.0F, 0.0F, 10.0F, 0.0F, false);

		L_fin = new AdvancedModelBox(this);
		L_fin.setRotationPoint(9.0F, 9.0F, -24.0F);
		body.addChild(L_fin);
		L_fin.setTextureOffset(92, 20).addBox(0.0F, -1.0F, -8.0F, 12.0F, 2.0F, 16.0F, 0.0F, false);
		L_fin.setTextureOffset(43, 36).addBox(0.0F, -1.0F, 8.0F, 12.0F, 0.0F, 5.0F, 0.0F, false);

		L_fin2 = new AdvancedModelBox(this);
		L_fin2.setRotationPoint(12.0F, 0.0F, 1.0F);
		L_fin.addChild(L_fin2);
		L_fin2.setTextureOffset(131, 77).addBox(0.0F, 0.0F, -9.0F, 8.0F, 1.0F, 16.0F, 0.0F, false);

		L_fin3 = new AdvancedModelBox(this);
		L_fin3.setRotationPoint(8.0F, 0.0F, 2.0F);
		L_fin2.addChild(L_fin3);
		L_fin3.setTextureOffset(140, 114).addBox(0.0F, 0.0F, -9.0F, 9.0F, 1.0F, 14.0F, 0.0F, false);
		L_fin3.setTextureOffset(85, 39).addBox(-5.0F, 0.0F, 5.0F, 16.0F, 0.0F, 10.0F, 0.0F, false);

		four_mouths = new AdvancedModelBox(this);
		four_mouths.setRotationPoint(0.0F, 1.0F, -35.0F);
		body.addChild(four_mouths);


		Mouth4 = new AdvancedModelBox(this);
		Mouth4.setRotationPoint(6.0F, 6.0F, 2.0F);
		four_mouths.addChild(Mouth4);
		setRotationAngle(Mouth4, 0.0436F, 0.0F, 0.0F);
		Mouth4.setTextureOffset(122, 39).addBox(-4.0F, -4.0F, -16.0F, 8.0F, 8.0F, 16.0F, 0.0F, false);
		Mouth4.setTextureOffset(181, 91).addBox(-6.0F, 4.0F, -16.0F, 2.0F, 0.0F, 14.0F, 0.0F, false);
		Mouth4.setTextureOffset(141, 183).addBox(4.0F, -6.0F, -16.0F, 0.0F, 2.0F, 14.0F, 0.0F, false);

		Mouth4_e = new AdvancedModelBox(this);
		Mouth4_e.setRotationPoint(-1.0F, -1.0F, -15.5F);
		Mouth4.addChild(Mouth4_e);
		setRotationAngle(Mouth4_e, -0.0873F, 0.0F, 0.0F);
		Mouth4_e.setTextureOffset(70, 156).addBox(-5.0F, -5.0F, -11.0F, 9.0F, 9.0F, 11.0F, 0.0F, false);

		Mouth3 = new AdvancedModelBox(this);
		Mouth3.setRotationPoint(-6.0F, 6.0F, 2.0F);
		four_mouths.addChild(Mouth3);
		setRotationAngle(Mouth3, 0.0436F, 0.0F, 0.0F);
		Mouth3.setTextureOffset(107, 121).addBox(-4.0F, -4.0F, -16.0F, 8.0F, 8.0F, 16.0F, 0.0F, false);
		Mouth3.setTextureOffset(141, 183).addBox(-4.0F, -6.0F, -16.0F, 0.0F, 2.0F, 14.0F, 0.0F, false);
		Mouth3.setTextureOffset(178, 169).addBox(4.0F, 4.0F, -16.0F, 2.0F, 0.0F, 14.0F, 0.0F, false);

		Mouth3_e = new AdvancedModelBox(this);
		Mouth3_e.setRotationPoint(1.0F, -1.0F, -15.5F);
		Mouth3.addChild(Mouth3_e);
		setRotationAngle(Mouth3_e, -0.0873F, 0.0F, 0.0F);
		Mouth3_e.setTextureOffset(155, 29).addBox(-4.0F, -5.0F, -11.0F, 9.0F, 9.0F, 11.0F, 0.0F, false);

		Mouth2 = new AdvancedModelBox(this);
		Mouth2.setRotationPoint(6.0F, -6.0F, 2.0F);
		four_mouths.addChild(Mouth2);
		setRotationAngle(Mouth2, -0.0436F, 0.0F, 0.0F);
		Mouth2.setTextureOffset(74, 112).addBox(-4.0F, -4.0F, -16.0F, 8.0F, 8.0F, 16.0F, 0.0F, false);
		Mouth2.setTextureOffset(73, 177).addBox(-6.0F, -4.0F, -16.0F, 2.0F, 0.0F, 14.0F, 0.0F, false);
		Mouth2.setTextureOffset(0, 182).addBox(4.0F, 4.0F, -16.0F, 0.0F, 2.0F, 14.0F, 0.0F, false);

		Mouth2_e = new AdvancedModelBox(this);
		Mouth2_e.setRotationPoint(-1.0F, 1.0F, -15.5F);
		Mouth2.addChild(Mouth2_e);
		setRotationAngle(Mouth2_e, 0.0873F, 0.0F, 0.0F);
		Mouth2_e.setTextureOffset(143, 148).addBox(-5.0F, -4.0F, -11.0F, 9.0F, 9.0F, 11.0F, 0.0F, false);

		Mouth = new AdvancedModelBox(this);
		Mouth.setRotationPoint(-6.0F, -6.0F, 2.0F);
		four_mouths.addChild(Mouth);
		setRotationAngle(Mouth, -0.0436F, 0.0F, 0.0F);
		Mouth.setTextureOffset(0, 110).addBox(-4.0F, -4.0F, -16.0F, 8.0F, 8.0F, 16.0F, 0.0F, false);
		Mouth.setTextureOffset(92, 0).addBox(4.0F, -4.0F, -16.0F, 2.0F, 0.0F, 14.0F, 0.0F, false);
		Mouth.setTextureOffset(0, 182).addBox(-4.0F, 4.0F, -16.0F, 0.0F, 2.0F, 14.0F, 0.0F, false);

		Mouth1_e = new AdvancedModelBox(this);
		Mouth1_e.setRotationPoint(1.0F, 1.0F, -15.5F);
		Mouth.addChild(Mouth1_e);
		setRotationAngle(Mouth1_e, 0.0873F, 0.0F, 0.0F);
		Mouth1_e.setTextureOffset(102, 146).addBox(-4.0F, -4.0F, -11.0F, 9.0F, 9.0F, 11.0F, 0.0F, false);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	private static double horizontalMag(Vec3 vec) {
		return vec.x * vec.x + vec.z * vec.z;
	}

	public void animate(The_Leviathan_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_GRAB);
		animator.startKeyframe(25);
		animator.rotate(Maw, (float) Math.toRadians(32.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-35F), 0, 0);
		animator.rotate(Mouth, (float) Math.toRadians(-37.5F), (float) Math.toRadians(42.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-37.5F), (float) Math.toRadians(-42.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(37.5F), (float) Math.toRadians(42.5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(37.5F), (float) Math.toRadians(-42.5F), 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(120);

		animator.resetKeyframe(15);


		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_GRAB_BITE);
		animator.startKeyframe(0);
		animator.rotate(Maw, (float) Math.toRadians(32.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-35F), 0, 0);
		animator.rotate(Mouth, (float) Math.toRadians(-37.5F), (float) Math.toRadians(42.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-37.5F), (float) Math.toRadians(-42.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(37.5F), (float) Math.toRadians(42.5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(37.5F), (float) Math.toRadians(-42.5F), 0);
		animator.endKeyframe();


		animator.resetKeyframe(3);

		animator.setStaticKeyframe(10);


		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_ABYSS_BLAST);
		animator.startKeyframe(20);
		animator.rotate(Maw, (float) Math.toRadians(20F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-20F), 0, 0);
		animator.rotate(Mouth, (float) Math.toRadians(-15F), (float) Math.toRadians(7.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-15F), (float) Math.toRadians(-7.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(2.5F), (float) Math.toRadians(5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(2.5F), (float) Math.toRadians(-5F), 0);
		animator.rotate(Tail, (float) Math.toRadians(15F), 0, 0);
		animator.rotate(Tail2, (float) Math.toRadians(12.5F), 0, 0);
		animator.rotate(Tail3, (float) Math.toRadians(12.5F), 0, 0);

		animator.rotate(LowerL_Tentacle4, 0, (float) Math.toRadians(-50F), 0);
		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(25F), 0);

		animator.rotate(LowerR_Tentacle4, 0, (float) Math.toRadians(47.5F), 0);
		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(-25F), 0);

		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(-50F), 0);
		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(25F), 0);

		animator.rotate(UpperR_Tentacle4, 0, (float) Math.toRadians(50F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(-25F), 0);


		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(25);
		animator.rotate(Tail, (float) Math.toRadians(17.5F), 0, 0);
		animator.rotate(Tail2, (float) Math.toRadians(15F), 0, 0);
		animator.rotate(Tail3, (float) Math.toRadians(15F), 0, 0);

		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(17.5F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(15F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(15F), 0);

		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(-17.5F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(-15F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(-15F), 0);

		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(17.5F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(15F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(15F), 0);

		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(-17.5F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(-15F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(-15F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(26);

		animator.startKeyframe(3);
		animator.rotate(Maw, (float) Math.toRadians(37.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-40F), 0, 0);
		animator.rotate(Mouth, (float) Math.toRadians(-37.5F), (float) Math.toRadians(40F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-37.5F), (float) Math.toRadians(-40F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(37.5F), (float) Math.toRadians(40F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(37.5F), (float) Math.toRadians(-40F), 0);
		animator.rotate(Tail, (float) Math.toRadians(25F), 0, (float) Math.toRadians(5F));
		animator.rotate(Tail2, (float) Math.toRadians(27.5F), 0, (float) Math.toRadians(-2.5F));
		animator.rotate(Tail3, (float) Math.toRadians(50F), 0, (float) Math.toRadians(-2.5F));

		animator.rotate(LowerL_Tentacle4, 0, (float) Math.toRadians(-55F), 0);
		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(-20F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(27.5F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(22.5F), 0);

		animator.rotate(LowerR_Tentacle4, 0, (float) Math.toRadians(55F), 0);
		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(20F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(-27.5F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(-22.5F), 0);

		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(-55F), 0);
		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(-20F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(27.5F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(22.5F), 0);

		animator.rotate(UpperR_Tentacle4, 0, (float) Math.toRadians(55F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(20F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(-27.5F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(-22.5F), 0);

		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.rotate(Maw, (float) Math.toRadians(37.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-40F), 0, 0);
		animator.rotate(Mouth, (float) Math.toRadians(-37.5F), (float) Math.toRadians(40F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-37.5F), (float) Math.toRadians(-40F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(37.5F), (float) Math.toRadians(40F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(37.5F), (float) Math.toRadians(-40F), 0);
		animator.rotate(Tail, (float) Math.toRadians(25F), 0, (float) Math.toRadians(5F));
		animator.rotate(Tail2, (float) Math.toRadians(27.5F), 0, (float) Math.toRadians(-2.5F));
		animator.rotate(Tail3, (float) Math.toRadians(50F), 0, (float) Math.toRadians(-2.5F));

		animator.rotate(LowerL_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(42.5F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-70F), 0);

		animator.rotate(LowerR_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(-42.5F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(70F), 0);

		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(42.5F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-70F), 0);

		animator.rotate(UpperR_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(-42.5F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(70F), 0);

		animator.endKeyframe();

		animator.setStaticKeyframe(78);

		animator.resetKeyframe(20);

		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_RUSH);
		animator.startKeyframe(25);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(20F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(50F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(50F), 0);
		animator.rotate(UpperR_Tentacle4, 0, (float) Math.toRadians(70F), 0);

		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-20F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(-50F), 0);
		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(-50F), 0);
		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(-70F), 0);

		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(20F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(50F), 0);
		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(52.5F), 0);
		animator.rotate(LowerR_Tentacle4, 0, (float) Math.toRadians(55F), 0);

		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-20F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(-50F), 0);
		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(-52.5F), 0);
		animator.rotate(LowerL_Tentacle4, 0, (float) Math.toRadians(-55F), 0);

		animator.rotate(Mouth, (float) Math.toRadians(-2.5F), 0, 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-2.5F), 0, 0);
		animator.rotate(Mouth3, (float) Math.toRadians(2.5F), 0, 0);
		animator.rotate(Mouth4, (float) Math.toRadians(2.5F), 0, 0);

		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(3);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(37.5F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(45F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(50F), 0);
		animator.rotate(UpperR_Tentacle4, 0, (float) Math.toRadians(40F), 0);
		animator.rotate(UpperR_Hook, 0, 0, (float) Math.toRadians(25F));
		animator.rotate(UpperR_Hook2, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(UpperR_Hook3, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(UpperR_Hook4, 0, 0, (float) Math.toRadians(-25F));

		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-37.5F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(-45F), 0);
		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(-50F), 0);
		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(-40F), 0);
		animator.rotate(UpperL_Hook, 0, 0, (float) Math.toRadians(-25F));
		animator.rotate(UpperL_Hook2, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(UpperL_Hook3, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(UpperL_Hook4, 0, 0, (float) Math.toRadians(25F));

		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(37.5F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(45F), 0);
		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(52.5F), 0);
		animator.rotate(LowerR_Tentacle4, 0, (float) Math.toRadians(30F), 0);
		animator.rotate(LowerR_Hook, 0, 0, (float) Math.toRadians(25F));
		animator.rotate(LowerR_Hook2, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(LowerR_Hook3, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(LowerR_Hook4, 0, 0, (float) Math.toRadians(-25F));

		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-37.5F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(-45F), 0);
		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(-52.5F), 0);
		animator.rotate(LowerL_Tentacle4, 0, (float) Math.toRadians(-30F), 0);
		animator.rotate(LowerL_Hook, 0, 0, (float) Math.toRadians(-25F));
		animator.rotate(LowerL_Hook2, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(LowerL_Hook3, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(LowerL_Hook4, 0, 0, (float) Math.toRadians(25F));

		animator.rotate(Maw, (float) Math.toRadians(15F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-30F), 0, 0);
		animator.rotate(Mouth, (float) Math.toRadians(-27.5F), (float) Math.toRadians(2.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-27.5F), (float) Math.toRadians(-2.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(10F), (float) Math.toRadians(2.5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(10F), (float) Math.toRadians(-2.5F), 0);

		animator.endKeyframe();

		animator.setStaticKeyframe(16);

		animator.startKeyframe(3);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(55F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(45F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(50F), 0);
		animator.rotate(UpperR_Tentacle4, 0, (float) Math.toRadians(40F), 0);
		animator.rotate(UpperR_Hook, 0, 0, (float) Math.toRadians(25F));
		animator.rotate(UpperR_Hook2, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(UpperR_Hook3, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(UpperR_Hook4, 0, 0, (float) Math.toRadians(-25F));

		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-55F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(-45F), 0);
		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(-50F), 0);
		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(-40F), 0);
		animator.rotate(UpperL_Hook, 0, 0, (float) Math.toRadians(-25F));
		animator.rotate(UpperL_Hook2, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(UpperL_Hook3, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(UpperL_Hook4, 0, 0, (float) Math.toRadians(25F));

		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(55F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(45F), 0);
		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(52.5F), 0);
		animator.rotate(LowerR_Tentacle4, 0, (float) Math.toRadians(30F), 0);
		animator.rotate(LowerR_Hook, 0, 0, (float) Math.toRadians(25F));
		animator.rotate(LowerR_Hook2, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(LowerR_Hook3, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(LowerR_Hook4, 0, 0, (float) Math.toRadians(-25F));

		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-55F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(-45F), 0);
		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(-52.5F), 0);
		animator.rotate(LowerL_Tentacle4, 0, (float) Math.toRadians(-30F), 0);
		animator.rotate(LowerL_Hook, 0, 0, (float) Math.toRadians(-25F));
		animator.rotate(LowerL_Hook2, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(LowerL_Hook3, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(LowerL_Hook4, 0, 0, (float) Math.toRadians(25F));

		animator.rotate(Maw, (float) Math.toRadians(20F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-35F), 0, 0);
		animator.rotate(Mouth, (float) Math.toRadians(-37.5F), (float) Math.toRadians(7.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-37.5F), (float) Math.toRadians(-7.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(37.5F), (float) Math.toRadians(7.5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(37.5F), (float) Math.toRadians(-7.5F), 0);

		animator.endKeyframe();

		animator.setStaticKeyframe(80);

		animator.resetKeyframe(20);


		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_ABYSS_BLAST_PORTAL);
		animator.startKeyframe(25);
		animator.rotate(Mouth, (float) Math.toRadians(-30F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-30F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(30F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(30F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Maw, (float) Math.toRadians(42.5F), 0, 0);
		animator.rotate(UpperR_Tentacle, (float) Math.toRadians(27.5F), (float) Math.toRadians(10F), (float) Math.toRadians(20F));
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(-22.5F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(-35F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(17.5F), 0);

		animator.rotate(UpperL_Tentacle, (float) Math.toRadians(27.5F), (float) Math.toRadians(-5F), (float) Math.toRadians(-15F));
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(20F), 0);
		if(!entity.blocksByrighttentacle) {
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(15F), (float) Math.toRadians(35F), (float) Math.toRadians(80F));
		}else{
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(15F), (float) Math.toRadians(35F), (float) Math.toRadians(47.5F));
		}
		if(!entity.blocksByrighttentacle){
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(57.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(-82.5F));
		}else{
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(57.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(-50F));
		}
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(57.5F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(7.5F), 0);
		animator.rotate(LowerR_Tentacle4,(float)Math.toRadians(67.5F),(float)Math.toRadians(-30F), (float)Math.toRadians(-65F));
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-5F), 0);
		animator.rotate(LowerR_Tentacle2,(float)Math.toRadians(2.5F),0, 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(45F), 0);

		animator.rotate(Tail3,(float)Math.toRadians(15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-32.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-32.5F),0, 0);
		animator.rotate(body,(float)Math.toRadians(25F),0, 0);
		animator.rotate(root,(float)Math.toRadians(-5F),0, 0);
		animator.move(root,0,-28, 0);
		animator.rotate(Skul,(float)Math.toRadians(-12.5F),0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(10);

		animator.startKeyframe(3);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(40F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(7.5F), 0);
		animator.rotate(LowerR_Tentacle4,(float)Math.toRadians(32.5F),(float)Math.toRadians(-25F), (float)Math.toRadians(-20F));
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-5F), 0);
		animator.rotate(LowerR_Tentacle2,(float)Math.toRadians(5F),(float)Math.toRadians(-32.5F), (float)Math.toRadians(-2.5F));
		animator.rotate(UpperL_Tentacle3,(float)Math.toRadians(52.5F),(float)Math.toRadians(32.5F), (float)Math.toRadians(57.5F));
		animator.rotate(Tail3,(float)Math.toRadians(15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-7.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-32.5F),0, 0);
		animator.rotate(body,(float)Math.toRadians(25F),0, 0);
		animator.move(root,0,-23, 0);
		animator.rotate(Skul,(float)Math.toRadians(-12.5F),0, 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(25F), 0);
		if(!entity.blocksBylefttentacle) {
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-70F));
		}else{
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-37.5F));
		}
		if(!entity.blocksByrighttentacle) {
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(72.5F));
		}else{
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(37.5F));
		}

		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-30F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(10F), 0);
		animator.rotate(UpperL_Tentacle,(float)Math.toRadians(35F),(float)Math.toRadians(25F), (float)Math.toRadians(5F));
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(22.5F),0);
		animator.rotate(UpperR_Tentacle3,(float)Math.toRadians(-30F),(float)Math.toRadians(-30F),(float)Math.toRadians(35F));
		animator.rotate(UpperR_Tentacle2,(float)Math.toRadians(-7.5F),(float)Math.toRadians(-17.5F),(float)Math.toRadians(10F));
		animator.rotate(UpperR_Tentacle,(float)Math.toRadians(72.5F),(float)Math.toRadians(-22.5F),0);
		animator.endKeyframe();
		animator.setStaticKeyframe(15);

		animator.startKeyframe(3);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(40F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(7.5F), 0);
		animator.rotate(LowerR_Tentacle4,(float)Math.toRadians(32.5F),(float)Math.toRadians(-25F), (float)Math.toRadians(-20F));
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-5F), 0);
		animator.rotate(LowerR_Tentacle2,(float)Math.toRadians(5F),(float)Math.toRadians(-32.5F), (float)Math.toRadians(-2.5F));
		animator.rotate(UpperL_Tentacle3,(float)Math.toRadians(52.5F),(float)Math.toRadians(32.5F), (float)Math.toRadians(57.5F));
		animator.rotate(Tail3,(float)Math.toRadians(15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-7.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-32.5F),0, 0);
		animator.rotate(body,(float)Math.toRadians(25F),0, 0);
		animator.move(root,0,-23, 0);
		animator.rotate(Skul,(float)Math.toRadians(-12.5F),0, 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(25F), 0);
		if(!entity.blocksBylefttentacle) {
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-70F));
		}else{
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-37.5F));
		}
		if(!entity.blocksByrighttentacle) {
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(72.5F));
		}else{
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(37.5F));
		}

		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-30F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(10F), 0);
		animator.rotate(UpperL_Tentacle,(float)Math.toRadians(35F),(float)Math.toRadians(25F), (float)Math.toRadians(5F));
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(22.5F),0);
		animator.rotate(UpperR_Tentacle3,(float)Math.toRadians(-30F),(float)Math.toRadians(-30F),(float)Math.toRadians(35F));
		animator.rotate(UpperR_Tentacle2,(float)Math.toRadians(-7.5F),(float)Math.toRadians(-17.5F),(float)Math.toRadians(10F));
		animator.rotate(UpperR_Tentacle,(float)Math.toRadians(72.5F),(float)Math.toRadians(-22.5F),0);

		animator.rotate(Mouth, (float) Math.toRadians(-30F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-30F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(15F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(15F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Maw, (float) Math.toRadians(42.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-42.5F), 0, 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(3);

		animator.startKeyframe(12);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(40F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(7.5F), 0);
		animator.rotate(LowerR_Tentacle4,(float)Math.toRadians(32.5F),(float)Math.toRadians(-25F), (float)Math.toRadians(-20F));
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-5F), 0);
		animator.rotate(LowerR_Tentacle2,(float)Math.toRadians(5F),(float)Math.toRadians(-32.5F), (float)Math.toRadians(-2.5F));
		animator.rotate(UpperL_Tentacle3,(float)Math.toRadians(52.5F),(float)Math.toRadians(32.5F), (float)Math.toRadians(57.5F));
		animator.rotate(Tail3,(float)Math.toRadians(15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-7.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-32.5F),0, 0);
		animator.rotate(body,(float)Math.toRadians(25F),0, 0);
		animator.move(root,0,-23, 0);
		animator.rotate(Skul,(float)Math.toRadians(-12.5F),0, 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(25F), 0);
		if(!entity.blocksBylefttentacle) {
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-70F));
		}else{
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-37.5F));
		}
		if(!entity.blocksByrighttentacle) {
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(72.5F));
		}else{
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(37.5F));
		}

		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-30F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(10F), 0);
		animator.rotate(UpperL_Tentacle,(float)Math.toRadians(35F),(float)Math.toRadians(25F), (float)Math.toRadians(5F));
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(22.5F),0);
		animator.rotate(UpperR_Tentacle3,(float)Math.toRadians(-30F),(float)Math.toRadians(-30F),(float)Math.toRadians(35F));
		animator.rotate(UpperR_Tentacle2,(float)Math.toRadians(-7.5F),(float)Math.toRadians(-17.5F),(float)Math.toRadians(10F));
		animator.rotate(UpperR_Tentacle,(float)Math.toRadians(72.5F),(float)Math.toRadians(-22.5F),0);

		animator.rotate(Mouth, (float) Math.toRadians(-30F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-30F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(15F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(15F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Head, 0, (float) Math.toRadians(-20F), 0);
		animator.rotate(Maw, (float) Math.toRadians(42.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-42.5F), 0, 0);
		animator.rotate(four_mouths, 0, (float) Math.toRadians(-20F), 0);
		animator.endKeyframe();

		animator.startKeyframe(11);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(40F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(7.5F), 0);
		animator.rotate(LowerR_Tentacle4,(float)Math.toRadians(32.5F),(float)Math.toRadians(-25F), (float)Math.toRadians(-20F));
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-5F), 0);
		animator.rotate(LowerR_Tentacle2,(float)Math.toRadians(5F),(float)Math.toRadians(-32.5F), (float)Math.toRadians(-2.5F));
		animator.rotate(UpperL_Tentacle3,(float)Math.toRadians(52.5F),(float)Math.toRadians(32.5F), (float)Math.toRadians(57.5F));
		animator.rotate(Tail3,(float)Math.toRadians(15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-7.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-32.5F),0, 0);
		animator.rotate(body,(float)Math.toRadians(25F),0, 0);
		animator.move(root,0,-23, 0);
		animator.rotate(Skul,(float)Math.toRadians(-12.5F),0, 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(25F), 0);
		if(!entity.blocksBylefttentacle) {
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-70F));
		}else{
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-37.5F));
		}
		if(!entity.blocksByrighttentacle) {
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(72.5F));
		}else{
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(37.5F));
		}
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-30F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(10F), 0);
		animator.rotate(UpperL_Tentacle,(float)Math.toRadians(35F),(float)Math.toRadians(25F), (float)Math.toRadians(5F));
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(22.5F),0);
		animator.rotate(UpperR_Tentacle3,(float)Math.toRadians(-30F),(float)Math.toRadians(-30F),(float)Math.toRadians(35F));
		animator.rotate(UpperR_Tentacle2,(float)Math.toRadians(-7.5F),(float)Math.toRadians(-17.5F),(float)Math.toRadians(10F));
		animator.rotate(UpperR_Tentacle,(float)Math.toRadians(72.5F),(float)Math.toRadians(-22.5F),0);
		animator.rotate(Mouth, (float) Math.toRadians(-30F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-30F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(15F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(15F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Head, 0, (float) Math.toRadians(20F), 0);
		animator.rotate(Maw, (float) Math.toRadians(42.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-42.5F), 0, 0);
		animator.rotate(four_mouths, 0, (float) Math.toRadians(20F), 0);
		animator.endKeyframe();

		animator.startKeyframe(10);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(40F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(7.5F), 0);
		animator.rotate(LowerR_Tentacle4,(float)Math.toRadians(32.5F),(float)Math.toRadians(-25F), (float)Math.toRadians(-20F));
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-5F), 0);
		animator.rotate(LowerR_Tentacle2,(float)Math.toRadians(5F),(float)Math.toRadians(-32.5F), (float)Math.toRadians(-2.5F));
		animator.rotate(UpperL_Tentacle3,(float)Math.toRadians(52.5F),(float)Math.toRadians(32.5F), (float)Math.toRadians(57.5F));
		animator.rotate(Tail3,(float)Math.toRadians(15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-7.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-32.5F),0, 0);
		animator.rotate(body,(float)Math.toRadians(25F),0, 0);
		animator.move(root,0,-23, 0);
		animator.rotate(Skul,(float)Math.toRadians(-12.5F),0, 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(25F), 0);
		if(!entity.blocksBylefttentacle) {
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-70F));
		}else{
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-37.5F));
		}
		if(!entity.blocksByrighttentacle) {
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(72.5F));
		}else{
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(37.5F));
		}
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-30F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(10F), 0);
		animator.rotate(UpperL_Tentacle,(float)Math.toRadians(35F),(float)Math.toRadians(25F), (float)Math.toRadians(5F));
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(22.5F),0);
		animator.rotate(UpperR_Tentacle3,(float)Math.toRadians(-30F),(float)Math.toRadians(-30F),(float)Math.toRadians(35F));
		animator.rotate(UpperR_Tentacle2,(float)Math.toRadians(-7.5F),(float)Math.toRadians(-17.5F),(float)Math.toRadians(10F));
		animator.rotate(UpperR_Tentacle,(float)Math.toRadians(72.5F),(float)Math.toRadians(-22.5F),0);

		animator.rotate(Mouth, (float) Math.toRadians(-30F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-30F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(15F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(15F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Head, 0, (float) Math.toRadians(-20F), 0);
		animator.rotate(Maw, (float) Math.toRadians(42.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-42.5F), 0, 0);
		animator.rotate(four_mouths, 0, (float) Math.toRadians(-20F), 0);
		animator.endKeyframe();

		animator.startKeyframe(9);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(40F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(7.5F), 0);
		animator.rotate(LowerR_Tentacle4,(float)Math.toRadians(32.5F),(float)Math.toRadians(-25F), (float)Math.toRadians(-20F));
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-5F), 0);
		animator.rotate(LowerR_Tentacle2,(float)Math.toRadians(5F),(float)Math.toRadians(-32.5F), (float)Math.toRadians(-2.5F));
		animator.rotate(UpperL_Tentacle3,(float)Math.toRadians(52.5F),(float)Math.toRadians(32.5F), (float)Math.toRadians(57.5F));
		animator.rotate(Tail3,(float)Math.toRadians(15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-7.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-32.5F),0, 0);
		animator.rotate(body,(float)Math.toRadians(25F),0, 0);
		animator.move(root,0,-23, 0);
		animator.rotate(Skul,(float)Math.toRadians(-12.5F),0, 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(25F), 0);
		if(!entity.blocksBylefttentacle) {
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-70F));
		}else{
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-37.5F));
		}
		if(!entity.blocksByrighttentacle) {
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(72.5F));
		}else{
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(37.5F));
		}
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-30F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(10F), 0);
		animator.rotate(UpperL_Tentacle,(float)Math.toRadians(35F),(float)Math.toRadians(25F), (float)Math.toRadians(5F));
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(22.5F),0);
		animator.rotate(UpperR_Tentacle3,(float)Math.toRadians(-30F),(float)Math.toRadians(-30F),(float)Math.toRadians(35F));
		animator.rotate(UpperR_Tentacle2,(float)Math.toRadians(-7.5F),(float)Math.toRadians(-17.5F),(float)Math.toRadians(10F));
		animator.rotate(UpperR_Tentacle,(float)Math.toRadians(72.5F),(float)Math.toRadians(-22.5F),0);
		animator.rotate(Mouth, (float) Math.toRadians(-30F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-30F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(15F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(15F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Head, 0, (float) Math.toRadians(20F), 0);
		animator.rotate(Maw, (float) Math.toRadians(42.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-42.5F), 0, 0);
		animator.rotate(four_mouths, 0, (float) Math.toRadians(20F), 0);
		animator.endKeyframe();

		animator.startKeyframe(8);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(40F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(7.5F), 0);
		animator.rotate(LowerR_Tentacle4,(float)Math.toRadians(32.5F),(float)Math.toRadians(-25F), (float)Math.toRadians(-20F));
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-5F), 0);
		animator.rotate(LowerR_Tentacle2,(float)Math.toRadians(5F),(float)Math.toRadians(-32.5F), (float)Math.toRadians(-2.5F));
		animator.rotate(UpperL_Tentacle3,(float)Math.toRadians(52.5F),(float)Math.toRadians(32.5F), (float)Math.toRadians(57.5F));
		animator.rotate(Tail3,(float)Math.toRadians(15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-7.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-32.5F),0, 0);
		animator.rotate(body,(float)Math.toRadians(25F),0, 0);
		animator.move(root,0,-23, 0);
		animator.rotate(Skul,(float)Math.toRadians(-12.5F),0, 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(25F), 0);
		if(!entity.blocksBylefttentacle) {
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-70F));
		}else{
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-37.5F));
		}
		if(!entity.blocksByrighttentacle) {
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(72.5F));
		}else{
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(37.5F));
		}
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-30F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(10F), 0);
		animator.rotate(UpperL_Tentacle,(float)Math.toRadians(35F),(float)Math.toRadians(25F), (float)Math.toRadians(5F));
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(22.5F),0);
		animator.rotate(UpperR_Tentacle3,(float)Math.toRadians(-30F),(float)Math.toRadians(-30F),(float)Math.toRadians(35F));
		animator.rotate(UpperR_Tentacle2,(float)Math.toRadians(-7.5F),(float)Math.toRadians(-17.5F),(float)Math.toRadians(10F));
		animator.rotate(UpperR_Tentacle,(float)Math.toRadians(72.5F),(float)Math.toRadians(-22.5F),0);

		animator.rotate(Mouth, (float) Math.toRadians(-30F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-30F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(15F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(15F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Head, 0, (float) Math.toRadians(-20F), 0);
		animator.rotate(Maw, (float) Math.toRadians(42.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-42.5F), 0, 0);
		animator.rotate(four_mouths, 0, (float) Math.toRadians(-20F), 0);
		animator.endKeyframe();

		animator.startKeyframe(7);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(40F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(7.5F), 0);
		animator.rotate(LowerR_Tentacle4,(float)Math.toRadians(32.5F),(float)Math.toRadians(-25F), (float)Math.toRadians(-20F));
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-5F), 0);
		animator.rotate(LowerR_Tentacle2,(float)Math.toRadians(5F),(float)Math.toRadians(-32.5F), (float)Math.toRadians(-2.5F));
		animator.rotate(UpperL_Tentacle3,(float)Math.toRadians(52.5F),(float)Math.toRadians(32.5F), (float)Math.toRadians(57.5F));
		animator.rotate(Tail3,(float)Math.toRadians(15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-7.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-32.5F),0, 0);
		animator.rotate(body,(float)Math.toRadians(25F),0, 0);
		animator.move(root,0,-23, 0);
		animator.rotate(Skul,(float)Math.toRadians(-12.5F),0, 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(25F), 0);
		if(!entity.blocksBylefttentacle) {
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-70F));
		}else{
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-37.5F));
		}
		if(!entity.blocksByrighttentacle) {
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(72.5F));
		}else{
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(37.5F));
		}
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-30F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(10F), 0);
		animator.rotate(UpperL_Tentacle,(float)Math.toRadians(35F),(float)Math.toRadians(25F), (float)Math.toRadians(5F));
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(22.5F),0);
		animator.rotate(UpperR_Tentacle3,(float)Math.toRadians(-30F),(float)Math.toRadians(-30F),(float)Math.toRadians(35F));
		animator.rotate(UpperR_Tentacle2,(float)Math.toRadians(-7.5F),(float)Math.toRadians(-17.5F),(float)Math.toRadians(10F));
		animator.rotate(UpperR_Tentacle,(float)Math.toRadians(72.5F),(float)Math.toRadians(-22.5F),0);
		animator.rotate(Mouth, (float) Math.toRadians(-30F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-30F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(15F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(15F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Head, 0, (float) Math.toRadians(20F), 0);
		animator.rotate(Maw, (float) Math.toRadians(42.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-42.5F), 0, 0);
		animator.rotate(four_mouths, 0, (float) Math.toRadians(20F), 0);
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(40F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(7.5F), 0);
		animator.rotate(LowerR_Tentacle4,(float)Math.toRadians(32.5F),(float)Math.toRadians(-25F), (float)Math.toRadians(-20F));
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-5F), 0);
		animator.rotate(LowerR_Tentacle2,(float)Math.toRadians(5F),(float)Math.toRadians(-32.5F), (float)Math.toRadians(-2.5F));
		animator.rotate(UpperL_Tentacle3,(float)Math.toRadians(52.5F),(float)Math.toRadians(32.5F), (float)Math.toRadians(57.5F));
		animator.rotate(Tail3,(float)Math.toRadians(15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-7.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-32.5F),0, 0);
		animator.rotate(body,(float)Math.toRadians(25F),0, 0);
		animator.move(root,0,-23, 0);
		animator.rotate(Skul,(float)Math.toRadians(-12.5F),0, 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(25F), 0);
		if(!entity.blocksBylefttentacle) {
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-70F));
		}else{
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(85F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-37.5F));
		}
		if(!entity.blocksByrighttentacle) {
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(72.5F));
		}else{
			animator.rotate(LowerR_Tentacle, (float) Math.toRadians(80F), (float) Math.toRadians(15F), (float) Math.toRadians(37.5F));
		}

		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-30F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(10F), 0);
		animator.rotate(UpperL_Tentacle,(float)Math.toRadians(35F),(float)Math.toRadians(25F), (float)Math.toRadians(5F));
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(22.5F),0);
		animator.rotate(UpperR_Tentacle3,(float)Math.toRadians(-30F),(float)Math.toRadians(-30F),(float)Math.toRadians(35F));
		animator.rotate(UpperR_Tentacle2,(float)Math.toRadians(-7.5F),(float)Math.toRadians(-17.5F),(float)Math.toRadians(10F));
		animator.rotate(UpperR_Tentacle,(float)Math.toRadians(72.5F),(float)Math.toRadians(-22.5F),0);

		animator.rotate(Mouth, (float) Math.toRadians(-30F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-30F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(15F), (float) Math.toRadians(27.5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(15F), (float) Math.toRadians(-27.5F), 0);
		animator.rotate(Maw, (float) Math.toRadians(42.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-42.5F), 0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(10);


		animator.resetKeyframe(10);


		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_TENTACLE_STRIKE_UPPER_R);
		animator.startKeyframe(23);
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(45F), 0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(37.5F), 0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(37.5F), 0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(47.5F), 0);
		animator.endKeyframe();


		animator.startKeyframe(1);
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(-55F), 0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(5F), 0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(-2.5F), 0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(2.5F), 0);

		animator.rotate(UpperR_Hook,0,0, (float)Math.toRadians(22.5F));
		animator.rotate(UpperR_Hook2,0,(float)Math.toRadians(22.5F), 0);
		animator.rotate(UpperR_Hook3,0,(float)Math.toRadians(-22.5F), 0);
		animator.rotate(UpperR_Hook4,0,0, (float)Math.toRadians(-22.5F));

		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.resetKeyframe(10);


		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_TENTACLE_STRIKE_LOWER_R);
		animator.startKeyframe(27);
		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(45F), 0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(37.5F), 0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(37.5F), 0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(47.5F), 0);
		animator.endKeyframe();


		animator.startKeyframe(1);
		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(-55F), 0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(5F), 0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-2.5F), 0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(2.5F), 0);

		animator.rotate(LowerR_Hook,0,0, (float)Math.toRadians(22.5F));
		animator.rotate(LowerR_Hook2,0,(float)Math.toRadians(22.5F), 0);
		animator.rotate(LowerR_Hook3,0,(float)Math.toRadians(-22.5F), 0);
		animator.rotate(LowerR_Hook4,0,0, (float)Math.toRadians(-22.5F));

		animator.endKeyframe();

		animator.setStaticKeyframe(6);

		animator.resetKeyframe(10);


		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_TENTACLE_STRIKE_UPPER_L);
		animator.startKeyframe(25);
		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-47.5F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(-37.5F), 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(-37.5F), 0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-47.5F), 0);
		animator.endKeyframe();


		animator.startKeyframe(1);
		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(55F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(5F), 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(-2.5F), 0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-2.5F), 0);

		animator.rotate(UpperL_Hook,0,0, (float)Math.toRadians(-22.5F));
		animator.rotate(UpperL_Hook2,0,(float)Math.toRadians(-22.5F), 0);
		animator.rotate(UpperL_Hook3,0,(float)Math.toRadians(22.5F), 0);
		animator.rotate(UpperL_Hook4,0,0, (float)Math.toRadians(22.5F));

		animator.endKeyframe();

		animator.setStaticKeyframe(8);

		animator.resetKeyframe(10);

		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_TENTACLE_STRIKE_LOWER_L);
		animator.startKeyframe(20);
		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-47.5F), 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(-37.5F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-37.5F), 0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(-47.5F), 0);
		animator.endKeyframe();


		animator.startKeyframe(1);
		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(55F), 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(5F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-2.5F), 0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(-2.5F), 0);

		animator.rotate(LowerL_Hook,0,0, (float)Math.toRadians(-22.5F));
		animator.rotate(LowerL_Hook2,0,(float)Math.toRadians(-22.5F), 0);
		animator.rotate(LowerL_Hook3,0,(float)Math.toRadians(22.5F), 0);
		animator.rotate(LowerL_Hook4,0,0, (float)Math.toRadians(22.5F));

		animator.endKeyframe();

		animator.setStaticKeyframe(13);

		animator.resetKeyframe(10);


		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_STUN);
		animator.startKeyframe(0);
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(37.5F), 0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(45F), 0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(50F), 0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(40F), 0);
		animator.rotate(UpperR_Hook,0,0, (float)Math.toRadians(25F));
		animator.rotate(UpperR_Hook2,0,(float)Math.toRadians(25F), 0);
		animator.rotate(UpperR_Hook3,0,(float)Math.toRadians(-25F), 0);
		animator.rotate(UpperR_Hook4,0,0, (float)Math.toRadians(-25F));
		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-37.5F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(-45F), 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(-50F), 0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-40F), 0);
		animator.rotate(UpperL_Hook,0,0, (float)Math.toRadians(-25F));
		animator.rotate(UpperL_Hook2,0,(float)Math.toRadians(-25F), 0);
		animator.rotate(UpperL_Hook3,0,(float)Math.toRadians(25F), 0);
		animator.rotate(UpperL_Hook4,0,0, (float)Math.toRadians(25F));
		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(37.5F), 0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(45F), 0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(52.5F), 0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(30F), 0);
		animator.rotate(LowerR_Hook,0,0, (float)Math.toRadians(25F));
		animator.rotate(LowerR_Hook2,0,(float)Math.toRadians(25F), 0);
		animator.rotate(LowerR_Hook3,0,(float)Math.toRadians(-25F), 0);
		animator.rotate(LowerR_Hook4,0,0, (float)Math.toRadians(-25F));
		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-37.5F), 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(-45F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-52.5F), 0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(-30F), 0);
		animator.rotate(LowerL_Hook,0,0, (float)Math.toRadians(-25F));
		animator.rotate(LowerL_Hook2,0,(float)Math.toRadians(-25F), 0);
		animator.rotate(LowerL_Hook3,0,(float)Math.toRadians(25F), 0);
		animator.rotate(LowerL_Hook4,0,0, (float)Math.toRadians(25F));
		animator.rotate(Maw,(float)Math.toRadians(15F),0, 0);
		animator.rotate(Skul,(float)Math.toRadians(-30F),0, 0);
		animator.rotate(Mouth,(float)Math.toRadians(-27.5F),(float)Math.toRadians(2.5F), 0);
		animator.rotate(Mouth2,(float)Math.toRadians(-27.5F),(float)Math.toRadians(-2.5F), 0);
		animator.rotate(Mouth3,(float)Math.toRadians(10F),(float)Math.toRadians(2.5F), 0);
		animator.rotate(Mouth4,(float)Math.toRadians(10F),(float)Math.toRadians(-2.5F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(5);

		animator.startKeyframe(8);
		animator.rotate(four_mouths,(float)Math.toRadians(15F),0, 0);
		animator.endKeyframe();
		animator.setStaticKeyframe(15);

		animator.resetKeyframe(15);
		animator.setStaticKeyframe(10);

		animator.startKeyframe(2);
		animator.rotate(Mouth,(float)Math.toRadians(-37.5F),(float)Math.toRadians(37.5f), 0);
		animator.rotate(Mouth2,(float)Math.toRadians(-37.5F),(float)Math.toRadians(-37.5f), 0);
		animator.rotate(Mouth3,(float)Math.toRadians(37.5F),(float)Math.toRadians(37.5f), 0);
		animator.rotate(Mouth4,(float)Math.toRadians(37.5F),(float)Math.toRadians(-37.5f), 0);
		animator.rotate(Skul,(float)Math.toRadians(-40F),0, 0);
		animator.rotate(Maw,(float)Math.toRadians(30F),0, 0);

		animator.endKeyframe();

		animator.setStaticKeyframe(20);


		animator.resetKeyframe(15);


		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_TAIL_WHIPS);
		animator.startKeyframe(12);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(32.5f), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(27.5f), 0);
		if(!entity.blocksBylefttentacle) {
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(12.5f), (float) Math.toRadians(10f), (float) Math.toRadians(-10f));
		}else{
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(12.5f), (float) Math.toRadians(10f), (float) Math.toRadians(22.5f));
		}
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(47.5F), 0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(52.5F), 0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(37.5F), (float)Math.toRadians(5F));
		if(entity.blocksByrighttentacle) {
			animator.rotate(LowerR_Tentacle, 0, 0, (float) Math.toRadians(-32.5f));
		}
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(30F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(25F), 0);

		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(62.5F), 0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(40F), 0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(42.5F), 0);

		animator.rotate(Tail3,0,(float)Math.toRadians(45f), 0);
		animator.rotate(Tail2,0,(float)Math.toRadians(30f), 0);
		animator.rotate(Tail,0,(float)Math.toRadians(37.5f), 0);
		animator.rotate(Belly,0,(float)Math.toRadians(27.5f), 0);
		animator.rotate(Main_belly,0,(float)Math.toRadians(32.5f), 0);
		animator.rotate(body,0,(float)Math.toRadians(-42.5f), 0);
		animator.rotate(root,0,(float)Math.toRadians(-52.5f), 0);
		animator.endKeyframe();

		animator.startKeyframe(20);

		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(10f), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(2.5f), 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(-7.5f), 0);

		if(!entity.blocksBylefttentacle) {
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(12.5f), (float) Math.toRadians(37.5f), (float) Math.toRadians(-22.5f));
		}else{
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(12.5f), (float) Math.toRadians(37.5f), (float) Math.toRadians(10f));
		}

		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-12.5F), 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(5F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(12.5F), 0);
		animator.rotate(UpperL_Tentacle,(float)Math.toRadians(-32.5F),(float)Math.toRadians(37.5F), (float)Math.toRadians(12.5F));

		animator.rotate(Belly,0,(float)Math.toRadians(2.5f), 0);
		animator.rotate(root,0,(float)Math.toRadians(-360f), 0);
		animator.endKeyframe();

		animator.startKeyframe(0);

		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(10f), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(2.5f), 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(-7.5f), 0);

		if(!entity.blocksBylefttentacle) {
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(12.5f), (float) Math.toRadians(37.5f), (float) Math.toRadians(-22.5f));
		}else{
			animator.rotate(LowerL_Tentacle, (float) Math.toRadians(12.5f), (float) Math.toRadians(37.5f), (float) Math.toRadians(10f));
		}

		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-12.5F), 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(5F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(12.5F), 0);
		animator.rotate(UpperL_Tentacle,(float)Math.toRadians(-32.5F),(float)Math.toRadians(37.5F), (float)Math.toRadians(12.5F));
		animator.rotate(Belly,0,(float)Math.toRadians(2.5f), 0);
		animator.endKeyframe();

		animator.resetKeyframe(10);

		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_BREAK_DIMENSION);
		animator.startKeyframe(10);
		animator.move(root,0,-10, 0);
		animator.rotate(body,(float)Math.toRadians(5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-10F),0, 0);
		animator.rotate(Belly,(float)Math.toRadians(-22.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-20F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(-22.5F),0, 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(57.5F), 0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-27.5F), 0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(-20F), 0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(-35F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-57.5F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(27.5F), 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(20F), 0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(35F), 0);


		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(57.5F), 0);

		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(-27.5F), 0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-20F), 0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(-35F), 0);



		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-57.5F), 0);

		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(27.5F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(20F), 0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(35F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(4);
		animator.move(root,0,-10, 0);
		animator.rotate(body,(float)Math.toRadians(5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-7.5F),0, 0);
		animator.rotate(Belly,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(10F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(30F),0, 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(-47.5F), 0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-15F), 0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(25F), 0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(12.5F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(47.5F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(15F), 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(-25F), 0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-12.5F), 0);



		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(-47.5F), 0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(-15F), 0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(25F), 0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(12.5F), 0);



		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(47.5F), 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(15F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-25F), 0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(-12.5F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(15);
		animator.move(root,0,-10, 0);
		animator.rotate(body,(float)Math.toRadians(5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-5F),0, 0);
		animator.rotate(Belly,(float)Math.toRadians(-22.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-20F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(-22.5F),0, 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(57.5F), 0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-27.5F), 0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(-20F), 0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(-35F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-57.5F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(27.5F), 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(20F), 0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(35F), 0);


		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(57.5F), 0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(-27.5F), 0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-20F), 0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(-35F), 0);



		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-57.5F), 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(27.5F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(20F), 0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(35F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(3);
		animator.move(root,0,-10, 0);
		animator.rotate(body,(float)Math.toRadians(5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-7.5F),0, 0);
		animator.rotate(Belly,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(10F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(30F),0, 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(-47.5F), 0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-15F), 0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(25F), 0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(12.5F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(47.5F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(15F), 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(-25F), 0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-12.5F), 0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(-47.5F), 0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(-15F), 0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(25F), 0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(12.5F), 0);



		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(47.5F), 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(15F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-25F), 0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(-12.5F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(10);
		animator.move(root,0,-10, 0);
		animator.rotate(body,(float)Math.toRadians(5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-5F),0, 0);
		animator.rotate(Belly,(float)Math.toRadians(-22.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-20F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(-22.5F),0, 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(57.5F), 0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-27.5F), 0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(-20F), 0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(-35F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-57.5F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(27.5F), 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(20F), 0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(35F), 0);



		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(57.5F), 0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(57.5F), 0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(-27.5F), 0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-20F), 0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(-35F), 0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-57.5F), 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(27.5F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(20F), 0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(35F), 0);

		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(2);
		animator.move(root,0,-10, 0);
		animator.rotate(body,(float)Math.toRadians(5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-7.5F),0, 0);
		animator.rotate(Belly,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(10F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(30F),0, 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(-47.5F), 0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-15F), 0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(25F), 0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(12.5F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(47.5F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(15F), 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(-25F), 0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-12.5F), 0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(-47.5F), 0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(-15F), 0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(25F), 0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(12.5F), 0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(47.5F), 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(15F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-25F), 0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(-12.5F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(10);
		animator.move(root,0,-10, 0);
		animator.rotate(body,(float)Math.toRadians(5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-5F),0, 0);
		animator.rotate(Belly,(float)Math.toRadians(-22.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-20F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(-22.5F),0, 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(57.5F), 0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-27.5F), 0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(-20F), 0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(-35F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-57.5F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(27.5F), 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(20F), 0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(35F), 0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(57.5F), 0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(-27.5F), 0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-20F), 0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(-35F), 0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-57.5F), 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(27.5F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(20F), 0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(35F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(2);
		animator.move(root,0,-10, 0);
		animator.rotate(body,(float)Math.toRadians(5F),0, 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-7.5F),0, 0);
		animator.rotate(Belly,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(10F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(30F),0, 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(-47.5F), 0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-15F), 0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(25F), 0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(12.5F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(47.5F), 0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(15F), 0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(-25F), 0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-12.5F), 0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(-47.5F), 0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(-15F), 0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(25F), 0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(12.5F), 0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(47.5F), 0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(15F), 0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-25F), 0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(-12.5F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);


		animator.resetKeyframe(20);

		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_BITE);
		animator.startKeyframe(8);
		animator.rotate(root,(float)Math.toRadians(-10F),0, 0);
		animator.rotate(Belly,(float)Math.toRadians(-15F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-15F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Maw,(float)Math.toRadians(20F),0, 0);
		animator.rotate(Skul,(float)Math.toRadians(-30F),0, 0);
		animator.rotate(Mouth,(float)Math.toRadians(-22.5F),(float)Math.toRadians(22.5F), (float)Math.toRadians(-2.5F));
		animator.rotate(Mouth2,(float)Math.toRadians(-22.5F),(float)Math.toRadians(-22.5F), (float)Math.toRadians(2.5F));
		animator.rotate(Mouth3,(float)Math.toRadians(22.5F),(float)Math.toRadians(15F), (float)Math.toRadians(10F));
		animator.rotate(Mouth4,(float)Math.toRadians(22.5F),(float)Math.toRadians(-20F), (float)Math.toRadians(-12.5F));
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.rotate(root,(float)Math.toRadians(-1.25F),0, 0);
		animator.move(root,0,0,-2);
		animator.rotate(Belly,(float)Math.toRadians(3.75F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-1.25F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(-1.25F),0, 0);
		animator.rotate(Maw,(float)Math.toRadians(30F),0, 0);
		animator.rotate(Skul,(float)Math.toRadians(-47.5F),0, 0);
		animator.rotate(Mouth,(float)Math.toRadians(-35F),(float)Math.toRadians(35F), (float)Math.toRadians(-5F));
		animator.rotate(Mouth2,(float)Math.toRadians(-37.5F),(float)Math.toRadians(-35F), (float)Math.toRadians(5F));
		animator.rotate(Mouth3,(float)Math.toRadians(32.5F),(float)Math.toRadians(22.5F), (float)Math.toRadians(15F));
		animator.rotate(Mouth4,(float)Math.toRadians(35F),(float)Math.toRadians(-30F), (float)Math.toRadians(-17.5F));
		animator.endKeyframe();

		animator.startKeyframe(4);
		animator.rotate(root,(float)Math.toRadians(7.5F),0, 0);
		animator.move(root,0,0,-4);
		animator.rotate(Belly,(float)Math.toRadians(22.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(12.5F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(15F),0, 0);
		animator.endKeyframe();

		animator.resetKeyframe(10);


		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_BITE);
		animator.startKeyframe(8);
		animator.rotate(root,(float)Math.toRadians(-10F),0, 0);
		animator.rotate(Belly,(float)Math.toRadians(-15F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(-15F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(-17.5F),0, 0);
		animator.rotate(Maw,(float)Math.toRadians(20F),0, 0);
		animator.rotate(Skul,(float)Math.toRadians(-30F),0, 0);
		animator.rotate(Mouth,(float)Math.toRadians(-22.5F),(float)Math.toRadians(22.5F), (float)Math.toRadians(-2.5F));
		animator.rotate(Mouth2,(float)Math.toRadians(-22.5F),(float)Math.toRadians(-22.5F), (float)Math.toRadians(2.5F));
		animator.rotate(Mouth3,(float)Math.toRadians(22.5F),(float)Math.toRadians(15F), (float)Math.toRadians(10F));
		animator.rotate(Mouth4,(float)Math.toRadians(22.5F),(float)Math.toRadians(-20F), (float)Math.toRadians(-12.5F));
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.rotate(root,(float)Math.toRadians(-1.25F),0, 0);
		animator.move(root,0,0,-2);
		animator.rotate(Belly,(float)Math.toRadians(3.75F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(-1.25F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(-1.25F),0, 0);
		animator.rotate(Maw,(float)Math.toRadians(30F),0, 0);
		animator.rotate(Skul,(float)Math.toRadians(-47.5F),0, 0);
		animator.rotate(Mouth,(float)Math.toRadians(-35F),(float)Math.toRadians(35F), (float)Math.toRadians(-5F));
		animator.rotate(Mouth2,(float)Math.toRadians(-37.5F),(float)Math.toRadians(-35F), (float)Math.toRadians(5F));
		animator.rotate(Mouth3,(float)Math.toRadians(32.5F),(float)Math.toRadians(22.5F), (float)Math.toRadians(15F));
		animator.rotate(Mouth4,(float)Math.toRadians(35F),(float)Math.toRadians(-30F), (float)Math.toRadians(-17.5F));
		animator.endKeyframe();

		animator.startKeyframe(4);
		animator.rotate(root,(float)Math.toRadians(7.5F),0, 0);
		animator.move(root,0,0,-4);
		animator.rotate(Belly,(float)Math.toRadians(22.5F),0, 0);
		animator.rotate(Tail,(float)Math.toRadians(15F),0, 0);
		animator.rotate(Tail2,(float)Math.toRadians(12.5F),0, 0);
		animator.rotate(Tail3,(float)Math.toRadians(15F),0, 0);
		animator.endKeyframe();

		animator.resetKeyframe(10);

		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_PHASE2);
		animator.startKeyframe(10);
		animator.rotate(root,(float)Math.toRadians(2.5F),0, (float)Math.toRadians(-5F));
		animator.rotate(body,0,(float)Math.toRadians(2.5F), 0);
		animator.rotate(Main_belly,(float)Math.toRadians(2.5F),0, 0);
		animator.rotate(Belly,(float)Math.toRadians(-2.5F),(float)Math.toRadians(2.5F), (float)Math.toRadians(-5F));
		animator.rotate(Tail,(float)Math.toRadians(-5F),(float)Math.toRadians(2.5F), 0);
		animator.rotate(Tail2,(float)Math.toRadians(5F),(float)Math.toRadians(2.5F), (float)Math.toRadians(10F));
		animator.rotate(Tail3,(float)Math.toRadians(-5F),(float)Math.toRadians(2.5F), 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(-10F), (float)Math.toRadians(-17.5F));
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(10F), (float)Math.toRadians(7.5F));
		animator.rotate(UpperR_Tentacle3,(float)Math.toRadians(2.5F),(float)Math.toRadians(15F), (float)Math.toRadians(2.5F));
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(27.5F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(5F), (float)Math.toRadians(20F));
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(-5F), 0);
		animator.rotate(UpperL_Tentacle3,0,0, (float)Math.toRadians(-5F));
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-5F),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(22.5F), (float)Math.toRadians(7.5F));
		animator.rotate(LowerR_Tentacle2,0,0, (float)Math.toRadians(7.5F));
		animator.rotate(LowerR_Tentacle3,(float)Math.toRadians(2.5F),0, (float)Math.toRadians(1.5F));
		animator.rotate(LowerR_Tentacle4,(float)Math.toRadians(-10F),0,(float)Math.toRadians(5F));

		animator.rotate(LowerL_Tentacle,(float)Math.toRadians(2.5F),(float)Math.toRadians(-10F), (float)Math.toRadians(-5F));
		animator.rotate(LowerL_Tentacle2,0,0, (float)Math.toRadians(-2.5F));
		animator.rotate(LowerL_Tentacle3,(float)Math.toRadians(-2.5F),(float)Math.toRadians(-2.5F), (float)Math.toRadians(-2.5F));


		animator.rotate(Head,(float)Math.toRadians(-10F),0,(float)Math.toRadians(-20F));
		animator.rotate(Maw,(float)Math.toRadians(25F),(float)Math.toRadians(2.5F),(float)Math.toRadians(7.5F));
		animator.endKeyframe();

		animator.startKeyframe(20);
		animator.rotate(root,(float)Math.toRadians(10F),(float)Math.toRadians(2.5F), (float)Math.toRadians(-12.5F));
		animator.rotate(body,(float)Math.toRadians(-2.5F),(float)Math.toRadians(10F), 0);
		animator.rotate(Main_belly,(float)Math.toRadians(-10F),0, 0);
		animator.rotate(Belly,(float)Math.toRadians(-10F),(float)Math.toRadians(7.5F), (float)Math.toRadians(-17.5F));
		animator.rotate(Tail,(float)Math.toRadians(-12.5F),(float)Math.toRadians(10F), (float)Math.toRadians(-2.5F));
		animator.rotate(Tail2,(float)Math.toRadians(-15F),(float)Math.toRadians(2.5F), (float)Math.toRadians(-27.5F));
		animator.rotate(Tail3,(float)Math.toRadians(-15F),(float)Math.toRadians(10F), (float)Math.toRadians(-2.5F));

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(-35F), (float)Math.toRadians(-50F));
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(27.5F), (float)Math.toRadians(22.5F));
		animator.rotate(UpperR_Tentacle3,(float)Math.toRadians(10F),(float)Math.toRadians(45F), (float)Math.toRadians(10F));
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(82.5F), 0);

		animator.rotate(UpperL_Tentacle,(float)Math.toRadians(2.5F),(float)Math.toRadians(15F), (float)Math.toRadians(62.5F));
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(-12.5F), 0);
		animator.rotate(UpperL_Tentacle3,0,0, (float)Math.toRadians(-17.5F));
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-15F),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(70F), (float)Math.toRadians(25F));
		animator.rotate(LowerR_Tentacle2,0,0, (float)Math.toRadians(22.5F));
		animator.rotate(LowerR_Tentacle3,(float)Math.toRadians(5F),(float)Math.toRadians(2.5F), (float)Math.toRadians(5F));
		animator.rotate(LowerR_Tentacle4,(float)Math.toRadians(-27.5F),0,(float)Math.toRadians(17.5F));

		animator.rotate(LowerL_Tentacle,(float)Math.toRadians(5F),(float)Math.toRadians(-27.5F), (float)Math.toRadians(-17.5F));
		animator.rotate(LowerL_Tentacle2,0,0, (float)Math.toRadians(-5F));
		animator.rotate(LowerL_Tentacle3,(float)Math.toRadians(-10F),(float)Math.toRadians(-5F), (float)Math.toRadians(-10F));

		animator.rotate(Head,(float)Math.toRadians(-30F),0,(float)Math.toRadians(-62.5F));
		animator.rotate(Maw,(float)Math.toRadians(75F),(float)Math.toRadians(5F),(float)Math.toRadians(22.5F));

		animator.rotate(Mouth,(float)Math.toRadians(-27.5F),(float)Math.toRadians(25F),0);
		animator.rotate(Mouth2,(float)Math.toRadians(-15F),(float)Math.toRadians(-15F),0);
		animator.rotate(Mouth3,(float)Math.toRadians(5F),(float)Math.toRadians(37.5F),(float)Math.toRadians(-2.5F));
		animator.rotate(Mouth4,(float)Math.toRadians(-5F),(float)Math.toRadians(-37.5F),0);

		animator.endKeyframe();

		animator.setStaticKeyframe(55);

		animator.startKeyframe(6);
		animator.rotate(body,(float)Math.toRadians(-2.5F),0, 0);
		animator.rotate(Belly,0,(float)Math.toRadians(30F),0);
		animator.rotate(Tail,0,(float)Math.toRadians(25F),0);
		animator.rotate(Tail2,0,(float)Math.toRadians(17.5F),0);
		animator.rotate(Tail3,0,(float)Math.toRadians(30F), 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(50F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-50F),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(50F),0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-50F), 0);

		animator.rotate(Maw,(float)Math.toRadians(60F),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-40F),0,0);

		animator.rotate(Mouth,(float)Math.toRadians(-52.5F),(float)Math.toRadians(52.5F),0);
		animator.rotate(Mouth2,(float)Math.toRadians(-52.5F),(float)Math.toRadians(-52.5F),0);
		animator.rotate(Mouth3,(float)Math.toRadians(52.5F),(float)Math.toRadians(52.5F),0);
		animator.rotate(Mouth4,(float)Math.toRadians(52.5F),(float)Math.toRadians(-52.5F),0);
		animator.endKeyframe();

		animator.startKeyframe(6);
		animator.rotate(body,(float)Math.toRadians(-2.5F),(float)Math.toRadians(5), 0);
		animator.rotate(Belly,0,(float)Math.toRadians(-30F),0);
		animator.rotate(Tail,0,(float)Math.toRadians(22.5F),(float)Math.toRadians(12.5F));
		animator.rotate(Tail2,0,(float)Math.toRadians(-40F),0);
		animator.rotate(Tail3,0,(float)Math.toRadians(-27.5F), 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(35F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-35F),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(35F),0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-35F), 0);

		animator.rotate(Maw,(float)Math.toRadians(35F),0,0);

		animator.rotate(Mouth,(float)Math.toRadians(-45F),(float)Math.toRadians(45F),0);
		animator.rotate(Mouth2,(float)Math.toRadians(-45F),(float)Math.toRadians(-45F),0);
		animator.rotate(Mouth3,(float)Math.toRadians(45F),(float)Math.toRadians(45F),0);
		animator.rotate(Mouth4,(float)Math.toRadians(45F),(float)Math.toRadians(-45F),0);
		animator.endKeyframe();

		animator.startKeyframe(6);
		animator.rotate(body,(float)Math.toRadians(-2.5F),(float)Math.toRadians(-5), 0);
		animator.rotate(Belly,0,(float)Math.toRadians(30F),0);
		animator.rotate(Tail,0,(float)Math.toRadians(25F),0);
		animator.rotate(Tail2,0,(float)Math.toRadians(17.5F),0);
		animator.rotate(Tail3,0,(float)Math.toRadians(30F), 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(50F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-50F),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(50F),0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-50F), 0);

		animator.rotate(Maw,(float)Math.toRadians(60F),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-40F),0,0);

		animator.rotate(Mouth,(float)Math.toRadians(-37.5F),(float)Math.toRadians(37.5F),0);
		animator.rotate(Mouth2,(float)Math.toRadians(-37.5F),(float)Math.toRadians(-37.5F),0);
		animator.rotate(Mouth3,(float)Math.toRadians(37.5F),(float)Math.toRadians(37.5F),0);
		animator.rotate(Mouth4,(float)Math.toRadians(37.5F),(float)Math.toRadians(-37.5F),0);
		animator.endKeyframe();

		animator.startKeyframe(6);
		animator.rotate(body,(float)Math.toRadians(-2.5F),(float)Math.toRadians(5), 0);
		animator.rotate(Belly,0,(float)Math.toRadians(-30F),0);
		animator.rotate(Tail,0,(float)Math.toRadians(-22.5F),(float)Math.toRadians(12.5F));
		animator.rotate(Tail2,0,(float)Math.toRadians(-40F),0);
		animator.rotate(Tail3,0,(float)Math.toRadians(-27.5F), 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(35F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-35F),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(35F),0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-35F), 0);

		animator.rotate(Maw,(float)Math.toRadians(35F),0,0);

		animator.rotate(Mouth,(float)Math.toRadians(-30F),(float)Math.toRadians(30F),0);
		animator.rotate(Mouth2,(float)Math.toRadians(-30F),(float)Math.toRadians(-30F),0);
		animator.rotate(Mouth3,(float)Math.toRadians(30F),(float)Math.toRadians(30F),0);
		animator.rotate(Mouth4,(float)Math.toRadians(30F),(float)Math.toRadians(-30F),0);
		animator.endKeyframe();

		animator.startKeyframe(6);
		animator.rotate(body,(float)Math.toRadians(-2.5F),(float)Math.toRadians(5), 0);
		animator.rotate(Belly,0,(float)Math.toRadians(30F),0);
		animator.rotate(Tail,0,(float)Math.toRadians(25F),0);
		animator.rotate(Tail2,0,(float)Math.toRadians(17.5F),0);
		animator.rotate(Tail3,0,(float)Math.toRadians(30F), 0);

		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(50F), 0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-50F),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(50F),0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-50F), 0);

		animator.rotate(Maw,(float)Math.toRadians(60F),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-40F),0,0);

		animator.rotate(Mouth,(float)Math.toRadians(-22.5F),(float)Math.toRadians(22.5F),0);
		animator.rotate(Mouth2,(float)Math.toRadians(-22.5F),(float)Math.toRadians(-22.5F),0);
		animator.rotate(Mouth3,(float)Math.toRadians(22.5F),(float)Math.toRadians(22.5F),0);
		animator.rotate(Mouth4,(float)Math.toRadians(22.5F),(float)Math.toRadians(-22.5F),0);
		animator.endKeyframe();

		animator.resetKeyframe(15);


		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_DEATH);
		animator.startKeyframe(15);
		animator.rotate(root,(float)Math.toRadians(-27.5F),(float)Math.toRadians(-2.5), (float)Math.toRadians(-7.5));
		animator.rotate(Main_belly,0,(float)Math.toRadians(12.5f), 0);
		animator.rotate(Belly,(float)Math.toRadians(-7.5),(float)Math.toRadians(12.5f), 0);
		animator.rotate(R_down_fin,0,0,(float)Math.toRadians(-55f));
		animator.rotate(R_down_fin2,0,0,(float)Math.toRadians(62.5f));
		animator.rotate(L_down_fin,0,0,(float)Math.toRadians(55f));
		animator.rotate(L_down_fin2,0,0,(float)Math.toRadians(-62.5f));
		animator.rotate(Tail,(float)Math.toRadians(-12.5f),(float)Math.toRadians(5f),0);
		animator.rotate(Tail2,(float)Math.toRadians(-10f),(float)Math.toRadians(17.5f),0);
		animator.rotate(Tail3,(float)Math.toRadians(-12.5f),0,0);
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(40f),0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(10f),0);
		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-40f),0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(-10f),0);
		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(40f),0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(10f),0);
		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-40f),0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-10f),0);
		animator.rotate(Maw,(float)Math.toRadians(47.5f),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-52.5f),0,0);
		animator.rotate(R_fin,0,0,(float)Math.toRadians(-27.5f));
		animator.rotate(L_fin,0,0,(float)Math.toRadians(27.5f));
		animator.rotate(Mouth4,(float)Math.toRadians(55f),(float)Math.toRadians(-35f),(float)Math.toRadians(-30f));
		animator.rotate(Mouth3,(float)Math.toRadians(55f),(float)Math.toRadians(32.5f),(float)Math.toRadians(32.5f));
		animator.rotate(Mouth2,(float)Math.toRadians(-50f),(float)Math.toRadians(-42.5),(float)Math.toRadians(7.5));
		animator.rotate(Mouth,(float)Math.toRadians(-50f),(float)Math.toRadians(42.5),(float)Math.toRadians(-7.5));
		animator.endKeyframe();

		animator.startKeyframe(5);
		animator.rotate(root,(float)Math.toRadians(-32.5F),(float)Math.toRadians(-15),0);
		animator.rotate(Main_belly,0,(float)Math.toRadians(7.5),0);
		animator.rotate(Belly,(float)Math.toRadians(-7.5),(float)Math.toRadians(5f), 0);
		animator.rotate(R_down_fin,0,0,(float)Math.toRadians(-32.5f));
		animator.rotate(R_down_fin2,0,0,(float)Math.toRadians(47.5f));
		animator.rotate(L_down_fin,0,0,(float)Math.toRadians(32.5f));
		animator.rotate(L_down_fin2,0,0,(float)Math.toRadians(-47.5f));
		animator.rotate(Tail,(float)Math.toRadians(-12.5f),(float)Math.toRadians(2.5f),0);
		animator.rotate(Tail2,(float)Math.toRadians(-10f),(float)Math.toRadians(2.5f),(float)Math.toRadians(2.5f));
		animator.rotate(Tail3,(float)Math.toRadians(-12.5f),(float)Math.toRadians(-5f),(float)Math.toRadians(2.5f));
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(30f),0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(7.5f),0);
		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-30f),0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(-7.5f),0);
		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(30f),0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(7.5f),0);
		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-30f),0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-7.5f),0);
		animator.rotate(Maw,(float)Math.toRadians(37.5f),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-40f),0,0);
		animator.rotate(R_fin,0,0,(float)Math.toRadians(-17.5f));
		animator.rotate(R_fin2,0,0,(float)Math.toRadians(15f));
		animator.rotate(R_fin3,0,0,(float)Math.toRadians(15f));
		animator.rotate(L_fin,0,0,(float)Math.toRadians(17.5f));
		animator.rotate(L_fin2,0,0,(float)Math.toRadians(-15f));
		animator.rotate(L_fin3,0,0,(float)Math.toRadians(-15f));
		animator.rotate(Mouth4,(float)Math.toRadians(35f),(float)Math.toRadians(-22.5f),(float)Math.toRadians(-22.5f));
		animator.rotate(Mouth3,(float)Math.toRadians(35f),(float)Math.toRadians(22.5f),(float)Math.toRadians(22.5f));
		animator.rotate(Mouth2,(float)Math.toRadians(-30f),(float)Math.toRadians(-30f),(float)Math.toRadians(-2.5f));
		animator.rotate(Mouth,(float)Math.toRadians(-30f),(float)Math.toRadians(30f),0);
		animator.endKeyframe();

		animator.startKeyframe(5);
		animator.rotate(root,(float)Math.toRadians(-27.5F),(float)Math.toRadians(5),(float)Math.toRadians(7.5f));
		animator.rotate(Main_belly,0,(float)Math.toRadians(-5f),0);
		animator.rotate(Belly,(float)Math.toRadians(-7.5f),(float)Math.toRadians(-10f),(float)Math.toRadians(2.5f));
		animator.rotate(R_down_fin,0,0,(float)Math.toRadians(-10f));
		animator.rotate(R_down_fin2,0,0,(float)Math.toRadians(32.5f));
		animator.rotate(L_down_fin,0,0,(float)Math.toRadians(10f));
		animator.rotate(L_down_fin2,0,0,(float)Math.toRadians(-32.5f));
		animator.rotate(Tail,(float)Math.toRadians(-12.5f),(float)Math.toRadians(-15f),(float)Math.toRadians(2.5f));
		animator.rotate(Tail2,(float)Math.toRadians(-10f),(float)Math.toRadians(-2.5f),(float)Math.toRadians(2.5f));
		animator.rotate(Tail3,(float)Math.toRadians(-12.5f),(float)Math.toRadians(-12.5f),(float)Math.toRadians(2.5f));
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(20f),0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(5f),0);
		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-20f),0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(-5f),0);
		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(20f),0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(5f),0);
		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-20f),0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-5f),0);
		animator.rotate(Maw,(float)Math.toRadians(27.5f),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-27.5f),0,0);
		animator.rotate(R_fin,0,0,(float)Math.toRadians(-5f));
		animator.rotate(R_fin2,0,0,(float)Math.toRadians(30f));
		animator.rotate(R_fin3,0,0,(float)Math.toRadians(30f));
		animator.rotate(L_fin,0,0,(float)Math.toRadians(5f));
		animator.rotate(L_fin2,0,0,(float)Math.toRadians(-30f));
		animator.rotate(L_fin3,0,0,(float)Math.toRadians(-30f));
		animator.rotate(Mouth4,(float)Math.toRadians(17.5f),(float)Math.toRadians(-10f),(float)Math.toRadians(-12.5f));
		animator.rotate(Mouth3,(float)Math.toRadians(17.5f),(float)Math.toRadians(10f),(float)Math.toRadians(12.5f));
		animator.rotate(Mouth2,(float)Math.toRadians(-10f),(float)Math.toRadians(-17.5f),(float)Math.toRadians(-10f));
		animator.rotate(Mouth,(float)Math.toRadians(-10f),(float)Math.toRadians(17.5f),(float)Math.toRadians(7.5f));
		animator.endKeyframe();

		animator.startKeyframe(5);
		animator.rotate(root,(float)Math.toRadians(-27.5F),(float)Math.toRadians(-2.5),(float)Math.toRadians(-7.5f));
		animator.rotate(Main_belly,0,(float)Math.toRadians(-5f),0);
		animator.rotate(Belly,(float)Math.toRadians(-7.5f),(float)Math.toRadians(12.5f),0);
		animator.rotate(R_down_fin,0,0,(float)Math.toRadians(-55f));
		animator.rotate(L_down_fin,0,0,(float)Math.toRadians(55f));
		animator.rotate(Tail,(float)Math.toRadians(-12.5f),(float)Math.toRadians(5f),(float)Math.toRadians(-2.5f));
		animator.rotate(Tail2,(float)Math.toRadians(-10f),(float)Math.toRadians(17.5f),0);
		animator.rotate(Tail3,(float)Math.toRadians(-12.5f),0,0);
		animator.rotate(Maw,(float)Math.toRadians(47.5f),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-52.5f),0,0);
		animator.rotate(R_fin,0,0,(float)Math.toRadians(-47.5f));
		animator.rotate(L_fin,0,0,(float)Math.toRadians(47.5f));
		animator.rotate(Mouth4,(float)Math.toRadians(40f),(float)Math.toRadians(-27.5f),(float)Math.toRadians(-22.5f));
		animator.rotate(Mouth3,(float)Math.toRadians(40f),(float)Math.toRadians(27.5f),(float)Math.toRadians(22.5f));
		animator.rotate(Mouth2,(float)Math.toRadians(-35f),(float)Math.toRadians(-35f),0);
		animator.rotate(Mouth,(float)Math.toRadians(-35f),(float)Math.toRadians(35f),0);
		animator.endKeyframe();

		animator.startKeyframe(120);
		animator.rotate(root,(float)Math.toRadians(5F),(float)Math.toRadians(2.5),(float)Math.toRadians(172.5f));
		animator.move(root,0,-20,0);
		animator.rotate(Main_belly,0,(float)Math.toRadians(-5f),0);
		animator.rotate(Belly,(float)Math.toRadians(12.5f),(float)Math.toRadians(12.5f),0);
		animator.rotate(R_down_fin,0,0,(float)Math.toRadians(52.5f));
		animator.rotate(R_down_fin2,0,0,(float)Math.toRadians(25f));
		animator.rotate(L_down_fin,0,0,(float)Math.toRadians(-52.5f));
		animator.rotate(L_down_fin2,0,0,(float)Math.toRadians(-25f));
		animator.rotate(Tail,(float)Math.toRadians(15f),0,0);
		animator.rotate(Tail2,(float)Math.toRadians(7.5f),0,0);
		animator.rotate(Tail3,(float)Math.toRadians(-15f),0,0);
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(20f),(float)Math.toRadians(25f));
		animator.rotate(UpperR_Tentacle3,(float)Math.toRadians(2.5f),(float)Math.toRadians(17.5f),(float)Math.toRadians(-12.5f));
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(-17.5f),0);
		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-15f),(float)Math.toRadians(-22.5f));
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(7.5f),0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(-25f),(float)Math.toRadians(37.5f));
		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(47.5f),(float)Math.toRadians(72.5f));
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(25f),(float)Math.toRadians(30f));
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(25f),(float)Math.toRadians(-15f));
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(25f),(float)Math.toRadians(-17.5f));
		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(-42.5f),(float)Math.toRadians(-72.5f));
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(-25f),(float)Math.toRadians(-22.5f));
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-25f),(float)Math.toRadians(30f));
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(-25f),(float)Math.toRadians(17.5f));
		animator.rotate(Maw,(float)Math.toRadians(-45f),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-72.5f),0,0);
		animator.rotate(R_fin,0,0,(float)Math.toRadians(20f));
		animator.rotate(R_fin2,0,0,(float)Math.toRadians(22.5f));
		animator.rotate(R_fin3,0,0,(float)Math.toRadians(22.5f));
		animator.rotate(L_fin,0,0,(float)Math.toRadians(-20f));
		animator.rotate(L_fin2,0,0,(float)Math.toRadians(-22.5f));
		animator.rotate(L_fin3,0,0,(float)Math.toRadians(-22.5f));
		animator.rotate(Mouth4,(float)Math.toRadians(-30f),(float)Math.toRadians(-25f),(float)Math.toRadians(12.5f));
		animator.rotate(Mouth3,(float)Math.toRadians(-27.5f),(float)Math.toRadians(7.5f),(float)Math.toRadians(-2.5f));
		animator.rotate(Mouth2,(float)Math.toRadians(-40f),(float)Math.toRadians(-15f),(float)Math.toRadians(12.5f));
		animator.rotate(Mouth,(float)Math.toRadians(-45f),(float)Math.toRadians(10f),(float)Math.toRadians(-7.5f));
		animator.endKeyframe();

		animator.setStaticKeyframe(60);


		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_TENTACLE_HOLD);


		animator.startKeyframe(30);
		animator.rotate(root,(float)Math.toRadians(5f),0,0);
		animator.move(root,0,0,13);
		animator.rotate(Belly,(float)Math.toRadians(5f),0,0);
		animator.rotate(Tail,(float)Math.toRadians(-7.5f),0,0);
		animator.rotate(Tail2,(float)Math.toRadians(-7.5f),0,0);
		animator.rotate(Tail3,(float)Math.toRadians(-12.5f),0,0);
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(25f),0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-32.5f),0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(-25f),0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(-20f),0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-25f),0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(32.5f),0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(25f),0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(20f),0);

		animator.rotate(LowerR_Tentacle,(float)Math.toRadians(25f),(float)Math.toRadians(80f),(float)Math.toRadians(40f));
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(7.5f),0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(-57.5f),0);

		animator.rotate(LowerL_Tentacle,(float)Math.toRadians(25f),(float)Math.toRadians(-80f),(float)Math.toRadians(-40f));
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(-7.5f),0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(57.5f),0);

		animator.rotate(Maw,(float)Math.toRadians(30f),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-40f),0,0);

		animator.rotate(Mouth4,(float)Math.toRadians(7.5f),(float)Math.toRadians(-7.5f),0);
		animator.rotate(Mouth3,(float)Math.toRadians(7.5f),(float)Math.toRadians(7.5f),0);
		animator.rotate(Mouth2,(float)Math.toRadians(-7.5f),(float)Math.toRadians(-7.5f),0);
		animator.rotate(Mouth,(float)Math.toRadians(-7.5f),(float)Math.toRadians(7.5f),0);
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.move(root,0,0,-3);
		animator.rotate(Belly,(float)Math.toRadians(5f),0,0);
		animator.rotate(Tail,(float)Math.toRadians(-7.5f),0,0);
		animator.rotate(Tail2,(float)Math.toRadians(-7.5f),0,0);
		animator.rotate(Tail3,(float)Math.toRadians(-12.5f),0,0);
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(17.5f),0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-22.5f),0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(-17.5f),0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(-12.5f),0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-17.5f),0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(22.5f),0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(17.5f),0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(12.5f),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(-40f),0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(7.5f),0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-5f),0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(-20f),0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(40f),0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(-7.5f),0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(5f),0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(20f),0);

		animator.rotate(Maw,(float)Math.toRadians(30f),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-30f),0,0);

		animator.rotate(Mouth4,(float)Math.toRadians(7.5f),(float)Math.toRadians(-7.5f),0);
		animator.rotate(Mouth3,(float)Math.toRadians(7.5f),(float)Math.toRadians(7.5f),0);
		animator.rotate(Mouth2,(float)Math.toRadians(-7.5f),(float)Math.toRadians(-7.5f),0);
		animator.rotate(Mouth,(float)Math.toRadians(-7.5f),(float)Math.toRadians(7.5f),0);
		animator.endKeyframe();

		animator.setStaticKeyframe(15);

		animator.resetKeyframe(15);

		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_TENTACLE_HOLD_BLAST);
		animator.startKeyframe(0);
		animator.move(root,0,0,-3);
		animator.rotate(Belly,(float)Math.toRadians(5f),0,0);
		animator.rotate(Tail,(float)Math.toRadians(-7.5f),0,0);
		animator.rotate(Tail2,(float)Math.toRadians(-7.5f),0,0);
		animator.rotate(Tail3,(float)Math.toRadians(-12.5f),0,0);
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(17.5f),0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-22.5f),0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(-17.5f),0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(-12.5f),0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-17.5f),0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(22.5f),0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(17.5f),0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(20f),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(-40f),0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(7.5f),0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-5f),0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(-20f),0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(40f),0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(-7.5f),0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(5f),0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(20f),0);

		animator.rotate(Maw,(float)Math.toRadians(30f),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-30f),0,0);

		animator.rotate(Mouth4,(float)Math.toRadians(7.5f),(float)Math.toRadians(-7.5f),0);
		animator.rotate(Mouth3,(float)Math.toRadians(7.5f),(float)Math.toRadians(7.5f),0);
		animator.rotate(Mouth2,(float)Math.toRadians(-7.5f),(float)Math.toRadians(-7.5f),0);
		animator.rotate(Mouth,(float)Math.toRadians(-7.5f),(float)Math.toRadians(7.5f),0);
		animator.endKeyframe();

		animator.startKeyframe(5);
		animator.move(root,0,0,-2);
		animator.rotate(Belly,(float)Math.toRadians(2.5f),0,0);
		animator.rotate(Tail,(float)Math.toRadians(-7.5f),0,0);
		animator.rotate(Tail2,(float)Math.toRadians(-10f),0,0);
		animator.rotate(Tail3,(float)Math.toRadians(-12.5f),0,0);
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(25f),0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-32.5f),0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(-25f),0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(-20f),0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-25f),0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(32.5f),0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(25f),0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(20f),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(-40f),0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(12.5f),0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(-7.5f),0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(-70f),0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(40f),0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(-12.5f),0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(7.5f),0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(70f),0);
		animator.endKeyframe();

		animator.setStaticKeyframe(9);

		animator.startKeyframe(25);
		animator.rotate(root,(float)Math.toRadians(2.5f),0,0);
		animator.rotate(Belly,(float)Math.toRadians(-2.5f),0,0);
		animator.rotate(Tail,(float)Math.toRadians(-7.5f),0,0);
		animator.rotate(Tail2,(float)Math.toRadians(-15f),0,0);
		animator.rotate(Tail3,(float)Math.toRadians(-12.5f),0,0);
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(25f),0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-32.5f),0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(-25f),0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(-20f),0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-25f),0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(32.5f),0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(25f),0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(20f),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(-40f),0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(12.5f),0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(7.5f),0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(-70f),0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(40f),0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(-12.5f),0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-7.5f),0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(70f),0);

		animator.rotate(Maw,(float)Math.toRadians(12.5f),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-20f),0,0);

		animator.rotate(Mouth4,(float)Math.toRadians(10f),(float)Math.toRadians(-10f),(float)Math.toRadians(-2.5f));
		animator.rotate(Mouth3,(float)Math.toRadians(10f),(float)Math.toRadians(10f),0);
		animator.rotate(Mouth2,(float)Math.toRadians(-10f),(float)Math.toRadians(-10f),0);
		animator.rotate(Mouth,(float)Math.toRadians(-10f),(float)Math.toRadians(10f),(float)Math.toRadians(-2.5f));
		animator.endKeyframe();

		animator.setStaticKeyframe(9);

		animator.startKeyframe(33);
		animator.rotate(root,(float)Math.toRadians(5f),0,0);
		animator.rotate(Belly,(float)Math.toRadians(-2.5f),0,0);
		animator.rotate(Tail,(float)Math.toRadians(-7.5f),0,0);
		animator.rotate(Tail2,(float)Math.toRadians(-15f),0,0);
		animator.rotate(Tail3,(float)Math.toRadians(-12.5f),0,0);
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(25f),0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-32.5f),0);
		animator.rotate(UpperR_Tentacle3,0,(float)Math.toRadians(-25f),0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(-20f),0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-25f),0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(32.5f),0);
		animator.rotate(UpperL_Tentacle3,0,(float)Math.toRadians(25f),0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(20f),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(-40f),0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(12.5f),0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(6.5f),0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(-70f),0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(40f),0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(-12.5f),0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-6.5f),0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(70f),0);
		animator.endKeyframe();

		animator.startKeyframe(3);
		animator.rotate(root,(float)Math.toRadians(5f),0,0);
		animator.move(root,0,0,2);
		animator.rotate(Belly,(float)Math.toRadians(7.5f),0,0);
		animator.rotate(Tail,(float)Math.toRadians(12.5f),0,0);
		animator.rotate(Tail2,(float)Math.toRadians(10f),0,0);
		animator.rotate(Tail3,(float)Math.toRadians(12.5f),0,0);
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(60f),0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-12.5f),0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(10f),0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-62.5f),0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(12.5f),0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-10f),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(-30f),0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(-15f),0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(20f),0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(-70f),0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(30f),0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(17.5f),0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-20f),0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(70f),0);

		animator.rotate(Maw,(float)Math.toRadians(42.5f),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-47.5f),0,0);

		animator.rotate(Mouth4,(float)Math.toRadians(37.5f),(float)Math.toRadians(-37.5f),0);
		animator.rotate(Mouth3,(float)Math.toRadians(37.5f),(float)Math.toRadians(37.5f),0);
		animator.rotate(Mouth2,(float)Math.toRadians(-37.5f),(float)Math.toRadians(-37.5f),0);
		animator.rotate(Mouth,(float)Math.toRadians(-37.5f),(float)Math.toRadians(37.5f),0);
		animator.endKeyframe();

		animator.setStaticKeyframe(60);

		animator.startKeyframe(25);
		animator.rotate(UpperR_Tentacle,0,(float)Math.toRadians(50f),0);
		animator.rotate(UpperR_Tentacle2,0,(float)Math.toRadians(-32.5f),0);
		animator.rotate(UpperR_Tentacle4,0,(float)Math.toRadians(10f),0);

		animator.rotate(UpperL_Tentacle,0,(float)Math.toRadians(-47.5f),0);
		animator.rotate(UpperL_Tentacle2,0,(float)Math.toRadians(32.5f),0);
		animator.rotate(UpperL_Tentacle4,0,(float)Math.toRadians(-10f),0);

		animator.rotate(LowerR_Tentacle,0,(float)Math.toRadians(-30f),0);
		animator.rotate(LowerR_Tentacle2,0,(float)Math.toRadians(-15f),0);
		animator.rotate(LowerR_Tentacle3,0,(float)Math.toRadians(20f),0);
		animator.rotate(LowerR_Tentacle4,0,(float)Math.toRadians(-20f),0);

		animator.rotate(LowerL_Tentacle,0,(float)Math.toRadians(30f),0);
		animator.rotate(LowerL_Tentacle2,0,(float)Math.toRadians(17.5f),0);
		animator.rotate(LowerL_Tentacle3,0,(float)Math.toRadians(-20f),0);
		animator.rotate(LowerL_Tentacle4,0,(float)Math.toRadians(20f),0);

		animator.rotate(Maw,(float)Math.toRadians(42.5f),0,0);
		animator.rotate(Skul,(float)Math.toRadians(-47.5f),0,0);

		animator.rotate(Mouth4,(float)Math.toRadians(37.5f),(float)Math.toRadians(-37.5f),0);
		animator.rotate(Mouth3,(float)Math.toRadians(37.5f),(float)Math.toRadians(37.5f),0);
		animator.rotate(Mouth2,(float)Math.toRadians(-37.5f),(float)Math.toRadians(-37.5f),0);
		animator.rotate(Mouth,(float)Math.toRadians(-37.5f),(float)Math.toRadians(37.5f),0);
		animator.endKeyframe();

		animator.resetKeyframe(20);


		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_ABYSS_BLAST_FIRE);
		animator.startKeyframe(20);
		animator.rotate(Maw, (float) Math.toRadians(20F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-20F), 0, 0);
		animator.rotate(Mouth, (float) Math.toRadians(-15F), (float) Math.toRadians(7.5F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-15F), (float) Math.toRadians(-7.5F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(2.5F), (float) Math.toRadians(5F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(2.5F), (float) Math.toRadians(-5F), 0);
		animator.rotate(Tail, (float) Math.toRadians(15F), 0, 0);
		animator.rotate(Tail2, (float) Math.toRadians(12.5F), 0, 0);
		animator.rotate(Tail3, (float) Math.toRadians(12.5F), 0, 0);

		animator.rotate(LowerL_Tentacle4, 0, (float) Math.toRadians(-50F), 0);
		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(25F), 0);

		animator.rotate(LowerR_Tentacle4, 0, (float) Math.toRadians(47.5F), 0);
		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(-25F), 0);

		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(-50F), 0);
		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(25F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(25F), 0);

		animator.rotate(UpperR_Tentacle4, 0, (float) Math.toRadians(50F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(-25F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(-25F), 0);


		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(25);
		animator.rotate(Tail, (float) Math.toRadians(17.5F), 0, 0);
		animator.rotate(Tail2, (float) Math.toRadians(15F), 0, 0);
		animator.rotate(Tail3, (float) Math.toRadians(15F), 0, 0);

		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(17.5F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(15F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(15F), 0);

		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(-17.5F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(-15F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(-15F), 0);

		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(17.5F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(15F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(15F), 0);

		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(-17.5F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(-15F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(-15F), 0);
		animator.endKeyframe();

		animator.setStaticKeyframe(26);

		animator.startKeyframe(3);
		animator.rotate(Maw, (float) Math.toRadians(37.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-40F), 0, 0);
		animator.rotate(Mouth, (float) Math.toRadians(-37.5F), (float) Math.toRadians(40F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-37.5F), (float) Math.toRadians(-40F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(37.5F), (float) Math.toRadians(40F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(37.5F), (float) Math.toRadians(-40F), 0);
		animator.rotate(Tail, (float) Math.toRadians(25F), 0, (float) Math.toRadians(5F));
		animator.rotate(Tail2, (float) Math.toRadians(27.5F), 0, (float) Math.toRadians(-2.5F));
		animator.rotate(Tail3, (float) Math.toRadians(50F), 0, (float) Math.toRadians(-2.5F));

		animator.rotate(LowerL_Tentacle4, 0, (float) Math.toRadians(-55F), 0);
		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(-20F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(27.5F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(22.5F), 0);

		animator.rotate(LowerR_Tentacle4, 0, (float) Math.toRadians(55F), 0);
		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(20F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(-27.5F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(-22.5F), 0);

		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(-55F), 0);
		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(-20F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(27.5F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(22.5F), 0);

		animator.rotate(UpperR_Tentacle4, 0, (float) Math.toRadians(55F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(20F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(-27.5F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(-22.5F), 0);

		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.rotate(Maw, (float) Math.toRadians(37.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-40F), 0, 0);
		animator.rotate(Mouth, (float) Math.toRadians(-37.5F), (float) Math.toRadians(40F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-37.5F), (float) Math.toRadians(-40F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(37.5F), (float) Math.toRadians(40F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(37.5F), (float) Math.toRadians(-40F), 0);
		animator.rotate(Tail, (float) Math.toRadians(25F), 0, (float) Math.toRadians(5F));
		animator.rotate(Tail2, (float) Math.toRadians(27.5F), 0, (float) Math.toRadians(-2.5F));
		animator.rotate(Tail3, (float) Math.toRadians(50F), 0, (float) Math.toRadians(-2.5F));

		animator.rotate(LowerL_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(42.5F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-70F), 0);

		animator.rotate(LowerR_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(-42.5F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(70F), 0);

		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(42.5F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-70F), 0);

		animator.rotate(UpperR_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(-42.5F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(70F), 0);

		animator.endKeyframe();

		animator.setStaticKeyframe(20);

		animator.startKeyframe(15);
		animator.rotate(Tail, (float) Math.toRadians(25F), 0, (float) Math.toRadians(5F));
		animator.rotate(Tail2, (float) Math.toRadians(27.5F), 0, (float) Math.toRadians(-2.5F));
		animator.rotate(Tail3, (float) Math.toRadians(50F), 0, (float) Math.toRadians(-2.5F));

		animator.rotate(LowerL_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(42.5F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-70F), 0);

		animator.rotate(LowerR_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(-42.5F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(70F), 0);

		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(42.5F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-70F), 0);

		animator.rotate(UpperR_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(-42.5F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(70F), 0);

		animator.endKeyframe();

		animator.setStaticKeyframe(8);

		animator.startKeyframe(2);
		animator.rotate(Maw, (float) Math.toRadians(37.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-40F), 0, 0);
		animator.rotate(Mouth, (float) Math.toRadians(-37.5F), (float) Math.toRadians(40F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-37.5F), (float) Math.toRadians(-40F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(37.5F), (float) Math.toRadians(40F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(37.5F), (float) Math.toRadians(-40F), 0);
		animator.rotate(Tail, (float) Math.toRadians(25F), 0, (float) Math.toRadians(5F));
		animator.rotate(Tail2, (float) Math.toRadians(27.5F), 0, (float) Math.toRadians(-2.5F));
		animator.rotate(Tail3, (float) Math.toRadians(50F), 0, (float) Math.toRadians(-2.5F));

		animator.rotate(LowerL_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(42.5F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-70F), 0);

		animator.rotate(LowerR_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(-42.5F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(70F), 0);

		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(42.5F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-70F), 0);

		animator.rotate(UpperR_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(-42.5F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(70F), 0);

		animator.endKeyframe();

		animator.setStaticKeyframe(20);

		animator.startKeyframe(15);
		animator.rotate(Tail, (float) Math.toRadians(25F), 0, (float) Math.toRadians(5F));
		animator.rotate(Tail2, (float) Math.toRadians(27.5F), 0, (float) Math.toRadians(-2.5F));
		animator.rotate(Tail3, (float) Math.toRadians(50F), 0, (float) Math.toRadians(-2.5F));

		animator.rotate(LowerL_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(42.5F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-70F), 0);

		animator.rotate(LowerR_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(-42.5F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(70F), 0);

		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(42.5F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-70F), 0);

		animator.rotate(UpperR_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(-42.5F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(70F), 0);

		animator.endKeyframe();

		animator.setStaticKeyframe(8);

		animator.startKeyframe(2);
		animator.rotate(Maw, (float) Math.toRadians(37.5F), 0, 0);
		animator.rotate(Skul, (float) Math.toRadians(-40F), 0, 0);
		animator.rotate(Mouth, (float) Math.toRadians(-37.5F), (float) Math.toRadians(40F), 0);
		animator.rotate(Mouth2, (float) Math.toRadians(-37.5F), (float) Math.toRadians(-40F), 0);
		animator.rotate(Mouth3, (float) Math.toRadians(37.5F), (float) Math.toRadians(40F), 0);
		animator.rotate(Mouth4, (float) Math.toRadians(37.5F), (float) Math.toRadians(-40F), 0);
		animator.rotate(Tail, (float) Math.toRadians(25F), 0, (float) Math.toRadians(5F));
		animator.rotate(Tail2, (float) Math.toRadians(27.5F), 0, (float) Math.toRadians(-2.5F));
		animator.rotate(Tail3, (float) Math.toRadians(50F), 0, (float) Math.toRadians(-2.5F));

		animator.rotate(LowerL_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerL_Tentacle3, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(LowerL_Tentacle2, 0, (float) Math.toRadians(42.5F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-70F), 0);

		animator.rotate(LowerR_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerR_Tentacle3, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(LowerR_Tentacle2, 0, (float) Math.toRadians(-42.5F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(70F), 0);

		animator.rotate(UpperL_Tentacle4, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(UpperL_Tentacle3, 0, (float) Math.toRadians(7.5F), 0);
		animator.rotate(UpperL_Tentacle2, 0, (float) Math.toRadians(42.5F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-70F), 0);

		animator.rotate(UpperR_Tentacle4, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(UpperR_Tentacle3, 0, (float) Math.toRadians(-7.5F), 0);
		animator.rotate(UpperR_Tentacle2, 0, (float) Math.toRadians(-42.5F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(70F), 0);

		animator.endKeyframe();

		animator.setStaticKeyframe(20);

		animator.resetKeyframe(20);



		animator.setAnimation(The_Leviathan_Entity.LEVIATHAN_MINE);
		animator.startKeyframe(15);
		animator.rotate(root, (float) Math.toRadians(5F), 0, 0);
		animator.rotate(Belly, (float) Math.toRadians(-2.5F), 0, 0);
		animator.rotate(Tail, (float) Math.toRadians(-2.5F), 0, 0);
		animator.rotate(Tail2, (float) Math.toRadians(-2.5F), 0, 0);
		animator.rotate(Tail3, (float) Math.toRadians(-2.5F), 0, 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(-30F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(30F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(-30F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(30F), 0);
		animator.rotate(Head,(float) Math.toRadians(20F),0,0);
		animator.endKeyframe();

		animator.setStaticKeyframe(10);

		animator.startKeyframe(6);
		animator.rotate(root, (float) Math.toRadians(-17.5F), (float) Math.toRadians(25F), (float) Math.toRadians(-7.5F));
		animator.rotate(Belly, (float) Math.toRadians(22.5F), (float) Math.toRadians(-17.5F), 0);
		animator.rotate(Tail, (float) Math.toRadians(10F), (float) Math.toRadians(-12.5F), 0);
		animator.rotate(Tail2, (float) Math.toRadians(12.5F), (float) Math.toRadians(-12.5F), 0);
		animator.rotate(Tail3, (float) Math.toRadians(15F), (float) Math.toRadians(-15F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(30F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-30F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(30F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-30F), 0);
		animator.rotate(Head,0,(float) Math.toRadians(17.5F),0);
		animator.rotate(Maw,(float) Math.toRadians(47.5F),(float) Math.toRadians(-15F),(float) Math.toRadians(-15F));
		animator.rotate(Skul,(float) Math.toRadians(-52.5F),0,0);
		animator.rotate(Mouth,(float) Math.toRadians(-30F),(float) Math.toRadians(30F),0);
		animator.rotate(Mouth2,(float) Math.toRadians(-30F),(float) Math.toRadians(-30F),0);
		animator.rotate(Mouth3,(float) Math.toRadians(30F),(float) Math.toRadians(30F),0);
		animator.rotate(Mouth4,(float) Math.toRadians(30F),(float) Math.toRadians(-30F),0);
		animator.endKeyframe();


		animator.startKeyframe(6);
		animator.rotate(root, (float) Math.toRadians(-15F), (float) Math.toRadians(-20F), (float) Math.toRadians(5F));
		animator.rotate(Belly, (float) Math.toRadians(-2.5F), (float) Math.toRadians(12.5F), 0);
		animator.rotate(Tail, (float) Math.toRadians(-2.5F), (float) Math.toRadians(12.5F), 0);
		animator.rotate(Tail2, (float) Math.toRadians(5F), (float) Math.toRadians(17.5F), (float) Math.toRadians(-10F));
		animator.rotate(Tail3, (float) Math.toRadians(-2.5F), (float) Math.toRadians(25F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(5F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-5F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(5F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-5F), 0);
		animator.rotate(Head,0,(float) Math.toRadians(-42.5F),0);
		animator.rotate(Maw,(float) Math.toRadians(47.5F),(float) Math.toRadians(12.5F),(float) Math.toRadians(12.5F));
		animator.rotate(Skul,(float) Math.toRadians(-55F),(float) Math.toRadians(12.5F),(float) Math.toRadians(-15F));
		animator.rotate(Mouth,(float) Math.toRadians(-30F),(float) Math.toRadians(30F),0);
		animator.rotate(Mouth2,(float) Math.toRadians(-30F),(float) Math.toRadians(-30F),0);
		animator.rotate(Mouth3,(float) Math.toRadians(30F),(float) Math.toRadians(30F),0);
		animator.rotate(Mouth4,(float) Math.toRadians(30F),(float) Math.toRadians(-30F),0);
		animator.endKeyframe();

		animator.startKeyframe(6);
		animator.rotate(root, (float) Math.toRadians(-15F), (float) Math.toRadians(25F), (float) Math.toRadians(-7.5F));
		animator.rotate(Belly, (float) Math.toRadians(17.5F), (float) Math.toRadians(-17.5F), 0);
		animator.rotate(Tail, (float) Math.toRadians(22.5F), (float) Math.toRadians(-12.5F), 0);
		animator.rotate(Tail2, (float) Math.toRadians(17.5F), (float) Math.toRadians(-12.5F), 0);
		animator.rotate(Tail3, (float) Math.toRadians(17.5F), (float) Math.toRadians(-15F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(30F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-30F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(30F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-30F), 0);
		animator.rotate(Head,(float) Math.toRadians(42.5F),(float) Math.toRadians(27.5F),0);
		animator.rotate(Maw,(float) Math.toRadians(45F),(float) Math.toRadians(-2.5F),(float) Math.toRadians(-2.5f));
		animator.rotate(Skul,(float) Math.toRadians(-55F),(float) Math.toRadians(-12.5F),(float) Math.toRadians(15F));
		animator.rotate(Mouth,(float) Math.toRadians(-25F),(float) Math.toRadians(12.5F),(float) Math.toRadians(10F));
		animator.rotate(Mouth2,(float) Math.toRadians(-37.5F),(float) Math.toRadians(-42.5F),(float) Math.toRadians(10F));
		animator.rotate(Mouth3,(float) Math.toRadians(25F),(float) Math.toRadians(12.5F),(float) Math.toRadians(-10F));
		animator.rotate(Mouth4,(float) Math.toRadians(40F),(float) Math.toRadians(-45F),(float) Math.toRadians(-15F));
		animator.endKeyframe();


		animator.startKeyframe(6);
		animator.rotate(root, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(7.5F));
		animator.rotate(Belly, (float) Math.toRadians(-2.5F), (float) Math.toRadians(12.5F), 0);
		animator.rotate(Tail, (float) Math.toRadians(-2.5F), (float) Math.toRadians(12.5F), 0);
		animator.rotate(Tail2, (float) Math.toRadians(-5F), (float) Math.toRadians(17.5F), (float) Math.toRadians(-10F));
		animator.rotate(Tail3, (float) Math.toRadians(-2.5F), (float) Math.toRadians(25F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(5F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-5F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(5F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-5F), 0);
		animator.rotate(Head,(float) Math.toRadians(20F),(float) Math.toRadians(-5F),(float) Math.toRadians(-15F));
		animator.rotate(Maw,(float) Math.toRadians(47.5F),(float) Math.toRadians(12.5F),(float) Math.toRadians(12.5f));
		animator.rotate(Skul,(float) Math.toRadians(-42.5F),(float) Math.toRadians(-10F),(float) Math.toRadians(12.5F));
		animator.rotate(Mouth,(float) Math.toRadians(-30F),(float) Math.toRadians(30F),0);
		animator.rotate(Mouth2,(float) Math.toRadians(-27.5F),(float) Math.toRadians(-25F),(float) Math.toRadians(-2.5F));
		animator.rotate(Mouth3,(float) Math.toRadians(30F),(float) Math.toRadians(30F),0);
		animator.rotate(Mouth4,(float) Math.toRadians(30F),(float) Math.toRadians(-30F),0);
		animator.endKeyframe();


		animator.startKeyframe(6);
		animator.rotate(root, (float) Math.toRadians(-17.5F), (float) Math.toRadians(25F), (float) Math.toRadians(-7.5F));
		animator.rotate(Belly, (float) Math.toRadians(22.5F), (float) Math.toRadians(-17.5F), 0);
		animator.rotate(Tail, (float) Math.toRadians(22.5F), (float) Math.toRadians(-12.5F), 0);
		animator.rotate(Tail2, (float) Math.toRadians(27.5F), (float) Math.toRadians(-12.5F), 0);
		animator.rotate(Tail3, (float) Math.toRadians(17.5F), (float) Math.toRadians(-15F), 0);
		animator.rotate(UpperR_Tentacle, 0, (float) Math.toRadians(30F), 0);
		animator.rotate(UpperL_Tentacle, 0, (float) Math.toRadians(-30F), 0);
		animator.rotate(LowerR_Tentacle, 0, (float) Math.toRadians(30F), 0);
		animator.rotate(LowerL_Tentacle, 0, (float) Math.toRadians(-30F), 0);
		animator.rotate(Head,0,(float) Math.toRadians(35F),0);
		animator.rotate(Maw,(float) Math.toRadians(47.5F),(float) Math.toRadians(-15F),(float) Math.toRadians(-17.5f));
		animator.rotate(Skul,(float) Math.toRadians(-32.5F),(float) Math.toRadians(-7.5F),(float) Math.toRadians(10F));
		animator.rotate(Mouth,(float) Math.toRadians(-22.5F),(float) Math.toRadians(22.5F),0);
		animator.rotate(Mouth2,(float) Math.toRadians(-22.5F),(float) Math.toRadians(-20F),(float) Math.toRadians(-2.5F));
		animator.rotate(Mouth3,(float) Math.toRadians(22.5F),(float) Math.toRadians(22.5F),0);
		animator.rotate(Mouth4,(float) Math.toRadians(22.5F),(float) Math.toRadians(-22.5F),0);
		animator.endKeyframe();


		animator.resetKeyframe(13);

	}

	@Override
	public void setupAnim(The_Leviathan_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

		AdvancedModelBox[] tailBoxes = new AdvancedModelBox[]{Tail, Tail2, Tail3};

		float swimSpeed = 0.1F;
		float swimDegree = 0.4F;
		float finspeed = 0.1F;
		float finDegree = 0.2F;
		boolean swimAnimate = entityIn.isInWater();
		float partialTick = Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);
		float LeftTentacleProgress = entityIn.prevLeftTentacleProgress + (entityIn.LeftTentacleProgress - entityIn.prevLeftTentacleProgress) * partialTick;
		float RightTentacleProgress = entityIn.prevRightTentacleProgress + (entityIn.RightTentacleProgress - entityIn.prevRightTentacleProgress) * partialTick;
		float NoswimProgress = entityIn.prevNoSwimProgress + (entityIn.NoSwimProgress - entityIn.prevNoSwimProgress) * partialTick;

		progressRotationPrev(R_fin,NoswimProgress,0, 0, (float)Math.toRadians(-15F), 10f);
		progressRotationPrev(L_fin,NoswimProgress,0, 0, (float)Math.toRadians(15F), 10f);
		progressRotationPrev(R_fin2,NoswimProgress,0, 0, (float)Math.toRadians(15F), 10f);
		progressRotationPrev(L_fin2,NoswimProgress,0, 0, (float)Math.toRadians(-15F), 10f);
		progressRotationPrev(R_down_fin,NoswimProgress,0, 0, (float)Math.toRadians(-50F), 10f);
		progressRotationPrev(L_down_fin,NoswimProgress,0, 0, (float)Math.toRadians(50F), 10f);
		progressRotationPrev(R_down_fin2,NoswimProgress,0, 0, (float)Math.toRadians(50F), 10f);
		progressRotationPrev(L_down_fin2,NoswimProgress,0, 0, (float)Math.toRadians(-50F), 10f);
		progressRotationPrev(R_mini_fin,NoswimProgress,0, 0, (float)Math.toRadians(-32.5F), 10f);
		progressRotationPrev(L_mini_fin,NoswimProgress,0, 0, (float)Math.toRadians(32.5F), 10f);

		progressRotationPrev(LowerL_Tentacle,LeftTentacleProgress,0, 0, (float)Math.toRadians(-32.5F), 10F);
		progressRotationPrev(LowerR_Tentacle,RightTentacleProgress,0, 0, (float)Math.toRadians(32.5F), 10F);

		//this.swing(UpperR_Tentacle, swimSpeed * 0.4F, 0.1F, false, 0F, -0.1F, ageInTicks, 1.0f);
		//this.swing(UpperR_Tentacle3, swimSpeed * 0.4F, 0.1F, false, 2F, -0.1F, ageInTicks, 1.0f);


		this.flap(UpperR_Hook, swimSpeed * 0.2F, 0.35F, true, 0F, -0.35F, ageInTicks, 1.0f);
		this.swing(UpperR_Hook2, swimSpeed * 0.2F, 0.35F, true, 0F, -0.35F, ageInTicks, 1.0f);
		this.swing(UpperR_Hook3, swimSpeed * 0.2F, 0.35F, false, 0F, -0.35F, ageInTicks, 1.0f);
		this.flap(UpperR_Hook4, swimSpeed * 0.2F, 0.35F, false, 0F, -0.35F, ageInTicks, 1.0f);
		this.flap(UpperR_Hook, swimSpeed * 1.3F, 0.35F, true, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.swing(UpperR_Hook2, swimSpeed * 1.3F, 0.35F, true, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.swing(UpperR_Hook3, swimSpeed * 1.3F, 0.35F, false, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.flap(UpperR_Hook4, swimSpeed * 1.3F, 0.35F, false, 0F, -0.35F, limbSwing, limbSwingAmount);

		//this.swing(UpperL_Tentacle, swimSpeed * 0.4F, 0.1F, true, 0F, -0.1F, ageInTicks, 1.0f);
	//	this.swing(UpperL_Tentacle3, swimSpeed * 0.4F, 0.1F, true, 2f, -0.1F, ageInTicks, 1.0f);


		this.flap(UpperL_Hook, swimSpeed * 0.2F, 0.35F, false, 0F, -0.35F, ageInTicks, 1.0f);
		this.swing(UpperL_Hook2, swimSpeed * 0.2F, 0.35F, false, 0F, -0.35F, ageInTicks, 1.0f);
		this.swing(UpperL_Hook3, swimSpeed * 0.2F, 0.35F, true, 0F, -0.35F, ageInTicks, 1.0f);
		this.flap(UpperL_Hook4, swimSpeed * 0.2F, 0.35F, true, 0F, -0.35F, ageInTicks, 1.0f);
		this.flap(UpperL_Hook, swimSpeed * 1.3F, 0.35F, false, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.swing(UpperL_Hook2, swimSpeed * 1.3F, 0.35F, false, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.swing(UpperL_Hook3, swimSpeed * 1.3F, 0.35F, true, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.flap(UpperL_Hook4, swimSpeed * 1.3F, 0.35F, true, 0F, -0.35F, limbSwing, limbSwingAmount);

		//this.swing(LowerR_Tentacle, swimSpeed * 0.4F, 0.1F, false, 0F, -0.1F, ageInTicks, 1.0f);
		//this.swing(LowerR_Tentacle3, swimSpeed * 0.4F, 0.1F, false, 2f, -0.1F, ageInTicks, 1.0f);


		this.flap(LowerR_Hook, swimSpeed * 0.2F, 0.35F, true, 0F, -0.35F, ageInTicks, 1.0f);
		this.swing(LowerR_Hook2, swimSpeed * 0.2F, 0.35F, true, 0F, -0.35F, ageInTicks, 1.0f);
		this.swing(LowerR_Hook3, swimSpeed * 0.2F, 0.35F, false, 0F, -0.35F, ageInTicks, 1.0f);
		this.flap(LowerR_Hook4, swimSpeed * 0.2F, 0.35F, false, 0F, -0.35F, ageInTicks, 1.0f);
		this.flap(LowerR_Hook, swimSpeed * 1.3F, 0.35F, true, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.swing(LowerR_Hook2, swimSpeed * 1.3F, 0.35F, true, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.swing(LowerR_Hook3, swimSpeed * 1.3F, 0.35F, false, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.flap(LowerR_Hook4, swimSpeed * 1.3F, 0.35F, false, 0F, -0.35F, limbSwing, limbSwingAmount);

		//this.swing(LowerL_Tentacle, swimSpeed * 0.4F, 0.1F, true, 0F, -0.1F, ageInTicks, 1.0f);

		//this.swing(LowerL_Tentacle3, swimSpeed * 0.4F, 0.1F, true, 2f, -0.1F, ageInTicks, 1.0f);

		this.flap(LowerL_Hook, swimSpeed * 0.2F, 0.35F, false, 0F, -0.35F, ageInTicks, 1.0f);
		this.swing(LowerL_Hook2, swimSpeed * 0.2F, 0.35F, false, 0F, -0.35F, ageInTicks, 1.0f);
		this.swing(LowerL_Hook3, swimSpeed * 0.2F, 0.35F, true, 0F, -0.35F, ageInTicks, 1.0f);
		this.flap(LowerL_Hook4, swimSpeed * 0.2F, 0.35F, true, 0F, -0.35F, ageInTicks, 1.0f);
		this.flap(LowerL_Hook, swimSpeed * 1.3F, 0.35F, false, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.swing(LowerL_Hook2, swimSpeed * 1.3F, 0.35F, false, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.swing(LowerL_Hook3, swimSpeed * 1.3F, 0.35F, true, 0F, -0.35F, limbSwing, limbSwingAmount);
		this.flap(LowerL_Hook4, swimSpeed * 1.3F, 0.35F, true, 0F, -0.35F, limbSwing, limbSwingAmount);

		this.chainSwing(tailBoxes, swimSpeed * 0.4F, swimDegree * 0.45F, -1, ageInTicks , 1.0f);
		this.chainSwing(tailBoxes, swimSpeed * 4F, swimDegree * 0.6F, -1, limbSwing,limbSwingAmount);
		if(NoswimProgress <= 0) {
			this.flap(R_fin, finspeed * 0.8F, finDegree, false, 0F, -0.2F, ageInTicks, 1.0f);
			this.flap(R_fin2, finspeed * 0.8F, finDegree, false, 1F, -0.2F, ageInTicks, 1.0f);
			this.flap(L_fin, finspeed * 0.8F, finDegree, true, 0F, -0.2F, ageInTicks, 1.0f);
			this.flap(L_fin2, finspeed * 0.8F, finDegree, true, 1F, -0.2F, ageInTicks, 1.0f);

			this.flap(R_fin, finspeed * 4.0F, finDegree, false, 0F, -0.2F, limbSwing, limbSwingAmount);
			this.flap(R_fin2, finspeed * 4.0F, finDegree, false, 1F, -0.2F, limbSwing, limbSwingAmount);
			this.flap(L_fin, finspeed * 4.0F, finDegree, true, 0F, -0.2F, limbSwing, limbSwingAmount);
			this.flap(L_fin2, finspeed * 4.0F, finDegree, true, 1F, -0.2F, limbSwing, limbSwingAmount);

			this.flap(R_mini_fin, finspeed * 1.2F, finDegree * 2.5F, false, 0F, -0.5F, ageInTicks, 1.0f);
			this.flap(L_mini_fin, finspeed * 1.2F, finDegree * 2.5F, true, 0F, -0.5F, ageInTicks, 1.0f);

			this.flap(R_down_fin, finspeed * 0.8F, finDegree * 1.5F, false, 0F, -0.3F, ageInTicks, 1.0f);
			this.flap(L_down_fin, finspeed * 0.8F, finDegree * 1.5F, true, 0F, -0.3F, ageInTicks, 1.0f);

			this.flap(R_mini_fin, finspeed * 4.0F, finDegree * 2.5F, false, 0F, -0.5F, limbSwing, limbSwingAmount);
			this.flap(L_mini_fin, finspeed * 4.0F, finDegree * 2.5F, true, 0F, -0.5F, limbSwing, limbSwingAmount);

			this.flap(R_down_fin, finspeed * 4.0F, finDegree * 1.5F, false, 0F, -0.3F, limbSwing, limbSwingAmount);
			this.flap(L_down_fin, finspeed * 4.0F, finDegree * 1.5F, true, 0F, -0.3F, limbSwing, limbSwingAmount);
		}else{
			this.swing(R_fin, finspeed * 20.0F, finDegree * 1.5f, false, 0F, -0.1F, limbSwing, limbSwingAmount);
			this.swing(L_fin, finspeed * 20.0F, finDegree * 1.5f, true, 0F, -0.1F, limbSwing, limbSwingAmount);
		}
		this.walk(Mouth, finspeed * 0.8F, finDegree * 0.15F, false, 0F, -0.03F, ageInTicks, 1.0f);
		this.walk(Mouth2, finspeed * 0.8F, finDegree * 0.15F, false, 0F, -0.03F, ageInTicks, 1.0f);
		this.walk(Mouth3, finspeed * 0.8F, finDegree * 0.15F, true, 0F, -0.03F, ageInTicks, 1.0f);
		this.walk(Mouth4, finspeed * 0.8F, finDegree * 0.15F, true, 0F, -0.03F, ageInTicks, 1.0f);

		this.walk(Maw, finspeed * 1.1F, finDegree * 0.15F, true, 0F, -0.03F, limbSwing, limbSwingAmount);
		this.walk(Skul, finspeed * 1.1F, finDegree * 0.15F, false, 0F, -0.03F, limbSwing, limbSwingAmount);



		AdvancedModelBox[] URT = new AdvancedModelBox[]{UpperR_Tentacle, UpperR_Tentacle2, UpperR_Tentacle3};

		AdvancedModelBox[] ULT = new AdvancedModelBox[]{UpperL_Tentacle, UpperL_Tentacle2, UpperL_Tentacle3};

		AdvancedModelBox[] LRT = new AdvancedModelBox[]{LowerR_Tentacle, LowerR_Tentacle2, LowerR_Tentacle3};

		AdvancedModelBox[] LLT = new AdvancedModelBox[]{LowerL_Tentacle, LowerL_Tentacle2, LowerL_Tentacle3};




		this.chainWave(URT, 0.03F, -0.1F, -3, ageInTicks, 1.0f);
		this.chainSwing(URT, 0.03F, -0.1F, -3, ageInTicks, 1.0f);

		this.chainWave(ULT, 0.03F, 0.1F, -3, ageInTicks, 1.0f);
		this.chainSwing(ULT, 0.03F, 0.1F, -3, ageInTicks, 1.0f);

		this.chainWave(LRT, 0.03F, -0.1F, -3, ageInTicks, 1.0f);
		this.chainSwing(LRT, 0.03F, -0.1F, -3, ageInTicks, 1.0f);

		this.chainWave(LLT, 0.03F, 0.1F, -3, ageInTicks, 1.0f);
		this.chainSwing(LLT, 0.03F, 0.1F, -3, ageInTicks, 1.0f);



		this.chainSwing(URT, 0.2F, -0.2F, -3, limbSwing, limbSwingAmount);
		this.chainWave(URT, 0.2F, -0.2F, -3, limbSwing, limbSwingAmount);

		this.chainSwing(ULT, 0.2F, 0.2F, -3, limbSwing, limbSwingAmount);
		this.chainWave(ULT, 0.2F, 0.2F, -3, limbSwing, limbSwingAmount);

		this.chainSwing(LRT, 0.2F, -0.2F, -3, limbSwing, limbSwingAmount);
		this.chainWave(LRT, 0.2F, -0.2F, -3, limbSwing, limbSwingAmount);

		this.chainSwing(LLT, 0.2F, 0.2F, -3, limbSwing, limbSwingAmount);
		this.chainWave(LLT, 0.2F, 0.2F, -3, limbSwing, limbSwingAmount);

		this.body.rotateAngleX += headPitch * ((float) Math.PI / 180F);
		this.body.rotateAngleY += netHeadYaw * ((float) Math.PI / 180F);

		if (horizontalMag(entityIn.getDeltaMovement()) > 1.0E-7D) {
			//this.body.rotateAngleX += -0.05F + -0.05F * Mth.cos(ageInTicks * 0.3F);
		}

	}


	
	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				body,
				R_Spike,
				L_Spike,
				Main_belly,
				R_Spike2,
				L_Spike2,
				R_mini_fin,
				L_mini_fin,
				Belly,
				R_down_fin,
				R_down_fin2,
				L_down_fin,
				L_down_fin2,
				Tail,
				R_Spike3,
				L_Spike3,
				Tail2,
				R_Spike4,
				L_Spike4,
				Tail3,
				Tail_Particle,
				UpperL_Tentacle,
				UpperL_Tentacle2,
				UpperL_Tentacle3,
				UpperL_Tentacle4,
				UpperL_Hook,
				UpperL_Hook2,
				UpperL_Hook3,
				UpperL_Hook4,
				UpperR_Tentacle,
				UpperR_Tentacle2,
				UpperR_Tentacle3,
				UpperR_Tentacle4,
				UpperR_Hook,
				UpperR_Hook2,
				UpperR_Hook3,
				UpperR_Hook4,
				LowerL_Tentacle,
				LowerL_Tentacle2,
				LowerL_Tentacle3,
				LowerL_Tentacle4,
				LowerL_Hook,
				LowerL_Hook2,
				LowerL_Hook3,
				LowerL_Hook4,
				LowerR_Tentacle,
				LowerR_Tentacle2,
				LowerR_Tentacle3,
				LowerR_Tentacle4,
				LowerR_Hook,
				LowerR_Hook2,
				LowerR_Hook3,
				LowerR_Hook4,
				Head,
				Muscle,
				Maw,
				Skul,
				tongue,
				R_fin,
				R_fin2,
				R_fin3,
				L_fin,
				L_fin2,
				L_fin3,
				four_mouths,
				Mouth4,
				Mouth4_e,
				Mouth3,
				Mouth3_e,
				Mouth2,
				Mouth2_e,
				Mouth,
				Mouth1_e);
	}

	public Vec3 translateToTongue(Vec3 in, float yawIn) {
		PoseStack modelTranslateStack = new PoseStack();
		modelTranslateStack.mulPose(Axis.YP.rotationDegrees(180.0F - yawIn));
		modelTranslateStack.translate((double) (root.rotationPointX / 16.0F), (double) (root.rotationPointY / 16.0F), (double) (root.rotationPointZ / 16.0F));
		modelTranslateStack.mulPose(Axis.ZN.rotation(root.rotateAngleZ));
		modelTranslateStack.mulPose(Axis.YN.rotation(root.rotateAngleY));
		modelTranslateStack.mulPose(Axis.XN.rotation(root.rotateAngleX));
		modelTranslateStack.translate((double) (body.rotationPointX / 16.0F), (double) (body.rotationPointY / 16.0F), (double) (body.rotationPointZ / 16.0F));
		modelTranslateStack.mulPose(Axis.ZN.rotation(body.rotateAngleZ));
		modelTranslateStack.mulPose(Axis.YN.rotation(body.rotateAngleY));
		modelTranslateStack.mulPose(Axis.XN.rotation(body.rotateAngleX));
		modelTranslateStack.translate((double) (Head.rotationPointX / 16.0F), (double) (Head.rotationPointY / 16.0F), (double) (Head.rotationPointZ / 16.0F));
		modelTranslateStack.mulPose(Axis.ZN.rotation(Head.rotateAngleZ));
		modelTranslateStack.mulPose(Axis.YN.rotation(Head.rotateAngleY));
		modelTranslateStack.mulPose(Axis.XN.rotation(Head.rotateAngleX));
		modelTranslateStack.translate((double) (tongue.rotationPointX / 16.0F), (double) (tongue.rotationPointY / 16.0F), (double) (tongue.rotationPointZ / 16.0F));
		modelTranslateStack.mulPose(Axis.ZN.rotation(tongue.rotateAngleZ));
		modelTranslateStack.mulPose(Axis.YN.rotation(tongue.rotateAngleY));
		modelTranslateStack.mulPose(Axis.XN.rotation(tongue.rotateAngleX));
		Vector4f tongueOffsetVec = new Vector4f((float) in.x, (float) in.y, (float) in.z, 1.0F);
		tongueOffsetVec.mul(modelTranslateStack.last().pose());
		Vec3 offset = new Vec3(tongueOffsetVec.x(), tongueOffsetVec.y(), tongueOffsetVec.z());
		modelTranslateStack.popPose();
		return offset;
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