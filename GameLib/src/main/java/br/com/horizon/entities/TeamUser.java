package br.com.horizon.entities;

import br.com.horizon.entities.abstractions.User;

import java.util.UUID;

public class TeamUser extends User {

    public TeamUser(UUID uuid) {
        super(uuid);
    }

}
