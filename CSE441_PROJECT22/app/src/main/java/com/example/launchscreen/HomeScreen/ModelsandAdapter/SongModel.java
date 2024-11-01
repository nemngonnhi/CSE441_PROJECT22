package com.example.launchscreen.HomeScreen.ModelsandAdapter;

public class SongModel {
    String songName;
    String songArtist;
    int playCount = 0;
    int songImg;

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getSongImg() {
        return songImg;
    }

    public void setSongLink(int songLink) {
        this.songImg = songLink;
    }

    public SongModel(String songName, String songArtist, int playCount, int songImg) {
        this.songName = songName;
        this.songArtist = songArtist;
        this.playCount = playCount;
        this.songImg = songImg;
    }
}

