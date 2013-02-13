package com.onyxchills.firetools;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerListener implements Listener
{		
	@EventHandler
	public void onPlayerAttack(EntityDamageEvent  event)
	{		
		if(event instanceof EntityDamageByEntityEvent)
		{
			EntityDamageByEntityEvent e = (EntityDamageByEntityEvent) event;
			Entity damager = e.getDamager();
			
			if(damager instanceof Player)
			{
				Player player = (Player) damager;
				if(player.getItemInHand().getType() == Material.GOLD_SWORD && player.hasPermission("firetools.sword"))
				{
					Entity damaged = event.getEntity();
					damaged.setFireTicks(20*4);
				}
			}
		}
	}
}
