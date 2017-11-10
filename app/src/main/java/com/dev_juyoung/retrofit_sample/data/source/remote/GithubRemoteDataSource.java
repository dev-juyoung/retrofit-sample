package com.dev_juyoung.retrofit_sample.data.source.remote;

import com.dev_juyoung.retrofit_sample.data.source.GithubDataSource;
import com.dev_juyoung.retrofit_sample.data.store.SearchInfo;
import com.dev_juyoung.retrofit_sample.network.GithubService;
import com.dev_juyoung.retrofit_sample.network.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by juyounglee on 2017. 11. 10..
 */

public class GithubRemoteDataSource implements GithubDataSource {
    private static GithubRemoteDataSource instance;

    public static GithubRemoteDataSource getInstance() {
        if (instance == null) {
            instance = new GithubRemoteDataSource();
        }

        return instance;
    }

    @Override
    public void searchData(final SearchDataCallback callback) {
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
                    callback.onSuccess(response.body().getRepositories());
                } else {
                    // 서버 요청은 정상적이였으나, 응답코드가 '20x'가 아닌 경우.
                    // 404 / 400 등 개발 의도에 따른 에러 코드 처리를 여기서 한다.
                    callback.onFailure("데이터를 가져오지 못했어요.");
                }
            }

            @Override
            public void onFailure(Call<SearchInfo> call, Throwable t) {
                // 요청이 실패한 경우.
                // API 서버 다운 / DB 에러 등의 서버의 비정상적인 문제로 인한 에러인 경우 여기서 처리한다.
                callback.onFailure(t.getMessage());
            }
        });
    }
}
