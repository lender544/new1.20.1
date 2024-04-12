package com.github.L_Ender.cataclysm.client.model.entity;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.github.L_Ender.cataclysm.entity.Deepling.Lionfish_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;import com.github.L_Ender.lionfishapi.client.model.Animations.ModelAnimator;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class ModelLionfish extends AdvancedEntityModel<Lionfish_Entity> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox body;
	private final AdvancedModelBox r_fin;
	private final AdvancedModelBox right_long_fin;
	private final AdvancedModelBox left_long_fin;
	private final AdvancedModelBox l_fin;
	private final AdvancedModelBox tail;
	private final AdvancedModelBox tail2;
	private final AdvancedModelBox head;
	private final AdvancedModelBox upper_jaw;
	private final AdvancedModelBox jaw;
	private ModelAnimator animator;

	public ModelLionfish() {
		texWidth = 64;
		texHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);


		body = new AdvancedModelBox(this);
		body.setRotationPoint(0.0F, -2.0F, 0.0F);
		root.addChild(body);
		body.setTextureOffset(0, 0).addBox(-2.0F, -6.0F, -6.0F, 4.0F, 8.0F, 11.0F, 0.0F, false);
		body.setTextureOffset(0, 20).addBox(0.0F, 2.0F, -5.0F, 0.0F, 6.0F, 11.0F, 0.0F, false);
		body.setTextureOffset(12, 31).addBox(0.0F, -12.0F, -5.0F, 0.0F, 6.0F, 11.0F, 0.0F, false);

		r_fin = new AdvancedModelBox(this);
		r_fin.setRotationPoint(-2.0F, -1.0F, -4.0F);
		body.addChild(r_fin);
		setRotationAngle(r_fin, 0.0F, 0.4363F, 0.0F);
		r_fin.setTextureOffset(24, 31).addBox(-10.0F, -5.0F, 0.0F, 10.0F, 8.0F, 0.0F, 0.0F, true);

		right_long_fin = new AdvancedModelBox(this);
		right_long_fin.setRotationPoint(-2.0F, 2.0F, -5.0F);
		body.addChild(right_long_fin);
		setRotationAngle(right_long_fin, 0.0F, 0.0F, 0.0873F);
		right_long_fin.setTextureOffset(19, 8).addBox(0.0F, 0.0F, -1.0F, 0.0F, 10.0F, 12.0F, 0.0F, true);

		left_long_fin = new AdvancedModelBox(this);
		left_long_fin.setRotationPoint(2.0F, 2.0F, -5.0F);
		body.addChild(left_long_fin);
		setRotationAngle(left_long_fin, 0.0F, 0.0F, -0.0873F);
		left_long_fin.setTextureOffset(19, 8).addBox(0.0F, 0.0F, -1.0F, 0.0F, 10.0F, 12.0F, 0.0F, false);

		l_fin = new AdvancedModelBox(this);
		l_fin.setRotationPoint(2.0F, -1.0F, -4.0F);
		body.addChild(l_fin);
		setRotationAngle(l_fin, 0.0F, -0.4363F, 0.0F);
		l_fin.setTextureOffset(24, 31).addBox(0.0F, -5.0F, 0.0F, 10.0F, 8.0F, 0.0F, 0.0F, false);

		tail = new AdvancedModelBox(this);
		tail.setRotationPoint(0.0F, -3.0F, 5.0F);
		body.addChild(tail);
		tail.setTextureOffset(0, 20).addBox(0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		tail.setTextureOffset(35, 40).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 5.0F, 0.0F, false);
		tail.setTextureOffset(0, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);

		tail2 = new AdvancedModelBox(this);
		tail2.setRotationPoint(0.0F, 0.0F, 5.0F);
		tail.addChild(tail2);
		tail2.setTextureOffset(32, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 9.0F, 7.0F, 0.0F, false);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, -1.0F, -6.0F);
		body.addChild(head);


		upper_jaw = new AdvancedModelBox(this);
		upper_jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(upper_jaw);
		upper_jaw.setTextureOffset(44, 13).addBox(-1.5F, -2.0F, -4.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);
		upper_jaw.setTextureOffset(40, 0).addBox(-1.5F, 1.0F, -4.0F, 3.0F, 0.0F, 4.0F, 0.0F, false);
		upper_jaw.setTextureOffset(0, 38).addBox(0.0F, -4.0F, -4.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		upper_jaw.setTextureOffset(12, 20).addBox(0.0F, -4.0F, -6.0F, 0.0F, 5.0F, 2.0F, 0.0F, false);

		jaw = new AdvancedModelBox(this);
		jaw.setRotationPoint(0.0F, 0.7F, -1.0F);
		head.addChild(jaw);
		jaw.setTextureOffset(44, 22).addBox(-1.5F, -0.5F, -3.5F, 3.0F, 3.0F, 4.0F, 0.025F, false);
		jaw.setTextureOffset(20, 0).addBox(-1.5F, 2.5F, -3.5F, 3.0F, 0.0F, 4.0F, 0.0F, false);
		jaw.setTextureOffset(20, 5).addBox(-1.5F, -0.5F, 0.5F, 3.0F, 3.0F, 0.0F, 0.0F, false);
		animator = ModelAnimator.create();
		this.updateDefaultPose();
	}

	public void animate(Lionfish_Entity entity, float f, float f1, float f2, float f3, float f4) {
		this.resetToDefaultPose();
		animator.update(entity);
		animator.setAnimation(Lionfish_Entity.LIONFISH_BITE);
		animator.startKeyframe(5);
		animator.rotate(root, (float) Math.toRadians(-10F), 0, 0);
		animator.rotate(r_fin, 0, (float) Math.toRadians(-22.5F), 0);
		animator.rotate(l_fin, 0, (float) Math.toRadians(22.5F), 0);
		animator.rotate(tail, (float) Math.toRadians(-2.5F), 0, 0);
		animator.rotate(upper_jaw, (float) Math.toRadians(-27.5F), 0, 0);
		animator.rotate(jaw, (float) Math.toRadians(45F), 0, 0);
		animator.rotate(tail2, (float) Math.toRadians(-22.5), 0, 0);
		animator.endKeyframe();

		animator.startKeyframe(2);
		animator.rotate(root, (float) Math.toRadians(7.5F), 0, 0);
		animator.rotate(r_fin, 0, (float) Math.toRadians(35F), 0);
		animator.rotate(body, (float) Math.toRadians(20F), 0, 0);
		animator.rotate(l_fin, 0, (float) Math.toRadians(-35F), 0);
		animator.rotate(tail, (float) Math.toRadians(20F), 0, 0);
		animator.rotate(upper_jaw, (float) Math.toRadians(-7.5F), 0, 0);
		animator.rotate(jaw, (float) Math.toRadians(-35F), 0, 0);
		animator.rotate(tail2, (float) Math.toRadians(17.5), 0, 0);
		animator.endKeyframe();

		animator.resetKeyframe(2);

		animator.setStaticKeyframe(10);

	}

	@Override
	public void setupAnim(Lionfish_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		float idleSpeed = 0.2F;
		float idleDegree = 0.3F;
		float swimSpeed = 0.55F;
		float swimDegree = 0.7F;
		AdvancedModelBox[] tailBoxes = new AdvancedModelBox[]{tail, tail2};
		float partialTick = ageInTicks - entityIn.tickCount;
		float landProgress = entityIn.prevOnLandProgress + (entityIn.onLandProgress - entityIn.prevOnLandProgress) * partialTick;

		progressRotationPrev(body, landProgress, 0, 0, (float) Math.toRadians(-90), 5F);

		this.chainSwing(tailBoxes, idleSpeed, idleDegree * 0.1F, 3, ageInTicks, 1);
		this.swing(r_fin, idleSpeed * 0.5F, idleDegree * 0.4F,true,0,-0.12F, ageInTicks, 1);
		this.swing(l_fin, idleSpeed * 0.5F, idleDegree * 0.4F,false,0,-0.12F, ageInTicks, 1);
		this.walk(right_long_fin, idleSpeed * 0.5F, idleDegree * 0.2F,true,0,-0.06F, ageInTicks, 1);
		this.walk(left_long_fin, idleSpeed * 0.5F, idleDegree * 0.2F,true,0,-0.06F, ageInTicks, 1);
		this.swing(r_fin, swimSpeed * 0.5F, swimDegree * 0.4F,true,0,-0.28F, limbSwing, limbSwingAmount);
		this.swing(l_fin, swimSpeed * 0.5F, swimDegree * 0.4F,false,0,-0.28F, limbSwing, limbSwingAmount);
		this.walk(right_long_fin, swimSpeed * 0.5F, swimDegree * 0.2F,true,0,-0.14F, limbSwing, limbSwingAmount);
		this.walk(left_long_fin, swimSpeed * 0.5F, swimDegree * 0.2F,true,0,-0.14F, limbSwing, limbSwingAmount);
		this.chainSwing(tailBoxes, swimSpeed, swimDegree, -2, limbSwing, limbSwingAmount);

		this.body.rotateAngleX += headPitch * ((float)Math.PI / 180F);
		this.head.rotateAngleX -= headPitch * 0.5F * ((float)Math.PI / 180F);

	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root,
				body,
				tail,
				tail2,
				l_fin,
				left_long_fin,
				right_long_fin,
				upper_jaw,
				jaw,
				head,
				r_fin);
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