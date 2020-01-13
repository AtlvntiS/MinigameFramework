package br.com.horizon.utils;

import lombok.Getter;

public class GameTime {

    private long time;
    private Unit unit;

    public GameTime(int time, Unit unit) {
        this.time = time * unit.getMillis();
        this.unit = unit;
    }

    public long toMilliseconds() {
        return time;
    }

    public int toTicks() {
        return (int) (time / Unit.TICK.getMillis());
    }

    public int toSeconds() {
        return (int) (time / Unit.SECOND.getMillis());
    }

    public int toMinutes() {
        return (int) (time / Unit.MINUTE.getMillis());
    }

    public int toHours() {
        return (int) (time / Unit.HOUR.getMillis());
    }

    public int toDays() {
        return (int) (time / Unit.DAY.getMillis());
    }

    public int toMounts() {
        return (int) (time / Unit.MONTH.getMillis());
    }

    public enum Unit {

        MILLISECOND(1L),
        TICK(50L),
        SECOND(1000L),
        MINUTE(60000L),
        HOUR(3600000L),
        DAY(86400000L),
        MONTH(2592000000L);

        @Getter
        long millis;

        Unit(long unit) {
            this.millis = unit;
        }

    }
}
