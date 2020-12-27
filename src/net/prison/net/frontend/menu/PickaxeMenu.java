package net.prison.net.frontend.menu;

import net.prison.net.backend.api.Pickaxes;
import net.prison.net.backend.files.PickaxesFile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class PickaxeMenu implements Listener {

    public static void open(Player player){

        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "              &0&lPickaxes"));

        Integer i = 0;
        for (String pickaxe : PickaxesFile.get().getConfigurationSection("pickaxes").getKeys(false)){
            inv.setItem(i, Pickaxes.get(i));
            i++;
        }

        player.openInventory(inv);

    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        String title = event.getView().getTitle();
        if (title.equalsIgnoreCase("              &0&lPickaxes")){
            event.setCancelled(true);
        }
    }

}
