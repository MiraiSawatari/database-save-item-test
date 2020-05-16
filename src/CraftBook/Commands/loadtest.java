package CraftBook.Commands;

import CraftBook.Util.SQLUtil;
import CraftBook.Util.converter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.io.IOException;

public class loadtest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
SQLUtil util = new SQLUtil();
String[] inventory = util.load(p.getName());
        converter con = new converter();
        try {
            ItemStack[] inventory2 = con.itemStackArrayFromBase64(inventory[0]);
            System.out.println("INVENTORY======");
            for(ItemStack a : inventory2) {
                System.out.println(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ItemStack[] inventory2 = con.itemStackArrayFromBase64(inventory[1]);
            System.out.println("ARMOR======");
            for(ItemStack a : inventory2) {
                System.out.println(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
