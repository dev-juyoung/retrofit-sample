package com.dev_juyoung.retrofit_sample;

import android.os.Bundle;
import android.util.Log;

import com.dev_juyoung.retrofit_sample.base.BaseActivity;
import com.dev_juyoung.retrofit_sample.network.GithubService;
import com.dev_juyoung.retrofit_sample.network.ServiceGenerator;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GithubService service = ServiceGenerator.createService(GithubService.class);

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
