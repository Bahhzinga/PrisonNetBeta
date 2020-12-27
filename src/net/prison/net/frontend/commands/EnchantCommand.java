package net.prison.net.frontend.commands;

import net.prison.net.Main;
import net.prison.net.frontend.enchants.ExplosiveEnchant;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;

public class EnchantCommand implements CommandExecutor {

    private static Plugin plugin = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player player = (Player) sender;

        if (player.hasPermission("prison.enchant")) {
            if (s.equalsIgnoreCase("enchant")) {

                if (sender instanceof Player) {

                    if (args.length == 0) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cCorrect Usage: /enchant <enchantment> <level>"));
                    } else {

                        Enchantment ench = Enchantment.getByKey(new NamespacedKey(plugin, args[0]));


                        // Get the itemstack
                        ItemStack item = player.getInventory().getItemInMainHand();

                        // Apply the enchantment
                        item.addEnchantment(Enchantment.getByKey(new NamespacedKey(plugin, args[0])), Integer.valueOf(args[1]));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Added &c" + args[0] + " &7level " + args[1] + " &7to your item."));

                        // Update the itemstack
                        ItemMeta meta = item.getItemMeta();
                        meta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&7" + args[0] + " " + args[1])));
                        item.setItemMeta(meta);



                    }

                }

            }
        }
        return false;
    }
}
