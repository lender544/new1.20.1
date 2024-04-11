package com.github.L_Ender.cataclysm.client.model.entity;

import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelPart;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

import static com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity.*;


public class ModelIgnis extends AdvancedEntityModel<Ignis_Entity> {
    private final AdvancedModelPart root;
    private final AdvancedModelPart upperbody;
    private final AdvancedModelPart right_chestplate;
    private final AdvancedModelPart left_chestplate;
    private final AdvancedModelPart right_plate;
    private final AdvancedModelPart left_plate;
    private final AdvancedModelPart head;
    private final AdvancedModelPart right_helmet;
    private final AdvancedModelPart left_helmet;
    private final AdvancedModelPart head_plate;
    private final AdvancedModelPart right_horn;
    private final AdvancedModelPart right_horn2;
    private final AdvancedModelPart right_horn3;
    private final AdvancedModelPart left_horn;
    private final AdvancedModelPart left_horn2;
    private final AdvancedModelPart left_horn3;
    private final AdvancedModelPart left_arm_joint;
    private final AdvancedModelPart left_arm;
    private final AdvancedModelPart left_fasteners3;
    private final AdvancedModelPart left_spike;
    private final AdvancedModelPart left_big_spike;
    private final AdvancedModelPart left_hand;
    private final AdvancedModelPart left_fasteners;
    private final AdvancedModelPart left_big_guantlet;
    private final AdvancedModelPart shield_root;
    private final AdvancedModelPart shield;
    private final AdvancedModelPart right;
    private final AdvancedModelPart left;
    private final AdvancedModelPart left_guantlet;
    private final AdvancedModelPart left_fist;
    private final AdvancedModelPart right_arm_joint;
    private final AdvancedModelPart right_arm;
    private final AdvancedModelPart right_fasteners;
    private final AdvancedModelPart right_spike;
    private final AdvancedModelPart right_big_spike;
    private final AdvancedModelPart right_hand;
    private final AdvancedModelPart right_fasteners2;
    private final AdvancedModelPart right_big_guantlet;
    private final AdvancedModelPart right_guantlet;
    private final AdvancedModelPart right_fist;
    private final AdvancedModelPart sword;
    private final AdvancedModelPart blade;
    public final AdvancedModelPart blade2;
    private final AdvancedModelPart blade_mid;
    private final AdvancedModelPart handle_core;
    private final AdvancedModelPart core;
    private final AdvancedModelPart upper_guard;
    private final AdvancedModelPart lower_guard;
    private final AdvancedModelPart bodycore;
    private final AdvancedModelPart lowerbody;
    private final AdvancedModelPart right_thighplate;
    private final AdvancedModelPart left_thighplate;
    private final AdvancedModelPart lowerbody2;
    private ModelAnimator animator;

    public ModelIgnis() {
        texWidth = 256;
        texHeight = 256;

        root = new AdvancedModelPart(this);
        root.setRotationPoint(0.0F, 19.0F, 0.0F);


        upperbody = new AdvancedModelPart(this);
        upperbody.setRotationPoint(0.0F, -24.5F, 1.0F);
        root.addChild(upperbody);
        setRotationAngle(upperbody, 0.3491F, 0.0F, 0.0F);
        upperbody.setTextureOffset(94, 0).addBox(-10.0F, -13.0F, -7.5F, 20.0F, 13.0F, 15.0F, 0.0F, false);
        upperbody.setTextureOffset(47, 72).addBox(-13.0F, -17.0F, -3.5F, 3.0F, 13.0F, 11.0F, 0.0F, false);
        upperbody.setTextureOffset(47, 72).addBox(10.0F, -17.0F, -3.5F, 3.0F, 13.0F, 11.0F, 0.0F, true);

        right_chestplate = new AdvancedModelPart(this);
        right_chestplate.setRotationPoint(-6.8F, -6.5F, -4.5F);
        upperbody.addChild(right_chestplate);
        setRotationAngle(right_chestplate, 0.0F, 0.3054F, 0.0F);
        right_chestplate.setTextureOffset(133, 84).addBox(-4.5F, -6.5F, -5.0F, 11.0F, 13.0F, 10.0F, 0.5F, false);

        left_chestplate = new AdvancedModelPart(this);
        left_chestplate.setRotationPoint(6.8F, -6.5F, -4.5F);
        upperbody.addChild(left_chestplate);
        setRotationAngle(left_chestplate, 0.0F, -0.3054F, 0.0F);
        left_chestplate.setTextureOffset(133, 84).addBox(-6.5F, -6.5F, -5.0F, 11.0F, 13.0F, 10.0F, 0.5F, true);

        right_plate = new AdvancedModelPart(this);
        right_plate.setRotationPoint(-5.3F, -12.9F, 8.0F);
        upperbody.addChild(right_plate);
        setRotationAngle(right_plate, 0.0F, -0.3054F, 0.0F);
        right_plate.setTextureOffset(47, 0).addBox(-5.0F, -2.0F, -15.0F, 5.0F, 4.0F, 15.0F, 0.0F, false);

        left_plate = new AdvancedModelPart(this);
        left_plate.setRotationPoint(5.3F, -12.9F, 8.0F);
        upperbody.addChild(left_plate);
        setRotationAngle(left_plate, 0.0F, 0.3054F, 0.0F);
        left_plate.setTextureOffset(47, 0).addBox(0.0F, -2.0F, -15.0F, 5.0F, 4.0F, 15.0F, 0.0F, true);

        head = new AdvancedModelPart(this);
        head.setRotationPoint(0.0F, -14.0F, 2.0F);
        upperbody.addChild(head);
        setRotationAngle(head, -0.3491F, 0.0F, 0.0F);
        head.setTextureOffset(133, 108).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 9.0F, 8.0F, 0.5F, false);
        head.setTextureOffset(135, 136).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        right_helmet = new AdvancedModelPart(this);
        right_helmet.setRotationPoint(-4.5F, -3.0F, -4.5F);
        head.addChild(right_helmet);
        setRotationAngle(right_helmet, 0.0F, -0.829F, 0.0F);
        right_helmet.setTextureOffset(47, 0).addBox(0.0F, -0.5F, -4.0F, 0.0F, 5.0F, 7.0F, 0.0F, false);

        left_helmet = new AdvancedModelPart(this);
        left_helmet.setRotationPoint(4.5F, -3.0F, -4.5F);
        head.addChild(left_helmet);
        setRotationAngle(left_helmet, 0.0F, 0.829F, 0.0F);
        left_helmet.setTextureOffset(47, 0).addBox(0.0F, -0.5F, -4.0F, 0.0F, 5.0F, 7.0F, 0.0F, true);

        head_plate = new AdvancedModelPart(this);
        head_plate.setRotationPoint(0.0F, -7.0F, -4.0F);
        head.addChild(head_plate);
        setRotationAngle(head_plate, -0.2618F, 0.0F, 0.0F);
        head_plate.setTextureOffset(90, 77).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

