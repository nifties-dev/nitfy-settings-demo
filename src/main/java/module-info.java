import dev.nifties.settings.SettingsService;

module nifty.settings.demo {
    requires nifty.settings.client;
    requires lombok;
    requires org.slf4j;
    requires spring.beans;
    requires spring.context;
    provides SettingsService with dev.nifties.settings.demo.VolatileSettingsSource;
}