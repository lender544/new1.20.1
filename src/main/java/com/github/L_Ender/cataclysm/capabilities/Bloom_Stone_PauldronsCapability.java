package com.github.L_Ender.cataclysm.capabilities;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nonnull;
import java.util.UUID;

public class Bloom_Stone_PauldronsCapability {
    public static ResourceLocation ID = new ResourceLocation(Cataclysm.MODID, "pauldrons_cap");

    public interface IBloom_Stone_PauldronsCapability extends INBTSerializable<CompoundTag> {



        void tick(TickEvent.PlayerTickEvent event);

        void setBurrow(boolean getBurrow);

        boolean isBurrow();
    }

    public static class Bloom_Stone_PauldronsCapabilityImp implements IBloom_Stone_PauldronsCapability {


        private boolean burrow;

        private static final AttributeModifier BURROW_KNOCKBACK_RESISTANCE = new AttributeModifier(UUID.fromString("2c0cabf5-c8bb-426f-8052-451db5bd77c5"), "knockback resistance addition", 1.0F, AttributeModifier.Operation.ADDITION);
        private static final AttributeModifier BURROW_ARMOR = new AttributeModifier(UUID.fromString("f9a7a24f-fcdf-4e5b-bfe2-47f6f2fd5f87"), "armor addition", 4.0F, AttributeModifier.Operation.ADDITION);
        private static final AttributeModifier BURROW_ARMOR_TOUGHNESS = new AttributeModifier(UUID.fromString("5c02c2d3-8479-4b8d-8579-fdad8ef94164"), "armor toughness addition", 3.0F, AttributeModifier.Operation.ADDITION);


        @Override
        public void tick(TickEvent.PlayerTickEvent event) {
            Player player = event.player;
            AttributeInstance attributeinstance = player.getAttribute(Attributes.KNOCKBACK_RESISTANCE);
            AttributeInstance attributeinstance2 = player.getAttribute(Attributes.ARMOR);
            AttributeInstance attributeinstance3 = player.getAttribute(Attributes.ARMOR_TOUGHNESS);

            if (!player.getCooldowns().isOnCooldown(ModItems.BLOOM_STONE_PAULDRONS.get()) && !player.getItemBySlot(EquipmentSlot.CHEST).isEmpty() && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.BLOOM_STONE_PAULDRONS.get() && player.onGround()) {
                if(player.isShiftKeyDown()) {
                    player.setPose(Pose.SWIMMING);
                    if (!attributeinstance.hasModifier(BURROW_KNOCKBACK_RESISTANCE)) {
                        attributeinstance.addTransientModifier(BURROW_KNOCKBACK_RESISTANCE);
                    }
                    if (!attributeinstance2.hasModifier(BURROW_ARMOR)) {
                        attributeinstance2.addTransientModifier(BURROW_ARMOR);
                    }
                    if (!attributeinstance3.hasModifier(BURROW_ARMOR_TOUGHNESS)) {
                        attributeinstance3.addTransientModifier(BURROW_ARMOR_TOUGHNESS);
                    }
                    if (!burrow) {
                        setBurrow(true);
                        if (player.level().isClientSide) {
                            for (int i1 = 0; i1 < 80 + player.getRandom().nextInt(12); i1++) {
                                double DeltaMovementX = player.getRandom().nextGaussian() * 0.07D;
                                double DeltaMovementY = player.getRandom().nextGaussian() * 0.1D;
                                double DeltaMovementZ = player.getRandom().nextGaussian() * 0.07D;
                                float angle = (0.01745329251F * player.yBodyRot) + i1;
                                double extraX = 1.0f * Mth.sin((float) (Math.PI + angle));
                                double extraY = 0.3F;
                                double extraZ = 1.0f * Mth.cos(angle);
                                int hitX = Mth.floor(player.getX() );
                                int hitY = Mth.floor(player.getY());
                                int hitZ = Mth.floor(player.getZ() );
                                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                                BlockState block = player.level().getBlockState(hit.below());
                                player.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), player.getX() + extraX, player.getY() + extraY, player.getZ() + extraZ , DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                            }

                        }
                        int hitX = Mth.floor(player.getX());
                        int hitY = Mth.floor(player.getY());
                        int hitZ = Mth.floor(player.getZ());
                        BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                        BlockState block = player.level().getBlockState(hit.below());
                        SoundType soundtype = block.getSoundType(player.level(), hit, player);
                        player.level().playSound((Player) null, player, soundtype.getBreakSound(), SoundSource.PLAYERS, 3.0f, 0.8F + player.getRandom().nextFloat() * 0.1F);

                    }
                }else{
                    if (burrow) {
                        for (int i = 0; i < 8; i++) {
                            float throwAngle = i * Mth.PI / 4F;
                            double sx = player.getX() + (Mth.cos(throwAngle) * 1);
                            double sy = player.getY() + (player.getBbHeight() * 0.5D);
                            double sz = player.getZ() + (Mth.sin(throwAngle) * 1);

                            double vx = Mth.cos(throwAngle);
                            double vy = 0 + player.getRandom().nextFloat() * 0.3F;
                            double vz = Mth.sin(throwAngle);
                            double v3 = Mth.sqrt((float) (vx * vx + vz * vz));
                            Amethyst_Cluster_Projectile_Entity projectile = new Amethyst_Cluster_Projectile_Entity(ModEntities.AMETHYST_CLUSTER_PROJECTILE.get(), player.level(), player);

                            projectile.moveTo(sx, sy, sz, i * 11.25F, player.getXRot());
                            float speed = 0.8F;
                            projectile.shoot(vx, vy + v3 * 0.20000000298023224D, vz, speed, 1.0F);
                            player.level().addFreshEntity(projectile);
                        }
                        player.getCooldowns().addCooldown(ModItems.BLOOM_STONE_PAULDRONS.get(), 240);
                        setBurrow(false);
                    }
                }
            }else{
                if(attributeinstance.hasModifier(BURROW_KNOCKBACK_RESISTANCE)) {
                    attributeinstance.removeModifier(BURROW_KNOCKBACK_RESISTANCE);
                }
                if(attributeinstance2.hasModifier(BURROW_ARMOR)) {
                    attributeinstance2.removeModifier(BURROW_ARMOR);
                }

                if(attributeinstance3.hasModifier(BURROW_ARMOR_TOUGHNESS)) {
                    attributeinstance3.removeModifier(BURROW_ARMOR_TOUGHNESS);
                }

                setBurrow(false);
            }
        }


        @Override
        public void setBurrow(boolean burrow) {
            this.burrow = burrow;
        }

        @Override
        public boolean isBurrow() {
            return this.burrow;
        }

        @Override
        public CompoundTag serializeNBT() {
            CompoundTag tag = new CompoundTag();
            tag.putBoolean("isBurrow", this.isBurrow());
            return tag;
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            this.setBurrow(nbt.getBoolean("isBurrow"));
        }

        public static class Bloom_Stone_PauldronsProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
            private final LazyOptional<IBloom_Stone_PauldronsCapability> instance = LazyOptional.of(Bloom_Stone_PauldronsCapabilityImp::new);

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
                return ModCapabilities.BLOOM_STONE_PAULDRONS_CAPABILITY_CAPABILITY.orEmpty(cap, instance.cast());
            }
        }
    }
}
