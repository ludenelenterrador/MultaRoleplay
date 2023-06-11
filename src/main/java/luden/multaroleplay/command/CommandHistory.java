package luden.multaroleplay.command;

import java.util.Iterator;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandHistory implements CommandExecutor {
    private final JavaPlugin plugin;

    public CommandHistory(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Este comando solo se puede ejecutar en el juego.");
            return true;
        } else {
            Player player = (Player) sender;
            String jugador;
            List multas;
            Iterator var8;
            String multa;
            String[] parts;
            int amount;
            String razon;
            String oficial;
            String date;
            if (player.hasPermission("luden-multa.history")) {
                if (args.length != 1) {
                    jugador = "Uso";
                    player.sendMessage(ChatColor.RED + "Uso: /multahistory <player>");
                    return true;
                }

                jugador = args[0];
                multas = this.plugin.getConfig().getStringList("multas." + jugador + ".lista");
                if (multas == null || multas.isEmpty()) {
                    player.sendMessage(ChatColor.RED + "Este jugador no tiene multas registradas");
                    return true;
                }

                player.sendMessage(ChatColor.RED + "Multas de " + ChatColor.WHITE + jugador + ChatColor.RED + ":");
                player.sendMessage(" ");
                var8 = multas.iterator();

                while (var8.hasNext()) {
                    multa = (String) var8.next();
                    parts = multa.split("\\|");
                    amount = Integer.parseInt(parts[0]);
                    razon = parts[1];
                    oficial = parts[2];
                    date = parts[3];
                    player.sendMessage(ChatColor.RED + "Fecha: " + ChatColor.WHITE + date);
                    player.sendMessage(ChatColor.RED + "Cantidad: " + ChatColor.WHITE + amount + "$");
                    player.sendMessage(ChatColor.RED + "Razon: " + ChatColor.WHITE + razon);
                    player.sendMessage(ChatColor.RED + "Oficial: " + ChatColor.WHITE + oficial);
                    player.sendMessage("");
                }
            } else if (player.isOp()) {
                if (args.length != 1) {
                    jugador = "Uso";
                    player.sendMessage(ChatColor.RED + "Uso: /multahistory <player>");
                    return true;
                }

                jugador = args[0];
                multas = this.plugin.getConfig().getStringList("multas." + jugador + ".lista");
                if (multas == null || multas.isEmpty()) {
                    player.sendMessage(ChatColor.RED + "Este jugador no tiene multas registradas");
                    return true;
                }

                player.sendMessage(ChatColor.RED + "Multas de " + ChatColor.WHITE + jugador + ChatColor.RED + ":");
                player.sendMessage(" ");
                var8 = multas.iterator();

                while (var8.hasNext()) {
                    multa = (String) var8.next();
                    parts = multa.split("\\|");
                    amount = Integer.parseInt(parts[0]);
                    razon = parts[1];
                    oficial = parts[2];
                    date = parts[3];
                    player.sendMessage(ChatColor.RED + "Fecha: " + ChatColor.WHITE + date);
                    player.sendMessage(ChatColor.RED + "Cantidad: " + ChatColor.WHITE + amount + "$");
                    player.sendMessage(ChatColor.RED + "Razon: " + ChatColor.WHITE + razon);
                    player.sendMessage(ChatColor.RED + "Oficial: " + ChatColor.WHITE + oficial);
                    player.sendMessage("");
                }
            } else {
                if (!player.isOp() || !player.hasPermission("luden-multa.history")) {
                    jugador = "Sin-Permisos";
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(jugador)));
                    return true;
                }

                if (args.length != 1) {
                    jugador = "Uso";
                    player.sendMessage(ChatColor.RED + "Uso: /multahistory <player>");
                    return true;
                }

                jugador = args[0];
                multas = this.plugin.getConfig().getStringList("multas." + jugador + ".lista");
                if (multas == null || multas.isEmpty()) {
                    player.sendMessage(ChatColor.RED + "Este jugador no tiene multas registradas");
                    return true;
                }

                player.sendMessage(ChatColor.RED + "Multas de " + ChatColor.WHITE + jugador + ChatColor.RED + ":");
                player.sendMessage(" ");
                var8 = multas.iterator();

                while (var8.hasNext()) {
                    multa = (String) var8.next();
                    parts = multa.split("\\|");
                    amount = Integer.parseInt(parts[0]);
                    razon = parts[1];
                    oficial = parts[2];
                    date = parts[3];
                    player.sendMessage(ChatColor.RED + "Fecha: " + ChatColor.WHITE + date);
                    player.sendMessage(ChatColor.RED + "Cantidad: " + ChatColor.WHITE + amount + "$");
                    player.sendMessage(ChatColor.RED + "Razon: " + ChatColor.WHITE + razon);
                    player.sendMessage(ChatColor.RED + "Oficial: " + ChatColor.WHITE + oficial);
                    player.sendMessage("");
                }
            }

            return false;
        }
    }
}