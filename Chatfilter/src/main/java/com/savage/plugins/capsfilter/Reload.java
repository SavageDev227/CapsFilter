package com.savage.plugins.capsfilter;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {

    FileConfiguration config = CapsFilter.getPlugin(CapsFilter.class).getConfig();
    CapsFilter plugin = CapsFilter.getPlugin(CapsFilter.class);


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(!p.hasPermission("profile.reloadfilter")) { p.sendMessage(ChatColor.DARK_RED + "You do not have permission to do that!"); }
        if(cmd.getName().equalsIgnoreCase("reloadfilter")) {
            plugin.saveConfig();
            plugin.reloadConfig();

            p.sendMessage(ChatColor.GREEN + "Config Reloaded!");
        }
        return true;
    }
}
