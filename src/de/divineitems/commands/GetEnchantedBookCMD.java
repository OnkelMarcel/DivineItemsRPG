package de.divineitems.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.divineitems.main.DivineItemsMain;
import de.divineitems.utils.Utils;

public class GetEnchantedBookCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

		if (cs instanceof Player) {
			if (args.length > 0) {
				Player p = (Player) cs;
				p.getInventory().addItem(DivineItemsMain.EM.getEnchantment(args[1]).getBook());
				p.updateInventory();
			} else {
				cs.sendMessage(Utils.ERROR + "Zu wenig Argumente!");
			}
		}
		
		return true;
	}

}
