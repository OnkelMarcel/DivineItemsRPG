package de.divineitems.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.divineitems.item.CustomItem;
import de.divineitems.main.DivineItemsMain;

public class ShowLoadedItemsCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		for (CustomItem name : DivineItemsMain.IM.getItems()) {
			cs.sendMessage(name.getName());
		}
		return true;
	}

}
