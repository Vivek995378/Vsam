package com.app.vsam.models;

public class ReelData {

    private int percentage;

    private String title;

    private String desc;

    private String url;

    public ReelData(int percentage, String title, String desc, String url) {
        this.percentage = percentage;
        this.title = title;
        this.desc = desc;
        this.url = url;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
