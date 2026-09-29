package com.nitricacid.worldeditwandfabrication;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(modid = WorldEditWandFabrication.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.GAME)
public final class ClientEvents {
    private static final ResourceLocation WAND_AXE = ResourceLocation.fromNamespaceAndPath("worldedit_items", "wand_axe");
    private static int lastSlot = -1;

    private ClientEvents() {}

    @SubscribeEvent
    public static void tick(ClientTickEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || minecraft.level == null || !player.isCreative() || !WandConfig.ENABLED.get()) return;
        if (minecraft.screen != null && (minecraft.mouseHandler.isLeftPressed() || minecraft.mouseHandler.isRightPressed())) return;

        for (int slot = 0; slot < 36; slot++) {
            if (isWandAxe(player.getInventory().getItem(slot))) lastSlot = slot;
        }
        if (containsWandAxe(player)) return;

        var item = BuiltInRegistries.ITEM.getOptional(WAND_AXE);
        if (item.isEmpty()) return;
        int slot = lastSlot >= 0 && lastSlot < 36 && player.getInventory().getItem(lastSlot).isEmpty()
                ? lastSlot : firstEmptySlot(player);
        if (slot >= 0) player.getInventory().setItem(slot, new ItemStack(item.get()));
    }

    private static boolean containsWandAxe(Player player) {
        for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
            if (isWandAxe(player.getInventory().getItem(slot))) return true;
        }
        return isWandAxe(player.containerMenu.getCarried());
    }

    private static boolean isWandAxe(ItemStack stack) {
        return !stack.isEmpty() && WAND_AXE.equals(BuiltInRegistries.ITEM.getKey(stack.getItem()));
    }

    private static int firstEmptySlot(Player player) {
        for (int slot = 9; slot < 36; slot++) {
            if (player.getInventory().getItem(slot).isEmpty()) return slot;
        }
        for (int slot = 0; slot < 9; slot++) {
            if (player.getInventory().getItem(slot).isEmpty()) return slot;
        }
        return -1;
    }
}
