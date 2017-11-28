package com.getset.bsia.soundsystem.configs;

import com.getset.bsia.soundsystem.BlankDisk;
import com.getset.bsia.soundsystem.CompactDisk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BlankDiskConfig4Xml {
    @Bean
    public CompactDisk blankDisk4x() {
        List<String> tracks = new ArrayList<String>();
        tracks.add("QingTian");
        tracks.add("YiFuZhiMing");
        tracks.add("SanNianErBan");
        return new BlankDisk("Yehuimei", "Jielun", tracks);
    }
}
