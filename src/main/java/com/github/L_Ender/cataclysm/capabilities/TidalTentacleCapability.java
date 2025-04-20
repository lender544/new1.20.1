package com.github.L_Ender.cataclysm.capabilities;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

public class TidalTentacleCapability {
    public static ResourceLocation ID = new ResourceLocation(Cataclysm.MODID, "tentacle_cap");

    public interface ITentacleCapability extends INBTSerializable<CompoundTag> {

        void setHasTentacle(boolean hasTentacle);

        boolean hasTentacle();

        void setLastTentacleID(int id);

        int getLastTentacleID();

        UUID getLastTentacleUUID();

        void setLastTentacleUUID(UUID livingEntity);

    }

    public static class TentacleCapabilityImp implements ITentacleCapability {
        private UUID lastTentacle;
        private boolean tentacle;
        public int id;

        @Override
        public void setHasTentacle(boolean Tentacle) {
            this.tentacle = Tentacle;
        }

        @Override
        public boolean hasTentacle() {
            return this.tentacle;
        }

        @Override
        public void setLastTentacleID(int frozenPitch) {
            this.id = frozenPitch;
        }

        @Override
        public int getLastTentacleID() {
            return id;
        }

        @Override
        public void setLastTentacleUUID(UUID livingEntity) {
            lastTentacle = livingEntity;
        }

        @Override
        public UUID getLastTentacleUUID() {
            return lastTentacle;
        }



        @Override
        public CompoundTag serializeNBT() {
            CompoundTag tag = new CompoundTag();
            tag.putBoolean("hasTentacle", this.hasTentacle());
            tag.putInt("getLastTentacleID", this.getLastTentacleID());
            if (getLastTentacleUUID() != null) {
                tag.putUUID("getLastTentacleUUID", getLastTentacleUUID());
            }
            return tag;
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            this.setHasTentacle(nbt.getBoolean("hasTentacle"));
            this.setLastTentacleID(nbt.getInt("getLastTentacleID"));
            try {
                setLastTentacleUUID(nbt.getUUID("getLastTentacleUUID"));
            }
            catch (NullPointerException ignored) {}
        }

        public static class TentacleProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
            private final LazyOptional<ITentacleCapability> instance = LazyOptional.of(TidalTentacleCapability.TentacleCapabilityImp::new);

            @Override
            public CompoundTag serializeNBT() {
                return instance.orElseThrow(NullPointerException::new).serializeNBT();
            }

            @Override
            public void deserializeNBT(CompoundTag nbt) {
                instance.orElseThrow(NullPointerException::new).deserializeNBT(nbt);
            }

            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
                return ModCapabilities.TENTACLE_CAPABILITY.orEmpty(cap, instance.cast());
            }
        }
    }
}
