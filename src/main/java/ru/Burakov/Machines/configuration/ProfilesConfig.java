package ru.Burakov.Machines.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import ru.Burakov.Machines.profiles.DevelopProfile;
import ru.Burakov.Machines.profiles.ProdProfile;
import ru.Burakov.Machines.profiles.ValueBean;

@Configuration
@Slf4j
public class ProfilesConfig {

    @Value("${profile.value:default}")
    private String name;

    @Bean
    @Profile("dev")
    public DevelopProfile developProfile() {
        log.info("Создан бин для Develop");
        return new DevelopProfile();
    }

    @Bean
    @Profile("prod")
    @ConditionalOnBean(name = "developProfile")
    public ProdProfile prodProfile() {
        log.info("Создан бин для Production");
        return new ProdProfile();
    }

    @Bean
    public ValueBean valueBean(@Value("${profile.value:default}") String value) {
        if (value != "default"){
            log.info("Создан value-bean");
            return new ValueBean();
        }
        return null;
    }
}
