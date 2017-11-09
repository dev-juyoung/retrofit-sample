package com.dev_juyoung.retrofit_sample.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by juyounglee on 2017. 11. 9..
 */

public class Repository {
    @SerializedName("_id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("description")
    private String description;
    @SerializedName("stargazers_count")
    private int stargazersCount;
    @SerializedName("watchers_count")
    private int watchersCount;
    @SerializedName("forks_count")
    private int forksCount;
    @SerializedName("owner")
    private OwnerInfo ownerInfo;

    public class OwnerInfo {
        @SerializedName("login")
        private String ownerName;
        @SerializedName("avatar_url")
        private String avatarURL;

        public String getOwnerName() {
            return ownerName;
        }

        public String getAvatarURL() {
            return avatarURL;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public int getWatchersCount() {
        return watchersCount;
    }

    public int getForksCount() {
        return forksCount;
    }

    public OwnerInfo getOwnerInfo() {
        return ownerInfo;
    }
}