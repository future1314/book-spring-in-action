package com.getset.bsia.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisk cd;

//    @Autowired
    public void setCd(CompactDisk cd) {
        this.cd = cd;
    }

    @Autowired
    public CDPlayer(CompactDisk cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
