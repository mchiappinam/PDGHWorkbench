package me.mchiappinam.pdghworkbench;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.mchiappinam.pdghworkbench.Listeners;

public class Main extends JavaPlugin {
	protected static Economy econ = null;
	
	@Override
    public void onEnable() {
		getServer().getPluginManager().registerEvents(new Listeners(this), this);

	    getServer().getPluginCommand("criar").setExecutor(new Comando(this));
	    setupEconomy();
		getServer().getConsoleSender().sendMessage("§3[PDGHWorkbench] §2ativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHWorkbench] §2Acesse: http://pdgh.com.br/");
	}
	
	@Override
    public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHWorkbench] §2desativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHWorkbench] §2Acesse: http://pdgh.com.br/");
    }
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
	
	
	
	
	
	
	
}
