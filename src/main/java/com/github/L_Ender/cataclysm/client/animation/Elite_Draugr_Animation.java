package com.github.L_Ender.cataclysm.client.animation;// Save this class in your mod and generate all required imports

import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationChannel;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationDefinition;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframe;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframeAnimations;

/**
 * Made with Blockbench 4.11.0
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author kor
 */
public class Elite_Draugr_Animation {
	public static final AdvancedAnimationDefinition RE_LOAD = AdvancedAnimationDefinition.Builder.withLength(1.5F)
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-38.4607F, 14.5864F, 22.6834F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-61.4199F, -24.9177F, -33.4574F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-41.3892F, -49.9544F, -65.1261F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-38.4607F, 14.5864F, 22.6834F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-38.4607F, 14.5864F, 22.6834F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-64.287F, -0.3422F, -20.6956F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-56.5554F, -28.856F, -41.827F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -22.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -47.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition SHOOT = AdvancedAnimationDefinition.Builder.withLength(1.125F)
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-92.5286F, 17.8637F, -0.5166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-41.3892F, -49.9544F, -65.1261F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-89.0672F, -29.6527F, -11.5537F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("maw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-38.4607F, 14.5864F, 22.6834F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-92.5286F, 17.8637F, -0.5166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(-92.5286F, 17.8637F, -0.5166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-56.5554F, -28.856F, -41.827F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-89.0672F, -29.6527F, -11.5537F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(-89.0672F, -29.6527F, -11.5537F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -47.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition WALK = AdvancedAnimationDefinition.Builder.withLength(1.0F).looping()
		.addAnimation("wind1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("wind1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, -25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, -25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, -25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(10.0374F, -4.9238F, -0.8704F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(10.0845F, 7.3854F, 1.3096F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(10.0374F, -4.9238F, -0.8704F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("maw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-9.0513F, -1.0009F, 22.4978F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, -25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, -25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, -25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -0.4F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -0.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.3F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.5F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.3F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition IDLE = AdvancedAnimationDefinition.Builder.withLength(1.75F).looping()
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("maw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition SWING = AdvancedAnimationDefinition.Builder.withLength(1.5417F)
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(-10.0F, -12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(20.0141F, 12.1324F, -4.3049F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(20.0141F, 12.1324F, -4.3049F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("waist", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(-17.5F, -30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-2.9848F, 32.4966F, -18.8521F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-2.9848F, 32.4966F, -18.8521F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("neck", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(-2.8136F, 16.8746F, -3.2502F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-31.1423F, -19.4932F, 25.6448F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-31.1423F, -19.4932F, 25.6448F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-38.4607F, 14.5864F, 22.6834F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(11.4094F, 2.9195F, -63.0374F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-93.5906F, 2.9195F, -63.0374F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-93.5906F, 2.9195F, -63.0374F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-56.5554F, -28.856F, -41.827F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(19.854F, 15.2881F, 38.1632F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(7.0125F, -10.1927F, 54.5079F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(7.0125F, -10.1927F, 54.5079F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -47.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition KICK = AdvancedAnimationDefinition.Builder.withLength(1.5F).looping()
		.addAnimation("roots", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 52.5F, -27.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(-91.4319F, 3.7793F, -84.5498F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("roots", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.5F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(28.8864F, -15.5839F, 25.9629F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(43.8864F, -15.5839F, 25.9629F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -65.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, -87.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-140.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(55.0F, 0.0F, 59.0874F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 65.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-140.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 22.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(56.1822F, -4.9809F, 29.6217F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 2.28F, 0.77F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 5.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 2.15F, -3.36F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition ATTACK = AdvancedAnimationDefinition.Builder.withLength(1.125F)
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-179.6746F, -27.6632F, 19.0237F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-50.4324F, -0.9599F, 11.0691F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.7977F, -15.1494F, -3.8531F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(31.4799F, 32.1499F, 19.6843F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-11.5762F, -38.0566F, 1.9515F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("maw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-179.6746F, -27.6632F, 19.0237F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-50.4324F, -0.9599F, 11.0691F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition ATTACK2 = AdvancedAnimationDefinition.Builder.withLength(1.0417F)
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-107.4356F, 4.3113F, -60.6327F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(25.9377F, -16.7974F, -68.5151F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 22.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-75.6764F, 37.1326F, 22.9131F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(26.6064F, 19.4362F, 16.5732F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(26.7143F, -16.7525F, -11.8935F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-4.8587F, -22.467F, -1.5514F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-10.7318F, 6.8622F, -0.9504F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("maw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-107.4356F, 4.3113F, -60.6327F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(25.9377F, -16.7974F, -68.5151F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 22.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-75.6764F, 37.1326F, 22.9131F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition SHOOT2 = AdvancedAnimationDefinition.Builder.withLength(1.125F)
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-92.5286F, 17.8637F, -0.5166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-89.0672F, -29.6527F, -11.5537F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("maw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("l_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-92.5286F, 17.8637F, -0.5166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-92.5286F, 17.8637F, -0.5166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-89.0672F, -29.6527F, -11.5537F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-89.0672F, -29.6527F, -11.5537F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("r_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();
}