package com.devsteady.commonessentials.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class ItemPickupListener implements Listener {
    @EventHandler
    public void onPlayerPickup(PlayerPickupItemEvent event) {
        event.setCancelled(true);
    }
}
