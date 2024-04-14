package com.online_lessons.models;

public class Course {

    private String title;
    private int price;
    private String description;
    private String photoPath;

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public Course setTitle(String title) {
        this.title = title;
        return this;
    }

    public Course setPrice(int price) {
        this.price = price;
        return this;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    public Course setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
        return this;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
