package com.getset.bsia.soundsystem.configs;

import com.getset.bsia.soundsystem.CompactDisk;
import com.getset.bsia.soundsystem.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDConfig {
    @Bean
    public CompactDisk compactDisk() {
        return new SgtPeppers("Jay", "Zhou Jielun");
    }
}
