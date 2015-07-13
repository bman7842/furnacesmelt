package me.bman7842.potfurance.main;

import me.bman7842.potfurance.main.events.furnaceSpeed;
import me.bman7842.potfurance.main.events.xpRelated;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by brand_000 on 7/12/2015.
 */
public class Main extends JavaPlugin {

    SettingsManager settings;

    @Override
    public void onEnable() {
        settings = settings.getInstance();

        loadData();

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new furnaceSpeed(), this);
        pm.registerEvents(new xpRelated(), this);
    }

    public void loadData() {
        settings.setup(this);

        try {
            furnaceSpeed.setCookTime((short) settings.getConfig().getDouble("cooktime"));
        } catch (Exception e) {
            Bukkit.getLogger().info("There is an error in the config, the cooktime option requires and integer!");
        }

        try {
            xpRelated.setXpBonus(settings.getConfig().getInt("xpbonus_per_item"));
        } catch (Exception e) {
            Bukkit.getLogger().info("There is an error in the config, the xpbonus_per_item option requires an integer!");
        }
    }
}
