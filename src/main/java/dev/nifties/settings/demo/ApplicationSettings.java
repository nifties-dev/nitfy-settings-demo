package dev.nifties.settings.demo;

import dev.nifties.settings.annotation.Setting;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@ToString
public class ApplicationSettings {
    @Setting
    private String name;

    @Setting
    private int count;

    public void setCount(int count) {
        log.info("count: {}", count);
        this.count = count;
    }
}
