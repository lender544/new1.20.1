package com.github.L_Ender.cataclysm.client.render.blockentity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blockentities.AltarOfAmethyst_Block_Entity;
import com.github.L_Ender.cataclysm.blocks.Altar_Of_Amethyst_Block;
import com.github.L_Ender.cataclysm.client.model.block.Altar_of_Amethyst_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.IItemHandler;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

import java.util.Random;

public class RendererAltar_of_Amethyst implements BlockEntityRenderer<AltarOfAmethyst_Block_Entity> {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/block/altar_of_amethyst.png");
    public static final ResourceLocation BEAM_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/beacon_beam.png");
    private static final Altar_of_Amethyst_Model MODEL = new Altar_of_Amethyst_Model();
    private final ItemRenderer itemRenderer;
    private final Random random = new Random();
    public RendererAltar_of_Amethyst(Context rendererDispatcherIn) {
        this.itemRenderer = rendererDispatcherIn.getItemRenderer();
    }

    public boolean shouldRenderOffScreen(AltarOfAmethyst_Block_Entity p_112138_) {
        return true;
    }

    public int getViewDistance() {
        return 256;
    }

    public boolean shouldRender(AltarOfAmethyst_Block_Entity p_173531_, Vec3 p_173532_) {
        return Vec3.atCenterOf(p_173531_.getBlockPos()).multiply(1.0D, 0.0D, 1.0D).closerThan(p_173532_.multiply(1.0D, 0.0D, 1.0D), (double)this.getViewDistance());
    }

    public AABB getRenderBoundingBox(AltarOfAmethyst_Block_Entity blockEntity) {
        BlockPos pos = blockEntity.getBlockPos();
        return new AABB((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)pos.getX() + (double)1.0F, (double)1024.0F, (double)pos.getZ() + (double)1.0F);
    }

