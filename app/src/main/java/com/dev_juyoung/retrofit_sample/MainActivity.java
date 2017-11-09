package com.dev_juyoung.retrofit_sample;

import android.os.Bundle;
import android.util.Log;

import com.dev_juyoung.retrofit_sample.base.BaseActivity;
import com.dev_juyoung.retrofit_sample.network.GithubService;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrofit 통신 기본 사용법.
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl("https://api.github.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        GithubService service = retrofit.create(GithubService.class);

        Call<JsonArray> request = service.getUserRepositories("dev-juyoung");
        request.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.isSuccessful()) {
                    Log.i(TAG, "onResponse(): " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.e(TAG, "onFailure(): " + t.getMessage());
            }
        });
    }
}
