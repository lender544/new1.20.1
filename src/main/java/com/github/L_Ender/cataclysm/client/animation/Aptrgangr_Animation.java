package com.github.L_Ender.cataclysm.client.animation;// Save this class in your mod and generate all required imports

import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationChannel;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationDefinition;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframe;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframeAnimations;

/**
 * Made with Blockbench 4.10.4
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author kor
 */
public class Aptrgangr_Animation {
	public static final AdvancedAnimationDefinition IDLE = AdvancedAnimationDefinition.Builder.withLength(2.0F).looping()
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.2965F, 2.1578F, 1.2968F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition WALK = AdvancedAnimationDefinition.Builder.withLength(1.3333F).looping()
			.addAnimation("roots", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 4.3F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.5F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 4.3F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -1.4F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -1.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(10.0374F, -4.9238F, -0.8704F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(10.0845F, 7.3854F, 1.3096F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(10.0374F, -4.9238F, -0.8704F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.0041F, 14.4775F, 3.9671F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(15.9153F, -19.291F, -5.3815F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(12.0041F, 14.4775F, 3.9671F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-15.1226F, -9.45F, 4.1278F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-13.1168F, 14.0812F, -2.9543F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-15.1226F, -9.45F, 4.1278F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(-0.6F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.6F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-43.4907F, 11.0007F, -22.7608F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(21.4345F, -9.9736F, -30.9513F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-43.4907F, 11.0007F, -22.7608F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(76.2858F, 11.9606F, 25.0573F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(66.2858F, 11.9606F, 25.0573F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(76.2858F, 11.9606F, 25.0573F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(84.7979F, 6.6485F, -3.4787F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition SWING_RIGHT = AdvancedAnimationDefinition.Builder.withLength(2.0F)
			.addAnimation("roots", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("roots", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(22.5F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-2.6073F, 1.5952F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(-1.0F, 0.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.posVec(-1.11F, 4.0F, -2.57F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(-1.0F, 0.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(32.5F, -15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(1.0F, 0.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(54.7946F, -23.6208F, -51.4774F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(54.7946F, -23.6208F, -51.4774F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-25.3211F, 49.2748F, -1.0169F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-25.3211F, 49.2748F, -1.0169F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-46.7718F, 49.5558F, -33.4863F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-31.1525F, -39.2716F, 18.7857F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-11.1871F, -23.2945F, 4.6011F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(39.8537F, 16.6993F, -18.2012F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(14.3461F, -0.3984F, -44.4513F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(33.1452F, -5.8107F, -22.5712F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-46.11F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-39.0759F, -20.475F, 37.2799F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-42.0277F, -14.9519F, 66.9226F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(106.6862F, -34.15F, 31.4058F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(4.0F, 0.0F, -7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(4.0F, 0.0F, -7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(4.0F, 0.0F, -7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(66.5685F, -19.9035F, 19.3763F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(66.5685F, -19.9035F, 19.3763F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(100.1065F, 9.4277F, 24.4539F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(57.738F, 5.9438F, 4.5822F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("cloth2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("cloth", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe_head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.scaleVec(1.0F, 2.3F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2083F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition SMASH = AdvancedAnimationDefinition.Builder.withLength(2.0F)
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-42.9129F, 2.927F, 7.3122F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.posVec(-1.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(-174.8084F, -16.0539F, -17.2016F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(-83.2559F, 35.7722F, -6.3006F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-83.2559F, 35.7722F, -6.3006F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.posVec(-2.0F, 2.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -9.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -9.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.7917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-23.1898F, -3.0467F, 34.6336F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-18.4281F, 1.7305F, 3.0857F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-37.8109F, -12.4789F, 15.1625F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(19.2454F, -40.5325F, -47.1598F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(36.7454F, -40.5325F, -47.1598F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(3.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(92.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(82.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("roots", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, -1.8F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, -7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-2.6117F, 1.2469F, -1.5185F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(32.0017F, 3.2211F, -3.9227F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(32.0017F, 3.2211F, -3.9227F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(36.1331F, -18.6925F, -3.6544F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(36.1331F, -18.6925F, -3.6544F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 32.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.6103F, -2.5857F, 39.5006F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.6103F, -2.5857F, 39.5006F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe_head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.scaleVec(1.0F, 2.1F, 0.7F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition RUSH_START = AdvancedAnimationDefinition.Builder.withLength(1.1667F)
			.addAnimation("roots", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(30.334F, 10.0559F, 1.3451F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(30.334F, 10.0559F, 1.3451F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(6.6711F, 49.2917F, -15.5697F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(6.6711F, 49.2917F, -15.5697F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-21.8845F, -34.3504F, 24.8068F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-31.8845F, -34.3504F, 24.8068F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-86.1823F, 29.601F, -4.9712F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-86.1823F, 29.601F, -4.9712F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-98.8297F, 61.5119F, -86.3006F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-98.8297F, 61.5119F, -86.3006F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(29.4316F, -0.9657F, -7.2943F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(29.4316F, -0.9657F, -7.2943F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(42.2339F, 11.0311F, -28.0756F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(42.2339F, 11.0311F, -28.0756F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 86.42F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 86.42F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition RUSHING = AdvancedAnimationDefinition.Builder.withLength(1.0F).looping()
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(30.334F, 10.0559F, 1.3451F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(30.334F, 10.0559F, 1.3451F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(6.6711F, 49.2917F, -15.5697F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(9.505F, 48.8322F, -11.8189F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(6.6711F, 49.2917F, -15.5697F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-21.8845F, -34.3504F, 24.8068F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-23.1335F, -36.1181F, 26.9713F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-21.8845F, -34.3504F, 24.8068F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-86.1823F, 29.601F, -4.9712F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-86.2711F, 27.1064F, -5.1581F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-86.1823F, 29.601F, -4.9712F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-98.8297F, 61.5119F, -86.3006F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-98.8297F, 61.5119F, -86.3006F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(29.4316F, -0.9657F, -7.2943F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(29.883F, 0.2905F, -5.0862F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(29.4316F, -0.9657F, -7.2943F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(42.2339F, 11.0311F, -28.0756F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(39.7339F, 11.0311F, -28.0756F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(42.2339F, 11.0311F, -28.0756F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 86.42F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 86.42F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition RUSH_END = AdvancedAnimationDefinition.Builder.withLength(1.125F)
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, -4.42F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(30.334F, 10.0559F, 1.3451F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-17.8981F, -11.9128F, 3.814F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-17.8981F, -11.9128F, 3.814F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(6.6711F, 49.2917F, -15.5697F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-38.3132F, -30.3611F, 7.7457F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-38.3132F, -30.3611F, 7.7457F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-21.8845F, -34.3504F, 24.8068F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-20.2799F, -0.9967F, -3.3981F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-20.2799F, -0.9967F, -3.3981F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-86.1823F, 29.601F, -4.9712F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(23.7877F, -0.4615F, -45.4199F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(23.7877F, -0.4615F, -45.4199F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-98.8297F, 61.5119F, -86.3006F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(29.4316F, -0.9657F, -7.2943F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.degreeVec(106.6849F, -22.5518F, 19.9839F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-13.478F, -4.0948F, 5.0443F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(42.2339F, 11.0311F, -28.0756F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.1667F, AdvancedKeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 86.42F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe_head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe_head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.0833F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.scaleVec(1.0F, 2.3F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition RUSH_HIT = AdvancedAnimationDefinition.Builder.withLength(0.875F)
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(30.334F, 10.0559F, 1.3451F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-14.666F, 10.0559F, 1.3451F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(6.6711F, 49.2917F, -15.5697F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-28.5614F, 22.0295F, -20.1233F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-21.8845F, -34.3504F, 24.8068F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-21.8845F, -34.3504F, 24.8068F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-86.1823F, 29.601F, -4.9712F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-6.8681F, -11.3623F, -48.2997F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-98.8297F, 61.5119F, -86.3006F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-94.7017F, 26.7197F, -80.6439F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(29.4316F, -0.9657F, -7.2943F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(48.4182F, 18.173F, 42.6509F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(42.2339F, 11.0311F, -28.0756F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 86.42F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe_head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("axe_head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

}