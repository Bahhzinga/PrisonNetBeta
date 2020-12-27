package net.prison.net.frontend.commands;

import net.prison.net.frontend.menu.PickaxeMenu;
import net.prison.net.frontend.menu.RanksMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RanksCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        Player player = (Player) sender;

        if (s.equalsIgnoreCase("ranks")){

            RanksMenu.open(player);

        } else if (s.equalsIgnoreCase("rankup")){

        }

        return false;
    }
}
