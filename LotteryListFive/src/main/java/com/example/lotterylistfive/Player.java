package com.example.lotterylistfive;

class Player {
    private String name;
    private int countryId;
    private int photoId;

    Player(String name, int countryId, int photoId) {
        this.name = name;
        this.countryId = countryId;
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public int getCountry() {
        return countryId;
    }

    public int getImage() {
        return photoId;
    }

}
