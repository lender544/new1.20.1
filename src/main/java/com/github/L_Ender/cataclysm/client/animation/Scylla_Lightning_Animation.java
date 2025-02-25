package com.github.L_Ender.cataclysm.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/**
 * Made with Blockbench 4.9.4
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author kor
 */
@OnlyIn(Dist.CLIENT)
public class Scylla_Lightning_Animation {
        public static final AnimationDefinition LIGHTNING_EXPLOSION = AnimationDefinition.Builder.withLength(7.4583F)
                .addAnimation("scylla", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("scylla", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("r_leg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.5F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(10.6276F, -19.6835F, 6.3836F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(19.3444F, -26.6182F, -5.8051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-5.0047F, 2.4905F, -7.718F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-5.0047F, 2.4905F, -7.718F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-23.6732F, 4.215F, 14.7556F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(41.4314F, 29.9119F, 23.7553F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-24.9626F, 49.0393F, -26.8398F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2917F, KeyframeAnimations.degreeVec(-24.9626F, 49.0393F, -26.8398F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(-22.2762F, 50.0414F, -23.3097F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.125F, KeyframeAnimations.degreeVec(20.0F, 10.0F, 22.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.5F, KeyframeAnimations.degreeVec(20.0F, 10.0F, 22.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-3.1339F, 17.2258F, -10.4748F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 2.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 2.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-41.5327F, -26.7952F, 8.9285F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2917F, KeyframeAnimations.degreeVec(-41.5327F, -26.7952F, 8.9285F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(-46.5327F, -26.7952F, 8.9285F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.5F, KeyframeAnimations.degreeVec(0.0F, -12.5F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_eye", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("r_eye", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-83.8258F, -8.899F, 4.7547F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(33.4823F, -3.2151F, -42.5592F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(33.4823F, -3.2151F, -42.5592F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(-21.4582F, -47.3242F, 8.2762F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-130.8075F, -51.5455F, 13.1412F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.2917F, KeyframeAnimations.degreeVec(-130.8075F, -51.5455F, 13.1412F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(-130.8075F, -51.5455F, 13.1412F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.125F, KeyframeAnimations.degreeVec(-18.3075F, -51.5455F, 13.1412F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.5F, KeyframeAnimations.degreeVec(-18.3075F, -51.5455F, 13.1412F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2917F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_arm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(87.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(87.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2917F, KeyframeAnimations.degreeVec(80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.6667F, KeyframeAnimations.degreeVec(95.5487F, -0.1105F, -5.0288F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.125F, KeyframeAnimations.degreeVec(-39.2222F, 21.4956F, -21.1209F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.4167F, KeyframeAnimations.degreeVec(-29.5886F, 39.78F, 1.6246F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("anchor", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("anchor", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.749F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.3323F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.3333F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.374F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.375F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.874F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.875F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(7.4573F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(7.4583F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("r_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-37.4783F, 4.4041F, 50.7592F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(37.7208F, 1.3507F, 54.7241F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(37.7208F, 1.3507F, 54.7241F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-114.1487F, 20.7048F, -9.0072F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.3333F, KeyframeAnimations.degreeVec(21.5282F, 10.4768F, 28.0745F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(31.19F, 5.7585F, 44.884F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2917F, KeyframeAnimations.degreeVec(31.19F, 5.7585F, 44.884F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(26.19F, 5.7585F, 44.884F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.4167F, KeyframeAnimations.degreeVec(-56.498F, -6.4729F, 70.6938F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(-56.498F, -6.4729F, 70.6938F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("r_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 3.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("r_arm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.5F, KeyframeAnimations.degreeVec(-120.13F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(-120.13F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.5F, KeyframeAnimations.degreeVec(-47.5F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_leg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.5F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain_anchor", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-45.0347F, 21.2168F, -36.653F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-45.7416F, 36.2206F, -115.3893F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-52.6256F, 48.7474F, -131.4798F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(58.7836F, 15.0368F, -68.335F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(130.8755F, 50.0273F, 9.7026F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(83.2856F, 60.7177F, -46.4606F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.375F, KeyframeAnimations.degreeVec(3.0546F, -1.5637F, -588.0575F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -720.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.375F, KeyframeAnimations.degreeVec(-68.1361F, 20.3403F, -749.9634F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.4583F, KeyframeAnimations.degreeVec(-51.3968F, -3.8846F, -737.0044F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-34.0163F, -24.9975F, -9.951F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-25.1163F, 71.4748F, -32.6835F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-32.5646F, 66.8536F, -27.2833F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(-2.1087F, 19.4223F, -23.326F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.125F, KeyframeAnimations.degreeVec(0.0F, 20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.3333F, KeyframeAnimations.degreeVec(-84.0265F, 22.0533F, -10.7069F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.375F, KeyframeAnimations.degreeVec(-67.849F, 10.9611F, 26.5171F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.4583F, KeyframeAnimations.degreeVec(-42.5F, 20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain_2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-30.191F, -31.9999F, 1.6377F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-2.5191F, 9.9905F, -0.439F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(6.85F, -37.4582F, 1.917F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(41.8216F, 37.1474F, 10.2273F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.125F, KeyframeAnimations.degreeVec(22.5F, 17.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.375F, KeyframeAnimations.degreeVec(-67.9227F, 20.0734F, -31.6178F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain_3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(58.7787F, 30.441F, -11.1226F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-86.7381F, -25.2537F, 35.3306F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-14.3549F, -7.5825F, -6.171F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-0.1171F, 7.3977F, -9.5221F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-0.1171F, 7.3977F, -9.5221F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(44.8829F, 7.3977F, -9.5221F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.125F, KeyframeAnimations.degreeVec(-70.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.3333F, KeyframeAnimations.degreeVec(3.7744F, -12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.375F, KeyframeAnimations.degreeVec(-27.7125F, -12.963F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.4583F, KeyframeAnimations.degreeVec(-17.5F, -12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain_main", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(104.747F, 19.5899F, -15.8477F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(104.747F, 19.5899F, -15.8477F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(88.0006F, 24.2674F, -58.8372F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(88.0006F, 24.2674F, -58.8372F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(94.9244F, 0.8672F, -9.9627F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2917F, KeyframeAnimations.degreeVec(94.9244F, 0.8672F, -9.9627F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(94.7697F, 1.5018F, -17.4375F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.125F, KeyframeAnimations.degreeVec(214.7697F, 1.5018F, -17.4375F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.375F, KeyframeAnimations.degreeVec(252.2697F, 1.5018F, -17.4375F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain_main", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7073F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.749F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.3323F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.3333F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.374F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.375F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.874F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.875F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(7.4573F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(7.4583F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("chain_4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(69.6155F, 18.4758F, -22.6314F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(56.1158F, 10.7295F, -45.6509F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(32.794F, 33.6645F, -32.3596F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(32.794F, 33.6645F, -32.3596F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(32.794F, 33.6645F, -32.3596F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.375F, KeyframeAnimations.degreeVec(0.7979F, 7.713F, -0.0354F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.125F, KeyframeAnimations.degreeVec(-85.0F, 12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.375F, KeyframeAnimations.degreeVec(-42.5F, 12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("everything", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.5F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(7.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("r_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.5F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 12.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("hair", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(26.9409F, 5.7358F, -6.125F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(26.0666F, 9.0866F, -12.8924F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(105.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.degreeVec(85.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.9583F, KeyframeAnimations.degreeVec(59.762F, -5.9438F, 4.5822F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.25F, KeyframeAnimations.degreeVec(92.262F, -5.9438F, 4.5822F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.75F, KeyframeAnimations.degreeVec(64.762F, -5.9438F, 4.5822F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("hair2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.5417F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0417F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.375F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();


        public static final AnimationDefinition LIGHTNING_SPEAR_THROW = AnimationDefinition.Builder.withLength(2.625F)
                .addAnimation("everything", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("everything", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -0.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, -0.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("r_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-12.9817F, 23.8257F, 7.3162F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-12.9817F, 23.8257F, 7.3162F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("r_leg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 22.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 22.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(40.2911F, -16.5897F, -18.9729F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(40.2911F, -16.5897F, -18.9729F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-6.4051F, 19.0687F, 9.8801F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-6.4051F, 19.0687F, 9.8801F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(10.2377F, -12.3071F, -2.2046F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(10.2377F, -12.3071F, -2.2046F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(20.9003F, -60.8721F, -18.4474F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(20.9003F, -60.8721F, -18.4474F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-11.5997F, -60.8721F, -18.4474F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-8.1935F, 30.8099F, -2.5165F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-8.1935F, 30.8099F, -2.5165F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_eye", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("r_eye", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.scaleVec(1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("hair", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(19.5623F, 4.2453F, -11.7678F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(60.2809F, -35.3963F, 29.8376F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(19.5623F, 4.2453F, -11.7678F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("hair2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(94.3206F, 27.1129F, -60.3755F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(89.3206F, 27.1129F, -60.3755F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(94.3206F, 27.1129F, -60.3755F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_sea_snake2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-32.5F, 20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_sea_snake3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-5.491F, 15.9398F, 38.6901F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_arm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("anchor", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(72.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("chain_main", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("r_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-117.9274F, 10.2831F, -38.0371F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-114.1451F, 13.2543F, -41.9307F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-117.9274F, 10.2831F, -38.0371F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-52.0961F, -25.4869F, -12.6551F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-52.0961F, -25.4869F, -12.6551F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("r_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, -2.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("r_arm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-72.5793F, 24.7234F, -44.8186F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-80.8183F, 17.9373F, -52.191F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-72.5793F, 24.7234F, -44.8186F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-23.9261F, -20.0575F, -1.8745F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-23.9261F, -20.0575F, -1.8745F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("l_leg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

}
