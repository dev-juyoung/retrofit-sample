package com.dev_juyoung.retrofit_sample.network;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by juyounglee on 2017. 11. 9..
 */

public interface GithubService {
    @GET("users/{user}/repos")
    Call<JsonArray> getUserRepositories(@Path("user") String userName);
}
