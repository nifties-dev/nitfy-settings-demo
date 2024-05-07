package dev.nifties.settings.demo;

import dev.nifties.settings.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class SettingsConfiguration {



    @Bean
    public SettingsService settingsService() {
        SettingsService instance = SettingsServiceFactory.getInstance();
        log.info("SettingsService: {}", instance);
        return instance;
    }

    @Bean
    public VolatileSettingsSource volatileSettingsSource() {
        VolatileSettingsSource volatileSettingsSource =
                ((MultiSourceSettingsService)settingsService()).findSettingsSource((VolatileSettingsSource.class)).get();
        volatileSettingsSource.put(ApplicationSettings.class.getName() + ".name", "NiftySettingsDemo");
        return volatileSettingsSource;
    }

    @Bean
    public SettingsManager settingsManager() {
        return new SettingsManager(new SettingsAnalyzer(), new SettingsBinder(), settingsService());
    }
}
