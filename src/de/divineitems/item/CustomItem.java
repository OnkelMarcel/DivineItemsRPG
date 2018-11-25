package de.divineitems.item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.divineitems.enchantment.CustomEnchantment;

public class CustomItem {

	private String name;

	private int damage;
	private int amount;

	private Material material;
	private List<String> lore;
	private List<String> realLore;
	
	private ItemConfig ic;

	public CustomItem(String name) {
		this.name = name;
		this.ic = new ItemConfig(name);
	}

	@SuppressWarnings("deprecation")
	public void loadItem() {
		this.name = ic.getString("Displayname");
		this.damage = ic.getInt("Damage");
		this.material = Material.getMaterial(ic.getInt("Id"));
		this.lore = ic.getStringList("Lore");
		this.realLore = new ArrayList<>();
		this.amount = ic.getInt("Amount");
	}
	
	public void addCustomEnchant(CustomEnchantment enchant, Player p, ItemStack toRemove) {
		lore.add("§c" + enchant.getName());
		p.getInventory().remove(toRemove);
		p.updateInventory();
	}
	
	public ItemStack getItem() {
		ItemStack is = new ItemStack(material, amount);
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

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public List<String> getLore() {
		return lore;
	}

	public void setLore(List<String> lore) {
		this.lore = lore;
	}

	public ItemConfig getIc() {
		return ic;
	}

	public void setIc(ItemConfig ic) {
		this.ic = ic;
	}

}
