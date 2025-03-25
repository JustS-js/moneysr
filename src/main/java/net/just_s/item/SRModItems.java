package net.just_s.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.just_s.SRMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SRModItems {

    public static final Item TERRA = registerItem("terracoin", new Item(new FabricItemSettings()));
    public static final Item KREDO = registerItem("kredocoin", new Item(new FabricItemSettings()));
    public static final Item SUMM = registerItem("summcoin", new Item(new FabricItemSettings()));

    public static final RegistryKey<ItemGroup> SR_ITEM_GROUP_KEY = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(),
            Identifier.of(SRMod.MOD_ID, "item_group")
    );
    public static final ItemGroup SR_ITEM_GROUP = registerItemGroup(
            SR_ITEM_GROUP_KEY,
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(SUMM))
                    .displayName(Text.translatable("item_group.moneysr"))
                    .build()
    );

    private static void addItemsToItemGroup(FabricItemGroupEntries entries) {
        entries.add(TERRA);
        entries.add(KREDO);
        entries.add(SUMM);
    }

    public static void registerModItems() {
        SRMod.LOGGER.info("registering mod items for " + SRMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(SR_ITEM_GROUP_KEY).register(SRModItems::addItemsToItemGroup);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SRMod.MOD_ID, name), item);
    }

    private static ItemGroup registerItemGroup(RegistryKey<ItemGroup> key, ItemGroup itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, key, itemGroup);
    }
}
