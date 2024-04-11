package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.util.CustomTabBehavior;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModGroup {


    public static final DeferredRegister<CreativeModeTab> DEF_REG = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cataclysm.MODID);

    public static final RegistryObject<CreativeModeTab> TAB = DEF_REG.register("cataclysm", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.cataclysm"))
            .icon(ModGroup::makeIcon)
            .displayItems((enabledFeatures, output) -> {
                for(RegistryObject<Item> item : ModItems.ITEMS.getEntries()){
                    if(item.get() instanceof CustomTabBehavior customTabBehavior){
                        customTabBehavior.fillItemCategory(output);
                    }else{
                        output.accept(item.get());
                    }
                }
            })
            .build());


    private static ItemStack makeIcon() {
        ItemStack stack = new ItemStack(ModItems.THE_INCINERATOR.get());
        CompoundTag tag = new CompoundTag();
        tag.putBoolean("IsCreativeTab", true);
        stack.setTag(tag);
        return stack;
    }

}

