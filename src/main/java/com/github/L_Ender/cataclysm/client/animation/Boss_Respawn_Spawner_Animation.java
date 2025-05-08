package com.github.L_Ender.cataclysm.client.animation;// Save this class in your mod and generate all required imports

import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationChannel;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationDefinition;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframe;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframeAnimations;

public class Boss_Respawn_Spawner_Animation {
	public static final AdvancedAnimationDefinition SPAWNING = AdvancedAnimationDefinition.Builder.withLength(0.9167F)
		.addAnimation("one", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, -3.5F, -20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("one", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(-0.25F, 0.0F, 0.25F), AdvancedAnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("two", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 3.5F, 20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("two", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(0.25F, 0.0F, 0.25F), AdvancedAnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("three", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, -3.5F, 20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("three", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(0.25F, 0.0F, -0.25F), AdvancedAnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("four", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 3.5F, -20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("four", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(-0.25F, 0.0F, -0.25F), AdvancedAnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("bone", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 126.67F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("bone", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 5.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("bone2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.0833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -2.05F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("bone3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.0833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.05F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
		))
		.build();
}