package ictgradschool.industry.test02.q2.model;

import javax.swing.*;

public class Thumbnail {

    private String name;

    private ImageIcon image;

    public Thumbnail(String name, ImageIcon image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getImage() {
        return image;
    }
}
