package com.bebopt.app.domain;

// fix later
public class Artist {
    private String artist;
    private String artistImage;

    public Artist(String artist, String artistImage) {
        this.artist = artist;
        this.artistImage = artistImage;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtistImage() {
        return artistImage;
    }

    public void setArtistImage(String artistImage) {
        this.artistImage = artistImage;
    }

}
