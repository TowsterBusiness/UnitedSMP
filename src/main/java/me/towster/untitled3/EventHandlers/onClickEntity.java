package me.towster.untitled3.EventHandlers;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Container;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.BlockInventoryHolder;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import me.towster.united_smp.AbilityStatics;

public class onClickEntity implements Listener {

    @EventHandler
    public void onClickEntity(PlayerInteractAtEntityEvent event) {

        if (event.getRightClicked() instanceof Player) {
            Player rightClicked = (Player) event.getRightClicked();
            Player player = event.getPlayer();
            World world = player.getWorld();
            Location rcLoc = rightClicked.getLocation();
            Location pLoc = player.getLocation();

            if (event.getPlayer().getItemInHand().getItemMeta().getCustomModelData() == 3001 && !AbilityStatics.usedDomainExpansion) {
                AbilityStatics.usedDomainExpansion = true;

                world.spawnParticle(Particle.ENCHANTMENT_TABLE, rcLoc, 600, 0.2, 0.5, 0.2);
                world.spawnParticle(Particle.ENCHANTMENT_TABLE, pLoc, 600, 0.2, 0.5, 0.2);

                Vector a1 = rcLoc.toVector();
                Vector a2 = pLoc.toVector();

                Vector b1 = a1.distanceSquared(a2) < 100
                        ? new Vector(Math.min(a1.getBlockX(), a2.getBlockX()) - 5, Math.min(a1.getBlockY(), a2.getBlockY()) - 1, Math.min(a1.getBlockZ(), a2.getBlockZ()) - 5)
                        : new Vector(a2.getBlockX() - 5, a1.getBlockY() - 1, a1.getBlockZ() - 5);
                Vector b2 = a1.distanceSquared(a2) < 100
                        ? new Vector(Math.max(a1.getBlockX(), a2.getBlockX()) + 5, Math.max(a1.getBlockY(), a2.getBlockY()) + 5, Math.max(a1.getBlockZ(), a2.getBlockZ()) + 5)
                        : new Vector(a2.getBlockX() + 5, a1.getBlockY() + 5, a1.getBlockZ() + 5);
            }
        }
    }
}
