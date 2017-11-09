package com.dev_juyoung.retrofit_sample.network;

import com.dev_juyoung.retrofit_sample.data.SearchInfo;
import com.google.gson.JsonArray;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by juyounglee on 2017. 11. 9..
 */

public interface GithubService {
    @GET("users/{user}/repos")
    Call<JsonArray> getUserRepositories(@Path("user") String userName);

    /**
     * Github의 Repository 검색 API.
     * @param queries API 통신 시 사용할 질의에 대한 Map 객체.
     * @return
     */
    @GET("search/repositories")
    Call<SearchInfo> getMostStarsRepositories(@QueryMap Map<String, String> queries);
}
