package com.qin.week1test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.qin.week1test.adapter.SearchAdapter;
import com.qin.week1test.bean.SearchBean;
import com.qin.week1test.mvp.presenter.Presenter;
import com.qin.week1test.mvp.view.IView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IView {
    private String name;
    @BindView(R.id.mSearchName)
    EditText mSearchName;
    @BindView(R.id.mSearchButton)
    Button mSearchButton;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        presenter = new Presenter(this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        
        mSearchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                name = mSearchName.getText().toString();
                presenter.getModelData(name,"1","7");
            }
        });
        presenter.getModelData("板鞋","1","7");
    }

    @Override
    public void getViewData(Object viewData) {
        SearchBean searchBean = (SearchBean) viewData;
        List<SearchBean.ResultBean> result = searchBean.getResult();
        SearchAdapter searchAdapter = new SearchAdapter(this, result);
        mRecyclerView.setAdapter(searchAdapter);
    }
}
