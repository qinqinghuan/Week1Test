package com.qin.week1test.mvp.presenter;

import com.qin.week1test.MainActivity;
import com.qin.week1test.api.Api;
import com.qin.week1test.mvp.model.IModel;
import com.qin.week1test.mvp.model.Model;

public class Presenter implements IPresenter{
    MainActivity mainActivity;
    private final Model model;

    public Presenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        model = new Model();
    }

    @Override
    public void getModelData(String name,String page,String count) {
        model.setModelData(Api.SEARCH_URL, name, page, count, new IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                mainActivity.getViewData(data);
            }

            @Override
            public void onFaild(Exception e) {

            }
        });
    }
}
