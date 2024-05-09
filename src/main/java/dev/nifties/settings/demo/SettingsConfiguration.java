package dev.nifties.settings.demo;

import dev.nifties.settings.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@Slf4j
public class SettingsConfiguration {

    @Bean
    public SettingsManager settingsManager() {
        SettingsManager settingsManager = SettingsManager.builder().build();
        ((MultiSourceSettingsService)settingsManager.getService())
                .findSettingsSource(ReadOnlySettingsSource.class).get().setValues(
                        Map.of(ApplicationSettings.class.getName() + ".name", "NiftySettingsDemo"));
        return settingsManager;
    }

    @Bean
    public VolatileSettingsSource volatileSettingsSource() {
        return ((MultiSourceSettingsService)settingsManager().getService())
                        .findSettingsSource((VolatileSettingsSource.class)).get();
    }
}
