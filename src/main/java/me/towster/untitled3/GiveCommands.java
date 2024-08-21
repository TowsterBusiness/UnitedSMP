package me.towster.untitled3;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GiveCommands implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player && args.length > 0) {
            Player player = (Player) sender;

            if (args[0].equals("wing")) {
                ItemStack is = new ItemStack(Material.ELYTRA);
                is.setDurability((short) 402);
                ItemMeta meta = is.getItemMeta();
                meta.setCustomModelData(3000);
                meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Icarus’s Wax Wings");
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.GRAY + "These are the wings of Parhelius, once used to roam the ");
                lore.add(ChatColor.GRAY + "earth they have been clipped off and left as a forgotten ");
                lore.add(ChatColor.GRAY + "relic. Due to its strong magical origin, it cannot be ");
                lore.add(ChatColor.GRAY + "affected by regular enchantments, and can only be");
                lore.add(ChatColor.GRAY + "mended with time.");
                meta.setLore(lore);
                is.setItemMeta(meta);
                player.getInventory().addItem(is);
            }
        return true;
    }
}
