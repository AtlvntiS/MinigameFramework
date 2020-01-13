package br.com.horizon.libs.countdown;

import br.com.horizon.GamePlugin;
import br.com.horizon.entities.abstractions.User;
import br.com.horizon.utils.GameTime;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.util.Collection;

public class Countdown {

    private GameTime gameTime;
    private Runnable callback;
    private TriggerCondition triggerCondition;

    private BukkitTask bukkitTask;

    public Countdown(GameTime gameTime, Collection<? extends User> users, Runnable callback) {
        this(gameTime, users, callback, TriggerCondition.DEFAULT_TRIGGER_CONDITION());
    }

    public Countdown(GameTime gameTime, Collection<? extends User> users, Runnable callback, TriggerCondition triggerCondition) {
        this.gameTime = gameTime;
        this.callback = callback;
        this.triggerCondition = triggerCondition;
        this.bukkitTask = null;
    }

    public void start() {

        if(bukkitTask != null) throw new IllegalStateException("O countdown " + this + " ja foi iniciado.");

        bukkitTask = Bukkit.getScheduler().runTaskTimer(GamePlugin.getInstance(), new Runnable() {

            int seconds = gameTime.toSeconds();

            @Override
            public void run() {

                if (seconds <= 0) {
                    callback.run();
                    bukkitTask.cancel();
                    bukkitTask = null;
                    return;
                }

                if (triggerCondition.checkCondition(seconds)) {
                    // TODO: send message
                }

                seconds--;
            }

        }, 0, gameTime.toTicks());

    }

    public void cancel() {

        if(bukkitTask == null) throw new IllegalStateException("O countdown " + this + " não foi iniciado.");

        bukkitTask.cancel();
        bukkitTask = null;

    }

}
