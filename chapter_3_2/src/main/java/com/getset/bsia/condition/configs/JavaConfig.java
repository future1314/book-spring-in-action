package com.getset.bsia.condition.configs;

import com.getset.bsia.condition.OS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    public OS winOS() {
        return new OS("Windows");
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public OS linuxOS() {
        return new OS("Linux");
    }
}
