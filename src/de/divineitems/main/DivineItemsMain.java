package de.divineitems.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.divineitems.commands.GetEnchantedBookCMD;
import de.divineitems.commands.GetItemCMD;
import de.divineitems.commands.ShowLoadedItemsCMD;
import de.divineitems.enchantment.CustomEnchantment;
import de.divineitems.enchantment.EnchantManager;
import de.divineitems.events.AddEnchToItemEvent;
import de.divineitems.events.EntityDamageEvent;
import de.divineitems.item.CustomItem;
import de.divineitems.item.ItemManager;

public class DivineItemsMain extends JavaPlugin {
	
	public static ItemManager IM = new ItemManager();
	public static EnchantManager EM = new EnchantManager();
	
	@Override
	public void onEnable() {
		loadCommands();
		loadConfig();
		registerEvents(getServer().getPluginManager());
		
		try {
			getConfig().load(new File("plugins/Items/Items.yml"));
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
		for(String s : getConfig().getKeys(false)) {
			CustomItem ci = new CustomItem(s);
			ci.loadItem();
			IM.addItem(ci.getName(), ci);
		}
		
		try {
			getConfig().load(new File("plugins/enchantments/enchant.yml"));
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
		for(String s : getConfig().getKeys(false)) {
			CustomEnchantment ce = new CustomEnchantment(s);
			ce.loadBook();
			EM.addEnchantment(ce.getName(), ce);
		}
		
		System.out.println("[DivineItems] Enabled");
	}
	
	public void onDisable() {
		System.out.println("[DivineItems] Disabled");
	}
	
	private void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	private void registerEvents(PluginManager pm) {
		pm.registerEvents(new EntityDamageEvent(), this);
		pm.registerEvents(new AddEnchToItemEvent(), this);
	}
	
	private void loadCommands() {
		getCommand("itemgive").setExecutor(new GetItemCMD());
		getCommand("showItems").setExecutor(new ShowLoadedItemsCMD());
		getCommand("getBook").setExecutor(new GetEnchantedBookCMD());
	}
	
}
