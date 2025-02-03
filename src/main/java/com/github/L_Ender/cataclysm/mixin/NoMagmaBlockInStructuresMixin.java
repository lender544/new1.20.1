package com.github.L_Ender.cataclysm.mixin;

import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.MixinUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.SectionPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.UnderwaterMagmaFeature;
import net.minecraft.world.level.levelgen.feature.configurations.DeltaFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(UnderwaterMagmaFeature.class)
public class NoMagmaBlockInStructuresMixin {

    @Inject(
            method = "place(Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;)Z",
            cancellable = true,
            at = @At(value = "HEAD")
    )
    private void cataclysm_noMagmablockInStructures(FeaturePlaceContext<DeltaFeatureConfiguration> context, CallbackInfoReturnable<Boolean> cir) {
        if(!(context.level() instanceof WorldGenRegion worldGenRegion)) {
            return;
        }

        if (MixinUtils.isPositionInTaggedStructure(worldGenRegion, context.origin(), ModTag.BLOCKED_MAGMA_BLOCK)) {
            cir.setReturnValue(false);
        }

    }
}
