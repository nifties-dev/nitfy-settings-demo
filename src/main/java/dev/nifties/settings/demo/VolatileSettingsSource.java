package dev.nifties.settings.demo;

import dev.nifties.settings.SettingValue;
import dev.nifties.settings.SettingsChannelBase;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VolatileSettingsSource extends SettingsChannelBase {
    private final Map<String, SettingValue> values = new ConcurrentHashMap();

    public SettingValue get(String key) {
        return values.get(key);
    }

    public void put(String key, Object value) {
        SettingValue settingValue = new SettingValue(value);
        values.put(key, settingValue);
        notifySubscribers(key);
    }

    public void remove(String key) {
        values.remove(key);
        notifySubscribers(key);
    }
}
