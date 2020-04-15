package com.ias.training.two.configuration.domain;

import com.ias.training.two.time.domain.Unit;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "settings")
@RequiredArgsConstructor
@Data
public class Settings {

    private Unit unit;

}
