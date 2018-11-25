package de.divineitems.item;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ItemConfig {

	public static File file = new File("plugins/DivineItemsRPG/config.yml");
	private FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
	
	private String item;
	
	public ItemConfig(String item) {
		this.item = item + ".";
	}

	public boolean isSet(String val) {
		if (fc.isSet(item + val)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getString(String val) {
		if (isSet(val)) {
			return fc.getString(item + val);
		} else {
			return null;
		}
	}

	public int getInt(String val) {
		if (isSet(val)) {
			return fc.getInt(item + val);
		} else {
			return 0;
		}
	}

	public double getDouble(String val) {
		if (isSet(val)) {
			return fc.getDouble(item + val);
		} else {
			return 0;
		}
	}

	public List<String> getStringList(String val) {
		if (isSet(val)) {
			return fc.getStringList(item + val);
		} else {
			return null;
		}
	}

}
