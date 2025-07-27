package com.github.L_Ender.cataclysm.blocks.Property;

import com.github.L_Ender.cataclysm.init.ModSounds;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public enum CustomNoteBlockInstrument {
    KOBOLEDIATOR("kobolediator", ModSounds.NOTE_BLOCK_IMITATE_KOBOLEDIATOR, NoteBlockInstrument.Type.MOB_HEAD),
    APTRGANGR("aptrgangr", ModSounds.NOTE_BLOCK_IMITATE_APTRGANGR, NoteBlockInstrument.Type.MOB_HEAD),
    DRAUGR("draugr", ModSounds.NOTE_BLOCK_IMITATE_DRAUGR, NoteBlockInstrument.Type.MOB_HEAD);

    private final String string;
    private final Holder<SoundEvent> soundEvent;
    private final NoteBlockInstrument.Type type;

    CustomNoteBlockInstrument(String string, Holder sound, NoteBlockInstrument.Type type) {
        this.string = string;
        this.soundEvent = sound;
        this.type = type;
    }

    public NoteBlockInstrument.Type getType() {
        return type;
    }

    public Holder<SoundEvent> getSoundEvent() {
        return soundEvent;
    }

    public String getString() {
        return string;
    }

    public NoteBlockInstrument get() {
        return NoteBlockInstrument.valueOf(this.name());
    }
}
