package net.prison.net.backend.files;

import net.prison.net.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class PickaxesFile {

    private static Plugin plugin = Main.getPlugin(Main.class);

    private static File file = new File(plugin.getDataFolder(), "pickaxes.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void save() {


        if (file.exists()){
            try {
                cfg.save(file);
                System.out.println("[PrisonNet] Saved 'pickaxes.yml' file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            cfg.set("pickaxes.0.displayName", "&7Prison Pickaxe &8(&3Level &bI&8)");
            cfg.set("pickaxes.0.material", "DIAMOND_PICKAXE");
            cfg.set("pickaxes.0.textureID", 1);
            cfg.set("pickaxes.0.lore", Arrays.asList("", ""));
            cfg.set("pickaxes.0.enchants.efficiency", 5);
            cfg.set("pickaxes.0.enchants.unbreaking", 5);
            cfg.set("pickaxes.0.enchants.fortune", 5);
            cfg.set("pickaxes.0.upgrade.money", 0);
            cfg.set("pickaxes.0.upgrade.blocks", 0);

            cfg.set("pickaxes.1.displayName", "&7Prison Pickaxe &8(&3Level &bII&8)");
            cfg.set("pickaxes.1.material", "DIAMOND_PICKAXE");
            cfg.set("pickaxes.1.textureID", 2);
            cfg.set("pickaxes.1.lore", Arrays.asList("", ""));
            cfg.set("pickaxes.1.enchants.efficiency", 6);
            cfg.set("pickaxes.1.enchants.unbreaking", 6);
            cfg.set("pickaxes.1.enchants.fortune", 6);
            cfg.set("pickaxes.1.upgrade.money", 1000);
            cfg.set("pickaxes.1.upgrade.blocks", 325);

            cfg.set("pickaxes.2.displayName", "&7Prison Pickaxe &8(&3Level &bIII&8)");
            cfg.set("pickaxes.2.material", "DIAMOND_PICKAXE");
            cfg.set("pickaxes.2.textureID", 3);
            cfg.set("pickaxes.2.lore", Arrays.asList("", ""));
            cfg.set("pickaxes.2.enchants.efficiency", 7);
            cfg.set("pickaxes.2.enchants.unbreaking", 7);
            cfg.set("pickaxes.2.enchants.fortune", 7);
            cfg.set("pickaxes.2.upgrade.money", 2500);
            cfg.set("pickaxes.2.upgrade.blocks", 500);

            try {
                cfg.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static FileConfiguration get(){
        return cfg;
    }

}
