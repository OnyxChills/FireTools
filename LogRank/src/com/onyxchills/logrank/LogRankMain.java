package com.onyxchills.logrank;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LogRankMain extends JavaPlugin
{
	
	@Override
    public void onEnable()
	{		
		try {
			if(getConfig().isSet("Password"))
			{
				getConfig(); // gets you the config
				// gets a String object from path, or returns "default" if the path was not found (useful to prevent NPE's).
				// This can also return other variables like getInt("path", 0) will return an int with default 0
			}
			else
			{
				getConfig().set("Password", "password"); // Object can be anything, like a String or int
				// Another way for defaults could be using copyDefaults
				getConfig().options().copyDefaults(true);
				// Call this after every modification:
				saveConfig();
				getLogger().warning("File: \"config.yml\" not found, was created with default settings.");
			}
			} 
		catch (Exception e) 
			{
				e.printStackTrace();
			}
	}
		
	@Override
    public void onDisable() {
		getLogger().info("");
    }
	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	    {    	
	    	Player player = (Player)sender;
	    	String name = player.getName();
	    	String password = this.getConfig().getString("Password");

	    	if(args.length == 1 && args[0].equals(password)) 
	    	{
	    		if(cmd.getName().equalsIgnoreCase("join"))
	    		{
	    			Bukkit.getServer().dispatchCommand(player.getServer().getConsoleSender(), "perms setrank " + name + " user");
	    			return true;
	    		}
	    	}
			return false;
	    }
}
