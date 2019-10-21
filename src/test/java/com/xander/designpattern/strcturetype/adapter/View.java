package com.xander.designpattern.strcturetype.adapter;

/**
 * Created by zhaobing04 on 2019/10/18.
 */
public class View {
    private String textView = "tv";
    private String imageView = "iv";

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }
}
