package com.github.L_Ender.cataclysm.client.model.entity;


import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Guardian_Entity;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class ModelEnder_Guardian extends AdvancedEntityModel<Ender_Guardian_Entity> {
    public final AdvancedModelBox root;
    public final AdvancedModelBox lowerbody;
    public final AdvancedModelBox upperbody;
    public final AdvancedModelBox right_arm;
    public final AdvancedModelBox rightarmor;
    public final AdvancedModelBox rightarmorspike;
    public final AdvancedModelBox right_arm2;
    public final AdvancedModelBox right_fist;
    public final AdvancedModelBox left_arm;
    public final AdvancedModelBox leftarmor;
    public final AdvancedModelBox leftarmorspike;
    public final AdvancedModelBox left_arm2;
    public final AdvancedModelBox left_fist;
    public final AdvancedModelBox helmet;
    public final AdvancedModelBox head;
    public final AdvancedModelBox upperhelmet;
    public final AdvancedModelBox armor;
    public final AdvancedModelBox voidstone;
    public final AdvancedModelBox right_leg;
    public final AdvancedModelBox left_leg;
    private ModelAnimator animator;

    public ModelEnder_Guardian() {
        texWidth = 256;
        texHeight = 256;

        root = new AdvancedModelBox(this);
        root.setRotationPoint(0.0F, 24.0F, 0.0F);


        lowerbody = new AdvancedModelBox(this);
        lowerbody.setRotationPoint(0.0F, -22.0F, 0.0F);
        root.addChild(lowerbody);
        lowerbody.setTextureOffset(121, 0).addBox(-11.0F, -8.0F, -7.0F, 22.0F, 8.0F, 14.0F, 0.0F, false);

        upperbody = new AdvancedModelBox(this);
        upperbody.setRotationPoint(0.0F, -7.0F, 0.0F);
        lowerbody.addChild(upperbody);
        upperbody.setTextureOffset(0, 0).addBox(-20.0F, -32.0F, -10.0F, 40.0F, 32.0F, 20.0F, 0.0F, false);

        right_arm = new AdvancedModelBox(this);
        right_arm.setRotationPoint(-20.0F, -25.0F, 0.0F);
        upperbody.addChild(right_arm);
        right_arm.setTextureOffset(94, 150).addBox(-14.0F, -6.0F, -6.0F, 14.0F, 20.0F, 12.0F, 0.0F, false);

        rightarmor = new AdvancedModelBox(this);
        rightarmor.setRotationPoint(-7.0F, 0.0F, -10.0F);
        right_arm.addChild(rightarmor);
        rightarmor.setTextureOffset(103, 35).addBox(-10.0F, -7.0F, 1.0F, 12.0F, 18.0F, 18.0F, 0.0F, false);

        rightarmorspike = new AdvancedModelBox(this);
        rightarmorspike.setRotationPoint(-7.0F, -3.0F, 10.0F);
        rightarmor.addChild(rightarmorspike);
        setRotationAngle(rightarmorspike, 0.0F, 0.0F, -0.6109F);
        rightarmorspike.setTextureOffset(0, 162).addBox(-3.0F, -12.0F, -3.0F, 6.0F, 12.0F, 6.0F, 0.0F, false);

        right_arm2 = new AdvancedModelBox(this);
        right_arm2.setRotationPoint(-8.5F, 14.0F, 0.0F);
        right_arm.addChild(right_arm2);
        right_arm2.setTextureOffset(146, 23).addBox(-5.5F, 0.0F, -6.0F, 10.0F, 14.0F, 12.0F, 0.0F, false);

        right_fist = new AdvancedModelBox(this);
        right_fist.setRotationPoint(-5.5F, 14.0F, 0.0F);
        right_arm2.addChild(right_fist);
        right_fist.setTextureOffset(142, 72).addBox(0.0F, -1.0F, -6.0F, 12.0F, 12.0F, 12.0F, 0.25F, false);

        left_arm = new AdvancedModelBox(this);
        left_arm.setRotationPoint(20.0F, -25.0F, 0.0F);
        upperbody.addChild(left_arm);
        left_arm.setTextureOffset(94, 150).addBox(0.0F, -6.0F, -6.0F, 14.0F, 20.0F, 12.0F, 0.0F, true);

        leftarmor = new AdvancedModelBox(this);
        leftarmor.setRotationPoint(7.0F, 0.0F, -10.0F);
        left_arm.addChild(leftarmor);
        leftarmor.setTextureOffset(103, 35).addBox(-2.0F, -7.0F, 1.0F, 12.0F, 18.0F, 18.0F, 0.0F, true);

        leftarmorspike = new AdvancedModelBox(this);
        leftarmorspike.setRotationPoint(7.0F, -3.0F, 10.0F);
        leftarmor.addChild(leftarmorspike);
        setRotationAngle(leftarmorspike, 0.0F, 0.0F, 0.6109F);
        leftarmorspike.setTextureOffset(0, 162).addBox(-3.0F, -12.0F, -3.0F, 6.0F, 12.0F, 6.0F, 0.0F, true);

        left_arm2 = new AdvancedModelBox(this);
        left_arm2.setRotationPoint(8.5F, 14.0F, 0.0F);
        left_arm.addChild(left_arm2);
        left_arm2.setTextureOffset(146, 23).addBox(-4.5F, 0.0F, -6.0F, 10.0F, 14.0F, 12.0F, 0.0F, true);

        left_fist = new AdvancedModelBox(this);
        left_fist.setRotationPoint(5.5F, 14.0F, 0.0F);
        left_arm2.addChild(left_fist);
        left_fist.setTextureOffset(142, 72).addBox(-12.0F, -1.0F, -6.0F, 12.0F, 12.0F, 12.0F, 0.25F, true);

        helmet = new AdvancedModelBox(this);
        helmet.setRotationPoint(0.0F, -28.0F, -7.0F);
        upperbody.addChild(helmet);
        helmet.setTextureOffset(0, 139).addBox(-8.0F, 2.0F, -16.0F, 16.0F, 6.0F, 16.0F, 0.0F, false);
        helmet.setTextureOffset(58, 155).addBox(-10.0F, -1.0F, -12.0F, 6.0F, 10.0F, 7.0F, 0.0F, false);
        helmet.setTextureOffset(161, 114).addBox(4.0F, -1.0F, -12.0F, 6.0F, 10.0F, 7.0F, 0.0F, false);

        head = new AdvancedModelBox(this);
        head.setRotationPoint(0.0F, -4.0F, -8.0F);
        helmet.addChild(head);
        head.setTextureOffset(49, 99).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);

        upperhelmet = new AdvancedModelBox(this);
        upperhelmet.setRotationPoint(0.0F, 0.0F, 0.0F);
        helmet.addChild(upperhelmet);
        upperhelmet.setTextureOffset(106, 121).addBox(-8.0F, -7.75F, -16.0F, 16.0F, 12.0F, 16.0F, -0.25F, false);
        upperhelmet.setTextureOffset(147, 150).addBox(-3.0F, -9.5F, -16.7F, 6.0F, 13.0F, 10.0F, 0.0F, false);

        armor = new AdvancedModelBox(this);
        armor.setRotationPoint(0.0F, 0.0F, 0.0F);
        upperbody.addChild(armor);
        armor.setTextureOffset(0, 53).addBox(-17.0F, -34.0F, -12.0F, 34.0F, 21.0F, 24.0F, 0.0F, false);
        armor.setTextureOffset(91, 73).addBox(-25.0F, -35.0F, -13.0F, 12.0F, 21.0F, 26.0F, 0.0F, false);
        armor.setTextureOffset(91, 73).addBox(13.0F, -35.0F, -13.0F, 12.0F, 21.0F, 26.0F, 0.0F, true);

        voidstone = new AdvancedModelBox(this);
        voidstone.setRotationPoint(0.0F, -16.0F, 10.0F);
        upperbody.addChild(voidstone);
        setRotationAngle(voidstone, -0.7854F, 0.0F, 0.0F);
        voidstone.setTextureOffset(0, 99).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, 1.0F, false);

        right_leg = new AdvancedModelBox(this);
        right_leg.setRotationPoint(-11.0F, -22.0F, 0.0F);
        root.addChild(right_leg);
        right_leg.setTextureOffset(49, 116).addBox(-8.0F, 0.0F, -8.0F, 12.0F, 22.0F, 16.0F, 0.0F, false);

        left_leg = new AdvancedModelBox(this);
        left_leg.setRotationPoint(11.0F, -22.0F, 0.0F);
        root.addChild(left_leg);
        left_leg.setTextureOffset(49, 116).addBox(-4.0F, 0.0F, -8.0F, 12.0F, 22.0F, 16.0F, 0.0F, true);
        animator = ModelAnimator.create();
        this.updateDefaultPose();
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4) {
        this.resetToDefaultPose();
        animator.update(entity);
        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_RIGHT_ATTACK);
        animator.startKeyframe(10);
        animator.rotate(upperbody,(float)Math.toRadians(5f),  (float)Math.toRadians(32.5F), (float)Math.toRadians(2.5F));
        animator.move(upperbody,0,0 ,-1);
        animator.rotate(left_leg,0,  (float)Math.toRadians(-5F), 0);
        animator.move(left_leg,0,0,-2);
        animator.rotate(right_leg,0,  (float)Math.toRadians(17.5F), 0);
        animator.move(right_leg, 1, 0,5);
        animator.rotate(armor,0,0,(float)Math.toRadians(7.5F));
        animator.move(armor, -3,0,0);
        animator.rotate(right_arm, (float)Math.toRadians(-17.5F),0,(float)Math.toRadians(35F));
        animator.move(right_arm, 2,1,1);
        animator.rotate(rightarmor,0,0,(float)Math.toRadians(5F));
        animator.rotate(right_arm2,(float)Math.toRadians(-80F), (float)Math.toRadians(-55F), (float)Math.toRadians(15F));
        animator.rotate(helmet,(float)Math.toRadians(17.5F),(float)Math.toRadians(-25F),(float)Math.toRadians(-2.5F));
        animator.rotate(left_arm, (float)Math.toRadians(-15F),(float)Math.toRadians(7.5F),(float)Math.toRadians(2.5F));
        animator.move(left_arm,1,3,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-37.5F),0,0);
        animator.move(left_arm2, -2,1,2);
        animator.move(left_fist, 0,-5,0);
        animator.endKeyframe();
        animator.setStaticKeyframe(10);

        animator.startKeyframe(3);
        animator.rotate(lowerbody,(float)Math.toRadians(10f),  (float)Math.toRadians(-7.5F), 0);
        animator.rotate(upperbody,(float)Math.toRadians(35F), (float)Math.toRadians(-30F), (float)Math.toRadians(-10F));
        animator.move(upperbody,0,0 ,-1);
        animator.rotate(left_leg,0,  (float)Math.toRadians(-12.5F), 0);
        animator.move(left_leg,0,0,2);
        animator.move(right_leg, 0,0,-4);
        animator.rotate(right_arm,(float)Math.toRadians(-65f),(float)Math.toRadians(-7.5f),(float)Math.toRadians(5f));
        animator.move(right_arm,-1,2,-7);
        animator.rotate(rightarmor, (float)Math.toRadians(10f),0,0);
        animator.move(rightarmor,0,-7,-2);
        animator.rotate(right_arm2,(float)Math.toRadians(-32.5f),(float)Math.toRadians(-87.5f),(float)Math.toRadians(32.5f));
        animator.move(right_arm2,2,0,0);
        animator.rotate(left_arm,(float)Math.toRadians(-10f),0,0);
        animator.move(left_arm,0,-2,-1);
        animator.rotate(left_arm2,(float)Math.toRadians(-40f),0,0);
        animator.move(left_arm2,0,-2,2);
        animator.rotate(helmet,(float)Math.toRadians(15F),(float)Math.toRadians(12.5F),(float)Math.toRadians(2.5F));
        animator.endKeyframe();
        animator.setStaticKeyframe(7);
        animator.resetKeyframe(10);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_LEFT_ATTACK);
        animator.startKeyframe(8);
        animator.rotate(upperbody,(float)Math.toRadians(5f),  (float)Math.toRadians(-32.5F), (float)Math.toRadians(-2.5F));
        animator.move(upperbody,0,0 ,-1);
        animator.rotate(right_leg,0,  (float)Math.toRadians(5F), 0);
        animator.move(right_leg,0,0,-2);
        animator.rotate(left_leg,0,  (float)Math.toRadians(-17.5F), 0);
        animator.move(left_leg, -1, 0,5);
        animator.rotate(armor,0,0,(float)Math.toRadians(-7.5F));
        animator.move(armor, 3,0,0);
        animator.rotate(left_arm, (float)Math.toRadians(-17.5F),0,(float)Math.toRadians(-35F));
        animator.move(left_arm, -2,1,1);
        animator.rotate(leftarmor,0,0,(float)Math.toRadians(-5F));
        animator.rotate(left_arm2,(float)Math.toRadians(-80F), (float)Math.toRadians(55F), (float)Math.toRadians(-15F));
        animator.rotate(helmet,(float)Math.toRadians(17.5F),(float)Math.toRadians(25F),(float)Math.toRadians(2.5F));
        animator.rotate(right_arm, (float)Math.toRadians(-15F),(float)Math.toRadians(-7.5F),(float)Math.toRadians(-2.5F));
        animator.move(right_arm,-1,3,0);
        animator.rotate(right_arm2,(float)Math.toRadians(-37.5F),0,0);
        animator.move(right_arm2, 2,1,2);
        animator.move(right_fist, 0,-5,0);
        animator.endKeyframe();
        animator.setStaticKeyframe(7);

        animator.startKeyframe(3);
        animator.rotate(lowerbody,(float)Math.toRadians(10f),  (float)Math.toRadians(7.5F), 0);
        animator.rotate(upperbody,(float)Math.toRadians(35F), (float)Math.toRadians(30F), (float)Math.toRadians(10F));
        animator.move(upperbody,0,0 ,-1);
        animator.rotate(right_leg,0,  (float)Math.toRadians(-12.5F), 0);
        animator.move(right_leg,0,0,2);
        animator.move(left_leg, 0,0,-4);
        animator.rotate(left_arm,(float)Math.toRadians(-65f),(float)Math.toRadians(7.5f),(float)Math.toRadians(-5f));
        animator.move(left_arm,1,2,-7);
        animator.rotate(leftarmor, (float)Math.toRadians(10f),0,0);
        animator.move(leftarmor,0,-7,-2);
        animator.rotate(left_arm2,(float)Math.toRadians(-32.5f),(float)Math.toRadians(87.5f),(float)Math.toRadians(-32.5f));
        animator.move(left_arm2,-2,0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-10f),0,0);
        animator.move(right_arm,0,-2,-1);
        animator.rotate(right_arm2,(float)Math.toRadians(-40f),0,0);
        animator.move(right_arm2,0,-2,2);
        animator.rotate(helmet,(float)Math.toRadians(15F),(float)Math.toRadians(-12F),(float)Math.toRadians(-2.5F));
        animator.endKeyframe();
        animator.setStaticKeyframe(12);
        animator.resetKeyframe(10);


        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_RIGHT_STRONG_ATTACK);
        animator.startKeyframe(15);
        animator.rotate(upperbody,(float)Math.toRadians(5f),  (float)Math.toRadians(32.5F), (float)Math.toRadians(2.5F));
        animator.move(upperbody,0,0 ,-1);
        animator.rotate(left_leg,0,  (float)Math.toRadians(-5F), 0);
        animator.move(left_leg,0,0,-2);
        animator.rotate(right_leg,0,  (float)Math.toRadians(17.5F), 0);
        animator.move(right_leg, 1, 0,5);
        animator.rotate(armor,0,0,(float)Math.toRadians(7.5F));
        animator.move(armor, -3,0,0);
        animator.rotate(right_arm, (float)Math.toRadians(-17.5F),0,(float)Math.toRadians(35F));
        animator.move(right_arm, 2,1,1);
        animator.rotate(rightarmor,0,0,(float)Math.toRadians(5F));
        animator.rotate(right_arm2,(float)Math.toRadians(-80F), (float)Math.toRadians(-55F), (float)Math.toRadians(15F));
        animator.rotate(helmet,(float)Math.toRadians(17.5F),(float)Math.toRadians(-25F),(float)Math.toRadians(-2.5F));
        animator.rotate(left_arm, (float)Math.toRadians(-15F),(float)Math.toRadians(7.5F),(float)Math.toRadians(2.5F));
        animator.move(left_arm,1,3,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-37.5F),0,0);
        animator.move(left_arm2, -2,1,2);
        animator.move(left_fist, 0,-5,0);
        animator.endKeyframe();
        animator.setStaticKeyframe(12);

        animator.startKeyframe(3);
        animator.rotate(lowerbody,(float)Math.toRadians(10f),  (float)Math.toRadians(-7.5F), 0);
        animator.rotate(upperbody,(float)Math.toRadians(27.5F), (float)Math.toRadians(-30F), (float)Math.toRadians(-10F));
        animator.move(upperbody,0,0 ,-1);
        animator.rotate(left_leg,0,  (float)Math.toRadians(-12.5F), 0);
        animator.move(left_leg,0,0,2);
        animator.move(right_leg, 0,0,-4);
        animator.rotate(right_arm,(float)Math.toRadians(-60f),(float)Math.toRadians(-7.5f),(float)Math.toRadians(5f));
        animator.move(right_arm,-1,9,0);
        animator.rotate(rightarmor, (float)Math.toRadians(10f),0,0);
        animator.move(rightarmor,0,-7,-2);
        animator.rotate(right_arm2,(float)Math.toRadians(-32.5f),(float)Math.toRadians(-87.5f),(float)Math.toRadians(32.5f));
        animator.move(right_arm2,2,0,0);
        animator.rotate(left_arm,(float)Math.toRadians(-10f),0,0);
        animator.move(left_arm,0,-2,-1);
        animator.rotate(left_arm2,(float)Math.toRadians(-40f),0,0);
        animator.move(left_arm2,0,-2,2);
        animator.rotate(helmet,(float)Math.toRadians(15F),(float)Math.toRadians(12.5F),(float)Math.toRadians(2.5F));
        animator.endKeyframe();
        animator.setStaticKeyframe(13);
        animator.resetKeyframe(17);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_LEFT_STRONG_ATTACK);
        animator.startKeyframe(17);
        animator.rotate(upperbody,(float)Math.toRadians(5f),  (float)Math.toRadians(-32.5F), (float)Math.toRadians(-2.5F));
        animator.move(upperbody,0,0 ,-1);
        animator.rotate(right_leg,0,  (float)Math.toRadians(5F), 0);
        animator.move(right_leg,0,0,-2);
        animator.rotate(left_leg,0,  (float)Math.toRadians(-17.5F), 0);
        animator.move(left_leg, -1, 0,5);
        animator.rotate(armor,0,0,(float)Math.toRadians(-7.5F));
        animator.move(armor, 3,0,0);
        animator.rotate(left_arm, (float)Math.toRadians(-17.5F),0,(float)Math.toRadians(-35F));
        animator.move(left_arm, -2,1,1);
        animator.rotate(leftarmor,0,0,(float)Math.toRadians(-5F));
        animator.rotate(left_arm2,(float)Math.toRadians(-80F), (float)Math.toRadians(55F), (float)Math.toRadians(-15F));
        animator.rotate(helmet,(float)Math.toRadians(17.5F),(float)Math.toRadians(25F),(float)Math.toRadians(2.5F));
        animator.rotate(right_arm, (float)Math.toRadians(-15F),(float)Math.toRadians(-7.5F),(float)Math.toRadians(-2.5F));
        animator.move(right_arm,-1,3,0);
        animator.rotate(right_arm2,(float)Math.toRadians(-37.5F),0,0);
        animator.move(right_arm2, 2,1,2);
        animator.move(right_fist, 0,-5,0);
        animator.endKeyframe();
        animator.setStaticKeyframe(15);

        animator.startKeyframe(3);
        animator.rotate(lowerbody,(float)Math.toRadians(10f),  (float)Math.toRadians(7.5F), 0);
        animator.rotate(upperbody,(float)Math.toRadians(27.5F), (float)Math.toRadians(30F), (float)Math.toRadians(10F));
        animator.move(upperbody,0,0 ,-1);
        animator.rotate(right_leg,0,  (float)Math.toRadians(-12.5F), 0);
        animator.move(right_leg,0,0,2);
        animator.move(left_leg, 0,0,-4);
        animator.rotate(left_arm,(float)Math.toRadians(-60f),(float)Math.toRadians(7.5f),(float)Math.toRadians(-5f));
        animator.move(left_arm,1,9,0);
        animator.rotate(leftarmor, (float)Math.toRadians(10f),0,0);
        animator.move(leftarmor,0,-7,-2);
        animator.rotate(left_arm2,(float)Math.toRadians(-32.5f),(float)Math.toRadians(87.5f),(float)Math.toRadians(-32.5f));
        animator.move(left_arm2,-2,0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-10f),0,0);
        animator.move(right_arm,0,-2,-1);
        animator.rotate(right_arm2,(float)Math.toRadians(-40f),0,0);
        animator.move(right_arm2,0,-2,2);
        animator.rotate(helmet,(float)Math.toRadians(15F),(float)Math.toRadians(-12F),(float)Math.toRadians(-2.5F));
        animator.endKeyframe();
        animator.setStaticKeyframe(10);
        animator.resetKeyframe(15);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_BURST_ATTACK);
        animator.startKeyframe(15);
        animator.move(left_leg,0,0,-3);
        animator.move(right_leg,0,0,4);
        animator.rotate(lowerbody,(float)Math.toRadians(-10f),0, 0);
        animator.move(lowerbody,0,0,2);
        animator.rotate(armor,(float)Math.toRadians(5f),0,0);
        animator.rotate(left_arm,(float)Math.toRadians(35f),(float)Math.toRadians(-5.5f),(float)Math.toRadians(-45f));
        animator.rotate(right_arm,(float)Math.toRadians(35f),(float)Math.toRadians(5.5f),(float)Math.toRadians(45f));
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.rotate(right_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,6,6);
        animator.move(right_arm2,0,6,6);
        animator.rotate(helmet,(float)Math.toRadians(17.5f),0,0);
        animator.endKeyframe();
        animator.setStaticKeyframe(10);

        animator.startKeyframe(3);
        animator.rotate(left_leg,(float)Math.toRadians(5f),0,0);
        animator.rotate(right_leg,(float)Math.toRadians(-5f),0,0);
        animator.move(left_leg,0,0,7);
        animator.move(right_leg,0,0,-5);
        animator.move(lowerbody,0,3,0);
        animator.rotate(lowerbody,(float)Math.toRadians(12.5f),0,0);
        animator.rotate(armor,(float)Math.toRadians(5f),0,0);
        animator.rotate(left_arm,(float)Math.toRadians(-80f),(float)Math.toRadians(12.5f),(float)Math.toRadians(-45f));
        animator.rotate(right_arm,(float)Math.toRadians(-80f),(float)Math.toRadians(-12.5f),(float)Math.toRadians(45f));
        animator.move(left_arm,0,0,-10);
        animator.move(right_arm,0,0,-10);
        animator.rotate(helmet,(float)Math.toRadians(17.5f),0,0);
        animator.endKeyframe();
        animator.setStaticKeyframe(10);
        animator.resetKeyframe(15);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_UPPERCUT_AND_BULLET);
        animator.startKeyframe(15);
        animator.rotate(left_leg,0,(float)Math.toRadians(12.5f),0);
        animator.move(left_leg,0,0,4);
        animator.move(right_leg,0,0,-3);
        animator.rotate(lowerbody,0,(float)Math.toRadians(-15f),0);
        animator.rotate(upperbody,(float)Math.toRadians(-2.5f),(float)Math.toRadians(-20f),(float)Math.toRadians(5f));
        animator.rotate(armor,0,0,(float)Math.toRadians(2.5f));
        animator.rotate(right_arm,(float)Math.toRadians(17.5f),(float)Math.toRadians(-5f),(float)Math.toRadians(10f));
        animator.rotate(right_arm2,(float)Math.toRadians(-77.5f),0,0);
        animator.move(right_arm,0,-1,0);
        animator.rotate(left_arm,(float)Math.toRadians(20f),(float)Math.toRadians(-20f),(float)Math.toRadians(-15f));
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,6,6);
        animator.endKeyframe();
        animator.setStaticKeyframe(10);

        animator.startKeyframe(5);
        animator.rotate(lowerbody,0,(float)Math.toRadians(20f),0);
        animator.rotate(upperbody,0,(float)Math.toRadians(35f),0);
        animator.rotate(right_arm,(float)Math.toRadians(35f),0,0);
        animator.rotate(right_arm2,(float)Math.toRadians(-77.5f),0,0);
        animator.rotate(left_arm,(float)Math.toRadians(-50f),(float)Math.toRadians(-2.5f),(float)Math.toRadians(-52.5f));
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,6,6);
        animator.endKeyframe();
        animator.setStaticKeyframe(20);

        animator.startKeyframe(5);
        animator.rotate(lowerbody,0,(float)Math.toRadians(-7.5f),0);
        animator.rotate(upperbody,0,(float)Math.toRadians(-7.5f),0);
        animator.rotate(right_arm,(float)Math.toRadians(35f),(float)Math.toRadians(20),(float)Math.toRadians(15));
        animator.rotate(right_arm2,(float)Math.toRadians(-77.5f),0,0);
        animator.rotate(left_arm,(float)Math.toRadians(45f),(float)Math.toRadians(-20f),(float)Math.toRadians(-35f));
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,6,6);
        animator.endKeyframe();
        animator.setStaticKeyframe(20);
        animator.resetKeyframe(15);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_STOMP);
        animator.startKeyframe(15);
        animator.move(right_leg,0,0,1);
        animator.move(left_leg,0,-9,-9);
        animator.rotate(lowerbody,(float)Math.toRadians(-7.5f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(-5f),0,0);
        animator.rotate(armor,(float)Math.toRadians(2.5f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-15f),(float)Math.toRadians(-12.5f),(float)Math.toRadians(5f));
        animator.rotate(left_arm,(float)Math.toRadians(-15f),(float)Math.toRadians(12.5f),(float)Math.toRadians(-5f));
        animator.move(right_arm,-1,0,0);
        animator.move(left_arm,1,0,0);
        animator.rotate(right_arm2,(float)Math.toRadians(-32.5f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-32.5f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(17.5f),0,0);
        animator.endKeyframe();

        animator.setStaticKeyframe(15);

        animator.startKeyframe(3);
        animator.move(right_leg,0,0,2);
        animator.move(left_leg,0,0,-8);
        animator.rotate(lowerbody,(float)Math.toRadians(15f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(-5f),0,0);
        animator.rotate(armor,(float)Math.toRadians(2.5f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(5f),(float)Math.toRadians(-7.5f),(float)Math.toRadians(5f));
        animator.rotate(left_arm,(float)Math.toRadians(5f),(float)Math.toRadians(7.5f),(float)Math.toRadians(-5f));
        animator.rotate(right_arm2,(float)Math.toRadians(-30f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-30f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(17.5f),0,0);
        animator.endKeyframe();
        animator.resetKeyframe(15);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_RAGE_STOMP);
        animator.startKeyframe(15);
        animator.move(right_leg,0,0,1);
        animator.move(left_leg,0,-9,-9);
        animator.rotate(lowerbody,(float)Math.toRadians(-7.5f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(-5f),0,0);
        animator.rotate(armor,(float)Math.toRadians(2.5f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-15f),(float)Math.toRadians(-12.5f),(float)Math.toRadians(5f));
        animator.rotate(left_arm,(float)Math.toRadians(-15f),(float)Math.toRadians(12.5f),(float)Math.toRadians(-5f));
        animator.move(right_arm,-1,0,0);
        animator.move(left_arm,1,0,0);
        animator.rotate(right_arm2,(float)Math.toRadians(-32.5f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-32.5f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(17.5f),0,0);
        animator.endKeyframe();

        animator.setStaticKeyframe(15);

        animator.startKeyframe(3);
        animator.move(right_leg,0,0,2);
        animator.move(left_leg,0,0,-8);
        animator.rotate(lowerbody,(float)Math.toRadians(15f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(-5f),0,0);
        animator.rotate(armor,(float)Math.toRadians(2.5f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(5f),(float)Math.toRadians(-7.5f),(float)Math.toRadians(5f));
        animator.rotate(left_arm,(float)Math.toRadians(5f),(float)Math.toRadians(7.5f),(float)Math.toRadians(-5f));
        animator.rotate(right_arm2,(float)Math.toRadians(-30f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-30f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(17.5f),0,0);
        animator.endKeyframe();

        animator.setStaticKeyframe(10);

        animator.startKeyframe(5);
        animator.move(right_leg,0,0,1);
        animator.move(left_leg,0,-9,-9);
        animator.rotate(lowerbody,(float)Math.toRadians(-7.5f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(-5f),0,0);
        animator.rotate(armor,(float)Math.toRadians(2.5f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-15f),(float)Math.toRadians(-12.5f),(float)Math.toRadians(5f));
        animator.rotate(left_arm,(float)Math.toRadians(-15f),(float)Math.toRadians(12.5f),(float)Math.toRadians(-5f));
        animator.move(right_arm,-1,0,0);
        animator.move(left_arm,1,0,0);
        animator.rotate(right_arm2,(float)Math.toRadians(-32.5f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-32.5f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(17.5f),0,0);
        animator.endKeyframe();

        animator.setStaticKeyframe(3);

        animator.startKeyframe(3);//54찍기
        animator.move(right_leg,0,0,2);
        animator.move(left_leg,0,0,-8);
        animator.rotate(lowerbody,(float)Math.toRadians(15f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(-5f),0,0);
        animator.rotate(armor,(float)Math.toRadians(2.5f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(5f),(float)Math.toRadians(-7.5f),(float)Math.toRadians(5f));
        animator.rotate(left_arm,(float)Math.toRadians(5f),(float)Math.toRadians(7.5f),(float)Math.toRadians(-5f));
        animator.rotate(right_arm2,(float)Math.toRadians(-30f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-30f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(17.5f),0,0);
        animator.endKeyframe();

        animator.setStaticKeyframe(3);

        animator.startKeyframe(3);
        animator.move(right_leg,0,0,1);
        animator.move(left_leg,0,-9,-9);
        animator.rotate(lowerbody,(float)Math.toRadians(-7.5f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(-5f),0,0);
        animator.rotate(armor,(float)Math.toRadians(2.5f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-15f),(float)Math.toRadians(-12.5f),(float)Math.toRadians(5f));
        animator.rotate(left_arm,(float)Math.toRadians(-15f),(float)Math.toRadians(12.5f),(float)Math.toRadians(-5f));
        animator.move(right_arm,-1,0,0);
        animator.move(left_arm,1,0,0);
        animator.rotate(right_arm2,(float)Math.toRadians(-32.5f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-32.5f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(17.5f),0,0);
        animator.endKeyframe();

        animator.startKeyframe(3);//63 찍기
        animator.move(right_leg,0,0,2);
        animator.move(left_leg,0,0,-8);
        animator.rotate(lowerbody,(float)Math.toRadians(15f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(-5f),0,0);
        animator.rotate(armor,(float)Math.toRadians(2.5f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(5f),(float)Math.toRadians(-7.5f),(float)Math.toRadians(5f));
        animator.rotate(left_arm,(float)Math.toRadians(5f),(float)Math.toRadians(7.5f),(float)Math.toRadians(-5f));
        animator.rotate(right_arm2,(float)Math.toRadians(-30f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-30f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(17.5f),0,0);
        animator.endKeyframe();

        animator.resetKeyframe(15);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_MASS_DESTRUCTION);
        animator.startKeyframe(25);
        animator.rotate(lowerbody,(float)Math.toRadians(-10f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(-22.5f),0,0);
        animator.rotate(armor,(float)Math.toRadians(-2.5f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-97.5f),(float)Math.toRadians(25f),(float)Math.toRadians(25f));
        animator.move(right_arm,0,0,-4);
        animator.rotate(left_arm,(float)Math.toRadians(-97.5f),(float)Math.toRadians(-25f),(float)Math.toRadians(-25f));
        animator.move(left_arm,0,0,-4);
        animator.rotate(right_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(right_arm2,0,6,6);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,6,6);
        animator.endKeyframe();

        animator.setStaticKeyframe(10);

        animator.startKeyframe(5);
        animator.rotate(lowerbody,(float)Math.toRadians(30f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(47.5f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-57.5f),(float)Math.toRadians(25f),(float)Math.toRadians(25f));
        animator.move(right_arm,0,0,-8);
        animator.rotate(left_arm,(float)Math.toRadians(-57.5f),(float)Math.toRadians(-25f),(float)Math.toRadians(-25f));
        animator.move(left_arm,0,0,-8);
        animator.rotate(right_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(right_arm2,0,6,6);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,6,6);
        animator.endKeyframe();
        animator.setStaticKeyframe(10);

        animator.resetKeyframe(25);


        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_FALLEN);
        animator.startKeyframe(15);
        animator.rotate(lowerbody,(float)Math.toRadians(-10f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(-20f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(30f),(float)Math.toRadians(10f),(float)Math.toRadians(72.5f));
        animator.rotate(left_arm,(float)Math.toRadians(30f),(float)Math.toRadians(-10f),(float)Math.toRadians(-75f));
        animator.rotate(right_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(right_arm2,0,6,6);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,6,6);
        animator.endKeyframe();

        animator.setStaticKeyframe(10);

        animator.startKeyframe(5);
        animator.rotate(lowerbody,(float)Math.toRadians(12.5f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(30f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-82.5f),(float)Math.toRadians(10f),(float)Math.toRadians(72.5f));
        animator.rotate(left_arm,(float)Math.toRadians(-82.5f),(float)Math.toRadians(-10f),(float)Math.toRadians(-75f));
        animator.endKeyframe();

        animator.setStaticKeyframe(20);

        animator.startKeyframe(6);
        animator.move(root,0,14,0);
        animator.rotate(right_leg,(float)Math.toRadians(90f),0,0);
        animator.rotate(left_leg,(float)Math.toRadians(90f),0,0);
        animator.rotate(lowerbody,(float)Math.toRadians(90f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(-52.5f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-65f),0,0);
        animator.rotate(left_arm,(float)Math.toRadians(-65f),0,0);
        animator.rotate(right_arm2,(float)Math.toRadians(-42.5f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-42.5f),0,0);
        animator.endKeyframe();

        animator.setStaticKeyframe(10);

        animator.startKeyframe(15);
        animator.move(root,0,14,0);
        animator.rotate(right_leg,(float)Math.toRadians(90f),0,0);
        animator.rotate(left_leg,(float)Math.toRadians(90f),0,0);
        animator.rotate(lowerbody,(float)Math.toRadians(90f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(-57.5f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-60f),0,0);
        animator.rotate(left_arm,(float)Math.toRadians(-60f),0,0);
        animator.rotate(right_arm2,(float)Math.toRadians(-35f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-35f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(-42.5f),0,0);
        animator.endKeyframe();

        animator.setStaticKeyframe(10);

        animator.startKeyframe(5);
        animator.move(root,0,14,0);
        animator.rotate(right_leg,(float)Math.toRadians(90f),0,0);
        animator.rotate(left_leg,(float)Math.toRadians(90f),0,0);
        animator.rotate(lowerbody,(float)Math.toRadians(90f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(-35f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-92.5f),0,0);
        animator.rotate(left_arm,(float)Math.toRadians(-92.5f),0,0);
        animator.rotate(right_arm2,(float)Math.toRadians(-35f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-35f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(20f),0,0);
        animator.endKeyframe();

        animator.setStaticKeyframe(100);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_RAGE_UPPERCUT);
        animator.startKeyframe(15);
        animator.rotate(left_leg,0,(float)Math.toRadians(12.5f),0);
        animator.move(left_leg,0,0,4);
        animator.move(right_leg,0,0,-3);
        animator.rotate(lowerbody,0,(float)Math.toRadians(-15f),0);
        animator.rotate(upperbody,(float)Math.toRadians(-2.5f),(float)Math.toRadians(-20f),(float)Math.toRadians(5f));
        animator.rotate(armor,0,0,(float)Math.toRadians(2.5f));
        animator.rotate(right_arm,(float)Math.toRadians(17.5f),(float)Math.toRadians(-5f),(float)Math.toRadians(10f));
        animator.rotate(right_arm2,(float)Math.toRadians(-77.5f),0,0);
        animator.move(right_arm,0,-1,0);
        animator.rotate(left_arm,(float)Math.toRadians(20f),(float)Math.toRadians(-20f),(float)Math.toRadians(-15f));
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,6,6);
        animator.endKeyframe();
        animator.setStaticKeyframe(10);

        animator.startKeyframe(5);
        animator.rotate(lowerbody,0,(float)Math.toRadians(20f),0);
        animator.rotate(upperbody,0,(float)Math.toRadians(35f),0);
        animator.rotate(right_arm,(float)Math.toRadians(35f),0,0);
        animator.rotate(right_arm2,(float)Math.toRadians(-77.5f),0,0);
        animator.rotate(left_arm,(float)Math.toRadians(-50f),(float)Math.toRadians(-2.5f),(float)Math.toRadians(-52.5f));
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,6,6);
        animator.endKeyframe();
        animator.setStaticKeyframe(20);

        animator.startKeyframe(5);
        animator.rotate(lowerbody,0,(float)Math.toRadians(-7.5f),0);
        animator.rotate(upperbody,0,(float)Math.toRadians(-7.5f),0);
        animator.rotate(right_arm,(float)Math.toRadians(35f),(float)Math.toRadians(20),(float)Math.toRadians(15));
        animator.rotate(right_arm2,(float)Math.toRadians(-77.5f),0,0);
        animator.rotate(left_arm,(float)Math.toRadians(45f),(float)Math.toRadians(-20f),(float)Math.toRadians(-35f));
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,6,6);
        animator.endKeyframe();
        animator.setStaticKeyframe(3);

        animator.startKeyframe(10);
        animator.rotate(upperbody,(float)Math.toRadians(-17.5f),0,0);
        animator.move(right_arm,0,0,-8);
        animator.rotate(right_arm,(float)Math.toRadians(-115f),0,(float)Math.toRadians(32.5f));
        animator.rotate(right_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(right_arm2,0,6,6);
        animator.move(left_arm,0,0,-7);
        animator.rotate(left_arm,(float)Math.toRadians(-115f),(float)Math.toRadians(-5f),(float)Math.toRadians(-32.5f));
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,6,6);
        animator.endKeyframe();
        animator.setStaticKeyframe(12);

        animator.startKeyframe(5);
        animator.rotate(lowerbody,(float)Math.toRadians(22.5f),0,0);
        animator.rotate(upperbody,(float)Math.toRadians(50f),0,0);
        animator.move(right_arm,0,0,-8);
        animator.rotate(right_arm,(float)Math.toRadians(-60f),(float)Math.toRadians(5f),(float)Math.toRadians(32.5f));
        animator.rotate(right_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(right_arm2,0,6,6);
        animator.move(left_arm,0,0,-7);
        animator.rotate(left_arm,(float)Math.toRadians(-60f),(float)Math.toRadians(-5f),(float)Math.toRadians(-32.5f));
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,6,6);
        animator.endKeyframe();
        animator.setStaticKeyframe(20);

        animator.resetKeyframe(15);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_HUG_ME);
        animator.startKeyframe(15);
        animator.rotate(root,0,(float)Math.toRadians(27.5f),0);
        animator.move(right_leg,0,0,8);
        animator.move(left_leg,0,0,-6);
        animator.rotate(upperbody,(float)Math.toRadians(35f),(float)Math.toRadians(-15f),0);
        animator.move(upperbody,0,2,0);
        animator.rotate(left_leg,0,(float)Math.toRadians(-35f),0);
        animator.rotate(right_arm,(float)Math.toRadians(42.5f),(float)Math.toRadians(-2.5f),(float)Math.toRadians(62.5f));
        animator.rotate(left_arm,(float)Math.toRadians(60f),(float)Math.toRadians(7.5f),(float)Math.toRadians(-57.5f));
        animator.rotate(right_arm2,(float)Math.toRadians(-90f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(-25f),(float)Math.toRadians(-7.5f),0);
        animator.endKeyframe();
        animator.setStaticKeyframe(20);

        animator.startKeyframe(6);
        animator.rotate(root,0,(float)Math.toRadians(-17.5f),0);
        animator.rotate(right_leg,0,(float)Math.toRadians(25f),0);
        animator.move(right_leg,0,0,-6);
        animator.move(left_leg,0,0,9);
        animator.rotate(upperbody,(float)Math.toRadians(-22.5f),(float)Math.toRadians(2.5f),0);
        animator.rotate(armor,0,0,(float)Math.toRadians(2.5f));
        animator.rotate(right_arm,(float)Math.toRadians(-60f),(float)Math.toRadians(5f),(float)Math.toRadians(45f));
        animator.rotate(left_arm,(float)Math.toRadians(-62.5f),(float)Math.toRadians(2.5f),(float)Math.toRadians(-35f));
        animator.rotate(right_arm2,(float)Math.toRadians(-82.5f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(17.5f),(float)Math.toRadians(17.5f),(float)Math.toRadians(5f));
        animator.endKeyframe();
        animator.setStaticKeyframe(20);

        animator.resetKeyframe(15);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_AIR_STRIKE1);
        animator.startKeyframe(15);
        animator.rotate(upperbody,(float)Math.toRadians(-15f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-15f),(float)Math.toRadians(-10f),(float)Math.toRadians(47.5f));
        animator.rotate(left_arm,(float)Math.toRadians(-17.5f),(float)Math.toRadians(10f),(float)Math.toRadians(-47.5f));
        animator.move(right_arm,0,0,-4);
        animator.move(left_arm,0,0,-4);
        animator.rotate(right_arm2,(float)Math.toRadians(-110f),(float)Math.toRadians(-30f),0);
        animator.rotate(left_arm2,(float)Math.toRadians(-110f),(float)Math.toRadians(30f),0);
        animator.move(right_arm2,0,6,0);
        animator.move(left_arm2,0,6,0);
        animator.endKeyframe();

        animator.setStaticKeyframe(3);

        animator.startKeyframe(2);
        animator.rotate(upperbody,(float)Math.toRadians(-15f),0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-50f),(float)Math.toRadians(-25f),(float)Math.toRadians(32.5f));
        animator.rotate(left_arm,(float)Math.toRadians(-50f),(float)Math.toRadians(25f),(float)Math.toRadians(-32.5f));
        animator.move(right_arm,2.5f,2f,-6);
        animator.move(left_arm,-2.75f,2f,-6);
        animator.rotate(right_arm2,(float)Math.toRadians(-105f),(float)Math.toRadians(-50f),(float)Math.toRadians(12.5f));
        animator.rotate(left_arm2,(float)Math.toRadians(-105f),(float)Math.toRadians(50f),(float)Math.toRadians(-12.5));
        animator.move(right_arm2,0,6f,0);
        animator.move(left_arm2,0,6f,0);
        animator.endKeyframe();
        animator.setStaticKeyframe(20);

        animator.startKeyframe(8);
        animator.rotate(root,0,(float)Math.toRadians(-17.5f),0);
        animator.rotate(lowerbody,(float)Math.toRadians(-5f),0,0);
        animator.move(lowerbody,0,3,0);
        animator.rotate(upperbody,(float)Math.toRadians(-27.5f),(float)Math.toRadians(-2.5f),(float)Math.toRadians(5f));
        animator.rotate(right_arm,(float)Math.toRadians(-82.5f),(float)Math.toRadians(17.5f),(float)Math.toRadians(45f));
        animator.rotate(left_arm,(float)Math.toRadians(-100f),(float)Math.toRadians(-17.5f),(float)Math.toRadians(-27.5f));
        animator.move(right_arm,2f,-2f,-2);
        animator.move(left_arm,-2f,-1f,-3);
        animator.rotate(right_arm2,(float)Math.toRadians(-82.5f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(17.5f),(float)Math.toRadians(17.5f),(float)Math.toRadians(5f));
        animator.rotate(right_leg,0,(float)Math.toRadians(30f),0);
        animator.move(right_leg,0,2,-6);
        animator.move(left_leg,0,3,9);
        animator.endKeyframe();
        animator.setStaticKeyframe(60);

        animator.resetKeyframe(15);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_AIR_STRIKE2);
        animator.startKeyframe(0);
        animator.rotate(root,0,(float)Math.toRadians(-17.5f),0);
        animator.rotate(lowerbody,(float)Math.toRadians(-5f),0,0);
        animator.move(lowerbody,0,3,0);
        animator.rotate(upperbody,(float)Math.toRadians(-27.5f),(float)Math.toRadians(-2.5f),(float)Math.toRadians(5f));
        animator.rotate(right_arm,(float)Math.toRadians(-82.5f),(float)Math.toRadians(17.5f),(float)Math.toRadians(45f));
        animator.rotate(left_arm,(float)Math.toRadians(-100f),(float)Math.toRadians(-17.5f),(float)Math.toRadians(-27.5f));
        animator.move(right_arm,2f,-2f,-2);
        animator.move(left_arm,-2f,-1f,-3);
        animator.rotate(right_arm2,(float)Math.toRadians(-82.5f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.rotate(helmet,(float)Math.toRadians(17.5f),(float)Math.toRadians(17.5f),(float)Math.toRadians(5f));
        animator.rotate(right_leg,0,(float)Math.toRadians(30f),0);
        animator.move(right_leg,0,2,-6);
        animator.move(left_leg,0,3,9);

        animator.endKeyframe();

        animator.startKeyframe(4);
        animator.rotate(root,0,(float)Math.toRadians(-17.5f),0);
        animator.rotate(lowerbody,(float)Math.toRadians(35f),0,0);
        animator.move(lowerbody,0,7,0);
        animator.rotate(upperbody,(float)Math.toRadians(27.5f),(float)Math.toRadians(12.5f),(float)Math.toRadians(-5f));
        animator.rotate(right_arm,(float)Math.toRadians(-65f),(float)Math.toRadians(-15f),(float)Math.toRadians(32.5f));
        animator.rotate(left_arm,(float)Math.toRadians(-65f),(float)Math.toRadians(15f),(float)Math.toRadians(-32.5f));
        animator.move(right_arm,2f,9f,-6);
        animator.move(left_arm,-1f,11f,-6);
        animator.rotate(right_arm2,(float)Math.toRadians(-90f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);

        animator.rotate(right_leg,0,(float)Math.toRadians(20f),0);
        animator.rotate(left_leg,(float)Math.toRadians(-15f),0,0);
        animator.move(right_leg,0,0,-6);
        animator.move(left_leg,0,1,5);
        animator.endKeyframe();
        animator.setStaticKeyframe(20);
        animator.resetKeyframe(15);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_RIGHT_SWING);
        animator.startKeyframe(0);
        animator.rotate(lowerbody,(float)Math.toRadians(10f),  (float)Math.toRadians(-7.5F), 0);
        animator.rotate(upperbody,(float)Math.toRadians(35F), (float)Math.toRadians(-30F), (float)Math.toRadians(-10F));
        animator.move(upperbody,0,0 ,-1);
        animator.rotate(left_leg,0,  (float)Math.toRadians(-12.5F), 0);
        animator.move(left_leg,0,0,2);
        animator.move(right_leg, 0,0,-4);
        animator.rotate(right_arm,(float)Math.toRadians(-65f),(float)Math.toRadians(-7.5f),(float)Math.toRadians(5f));
        animator.move(right_arm,-1,2,-7);
        animator.rotate(rightarmor, (float)Math.toRadians(10f),0,0);
        animator.move(rightarmor,0,-7,-2);
        animator.rotate(right_arm2,(float)Math.toRadians(-32.5f),(float)Math.toRadians(-87.5f),(float)Math.toRadians(32.5f));
        animator.move(right_arm2,2,0,0);
        animator.rotate(left_arm,(float)Math.toRadians(-10f),0,0);
        animator.move(left_arm,0,-2,-1);
        animator.rotate(left_arm2,(float)Math.toRadians(-40f),0,0);
        animator.move(left_arm2,0,-2,2);
        animator.rotate(helmet,(float)Math.toRadians(15F),(float)Math.toRadians(12.5F),(float)Math.toRadians(2.5F));
        animator.endKeyframe();

        animator.startKeyframe(15);
        animator.rotate(root,0,(float)Math.toRadians(5f),0);
        animator.rotate(lowerbody,(float)Math.toRadians(2.5f),(float)Math.toRadians(10f),0);
        animator.rotate(upperbody,(float)Math.toRadians(27.5f),(float)Math.toRadians(45f),(float)Math.toRadians(12.5f));
        animator.rotate(right_arm,(float)Math.toRadians(-10f),(float)Math.toRadians(32.5f),0);
        animator.move(right_arm,0,-2,-2);
        animator.rotate(right_arm2,(float)Math.toRadians(-65f),0,0);
        animator.move(right_arm2,0,-2,-2);
        animator.rotate(left_arm,(float)Math.toRadians(-65f),(float)Math.toRadians(7.5f),(float)Math.toRadians(-57.5f));
        animator.move(left_arm,4,8,-2);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,-6,-6);
        animator.rotate(helmet,(float)Math.toRadians(15f),(float)Math.toRadians(-12.5f),(float)Math.toRadians(-2.5f));
        animator.rotate(right_leg,0,(float)Math.toRadians(12.5f),0);
        animator.move(right_leg,0,0,8);
        animator.move(left_leg,0,0,-6);
        animator.endKeyframe();

        animator.setStaticKeyframe(8);

        animator.startKeyframe(4);
        animator.rotate(root,0,(float)Math.toRadians(5f),0);
        animator.rotate(lowerbody,(float)Math.toRadians(2.5f),(float)Math.toRadians(10f),0);
        animator.rotate(upperbody,(float)Math.toRadians(2.5f),(float)Math.toRadians(-45f),(float)Math.toRadians(12.5f));
        animator.rotate(right_arm,(float)Math.toRadians(-20f),(float)Math.toRadians(30f),(float)Math.toRadians(25f));
        animator.move(right_arm,0,-2,-2);
        animator.rotate(right_arm2,(float)Math.toRadians(-75f),(float)Math.toRadians(-25f),0);
        animator.move(right_arm2,0,-2,2);
        animator.rotate(left_arm,(float)Math.toRadians(32.5f),(float)Math.toRadians(7.5f),(float)Math.toRadians(-57.5f));
        animator.move(left_arm,4,8,2);
        animator.rotate(helmet,(float)Math.toRadians(-5f),(float)Math.toRadians(25f),(float)Math.toRadians(-12.5f));
        animator.rotate(right_leg,0,(float)Math.toRadians(12.5f),0);
        animator.move(right_leg,0,0,8);
        animator.move(left_leg,0,0,-6);
        animator.endKeyframe();

        animator.resetKeyframe(15);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_LEFT_SWING);

        animator.startKeyframe(0);
        animator.rotate(lowerbody,(float)Math.toRadians(10f),  (float)Math.toRadians(7.5F), 0);
        animator.rotate(upperbody,(float)Math.toRadians(35F), (float)Math.toRadians(30F), (float)Math.toRadians(10F));
        animator.move(upperbody,0,0 ,-1);
        animator.rotate(right_leg,0,  (float)Math.toRadians(-12.5F), 0);
        animator.move(right_leg,0,0,2);
        animator.move(left_leg, 0,0,-4);
        animator.rotate(left_arm,(float)Math.toRadians(-65f),(float)Math.toRadians(7.5f),(float)Math.toRadians(-5f));
        animator.move(left_arm,1,2,-7);
        animator.rotate(leftarmor, (float)Math.toRadians(10f),0,0);
        animator.move(leftarmor,0,-7,-2);
        animator.rotate(left_arm2,(float)Math.toRadians(-32.5f),(float)Math.toRadians(87.5f),(float)Math.toRadians(-32.5f));
        animator.move(left_arm2,-2,0,0);
        animator.rotate(right_arm,(float)Math.toRadians(-10f),0,0);
        animator.move(right_arm,0,-2,-1);
        animator.rotate(right_arm2,(float)Math.toRadians(-40f),0,0);
        animator.move(right_arm2,0,-2,2);
        animator.rotate(helmet,(float)Math.toRadians(15F),(float)Math.toRadians(-12F),(float)Math.toRadians(-2.5F));
        animator.endKeyframe();

        animator.startKeyframe(15);
        animator.rotate(root,0,(float)Math.toRadians(-5f),0);
        animator.rotate(lowerbody,(float)Math.toRadians(2.5f),(float)Math.toRadians(-10f),0);
        animator.rotate(upperbody,(float)Math.toRadians(27.5f),(float)Math.toRadians(-45f),(float)Math.toRadians(-12.5f));
        animator.rotate(left_arm,(float)Math.toRadians(-10f),(float)Math.toRadians(-32.5f),0);
        animator.move(left_arm,0,-2,-2);
        animator.rotate(left_arm2,(float)Math.toRadians(-65f),0,0);
        animator.move(left_arm2,0,-2,-2);
        animator.rotate(right_arm,(float)Math.toRadians(-65f),(float)Math.toRadians(-7.5f),(float)Math.toRadians(57.5f));
        animator.move(right_arm,-4,8,-2);
        animator.rotate(right_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(right_arm2,0,-6,6);
        animator.rotate(helmet,(float)Math.toRadians(15f),(float)Math.toRadians(12.5f),(float)Math.toRadians(2.5f));
        animator.rotate(left_leg,0,(float)Math.toRadians(-12.5f),0);
        animator.move(left_leg,0,0,8);
        animator.move(right_leg,0,0,-6);
        animator.endKeyframe();

        animator.setStaticKeyframe(8);

        animator.startKeyframe(4);
        animator.rotate(root,0,(float)Math.toRadians(5f),0);
        animator.rotate(lowerbody,(float)Math.toRadians(2.5f),(float)Math.toRadians(-10f),0);
        animator.rotate(upperbody,(float)Math.toRadians(2.5f),(float)Math.toRadians(45f),(float)Math.toRadians(-12.5f));
        animator.rotate(left_arm,(float)Math.toRadians(-20f),(float)Math.toRadians(-30f),(float)Math.toRadians(-25f));
        animator.move(left_arm,0,-2,-2);
        animator.rotate(left_arm2,(float)Math.toRadians(-75f),(float)Math.toRadians(25f),0);
        animator.move(left_arm2,0,-2,2);
        animator.rotate(right_arm,(float)Math.toRadians(32.5f),(float)Math.toRadians(-7.5f),(float)Math.toRadians(57.5f));
        animator.move(right_arm,-4,8,2);
        animator.rotate(helmet,(float)Math.toRadians(-5f),(float)Math.toRadians(-25f),(float)Math.toRadians(12.5f));
        animator.rotate(left_leg,0,(float)Math.toRadians(-12.5f),0);
        animator.move(left_leg,0,0,8);
        animator.move(right_leg,0,0,-6);
        animator.endKeyframe();

        animator.resetKeyframe(15);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_BLACKHOLE);
        animator.startKeyframe(12);
        animator.rotate(root,0,(float)Math.toRadians(42.5f),0);
        animator.rotate(lowerbody,0,(float)Math.toRadians(2.5f),0);
        animator.rotate(upperbody,(float)Math.toRadians(-12.5f),(float)Math.toRadians(22.5f),(float)Math.toRadians(-10f));
        animator.move(right_leg,0,0,9);
        animator.rotate(left_leg,0,(float)Math.toRadians(-35f),0);
        animator.move(left_leg,0,-7,-9);
        animator.rotate(right_arm,(float)Math.toRadians(-70f),(float)Math.toRadians(-5f),(float)Math.toRadians(55f));
        animator.rotate(left_arm,(float)Math.toRadians(-65f),0,(float)Math.toRadians(-57.5f));
        animator.rotate(right_arm2,(float)Math.toRadians(-90f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(right_arm2,0,6,0);
        animator.move(left_arm2,0,6,6);
        animator.rotate(helmet,(float)Math.toRadians(-5f),(float)Math.toRadians(-32.5f),0);
        animator.endKeyframe();

        animator.setStaticKeyframe(12);

        animator.startKeyframe(3);
        animator.rotate(root,0,(float)Math.toRadians(42.5f),0);
        animator.rotate(lowerbody,0,(float)Math.toRadians(5f),0);
        animator.rotate(upperbody,(float)Math.toRadians(17.5f),(float)Math.toRadians(20f),(float)Math.toRadians(10f));
        animator.move(right_leg,0,0,9);
        animator.rotate(left_leg,0,(float)Math.toRadians(-30f),0);
        animator.move(left_leg,0,0,-9);
        animator.rotate(right_arm,(float)Math.toRadians(30f),(float)Math.toRadians(-5f),(float)Math.toRadians(62.5f));
        animator.rotate(left_arm,(float)Math.toRadians(-32.5f),0,(float)Math.toRadians(-50f));
        animator.rotate(right_arm2,(float)Math.toRadians(-90f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(right_arm2,0,6,0);
        animator.move(left_arm2,0,6,6);
        animator.rotate(helmet,(float)Math.toRadians(-5f),(float)Math.toRadians(-32.5f),0);
        animator.endKeyframe();

        animator.setStaticKeyframe(20);

        animator.resetKeyframe(15);

        animator.setAnimation(Ender_Guardian_Entity.GUARDIAN_ROCKETPUNCH);
        animator.startKeyframe(0);
        animator.rotate(root,0,(float)Math.toRadians(42.5f),0);
        animator.rotate(lowerbody,0,(float)Math.toRadians(5f),0);
        animator.rotate(upperbody,(float)Math.toRadians(17.5f),(float)Math.toRadians(20f),(float)Math.toRadians(10f));
        animator.move(right_leg,0,0,9);
        animator.rotate(left_leg,0,(float)Math.toRadians(-30f),0);
        animator.move(left_leg,0,0,-9);
        animator.rotate(right_arm,(float)Math.toRadians(30f),(float)Math.toRadians(-5f),(float)Math.toRadians(62.5f));
        animator.rotate(left_arm,(float)Math.toRadians(-32.5f),0,(float)Math.toRadians(-50f));
        animator.rotate(right_arm2,(float)Math.toRadians(-90f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(right_arm2,0,6,0);
        animator.move(left_arm2,0,6,6);
        animator.rotate(helmet,(float)Math.toRadians(-5f),(float)Math.toRadians(-32.5f),0);
        animator.endKeyframe();

        animator.setStaticKeyframe(10);

        animator.startKeyframe(5);
        animator.rotate(root,0,(float)Math.toRadians(42.5f),0);
        animator.rotate(lowerbody,0,(float)Math.toRadians(10f),0);
        animator.rotate(upperbody,(float)Math.toRadians(17.5f),(float)Math.toRadians(25f),(float)Math.toRadians(10f));
        animator.move(right_leg,0,0,13);
        animator.rotate(left_leg,0,(float)Math.toRadians(-35f),0);
        animator.move(left_leg,0,0,-9);
        animator.rotate(right_arm,(float)Math.toRadians(40f),(float)Math.toRadians(-5f),(float)Math.toRadians(62.5f));
        animator.rotate(left_arm,(float)Math.toRadians(-57.5f),0,(float)Math.toRadians(-55f));
        animator.rotate(right_arm2,(float)Math.toRadians(-90f),0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(right_arm2,0,6,6);
        animator.move(left_arm2,0,6,6);
        animator.rotate(helmet,(float)Math.toRadians(-5f),(float)Math.toRadians(-32.5f),0);
        animator.endKeyframe();

        animator.setStaticKeyframe(10);

        animator.startKeyframe(3);
        animator.rotate(root,0,(float)Math.toRadians(-52.5f),0);
        animator.rotate(lowerbody,0,(float)Math.toRadians(-20f),0);
        animator.rotate(upperbody,(float)Math.toRadians(12.5f),0,(float)Math.toRadians(-12.5f));
        animator.move(right_leg,0,0,13);
        animator.rotate(left_leg,0,(float)Math.toRadians(-35f),0);
        animator.move(left_leg,0,0,-9);
        animator.rotate(right_arm,(float)Math.toRadians(-27.5f),(float)Math.toRadians(-2.5f),(float)Math.toRadians(72.5f));
        animator.rotate(left_arm,(float)Math.toRadians(-10f),(float)Math.toRadians(-10f),(float)Math.toRadians(-62.5f));
        animator.move(right_arm,-4,0,0);
        animator.rotate(left_arm2,(float)Math.toRadians(-90f),0,0);
        animator.move(left_arm2,0,6,6);
        animator.rotate(helmet,(float)Math.toRadians(-10f),(float)Math.toRadians(32.5f),0);
        animator.endKeyframe();

        animator.setStaticKeyframe(15);

        animator.resetKeyframe(15);
    }

    @Override
    public void setupAnim(Ender_Guardian_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float walkSpeed = 0.5F;
        float walkDegree = 0.5F;

        this.faceTarget(netHeadYaw, headPitch, 1, helmet);
        this.walk(left_leg, walkSpeed, walkDegree * 1.2F, true, 0F, 0F, limbSwing, limbSwingAmount);
        this.flap(root, walkSpeed, walkDegree * 0.2F, false, 0F, 0F, limbSwing, limbSwingAmount);
        this.walk(right_leg, walkSpeed, walkDegree * 1.2F, false, 0F, 0F, limbSwing, limbSwingAmount);
        this.walk(left_arm, walkSpeed, walkDegree * 1.2F, false, 0F, 0F, limbSwing, limbSwingAmount);
        this.walk(right_arm, walkSpeed, walkDegree * 1.2F, true, 0F, 0F, limbSwing, limbSwingAmount);
        upperhelmet.showModel = !entityIn.getIsHelmetless();
        head.showModel = entityIn.deathTime <= 100;

    }


    @Override
    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(
                root,
                left_arm,
                right_arm,
                left_arm2,
                right_arm2,
                left_fist,
                right_fist,
                left_leg,
                right_leg,
                head,
                armor,
                helmet,
                upperhelmet,
                lowerbody,
                upperbody,
                rightarmor,
                leftarmor);
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
