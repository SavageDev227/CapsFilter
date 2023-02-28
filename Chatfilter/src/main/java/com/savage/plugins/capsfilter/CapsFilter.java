package com.savage.plugins.capsfilter;

import com.savage.plugins.capsfilter.filter.Filter;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class CapsFilter extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Filter(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Plugin Enabled!");
        getCommand("reloadfilter").setExecutor(new Reload());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
