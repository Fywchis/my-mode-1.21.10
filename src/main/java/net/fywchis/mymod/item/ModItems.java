package net.fywchis.mymod.item;

import net.fywchis.mymod.MyMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MyMod.MODID);


    public static final DeferredItem<Item> TNT_10X = ITEMS.registerSimpleItem(
            "tnt10x",
            () -> new Item.Properties()// The properties to use.
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
