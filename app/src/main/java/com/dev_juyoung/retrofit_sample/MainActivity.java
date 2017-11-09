package com.dev_juyoung.retrofit_sample;

import android.os.Bundle;
import android.util.Log;

import com.dev_juyoung.retrofit_sample.base.BaseActivity;
import com.dev_juyoung.retrofit_sample.data.GithubData;
import com.dev_juyoung.retrofit_sample.network.GithubService;
import com.dev_juyoung.retrofit_sample.network.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> queries = new HashMap<>();
        queries.put("q", "android");
        queries.put("sort", "stars");

        GithubService service = ServiceGenerator.createService(GithubService.class);

        Call<GithubData> request = service.getMostStarsRepositories(queries);
        request.enqueue(new Callback<GithubData>() {
            @Override
            public void onResponse(Call<GithubData> call, Response<GithubData> response) {
                if (response.isSuccessful()) {
                    Log.i(TAG, "onResponse(): " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<GithubData> call, Throwable t) {
                Log.e(TAG, "onFailure(): " + t.getMessage());
            }
        });
    }
}
