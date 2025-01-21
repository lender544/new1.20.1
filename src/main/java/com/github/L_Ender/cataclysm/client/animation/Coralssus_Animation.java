package com.github.L_Ender.cataclysm.client.animation;// Save this class in your mod and generate all required imports

import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationChannel;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationDefinition;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframe;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframeAnimations;



/**
 * Made with Blockbench 4.9.4
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author kor
 */
public class Coralssus_Animation {
	public static final AdvancedAnimationDefinition IDLE = AdvancedAnimationDefinition.Builder.withLength(3.0F).looping()
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.78F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.posVec(0.0F, -0.2F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-5.29F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-5.29F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition WALK = AdvancedAnimationDefinition.Builder.withLength(1.0F).looping()
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-1.864F, 7.466F, -0.2849F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-1.864F, -7.466F, 0.2849F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-1.864F, 7.466F, -0.2849F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(5.2921F, -11.987F, 2.0843F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(5.2921F, 11.987F, -2.0843F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(5.2921F, -11.987F, 2.0843F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(2.4526F, 0.729F, -1.6586F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(2.4526F, -0.729F, 1.6586F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(2.4526F, 0.729F, -1.6586F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.4F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -0.2F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.4F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, -0.2F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-55.411F, 5.7162F, -8.2189F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.0833F, AdvancedKeyframeAnimations.degreeVec(-29.24F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-55.411F, 5.7162F, -8.2189F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.0833F, AdvancedKeyframeAnimations.posVec(0.0F, 2.23F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, -0.93F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 1.56F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.0833F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-55.411F, -5.7162F, 8.2189F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-29.24F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.95F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, -0.92F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(13.9906F, 3.795F, -3.2653F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-10.3228F, -0.938F, -5.4F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(13.9906F, 3.795F, -3.2653F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 8.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.posVec(0.0F, -0.43F, -4.93F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-10.3228F, 0.938F, 5.4F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(13.9906F, -3.795F, 3.2653F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-10.3228F, 0.938F, 5.4F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.0833F, AdvancedKeyframeAnimations.posVec(0.0F, -0.25F, -5.37F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 8.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition RIGHT_FIST = AdvancedAnimationDefinition.Builder.withLength(1.5F)
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-27.5896F, -4.4339F, 2.3134F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-28.1336F, 6.8547F, 7.6379F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-31.4254F, -28.3238F, -9.3577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-26.4254F, -28.3238F, -9.3577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(2.4363F, 7.082F, 17.1819F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(3.4023F, 11.8649F, 23.0407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(53.4023F, 11.8649F, 23.0407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(42.8764F, 11.8928F, 20.4861F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(34.987F, -19.3289F, -5.5392F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(34.2775F, -26.6412F, -3.7261F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-6.8062F, -2.2153F, -9.2775F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(5.6844F, 1.8465F, -6.3612F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -0.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-0.1981F, 7.6388F, 53.0657F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(2.1209F, 7.3428F, 70.715F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-51.1635F, -21.4568F, -33.9585F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-47.2865F, -25.3148F, -37.4248F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 1.75F, -1.88F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 3.99F, -4.15F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-33.735F, -9.9319F, -14.4817F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-9.5459F, 2.9932F, 7.25F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(18.092F, -3.4049F, -29.7197F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(27.7445F, -4.9441F, -24.9497F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-17.3727F, -0.5463F, 1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-47.3727F, -0.5463F, 1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-23.2281F, 14.0447F, 14.8166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-15.7281F, 14.0447F, 14.8166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(-1.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(-1.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(-1.0F, -4.0F, -7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(20.4F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition LEFT_FIST = AdvancedAnimationDefinition.Builder.withLength(1.5F)
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-27.5896F, 4.4339F, -2.3134F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-28.1336F, -6.8547F, -7.6379F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-31.4254F, 28.3238F, 9.3577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-26.4254F, 28.3238F, 9.3577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(2.4363F, -7.082F, -17.1819F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(3.4023F, -11.8649F, -23.0407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(53.4023F, -11.8649F, -23.0407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(42.8764F, -11.8928F, -20.4861F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(34.987F, 19.3289F, 5.5392F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(34.2775F, 26.6412F, 3.7261F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-6.8062F, 2.2153F, 9.2775F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(5.6844F, -1.8465F, 6.3612F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-9.5459F, -2.9932F, -7.25F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(18.092F, 3.4049F, 29.7197F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(27.7445F, 4.9441F, 24.9497F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 1.75F, -1.88F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-17.3727F, 0.5463F, -1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-47.3727F, 0.5463F, -1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-23.2281F, -14.0447F, -14.8166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-15.7281F, -14.0447F, -14.8166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-0.1981F, -7.6388F, -53.0657F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(2.1209F, -7.3428F, -70.715F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-51.1635F, 21.4568F, 33.9585F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-47.2865F, 25.3148F, 37.4248F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 1.75F, -1.88F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 3.99F, -4.15F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-33.735F, 9.9319F, 14.4817F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(1.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(1.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -0.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition JUMPING_READY = AdvancedAnimationDefinition.Builder.withLength(1.0F)
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(9.4752F, -0.2629F, -3.2116F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, -3.7F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 5.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.4F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -0.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-145.1839F, 14.9084F, -20.3018F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-145.1839F, -14.9084F, 20.3018F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(-1.0F, 8.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 1.6F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 9.0F, 5.6F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition JUMPING_LOOP = AdvancedAnimationDefinition.Builder.withLength(1.0F).looping()
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(-33.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 5.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 5.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -0.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -0.8F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -0.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-145.1839F, 14.9084F, -20.3018F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-150.1839F, 14.9084F, -20.3018F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-145.1839F, 14.9084F, -20.3018F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-145.1839F, -14.9084F, 20.3018F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-150.1839F, -14.9084F, 20.3018F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-145.1839F, -14.9084F, 20.3018F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(-1.0F, 8.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(-1.0F, 9.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(-1.0F, 8.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 9.0F, 5.6F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 8.0F, 6.6F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 9.0F, 5.6F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition JUMPING_FISH = AdvancedAnimationDefinition.Builder.withLength(1.0F)
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 5.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -0.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, -0.94F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.15F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-145.1839F, 14.9084F, -20.3018F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.degreeVec(-53.1045F, -13.5536F, -27.5271F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-30.2131F, -15.548F, -29.0847F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 3.54F, -7.36F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-145.1839F, -14.9084F, 20.3018F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.degreeVec(-53.1045F, 13.5536F, 27.5271F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-30.2131F, 15.548F, 29.0847F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 3.54F, -7.36F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(-1.0F, 8.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.posVec(-1.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(-1.0F, -4.0F, -7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(27.0627F, 0.7686F, -1.1714F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 9.0F, 5.6F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition ANGRY = AdvancedAnimationDefinition.Builder.withLength(2.0F)
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-27.5896F, -4.4339F, 2.3134F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-7.3924F, -3.8282F, -3.2187F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-7.0675F, 7.6443F, 6.4664F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-7.0675F, -7.6443F, -6.4664F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(2.4363F, 7.082F, 17.1819F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(12.3973F, 4.094F, -2.8728F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(11.5613F, -12.2403F, 8.7374F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(12.082F, 8.3907F, 3.2336F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(34.987F, -19.3289F, -5.5392F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.3F, -0.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(-0.2F, -0.1F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, -0.1F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -0.2F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.3F, -0.2F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.posVec(0.3F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.posVec(0.3F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2083F, AdvancedKeyframeAnimations.posVec(0.3F, -0.8F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(-0.1F, -0.8F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.posVec(-0.1F, -0.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.3F, -0.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.posVec(0.3F, -0.7F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.3F, -0.4F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.posVec(0.0F, -0.4F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.4F, -0.4F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.posVec(0.1F, -0.4F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.posVec(0.1F, -0.8F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.1F, -0.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-23.3653F, -13.8019F, -51.1811F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-21.4744F, -16.6662F, -58.3663F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(22.1209F, 28.1195F, 97.512F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(28.4547F, 21.6721F, 112.4637F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(30.3777F, 24.5068F, 104.8473F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-0.1981F, 7.6388F, 53.0657F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 1.75F, -1.88F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -32.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -17.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -40.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-50.8653F, 13.8019F, 51.1811F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-49.4228F, 19.5632F, 56.1967F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(22.1209F, -28.1195F, -97.512F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(4.6209F, -28.1195F, -97.512F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-13.0646F, -28.4057F, -91.844F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 32.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-17.3727F, -0.5463F, 1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition NANTA = AdvancedAnimationDefinition.Builder.withLength(3.0F)
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-27.5896F, -4.4339F, 2.3134F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(-28.1336F, 6.8547F, 7.6379F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-31.4254F, -28.3238F, -9.3577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-26.4254F, -28.3238F, -9.3577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-27.5896F, 4.4339F, -2.3134F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-28.1336F, -6.8547F, -7.6379F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-31.4254F, 28.3238F, 9.3577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-26.4254F, 28.3238F, 9.3577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-27.5896F, -4.4339F, 2.3134F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-28.1336F, 6.8547F, 7.6379F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-31.4254F, -28.3238F, -9.3577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-26.4254F, -28.3238F, -9.3577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-27.5896F, 4.4339F, -2.3134F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(-28.1336F, -6.8547F, -7.6379F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-31.4254F, 28.3238F, 9.3577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(-26.4254F, 28.3238F, 9.3577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.degreeVec(-27.5896F, -4.4339F, 2.3134F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(2.4363F, 7.082F, 17.1819F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(3.4023F, 11.8649F, 23.0407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(53.4023F, 11.8649F, 23.0407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(42.8764F, 11.8928F, 20.4861F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(2.4363F, -7.082F, -17.1819F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(3.4023F, -11.8649F, -23.0407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(53.4023F, -11.8649F, -23.0407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(42.8764F, -11.8928F, -20.4861F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(2.4363F, 7.082F, 17.1819F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(3.4023F, 11.8649F, 23.0407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(53.4023F, 11.8649F, 23.0407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(42.8764F, 11.8928F, 20.4861F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(2.4363F, -7.082F, -17.1819F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(3.4023F, -11.8649F, -23.0407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(53.4023F, -11.8649F, -23.0407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(42.8764F, -11.8928F, -20.4861F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.degreeVec(2.4363F, 7.082F, 17.1819F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(34.987F, -19.3289F, -5.5392F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(34.2775F, -26.6412F, -3.7261F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-6.8062F, -2.2153F, -9.2775F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(5.6844F, 1.8465F, -6.3612F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(34.987F, 19.3289F, 5.5392F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(34.2775F, 26.6412F, 3.7261F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-6.8062F, 2.2153F, 9.2775F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(5.6844F, -1.8465F, 6.3612F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(34.987F, -19.3289F, -5.5392F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(34.2775F, -26.6412F, -3.7261F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-6.8062F, -2.2153F, -9.2775F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(5.6844F, 1.8465F, -6.3612F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(34.987F, 19.3289F, 5.5392F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(34.2775F, 26.6412F, 3.7261F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-6.8062F, 2.2153F, 9.2775F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(5.6844F, -1.8465F, 6.3612F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.degreeVec(34.987F, -19.3289F, -5.5392F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.posVec(0.0F, -0.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, -0.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.posVec(0.0F, -0.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.posVec(0.0F, -0.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-0.1981F, 7.6388F, 53.0657F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(2.1209F, 7.3428F, 70.715F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-51.1635F, -21.4568F, -33.9585F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-47.2865F, -25.3148F, -37.4248F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-9.5459F, -2.9932F, -7.25F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(18.092F, 3.4049F, 29.7197F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(27.7445F, 4.9441F, 24.9497F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-0.1981F, 7.6388F, 53.0657F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(2.1209F, 7.3428F, 70.715F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-51.1635F, -21.4568F, -33.9585F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-47.2865F, -25.3148F, -37.4248F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(-9.5459F, -2.9932F, -7.25F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(18.092F, 3.4049F, 29.7197F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(27.7445F, 4.9441F, 24.9497F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.degreeVec(-0.1981F, 7.6388F, 53.0657F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 1.75F, -1.88F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.posVec(0.0F, 3.99F, -4.15F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 1.75F, -1.88F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 1.75F, -1.88F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.posVec(0.0F, 3.99F, -4.15F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(0.0F, 1.75F, -1.88F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.posVec(0.0F, 1.75F, -1.88F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(-33.735F, -9.9319F, -14.4817F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-17.3727F, 0.5463F, -1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-47.3727F, 0.5463F, -1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-23.2281F, -14.0447F, -14.8166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-15.7281F, -14.0447F, -14.8166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-33.735F, -9.9319F, -14.4817F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-17.3727F, 0.5463F, -1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(-47.3727F, 0.5463F, -1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-23.2281F, -14.0447F, -14.8166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(-15.7281F, -14.0447F, -14.8166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(-9.5459F, 2.9932F, 7.25F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(18.092F, -3.4049F, -29.7197F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(27.7445F, -4.9441F, -24.9497F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-0.1981F, -7.6388F, -53.0657F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(2.1209F, -7.3428F, -70.715F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-51.1635F, 21.4568F, 33.9585F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-47.2865F, 25.3148F, 37.4248F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-9.5459F, 2.9932F, 7.25F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(18.092F, -3.4049F, -29.7197F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(27.7445F, -4.9441F, -24.9497F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-0.1981F, -7.6388F, -53.0657F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(2.1209F, -7.3428F, -70.715F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-51.1635F, 21.4568F, 33.9585F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(-47.2865F, 25.3148F, 37.4248F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 1.75F, -1.88F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 3.99F, -4.15F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(0.0F, 1.75F, -1.88F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.posVec(0.0F, 3.99F, -4.15F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, -5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-17.3727F, -0.5463F, 1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(-47.3727F, -0.5463F, 1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-23.2281F, 14.0447F, 14.8166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-15.7281F, 14.0447F, 14.8166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-33.735F, 9.9319F, 14.4817F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-17.3727F, -0.5463F, 1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-47.3727F, -0.5463F, 1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-23.2281F, 14.0447F, 14.8166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-15.7281F, 14.0447F, 14.8166F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(-33.735F, 9.9319F, 14.4817F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.degreeVec(-17.3727F, -0.5463F, 1.003F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, -3.56F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, -3.56F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, -4.22F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, -4.22F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition DEATH = AdvancedAnimationDefinition.Builder.withLength(1.5F)
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-25.5305F, 11.3125F, -5.3525F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-15.5305F, 11.3125F, -5.3525F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(16.9695F, 11.3125F, -5.3525F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(26.9695F, 11.3125F, -5.3525F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-15.7729F, -7.9626F, -14.9732F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(15.7866F, 3.2354F, 7.434F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(10.7866F, 3.2354F, 7.434F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(19.5538F, -17.7493F, -7.2742F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(20.7985F, -6.6341F, -13.1352F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-2.3469F, 2.5273F, 4.6737F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-17.2788F, 4.7896F, 5.7398F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.3F, -0.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.posVec(-0.2F, -0.1F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.posVec(0.0F, -0.1F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -0.2F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.3F, -0.2F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.posVec(0.3F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.posVec(0.3F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.3F, -0.8F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(-0.1F, -0.8F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(-0.1F, -0.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.3F, -0.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.posVec(0.16F, -0.94F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2083F, AdvancedKeyframeAnimations.posVec(0.46F, -0.94F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.posVec(0.46F, -2.84F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-11.5752F, 4.7511F, 22.0182F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-16.875F, 10.191F, 38.8013F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-52.4592F, 4.2642F, 34.1663F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-51.2051F, 14.1072F, 41.9818F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(54.769F, 4.2936F, -16.1552F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(23.3922F, 9.4111F, -27.6459F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(20.3597F, 15.0297F, -41.8845F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(80.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, -4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, -7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, -8.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition SWIM = AdvancedAnimationDefinition.Builder.withLength(1.5F).looping()
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 3.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chest", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("eye", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-34.6557F, -2.1827F, -4.1648F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(120.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(75.8945F, 29.6972F, 56.6636F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(174.3839F, 3.8849F, 54.4004F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(29.31F, 18.71F, 39.41F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-34.6557F, 2.1827F, 4.1648F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(120.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(75.8945F, -29.6972F, -56.6636F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(174.3839F, -3.8849F, -54.4004F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(29.3085F, -18.7068F, -39.4142F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 5.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(24.1F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 5.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();
}