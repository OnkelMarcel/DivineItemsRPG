package de.divineitems.enchantment;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public abstract class DeathEnchantments extends CustomEnchantment implements Listener {
	
	@EventHandler
	abstract void onEntityDeath(EntityDeathEvent e); 
	
}
