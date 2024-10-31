package com.example.launchscreen.items;

public class GenreModel {
    private String id;
    private String name;
    private String description;
    private int playCount;
    private String imageUrl;


    public GenreModel() {
    }

    public GenreModel(String id, String name, String description, int playCount, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.playCount = playCount;
        this.imageUrl = imageUrl;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getPlayCount() { return playCount; }
    public void setPlayCount(int playCount) { this.playCount = playCount; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
