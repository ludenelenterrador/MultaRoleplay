package luden.multaroleplay;

import luden.multaroleplay.command.CommandHistory;
import luden.multaroleplay.command.CommandMulta;
import luden.multaroleplay.events.JoinPlayer;
import luden.multaroleplay.tabcompleter.CommandHistoryTabCompleter;
import luden.multaroleplay.tabcompleter.CommandMultaTabCompleter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class Main extends JavaPlugin implements Listener, CommandExecutor {
    ConsoleCommandSender mycmd = Bukkit.getConsoleSender();
    PluginDescriptionFile pdfile = this.getDescription();
    public String path;
    public String version;
    public String latestversion;
    public String name;

    public Main() {
        this.version = this.pdfile.getVersion();
        this.latestversion = this.pdfile.getVersion();
        this.name = ChatColor.YELLOW + "[" + ChatColor.RED + this.pdfile.getName() + ChatColor.YELLOW + "]";
    }

    public void onLoad() {
        this.mycmd.sendMessage("[Luden-Multa] Loading...");
        this.mycmd.sendMessage("[Luden-Multa] This plugin is created by Luden...");
    }

    public void onEnable() {

        this.insertConfig();
        this.updateChecker();

        this.getCommand("multa").setExecutor(new CommandMulta(this));
        this.getCommand("multa").setTabCompleter(new CommandMultaTabCompleter());
        this.getCommand("multahistory").setExecutor(new CommandHistory(this));
        this.getCommand("multahistory").setTabCompleter(new CommandHistoryTabCompleter());
        this.getServer().getPluginManager().registerEvents(new JoinPlayer(this), this);
        this.mycmd.sendMessage("");
        this.mycmd.sendMessage("§b   Luden " + this.version + " Multa");
        this.mycmd.sendMessage("§e   Paper | Spigot     ");
        this.mycmd.sendMessage("§bhttps://luden.x10.mx/");
        this.mycmd.sendMessage("");
        this.mycmd.sendMessage("[Luden-Multa] Successfully enabled.");
    }

    public void onDisable() {
        this.mycmd.sendMessage("[Luden-Multa] Goodbye!");
        this.mycmd.sendMessage("[Luden-Multa] Saved Configs!");
    }

    public void insertConfig() {
        File config = new File(this.getDataFolder(), "config.yml");
        path = config.getPath();
        if (!config.exists()) {
            this.getConfig().options().copyDefaults(true);
            this.saveDefaultConfig();
        }

    }

    public void updateChecker() {
        try {
            HttpURLConnection con = (HttpURLConnection) (new URL("https://api.spigotmc.org/legacy/update.php?resource=108668")).openConnection();
            int timed_out = 1250;
            con.setConnectTimeout(timed_out);
            con.setReadTimeout(timed_out);
            this.latestversion = (new BufferedReader(new InputStreamReader(con.getInputStream()))).readLine();
            if (this.latestversion.length() <= 7 && !this.version.equals(this.latestversion)) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Hay una nueva versión disponible. " + ChatColor.YELLOW + "(" + ChatColor.GRAY + this.latestversion + ChatColor.YELLOW + ")");
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Puede descargarlo en: " + ChatColor.WHITE + "https://www.spigotmc.org/resources/108668/");
            }
        } catch (Exception var3) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Error al comprobar la actualización.");
        }

    }
}