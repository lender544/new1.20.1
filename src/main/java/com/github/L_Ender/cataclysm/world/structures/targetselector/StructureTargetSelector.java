package com.github.L_Ender.cataclysm.world.structures.targetselector;

import com.github.L_Ender.cataclysm.structures.jisaw.PieceEntry;
import com.github.L_Ender.cataclysm.structures.jisaw.context.StructureContext;


import java.util.List;
/**
 * A serializable class used for selecting a list of {@link PieceEntry}s during world generation.
 */
public abstract class StructureTargetSelector {
    abstract public StructureTargetSelectorType<?> type();
    abstract public List<PieceEntry> apply(StructureContext ctx);
}
