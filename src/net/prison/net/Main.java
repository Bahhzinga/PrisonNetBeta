package net.prison.net;

import net.prison.net.backend.files.MinesFile;
import net.prison.net.backend.files.PickaxesFile;
import net.prison.net.backend.files.PrestigesFile;
import net.prison.net.backend.files.RanksFile;
import net.prison.net.frontend.commands.EnchantCommand;
import net.prison.net.frontend.commands.PickaxesCommands;
import net.prison.net.frontend.commands.RanksCommand;
import net.prison.net.frontend.enchants.ExplosiveEnchant;
import net.prison.net.frontend.events.EnchantEvents;
import net.prison.net.frontend.menu.PickaxeMenu;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;


public class Main extends JavaPlugin {

    public ExplosiveEnchant explosive = new ExplosiveEnchant(new NamespacedKey(this, "EXPLOSIVE"));

    public void onEnable(){

        // Register Events
        Bukkit.getPluginManager().registerEvents(new PickaxeMenu(), this);
        Bukkit.getPluginManager().registerEvents(new EnchantEvents(), this);

        // Register Commands
        this.getCommand("pickaxes").setExecutor(new PickaxesCommands());
        this.getCommand("ranks").setExecutor(new RanksCommand());
        this.getCommand("rankup").setExecutor(new RanksCommand());
        this.getCommand("enchant").setExecutor(new EnchantCommand());

        // save Files
        PickaxesFile.save();
        RanksFile.save();
        PrestigesFile.save();
        MinesFile.save();

        // Load enchantments
        LoadEnchantments();

    }

    private void LoadEnchantments() {
        try {
            try {
                Field f = Enchantment.class.getDeclaredField("acceptingNew");
                f.setAccessible(true);
                f.set(null, true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Enchantment.registerEnchantment(explosive);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
