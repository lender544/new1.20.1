package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Clearable;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class AltarOfAbyss_Block_Entity extends BlockEntity implements Clearable {

    public int tickCount;
    private static final int NUM_SLOTS = 1;
    private NonNullList<ItemStack> items = NonNullList.withSize(NUM_SLOTS, ItemStack.EMPTY);
    public boolean summoningthis = false;
    public int summoningticks = 0;
    private float chompProgress;
    private float prevChompProgress;
    private final RandomSource rnd = RandomSource.create();

    public AltarOfAbyss_Block_Entity(BlockPos pos, BlockState state) {
        super(ModTileentites.ALTAR_OF_ABYSS.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, AltarOfAbyss_Block_Entity entity) {
        entity.tick();

    }

    public void tick() {
        tickCount++;
        summoningthis = false;
        prevChompProgress = chompProgress;
        if (!this.getItem(0).isEmpty()) {
            if(this.getItem(0).getItem() == ModItems.ABYSSAL_SACRIFICE.get()){
                summoningthis = true;
                if(summoningticks == 1) {
                    ScreenShake_Entity.ScreenShake(this.level, Vec3.atCenterOf(this.getBlockPos()), 20, 0.03f, 0, 150);
                    //   this.level.addFreshEntity(new Flame_Strike_Entity(this.level, this.getBlockPos().getX() + 0.5F, this.getBlockPos().getY(), this.getBlockPos().getZ() + 0.5F, 0, 0, 100, 0, 2.5F, false, null));
                }
                if(summoningticks > 118 && summoningticks < 121) {
                    Sphereparticle(3,3);
                }
                if(summoningticks > 121) {
                    this.items.set(0, ItemStack.EMPTY);
                    BlockBreaking(3, 6, 3);
                    The_Leviathan_Entity leviathan = ModEntities.THE_LEVIATHAN.get().create(level);
                    if (leviathan != null) {
                        leviathan.setPos(this.getBlockPos().getX() + 0.5F, this.getBlockPos().getY() + 3, this.getBlockPos().getZ() + 0.5F);
                        if (!level.isClientSide) {
                            level.addFreshEntity(leviathan);
                        }
                    }
                }

            }
        }

        if(summoningthis && chompProgress < 30F){
            chompProgress++;
        }
        if(!summoningthis && chompProgress > 0F){
            chompProgress--;
        }

        if(!summoningthis){
            summoningticks = 0;
        }else{
            summoningticks++;
        }
    }

    public float getChompProgress(float partialTick){
        return prevChompProgress + (chompProgress - prevChompProgress) * partialTick;
    }

    private void BlockBreaking(int x, int y, int z) {
        //this.level.destroyBlock(this.getBlockPos(), false);
        int MthX = Mth.floor(this.getBlockPos().getX());
        int MthY = Mth.floor(this.getBlockPos().getY());
        int MthZ = Mth.floor(this.getBlockPos().getZ());
        for (int k2 = -x; k2 <= x; ++k2) {
            for (int l2 = -z; l2 <= z; ++l2) {
                for (int j = 0; j <= y; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    BlockState block = this.level.getBlockState(blockpos);
                    if (block != Blocks.AIR.defaultBlockState() && !block.is(ModTag.ALTAR_DESTROY_IMMUNE)) {
                        this.level.destroyBlock(blockpos, false);
                    }

                }
            }
        }
    }


    private void Sphereparticle(float height, float size) {
        double d0 = this.getBlockPos().getX() + 0.5F;
        double d1 = this.getBlockPos().getY() + height;
        double d2 = this.getBlockPos().getZ() + 0.5F;
        for (float i = -size; i <= size; ++i) {
            for (float j = -size; j <= size; ++j) {
                for (float k = -size; k <= size; ++k) {
                    double d3 = (double) j + (this.rnd.nextDouble() - this.rnd.nextDouble()) * 0.5D;
                    double d4 = (double) i + (this.rnd.nextDouble() - this.rnd.nextDouble()) * 0.5D;
                    double d5 = (double) k + (this.rnd.nextDouble() - this.rnd.nextDouble()) * 0.5D;
                    double d6 = (double) Mth.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + this.rnd.nextGaussian() * 0.05D;

                    this.level.addParticle(ParticleTypes.REVERSE_PORTAL, d0, d1, d2, d3 / d6, d4 / d6, d5 / d6);

                    if (i != -size && i != size && j != -size && j != size) {
                        k += size * 2 - 1;

                    }
                }
            }
        }
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public int getContainerSize() {
        return this.items.size();
    }

    public ItemStack getItem(int index) {
        return this.items.get(index);
    }

    public void setItem(int index, ItemStack stack) {
        this.getItems().set(index, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }
    }

    public void placeItem(@Nullable LivingEntity entity, int index, ItemStack stack) {
        this.getItems().set(index, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }

        this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
        this.markUpdated();
    }


    public int getMaxStackSize() {
        return 1;
    }

    public void loadAdditional(CompoundTag p_155312_, HolderLookup.Provider p_324612_) {
        super.loadAdditional(p_155312_,p_324612_);
        this.items.clear();
        ContainerHelper.loadAllItems(p_155312_, this.items, p_324612_);

    }

    protected void saveAdditional(CompoundTag p_187486_, HolderLookup.Provider p_324612_) {
        super.saveAdditional(p_187486_,p_324612_);
        ContainerHelper.saveAllItems(p_187486_, this.items, true, p_324612_);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }



    public CompoundTag getUpdateTag(HolderLookup.Provider p_324612_) {
        CompoundTag compoundtag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundtag, this.items, true, p_324612_);
        return compoundtag;
    }

    private void markUpdated() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    public void dowse() {
        if (this.level != null) {
            this.markUpdated();
        }
    }

    @Override
    protected void applyImplicitComponents(BlockEntity.DataComponentInput p_338534_) {
        super.applyImplicitComponents(p_338534_);
        p_338534_.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyInto(this.getItems());
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder p_338620_) {
        super.collectImplicitComponents(p_338620_);
        p_338620_.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getItems()));
    }

    @Override
    public void removeComponentsFromTag(CompoundTag p_332690_) {
        p_332690_.remove("Items");
    }
}
