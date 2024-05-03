package dev.nifties.settings.demo;

import dev.nifties.settings.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class SettingsConfiguration {

    @Bean
    public VolatileSettingsSource settingsService() {
        SettingsService instance = SettingsServiceFactory.getInstance();
        log.info("SettingsService: {}", instance);
        VolatileSettingsSource settingsService =
                ((MultiSourceSettingsService)instance).findSettingsSource((VolatileSettingsSource.class)).get();
        settingsService.put(ApplicationSettings.class.getName() + ".name", "NiftySettingsDemo");
        return settingsService;
    }

    @Bean
    public SettingsManager settingsManager() {
        return new SettingsManager(new SettingsAnalyzer(), new SettingsBinder(), settingsService());
    }
}
