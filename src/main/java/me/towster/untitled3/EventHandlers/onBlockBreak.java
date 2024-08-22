package me.towster.untitled3.EventHandlers;

import me.towster.united_smp.AbilityStatics;
import org.bukkit.*;
import org.bukkit.entity.LightningStrike;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class onBlockBreak implements Listener {
    @EventHandler
    public void onBlockBreak (BlockBreakEvent event) {
        if (AbilityStatics.domExpCheckForPlayerPos && event.getBlock().getWorld().equals(AbilityStatics.domExpWorld)) {
            Vector blockPos = event.getBlock().getLocation().toVector();
            if (blockPos.getBlockX() == AbilityStatics.domExpV1.getBlockX()
                    || blockPos.getBlockY() == AbilityStatics.domExpV1.getBlockY()
                    || blockPos.getBlockZ() == AbilityStatics.domExpV1.getBlockZ()
                    || blockPos.getBlockX() == AbilityStatics.domExpV2.getBlockX()
                    || blockPos.getBlockY() == AbilityStatics.domExpV2.getBlockY()
                    || blockPos.getBlockZ() == AbilityStatics.domExpV2.getBlockZ()) {
                event.setCancelled(true);
            }

        }
    }
}
