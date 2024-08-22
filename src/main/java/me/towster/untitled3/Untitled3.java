package me.towster.untitled3;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import me.towster.untitled3.EventHandlers.*;

public class Untitled3 extends JavaPlugin {

    private static Untitled3 instance;
    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        this.getCommand("united-give").setExecutor(new GiveCommands());
        this.getServer().getPluginManager().registerEvents(new onAnvilUse(), this);
        this.getServer().getPluginManager().registerEvents(new onClickEntity(), this);
        this.getServer().getPluginManager().registerEvents(new onClick(), this);
        this.getServer().getPluginManager().registerEvents(new onBlockBreak(), this);

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    ItemStack is = p.getInventory().getChestplate();
                    if (is == null) continue;
                    if (!is.hasItemMeta()) continue;
                    if (!is.getItemMeta().hasCustomModelData()) continue;
                    if (is.getItemMeta().getCustomModelData() == 3000) {
                        if (is.getDurability() > 402) {
                            is.setDurability((short) (is.getDurability() - 1));
                        }
                    }
                }
            }

        }, 0L, 1200L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Untitled3 getInstance() {
        return instance;
    }
}
