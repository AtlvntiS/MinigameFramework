package br.com.horizon.components;

import br.com.horizon.components.abstractions.CoreComponent;
import br.com.horizon.components.info.MatchInfo;
import br.com.horizon.entities.TeamUser;
import br.com.horizon.entities.abstractions.User;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class ChosenTeamMatch extends CoreComponent {

    private Set<TeamUser> users;

    public ChosenTeamMatch(JavaPlugin plugin, MatchInfo matchInfo) {

        super(plugin, matchInfo);

        users = new HashSet<>();

    }

    @Override
    public Set<? extends User> getUsers() {
        return users;
    }
}