        right_horn = new AdvancedModelPart(this);
        right_horn.setRotationPoint(-3.5F, -7.5F, -3.5F);
        head.addChild(right_horn);
        setRotationAngle(right_horn, 0.3927F, 0.2182F, -0.1309F);
        right_horn.setTextureOffset(47, 20).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        right_horn2 = new AdvancedModelPart(this);
        right_horn2.setRotationPoint(0.0F, -5.0F, -1.0F);
        right_horn.addChild(right_horn2);
        setRotationAngle(right_horn2, -1.3526F, 0.0F, 0.0F);
        right_horn2.setTextureOffset(32, 68).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);

        right_horn3 = new AdvancedModelPart(this);
        right_horn3.setRotationPoint(0.0F, -6.99F, 1.99F);
        right_horn2.addChild(right_horn3);
        setRotationAngle(right_horn3, -0.5236F, 0.0F, 0.0F);
        right_horn3.setTextureOffset(31, 35).addBox(-0.5F, -0.01F, -3.99F, 1.0F, 1.0F, 4.0F, -0.01F, false);

        left_horn = new AdvancedModelPart(this);
        left_horn.setRotationPoint(3.5F, -7.5F, -3.5F);
        head.addChild(left_horn);
        setRotationAngle(left_horn, 0.3927F, -0.2182F, 0.1309F);
        left_horn.setTextureOffset(47, 20).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);

        left_horn2 = new AdvancedModelPart(this);
        left_horn2.setRotationPoint(0.0F, -5.0F, -1.0F);
        left_horn.addChild(left_horn2);
        setRotationAngle(left_horn2, -1.3526F, 0.0F, 0.0F);
        left_horn2.setTextureOffset(32, 68).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 7.0F, 2.0F, 0.0F, true);

        left_horn3 = new AdvancedModelPart(this);
        left_horn3.setRotationPoint(0.0F, -6.99F, 1.99F);
        left_horn2.addChild(left_horn3);
        setRotationAngle(left_horn3, -0.5236F, 0.0F, 0.0F);
        left_horn3.setTextureOffset(31, 35).addBox(-0.5F, -0.01F, -3.99F, 1.0F, 1.0F, 4.0F, -0.01F, true);

        left_arm_joint = new AdvancedModelPart(this);
        left_arm_joint.setRotationPoint(15.8F, -14.0F, 3.0F);
        upperbody.addChild(left_arm_joint);
        setRotationAngle(left_arm_joint, -0.3491F, 0.0F, 0.0F);


        left_arm = new AdvancedModelPart(this);
        left_arm.setRotationPoint(0.0F, 0.0F, 0.0F);
        left_arm_joint.addChild(left_arm);
        setRotationAngle(left_arm, 0.0F, 0.0F, -0.2618F);
        left_arm.setTextureOffset(0, 23).addBox(7.0F, 6.5F, -6.0F, 5.0F, 3.0F, 12.0F, 0.5F, true);
        left_arm.setTextureOffset(47, 20).addBox(5.0F, 5.5F, -6.0F, 7.0F, 8.0F, 12.0F, 0.0F, true);
        left_arm.setTextureOffset(53, 128).addBox(0.0F, -5.5F, -6.0F, 12.0F, 11.0F, 12.0F, 0.5F, true);
        left_arm.setTextureOffset(124, 60).addBox(0.0F, -5.5F, -6.0F, 12.0F, 11.0F, 12.0F, 0.0F, true);

        left_fasteners3 = new AdvancedModelPart(this);
        left_fasteners3.setRotationPoint(4.5F, 6.0F, -7.0F);
        left_arm.addChild(left_fasteners3);
        setRotationAngle(left_fasteners3, 0.0F, 0.0F, -0.7854F);
        left_fasteners3.setTextureOffset(0, 85).addBox(-2.5F, -2.5F, -0.75F, 5.0F, 5.0F, 2.0F, 0.0F, true);
        left_fasteners3.setTextureOffset(74, 20).addBox(-2.5F, -2.5F, 12.75F, 5.0F, 5.0F, 2.0F, 0.0F, true);

        left_spike = new AdvancedModelPart(this);
        left_spike.setRotationPoint(11.9F, 2.4F, 0.0F);
        left_arm.addChild(left_spike);
        setRotationAngle(left_spike, 0.0F, 0.0F, 1.3526F);
        left_spike.setTextureOffset(0, 57).addBox(-2.0F, -7.0F, 0.0F, 4.0F, 7.0F, 0.0F, 0.0F, true);

        left_big_spike = new AdvancedModelPart(this);
        left_big_spike.setRotationPoint(9.5F, -2.8F, 0.0F);
        left_arm.addChild(left_big_spike);
        setRotationAngle(left_big_spike, 0.0F, 0.0F, 0.6109F);
        left_big_spike.setTextureOffset(76, 83).addBox(-3.0F, -13.0F, 0.0F, 6.0F, 13.0F, 0.0F, 0.0F, true);

        left_hand = new AdvancedModelPart(this);
        left_hand.setRotationPoint(8.2F, 18.4F, 0.0F);
        left_arm.addChild(left_hand);
        setRotationAngle(left_hand, 0.0F, 0.0F, 0.2618F);
        left_hand.setTextureOffset(83, 153).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 8.0F, 7.0F, 0.0F, true);

        left_fasteners = new AdvancedModelPart(this);
        left_fasteners.setRotationPoint(1.1966F, 11.2224F, -6.0F);
        left_hand.addChild(left_fasteners);
        setRotationAngle(left_fasteners, 0.0F, 0.0F, 0.7854F);
        left_fasteners.setTextureOffset(94, 48).addBox(-7.5F, -4.5F, 9.0F, 4.0F, 4.0F, 2.0F, 0.0F, true);
        left_fasteners.setTextureOffset(94, 8).addBox(-7.5F, -4.5F, 1.0F, 4.0F, 4.0F, 2.0F, 0.0F, true);

        left_big_guantlet = new AdvancedModelPart(this);
        left_big_guantlet.setRotationPoint(2.0F, 12.0F, 0.0F);
        left_hand.addChild(left_big_guantlet);
        setRotationAngle(left_big_guantlet, 0.0F, 0.0F, 0.3054F);
        left_big_guantlet.setTextureOffset(0, 151).addBox(-3.5F, -13.0F, -4.0F, 5.0F, 13.0F, 8.0F, 0.5F, true);

        shield_root = new AdvancedModelPart(this);
        shield_root.setRotationPoint(2.0F, -6.0F, 0.0F);
        left_big_guantlet.addChild(shield_root);
        shield_root.setTextureOffset(112, 153).addBox(0.0F, -4.0F, -4.0F, 4.0F, 8.0F, 8.0F, 0.0F, false);

        shield = new AdvancedModelPart(this);
        shield.setRotationPoint(0.0F, 0.0F, -3.0F);
        shield_root.addChild(shield);
        shield.setTextureOffset(0, 57).addBox(1.0F, -7.0F, -18.0F, 2.0F, 14.0F, 42.0F, 0.0F, false);
        shield.setTextureOffset(90, 72).addBox(0.0F, -8.0F, -29.0F, 4.0F, 16.0F, 11.0F, 0.0F, false);
        shield.setTextureOffset(0, 57).addBox(0.0F, -8.0F, 22.0F, 4.0F, 16.0F, 11.0F, 0.0F, false);

        right = new AdvancedModelPart(this);
        right.setRotationPoint(0.0F, -11.0F, 3.5F);
        shield.addChild(right);
        setRotationAngle(right, -0.0865F, -0.0114F, -0.1304F);
        right.setTextureOffset(27, 151).addBox(-2.0F, -8.0F, -29.5F, 4.0F, 14.0F, 8.0F, 0.0F, false);
        right.setTextureOffset(27, 151).addBox(-2.0F, -8.0F, 20.5F, 4.0F, 14.0F, 8.0F, 0.0F, false);
        right.setTextureOffset(0, 0).addBox(-1.0F, -7.0F, -21.5F, 2.0F, 14.0F, 42.0F, 0.0F, false);

        left = new AdvancedModelPart(this);
        left.setRotationPoint(0.0F, 11.0F, 3.5F);
        shield.addChild(left);
        setRotationAngle(left, 0.0865F, -0.0114F, 0.1304F);
        left.setTextureOffset(27, 151).addBox(-2.0F, -6.0F, -29.5F, 4.0F, 14.0F, 8.0F, 0.0F, false);
        left.setTextureOffset(27, 151).addBox(-2.0F, -6.0F, 20.5F, 4.0F, 14.0F, 8.0F, 0.0F, false);
        left.setTextureOffset(47, 15).addBox(-1.0F, -7.0F, -21.5F, 2.0F, 14.0F, 42.0F, 0.0F, false);

        left_guantlet = new AdvancedModelPart(this);
        left_guantlet.setRotationPoint(-1.0F, 3.0F, 0.0F);
        left_hand.addChild(left_guantlet);
        setRotationAngle(left_guantlet, 0.0F, 0.0F, 0.2182F);
        left_guantlet.setTextureOffset(151, 29).addBox(0.5F, -12.0F, -3.5F, 4.0F, 16.0F, 7.0F, 0.5F, true);

        left_fist = new AdvancedModelPart(this);
        left_fist.setRotationPoint(-1.5F, 8.0F, 0.0F);
        left_hand.addChild(left_fist);
        left_fist.setTextureOffset(102, 136).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);

        right_arm_joint = new AdvancedModelPart(this);
        right_arm_joint.setRotationPoint(-15.8F, -14.0F, 3.0F);
        upperbody.addChild(right_arm_joint);
        setRotationAngle(right_arm_joint, -0.3491F, 0.0F, 0.0F);


        right_arm = new AdvancedModelPart(this);
        right_arm.setRotationPoint(0.0F, 0.0F, 0.0F);
        right_arm_joint.addChild(right_arm);
        setRotationAngle(right_arm, 0.0F, 0.0F, 0.2618F);
        right_arm.setTextureOffset(0, 23).addBox(-12.0F, 6.5F, -6.0F, 5.0F, 3.0F, 12.0F, 0.5F, false);
        right_arm.setTextureOffset(47, 20).addBox(-12.0F, 5.5F, -6.0F, 7.0F, 8.0F, 12.0F, 0.0F, false);
        right_arm.setTextureOffset(53, 128).addBox(-12.0F, -5.5F, -6.0F, 12.0F, 11.0F, 12.0F, 0.5F, false);
        right_arm.setTextureOffset(124, 60).addBox(-12.0F, -5.5F, -6.0F, 12.0F, 11.0F, 12.0F, 0.0F, false);

        right_fasteners = new AdvancedModelPart(this);
        right_fasteners.setRotationPoint(-4.5F, 6.0F, -7.0F);
        right_arm.addChild(right_fasteners);
        setRotationAngle(right_fasteners, 0.0F, 0.0F, 0.7854F);
        right_fasteners.setTextureOffset(0, 85).addBox(-2.5F, -2.5F, -0.75F, 5.0F, 5.0F, 2.0F, 0.0F, false);
        right_fasteners.setTextureOffset(74, 20).addBox(-2.5F, -2.5F, 12.75F, 5.0F, 5.0F, 2.0F, 0.0F, false);

        right_spike = new AdvancedModelPart(this);
        right_spike.setRotationPoint(-11.9F, 2.4F, 0.0F);
        right_arm.addChild(right_spike);
        setRotationAngle(right_spike, 0.0F, 0.0F, -1.3526F);
        right_spike.setTextureOffset(0, 57).addBox(-2.0F, -7.0F, 0.0F, 4.0F, 7.0F, 0.0F, 0.0F, false);

        right_big_spike = new AdvancedModelPart(this);
        right_big_spike.setRotationPoint(-9.5F, -2.8F, 0.0F);
        right_arm.addChild(right_big_spike);
        setRotationAngle(right_big_spike, 0.0F, 0.0F, -0.6109F);
        right_big_spike.setTextureOffset(76, 83).addBox(-3.0F, -13.0F, 0.0F, 6.0F, 13.0F, 0.0F, 0.0F, false);

        right_hand = new AdvancedModelPart(this);
        right_hand.setRotationPoint(-8.2F, 18.4F, 0.0F);
        right_arm.addChild(right_hand);
        setRotationAngle(right_hand, 0.0F, 0.0F, -0.2618F);
        right_hand.setTextureOffset(83, 153).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 8.0F, 7.0F, 0.0F, false);

        right_fasteners2 = new AdvancedModelPart(this);
        right_fasteners2.setRotationPoint(-1.1966F, 11.2224F, -6.0F);
        right_hand.addChild(right_fasteners2);
        setRotationAngle(right_fasteners2, 0.0F, 0.0F, -0.7854F);
        right_fasteners2.setTextureOffset(94, 48).addBox(3.5F, -4.5F, 9.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
        right_fasteners2.setTextureOffset(94, 8).addBox(3.5F, -4.5F, 1.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);

        right_big_guantlet = new AdvancedModelPart(this);
        right_big_guantlet.setRotationPoint(-2.0F, 12.0F, 0.0F);
        right_hand.addChild(right_big_guantlet);
        setRotationAngle(right_big_guantlet, 0.0F, 0.0F, -0.3054F);
        right_big_guantlet.setTextureOffset(0, 151).addBox(-1.5F, -13.0F, -4.0F, 5.0F, 13.0F, 8.0F, 0.5F, false);

        right_guantlet = new AdvancedModelPart(this);
        right_guantlet.setRotationPoint(1.0F, 3.0F, 0.0F);
        right_hand.addChild(right_guantlet);
        setRotationAngle(right_guantlet, 0.0F, 0.0F, -0.2182F);
        right_guantlet.setTextureOffset(151, 29).addBox(-4.5F, -12.0F, -3.5F, 4.0F, 16.0F, 7.0F, 0.5F, false);

        right_fist = new AdvancedModelPart(this);
        right_fist.setRotationPoint(1.5F, 8.0F, 0.0F);
        right_hand.addChild(right_fist);
        right_fist.setTextureOffset(102, 136).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        sword = new AdvancedModelPart(this);
        sword.setRotationPoint(1.5F, 4.5F, 0.0F);
        right_fist.addChild(sword);
        sword.setTextureOffset(52, 152).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 12.0F, 0.0F, false);
        sword.setTextureOffset(94, 0).addBox(-2.5F, -2.5F, 6.0F, 5.0F, 5.0F, 2.0F, 0.0F, false);
        sword.setTextureOffset(49, 74).addBox(0.0F, -6.5F, -49.0F, 0.0F, 13.0F, 40.0F, 0.0F, false);
        sword.setTextureOffset(90, 88).addBox(-0.5F, -3.5F, -49.0F, 1.0F, 7.0F, 40.0F, 0.0F, false);

        blade = new AdvancedModelPart(this);
        blade.setRotationPoint(0.0F, 0.0F, -49.0F);
        sword.addChild(blade);
        setRotationAngle(blade, 0.7854F, 0.0F, 0.0F);
        blade.setTextureOffset(27, 0).addBox(-0.5F, -2.5F, -2.5F, 1.0F, 5.0F, 5.0F, -0.01F, false);

        blade2 = new AdvancedModelPart(this);
        blade2.setRotationPoint(0.0F, 0.0F, -49.0F);
        sword.addChild(blade2);
        setRotationAngle(blade2, 0.7854F, 0.0F, 0.0F);
        blade2.setTextureOffset(22, 76).addBox(0.0F, -4.5F, -4.5F, 0.0F, 9.0F, 9.0F, 0.0F, false);

        blade_mid = new AdvancedModelPart(this);
        blade_mid.setRotationPoint(0.0F, 0.0F, -8.8F);
        sword.addChild(blade_mid);
        setRotationAngle(blade_mid, 0.7854F, 0.0F, 0.0F);
        blade_mid.setTextureOffset(23, 23).addBox(-1.5F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, 0.5F, false);
        blade_mid.setTextureOffset(35, 0).addBox(-1.0F, 2.5F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);
        blade_mid.setTextureOffset(90, 72).addBox(-1.0F, -0.5F, 2.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        handle_core = new AdvancedModelPart(this);
        handle_core.setRotationPoint(0.0F, 0.0F, 12.5F);
        sword.addChild(handle_core);
        setRotationAngle(handle_core, 0.6284F, -0.4422F, -1.2329F);
        handle_core.setTextureOffset(73, 0).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, 0.7F, false);

        core = new AdvancedModelPart(this);
        core.setRotationPoint(0.0F, 0.0F, 12.5F);
        sword.addChild(core);
        setRotationAngle(core, 0.37F, -0.4404F, -0.7382F);
        core.setTextureOffset(65, 72).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);

        upper_guard = new AdvancedModelPart(this);
        upper_guard.setRotationPoint(0.0F, -1.9F, -8.5F);
        sword.addChild(upper_guard);
        setRotationAngle(upper_guard, -0.1745F, 0.0F, 0.0F);
        upper_guard.setTextureOffset(0, 93).addBox(-1.0F, -5.0F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
        upper_guard.setTextureOffset(32, 78).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
        upper_guard.setTextureOffset(55, 0).addBox(-0.5F, -6.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        upper_guard.setTextureOffset(95, 100).addBox(-0.5F, -8.0F, -2.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        upper_guard.setTextureOffset(7, 23).addBox(-0.5F, -9.0F, -3.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
        upper_guard.setTextureOffset(90, 100).addBox(-0.5F, -11.0F, -6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        upper_guard.setTextureOffset(27, 0).addBox(-0.5F, -11.0F, -7.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        upper_guard.setTextureOffset(0, 23).addBox(-0.5F, -11.0F, -5.0F, 1.0F, 9.0F, 2.0F, 0.0F, false);

        lower_guard = new AdvancedModelPart(this);
        lower_guard.setRotationPoint(0.0F, 1.9F, -8.5F);
        sword.addChild(lower_guard);
        setRotationAngle(lower_guard, 0.1745F, 0.0F, 0.0F);
        lower_guard.setTextureOffset(11, 91).addBox(-1.0F, 4.0F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
        lower_guard.setTextureOffset(47, 72).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
        lower_guard.setTextureOffset(47, 0).addBox(-0.5F, 2.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        lower_guard.setTextureOffset(99, 29).addBox(-0.5F, 2.0F, -2.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        lower_guard.setTextureOffset(7, 0).addBox(-0.5F, 2.0F, -3.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
        lower_guard.setTextureOffset(94, 29).addBox(-0.5F, 5.0F, -6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        lower_guard.setTextureOffset(23, 23).addBox(-0.5F, 9.0F, -7.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        lower_guard.setTextureOffset(0, 0).addBox(-0.5F, 2.0F, -5.0F, 1.0F, 9.0F, 2.0F, 0.0F, false);

        bodycore = new AdvancedModelPart(this);
        bodycore.setRotationPoint(0.0F, 0.0F, 0.0F);
        upperbody.addChild(bodycore);
        setRotationAngle(bodycore, -0.3491F, 0.0F, 0.0F);
        bodycore.setTextureOffset(20, 57).addBox(-4.0F, -11.5F, -12.0F, 8.0F, 8.0F, 2.0F, 0.0F, false);

        lowerbody = new AdvancedModelPart(this);
        lowerbody.setRotationPoint(0.0F, -27.0F, 1.0F);
        root.addChild(lowerbody);
        lowerbody.setTextureOffset(94, 29).addBox(-8.0F, 0.0F, -6.0F, 16.0F, 6.0F, 12.0F, 0.0F, false);

        right_thighplate = new AdvancedModelPart(this);
        right_thighplate.setRotationPoint(-5.7F, 10.3F, -1.0F);
        lowerbody.addChild(right_thighplate);
        setRotationAngle(right_thighplate, 0.0F, 0.0F, 0.3054F);
        right_thighplate.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, -5.0F, 7.0F, 10.0F, 12.0F, 0.5F, false);

        left_thighplate = new AdvancedModelPart(this);
        left_thighplate.setRotationPoint(5.7F, 10.3F, -1.0F);
        lowerbody.addChild(left_thighplate);
        setRotationAngle(left_thighplate, 0.0F, 0.0F, -0.3054F);
        left_thighplate.setTextureOffset(0, 0).addBox(-3.0F, -5.0F, -5.0F, 7.0F, 10.0F, 12.0F, 0.5F, true);

        lowerbody2 = new AdvancedModelPart(this);
        lowerbody2.setRotationPoint(0.0F, 5.0F, -5.0F);
        lowerbody.addChild(lowerbody2);
        lowerbody2.setTextureOffset(0, 118).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 22.0F, 10.0F, 0.0F, false);

        animator = ModelAnimator.create();
        this.updateDefaultPose();

    }

    public void animate(Ignis_Entity entity, float f, float f1, float f2, float f3, float f4) {
        this.resetToDefaultPose();
        animator.update(entity);
        animator.setAnimation(SWING_ATTACK);
        if (!entity.getIsShieldBreak()) {
            animator.startKeyframe(12);
            animator.rotate(root, 0, (float) Math.toRadians(7.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-12.5F), (float) Math.toRadians(25F), (float) Math.toRadians(7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-147.5F), 0, (float) Math.toRadians(15F));
            animator.rotate(right_arm, 0, (float) Math.toRadians(30F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-15F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(-42.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(-5F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(17.5F), (float) Math.toRadians(-50F), (float) Math.toRadians(-15F));
            animator.rotate(left_arm, 0, (float) Math.toRadians(2.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(2.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(8);

            animator.startKeyframe(5);
            animator.rotate(root, 0, (float) Math.toRadians(-65F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(2.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-30F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-35F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(27.5F));
            animator.rotate(right_arm, 0, 0, (float) Math.toRadians(5F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(98.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, (float) Math.toRadians(2.5F), (float) Math.toRadians(-15F), 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(70F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(60F), (float) Math.toRadians(-5F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm, 0, 0, (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(-25F), (float) Math.toRadians(-10F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);
            animator.resetKeyframe(15);
        } else {
            animator.startKeyframe(12);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(17.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-142.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(5F));
            animator.rotate(right_arm, 0, (float) Math.toRadians(30F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-45F), 0, 0);
            animator.rotate(head, 0, 0, (float) Math.toRadians(-10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-40F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(-30F));
            animator.rotate(left_arm, 0, (float) Math.toRadians(2.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, 0, (float) Math.toRadians(17.5F), (float) Math.toRadians(32.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(8);

            animator.startKeyframe(5);
            animator.rotate(root, 0, (float) Math.toRadians(-72.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-20F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(17.5F));
            animator.rotate(right_arm, 0, 0, (float) Math.toRadians(5F));
            animator.rotate(right_hand, (float) Math.toRadians(45F), (float) Math.toRadians(98.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, 0, (float) Math.toRadians(-15F), 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(70F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(2.5F), (float) Math.toRadians(42.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm, 0, 0, (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(27.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(20F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);
            animator.resetKeyframe(15);
        }

        animator.setAnimation(SWING_ATTACK_SOUL);
        if (!entity.getIsShieldBreak()) {
            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(7.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-12.5F), (float) Math.toRadians(25F), (float) Math.toRadians(7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-147.5F), 0, (float) Math.toRadians(15F));
            animator.rotate(right_arm, 0, (float) Math.toRadians(30F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-15F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(-42.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(-5F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(17.5F), (float) Math.toRadians(-50F), (float) Math.toRadians(-15F));
            animator.rotate(left_arm, 0, (float) Math.toRadians(2.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(2.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(6);

            animator.startKeyframe(3);
            animator.rotate(root, 0, (float) Math.toRadians(-65F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(2.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-30F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-35F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(27.5F));
            animator.rotate(right_arm, 0, 0, (float) Math.toRadians(5F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(98.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, (float) Math.toRadians(2.5F), (float) Math.toRadians(-15F), 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(70F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(60F), (float) Math.toRadians(-5F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm, 0, 0, (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(-25F), (float) Math.toRadians(-10F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);
            animator.resetKeyframe(12);
        } else {
            animator.startKeyframe(10);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(17.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-142.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(5F));
            animator.rotate(right_arm, 0, (float) Math.toRadians(30F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-45F), 0, 0);
            animator.rotate(head, 0, 0, (float) Math.toRadians(-10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-40F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(-30F));
            animator.rotate(left_arm, 0, (float) Math.toRadians(2.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, 0, (float) Math.toRadians(17.5F), (float) Math.toRadians(32.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(6);

            animator.startKeyframe(3);
            animator.rotate(root, 0, (float) Math.toRadians(-72.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-20F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(17.5F));
            animator.rotate(right_arm, 0, 0, (float) Math.toRadians(5F));
            animator.rotate(right_hand, (float) Math.toRadians(45F), (float) Math.toRadians(98.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, 0, (float) Math.toRadians(-15F), 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(70F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(2.5F), (float) Math.toRadians(42.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm, 0, 0, (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(27.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(20F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);
            animator.resetKeyframe(12);
        }

        animator.setAnimation(SWING_ATTACK_BERSERK);
        if (!entity.getIsShieldBreak()) {
            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(7.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-12.5F), (float) Math.toRadians(25F), (float) Math.toRadians(7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-147.5F), 0, (float) Math.toRadians(15F));
            animator.rotate(right_arm, 0, (float) Math.toRadians(30F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-15F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(-42.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(-5F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(17.5F), (float) Math.toRadians(-50F), (float) Math.toRadians(-15F));
            animator.rotate(left_arm, 0, (float) Math.toRadians(2.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(2.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(5);

            animator.startKeyframe(2);
            animator.rotate(root, 0, (float) Math.toRadians(-65F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(2.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-30F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-35F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(27.5F));
            animator.rotate(right_arm, 0, 0, (float) Math.toRadians(5F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(98.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, (float) Math.toRadians(2.5F), (float) Math.toRadians(-15F), 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(70F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(60F), (float) Math.toRadians(-5F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm, 0, 0, (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(-25F), (float) Math.toRadians(-10F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);
            animator.resetKeyframe(10);
        } else {
            animator.startKeyframe(10);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(17.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-142.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(5F));
            animator.rotate(right_arm, 0, (float) Math.toRadians(30F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-45F), 0, 0);
            animator.rotate(head, 0, 0, (float) Math.toRadians(-10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-40F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(-30F));
            animator.rotate(left_arm, 0, (float) Math.toRadians(2.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, 0, (float) Math.toRadians(17.5F), (float) Math.toRadians(32.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(5);

            animator.startKeyframe(2);
            animator.rotate(root, 0, (float) Math.toRadians(-72.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-20F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(17.5F));
            animator.rotate(right_arm, 0, 0, (float) Math.toRadians(5F));
            animator.rotate(right_hand, (float) Math.toRadians(45F), (float) Math.toRadians(98.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, 0, (float) Math.toRadians(-15F), 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(70F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(2.5F), (float) Math.toRadians(42.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm, 0, 0, (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(27.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(20F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);
            animator.resetKeyframe(10);
        }

        animator.setAnimation(Ignis_Entity.HORIZONTAL_SWING_ATTACK);
        if (!entity.getIsShieldBreak()) {
            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-55F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(-62.5F), (float) Math.toRadians(-15F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(37.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-15F), (float) Math.toRadians(5F), (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(-15F), 0, 0);
            animator.rotate(head, 0, (float) Math.toRadians(75F), (float) Math.toRadians(-10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(90F), (float) Math.toRadians(-10F), (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(-5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(12);

            animator.startKeyframe(6);
            animator.rotate(root, 0, (float) Math.toRadians(7.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(30F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(12.5F), (float) Math.toRadians(-5F), (float) Math.toRadians(47.5F));
            animator.rotate(right_hand, (float) Math.toRadians(20F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(70F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(10F), (float) Math.toRadians(-25F), (float) Math.toRadians(7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(22.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(47.5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(7.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);
            animator.resetKeyframe(20);
        } else {
            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-62.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(-65F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-25F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(27.5F));
            animator.rotate(right_hand, 0, (float) Math.toRadians(5F), (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(-17.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(80F), (float) Math.toRadians(-20F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(32.5F), (float) Math.toRadians(37.5F), (float) Math.toRadians(-35F));
            animator.rotate(left_hand, (float) Math.toRadians(52.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(25F));
            animator.endKeyframe();
            animator.setStaticKeyframe(12);

            animator.startKeyframe(6);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(27.5F), (float) Math.toRadians(10));
            animator.rotate(right_arm_joint, (float) Math.toRadians(15F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(37.5F));
            animator.rotate(right_hand, (float) Math.toRadians(35F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(67.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-35F), (float) Math.toRadians(37.5F), (float) Math.toRadians(-35F));
            animator.rotate(left_hand, (float) Math.toRadians(95F), (float) Math.toRadians(7.5F), (float) Math.toRadians(37.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);
            animator.resetKeyframe(20);
        }

        animator.setAnimation(Ignis_Entity.HORIZONTAL_SWING_ATTACK_SOUL);
        if (!entity.getIsShieldBreak()) {
            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-55F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(-62.5F), (float) Math.toRadians(-15F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(37.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-15F), (float) Math.toRadians(5F), (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(-15F), 0, 0);
            animator.rotate(head, 0, (float) Math.toRadians(75F), (float) Math.toRadians(-10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(90F), (float) Math.toRadians(-10F), (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(-5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(3);
            animator.rotate(root, 0, (float) Math.toRadians(7.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(30F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(12.5F), (float) Math.toRadians(-5F), (float) Math.toRadians(47.5F));
            animator.rotate(right_hand, (float) Math.toRadians(20F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(70F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(10F), (float) Math.toRadians(-25F), (float) Math.toRadians(7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(22.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(47.5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(7.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);
            animator.resetKeyframe(15);
        } else {
            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-62.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(-65F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-25F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(27.5F));
            animator.rotate(right_hand, 0, (float) Math.toRadians(5F), (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(-17.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(80F), (float) Math.toRadians(-20F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(32.5F), (float) Math.toRadians(37.5F), (float) Math.toRadians(-35F));
            animator.rotate(left_hand, (float) Math.toRadians(52.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(25F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(3);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(27.5F), (float) Math.toRadians(10));
            animator.rotate(right_arm_joint, (float) Math.toRadians(15F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(37.5F));
            animator.rotate(right_hand, (float) Math.toRadians(35F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(67.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-35F), (float) Math.toRadians(37.5F), (float) Math.toRadians(-35F));
            animator.rotate(left_hand, (float) Math.toRadians(95F), (float) Math.toRadians(7.5F), (float) Math.toRadians(37.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);
            animator.resetKeyframe(15);
        }

        animator.setAnimation(Ignis_Entity.HORIZONTAL_SMALL_SWING_ATTACK);
        if (!entity.getIsShieldBreak()) {
            animator.startKeyframe(12);
            animator.rotate(root, 0, (float) Math.toRadians(-72.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(-35F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-60F), (float) Math.toRadians(17.5F), (float) Math.toRadians(30F));
            animator.rotate(right_hand, (float) Math.toRadians(-52.5F), (float) Math.toRadians(-50F), (float) Math.toRadians(25F));
            animator.rotate(right_fist, (float) Math.toRadians(20F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(62.5F), (float) Math.toRadians(-15F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(40F), (float) Math.toRadians(-45F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-22.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(6);

            animator.startKeyframe(2);
            animator.rotate(root, 0, (float) Math.toRadians(-27.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-57.5F), (float) Math.toRadians(92.5F), (float) Math.toRadians(10F));
            animator.rotate(right_hand, (float) Math.toRadians(20F), (float) Math.toRadians(-25F), (float) Math.toRadians(5F));
            animator.rotate(right_fist, (float) Math.toRadians(37.5F), (float) Math.toRadians(-45F), 0);
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(42.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(-52.5F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-22.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(12);
            animator.resetKeyframe(12);
        } else {
            animator.startKeyframe(12);
            animator.rotate(root, 0, (float) Math.toRadians(-80F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(-37.5F), (float) Math.toRadians(7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-57.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(20F));
            animator.rotate(right_hand, (float) Math.toRadians(-42.5F), (float) Math.toRadians(-50F), (float) Math.toRadians(25F));
            animator.rotate(right_fist, (float) Math.toRadians(17.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(67.5F), (float) Math.toRadians(-25F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-17.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(25F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(6);

            animator.startKeyframe(2);
            animator.rotate(root, 0, (float) Math.toRadians(-35F), 0);
            animator.rotate(upperbody, 0, (float) Math.toRadians(-10F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(95F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(-25F), (float) Math.toRadians(5F));
            animator.rotate(right_fist, (float) Math.toRadians(35F), (float) Math.toRadians(-45F), 0);
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(47.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-22.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(25F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(12);
            animator.resetKeyframe(12);
        }

        animator.setAnimation(Ignis_Entity.HORIZONTAL_SMALL_SWING_ALT_ATTACK2);
        if (!entity.getIsShieldBreak()) {
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(-27.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-57.5F), (float) Math.toRadians(92.5F), (float) Math.toRadians(10F));
            animator.rotate(right_hand, (float) Math.toRadians(20F), (float) Math.toRadians(-25F), (float) Math.toRadians(5F));
            animator.rotate(right_fist, (float) Math.toRadians(37.5F), (float) Math.toRadians(-45F), 0);
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(62.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(-52.5F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-22.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.startKeyframe(6);
            animator.rotate(root, 0, (float) Math.toRadians(5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(2.5F), (float) Math.toRadians(-5F), (float) Math.toRadians(-10F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-30F), (float) Math.toRadians(97.5F), (float) Math.toRadians(5F));
            animator.rotate(right_hand, (float) Math.toRadians(-82.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(42.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(5F), (float) Math.toRadians(12.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(17.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(6);

            animator.startKeyframe(2);
            animator.rotate(root, 0, (float) Math.toRadians(-75F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-12.5F), (float) Math.toRadians(-37.5F), (float) Math.toRadians(-10F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-67.5F), 0, (float) Math.toRadians(32.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-82.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(42.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(70F), (float) Math.toRadians(-5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(60F), (float) Math.toRadians(-52.5F), (float) Math.toRadians(-50F));
            animator.rotate(left_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(12);
            animator.resetKeyframe(12);
        } else {
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(-35F), 0);
            animator.rotate(upperbody, 0, (float) Math.toRadians(-10F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(95F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(-25F), (float) Math.toRadians(5F));
            animator.rotate(right_fist, (float) Math.toRadians(35F), (float) Math.toRadians(-45F), 0);
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(67.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-22.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(25F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.startKeyframe(6);
            animator.rotate(root, 0, (float) Math.toRadians(-2.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-7.5F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(100F), (float) Math.toRadians(-5F));
            animator.rotate(right_hand, (float) Math.toRadians(-72.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(42.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(10F), (float) Math.toRadians(2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-40F), (float) Math.toRadians(17.5F), (float) Math.toRadians(-35F));
            animator.rotate(left_hand, (float) Math.toRadians(7.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(6);

            animator.startKeyframe(2);
            animator.rotate(root, 0, (float) Math.toRadians(-82.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-40F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-65F), (float) Math.toRadians(2.5F), (float) Math.toRadians(22.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-72.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(42.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(75F), (float) Math.toRadians(-15F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(2.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-65F));
            animator.rotate(left_hand, (float) Math.toRadians(7.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(12);
            animator.resetKeyframe(12);
        }


        animator.setAnimation(Ignis_Entity.POKE_ATTACK);
        poke(entity, 20, 15, 15);

        animator.setAnimation(Ignis_Entity.POKE_ATTACK2);
        poke(entity, 17, 12, 12);

        animator.setAnimation(Ignis_Entity.POKE_ATTACK3);
        poke(entity, 15, 10, 10);

        animator.setAnimation(Ignis_Entity.POKED_ATTACK);
        if (!entity.getIsShieldBreak()) {
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(-32.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(-15F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-65F), (float) Math.toRadians(7.5F), (float) Math.toRadians(55F));
            animator.rotate(right_hand, (float) Math.toRadians(15F), (float) Math.toRadians(57.5F), (float) Math.toRadians(20F));
            animator.rotate(right_fist, (float) Math.toRadians(72.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(67.5F), (float) Math.toRadians(-22.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(105F), (float) Math.toRadians(-15F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-62.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.startKeyframe(20);
            animator.rotate(root, 0, (float) Math.toRadians(-45F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-57.5F), (float) Math.toRadians(30F), (float) Math.toRadians(70F));
            animator.rotate(right_hand, (float) Math.toRadians(15F), (float) Math.toRadians(57.5F), (float) Math.toRadians(20F));
            animator.rotate(right_fist, (float) Math.toRadians(70F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(75F), (float) Math.toRadians(-12.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(75f), (float) Math.toRadians(-15F), (float) Math.toRadians(-22.5F));
            animator.rotate(left_arm, 0, 0, (float) Math.toRadians(-2.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-70F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(20);
            animator.resetKeyframe(15);
        } else {
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(-40F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(12.5F), (float) Math.toRadians(-45F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-62.5F), (float) Math.toRadians(10F), (float) Math.toRadians(45F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(57.5F), (float) Math.toRadians(20F));
            animator.rotate(right_fist, (float) Math.toRadians(70F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(72.5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(47.5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-15F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.startKeyframe(20);
            animator.rotate(root, 0, (float) Math.toRadians(-52.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-45F), (float) Math.toRadians(7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(32.5F), (float) Math.toRadians(60F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(57.5F), (float) Math.toRadians(20F));
            animator.rotate(right_fist, (float) Math.toRadians(67.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(80F), (float) Math.toRadians(-22.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(17.5f), (float) Math.toRadians(32.5F), (float) Math.toRadians(-37.5F));
            animator.rotate(left_arm, 0, 0, (float) Math.toRadians(-2.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-22.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(20);
            animator.resetKeyframe(15);

        }

        animator.setAnimation(Ignis_Entity.PHASE_3);
        if (entity.getIsSword()) {
            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-25F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-80F), (float) Math.toRadians(-50F), (float) Math.toRadians(30F));
            animator.move(right_arm_joint, 0, 3, 0);
            animator.rotate(right_hand, (float) Math.toRadians(-5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, (float) Math.toRadians(-20F));
            animator.rotate(sword, 0, (float) Math.toRadians(182.5F), 0);
            animator.rotate(head, 0, (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-77.5F), (float) Math.toRadians(85F), (float) Math.toRadians(-47.5F));
            animator.move(left_arm_joint, 0, 3, 0);
            animator.rotate(left_hand, (float) Math.toRadians(40F), (float) Math.toRadians(-5F), (float) Math.toRadians(27.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-25F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-90F), (float) Math.toRadians(-40F), (float) Math.toRadians(30F));
            animator.move(right_arm_joint, 3, 0, 0);
            animator.rotate(right_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(-37.5F));
            animator.rotate(right_fist, 0, 0, (float) Math.toRadians(-25F));
            animator.rotate(sword, 0, (float) Math.toRadians(182.5F), 0);
            animator.rotate(head, 0, (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-87.5F), (float) Math.toRadians(72.5F), (float) Math.toRadians(-47.5F));
            animator.move(left_arm_joint, -2, 0, 0);
            animator.rotate(left_hand, (float) Math.toRadians(32.5F), (float) Math.toRadians(-25F), (float) Math.toRadians(47.5F));
            animator.rotate(left_fist, (float) Math.toRadians(22.5F), 0, 0);
            animator.endKeyframe();
            animator.setStaticKeyframe(15);

            animator.startKeyframe(4);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-25F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-90F), (float) Math.toRadians(-40F), (float) Math.toRadians(30F));
            animator.move(right_arm_joint, 1, 6, 0);
            animator.rotate(right_hand, 0, 0, (float) Math.toRadians(-20F));
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, (float) Math.toRadians(-22.5F));
            animator.rotate(sword, 0, (float) Math.toRadians(182.5F), 0);
            animator.rotate(head, 0, (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-87.5F), (float) Math.toRadians(72.5F), (float) Math.toRadians(-47.5F));
            animator.move(left_arm_joint, -1, 6, -1);
            animator.rotate(left_hand, (float) Math.toRadians(47.5F), 0, (float) Math.toRadians(42.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-70F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-25F), (float) Math.toRadians(-40F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-77.5F), (float) Math.toRadians(-25F), (float) Math.toRadians(45F));
            animator.rotate(right_hand, (float) Math.toRadians(2.5F), 0, (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(-27.5F), 0, (float) Math.toRadians(-22.5F));
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(65F), (float) Math.toRadians(-12.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-70F), (float) Math.toRadians(57.5F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_hand, (float) Math.toRadians(7.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(12);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(2.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-15F), (float) Math.toRadians(22.5F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(10F), (float) Math.toRadians(-5F), (float) Math.toRadians(27.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-2.5F), 0, (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(27.5F), 0, (float) Math.toRadians(-12.5F));
            animator.rotate(head, (float) Math.toRadians(12.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(-12.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-30F), (float) Math.toRadians(5F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_hand, (float) Math.toRadians(7.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.resetKeyframe(10);
        } else if (entity.getIsShield()) {
            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-17.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-12.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-82.5F), (float) Math.toRadians(-52.5F), (float) Math.toRadians(40F));
            animator.move(right_arm_joint, 0, 3, 0);
            animator.rotate(right_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, (float) Math.toRadians(-20F));
            animator.rotate(sword, 0, (float) Math.toRadians(182.5F), 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(25F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-20F), (float) Math.toRadians(37.5F), (float) Math.toRadians(-32.5F));
            animator.move(left_arm_joint, 0, 3, 0);
            animator.rotate(left_hand, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-2.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-17.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-22.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-92.5F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(40F));
            animator.move(right_arm_joint, 3, 0, 0);
            animator.rotate(right_hand, (float) Math.toRadians(-32.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(-37.5F));
            animator.rotate(right_fist, (float) Math.toRadians(2.5F), 0, (float) Math.toRadians(-25F));
            animator.rotate(sword, 0, (float) Math.toRadians(182.5F), 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(25F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-30F), (float) Math.toRadians(25F), (float) Math.toRadians(-32.5F));
            animator.move(left_arm_joint, -2, 0, 0);
            animator.rotate(left_hand, (float) Math.toRadians(-15F), (float) Math.toRadians(-40F), (float) Math.toRadians(17.5F));
            animator.rotate(left_fist, (float) Math.toRadians(22.5F), 0, 0);
            animator.endKeyframe();
            animator.setStaticKeyframe(15);

            animator.startKeyframe(4);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-17.5F), 0);
            animator.rotate(upperbody, 0, (float) Math.toRadians(-10F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-92.5F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(40F));
            animator.move(right_arm_joint, 1, 6, 0);
            animator.rotate(right_hand, (float) Math.toRadians(-15F), 0, (float) Math.toRadians(-20F));
            animator.rotate(right_fist, (float) Math.toRadians(-20F), 0, (float) Math.toRadians(-22.5F));
            animator.rotate(sword, 0, (float) Math.toRadians(182.5F), 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(25F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-30F), (float) Math.toRadians(25F), (float) Math.toRadians(-32.5F));
            animator.move(left_arm_joint, -1, 6, -1);
            animator.rotate(left_hand, 0, (float) Math.toRadians(-15F), (float) Math.toRadians(12.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-62.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-30F), (float) Math.toRadians(-37.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-80F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(55F));
            animator.rotate(right_hand, (float) Math.toRadians(-12.5F), 0, (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, (float) Math.toRadians(-22.5F));
            animator.rotate(head, (float) Math.toRadians(10F), (float) Math.toRadians(60F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-12.5F), (float) Math.toRadians(10F), (float) Math.toRadians(-12.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(12);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(10F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-20F), (float) Math.toRadians(25F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(7.5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(37.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-17.5F), 0, (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(30F), 0, (float) Math.toRadians(-12.5F));
            animator.rotate(head, (float) Math.toRadians(17.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(27.5F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(-12.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.resetKeyframe(10);

        } else {
            animator.startKeyframe(15);
            animator.rotate(upperbody, (float) Math.toRadians(-12.5F), 0, 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-60F), (float) Math.toRadians(-52.5F), (float) Math.toRadians(40F));
            animator.move(right_arm_joint, 0, 3, 0);
            animator.rotate(right_hand, (float) Math.toRadians(-50F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_fist, 0, 0, (float) Math.toRadians(-20F));
            animator.rotate(sword, 0, (float) Math.toRadians(182.5F), 0);
            animator.rotate(head, (float) Math.toRadians(15F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-60F), (float) Math.toRadians(52.5F), (float) Math.toRadians(-40F));
            animator.move(left_arm_joint, 0, 3, 0);
            animator.rotate(left_hand, (float) Math.toRadians(-50F), (float) Math.toRadians(-5F), (float) Math.toRadians(12.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(15);
            animator.rotate(upperbody, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-70F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(40F));
            animator.move(right_arm_joint, 3, 0, 0);
            animator.rotate(right_hand, (float) Math.toRadians(-62.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(-37.5F));
            animator.rotate(right_fist, (float) Math.toRadians(25F), 0, (float) Math.toRadians(-25F));
            animator.rotate(sword, 0, (float) Math.toRadians(182.5F), 0);
            animator.rotate(head, (float) Math.toRadians(15F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-70F), (float) Math.toRadians(40F), (float) Math.toRadians(-40F));
            animator.move(left_arm_joint, -2, 0, 0);
            animator.rotate(left_hand, (float) Math.toRadians(-57.5F), (float) Math.toRadians(-25F), (float) Math.toRadians(32.5F));
            animator.rotate(left_fist, (float) Math.toRadians(22.5F), 0, 0);
            animator.endKeyframe();
            animator.setStaticKeyframe(15);

            animator.startKeyframe(4);
            animator.rotate(root, (float) Math.toRadians(-2.5F), 0, 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-70F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(40F));
            animator.move(right_arm_joint, 1, 6, 0);
            animator.rotate(right_hand, (float) Math.toRadians(-45F), 0, (float) Math.toRadians(-20F));
            animator.rotate(right_fist, (float) Math.toRadians(2.5F), 0, (float) Math.toRadians(-22.5F));
            animator.rotate(sword, 0, (float) Math.toRadians(182.5F), 0);
            animator.rotate(head, (float) Math.toRadians(15F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-70F), (float) Math.toRadians(40F), (float) Math.toRadians(-40F));
            animator.move(left_arm_joint, -1, 6, -1);
            animator.rotate(left_hand, (float) Math.toRadians(-42.5F), 0, (float) Math.toRadians(27.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-45F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-30F), (float) Math.toRadians(-27.5F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-57.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(55F));
            animator.rotate(right_hand, (float) Math.toRadians(-42.5F), 0, (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(-2.5F), 0, (float) Math.toRadians(-22.5F));
            animator.rotate(head, (float) Math.toRadians(20F), (float) Math.toRadians(35F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-52.5F), (float) Math.toRadians(25F), (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(-82.5F), 0, 0);
            animator.endKeyframe();
            animator.setStaticKeyframe(12);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(27.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-20F), (float) Math.toRadians(35F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(30F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(37.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-47.5F), 0, (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(52.5F), 0, (float) Math.toRadians(-12.5F));
            animator.rotate(head, (float) Math.toRadians(27.5F), (float) Math.toRadians(-52.5F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-12.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(-82.5F), 0, 0);
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.resetKeyframe(10);

        }

        animator.setAnimation(Ignis_Entity.SHIELD_SMASH_ATTACK);
        animator.startKeyframe(20);
        animator.rotate(root, (float) Math.toRadians(-5F), (float) Math.toRadians(30F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-25F), 0, (float) Math.toRadians(-10F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(5F), (float) Math.toRadians(5F), (float) Math.toRadians(45F));
        animator.rotate(right_hand, (float) Math.toRadians(32.5F), (float) Math.toRadians(10F), (float) Math.toRadians(15F));
        animator.rotate(right_fist, (float) Math.toRadians(30F), 0, 0);
        animator.rotate(head, 0, 0, (float) Math.toRadians(2.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-30F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-20F));
        animator.rotate(left_arm, 0, (float) Math.toRadians(2.5F), (float) Math.toRadians(7.5F));
        animator.rotate(left_hand, (float) Math.toRadians(25F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(7.5F));
        animator.endKeyframe();
        animator.setStaticKeyframe(10);

        animator.startKeyframe(5);
        animator.rotate(root, (float) Math.toRadians(17.5F), (float) Math.toRadians(30F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(15F), 0);
        animator.rotate(right_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(5F), (float) Math.toRadians(45F));
        animator.rotate(right_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(10F), (float) Math.toRadians(15F));
        animator.rotate(right_fist, (float) Math.toRadians(17.5F), 0, 0);
        animator.rotate(head, 0, (float) Math.toRadians(-10F), 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-20F));
        animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(5F));
        animator.endKeyframe();
        animator.setStaticKeyframe(20);
        animator.resetKeyframe(15);

        animator.setAnimation(Ignis_Entity.PHASE_2);
        if (entity.getIsBlocking()) {
            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-17.5F), 0);
            animator.rotate(upperbody, 0, (float) Math.toRadians(-10F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-82.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(2.5F));
            animator.rotate(right_arm, 0, 0, (float) Math.toRadians(-30F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(-30F), (float) Math.toRadians(-62.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(25F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(40F), (float) Math.toRadians(-10F), (float) Math.toRadians(22.5F));
            animator.rotate(left_hand, (float) Math.toRadians(42.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-40F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-17.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-20F), (float) Math.toRadians(-10F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-105F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(17.5F));
            animator.rotate(right_fist, (float) Math.toRadians(22.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-20F), (float) Math.toRadians(25F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(85F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(20F));
            animator.rotate(left_hand, (float) Math.toRadians(-45F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-27.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(20);
            animator.resetKeyframe(15);
        } else if (entity.getIsSword()) {
            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-25F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-80F), (float) Math.toRadians(10F), (float) Math.toRadians(-7.5F));
            animator.rotate(right_arm, 0, 0, (float) Math.toRadians(-30F));
            animator.rotate(right_hand, (float) Math.toRadians(45F), (float) Math.toRadians(-30F), (float) Math.toRadians(-62.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-17.5F), (float) Math.toRadians(37.5F), (float) Math.toRadians(7.5F));
            animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
            animator.rotate(left_hand, (float) Math.toRadians(90F), 0, (float) Math.toRadians(-10F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-25F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-15F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-102.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-15F));
            animator.rotate(right_hand, (float) Math.toRadians(45F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(17.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-25F), (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(27.5F), (float) Math.toRadians(30F), (float) Math.toRadians(5F));
            animator.rotate(left_hand, (float) Math.toRadians(2.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(2.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(20);
            animator.resetKeyframe(15);
        } else {
            animator.startKeyframe(15);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-60F), (float) Math.toRadians(7.5F), (float) Math.toRadians(2.5F));
            animator.rotate(right_arm, 0, 0, (float) Math.toRadians(-30F));
            animator.rotate(right_hand, 0, (float) Math.toRadians(-30F), (float) Math.toRadians(-62.5F));
            animator.rotate(left_arm_joint, 0, (float) Math.toRadians(5F), (float) Math.toRadians(15F));
            animator.rotate(left_hand, 0, 0, (float) Math.toRadians(-25F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(upperbody, (float) Math.toRadians(-20F), 0, 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-82.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_hand, 0, (float) Math.toRadians(-2.5F), (float) Math.toRadians(17.5F));
            animator.rotate(head, (float) Math.toRadians(-10F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(45F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(12.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-87.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(-12.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(20);
            animator.resetKeyframe(15);
        }
        animator.setAnimation(Ignis_Entity.BODY_CHECK_ATTACK1);
        bodycheck(entity, 12, 20, 15);

        animator.setAnimation(Ignis_Entity.BODY_CHECK_ATTACK2);
        animator.startKeyframe(0);
        if (!entity.getIsShieldBreak()) {
            animator.rotate(root, 0, (float) Math.toRadians(7.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(30F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(12.5F), (float) Math.toRadians(-5F), (float) Math.toRadians(47.5F));
            animator.rotate(right_hand, (float) Math.toRadians(20F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(70F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(10F), (float) Math.toRadians(-25F), (float) Math.toRadians(7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(22.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(47.5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(7.5F));
        } else {
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(27.5F), (float) Math.toRadians(10));
            animator.rotate(right_arm_joint, (float) Math.toRadians(15F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(37.5F));
            animator.rotate(right_hand, (float) Math.toRadians(35F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(67.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-35F), (float) Math.toRadians(37.5F), (float) Math.toRadians(-35F));
            animator.rotate(left_hand, (float) Math.toRadians(95F), (float) Math.toRadians(7.5F), (float) Math.toRadians(37.5F));
        }
        animator.endKeyframe();
        bodycheck(entity, 12, 20, 15);

        animator.setAnimation(Ignis_Entity.BODY_CHECK_ATTACK3);
        animator.startKeyframe(0);
        animator.rotate(root, (float) Math.toRadians(17.5F), (float) Math.toRadians(30F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(15F), 0);
        animator.rotate(right_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(5F), (float) Math.toRadians(45F));
        animator.rotate(right_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(10F), (float) Math.toRadians(15F));
        animator.rotate(right_fist, (float) Math.toRadians(17.5F), 0, 0);
        animator.rotate(head, 0, (float) Math.toRadians(-10F), 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-20F));
        animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(5F));
        animator.endKeyframe();
        bodycheck(entity, 12, 20, 15);

        animator.setAnimation(Ignis_Entity.BODY_CHECK_ATTACK4);
        animator.startKeyframe(0);
        if (!entity.getIsShieldBreak()) {
            animator.rotate(root, 0, (float) Math.toRadians(-32.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(-15F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-62.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(55F));
            animator.rotate(right_hand, (float) Math.toRadians(15F), (float) Math.toRadians(57.5F), (float) Math.toRadians(20F));
            animator.rotate(right_fist, (float) Math.toRadians(72.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(67.5F), (float) Math.toRadians(-22.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(105F), (float) Math.toRadians(-15F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-62.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
        } else {
            animator.rotate(root, 0, (float) Math.toRadians(-40F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(12.5F), (float) Math.toRadians(-45F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-60F), (float) Math.toRadians(10F), (float) Math.toRadians(45F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(57.5F), (float) Math.toRadians(20F));
            animator.rotate(right_fist, (float) Math.toRadians(70F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(72.5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(47.5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-15F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(15F));
            animator.endKeyframe();
        }
        bodycheck(entity, 12, 20, 15);

        animator.setAnimation(Ignis_Entity.BODY_CHECK_ATTACK_SOUL1);
        bodycheck(entity, 8, 12, 10);

        animator.setAnimation(Ignis_Entity.BODY_CHECK_ATTACK_SOUL2);
        animator.startKeyframe(0);
        if (!entity.getIsShieldBreak()) {
            animator.rotate(root, 0, (float) Math.toRadians(7.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(30F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(12.5F), (float) Math.toRadians(-5F), (float) Math.toRadians(47.5F));
            animator.rotate(right_hand, (float) Math.toRadians(20F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(70F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(10F), (float) Math.toRadians(-25F), (float) Math.toRadians(7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(22.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(47.5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(7.5F));
        } else {
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(27.5F), (float) Math.toRadians(10));
            animator.rotate(right_arm_joint, (float) Math.toRadians(15F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(37.5F));
            animator.rotate(right_hand, (float) Math.toRadians(35F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(67.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-35F), (float) Math.toRadians(37.5F), (float) Math.toRadians(-35F));
            animator.rotate(left_hand, (float) Math.toRadians(95F), (float) Math.toRadians(7.5F), (float) Math.toRadians(37.5F));
        }
        animator.endKeyframe();
        bodycheck(entity, 8, 12, 10);

        animator.setAnimation(Ignis_Entity.BODY_CHECK_ATTACK_SOUL3);
        animator.startKeyframe(0);
        animator.rotate(root, (float) Math.toRadians(17.5F), (float) Math.toRadians(30F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(15F), 0);
        animator.rotate(right_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(5F), (float) Math.toRadians(45F));
        animator.rotate(right_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(10F), (float) Math.toRadians(15F));
        animator.rotate(right_fist, (float) Math.toRadians(17.5F), 0, 0);
        animator.rotate(head, 0, (float) Math.toRadians(-10F), 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-20F));
        animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(5F));
        animator.endKeyframe();
        bodycheck(entity, 8, 12, 10);

        animator.setAnimation(Ignis_Entity.BODY_CHECK_ATTACK_SOUL4);
        animator.startKeyframe(0);
        if (!entity.getIsShieldBreak()) {
            animator.rotate(root, 0, (float) Math.toRadians(-32.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(-15F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-62.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(55F));
            animator.rotate(right_hand, (float) Math.toRadians(15F), (float) Math.toRadians(57.5F), (float) Math.toRadians(20F));
            animator.rotate(right_fist, (float) Math.toRadians(72.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(67.5F), (float) Math.toRadians(-22.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(105F), (float) Math.toRadians(-15F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-62.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
        } else {
            animator.rotate(root, 0, (float) Math.toRadians(-40F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(12.5F), (float) Math.toRadians(-45F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-60F), (float) Math.toRadians(10F), (float) Math.toRadians(45F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(57.5F), (float) Math.toRadians(20F));
            animator.rotate(right_fist, (float) Math.toRadians(70F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(72.5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(47.5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-15F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(15F));
            animator.endKeyframe();
        }
        bodycheck(entity, 8, 12, 10);


        animator.setAnimation(Ignis_Entity.SMASH_IN_AIR);
        if(!entity.getIsShieldBreak()) {
            animator.startKeyframe(15);
            animator.rotate(root, (float) Math.toRadians(15F), (float) Math.toRadians(-17.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(2.5F), (float) Math.toRadians(35F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(15F), (float) Math.toRadians(10F), (float) Math.toRadians(30F));
            animator.rotate(right_hand, (float) Math.toRadians(-37.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(72.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_hand, (float) Math.toRadians(20F), 0, 0);
            animator.endKeyframe();
            animator.setStaticKeyframe(5);

            animator.startKeyframe(10);
            animator.rotate(root, (float) Math.toRadians(2.5F), 0, 0);
            animator.rotate(upperbody, (float) Math.toRadians(-30F), (float) Math.toRadians(27.5F), (float) Math.toRadians(-5F));
            animator.rotate(head, 0, (float) Math.toRadians(25F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-107.5F), (float) Math.toRadians(40F), (float) Math.toRadians(32.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-52.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-50F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(-42.5F));
            animator.rotate(left_hand, (float) Math.toRadians(25F), (float) Math.toRadians(22.5F), (float) Math.toRadians(-25F));
            animator.endKeyframe();
            animator.setStaticKeyframe(60);
            animator.resetKeyframe(15);
        }else{
            animator.startKeyframe(15);
            animator.rotate(root, (float) Math.toRadians(15F), (float) Math.toRadians(-25F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(10F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(17.5F), (float) Math.toRadians(12.5F), (float) Math.toRadians(20F));
            animator.rotate(right_hand, (float) Math.toRadians(-27.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(15F), (float) Math.toRadians(27.5F), (float) Math.toRadians(-47.5F));
            animator.rotate(left_hand, (float) Math.toRadians(67.5F), (float) Math.toRadians(15F), (float) Math.toRadians(30F));
            animator.endKeyframe();
            animator.setStaticKeyframe(5);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-72.5F), 0);
            animator.rotate(upperbody, 0, (float) Math.toRadians(-20F), (float) Math.toRadians(-15F));
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(70F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-35F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_hand, (float) Math.toRadians(35F), (float) Math.toRadians(25F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-22.5F), (float) Math.toRadians(35F), (float) Math.toRadians(-62.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-10F), (float) Math.toRadians(12.5F), (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(60);
            animator.resetKeyframe(15);

        }

        animator.setAnimation(Ignis_Entity.SMASH);
        if(!entity.getIsShieldBreak()) {
            animator.startKeyframe(0);
            animator.rotate(root, (float) Math.toRadians(2.5F), 0, 0);
            animator.rotate(upperbody, (float) Math.toRadians(-30F), (float) Math.toRadians(27.5F), (float) Math.toRadians(-5F));
            animator.rotate(head, 0, (float) Math.toRadians(25F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-107.5F), (float) Math.toRadians(40F), (float) Math.toRadians(32.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-52.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-50F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(-42.5F));
            animator.rotate(left_hand, (float) Math.toRadians(25F), (float) Math.toRadians(22.5F), (float) Math.toRadians(-25F));
            animator.endKeyframe();

            animator.startKeyframe(8);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-17.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(35F), (float) Math.toRadians(10F));
            animator.rotate(lowerbody, 0, (float) Math.toRadians(35F), 0);
            animator.rotate(head, (float) Math.toRadians(10F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-45F), (float) Math.toRadians(60F), (float) Math.toRadians(20F));
            animator.rotate(right_hand, (float) Math.toRadians(15F), (float) Math.toRadians(-87.5F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-27.5F), (float) Math.toRadians(70F), (float) Math.toRadians(-95F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-15F), (float) Math.toRadians(-15F), (float) Math.toRadians(37.5F));
            animator.rotate(left_hand, (float) Math.toRadians(37.5F), 0, (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(20);
            animator.resetKeyframe(15);
        }else{
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(-72.5F), 0);
            animator.rotate(upperbody, 0, (float) Math.toRadians(-20F), (float) Math.toRadians(-15F));
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(70F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-35F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_hand, (float) Math.toRadians(35F), (float) Math.toRadians(25F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-22.5F), (float) Math.toRadians(35F), (float) Math.toRadians(-62.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-10F), (float) Math.toRadians(12.5F), (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.startKeyframe(8);
            animator.rotate(root, 0, (float) Math.toRadians(7.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(30F), (float) Math.toRadians(5F), (float) Math.toRadians(30F));
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-42.5F), (float) Math.toRadians(37.5F), (float) Math.toRadians(17.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-10F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(20F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-30F), (float) Math.toRadians(45F), (float) Math.toRadians(-30F));
            animator.rotate(left_hand, (float) Math.toRadians(67.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(15F));
            animator.move(left_hand, 0, 2, -1);
            animator.endKeyframe();
            animator.setStaticKeyframe(20);
            animator.resetKeyframe(15);
        }

        animator.setAnimation(Ignis_Entity.BREAK_THE_SHIELD);
        if (entity.getIsBlocking()) {
            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-42.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-30F), (float) Math.toRadians(-37.5F), (float) Math.toRadians(-5F));
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(5F), (float) Math.toRadians(32.5F), 0);
            animator.rotate(left_arm_joint, 0, (float) Math.toRadians(-60F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(2.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(20);

            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-17.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(-5F));
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(25F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-92.5F), (float) Math.toRadians(-50F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(-5F), (float) Math.toRadians(-5F), (float) Math.toRadians(-22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-17.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-30F), (float) Math.toRadians(40F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(2.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(5);

            animator.startKeyframe(5);
            animator.rotate(root, (float) Math.toRadians(7.5F), (float) Math.toRadians(-17.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(15F), (float) Math.toRadians(-10F), (float) Math.toRadians(-5F));
            animator.rotate(head, (float) Math.toRadians(-25F), (float) Math.toRadians(25F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(27.5F), (float) Math.toRadians(15F), (float) Math.toRadians(2.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-5F), (float) Math.toRadians(-5F), (float) Math.toRadians(-22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-17.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(85F), (float) Math.toRadians(-30F), (float) Math.toRadians(2.5F));
            animator.rotate(left_hand, (float) Math.toRadians(2.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(15);

            animator.resetKeyframe(12);
        } else {
            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-25F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-30F), (float) Math.toRadians(-27.5F), 0);
            animator.rotate(head, (float) Math.toRadians(15F), (float) Math.toRadians(-47.5F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(27.5F), (float) Math.toRadians(32.5F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(-30F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(22.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-40F), (float) Math.toRadians(-45F), 0);
            animator.rotate(left_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(-5F), 0);
            animator.endKeyframe();

            animator.setStaticKeyframe(20);

            animator.startKeyframe(15);
            animator.rotate(root, 0, 0, 0);
            animator.rotate(upperbody, (float) Math.toRadians(-47.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(15F), 0, 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-70F), (float) Math.toRadians(-50F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(-35F), (float) Math.toRadians(-5F), (float) Math.toRadians(-22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-70F), (float) Math.toRadians(55F), 0);
            animator.rotate(left_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(-5F), 0);
            animator.endKeyframe();

            animator.setStaticKeyframe(5);

            animator.startKeyframe(5);
            animator.rotate(root, (float) Math.toRadians(7.5F), 0, 0);
            animator.rotate(upperbody, (float) Math.toRadians(15F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-15F), 0, 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(50F), (float) Math.toRadians(15F), (float) Math.toRadians(2.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-35F), (float) Math.toRadians(-5F), (float) Math.toRadians(-22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(45F), (float) Math.toRadians(-15F), (float) Math.toRadians(-5F));
            animator.rotate(left_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(-5F), 0);
            animator.endKeyframe();

            animator.setStaticKeyframe(15);

            animator.resetKeyframe(12);
        }
        animator.setAnimation(Ignis_Entity.COMBO1);
        animator.startKeyframe(10);
        animator.rotate(root, 0, (float) Math.toRadians(-25F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(70F), (float) Math.toRadians(55F), (float) Math.toRadians(90F));
        animator.rotate(lowerbody, 0, (float) Math.toRadians(67.5F), (float) Math.toRadians(7.5F));
        animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-2.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-90F), (float) Math.toRadians(-40F), (float) Math.toRadians(-2.5F));
        animator.rotate(right_hand, (float) Math.toRadians(15F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(-17.5F));
        animator.rotate(right_fist, (float) Math.toRadians(-25F), (float) Math.toRadians(27.5F), 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(-87.5F), (float) Math.toRadians(87.5F), (float) Math.toRadians(-7.5F));
        animator.rotate(left_hand, (float) Math.toRadians(110F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(25F));
        animator.endKeyframe();

        animator.setStaticKeyframe(7);

        animator.startKeyframe(3);
        animator.rotate(root, 0, (float) Math.toRadians(-25F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(20F), (float) Math.toRadians(-50F), (float) Math.toRadians(-15F));
        animator.rotate(lowerbody, (float) Math.toRadians(5F), (float) Math.toRadians(-45F), 0);
        animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(62.5F), (float) Math.toRadians(-12.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-107.5F), (float) Math.toRadians(-55F), (float) Math.toRadians(67.5F));
        animator.rotate(right_hand, (float) Math.toRadians(-25F), (float) Math.toRadians(92.5F), (float) Math.toRadians(-65F));
        animator.rotate(right_fist, (float) Math.toRadians(30F), 0, 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(-37.5F), (float) Math.toRadians(82.5F), (float) Math.toRadians(30F));
        animator.rotate(left_hand, (float) Math.toRadians(77.5F), (float) Math.toRadians(20F), (float) Math.toRadians(25F));
        animator.endKeyframe();

        animator.setStaticKeyframe(3);

        animator.startKeyframe(8);
        animator.rotate(root, 0, (float) Math.toRadians(-25F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-100F), (float) Math.toRadians(-122.5F), (float) Math.toRadians(90F));
        animator.rotate(lowerbody, 0, (float) Math.toRadians(-67.5F), (float) Math.toRadians(-7.5F));
        animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(82.5F), (float) Math.toRadians(-12.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-85F), (float) Math.toRadians(-37.5F), (float) Math.toRadians(10F));
        animator.rotate(right_hand, (float) Math.toRadians(5F), (float) Math.toRadians(12.5F), (float) Math.toRadians(-20F));
        animator.rotate(right_fist, (float) Math.toRadians(12.5F), (float) Math.toRadians(17.5F), (float) Math.toRadians(-62.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-75F), (float) Math.toRadians(97.5F), (float) Math.toRadians(-2.5F));
        animator.rotate(left_hand, (float) Math.toRadians(110F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(25F));
        animator.endKeyframe();

        animator.setStaticKeyframe(5);

        animator.startKeyframe(3);
        animator.rotate(root, 0, (float) Math.toRadians(2.5F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(10F), (float) Math.toRadians(5F), (float) Math.toRadians(20F));
        animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(-12.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(15F), (float) Math.toRadians(45F), (float) Math.toRadians(55F));
        animator.rotate(right_hand, (float) Math.toRadians(42.5F), 0, (float) Math.toRadians(10F));
        animator.rotate(right_fist, (float) Math.toRadians(52.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(2.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-45F), (float) Math.toRadians(30F), (float) Math.toRadians(-7.5F));
        animator.rotate(left_hand, (float) Math.toRadians(15F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(25F));
        animator.endKeyframe();

        animator.setStaticKeyframe(10);

        animator.startKeyframe(8);
        animator.rotate(root, 0, (float) Math.toRadians(22.5F), 0);
        animator.rotate(upperbody, 0, (float) Math.toRadians(-2.5F), (float) Math.toRadians(15F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-127.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(-10F));
        animator.rotate(right_hand, (float) Math.toRadians(-5F), (float) Math.toRadians(12.5F), (float) Math.toRadians(-55F));
        animator.rotate(right_fist, (float) Math.toRadians(-52.5F), 0, 0);
        animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(-2.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-35F), (float) Math.toRadians(12.5F), (float) Math.toRadians(-7.5F));
        animator.rotate(left_hand, (float) Math.toRadians(27.5F), (float) Math.toRadians(5F), (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.setStaticKeyframe(3);

        animator.startKeyframe(2);
        animator.rotate(root, 0, (float) Math.toRadians(-70F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(2.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-7.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(2.5F));
        animator.rotate(right_hand, (float) Math.toRadians(-37.5F), (float) Math.toRadians(80F), (float) Math.toRadians(-47.5F));
        animator.rotate(right_fist, (float) Math.toRadians(22.5F), 0, 0);
        animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(72.5F), (float) Math.toRadians(-17.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-40F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-7.5F));
        animator.rotate(left_hand, (float) Math.toRadians(27.5F), (float) Math.toRadians(5F), (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.setStaticKeyframe(1);

        animator.startKeyframe(10);
        animator.move(root, 0, -7, 0);
        animator.rotate(root, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-232.5F), (float) Math.toRadians(5F));
        animator.rotate(upperbody, (float) Math.toRadians(-35F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(12.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-112.5F), (float) Math.toRadians(102.5F), (float) Math.toRadians(-30F));
        animator.rotate(right_hand, (float) Math.toRadians(15F), (float) Math.toRadians(55F), (float) Math.toRadians(27.5F));
        animator.rotate(right_fist, (float) Math.toRadians(62.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(-17.5F));
        animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-12.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-47.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(-7.5F));
        animator.rotate(left_hand, (float) Math.toRadians(22.5F), (float) Math.toRadians(5F), (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.startKeyframe(4);
        animator.rotate(root, (float) Math.toRadians(5F), (float) Math.toRadians(-452.5F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(2.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(17.5F));
        animator.rotate(right_hand, (float) Math.toRadians(45F), (float) Math.toRadians(75F), (float) Math.toRadians(27.5F));
        animator.rotate(right_fist, (float) Math.toRadians(62.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(-17.5F));
        animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(67.5F), (float) Math.toRadians(-7.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-40F));
        animator.rotate(left_hand, (float) Math.toRadians(7.5F), (float) Math.toRadians(5F), (float) Math.toRadians(15F));
        animator.endKeyframe();
        animator.setStaticKeyframe(10);

        animator.startKeyframe(0);
        animator.rotate(root, (float) Math.toRadians(5F), (float) Math.toRadians(-92.5F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(2.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(17.5F));
        animator.rotate(right_hand, (float) Math.toRadians(45F), (float) Math.toRadians(75F), (float) Math.toRadians(27.5F));
        animator.rotate(right_fist, (float) Math.toRadians(62.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(-17.5F));
        animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(67.5F), (float) Math.toRadians(-7.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-40F));
        animator.rotate(left_hand, (float) Math.toRadians(7.5F), (float) Math.toRadians(5F), (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.resetKeyframe(15);

        animator.setAnimation(Ignis_Entity.COMBO2);
        animator.startKeyframe(0);
        animator.rotate(root, (float) Math.toRadians(5F), (float) Math.toRadians(-92.5F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(2.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(17.5F));
        animator.rotate(right_hand, (float) Math.toRadians(45F), (float) Math.toRadians(75F), (float) Math.toRadians(27.5F));
        animator.rotate(right_fist, (float) Math.toRadians(62.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(-17.5F));
        animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(67.5F), (float) Math.toRadians(-7.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-40F));
        animator.rotate(left_hand, (float) Math.toRadians(7.5F), (float) Math.toRadians(5F), (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.setStaticKeyframe(5);

        animator.startKeyframe(13);
        animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-85F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(12.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(7.5F));
        animator.rotate(head, (float) Math.toRadians(-27.5F), (float) Math.toRadians(65F), (float) Math.toRadians(-37.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-20F), (float) Math.toRadians(40F), (float) Math.toRadians(-10F));
        animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(40F), 0);
        animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(-12.5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(17.5F));
        animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.startKeyframe(10);
        animator.rotate(root, (float) Math.toRadians(-5F), (float) Math.toRadians(-90F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(17.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(10F));
        animator.rotate(head, (float) Math.toRadians(-27.5F), (float) Math.toRadians(65F), (float) Math.toRadians(-37.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-15F), (float) Math.toRadians(50F), (float) Math.toRadians(-10F));
        animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(40F), 0);
        animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(17.5F), (float) Math.toRadians(27.5F), (float) Math.toRadians(-47.5F));
        animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.setStaticKeyframe(3);

        animator.startKeyframe(4);
        animator.rotate(root, (float) Math.toRadians(-5F), (float) Math.toRadians(45F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-7.5F), 0);
        animator.rotate(head, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(12.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-10F), (float) Math.toRadians(55F), (float) Math.toRadians(-10F));
        animator.rotate(right_hand, (float) Math.toRadians(7.5F), (float) Math.toRadians(40F), 0);
        animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(-77.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-47.5F));
        animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
        animator.endKeyframe();
        animator.setStaticKeyframe(8);
//베기
        animator.startKeyframe(10);
        animator.rotate(root, 0, (float) Math.toRadians(-80F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(-37.5F), (float) Math.toRadians(7.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-57.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(20F));
        animator.rotate(right_hand, (float) Math.toRadians(-42.5F), (float) Math.toRadians(-50F), (float) Math.toRadians(25F));
        animator.rotate(right_fist, (float) Math.toRadians(17.5F), 0, 0);
        animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(67.5F), (float) Math.toRadians(-25F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-17.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-17.5F));
        animator.rotate(left_hand, (float) Math.toRadians(25F), 0, (float) Math.toRadians(15F));
        animator.endKeyframe();
        animator.setStaticKeyframe(6);

        animator.startKeyframe(2);
        animator.rotate(root, 0, (float) Math.toRadians(-35F), 0);
        animator.rotate(upperbody, 0, (float) Math.toRadians(-10F), (float) Math.toRadians(5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(95F), 0);
        animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(-25F), (float) Math.toRadians(5F));
        animator.rotate(right_fist, (float) Math.toRadians(35F), (float) Math.toRadians(-45F), 0);
        animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(47.5F), (float) Math.toRadians(-17.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-22.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-17.5F));
        animator.rotate(left_hand, (float) Math.toRadians(25F), 0, (float) Math.toRadians(15F));
        animator.endKeyframe();
        animator.setStaticKeyframe(1);

        animator.startKeyframe(6);
        animator.rotate(root, 0, (float) Math.toRadians(-2.5F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-7.5F), 0);
        animator.rotate(right_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(100F), (float) Math.toRadians(-5F));
        animator.rotate(right_hand, (float) Math.toRadians(-72.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(42.5F));
        animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
        animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
        animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(10F), (float) Math.toRadians(2.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-40F), (float) Math.toRadians(17.5F), (float) Math.toRadians(-35F));
        animator.rotate(left_hand, (float) Math.toRadians(7.5F), 0, (float) Math.toRadians(15F));
        animator.endKeyframe();
        animator.setStaticKeyframe(6);

        animator.startKeyframe(2);
        animator.rotate(root, 0, (float) Math.toRadians(-82.5F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-40F), 0);
        animator.rotate(right_arm_joint, (float) Math.toRadians(-65F), (float) Math.toRadians(2.5F), (float) Math.toRadians(22.5F));
        animator.rotate(right_hand, (float) Math.toRadians(-72.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(42.5F));
        animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
        animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
        animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(75F), (float) Math.toRadians(-15F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(2.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-65F));
        animator.rotate(left_hand, (float) Math.toRadians(7.5F), 0, (float) Math.toRadians(15F));
        animator.endKeyframe();
        animator.setStaticKeyframe(7);

        animator.startKeyframe(10);
        animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-87.5F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(12.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
        animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(80F), (float) Math.toRadians(-42.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-45F), (float) Math.toRadians(7.5F), (float) Math.toRadians(40F));
        animator.rotate(right_hand, (float) Math.toRadians(-22.5F), 0, (float) Math.toRadians(47.5F));
        animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(42.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(17.5F));
        animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.setStaticKeyframe(10);

        animator.startKeyframe(6);
        animator.rotate(root, 0, (float) Math.toRadians(310F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(20F), (float) Math.toRadians(30F), (float) Math.toRadians(20F));
        animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-22.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-20F), (float) Math.toRadians(90F), (float) Math.toRadians(27.5F));
        animator.rotate(right_hand, (float) Math.toRadians(47.5F), (float) Math.toRadians(-47.5F), (float) Math.toRadians(22.5F));
        animator.rotate(right_fist, (float) Math.toRadians(42.5F), 0, 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(-25F), (float) Math.toRadians(57.5F), (float) Math.toRadians(-35F));
        animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.startKeyframe(0);
        animator.rotate(root, 0, (float) Math.toRadians(-50F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(20F), (float) Math.toRadians(30F), (float) Math.toRadians(20F));
        animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-22.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-20F), (float) Math.toRadians(90F), (float) Math.toRadians(27.5F));
        animator.rotate(right_hand, (float) Math.toRadians(47.5F), (float) Math.toRadians(-47.5F), (float) Math.toRadians(22.5F));
        animator.rotate(right_fist, (float) Math.toRadians(42.5F), 0, 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(-25F), (float) Math.toRadians(57.5F), (float) Math.toRadians(-35F));
        animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.setStaticKeyframe(10);
        animator.resetKeyframe(12);


        animator.setAnimation(Ignis_Entity.COUNTER);
        if(!entity.getIsShieldBreak()) {
            animator.startKeyframe(8);
            animator.rotate(root, (float) Math.toRadians(-5F), (float) Math.toRadians(30F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-25F), 0, (float) Math.toRadians(-10F));
            animator.rotate(head, (float) Math.toRadians(-10F), 0, (float) Math.toRadians(2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-22.5F), (float) Math.toRadians(5F), (float) Math.toRadians(45F));
            animator.rotate(right_hand, (float) Math.toRadians(32.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(30F), 0, 0);
            animator.rotate(left_arm_joint, 0, (float) Math.toRadians(-27.5F), (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(7.5F));
            animator.endKeyframe();

            animator.setStaticKeyframe(5);

            animator.startKeyframe(3);
            animator.rotate(root, (float) Math.toRadians(17.5F), (float) Math.toRadians(30F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(15F), 0);
            animator.rotate(head, 0, (float) Math.toRadians(-10F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(5F), (float) Math.toRadians(45F));
            animator.rotate(right_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(7.5F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(30F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(5F));
            animator.endKeyframe();

            animator.setStaticKeyframe(30);

            animator.resetKeyframe(15);
        }else{
            animator.startKeyframe(8);
            animator.rotate(root, (float) Math.toRadians(-5F), (float) Math.toRadians(22.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-20F), (float) Math.toRadians(-2.5F), 0);
            animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(5F), (float) Math.toRadians(-7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-20F), (float) Math.toRadians(7.5F), (float) Math.toRadians(35F));
            animator.rotate(right_hand, (float) Math.toRadians(42.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(27.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-57.5F), (float) Math.toRadians(20F), (float) Math.toRadians(-35F));
            animator.rotate(left_hand, (float) Math.toRadians(52.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(37.5F));
            animator.endKeyframe();

            animator.setStaticKeyframe(5);

            animator.startKeyframe(3);
            animator.rotate(root, (float) Math.toRadians(17.5F), (float) Math.toRadians(22.5F), 0);
            animator.rotate(upperbody, 0, (float) Math.toRadians(12.5F), (float) Math.toRadians(10F));
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(-5F), (float) Math.toRadians(-10F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(37.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(35F));
            animator.rotate(right_hand, (float) Math.toRadians(-30F), (float) Math.toRadians(7.5F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(27.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-22.5F), (float) Math.toRadians(20F), (float) Math.toRadians(-35F));
            animator.rotate(left_hand, 0, (float) Math.toRadians(-2.5F), (float) Math.toRadians(35F));
            animator.endKeyframe();

            animator.setStaticKeyframe(30);

            animator.resetKeyframe(15);
        }
            animator.setAnimation(STRIKE);
            animator.startKeyframe(0);
            animator.rotate(root, (float) Math.toRadians(17.5F), (float) Math.toRadians(30F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(15F), 0);
            animator.rotate(head, 0, (float) Math.toRadians(-10F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(5F), (float) Math.toRadians(45F));
            animator.rotate(right_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(7.5F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(30F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(5F));
            animator.endKeyframe();

            animator.setStaticKeyframe(5);

            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-155F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-30F), (float) Math.toRadians(-25F), (float) Math.toRadians(-15F));
            animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(27.5F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-90F), (float) Math.toRadians(-37.5F), (float) Math.toRadians(80F));
            animator.rotate(right_hand, (float) Math.toRadians(-45F), (float) Math.toRadians(2.5F), (float) Math.toRadians(37.5F));
            animator.rotate(right_fist, (float) Math.toRadians(32.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(100F), (float) Math.toRadians(-57.5F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-32.5F), (float) Math.toRadians(-22.5F));
            animator.endKeyframe();

            animator.setStaticKeyframe(8);

            animator.startKeyframe(4);
            animator.rotate(root, (float) Math.toRadians(15F), (float) Math.toRadians(12.5F), (float) Math.toRadians(7.5F));
            animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-2.5F), 0);
            animator.rotate(head, (float) Math.toRadians(10F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-5F), (float) Math.toRadians(-10F), (float) Math.toRadians(52.5F));
            animator.rotate(right_hand, (float) Math.toRadians(20F), (float) Math.toRadians(2.5F), (float) Math.toRadians(37.5F));
            animator.rotate(right_fist, (float) Math.toRadians(22.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(102.5F), (float) Math.toRadians(-67.5F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-32.5F), (float) Math.toRadians(-22.5F));
            animator.endKeyframe();

            animator.setStaticKeyframe(20);

            animator.resetKeyframe(10);

        animator.setAnimation(SWING_UPPERCUT);
        if (!entity.getIsShieldBreak()) {
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(-65F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(2.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-30F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-35F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(27.5F));
            animator.rotate(right_arm, 0, 0, (float) Math.toRadians(5F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(98.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, (float) Math.toRadians(2.5F), (float) Math.toRadians(-15F), 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(70F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(60F), (float) Math.toRadians(-5F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm, 0, 0, (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(-25F), (float) Math.toRadians(-10F));
            animator.endKeyframe();

            animator.setStaticKeyframe(5);

            animator.startKeyframe(13);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-77.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-2.5F));
            animator.rotate(head, (float) Math.toRadians(-22.5F), (float) Math.toRadians(60F), (float) Math.toRadians(-27.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-22.5F), (float) Math.toRadians(37.5F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(15F), (float) Math.toRadians(40F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(70F), (float) Math.toRadians(-15F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            //animator.setStaticKeyframe(5);

            animator.startKeyframe(10);
            animator.rotate(root, (float) Math.toRadians(-5F), (float) Math.toRadians(-82.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(12.5F), (float) Math.toRadians(-20F), 0);
            animator.rotate(head, (float) Math.toRadians(-22.5F), (float) Math.toRadians(60F), (float) Math.toRadians(-27.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-17.5F), (float) Math.toRadians(47.5F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(15F), (float) Math.toRadians(40F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(75F), (float) Math.toRadians(-20F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(3);

            animator.startKeyframe(4);
            animator.rotate(root, (float) Math.toRadians(-5F), (float) Math.toRadians(52.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(2.5F), (float) Math.toRadians(-5F), (float) Math.toRadians(-10F));
            animator.rotate(head, (float) Math.toRadians(-12.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(22.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-12.5F), (float) Math.toRadians(52.5F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(-2.5F), (float) Math.toRadians(40F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-20F), (float) Math.toRadians(-65F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);


            animator.resetKeyframe(15);

        } else {
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(-72.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-20F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(17.5F));
            animator.rotate(right_arm, 0, 0, (float) Math.toRadians(5F));
            animator.rotate(right_hand, (float) Math.toRadians(45F), (float) Math.toRadians(98.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, 0, (float) Math.toRadians(-15F), 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(70F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(2.5F), (float) Math.toRadians(42.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm, 0, 0, (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(27.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(20F));
            animator.endKeyframe();

            animator.setStaticKeyframe(5);

            animator.startKeyframe(13);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-85F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(12.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(7.5F));
            animator.rotate(head, (float) Math.toRadians(-27.5F), (float) Math.toRadians(65F), (float) Math.toRadians(-37.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-20F), (float) Math.toRadians(40F), (float) Math.toRadians(-10F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(40F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-12.5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(17.5F));
            animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(root, (float) Math.toRadians(-5F), (float) Math.toRadians(-90F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(17.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(10F));
            animator.rotate(head, (float) Math.toRadians(-27.5F), (float) Math.toRadians(65F), (float) Math.toRadians(-37.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-15F), (float) Math.toRadians(50F), (float) Math.toRadians(-10F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(40F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(17.5F), (float) Math.toRadians(27.5F), (float) Math.toRadians(-47.5F));
            animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(3);

            animator.startKeyframe(4);
            animator.rotate(root, (float) Math.toRadians(-5F), (float) Math.toRadians(45F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-7.5F), 0);
            animator.rotate(head, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(12.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-10F), (float) Math.toRadians(55F), (float) Math.toRadians(-10F));
            animator.rotate(right_hand, (float) Math.toRadians(7.5F), (float) Math.toRadians(40F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-77.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-47.5F));
            animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);

            animator.resetKeyframe(15);
        }

        animator.setAnimation(SWING_UPPERSLASH);
        if (!entity.getIsShieldBreak()) {
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(-65F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(2.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-30F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-35F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(27.5F));
            animator.rotate(right_arm, 0, 0, (float) Math.toRadians(5F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(98.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, (float) Math.toRadians(2.5F), (float) Math.toRadians(-15F), 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(70F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(60F), (float) Math.toRadians(-5F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm, 0, 0, (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(-25F), (float) Math.toRadians(-10F));
            animator.endKeyframe();

            animator.setStaticKeyframe(5);

            animator.startKeyframe(12);
            animator.rotate(root, (float) Math.toRadians(10F), (float) Math.toRadians(-95F), 0);
            animator.rotate(upperbody, 0, (float) Math.toRadians(-37.5F), (float) Math.toRadians(-12.5F));
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(-5F), (float) Math.toRadians(22.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-82.5F), (float) Math.toRadians(-40F), (float) Math.toRadians(72.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(95F), (float) Math.toRadians(-57.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-30F));
            animator.endKeyframe();

            animator.setStaticKeyframe(6);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(35F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-37.5F), (float) Math.toRadians(15F), (float) Math.toRadians(2.5F));
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(15F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(20F), (float) Math.toRadians(50F), (float) Math.toRadians(72.5F));
            animator.rotate(right_hand, (float) Math.toRadians(2.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, (float) Math.toRadians(30F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(70F), (float) Math.toRadians(-32.5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-30F));
            animator.endKeyframe();

            animator.setStaticKeyframe(12);

            animator.resetKeyframe(15);

        } else {
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(-72.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-20F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(17.5F));
            animator.rotate(right_arm, 0, 0, (float) Math.toRadians(5F));
            animator.rotate(right_hand, (float) Math.toRadians(45F), (float) Math.toRadians(98.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, 0, (float) Math.toRadians(-15F), 0);
            animator.rotate(head, (float) Math.toRadians(5F), (float) Math.toRadians(70F), 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(2.5F), (float) Math.toRadians(42.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm, 0, 0, (float) Math.toRadians(-20F));
            animator.rotate(left_hand, (float) Math.toRadians(27.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(20F));
            animator.endKeyframe();

            animator.setStaticKeyframe(5);

            animator.startKeyframe(12);
            animator.rotate(root, (float) Math.toRadians(10F), (float) Math.toRadians(-102.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(5F), (float) Math.toRadians(-40F), (float) Math.toRadians(-2.5F));
            animator.rotate(head, (float) Math.toRadians(-10F), 0, (float) Math.toRadians(12.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-80F), (float) Math.toRadians(-37.5F), (float) Math.toRadians(62.5F));
            animator.rotate(right_hand, (float) Math.toRadians(7.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(37.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(-22.5F));
            animator.endKeyframe();

            animator.setStaticKeyframe(6);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(27.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-32.5F), (float) Math.toRadians(12.5F), (float) Math.toRadians(12.5F));
            animator.rotate(head, 0, (float) Math.toRadians(7.5F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(22.5F), (float) Math.toRadians(52.5F), (float) Math.toRadians(62.5F));
            animator.rotate(right_hand, (float) Math.toRadians(17.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(12.5F));
            animator.rotate(right_fist, (float) Math.toRadians(27.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(12.5F), (float) Math.toRadians(15F), (float) Math.toRadians(-47.5F));
            animator.endKeyframe();

            animator.setStaticKeyframe(12);

            animator.resetKeyframe(15);

        }

        animator.setAnimation(SPIN_ATTACK);
        if(!entity.getIsShieldBreak()) {
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(-75F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-12.5F), (float) Math.toRadians(-37.5F), (float) Math.toRadians(-10F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-67.5F), 0, (float) Math.toRadians(32.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-82.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(42.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(70F), (float) Math.toRadians(-5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(60F), (float) Math.toRadians(-52.5F), (float) Math.toRadians(-50F));
            animator.rotate(left_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(root, (float) Math.toRadians(-5F), (float) Math.toRadians(52.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(-5F));
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(25F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-72.5F), 0, (float) Math.toRadians(40F));
            animator.rotate(right_hand, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-30F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(10F), (float) Math.toRadians(10F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-32.5F), (float) Math.toRadians(15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(1);
            animator.startKeyframe(6);
            animator.rotate(root, 0, (float) Math.toRadians(357.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(-5F));
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(25F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(2F), (float) Math.toRadians(25F), (float) Math.toRadians(50F));
            animator.rotate(right_hand, (float) Math.toRadians(7.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(62.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(12.5F), (float) Math.toRadians(-45F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(-2.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(-5F));
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(25F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(2F), (float) Math.toRadians(25F), (float) Math.toRadians(50F));
            animator.rotate(right_hand, (float) Math.toRadians(7.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(62.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(12.5F), (float) Math.toRadians(-45F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.resetKeyframe(10);

        }else{
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(-82.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-40F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-65F), (float) Math.toRadians(2.5F), (float) Math.toRadians(22.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-72.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(42.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(75F), (float) Math.toRadians(-15F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(2.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-65F));
            animator.rotate(left_hand, (float) Math.toRadians(7.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(root, (float) Math.toRadians(-5F), (float) Math.toRadians(45F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(12.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
            animator.rotate(head, (float) Math.toRadians(-12.5F), (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-75F), (float) Math.toRadians(2.5F), (float) Math.toRadians(30F));
            animator.rotate(right_hand, (float) Math.toRadians(2.5F), (float) Math.toRadians(-30F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-47.5F), (float) Math.toRadians(57.5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_hand, (float) Math.toRadians(15F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(1);
            animator.startKeyframe(6);
            animator.rotate(root, 0, (float) Math.toRadians(350F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(22.5F), (float) Math.toRadians(27.5F), (float) Math.toRadians(40F));
            animator.rotate(right_hand, (float) Math.toRadians(17.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(60F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-45F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(15F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(-10F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(22.5F), (float) Math.toRadians(27.5F), (float) Math.toRadians(40F));
            animator.rotate(right_hand, (float) Math.toRadians(17.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(30F));
            animator.rotate(right_fist, (float) Math.toRadians(60F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-45F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(15F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.resetKeyframe(10);
        }

        animator.setAnimation(MAGIC_ATTACK);
        if(!entity.getIsShieldBreak()) {
            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-37.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-122.5F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-10F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(60F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(52.5F), (float) Math.toRadians(-10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(57.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(22.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), 0, (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-45F), (float) Math.toRadians(12.5F), (float) Math.toRadians(30F));
            animator.rotate(right_arm, (float) Math.toRadians(27.5F), 0, 0);
            animator.rotate(right_hand, (float) Math.toRadians(-30F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(37.5F));
            animator.rotate(right_fist, (float) Math.toRadians(7.5F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(-5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(62.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(7.5F));
            animator.rotate(left_arm, 0, (float) Math.toRadians(5F), (float) Math.toRadians(-30F));
            animator.rotate(left_hand, (float) Math.toRadians(-75F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(-47.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(12.5F), (float) Math.toRadians(7.5F));
            animator.rotate(right_arm, (float) Math.toRadians(-27.5F), (float) Math.toRadians(15F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(10F), (float) Math.toRadians(-25F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(47.5F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-12.5F), (float) Math.toRadians(60F), (float) Math.toRadians(-22.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(57.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-42.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.resetKeyframe(10);
        }else{
            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-45F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(-20F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-120F), (float) Math.toRadians(15F), (float) Math.toRadians(-10F));
            animator.rotate(right_hand, (float) Math.toRadians(7.5F), (float) Math.toRadians(-10F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(57.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(57.5F), (float) Math.toRadians(-20F));
            animator.rotate(left_arm_joint, 0, (float) Math.toRadians(32.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(42.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(15F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(15F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-42.5F), (float) Math.toRadians(15F), (float) Math.toRadians(20F));
            animator.rotate(right_arm, (float) Math.toRadians(27.5F), 0, 0);
            animator.rotate(right_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(37.5F));
            animator.rotate(right_fist, (float) Math.toRadians(5F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(-15F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_arm, 0, (float) Math.toRadians(5F), (float) Math.toRadians(-30F));
            animator.rotate(left_hand, (float) Math.toRadians(-27.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(-55F), 0);
            animator.rotate(upperbody, 0, (float) Math.toRadians(-25F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-52.5F), (float) Math.toRadians(15F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm, (float) Math.toRadians(-27.5F), (float) Math.toRadians(15F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(20F), (float) Math.toRadians(-25F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(45F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-17.5F), (float) Math.toRadians(65F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_arm_joint, 0, (float) Math.toRadians(32.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.resetKeyframe(10);
        }

        animator.setAnimation(EARTH_SHUDDERS_ATTACK);
        if(!entity.getIsShieldBreak()) {
            animator.startKeyframe(15);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-67.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-15F), (float) Math.toRadians(-20F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-82.5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(35F));
            animator.rotate(right_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(80F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(30F), (float) Math.toRadians(-30F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-25F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(13);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(-67.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-30F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(37.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_hand, (float) Math.toRadians(-60F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-5F), (float) Math.toRadians(-12.5F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(80F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(30F), (float) Math.toRadians(-30F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-25F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(9);
            animator.rotate(root, 0, (float) Math.toRadians(-72.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-12.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-57.5F), (float) Math.toRadians(40F), (float) Math.toRadians(-7.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-5F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(80F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(27.5F), (float) Math.toRadians(-32.5F), (float) Math.toRadians(-10F));
            animator.rotate(left_hand, (float) Math.toRadians(-25F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.startKeyframe(11);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-67.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-15F), (float) Math.toRadians(-20F), (float) Math.toRadians(10F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-82.5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(35F));
            animator.rotate(right_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(80F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(30F), (float) Math.toRadians(-30F), (float) Math.toRadians(-15F));
            animator.rotate(left_hand, (float) Math.toRadians(-25F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(8);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(-72.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(10F), (float) Math.toRadians(-15F), (float) Math.toRadians(-32.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-45F), (float) Math.toRadians(35F), (float) Math.toRadians(-5F));
            animator.rotate(right_hand, (float) Math.toRadians(-57.5F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-7.5F), 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(80F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(30F), (float) Math.toRadians(-30F), (float) Math.toRadians(2.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-25F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(12);

            animator.startKeyframe(12);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-67.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-15F), (float) Math.toRadians(-20F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-82.5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(35F));
            animator.rotate(right_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(80F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(30F), (float) Math.toRadians(-30F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-25F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(17);

            animator.startKeyframe(3);
            animator.rotate(root, 0, (float) Math.toRadians(-67.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-30F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(37.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_hand, (float) Math.toRadians(-60F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-5F), (float) Math.toRadians(-12.5F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(80F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(30F), (float) Math.toRadians(-30F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-25F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.resetKeyframe(10);
        }else{
            animator.startKeyframe(15);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-75F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(10F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-80F), (float) Math.toRadians(35F), (float) Math.toRadians(25F));
            animator.rotate(right_hand, (float) Math.toRadians(-30F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(85F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(17.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(22.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(13);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(-75F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(12.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(-20F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-52.5F), (float) Math.toRadians(40F), (float) Math.toRadians(-15F));
            animator.rotate(right_hand, (float) Math.toRadians(-50F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-12.5F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(85F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(17.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(22.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(9);
            animator.rotate(root, 0, (float) Math.toRadians(-80F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(15F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(42.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-37.5F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-5F), (float) Math.toRadians(-5F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(85F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-30F), (float) Math.toRadians(15F), (float) Math.toRadians(-25F));
            animator.rotate(left_hand, (float) Math.toRadians(22.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.startKeyframe(11);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-75F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(20F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-80F), (float) Math.toRadians(35F), (float) Math.toRadians(25F));
            animator.rotate(right_hand, (float) Math.toRadians(-30F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(85F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(17.5F), (float) Math.toRadians(-15F));
            animator.rotate(left_hand, (float) Math.toRadians(22.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(8);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(-80F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(15F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-22.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-47.5F), (float) Math.toRadians(37.5F), (float) Math.toRadians(-15F));
            animator.rotate(right_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-7.5F), 0);
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(80F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(17.5F), (float) Math.toRadians(-12.5F));
            animator.rotate(left_hand, (float) Math.toRadians(22.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(12);

            animator.startKeyframe(12);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-75F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(10F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-80F), (float) Math.toRadians(35F), (float) Math.toRadians(25F));
            animator.rotate(right_hand, (float) Math.toRadians(-30F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(85F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(17.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(22.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(17);

            animator.startKeyframe(3);
            animator.rotate(root, 0, (float) Math.toRadians(-75F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(12.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(-20F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-52.5F), (float) Math.toRadians(40F), (float) Math.toRadians(-15F));
            animator.rotate(right_hand, (float) Math.toRadians(-50F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-12.5F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(85F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(17.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(22.5F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.resetKeyframe(10);
        }

        animator.setAnimation(REINFORCED_SMASH_IN_AIR);
        if(!entity.getIsShieldBreak()) {
            animator.startKeyframe(10);
            animator.rotate(root, (float) Math.toRadians(7.5F), (float) Math.toRadians(-77.5F), 0);
            animator.rotate(upperbody, 0, (float) Math.toRadians(-20F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(-32.5F), (float) Math.toRadians(45F));
            animator.rotate(right_hand, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-35F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(30F), 0, 0);
            animator.rotate(head, 0, (float) Math.toRadians(72.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(40F), (float) Math.toRadians(-30F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(6);
            animator.rotate(root, (float) Math.toRadians(5F), (float) Math.toRadians(40F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-30F), (float) Math.toRadians(-10F), (float) Math.toRadians(-12.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-87.5F), (float) Math.toRadians(62.5F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(-35F), (float) Math.toRadians(-10F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(55F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(15F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(40F), (float) Math.toRadians(-77.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-67.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-22.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-145F), (float) Math.toRadians(30F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(-57.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(12.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(12.5F), (float) Math.toRadians(52.5F), (float) Math.toRadians(-10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-15F), (float) Math.toRadians(-77.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(7);

            animator.startKeyframe(3);
            animator.rotate(root, 0, (float) Math.toRadians(-72.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-17.5F), (float) Math.toRadians(30F), (float) Math.toRadians(-10F));
            animator.rotate(right_hand, 0, (float) Math.toRadians(2.5F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(12.5F), (float) Math.toRadians(52.5F), (float) Math.toRadians(-10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-82.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-70F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-22.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-10F), (float) Math.toRadians(20F), (float) Math.toRadians(55F));
            animator.rotate(right_hand, (float) Math.toRadians(-52.5F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(12.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(12.5F), (float) Math.toRadians(52.5F), (float) Math.toRadians(-10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(50F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(6);
            animator.rotate(root, 0, (float) Math.toRadians(35F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(-10F), (float) Math.toRadians(-22.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(35F), (float) Math.toRadians(20F));
            animator.rotate(right_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(12.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(7.5F), 0, (float) Math.toRadians(20F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-20F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(60);

            animator.resetKeyframe(10);
        }else{
            animator.startKeyframe(10);
            animator.rotate(root, (float) Math.toRadians(7.5F), (float) Math.toRadians(-85F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(10F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-52.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(35F));
            animator.rotate(right_hand, (float) Math.toRadians(-22.5F), (float) Math.toRadians(-35F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(27.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(77.5F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-17.5F), (float) Math.toRadians(17.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(6);
            animator.rotate(root, (float) Math.toRadians(5F), (float) Math.toRadians(32.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-25F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-85F), (float) Math.toRadians(65F), (float) Math.toRadians(-10F));
            animator.rotate(right_hand, (float) Math.toRadians(-25F), (float) Math.toRadians(-10F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(52.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(10F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-75F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(17.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-142.5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-10F));
            animator.rotate(right_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(7.5F), (float) Math.toRadians(57.5F), (float) Math.toRadians(-20F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-72.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(7);

            animator.startKeyframe(3);
            animator.rotate(root, 0, (float) Math.toRadians(-80F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-15F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-20F));
            animator.rotate(right_hand, (float) Math.toRadians(10F), (float) Math.toRadians(2.5F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(7.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(7.5F), (float) Math.toRadians(57.5F), (float) Math.toRadians(-20F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-60F), (float) Math.toRadians(-35F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-77.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(2.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-12.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-7.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(45F));
            animator.rotate(right_hand, (float) Math.toRadians(-42.5F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(7.5F), (float) Math.toRadians(57.5F), (float) Math.toRadians(-20F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-7.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-42.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(6);
            animator.rotate(root, 0, (float) Math.toRadians(27.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(-12.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-25F), (float) Math.toRadians(37.5F), (float) Math.toRadians(10F));
            animator.rotate(right_hand, (float) Math.toRadians(-10F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(5F), (float) Math.toRadians(10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-77.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(60);

            animator.resetKeyframe(10);
        }

        animator.setAnimation(REINFORCED_SMASH_IN_AIR_SOUL);
        if(!entity.getIsShieldBreak()) {
            animator.startKeyframe(10);
            animator.rotate(root, (float) Math.toRadians(7.5F), (float) Math.toRadians(-77.5F), 0);
            animator.rotate(upperbody, 0, (float) Math.toRadians(-20F), 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(-32.5F), (float) Math.toRadians(45F));
            animator.rotate(right_hand, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-35F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(30F), 0, 0);
            animator.rotate(head, 0, (float) Math.toRadians(72.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(40F), (float) Math.toRadians(-30F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(6);
            animator.rotate(root, (float) Math.toRadians(5F), (float) Math.toRadians(40F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-30F), (float) Math.toRadians(-10F), (float) Math.toRadians(-12.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-87.5F), (float) Math.toRadians(62.5F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(-35F), (float) Math.toRadians(-10F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(55F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(15F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(40F), (float) Math.toRadians(-77.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-67.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-22.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-145F), (float) Math.toRadians(30F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(-57.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(12.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(12.5F), (float) Math.toRadians(52.5F), (float) Math.toRadians(-10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-15F), (float) Math.toRadians(-77.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(7);

            animator.startKeyframe(3);
            animator.rotate(root, 0, (float) Math.toRadians(-72.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-17.5F), (float) Math.toRadians(30F), (float) Math.toRadians(-10F));
            animator.rotate(right_hand, 0, (float) Math.toRadians(2.5F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(12.5F), (float) Math.toRadians(52.5F), (float) Math.toRadians(-10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-82.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-70F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-22.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-10F), (float) Math.toRadians(20F), (float) Math.toRadians(55F));
            animator.rotate(right_hand, (float) Math.toRadians(-52.5F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(12.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(12.5F), (float) Math.toRadians(52.5F), (float) Math.toRadians(-10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(50F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(6);
            animator.rotate(root, 0, (float) Math.toRadians(35F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(-10F), (float) Math.toRadians(-22.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(35F), (float) Math.toRadians(20F));
            animator.rotate(right_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(12.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(7.5F), 0, (float) Math.toRadians(20F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-20F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(60);

            animator.resetKeyframe(10);
        }else{
            animator.startKeyframe(10);
            animator.rotate(root, (float) Math.toRadians(7.5F), (float) Math.toRadians(-85F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(10F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-52.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(35F));
            animator.rotate(right_hand, (float) Math.toRadians(-22.5F), (float) Math.toRadians(-35F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(27.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(77.5F), (float) Math.toRadians(-27.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-17.5F), (float) Math.toRadians(17.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(6);
            animator.rotate(root, (float) Math.toRadians(5F), (float) Math.toRadians(32.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-25F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(-2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-85F), (float) Math.toRadians(65F), (float) Math.toRadians(-10F));
            animator.rotate(right_hand, (float) Math.toRadians(-25F), (float) Math.toRadians(-10F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(52.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(10F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-75F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(17.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-142.5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-10F));
            animator.rotate(right_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(7.5F), (float) Math.toRadians(57.5F), (float) Math.toRadians(-20F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-72.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(7);

            animator.startKeyframe(3);
            animator.rotate(root, 0, (float) Math.toRadians(-80F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-15F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-20F));
            animator.rotate(right_hand, (float) Math.toRadians(10F), (float) Math.toRadians(2.5F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(7.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(7.5F), (float) Math.toRadians(57.5F), (float) Math.toRadians(-20F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-60F), (float) Math.toRadians(-35F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, 0, (float) Math.toRadians(-77.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(2.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-12.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-7.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(45F));
            animator.rotate(right_hand, (float) Math.toRadians(-42.5F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(7.5F), (float) Math.toRadians(57.5F), (float) Math.toRadians(-20F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-7.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-42.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(6);
            animator.rotate(root, 0, (float) Math.toRadians(27.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(-12.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-25F), (float) Math.toRadians(37.5F), (float) Math.toRadians(10F));
            animator.rotate(right_hand, (float) Math.toRadians(-10F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(5F), (float) Math.toRadians(10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-77.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(60);

            animator.resetKeyframe(10);
        }


        animator.setAnimation(REINFORCED_SMASH);
        if(!entity.getIsShieldBreak()) {
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(35F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(-10F), (float) Math.toRadians(-22.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(35F), (float) Math.toRadians(20F));
            animator.rotate(right_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(12.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(7.5F), 0, (float) Math.toRadians(20F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-20F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.startKeyframe(8);
            animator.rotate(root, 0, (float) Math.toRadians(35F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(10F), (float) Math.toRadians(-10F), (float) Math.toRadians(7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-45F), (float) Math.toRadians(65F), (float) Math.toRadians(20F));
            animator.rotate(right_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(12.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-25F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(-22.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-22.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-67.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(35F));
            animator.rotate(right_hand, (float) Math.toRadians(-50F), (float) Math.toRadians(20F), (float) Math.toRadians(-45F));
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), (float) Math.toRadians(-27.5F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(60F), (float) Math.toRadians(-55F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(-50F), 0);
            animator.rotate(upperbody, 0, (float) Math.toRadians(-27.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-52.5F), (float) Math.toRadians(-57.5F), (float) Math.toRadians(80F));
            animator.rotate(right_hand, (float) Math.toRadians(-30F), (float) Math.toRadians(90F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), (float) Math.toRadians(30F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(7.5F), (float) Math.toRadians(47.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(65F), (float) Math.toRadians(-75F), (float) Math.toRadians(-25F));
            animator.rotate(left_hand, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(20);
            //13

            animator.startKeyframe(30);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(17.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-25F), (float) Math.toRadians(12.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-75F), (float) Math.toRadians(7.5F), (float) Math.toRadians(35F));
            animator.rotate(right_hand, (float) Math.toRadians(-60F), (float) Math.toRadians(22.5F), (float) Math.toRadians(-45F));
            animator.rotate(right_fist, (float) Math.toRadians(-37.5F), (float) Math.toRadians(20F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(55F), (float) Math.toRadians(-67.5F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(8);

            animator.resetKeyframe(10);
        }else{
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(27.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(-12.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-25F), (float) Math.toRadians(32.5F), (float) Math.toRadians(10F));
            animator.rotate(right_hand, (float) Math.toRadians(-10F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(5F), (float) Math.toRadians(10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-77.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.startKeyframe(8);
            animator.rotate(root, 0, (float) Math.toRadians(27.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(25F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(37.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-42.5F), (float) Math.toRadians(70F), (float) Math.toRadians(10F));
            animator.rotate(right_hand, (float) Math.toRadians(-12.5F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-30F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(-5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-37.5F), (float) Math.toRadians(45F), (float) Math.toRadians(-42.5F));
            animator.rotate(left_hand, (float) Math.toRadians(80F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-17.5F), (float) Math.toRadians(5F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-65F), (float) Math.toRadians(5F), (float) Math.toRadians(25F));
            animator.rotate(right_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(20F), (float) Math.toRadians(-45F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), (float) Math.toRadians(-27.5F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(2.5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(-57.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-50F), (float) Math.toRadians(-55F), (float) Math.toRadians(70F));
            animator.rotate(right_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(90F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), (float) Math.toRadians(30F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(52.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(7.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-40F));
            animator.rotate(left_hand, (float) Math.toRadians(15F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(20);
            //13
            animator.startKeyframe(30);
            animator.rotate(root, (float) Math.toRadians(-2.5F), 0, 0);
            animator.rotate(upperbody, (float) Math.toRadians(-20F), (float) Math.toRadians(10F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-72.5F), (float) Math.toRadians(10F), (float) Math.toRadians(25F));
            animator.rotate(right_hand, (float) Math.toRadians(-50F), (float) Math.toRadians(22.5F), (float) Math.toRadians(-45F));
            animator.rotate(right_fist, (float) Math.toRadians(-40F), (float) Math.toRadians(20F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(8);

            animator.resetKeyframe(10);
        }

        animator.setAnimation(REINFORCED_SMASH_SOUL);
        if(!entity.getIsShieldBreak()) {
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(35F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(-10F), (float) Math.toRadians(-22.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-27.5F), (float) Math.toRadians(35F), (float) Math.toRadians(20F));
            animator.rotate(right_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(12.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(7.5F), 0, (float) Math.toRadians(20F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-20F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.startKeyframe(8);
            animator.rotate(root, 0, (float) Math.toRadians(35F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(10F), (float) Math.toRadians(-10F), (float) Math.toRadians(7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-45F), (float) Math.toRadians(65F), (float) Math.toRadians(20F));
            animator.rotate(right_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(12.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-25F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(-22.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(12.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-22.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-67.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(35F));
            animator.rotate(right_hand, (float) Math.toRadians(-50F), (float) Math.toRadians(20F), (float) Math.toRadians(-45F));
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), (float) Math.toRadians(-27.5F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(60F), (float) Math.toRadians(-55F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(-50F), 0);
            animator.rotate(upperbody, 0, (float) Math.toRadians(-27.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-52.5F), (float) Math.toRadians(-57.5F), (float) Math.toRadians(80F));
            animator.rotate(right_hand, (float) Math.toRadians(-30F), (float) Math.toRadians(90F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), (float) Math.toRadians(30F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(7.5F), (float) Math.toRadians(47.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(65F), (float) Math.toRadians(-75F), (float) Math.toRadians(-25F));
            animator.rotate(left_hand, (float) Math.toRadians(-32.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(20);
            //13
            animator.startKeyframe(30);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(17.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-25F), (float) Math.toRadians(12.5F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-75F), (float) Math.toRadians(7.5F), (float) Math.toRadians(35F));
            animator.rotate(right_hand, (float) Math.toRadians(-60F), (float) Math.toRadians(22.5F), (float) Math.toRadians(-45F));
            animator.rotate(right_fist, (float) Math.toRadians(-37.5F), (float) Math.toRadians(20F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(2.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(55F), (float) Math.toRadians(-67.5F), (float) Math.toRadians(-2.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(8);

            animator.resetKeyframe(10);
        }else{
            animator.startKeyframe(0);
            animator.rotate(root, 0, (float) Math.toRadians(27.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(-12.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-25F), (float) Math.toRadians(32.5F), (float) Math.toRadians(10F));
            animator.rotate(right_hand, (float) Math.toRadians(-10F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(5F), (float) Math.toRadians(10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-77.5F), (float) Math.toRadians(5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.startKeyframe(8);
            animator.rotate(root, 0, (float) Math.toRadians(27.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(25F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(37.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-42.5F), (float) Math.toRadians(70F), (float) Math.toRadians(10F));
            animator.rotate(right_hand, (float) Math.toRadians(-12.5F), (float) Math.toRadians(-25F), (float) Math.toRadians(22.5F));
            animator.rotate(right_fist, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-30F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(-5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-37.5F), (float) Math.toRadians(45F), (float) Math.toRadians(-42.5F));
            animator.rotate(left_hand, (float) Math.toRadians(80F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(10);
            animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-17.5F), (float) Math.toRadians(5F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-65F), (float) Math.toRadians(5F), (float) Math.toRadians(25F));
            animator.rotate(right_hand, (float) Math.toRadians(-40F), (float) Math.toRadians(20F), (float) Math.toRadians(-45F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), (float) Math.toRadians(-27.5F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(7.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(2.5F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(30F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(15);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(-57.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-50F), (float) Math.toRadians(-55F), (float) Math.toRadians(70F));
            animator.rotate(right_hand, (float) Math.toRadians(-20F), (float) Math.toRadians(90F), (float) Math.toRadians(15F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), (float) Math.toRadians(30F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(52.5F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(7.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-40F));
            animator.rotate(left_hand, (float) Math.toRadians(15F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);
            //13
            animator.startKeyframe(30);
            animator.rotate(root, (float) Math.toRadians(-2.5F), 0, 0);
            animator.rotate(upperbody, (float) Math.toRadians(-20F), (float) Math.toRadians(10F), (float) Math.toRadians(5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-72.5F), (float) Math.toRadians(10F), (float) Math.toRadians(25F));
            animator.rotate(right_hand, (float) Math.toRadians(-50F), (float) Math.toRadians(22.5F), (float) Math.toRadians(-45F));
            animator.rotate(right_fist, (float) Math.toRadians(-40F), (float) Math.toRadians(20F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-20F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(8);

            animator.resetKeyframe(10);
        }

        animator.setAnimation(SHIELD_BREAK_COUNTER);
        animator.startKeyframe(8);
        animator.rotate(root, 0, (float) Math.toRadians(-50F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-2.5F));
        animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(62.5F), (float) Math.toRadians(-12.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-45F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(-5F));
        animator.move(right_arm_joint, 0, 0, 2);
        animator.rotate(right_hand, (float) Math.toRadians(-5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-10F));
        animator.rotate(right_fist, (float) Math.toRadians(-25F), (float) Math.toRadians(-15F), 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(-75F), (float) Math.toRadians(90F), (float) Math.toRadians(-7.5F));
        animator.rotate(left_hand, (float) Math.toRadians(47.5F), (float) Math.toRadians(27.5F), (float) Math.toRadians(37.5F));
        animator.endKeyframe();

        animator.setStaticKeyframe(30);

        animator.resetKeyframe(15);

        animator.setAnimation(SHIELD_BREAK_STRIKE);
        animator.startKeyframe(0);
        animator.rotate(root, 0, (float) Math.toRadians(-50F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-30F), (float) Math.toRadians(-2.5F));
        animator.rotate(head, (float) Math.toRadians(2.5F), (float) Math.toRadians(62.5F), (float) Math.toRadians(-12.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-45F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(-5F));
        animator.move(right_arm_joint, 0, 0, 2);
        animator.rotate(right_hand, (float) Math.toRadians(-5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-10F));
        animator.rotate(right_fist, (float) Math.toRadians(-25F), (float) Math.toRadians(-15F), 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(-75F), (float) Math.toRadians(90F), (float) Math.toRadians(-7.5F));
        animator.rotate(left_hand, (float) Math.toRadians(47.5F), (float) Math.toRadians(27.5F), (float) Math.toRadians(37.5F));
        animator.endKeyframe();

        animator.startKeyframe(12);
        animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-25F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-27.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
        animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-90F), (float) Math.toRadians(2.5F), (float) Math.toRadians(35F));
        animator.rotate(right_hand, (float) Math.toRadians(-30F), 0, 0);
        animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(-82.5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-52.5F));
        animator.rotate(left_hand, (float) Math.toRadians(15F), 0, (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.setStaticKeyframe(3);

        animator.startKeyframe(3);
        animator.rotate(root, (float) Math.toRadians(5F), (float) Math.toRadians(-25F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(12.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
        animator.rotate(head, (float) Math.toRadians(-20F), (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
        animator.rotate(right_arm_joint, 0, (float) Math.toRadians(57.5F), 0);
        animator.rotate(right_hand, (float) Math.toRadians(-30F), 0, 0);
        animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(7.5F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(-17.5F));
        animator.rotate(left_hand, (float) Math.toRadians(15F), 0, (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.setStaticKeyframe(8);

        animator.startKeyframe(6);
        animator.rotate(root, (float) Math.toRadians(-2.5F), (float) Math.toRadians(-87.5F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(12.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
        animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(80F), (float) Math.toRadians(-42.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-45F), (float) Math.toRadians(7.5F), (float) Math.toRadians(40F));
        animator.rotate(right_hand, (float) Math.toRadians(-22.5F), 0, (float) Math.toRadians(47.5F));
        animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(42.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(17.5F));
        animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.setStaticKeyframe(5);

        animator.startKeyframe(8);
        animator.rotate(root, 0, (float) Math.toRadians(295F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(20F), (float) Math.toRadians(30F), (float) Math.toRadians(20F));
        animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-22.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-20F), (float) Math.toRadians(90F), (float) Math.toRadians(27.5F));
        animator.rotate(right_hand, (float) Math.toRadians(47.5F), (float) Math.toRadians(-47.5F), (float) Math.toRadians(22.5F));
        animator.rotate(right_fist, (float) Math.toRadians(42.5F), 0, 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(-25F), (float) Math.toRadians(57.5F), (float) Math.toRadians(-35F));
        animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.startKeyframe(0);
        animator.rotate(root, 0, (float) Math.toRadians(-65F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(20F), (float) Math.toRadians(30F), (float) Math.toRadians(20F));
        animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-22.5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-20F), (float) Math.toRadians(90F), (float) Math.toRadians(27.5F));
        animator.rotate(right_hand, (float) Math.toRadians(47.5F), (float) Math.toRadians(-47.5F), (float) Math.toRadians(22.5F));
        animator.rotate(right_fist, (float) Math.toRadians(42.5F), 0, 0);
        animator.rotate(left_arm_joint, (float) Math.toRadians(-25F), (float) Math.toRadians(57.5F), (float) Math.toRadians(-35F));
        animator.rotate(left_hand, 0, 0, (float) Math.toRadians(15F));
        animator.endKeyframe();

        animator.setStaticKeyframe(10);

        animator.resetKeyframe(10);

        animator.setAnimation(ULTIMATE_ATTACK);
        animator.startKeyframe(18);
        animator.rotate(root, 0, (float) Math.toRadians(-25F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-122.5F), (float) Math.toRadians(-47.5F), (float) Math.toRadians(7.5F));
        animator.rotate(right_hand, (float) Math.toRadians(45F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(-5F));
        animator.rotate(right_fist, (float) Math.toRadians(-25F), (float) Math.toRadians(-2.5F), 0);
        animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-120F), (float) Math.toRadians(82.5F), (float) Math.toRadians(-25F));
        animator.rotate(left_hand, (float) Math.toRadians(90F), (float) Math.toRadians(15F), (float) Math.toRadians(22.5F));
        animator.endKeyframe();

        animator.setStaticKeyframe(8);

        animator.startKeyframe(18);
        animator.rotate(root, 0, (float) Math.toRadians(-25F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-25F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-132.5F), (float) Math.toRadians(-47.5F), (float) Math.toRadians(12.5F));
        animator.rotate(right_hand, (float) Math.toRadians(65F), (float) Math.toRadians(22.5F), (float) Math.toRadians(-5F));
        animator.rotate(right_fist, (float) Math.toRadians(-20F), (float) Math.toRadians(5F), (float) Math.toRadians(10F));
        animator.rotate(sword, (float) Math.toRadians(2.5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(57.5F));
        animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-100F), (float) Math.toRadians(87.5F), (float) Math.toRadians(-20F));
        animator.rotate(left_hand, (float) Math.toRadians(92.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(32.5F));
        animator.rotate(left_fist, 0, 0, (float) Math.toRadians(65F));
        animator.endKeyframe();

        animator.setStaticKeyframe(8);

        animator.startKeyframe(15);
        animator.rotate(root, 0, (float) Math.toRadians(-25F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(-30F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-157.5F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(35F));
        animator.rotate(right_hand, (float) Math.toRadians(40F), (float) Math.toRadians(-5F), (float) Math.toRadians(-5F));
        animator.rotate(right_fist, (float) Math.toRadians(-25F), (float) Math.toRadians(-25F), 0);
        animator.rotate(sword, (float) Math.toRadians(5F), (float) Math.toRadians(10F), (float) Math.toRadians(57.5F));
        animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-145F), (float) Math.toRadians(60F), (float) Math.toRadians(-52.5F));
        animator.rotate(left_hand, (float) Math.toRadians(65F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-2.5F));
        animator.endKeyframe();

        animator.setStaticKeyframe(5);

        animator.startKeyframe(2);
        animator.rotate(root, (float) Math.toRadians(25F), (float) Math.toRadians(-25F), 0);
        animator.rotate(upperbody, (float) Math.toRadians(15F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(5F));
        animator.rotate(right_arm_joint, (float) Math.toRadians(-67.5F), (float) Math.toRadians(-40F), (float) Math.toRadians(-20F));
        animator.move(right_arm_joint, 0, -1, -2);
        animator.rotate(right_hand, (float) Math.toRadians(25F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(17.5F));
        animator.move(right_hand, 2, 4, -2);
        animator.rotate(right_fist, (float) Math.toRadians(7.5F), (float) Math.toRadians(27.5F), (float) Math.toRadians(-15F));
        animator.rotate(sword, 0, 0, (float) Math.toRadians(50F));
        animator.rotate(head, (float) Math.toRadians(-30F), (float) Math.toRadians(30F), (float) Math.toRadians(-12.5F));
        animator.rotate(left_arm_joint, (float) Math.toRadians(-57.5F), (float) Math.toRadians(80F), (float) Math.toRadians(27.5F));
        animator.move(left_arm_joint, 1, -1, -2);
        animator.rotate(left_hand, (float) Math.toRadians(90F), (float) Math.toRadians(10F), (float) Math.toRadians(-5F));
        animator.move(left_hand, -2, 4, 2);
        animator.endKeyframe();

        animator.setStaticKeyframe(20);

        animator.resetKeyframe(20);

        animator.setAnimation(Ignis_Entity.IGNIS_DEATH);
        if(entity.getIsBlocking()) {
            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-57.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-15F), (float) Math.toRadians(-17.5F), 0);
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(62.5F), (float) Math.toRadians(-10F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-72.5F), (float) Math.toRadians(17.5F), (float) Math.toRadians(55F));
            animator.rotate(right_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(37.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(40F), (float) Math.toRadians(-22.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.startKeyframe(5);
            animator.rotate(root, 0, (float) Math.toRadians(-62.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-20F), (float) Math.toRadians(-15F), (float) Math.toRadians(2.5F));
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(72.5F), (float) Math.toRadians(-10F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-77.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(57.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-22.5F), (float) Math.toRadians(37.5F), (float) Math.toRadians(2.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-22.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(-62.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-12.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-7.5F));
            animator.rotate(head, (float) Math.toRadians(-2.5F), (float) Math.toRadians(72.5F), (float) Math.toRadians(-10F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-12.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(2.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-50F), (float) Math.toRadians(37.5F), (float) Math.toRadians(2.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-22.5F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(35F), (float) Math.toRadians(-27.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-22.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(80);
        }else if (entity.getIsSword()) {
            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-65F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-10F), (float) Math.toRadians(-20F), (float) Math.toRadians(10F));
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(77.5F), (float) Math.toRadians(-20F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-70F), (float) Math.toRadians(20F), (float) Math.toRadians(45F));
            animator.rotate(right_hand, (float) Math.toRadians(-2.5F), (float) Math.toRadians(37.5F), 0);
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-17.5F), (float) Math.toRadians(25F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(25F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.startKeyframe(5);
            animator.rotate(root, 0, (float) Math.toRadians(-70F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-15F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(12.5F));
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(77.5F), (float) Math.toRadians(-20F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-75F), (float) Math.toRadians(25F), (float) Math.toRadians(47.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-7.5F), (float) Math.toRadians(37.5F), (float) Math.toRadians(2.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-22.5F), (float) Math.toRadians(20F), (float)Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(25F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(-70F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-7.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(2.5F));
            animator.rotate(head, (float) Math.toRadians(-7.5F), (float) Math.toRadians(77.5F), (float) Math.toRadians(-20F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-10F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-35F), (float) Math.toRadians(37.5F), (float) Math.toRadians(2.5F));
            animator.rotate(right_fist, (float) Math.toRadians(-25F), 0, 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-22.5F), (float) Math.toRadians(20F), (float) Math.toRadians(-7.5F));
            animator.rotate(left_hand, (float) Math.toRadians(25F), 0, (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(80);
        }else{
            animator.startKeyframe(15);
            animator.rotate(root, 0, (float) Math.toRadians(-40F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-15F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(5F));
            animator.rotate(head, (float) Math.toRadians(7.5F), (float) Math.toRadians(47.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-50F), (float) Math.toRadians(17.5F), (float) Math.toRadians(55F));
            animator.rotate(right_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(37.5F), 0);
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(left_arm_joint, 0, (float) Math.toRadians(-7.5F), 0);
            animator.rotate(left_hand, (float) Math.toRadians(-65F), 0, 0);
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.startKeyframe(5);
            animator.rotate(root, 0, (float) Math.toRadians(-45F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-20F), (float) Math.toRadians(-5F), (float) Math.toRadians(7.5F));
            animator.rotate(head, (float) Math.toRadians(7.5F), (float) Math.toRadians(47.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-55F), (float) Math.toRadians(22.5F), (float) Math.toRadians(57.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-52.5F), (float) Math.toRadians(37.5F), (float) Math.toRadians(2.5F));
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-5F), (float) Math.toRadians(-12.5F), 0);
            animator.rotate(left_hand, (float) Math.toRadians(-65F), 0, 0);
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.startKeyframe(4);
            animator.rotate(root, 0, (float) Math.toRadians(-45F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(-12.5F), (float) Math.toRadians(-5F), (float) Math.toRadians(-2.5F));
            animator.rotate(head, (float) Math.toRadians(7.5F), (float) Math.toRadians(47.5F), (float) Math.toRadians(-7.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(10F), (float) Math.toRadians(-10F), (float) Math.toRadians(2.5F));
            animator.rotate(right_hand, (float) Math.toRadians(-80F), (float) Math.toRadians(37.5F), (float) Math.toRadians(2.5F));
            animator.rotate(sword, (float) Math.toRadians(180F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-5F), (float) Math.toRadians(-12.5F), 0);
            animator.rotate(left_hand, (float) Math.toRadians(-65F), 0, 0);
            animator.endKeyframe();

            animator.setStaticKeyframe(80);

        }

    }

    private void poke(Ignis_Entity entity, int start, int setstatic, int reset){
        if(!entity.getIsShieldBreak()) {
            animator.startKeyframe(start);
            animator.rotate(root, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(upperbody, (float) Math.toRadians(10F), (float) Math.toRadians(30F), (float) Math.toRadians(15F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(10F), (float) Math.toRadians(20F), (float) Math.toRadians(50F));
            animator.rotate(right_hand, (float) Math.toRadians(-42.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(35F));
            animator.rotate(head, (float) Math.toRadians(-5F), (float) Math.toRadians(-12.5F), 0);
            animator.rotate(left_arm_joint, 0, (float) Math.toRadians(-45F), (float) Math.toRadians(-30F));
            animator.rotate(left_hand, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(setstatic);

            animator.startKeyframe(5);
            animator.rotate(root, 0, (float) Math.toRadians(-32.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(7.5F), (float) Math.toRadians(-42.5F), (float) Math.toRadians(-15F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-65F), (float) Math.toRadians(7.5F), (float) Math.toRadians(55F));
            animator.rotate(right_hand, (float) Math.toRadians(15F), (float) Math.toRadians(57.5F), (float) Math.toRadians(20F));
            animator.rotate(right_fist, (float) Math.toRadians(72.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(67.5F), (float) Math.toRadians(-22.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(105F), (float) Math.toRadians(-15F), (float) Math.toRadians(-17.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-62.5F), (float) Math.toRadians(-17.5F), (float) Math.toRadians(-15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);
            animator.resetKeyframe(reset);
        }else{
            animator.startKeyframe(start);
            animator.rotate(root, (float) Math.toRadians(10F), (float) Math.toRadians(-7.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(15F), (float) Math.toRadians(27.5F), (float) Math.toRadians(25F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(12.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(40F));
            animator.rotate(right_hand, (float) Math.toRadians(-27.5F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(35F));
            animator.rotate(right_fist, (float) Math.toRadians(-2.5F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(-10F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(-57.5F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-45F));
            animator.rotate(left_hand, (float) Math.toRadians(30), (float) Math.toRadians(-2.5F), (float) Math.toRadians(15F));
            animator.endKeyframe();

            animator.setStaticKeyframe(setstatic);

            animator.startKeyframe(5);
            animator.rotate(root, 0, (float) Math.toRadians(-40F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(12.5F), (float) Math.toRadians(-45F), (float) Math.toRadians(-5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-62.5F), (float) Math.toRadians(10F), (float) Math.toRadians(45F));
            animator.rotate(right_hand, (float) Math.toRadians(30F), (float) Math.toRadians(57.5F), (float) Math.toRadians(20F));
            animator.rotate(right_fist, (float) Math.toRadians(70F), 0, 0);
            animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(72.5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_arm_joint, (float) Math.toRadians(47.5F), (float) Math.toRadians(32.5F), (float) Math.toRadians(-32.5F));
            animator.rotate(left_hand, (float) Math.toRadians(-15F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(15F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);
            animator.resetKeyframe(reset);
        }
    }


    private void bodycheck(Ignis_Entity entity, int start, int setstatic, int reset){
        if(!entity.getIsShieldBreak()) {
            animator.startKeyframe(start);
            animator.rotate(root, 0, (float) Math.toRadians(65F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(10F), (float) Math.toRadians(5F), (float) Math.toRadians(-7.5F));
            animator.rotate(lowerbody, (float) Math.toRadians(7.5F), 0, (float) Math.toRadians(2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-7.5F), (float) Math.toRadians(45F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(-5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(12.5F), (float) Math.toRadians(22.5F), (float) Math.toRadians(-35F));
            animator.rotate(left_hand, (float) Math.toRadians(-5F), 0, 0);
            animator.rotate(left_fist, 0, 0, (float) Math.toRadians(40F));
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(22.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(5);
            animator.rotate(root, 0, (float) Math.toRadians(32.5F), 0);
            animator.rotate(upperbody, 0, 0, (float) Math.toRadians(-15F));
            animator.rotate(lowerbody, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-12.5F), (float) Math.toRadians(45F), 0);
            animator.rotate(right_hand, (float) Math.toRadians(-32.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(40F), (float) Math.toRadians(-57.5F), (float) Math.toRadians(5F));
            animator.rotate(left_hand, (float) Math.toRadians(-47.5F), (float) Math.toRadians(-15F), (float) Math.toRadians(-10F));
            animator.rotate(left_fist, 0, 0, (float) Math.toRadians(40F));
            animator.rotate(head, (float) Math.toRadians(-10F), (float) Math.toRadians(-12.5F), (float) Math.toRadians(22.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(setstatic);
            animator.resetKeyframe(reset);
        }else{
            animator.startKeyframe(start);
            animator.rotate(root, 0, (float) Math.toRadians(57.5F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(15F), (float) Math.toRadians(2.5F), (float) Math.toRadians(2.5F));
            animator.rotate(lowerbody, (float) Math.toRadians(7.5F), 0, (float) Math.toRadians(2.5F));
            animator.rotate(right_arm_joint, (float) Math.toRadians(-5F), (float) Math.toRadians(47.5F), (float) Math.toRadians(-10F));
            animator.rotate(right_hand, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(-2.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-45F), (float) Math.toRadians(70F), (float) Math.toRadians(-50F));
            animator.rotate(left_hand, (float) Math.toRadians(42.5F), (float) Math.toRadians(15F), (float) Math.toRadians(30F));
            animator.rotate(left_fist, 0, 0, (float) Math.toRadians(40F));
            animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(12.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(5);
            animator.rotate(root, 0, (float) Math.toRadians(25F), 0);
            animator.rotate(upperbody, (float) Math.toRadians(5F), (float) Math.toRadians(-2.5F), (float) Math.toRadians(-5F));
            animator.rotate(lowerbody, (float) Math.toRadians(10F), 0, 0);
            animator.rotate(right_arm_joint, (float) Math.toRadians(-10F), (float) Math.toRadians(47.5F), (float) Math.toRadians(-10F));
            animator.rotate(right_hand, (float) Math.toRadians(-17.5F), 0, 0);
            animator.rotate(right_fist, (float) Math.toRadians(-2.5F), 0, 0);
            animator.rotate(left_arm_joint, (float) Math.toRadians(-17.5F), (float) Math.toRadians(-10F), (float) Math.toRadians(-10F));
            animator.rotate(left_hand, 0, 0, (float) Math.toRadians(20F));
            animator.rotate(left_fist, 0, 0, (float) Math.toRadians(40F));
            animator.rotate(head, (float) Math.toRadians(-15F), (float) Math.toRadians(-7.5F), (float) Math.toRadians(12.5F));
            animator.endKeyframe();
            animator.setStaticKeyframe(setstatic);
            animator.resetKeyframe(reset);
        }
    }


    @Override
    public void setupAnim(Ignis_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        animate(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float walkSpeed = 0.5F;
        float walkDegree = 0.4F;
        float idleSpeed = 0.1F;
        float idleDegree = 0.1F;
        float partialTick = Minecraft.getInstance().getFrameTime();
        float blockingProgress = entity.prevblockingProgress + (entity.blockingProgress - entity.prevblockingProgress) * partialTick;
        float swordProgress = entity.prevswordProgress + (entity.swordProgress - entity.prevswordProgress) * partialTick;
        this.bob(root, walkSpeed * 0.2F, walkDegree * 2, false, ageInTicks, 1.0f);
        this.bob(right_arm_joint, walkSpeed * 0.15F, walkDegree * -1.2f, false, ageInTicks, 1.0f);
        this.bob(left_arm_joint, walkSpeed * 0.15F, walkDegree * -1.2f, false, ageInTicks, 1.0f);
        if(entity.getIsShieldBreak()) {
            if (swordProgress < 10) {
                this.flap(left_arm_joint, idleSpeed, idleDegree * 0.4F, false, 0, 0F, ageInTicks, 1);
                this.flap(left_hand, idleSpeed, idleDegree * 0.4F, true, 0, -0.1F, ageInTicks, 1);
                this.flap(left_fist, idleSpeed, idleDegree * 0.4F, true, 0, -0.1F, ageInTicks, 1);
                this.flap(right_arm_joint, idleSpeed, idleDegree * 0.4F, true, 0, 0F, ageInTicks, 1);
                this.flap(right_hand, idleSpeed, idleDegree * 0.4F, false, 0, -0.1F, ageInTicks, 1);
                this.flap(right_fist, idleSpeed, idleDegree * 0.4F, false, 0, -0.1F, ageInTicks, 1);
            }
        }else{
            if (blockingProgress < 10) {
                this.flap(left_arm_joint, idleSpeed, idleDegree * 0.4F, false, 0, 0F, ageInTicks, 1);
                this.flap(left_hand, idleSpeed, idleDegree * 0.4F, true, 0, -0.1F, ageInTicks, 1);
                this.flap(left_fist, idleSpeed, idleDegree * 0.4F, true, 0, -0.1F, ageInTicks, 1);
                this.flap(right_arm_joint, idleSpeed, idleDegree * 0.4F, true, 0, 0F, ageInTicks, 1);
                this.flap(right_hand, idleSpeed, idleDegree * 0.4F, false, 0, -0.1F, ageInTicks, 1);
                this.flap(right_fist, idleSpeed, idleDegree * 0.4F, false, 0, -0.1F, ageInTicks, 1);
            }
        }

        this.faceTarget(netHeadYaw, headPitch, 1, head);

        progressRotationPrev(root,blockingProgress,0, (float)Math.toRadians(17.5F), 0, 10f);
        progressRotationPrev(upperbody,blockingProgress,0, (float)Math.toRadians(10F), (float)Math.toRadians(5F), 10f);
        progressRotationPrev(head,blockingProgress,(float)Math.toRadians(10F), (float)Math.toRadians(-25F), (float)Math.toRadians(2.5F), 10f);
        progressRotationPrev(right_arm_joint,blockingProgress,(float)Math.toRadians(22.5F), 0, 0, 10f);
        progressRotationPrev(right_hand,blockingProgress,(float)Math.toRadians(-30F), 0, 0, 10f);
        progressRotationPrev(right_fist,blockingProgress,(float)Math.toRadians(22.5F), 0, 0, 10f);
        progressRotationPrev(left_arm_joint,blockingProgress,(float)Math.toRadians(-40F), (float)Math.toRadians(15F), (float)Math.toRadians(-7.5F), 10f);
        progressRotationPrev(left_hand,blockingProgress,(float)Math.toRadians(-42.5F), (float)Math.toRadians(15F), (float)Math.toRadians(15F), 10f);

        progressRotationPrev(root,swordProgress,0, (float)Math.toRadians(25F), 0, 10f);
        progressRotationPrev(upperbody,swordProgress,(float)Math.toRadians(-5F), (float)Math.toRadians(12.5F), (float)Math.toRadians(-5F), 10f);
        progressRotationPrev(head,swordProgress,(float)Math.toRadians(15F), (float)Math.toRadians(-30F), (float)Math.toRadians(12.5F), 10f);
        progressRotationPrev(right_arm_joint,swordProgress,(float)Math.toRadians(20F), (float)Math.toRadians(-2.5F), (float)Math.toRadians(10F), 10f);
        progressRotationPrev(right_hand,swordProgress,(float)Math.toRadians(-45F), 0, 0, 10f);
        progressRotationPrev(right_fist,swordProgress,(float)Math.toRadians(25F), 0, 0, 10f);
        progressRotationPrev(left_arm_joint,swordProgress,(float)Math.toRadians(17.5F), (float)Math.toRadians(-32.5F), (float)Math.toRadians(7.5F), 10f);
        progressRotationPrev(left_hand,swordProgress,(float)Math.toRadians(-90F), 0, (float)Math.toRadians(-15F), 10f);

        shield_root.showModel = entity.getShowShield();
    }

    @Override
    public Iterable<AdvancedModelPart> getAllParts() {
        return ImmutableList.of(
                root,
                upperbody,
                head,
                right_chestplate,
                lowerbody,
                lowerbody2,
                left_arm_joint,
                left_arm,
                left_guantlet,
                left_big_guantlet,
                left_hand,
                left_fist,
                right_arm_joint,
                right_arm,
                right_guantlet,
                right_big_guantlet,
                right_hand,
                right_fist,
                sword,
                handle_core,
                core,
                shield_root,
                shield
                );
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
