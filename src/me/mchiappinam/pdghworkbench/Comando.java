package me.mchiappinam.pdghworkbench;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.mchiappinam.pdghworkbench.Main;

public class Comando implements CommandExecutor {
  private Main plugin;
  public Comando(Main main) {
    plugin = main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
    if (cmd.getName().equalsIgnoreCase("criar")) {
        if (args.length >0) {
        	sender.sendMessage("§cUse /criar");
            return true;
        }
        if (!(Main.econ.getBalance(sender.getName()) >= 5000.0)) {
		    sender.sendMessage("§3[Ⓒⓡⓘⓐⓡ] §cVocê não tem money suficiente.");
		    sender.sendMessage("§3[Ⓒⓡⓘⓐⓡ] §cMoney necessário: §a$5000.0§c.");
		    return true;
        }
        Main.econ.withdrawPlayer(sender.getName(), 5000.0);
	    ItemStack workbench = new ItemStack(Material.WORKBENCH, 1);
	    ItemMeta itemMeta = workbench.getItemMeta();
	    itemMeta.setDisplayName(ChatColor.RED+"Ⓒⓡⓘⓐⓡ");
	    workbench.setItemMeta(itemMeta);
	    ((Player) sender).getInventory().addItem(workbench);
        sender.sendMessage("§3[Ⓒⓡⓘⓐⓡ] §aVocê gastou $5000.0 comprando uma workbench liberada.");
        plugin.getServer().broadcastMessage("§3[Ⓒⓡⓘⓐⓡ] §a"+sender.getName()+" gastou $5000.0 comprando uma workbench liberada.");
        return true;
    }
    return false;
  }










}
