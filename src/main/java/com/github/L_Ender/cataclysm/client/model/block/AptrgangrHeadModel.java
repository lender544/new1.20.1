package com.github.L_Ender.cataclysm.client.model.block;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AptrgangrHeadModel extends SkullModelBase {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart head;
	private final ModelPart helmet;
	private final ModelPart jaw;



	public AptrgangrHeadModel(ModelPart root) {
		this.head = root.getChild("head");
		this.helmet = this.head.getChild("helmet");
		this.jaw = this.head.getChild("jaw");
	}

	public static LayerDefinition createHeadLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 111).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition helmet = head.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(32, 113).addBox(-4.0F, -2.0F, -3.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.5F))
				.texOffs(102, 110).addBox(-1.5F, -2.8F, -4.3F, 3.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(64, 120).mirror().addBox(-5.5F, -2.0F, -1.5F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(116, 20).addBox(-10.5F, -3.5F, 0.5F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(64, 120).addBox(4.5F, -2.0F, -1.5F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(116, 0).addBox(4.5F, -9.5F, 0.5F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(88, 98).addBox(-5.0F, 3.2F, -4.3F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.001F))
				.texOffs(62, 91).addBox(-4.0F, 5.0F, -3.5F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -0.5F));

		PartDefinition head_r1 = helmet.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(28, 104).mirror().addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.4F, 3.5F, -3.8F, 0.0F, 0.0F, -0.7854F));

		PartDefinition head_r2 = helmet.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(42, 111).mirror().addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(44, 106).mirror().addBox(0.0F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(43, 109).mirror().addBox(-1.0F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(29, 115).mirror().addBox(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.4F, 3.5F, -4.1F, 0.0F, 0.0F, -0.2618F));

		PartDefinition head_r3 = helmet.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(43, 108).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 104).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, 3.5F, -4.1F, 0.0F, 0.0F, 0.2618F));

		PartDefinition head_r4 = helmet.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(25, 108).mirror().addBox(-0.5F, -1.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.8F, -4.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition head_r5 = helmet.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(31, 108).mirror().addBox(-0.5F, -1.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.2F, -4.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition head_r6 = helmet.addOrReplaceChild("head_r6", CubeListBuilder.create().texOffs(30, 111).mirror().addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.7F, -3.9F, 0.0F, 0.0F, -0.7854F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(34, 26).addBox(-3.0F, 0.0F, -2.5F, 6.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(48, 0).addBox(3.0F, 3.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(48, 5).addBox(3.0F, -2.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(48, 5).mirror().addBox(-5.0F, -2.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(48, 0).mirror().addBox(-9.0F, 3.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(84, 1).addBox(3.0F, 8.0F, -2.5F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(84, 1).mirror().addBox(-8.0F, 8.0F, -2.5F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(52, 33).addBox(-3.0F, 0.0F, 0.5F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -1.5F));

		PartDefinition head_r7 = jaw.addOrReplaceChild("head_r7", CubeListBuilder.create().texOffs(92, 12).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -2.5F, -0.3491F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	public void setupAnim(float p_104188_, float p_104189_, float p_104190_) {
		this.jaw.y = -3.0F + Mth.sin(p_104188_ * 0.5F - 2) * 2f;
		this.head.yRot = p_104189_ * ((float)Math.PI / 180F);
		this.head.xRot = p_104190_ * ((float)Math.PI / 180F);
	}

	public void renderToBuffer(PoseStack p_104192_, VertexConsumer p_104193_, int p_104194_, int p_104195_, float p_104196_, float p_104197_, float p_104198_, float p_104199_) {
		p_104192_.pushPose();
		p_104192_.translate(0.0F, -0.49916F, 0.0F);
		p_104192_.scale(1.0F, 1.0F, 1.0F);
		this.head.render(p_104192_, p_104193_, p_104194_, p_104195_, p_104196_, p_104197_, p_104198_, p_104199_);
		p_104192_.popPose();
	}
}