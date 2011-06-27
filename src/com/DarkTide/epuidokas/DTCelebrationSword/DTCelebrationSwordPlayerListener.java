package com.DarkTide.epuidokas.DTCelebrationSword;

import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerListener;

public class DTCelebrationSwordPlayerListener extends PlayerListener {
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (!event.isCancelled() && event.getMessage().equals("/celebrate")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("Time to celebrate!");
            DTCelebrationSwordPlugin.startTheParty(event.getPlayer().getName());
        }
    }
}
