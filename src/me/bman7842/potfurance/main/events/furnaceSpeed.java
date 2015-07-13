package me.bman7842.potfurance.main.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.FurnaceInventory;

import java.util.Set;

/**
 * Created by brand_000 on 7/12/2015.
 */
public class furnaceSpeed implements Listener {

    private static Short cookTime = (short) 50;
    public static void setCookTime(short ct) { cookTime = ct; }

    @EventHandler
    public void furnaceOpenEvent(PlayerInteractEvent event) {
        Player p = (Player)event.getPlayer();

        if (event.getClickedBlock().getType().equals(Material.FURNACE) || event.getClickedBlock().getType().equals(Material.BURNING_FURNACE)) {
            Furnace furnace = (Furnace)event.getClickedBlock().getState();
            Bukkit.getLogger().info(cookTime.toString());
            Bukkit.getLogger().info(Short.toString(furnace.getCookTime()));
            if (furnace.getCookTime() < cookTime) {
                Bukkit.getLogger().info(cookTime.toString());
                furnace.setCookTime(cookTime);
                furnace.update(true);
            }
        }
    }

    @EventHandler
    public void furnaceSmeltEvent(FurnaceSmeltEvent event) {

        if (event.getBlock().getType().equals(Material.FURNACE) || event.getBlock().getType().equals(Material.BURNING_FURNACE)) {
            Furnace furnace = (Furnace) event.getBlock().getState();
            if (furnace.getCookTime() < cookTime) {
                furnace.setCookTime(cookTime);
                furnace.update(true);
            }
        }
    }

    @EventHandler
    public void onInventoryInteract(InventoryClickEvent event) {
        Player p = (Player)event.getWhoClicked();
        Block blockType = event.getWhoClicked().getTargetBlock((Set<Material>) null, 10);

        if (event.getInventory().getType().equals(InventoryType.FURNACE)) {
            Furnace furnace = (Furnace) blockType.getState();
            if (furnace.getCookTime() < cookTime) {
                furnace.setCookTime(cookTime);
                furnace.update(true);
            }
        }
    }

}
