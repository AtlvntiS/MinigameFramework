package br.com.horizon;

import br.com.horizon.components.abstractions.CoreComponent;
import br.com.horizon.components.abstractions.ExtraComponent;
import br.com.horizon.managers.ComponentManager;
import br.com.horizon.managers.StateManager;
import br.com.horizon.state.abstractions.State;
import com.avaje.ebean.Ebean;
import com.google.common.eventbus.EventBus;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

@Getter
public abstract class GamePlugin extends JavaPlugin {

    @Getter
    private static GamePlugin instance;

    private ComponentManager componentManager;
    private StateManager stateManager;

    @Override
    public void onEnable() {

        instance = this;

        componentManager = new ComponentManager(this, withCoreComponent(), withExtraComponents());
        stateManager = new StateManager(this, withStates());

        enable();

    }

    @Override
    public void onDisable() {

        disable();

    }

    public abstract void enable();
    public abstract void disable();

    public abstract CoreComponent withCoreComponent();

    public abstract List<? extends ExtraComponent> withExtraComponents();

    public abstract List<? extends State> withStates();
}
