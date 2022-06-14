package com.app.vsam.models;

import android.graphics.drawable.Drawable;

public class MessengerData {
    
    String  userName , bio , time;
    Drawable profileImg;

    public MessengerData(String userName, String bio, String time, Drawable profileImg) {
        this.userName = userName;
        this.bio = bio;
        this.time = time;
        this.profileImg = profileImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Drawable getprofileImg() {
        return profileImg;
    }

    public void setprofileImg(Drawable profileImg) {
        this.profileImg = profileImg;
    }
}
