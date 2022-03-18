package com.example.foodapp.Models;

public class OrderModel {
        int orderImage;
        String itemName,price,orderNumber,name,number,pid;

    public OrderModel() {
        this.orderImage = orderImage;
        this.itemName = itemName;
        this.price = price;
        this.orderNumber = orderNumber;
        this.name=name;
        this.number=number;
        this.pid=pid;

    }


    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getName() { return name; }
    public void setName (String name) {this.name = name;}

    public String getNumber() { return number; }
    public void setNumber (String name) {this.number = number;}

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
