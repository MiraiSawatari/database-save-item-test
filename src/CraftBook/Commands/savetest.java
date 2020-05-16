package CraftBook.Commands;

import CraftBook.Util.SQLUtil;
import CraftBook.Util.converter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class savetest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        PlayerInventory inventory = p.getInventory();
        converter con = new converter();
        String[] base64 = con.playerInventoryToBase64(inventory);
        String inventory2 = base64[0];
        String armor = base64[1];
        SQLUtil util = new SQLUtil();
        util.save(inventory2,armor,p.getName());
        return true;
    }
}
