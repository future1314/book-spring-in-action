package com.getset.bsia.soundsystem.config;

import com.getset.bsia.soundsystem.CDPlayer;
import com.getset.bsia.soundsystem.CompactDisk;
import com.getset.bsia.soundsystem.MediaPlayer;
import com.getset.bsia.soundsystem.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {

    @Bean
    public CompactDisk sgtPeppers() {
        return new SgtPeppers();
    }

//    @Bean
//    public MediaPlayer cdPlayer() {
//        return new CDPlayer(sgtPeppers());
//    }

    @Bean
    public MediaPlayer cdPlayer(CompactDisk cd) {
        return new CDPlayer(cd);
    }
}
