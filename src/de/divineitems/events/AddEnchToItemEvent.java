package de.divineitems.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import de.divineitems.main.DivineItemsMain;

public class AddEnchToItemEvent implements Listener {

	private ItemStack toEnchant;

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getCurrentItem().getType() != Material.AIR) {
			if (!DivineItemsMain.EM.contains(e.getCurrentItem())) {
				if (DivineItemsMain.IM.contains(e.getCurrentItem())) {
					toEnchant = e.getCurrentItem();
				} else {
					return;
				}
			} else {
				if (DivineItemsMain.EM.contains(e.getCurrentItem())) {
					DivineItemsMain.EM.getEnchantment(e.getCurrentItem().getItemMeta().getDisplayName())
							.addCustomEnchant(e.getCurrentItem().getItemMeta().getDisplayName(),
									(Player) e.getWhoClicked(), toEnchant);
					System.out.println("true");
				} else {
					System.out.println("false");
					return;
				}
			}
		}
	}
}
