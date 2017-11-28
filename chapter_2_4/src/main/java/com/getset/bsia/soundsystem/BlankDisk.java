package com.getset.bsia.soundsystem;

import java.util.List;

public class BlankDisk implements CompactDisk {

    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisk(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String s : tracks) {
            System.out.print(s + "  ");
        }
    }
}
