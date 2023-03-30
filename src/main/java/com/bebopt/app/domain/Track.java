package com.bebopt.app.domain;

import com.vaadin.flow.component.html.ListItem;

// fix later
public class Track extends ListItem {

    private String track;
    private String artist;
    // track has artists
    // private Artist artist;
    private String albumImage;

    public Track(String trackName, String artistName, String albumImage) {
        this.track = trackName;
        this.artist = artistName;
        this.albumImage = albumImage;
    }
    public String getTrack() {
        return track;
    }
    public void setTrackName(String trackName) {
        this.track = trackName;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artistName) {
        this.artist = artistName;
    }
    public String getImage() {
        return albumImage;
    }
    public void setImage(String albumImage) {
        this.albumImage = albumImage;
    }
}
