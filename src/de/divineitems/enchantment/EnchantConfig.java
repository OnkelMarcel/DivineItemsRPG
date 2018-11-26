package de.divineitems.enchantment;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class EnchantConfig {
	
	public static File file = new File("plugins/enchantments/enchant.yml");
	private FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
	
	private String enchant;
	
	public EnchantConfig(String enchant) {
		this.enchant = enchant + ".";
	}

	public boolean isSet(String val) {
		if (fc.isSet(enchant + val)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getString(String val) {
		if (isSet(val)) {
			return fc.getString(enchant + val);
		} else {
			return null;
		}
	}

	public int getInt(String val) {
		if (isSet(val)) {
			return fc.getInt(enchant + val);
		} else {
			return 0;
		}
	}

	public double getDouble(String val) {
		if (isSet(val)) {
			return fc.getDouble(enchant + val);
		} else {
			return 0;
		}
	}

	public List<String> getStringList(String val) {
		if (isSet(val)) {
			return fc.getStringList(enchant + val);
		} else {
			return null;
		}
	}
	
}
