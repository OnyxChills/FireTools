package com.onyxchills.toolreplenish;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ToolReplenishMain extends JavaPlugin
{
	@Override
    public void onEnable()
	{		
		getLogger().info("onEnable has been invoked!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerHandListener(), this);
	}
	
	@Override
    public void onDisable() {
		getLogger().info("onDisable has been invoked!");
    }
}
