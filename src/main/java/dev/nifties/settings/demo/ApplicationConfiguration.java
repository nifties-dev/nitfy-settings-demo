package dev.nifties.settings.demo;

import dev.nifties.settings.SettingsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration
public class ApplicationConfiguration {
    private static final long UPDATE_INTERVAL = 5_000L;

    @Bean
    public ApplicationSettings applicationSettings(SettingsManager settingsManager) {
        ApplicationSettings applicationSettings = new ApplicationSettings();
        settingsManager.bind(applicationSettings);
        return applicationSettings;
    }
}
