package dev.nifties.settings.demo;

import dev.nifties.settings.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SettingsConfiguration {

    @Bean
    public SimpleSettingsService settingsService() {
        SimpleSettingsService settingsService = new SimpleSettingsService();
        settingsService.put(ApplicationSettings.class.getName() + ".name", "NiftySettingsDemo");
        return settingsService;
    }

    @Bean
    public SettingsManager settingsManager() {
        return new SettingsManager(new SettingsAnalyzer(), new SettingsBinder(), settingsService());
    }
}
