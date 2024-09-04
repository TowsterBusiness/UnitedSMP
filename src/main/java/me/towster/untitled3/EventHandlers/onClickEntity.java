package me.towster.untitled3.EventHandlers;
import me.towster.untitled3.Untitled3;
import me.towster.untitled3.utils.ParticleDrawer;
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

                world.spawnParticle(Particle.ENCHANTMENT_TABLE, rcLoc, 600, 0.1, 0.5, 0.2);
                world.spawnParticle(Particle.ENCHANTMENT_TABLE, pLoc, 600, 0.1, 0.5, 0.2);

                Vector a1 = rcLoc.toVector();
                Vector a2 = pLoc.toVector();

                Vector b1 = a1.distanceSquared(a2) < 100
                        ? new Vector(Math.min(a1.getBlockX(), a2.getBlockX()) - 5, Math.min(a1.getBlockY(), a2.getBlockY()) - 1, Math.min(a1.getBlockZ(), a2.getBlockZ()) - 5)
                        : new Vector(a2.getBlockX() - 5, a1.getBlockY() - 1, a1.getBlockZ() - 5);
                Vector b2 = a1.distanceSquared(a2) < 100
                        ? new Vector(Math.max(a1.getBlockX(), a2.getBlockX()) + 5, Math.max(a1.getBlockY(), a2.getBlockY()) + 5, Math.max(a1.getBlockZ(), a2.getBlockZ()) + 5)
                        : new Vector(a2.getBlockX() + 5, a1.getBlockY() + 5, a1.getBlockZ() + 5);
                for (Player recipient : Bukkit.getOnlinePlayers()) {
                    if (recipient.equals(player)) continue;
                    if (recipient.equals(rightClicked)) continue;
                    if (player.getLocation().distanceSquared(recipient.getLocation()) >= 81) continue;
                    recipient.setVelocity(recipient.getLocation().toVector().subtract(player.getLocation().toVector()).setY(0).normalize().multiply(1.5).add(new Vector(0, 1.5, 0)));
                }

                AbilityStatics.domExpV1 = b1;
                AbilityStatics.domExpV2 = b2;
                AbilityStatics.domExpP1 = player;
                AbilityStatics.domExpP2 = rightClicked;
                AbilityStatics.domExpWorld = world;

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Untitled3.getInstance(), () -> {
                    AbilityStatics.domExpCheckForPlayerPos = true;
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 99999, 1));
                    rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 99999, 1));
                    ParticleDrawer.drawLine(world, Particle.FLAME, b1, b2, 0.1);
                }, 1000);

                BlockState[][][] blocks =
                        new BlockState[b2.getBlockX() - b1.getBlockX() + 1]
                                [b2.getBlockY() - b1.getBlockY() + 1]
                                [b2.getBlockZ() - b1.getBlockZ() + 1];


                for (int x = 0; x <= b2.getBlockX() - b1.getBlockX(); x++) {
                    for (int y = 0; y <= b2.getBlockY() - b1.getBlockY(); y++) {
                        for (int z = 0; z <= b2.getBlockZ() - b1.getBlockZ(); z++) {

                            blocks[x][y][z] = world.getBlockAt(new Location(world, x + b1.getBlockX(), y + b1.getBlockY(), z + b1.getBlockZ())).getState();

                            if (x == 0 || y == 0 || z == 0 || x == b2.getBlockX() - b1.getBlockX() || y == b2.getBlockY() - b1.getBlockY() || z == b2.getBlockZ() - b1.getBlockZ()) {
                                world.getBlockAt(x + b1.getBlockX(), y + b1.getBlockY(), z + b1.getBlockZ()).setType(Material.BLACK_CONCRETE);
                            } else {
                                world.getBlockAt(x + b1.getBlockX(), y + b1.getBlockY(), z + b1.getBlockZ()).setType(Material.AIR);
                            }
                        }
                    }
                }

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Untitled3.getInstance(), () -> {
                    player.removePotionEffect(PotionEffectType.DARKNESS);
                    rightClicked.removePotionEffect(PotionEffectType.DARKNESS);
                    int x = 0, y = 0, z = 0;
                    for (BlockState[][] a : blocks) {
                        for (BlockState[] b : a) {
                            for (BlockState c : b) {
                                if (c != null) {
                                    c.update(true, true);
                                } else {
                                    world.getBlockAt(x + b1.getBlockX(), y + b1.getBlockY(), z + b1.getBlockZ()).setType(Material.AIR);
                                }
                                z++;
                            }
                            y++;
                            z = 0;
                        }
                        x++;
                        y = 0;
                    }
                }, 50L);

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Untitled3.getInstance(), () -> {
                    player.sendMessage("usedDomainExpansion = false");
                    AbilityStatics.usedDomainExpansion = false;
                    AbilityStatics.domExpCheckForPlayerPos = false;
                }, 50L);
            }
        }
    }
}
