package me.towster.untitled3.*
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Untitled3 extends JavaPlugin {

    private static UnitedSMP instance;
    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        this.getCommand("united-give").setExecutor(new GiveCommands());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Untitled3 getInstance() {
        return instance;
    }
}
