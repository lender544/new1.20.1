package com.github.L_Ender.cataclysm.mixin.accessor;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(StructureTemplatePool.class)
public interface StructureTemplatePoolAccessor {
    @Accessor
    List<Pair<StructurePoolElement, Integer>> getRawTemplates();
}
