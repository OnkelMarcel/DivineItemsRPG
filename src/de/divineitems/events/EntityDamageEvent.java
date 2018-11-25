package de.divineitems.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.divineitems.main.DivineItemsMain;

public class EntityDamageEvent implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (DivineItemsMain.IM.contains(p.getItemInHand())) {
				e.setDamage(DivineItemsMain.IM.getItem(p.getItemInHand().getItemMeta().getDisplayName()).getDamage());
			}
		}

	}

}
