package net.prison.net.backend.files;

import net.prison.net.Main;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class MinesFile {

    private static Plugin plugin = Main.getPlugin(Main.class);

    private static File file = new File(plugin.getDataFolder(), "mines.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void save() {

        if (file.exists()){
            try {
                cfg.save(file);
                System.out.println("[PrisonNet] Saved 'mines.yml' file.");
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
                cfg.set("mines." + i + ".displayName", "&8(&bMine &3" + i + "&8)");
                cfg.set("mines." + i + ".icon.material", "DIAMOND_PICKAXE");
                cfg.set("mines." + i + ".icon.textureID", 1*i);
                cfg.set("mines." + i + ".icon.lore", Arrays.asList("", "", ""));
                cfg.set("mines." + i + ".cost.money", 150*i);
                cfg.set("mines." + i + ".cost.blocks", 200*i);

                cfg.set("mines." + i + ".contents.emerald_ore.percentage", 25);
                cfg.set("mines." + i + ".contents.diamond_ore.percentage", 35);
                cfg.set("mines." + i + ".contents.stone.percentage", 40);

                cfg.set("mines." + i + ".contents.emerald_ore.value", 35*i*(i/0.5));
                cfg.set("mines." + i + ".contents.diamond_ore.value", 20*i*(i/0.5));
                cfg.set("mines." + i + ".contents.stone.value", 5*i*(i/0.5));

                cfg.set("mines." + i + ".specials.luckyblock.1.probability", 0.05*i);
                cfg.set("mines." + i + ".specials.luckyblock.1.message", Arrays.asList("&7You discovered a &b&lBlock of Haste&7, you have been granted greater mining speed for the next minute!"));
                cfg.set("mines." + i + ".specials.luckyblock.1.sound", "ENTITY_PLAYER_LEVELUP");
                cfg.set("mines." + i + ".specials.luckyblock.1.particle", "DRAGON_BREATH");
                cfg.set("mines." + i + ".specials.luckyblock.1.title", "&b&lBlock of Haste");
                cfg.set("mines." + i + ".specials.luckyblock.1.subtitle", "&7Faster mining for the next minute!");
                cfg.set("mines." + i + ".specials.luckyblock.1.commands", Arrays.asList("/effect give {PLAYER} haste 1"));

                cfg.set("mines." + i + ".specials.luckyblock.2.probability", 0.02*i);
                cfg.set("mines." + i + ".specials.luckyblock.2.message", Arrays.asList("&7You discovered a &b&lBlock of Fortune&7, you have received &b$15,000&7!"));
                cfg.set("mines." + i + ".specials.luckyblock.2.sound", "ENTITY_PLAYER_LEVELUP");
                cfg.set("mines." + i + ".specials.luckyblock.2.particle", "DRAGON_BREATH");
                cfg.set("mines." + i + ".specials.luckyblock.2.title", "&b&lBlock of Fortune");
                cfg.set("mines." + i + ".specials.luckyblock.2.subtitle", "&7Tou won $15,000!");
                cfg.set("mines." + i + ".specials.luckyblock.2.commands", Arrays.asList("/eco give {PLAYER} 15000"));

                cfg.set("mines." + i + ".events.levelup.succeed.sound", "ENTITY_FIREWORK_ROCKET_TWINKLE");
                cfg.set("mines." + i + ".events.levelup.failed.sound", "BLOCK_ANVIL_BREAK");
                cfg.set("mines." + i + ".events.levelup.succeed.particle", "DRAGON_BREATH");
                cfg.set("mines." + i + ".events.levelup.failed.particle", "SMOKE");
                cfg.set("mines." + i + ".events.levelup.succeed.title", "&b&lCongratulations&7");
                cfg.set("mines." + i + ".events.levelup.failed.title", "&c&lUh oh");
                cfg.set("mines." + i + ".events.levelup.succeed.subtitle", "&7You ranked up!");
                cfg.set("mines." + i + ".events.levelup.failed.subtitle", "&7You haven't met the requirements!");
                cfg.set("mines." + i + ".events.levelup.succeed.actionbar", "&b&lCongratulations&7! You ranked up to &b{MINE_DISPLAY}&7!");
                cfg.set("mines." + i + ".events.levelup.failed.actionbar", "&c&lUh oh! 7You need &b{MINE_BLOCKS_BROKEN_COST} blocks broken &7and &b${MINE_MONEY_COST}&7 to rank up! ");
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
