package br.com.horizon.components.abstractions;

import br.com.horizon.components.info.MatchInfo;
import br.com.horizon.entities.abstractions.User;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;
import java.util.function.Predicate;

@Getter
public abstract class CoreComponent extends Component {

    private MatchInfo matchInfo;

    public CoreComponent(JavaPlugin plugin, MatchInfo matchInfo) {
        super(plugin);
        this.matchInfo = matchInfo;
    }

    public abstract Set<? extends User> getUsers();

    public User find(Predicate<User> predicate) {
        for(User user : getUsers()) {
            if(predicate.test(user)) return user;
        }
        return null;
    }

}

