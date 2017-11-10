package com.dev_juyoung.retrofit_sample.data;

import com.dev_juyoung.retrofit_sample.data.listener.SearchCallback;
import com.dev_juyoung.retrofit_sample.data.store.SearchInfo;
import com.dev_juyoung.retrofit_sample.network.GithubService;
import com.dev_juyoung.retrofit_sample.network.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by juyounglee on 2017. 11. 9..
 */

public class GithubData {
    private static final String TAG = "GithubData";

    private static GithubData instance;

    public static GithubData getInstance() {
        if (instance == null) {
            instance = new GithubData();
        }

        return instance;
    }

    public void getRepositories(final SearchCallback callback) {
        // 검색 시 사용할 queiry 생성.
        Map<String, String> quereis = new HashMap<>();
        quereis.put("q", "android");
        quereis.put("sort", "stars");

        // REST 클라이언트 생성.
        GithubService service = ServiceGenerator.createService(GithubService.class);

        // API 요청.
        Call<SearchInfo> request = service.getMostStarsRepositories(quereis);
        request.enqueue(new Callback<SearchInfo>() {
            @Override
            public void onResponse(Call<SearchInfo> call, Response<SearchInfo> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<SearchInfo> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }
}
