package com.github.L_Ender.cataclysm.client.animation;

import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationChannel;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationDefinition;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframe;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframeAnimations;

public class Ancient_Remnant_Animation {

        public static final AdvancedAnimationDefinition IDLE = AdvancedAnimationDefinition.Builder.withLength(3.0F).looping()
                .addAnimation("right_finger", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_toe4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_toe5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_toe6", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_finger", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, -1.4F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(0.0503F, 0.484F, 0.1111F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(1.63F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(2.94F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(6.67F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-15.28F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(30.06F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_hand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_finger2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_hand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legs", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-4.9727F, -0.0869F, -0.5112F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_ankel", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-4.9727F, 0.0869F, 0.5112F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_ankel", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AdvancedAnimationDefinition WALK = AdvancedAnimationDefinition.Builder.withLength(2.0F).looping()
                .addAnimation("right_finger", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_finger", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_toe4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.001F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_toe5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.001F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_toe6", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.001F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_toe4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_toe5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_toe6", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-0.16F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, -3.69F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(9.9952F, -4.9952F, 0.0002F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(8.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(9.9905F, 4.9952F, -0.2187F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(8.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(9.9905F, -4.9952F, 0.2187F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, -0.625F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-5.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-2.3438F, -0.2734F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(5.0F, -0.625F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.5845F, 7.3854F, 1.3096F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(12.5845F, -7.3854F, -1.3096F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(17.5845F, -0.9232F, -0.1637F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(12.5845F, 7.3854F, 1.3096F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(25.0F, -0.9375F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(24.6875F, -0.4102F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(7.83F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(7.83F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-3.26F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-3.26F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_hand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_finger2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_hand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legs", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(9.84F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_ankel", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-8.59F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(8.59F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_ankel", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        
        public static final AdvancedAnimationDefinition RIGHT_BITE = AdvancedAnimationDefinition.Builder.withLength(3.5F)
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-2.8488F, 7.5937F, 2.1476F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-3.1797F, 8.5918F, 4.0965F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-6.1821F, 8.4515F, 5.0863F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-2.8267F, 2.5999F, 2.3961F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(42.2954F, -45.7259F, -24.6513F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(53.3793F, -54.174F, -39.0604F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(3.2083F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 1.02F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.37F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.posVec(-8.0F, 4.0F, 29.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(-8.0F, -4.0F, 29.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 31.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(3.2083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-21.1565F, 9.2346F, 5.7915F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-20.9575F, 7.1511F, 7.1876F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(5.0767F, -9.9616F, -0.8804F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(12.9096F, -22.4097F, -2.0675F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(13.1563F, -24.8453F, -2.6829F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(12.8472F, -12.0675F, -3.284F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(25.1253F, -31.2646F, -9.363F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(25.9295F, -33.4182F, -10.866F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(17.0563F, -1.253F, 1.5856F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(22.6344F, -15.7579F, -2.29F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(29.3988F, -30.1836F, -6.7735F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(30.0947F, -32.4064F, -8.1128F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(37.6754F, -14.9416F, -1.3378F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(33.0138F, -24.8984F, -2.3273F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(33.2928F, -27.3328F, -2.9608F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(5.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(5.1317F, 14.9708F, 0.6747F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(14.6255F, 2.8866F, -2.5683F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(17.1152F, -1.9517F, -3.83F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(17.1152F, -1.9517F, -3.83F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(5.1768F, 7.0288F, 2.1269F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(13.3325F, 13.6295F, 5.1256F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(15.14F, 21.9045F, 11.0286F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(13.042F, -11.6487F, -11.166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(18.7946F, -15.5672F, -14.3621F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(18.7946F, -15.5672F, -14.3621F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-28.9838F, 24.2848F, -29.4983F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-8.5123F, 7.1311F, -10.7735F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(6.4877F, 7.1311F, -10.7735F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(4.0307F, -28.3143F, 1.9094F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(2.2988F, -35.2784F, 5.1896F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-28.8076F, -36.0924F, 8.3235F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-27.4912F, -31.4943F, 5.9588F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(30.0088F, -31.4943F, 5.9588F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(31.9559F, -35.5417F, 2.4358F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(31.9559F, -35.5417F, 2.4358F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-17.5F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-22.5F, -12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-15.7849F, -32.4137F, 2.0236F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-15.5389F, -42.4086F, 1.6202F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-15.5389F, -42.4086F, 1.6202F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(87.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 3.89F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(25.09F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_hand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_finger2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(8.5973F, -3.9236F, 7.5777F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(15.7935F, -12.0174F, 16.1064F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-6.2672F, -12.6584F, 27.0147F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-6.2672F, -12.6584F, 27.0147F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(14.26F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_hand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legs", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-28.2107F, 0.1247F, -5.804F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(3.9489F, 0.2751F, -5.9957F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-24.1771F, 16.0216F, -9.8881F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-41.9957F, -12.7925F, 24.3747F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-40.3868F, -7.9637F, 15.469F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(-19.9917F, -6.0791F, 6.2449F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 2.57F, -13.24F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 2.93F, -14.43F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 5.0F, -13.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.posVec(0.0F, -2.9F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, -2.8F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, -3.95F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(36.11F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-21.67F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(-18.97F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-12.49F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(26.09F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_ankel", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-10.56F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(7.34F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(6.46F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.79F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-4.18F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(18.6774F, 0.0F, -0.6136F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, -1.0288F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(20.7904F, 0.0F, -1.2499F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(6.4255F, 0.0F, -1.4224F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(5.475F, 0.0F, 16.44F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(5.9375F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(5.2534F, 0.0F, 2.2387F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(6.9837F, 0.0F, 3.467F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-36.6559F, -11.3133F, 44.1018F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-49.7637F, 5.5765F, 27.3535F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-49.2592F, 15.1578F, 23.7945F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(-54.1336F, 11.3488F, 14.7959F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, -0.81F, -0.15F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.posVec(0.0F, -1.04F, -0.21F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.54F, 0.27F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.74F, 0.68F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.17F, 2.51F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 4.16F, 1.29F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-0.4167F, 0.0F, -2.2049F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-0.7407F, 0.0F, -3.9198F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(11.25F, 0.0F, -7.9688F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(27.2152F, 0.4666F, -9.4655F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(46.6146F, 0.338F, -6.9679F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(57.3991F, -0.0211F, -3.7833F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_ankel", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-1.7152F, -0.0158F, 0.0131F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-3.0492F, -0.0281F, 0.0234F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(-21.1902F, 0.4274F, -0.3548F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-29.8804F, 0.8549F, -0.7096F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-27.3804F, 0.8549F, -0.7096F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-21.4354F, 0.9083F, -0.754F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-27.3804F, 0.8549F, -0.7096F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(-24.0617F, 0.4241F, -0.352F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(6.6468F, -3.7787F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(9.5313F, -2.8125F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(10.3469F, -1.0189F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(9.294F, 0.2083F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(36.25F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AdvancedAnimationDefinition STOMP1 = AdvancedAnimationDefinition.Builder.withLength(2.3333F)
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("mid_pivot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-17.5F, -7.5F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-17.5F, -7.5F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-15.0F, -7.5F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-15.0F, -7.5F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("mid_pivot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, -12.4F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.posVec(0.0F, -12.4F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, -2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(12.5F, 7.5F, 1.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(12.5F, -15.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(12.5F, -15.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(22.5F, 5.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(22.5F, -7.5F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(22.5F, -7.5F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(22.5F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(22.5F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(10.0F, 12.5F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(10.0F, 12.5F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(2.5F, 17.5F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(2.5F, 17.5F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(7.5F, -10.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(7.5F, -10.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(3.5F, -12.5F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(3.5F, -12.5F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(7.5F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(7.5F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(15.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(15.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(10.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(10.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(12.5F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(12.5F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(7.5F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(2.5F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(2.5F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-50.0F, -12.5F, -15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-50.0F, -12.5F, -15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -12.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -12.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        
        public static final AdvancedAnimationDefinition STOMP2 = AdvancedAnimationDefinition.Builder.withLength(2.3333F)
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("mid_pivot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-17.5F, -7.5F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-17.5F, -7.5F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-15.0F, -7.5F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-15.0F, -7.5F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("mid_pivot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, -12.4F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.posVec(0.0F, -12.4F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, -2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(12.5F, -7.5F, -1.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(12.5F, -15.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(12.5F, -15.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(22.5F, -5.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(22.5F, -7.5F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(22.5F, -7.5F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(22.5F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(22.5F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(10.0F, -17.5F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(10.0F, -17.5F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(2.5F, -17.5F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(2.5F, -17.5F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(7.5F, 10.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(7.5F, 10.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(3.5F, 12.5F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(3.5F, 12.5F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(7.1667F, 14.7645F, -1.5529F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(7.1667F, 14.7645F, -1.5529F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(7.1667F, 14.7645F, -1.5529F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(7.1667F, 14.7645F, -1.5529F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(7.5F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 12.5F, 15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 12.5F, 15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 17.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 17.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, -12.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -12.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AdvancedAnimationDefinition PHASE_ROAR = AdvancedAnimationDefinition.Builder.withLength(3.0F)
                .addAnimation("mid_pivot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(2.4155F, -7.3854F, 1.3099F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(2.1547F, -14.7668F, 2.6645F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(2.29F, -11.08F, 1.99F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(2.4155F, -7.3854F, 1.3099F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-15.2375F, 4.5573F, -5.9629F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-16.2926F, 0.5728F, 7.6048F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-16.3553F, 5.4281F, 6.4087F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-42.7085F, 23.1786F, -13.4363F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-29.53F, 14.3F, -3.51F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-16.3553F, 5.4281F, 6.4087F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(10.5041F, 14.4774F, 3.9676F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-7.8177F, -27.4717F, 1.2998F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(11.1737F, 21.6934F, 6.1199F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(8.09F, 10.85F, 3.06F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(22.5175F, 2.3491F, 0.8556F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(5.684F, -42.2052F, 0.1099F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(22.5056F, 28.4801F, 9.8501F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 14.24F, 4.93F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(35.6469F, 14.0761F, 5.2362F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(27.4378F, -41.6574F, -2.5805F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(40.5614F, 27.5124F, 12.4589F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(39.03F, 13.76F, 6.23F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(15.0628F, -4.768F, -1.5072F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(15.0974F, 0.1574F, -2.3688F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(15.087F, 2.6201F, -2.799F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(15.09F, 1.39F, -2.58F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(15.0974F, 0.1574F, -2.3688F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-25.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-25.5938F, -14.3822F, 3.5148F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-25.68F, 0.87F, -2.16F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-25.7732F, 16.1241F, -7.8299F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-39.3453F, -5.9981F, -2.622F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-19.481F, -4.9975F, 2.0473F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-19.6F, 11.24F, 1.45F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-19.7248F, 27.4818F, 0.8465F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-33.0645F, -7.4345F, -29.1476F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-0.4908F, 32.6838F, -56.728F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(6.2553F, 27.7956F, -43.3911F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-2.0308F, 33.4851F, -59.55F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-2.1098F, 27.8007F, -51.9609F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-30.9283F, 4.7505F, 157.9817F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-54.9102F, -24.7407F, 117.7316F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-88.0979F, -15.3589F, 148.1563F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-60.5979F, -15.3589F, 148.1563F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-33.0645F, 7.4345F, 29.1476F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-0.4908F, -32.6838F, 56.728F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(6.2553F, -27.7956F, 43.3911F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-2.0308F, -33.4851F, 59.55F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-2.1098F, -27.8007F, 51.9609F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-31.9127F, -6.6773F, -148.1195F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-59.1278F, 22.2263F, -128.2881F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-88.7069F, 14.3658F, -150.5301F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-66.2069F, 14.3658F, -150.5301F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-6.5732F, -31.3661F, -9.0565F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-6.5732F, -31.3661F, -9.0565F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-6.5732F, -31.3661F, -9.0565F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-6.5732F, -31.3661F, -9.0565F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-6.5732F, -31.3661F, -9.0565F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(13.13F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-6.5732F, 31.3661F, 9.0565F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-6.5732F, 31.3661F, 9.0565F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-6.5732F, 31.3661F, 9.0565F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-6.5732F, 31.3661F, 9.0565F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-6.5732F, 31.3661F, 9.0565F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(13.13F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_finger3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(100.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(73.39F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_finger1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(102.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(24.66F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_finger2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(102.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(47.54F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(107.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(78.33F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(102.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(47.54F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(107.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(33.33F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AdvancedAnimationDefinition AWAKEN = AdvancedAnimationDefinition.Builder.withLength(4.0F)
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, -45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, -47.42F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.posVec(0.0F, -43.65F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, -33.86F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-6.4758F, 20.1692F, 2.2951F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-6.4758F, 20.1692F, 2.2951F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-13.1559F, -19.5968F, 7.9904F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-20.8309F, 9.2793F, 1.0559F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(-33.1659F, 7.2681F, 0.8271F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(-41.9188F, 5.9761F, 0.68F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.2083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 52.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 52.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(18.4107F, 33.1106F, 14.8442F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(20.2455F, -34.8561F, -13.6227F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(11.0185F, 15.5556F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.7917F, AdvancedKeyframeAnimations.degreeVec(12.679F, 4.2957F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(8.546F, 41.3676F, 20.1538F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(8.546F, 41.3676F, 20.1538F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(9.4001F, -22.973F, 9.5975F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(12.8496F, -24.86F, 4.752F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(15.0322F, 12.2571F, 5.9715F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.degreeVec(16.2874F, 3.3848F, 1.649F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(12.5F, 45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(17.8843F, -20.4214F, -2.5388F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(24.06F, -18.1537F, -4.9418F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(23.6301F, 7.7013F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(30.0751F, -4.9226F, -1.8645F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(5.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-4.1552F, -25.62F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-2.8345F, -13.7005F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.9167F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.9167F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(42.5F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(41.5624F, -30.2189F, 1.7382F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(-26.1738F, 19.8148F, -29.2628F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-7.5373F, 2.8387F, -21.8444F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0417F, AdvancedKeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.6667F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-12.5F, -30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(-22.1673F, -25.0408F, -0.7193F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(-9.6673F, -25.0408F, -0.7193F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-29.6673F, -25.0408F, -0.7193F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.6667F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(7.1729F, -7.7558F, -75.5759F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(7.6388F, 7.4228F, -21.0878F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-3.3542F, -31.003F, -43.5907F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-20.281F, -35.3972F, -29.8364F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(4.0208F, -51.3068F, -45.5118F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(29.4205F, -20.7604F, -51.3288F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.6667F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5417F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(57.05F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(49.55F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.9167F, AdvancedKeyframeAnimations.degreeVec(57.05F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.4583F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("desert_necklace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-10.1157F, 0.7521F, -17.4843F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(9.1559F, -5.854F, -1.2539F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-20.8441F, -5.854F, -1.2539F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.9167F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.2083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-117.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-117.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-97.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("desert_eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-42.5F, 0.0F, -15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-105.3824F, -13.3493F, 24.2666F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-100.656F, 15.3586F, -23.0941F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-64.5169F, -66.3205F, -12.4554F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-5.8825F, -37.6772F, -61.9902F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(36.6179F, 24.0228F, -4.8374F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(4.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(64.9125F, -29.2081F, 51.9839F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(68.3883F, -16.4296F, 29.2409F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(-6.3055F, 1.0268F, -1.8276F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-46.7546F, 1.7313F, 5.3121F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-67.2321F, -39.0137F, -16.3215F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-70.4086F, 11.9566F, 8.0189F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(-1.6827F, 6.6174F, 4.1786F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(14.1211F, 18.9143F, 27.0765F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(4.058F, 3.4045F, -8.3555F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-72.8191F, 19.9207F, -1.817F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-117.8191F, 19.9207F, -1.817F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-56.8724F, 19.6835F, 3.6164F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-56.8724F, 19.6835F, 3.6164F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.2083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(109.66F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(68.32F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(36.14F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-31.17F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(-23.18F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(40.94F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-3.95F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AdvancedAnimationDefinition SLEEP = AdvancedAnimationDefinition.Builder.withLength(0.0F)
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-6.4758F, 20.1692F, 2.2951F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 52.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(8.546F, 41.3676F, 20.1538F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(42.5F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-12.5F, -30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(7.1729F, -7.7558F, -75.5759F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("desert_necklace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-117.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("desert_eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-105.3824F, -13.3493F, 24.2666F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-100.656F, 15.3586F, -23.0941F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-64.5169F, -66.3205F, -12.4554F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-72.8191F, 19.9207F, -1.817F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AdvancedAnimationDefinition DEATH = AdvancedAnimationDefinition.Builder.withLength(2.375F)
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-22.7836F, -9.3912F, 3.4515F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(24.1488F, 20.7045F, 9.0079F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(22.1449F, 20.03F, 21.285F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(34.5684F, 26.128F, 8.8967F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.5119F, -7.4997F, -0.0668F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.87F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-9.2276F, -7.404F, 1.1993F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-33.6755F, -37.3347F, 83.7069F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, -70.0F, 40.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(25.3045F, 5.1465F, 1.7346F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(27.358F, 18.3331F, 10.0758F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(2.0F, 9.0F, -13.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-11.1392F, 2.0F, -17.3889F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-18.9718F, 2.0111F, 14.5637F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-30.9209F, -21.6046F, -2.0433F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(16.5401F, 18.4487F, -37.9634F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(-1.0F, -10.0F, -14.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-44.09F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("desert_eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 87.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("desert_eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(-2.0F, 0.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-9.5858F, -37.158F, -46.0143F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-24.5858F, -37.158F, -46.0143F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-24.5858F, -37.158F, -46.0143F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-42.4589F, 18.2102F, -70.539F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(15.0F, -50.0F, 47.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-2.7911F, -16.5903F, 46.4724F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-22.6898F, 25.7151F, 32.5963F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-64.7211F, 13.9257F, 12.1626F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-64.7211F, 13.9257F, 12.1626F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-93.7899F, 60.6178F, -13.6228F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.posVec(0.0F, -58.0F, 39.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(85.4776F, -29.1725F, -37.5096F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-22.4232F, 13.6623F, 4.8741F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-22.4232F, 13.6623F, 4.8741F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AdvancedAnimationDefinition SAND_STORM_ROAR = AdvancedAnimationDefinition.Builder.withLength(3.0F)
                .addAnimation("mid_pivot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, -14.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.posVec(0.0F, -15.77F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.posVec(0.0F, -11.9F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.posVec(0.0F, -9.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.posVec(0.0F, -6.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(2.3489F, -9.8465F, 1.7541F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0597F, 0.1053F, 0.5307F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-0.2076F, -6.5683F, 1.8677F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-17.1826F, -21.1026F, 6.9733F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(-18.9058F, -33.1501F, 10.7307F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.7917F, AdvancedKeyframeAnimations.degreeVec(-16.6904F, 15.2925F, -2.2327F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(11.1737F, 21.6934F, 6.1199F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(10.3472F, 12.0674F, 3.2844F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(10.0547F, -4.8292F, -1.2973F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(10.5041F, 14.4774F, 3.9676F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(17.5F, 42.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(17.2487F, -34.9521F, -2.9782F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.6667F, AdvancedKeyframeAnimations.degreeVec(16.9951F, 22.5149F, -0.9253F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-23.2109F, -13.8345F, 5.8546F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-23.2109F, 13.8345F, -5.8546F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(2.9179F, 25.3144F, 2.7043F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-32.9263F, -14.6365F, 3.3186F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-39.0315F, -15.217F, -3.2531F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-31.367F, 7.4431F, -7.0079F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-4.201F, 3.9804F, -2.8831F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(43.8437F, 21.4056F, 7.1007F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(15.0628F, -4.768F, -1.5072F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(14.3119F, -21.99F, 1.7004F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(15.0894F, -2.3054F, -1.9387F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(14.9744F, 8.7771F, -3.8822F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.degreeVec(20.08F, -4.8243F, -1.9407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-25.2218F, -9.6956F, 1.7328F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.2083F, AdvancedKeyframeAnimations.degreeVec(-30.1853F, 9.0967F, -5.1429F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-26.129F, -19.0549F, 5.3733F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(-25.9168F, -8.4815F, 1.3944F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.degreeVec(-26.3736F, 20.7902F, -9.7245F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-19.7248F, 27.4818F, 0.8465F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-19.481F, -4.9975F, 2.0473F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(-19.6F, 11.24F, 1.45F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(-19.7248F, 27.4818F, 0.8465F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(7.0519F, 8.1387F, 0.213F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(12.9091F, 19.093F, -26.8124F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(14.9036F, 26.667F, -40.8821F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(23.4774F, 24.5937F, -35.5715F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(19.2128F, -0.85F, -1.3685F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(16.192F, -2.3039F, 1.5949F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-3.89F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(-14.52F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(10.56F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(12.9091F, -19.093F, 26.8124F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(25.41F, -19.09F, 26.81F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(20.7054F, 1.0683F, 1.5134F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(0.4829F, -6.0539F, 11.6932F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(3.8619F, -4.124F, 7.7131F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(34.72F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(1.83F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(11.27F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-20.4533F, -10.5831F, -0.4213F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-34.705F, -24.4144F, 2.4781F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-34.705F, -24.4144F, 2.4781F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-64.0365F, 11.8491F, 9.2643F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-20.4533F, 10.5831F, 0.4213F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-34.705F, 24.4144F, -2.4781F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-34.705F, 24.4144F, -2.4781F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("desert_necklace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-51.8247F, -7.9969F, -9.6387F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(32.6075F, 3.2114F, 3.8343F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-1.8998F, 0.0417F, 21.0541F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(46.447F, 5.7087F, -11.0027F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(34.2157F, -24.5338F, 29.9081F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.degreeVec(12.2117F, -11.3033F, 4.476F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.7917F, AdvancedKeyframeAnimations.degreeVec(2.2117F, -11.3033F, 4.476F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();


        public static final AdvancedAnimationDefinition CHARGE = AdvancedAnimationDefinition.Builder.withLength(1.0F).looping()
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 7.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(24.9929F, -0.0071F, 0.3268F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(11.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(24.9929F, 0.0071F, -0.3268F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(11.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(24.9929F, -0.0071F, 0.3268F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 8.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.posVec(0.0F, 8.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-12.5F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.5845F, 7.3854F, 1.3096F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5845F, -7.3854F, -1.3096F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(12.5845F, 7.3854F, 1.3096F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(20.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-10.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-10.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(27.5F, -0.3125F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, -2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.3125F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-20.0F, -0.3125F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-15.0F, -2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.3125F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-19.9929F, -2.5024F, -0.1091F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-27.4929F, 0.3128F, 0.0136F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-19.9929F, 2.5024F, 0.1091F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-27.4929F, -0.3128F, -0.0136F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-19.9929F, -2.5024F, -0.1091F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_hand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_finger2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_hand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legs", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, -4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(8.59F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_ankel", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, -4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, -4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(8.59F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_ankel", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("mid_pivot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("mid_pivot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("desert_necklace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AdvancedAnimationDefinition CHARGE_PREPARE = AdvancedAnimationDefinition.Builder.withLength(3.5F)
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("mid_pivot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("mid_pivot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, -7.2F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, -7.2F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(2.5283F, -4.9571F, -0.6543F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(2.5283F, 4.9571F, 0.6543F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(15.0462F, -4.8812F, -1.0848F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(15.0462F, 4.8812F, 1.0848F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(12.5845F, 7.3854F, 1.3096F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(25.019F, -4.9809F, -0.4369F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(25.019F, 4.9809F, 0.4369F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(20.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(2.5024F, 2.4976F, 0.1091F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(2.5024F, -2.4976F, -0.1091F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(-10.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("spine2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(2.5193F, 2.3096F, 0.9572F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(2.5193F, -2.3096F, -0.9572F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-7.5038F, 0.1869F, 0.1625F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-10.0038F, 0.1869F, 0.1625F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-7.5038F, -0.1869F, -0.1625F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-10.0038F, -0.1869F, -0.1625F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(-19.9929F, -2.5024F, -0.1091F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(5.16F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-0.4096F, -22.4097F, 2.0675F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(5.16F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(47.4123F, 0.8977F, -0.8977F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(20.1276F, -1.9703F, 0.3842F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-44.9533F, 0.2918F, 0.3861F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, -4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_ankel_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(9.9905F, -4.9952F, 0.2187F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(9.9905F, 4.9952F, -0.2187F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(24.9929F, -0.0071F, 0.3268F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(32.97F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(32.97F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_hand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(8.59F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(8.59F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(5.16F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-0.4096F, 22.4097F, -2.0675F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(5.16F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(32.97F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(32.97F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_hand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(8.59F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(8.59F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(34.9901F, -0.305F, -0.0932F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_foot", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(47.4901F, 0.305F, 0.0932F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("desert_necklace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-17.4981F, 0.2469F, -0.1191F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(-12.4995F, 0.143F, -0.0456F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-27.4983F, 0.3279F, -0.1899F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-2.4978F, 0.3502F, -0.0311F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.7917F, AdvancedKeyframeAnimations.degreeVec(-12.4971F, 0.22F, -0.0525F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-27.4935F, -0.087F, 0.0522F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(-39.3705F, -0.3177F, 0.206F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(-9.9946F, 0.0739F, -0.0637F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.9583F, AdvancedKeyframeAnimations.degreeVec(-4.9947F, 0.0946F, -0.0901F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_finger2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_finger3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legs", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_ankel", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_ankel", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        
}
