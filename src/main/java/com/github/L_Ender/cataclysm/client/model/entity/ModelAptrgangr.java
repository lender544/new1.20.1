package com.github.L_Ender.cataclysm.client.model.entity;

import com.github.L_Ender.cataclysm.client.animation.Aptrgangr_Animation;
import com.github.L_Ender.cataclysm.client.animation.Kobolediator_Animation;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class ModelAptrgangr extends AdvancedEntityModel<Aptrgangr_Entity> {
    private final AdvancedModelBox roots;
    private final AdvancedModelBox l_leg;
    private final AdvancedModelBox l_leg_armor;
    private final AdvancedModelBox left_leg_r1;
    private final AdvancedModelBox left_leg_r2;
    private final AdvancedModelBox r_leg;
    private final AdvancedModelBox r_leg_armor;
    private final AdvancedModelBox right_leg_r1;
    private final AdvancedModelBox right_leg_r2;
    private final AdvancedModelBox body;
    private final AdvancedModelBox chest;
    private final AdvancedModelBox neck;
    private final AdvancedModelBox head;
    private final AdvancedModelBox helmet;
    private final AdvancedModelBox head_r1;
    private final AdvancedModelBox head_r2;
    private final AdvancedModelBox head_r3;
    private final AdvancedModelBox head_r4;
    private final AdvancedModelBox head_r5;
    private final AdvancedModelBox head_r6;
    private final AdvancedModelBox jaw;
    private final AdvancedModelBox head_r7;
    private final AdvancedModelBox chestplate;
    private final AdvancedModelBox body_r1;
    private final AdvancedModelBox body_r2;
    private final AdvancedModelBox body_r3;
    private final AdvancedModelBox body_r4;
    private final AdvancedModelBox body_r5;
    private final AdvancedModelBox body_r6;
    private final AdvancedModelBox body_r7;
    private final AdvancedModelBox l_arm;
    private final AdvancedModelBox l_arm_armor;
    private final AdvancedModelBox right_arm_r1;
    private final AdvancedModelBox right_arm_r2;
    private final AdvancedModelBox right_arm_r3;
    private final AdvancedModelBox right_arm_r4;
    private final AdvancedModelBox right_arm_r5;
    private final AdvancedModelBox right_arm_r6;
    private final AdvancedModelBox arrow;
    private final AdvancedModelBox arrow2;
    private final AdvancedModelBox left_arm2;
    private final AdvancedModelBox l_arm_cloth;
    private final AdvancedModelBox r_arm;
    private final AdvancedModelBox right_arm2;
    private final AdvancedModelBox r_arm_cloth;
    private final AdvancedModelBox axe;
    private final AdvancedModelBox cube_r1;
    private final AdvancedModelBox cube_r2;
    private final AdvancedModelBox axe_head;
    private final AdvancedModelBox cube_r3;
    private final AdvancedModelBox cube_r4;
    private final AdvancedModelBox cube_r5;
    private final AdvancedModelBox cube_r6;
    private final AdvancedModelBox cube_r7;
    private final AdvancedModelBox cube_r8;
    private final AdvancedModelBox emblem3;
    private final AdvancedModelBox right_arm_r7;
    private final AdvancedModelBox emblem4;
    private final AdvancedModelBox r_arm_armor;
    private final AdvancedModelBox left_arm_r1;
    private final AdvancedModelBox left_arm_r2;
    private final AdvancedModelBox left_arm_r3;
    private final AdvancedModelBox left_arm_r4;
    private final AdvancedModelBox left_arm_r5;
    private final AdvancedModelBox left_arm_r6;
    private final AdvancedModelBox belt;
    private final AdvancedModelBox body_r8;
    private final AdvancedModelBox emblem2;
    private final AdvancedModelBox emblem;
    private final AdvancedModelBox cloth2;
    private final AdvancedModelBox cloth;


    public ModelAptrgangr() {
        texWidth = 256;
        texHeight = 256;

        roots = new AdvancedModelBox(this,"roots");
        roots.setRotationPoint(0.0F, 24.0F, 0.0F);


        l_leg = new AdvancedModelBox(this,"l_leg");
        l_leg.setRotationPoint(6.0F, -13.0F, 0.0F);
        roots.addChild(l_leg);
        l_leg.setTextureOffset(0, 69).addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F, false);

        l_leg_armor = new AdvancedModelBox(this,"l_leg_armor");
        l_leg_armor.setRotationPoint(0.0F, -2.0F, 0.0F);
        l_leg.addChild(l_leg_armor);
        l_leg_armor.setTextureOffset(39, 91).addBox(-3.5F, -1.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.4F, false);
        l_leg_armor.setTextureOffset(0, 90).addBox(-3.5F, 7.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.4F, false);
        l_leg_armor.setTextureOffset(0, 109).addBox(-0.5F, 3.0F, -6.5F, 0.0F, 4.0F, 2.0F, 0.0F, false);
        l_leg_armor.setTextureOffset(0, 141).addBox(-4.5F, 11.0F, -4.0F, 8.0F, 2.0F, 7.0F, 0.0F, true);

        left_leg_r1 = new AdvancedModelBox(this,"left_leg_r1");
        left_leg_r1.setRotationPoint(-0.5F, 6.0F, -2.6F);
        l_leg_armor.addChild(left_leg_r1);
        setRotationAngle(left_leg_r1, 0.0F, 0.0F, 0.7854F);
        left_leg_r1.setTextureOffset(0, 105).addBox(-1.0F, -1.0F, -1.5F, 6.0F, 6.0F, 0.0F, 0.0F, false);
        left_leg_r1.setTextureOffset(0, 99).addBox(-2.0F, -2.0F, -1.9F, 4.0F, 4.0F, 2.0F, 0.0F, false);

        left_leg_r2 = new AdvancedModelBox(this,"left_leg_r2");
        left_leg_r2.setRotationPoint(3.0F, -1.5F, -0.5F);
        l_leg_armor.addChild(left_leg_r2);
        setRotationAngle(left_leg_r2, 0.0F, 0.0F, -0.0873F);
        left_leg_r2.setTextureOffset(0, 128).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 7.0F, 6.0F, 0.0F, false);

        r_leg = new AdvancedModelBox(this,"r_leg");
        r_leg.setRotationPoint(-5.0F, -13.0F, 0.0F);
        roots.addChild(r_leg);
        r_leg.setTextureOffset(22, 72).addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F, false);

        r_leg_armor = new AdvancedModelBox(this,"r_leg_armor");
        r_leg_armor.setRotationPoint(-0.5F, -2.0F, -5.0F);
        r_leg.addChild(r_leg_armor);
        r_leg_armor.setTextureOffset(90, 71).addBox(-3.0F, -1.0F, 2.0F, 6.0F, 4.0F, 5.0F, 0.4F, false);
        r_leg_armor.setTextureOffset(88, 62).addBox(-3.0F, 7.0F, 2.0F, 6.0F, 4.0F, 5.0F, 0.4F, false);
        r_leg_armor.setTextureOffset(0, 141).addBox(-4.0F, 11.0F, 1.0F, 8.0F, 2.0F, 7.0F, 0.0F, false);
        r_leg_armor.setTextureOffset(0, 109).addBox(0.0F, 3.0F, -1.5F, 0.0F, 4.0F, 2.0F, 0.0F, true);

        right_leg_r1 = new AdvancedModelBox(this,"right_leg_r1");
        right_leg_r1.setRotationPoint(0.0F, 6.0F, 2.4F);
        r_leg_armor.addChild(right_leg_r1);
        setRotationAngle(right_leg_r1, 0.0F, 0.0F, -0.7854F);
        right_leg_r1.setTextureOffset(0, 105).addBox(-5.0F, -1.0F, -1.5F, 6.0F, 6.0F, 0.0F, 0.0F, true);
        right_leg_r1.setTextureOffset(0, 99).addBox(-2.0F, -2.0F, -1.9F, 4.0F, 4.0F, 2.0F, 0.0F, true);

        right_leg_r2 = new AdvancedModelBox(this,"right_leg_r2");
        right_leg_r2.setRotationPoint(-3.5F, -1.5F, 4.5F);
        r_leg_armor.addChild(right_leg_r2);
        setRotationAngle(right_leg_r2, 0.0F, 0.0F, 0.0873F);
        right_leg_r2.setTextureOffset(0, 128).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 7.0F, 6.0F, 0.0F, true);

        body = new AdvancedModelBox(this,"body");
        body.setRotationPoint(0.0F, -16.0F, 0.0F);
        roots.addChild(body);
        body.setTextureOffset(32, 60).addBox(-5.5F, -6.0F, -3.0F, 11.0F, 6.0F, 6.0F, 0.0F, false);

        chest = new AdvancedModelBox(this,"chest");
        chest.setRotationPoint(0.0F, -6.0F, 0.0F);
        body.addChild(chest);
        setRotationAngle(chest, 0.0436F, 0.0F, 0.0F);
        chest.setTextureOffset(0, 0).addBox(-9.0F, -14.0F, -6.0F, 18.0F, 14.0F, 12.0F, 0.0F, false);

        neck = new AdvancedModelBox(this,"neck");
        neck.setRotationPoint(0.0F, -14.0F, -2.45F);
        chest.addChild(neck);
        setRotationAngle(neck, 0.4363F, 0.0F, 0.0F);
        neck.setTextureOffset(80, 165).addBox(-2.5F, -4.0F, -2.55F, 5.0F, 4.0F, 5.0F, 0.0F, false);
        neck.setTextureOffset(80, 165).addBox(-2.5F, 0.0F, -2.55F, 5.0F, 4.0F, 5.0F, 0.0F, false);
        neck.setTextureOffset(100, 168).addBox(0.0F, -4.0F, 2.45F, 0.0F, 4.0F, 2.0F, 0.0F, false);

        head = new AdvancedModelBox(this,"head");
        head.setRotationPoint(0.0F, -4.0F, -0.55F);
        neck.addChild(head);
        setRotationAngle(head, -0.3927F, 0.0F, 0.0F);
        head.setTextureOffset(0, 111).addBox(-4.0F, -7.0F, -5.5F, 8.0F, 9.0F, 8.0F, 0.0F, false);

        helmet = new AdvancedModelBox(this,"helmet");
        helmet.setRotationPoint(0.0F, -5.0F, -2.0F);
        head.addChild(helmet);
        helmet.setTextureOffset(32, 113).addBox(-4.0F, -2.0F, -3.5F, 8.0F, 6.0F, 8.0F, 0.5F, false);
        helmet.setTextureOffset(102, 110).addBox(-1.5F, -2.8F, -4.3F, 3.0F, 8.0F, 10.0F, 0.0F, false);
        helmet.setTextureOffset(64, 120).addBox(-5.5F, -2.0F, -1.5F, 1.0F, 4.0F, 4.0F, 0.0F, true);
        helmet.setTextureOffset(116, 20).addBox(-10.5F, -3.5F, 0.5F, 5.0F, 5.0F, 0.0F, 0.0F, false);
        helmet.setTextureOffset(64, 120).addBox(4.5F, -2.0F, -1.5F, 1.0F, 4.0F, 4.0F, 0.0F, false);
        helmet.setTextureOffset(116, 0).addBox(4.5F, -9.5F, 0.5F, 6.0F, 11.0F, 0.0F, 0.0F, false);
        helmet.setTextureOffset(88, 98).addBox(-5.0F, 3.2F, -4.3F, 10.0F, 2.0F, 10.0F, 0.001F, false);
        helmet.setTextureOffset(62, 91).addBox(-4.0F, 5.0F, -3.5F, 8.0F, 0.0F, 8.0F, 0.0F, false);

        head_r1 = new AdvancedModelBox(this,"head_r1");
        head_r1.setRotationPoint(2.4F, 3.5F, -3.8F);
        helmet.addChild(head_r1);
        setRotationAngle(head_r1, 0.0F, 0.0F, -0.7854F);
        head_r1.setTextureOffset(28, 104).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);

        head_r2 = new AdvancedModelBox(this,"head_r2");
        head_r2.setRotationPoint(2.4F, 3.5F, -4.1F);
        helmet.addChild(head_r2);
        setRotationAngle(head_r2, 0.0F, 0.0F, -0.2618F);
        head_r2.setTextureOffset(42, 111).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);
        head_r2.setTextureOffset(44, 106).addBox(0.0F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        head_r2.setTextureOffset(43, 109).addBox(-1.0F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        head_r2.setTextureOffset(29, 115).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, 0.0F, true);

        head_r3 = new AdvancedModelBox(this,"head_r3");
        head_r3.setRotationPoint(-2.4F, 3.5F, -4.1F);
        helmet.addChild(head_r3);
        setRotationAngle(head_r3, 0.0F, 0.0F, 0.2618F);
        head_r3.setTextureOffset(43, 108).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        head_r3.setTextureOffset(32, 104).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, 0.0F, false);

        head_r4 = new AdvancedModelBox(this,"head_r4");
        head_r4.setRotationPoint(0.0F, 4.8F, -4.0F);
        helmet.addChild(head_r4);
        setRotationAngle(head_r4, 0.0F, 0.0F, -0.7854F);
        head_r4.setTextureOffset(25, 108).addBox(-0.5F, -1.5F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);

        head_r5 = new AdvancedModelBox(this,"head_r5");
        head_r5.setRotationPoint(0.0F, 6.2F, -4.0F);
        helmet.addChild(head_r5);
        setRotationAngle(head_r5, 0.0F, 0.0F, -0.7854F);
        head_r5.setTextureOffset(31, 108).addBox(-0.5F, -1.5F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);

        head_r6 = new AdvancedModelBox(this,"head_r6");
        head_r6.setRotationPoint(0.0F, 1.7F, -3.9F);
        helmet.addChild(head_r6);
        setRotationAngle(head_r6, 0.0F, 0.0F, -0.7854F);
        head_r6.setTextureOffset(30, 111).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, true);

        jaw = new AdvancedModelBox(this,"jaw");
        jaw.setRotationPoint(0.0F, -2.0F, -3.0F);
        head.addChild(jaw);
        jaw.setTextureOffset(34, 26).addBox(-3.0F, 0.0F, -2.5F, 6.0F, 8.0F, 3.0F, 0.0F, false);
        jaw.setTextureOffset(48, 0).addBox(3.0F, 3.0F, 0.0F, 6.0F, 5.0F, 0.0F, 0.0F, false);
        jaw.setTextureOffset(48, 5).addBox(3.0F, -2.0F, 0.0F, 2.0F, 5.0F, 0.0F, 0.0F, false);
        jaw.setTextureOffset(48, 5).addBox(-5.0F, -2.0F, 0.0F, 2.0F, 5.0F, 0.0F, 0.0F, true);
        jaw.setTextureOffset(48, 0).addBox(-9.0F, 3.0F, 0.0F, 6.0F, 5.0F, 0.0F, 0.0F, true);
        jaw.setTextureOffset(84, 1).addBox(3.0F, 8.0F, -2.5F, 5.0F, 4.0F, 3.0F, 0.0F, false);
        jaw.setTextureOffset(84, 1).addBox(-8.0F, 8.0F, -2.5F, 5.0F, 4.0F, 3.0F, 0.0F, true);
        jaw.setTextureOffset(52, 33).addBox(-3.0F, 0.0F, 0.5F, 6.0F, 2.0F, 2.0F, 0.0F, false);

        head_r7 = new AdvancedModelBox(this,"head_r7");
        head_r7.setRotationPoint(0.0F, 8.0F, -2.5F);
        jaw.addChild(head_r7);
        setRotationAngle(head_r7, -0.3491F, 0.0F, 0.0F);
        head_r7.setTextureOffset(92, 12).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 8.0F, 0.0F, 0.0F, false);

        chestplate = new AdvancedModelBox(this,"chestplate");
        chestplate.setRotationPoint(0.0F, -9.0F, 1.0F);
        chest.addChild(chestplate);
        chestplate.setTextureOffset(0, 150).addBox(-6.0F, -3.0F, -9.0F, 12.0F, 7.0F, 2.0F, 0.0F, false);
        chestplate.setTextureOffset(0, 159).addBox(-4.0F, 4.0F, -9.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);
        chestplate.setTextureOffset(0, 180).addBox(-9.0F, 3.0F, -7.0F, 18.0F, 2.0F, 12.0F, 0.2F, false);
        chestplate.setTextureOffset(68, 174).addBox(-5.0F, -5.0F, -7.0F, 10.0F, 6.0F, 12.0F, 0.1F, false);
        chestplate.setTextureOffset(0, 165).addBox(-6.0F, -3.0F, -9.0F, 12.0F, 7.0F, 2.0F, -0.1F, false);
        chestplate.setTextureOffset(0, 174).addBox(-4.0F, 4.0F, -9.0F, 8.0F, 4.0F, 2.0F, -0.1F, false);

        body_r1 = new AdvancedModelBox(this,"body_r1");
        body_r1.setRotationPoint(0.0F, 2.0F, 6.0F);
        chestplate.addChild(body_r1);
        setRotationAngle(body_r1, 0.0F, 0.0F, -0.7854F);
        body_r1.setTextureOffset(48, 182).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F, 0.0F, false);

        body_r2 = new AdvancedModelBox(this,"body_r2");
        body_r2.setRotationPoint(6.5F, 4.0F, -7.3F);
        chestplate.addChild(body_r2);
        setRotationAngle(body_r2, 0.0F, 0.2618F, 0.1309F);
        body_r2.setTextureOffset(0, 188).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);

        body_r3 = new AdvancedModelBox(this,"body_r3");
        body_r3.setRotationPoint(-6.5F, 4.0F, -7.3F);
        chestplate.addChild(body_r3);
        setRotationAngle(body_r3, 0.0F, -0.2618F, -0.1309F);
        body_r3.setTextureOffset(0, 188).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, true);

        body_r4 = new AdvancedModelBox(this,"body_r4");
        body_r4.setRotationPoint(-6.5F, -3.0F, -7.3F);
        chestplate.addChild(body_r4);
        setRotationAngle(body_r4, 0.0F, -0.2618F, 0.5236F);
        body_r4.setTextureOffset(0, 188).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, true);

        body_r5 = new AdvancedModelBox(this,"body_r5");
        body_r5.setRotationPoint(-9.0F, -4.5F, -1.0F);
        chestplate.addChild(body_r5);
        setRotationAngle(body_r5, 0.0F, 0.0F, 0.5236F);
        body_r5.setTextureOffset(0, 194).addBox(-0.5F, -1.0F, -6.0F, 9.0F, 2.0F, 12.0F, 0.1F, true);

        body_r6 = new AdvancedModelBox(this,"body_r6");
        body_r6.setRotationPoint(6.5F, -3.0F, -7.3F);
        chestplate.addChild(body_r6);
        setRotationAngle(body_r6, 0.0F, 0.2618F, -0.5236F);
        body_r6.setTextureOffset(0, 188).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);

        body_r7 = new AdvancedModelBox(this,"body_r7");
        body_r7.setRotationPoint(9.0F, -4.5F, -1.0F);
        chestplate.addChild(body_r7);
        setRotationAngle(body_r7, 0.0F, 0.0F, -0.5236F);
        body_r7.setTextureOffset(0, 194).addBox(-8.5F, -1.0F, -6.0F, 9.0F, 2.0F, 12.0F, 0.1F, false);

        l_arm = new AdvancedModelBox(this,"l_arm");
        l_arm.setRotationPoint(12.0F, -12.5F, 0.0F);
        chest.addChild(l_arm);
        setRotationAngle(l_arm, 0.0F, 0.0F, -0.0873F);
        l_arm.setTextureOffset(0, 49).addBox(-3.0F, -2.5F, -4.0F, 8.0F, 12.0F, 8.0F, 0.0F, false);

        l_arm_armor = new AdvancedModelBox(this,"l_arm_armor");
        l_arm_armor.setRotationPoint(1.5F, 0.0F, 0.0F);
        l_arm.addChild(l_arm_armor);
        setRotationAngle(l_arm_armor, 0.0F, 0.0F, -0.1309F);
        l_arm_armor.setTextureOffset(112, 56).addBox(-4.5086F, -5.3695F, -7.0F, 2.0F, 10.0F, 14.0F, 0.0F, true);
        l_arm_armor.setTextureOffset(130, 66).addBox(-4.5086F, 4.6305F, -7.0F, 12.0F, 2.0F, 14.0F, 0.0F, true);
        l_arm_armor.setTextureOffset(0, 26).addBox(-4.5086F, -4.3695F, -6.0F, 11.0F, 11.0F, 12.0F, 0.0F, true);
        l_arm_armor.setTextureOffset(138, 36).addBox(6.4914F, -3.3695F, -3.0F, 2.0F, 6.0F, 6.0F, 0.0F, true);
        l_arm_armor.setTextureOffset(106, 36).addBox(-1.5086F, -4.3695F, -6.0F, 8.0F, 8.0F, 12.0F, 0.2F, true);
        l_arm_armor.setTextureOffset(154, 40).addBox(0.4914F, -3.3695F, -7.0F, 4.0F, 4.0F, 2.0F, 0.0F, true);
        l_arm_armor.setTextureOffset(166, 38).addBox(2.4914F, -4.3695F, -11.0F, 0.0F, 4.0F, 4.0F, 0.0F, true);
        l_arm_armor.setTextureOffset(162, 46).addBox(1.4914F, -1.3695F, -11.0F, 2.0F, 0.0F, 4.0F, 0.0F, true);
        l_arm_armor.setTextureOffset(142, 55).addBox(8.4914F, -0.3695F, -2.0F, 6.0F, 0.0F, 4.0F, 0.0F, true);
        l_arm_armor.setTextureOffset(146, 49).addBox(8.4914F, -4.3695F, 0.0F, 6.0F, 6.0F, 0.0F, 0.0F, true);

        right_arm_r1 = new AdvancedModelBox(this,"right_arm_r1");
        right_arm_r1.setRotationPoint(-3.0086F, 5.1305F, -8.0F);
        l_arm_armor.addChild(right_arm_r1);
        setRotationAngle(right_arm_r1, 0.0F, 0.0F, -0.7854F);
        right_arm_r1.setTextureOffset(168, 68).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, -0.1F, true);
        right_arm_r1.setTextureOffset(168, 74).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, 0.0F, true);
        right_arm_r1.setTextureOffset(182, 75).addBox(-6.5F, -0.5F, 0.5F, 7.0F, 7.0F, 0.0F, 0.0F, true);

        right_arm_r2 = new AdvancedModelBox(this,"right_arm_r2");
        right_arm_r2.setRotationPoint(1.4914F, 6.6305F, 6.0F);
        l_arm_armor.addChild(right_arm_r2);
        setRotationAngle(right_arm_r2, 0.3491F, 0.0F, 0.0F);
        right_arm_r2.setTextureOffset(130, 82).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 0.0F, 0.0F, true);

        right_arm_r3 = new AdvancedModelBox(this,"right_arm_r3");
        right_arm_r3.setRotationPoint(1.4914F, 6.6305F, -6.0F);
        l_arm_armor.addChild(right_arm_r3);
        setRotationAngle(right_arm_r3, -0.3491F, 0.0F, 0.0F);
        right_arm_r3.setTextureOffset(130, 82).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 0.0F, 0.0F, true);

        right_arm_r4 = new AdvancedModelBox(this,"right_arm_r4");
        right_arm_r4.setRotationPoint(6.4914F, 6.6305F, 0.0F);
        l_arm_armor.addChild(right_arm_r4);
        setRotationAngle(right_arm_r4, 0.0F, 0.0F, -0.3491F);
        right_arm_r4.setTextureOffset(154, 68).addBox(0.0F, 0.0F, -7.0F, 0.0F, 4.0F, 14.0F, 0.0F, true);

        right_arm_r5 = new AdvancedModelBox(this,"right_arm_r5");
        right_arm_r5.setRotationPoint(2.4914F, -1.3695F, 9.0F);
        l_arm_armor.addChild(right_arm_r5);
        setRotationAngle(right_arm_r5, 0.0F, -3.1416F, 0.0F);
        right_arm_r5.setTextureOffset(162, 46).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, 0.0F, true);
        right_arm_r5.setTextureOffset(166, 38).addBox(0.0F, -3.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, true);

        right_arm_r6 = new AdvancedModelBox(this,"right_arm_r6");
        right_arm_r6.setRotationPoint(2.4914F, -1.3695F, 6.0F);
        l_arm_armor.addChild(right_arm_r6);
        setRotationAngle(right_arm_r6, 0.0F, -3.1416F, 0.0F);
        right_arm_r6.setTextureOffset(154, 40).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, 0.0F, true);

        arrow = new AdvancedModelBox(this,"arrow");
        arrow.setRotationPoint(-1.5F, -3.0F, -5.0F);
        l_arm_armor.addChild(arrow);
        setRotationAngle(arrow, 0.0F, -0.4363F, 1.7453F);
        arrow.setTextureOffset(128, 100).addBox(-8.0F, -2.5F, 0.0F, 16.0F, 5.0F, 0.0F, 0.0F, false);
        arrow.setTextureOffset(128, 100).addBox(-7.0F, -2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, false);
        arrow.setTextureOffset(123, 100).addBox(-8.0F, 0.0F, -2.5F, 16.0F, 0.0F, 5.0F, 0.0F, false);

        arrow2 = new AdvancedModelBox(this,"arrow2");
        arrow2.setRotationPoint(2.5F, -6.0F, 1.0F);
        l_arm_armor.addChild(arrow2);
        setRotationAngle(arrow2, 0.0385F, 0.2148F, 1.924F);
        arrow2.setTextureOffset(128, 100).addBox(-8.0F, -2.5F, 0.0F, 16.0F, 5.0F, 0.0F, 0.0F, false);
        arrow2.setTextureOffset(128, 100).addBox(-7.0F, -2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, false);
        arrow2.setTextureOffset(123, 100).addBox(-8.0F, 0.0F, -2.5F, 16.0F, 0.0F, 5.0F, 0.0F, false);

        left_arm2 = new AdvancedModelBox(this,"left_arm2");
        left_arm2.setRotationPoint(3.0F, 9.5F, 0.0F);
        l_arm.addChild(left_arm2);
        left_arm2.setTextureOffset(70, 75).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 10.0F, 6.0F, 0.0F, false);
        left_arm2.setTextureOffset(80, 49).addBox(-4.0F, 10.0F, -3.0F, 7.0F, 7.0F, 6.0F, 0.0F, false);

        l_arm_cloth = new AdvancedModelBox(this,"l_arm_cloth");
        l_arm_cloth.setRotationPoint(0.5F, 7.25F, 0.0F);
        left_arm2.addChild(l_arm_cloth);
        l_arm_cloth.setTextureOffset(88, 31).addBox(-3.5F, -4.25F, -3.0F, 7.0F, 5.0F, 6.0F, 0.5F, false);
        l_arm_cloth.setTextureOffset(109, 129).addBox(-4.5F, 0.75F, -4.0F, 9.0F, 2.0F, 8.0F, 0.0F, true);

        r_arm = new AdvancedModelBox(this,"r_arm");
        r_arm.setRotationPoint(-12.0F, -12.5F, 0.0F);
        chest.addChild(r_arm);
        setRotationAngle(r_arm, -1.044F, 0.2117F, 0.25F);
        r_arm.setTextureOffset(60, 0).addBox(-5.0F, -2.5F, -4.0F, 8.0F, 12.0F, 8.0F, 0.0F, false);

        right_arm2 = new AdvancedModelBox(this,"right_arm2");
        right_arm2.setRotationPoint(-3.0F, 9.5F, 0.0F);
        r_arm.addChild(right_arm2);
        setRotationAngle(right_arm2, -1.9635F, 0.0F, 0.0F);
        right_arm2.setTextureOffset(44, 75).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 10.0F, 6.0F, 0.0F, false);
        right_arm2.setTextureOffset(68, 36).addBox(-3.0F, 10.0F, -3.0F, 7.0F, 7.0F, 6.0F, 0.0F, false);

        r_arm_cloth = new AdvancedModelBox(this,"r_arm_cloth");
        r_arm_cloth.setRotationPoint(-0.5F, 7.25F, 0.0F);
        right_arm2.addChild(r_arm_cloth);
        r_arm_cloth.setTextureOffset(84, 20).addBox(-3.5F, -4.25F, -3.0F, 7.0F, 5.0F, 6.0F, 0.5F, false);
        r_arm_cloth.setTextureOffset(109, 129).addBox(-4.5F, 0.75F, -4.0F, 9.0F, 2.0F, 8.0F, 0.0F, false);

        axe = new AdvancedModelBox(this,"axe");
        axe.setRotationPoint(0.5F, 13.5F, 0.0F);
        right_arm2.addChild(axe);
        axe.setTextureOffset(3, 205).addBox(-1.5F, -1.5F, -32.0F, 3.0F, 3.0F, 48.0F, 0.0F, false);
        axe.setTextureOffset(56, 241).addBox(-3.5F, 0.0F, -31.0F, 2.0F, 0.0F, 4.0F, 0.0F, false);
        axe.setTextureOffset(3, 205).addBox(-1.5F, -1.5F, -32.0F, 3.0F, 3.0F, 48.0F, 0.0F, false);
        axe.setTextureOffset(26, 241).addBox(-1.5F, -1.5F, -25.0F, 3.0F, 3.0F, 9.0F, 0.2F, false);
        axe.setTextureOffset(26, 241).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 9.0F, 0.2F, false);
        axe.setTextureOffset(25, 245).addBox(-1.5F, -1.5F, -18.0F, 3.0F, 3.0F, 2.0F, 0.4F, false);
        axe.setTextureOffset(25, 245).addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 2.0F, 0.4F, false);
        axe.setTextureOffset(25, 245).addBox(-1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 2.0F, 0.4F, false);
        axe.setTextureOffset(57, 245).addBox(-2.5F, -2.5F, -28.0F, 5.0F, 5.0F, 3.0F, 0.0F, false);
        axe.setTextureOffset(57, 245).addBox(-2.5F, -2.5F, 15.0F, 5.0F, 5.0F, 3.0F, 0.0F, false);
        axe.setTextureOffset(60, 228).addBox(-3.5F, 0.0F, 17.0F, 2.0F, 0.0F, 4.0F, 0.0F, false);
        axe.setTextureOffset(64, 228).addBox(1.4F, 0.0F, 17.0F, 2.0F, 0.0F, 4.0F, 0.0F, false);
        axe.setTextureOffset(60, 231).addBox(-0.1F, 1.5F, 17.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);
        axe.setTextureOffset(60, 233).addBox(-0.1F, -3.5F, 17.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);
        axe.setTextureOffset(60, 241).addBox(1.5F, 0.0F, -31.0F, 2.0F, 0.0F, 4.0F, 0.0F, false);

        cube_r1 = new AdvancedModelBox(this,"cube_r1");
        cube_r1.setRotationPoint(0.0F, 0.0F, -29.0F);
        axe.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, -1.5708F);
        cube_r1.setTextureOffset(60, 241).addBox(1.5F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, 0.0F, false);
        cube_r1.setTextureOffset(56, 241).addBox(-3.5F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, 0.0F, false);

        cube_r2 = new AdvancedModelBox(this,"cube_r2");
        cube_r2.setRotationPoint(0.0F, 0.0F, 20.0F);
        axe.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 3.1416F, 0.0F);
        cube_r2.setTextureOffset(68, 231).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);

        axe_head = new AdvancedModelBox(this,"axe_head");
        axe_head.setRotationPoint(0.0F, 0.0F, -32.2F);
        axe.addChild(axe_head);
        axe_head.setTextureOffset(111, 249).addBox(-1.5F, -1.5F, -14.0F, 3.0F, 3.0F, 4.0F, 0.2F, false);
        axe_head.setTextureOffset(68, 231).addBox(-1.5F, -1.5F, -13.8F, 3.0F, 3.0F, 4.0F, 0.0F, false);
        axe_head.setTextureOffset(122, 203).addBox(-0.5F, 7.4F, -8.8F, 1.0F, 10.0F, 9.0F, -0.001F, false);
        axe_head.setTextureOffset(0, 236).addBox(-1.5F, -5.5F, -5.8F, 3.0F, 11.0F, 6.0F, 0.3F, false);
        axe_head.setTextureOffset(97, 232).addBox(-1.5F, -7.5F, -9.6F, 3.0F, 15.0F, 6.0F, 0.2F, false);
        axe_head.setTextureOffset(73, 229).addBox(-1.5F, -7.5F, -8.8F, 3.0F, 15.0F, 9.0F, 0.0F, false);

        cube_r3 = new AdvancedModelBox(this,"cube_r3");
        cube_r3.setRotationPoint(0.0F, -10.5F, -4.3F);
        axe_head.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.48F, 0.0F, 0.0F);
        cube_r3.setTextureOffset(81, 211).addBox(-0.5F, -3.5F, -5.5F, 1.0F, 9.0F, 9.0F, 0.01F, false);

        cube_r4 = new AdvancedModelBox(this,"cube_r4");
        cube_r4.setRotationPoint(-0.5F, 19.1267F, -0.0182F);
        axe_head.addChild(cube_r4);
        setRotationAngle(cube_r4, -1.0036F, 0.0F, 0.0F);
        cube_r4.setTextureOffset(156, 198).addBox(0.5F, -18.5F, -7.0F, 0.0F, 33.0F, 14.0F, 0.001F, false);

        cube_r5 = new AdvancedModelBox(this,"cube_r5");
        cube_r5.setRotationPoint(0.0F, 14.0647F, -3.2431F);
        axe_head.addChild(cube_r5);
        setRotationAngle(cube_r5, -1.0036F, 0.0F, 0.0F);
        cube_r5.setTextureOffset(142, 206).addBox(-0.5F, -13.5F, -1.0F, 1.0F, 16.0F, 6.0F, 0.001F, false);
        cube_r5.setTextureOffset(104, 208).addBox(-0.5F, 2.5F, -9.0F, 1.0F, 6.0F, 14.0F, 0.001F, false);

        cube_r6 = new AdvancedModelBox(this,"cube_r6");
        cube_r6.setRotationPoint(-0.5F, 17.2895F, -8.3051F);
        axe_head.addChild(cube_r6);
        setRotationAngle(cube_r6, -1.0036F, 0.0F, 0.0F);
        cube_r6.setTextureOffset(109, 214).addBox(0.5F, 2.5F, -9.0F, 0.0F, 6.0F, 14.0F, 0.001F, false);

        cube_r7 = new AdvancedModelBox(this,"cube_r7");
        cube_r7.setRotationPoint(0.0F, 0.0F, -15.8F);
        axe_head.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, 0.0F, 2.3562F);
        cube_r7.setTextureOffset(64, 228).addBox(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);

        cube_r8 = new AdvancedModelBox(this,"cube_r8");
        cube_r8.setRotationPoint(0.0F, 0.0F, -15.8F);
        axe_head.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0F, 0.0F, 0.7854F);
        cube_r8.setTextureOffset(64, 228).addBox(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);

        emblem3 = new AdvancedModelBox(this,"emblem3");
        emblem3.setRotationPoint(-2.0F, 0.0F, -5.3F);
        axe_head.addChild(emblem3);
        setRotationAngle(emblem3, 1.5708F, -0.7854F, 1.5708F);
        emblem3.setTextureOffset(168, 74).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, 0.0F, false);
        emblem3.setTextureOffset(168, 68).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, -0.1F, false);

        right_arm_r7 = new AdvancedModelBox(this,"right_arm_r7");
        right_arm_r7.setRotationPoint(0.5F, 0.5F, -0.5F);
        emblem3.addChild(right_arm_r7);
        setRotationAngle(right_arm_r7, 0.0F, 0.0F, -1.5708F);
        right_arm_r7.setTextureOffset(169, 204).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, 0.0F, true);

        emblem4 = new AdvancedModelBox(this,"emblem4");
        emblem4.setRotationPoint(2.0F, 0.0F, -5.3F);
        axe_head.addChild(emblem4);
        setRotationAngle(emblem4, 1.5708F, 0.7854F, -1.5708F);
        emblem4.setTextureOffset(168, 74).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, 0.0F, true);
        emblem4.setTextureOffset(169, 204).addBox(-4.5F, -3.5F, -0.5F, 8.0F, 8.0F, 0.0F, 0.0F, true);
        emblem4.setTextureOffset(168, 68).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, -0.1F, true);

        r_arm_armor = new AdvancedModelBox(this,"r_arm_armor");
        r_arm_armor.setRotationPoint(-1.5F, 0.0F, 0.0F);
        r_arm.addChild(r_arm_armor);
        setRotationAngle(r_arm_armor, 0.0F, 0.0F, 0.1309F);
        r_arm_armor.setTextureOffset(112, 56).addBox(2.5086F, -5.3695F, -7.0F, 2.0F, 10.0F, 14.0F, 0.0F, false);
        r_arm_armor.setTextureOffset(130, 86).addBox(2.5086F, -3.3695F, -7.0F, 2.0F, 2.0F, 1.0F, 0.1F, false);
        r_arm_armor.setTextureOffset(130, 66).addBox(-7.4914F, 4.6305F, -7.0F, 12.0F, 2.0F, 14.0F, 0.0F, false);
        r_arm_armor.setTextureOffset(0, 26).addBox(-6.4914F, -4.3695F, -6.0F, 11.0F, 11.0F, 12.0F, 0.0F, false);
        r_arm_armor.setTextureOffset(138, 36).addBox(-8.4914F, -3.3695F, -3.0F, 2.0F, 6.0F, 6.0F, 0.0F, false);
        r_arm_armor.setTextureOffset(106, 36).addBox(-6.4914F, -4.3695F, -6.0F, 8.0F, 8.0F, 12.0F, 0.2F, false);
        r_arm_armor.setTextureOffset(154, 40).addBox(-4.4914F, -3.3695F, -7.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
        r_arm_armor.setTextureOffset(166, 38).addBox(-2.4914F, -4.3695F, -11.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);
        r_arm_armor.setTextureOffset(162, 46).addBox(-3.4914F, -1.3695F, -11.0F, 2.0F, 0.0F, 4.0F, 0.0F, false);
        r_arm_armor.setTextureOffset(142, 55).addBox(-14.4914F, -0.3695F, -2.0F, 6.0F, 0.0F, 4.0F, 0.0F, false);
        r_arm_armor.setTextureOffset(146, 49).addBox(-14.4914F, -4.3695F, 0.0F, 6.0F, 6.0F, 0.0F, 0.0F, false);

        left_arm_r1 = new AdvancedModelBox(this,"left_arm_r1");
        left_arm_r1.setRotationPoint(3.0086F, 5.1305F, -8.0F);
        r_arm_armor.addChild(left_arm_r1);
        setRotationAngle(left_arm_r1, 0.0F, 0.0F, 0.7854F);
        left_arm_r1.setTextureOffset(168, 68).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, -0.1F, false);
        left_arm_r1.setTextureOffset(168, 74).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
        left_arm_r1.setTextureOffset(182, 75).addBox(-0.5F, -0.5F, 0.5F, 7.0F, 7.0F, 0.0F, 0.0F, false);

        left_arm_r2 = new AdvancedModelBox(this,"left_arm_r2");
        left_arm_r2.setRotationPoint(-1.4914F, 6.6305F, 6.0F);
        r_arm_armor.addChild(left_arm_r2);
        setRotationAngle(left_arm_r2, 0.3491F, 0.0F, 0.0F);
        left_arm_r2.setTextureOffset(130, 82).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 0.0F, 0.0F, false);

        left_arm_r3 = new AdvancedModelBox(this,"left_arm_r3");
        left_arm_r3.setRotationPoint(-1.4914F, 6.6305F, -6.0F);
        r_arm_armor.addChild(left_arm_r3);
        setRotationAngle(left_arm_r3, -0.3491F, 0.0F, 0.0F);
        left_arm_r3.setTextureOffset(130, 82).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 0.0F, 0.0F, false);

        left_arm_r4 = new AdvancedModelBox(this,"left_arm_r4");
        left_arm_r4.setRotationPoint(-6.4914F, 6.6305F, 0.0F);
        r_arm_armor.addChild(left_arm_r4);
        setRotationAngle(left_arm_r4, 0.0F, 0.0F, 0.3491F);
        left_arm_r4.setTextureOffset(154, 68).addBox(0.0F, 0.0F, -7.0F, 0.0F, 4.0F, 14.0F, 0.0F, false);

        left_arm_r5 = new AdvancedModelBox(this,"left_arm_r5");
        left_arm_r5.setRotationPoint(-2.4914F, -1.3695F, 9.0F);
        r_arm_armor.addChild(left_arm_r5);
        setRotationAngle(left_arm_r5, 0.0F, 3.1416F, 0.0F);
        left_arm_r5.setTextureOffset(162, 46).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, 0.0F, false);
        left_arm_r5.setTextureOffset(166, 38).addBox(0.0F, -3.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);

        left_arm_r6 = new AdvancedModelBox(this,"left_arm_r6");
        left_arm_r6.setRotationPoint(-2.4914F, -1.3695F, 6.0F);
        r_arm_armor.addChild(left_arm_r6);
        setRotationAngle(left_arm_r6, 0.0F, 3.1416F, 0.0F);
        left_arm_r6.setTextureOffset(154, 40).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);

        belt = new AdvancedModelBox(this,"belt");
        belt.setRotationPoint(0.0F, 14.0F, 0.0F);
        body.addChild(belt);
        belt.setTextureOffset(95, 131).addBox(3.5F, -19.0F, -4.0F, 3.0F, 5.0F, 8.0F, 0.0F, false);
        belt.setTextureOffset(100, 144).addBox(6.5F, -17.0F, -2.0F, 3.0F, 0.0F, 3.0F, 0.0F, false);
        belt.setTextureOffset(100, 144).addBox(-9.5F, -17.0F, -2.0F, 3.0F, 0.0F, 3.0F, 0.0F, true);
        belt.setTextureOffset(95, 131).addBox(-6.5F, -19.0F, -4.0F, 3.0F, 5.0F, 8.0F, 0.0F, true);
        belt.setTextureOffset(60, 66).addBox(-5.5F, -17.0F, -3.0F, 11.0F, 3.0F, 6.0F, 0.5F, false);
        belt.setTextureOffset(157, 86).addBox(-5.5F, -19.0F, -3.0F, 11.0F, 3.0F, 6.0F, 0.3F, false);

        body_r8 = new AdvancedModelBox(this,"body_r8");
        body_r8.setRotationPoint(8.0F, -17.0F, -0.5F);
        belt.addChild(body_r8);
        setRotationAngle(body_r8, -1.5708F, 0.0F, 0.0F);
        body_r8.setTextureOffset(100, 144).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 0.0F, 3.0F, 0.0F, false);
        body_r8.setTextureOffset(100, 144).addBox(-17.5F, 0.0F, -1.5F, 3.0F, 0.0F, 3.0F, 0.0F, true);

        emblem2 = new AdvancedModelBox(this,"emblem2");
        emblem2.setRotationPoint(0.0F, -15.5F, 3.5F);
        belt.addChild(emblem2);
        setRotationAngle(emblem2, 3.1416F, 0.0F, 2.3562F);
        emblem2.setTextureOffset(168, 74).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, 0.0F, false);
        emblem2.setTextureOffset(168, 68).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, -0.1F, false);

        emblem = new AdvancedModelBox(this,"emblem");
        emblem.setRotationPoint(0.0F, -15.5F, -3.5F);
        belt.addChild(emblem);
        setRotationAngle(emblem, 0.0F, 0.0F, 0.7854F);
        emblem.setTextureOffset(168, 74).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, 0.0F, false);
        emblem.setTextureOffset(168, 68).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, -0.1F, false);

        cloth2 = new AdvancedModelBox(this,"cloth2");
        cloth2.setRotationPoint(0.0F, -13.5F, 3.5F);
        belt.addChild(cloth2);
        cloth2.setTextureOffset(46, 127).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 12.0F, 0.0F, 0.0F, false);

        cloth = new AdvancedModelBox(this,"cloth");
        cloth.setRotationPoint(0.0F, -13.5F, -3.5F);
        belt.addChild(cloth);
        cloth.setTextureOffset(46, 127).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 12.0F, 0.0F, 0.0F, false);
        this.updateDefaultPose();
    }

    @Override
    public void setupAnim(Aptrgangr_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
        this.faceTarget(netHeadYaw, headPitch, 1, head);
        if(entity.getAttackState() != 4) {
            this.animateWalk(Aptrgangr_Animation.WALK, limbSwing, limbSwingAmount, 2.5F, 4.0F);
        }
        this.animate(entity.getAnimationState("idle"), Aptrgangr_Animation.IDLE, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("swing_right"), Aptrgangr_Animation.SWING_RIGHT, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("smash"), Aptrgangr_Animation.SMASH, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("charge_start"), Aptrgangr_Animation.RUSH_START, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("charge"), Aptrgangr_Animation.RUSHING, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("charge_end"), Aptrgangr_Animation.RUSH_END, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("charge_hit"), Aptrgangr_Animation.RUSH_HIT, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("death"), Aptrgangr_Animation.DEATH, ageInTicks, 1.0F);
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
        AdvancedModelBox.rotateAngleX = x;
        AdvancedModelBox.rotateAngleY = y;
        AdvancedModelBox.rotateAngleZ = z;
    }

    @Override
    public Iterable<BasicModelPart> parts() {
        return ImmutableList.of(roots);
    }

    @Override
    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(roots,
                l_leg,
                l_leg_armor,
                left_leg_r1,
                left_leg_r2,
                r_leg,
                r_leg_armor,
                right_leg_r1,
                right_leg_r2,
                body,
                chest,
                neck,
                head,
                helmet,
                head_r1,
                head_r2,
                head_r3,
                head_r4,
                head_r5,
                head_r6,
                jaw,
                head_r7,
                chestplate,
                body_r1,
                body_r2,
                body_r3,
                body_r4,
                body_r5,
                body_r6,
                body_r7,
                l_arm,
                l_arm_armor,
                right_arm_r1,
                right_arm_r2,
                right_arm_r3,
                right_arm_r4,
                right_arm_r5,
                right_arm_r6,
                arrow,
                arrow2,
                left_arm2,
                l_arm_cloth,
                r_arm,
                right_arm2,
                r_arm_cloth,
                axe,
                cube_r1,
                cube_r2,
                axe_head,
                cube_r3,
                cube_r4,
                cube_r5,
                cube_r6,
                cube_r7,
                cube_r8,
                emblem3,
                right_arm_r7,
                emblem4,
                r_arm_armor,
                left_arm_r1,
                left_arm_r2,
                left_arm_r3,
                left_arm_r4,
                left_arm_r5,
                left_arm_r6,
                belt,
                body_r8,
                emblem2,
                emblem,
                cloth2,
                cloth);
    }

}
