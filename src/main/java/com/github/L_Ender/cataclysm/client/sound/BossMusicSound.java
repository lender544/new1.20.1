package com.github.L_Ender.cataclysm.client.sound;

import com.github.L_Ender.cataclysm.client.tool.ControlledAnimation;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.etc.Animation_Monsters;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public class BossMusicSound extends AbstractTickableSoundInstance {
    private Animation_Monsters boss;
    private int ticksExisted = 0;
    private int timeUntilFade;

    private final SoundEvent soundEvent;
    ControlledAnimation volumeControl;

    public BossMusicSound(SoundEvent sound, Animation_Monsters boss) {
        super(sound, SoundSource.RECORDS,boss.getRandom());
        this.boss = boss;
        this.soundEvent = sound;
        this.attenuation = Attenuation.NONE;
        this.looping = true;
        this.delay = 0;
        this.x = boss.getX();
        this.y = boss.getY();
        this.z = boss.getZ();

        volumeControl = new ControlledAnimation(40);
        volumeControl.setTimer(20);
        volume = volumeControl.getAnimationFraction();
        timeUntilFade = 80;
    }

    public boolean canPlaySound() {
        return BossMusicPlayer.bossMusic == this;
    }

    public void tick() {
        // If the music should stop playing
        if (boss == null || !boss.isAlive() || boss.isSilent()) {
            // If the boss is dead, skip the fade timer and fade out right away
            if (boss != null && !boss.isAlive()) timeUntilFade = 0;
            boss = null;
            if (timeUntilFade > 0) timeUntilFade--;
            else volumeControl.decreaseTimer();
        }
        // If the music should keep playing
        else {
            volumeControl.increaseTimer();
            timeUntilFade = 15;
        }

        if (volumeControl.getAnimationFraction() < 0.025) {
            stop();
            BossMusicPlayer.bossMusic = null;
        }

        volume = volumeControl.getAnimationFraction() / CMConfig.BossMusicVolume;

        if (ticksExisted % 100 == 0) {
            Minecraft.getInstance().getMusicManager().stopPlaying();
        }
        ticksExisted++;
    }

    public void setBoss(Animation_Monsters boss) {
        this.boss = boss;
    }

    public Animation_Monsters getBoss() {
        return boss;
    }

    public SoundEvent getSoundEvent() {
        return soundEvent;
    }
}