package com.getset.bsia.soundsystem.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({CDPlayerConfig.class, CDConfig.class})     // 顶层配置类，可以将所有其他配置类都import进来，各被import的配置类之间可以互相引用而无需再互相import
@ImportResource("classpath:soundsystem4j.xml")        // 引入XML配置
public class SoundSystemConfig {
}
