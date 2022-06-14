package com.app.vsam.models;

import android.graphics.drawable.Drawable;

public class NotificationData {

    String  userName , notification ;
    Drawable profileImg , image;

    public NotificationData(String userName, String notification, Drawable profileImg, Drawable image) {
        this.userName = userName;
        this.notification = notification;
        this.profileImg = profileImg;
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Drawable getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(Drawable profileImg) {
        this.profileImg = profileImg;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
