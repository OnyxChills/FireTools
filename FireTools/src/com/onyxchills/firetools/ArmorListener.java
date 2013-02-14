package com.onyxchills.firetools;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInventoryEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmorListener implements Listener 
{	
	Material boots = Material.GOLD_BOOTS;
	Material pants = Material.GOLD_LEGGINGS;
	Material chest = Material.GOLD_CHESTPLATE;
	Material helmet = Material.GOLD_HELMET;
	
	@EventHandler
	public void onArmorEquip(PlayerMoveEvent event)
	{
		Player player = event.getPlayer();
		if(player.hasPermission("firetools.armor"))
		{
			if(player.getEquipment().getBoots().getType() == boots && player.getEquipment().getChestplate().getType() == chest && player.getEquipment().getLeggings().getType() == pants && player.getEquipment().getHelmet().getType() == helmet)
			{
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20*5, 10));
			}
			else
			{
				
			}
		}
		else
		{
			
		}
	}

}
