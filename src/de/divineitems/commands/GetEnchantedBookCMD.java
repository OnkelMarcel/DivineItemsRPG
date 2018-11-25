package de.divineitems.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.divineitems.enchantment.CustomEnchantment;

public class GetEnchantedBookCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (args.length > 0) {
				if (CustomEnchantment.names.containsKey(args[0])) {
					p.getInventory().addItem(CustomEnchantment.names.get(args[0]).getItem());
					p.updateInventory();
				} else {
					p.sendMessage("Dieses Buch gibt es nicht!");
				}
			}
		}
		
		return true;
	}

}
