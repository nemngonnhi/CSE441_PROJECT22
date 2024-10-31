package com.example.launchscreen.items;

public class ArtistModel {
    private String artistID;
    private String name;
    private String description;
    private String imageUrl;

    public ArtistModel() {

    }

    public ArtistModel(String artistID, String name, String description, String imageUrl) {
        this.artistID = artistID;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getArtistID() {
        return artistID;
    }

    public void setArtistID(String artistID) {
        this.artistID = artistID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
