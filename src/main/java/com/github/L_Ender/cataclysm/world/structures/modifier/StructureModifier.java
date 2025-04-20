package com.github.L_Ender.cataclysm.world.structures.modifier;

import com.github.L_Ender.cataclysm.structures.jisaw.PieceEntry;
import com.github.L_Ender.cataclysm.structures.jisaw.condition.StructureCondition;
import com.github.L_Ender.cataclysm.structures.jisaw.condition.StructureConditionType;
import com.github.L_Ender.cataclysm.structures.jisaw.context.StructureContext;
import com.github.L_Ender.cataclysm.world.structures.action.StructureAction;
import com.github.L_Ender.cataclysm.world.structures.action.StructureActionType;
import com.github.L_Ender.cataclysm.world.structures.targetselector.StructureTargetSelector;
import com.github.L_Ender.cataclysm.world.structures.targetselector.StructureTargetSelectorType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;

/**
 */
public class StructureModifier {
    public static final Codec<StructureModifier> CODEC = RecordCodecBuilder.create((builder) -> builder
            .group(
                    StructureConditionType.CONDITION_CODEC.fieldOf("condition").forGetter(modifier -> modifier.condition),
                    StructureActionType.ACTION_CODEC.listOf().fieldOf("actions").forGetter(modifier -> modifier.actions),
                    StructureTargetSelectorType.TARGET_SELECTOR_CODEC.fieldOf("target_selector").forGetter(modifier -> modifier.targetSelector))
            .apply(builder, StructureModifier::new));

    private final StructureCondition condition;
    private final List<StructureAction> actions;
    private final StructureTargetSelector targetSelector;

    public StructureModifier(StructureCondition condition, List<StructureAction> actions, StructureTargetSelector targetSelector) {
        this.condition = condition;
        this.actions = actions;
        this.targetSelector = targetSelector;
    }

    public boolean apply(StructureContext structureContext) {
        // Validate condition
        if (!this.condition.passes(structureContext)) {
            return false;
        }

        // Validate target
        List<PieceEntry> targets = this.targetSelector.apply(structureContext);

        // Apply actions to each target
        for (PieceEntry target : targets) {
            this.actions.forEach(action -> action.apply(structureContext, target));
        }

        return true;
    }
}
