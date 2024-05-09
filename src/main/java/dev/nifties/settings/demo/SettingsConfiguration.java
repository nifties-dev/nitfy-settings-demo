package dev.nifties.settings.demo;

import dev.nifties.settings.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@Slf4j
public class SettingsConfiguration {

    @Bean
    public SettingsManager settingsManager() {
        ReadOnlySettingsSource readOnlySettingsSource = new ReadOnlySettingsSource();
        readOnlySettingsSource.setValues(
                Map.of(ApplicationSettings.class.getName() + ".name", "NiftySettingsDemo"));

        SettingsManager settingsManager = SettingsManager.builder()
                .service(new MultiSourceSettingsService(List.of(readOnlySettingsSource, volatileSettingsSource())))
                .build();
        return settingsManager;
    }

    @Bean
    public VolatileSettingsSource volatileSettingsSource() {
        return new VolatileSettingsSource();
    }
}
