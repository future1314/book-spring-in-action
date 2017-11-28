package com.getset.bsia.soundsystem;

import org.springframework.stereotype.Component;

@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisk {

    private String title;
    private String artist;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
