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
public class Prowler_Animation {
	public static final AdvancedAnimationDefinition MELEE = AdvancedAnimationDefinition.Builder.withLength(3.5F)
			.addAnimation("upperbody", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(16.1405F, -38.8697F, -10.2935F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(16.14F, -38.87F, -10.29F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(5.4916F, -49.6847F, -3.173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(5.4916F, -49.6847F, -3.173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("eye_blow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-24.841F, -15.06F, 66.6238F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-24.84F, -15.06F, 66.62F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-28.7918F, -0.8104F, 61.5356F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-28.7918F, -0.8104F, 61.5356F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(-28.79F, -0.81F, 61.54F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("saw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(887.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(1067.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(1067.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(5747.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(5760.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition STRONG_ATTACK = AdvancedAnimationDefinition.Builder.withLength(3.5F)
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upperbody", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(25.6288F, 21.9184F, 4.7966F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(25.63F, 21.92F, 4.8F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(37.6446F, 28.0644F, 9.5368F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-31.3691F, -40.5497F, 16.175F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(-31.3691F, -40.5497F, 16.175F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("eye_blow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(24.2477F, -6.2797F, 13.6497F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(24.25F, -6.28F, 13.65F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(29.25F, -6.28F, 13.65F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(-62.259F, 16.0208F, 25.0645F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(-104.759F, 16.0208F, 25.0645F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(-104.759F, 16.0208F, 25.0645F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(50.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(50.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(55.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chainsaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -12.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -12.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chainsaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("saw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-180.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-180.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(3240.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition SPIN = AdvancedAnimationDefinition.Builder.withLength(2.75F)
			.addAnimation("upperbody", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -47.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -70.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 380.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("eye_blow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("eye_blow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.99F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 1.75F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.posVec(0.0F, -0.75F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 50.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 50.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 50.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 40.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(90.0F, 0.0F, 40.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chainsaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 40.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 40.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-12.5F, 0.0F, 40.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("saw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-540.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(4277.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition STUN = AdvancedAnimationDefinition.Builder.withLength(2.875F)
			.addAnimation("upperbody", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("eye_blow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("eye_blow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("rocket_luncher", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("saw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-720.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-630.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-720.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition DEATH = AdvancedAnimationDefinition.Builder.withLength(3.0F)
			.addAnimation("upperbody", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("eye_blow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("rocket_luncher", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-125.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition IDLE = AdvancedAnimationDefinition.Builder.withLength(3.0F).looping()
			.addAnimation("upperbody", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0268F, -40.9707F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, -40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("eye_blow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(0.0F, 1.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.posVec(0.0F, 1.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("rocket_luncher", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("saw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(2430.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();


	public static final AdvancedAnimationDefinition STRONG_SPIN = AdvancedAnimationDefinition.Builder.withLength(4.75F)
			.addAnimation("upperbody", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -72.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -72.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 1122.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 1080.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("rocket_luncher", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-360.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("missile", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("missile2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("missile3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(2.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 42.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 42.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 65.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 47.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 47.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.375F, AdvancedKeyframeAnimations.degreeVec(90.0F, 0.0F, 25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("saw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(3780.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();


	public static final AdvancedAnimationDefinition PIERCE = AdvancedAnimationDefinition.Builder.withLength(5.0F)
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upperbody", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 47.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -70.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 72.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("upperbody", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("rocket_luncher", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(360.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("rocket_luncher", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("missile", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("missile", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("missile2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("missile2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("missile3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("missile3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.625F, AdvancedKeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.0F, AdvancedKeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(4.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 32.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(36.6911F, 25.1478F, -7.5282F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.625F, AdvancedKeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.125F, AdvancedKeyframeAnimations.degreeVec(-40.0F, -67.5F, 90.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(10.0F, -67.5F, 90.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("chainsaw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 42.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 42.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.2083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("saw", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.75F, AdvancedKeyframeAnimations.degreeVec(4352.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition LASER = AdvancedAnimationDefinition.Builder.withLength(4.5F)
			.addAnimation("upperbody", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.875F, AdvancedKeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(4.0F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("upperbody", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(4.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("eye_blow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(0.0F, -0.75F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.875F, AdvancedKeyframeAnimations.posVec(0.0F, -0.75F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.posVec(0.0F, 2.25F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(4.125F, AdvancedKeyframeAnimations.posVec(0.0F, 2.25F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rocket_luncher", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-360.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("missile", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("missile2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("missile3", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(2.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.25F, AdvancedKeyframeAnimations.degreeVec(63.4009F, 36.4313F, 17.8023F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(4.0F, AdvancedKeyframeAnimations.degreeVec(63.4009F, 36.4313F, 17.8023F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("right_arm_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(4.0F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("right_joint", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.875F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.build();
}