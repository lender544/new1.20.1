package com.github.L_Ender.cataclysm.client.animation;

import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationChannel;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationDefinition;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframe;
import com.github.L_Ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframeAnimations;

public class Maledictus_Attack_Animation {

    public static final AdvancedAnimationDefinition SPIN_SLASHES = AdvancedAnimationDefinition.Builder.withLength(3.375F)
            .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-55.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(-27.3601F, -11.2409F, -0.6685F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(13.7806F, 13.0646F, 12.0248F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(17.9237F, 11.6059F, 9.4214F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-10.0F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-25.1087F, -16.1024F, 7.3535F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(13.7806F, -13.0646F, -12.0248F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(-25.5611F, 2.4294F, -17.3926F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(-48.1393F, 3.0149F, -13.5827F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 47.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-17.2299F, -43.7154F, 6.7609F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-13.2626F, -45.9977F, 11.3193F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-14.861F, -46.7868F, 11.5336F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(18.4209F, -36.6955F, 1.523F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.0417F, AdvancedKeyframeAnimations.degreeVec(16.5F, -60.4096F, -4.6042F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(26.7609F, -58.9937F, -6.5632F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.7083F, AdvancedKeyframeAnimations.degreeVec(27.4753F, -43.5101F, -1.3367F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(54.1485F, 58.5236F, 72.6627F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(92.8031F, 35.8795F, 113.2354F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(118.8811F, 30.6357F, 156.1087F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-63.7006F, -8.2574F, -13.2431F), AdvancedAnimationChannel.Interpolations.LINEAR),
                    new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-68.7112F, -30.4912F, -25.0118F), AdvancedAnimationChannel.Interpolations.LINEAR),
                    new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-107.9845F, 77.3689F, -45.6422F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.0417F, AdvancedKeyframeAnimations.degreeVec(-49.8082F, -65.6055F, -11.8729F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-56.9454F, -58.8864F, 25.3604F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-123.1352F, 76.8516F, -48.3026F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-167.012F, 72.1834F, -94.1085F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-119.3331F, 35.9391F, -103.9076F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(3.0135F, 35.0138F, -63.456F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.2917F, AdvancedKeyframeAnimations.degreeVec(31.6426F, 0.9346F, -31.27F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(57.0986F, -56.926F, -118.212F), AdvancedAnimationChannel.Interpolations.LINEAR),
                    new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(37.7216F, -69.7726F, -113.3639F), AdvancedAnimationChannel.Interpolations.LINEAR),
                    new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(57.3648F, -34.6103F, -64.3733F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(92.3648F, -34.6103F, -64.3733F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.625F, AdvancedKeyframeAnimations.degreeVec(91.7135F, -25.134F, -81.4721F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-1.867F, 27.3866F, 2.5978F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(-2.2587F, 17.4313F, 1.5741F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(-2.4571F, -7.4713F, -0.6574F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-2.3246F, -14.9416F, -1.3378F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(8.72F, -29.7082F, -3.8653F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(25.1632F, -49.6553F, -17.6214F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.7083F, AdvancedKeyframeAnimations.degreeVec(7.4385F, -10.4402F, -4.7908F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 37.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 85.37F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 97.07F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 7.41F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -8.04F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-4.3045F, -45.4622F, 10.8707F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -67.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, -43.66F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.86F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -1.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -115.02F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -90.36F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 48.86F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -4.38F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -41.98F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.1F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -28.15F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(0.0F, 60.22F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 75.33F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 73.89F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 20.26F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 42.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(5.0F, 42.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -132.5F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                    new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -132.5F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                    new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -340.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(0.0F, -370.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.0833F, AdvancedKeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.posVec(0.0F, -4.13F, -1.53F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(30.6538F, -0.0029F, -1.6857F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(27.48F, -0.0024F, -1.4147F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.2917F, AdvancedKeyframeAnimations.degreeVec(47.3161F, 1.7467F, 3.3076F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(8.0754F, 24.8858F, 1.7846F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(8.4474F, 29.834F, 2.5933F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(7.4306F, -9.8141F, -2.9057F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(5.1484F, 36.8127F, 8.2754F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(3.0065F, 6.4952F, 5.7016F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(11.5693F, -44.8252F, -2.4366F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(20.1175F, -53.2065F, -6.182F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.7083F, AdvancedKeyframeAnimations.degreeVec(7.8172F, -41.9097F, 3.6781F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(7.5F, -17.5F, 7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(18.3697F, -0.358F, -17.8432F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(38.7334F, 70.8131F, 28.8568F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(16.3405F, 17.501F, -2.7402F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(90.2461F, 79.4086F, 44.7539F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(104.6359F, 61.2067F, 34.8086F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(27.5F, 52.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.9167F, AdvancedKeyframeAnimations.degreeVec(62.6452F, 30.4553F, 1.206F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(72.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(35.1767F, -29.784F, -19.2953F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                    new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.5833F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(54.7086F, -1.4597F, -6.5141F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.1667F, AdvancedKeyframeAnimations.degreeVec(37.6056F, -3.9649F, -3.0487F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.4583F, AdvancedKeyframeAnimations.degreeVec(75.0479F, -30.661F, -27.0585F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(24.6068F, -17.1687F, -19.8613F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.7083F, AdvancedKeyframeAnimations.degreeVec(86.0631F, -16.121F, -19.5254F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.7917F, AdvancedKeyframeAnimations.degreeVec(75.8558F, -16.8052F, -20.0638F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(1.9583F, AdvancedKeyframeAnimations.degreeVec(92.1068F, -17.1687F, -19.8613F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(2.2083F, AdvancedKeyframeAnimations.degreeVec(124.6068F, -17.1687F, -19.8613F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                    new AdvancedKeyframe(3.375F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

        public static final AdvancedAnimationDefinition COMBO_FIRST = AdvancedAnimationDefinition.Builder.withLength(1.3333F)
                .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, -22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-7.816F, -26.6824F, 3.1145F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-7.816F, -26.6824F, 3.1145F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.posVec(0.0F, -11.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -11.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-48.0645F, 7.4965F, 6.8998F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-48.0645F, 7.4965F, 6.8998F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(-88.0645F, 7.4965F, 6.8998F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-90.5645F, 7.4965F, 6.8998F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-90.5645F, 7.4965F, 6.8998F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(47.396F, -1.41F, 0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(57.396F, -1.41F, 0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(49.896F, -1.41F, 0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(82.396F, -1.41F, 0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(84.896F, -1.41F, 0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(84.896F, -1.41F, 0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(18.8912F, 8.4214F, -26.4849F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-13.5684F, -15.0141F, -35.6115F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-13.5684F, -15.0141F, -35.6115F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(15.3934F, 11.9515F, -8.3173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(12.8934F, 11.9515F, -8.3173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(12.8934F, 11.9515F, -8.3173F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(7.5F, -50.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(23.7827F, -56.9644F, -4.6971F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(8.0924F, -59.7427F, 13.6851F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(16.2246F, -38.1084F, 5.3984F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(24.5601F, -40.3899F, 4.0781F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(24.5601F, -40.3899F, 4.0781F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-5.2963F, 27.4699F, -0.7346F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-11.6016F, 41.2369F, -12.382F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-5.0201F, 8.8922F, -8.7974F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(4.9208F, -1.0707F, -9.6612F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(4.661F, -1.908F, 0.3071F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(13.5118F, -23.012F, -14.7919F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(19.2804F, -27.743F, -16.5836F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(19.2804F, -27.743F, -16.5836F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(12.8947F, 23.6832F, 8.5673F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(41.7745F, 21.5369F, 36.8571F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-105.1668F, 37.2485F, 4.4338F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-200.1337F, 58.3556F, -42.9235F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-160.1337F, 58.3556F, -42.9235F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(-67.6118F, 45.8556F, -42.8982F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-77.2965F, 49.0534F, -54.7185F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-77.2965F, 49.0534F, -54.7185F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(5.4925F, -3.8711F, 9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-39.5075F, -3.8711F, 9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(5.4925F, -3.8711F, 9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(7.9925F, -3.8711F, 9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(7.9925F, -3.8711F, 9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-81.8677F, 65.4096F, 31.1685F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-76.3126F, 25.4917F, 53.1238F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-75.6338F, -28.8101F, 25.4371F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-59.9265F, -53.0106F, 4.9724F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-23.0547F, -23.3258F, -53.8303F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(10.7429F, -19.7239F, -84.4303F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(14.1661F, -17.1521F, -92.2628F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(14.1661F, -17.1521F, -92.2628F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(5.0F, 65.0F, -17.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(2.7581F, 40.0509F, -20.2581F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(92.5F, 20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(145.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(121.1136F, -47.9366F, 50.8895F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(113.2412F, -51.3742F, 61.2021F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(113.2412F, -51.3742F, 61.2021F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-2.4571F, -7.4713F, -0.6574F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-2.0904F, 22.4097F, 2.0675F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.2508F, 49.7409F, 5.9299F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.2508F, 49.7409F, 5.9299F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(11.9937F, 44.4225F, 8.456F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(19.8332F, 40.0234F, 5.2439F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(19.8332F, 40.0234F, 5.2439F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-0.5351F, 29.9929F, 31.6504F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(-26.606F, 24.0983F, -2.1641F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-35.0658F, 34.7544F, -12.8558F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-11.3993F, 53.742F, 14.5592F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-51.2594F, 45.1678F, -27.0871F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(16.8538F, -13.1881F, -17.342F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 38.43F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 112.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 55.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AdvancedAnimationDefinition COMBO_FIRST_END = AdvancedAnimationDefinition.Builder.withLength(0.6667F)
                .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -11.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.posVec(0.0F, -11.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-90.5645F, 7.4965F, 6.8998F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-90.5645F, 7.4965F, 6.8998F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(84.896F, -1.41F, 0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(84.896F, -1.41F, 0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.8934F, 11.9515F, -8.3173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(12.8934F, 11.9515F, -8.3173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(24.5601F, -40.3899F, 4.0781F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(24.5601F, -40.3899F, 4.0781F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(19.2804F, -27.743F, -16.5836F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(19.2804F, -27.743F, -16.5836F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-77.2965F, 49.0534F, -54.7185F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-77.2965F, 49.0534F, -54.7185F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(7.9925F, -3.8711F, 9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(7.9925F, -3.8711F, 9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(14.1661F, -17.1521F, -92.2628F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(14.1661F, -17.1521F, -92.2628F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(113.2412F, -51.3742F, 61.2021F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(113.2412F, -51.3742F, 61.2021F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(19.8332F, 40.0234F, 5.2439F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(19.8332F, 40.0234F, 5.2439F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-51.2594F, 45.1678F, -27.0871F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(-51.2594F, 45.1678F, -27.0871F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.2917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AdvancedAnimationDefinition COMBO_SECOND = AdvancedAnimationDefinition.Builder.withLength(2.25F)
                .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-2.5F, -15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-15.0F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-7.816F, 26.6824F, -3.1145F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-7.816F, 26.6824F, -3.1145F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, -11.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.posVec(0.0F, -11.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.posVec(0.0F, -11.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-90.5645F, 7.4965F, 6.8998F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(18.8912F, -8.4214F, 26.4849F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-13.5684F, 15.0141F, 35.6115F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-13.5684F, 15.0141F, 35.6115F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(15.3934F, -11.9515F, 8.3173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(12.8934F, -11.9515F, 8.3173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(12.8934F, -11.9515F, 8.3173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(84.896F, -1.41F, 0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(49.896F, -1.41F, 0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(12.8934F, 11.9515F, -8.3173F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-48.0645F, -7.4965F, -6.8998F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-48.0645F, -7.4965F, -6.8998F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(-88.0645F, -7.4965F, -6.8998F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-90.5645F, -7.4965F, -6.8998F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-90.5645F, -7.4965F, -6.8998F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(47.396F, 1.41F, -0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(57.396F, 1.41F, -0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(49.896F, 1.41F, -0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(82.396F, 1.41F, -0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(84.896F, 1.41F, -0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(84.896F, 1.41F, -0.1972F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(24.5601F, -40.3899F, 4.0781F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(7.5F, 50.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(23.7827F, 56.9644F, 4.6971F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(8.0924F, 59.7427F, -13.6851F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(16.2246F, 38.1084F, -5.3984F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(24.5601F, 40.3899F, -4.0781F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(24.5601F, 40.3899F, -4.0781F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(19.2804F, -27.743F, -16.5836F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-5.2963F, -27.4699F, 0.7346F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-11.6016F, -41.2369F, 12.382F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-5.0201F, -8.8922F, 8.7974F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(4.9208F, 1.0707F, 9.6612F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(4.661F, 1.908F, -0.3071F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(13.5118F, 23.012F, 14.7919F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(19.2804F, 27.743F, 16.5836F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(19.2804F, 27.743F, 16.5836F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-77.2965F, 49.0534F, -54.7185F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-81.8677F, -65.4096F, -31.1685F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-76.3126F, -25.4917F, -53.1238F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-75.6338F, 28.8101F, -25.4371F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-59.9265F, 53.0106F, -4.9724F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-23.0547F, 23.3258F, 53.8303F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(10.7429F, 19.7239F, 84.4303F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(14.1661F, 17.1521F, 92.2628F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(14.1661F, 17.1521F, 92.2628F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(5.0F, -65.0F, 17.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(2.7581F, -40.0509F, 20.2581F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(7.9925F, -3.8711F, 9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(92.5F, -20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(5.4925F, -3.8711F, 9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-39.5075F, -3.8711F, 9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(145.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(121.1136F, 47.9366F, -50.8895F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(113.2412F, 51.3742F, -61.2021F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(113.2412F, 51.3742F, -61.2021F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(14.1661F, -17.1521F, -92.2628F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(12.8947F, -23.6832F, -8.5673F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(41.7745F, -21.5369F, -36.8571F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-105.1668F, -37.2485F, -4.4338F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-200.1337F, -58.3556F, 42.9235F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-160.1337F, -58.3556F, 42.9235F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(-67.6118F, -45.8556F, 42.8982F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-77.2965F, -49.0534F, 54.7185F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-77.2965F, -49.0534F, 54.7185F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(2.7581F, 40.0509F, -20.2581F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(113.2412F, -51.3742F, 61.2021F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(92.5F, 20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(5.4925F, 3.8711F, -9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-39.5075F, 3.8711F, -9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(145.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(5.4925F, 3.8711F, -9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(7.9925F, 3.8711F, -9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(7.9925F, 3.8711F, -9.4351F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(19.8332F, 40.0234F, 5.2439F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.3333F, AdvancedKeyframeAnimations.degreeVec(-2.4571F, 7.4713F, 0.6574F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.6667F, AdvancedKeyframeAnimations.degreeVec(-2.0904F, -22.4097F, -2.0675F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(0.2508F, -49.7409F, -5.9299F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.2508F, -49.7409F, -5.9299F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(11.9937F, -44.4225F, -8.456F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(19.8332F, -40.0234F, -5.2439F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(19.8332F, -40.0234F, -5.2439F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-51.2594F, 45.1678F, -27.0871F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 40.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(16.8538F, 13.1881F, 17.342F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -38.43F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, -112.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -55.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(-0.5351F, -29.9929F, -31.6504F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(-26.606F, -24.0983F, 2.1641F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-35.0658F, -34.7544F, 12.8558F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-11.3993F, -53.742F, -14.5592F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-51.2594F, -45.1678F, 27.0871F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 52.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7083F, AdvancedKeyframeAnimations.degreeVec(0.0F, 37.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 52.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 20.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();



        public static final AdvancedAnimationDefinition UPPERCUT_RIGHT = AdvancedAnimationDefinition.Builder.withLength(3.0F)
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-2.546F, 4.9971F, 12.3222F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-10.046F, 4.9971F, 12.3222F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-35.046F, 4.9971F, 12.3222F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-48.3727F, 16.5066F, 22.8208F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-101.2423F, -8.7081F, 9.4666F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-116.2423F, -8.7081F, 9.4666F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-93.7423F, -8.7081F, 9.4666F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-96.2423F, -8.7081F, 9.4666F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-96.2423F, -8.7081F, 9.4666F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-13.363F, -23.2831F, -19.5113F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-9.7615F, -24.2389F, -25.5981F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-5.2173F, 6.26F, 6.5729F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-7.7173F, 6.26F, 6.5729F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(18.7982F, 4.8598F, -5.9404F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(8.7982F, 4.8598F, -5.9404F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-22.7605F, 4.9064F, 7.2979F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-17.7605F, 4.9064F, 7.2979F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-17.7605F, 4.9064F, 7.2979F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-9.7431F, -19.9612F, 2.11F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-19.1461F, -31.8424F, 6.4413F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-17.0462F, -40.5201F, 3.4486F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-24.5462F, -40.5201F, 3.4486F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(3.3306F, 15.9013F, -18.5191F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(5.8306F, 15.9013F, -18.5191F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(5.8306F, 15.9013F, -18.5191F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(55.0F, 0.0F, 47.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(65.0F, 0.0F, 47.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(67.5F, 0.0F, 47.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-154.8512F, 52.8687F, -10.0425F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-162.3512F, 52.8687F, -10.0425F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-146.2872F, -4.0686F, -15.6979F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-127.9445F, -28.0422F, -18.0791F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-122.9445F, -28.0422F, -18.0791F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-122.9445F, -28.0422F, -18.0791F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-71.5454F, -15.6118F, -12.7417F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(15.65F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-38.15F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(9.19F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(16.2738F, 43.7995F, -18.9744F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(13.5571F, 50.5619F, -15.3344F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(23.3174F, -26.0528F, -40.5167F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(36.8322F, -19.0543F, -52.4952F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(36.8322F, -19.0543F, -52.4952F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(36.8322F, -19.0543F, -52.4952F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(41.8322F, -19.0543F, -52.4952F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(41.8322F, -19.0543F, -52.4952F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(5.5544F, 0.0591F, -20.6729F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(30.7428F, 34.1624F, -8.1206F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-2.0904F, -22.4097F, -2.0675F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(4.2673F, -42.3005F, -4.5662F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(1.7467F, -20.1632F, 0.2029F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(4.5939F, 43.9504F, 11.8732F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(12.0939F, 43.9504F, 11.8732F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-15.5126F, 15.1844F, 1.8678F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-33.3929F, 5.7347F, -9.393F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-33.3929F, 5.7347F, -9.393F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 62.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 86.62F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-17.3589F, 42.2003F, -7.5391F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(-12.7744F, 22.8399F, -2.7932F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-6.4978F, -16.721F, 2.6817F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -57.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -66.69F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -15.67F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -31.9F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -56.68F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -20.18F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(67.4455F, -57.5033F, -78.0484F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(100.104F, -53.6436F, -111.058F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(38.8655F, -29.2877F, -42.038F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 32.15F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 79.56F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 53.29F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 119.9F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-2.7554F, -24.9722F, 1.2731F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-2.7554F, -24.9722F, 1.2731F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(27.4569F, 0.0478F, -0.4586F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(27.4569F, 0.0478F, -0.4586F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(27.4569F, 0.0478F, -0.4586F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(-1.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(-0.39F, -1.71F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.posVec(0.0F, -6.0F, -3.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, -7.2F, -3.6F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, -7.2F, -3.6F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(62.584F, 0.3393F, 0.5387F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(62.584F, 0.3393F, 0.5387F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-5.0F, 10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-6.35F, 22.1953F, -3.8581F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-8.667F, -17.5851F, 0.419F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-14.4971F, -34.769F, 18.328F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-20.8013F, -39.4637F, 20.4874F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-28.6783F, -36.4674F, 29.2144F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(36.5597F, -23.6663F, 4.2462F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(41.5597F, -23.6663F, 4.2462F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(41.5597F, -23.6663F, 4.2462F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(71.8716F, 2.871F, -2.3881F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(102.1028F, 3.0836F, -2.565F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(9.3716F, 2.871F, -2.3881F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-0.6284F, 2.871F, -2.3881F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(12.7975F, 2.871F, -2.3881F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(66.8716F, 2.871F, -2.3881F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(49.3716F, 2.871F, -2.3881F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(56.8716F, 2.871F, -2.3881F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(48.3353F, 1.2726F, -1.0586F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(23.6491F, 10.7195F, 8.1887F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-4.4F, 30.6689F, 6.6584F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-13.4733F, 40.4269F, 3.9623F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-13.4733F, 40.4269F, 3.9623F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-16.238F, 40.0449F, 3.4609F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-16.238F, 40.0449F, 3.4609F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(5.559F, 7.3687F, 0.374F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AdvancedAnimationDefinition UPPERCUT_LEFT = AdvancedAnimationDefinition.Builder.withLength(3.0F)
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-13.363F, 23.2831F, 19.5113F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-9.7615F, 24.2389F, 25.5981F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-5.2173F, -6.26F, -6.5729F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-7.7173F, -6.26F, -6.5729F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(18.7982F, -4.8598F, 5.9404F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(8.7982F, -4.8598F, 5.9404F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-22.7605F, -4.9064F, -7.2979F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-17.7605F, -4.9064F, -7.2979F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-17.7605F, -4.9064F, -7.2979F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-2.546F, -4.9971F, -12.3222F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-10.046F, -4.9971F, -12.3222F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-35.046F, -4.9971F, -12.3222F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-48.3727F, -16.5066F, -22.8208F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-101.2423F, 8.7081F, -9.4666F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-116.2423F, 8.7081F, -9.4666F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-93.7423F, 8.7081F, -9.4666F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-96.2423F, 8.7081F, -9.4666F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-96.2423F, 8.7081F, -9.4666F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-2.5F, -32.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-9.7431F, 19.9612F, -2.11F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-19.1461F, 31.8424F, -6.4413F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-17.0462F, 40.5201F, -3.4486F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-24.5462F, 40.5201F, -3.4486F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(3.3306F, -15.9013F, 18.5191F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(5.8306F, -15.9013F, 18.5191F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(5.8306F, -15.9013F, 18.5191F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(16.2738F, -43.7995F, 18.9744F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(13.5571F, -50.5619F, 15.3344F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(67.5F, 0.0F, 47.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(23.3174F, 26.0528F, 40.5167F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(36.8322F, 19.0543F, 52.4952F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(36.8322F, 19.0543F, 52.4952F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-146.2872F, -4.0686F, -15.6979F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(36.8322F, 19.0543F, 52.4952F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(41.8322F, 19.0543F, 52.4952F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(41.8322F, 19.0543F, 52.4952F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(5.5544F, -0.0591F, 20.6729F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(15.65F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-38.15F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(30.7428F, -34.1624F, 8.1206F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("halberd", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(55.0F, 0.0F, -47.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(65.0F, 0.0F, -47.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(67.5F, 0.0F, -47.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(23.3174F, -26.0528F, -40.5167F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-154.8512F, -52.8687F, 10.0425F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-162.3512F, -52.8687F, 10.0425F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-146.2872F, 4.0686F, 15.6979F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-127.9445F, 28.0422F, 18.0791F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-122.9445F, 28.0422F, 18.0791F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-122.9445F, 28.0422F, 18.0791F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(-71.5454F, 15.6118F, 12.7417F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(15.65F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(-38.15F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(9.19F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-2.0904F, 22.4097F, 2.0675F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(4.2673F, 42.3005F, 4.5662F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(1.7467F, 20.1632F, -0.2029F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(4.5939F, -43.9504F, -11.8732F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(12.0939F, -43.9504F, -11.8732F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-15.5126F, -15.1844F, -1.8678F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-33.3929F, -5.7347F, 9.393F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-33.3929F, -5.7347F, 9.393F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 20.18F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(67.4455F, 57.5033F, 78.0484F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(100.104F, 53.6436F, 111.058F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(38.8655F, 29.2877F, 42.038F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -32.15F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, -79.56F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -53.29F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, -119.9F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -62.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, -86.62F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-17.3589F, -42.2003F, 7.5391F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(-12.7744F, -22.8399F, 2.7932F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(-6.4978F, 16.721F, -2.6817F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 57.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(0.0F, 66.69F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.67F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 31.9F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.875F, AdvancedKeyframeAnimations.degreeVec(0.0F, 56.68F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(0.0F, -2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-2.5F, -2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-2.7554F, 24.9722F, -1.2731F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-2.7554F, 24.9722F, -1.2731F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(27.4569F, -0.0478F, 0.4586F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(27.4569F, -0.0478F, 0.4586F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(27.4569F, -0.0478F, 0.4586F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.posVec(1.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.8333F, AdvancedKeyframeAnimations.posVec(0.39F, -1.71F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.posVec(0.0F, -6.0F, -3.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.posVec(0.0F, -7.2F, -3.6F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.posVec(0.0F, -7.2F, -3.6F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(62.584F, -0.3393F, -0.5387F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(62.584F, -0.3393F, -0.5387F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(-5.0F, -10.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-6.35F, -22.1953F, 3.8581F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9583F, AdvancedKeyframeAnimations.degreeVec(-8.667F, 17.5851F, -0.419F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-14.4971F, 34.769F, -18.328F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-20.8013F, 39.4637F, -20.4874F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-28.6783F, 36.4674F, -29.2144F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(36.5597F, 23.6663F, -4.2462F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(41.5597F, 23.6663F, -4.2462F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(41.5597F, 23.6663F, -4.2462F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(71.8716F, 2.871F, -2.3881F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(102.1028F, 3.0836F, -2.565F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(23.6491F, -10.7195F, -8.1887F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(-4.4F, -30.6689F, -6.6584F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-13.4733F, -40.4269F, -3.9623F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(12.7975F, 2.871F, -2.3881F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(-13.4733F, -40.4269F, -3.9623F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(-16.238F, -40.0449F, -3.4609F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(-16.238F, -40.0449F, -3.4609F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(5.559F, -7.3687F, -0.374F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.625F, AdvancedKeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.7917F, AdvancedKeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.875F, AdvancedKeyframeAnimations.degreeVec(71.8716F, -2.871F, 2.3881F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(102.1028F, -3.0836F, 2.565F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(23.6491F, 10.7195F, 8.1887F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.25F, AdvancedKeyframeAnimations.degreeVec(9.3716F, -2.871F, 2.3881F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5417F, AdvancedKeyframeAnimations.degreeVec(-0.6284F, -2.871F, 2.3881F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.625F, AdvancedKeyframeAnimations.degreeVec(12.7975F, -2.871F, 2.3881F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(1.6667F, AdvancedKeyframeAnimations.degreeVec(66.8716F, -2.871F, 2.3881F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(49.3716F, -2.871F, 2.3881F), AdvancedAnimationChannel.Interpolations.LINEAR),
                        new AdvancedKeyframe(2.5417F, AdvancedKeyframeAnimations.degreeVec(56.8716F, -2.871F, 2.3881F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.75F, AdvancedKeyframeAnimations.degreeVec(48.3353F, -1.2726F, 1.0586F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(3.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AdvancedAnimationDefinition HALBERD_SLASH = AdvancedAnimationDefinition.Builder.withLength(2.5F)
                .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 2.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-0.2031F, -22.4751F, 1.1431F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-0.1942F, -14.9751F, 1.1157F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-0.1892F, -7.4752F, 1.0901F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-0.1878F, -2.4752F, 1.0736F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("berserker", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(-0.9021F, -0.61F, 2.8312F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(-0.0015F, -0.7992F, -0.0349F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(-0.1935F, -5.4184F, -4.4609F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.posVec(-0.1935F, -5.4184F, -4.4609F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(18.0087F, -0.7854F, 2.4273F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(-121.9913F, -0.7854F, 2.4273F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-69.4913F, -0.7854F, 2.4273F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-69.4913F, -0.7854F, 2.4273F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-70.8867F, 4.1698F, -3.9259F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-70.8867F, 4.1698F, -3.9259F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(110.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, -7.5F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(1.3998F, 4.7632F, 1.1226F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(19.4681F, 6.4528F, -3.6176F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(27.3456F, 8.779F, -8.0599F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(22.3456F, 8.779F, -8.0599F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(22.3456F, 8.779F, -8.0599F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_leg", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("pelvis", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-5.0F, -12.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-6.0719F, 11.9253F, -7.2525F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-8.8853F, 28.639F, -14.9571F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-8.8853F, 28.639F, -14.9571F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-2.5F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(-5.1307F, -24.9925F, 0.3599F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-7.3716F, 17.3602F, -3.2693F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(1.1472F, 35.381F, 9.3934F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(1.1472F, 35.381F, 9.3934F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-55.6013F, -60.9823F, 46.1946F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(-71.3341F, -15.8054F, 23.2107F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(24.1296F, -33.553F, 52.0026F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(45.7246F, -14.2956F, 76.141F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(87.363F, -4.9813F, 97.0754F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(85.8666F, -3.1301F, 72.0988F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(85.8666F, -3.1301F, 72.0988F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-22.73F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(17.27F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bow", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("halberd", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(5.0F, -17.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-13.1017F, -19.9991F, -1.7761F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(17.5351F, 9.2901F, -8.3709F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("halberd", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.posVec(6.2624F, -1.9924F, -19.8618F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(4.0684F, 3.3694F, -13.3011F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.posVec(-0.6666F, -3.1098F, -10.5474F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-7.2849F, -30.3706F, -22.3529F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(-145.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-74.6133F, 39.775F, 6.5053F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(-53.489F, 56.8548F, 9.8263F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(-71.9623F, 75.1981F, 26.5312F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(-69.0163F, 77.425F, 29.6888F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(-69.0163F, 77.425F, 29.6888F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_shoulder", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.posVec(-2.9593F, -0.8626F, -2.5492F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_front_arm", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(-107.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0F, AdvancedKeyframeAnimations.degreeVec(-36.4651F, -0.2253F, -2.77F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0417F, AdvancedKeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(13.5295F, 3.0414F, 37.3946F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.3333F, AdvancedKeyframeAnimations.degreeVec(13.96F, 3.5333F, 44.8908F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.75F, AdvancedKeyframeAnimations.degreeVec(13.96F, 3.5333F, 44.8908F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_mace", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.2901F, 24.3187F, 7.7901F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.9167F, AdvancedKeyframeAnimations.degreeVec(5.2901F, 24.3187F, 7.7901F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.125F, AdvancedKeyframeAnimations.degreeVec(4.2501F, -2.0753F, -0.5331F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 79.6F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 90.06F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 55.68F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("left_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, -46.38F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -19.82F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, -18.25F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_wing", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 22.21F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, -2.23F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 15.48F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("right_wing2", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.ROTATION,
                        new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(0.75F, AdvancedKeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.0833F, AdvancedKeyframeAnimations.degreeVec(0.0F, 47.19F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(1.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 31.22F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.0F, AdvancedKeyframeAnimations.degreeVec(0.0F, 79.3F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM),
                        new AdvancedKeyframe(2.5F, AdvancedKeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        
}
