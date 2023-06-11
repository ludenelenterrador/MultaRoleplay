package luden.multaroleplay.tabcompleter;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CommandMultaTabCompleter implements TabCompleter {
    public  CommandMultaTabCompleter() {
    }

    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;
        ArrayList razones;
        Player[] players;
        int i;
        if (player.isOp() && args.length == 1) {
            razones = new ArrayList();
            players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);

            for (i = 0; i < players.length; ++i) {
                razones.add(players[i].getName());
            }

            razones.add("reload");
            return razones;
        } else if (player.hasPermission("luden-multa.multa") && args.length == 1) {
            razones = new ArrayList();
            players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);

            for (i = 0; i < players.length; ++i) {
                razones.add(players[i].getName());
            }

            razones.add("reload");
            return razones;
        } else if (player.hasPermission("luden-multa.multa") && player.isOp() && args.length == 1) {
            razones = new ArrayList();
            players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);

            for (i = 0; i < players.length; ++i) {
                razones.add(players[i].getName());
            }

            razones.add("reload");
            return razones;
        } else if (player.isOp() && args.length == 2) {
            razones = new ArrayList();
            razones.add("(Cantidad)");
            return razones;
        } else if (player.hasPermission("luden-multa.multa") && args.length == 2) {
            razones = new ArrayList();
            razones.add("(Cantidad)");
            return razones;
        } else if (player.hasPermission("luden-multa.multa") && player.isOp() && args.length == 2) {
            razones = new ArrayList();
            razones.add("(Cantidad)");
            return razones;
        } else if (player.isOp() && args.length > 2) {
            razones = new ArrayList();
            razones.add("Uso de Mascara");
            razones.add("Robo a OxxO");
            razones.add("Robo a Banco");
            razones.add("Robo a Joyería");
            razones.add("Robo a un civil");
            razones.add("Robo a un local");
            razones.add("Robo de vehículo");
            razones.add("Asalto sin armas");
            razones.add("Asalto con arma blanca");
            razones.add("Asalto con arma de fuego");
            razones.add("Porte arma Blanca");
            razones.add("Porte de armas de Bajo de Calibre");
            razones.add("Porte de armas de Medio de Calibre");
            razones.add("Porte de armas de Alto Calibre");
            razones.add("Uso de explosivos");
            razones.add("Porte de explosivos");
            razones.add("No portar dni");
            razones.add("Intento de asesinato a un civil");
            razones.add("Intento de asesinato a un funcionario publico");
            razones.add("Homicidio frustado a un civil");
            razones.add("Homicidio frustado a un funcionario publico");
            razones.add("Asesinato a un civil");
            razones.add("Asesinato a un funcionario publico");
            razones.add("Agresion Fisica");
            razones.add("Agresion Verbal");
            razones.add("Soborno");
            razones.add("Antirol");
            razones.add("Falta de respeto a un funcionario publico");
            razones.add("Interrumpir el trabajo de un funcionario publico");
            razones.add("Porte de Drogas");
            razones.add("Consumo de estupefacientes | (Estupefaciente)");
            razones.add("Riña callejera | (Puños/Armas/Blanca)");
            razones.add("Disturbius en Zonas Publicas");
            razones.add("Acoso");
            razones.add("Secuestro a un civil");
            razones.add("Secuestro a un funcionario publico");
            razones.add("Allanamiento de morada");
            razones.add("Usurpación de vehículo");
            razones.add("Atropello a un civil");
            razones.add("Detenido por orden busqueda y captura");
            razones.add("Terrorismo");
            razones.add("Acusacion falsa");
            razones.add("Incitacion al odio");
            razones.add("Incumplimiento de contrato");
            razones.add("Falsificación de firma");
            razones.add("Falsificación de un documento");
            razones.add("Estafa");
            razones.add("Prostitucion");
            razones.add("Abrir un establecimiento sin licencia");
            razones.add("Imprimir dinero");
            razones.add("Usurpacion de identidad de un civil");
            razones.add("Usurpacion de identidad de un funcionario publico");
            razones.add("Amenaza a un civil");
            razones.add("Amenaza a un funcionario publico");
            razones.add("Porte de chaleco antibalas | (Normal/Falso)");
            razones.add("Vandalismo en propiedad pública");
            razones.add("Vandalismo en propiedad privada");
            razones.add("Conduccion temeraria");
            razones.add("Escandalo publico");
            return razones;
        } else if (player.hasPermission("luden-multa.multa") && args.length > 2) {
            razones = new ArrayList();
            razones.add("Uso de Mascara");
            razones.add("Robo a OxxO");
            razones.add("Robo a Banco");
            razones.add("Robo a Joyería");
            razones.add("Robo a un civil");
            razones.add("Robo a un local");
            razones.add("Robo de vehículo");
            razones.add("Asalto sin armas");
            razones.add("Asalto con arma blanca");
            razones.add("Asalto con arma de fuego");
            razones.add("Porte arma Blanca");
            razones.add("Porte de armas de Bajo de Calibre");
            razones.add("Porte de armas de Medio de Calibre");
            razones.add("Porte de armas de Alto Calibre");
            razones.add("Uso de explosivos");
            razones.add("Porte de explosivos");
            razones.add("No portar dni");
            razones.add("Intento de asesinato a un civil");
            razones.add("Intento de asesinato a un funcionario publico");
            razones.add("Homicidio frustado a un civil");
            razones.add("Homicidio frustado a un funcionario publico");
            razones.add("Asesinato a un civil");
            razones.add("Asesinato a un funcionario publico");
            razones.add("Agresion Fisica");
            razones.add("Agresion Verbal");
            razones.add("Soborno");
            razones.add("Antirol");
            razones.add("Falta de respeto a un funcionario publico");
            razones.add("Interrumpir el trabajo de un funcionario publico");
            razones.add("Porte de Drogas");
            razones.add("Consumo de estupefacientes | (Estupefaciente)");
            razones.add("Riña callejera | (Puños/Armas/Blanca)");
            razones.add("Disturbius en Zonas Publicas");
            razones.add("Acoso");
            razones.add("Secuestro a un civil");
            razones.add("Secuestro a un funcionario publico");
            razones.add("Allanamiento de morada");
            razones.add("Usurpación de vehículo");
            razones.add("Atropello a un civil");
            razones.add("Detenido por orden busqueda y captura");
            razones.add("Terrorismo");
            razones.add("Acusacion falsa");
            razones.add("Incitacion al odio");
            razones.add("Incumplimiento de contrato");
            razones.add("Falsificación de firma");
            razones.add("Falsificación de un documento");
            razones.add("Estafa");
            razones.add("Prostitucion");
            razones.add("Abrir un establecimiento sin licencia");
            razones.add("Imprimir dinero");
            razones.add("Usurpacion de identidad de un civil");
            razones.add("Usurpacion de identidad de un funcionario publico");
            razones.add("Amenaza a un civil");
            razones.add("Amenaza a un funcionario publico");
            razones.add("Porte de chaleco antibalas | (Normal/Falso)");
            razones.add("Vandalismo en propiedad pública");
            razones.add("Vandalismo en propiedad privada");
            razones.add("Conduccion temeraria");
            razones.add("Escandalo publico");
            return razones;
        } else if (player.isOp() && player.hasPermission("luden-multa.multa") && args.length > 2) {
            razones = new ArrayList();
            razones.add("Uso de Mascara");
            razones.add("Robo a OxxO");
            razones.add("Robo a Banco");
            razones.add("Robo a Joyería");
            razones.add("Robo a un civil");
            razones.add("Robo a un local");
            razones.add("Robo de vehículo");
            razones.add("Asalto sin armas");
            razones.add("Asalto con arma blanca");
            razones.add("Asalto con arma de fuego");
            razones.add("Porte arma Blanca");
            razones.add("Porte de armas de Bajo de Calibre");
            razones.add("Porte de armas de Medio de Calibre");
            razones.add("Porte de armas de Alto Calibre");
            razones.add("Uso de explosivos");
            razones.add("Porte de explosivos");
            razones.add("No portar dni");
            razones.add("Intento de asesinato a un civil");
            razones.add("Intento de asesinato a un funcionario publico");
            razones.add("Homicidio frustado a un civil");
            razones.add("Homicidio frustado a un funcionario publico");
            razones.add("Asesinato a un civil");
            razones.add("Asesinato a un funcionario publico");
            razones.add("Agresion Fisica");
            razones.add("Agresion Verbal");
            razones.add("Soborno");
            razones.add("Antirol");
            razones.add("Falta de respeto a un funcionario publico");
            razones.add("Interrumpir el trabajo de un funcionario publico");
            razones.add("Porte de Drogas");
            razones.add("Consumo de estupefacientes | (Estupefaciente)");
            razones.add("Riña callejera | (Puños/Armas/Blanca)");
            razones.add("Disturbius en Zonas Publicas");
            razones.add("Acoso");
            razones.add("Secuestro a un civil");
            razones.add("Secuestro a un funcionario publico");
            razones.add("Allanamiento de morada");
            razones.add("Usurpación de vehículo");
            razones.add("Atropello a un civil");
            razones.add("Detenido por orden busqueda y captura");
            razones.add("Terrorismo");
            razones.add("Acusacion falsa");
            razones.add("Incitacion al odio");
            razones.add("Incumplimiento de contrato");
            razones.add("Falsificación de firma");
            razones.add("Falsificación de un documento");
            razones.add("Estafa");
            razones.add("Prostitucion");
            razones.add("Abrir un establecimiento sin licencia");
            razones.add("Imprimir dinero");
            razones.add("Usurpacion de identidad de un civil");
            razones.add("Usurpacion de identidad de un funcionario publico");
            razones.add("Amenaza a un civil");
            razones.add("Amenaza a un funcionario publico");
            razones.add("Porte de chaleco antibalas | (Normal/Falso)");
            razones.add("Vandalismo en propiedad pública");
            razones.add("Vandalismo en propiedad privada");
            razones.add("Conduccion temeraria");
            razones.add("Escandalo publico");
            return razones;
        } else {
            return null;
        }
    }
}