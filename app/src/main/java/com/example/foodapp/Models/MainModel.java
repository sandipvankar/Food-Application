package com.example.foodapp.Models;

public class MainModel {
    int image;
    String name,price,description,pid;

    public MainModel(int image,String pid, String name, String price, String description) {
        this.image = image;
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.description = description;

    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;

    }
}
