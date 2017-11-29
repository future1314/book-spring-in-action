package com.getset.bsia.valueinsertion;

public class BlankDisk2 implements CompactDisk {

    private String title;
    private String artist;

    public BlankDisk2(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
