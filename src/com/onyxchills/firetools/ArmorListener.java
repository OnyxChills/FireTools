package com.onyxchills.firetools;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmorListener implements Listener 
{	
	ItemStack boots = new ItemStack(Material.GOLD_BOOTS);
	ItemStack pants = new ItemStack(Material.GOLD_LEGGINGS);
	ItemStack chest = new ItemStack(Material.GOLD_CHESTPLATE);
	ItemStack helmet = new ItemStack(Material.GOLD_HELMET);
	
	@EventHandler
	public void onArmorEquip(PlayerMoveEvent event)
	{
		Player player = event.getPlayer();
		if(player.getEquipment().getBoots() == boots && player.getEquipment().getChestplate() == chest && player.getEquipment().getLeggings() == pants && player.getEquipment().getHelmet() == helmet && player.hasPermission("firetools.armor"))
		{
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20*600, 10));
		}
	}

}
