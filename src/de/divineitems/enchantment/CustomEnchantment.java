package de.divineitems.enchantment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class CustomEnchantment {
	
	private String name, level;
	private int successRate, failureRate, chance;
	private List<String> lore;
	public static HashMap<String, CustomEnchantment> names = new HashMap<>();
	
	public CustomEnchantment(String name, String level, int successRate, int failureRate, int chance) {
		this.name = name;
		this.level = level;
		this.successRate = successRate;
		this.lore = new ArrayList<>();
	}
	
	public CustomEnchantment() {
		this.lore = new ArrayList<>();
	}
	
	
	public ItemStack getItem() {
		ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta im = book.getItemMeta();
		im.setDisplayName("§c(Enchant) " + this.name + " " + this.level);
		im.setLore(this.lore);
		book.setItemMeta(im);
		return book;
	}
	
	public void setLore(String description) {
		this.lore.add("---------- Info ----------");
		this.lore.add("> Type: Divine Enchant");
		this.lore.add("> Level: " + this.level);
		this.lore.add("> Success: " + this.successRate + " : Failure: " + this.failureRate);
		this.lore.add("---------- Description ----------");
		this.lore.add("You have a chance " + this.chance + " to " + description);
		this.lore.add("");
		this.lore.add("(Drag on item to enchant)");
	}
	
	public void setChance(int chance) {
		this.chance = chance;
	}
	
	public int getChance() {
		return this.chance;
	}
	
	public int getFailureRate() {
		return this.failureRate;
	}
	
	public void setFailureRate(int failureRate) {
		this.failureRate = failureRate;
	}
	
	public void setSuccessRate(int successRate) {
		this.successRate = successRate;
	}
	
	public int getSuccessRate() {
		return this.successRate;
	}
	
	public List<String> getLore() {
		return this.lore;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getLevel() {
		return this.level;
	}
	
}
