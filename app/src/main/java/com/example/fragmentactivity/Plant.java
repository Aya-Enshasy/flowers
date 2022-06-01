package com.example.fragmentactivity;

public class Plant {
    String image;
    String name,price,details;

    public Plant() {
    }

    public Plant(String image, String name, String price, String details) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
