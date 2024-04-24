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
public class Wadjet_Animation {
	public static final AdvancedAnimationDefinition IDLE = AdvancedAnimationDefinition.Builder.withLength(3.0F).looping()
		.addAnimation("upper_body1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("upper_body1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, -0.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, -0.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("tail5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("tail5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.1F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition WALK = AdvancedAnimationDefinition.Builder.withLength(1.0F).looping()
		.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(23.0101F, 1.3152F, 6.2029F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(22.9434F, -7.2828F, -2.4057F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(23.0101F, 1.3152F, 6.2029F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.0803F, -2.4795F, -5.2051F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(11.8204F, 3.5461F, 1.9635F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(12.0803F, -2.4795F, -5.2051F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-47.4843F, 2.3842F, 0.7522F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-47.4843F, 2.3842F, 0.7522F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(2.3762F, 14.9486F, 3.6666F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-51.4984F, 14.8872F, 0.1372F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-50.197F, -10.3537F, -6.9883F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-51.4984F, 14.8872F, 0.1372F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("upper_body1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION, 
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(20, -11.9511F, -10.3568F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(20, 11.9511F, 10.3568F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(20, -11.9511F, -10.3568F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();


	public static final AdvancedAnimationDefinition STAB_N_SWING = AdvancedAnimationDefinition.Builder.withLength(3.0F)
			.addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.5957F, -2.8838F, -2.4097F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -12.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -13.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-10.0F - 17.5f, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-16.0786F - 17.5f, 30.3987F, -9.6473F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(63.7276F - 17.5f, 2.9058F, -10.3044F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-6.28F - 17.5f, -40.1584F, 9.4953F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(-16.4325F - 17.5f, 53.173F, -32.0739F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(-25.988F - 17.5f, 57.769F, -43.4526F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-25.988F - 17.5f, 57.769F, -43.4526F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -12.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -11.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -13.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(12.3022F, 9.8207F, 5.3235F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(12.2762F, -2.6725F, 4.9101F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(23.7511F, -27.0888F, -0.699F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(24.4217F, -31.947F, -2.0587F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(34.8201F, -28.2329F, -12.7972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(37.6287F, -37.2407F, -17.9723F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(31.9046F, 6.4901F, 1.8793F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(32.6397F, 15.7733F, 5.673F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-7.3081F, -22.6887F, 4.0023F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-7.3081F, -22.6887F, 4.0023F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-30.3047F, -6.1232F, 10.3861F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-33.1498F, 39.5026F, -4.0149F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-35.3102F, 57.8227F, -30.0282F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-80.8249F, 69.8144F, -103.1444F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-80.8249F, 69.8144F, -103.1444F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(-8.6825F, -11.0033F, 9.7337F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(-10.6988F, -24.6633F, 16.2644F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5272F, -1.6887F, -1.8437F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(34.234F, -0.9499F, -1.0371F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(27.1019F, 11.9128F, -3.814F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-37.34F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-72.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-77.3159F, -2.1539F, -9.7676F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(-55.247F, 0.1267F, 54.3067F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(-60.247F, 0.1267F, 54.3067F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(6.14F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(16.14F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(31.14F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(26.14F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(15.2469F, 23.6582F, 18.1684F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.4257F, 38.658F, 18.3663F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0504F, -16.86F, 6.4178F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(-78.2001F, -93.3764F, 71.0828F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-115.658F, -65.317F, 132.2951F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-84.3443F, -62.5752F, 73.3758F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-57.4106F, -26.6124F, 40.3165F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-60.0687F, -83.3147F, 160.7296F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-68.8905F, -86.5593F, 171.8412F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-15.067F, -90.0301F, 104.5983F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(-49.3302F, 6.8198F, 43.7163F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-20.5802F, 18.511F, 49.6793F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -75.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.399F, -45.0074F, -0.4193F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(0.172F, 2.2113F, -0.1672F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 29.43F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-4.207F, 6.5728F, 3.9539F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-8.0962F, -42.4292F, 8.6128F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -28.07F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -33.07F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 44.43F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 22.03F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-2.8076F, 23.9915F, 0.6632F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-2.8659F, 26.4884F, 0.5264F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(-9.6777F, 64.6223F, -7.3323F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-10.8755F, 76.2797F, -8.7668F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-6.4141F, 66.3853F, -4.0754F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-4.9732F, 58.9216F, -2.4567F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-4.6421F, 56.4304F, -2.0649F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(-4.1174F, 51.4449F, -1.4165F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(-11.0F, 1.0F, -3.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(-2.0F, 0.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(-4.0F, 0.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(-14.0F, 0.0F, -9.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.posVec(-14.0F, 0.0F, -11.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(76.9451F, 48.3436F, 21.4849F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(87.6591F, 52.2557F, 25.6694F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(98.0834F, 59.427F, 62.0609F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(100.6089F, 68.0785F, 95.7749F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(108.1816F, 54.3954F, 124.5938F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(85.5605F, 45.5778F, 86.3365F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(75.4464F, 82.7777F, 21.4684F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(21.0676F, -47.4314F, -45.4534F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(18.1502F, -42.7195F, -42.0904F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(-1.6065F, 60.0746F, -41.8252F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(13.3384F, 71.5789F, -24.1092F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 36.67F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, -33.05F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.13F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.27F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 6.12F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.81F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 42.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 52.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 70.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -67.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -50.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(7.6078F, 3.814F, 3.2356F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(7.9331F, -7.6157F, -6.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-24.5113F, -10.09F, -6.8615F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-24.4392F, -12.564F, -7.2286F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-8.8606F, -31.0948F, -15.3878F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-7.4901F, -35.6426F, -17.8773F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(-7.336F, 6.1789F, -0.2071F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(-7.0157F, 10.6894F, 1.9746F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition SPEAR_CHARGE = AdvancedAnimationDefinition.Builder.withLength(2.25F)
			.addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.5957F, -2.8838F, -2.4097F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -17.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-10.0F + 23.1591F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-28.5786F + 23.1591F, 30.3987F, -9.6473F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(64.3916F + 23.1591F, -8.6128F, -23.5181F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(74.372F, -8.2323F, -27.207F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(25.3098F, -4.0924F, -13.8341F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -12.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.3022F, 9.8207F, 5.3235F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(12.2762F, -2.6725F, 4.9101F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(24.0658F, -29.5196F, -1.3625F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(21.5658F, -29.5196F, -1.3625F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-7.3081F, -22.6887F, 4.0023F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-7.3081F, -22.6887F, 4.0023F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-30.3047F, -6.1232F, 10.3861F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-17.4102F, 63.6033F, 16.1243F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-7.0224F, 61.8584F, 17.4844F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(12.5272F, -1.6887F, -1.8437F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(34.234F, -0.9499F, -1.0371F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-37.34F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(15.2469F, 23.6582F, 18.1684F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(179.2896F, 46.3407F, 197.2663F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0504F, -16.86F, 6.4178F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(-78.2001F, -93.3764F, 71.0828F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-111.855F, -44.6696F, 122.5357F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-113.1701F, -41.7943F, 129.587F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -95.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.399F, -45.0074F, -0.4193F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(0.1587F, 9.7112F, -0.1418F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 29.43F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 26.93F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-2.8076F, 23.9915F, 0.6632F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-2.8659F, 26.4884F, 0.5264F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(5.6082F, 69.5351F, -9.7339F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-23.2564F, 83.4923F, -21.3168F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-36.4035F, 85.6755F, -34.52F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(-11.0F, 1.0F, -3.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(76.9451F, 48.3436F, 21.4849F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(85.7653F, 52.1123F, 22.5365F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(98.0834F, 59.427F, 62.0609F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(100.6089F, 68.0785F, 95.7749F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(105.1421F, 37.6137F, 118.76F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(105.1421F, 37.6137F, 118.76F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(73.7038F, 71.5822F, 32.1398F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 51.67F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -33.05F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.13F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.27F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 4.73F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 24.07F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -62.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-8.835F, 58.9451F, -8.367F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(7.6078F, 3.814F, 3.2356F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(21.0776F, -10.5905F, -10.5706F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-24.2425F, -17.5103F, -7.9857F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-24.116F, -19.9824F, -8.3793F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(10.4499F, -10.1457F, -4.2142F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition DOUBLE_SWING = AdvancedAnimationDefinition.Builder.withLength(2.75F)
			.addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 75.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -13.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -1.31F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -17.89F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F , 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-6.28F - 17.5f, -40.1584F, 9.4953F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-16.4325F - 17.5f, 53.173F, -32.0739F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-25.6018F - 17.5f, 61.2944F, -42.9414F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(7.3532F - 17.5f, -17.9859F, 11.0017F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(6.7671F - 17.5f, -27.8906F, 12.4997F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -13.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -1.31F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -17.89F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(37.6287F, -37.2407F, -17.9723F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(31.9046F, 6.4901F, 1.8793F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(33.2664F, 20.3913F, 7.6903F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(32.1442F, -46.8773F, -5.7956F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(35.763F, -53.7571F, -10.4884F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-80.8249F, 69.8144F, -103.1444F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-8.6825F, -11.0033F, 9.7337F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-14.4196F, 36.711F, -13.5459F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-36.0385F, 53.2156F, -29.7647F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(27.1019F, 11.9128F, -3.814F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(12.5014F, -21.469F, 13.1243F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(2.8137F, 17.3877F, 3.2489F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-77.3159F, -2.1539F, -9.7676F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-55.247F, 0.1267F, 54.3067F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-65.3707F, -1.5608F, 64.1644F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-27.6657F, 1.7032F, -22.8349F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-48.018F, 3.9187F, -30.0093F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(16.14F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(31.14F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(23.64F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(28.64F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(21.14F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-68.8905F, -86.5593F, 171.8412F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(-15.067F, -90.0301F, 104.5983F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-49.3302F, 6.8198F, 43.7163F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-111.3933F, 18.4354F, -36.6498F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-91.109F, -32.0395F, 49.8904F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-45.6585F, -120.2128F, 102.5381F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-168.9416F, -113.9424F, 225.9641F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -33.07F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 44.43F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 39.43F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -3.07F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -13.07F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-4.6421F, 56.4304F, -2.0649F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-4.1174F, 51.4449F, -1.4165F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-4.9732F, 58.9216F, -2.4567F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-19.7112F, 82.3751F, -17.7447F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-4.6421F, 56.4304F, -2.0649F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-4.1174F, 51.4449F, -1.4165F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(-14.0F, 0.0F, -9.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(-14.0F, 0.0F, -11.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.posVec(-14.0F, 0.0F, -11.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(-14.0F, 0.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(-14.0F, 1.0F, -11.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(18.1502F, -42.7195F, -42.0904F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-1.6065F, 60.0746F, -41.8252F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-3.3271F, 85.0549F, -43.8156F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(1.6471F, -27.403F, -40.947F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(1.8883F, -34.8994F, -41.2807F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 42.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 55.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(2.5365F, -17.6338F, -9.4871F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(1.8599F, -8.0786F, -6.4578F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-7.4901F, -35.6426F, -17.8773F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-7.336F, 6.1789F, -0.2071F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-6.5121F, 15.1844F, 4.2221F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(10.9929F, -27.468F, -17.3335F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(20.8F, -37.1819F, -30.9044F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition MAGIC = AdvancedAnimationDefinition.Builder.withLength(1.75F)
			.addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.332F, 8.1401F, 2.4394F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.2645F, 23.2784F, 0.9873F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-2.5759F, 25.664F, 0.1657F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-2.5759F, 25.664F, 0.1657F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(15.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(25.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(25.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-129.1105F, -80.4366F, 121.1136F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-133.0565F, -77.1477F, 126.5681F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-133.0565F, -77.1477F, 126.5681F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 37.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 37.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 37.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 42.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 42.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -7.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(9.2782F, -20.7276F, -34.2168F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(15.3296F, -28.1186F, -35.8689F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(15.3296F, -28.1186F, -35.8689F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-10.0909F, 0.3871F, -1.9318F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-10.0909F, 0.3871F, -1.9318F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition DEATH = AdvancedAnimationDefinition.Builder.withLength(3.0F)
			.addAnimation("tail", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("tail", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-16.1894F, 15.0949F, -8.9589F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-21.6177F, 17.1072F, -10.5031F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-23.5592F, 7.0283F, -3.2869F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-26.4526F, -9.9883F, -3.3684F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-32.3222F, -3.3021F, 4.1224F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-32.3222F, -3.3021F, 4.1224F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("upper_body1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(2.1963F, -2.4919F, -0.2013F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(42.5175F, -4.9838F, -0.4026F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(42.5175F, -4.9838F, -0.4026F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("upper_body2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-21.8392F, 7.5463F, 9.9942F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-26.8392F, 7.5463F, 9.9942F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(15.6608F, 7.5463F, 9.9942F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(55.6608F, 7.5463F, 9.9942F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(55.6608F, 7.5463F, 9.9942F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(60.6608F, 7.5463F, 9.9942F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("neck2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-20.4385F, 7.053F, -7.1071F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-38.2368F, 8.1847F, -9.3561F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-20.7368F, 8.1847F, -9.3561F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-51.1834F, 3.7132F, 10.2493F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-51.1834F, 3.7132F, 10.2493F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-56.1834F, 3.7132F, 10.2493F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("jaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 40.0F, 22.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 47.5F, 22.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-20.698F, 23.7891F, 10.4049F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-11.3641F, -27.0773F, 26.7644F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-36.993F, -49.7609F, 10.3753F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-65.1014F, -28.3308F, 67.4981F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(-4.0F, -6.0F, -18.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(-4.25F, -6.31F, -19.12F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(-4.0F, -6.0F, -20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -55.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -57.5F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 37.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 47.5F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 55.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 55.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("wand", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-1.5309F, -0.6074F, -6.9242F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-0.9079F, -13.1575F, -9.3157F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-0.4496F, 6.8128F, -12.1549F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-0.5751F, 54.3111F, -12.5832F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-0.5751F, 54.3111F, -12.5832F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("left_fore_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("tail2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("tail3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 47.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("tail4", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 40.0F, -0.0001F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("tail5", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-12.429F, 4.6901F, 1.7347F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-12.0495F, 11.7158F, 4.3885F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(22.6604F, 7.0339F, 2.6094F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(42.6604F, 7.0339F, 2.6094F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(42.6604F, 7.0339F, 2.6094F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();
}
