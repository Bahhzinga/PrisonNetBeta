package net.prison.net.frontend.menu;

import net.prison.net.backend.api.Pickaxes;
import net.prison.net.backend.files.PickaxesFile;
import net.prison.net.backend.files.RanksFile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class RanksMenu implements Listener {

    public static void open(Player player){

        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "                &0&lRanks"));

        Integer i = 0;
        for (String rank : RanksFile.get().getConfigurationSection("ranks").getKeys(false)){

            ItemStack item = new ItemStack(Material.valueOf(RanksFile.get().getString("ranks." + rank + ".icon.material")));    ItemMeta meta = item.getItemMeta();
            meta.setCustomModelData(RanksFile.get().getInt("ranks." + rank + ".icon.textureID"));
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RanksFile.get().getString("ranks." + rank + ".displayName")));

            List<String> lore = new ArrayList<>();
            for (int l = 0;l<RanksFile.get().getStringList("ranks." + rank + ".icon.lore").size();l++){
                lore.add(ChatColor.translateAlternateColorCodes('&', RanksFile.get().getStringList("ranks." + rank + ".icon.lore").get(l)));
            }

            if (RanksFile.get().getInt("ranks." + rank + ".cost.blocks") == 0){
                if (RanksFile.get().getInt("ranks." + rank + ".cost.money") == 0){
                    lore.add("");
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7Upgrade Cost: &a&lFREE"));
                }
            } else {
                lore.add("");
                lore.add(ChatColor.translateAlternateColorCodes('&', "&7Upgrade Cost: &a$" +
                        RanksFile.get().getInt("ranks." + rank + ".cost.blocks") + " &7and &a" +
                        RanksFile.get().getInt("ranks." + rank + ".cost.money") + " &ablocks broken"));
            }

            meta.setLore(lore);
            item.setItemMeta(meta);

            inv.setItem(i, item);

            i++;
        }



        player.openInventory(inv);

    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        String title = event.getView().getTitle();
        if (title.equalsIgnoreCase("                &0&lRanks")){
            event.setCancelled(true);
        }
    }

}
