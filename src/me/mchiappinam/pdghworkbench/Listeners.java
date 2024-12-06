package me.mchiappinam.pdghworkbench;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {
	//private Main plugin;
	public Listeners(Main main) {
		//plugin=main;
	}
	
	@EventHandler(priority=EventPriority.MONITOR)
	public void onCraft(CraftItemEvent e) {
	    if(!(e.getRecipe().getResult().getType()==Material.DIAMOND_HELMET/*Elmo Dima 310*/ || 
	    	e.getRecipe().getResult().getType()==Material.DIAMOND_CHESTPLATE/*Peito Dima 311*/ || 
	    	e.getRecipe().getResult().getType()==Material.DIAMOND_LEGGINGS/*Calça Dima 312*/ || 
	    	e.getRecipe().getResult().getType()==Material.DIAMOND_BOOTS/*Bota Dima 313*/ || 
	    	e.getRecipe().getResult().getType()==Material.DIAMOND_SWORD/*Espada Dima 276*/ || 
	    	e.getRecipe().getResult().getType()==Material.DIAMOND/*Dima 264*/ || 
	    	e.getRecipe().getResult().getType()==Material.DIAMOND_BLOCK/*Bloco Dima 57*/ || 
	    	e.getRecipe().getResult().getType()==Material.IRON_BLOCK/*Bloco Ferro 42*/ || 
	    	e.getRecipe().getResult().getType()==Material.GLOWSTONE/*Glowstone 89*/ || 
	    	e.getRecipe().getResult().getType()==Material.LADDER/*Escada 65*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(98)/*Tijolo de Pedra 98*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(80)/*Neve 80*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(72)/*Placa Pressão Madeira 72*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(70)/*Placa Pressão Pedra 70*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(5)/*Madeiras 5*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(143)/*Botão de Madeira 143*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(77)/*Botão de Pedra 77*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(280)/*Graveto 280*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(339)/*Papel 339*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(401)/*Fogos de Artifício 401*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(402)/*Estrela de Fogos de Artifício 402*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(45)/*Tijolos 45*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(82)/*Argila 82*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(159)/*Argila Tingida 159*/ || 
	    	(e.getRecipe().getResult().getType()==Material.getMaterial(282)&&e.getRecipe().getResult().getItemMeta().hasDisplayName())/*Sopa 282*/ || 
	    	e.getRecipe().getResult().getType()==Material.getMaterial(297)/*Pão 297*/)) {
		    Player p = (Player) e.getWhoClicked();
	    	e.setCancelled(true);
	        p.closeInventory();
	        p.sendMessage("§cVocê não tem permissões para criar esse item.");
	        p.sendMessage("§eVocê pode criar apenas:");
	        p.sendMessage("§8╳╳╳╳╳╳╳╳╳╳ §3/Ⓒⓡⓘⓐⓡ §8╳╳╳╳╳╳╳╳╳╳");
	        p.sendMessage("§2---§3---§eDiamantes§3---§2---");
	        p.sendMessage("§eElmo, Peitoral, Calça, Bota, Espada, Diamante");
	        p.sendMessage("§2---§3---§eBlocos§3---§2---");
	        p.sendMessage("§eArgila, Argila Tingida, Bloco de Diamante, Bloco de Ferro, Glowstone, Escada, Tijolo de Pedra, Tijolos, Neve, Placas de Pressão, Madeira, Botões");
	        p.sendMessage("§2---§3---§eOutros§3---§2---");
	        p.sendMessage("§eEstrela de Fogos de Artifício, Fogos de Artifício, Graveto, Pão, Papel");
	    }
	}

	@EventHandler(priority=EventPriority.MONITOR)
	public void onBlockPlace(BlockPlaceEvent e) {
	    if(e.getBlockPlaced().getType()==Material.WORKBENCH) {
	    	if(e.getPlayer().getItemInHand().getItemMeta().hasDisplayName()==false) {
	    		e.getPlayer().sendMessage("§3[Ⓒⓡⓘⓐⓡ] §cEssa workbench não pode ser usada. Compre uma workbench liberada com o comando §a/criar");
	    		//e.getBlock().breakNaturally();
		    	e.setCancelled(true);
	    		e.getPlayer().closeInventory();
	    		e.getPlayer().getInventory().removeItem(new ItemStack(Material.WORKBENCH, 1));
	    	}else{
	    		e.getPlayer().sendMessage("§3[Ⓒⓡⓘⓐⓡ] §aWorkbench liberada! Bom uso! §c(Caso removê-la não será possível colocá-la novamente)");
		    }
	    }
	}
}
