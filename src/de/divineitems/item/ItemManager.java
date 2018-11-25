package de.divineitems.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.inventory.ItemStack;

public class ItemManager {

	private HashMap<String, CustomItem> items = new HashMap<String, CustomItem>();

	public void addItem(String val, CustomItem ci) {
		items.put(val, ci);
	}

	public boolean contains(ItemStack im) {
		if (items.containsKey(im.getItemMeta().getDisplayName())) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}

	public List<CustomItem> getItems() {
		List<CustomItem> ci = new ArrayList<>();
		for (CustomItem item : items.values()) {
			ci.add(item);
		}
		return ci;
	}

	public void deleteItem(String name) {
		items.remove(name);
	}

	public CustomItem getItem(String name) {
		return items.get(name);
	}

}
