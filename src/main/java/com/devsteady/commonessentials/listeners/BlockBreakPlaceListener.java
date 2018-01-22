package com.devsteady.commonessentials.listeners;

import com.caved_in.commons.Commons;
import com.caved_in.commons.player.Players;
import com.devsteady.commonessentials.CommonEssentials;
import com.devsteady.commonessentials.config.CommonEssentialsConfig;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockBreakPlaceListener implements Listener {
	private CommonEssentials plugin;

	private CommonEssentialsConfig config;

	public BlockBreakPlaceListener(CommonEssentials plugin) {
		this.plugin = plugin;
		this.config = plugin.getConfiguration();
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if (event.isCancelled()) {
			return;
		}

		if (config.isBlockBreakEnabled()) {
			return;
		}

		if (!Players.hasPermission(event.getPlayer(),config.getBlockBreakBypassPermission())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		if (event.isCancelled()) {
			return;
		}

		if (config.isBlockPlaceEnabled()) {
			return;
		}

		if (!Players.hasPermission(event.getPlayer(),config.getBlockPlaceBypassPermission())) {
			return;
		}

		Player player = event.getPlayer();
		if (config.enableBlockBreak()) {
			return;
		}

		if (!Players.hasPermission(player, Perms.BLOCK_PLACE)) {
			if (player.getGameMode() != GameMode.CREATIVE) {
				event.setCancelled(true);
			}
		}

	}


}
