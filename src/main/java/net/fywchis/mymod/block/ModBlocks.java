package net.fywchis.mymod.block;

import net.fywchis.mymod.MyMod;
import net.fywchis.mymod.item.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MyMod.MODID);

    public static final DeferredBlock<Block> BLOCK_SMTH = registerBlock("block_smth",
            () -> BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
                    .strength(1.5f, 6.0f) // Set hardness and explosion resistance
                    .friction(0.6f)
            );

    private static <T extends Block> DeferredBlock<Block> registerBlock(String name, Supplier<BlockBehaviour.Properties> block){
        DeferredBlock<Block> toReturn = BLOCKS.registerSimpleBlock(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.registerSimpleBlockItem(name, block);
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
