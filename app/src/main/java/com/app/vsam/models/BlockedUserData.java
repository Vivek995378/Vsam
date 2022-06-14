package com.app.vsam.models;

import android.graphics.drawable.Drawable;

public class BlockedUserData {

    String name , userName;
    public Drawable profileImg;

    public BlockedUserData(String name, String userName, Drawable profileImg) {
        this.name = name;
        this.userName = userName;
        this.profileImg = profileImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Drawable getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(Drawable profileImg) {
        this.profileImg = profileImg;
    }
}
