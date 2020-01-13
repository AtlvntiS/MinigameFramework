package br.com.horizon.components;

import br.com.horizon.components.abstractions.CoreComponent;
import br.com.horizon.components.events.PlayerListUpdateEvent;
import br.com.horizon.components.info.MatchInfo;
import br.com.horizon.entities.SingleUser;
import br.com.horizon.entities.abstractions.User;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

@Getter
public class SinglePlayerMatch extends CoreComponent {

    Set<SingleUser> users;

    public SinglePlayerMatch(JavaPlugin plugin, MatchInfo matchInfo) {

        super(plugin, matchInfo);

        users = new HashSet<>();

    }

    public Set<? extends User> getUsers() {
        return users;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if(find(u -> player.getUniqueId().equals(u.getUuid())) != null) {
            // TODO: exception handling, kick the player
        }

        users.add(new SingleUser(player.getUniqueId()));

        plugin.getServer().getPluginManager().callEvent(
                new PlayerListUpdateEvent(
                        PlayerListUpdateEvent.Action.PLAYER_JOIN, users.size() - 1, users.size()
                ));

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();

        User user = find(u -> player.getUniqueId().equals(u.getUuid()));

        if(user == null) {
            // TODO: exception handling, kick the player
        }

        users.remove(user);

        plugin.getServer().getPluginManager().callEvent(
                new PlayerListUpdateEvent(
                        PlayerListUpdateEvent.Action.PLAYER_QUIT, users.size() + 1, users.size()
                ));

    }

}
