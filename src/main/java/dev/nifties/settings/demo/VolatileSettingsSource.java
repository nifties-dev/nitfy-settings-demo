package dev.nifties.settings.demo;

import dev.nifties.settings.SettingValue;
import dev.nifties.settings.SettingsChannel;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class VolatileSettingsSource implements SettingsChannel {
    private final Map<String, SettingValue> values = new ConcurrentHashMap();
    private final Set<Consumer<String>> subscribers = Collections.synchronizedSet(new HashSet<>());

    public SettingValue get(String key) {
        return (SettingValue)this.values.get(key);
    }

    public void put(String key, Object value) {
        SettingValue settingValue = new SettingValue(value);
        this.values.put(key, settingValue);
        this.notifySubscribers(key);
    }

    public void remove(String key) {
        this.values.remove(key);
        this.notifySubscribers(key);
    }

    @Override
    public void subscribe(Consumer<String> consumer) {
        subscribers.add(consumer);
    }

    @Override
    public void unsubscribe(Consumer<String> consumer) {
        subscribers.remove(consumer);
    }

    protected void notifySubscribers(final String key) {
        this.subscribers.forEach(s -> s.accept(key));
    }
}
