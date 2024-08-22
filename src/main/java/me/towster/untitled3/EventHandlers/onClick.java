package me.towster.untitled3.EventHandlers;

import me.towster.untitled3.utils.ParticleDrawer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.util.Vector;

public class onClick implements Listener {
    @EventHandler
    public void onClick (PlayerInteractEvent event) {
        Player player = event.getPlayer();
//        player.sendMessage(event.getAction().toString());

        if (!player.getInventory().getItemInMainHand().hasItemMeta()) return;
        if (!player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) return;
        int modelData = player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData();
        boolean rightClickedWithHand = ((event.getAction() == Action.RIGHT_CLICK_AIR && event.getHand() == EquipmentSlot.HAND)
                || (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getHand() == EquipmentSlot.HAND));
        if (modelData == 4000 && rightClickedWithHand) {
            for (Player recipient : Bukkit.getOnlinePlayers()) {
                if (recipient.equals(player)) continue;
                if (player.getLocation().distanceSquared(recipient.getLocation()) >= 25) continue;
                recipient.setVelocity(recipient.getLocation().toVector().subtract(player.getLocation().toVector()).normalize());
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
            }
        } else if (modelData == 4001 && rightClickedWithHand) {
            player.setVelocity(
                    player.getLocation().getDirection().add(new Vector(0, 0.25, 0))
            );
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
        } else if (modelData == 3002 && rightClickedWithHand) {
            ParticleDrawer.drawLine(
                    player.getWorld(),
                    Particle.FLAME,
                    player.getLocation().toVector().add(new Vector(0, 1.5,0)).add(player.getLocation().getDirection().multiply(0.5)),
                    player.getLocation().toVector().add(new Vector(0, 1.5,0)).add(player.getLocation().getDirection().multiply(30)),
                    1);
        }
    }
//    public void itemHandler(
}
