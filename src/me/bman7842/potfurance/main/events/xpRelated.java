package me.bman7842.potfurance.main.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.FurnaceInventory;

import java.util.Set;

/**
 * Created by brand_000 on 7/12/2015.
 */
public class xpRelated implements Listener {

    private static int xpBonus = 1;
    public static void setXpBonus(int amount) { xpBonus = amount; }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player)event.getWhoClicked();
        Block blockType = event.getWhoClicked().getTargetBlock((Set<Material>) null, 10);

        Bukkit.getLogger().info("Hey");
        if (event.getInventory() instanceof FurnaceInventory) {

            if (event.getSlot() == 1 && !event.getInventory().getItem(1).getType().equals(Material.AIR)) {
                int rewardxp = event.getInventory().getItem(1).getAmount();
                p.giveExp(xpBonus * rewardxp);
            }
        }
    }

}
