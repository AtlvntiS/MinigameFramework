package br.com.horizon.components.abstractions;

import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

@RequiredArgsConstructor
public abstract class Component implements Listener {

    protected final JavaPlugin plugin;

    public void registerListeners() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

}
