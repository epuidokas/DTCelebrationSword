package com.DarkTide.epuidokas.DTCelebrationSword;

import org.bukkit.Material;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class DTCelebrationSwordBlockListener extends BlockListener {
    public void onBlockDamage(BlockDamageEvent event) {
        if (!event.isCancelled() && DTCelebrationSwordPlugin.isCelebrating(event.getPlayer().getName()) && event.getItemInHand().getTypeId() == 276) {
            event.getBlock().setTypeId(92);
            Integer durability_int = event.getItemInHand().getDurability() + (1600/4);
            Short durability = new Short(durability_int.toString());
            if (durability_int > 1500) {
                event.getPlayer().setItemInHand(new ItemStack(Material.CAKE, 1));
            } else {
                event.getItemInHand().setDurability(durability);
            }
        }
    }
}
