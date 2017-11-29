package com.getset.bsia.valueinsertion;

import java.util.List;

public class BlankDisk implements CompactDisk {

    private String title;
    private String artist;
    private int tracksNum;
    private List<String> tracks;

    public BlankDisk(String title, String artist, int tracksNum, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracksNum = tracksNum;
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        System.out.print("Totally " + tracksNum + " tracks: ");
        for (String s : tracks) {
            System.out.print(s + "  ");
        }
    }
}
