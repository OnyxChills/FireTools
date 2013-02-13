package com.onyxchills.firetools;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerListener implements Listener
{		
	@EventHandler
	public void onPlayerAttack(EntityDamageEvent  event)
	{
		Entity mob = event.getEntity();
		
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
