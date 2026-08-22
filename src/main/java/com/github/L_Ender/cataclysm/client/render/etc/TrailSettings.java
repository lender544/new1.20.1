package com.github.L_Ender.cataclysm.client.render.etc;

import org.joml.Vector3f;
//https://github.com/Violunae/arrowtrails/blob/d94f3866bbf33241e57e1166f7bd5351dbded68f/common/src/main/java/com/biverom/arrowtrails/TrailSettings.java
public record TrailSettings(int length, Vector3f startColor, float startAlpha, float startWidth, Vector3f endColor,
                            float endAlpha, float endWidth) {
}