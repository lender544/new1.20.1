package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.client.animation.Netherite_Monstrosity_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class Netherite_Monstrosity_Model extends HierarchicalModel<Netherite_Monstrosity_Entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor

	private final ModelPart root;
	private final ModelPart roots;
	private final ModelPart lowerbody;
	private final ModelPart upperbody;
	private final ModelPart head;
	private final ModelPart horns;
	private final ModelPart jaw;
	private final ModelPart leftarmjoint;
	private final ModelPart leftarm;
	private final ModelPart leftarm2;
	private final ModelPart lefthand;
	private final ModelPart l_hand_blast_4;
	private final ModelPart l_hand_blast_3;
	private final ModelPart leftfinger1;
	private final ModelPart l_hand_blast_2;
	private final ModelPart leftfinger2;
	private final ModelPart l_hand_blast_1;
	private final ModelPart leftfinger3;
	private final ModelPart l_cannon;
	private final ModelPart l_core;
	private final ModelPart l_flame_2;
	private final ModelPart l_flame_1;
	private final ModelPart rightarmjoint;
	private final ModelPart rightarm;
	private final ModelPart rightarm2;
	private final ModelPart righthand;
	private final ModelPart r_hand_blast_4;
	private final ModelPart r_hand_blast_3;
	private final ModelPart rightfinger1;
	private final ModelPart r_hand_blast_2;
	private final ModelPart rightfinger2;
	private final ModelPart r_hand_blast_1;
	private final ModelPart rightfinger3;
	private final ModelPart r_cannon;
	private final ModelPart r_core;
	private final ModelPart r_flame_1;
	private final ModelPart r_flame_2;
	private final ModelPart rightleg;
	private final ModelPart leftleg;

	public Netherite_Monstrosity_Model(ModelPart root) {
		this.root = root;
		this.roots = this.root.getChild("roots");
		this.lowerbody = this.roots.getChild("lowerbody");
		this.upperbody = this.lowerbody.getChild("upperbody");
		this.head = this.upperbody.getChild("head");
		this.horns = this.head.getChild("horns");
		this.jaw = this.head.getChild("jaw");
		this.leftarmjoint = this.upperbody.getChild("leftarmjoint");
		this.leftarm = this.leftarmjoint.getChild("leftarm");
		this.leftarm2 = this.leftarm.getChild("leftarm2");
		this.lefthand = this.leftarm2.getChild("lefthand");
		this.l_hand_blast_4 = this.lefthand.getChild("l_hand_blast_4");
		this.l_hand_blast_3 = this.lefthand.getChild("l_hand_blast_3");
		this.leftfinger1 = this.l_hand_blast_3.getChild("leftfinger1");
		this.l_hand_blast_2 = this.lefthand.getChild("l_hand_blast_2");
		this.leftfinger2 = this.l_hand_blast_2.getChild("leftfinger2");
		this.l_hand_blast_1 = this.lefthand.getChild("l_hand_blast_1");
		this.leftfinger3 = this.l_hand_blast_1.getChild("leftfinger3");
		this.l_cannon = this.lefthand.getChild("l_cannon");
		this.l_core = this.lefthand.getChild("l_core");
		this.l_flame_2 = this.l_core.getChild("l_flame_2");
		this.l_flame_1 = this.l_core.getChild("l_flame_1");
		this.rightarmjoint = this.upperbody.getChild("rightarmjoint");
		this.rightarm = this.rightarmjoint.getChild("rightarm");
		this.rightarm2 = this.rightarm.getChild("rightarm2");
		this.righthand = this.rightarm2.getChild("righthand");
		this.r_hand_blast_4 = this.righthand.getChild("r_hand_blast_4");
		this.r_hand_blast_3 = this.righthand.getChild("r_hand_blast_3");
		this.rightfinger1 = this.r_hand_blast_3.getChild("rightfinger1");
		this.r_hand_blast_2 = this.righthand.getChild("r_hand_blast_2");
		this.rightfinger2 = this.r_hand_blast_2.getChild("rightfinger2");
		this.r_hand_blast_1 = this.righthand.getChild("r_hand_blast_1");
		this.rightfinger3 = this.r_hand_blast_1.getChild("rightfinger3");
		this.r_cannon = this.righthand.getChild("r_cannon");
		this.r_core = this.righthand.getChild("r_core");
		this.r_flame_1 = this.r_core.getChild("r_flame_1");
		this.r_flame_2 = this.r_core.getChild("r_flame_2");
		this.rightleg = this.roots.getChild("rightleg");
		this.leftleg = this.roots.getChild("leftleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition roots = partdefinition.addOrReplaceChild("roots", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition lowerbody = roots.addOrReplaceChild("lowerbody", CubeListBuilder.create().texOffs(175, 193).addBox(-14.0F, -11.0F, -10.5F, 28.0F, 11.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 2.0F));

		PartDefinition upperbody = lowerbody.addOrReplaceChild("upperbody", CubeListBuilder.create().texOffs(0, 0).addBox(-37.0F, -57.0F, -15.0F, 74.0F, 57.0F, 30.0F, new CubeDeformation(0.0F))
				.texOffs(209, 226).addBox(-14.0F, -50.0F, 15.0F, 28.0F, 16.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = upperbody.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 139).addBox(-14.0F, -18.0F, -20.5F, 28.0F, 31.0F, 22.0F, new CubeDeformation(0.0F))
				.texOffs(246, 112).addBox(-34.0F, -12.5F, -16.0F, 20.0F, 13.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(246, 112).mirror().addBox(14.0F, -12.5F, -16.0F, 20.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(253, 184).addBox(-34.0F, -27.5F, -16.0F, 8.0F, 15.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(169, 171).addBox(26.0F, -15.5F, -16.0F, 8.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(12, 0).addBox(-2.5F, -2.0F, -20.7F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(17, 5).addBox(-14.25F, 1.5F, -20.7F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(17, 5).addBox(10.25F, 1.5F, -20.7F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -33.0F, -16.5F));

		PartDefinition horns = head.addOrReplaceChild("horns", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.5F, 47.0F, -3.5F, 1.0472F, 0.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(209, 2).addBox(-13.5F, -10.0F, -21.9F, 27.0F, 16.0F, 21.0F, new CubeDeformation(0.0F))
				.texOffs(305, 8).addBox(-13.5F, 6.0F, -21.9F, 27.0F, 5.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(209, 40).addBox(-13.5F, 3.0F, -21.9F, 27.0F, 0.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, 1.5F, 0.1309F, 0.0F, 0.0F));

		PartDefinition leftarmjoint = upperbody.addOrReplaceChild("leftarmjoint", CubeListBuilder.create(), PartPose.offset(37.0F, -38.5F, -2.5F));

		PartDefinition leftarm = leftarmjoint.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(101, 163).addBox(0.0F, -33.5F, -13.5F, 20.0F, 23.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 88).addBox(0.0F, -10.5F, -13.5F, 37.0F, 23.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftarm2 = leftarm.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(132, 226).addBox(-11.0F, -4.5F, -8.0F, 22.0F, 20.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0F, 12.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition lefthand = leftarm2.addOrReplaceChild("lefthand", CubeListBuilder.create().texOffs(136, 264).mirror().addBox(-12.0F, -5.0F, -12.0F, 24.0F, 5.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 17.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition righthand_r1 = lefthand.addOrReplaceChild("righthand_r1", CubeListBuilder.create().texOffs(102, 260).mirror().addBox(-2.5F, -13.5F, 3.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(74, 260).mirror().addBox(-19.5F, -13.5F, 3.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)).mirror(false)
				.texOffs(88, 260).mirror().addBox(-19.5F, -13.5F, 3.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(61, 314).mirror().addBox(-16.5F, -4.5F, -2.0F, 14.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(60, 270).mirror().addBox(-16.5F, -13.5F, -2.0F, 14.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 13.5F, 9.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition lefthand_r1 = lefthand.addOrReplaceChild("lefthand_r1", CubeListBuilder.create().texOffs(88, 260).addBox(-103.0F, -3.0F, -10.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-110.0F, 3.0F, -8.5F, 0.0F, -3.1416F, 0.0F));

		PartDefinition righthand_r2 = lefthand.addOrReplaceChild("righthand_r2", CubeListBuilder.create().texOffs(88, 260).mirror().addBox(-10.0F, -3.0F, -10.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, -8.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition lefthand_r2 = lefthand.addOrReplaceChild("lefthand_r2", CubeListBuilder.create().texOffs(74, 260).addBox(-111.5F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-118.5F, 3.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition righthand_r3 = lefthand.addOrReplaceChild("righthand_r3", CubeListBuilder.create().texOffs(74, 260).mirror().addBox(-10.0F, -3.0F, -2.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, -0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition righthand_r4 = lefthand.addOrReplaceChild("righthand_r4", CubeListBuilder.create().texOffs(74, 260).mirror().addBox(-18.5F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, -8.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition l_hand_blast_4 = lefthand.addOrReplaceChild("l_hand_blast_4", CubeListBuilder.create(), PartPose.offset(-10.0F, 0.0F, 10.0F));

		PartDefinition lefthand_r3 = l_hand_blast_4.addOrReplaceChild("lefthand_r3", CubeListBuilder.create().texOffs(0, 304).addBox(-0.5F, -13.5F, -5.0F, 10.0F, 15.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 329).addBox(2.5F, 1.5F, -2.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 269).addBox(-5.5F, -13.5F, -10.0F, 15.0F, 20.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 13.5F, -0.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition l_hand_blast_3 = lefthand.addOrReplaceChild("l_hand_blast_3", CubeListBuilder.create(), PartPose.offset(10.0F, 0.0F, 10.0F));

		PartDefinition righthand_r5 = l_hand_blast_3.addOrReplaceChild("righthand_r5", CubeListBuilder.create().texOffs(0, 304).mirror().addBox(-9.5F, -13.5F, -5.0F, 10.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 329).mirror().addBox(-9.5F, 1.5F, -2.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 269).mirror().addBox(-9.5F, -13.5F, -10.0F, 15.0F, 20.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 13.5F, -0.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition leftfinger1 = l_hand_blast_3.addOrReplaceChild("leftfinger1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -4.0F));

		PartDefinition l_hand_blast_2 = lefthand.addOrReplaceChild("l_hand_blast_2", CubeListBuilder.create().texOffs(0, 269).mirror().addBox(-10.0F, 0.0F, -5.0F, 15.0F, 20.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 329).mirror().addBox(-10.0F, 15.0F, 3.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 304).mirror().addBox(-10.0F, 0.0F, 0.0F, 10.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 0.0F, -10.0F));

		PartDefinition leftfinger2 = l_hand_blast_2.addOrReplaceChild("leftfinger2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 2.0F));

		PartDefinition l_hand_blast_1 = lefthand.addOrReplaceChild("l_hand_blast_1", CubeListBuilder.create().texOffs(0, 269).addBox(-5.0F, 0.0F, -5.0F, 15.0F, 20.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(0, 329).addBox(3.0F, 15.0F, 3.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 304).addBox(0.0F, 0.0F, 0.0F, 10.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, 0.0F, -10.0F));

		PartDefinition leftfinger3 = l_hand_blast_1.addOrReplaceChild("leftfinger3", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, 8.5F));

		PartDefinition leftfinger3_r1 = leftfinger3.addOrReplaceChild("leftfinger3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -7.5F, -2.5F, 3.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 1.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition l_cannon = lefthand.addOrReplaceChild("l_cannon", CubeListBuilder.create(), PartPose.offset(0.0F, 13.75F, 0.0F));

		PartDefinition righthand_r6 = l_cannon.addOrReplaceChild("righthand_r6", CubeListBuilder.create().texOffs(61, 294).mirror().addBox(-7.0F, 7.5F, -7.0F, 14.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(69, 331).mirror().addBox(-6.0F, 2.5F, -6.0F, 12.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.25F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition l_core = lefthand.addOrReplaceChild("l_core", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, 0.0F));

		PartDefinition righthand_r7 = l_core.addOrReplaceChild("righthand_r7", CubeListBuilder.create().texOffs(0, 341).mirror().addBox(-4.0F, 6.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.5F)).mirror(false)
				.texOffs(0, 357).mirror().addBox(-4.0F, 6.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition l_flame_2 = l_core.addOrReplaceChild("l_flame_2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition righthand_r8 = l_flame_2.addOrReplaceChild("righthand_r8", CubeListBuilder.create().texOffs(-16, 373).mirror().addBox(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.0663F, -1.0163F, -2.2196F));

		PartDefinition l_flame_1 = l_core.addOrReplaceChild("l_flame_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition righthand_r9 = l_flame_1.addOrReplaceChild("righthand_r9", CubeListBuilder.create().texOffs(-16, 373).mirror().addBox(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -1.1781F, 2.7489F));

		PartDefinition rightarmjoint = upperbody.addOrReplaceChild("rightarmjoint", CubeListBuilder.create(), PartPose.offset(-37.0F, -38.5F, -2.5F));

		PartDefinition rightarm = rightarmjoint.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(101, 163).mirror().addBox(-20.0F, -33.5F, -13.5F, 20.0F, 23.0F, 27.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 88).mirror().addBox(-37.0F, -10.5F, -13.5F, 37.0F, 23.0F, 27.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightarm2 = rightarm.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(132, 226).addBox(-11.0F, -4.5F, -8.0F, 22.0F, 22.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, 12.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition righthand = rightarm2.addOrReplaceChild("righthand", CubeListBuilder.create().texOffs(136, 264).addBox(-12.0F, -5.0F, -12.0F, 24.0F, 5.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 17.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition lefthand_r4 = righthand.addOrReplaceChild("lefthand_r4", CubeListBuilder.create().texOffs(102, 260).addBox(-0.5F, -13.5F, 3.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(74, 260).addBox(16.5F, -13.5F, 3.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.2F))
				.texOffs(88, 260).addBox(16.5F, -13.5F, 3.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(61, 314).addBox(2.5F, -4.5F, -2.0F, 14.0F, 3.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(60, 270).addBox(2.5F, -13.5F, -2.0F, 14.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 13.5F, 9.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition righthand_r10 = righthand.addOrReplaceChild("righthand_r10", CubeListBuilder.create().texOffs(88, 260).mirror().addBox(100.0F, -3.0F, -10.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(110.0F, 3.0F, -8.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition lefthand_r5 = righthand.addOrReplaceChild("lefthand_r5", CubeListBuilder.create().texOffs(88, 260).addBox(7.0F, -3.0F, -10.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -8.5F, 0.0F, -3.1416F, 0.0F));

		PartDefinition righthand_r11 = righthand.addOrReplaceChild("righthand_r11", CubeListBuilder.create().texOffs(74, 260).mirror().addBox(108.5F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(118.5F, 3.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition lefthand_r6 = righthand.addOrReplaceChild("lefthand_r6", CubeListBuilder.create().texOffs(74, 260).addBox(7.0F, -3.0F, -2.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 3.0F, -0.5F, 0.0F, -3.1416F, 0.0F));

		PartDefinition lefthand_r7 = righthand.addOrReplaceChild("lefthand_r7", CubeListBuilder.create().texOffs(74, 260).addBox(15.5F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 3.0F, -8.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition r_hand_blast_4 = righthand.addOrReplaceChild("r_hand_blast_4", CubeListBuilder.create(), PartPose.offset(10.0F, 0.0F, 10.0F));

		PartDefinition righthand_r12 = r_hand_blast_4.addOrReplaceChild("righthand_r12", CubeListBuilder.create().texOffs(0, 304).mirror().addBox(-9.5F, -13.5F, -5.0F, 10.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 329).mirror().addBox(-9.5F, 1.5F, -2.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 269).mirror().addBox(-9.5F, -13.5F, -10.0F, 15.0F, 20.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 13.5F, -0.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition r_hand_blast_3 = righthand.addOrReplaceChild("r_hand_blast_3", CubeListBuilder.create(), PartPose.offset(-10.0F, 0.0F, 10.0F));

		PartDefinition lefthand_r8 = r_hand_blast_3.addOrReplaceChild("lefthand_r8", CubeListBuilder.create().texOffs(0, 304).addBox(-0.5F, -13.5F, -5.0F, 10.0F, 15.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 329).addBox(2.5F, 1.5F, -2.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 269).addBox(-5.5F, -13.5F, -10.0F, 15.0F, 20.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 13.5F, -0.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rightfinger1 = r_hand_blast_3.addOrReplaceChild("rightfinger1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 20.0F, -4.0F));

		PartDefinition r_hand_blast_2 = righthand.addOrReplaceChild("r_hand_blast_2", CubeListBuilder.create().texOffs(0, 269).addBox(-5.0F, 0.0F, -5.0F, 15.0F, 20.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(0, 329).addBox(3.0F, 15.0F, 3.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 304).addBox(0.0F, 0.0F, 0.0F, 10.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, 0.0F, -10.0F));

		PartDefinition rightfinger2 = r_hand_blast_2.addOrReplaceChild("rightfinger2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 20.0F, 2.0F));

		PartDefinition r_hand_blast_1 = righthand.addOrReplaceChild("r_hand_blast_1", CubeListBuilder.create().texOffs(0, 269).mirror().addBox(-10.0F, 0.0F, -5.0F, 15.0F, 20.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 329).mirror().addBox(-10.0F, 15.0F, 3.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 304).mirror().addBox(-10.0F, 0.0F, 0.0F, 10.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 0.0F, -10.0F));

		PartDefinition rightfinger3 = r_hand_blast_1.addOrReplaceChild("rightfinger3", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, 8.5F));

		PartDefinition rightfinger3_r1 = rightfinger3.addOrReplaceChild("rightfinger3_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -7.5F, -2.5F, 3.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 1.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition r_cannon = righthand.addOrReplaceChild("r_cannon", CubeListBuilder.create(), PartPose.offset(0.0F, 13.75F, 0.0F));

		PartDefinition lefthand_r9 = r_cannon.addOrReplaceChild("lefthand_r9", CubeListBuilder.create().texOffs(61, 294).addBox(-7.0F, 7.5F, -7.0F, 14.0F, 5.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(69, 331).addBox(-6.0F, 2.5F, -6.0F, 12.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.25F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition r_core = righthand.addOrReplaceChild("r_core", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, 0.0F));

		PartDefinition lefthand_r10 = r_core.addOrReplaceChild("lefthand_r10", CubeListBuilder.create().texOffs(0, 341).addBox(-4.0F, 6.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 357).addBox(-4.0F, 6.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition r_flame_1 = r_core.addOrReplaceChild("r_flame_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lefthand_r11 = r_flame_1.addOrReplaceChild("lefthand_r11", CubeListBuilder.create().texOffs(-16, 373).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.0663F, 1.0163F, 2.2196F));

		PartDefinition r_flame_2 = r_core.addOrReplaceChild("r_flame_2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lefthand_r12 = r_flame_2.addOrReplaceChild("lefthand_r12", CubeListBuilder.create().texOffs(-16, 373).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 1.1781F, -2.7489F));

		PartDefinition rightleg = roots.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 193).addBox(-19.0F, -2.0F, -7.5F, 24.0F, 29.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -27.0F, 0.0F, 0.0F, 0.0873F, 0.0F));

		PartDefinition leftleg = roots.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 193).mirror().addBox(-5.0F, -2.0F, -7.5F, 24.0F, 29.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.0F, -27.0F, 0.0F, 0.0F, -0.0873F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}



	@Override
	public void setupAnim(Netherite_Monstrosity_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {


		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateHeadLookTarget(netHeadYaw, headPitch);

		if(!(entity.getAttackState() == 8 && entity.attackTicks > 16 && entity.attackTicks < 47)) {
			this.animateWalk(Netherite_Monstrosity_Animation.WALK, limbSwing, limbSwingAmount, 2.0F, 2.0F);
		}


		this.animate(entity.getAnimationState("idle"), Netherite_Monstrosity_Animation.IDLE, ageInTicks, 1.0F);

		this.animate(entity.getAnimationState("smash"), Netherite_Monstrosity_Animation.SMASH, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("sleep"), Netherite_Monstrosity_Animation.SLEEP, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("awake"), Netherite_Monstrosity_Animation.AWAKE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("phase_two"), Netherite_Monstrosity_Animation.PHASE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("death"), Netherite_Monstrosity_Animation.DEATH, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("fire"), Netherite_Monstrosity_Animation.FIRE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("drain"), Netherite_Monstrosity_Animation.DRAIN, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("shoulder_check"), Netherite_Monstrosity_Animation.SHOULDER_CHECK, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("overpower"), Netherite_Monstrosity_Animation.OVERPOWER, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("flare_shot"), Netherite_Monstrosity_Animation.FLARE_SHOT, ageInTicks, 1.0F);
	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot = xRot * ((float) Math.PI / 180F);
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}

	public ModelPart root() {
		return this.root;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}