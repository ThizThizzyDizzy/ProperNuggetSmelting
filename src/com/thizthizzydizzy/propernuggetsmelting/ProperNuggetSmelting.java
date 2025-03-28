package com.thizthizzydizzy.propernuggetsmelting;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
public class ProperNuggetSmelting extends JavaPlugin{
    public void onEnable(){
        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();
        //<editor-fold defaultstate="collapsed" desc="Register Events">
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new FurnaceSmelt(this), this);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Register Config">
        saveDefaultConfig();
//</editor-fold>
        logger.log(Level.INFO, "{0} has been enabled! (Version {1}) by ThizThizzyDizzy", new Object[]{pdfFile.getName(), pdfFile.getVersion()});
    }
    public void onDisable(){
        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();
        logger.log(Level.INFO, "{0} has been disabled! (Version {1}) by ThizThizzyDizzy", new Object[]{pdfFile.getName(), pdfFile.getVersion()});
    }
}
