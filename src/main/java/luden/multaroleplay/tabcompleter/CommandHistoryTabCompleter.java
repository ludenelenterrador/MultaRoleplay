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

public class CommandHistoryTabCompleter implements TabCompleter {
    public CommandHistoryTabCompleter() {
    }

    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;
        ArrayList playerNames;
        Player[] players;
        int i;
        if (player.isOp() && args.length == 1) {
            playerNames = new ArrayList();
            players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);

            for (i = 0; i < players.length; ++i) {
                playerNames.add(players[i].getName());
            }

            return playerNames;
        } else if (player.hasPermission("luden-multa.history") && args.length == 1) {
            playerNames = new ArrayList();
            players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);

            for (i = 0; i < players.length; ++i) {
                playerNames.add(players[i].getName());
            }

            return playerNames;
        } else if (player.hasPermission("luden-multa.history") && player.isOp() && args.length == 1) {
            playerNames = new ArrayList();
            players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);

            for (i = 0; i < players.length; ++i) {
                playerNames.add(players[i].getName());
            }

            return playerNames;
        } else {
            return null;
        }
    }
}