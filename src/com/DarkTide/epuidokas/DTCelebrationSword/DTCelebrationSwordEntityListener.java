package com.DarkTide.epuidokas.DTCelebrationSword;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;

public class DTCelebrationSwordEntityListener extends EntityListener {
    public void onEntityDamage(EntityDamageEvent event) {
        if (!event.isCancelled() && event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)){
            EntityDamageByEntityEvent event2 = (EntityDamageByEntityEvent) event;
            Player damager = (Player) event2.getDamager();
            if (DTCelebrationSwordPlugin.isCelebrating(damager.getName()) && damager.getItemInHand().getTypeId() == 276) {

                damager.setItemInHand(new ItemStack(Material.CAKE, 1));
                World world = event.getEntity().getWorld();
                Location location = event.getEntity().getLocation();
                event.setDamage(9999);
                DTCelebrationSwordPlugin.endTheParty(damager.getName());
                damager.sendMessage("Party's over");

                Wool wool = new Wool();
                wool.setColor(DyeColor.CYAN);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.BLACK);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.BLUE);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.BROWN);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.GRAY);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.GREEN);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.LIGHT_BLUE);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.LIME);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.MAGENTA);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.ORANGE);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.PINK);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.PURPLE);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.RED);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.SILVER);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.WHITE);
                world.dropItemNaturally(location, wool.toItemStack(1));
                wool.setColor(DyeColor.YELLOW);
                world.dropItemNaturally(location, wool.toItemStack(1));


            }
        }
    }
}
