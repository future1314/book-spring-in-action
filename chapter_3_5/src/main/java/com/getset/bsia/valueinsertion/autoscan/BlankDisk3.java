package com.getset.bsia.valueinsertion.autoscan;

import com.getset.bsia.valueinsertion.CompactDisk;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlankDisk3 implements CompactDisk {

    private String title;
    private String artist;

    public BlankDisk3(@Value("${disc.title}") String title,
                      @Value("${disc.artist}") String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
