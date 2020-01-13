package br.com.horizonmc.skywars;

import br.com.horizon.GamePlugin;
import br.com.horizon.components.abstractions.CoreComponent;
import br.com.horizon.components.SinglePlayerMatch;
import br.com.horizon.components.abstractions.ExtraComponent;
import br.com.horizon.components.info.MatchInfo;
import br.com.horizon.state.WaitingState;
import br.com.horizon.state.abstractions.State;

import java.util.Arrays;
import java.util.List;

public class Main extends GamePlugin {

    public void enable() {

    }

    public void disable() {

    }

    public CoreComponent withCoreComponent() {
        return new SinglePlayerMatch(this, new MatchInfo(8, 4));
    }

    public List<? extends ExtraComponent> withExtraComponents() {
        return Arrays.asList(
        );
    }

    public List<? extends State> withStates() {
        return Arrays.asList(
                new WaitingState(this, 30)
        );
    }

}
