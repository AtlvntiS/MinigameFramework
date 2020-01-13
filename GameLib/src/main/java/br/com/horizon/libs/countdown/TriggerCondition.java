package br.com.horizon.libs.countdown;

public interface TriggerCondition {

    boolean checkCondition(long secs);

    static TriggerCondition DEFAULT_TRIGGER_CONDITION() {
       return secs -> (secs % 60 == 0 || secs % 30 == 0 || secs == 10 || secs == 5 || secs == 3 || secs == 2 || secs == 1);
    }

}
