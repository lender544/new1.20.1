package com.github.L_Ender.cataclysm.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector4f;

@OnlyIn(Dist.CLIENT)
public class Ceraunus_Model<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart everything;
    private final ModelPart chain;



    public Ceraunus_Model(ModelPart root) {
        this.root = root;
        this.everything = this.root.getChild("everything");
        this.chain = this.everything.getChild("chain");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create().texOffs(21, 0).addBox(-9.0F, -40.3F, 0.0F, 18.0F, 11.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 62).addBox(-3.0F, -35.3F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(25, 60).addBox(0.0F, -38.3F, -3.0F, 0.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, -25.3F, -2.0F, 6.0F, 32.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = everything.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(33, 47).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 4.7F, 0.0F, 0.0F, 0.0F, 2.3562F));

        PartDefinition cube_r2 = everything.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 49).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -28.5F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r3 = everything.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(33, 38).addBox(-6.0F, -3.0F, -1.0F, 12.0F, 6.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(15.6944F, -23.5732F, 0.0F, 0.0F, 0.0F, 0.7418F));

        PartDefinition cube_r4 = everything.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(21, 12).addBox(-1.0F, -3.0F, -2.0F, 12.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -28.3F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r5 = everything.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(50, 23).addBox(-6.0F, -3.0F, -1.0F, 12.0F, 6.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-15.6944F, -23.5732F, 0.0F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r6 = everything.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 38).addBox(-11.0F, -3.0F, -2.0F, 12.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -28.3F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition cube_r7 = everything.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(58, 54).addBox(-5.0F, -2.0F, -1.0F, 10.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0963F, -24.7693F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r8 = everything.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(58, 47).addBox(-5.0F, -2.0F, -1.0F, 10.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0963F, -24.7693F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r9 = everything.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(51, 61).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(64, 61).addBox(-1.0F, 5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(58, 0).addBox(-5.0F, 3.0F, 0.0F, 10.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.5093F, -17.0353F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r10 = everything.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(62, 32).addBox(-1.0F, 5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(38, 60).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.5093F, -17.0353F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition cube_r11 = everything.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(54, 12).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.4651F, -9.1037F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition chain = everything.addOrReplaceChild("chain", CubeListBuilder.create(), PartPose.offset(0.0F, 16.3F, 0.0F));

        PartDefinition cube_r12 = chain.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(21, 23).addBox(-4.0F, -10.0F, -1.0F, 14.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.6F, 1.0F, 0.0F, 0.0F, 2.3562F));

        return LayerDefinition.create(meshdefinition, 128, 128);

    }



    public Vec3 getChainPosition(Vec3 offset, PoseStack transform) {
        this.root.translateAndRotate(transform);
        this.everything.translateAndRotate(transform);
        this.chain.translateAndRotate(transform);
        Vector4f vec = new Vector4f((float) offset.x, (float) offset.y, (float) offset.z, 1.0F);
        vec.mul(transform.last().pose());
        return new Vec3(vec.x(), vec.y(), vec.z());
    }


    public ModelPart root() {
        return this.root;
    }



    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
    }

}

