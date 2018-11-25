package de.divineitems.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import de.divineitems.enchantment.CustomEnchantment;
import de.divineitems.item.CustomItem;
import de.divineitems.main.DivineItemsMain;

public class AddEnchToItemEvent implements Listener {

	private CustomEnchantment ce;
	private CustomItem ci;

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {

		if (e.getCurrentItem().getType() == Material.ENCHANTED_BOOK) {
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().split(" ").length > 1) {

				ce = CustomEnchantment.names.get(e.getCurrentItem().getItemMeta().getDisplayName().split(" ")[1]);

			} else {

			}

		} else {
			if (e.getCursor().getItemMeta().getDisplayName().split(" ").length > 1) {
				if (CustomEnchantment.names.containsKey(e.getCursor().getItemMeta().getDisplayName().split(" ")[1])) {
					if (e.getCurrentItem().getType() != Material.AIR) {
						Player p = (Player) e.getWhoClicked();
						ci = DivineItemsMain.IM.getItem(e.getCurrentItem().getItemMeta().getDisplayName());
						ci.addCustomEnchant(ce, p, e.getCursor());
						Bukkit.broadcastMessage("Erfolgreich verzaubert!");
					}
				} else {

				}
			} else {

			}
		}

	}

}
