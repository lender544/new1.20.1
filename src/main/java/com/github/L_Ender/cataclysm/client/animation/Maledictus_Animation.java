package com.github.L_Ender.cataclysm.client.animation;// Save this class in your mod and generate all required imports

import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationChannel;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationDefinition;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframe;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Made with Blockbench 4.9.4
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author kor
 */
public class Maledictus_Animation {
	public static final AdvancedAnimationDefinition IDLE = AdvancedAnimationDefinition.Builder.withLength(2.0F).looping()
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -0.2F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, -42.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition SMASH_LEAP = AdvancedAnimationDefinition.Builder.withLength(0.8333F)
		.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -6.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-49.446F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-40.696F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-76.946F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(100.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(61.25F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(102.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-71.946F, -12.4879F, -2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-120.973F, -11.244F, -1.2803F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(-5.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(133.75F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-12.7001F, 34.6292F, 11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(-4.1835F, -20.2281F, 15.7069F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(7.2999F, 34.6292F, 11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(-94.53F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-12.7001F, -34.6292F, -11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(-4.1835F, 20.2281F, -15.7069F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(7.2999F, -34.6292F, -11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(-94.53F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-1.1338F, 14.9756F, -2.9187F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-6.8871F, -35.7432F, -9.0988F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-4.3005F, 14.7384F, -8.8319F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -142.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-1.1338F, -14.9756F, 2.9187F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-6.8871F, 35.7432F, 9.0988F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-4.3005F, -14.7384F, 8.8319F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 145.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition SMASH_DESENT = AdvancedAnimationDefinition.Builder.withLength(1.5F)
		.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-76.946F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.554F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(-77.8497F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-69.446F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(102.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(109.66F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-5.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-57.5F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-17.5F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.09F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.09F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(122.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(85.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(38.4635F, -11.8491F, -9.2643F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(62.8783F, 4.9809F, 8.6822F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(7.2999F, 34.6292F, 11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-127.7001F, 34.6292F, 11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-58.0224F, -5.2483F, 11.3608F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(7.2999F, -34.6292F, -11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-79.3975F, -3.762F, 20.2676F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-57.6541F, -9.3955F, -18.0283F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-18.6966F, 16.9567F, -5.4884F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(50.064F, -7.4355F, -0.9845F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-4.3005F, 14.7384F, -8.8319F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-6.2935F, 37.148F, -11.6747F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-3.688F, -14.2071F, -6.7734F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -85.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-4.3005F, -14.7384F, 8.8319F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-6.7115F, -39.632F, 12.1795F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-3.7611F, 2.7192F, 7.4956F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 85.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition WALK = AdvancedAnimationDefinition.Builder.withLength(1.25F).looping()
		.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(5.1754F, 0.0F, 1.3378F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.posVec(0.0F, -1.16F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -1.22F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, -0.16F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(13.9906F, 3.795F, -3.2653F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-18.214F, 0.5031F, -2.5834F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-22.8228F, -0.938F, -5.4F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-17.4684F, -0.2742F, -2.9822F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(13.9906F, 3.795F, -3.2653F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(-0.5F, 0.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(-0.6F, 2.0F, -0.63F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(-0.5F, 0.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.posVec(-0.5F, -1.07F, -2.63F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(-0.5F, 0.0F, 0.48F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(-0.5F, 0.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(5.52F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(51.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(45.23F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(3.18F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(32.7265F, 1.6044F, 0.2666F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(5.52F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-22.8228F, 0.938F, 5.4F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-17.4684F, 0.2742F, 2.9822F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(16.4877F, -3.9922F, 3.1723F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(-18.214F, -0.5031F, 2.5834F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-22.8228F, 0.938F, 5.4F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.5F, 0.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.0833F, AdvancedKeyframeAnimations.posVec(0.5F, -1.0F, -0.54F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.5F, 0.0F, 0.48F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.5F, 0.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(0.5F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.5F, 0.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(3.18F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(32.7265F, -1.6044F, -0.2666F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(5.52F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(51.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(45.23F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(3.18F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(2.5F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(4.8079F, 10.178F, 0.1633F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, -0.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(25.2393F, 15.2713F, 15.7485F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(11.1123F, 0.0605F, 8.7421F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(-10.3315F, -9.7465F, 4.2248F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-2.8351F, 12.6032F, -4.8288F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(25.2393F, 15.2713F, 15.7485F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.8351F, 12.6032F, -4.8288F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(2.0161F, -4.1219F, -11.6371F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(25.9215F, -19.7819F, -18.0119F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(2.0161F, -4.1219F, -11.6371F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-2.8351F, 12.6032F, -4.8288F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(4.9267F, -5.9673F, -0.5903F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(2.4881F, -5.0024F, 0.1094F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(4.9267F, -5.9673F, -0.5903F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.0031F, -2.6313F, -7.7614F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(5.9299F, 32.2409F, 7.7508F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-2.0031F, -2.6313F, -7.7614F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -77.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -77.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-4.7535F, -14.6883F, 8.8722F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(5.9299F, -32.2409F, -7.7508F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-4.7535F, -14.6883F, 8.8722F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 77.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 77.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition SHOOT = AdvancedAnimationDefinition.Builder.withLength(2.3333F)
		.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -70.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, -70.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(-45.0542F, 28.8066F, 1.9515F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-27.9221F, 67.5369F, -6.1779F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-27.9221F, 67.5369F, -6.1779F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-24.1703F, 52.1852F, 1.0788F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.554F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(60.72F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-6.9444F, -12.4808F, 2.4284F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-11.4266F, 0.2525F, -5.6778F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-11.265F, 1.4752F, -3.2608F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-8.1081F, -2.3922F, -5.3791F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(-25.7237F, -10.921F, -3.0884F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(12.28F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(16.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(39.06F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-2.9325F, 22.4097F, 5.4096F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-5.8536F, 23.0103F, 10.7909F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-4.7903F, 23.2422F, 13.4977F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-4.6346F, 18.2591F, 13.9368F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(16.7357F, -41.2675F, -11.2179F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(16.7357F, -41.2675F, -11.2179F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(20.8172F, -15.2092F, -27.8057F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(7.564F, 7.4355F, 10.9845F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-80.0F, 20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-100.5212F, 58.7909F, -5.9364F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-101.7495F, 62.0045F, -7.8159F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-102.4018F, 62.0492F, -7.2192F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2083F, AdvancedKeyframeAnimations.degreeVec(-101.7495F, 62.0045F, -7.8159F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-102.4018F, 62.0492F, -7.2192F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-100.5212F, 58.7909F, -5.9364F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-64.571F, 44.3606F, 45.173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 30.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 37.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 37.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(43.3818F, 0.0F, 32.6455F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("bow_string", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 8.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 8.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("string1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("string2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(2.3208F, -12.511F, 0.5541F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(7.564F, -7.4355F, -10.9845F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-74.4633F, 8.7219F, 11.8862F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-110.2334F, 6.4893F, -7.7716F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-110.2334F, 6.4893F, -7.7716F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-112.5267F, -26.2414F, 5.0057F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 90.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-8.801F, -1.154F, 92.0517F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-7.0863F, -2.1143F, 82.7458F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 90.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 30.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(12.5F, 42.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(26.0187F, 39.5608F, 9.1544F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(24.1121F, 40.6202F, 6.1942F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-6.5717F, 45.102F, -9.0961F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_horn", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
			new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.86F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-1.0351F, 4.9774F, -2.7057F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.71F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, -71.41F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -54.29F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.36F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 52.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-1.0351F, -4.9774F, 2.7057F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -23.21F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 60.86F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition SWING = AdvancedAnimationDefinition.Builder.withLength(2.1667F)
		.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.posVec(0.0F, -12.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.posVec(0.0F, -12.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-74.446F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(20.543F, -5.0113F, 2.3934F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-19.5623F, 4.2453F, 11.7678F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(92.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-40.7832F, -36.7644F, -16.9573F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-2.5232F, -45.5258F, -33.2013F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-105.1437F, -34.0544F, 8.6177F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-121.4534F, -0.6794F, 9.0817F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-102.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-102.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(92.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(107.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(122.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(105.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(105.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(42.2963F, -25.231F, -21.1975F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-7.4366F, -0.9762F, 5.0634F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(5.0F, 27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-6.3144F, -2.4682F, 32.6107F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-84.7523F, 34.0143F, 13.1645F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-109.7523F, 34.0143F, 13.1645F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(30.9805F, 0.1326F, 20.0773F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-21.5195F, 0.1326F, 20.0773F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-41.0211F, 24.0971F, -22.272F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(22.6746F, -6.9262F, -2.8842F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(22.6746F, -6.9262F, -2.8842F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-82.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-44.59F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(8.8722F, -32.1883F, -14.7535F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-8.3799F, -47.3886F, -17.9205F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-85.5995F, -27.582F, 11.3234F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-83.0595F, 4.4419F, 20.0714F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(22.6746F, 6.9262F, 2.8842F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(22.6746F, 6.9262F, 2.8842F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-66.7808F, -13.9954F, 14.4328F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-45.6632F, 0.9599F, -0.9899F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-19.5684F, 26.128F, -8.8967F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(37.1326F, 3.8167F, -11.9305F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-1.415F, 29.972F, -3.3528F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-5.4812F, 62.4356F, -7.7073F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-1.0784F, -45.0151F, -1.8116F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-1.2052F, 19.9746F, -3.0432F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-1.2052F, 19.9746F, -3.0432F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -115.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -65.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -125.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, -40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-1.415F, -29.972F, 3.3528F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-3.1743F, -54.9554F, 5.3369F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-1.1678F, 52.5137F, 1.6398F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-1.2481F, -22.474F, 3.1118F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-1.2481F, -22.474F, 3.1118F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 115.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 65.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 125.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();

	public static final AdvancedAnimationDefinition TAKE_DOWN = AdvancedAnimationDefinition.Builder.withLength(3.0F)
		.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.7917F, AdvancedKeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-71.6587F, 49.9854F, 3.0852F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.7917F, AdvancedKeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.7917F, AdvancedKeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-77.3784F, -19.7153F, 0.0888F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.7917F, AdvancedKeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(12.9934F, -10.411F, 9.92F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-127.3898F, 16.1909F, 7.9732F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-17.8416F, -27.1492F, 8.9216F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(-36.5122F, -24.1818F, 20.5302F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-17.8416F, -27.1492F, 8.9216F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 40.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-47.0675F, 7.6443F, 6.4664F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-40.16F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-91.58F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(-96.23F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-62.5894F, -2.3064F, 4.4375F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(207.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(187.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.degreeVec(187.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(12.2286F, 7.9243F, -8.9173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-126.512F, -16.996F, -2.9463F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-30.0828F, 22.3301F, -6.9786F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(-45.6888F, 17.1578F, -16.4899F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-30.0828F, 22.3301F, -6.9786F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, -40.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-45.7471F, -5.57F, -10.4263F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-35.6011F, -13.017F, -11.329F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-26.25F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-81.7896F, -0.2631F, -0.6919F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-57.7032F, 4.4384F, 11.6727F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(-90.9141F, 4.9152F, 12.9266F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-60.0913F, 13.5322F, -3.483F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(207.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(185.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.degreeVec(185.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-1.1103F, -47.3784F, -1.7584F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-1.3641F, 27.6088F, -3.278F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-1.0632F, 7.6132F, -2.7628F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-1.0632F, 7.6132F, -2.7628F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.7917F, AdvancedKeyframeAnimations.degreeVec(-1.9317F, 42.6029F, -3.9863F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(-0.9779F, -7.3845F, -2.4833F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -108.09F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -61.11F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-1.0245F, 36.7686F, 1.9742F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-1.4516F, -30.7194F, 3.3949F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-1.0976F, -10.7241F, 2.8314F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-1.0976F, -10.7241F, 2.8314F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.7917F, AdvancedKeyframeAnimations.degreeVec(-2.1462F, -45.7123F, 4.2284F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(-0.9935F, 4.2734F, 2.5396F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
			new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 114.96F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 62.9F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
			new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
		))
		.build();


	public static final AdvancedAnimationDefinition DEATH = AdvancedAnimationDefinition.Builder.withLength(3.0F)
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(92.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0417F, AdvancedKeyframeAnimations.degreeVec(92.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(92.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 6.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.02F, 3.56F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.4F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.posVec(0.0F, -9.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(0.0F, -8.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, -8.07F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 4.0F, -4.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-28.2467F, 16.3205F, -5.4163F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-12.4722F, -1.0445F, 0.3466F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(-75.959F, 0.0709F, -0.0235F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-74.4606F, 0.0535F, -0.0177F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-13.9218F, 9.1879F, 21.5875F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0417F, AdvancedKeyframeAnimations.degreeVec(13.6027F, -12.1729F, 7.5501F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-1.3673F, -14.8772F, 5.3366F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(24.3335F, -0.9265F, 3.3973F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(40.9827F, 0.0593F, -0.2174F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(82.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(82.7511F, -0.0037F, 0.0136F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(82.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(-38.43F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-45.47F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(16.68F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4167F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(81.7039F, 19.2789F, -7.2708F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(81.7039F, 19.2789F, -7.2708F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(92.6078F, 15.3628F, -5.7939F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(28.467F, 8.4771F, -3.197F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("front_cloth1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-38.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(-33.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("front_cloth2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-36.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(-4.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.0833F, AdvancedKeyframeAnimations.degreeVec(10.0182F, -1.6097F, -0.4324F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(22.5547F, -4.8292F, -1.2972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(25.506F, 2.3349F, 2.0406F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(-15.2207F, 9.6559F, -2.613F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-20.2207F, 9.6559F, -2.613F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-2.4552F, 4.8969F, 0.3419F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-4.9552F, 4.8969F, 0.3419F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2083F, AdvancedKeyframeAnimations.degreeVec(-4.8773F, 5.979F, 1.2566F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-4.9552F, 4.8969F, 0.3419F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-5.0332F, 3.8137F, -0.5698F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-4.9552F, 4.8969F, 0.3419F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-4.8773F, 5.979F, 1.2566F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-4.9552F, 4.8969F, 0.3419F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-5.0332F, 3.8137F, -0.5698F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-4.9552F, 4.8969F, 0.3419F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-5.0332F, 3.8137F, -0.5698F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-10.5332F, 3.8137F, -0.5698F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(-5.0332F, 3.8137F, -0.5698F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, -0.2F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(10.548F, 26.2049F, 19.3614F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 30.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(13.0041F, 14.4775F, 3.9671F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(15.5041F, 14.4775F, 3.9671F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(15.5041F, 14.4775F, 3.9671F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(20.5041F, 14.4775F, 3.9671F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(90.5041F, 14.4775F, 3.9671F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(18.4938F, -26.7658F, -18.5407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -22.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.7011F, -17.3362F, -24.9986F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(7.856F, -19.9082F, -1.9321F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(10.356F, -19.9082F, -1.9321F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(10.356F, -19.9082F, -1.9321F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(17.856F, -19.9082F, -1.9321F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(105.356F, -19.9082F, -1.9321F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(39.7026F, 1.3197F, 15.5338F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-40.0542F, -3.2585F, 1.2437F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-50.0542F, -3.2585F, 1.2437F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(-50.1317F, -1.5664F, 3.0857F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-50.0542F, -3.2585F, 1.2437F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-49.9219F, -4.9472F, -0.6045F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2083F, AdvancedKeyframeAnimations.degreeVec(-50.0542F, -3.2585F, 1.2437F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-50.1317F, -1.5664F, 3.0857F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(-50.0542F, -3.2585F, 1.2437F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-49.9219F, -4.9472F, -0.6045F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-50.0542F, -3.2585F, 1.2437F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-50.1317F, -1.5664F, 3.0857F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-50.0542F, -3.2585F, 1.2437F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-49.9219F, -4.9472F, -0.6045F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.499F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -19.24F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -2.68F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, -18.59F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -46.87F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -24.39F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, -29.65F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.96F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 18.81F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -15.84F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 13.94F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 39.37F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 20.35F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 18.2F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.2F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition SWING_LEFT = AdvancedAnimationDefinition.Builder.withLength(1.125F)
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(12.4541F, 36.8345F, -4.7621F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-7.3584F, -31.4564F, -9.9203F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(39.6306F, -5.4039F, 38.7854F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(27.9879F, -6.8442F, 26.1723F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-7.14F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-78.7657F, 33.8682F, -49.7473F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(20.9723F, 0.8525F, -47.0255F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-37.1665F, 13.4716F, -18.1914F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(2.1921F, 9.3762F, -12.6612F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(39.98F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(13.0238F, -29.6589F, -2.0999F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(19.3364F, 11.1816F, 11.6431F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition swing_attack_right = AdvancedAnimationDefinition.Builder.withLength(1.125F)
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 2.84F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(30.92F, -18.9477F, 2.2213F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-18.0307F, 17.6929F, -7.484F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-84.9218F, -21.8243F, 44.1778F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(26.4907F, -18.339F, 42.6343F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.15F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-40.3483F, -20.4366F, 29.0527F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-7.14F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(47.18F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(33.5119F, 6.743F, -27.941F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(4.2643F, -9.2743F, -26.4761F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-22.1665F, 13.4716F, -18.1914F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(2.1921F, 9.3762F, -12.6612F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(62.48F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-5.5334F, 11.1441F, -5.154F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(21.6628F, -10.3422F, 1.9509F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition FLYING_SHOOT = AdvancedAnimationDefinition.Builder.withLength(3.375F)
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -70.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, -70.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.7083F, AdvancedKeyframeAnimations.posVec(0.0F, 3.07F, 8.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-71.6587F, 49.9854F, 3.0852F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-60.1598F, 33.4267F, -7.2121F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-60.497F, 57.9213F, -3.5104F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(-115.9737F, 71.8212F, -60.7332F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-115.9737F, 71.8212F, -60.7332F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(0.554F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(60.72F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(102.35F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(102.35F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(65.54F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-77.3784F, -19.7153F, 0.0888F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-6.9444F, -12.4808F, 2.4284F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(-36.3716F, 35.7618F, -29.5407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.degreeVec(-53.8716F, 35.7618F, -29.5407F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.7083F, AdvancedKeyframeAnimations.degreeVec(-36.206F, 23.3736F, -22.8133F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(-25.7237F, -10.921F, -3.0884F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(12.28F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5833F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.7083F, AdvancedKeyframeAnimations.degreeVec(26.74F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(39.06F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(112.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-2.9325F, 22.4097F, 5.4096F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(-5.8536F, 23.0103F, 10.7909F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(-4.5732F, 15.7671F, 14.1467F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-4.6346F, 18.2591F, 13.9368F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(12.9934F, -10.411F, 9.92F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(16.7357F, -41.2675F, -11.2179F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(16.7357F, -41.2675F, -11.2179F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(20.8172F, -15.2092F, -27.8057F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(7.564F, 7.4355F, 10.9845F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 40.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-80.0F, 20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(-100.5212F, 58.7909F, -5.9364F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(-101.7495F, 62.0045F, -7.8159F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(-102.4018F, 62.0492F, -7.2192F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-101.7495F, 62.0045F, -7.8159F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(-102.4018F, 62.0492F, -7.2192F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(-100.5212F, 58.7909F, -5.9364F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-64.571F, 44.3606F, 45.173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 30.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 37.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 37.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.7083F, AdvancedKeyframeAnimations.degreeVec(43.3818F, 0.0F, 32.6455F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.374F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(12.2286F, 7.9243F, -8.9173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(2.3208F, -12.511F, 0.5541F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(7.564F, -7.4355F, -10.9845F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.posVec(-3.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, -40.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-74.4633F, 8.7219F, 11.8862F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(-110.2334F, 6.4893F, -7.7716F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(-110.2334F, 6.4893F, -7.7716F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-112.5267F, -26.2414F, 5.0057F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 90.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.1667F, AdvancedKeyframeAnimations.degreeVec(6.199F, -1.154F, 92.0517F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(5.4137F, -2.1143F, 82.7458F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 90.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 30.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.374F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(12.5F, 42.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(26.0187F, 39.5608F, 9.1544F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(24.1121F, 40.6202F, 6.1942F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-6.5717F, 45.102F, -9.0961F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-1.1103F, -47.3784F, -1.7584F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-1.3641F, 27.6088F, -3.278F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-1.0632F, 7.6132F, -2.7628F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 17.86F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(-1.0351F, 4.9774F, -2.7057F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -108.09F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.71F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -71.41F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -54.29F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(-1.0245F, 36.7686F, 1.9742F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-1.4516F, -30.7194F, 3.3949F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-1.0976F, -10.7241F, 2.8314F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.36F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 52.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(-1.0351F, -4.9774F, 2.7057F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 114.96F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, -23.21F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 60.86F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -37.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -37.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bow_string", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.posVec(0.0F, 8.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.posVec(0.0F, 8.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("string1", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("string2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4583F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_horn", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.build();

	public static final AdvancedAnimationDefinition FALL_LOOP = AdvancedAnimationDefinition.Builder.withLength(1.0F).looping()
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-72.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(112.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(107.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(112.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -25.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))

			.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))

			.build();

	public static final AdvancedAnimationDefinition FALL_END = AdvancedAnimationDefinition.Builder.withLength(1.3333F)
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(-77.5F, 37.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(107.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(-77.5F, -27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(112.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(112.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 42.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, -50.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -27.5F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -55.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 10.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, -4.06F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition MASS_EFFECT = AdvancedAnimationDefinition.Builder.withLength(3.2917F)
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.posVec(0.0F, -9.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.posVec(0.0F, -9.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-141.172F, 15.3202F, -17.6352F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-84.6375F, 14.7392F, -3.5482F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(-84.6375F, 14.7392F, -3.5482F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(87.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-12.5F, -12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(102.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(102.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 12.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(47.1665F, -13.4716F, -5.6914F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(47.1665F, -13.4716F, -5.6914F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-31.4196F, 63.5714F, 74.0039F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-31.4196F, 63.5714F, 74.0039F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-92.6002F, 14.1038F, -21.6251F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(-92.9471F, -8.3197F, -23.5229F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, -30.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-19.6009F, -12.6796F, 18.7423F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(-19.6009F, -12.6796F, 18.7423F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.8333F, AdvancedKeyframeAnimations.degreeVec(-32.3004F, -6.3398F, 9.3711F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(177.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(177.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -9.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -9.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-31.4196F, -63.5714F, -74.0039F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-31.4196F, -63.5714F, -74.0039F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(-77.4165F, 16.4486F, 5.9956F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 30.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-35.411F, 5.7162F, -8.2189F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(-35.411F, 5.7162F, -8.2189F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.8333F, AdvancedKeyframeAnimations.degreeVec(-40.2055F, 2.8581F, -4.1094F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(182.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(182.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -9.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -9.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.8333F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -47.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 47.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition FLYING_SMASH_2 = AdvancedAnimationDefinition.Builder.withLength(1.1667F)
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.0833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.554F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(-77.8497F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-69.446F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.degreeVec(109.66F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-57.5F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-17.5F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.2083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.09F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.09F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(122.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(85.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(38.46F, -11.85F, -9.26F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.0417F, AdvancedKeyframeAnimations.degreeVec(38.4635F, -11.8491F, -9.2643F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(62.8783F, 4.9809F, 8.6822F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-127.7001F, 34.6292F, 11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-58.0224F, -5.2483F, 11.3608F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-79.3975F, -3.762F, 20.2676F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-57.6541F, -9.3955F, -18.0283F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.4583F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-18.6966F, 16.9567F, -5.4884F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(50.064F, -7.4355F, -0.9845F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-6.2935F, 37.148F, -11.6747F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-3.688F, -14.2071F, -6.7734F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, -85.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-6.7115F, -39.632F, 12.1795F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-3.7611F, 2.7192F, 7.4956F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 85.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition FLYING_SMASH_1 = AdvancedAnimationDefinition.Builder.withLength(5.0F)
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, -5.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, -6.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.posVec(0.0F, 0.55F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.55F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-41.946F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-49.446F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-40.696F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-76.946F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-76.946F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(0.554F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(0.554F, 12.4879F, 2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(92.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(100.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(61.25F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(102.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(102.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-64.446F, -12.4879F, -2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-71.946F, -12.4879F, -2.5606F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(-120.973F, -11.244F, -1.2803F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-5.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-5.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(-57.5F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(-57.5F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(133.75F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(122.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(122.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(34.23F, -11.73F, -9.38F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(34.23F, -11.73F, -9.38F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(8.2651F, 24.7716F, 13.483F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-12.7001F, 34.6292F, 11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-4.1835F, -20.2281F, 15.7069F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(7.2999F, 34.6292F, 11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(7.2999F, 34.6292F, 11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(-127.7001F, 34.6292F, 11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(-127.7001F, 34.6292F, 11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(5.73F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(5.73F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-94.53F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(8.2651F, -24.7716F, -13.483F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-12.7001F, -34.6292F, -11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-4.1835F, 20.2281F, -15.7069F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(7.2999F, -34.6292F, -11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(7.2999F, -34.6292F, -11.5422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(-79.3975F, -3.762F, 20.2676F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(-79.3975F, -3.762F, 20.2676F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-94.53F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(-18.6966F, 16.9567F, -5.4884F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(-18.6966F, 16.9567F, -5.4884F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-1.352F, 27.4727F, -3.2656F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-1.1338F, 14.9756F, -2.9187F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-1.1338F, 14.9756F, -2.9187F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-6.8871F, -35.7432F, -9.0988F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(-4.3005F, 14.7384F, -8.8319F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-4.3005F, 14.7384F, -8.8319F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(-6.2935F, 37.148F, -11.6747F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(-6.2935F, 37.148F, -11.6747F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -142.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-1.352F, -27.4727F, 3.2656F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-1.1338F, -14.9756F, 2.9187F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-1.1338F, -14.9756F, 2.9187F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-6.8871F, 35.7432F, 9.0988F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(-4.3005F, -14.7384F, 8.8319F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-4.3005F, -14.7384F, 8.8319F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(-6.7115F, -39.632F, 12.1795F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(-6.7115F, -39.632F, 12.1795F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 145.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(4.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(5.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();


	public static final AdvancedAnimationDefinition CHARGE_BACKSTEP = AdvancedAnimationDefinition.Builder.withLength(0.75F)
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.25F, AdvancedKeyframeAnimations.degreeVec(100.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("front_cloth2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 40.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(33.0897F, 7.9713F, 27.9733F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.degreeVec(33.0897F, -7.9713F, -27.9733F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -55.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 55.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition CHARGE = AdvancedAnimationDefinition.Builder.withLength(2.75F)
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(39.49F, -30.0211F, -3.3502F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(39.49F, -30.0211F, -3.3502F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, -9.8F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.posVec(0.0F, -8.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-102.5449F, 27.0444F, -5.6387F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-73.4256F, 29.0273F, 8.6748F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(127.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-122.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-122.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-130.8445F, -24.4895F, 19.3396F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-73.4256F, -29.0273F, -8.6748F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(115.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(115.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(115.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(77.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(36.3391F, -24.9417F, -17.2344F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(36.3391F, -24.9417F, -17.2344F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-12.6652F, -27.0478F, 11.2431F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-12.6652F, -27.0478F, 11.2431F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-14.0876F, 4.6917F, 38.977F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-1.9758F, -15.8383F, -13.6272F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-5.04F, -24.919F, -2.6789F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-1.5215F, -25.349F, -10.951F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-54.1335F, -21.9426F, 19.0958F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-54.1335F, -21.9426F, 19.0958F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-35.9757F, 4.8845F, 8.8604F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-35.9757F, 4.8845F, 8.8604F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-35.9757F, 4.8845F, 8.8604F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-35.9757F, 4.8845F, 8.8604F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(7.4728F, 10.5827F, 45.1845F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(7.4728F, 10.5827F, 45.1845F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(15.2544F, 6.1199F, 102.8671F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(15.2544F, 6.1199F, 102.8671F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(7.7544F, 6.1199F, 102.8671F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-12.6338F, 10.3405F, 100.1577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-12.6338F, 10.3405F, 100.1577F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-19.8377F, 9.1247F, 9.1711F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-19.8377F, 9.1247F, 9.1711F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-19.8377F, 9.1247F, 9.1711F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-19.8377F, 9.1247F, 9.1711F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-51.7705F, 18.3606F, -64.0712F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-51.7705F, 18.3606F, -64.0712F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-50.564F, 4.3775F, -45.2867F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-50.564F, 4.3775F, -45.2867F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-50.564F, 4.3775F, -45.2867F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-50.564F, 4.3775F, -45.2867F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 62.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 62.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 62.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 62.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -1.15F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -34.13F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.76F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, -6.82F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 36.17F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -43.81F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.95F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 9.7F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 6.35F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.52F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 4.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, -3.95F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -31.45F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 55.42F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.9F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.degreeVec(0.0F, -2.79F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5417F, AdvancedKeyframeAnimations.degreeVec(-43.1606F, 0.9033F, -0.9972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(-43.1606F, 0.9033F, -0.9972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-19.2299F, 17.5391F, -19.3617F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-19.2299F, 17.5391F, -19.3617F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-19.2299F, 17.5391F, -19.3617F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-19.2299F, 17.5391F, -19.3617F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("halberd", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("halberd", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.49F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.49F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
					new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AdvancedAnimationDefinition DASH_ATTACK2 = AdvancedAnimationDefinition.Builder.withLength(3.5F)
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(39.49F, -30.0211F, -3.3502F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(39.49F, -30.0211F, -3.3502F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("root", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 20.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 12.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(9.9147F, -2.3465F, 11.9503F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-122.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-122.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-134.0822F, -5.306F, -3.8958F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -17.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.degreeVec(5.0F, 27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-20.3226F, -3.5226F, -4.9456F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.posVec(-0.0506F, -0.9206F, -0.3872F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(115.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(115.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(117.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(35.4079F, 9.969F, -5.0874F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(85.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(36.3391F, -24.9417F, -17.2344F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(36.3391F, -24.9417F, -17.2344F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-12.6652F, -27.0478F, 11.2431F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-12.6652F, -27.0478F, 11.2431F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-12.6652F, -27.0478F, 11.2431F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-20.3966F, -55.9234F, 22.5263F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(-18.0583F, -51.5254F, 18.7026F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(-13.1793F, -32.2327F, 11.5024F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.4167F, AdvancedKeyframeAnimations.degreeVec(-3.4968F, -39.72F, 12.0416F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-14.0876F, 4.6917F, 38.977F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-1.9758F, -15.8383F, -13.6272F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-5.04F, -24.919F, -2.6789F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-1.5215F, -25.349F, -10.951F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-2.1545F, -50.3369F, -9.9437F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-2.1545F, -50.3369F, -9.9437F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(-2.5454F, -60.0911F, -4.1611F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(-3.7259F, -70.0767F, -2.8643F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(4.1673F, -15.1843F, 5.2426F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-54.1335F, -21.9426F, 19.0958F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-54.1335F, -21.9426F, 19.0958F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-35.9757F, 4.8845F, 8.8604F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-54.8937F, -58.2216F, 55.492F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-14.9842F, -7.4899F, 32.603F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(-41.6364F, -20.3897F, 30.7178F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(-61.2336F, -31.3754F, 45.1113F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 17.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-24.6536F, -27.4769F, 49.7429F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(7.4728F, 10.5827F, 45.1845F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(7.4728F, 10.5827F, 45.1845F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(15.2544F, 6.1199F, 102.8671F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(15.2544F, 6.1199F, 102.8671F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(9.0688F, 1.6324F, 27.4375F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-18.3428F, -17.5201F, 16.4705F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-19.8377F, 9.1247F, 9.1711F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-19.8377F, 9.1247F, 9.1711F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-6.7666F, -22.5598F, 16.7496F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(52.9931F, -48.0296F, -50.4094F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(50.0994F, -24.6613F, -13.0826F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(49.0875F, -42.2275F, -0.2595F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, -12.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -12.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-51.7705F, 18.3606F, -64.0712F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-51.7705F, 18.3606F, -64.0712F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-50.564F, 4.3775F, -45.2867F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-50.564F, 4.3775F, -45.2867F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-50.65F, 1.1676F, -12.0792F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 62.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 62.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 62.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-27.5F, 62.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-5.7171F, 40.6852F, 8.243F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(11.4708F, 23.1921F, 7.6598F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(21.3651F, 29.482F, 9.4303F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(8.8651F, 29.482F, 9.4303F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, -2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-6.3612F, -35.6298F, 25.7174F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(6.7567F, -1.8724F, 18.7358F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-6.9288F, -31.0735F, 37.9939F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(6.4511F, -8.7125F, 25.7881F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 14.64F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 36.17F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -43.81F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, -24.35F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -3.53F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -65.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 6.35F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.52F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 57.46F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 64.64F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -31.45F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 55.42F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 89.28F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 64.64F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-1.3571F, -10.1984F, 7.6211F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(-17.1921F, -28.8791F, 8.4988F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(-22.1921F, -28.8791F, 8.4988F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-17.4521F, -12.2187F, 9.4783F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-43.1606F, 0.9033F, -0.9972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4167F, AdvancedKeyframeAnimations.degreeVec(-43.1606F, 0.9033F, -0.9972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-19.2299F, 17.5391F, -19.3617F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-19.2299F, 17.5391F, -19.3617F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(17.0908F, 17.7537F, -27.0559F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(20.0743F, 17.8317F, -29.8547F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(37.5743F, 17.8317F, -29.8547F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(40.5578F, 6.7474F, -15.9687F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("halberd", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 170.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.degreeVec(40.0F, 170.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-5.123F, 21.9386F, -103.4936F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-0.2271F, 37.3874F, 5.6181F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("halberd", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.49F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.49F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -14.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.posVec(-2.8363F, -0.2791F, 11.2065F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.3333F, AdvancedKeyframeAnimations.posVec(-1.4005F, -6.2279F, 3.4924F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, -8.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("halberd", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-0.7594F, 35.8939F, -5.0099F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-0.6475F, 56.4348F, -3.5899F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(-3.5525F, -22.9709F, -6.3623F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-6.1775F, -414.8431F, -1.3053F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -450.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(-1.7287F, -0.5451F, -0.1548F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.posVec(1.7215F, -2.4862F, 15.1254F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.posVec(4.4255F, -2.0833F, 20.9156F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("legs", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
					new AdvancedKeyframe(3.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
			))
			.build();
}