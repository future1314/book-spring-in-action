package com.getset.bsia.soundsystem.configs;

import com.getset.bsia.soundsystem.CDPlayer;
import com.getset.bsia.soundsystem.CompactDisk;
import com.getset.bsia.soundsystem.MediaPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {

    @Bean
    public CDPlayer cdPlayer(CompactDisk compactDisk) {
        return new CDPlayer(compactDisk);
    }

    @Bean
    public MediaPlayer cdPlayer1(CompactDisk blankDisk4j) {
        return new CDPlayer(blankDisk4j);
    }
}
