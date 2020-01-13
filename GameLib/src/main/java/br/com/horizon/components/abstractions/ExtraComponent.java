package br.com.horizon.components.abstractions;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public abstract class ExtraComponent extends Component {

    List<Class<? extends ExtraComponent>> conflicts;

    public ExtraComponent(JavaPlugin plugin, Class<? extends ExtraComponent>... conflicts) {

        super(plugin);

        this.conflicts = Arrays.asList(conflicts);

    }

    public void init() {
        registerListeners();
    }

}
