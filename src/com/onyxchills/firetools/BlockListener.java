package com.onyxchills.firetools;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class BlockListener implements Listener
{
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
    {
    	Player player = event.getPlayer();
    	Block block = event.getBlock();
    	Location location = block.getLocation();
    	    	
    	if(player.hasPermission("firetools.pickaxe") && block.getType() == Material.STONE && player.getItemInHand().getType() == Material.GOLD_PICKAXE)
    	{
    		event.setCancelled(true);
    		block.setType(Material.AIR);
    		block.getWorld().dropItemNaturally(location, new ItemStack(Material.STONE, 1));
    	}
    	else if(player.hasPermission("firetools.shovel") && block.getType() == Material.SAND && player.getItemInHand().getType() == Material.GOLD_SPADE)
    	{
    		event.setCancelled(true);
    		block.setType(Material.AIR);
    		block.getWorld().dropItemNaturally(location, new ItemStack(Material.GLASS, 1));
    	}
    	else if(player.hasPermission("firetools.shovel") && block.getType() == Material.GRAVEL && player.getItemInHand().getType() == Material.GOLD_SPADE)
    	{
    		event.setCancelled(true);
    		block.setType(Material.AIR);
    		block.getWorld().dropItemNaturally(location, new ItemStack(Material.FLINT, 1));
    	}
    	else if(player.hasPermission("firetools.hoe") && block.getType() == Material.WHEAT && player.getItemInHand().getType() == Material.GOLD_HOE)
    	{
    		event.setCancelled(true);
    		block.setType(Material.AIR);
    		block.getWorld().dropItemNaturally(location, new ItemStack(Material.BREAD, 1));
    	}
    	else if(player.hasPermission("firetools.axe") && block.getType() == Material.BOOKSHELF && player.getItemInHand().getType() == Material.GOLD_AXE)
    	{
    		event.setCancelled(true);
    		block.setType(Material.AIR);
    		block.getWorld().dropItemNaturally(location, new ItemStack(Material.BOOKSHELF, 1));
    	}
    	else if(block.getType() == Material.LOG)
    	{
    		if(player.hasPermission("firetools.axe") && player.getItemInHand().getType() == Material.GOLD_AXE && (block.getData() == 0 || block.getData() == 1 || block.getData() == 2 || block.getData() == 3))
        	{
        		event.setCancelled(true);
        		block.setType(Material.AIR);
        		block.getWorld().dropItemNaturally(location, new ItemStack(Material.COAL, 1));
        	}
    		else
    		{
    			
    		}
    	}
    	
    }	
}