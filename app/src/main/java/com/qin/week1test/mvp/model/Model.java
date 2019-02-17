package com.qin.week1test.mvp.model;

import com.qin.week1test.http.RetrofitManager;

public class Model implements IModel{
    @Override
    public void setModelData(String url, String name, String page, String count, final IModelCallBack iModelCallBack) {

        RetrofitManager.doGet(url, name, page, count, new RetrofitManager.setRetrofit() {
            @Override
            public void getData(Object data) {
                iModelCallBack.onSuccess(data);
            }
        });
    }
}
