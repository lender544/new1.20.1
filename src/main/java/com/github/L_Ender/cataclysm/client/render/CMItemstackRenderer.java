package com.github.L_Ender.cataclysm.client.render;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blocks.Abstract_Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.blocks.Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.client.model.block.*;
import com.github.L_Ender.cataclysm.client.model.entity.ModelCoral_Bardiche;
import com.github.L_Ender.cataclysm.client.model.entity.ModelCoral_Spear;
import com.github.L_Ender.cataclysm.client.model.item.*;
import com.github.L_Ender.cataclysm.client.render.blockentity.Cataclysm_Skull_Block_Renderer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.github.L_Ender.cataclysm.init.ModBlocks;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.items.Cursed_bow;
import com.github.L_Ender.cataclysm.items.Laser_Gatling;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class CMItemstackRenderer extends BlockEntityWithoutLevelRenderer {

    public static int ticksExisted = 0;

    private static final ModelBulwark_of_the_flame BULWARK_OF_THE_FLAME_MODEL = new ModelBulwark_of_the_flame();
    private static final Model_EMP EMP_MODEL = new Model_EMP();
    private static final Model_Mechanical_Anvil MF_MODEL = new Model_Mechanical_Anvil();
    private static final ModelGauntlet_of_Guard GAUNTLET_OF_GUARD_MODEL = new ModelGauntlet_of_Guard();
    private static final ModelGauntlet_of_Bulwark GAUNTLET_OF_BULWARK_MODEL = new ModelGauntlet_of_Bulwark();
    private static final ModelIncinerator THE_INCINERATOR_MODEL = new ModelIncinerator();
    private static final ModelCoral_Spear CORAL_SPEAR_MODEL = new ModelCoral_Spear();
    private static final ModelCoral_Bardiche CORAL_BARDICHE_MODEL = new ModelCoral_Bardiche();
    private static final Model_Altar_of_Fire ALTAR_OF_FIRE_MODEL = new Model_Altar_of_Fire();
    private static final Model_Altar_of_Void ALTAR_OF_VOID_MODEL = new Model_Altar_of_Void();
    private static final Model_Altar_of_Amethyst ALTAR_OF_AMETHYST_MODEL = new Model_Altar_of_Amethyst();
    private static final Model_Altar_of_Abyss ALTAR_OF_ABYSS_MODEL = new Model_Altar_of_Abyss();
    private static final Model_Abyssal_Egg ABYSSAL_MODEL = new Model_Abyssal_Egg();
    private static final ModelWither_Assault_SHoulder_Weapon WASW_MODEL = new ModelWither_Assault_SHoulder_Weapon();
    private static final ModelVoid_Forge VOID_FORGE_MODEL = new ModelVoid_Forge();
    private static final ModelTidal_Claws TIDAL_CLAWS_MODEL = new ModelTidal_Claws();
    private static final ModelMeat_Shredder MEAT_SHREDDER_MODEL = new ModelMeat_Shredder();
    private static final ModelLaser_Gatling LASER_GATLING_MODEL = new ModelLaser_Gatling();
    private static final ModelAncient_Spear ANCIENT_SPEAR_MODEL = new ModelAncient_Spear();
    private static final Model_Cursed_Bow CURSED_BOW_MODEL = new Model_Cursed_Bow();
    private static final ResourceLocation CURSED_BOW_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/cursed_bow.png");
    private static final ResourceLocation CURSED_BOW_GHOST_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/cursed_bow_ghost.png");
    private static final ResourceLocation BULWARK_OF_THE_FLAME_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/bulwark_of_the_flame.png");
    private static final ResourceLocation GAUNTLET_OF_GUARD_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/gauntlet_of_guard.png");
    private static final ResourceLocation GAUNTLET_OF_BULWARK_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/gauntlet_of_bulwark.png");
    private static final ResourceLocation THE_INCINERATOR_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/the_incinerator.png");
    private static final ResourceLocation VOID_FORGE_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/void_forge.png");
    private static final ResourceLocation TIDAL_CLAWS_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/tidal_claws.png");
    private static final ResourceLocation MEAT_SHREDDER_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/meat_shredder.png");
    private static final ResourceLocation LASER_GATLING_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/laser_gatling.png");
    private static final ResourceLocation ALTAR_OF_FIRE_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/altar_of_fire/altar_of_fire.png");
    private static final ResourceLocation ALTAR_OF_VOID_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/altar_of_void.png");
    private static final ResourceLocation ALTAR_OF_AMETHYST_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/altar_of_amethyst.png");
    private static final ResourceLocation ALTAR_OF_ABYSS_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/altar_of_abyss.png");
    private static final ResourceLocation ABYSSAL_EGG_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/abyssal_egg.png");
    private static final ResourceLocation ABYSSAL_EGG_LAYER_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/abyssal_egg_layer.png");
    private static final ResourceLocation MIF_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/mechanical_fusion_anvil.png");
    private static final ResourceLocation WASW_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/wither_assualt_shoulder_weapon.png");
    private static final ResourceLocation VASW_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/void_assualt_shoulder_weapon.png");
    private static final ResourceLocation EMP_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/emp.png");
    private static final ResourceLocation[] TEXTURE_FIRE_PROGRESS = new ResourceLocation[8];
    private static final ResourceLocation CORAL_SPEAR_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/entity/coral_spear.png");
    private static final ResourceLocation CORAL_BARDICHE_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/entity/coral_bardiche.png");
    private static final ResourceLocation ANCIENT_SPEAR_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/ancient_spear.png");

    private Map<Cataclysm_Skull_Block.Type, Cataclysm_Skull_Model_Base> skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers(Minecraft.getInstance().getEntityModels());

    public static final Map<Cataclysm_Skull_Block.Type, ResourceLocation> SKIN_BY_TYPE = Util.make(Maps.newHashMap(), (p_261388_) -> {
        p_261388_.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, new ResourceLocation(Cataclysm.MODID,"textures/entity/koboleton/kobolediator.png"));
    });

    public CMItemstackRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());


        for(int i = 0; i < 8; i++){
            TEXTURE_FIRE_PROGRESS[i] = new ResourceLocation(Cataclysm.MODID,"textures/block/altar_of_fire/altarfire_" + i + ".png");
        }

    }

    @Override
    public void onResourceManagerReload(ResourceManager manager) {
        this.skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers(Minecraft.getInstance().getEntityModels());

        Cataclysm.LOGGER.debug("Reloaded ItemStackRenderer!");
    }

    public static void incrementTick() {
        ticksExisted++;
    }

    @Override
    public void renderByItem(ItemStack itemStackIn, ItemDisplayContext transformType, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        float partialTick = Minecraft.getInstance().getPartialTick();
        boolean left = transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || transformType == ItemDisplayContext.FIRST_PERSON_LEFT_HAND;
        int tick;
        if(Minecraft.getInstance().player == null || Minecraft.getInstance().isPaused()){
            tick = ticksExisted;
        }else{
            tick = Minecraft.getInstance().player.tickCount;
        }

        Item item = itemStackIn.getItem();
        if (item instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            if (block instanceof Abstract_Cataclysm_Skull_Block) {
                Cataclysm_Skull_Block.Type skullblock$type = ((Abstract_Cataclysm_Skull_Block) block).getType();
                Cataclysm_Skull_Model_Base skullmodelbase = this.skullModels.get(skullblock$type);
                ResourceLocation resourcelocation = SKIN_BY_TYPE.get(skullblock$type);
                RenderType rendertype = RenderType.entityCutoutNoCullZOffset(resourcelocation);
                Cataclysm_Skull_Block_Renderer.renderSkull((Direction) null, 180.0F, 0.0F, matrixStackIn, bufferIn, combinedLightIn, skullmodelbase, rendertype);
            }
        }

        if (itemStackIn.getItem() == ModItems.BULWARK_OF_THE_FLAME.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(BULWARK_OF_THE_FLAME_TEXTURE), false, itemStackIn.hasFoil());
            BULWARK_OF_THE_FLAME_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.GAUNTLET_OF_GUARD.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(GAUNTLET_OF_GUARD_TEXTURE), false, itemStackIn.hasFoil());
            GAUNTLET_OF_GUARD_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.GAUNTLET_OF_BULWARK.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(GAUNTLET_OF_BULWARK_TEXTURE), false, itemStackIn.hasFoil());
            GAUNTLET_OF_BULWARK_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.THE_INCINERATOR.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(THE_INCINERATOR_TEXTURE), false, itemStackIn.hasFoil());
            THE_INCINERATOR_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.WITHER_ASSULT_SHOULDER_WEAPON.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(WASW_TEXTURE), false, itemStackIn.hasFoil());
            WASW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.VOID_ASSULT_SHOULDER_WEAPON.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(VASW_TEXTURE), false, itemStackIn.hasFoil());
            WASW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }

        if (itemStackIn.getItem() == ModItems.CORAL_SPEAR.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(CORAL_SPEAR_TEXTURE), false, itemStackIn.hasFoil());
            CORAL_SPEAR_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }

        if (itemStackIn.getItem() == ModItems.CORAL_BARDICHE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(CORAL_BARDICHE_TEXTURE), false, itemStackIn.hasFoil());
            CORAL_BARDICHE_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }

        if (itemStackIn.getItem() == ModItems.VOID_FORGE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(VOID_FORGE_TEXTURE), false, itemStackIn.hasFoil());
            VOID_FORGE_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.TIDAL_CLAWS.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(TIDAL_CLAWS_TEXTURE), false, itemStackIn.hasFoil());
            TIDAL_CLAWS_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }

        if (itemStackIn.getItem() == ModItems.MEAT_SHREDDER.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(MEAT_SHREDDER_TEXTURE), false, itemStackIn.hasFoil());
            MEAT_SHREDDER_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            MEAT_SHREDDER_MODEL.animateStack(itemStackIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.LASER_GATLING.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(LASER_GATLING_TEXTURE), false, itemStackIn.hasFoil());
            float ageInTicks = Minecraft.getInstance().player == null ? 0F : Minecraft.getInstance().player.tickCount + partialTick;
            float openAmount = Minecraft.getInstance().player != null && Laser_Gatling.isCharged(itemStackIn) ? Minecraft.getInstance().player.tickCount + partialTick : 0;

            LASER_GATLING_MODEL.setupAnim(null, openAmount, 0, ageInTicks, 0, 0);
            LASER_GATLING_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);

            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ANCIENT_SPEAR.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(ANCIENT_SPEAR_TEXTURE), false, itemStackIn.hasFoil());
            ANCIENT_SPEAR_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }

        if (itemStackIn.is(ModItems.CURSED_BOW.get())) {
            float ageInTicks = Minecraft.getInstance().player == null ? 0F : Minecraft.getInstance().player.tickCount + partialTick;
            float pullAmount = Cursed_bow.getPullingAmount(itemStackIn, partialTick);

            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5f, 0.5f);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            CURSED_BOW_MODEL.setupAnim(null, pullAmount, ageInTicks,  0, 0, 0);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(CURSED_BOW_TEXTURE), false, itemStackIn.hasFoil());
            CURSED_BOW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorFoilBuffer(bufferIn, CMRenderTypes.getghost(CURSED_BOW_GHOST_TEXTURE), false, itemStackIn.hasFoil());
            CURSED_BOW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);

            matrixStackIn.popPose();
        }

        if(itemStackIn.getItem() == ModBlocks.ALTAR_OF_FIRE.get().asItem()){
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            ALTAR_OF_FIRE_MODEL.resetToDefaultPose();
            ALTAR_OF_FIRE_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(ALTAR_OF_FIRE_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            ALTAR_OF_FIRE_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(CMRenderTypes.getGlowingEffect(getIdleTexture((int) ((tick * 0.5F) % 7)))), 210, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
            matrixStackIn.popPose();
        }
        if(itemStackIn.getItem() == ModBlocks.ALTAR_OF_VOID.get().asItem()){
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);;
            ALTAR_OF_VOID_MODEL.resetToDefaultPose();
            ALTAR_OF_VOID_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(ALTAR_OF_VOID_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if(itemStackIn.getItem() == ModBlocks.ALTAR_OF_AMETHYST.get().asItem()){
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            ALTAR_OF_AMETHYST_MODEL.resetToDefaultPose();
            ALTAR_OF_AMETHYST_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(ALTAR_OF_AMETHYST_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if(itemStackIn.getItem() == ModBlocks.ALTAR_OF_ABYSS.get().asItem()){
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            ALTAR_OF_ABYSS_MODEL.resetToDefaultPose();
            ALTAR_OF_ABYSS_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(ALTAR_OF_ABYSS_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if(itemStackIn.getItem() == ModBlocks.EMP.get().asItem()){
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            EMP_MODEL.resetToDefaultPose();
            EMP_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(EMP_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if(itemStackIn.getItem() == ModBlocks.MECHANICAL_FUSION_ANVIL.get().asItem()){
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            MF_MODEL.resetToDefaultPose();
            MF_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(MIF_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if(itemStackIn.getItem() == ModBlocks.ABYSSAL_EGG.get().asItem()){
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            ABYSSAL_MODEL.resetToDefaultPose();
            ABYSSAL_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(ABYSSAL_EGG_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            ABYSSAL_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(CMRenderTypes.getghost(ABYSSAL_EGG_LAYER_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
    }


    private ResourceLocation getIdleTexture(int age) {
        return TEXTURE_FIRE_PROGRESS[Mth.clamp(age, 0, 7)];
    }

}
