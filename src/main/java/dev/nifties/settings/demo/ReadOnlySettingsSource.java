package dev.nifties.settings.demo;

import dev.nifties.settings.SettingValue;
import dev.nifties.settings.SettingsSource;

import java.util.Map;
import java.util.stream.Collectors;

public class ReadOnlySettingsSource implements SettingsSource {

    private Map<String, SettingValue> values;

    public void setValues(Map<String, Object> values) {
        this.values = values.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> new SettingValue(e.getValue())));
    }

    @Override
    public SettingValue get(String s) {
        return values.get(s);
    }
}
