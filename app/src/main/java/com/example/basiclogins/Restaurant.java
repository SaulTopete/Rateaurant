package com.example.basiclogins;

public class Restaurant {
    //name, cuisine, rating, link to website/yelp, price, address
    private String name;
    private String cuisine;
    private double rating; //0 to 5 with .5 increments
    private String websiteLink;
    private String address;
    private int price;

    //need a default constructor for Backendless
    public Restaurant() {
    }

    public Restaurant(String name, String cuisine, double rating, String websuteLink, String address, int price) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
        this.websiteLink = websiteLink;
        this.address = address;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", rating=" + rating +
                ", websiteLink='" + websiteLink + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                '}';
    }
}
