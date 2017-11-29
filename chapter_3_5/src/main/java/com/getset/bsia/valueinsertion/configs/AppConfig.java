package com.getset.bsia.valueinsertion.configs;

import com.getset.bsia.valueinsertion.BlankDisk;
import com.getset.bsia.valueinsertion.CompactDisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Configuration
@PropertySource("classpath:app.properties")
public class AppConfig {
    @Autowired
    Environment env;

    @Bean
    public CompactDisk yehuimei() {
        String[] tracks = env.getProperty("disc.tracks").split(",");
        return new BlankDisk(env.getProperty("disc.title", "Yehuimei"), env.getProperty("disc.artist"), env.getProperty("disc.tracks_num", Integer.class), Arrays.asList(tracks));
    }
}
