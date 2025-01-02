package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.projectile.Flare_Bomb_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.phys.Vec3;

public class Flare_Bomb_Model extends HierarchicalModel<Flare_Bomb_Entity> {


	private final ModelPart root;
	private final ModelPart outer;
	private final ModelPart inner;
	public Flare_Bomb_Model(ModelPart root) {
		this.root = root.getChild("root");
		this.outer = this.root.getChild("outer");
		this.inner = this.root.getChild("inner");
	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition outer = root.addOrReplaceChild("outer", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition inner = root.addOrReplaceChild("inner", CubeListBuilder.create().texOffs(0, 33).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	@Override
	public void setupAnim(Flare_Bomb_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float delta = ageInTicks - entity.tickCount;
		Vec3 prevV = new Vec3(entity.prevDeltaMovementX, entity.prevDeltaMovementY, entity.prevDeltaMovementZ);
		Vec3 dv = prevV.add(entity.getDeltaMovement().subtract(prevV).scale(delta));
		double d = Math.sqrt(dv.x * dv.x + dv.y * dv.y + dv.z * dv.z);
		if (d != 0) {
			double a = dv.y / d;
			a = Math.max(-10, Math.min(1, a));
			float pitch = -(float) Math.asin(a);
			root.xRot = pitch + (float)Math.PI / 2f;

		}
		this.inner.yRot = ageInTicks * 20 * ((float)Math.PI / 180F);
		this.inner.xRot = ageInTicks * 20  * ((float)Math.PI / 180F);
		this.inner.zRot = ageInTicks  * 20  * ((float)Math.PI / 180F);

		this.outer.yRot = ageInTicks * -10 * ((float)Math.PI / 180F);
		this.outer.xRot = ageInTicks * -10  * ((float)Math.PI / 180F);
		this.outer.zRot = ageInTicks  * -10  * ((float)Math.PI / 180F);


	}

	@Override
	public ModelPart root() {
		return this.root;
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}