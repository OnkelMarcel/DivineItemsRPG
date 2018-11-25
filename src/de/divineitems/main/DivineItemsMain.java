package de.divineitems.main;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.divineitems.commands.GetEnchantedBookCMD;
import de.divineitems.commands.GetItemCMD;
import de.divineitems.commands.ShowLoadedItemsCMD;
import de.divineitems.enchantment.ExecutionerEnchant;
import de.divineitems.events.AddEnchToItemEvent;
import de.divineitems.events.EntityDamageEvent;
import de.divineitems.item.CustomItem;
import de.divineitems.item.ItemManager;

public class DivineItemsMain extends JavaPlugin {
	
	public static ItemManager IM = new ItemManager();
	
	@Override
	public void onEnable() {
		loadCommands();
		loadConfig();
		registerEvents(getServer().getPluginManager());
		
		for(String s : getConfig().getKeys(false)) {
			CustomItem ci = new CustomItem(s);
			ci.loadItem();
			IM.addItem(ci.getName(), ci);
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
		pm.registerEvents(new ExecutionerEnchant(), this);
	}
	
	private void loadCommands() {
		getCommand("itemgive").setExecutor(new GetItemCMD());
		getCommand("showItems").setExecutor(new ShowLoadedItemsCMD());
		getCommand("getBook").setExecutor(new GetEnchantedBookCMD());
	}
	
}
