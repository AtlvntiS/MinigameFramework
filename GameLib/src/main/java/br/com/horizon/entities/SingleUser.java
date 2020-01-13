package br.com.horizon.entities;

import br.com.horizon.entities.abstractions.User;

import java.util.UUID;

public class SingleUser extends User {

    public SingleUser(UUID uuid) {
        super(uuid);
    }
}
