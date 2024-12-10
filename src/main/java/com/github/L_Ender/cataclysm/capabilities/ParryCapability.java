package com.github.L_Ender.cataclysm.capabilities;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;

public class ParryCapability {
    public static ResourceLocation ID = new ResourceLocation(Cataclysm.MODID, "parry_cap");


    public interface IParryCapability extends INBTSerializable<CompoundTag> {



        void setParryFrame(int frame);

        int getParryFrame();

    }

    public static class ParryCapabilityImp implements IParryCapability {

        public int frame;




        @Override
        public void setParryFrame(int timer) {
            this.frame = timer;
        }

        @Override
        public int getParryFrame() {
            return frame;
        }

        @Override
        public CompoundTag serializeNBT() {
            CompoundTag tag = new CompoundTag();
            tag.putInt("frame", this.getParryFrame());
            return tag;
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            this.setParryFrame(nbt.getInt("frame"));

        }

        public static class ParryProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
            private final LazyOptional<ParryCapability.IParryCapability> instance = LazyOptional.of(ParryCapabilityImp::new);

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
                return ModCapabilities.PARRY_CAPABILITY.orEmpty(cap, instance.cast());
            }
        }
    }
}
