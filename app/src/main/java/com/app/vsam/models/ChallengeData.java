package com.app.vsam.models;

import android.graphics.drawable.Drawable;

public class ChallengeData {

    String challenge , hashtag;
    Drawable sponsor;

    public ChallengeData(String challenge, String hashtag, Drawable sponsor) {
        this.challenge = challenge;
        this.hashtag = hashtag;
        this.sponsor = sponsor;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public Drawable getSponsor() {
        return sponsor;
    }

    public void setSponsor(Drawable sponsor) {
        this.sponsor = sponsor;
    }
}
