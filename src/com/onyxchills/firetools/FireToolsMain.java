package com.onyxchills.firetools;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class FireToolsMain extends  JavaPlugin
{
	
	//public static boolean state = false;
	public static boolean statearmor = false;
	ItemStack boots = new ItemStack(Material.GOLD_BOOTS);
	ItemStack pants = new ItemStack(Material.GOLD_LEGGINGS);
	ItemStack chest = new ItemStack(Material.GOLD_CHESTPLATE);
	ItemStack helmet = new ItemStack(Material.GOLD_HELMET);
	
	/*
	 commands:
   firetool:
      description: Toggles Fire Tool ability.
      usage: /<command>
      permission: firetools.tool
      default: op
      permission-message: You don't have permission for that!
   firearmor:
      description: Toggles Fire Armor ability.
      usage: /<command>
      permission: firetools.armor
      default: op
      permission-message: You don't have permission for that!   
	 */
	
	@Override
    public void onEnable()
	{		
		getLogger().info("onEnable has been invoked!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new BlockListener(), this);
		pm.registerEvents(new PlayerListener(), this);
		//pm.registerEvents(new ArmorListener(), this);
	}
	
	@Override
    public void onDisable() {
		getLogger().info("onDisable has been invoked!");
    }
	
	
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {    	
    	Player player = (Player)sender;
    	if(cmd.getName().equalsIgnoreCase("firearmor")) // If the player typed /<command> then do the following...
    	{
    	    if(sender.hasPermission("firetools.armor")) 
    	    {
    	    	if (args.length > 0) 
    	    	{
    	           sender.sendMessage("Too many arguments!");
    	           return false;
    	        } 
    	        	else
    	        	{
    	        		
    	        		// && player.getEquipment().getChestplate().equals(chest) && player.getEquipment().getLeggings().equals(pants) && player.getEquipment().getBoots().equals(boots) && player.getEquipment().getHelmet().equals(helmet)
    	        		if(statearmor == true && player.hasPermission("firetools.armor"))
    	        		{
    	        			statearmor = false;
    	        			sender.sendMessage("FireArmor OFF.");
    	        			player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
    	        			return true;
    	        		}
    	        		else if(statearmor == false && player.hasPermission("firetools.armor") && player.getEquipment().getChestplate().isSimilar(chest) && player.getEquipment().getLeggings().isSimilar(pants) && player.getEquipment().getBoots().isSimilar(boots) && player.getEquipment().getHelmet().isSimilar(helmet))
    	        		{
    	        			statearmor = true;
    	        			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20*600, 10));
    	        			sender.sendMessage("FireArmor ON for 10 minutes. (Requires FULL Gold Armor)");
    	        			return true;
    	        		}
    	        		else
    	        		{
    	        			player.sendMessage("Fork 1");
    	        		}
    	          	}
    	    	}
    	    else
    	    {
    	    	player.sendMessage("Fork 2");
    	    }
    	}
		return false;
    }
}
