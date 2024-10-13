package com.github.L_Ender.cataclysm.world.structures.targetselector;

import com.github.L_Ender.cataclysm.structures.jisaw.PieceEntry;
import com.github.L_Ender.cataclysm.structures.jisaw.context.StructureContext;
import com.mojang.serialization.Codec;

import java.util.ArrayList;
import java.util.List;

/**
 * Target selector that returns the piece currently undergoing modification.
 */
public class SelfTargetSelector extends StructureTargetSelector {
    private static final SelfTargetSelector INSTANCE = new SelfTargetSelector();
    public static final Codec<SelfTargetSelector> CODEC = Codec.unit(() -> INSTANCE);

    public SelfTargetSelector() {
    }

    @Override
    public StructureTargetSelectorType<?> type() {
        return StructureTargetSelectorType.SELF;
    }

    @Override
    public List<PieceEntry> apply(StructureContext ctx) {
        List<PieceEntry> list = new ArrayList<>();

        if (ctx.pieceEntry() != null) {
            list.add(ctx.pieceEntry());
        }

        return list;
    }
}
