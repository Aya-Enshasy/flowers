package com.example.fragmentactivity;

public class FlowersAll {
    String image ;
    String name_flowers;

    public FlowersAll(String image, String name_flowers) {
        this.image = image;
        this.name_flowers = name_flowers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName_flowers() {
        return name_flowers;
    }

    public void setName_flowers(String name_flowers) {
        this.name_flowers = name_flowers;
    }
}
