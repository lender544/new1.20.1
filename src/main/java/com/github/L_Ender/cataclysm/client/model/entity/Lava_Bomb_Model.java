package com.github.L_Ender.cataclysm.client.model.entity;

import com.github.L_Ender.cataclysm.entity.projectile.Lava_Bomb_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.phys.Vec3;

public class Lava_Bomb_Model extends AdvancedEntityModel<Lava_Bomb_Entity> {
    private final AdvancedModelBox root;


    public Lava_Bomb_Model() {
        texWidth = 64;
        texHeight = 64;

        root = new AdvancedModelBox(this);
        root.setRotationPoint(0.0F, 4F, 0.0F);



        root.setTextureOffset(0, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
        this.updateDefaultPose();
    }

    @Override
    public Iterable<BasicModelPart> parts() {
        return ImmutableList.of(root);
    }

    @Override
    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(root);
    }

    @Override
    public void setupAnim(Lava_Bomb_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        float delta = ageInTicks - entity.tickCount;
        Vec3 prevV = new Vec3(entity.prevDeltaMovementX, entity.prevDeltaMovementY, entity.prevDeltaMovementZ);
        Vec3 dv = prevV.add(entity.getDeltaMovement().subtract(prevV).scale(delta));
        double d = Math.sqrt(dv.x * dv.x + dv.y * dv.y + dv.z * dv.z);
        if (d != 0) {
            double a = dv.y / d;
            a = Math.max(-10, Math.min(1, a));
            float pitch = -(float) Math.asin(a);
            root.rotateAngleX = pitch + (float)Math.PI / 2f;

        }

    }




    public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
        AdvancedModelBox.rotateAngleX = x;
        AdvancedModelBox.rotateAngleY = y;
        AdvancedModelBox.rotateAngleZ = z;
    }
}