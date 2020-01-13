package br.com.horizon.state.abstractions;

import br.com.horizon.GamePlugin;
import org.bukkit.event.Listener;

public abstract class State implements Listener {

    protected final GamePlugin plugin;

    protected final String stateName;

    public State(GamePlugin plugin, String stateName) {
        this.plugin = plugin;
        this.stateName = stateName;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void next() {
        plugin.getStateManager().next();
    }

}
