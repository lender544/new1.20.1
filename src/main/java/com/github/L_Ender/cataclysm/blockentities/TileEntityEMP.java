package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.blocks.EMP_Block;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;

import com.github.L_Ender.cataclysm.init.ModTileentites;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TileEntityEMP extends BlockEntity {

    private float chompProgress;
    private float prevChompProgress;
    public int ticksExisted;

    public TileEntityEMP(BlockPos pos, BlockState state) {
        super(ModTileentites.EMP.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, TileEntityEMP entity) {
        entity.tick();

    }

    public void tick() {
        prevChompProgress = chompProgress;
        boolean powered = false;
        if(getBlockState().getBlock() instanceof EMP_Block){
            powered = getBlockState().getValue(EMP_Block.POWERED);
        }
        boolean overload = false;
        if(getBlockState().getBlock() instanceof EMP_Block){
            overload = getBlockState().getValue(EMP_Block.OVERLOAD);
        }

        if(powered && chompProgress < 15F){
            chompProgress++;
        }
        if(!powered && chompProgress > 0F){
            chompProgress--;
        }
        float x = this.getBlockPos().getX() + 0.5F;
        float y = this.getBlockPos().getY() + 0.5f;
        float z = this.getBlockPos().getZ() + 0.5F;

        if(!overload && chompProgress == 15F ){
            level.addParticle(ModParticle.EM_PULSE.get(), x, y, z, 0, 0, 0);
            ScreenShake_Entity.ScreenShake(this.level, Vec3.atCenterOf(this.getBlockPos()), 20, 0.01f, 0, 20);
            level.playSound((Player)null, this.getBlockPos(), ModSounds.EMP_ACTIVATED.get(), SoundSource.BLOCKS, 4F, level.random.nextFloat() * 0.2F + 1.0F);
            level.setBlockAndUpdate(this.getBlockPos(), getBlockState().setValue(EMP_Block.OVERLOAD, true));
            AABB screamBox = new AABB(this.getBlockPos().getX() - 5f, this.getBlockPos().getY() - 5F, this.getBlockPos().getZ() - 5, this.getBlockPos().getX() + 5, this.getBlockPos().getY() + 5F, this.getBlockPos().getZ() + 5F);
            for(LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, screamBox)){
               entity.hurt(CMDamageTypes.getDamageSource(level, CMDamageTypes.EMP), 3 + entity.getRandom().nextInt(3));

            }
        }
        ticksExisted++;
    }

    public float getChompProgress(float partialTick){
        return prevChompProgress + (chompProgress - prevChompProgress) * partialTick;
    }

}
