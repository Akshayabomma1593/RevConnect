package com.revconnect.model;

public class Profile {

    private int profileId;
    private int userId;
    private String displayName;
    private String bio;
    private String contactInfo;
    private String website;
    private String profilePicturePath;

    // No-arg constructor
    public Profile() {
    }

    // All-args constructor
    public Profile(int profileId, int userId, String displayName,
                   String bio, String contactInfo,
                   String website, String profilePicturePath) {
        this.profileId = profileId;
        this.userId = userId;
        this.displayName = displayName;
        this.bio = bio;
        this.contactInfo = contactInfo;
        this.website = website;
        this.profilePicturePath = profilePicturePath;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }
}

