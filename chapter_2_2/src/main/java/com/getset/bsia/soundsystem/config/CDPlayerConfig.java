package com.getset.bsia.soundsystem.config;

import com.getset.bsia.soundsystem.CompactDisk;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.getset.bsia.soundsystem")
//@ComponentScan(basePackages = {"com.getset.bsia.soundsystem"})
@ComponentScan(basePackageClasses = CompactDisk.class)
public class CDPlayerConfig {
}
