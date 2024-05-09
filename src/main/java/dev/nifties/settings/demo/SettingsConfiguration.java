package dev.nifties.settings.demo;

import dev.nifties.settings.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class SettingsConfiguration {

    @Bean
    public SettingsManager settingsManager() {
        return SettingsManager.builder().build();
    }

    @Bean
    public VolatileSettingsSource volatileSettingsSource() {
        VolatileSettingsSource volatileSettingsSource =
                ((MultiSourceSettingsService)settingsManager().getService())
                        .findSettingsSource((VolatileSettingsSource.class)).get();
        volatileSettingsSource.put(ApplicationSettings.class.getName() + ".name", "NiftySettingsDemo");
        return volatileSettingsSource;
    }
}
