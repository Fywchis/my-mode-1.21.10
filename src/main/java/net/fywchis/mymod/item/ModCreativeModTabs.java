package net.fywchis.mymod.item;

import net.fywchis.mymod.MyMod;
import net.fywchis.mymod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MyMod.MODID);

    public static final Supplier<CreativeModeTab> My_Mod_Tab = CREATIVE_MODE_TAB.register("my_mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TNT_10X.get()))
                    .title(Component.translatable("creativetab.mymod.mod_items_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TNT_10X);
                        output.accept(ModBlocks.BLOCK_SMTH);
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

