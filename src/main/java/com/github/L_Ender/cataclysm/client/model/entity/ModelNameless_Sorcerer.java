package com.github.L_Ender.cataclysm.client.model.entity;

import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Nameless_Sorcerer_Entity;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.AbstractIllager;


public class ModelNameless_Sorcerer extends AdvancedEntityModel<Nameless_Sorcerer_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox head;
    private final AdvancedModelBox headwear;
    private final AdvancedModelBox nose;
    private final AdvancedModelBox body;
    private final AdvancedModelBox bodywear;
    private final AdvancedModelBox right_leg;
    private final AdvancedModelBox left_leg;
    private final AdvancedModelBox right_arm;
    private final AdvancedModelBox book;
    private final AdvancedModelBox cover_right;
    private final AdvancedModelBox cover_left;
    private final AdvancedModelBox filpping_page_right;
    private final AdvancedModelBox page_right;
    private final AdvancedModelBox page_left;
    private final AdvancedModelBox filpping_page_left;
    private final AdvancedModelBox left_arm;

    private ModelAnimator animator;

    public ModelNameless_Sorcerer() {
        texWidth = 128;
        texHeight = 128;

        root = new AdvancedModelBox(this);
        root.setRotationPoint(0.0F, 24.0F, 0.0F);


        head = new AdvancedModelBox(this);
        head.setRotationPoint(0.0F, -24.0F, 0.0F);
        root.addChild(head);
        head.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, 0.0F, false);

        headwear = new AdvancedModelBox(this);
        headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(headwear);
        headwear.setTextureOffset(32, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, 0.25F, false);

        nose = new AdvancedModelBox(this);
        nose.setRotationPoint(0.0F, -2.0F, 0.0F);
        head.addChild(nose);
        nose.setTextureOffset(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        body = new AdvancedModelBox(this);
        body.setRotationPoint(0.0F, -24.0F, 0.0F);
        root.addChild(body);
        body.setTextureOffset(16, 20).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, 0.0F, false);

        bodywear = new AdvancedModelBox(this);
        bodywear.setRotationPoint(0.0F, -24.0F, 0.0F);
        root.addChild(bodywear);
        bodywear.setTextureOffset(0, 38).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 18.0F, 6.0F, 0.5F, false);

        right_leg = new AdvancedModelBox(this);
        right_leg.setRotationPoint(-2.0F, -12.0F, 0.0F);
        root.addChild(right_leg);
        right_leg.setTextureOffset(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

        left_leg = new AdvancedModelBox(this);
        left_leg.setRotationPoint(2.0F, -12.0F, 0.0F);
        root.addChild(left_leg);
        left_leg.setTextureOffset(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        right_arm = new AdvancedModelBox(this);
        right_arm.setRotationPoint(-4.0F, -22.0F, 0.0F);
        root.addChild(right_arm);
        right_arm.setTextureOffset(40, 46).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        book = new AdvancedModelBox(this);
        book.setRotationPoint(-2.0F, 14.5F, 5.0F);
        right_arm.addChild(book);
        book.setTextureOffset(19, 55).addBox(-1.0F, 0.0F, -10.0F, 2.0F, 0.0F, 10.0F, 0.0F, false);

        cover_right = new AdvancedModelBox(this);
        cover_right.setRotationPoint(-1.0F, 0.0F, -5.0F);
        book.addChild(cover_right);
        setRotationAngle(cover_right, 0.0F, 0.0F, 1.5708F);
        cover_right.setTextureOffset(35, 27).addBox(-6.0F, 0.0F, -5.0F, 6.0F, 0.0F, 10.0F, 0.0F, false);

        cover_left = new AdvancedModelBox(this);
        cover_left.setRotationPoint(1.0F, 0.0F, -5.0F);
        book.addChild(cover_left);
        setRotationAngle(cover_left, 0.0F, 0.0F, -1.5708F);
        cover_left.setTextureOffset(47, 27).addBox(0.0F, 0.0F, -5.0F, 6.0F, 0.0F, 10.0F, 0.0F, false);

        filpping_page_right = new AdvancedModelBox(this);
        filpping_page_right.setRotationPoint(0.0F, -0.075F, -5.0F);
        book.addChild(filpping_page_right);
        setRotationAngle(filpping_page_right, 0.0F, 0.0F, 1.5708F);
        filpping_page_right.setTextureOffset(49, 46).addBox(-5.0F, -0.025F, -4.0F, 5.0F, 0.0F, 8.0F, 0.0F, false);

        page_right = new AdvancedModelBox(this);
        page_right.setRotationPoint(0.0F, -0.075F, -5.0F);
        book.addChild(page_right);
        setRotationAngle(page_right, 0.0F, 0.0F, 1.5708F);
        page_right.setTextureOffset(65, 0).addBox(-5.0F, -0.025F, -4.0F, 5.0F, 1.0F, 8.0F, 0.0F, false);

        page_left = new AdvancedModelBox(this);
        page_left.setRotationPoint(0.0F, -0.075F, -5.0F);
        book.addChild(page_left);
        setRotationAngle(page_left, 0.0F, 0.0F, -1.5708F);
        page_left.setTextureOffset(65, 9).addBox(0.0F, -0.025F, -4.0F, 5.0F, 1.0F, 8.0F, 0.0F, false);

        filpping_page_left = new AdvancedModelBox(this);
        filpping_page_left.setRotationPoint(0.0F, -0.075F, -5.0F);
        book.addChild(filpping_page_left);
        setRotationAngle(filpping_page_left, 0.0F, 0.0F, -1.5708F);
        filpping_page_left.setTextureOffset(49, 54).addBox(0.0F, -0.025F, -4.0F, 5.0F, 0.0F, 8.0F, 0.0F, false);

        left_arm = new AdvancedModelBox(this);
        left_arm.setRotationPoint(4.0F, -22.0F, 0.0F);
        root.addChild(left_arm);
        left_arm.setTextureOffset(40, 46).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
        animator = ModelAnimator.create();
        this.updateDefaultPose();
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4) {
        this.resetToDefaultPose();
    }

    @Override
    public void setupAnim(Nameless_Sorcerer_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
        this.right_leg.rotateAngleX = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.left_leg.rotateAngleX = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        float f = 1.0F;
        this.right_arm.rotateAngleX += Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
        this.left_arm.rotateAngleX += Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
        this.right_arm.rotateAngleZ += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.left_arm.rotateAngleZ -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.right_arm.rotateAngleX += Mth.sin(ageInTicks * 0.067F) * 0.05F;
        this.left_arm.rotateAngleX -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
        AbstractIllager.IllagerArmPose abstractillagerentity$armpose = entityIn.getArmPose();
        if (abstractillagerentity$armpose == AbstractIllager.IllagerArmPose.SPELLCASTING) {
            this.right_arm.rotationPointZ = 0.0F;
            this.right_arm.rotationPointX = -5.0F;
            this.left_arm.rotationPointZ = 0.0F;
            this.left_arm.rotationPointX = 5.0F;
            this.right_arm.rotateAngleX = Mth.cos(ageInTicks * 0.6662F) * 0.25F;
            this.left_arm.rotateAngleX = Mth.cos(ageInTicks * 0.6662F) * 0.25F;
            this.right_arm.rotateAngleZ = 2.3561945F;
            this.left_arm.rotateAngleZ = -2.3561945F;
            this.right_arm.rotateAngleY = 0.0F;
            this.left_arm.rotateAngleY = 0.0F;
        }
    }

    @Override
    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(
                root,
                head,
                nose,
                body,
                left_arm,
                right_arm,
                left_leg,
                right_leg,
                book,
                cover_left,
                cover_right,
                filpping_page_left,
                filpping_page_right,
                page_left,
                page_right);
    }

    @Override
    public Iterable<BasicModelPart> parts() {
        return ImmutableList.of(root);
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
        AdvancedModelBox.rotateAngleX = x;
        AdvancedModelBox.rotateAngleY = y;
        AdvancedModelBox.rotateAngleZ = z;
    }
}