    @Override
    public void render(AltarOfAmethyst_Block_Entity tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.pushPose();
        Direction dir = tileEntityIn.getBlockState().getValue(Altar_Of_Amethyst_Block.FACING);
        if(dir == Direction.NORTH){
            matrixStackIn.translate(0.5, 1.5F, 0.5F);
        }else if(dir == Direction.EAST){
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        }else if(dir == Direction.SOUTH){
            matrixStackIn.translate(0.5, 1.5F, 0.5F);
        }else if(dir == Direction.WEST){
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        }
        matrixStackIn.mulPose(dir.getOpposite().getRotation());
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0F));
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(TEXTURE)), combinedLightIn, combinedOverlayIn);

        matrixStackIn.popPose();
        renderItem(tileEntityIn, partialTicks,matrixStackIn,bufferIn,combinedLightIn);
    }

    public void renderItem(AltarOfAmethyst_Block_Entity tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn) {



        IItemHandler inventory = tileEntityIn.getInventory();
        int posLong = (int) tileEntityIn.getBlockPos().asLong();
        ItemStack stack = inventory.getStackInSlot(0);
        int seed = stack.isEmpty() ? 187 : Item.getId(stack.getItem()) + stack.getDamageValue();
        this.random.setSeed(seed);
        if (stack != ItemStack.EMPTY) {
            int itemRenderCount = this.getCount(stack);
            for (int i = 0; i < itemRenderCount; i++) {
                matrixStackIn.pushPose();


                float xOffset = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F * 0.5F;
                float zOffset = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F * 0.5F;
                matrixStackIn.translate(0.5D + xOffset, 1.15F + 0.03 * (i + 1), 0.5D + zOffset);
                matrixStackIn.scale(0.5F, 0.5F, 0.5F);
                if (tileEntityIn.getLevel() != null) {
                    long time = tileEntityIn.getLevel().getGameTime();
                    matrixStackIn.mulPose(Axis.YP.rotationDegrees(time));
                    this.itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, combinedLightIn, OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn, tileEntityIn.getLevel(), posLong);
                }
                matrixStackIn.popPose();

            }
            if (tileEntityIn.getLevel() != null) {
                long time = tileEntityIn.getLevel().getGameTime();
                int j2 = 0;

                for (int k = 0; k < 6; ++k) {
                    renderBeaconBeam(matrixStackIn, bufferIn, partialTicks, time, j2, 10);
                }
            }

        }
        

    }

    protected int getCount(ItemStack stack) {
        if (stack.getCount() > 48) {
            return 5;
        } else if (stack.getCount() > 32) {
            return 4;
        } else if (stack.getCount() > 16) {
            return 3;
        } else if (stack.getCount() > 1) {
            return 2;
        }
        return 1;
    }


    private static void renderBeaconBeam(PoseStack p_112177_, MultiBufferSource p_112178_, float p_112179_, long p_112180_, int p_112181_, int p_112182_) {
        renderBeaconBeam(p_112177_, p_112178_, BEAM_LOCATION, p_112179_, 1.0F, p_112180_, p_112181_, p_112182_, 0.2F, 0.25F);
    }

    public static void renderBeaconBeam(PoseStack p_112185_, MultiBufferSource p_112186_, ResourceLocation p_112187_, float p_112188_, float p_112189_, long p_112190_, int p_112191_, int p_112192_, float p_112194_, float p_112195_) {
        int i = p_112191_ + p_112192_;
        p_112185_.pushPose();
        p_112185_.translate(0.5D, 0.0D, 0.5D);
        float f = (float)Math.floorMod(p_112190_, 40) + p_112188_;
        float f1 = p_112192_ < 0 ? f : -f;
        float f2 = Mth.frac(f1 * 0.2F - (float)Mth.floor(f1 * 0.1F));

        p_112185_.pushPose();
        p_112185_.mulPose(Axis.YP.rotationDegrees(f * 2.25F - 45.0F));
        float f6 = 0.0F;
        float f8 = 0.0F;
        float f9 = -p_112194_;
        float f10 = 0.0F;
        float f11 = 0.0F;
        float f12 = -p_112194_;
        float f13 = 0.0F;
        float f14 = 1.0F;
        float f15 = -1.0F + f2;
        float f16 = (float)p_112192_ * p_112189_ * (0.5F / p_112194_) + f15;
        renderPart(p_112185_, p_112186_.getBuffer(RenderType.beaconBeam(p_112187_, false)), 1, 52, 25, 1.0F, p_112191_, i, 0.0F, p_112194_, p_112194_, 0.0F, f9, 0.0F, 0.0F, f12, 0.0F, 1.0F, f16, f15);
        p_112185_.popPose();
        f6 = -p_112195_;
        float f7 = -p_112195_;
        f8 = -p_112195_;
        f9 = -p_112195_;
        f13 = 0.0F;
        f14 = 1.0F;
        f15 = -1.0F + f2;
        f16 = (float)p_112192_ * p_112189_ + f15;
        renderPart(p_112185_, p_112186_.getBuffer(RenderType.beaconBeam(p_112187_, true)), 1, 52, 25, 0.125F, p_112191_, i, f6, f7, p_112195_, f8, f9, p_112195_, p_112195_, p_112195_, 0.0F, 1.0F, f16, f15);
        p_112185_.popPose();
    }

    private static void renderPart(PoseStack p_112156_, VertexConsumer p_112157_, float p_112158_, float p_112159_, float p_112160_, float p_112161_, int p_112162_, int p_112163_, float p_112164_, float p_112165_, float p_112166_, float p_112167_, float p_112168_, float p_112169_, float p_112170_, float p_112171_, float p_112172_, float p_112173_, float p_112174_, float p_112175_) {
        PoseStack.Pose posestack$pose = p_112156_.last();
        renderQuad(posestack$pose, p_112157_, p_112158_, p_112159_, p_112160_, p_112161_, p_112162_, p_112163_, p_112164_, p_112165_, p_112166_, p_112167_, p_112172_, p_112173_, p_112174_, p_112175_);
        renderQuad(posestack$pose, p_112157_, p_112158_, p_112159_, p_112160_, p_112161_, p_112162_, p_112163_, p_112170_, p_112171_, p_112168_, p_112169_, p_112172_, p_112173_, p_112174_, p_112175_);
        renderQuad(posestack$pose, p_112157_, p_112158_, p_112159_, p_112160_, p_112161_, p_112162_, p_112163_, p_112166_, p_112167_, p_112170_, p_112171_, p_112172_, p_112173_, p_112174_, p_112175_);
        renderQuad(posestack$pose, p_112157_, p_112158_, p_112159_, p_112160_, p_112161_, p_112162_, p_112163_, p_112168_, p_112169_, p_112164_, p_112165_, p_112172_, p_112173_, p_112174_, p_112175_);
    }

    private static void renderQuad(PoseStack.Pose p_324380_, VertexConsumer p_112122_, float p_112123_, float p_112124_, float p_112125_, float p_112126_, int p_112127_, int p_112128_, float p_112129_, float p_112130_, float p_112131_, float p_112132_, float p_112133_, float p_112134_, float p_112135_, float p_112136_) {
        addVertex(p_324380_, p_112122_, p_112123_, p_112124_, p_112125_, p_112126_, p_112128_, p_112129_, p_112130_, p_112134_, p_112135_);
        addVertex(p_324380_, p_112122_, p_112123_, p_112124_, p_112125_, p_112126_, p_112127_, p_112129_, p_112130_, p_112134_, p_112136_);
        addVertex(p_324380_, p_112122_, p_112123_, p_112124_, p_112125_, p_112126_, p_112127_, p_112131_, p_112132_, p_112133_, p_112136_);
        addVertex(p_324380_, p_112122_, p_112123_, p_112124_, p_112125_, p_112126_, p_112128_, p_112131_, p_112132_, p_112133_, p_112135_);
    }

    private static void addVertex(PoseStack.Pose p_324380_, VertexConsumer p_253894_, float p_253871_, float p_253841_, float p_254568_, float p_254361_, int p_254357_, float p_254451_, float p_254240_, float p_254117_, float p_253698_) {
        p_253894_.addVertex(p_324380_, p_254451_, (float)p_254357_, p_254240_).setColor(p_253871_, p_253841_, p_254568_, p_254361_).setUv(p_254117_, p_253698_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(15728880).setNormal(p_324380_, 0.0F, 1.0F, 0.0F);
    }


}


