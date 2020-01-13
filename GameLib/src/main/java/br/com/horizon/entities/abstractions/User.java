package br.com.horizon.entities.abstractions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public abstract class User {

    private final UUID uuid;

}
