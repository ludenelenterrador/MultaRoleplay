package luden.multaroleplay.events;

import luden.multaroleplay.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinPlayer implements Listener {
    private Main plugin;

    public JoinPlayer(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void join(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        FileConfiguration config = this.plugin.getConfig();
        if (p.isOp() && !this.plugin.version.equals(this.plugin.latestversion)) {
            p.sendMessage(this.plugin.name + ChatColor.RED + " Hay una nueva versión disponible. " + ChatColor.YELLOW + "(" + ChatColor.GRAY + this.plugin.latestversion + ChatColor.YELLOW + ")");
            p.sendMessage(ChatColor.RED + "Puede descargarlo en: " + ChatColor.WHITE + "https://www.spigotmc.org/resources/108668/");
        }

    }
}