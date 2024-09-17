package com.github.L_Ender.cataclysm.client.model.entity;

import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.github.L_Ender.cataclysm.client.animation.Kobolediator_Animation;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class ModelKobolediator extends AdvancedEntityModel<Kobolediator_Entity> {
    private final AdvancedModelBox everything;
    private final AdvancedModelBox mid_root;
    private final AdvancedModelBox pelvis;
    private final AdvancedModelBox lower_body;
    private final AdvancedModelBox body;
    private final AdvancedModelBox right_shoulder;
    private final AdvancedModelBox right_arm;
    private final AdvancedModelBox right_front_arm;
    private final AdvancedModelBox golden_greatsword;
    private final AdvancedModelBox left_shoulder;
    private final AdvancedModelBox left_arm;
    private final AdvancedModelBox left_front_arm;
    private final AdvancedModelBox head;
    private final AdvancedModelBox head_cube1;
    private final AdvancedModelBox head_cube2;
    private final AdvancedModelBox head_cube3;
    private final AdvancedModelBox head_cube4;
    private final AdvancedModelBox right_horn;
    private final AdvancedModelBox left_horn;
    private final AdvancedModelBox jaw;
    private final AdvancedModelBox tail1;
    private final AdvancedModelBox tail2;
    private final AdvancedModelBox legs;
    private final AdvancedModelBox right_leg;
    private final AdvancedModelBox right_front_leg;
    private final AdvancedModelBox left_leg;
    private final AdvancedModelBox left_front_leg;

    public ModelKobolediator() {
        texWidth = 256;
        texHeight = 256;

        everything = new AdvancedModelBox(this);
        everything.setRotationPoint(0.0F, 25.0F, -1.0F);


        mid_root = new AdvancedModelBox(this,"mid_root");
        mid_root.setRotationPoint(0.0F, 0.0F, 0.0F);
        everything.addChild(mid_root);


        pelvis = new AdvancedModelBox(this,"pelvis");
        pelvis.setRotationPoint(0.0F, -22.0F, 0.0F);
        mid_root.addChild(pelvis);
        setRotationAngle(pelvis, 0.1745F, 0.1309F, 0.0F);
        pelvis.setTextureOffset(94, 72).addBox(-9.0F, -3.0F, -6.0513F, 18.0F, 6.0F, 15.0F, 0.0F, false);

        lower_body = new AdvancedModelBox(this,"lower_body");
        lower_body.setRotationPoint(-0.7832F, 0.0F, 8.9487F);
        pelvis.addChild(lower_body);
        lower_body.setTextureOffset(86, 0).addBox(-6.2168F, -14.0F, -15.0F, 14.0F, 14.0F, 15.0F, 0.0F, false);
        lower_body.setTextureOffset(56, 146).addBox(-2.2168F, -14.0F, -3.0F, 6.0F, 14.0F, 6.0F, 0.0F, false);

        body = new AdvancedModelBox(this,"body");
        body.setRotationPoint(1.0F, -14.0F, 0.0F);
        lower_body.addChild(body);
        setRotationAngle(body, 0.1372F, -0.3027F, -0.0411F);
        body.setTextureOffset(0, 0).addBox(-12.2168F, -21.0F, -19.0F, 24.0F, 21.0F, 19.0F, 0.0F, false);
        body.setTextureOffset(126, 130).addBox(-3.2168F, -21.0F, -3.0F, 6.0F, 21.0F, 6.0F, 0.0F, false);
        body.setTextureOffset(0, 40).addBox(-10.2168F, -21.0F, -21.0F, 4.0F, 16.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(5.7832F, -21.0F, -21.0F, 4.0F, 16.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 40).addBox(-13.2168F, -21.0F, -19.0F, 26.0F, 7.0F, 19.0F, 0.5F, false);

        right_shoulder = new AdvancedModelBox(this,"right_shoulder");
        right_shoulder.setRotationPoint(-13.0F, -20.0F, -8.0F);
        body.addChild(right_shoulder);
        setRotationAngle(right_shoulder, -0.6109F, 0.2618F, 0.2182F);
        right_shoulder.setTextureOffset(0, 66).addBox(-16.0F, -4.0F, -9.0F, 17.0F, 15.0F, 19.0F, 0.0F, false);

        right_arm = new AdvancedModelBox(this,"right_arm");
        right_arm.setRotationPoint(-5.0F, 9.0F, 2.0F);
        right_shoulder.addChild(right_arm);
        setRotationAngle(right_arm, -0.4904F, 0.0334F, 0.0769F);
        right_arm.setTextureOffset(94, 124).addBox(-5.0F, -1.0F, -4.0F, 8.0F, 14.0F, 8.0F, 0.0F, false);

        right_front_arm = new AdvancedModelBox(this,"right_front_arm");
        right_front_arm.setRotationPoint(0.0F, 13.0F, 2.0F);
        right_arm.addChild(right_front_arm);
        setRotationAngle(right_front_arm, -1.5708F, 0.0F, 0.0F);
        right_front_arm.setTextureOffset(0, 100).addBox(-6.025F, 0.0F, -6.5F, 9.0F, 22.0F, 9.0F, 0.0F, false);
        right_front_arm.setTextureOffset(94, 93).addBox(-8.025F, 2.0F, -8.5F, 8.0F, 18.0F, 13.0F, 0.0F, false);
        right_front_arm.setTextureOffset(67, 0).addBox(1.0F, 16.0F, -1.5F, 4.0F, 7.0F, 0.0F, 0.0F, false);
        right_front_arm.setTextureOffset(53, 69).addBox(1.0F, 17.0F, 1.5F, 4.0F, 6.0F, 0.0F, 0.0F, false);
        right_front_arm.setTextureOffset(53, 69).addBox(1.0F, 17.0F, -4.5F, 4.0F, 6.0F, 0.0F, 0.0F, false);

        golden_greatsword = new AdvancedModelBox(this,"golden_greatsword");
        golden_greatsword.setRotationPoint(-1.0F, 18.9F, 1.0F);
        right_front_arm.addChild(golden_greatsword);
        setRotationAngle(golden_greatsword, 1.3963F, 0.0F, 0.0F);
        golden_greatsword.setTextureOffset(80, 146).addBox(-2.2168F, -12.0F, -2.1F, 4.0F, 21.0F, 4.0F, 0.0F, false);
        golden_greatsword.setTextureOffset(72, 72).addBox(-1.7168F, -78.0F, -4.1F, 3.0F, 66.0F, 8.0F, 0.0F, false);
        golden_greatsword.setTextureOffset(71, 40).addBox(-2.2168F, -12.0F, 1.9F, 4.0F, 5.0F, 5.0F, 0.0F, false);
        golden_greatsword.setTextureOffset(0, 66).addBox(-2.2168F, -12.0F, -7.1F, 4.0F, 5.0F, 5.0F, 0.0F, false);

        left_shoulder = new AdvancedModelBox(this,"left_shoulder");
        left_shoulder.setRotationPoint(12.5663F, -20.0F, -8.0F);
        body.addChild(left_shoulder);
        setRotationAngle(left_shoulder, 0.0436F, -0.0873F, -0.1309F);
        left_shoulder.setTextureOffset(0, 66).addBox(-1.0F, -4.0F, -9.0F, 17.0F, 15.0F, 19.0F, 0.0F, true);

        left_arm = new AdvancedModelBox(this,"left_arm");
        left_arm.setRotationPoint(5.0F, 9.0F, 2.0F);
        left_shoulder.addChild(left_arm);
        setRotationAngle(left_arm, 0.0873F, 0.0F, 0.0F);
        left_arm.setTextureOffset(94, 124).addBox(-3.0F, -1.0F, -4.0F, 8.0F, 14.0F, 8.0F, 0.0F, true);

        left_front_arm = new AdvancedModelBox(this,"left_front_arm");
        left_front_arm.setRotationPoint(0.0F, 13.0F, 2.0F);
        left_arm.addChild(left_front_arm);
        setRotationAngle(left_front_arm, -0.829F, 0.0F, 0.0F);
        left_front_arm.setTextureOffset(0, 100).addBox(-2.975F, 0.0F, -6.5F, 9.0F, 22.0F, 9.0F, 0.0F, true);
        left_front_arm.setTextureOffset(94, 93).addBox(0.025F, 2.0F, -8.5F, 8.0F, 18.0F, 13.0F, 0.0F, true);
        left_front_arm.setTextureOffset(53, 69).addBox(-5.0F, 17.0F, -4.5F, 4.0F, 6.0F, 0.0F, 0.0F, true);
        left_front_arm.setTextureOffset(67, 0).addBox(-5.0F, 16.0F, -1.5F, 4.0F, 7.0F, 0.0F, 0.0F, true);
        left_front_arm.setTextureOffset(53, 69).addBox(-5.0F, 17.0F, 1.5F, 4.0F, 6.0F, 0.0F, 0.0F, true);

        head = new AdvancedModelBox(this,"head");
        head.setRotationPoint(-1.0F, -30.0F, -9.0F);
        body.addChild(head);
        setRotationAngle(head, 0.0F, 0.1309F, 0.0F);
        head.setTextureOffset(24, 119).addBox(-4.2168F, -3.0F, -10.0F, 10.0F, 7.0F, 12.0F, 0.0F, false);

        head_cube1 = new AdvancedModelBox(this);
        head_cube1.setRotationPoint(1.5663F, -2.0F, -2.0F);
        head.addChild(head_cube1);
        setRotationAngle(head_cube1, 0.1616F, 0.1866F, -0.0568F);
        head_cube1.setTextureOffset(36, 100).addBox(0.8F, -5.0F, -8.0F, 6.0F, 6.0F, 11.0F, 0.0F, false);

        head_cube2 = new AdvancedModelBox(this);
        head_cube2.setRotationPoint(-3.2168F, -3.0F, -2.0F);
        head.addChild(head_cube2);
        setRotationAngle(head_cube2, 0.48F, 0.0F, 0.0F);
        head_cube2.setTextureOffset(62, 38).addBox(1.0F, -6.0F, -12.0F, 6.0F, 6.0F, 28.0F, 0.0F, false);

        head_cube3 = new AdvancedModelBox(this);
        head_cube3.setRotationPoint(0.0F, -2.0F, -2.0F);
        head.addChild(head_cube3);
        setRotationAngle(head_cube3, 0.1616F, -0.1866F, 0.0568F);
        head_cube3.setTextureOffset(125, 113).addBox(-6.8F, -5.0F, -8.0F, 6.0F, 6.0F, 11.0F, 0.0F, false);

        head_cube4 = new AdvancedModelBox(this);
        head_cube4.setRotationPoint(-0.7168F, 30.0F, 5.0F);
        head.addChild(head_cube4);
        setRotationAngle(head_cube4, 0.0436F, 0.0F, 0.0F);
        head_cube4.setTextureOffset(102, 49).addBox(-3.0F, -34.0F, -23.0F, 9.0F, 7.0F, 10.0F, -0.01F, false);

        right_horn = new AdvancedModelBox(this,"right_horn");
        right_horn.setRotationPoint(-2.0F, -5.0F, -3.0F);
        head.addChild(right_horn);
        right_horn.setTextureOffset(148, 105).addBox(-9.2168F, -9.0F, 4.0513F, 5.0F, 5.0F, 6.0F, 0.0F, false);
        right_horn.setTextureOffset(148, 40).addBox(-9.2168F, -9.0F, -1.9487F, 6.0F, 6.0F, 6.0F, 0.0F, false);
        right_horn.setTextureOffset(129, 0).addBox(-9.2168F, -3.0F, -1.9487F, 12.0F, 6.0F, 6.0F, 0.0F, false);

        left_horn = new AdvancedModelBox(this,"left_horn");
        left_horn.setRotationPoint(3.5663F, -5.0F, -3.0F);
        head.addChild(left_horn);
        left_horn.setTextureOffset(148, 52).addBox(4.2168F, -9.0F, 4.0513F, 5.0F, 5.0F, 6.0F, 0.0F, false);
        left_horn.setTextureOffset(96, 146).addBox(3.2168F, -9.0F, -1.9487F, 6.0F, 6.0F, 6.0F, 0.0F, false);
        left_horn.setTextureOffset(123, 93).addBox(-2.7832F, -3.0F, -1.9487F, 12.0F, 6.0F, 6.0F, 0.0F, false);

        jaw = new AdvancedModelBox(this,"jaw");
        jaw.setRotationPoint(0.0F, 6.0F, -6.0F);
        head.addChild(jaw);
        setRotationAngle(jaw, 0.1309F, 0.0F, 0.0F);
        jaw.setTextureOffset(102, 29).addBox(-2.7168F, -4.0F, -12.0F, 7.0F, 4.0F, 16.0F, 0.0F, false);

        tail1 = new AdvancedModelBox(this,"tail1");
        tail1.setRotationPoint(0.0F, -0.1231F, 11.3724F);
        pelvis.addChild(tail1);
        setRotationAngle(tail1, -0.3927F, 0.0F, 0.0F);
        tail1.setTextureOffset(130, 54).addBox(-1.5F, -2.0F, -1.0F, 3.0F, 4.0F, 12.0F, 0.0F, false);

        tail2 = new AdvancedModelBox(this,"tail2");
        tail2.setRotationPoint(1.0F, -0.5F, 10.0F);
        tail1.addChild(tail2);
        setRotationAngle(tail2, 0.4799F, 0.0F, 0.0F);
        tail2.setTextureOffset(67, 0).addBox(-2.0F, -1.1888F, -1.1585F, 2.0F, 3.0F, 12.0F, 0.0F, false);

        legs = new AdvancedModelBox(this,"legs");
        legs.setRotationPoint(0.0F, -22.0F, 0.0F);
        mid_root.addChild(legs);


        right_leg = new AdvancedModelBox(this,"right_leg");
        right_leg.setRotationPoint(-6.7832F, 4.0F, 0.9487F);
        legs.addChild(right_leg);
        setRotationAngle(right_leg, -0.1295F, 0.5275F, 0.3306F);
        right_leg.setTextureOffset(145, 70).addBox(-3.2168F, -2.0F, -3.0F, 7.0F, 10.0F, 7.0F, 0.0F, false);

        right_front_leg = new AdvancedModelBox(this,"right_front_leg");
        right_front_leg.setRotationPoint(-0.975F, 8.0F, -2.0F);
        right_leg.addChild(right_front_leg);
        setRotationAngle(right_front_leg, 0.3927F, 0.0F, 0.0F);
        right_front_leg.setTextureOffset(137, 22).addBox(-2.2168F, 0.0F, -1.0F, 7.0F, 11.0F, 7.0F, 0.0F, false);
        right_front_leg.setTextureOffset(53, 62).addBox(-1.2168F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);
        right_front_leg.setTextureOffset(53, 62).addBox(3.7832F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);
        right_front_leg.setTextureOffset(53, 62).addBox(1.2832F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);

        left_leg = new AdvancedModelBox(this,"left_leg");
        left_leg.setRotationPoint(6.7832F, 3.0F, 0.9487F);
        legs.addChild(left_leg);
        setRotationAngle(left_leg, -0.1295F, -0.5275F, -0.3306F);
        left_leg.setTextureOffset(28, 138).addBox(-3.7832F, -2.0F, -3.0F, 7.0F, 10.0F, 7.0F, 0.0F, false);

        left_front_leg = new AdvancedModelBox(this,"left_front_leg");
        left_front_leg.setRotationPoint(0.975F, 8.0F, -2.0F);
        left_leg.addChild(left_front_leg);
        setRotationAngle(left_front_leg, 0.3927F, 0.0F, 0.0F);
        left_front_leg.setTextureOffset(0, 131).addBox(-4.7832F, 0.0F, -1.0F, 7.0F, 11.0F, 7.0F, 0.0F, false);
        left_front_leg.setTextureOffset(53, 62).addBox(1.2168F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, 0.0F, true);
        left_front_leg.setTextureOffset(53, 62).addBox(-1.2832F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, 0.0F, true);
        left_front_leg.setTextureOffset(53, 62).addBox(-3.7832F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, 0.0F, true);
        this.updateDefaultPose();
    }

    @Override
    public void setupAnim(Kobolediator_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.resetToDefaultPose();
        this.faceTarget(netHeadYaw, headPitch, 1, head);
        if(entity.getAttackState() != 6 && !entity.isSleep()) {
            this.animateWalk(Kobolediator_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 4.0F);
        }
        this.animate(entity.getAnimationState("idle"), Kobolediator_Animation.IDLE, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("sleep"), Kobolediator_Animation.SLEEP, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("awake"), Kobolediator_Animation.AWAKE, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("sword1"), Kobolediator_Animation.SWORD1, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("sword2"), Kobolediator_Animation.SWORD2, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("charge"), Kobolediator_Animation.CHARGE, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("charge_prepare"), Kobolediator_Animation.CHARGE_PREPARE, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("charge_end"), Kobolediator_Animation.CHARGE_END, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("death"), Kobolediator_Animation.DEATH, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("block"), Kobolediator_Animation.BLOCK, ageInTicks, 1.0F);
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
        return ImmutableList.of( everything,
                 mid_root,
                pelvis,
                 lower_body,
                 body,
                right_shoulder,
                right_arm,
                right_front_arm,
                 golden_greatsword,
                 left_shoulder,
                 left_arm,
                 left_front_arm,
                 head,
                 head_cube1,
                 head_cube2,
                 head_cube3,
                 head_cube4,
                right_horn,
                 left_horn,
                jaw,
                 tail1,
                 tail2,
                 legs,
                right_leg,
                right_front_leg,
                left_leg,
                 left_front_leg);
    }

}
