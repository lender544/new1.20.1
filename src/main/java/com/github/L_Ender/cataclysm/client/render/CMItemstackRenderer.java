package com.github.L_Ender.cataclysm.client.render;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blocks.Abstract_Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.blocks.Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.client.model.block.*;
import com.github.L_Ender.cataclysm.client.model.entity.Coral_Bardiche_Model;
import com.github.L_Ender.cataclysm.client.model.entity.Coral_Spear_Model;
import com.github.L_Ender.cataclysm.client.model.item.*;
import com.github.L_Ender.cataclysm.client.render.blockentity.Cataclysm_Skull_Block_Renderer;
import com.github.L_Ender.cataclysm.init.ModBlocks;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.items.Cursed_bow;
import com.github.L_Ender.cataclysm.items.Laser_Gatling;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
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

    private static final Bulwark_of_the_flame_Model BULWARK_OF_THE_FLAME_MODEL = new Bulwark_of_the_flame_Model();
    private static final Black_Steel_Targe_Model BLACK_STEEL_TARGE_MODEL = new Black_Steel_Targe_Model();
    private static final EMP_Model EMP_MODEL = new EMP_Model();
    private static final Mechanical_Anvil_Model MF_MODEL = new Mechanical_Anvil_Model();
    private static final Gauntlet_of_Guard_Model GAUNTLET_OF_GUARD_MODEL = new Gauntlet_of_Guard_Model();
    private static final Gauntlet_of_Bulwark_Model GAUNTLET_OF_BULWARK_MODEL = new Gauntlet_of_Bulwark_Model();
    private static final Incinerator_Model THE_INCINERATOR_MODEL = new Incinerator_Model();
    private static final Coral_Spear_Model CORAL_SPEAR_MODEL = new Coral_Spear_Model();
    private static final Coral_Bardiche_Model CORAL_BARDICHE_MODEL = new Coral_Bardiche_Model();
    private static final Altar_of_Fire_Model ALTAR_OF_FIRE_MODEL = new Altar_of_Fire_Model();
    private static final Altar_of_Void_Model ALTAR_OF_VOID_MODEL = new Altar_of_Void_Model();
    private static final Altar_of_Amethyst_Model ALTAR_OF_AMETHYST_MODEL = new Altar_of_Amethyst_Model();
    private static final Altar_of_Abyss_Model ALTAR_OF_ABYSS_MODEL = new Altar_of_Abyss_Model();
    private static final Abyssal_Egg_Model ABYSSAL_MODEL = new Abyssal_Egg_Model();
    private static final Wither_Assault_SHoulder_Weapon_Model WASW_MODEL = new Wither_Assault_SHoulder_Weapon_Model();
    private static final Void_Forge_Model VOID_FORGE_MODEL = new Void_Forge_Model();
    private static final Tidal_Claws_Model TIDAL_CLAWS_MODEL = new Tidal_Claws_Model();
    private static final Meat_Shredder_Model MEAT_SHREDDER_MODEL = new Meat_Shredder_Model();
    private static final Laser_Gatling_Model LASER_GATLING_MODEL = new Laser_Gatling_Model();
    private static final Ancient_Spear_Model ANCIENT_SPEAR_MODEL = new Ancient_Spear_Model();
    private static final Cursed_Bow_Model CURSED_BOW_MODEL = new Cursed_Bow_Model();
    private static final The_Annihilator_Model THE_ANNIHILATOR = new The_Annihilator_Model();
    private static final Soul_render_Model SOUL_RENDER = new Soul_render_Model();
    private static final ResourceLocation CURSED_BOW_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/cursed_bow.png");
    private static final ResourceLocation CURSED_BOW_GHOST_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/cursed_bow_ghost.png");
    private static final ResourceLocation SOUL_RENDER_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/soul_render.png");
    private static final ResourceLocation SOUL_RENDER_GHOST_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/soul_render_ghost.png");
    private static final ResourceLocation THE_ANNIHILATOR_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/the_annihilator.png");
    private static final ResourceLocation THE_ANNIHILATOR_GHOST_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/the_annihilator_ghost.png");
    private static final ResourceLocation BULWARK_OF_THE_FLAME_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/bulwark_of_the_flame.png");
    private static final ResourceLocation BLACK_STEEL_TARGE_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/black_steel_targe.png");
    private static final ResourceLocation GAUNTLET_OF_GUARD_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/gauntlet_of_guard.png");
    private static final ResourceLocation GAUNTLET_OF_BULWARK_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/gauntlet_of_bulwark.png");
    private static final ResourceLocation GAUNTLET_OF_GUARD_LAYER_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/gauntlet_of_guard_layer.png");
    private static final ResourceLocation GAUNTLET_OF_BULWARK_LAYER_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/gauntlet_of_bulwark_layer.png");
    private static final ResourceLocation THE_INCINERATOR_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/the_incinerator.png");
    private static final ResourceLocation VOID_FORGE_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/void_forge.png");
    private static final ResourceLocation VOID_FORGE_LAYER_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/void_forge_layer.png");
    private static final ResourceLocation TIDAL_CLAWS_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/tidal_claws.png");
    private static final ResourceLocation MEAT_SHREDDER_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/meat_shredder.png");
    private static final ResourceLocation MEAT_SHREDDER_LAYER_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/meat_shredder_layer.png");
    private static final ResourceLocation LASER_GATLING_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/laser_gatling.png");
    private static final ResourceLocation LASER_GATLING_LAYER_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/laser_gatling_layer.png");
    private static final ResourceLocation ALTAR_OF_FIRE_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/altar_of_fire/altar_of_fire.png");
    private static final ResourceLocation ALTAR_OF_VOID_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/altar_of_void.png");
    private static final ResourceLocation ALTAR_OF_AMETHYST_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/altar_of_amethyst.png");
    private static final ResourceLocation ALTAR_OF_ABYSS_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/altar_of_abyss.png");
    private static final ResourceLocation ABYSSAL_EGG_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/abyssal_egg.png");
    private static final ResourceLocation ABYSSAL_EGG_LAYER_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/abyssal_egg_layer.png");
    private static final ResourceLocation MIF_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/mechanical_fusion_anvil.png");
    private static final ResourceLocation WASW_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/wither_assualt_shoulder_weapon.png");
    private static final ResourceLocation WASW_LAYER_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/wither_assualt_shoulder_weapon_layer.png");
    private static final ResourceLocation VASW_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/void_assualt_shoulder_weapon.png");
    private static final ResourceLocation VASW_LAYER_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/void_assualt_shoulder_weapon_layer.png");
    private static final ResourceLocation EMP_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/emp.png");
    private static final ResourceLocation[] TEXTURE_FIRE_PROGRESS = new ResourceLocation[8];
    private static final ResourceLocation CORAL_SPEAR_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/entity/coral_spear.png");
    private static final ResourceLocation CORAL_BARDICHE_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/entity/coral_bardiche.png");
    private static final ResourceLocation ANCIENT_SPEAR_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/ancient_spear.png");

    private Map<Cataclysm_Skull_Block.Type, Cataclysm_Skull_Model_Base> skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers(Minecraft.getInstance().getEntityModels());

    public static final Map<Cataclysm_Skull_Block.Type, ResourceLocation> SKIN_BY_TYPE = Util.make(Maps.newHashMap(), (p_261388_) -> {
        p_261388_.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, new ResourceLocation(Cataclysm.MODID,"textures/entity/koboleton/kobolediator.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.APTRGANGR, new ResourceLocation(Cataclysm.MODID,"textures/entity/draugar/aptrgangr.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.DRAUGR, new ResourceLocation(Cataclysm.MODID,"textures/entity/draugar/draugr.png"));
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
        if (itemStackIn.getItem() == ModItems.BLACK_STEEL_TARGE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(BLACK_STEEL_TARGE_TEXTURE), false, itemStackIn.hasFoil());
            BLACK_STEEL_TARGE_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.GAUNTLET_OF_GUARD.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.entityCutoutNoCull(GAUNTLET_OF_GUARD_TEXTURE), false, itemStackIn.hasFoil());
            GAUNTLET_OF_GUARD_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorFoilBuffer(bufferIn, CMRenderTypes.eyes(GAUNTLET_OF_GUARD_LAYER_TEXTURE), false, itemStackIn.hasFoil());
            GAUNTLET_OF_GUARD_MODEL.renderToBuffer(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.GAUNTLET_OF_BULWARK.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.entityCutoutNoCull(GAUNTLET_OF_BULWARK_TEXTURE), false, itemStackIn.hasFoil());
            GAUNTLET_OF_BULWARK_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorFoilBuffer(bufferIn, CMRenderTypes.eyes(GAUNTLET_OF_BULWARK_LAYER_TEXTURE), false, itemStackIn.hasFoil());
            GAUNTLET_OF_BULWARK_MODEL.renderToBuffer(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
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
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.entityCutoutNoCull(WASW_TEXTURE), false, itemStackIn.hasFoil());
            WASW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorFoilBuffer(bufferIn, CMRenderTypes.eyes(WASW_LAYER_TEXTURE), false, itemStackIn.hasFoil());
            WASW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.VOID_ASSULT_SHOULDER_WEAPON.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.entityCutoutNoCull(VASW_TEXTURE), false, itemStackIn.hasFoil());
            WASW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorFoilBuffer(bufferIn, CMRenderTypes.eyes(VASW_LAYER_TEXTURE), false, itemStackIn.hasFoil());
            WASW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
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
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.entityCutoutNoCull(VOID_FORGE_TEXTURE), false, itemStackIn.hasFoil());
            VOID_FORGE_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorFoilBuffer(bufferIn, CMRenderTypes.eyes(VOID_FORGE_LAYER_TEXTURE), false, itemStackIn.hasFoil());
            VOID_FORGE_MODEL.renderToBuffer(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);

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
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.entityCutoutNoCull(MEAT_SHREDDER_TEXTURE), false, itemStackIn.hasFoil());
            MEAT_SHREDDER_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorFoilBuffer(bufferIn, CMRenderTypes.CMEyes(MEAT_SHREDDER_LAYER_TEXTURE), false, itemStackIn.hasFoil());
            MEAT_SHREDDER_MODEL.renderToBuffer(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            MEAT_SHREDDER_MODEL.animateStack(itemStackIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.LASER_GATLING.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.entityCutoutNoCull(LASER_GATLING_TEXTURE), false, itemStackIn.hasFoil());
            float ageInTicks = Minecraft.getInstance().player == null ? 0F : Minecraft.getInstance().player.tickCount + partialTick;
            float openAmount = Minecraft.getInstance().player != null && Laser_Gatling.isCharged(itemStackIn) ? Minecraft.getInstance().player.tickCount + partialTick : 0;

            LASER_GATLING_MODEL.setupAnim(null, openAmount, 0, ageInTicks, 0, 0);
            LASER_GATLING_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorFoilBuffer(bufferIn, CMRenderTypes.eyes(LASER_GATLING_LAYER_TEXTURE), false, itemStackIn.hasFoil());
            LASER_GATLING_MODEL.renderToBuffer(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);

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

        if (itemStackIn.is(ModItems.SOUL_RENDER.get())) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5f, 0.5f);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(SOUL_RENDER_TEXTURE), false, itemStackIn.hasFoil());
            SOUL_RENDER.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorFoilBuffer(bufferIn, CMRenderTypes.getghost(SOUL_RENDER_GHOST_TEXTURE), false, itemStackIn.hasFoil());
            SOUL_RENDER.renderToBuffer(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.popPose();
        }

        if (itemStackIn.is(ModItems.THE_ANNIHILATOR.get())) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 0.5f, 0.5f);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferIn, RenderType.armorCutoutNoCull(THE_ANNIHILATOR_TEXTURE), false, itemStackIn.hasFoil());
            THE_ANNIHILATOR.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorFoilBuffer(bufferIn, CMRenderTypes.getghost(THE_ANNIHILATOR_GHOST_TEXTURE), false, itemStackIn.hasFoil());
            THE_ANNIHILATOR.renderToBuffer(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
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

    private void renderMapHand(PoseStack poseStack, MultiBufferSource bufferSource, int i, HumanoidArm humanoidArm) {
        RenderSystem.setShaderTexture(0, Minecraft.getInstance().player.getSkinTextureLocation());
        PlayerRenderer playerrenderer = (PlayerRenderer)Minecraft.getInstance().getEntityRenderDispatcher().<AbstractClientPlayer>getRenderer(Minecraft.getInstance().player);
        poseStack.pushPose();
        float f = humanoidArm == HumanoidArm.RIGHT ? 1.0F : -1.0F;
        poseStack.mulPose(Axis.YP.rotationDegrees(92.0F));
        poseStack.mulPose(Axis.XP.rotationDegrees(45.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(f * -41.0F));
        poseStack.translate(f * 0.3F, -1.1F, 0.45F);
        if (humanoidArm == HumanoidArm.RIGHT) {
            playerrenderer.renderRightHand(poseStack, bufferSource, i, Minecraft.getInstance().player);
        } else {
            playerrenderer.renderLeftHand(poseStack, bufferSource, i, Minecraft.getInstance().player);
        }

        poseStack.popPose();
    }


    private ResourceLocation getIdleTexture(int age) {
        return TEXTURE_FIRE_PROGRESS[Mth.clamp(age, 0, 7)];
    }

}
