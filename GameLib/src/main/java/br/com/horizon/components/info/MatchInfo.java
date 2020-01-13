package br.com.horizon.components.info;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MatchInfo {

    private final int minPlayers;
    private final int maxPlayers;

}
