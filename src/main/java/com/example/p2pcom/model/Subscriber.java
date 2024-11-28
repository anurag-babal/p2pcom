package com.example.p2pcom.model;

public class Subscriber {
    private String userId;
    private String category;

    public String getEmail() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
