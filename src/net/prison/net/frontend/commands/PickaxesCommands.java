package net.prison.net.frontend.commands;

import net.prison.net.frontend.menu.PickaxeMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PickaxesCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        Player player = (Player) sender;

        if (s.equalsIgnoreCase("pickaxes")){

            PickaxeMenu.open(player);

        }

        return false;
    }
}
