package com.example.lotterylistfive;

class Player {
    private String name;
    private String age;
    private int photoId;

    // Getter methods
    Player(String name, String age, int photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public int getImage() {
        return photoId;
    }

}
