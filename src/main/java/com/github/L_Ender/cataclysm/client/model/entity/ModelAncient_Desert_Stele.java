package com.github.L_Ender.cataclysm.client.model.entity;

import com.github.L_Ender.cataclysm.entity.projectile.Ancient_Desert_Stele_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelPart;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class ModelAncient_Desert_Stele extends AdvancedEntityModel<Ancient_Desert_Stele_Entity> {
    private final AdvancedModelPart root;

    public ModelAncient_Desert_Stele() {
        texWidth = 64;
        texHeight = 64;

        root = new AdvancedModelPart(this);
        root.setRotationPoint(0.0F, 24.0F, 0.0F);
        root.setTextureOffset(0, 0).addBox(-7.0F, -22.0F, -7.0F, 14.0F, 20.0F, 14.0F, 0.0F, false);
        root.setTextureOffset(0, 34).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
        this.updateDefaultPose();
    }

    /**
     * Sets this entity's model rotation angles
     */
    public void setupAnim(Ancient_Desert_Stele_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    @Override
    public Iterable<BasicModelPart> parts() {
        return ImmutableList.of(root);
    }

    @Override
    public Iterable<AdvancedModelPart> getAllParts() {
        return ImmutableList.of(root);
    }

}