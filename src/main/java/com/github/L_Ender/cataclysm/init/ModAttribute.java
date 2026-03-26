package com.github.L_Ender.cataclysm.init;


import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Cataclysm.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModAttribute {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, Cataclysm.MODID);

    public static final RegistryObject<Attribute> ADDITIONAL_CRITICAL_DAMAGE = ATTRIBUTES.register("additional_critical_damage", () ->
            (new RangedAttribute("attribute.cataclysm.additional_critical_damage", 0, -512, 512.0D)).setSyncable(true));

    public static final RegistryObject<Attribute> NATURE_HEAL = ATTRIBUTES.register("nature_heal", () ->
            (new RangedAttribute("attribute.cataclysm.nature_heal", 0, -256, 1024.0D)).setSyncable(true));

    public static final RegistryObject<Attribute> EAT_SPEED = ATTRIBUTES.register("eat_speed", () ->
            (new RangedAttribute("attribute.cataclysm.eat_speed", 0, -100, 100D)).setSyncable(true));



    public static final RegistryObject<Attribute> CHARGE_TIME = ATTRIBUTES.register("charge_time", () ->
            (new RangedAttribute("attribute.cataclysm.charge_time", 0, -100, 512.0D)).setSyncable(true));


    @SubscribeEvent
    public static void modifyEntityAttributes(EntityAttributeModificationEvent e) {
        e.getTypes().forEach(entity -> ATTRIBUTES.getEntries().forEach(attribute -> {
            if (!e.has(entity, attribute.get())) {
                e.add(entity, attribute.get());
            }
        }));
    }
}
