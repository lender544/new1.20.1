package com.github.L_Ender.cataclysm.client.animation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public class SineWaveAnimationUtils {
	   
	public static void addSineWaveMotionToModelPart(ModelPart modelPart, float amount, float speed, float tick, float min, float max, float offset, float speedMultiplier, float amountMultiplier, SineWaveMotionTypes motionType) {
		float rotationMotion = Mth.clamp(Mth.cos(tick * (speedMultiplier * speed) + degToRad(offset)) * (Mth.PI / 180) * degToRad(amount), degToRad(min), degToRad(max));
		
		float motion = Mth.clamp(Mth.cos(tick * (speedMultiplier * speed) + offset) * amount, min, max);
		
		if (motionType == SineWaveMotionTypes.POSITION_Y) {
			motion = -motion;
		}
		
		affectModelPartBasedOnMotionType(modelPart, rotationMotion * amountMultiplier, motion * amountMultiplier, motionType);
	}
	
	public static void adjustPositionOfModelPart(ModelPart modelPart, float amount, float amountMultiplier, SineWaveMotionTypes motionType) {
		float newAmount = amount;
		float newPositionAmount = amount;
		
		if (motionType == SineWaveMotionTypes.POSITION_Y) {
			newPositionAmount = -newPositionAmount;
		}
		
		affectModelPartBasedOnMotionType(modelPart, degToRad(newAmount) * amountMultiplier, newPositionAmount * amountMultiplier, motionType);
	}
	
	public static float getSineWaveKeyframe(float amount, float speed, float tick, float min, float max, float offset) {
		return Mth.clamp(Mth.cos(tick * (1 * speed) + offset) * amount, min, max);
	}
	
	public static float getConstantMotionKeyframe(float speed, float tick) {
		return tick * speed;
	}
	
	public static void affectModelPartBasedOnMotionType(ModelPart modelPart, float rotationMotion, float motion, SineWaveMotionTypes motionType) {
		switch(motionType) {
		case ROTATION_X: {
			modelPart.xRot += rotationMotion;
			break;
		}		
		case ROTATION_Y: {
			modelPart.yRot += rotationMotion;
			break;
		}	
		case ROTATION_Z: {
			modelPart.zRot += rotationMotion;
			break;
		}	
		
		case POSITION_X: {
			modelPart.x += motion;
			break;
		}	
		case POSITION_Y: {
			modelPart.y += motion;
			break;
		}	
		case POSITION_Z: {
			modelPart.z += motion;
			break;
		}	
		
		case SCALE_X: {
			modelPart.xScale += motion;
			break;
		}	
		case SCALE_Y: {
			modelPart.yScale += motion;
			break;
		}	
		case SCALE_Z: {
			modelPart.zScale += motion;
			break;
		}	
		}
	}
	
	public static float tickAmountMultiplierChange(float value, boolean shouldPlay, float transitionSpeed) {
		float newValue = value;
		if (shouldPlay) {
			if (newValue < 1) {
				if (newValue + transitionSpeed > 1) {
					newValue = 1;
				} else {
					newValue = newValue + transitionSpeed;
				}
			}
		} else {
			if (newValue > 0) {
				if (newValue - transitionSpeed < 0) {
					newValue = 0;
				} else {
					newValue = newValue - transitionSpeed;
				}
			}
		}
		return newValue;
	}
	
	public static float getTick(int tick, boolean convertToRadians) {
		return convertToRadians ? (degToRad((tick + Minecraft.getInstance().getFrameTime())) / 20) : ((tick + Minecraft.getInstance().getFrameTime()) / 20);
	}

	private static float degToRad(float deg) {
		return deg * (Mth.PI / 180);
	}
	
}
