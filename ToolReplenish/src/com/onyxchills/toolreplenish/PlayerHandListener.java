package com.onyxchills.toolreplenish;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerHandListener implements Listener
{

	@EventHandler
	public boolean onPlayerRightClick(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		Material item = player.getItemInHand().getType();
		Action action = event.getAction();
		
		if(event.getAction().equals(action))
		{
			if(player.hasPermission("toolreplenish.fix"))
			{
				/*
    			if(item == Material.WOOD_SPADE || item == Material.WOOD_SWORD || item == Material.WOOD_PICKAXE || item == Material.WOOD_AXE || item == Material.WOOD_HOE)
    			{
    				player.getItemInHand().setDurability((short) ((item.getMaxDurability())-59));
    				return true;
    			}
    			else if(item == Material.STONE_SPADE || item == Material.STONE_SWORD || item == Material.STONE_PICKAXE || item == Material.STONE_AXE || item == Material.STONE_HOE)
    			{
        			player.getItemInHand().setDurability((short) ((item.getMaxDurability())-131));
        			return true;
    			}
    			else if(item == Material.IRON_SPADE || item == Material.IRON_SWORD || item == Material.IRON_PICKAXE || item == Material.IRON_AXE || item == Material.IRON_HOE)
    			{
        			player.getItemInHand().setDurability((short) ((item.getMaxDurability())-250));
        			return true;
    			}
    			*/
    			if(item == Material.GOLD_SPADE || item == Material.GOLD_SWORD || item == Material.GOLD_PICKAXE || item == Material.GOLD_AXE || item == Material.GOLD_HOE)
    			{
        			player.getItemInHand().setDurability((short) ((item.getMaxDurability())-32));
        			return true;
    			}
    			//else if(item == Material.DIAMOND_SPADE || item == Material.DIAMOND_SWORD || item == Material.DIAMOND_PICKAXE || item == Material.DIAMOND_AXE || item == Material.DIAMOND_HOE)
    			//{
        		//	player.getItemInHand().setDurability((short) ((item.getMaxDurability())-1561));
        		//	return true;
    			//}
    		}
		}
		else
		{
			
		}
		return false;
	}
	
}
