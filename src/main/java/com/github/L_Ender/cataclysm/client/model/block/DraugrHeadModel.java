package com.github.L_Ender.cataclysm.client.model.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DraugrHeadModel extends Cataclysm_Skull_Model_Base {
    private final ModelPart head;
    private final ModelPart maw;

    public DraugrHeadModel(ModelPart p_171097_) {
        this.head = p_171097_.getChild("head");
        this.maw = this.head.getChild("maw");
    }

    public static LayerDefinition createHeadLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(92, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F))
                .texOffs(0, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F))
                .texOffs(58, 36).addBox(0.0F, -16.0F, 0.0F, 10.0F, 11.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 55).mirror().addBox(-10.0F, -13.0F, 0.0F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition maw = head.addOrReplaceChild("maw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.5F, -1.0F, -0.0873F, 0.0F, 0.2182F));

        PartDefinition body_r1 = maw.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(32, 6).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    public void setupAnim(float p_104188_, float p_104189_, float p_104190_) {
        this.head.yRot = p_104189_ * ((float)Math.PI / 180F);
        this.head.xRot = p_104190_ * ((float)Math.PI / 180F);
    }
    @Override
    public void renderToBuffer(PoseStack p_104192_, VertexConsumer p_104193_, int p_104194_, int p_104195_, int p_350947_) {
        p_104192_.pushPose();
        p_104192_.translate(0.0F, -0.374375F, 0.0F);
        p_104192_.scale(1.0F, 1.0F, 1.0F);
        this.head.render(p_104192_, p_104193_, p_104194_, p_104195_, p_350947_);
        p_104192_.popPose();
    }


}
