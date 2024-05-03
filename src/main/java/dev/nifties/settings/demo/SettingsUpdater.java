package dev.nifties.settings.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Periodically updates counter in the SettingsService to demonstrate settings change.
 */
@Service
public class SettingsUpdater {
    private static final long UPDATE_INTERVAL = 5_000L;
    private static final long START_TIME = System.currentTimeMillis();

    @Autowired
    private VolatileSettingsSource settingsService;

    @Scheduled(fixedRate = UPDATE_INTERVAL)
    public void update() {
        settingsService.put(ApplicationSettings.class.getName() + ".count",
                (int)((System.currentTimeMillis() - START_TIME) / UPDATE_INTERVAL));
    }
}
