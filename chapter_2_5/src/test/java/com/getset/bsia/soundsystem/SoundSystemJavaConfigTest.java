package com.getset.bsia.soundsystem;

import com.getset.bsia.soundsystem.configs.SoundSystemConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemConfig.class)
public class SoundSystemJavaConfigTest {
    @Rule
    public StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired  //来自JavaConfig
    private MediaPlayer cdPlayer;
    @Autowired  //来自XML配置文件
    private MediaPlayer cdPlayer1;

    @Test
    public void cdPlayerShouldNotBeNull() {
        assertNotNull(cdPlayer);
    }

    @Test
    public void playSgtPeppersTest() {
        cdPlayer.play();
    }

    @Test
    public void playBlankDiskTest() {
        cdPlayer1.play();
    }
}
