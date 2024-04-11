package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

import java.util.ArrayList;
import java.util.List;

public class Void_Scatter_Arrow_Entity extends AbstractArrow {

    public Void_Scatter_Arrow_Entity(EntityType type, Level worldIn) {
        super(type, worldIn);
    }

    public Void_Scatter_Arrow_Entity(EntityType type, double x, double y, double z, Level worldIn) {
        this(type, worldIn);
        this.setPos(x, y, z);
    }

    public Void_Scatter_Arrow_Entity(Level worldIn, LivingEntity shooter) {
        this(ModEntities.VOID_SCATTER_ARROW.get(), shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
        this.setOwner(shooter);
        if (shooter instanceof Player) {
            this.pickup = Pickup.ALLOWED;
        }
    }

    public Void_Scatter_Arrow_Entity(PlayMessages.SpawnEntity spawnEntity, Level world) {
        this(ModEntities.VOID_SCATTER_ARROW.get(), world);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(Items.ARROW);
    }


    @Override
    protected void onHit(HitResult hit) {
        super.onHit(hit);
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        if (this.level().isClientSide){
            for (int l2 = 0; l2 < 8; ++l2) {
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(ModItems.VOID_SCATTER_ARROW.get())), x, y, z, random.nextGaussian() * 0.1D, random.nextDouble() * 0.15D, random.nextGaussian() * 0.1D);
            }
        }
        else {
            List<Vec3> directions = getShootVectors(this.random,0);
            for (Vec3 vec : directions) {
                Entity target = null;
                Direction dir = Direction.UP;
                if (hit.getType() == HitResult.Type.ENTITY) {
                    target = ((EntityHitResult) hit).getEntity();
                } else if (hit.getType() == HitResult.Type.BLOCK) {
                    dir = ((BlockHitResult)hit).getDirection();
                }
                vec = vec.scale(0.35f);
                vec = this.mulPoseVector(vec,dir);
                Void_Shard_Entity shard = new Void_Shard_Entity(level(), (LivingEntity) this.getOwner(),
                        x+vec.x,y+vec.y+0.25, vec.z+z, vec, target);
                level().addFreshEntity(shard);
            }

            this.playSound(SoundEvents.GLASS_BREAK, 1.1F, 0.8F);

        }
        this.discard();
    }

    public List<Vec3> getShootVectors(RandomSource random, float uncertainty){
        List<Vec3> vectors = new ArrayList<>();
        float turnFraction = (1 + Mth.sqrt(5))/2;
        int numPoints = 17;
        double fullness = 0.8;
        for (int i = 1; i <= numPoints; i++){
            float dst = i / ((float)numPoints);
            //in degrees cause Mth sin are in deg
            float inclination = (random.nextFloat() - 0.5f) * uncertainty
                    + (float) (  Math.acos(1 - fullness * dst));
            float azimuth = (float) ((random.nextFloat() - 0.5f) * uncertainty
                    + (2f*Math.PI) * (random.nextFloat() + (turnFraction * i)));

            double x = Math.sin(inclination) * Math.cos(azimuth);
            double z = Math.sin(inclination) * Math.sin(azimuth);
            double y = Math.cos(inclination);

            Vec3 vec = new Vec3(x, y, z);

            if(i==1){
                vec = vec.add(0, 1,0);
                vec = vec.scale(0.5);
            }

            vectors.add(vec);
        }
        return vectors;
    }

    private Vec3 mulPoseVector(Vec3 v, Direction dir){
        switch (dir){
            default:
            case UP:
                return v;
            case DOWN:
                return v.multiply(0d,-1d,0d);
            case NORTH:
                return new Vec3(v.z,v.x,-v.y);
            case SOUTH:
                return new Vec3(v.z,v.x,v.y);
            case WEST:
                return new Vec3(-v.y,v.z,v.x);
            case EAST:
                return new Vec3(v.y,v.z,v.x);

        }
    }
}
