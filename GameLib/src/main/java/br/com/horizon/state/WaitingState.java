package br.com.horizon.state;

import br.com.horizon.GamePlugin;
import br.com.horizon.components.events.PlayerListUpdateEvent;
import br.com.horizon.libs.countdown.Countdown;
import br.com.horizon.state.abstractions.State;
import br.com.horizon.utils.GameTime;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.scheduler.BukkitTask;

public class WaitingState extends State {

    private InternalState internalState;

    private Countdown countdown;

    public WaitingState(GamePlugin plugin, int wait) {
        super(plugin, "Waiting");
        this.internalState = InternalState.WAITING;
        this.countdown = new Countdown(
                new GameTime(wait, GameTime.Unit.SECOND),
                plugin.getComponentManager().getCoreComponent().getUsers(),
                this::next);
    }

    @EventHandler
    public void onPlayerListUpdate(PlayerListUpdateEvent event) {
        checkState(event.getNewPlayerCount());
    }

    private void checkState(int playerCount) {
        if(playerCount >= plugin.getComponentManager().getCoreComponent().getMatchInfo().getMinPlayers()) {
            setStarting();
        } else {
            setWaiting();
        }
    }

    private void setStarting() {

        if(internalState == InternalState.STARTING) return;

        countdown.start();

    }

    private void setWaiting() {

        if(internalState == InternalState.WAITING) return;

        countdown.cancel();

    }

    private enum InternalState {
        WAITING, STARTING
    }

}
