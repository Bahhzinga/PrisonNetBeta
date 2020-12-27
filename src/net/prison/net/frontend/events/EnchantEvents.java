package net.prison.net.frontend.events;

import net.prison.net.Main;
import net.prison.net.backend.utils.Maths;
import net.prison.net.frontend.enchants.ExplosiveEnchant;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class EnchantEvents implements Listener {

    private static Plugin plugin = Main.getPlugin(Main.class);
    public ExplosiveEnchant explosive = new ExplosiveEnchant(new NamespacedKey(plugin, "EXPLOSIVE"));

    @EventHandler
    public void onMine(BlockBreakEvent event){

        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        Integer level = item.getEnchantmentLevel(explosive);

        if (item.containsEnchantment(explosive)){

            Integer bound = Maths.randInt(1, 20);
            if (level+1 >= bound){
                player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 5, 5);
                player.getWorld().createExplosion(event.getBlock().getLocation(), 1, false);

            }
        }

    }

}
