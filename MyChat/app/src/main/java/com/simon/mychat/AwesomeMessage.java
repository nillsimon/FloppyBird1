package com.simon.mychat;

public class AwesomeMessage {
    String text;
    String name;
    String ImageUrl;

    public AwesomeMessage() {
        this.text = text;
        this.name = name;
        ImageUrl = ImageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
