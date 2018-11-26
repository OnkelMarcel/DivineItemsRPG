package de.divineitems.enchantment;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomEnchantment {
	
	private String name;
	
	private List<String> lore;
	private List<String> realLore;
	
	private EnchantConfig ec;

	public CustomEnchantment(String name) {
		this.name = name;
		this.ec = new EnchantConfig(name);
	}
	
	public void loadBook() {
		this.name = ec.getString("Displayname");
		this.lore = ec.getStringList("Lore");
		this.realLore = new ArrayList<>();
	}
	
	private ItemStack replaceItem(ItemStack old, String addToLore) {
		ItemStack newItem = old;
		ItemMeta im = newItem.getItemMeta();
		List<String> l = new ArrayList<>();
		for(String line : im.getLore()) {
			l.add(line);
		}
		l.add(addToLore);
		im.setLore(l);
		newItem.setItemMeta(im);
		return newItem;
	}
	
	public void addCustomEnchant(String enchant, Player p, ItemStack toEnchant) {
		p.getInventory().addItem(replaceItem(toEnchant, enchant));
		p.getInventory().remove(toEnchant);
		p.updateInventory();
	}
	
	public ItemStack getBook() {
		ItemStack is = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(name);
		
		for(String line : lore) {
			line = ChatColor.GRAY + line;
			realLore.add(line);
		}
		
		im.setLore(realLore);
		is.setItemMeta(im);
		return is;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getLore() {
		return lore;
	}

	public void setLore(List<String> lore) {
		this.lore = lore;
	}

	public EnchantConfig getIc() {
		return ec;
	}

	public void setIc(EnchantConfig ec) {
		this.ec = ec;
	}
	
}
