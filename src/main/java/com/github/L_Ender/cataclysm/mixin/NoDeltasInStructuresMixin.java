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
import net.minecraft.world.level.levelgen.feature.DeltaFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.DeltaFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(DeltaFeature.class)
public class NoDeltasInStructuresMixin {

    @Inject(
            method = "place(Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;)Z",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void cataclysm_noDeltasInStructures(FeaturePlaceContext<DeltaFeatureConfiguration> context, CallbackInfoReturnable<Boolean> cir) {
        if(!(context.level() instanceof WorldGenRegion worldGenRegion)) {
            return;
        }

        if (MixinUtils.isPositionInTaggedStructure(worldGenRegion, context.origin(), ModTag.BLOCKED_BASALT)) {
            cir.setReturnValue(false);
        }
    }
}
