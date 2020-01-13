package br.com.horizon.components.events;

import br.com.horizon.components.events.abstractions.GameEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PlayerListUpdateEvent extends GameEvent {

    private final Action playerListUpdate;
    private final int oldPlayerCount;
    private final int newPlayerCount;

    public enum Action {
        PLAYER_JOIN, PLAYER_QUIT
    }

}
