package net.prison.net.backend.api;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import net.prison.net.backend.files.PickaxesFile;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Pickaxes {

    public static ItemStack get(Integer id) {

        // Define ItemStack and its meta
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = item.getItemMeta(); meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PickaxesFile.get().getString("pickaxes." + id + ".displayName")));
        meta.setCustomModelData(PickaxesFile.get().getInt("pickaxes." + id + ".textureID"));

        List<String> lore = new ArrayList<>();
        for (int i = 0;i<PickaxesFile.get().getStringList("pickaxes." + id + ".lore").size();i++){
            lore.add(ChatColor.translateAlternateColorCodes('&', PickaxesFile.get().getStringList("pickaxes." + id + ".lore").get(i)));
        }

        if (PickaxesFile.get().getInt("pickaxes." + id + ".upgrade.blocks") == 0){
            if (PickaxesFile.get().getInt("pickaxes." + id + ".upgrade.money") == 0){
                lore.add("");
                lore.add(ChatColor.translateAlternateColorCodes('&', "&7Upgrade Cost: &a&lFREE"));
            }
        } else {
            lore.add("");
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Upgrade Cost: &a$" +
                    PickaxesFile.get().getInt("pickaxes." + id + ".upgrade.money") + " &7and &a" +
                    PickaxesFile.get().getInt("pickaxes." + id + ".upgrade.blocks") + " &ablocks broken"));
        }

        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public static void give(Player player, Integer id){
        player.getInventory().addItem(get(id));
    }

}
