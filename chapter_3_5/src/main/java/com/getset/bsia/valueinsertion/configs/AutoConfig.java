package com.getset.bsia.valueinsertion.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("com.getset.bsia.valueinsertion.autoscan")
@PropertySource("classpath:app.properties")
@Configuration
public class AutoConfig {
}
