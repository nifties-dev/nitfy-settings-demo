import dev.nifties.settings.SettingsSource;

module nifty.settings.demo {
    requires static lombok;
    requires nifty.settings.client;
    requires org.slf4j;
    requires spring.beans;
    requires spring.context;
    provides SettingsSource with dev.nifties.settings.demo.VolatileSettingsSource;
}