package net.prison.net.backend.files;

import net.prison.net.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class PrestigesFile {

    private static Plugin plugin = Main.getPlugin(Main.class);

    private static File file = new File(plugin.getDataFolder(), "prestiges.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void save() {


        if (file.exists()){
            try {
                cfg.save(file);
                System.out.println("[PrisonNet] Saved 'prestiges.yml' file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0;i<3;i++){
                cfg.set("prestiges." + i + ".displayName", "&8(&bA&8)");
                cfg.set("prestiges." + i + ".icon.material", "GOLD_INGOT");
                cfg.set("prestiges." + i + ".icon.textureID", 1);
                cfg.set("prestiges." + i + ".icon.lore", Arrays.asList("", "", ""));
                cfg.set("prestiges." + i + ".cost.money", 150*i);
                cfg.set("prestiges." + i + ".cost.blocks", 200*i);

                cfg.set("prestiges." + i + ".events.levelup.succeed.message.string", Arrays.asList(
                        "&b&lCongratulations! &7You reached {PRESTIGE_DISPLAY}, your next rank is &b{NEXT_PRESTIGE}&7!",
                        "&7To rank up, you need to have broken &b{BLOCKS_BROKEN_COST} &7and have &b${MONEY_COST}&7!"));
                cfg.set("prestiges." + i + ".events.levelup.succeed.message.tooltip", "&7To view the next prestige, type /ranks!");

                cfg.set("prestiges." + i + ".events.levelup.failed.message.string", Arrays.asList(
                        "&c&lUh oh! &7You need &b{BLOCKS_BROKEN_COST} blocks broken &7and &b${MONEY_COST}&7 to reach the next prestige!",
                        "&&To view the cost of all prestiges, type /ranks!"));

                cfg.set("prestiges." + i + ".events.levelup.succeed.sound", "ENTITY_FIREWORK_ROCKET_TWINKLE");
                cfg.set("prestiges." + i + ".events.levelup.failed.sound", "BLOCK_ANVIL_BREAK");
                cfg.set("prestiges." + i + ".events.levelup.succeed.particle", "DRAGON_BREATH");
                cfg.set("prestiges." + i + ".events.levelup.failed.particle", "SMOKE");
                cfg.set("prestiges." + i + ".events.levelup.succeed.title", "&b&lCongratulations&7");
                cfg.set("prestiges." + i + ".events.levelup.failed.title", "&c&lUh oh");
                cfg.set("prestiges." + i + ".events.levelup.succeed.subtitle", "&7You ranked up!");
                cfg.set("prestiges." + i + ".events.levelup.failed.subtitle", "&7You haven't met the rankup requirements!");
                cfg.set("prestiges." + i + ".events.levelup.succeed.actionbar", "&b&lCongratulations&7! You ranked up to &b{RANK_DISPLAY}&7!");
                cfg.set("prestiges." + i + ".events.levelup.failed.actionbar", "&c&lUh oh! 7You need &b{BLOCKS_BROKEN_COST} blocks broken &7and &b${MONEY_COST}&7 to rank up! ");
                cfg.set("prestiges." + i + ".events.levelup.succeed.commands", Arrays.asList("/crate givekey {PLAYER} Drug 1"));
                cfg.set("prestiges." + i + ".events.levelup.succeed.broadcast", Arrays.asList("&b&lCongratulations &7to &3{PLAYER}&7 who reached {PRESTIGE_DISPLAY}&7!"));
            }

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
