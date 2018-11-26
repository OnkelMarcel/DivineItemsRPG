package de.divineitems.enchantment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.inventory.ItemStack;

public class EnchantManager {
	
	private HashMap<String, CustomEnchantment> enchantments = new HashMap<String, CustomEnchantment>();

	public void addEnchantment(String val, CustomEnchantment ci) {
		enchantments.put(val, ci);
	}

	public boolean contains(ItemStack im) {
		if (enchantments.containsKey(im.getItemMeta().getDisplayName())) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}

	public List<CustomEnchantment> getEnchantments() {
		List<CustomEnchantment> ci = new ArrayList<>();
		for (CustomEnchantment item : enchantments.values()) {
			ci.add(item);
		}
		return ci;
	}

	public void deleteEnchantment(String name) {
		enchantments.remove(name);
	}

	public CustomEnchantment getEnchantment(String name) {
		return enchantments.get(name);
	}
	
}
