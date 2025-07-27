package com.github.L_Ender.cataclysm.mixin;

import com.github.L_Ender.cataclysm.blocks.Property.CustomNoteBlockInstrument;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(NoteBlockInstrument.class)
public class NoteBlockInstrumentMixin {
    @Shadow
    @Mutable
    @Final
    private static NoteBlockInstrument[] $VALUES;

    @Invoker("<init>")
    public static NoteBlockInstrument newInstrument(String name, int id, String enumName, Holder sound, NoteBlockInstrument.Type type) {
        throw new AssertionError();
    }

    @Inject(method = "<clinit>", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/NoteBlockInstrument;$VALUES:[Lnet/minecraft/world/level/block/state/properties/NoteBlockInstrument;", shift = At.Shift.AFTER))
    private static void US$addCustomInstruments(CallbackInfo ci) {
        List<NoteBlockInstrument> instruments = new ArrayList<>(Arrays.asList($VALUES));
        NoteBlockInstrument last = instruments.get(instruments.size() - 1);
        int i = 1;
        for (CustomNoteBlockInstrument instrument : CustomNoteBlockInstrument.values()) {
            instruments.add(newInstrument(instrument.name(),
                    last.ordinal() + i,
                    instrument.getString(),
                    instrument.getSoundEvent(),
                    instrument.getType())
            );
            i++;
        }
        $VALUES = instruments.toArray(new NoteBlockInstrument[0]);
    }
}