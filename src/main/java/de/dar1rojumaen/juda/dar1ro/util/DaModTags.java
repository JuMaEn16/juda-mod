package de.dar1rojumaen.juda.dar1ro.util;

import de.dar1rojumaen.juda.JuDaMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class DaModTags {
    public static class Blocks {
        //Für Tools public static final TagKey<Block> NEEDS_NAME_TOOL = createTag("needs_NAME_tool");
        //Für Tools public static final TagKey<Block> INCORRECT_FOR_NAME_TOOL = createTag("incorrect_for_NAME_tool");

        //Allgemein Blöcke public static final TagKey<Block> NAME_BLOCKS = createTag("NAME_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(JuDaMod.MOD_ID, name));
        }

    }

    public static class Items {
        //Allgemein Items public static final TagKey<Item> NAME_ITEMS = createTag("name_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(JuDaMod.MOD_ID, name));
        }
    }
}
