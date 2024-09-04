package me.towster.untitled3.EventHandlers;

import org.bukkit.*;
import org.bukkit.entity.LightningStrike;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import java.util.ArrayList;

public class onAnvilUse implements Listener {
    @EventHandler
    public void onAnvilUse (InventoryClickEvent event) {

        if (event.getInventory().getType() == InventoryType.ANVIL) {
            if(event.getCurrentItem().getType() == Material.ELYTRA) {
                String[] words = {
                        "<Icarus> Hey! That's not part of the lore",
                        "<Icarus> GO KYS GRAHHH Hits you with the force of 10 million suns",
                        "<Icarus> You swore an oath under my name, I recognized you as my champion for crying out loud! Don't you go trying to two-time me",
                        "<Icarus> Dawg why you trying to do me dirty?",
                        "<Icarus> Curse of RAHHHHHH",
                };

                event.getWhoClicked().sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + words[(int) Math.floor(Math.random() * words.length)]);
                event.getWhoClicked().getWorld().spawn(event.getWhoClicked().getLocation(), LightningStrike.class);
                event.setCancelled(true);
            }
        }
    }
}
