package br.com.horizon.managers;

import br.com.horizon.GamePlugin;
import br.com.horizon.components.abstractions.CoreComponent;
import br.com.horizon.components.abstractions.ExtraComponent;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Getter
public class ComponentManager {

    private final GamePlugin plugin;

    private final CoreComponent coreComponent;
    private final Set<? extends ExtraComponent> extraComponents;

    public ComponentManager(GamePlugin plugin, CoreComponent coreComponent, List<? extends ExtraComponent> extraComponents)  {

        this.plugin = plugin;

        this.coreComponent = coreComponent;
        this.extraComponents = extraComponents.stream().peek(ExtraComponent::init).collect(Collectors.toSet());

    }

}
