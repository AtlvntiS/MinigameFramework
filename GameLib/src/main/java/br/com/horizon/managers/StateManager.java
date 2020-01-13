package br.com.horizon.managers;

import br.com.horizon.GamePlugin;
import br.com.horizon.state.abstractions.State;

import java.util.List;

public class StateManager {

    private final GamePlugin plugin;

    private State actualState;
    private List<? extends State> states;

    public StateManager(GamePlugin plugin, List<? extends State> states) {

        this.plugin = plugin;

        this.actualState = states.get(0);
        this.states = states.subList(1, states.size());

    }

    public void next() {

        actualState = states.get(0);
        states.remove(0);

    }

}
