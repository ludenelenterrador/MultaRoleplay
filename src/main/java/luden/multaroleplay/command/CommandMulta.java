package luden.multaroleplay.command;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandMulta implements CommandExecutor {
    private final JavaPlugin plugin;

    public CommandMulta(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Este comando solo se puede ejecutar en el juego.");
            return true;
        } else {
            Player player = (Player) sender;
            String pathformato;
            Integer amount;
            StringBuilder builder;
            String pathcantidadinvalida;
            int endArg;
            int i;
            List multas;
            Calendar calendar;
            String date;
            String oficial;
            String personamala;
            String pathañadirmulta;
            Player target;
            String pathjugadorinvalido;
            byte startArg;
            String razon;
            if (player.isOp()) {
                if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                    if (sender.isOp()) {
                        pathformato = "Reload";
                        this.plugin.reloadConfig();
                        player.sendMessage(ChatColor.GREEN + "El plugin a sido recargado correctamente.");
                        return true;
                    } else {
                        pathformato = "Sin-Permisos";
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(pathformato)));
                        return true;
                    }
                } else if (args.length < 3) {
                    pathformato = "Formato";
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(pathformato)));
                    return true;
                } else {
                    target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) {
                        pathjugadorinvalido = "Jugador-Invalido";
                        player.sendMessage(ChatColor.RED + "¡Este jugador no existe!");
                        return true;
                    } else if (!target.isOnline()) {
                        player.sendMessage(ChatColor.RED + "El jugador no está en línea.");
                        return true;
                    } else {
                        try {
                            amount = Integer.valueOf(args[1]);
                        } catch (NumberFormatException var18) {
                            pathcantidadinvalida = "Cantidad-Invalida";
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(pathcantidadinvalida)));
                            return true;
                        }

                        builder = new StringBuilder();
                        startArg = 2;
                        endArg = args.length;

                        for (i = startArg; i < endArg; ++i) {
                            builder.append(args[i]).append(args.length > i + 1 ? " " : "");
                        }

                        razon = builder.toString();
                        if (!this.plugin.getConfig().isConfigurationSection("multas")) {
                            this.plugin.getConfig().createSection("multas");
                        }

                        if (!this.plugin.getConfig().isConfigurationSection("multas." + target.getName())) {
                            this.plugin.getConfig().createSection("multas." + target.getName());
                        }

                        multas = this.plugin.getConfig().getStringList("multas." + target.getName() + ".lista");
                        calendar = Calendar.getInstance();
                        date = String.format("%04d-%02d-%02d %02d:%02d:%02d", calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13));
                        oficial = player.getName();
                        personamala = target.getName();
                        multas.add(amount + "|" + razon + "|" + oficial + "|" + date);
                        this.plugin.getConfig().set("multas." + target.getName() + ".lista", multas);
                        this.plugin.saveConfig();
                        player.getInventory().addItem(new ItemStack[]{this.createMulta(target.getName(), amount, razon, oficial, date)});
                        pathañadirmulta = "Añadir-Multa";
                        player.sendMessage(ChatColor.GREEN + "Se ha añadido una multa al jugador: " + ChatColor.WHITE + personamala);
                        this.plugin.reloadConfig();
                        return true;
                    }
                }
            } else if (player.hasPermission("luden-multa.multa")) {
                if (args.length < 3) {
                    pathformato = "Formato";
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(pathformato)));
                    return true;
                } else {
                    target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) {
                        pathjugadorinvalido = "Jugador-Invalido";
                        player.sendMessage(ChatColor.RED + "¡Este jugador no existe!");
                        return true;
                    } else if (!target.isOnline()) {
                        player.sendMessage(ChatColor.RED + "El jugador no está en línea.");
                        return true;
                    } else {
                        try {
                            amount = Integer.valueOf(args[1]);
                        } catch (NumberFormatException var19) {
                            pathcantidadinvalida = "Cantidad-Invalida";
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(pathcantidadinvalida)));
                            return true;
                        }

                        builder = new StringBuilder();
                        startArg = 2;
                        endArg = args.length;

                        for (i = startArg; i < endArg; ++i) {
                            builder.append(args[i]).append(args.length > i + 1 ? " " : "");
                        }

                        razon = builder.toString();
                        if (!this.plugin.getConfig().isConfigurationSection("multas")) {
                            this.plugin.getConfig().createSection("multas");
                        }

                        if (!this.plugin.getConfig().isConfigurationSection("multas." + target.getName())) {
                            this.plugin.getConfig().createSection("multas." + target.getName());
                        }

                        multas = this.plugin.getConfig().getStringList("multas." + target.getName() + ".lista");
                        calendar = Calendar.getInstance();
                        date = String.format("%04d-%02d-%02d %02d:%02d:%02d", calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13));
                        oficial = player.getName();
                        personamala = target.getName();
                        multas.add(amount + "|" + razon + "|" + oficial + "|" + date);
                        this.plugin.getConfig().set("multas." + target.getName() + ".lista", multas);
                        this.plugin.saveConfig();
                        player.getInventory().addItem(new ItemStack[]{this.createMulta(target.getName(), amount, razon, oficial, date)});
                        pathañadirmulta = "Añadir-Multa";
                        player.sendMessage(ChatColor.GREEN + "Se ha añadido una multa al jugador: " + ChatColor.WHITE + personamala);
                        this.plugin.reloadConfig();
                        return true;
                    }
                }
            } else if (player.hasPermission("luden-multa.multa") && player.isOp()) {
                if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                    if (sender.isOp()) {
                        pathformato = "Reload";
                        this.plugin.reloadConfig();
                        player.sendMessage(ChatColor.GREEN + "El plugin a sido recargado correctamente.");
                        return true;
                    } else {
                        pathformato = "Sin-Permisos";
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(pathformato)));
                        return true;
                    }
                } else if (args.length < 3) {
                    pathformato = "Formato";
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(pathformato)));
                    return true;
                } else {
                    target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) {
                        pathjugadorinvalido = "Jugador-Invalido";
                        player.sendMessage(ChatColor.RED + "¡Este jugador no existe!");
                        return true;
                    } else if (!target.isOnline()) {
                        player.sendMessage(ChatColor.RED + "El jugador no está en línea.");
                        return true;
                    } else {
                        try {
                            amount = Integer.valueOf(args[1]);
                        } catch (NumberFormatException var20) {
                            pathcantidadinvalida = "Cantidad-Invalida";
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(pathcantidadinvalida)));
                            return true;
                        }

                        builder = new StringBuilder();
                        startArg = 2;
                        endArg = args.length;

                        for (i = startArg; i < endArg; ++i) {
                            builder.append(args[i]).append(args.length > i + 1 ? " " : "");
                        }

                        razon = builder.toString();
                        if (!this.plugin.getConfig().isConfigurationSection("multas")) {
                            this.plugin.getConfig().createSection("multas");
                        }

                        if (!this.plugin.getConfig().isConfigurationSection("multas." + target.getName())) {
                            this.plugin.getConfig().createSection("multas." + target.getName());
                        }

                        multas = this.plugin.getConfig().getStringList("multas." + target.getName() + ".lista");
                        calendar = Calendar.getInstance();
                        date = String.format("%04d-%02d-%02d %02d:%02d:%02d", calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13));
                        oficial = player.getName();
                        personamala = target.getName();
                        multas.add(amount + "|" + razon + "|" + oficial + "|" + date);
                        this.plugin.getConfig().set("multas." + target.getName() + ".lista", multas);
                        this.plugin.saveConfig();
                        player.getInventory().addItem(new ItemStack[]{this.createMulta(target.getName(), amount, razon, oficial, date)});
                        pathañadirmulta = "Añadir-Multa";
                        player.sendMessage(ChatColor.GREEN + "Se ha añadido una multa al jugador: " + ChatColor.WHITE + personamala);
                        this.plugin.reloadConfig();
                        return true;
                    }
                }
            } else {
                pathformato = "Sin-Permisos";
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(pathformato)));
                return true;
            }


        }
    }

    private ItemStack createMulta(String playerName, int amount, String razonI, String oficial1, String date) {
        ItemStack item = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "Multa Policial");
        List<String> lore = new ArrayList();
        lore.add(ChatColor.RED + "Nombre: " + ChatColor.WHITE + playerName);
        lore.add(ChatColor.RED + "Cantidad: " + ChatColor.WHITE + amount + "$");
        lore.add(ChatColor.RED + "Razón: " + ChatColor.WHITE + razonI);
        lore.add("");
        lore.add(ChatColor.RED + "Multa hecha por el oficial: " + ChatColor.WHITE + oficial1);
        lore.add(ChatColor.RED + "Fecha: " + ChatColor.WHITE + date);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

}