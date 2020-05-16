package CraftBook;

import CraftBook.Commands.loadtest;
import CraftBook.Commands.savetest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main instance;
    @Override
    public void onEnable(){

        instance = this;
        getCommand("savetest").setExecutor(new savetest());
        getCommand("loadtest").setExecutor(new loadtest());
    }
}
