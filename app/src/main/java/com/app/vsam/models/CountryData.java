package com.app.vsam.models;

import android.graphics.drawable.Drawable;

public class CountryData {

    String countryName , percentage;
    public Drawable imgRoundLogo , imgIncDec;

    public CountryData(String countryName, String percentage, Drawable imgRoundLogo, Drawable imgIncDec) {
        this.countryName = countryName;
        this.percentage = percentage;
        this.imgRoundLogo = imgRoundLogo;
        this.imgIncDec = imgIncDec;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public Drawable getImgRoundLogo() {
        return imgRoundLogo;
    }

    public void setImgRoundLogo(Drawable imgRoundLogo) {
        this.imgRoundLogo = imgRoundLogo;
    }

    public Drawable getImgIncDec() {
        return imgIncDec;
    }

    public void setImgIncDec(Drawable imgIncDec) {
        this.imgIncDec = imgIncDec;
    }
}
