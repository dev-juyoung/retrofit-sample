package com.dev_juyoung.retrofit_sample;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dev_juyoung.retrofit_sample.adapter.RepositoryAdapter;
import com.dev_juyoung.retrofit_sample.base.BaseActivity;
import com.dev_juyoung.retrofit_sample.data.GithubData;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainContract.View {
    private static final String TAG = "MainActivity";

    @BindView(R.id.repoList)
    RecyclerView repoList;

    private MainContract.Presenter mPresenter;
    private RepositoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupPresenter();
        setupRecyclerView();
    }

    private void setupPresenter() {
        // Presenter 생성 및 View 세팅.
        mPresenter = new MainPresenter();
        mPresenter.setView(this);

        // Adapter 생성 및 Presenter에 사용될 AdapterView / AdapterModel 세팅.
        mAdapter = new RepositoryAdapter(this);
        mPresenter.setAdapterView(mAdapter);
        mPresenter.setAdapterModel(mAdapter);

        // Presenter에서 사용될 Model 세팅.
        mPresenter.setModel(GithubData.getInstance());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.removeView();
    }

    private void setupRecyclerView() {
        repoList.setHasFixedSize(true);
        repoList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        repoList.setAdapter(mAdapter);

        // Presenter로 데이터 요청 이벤트 전달.
        mPresenter.requestData(false);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
