package de.divineitems.enchantment;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class ExecutionerEnchant extends DeathEnchantments {

	public ExecutionerEnchant() {
		setName("Executioner");
		setLore("get the head of the enemy.");
		names.put(getName(), this);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			Player p = e.getEntity().getKiller();
			if (e.getEntityType() != EntityType.PLAYER) {
				if(p.getItemInHand().getItemMeta().getLore().contains(getName())) {
					e.getEntity().getKiller().getInventory().addItem(getSkull(e.getEntity().getName()));
					e.getEntity().getKiller().updateInventory();
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	private ItemStack getSkull(String name) {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		SkullMeta im = (SkullMeta) is.getItemMeta();
		im.setDisplayName(name);
		im.setOwner("MHF_" + name);
		is.setItemMeta(im);
		return is;
	}
	
}
