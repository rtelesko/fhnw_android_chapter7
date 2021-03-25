package com.example.lotterylistone;

public class Lottery {
    // Lotteries is an array of Lottery
    public static final Lottery[] lotteries = {
            new Lottery("Swiss Lottery", "Lottery where to choose 6 numbers and 1 lucky number per pick", R.drawable.swiss_lottery),
            new Lottery("Euro Millions", "Lottery where to choose 5 numbers and 2 stars per pick", R.drawable.euro_millions),
    };
    private String name;
    private String description;
    private int imageResourceId;

    // Each Lottery has a name, description, and an image resource
    private Lottery(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}