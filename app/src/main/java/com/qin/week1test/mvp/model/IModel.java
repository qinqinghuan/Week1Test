package com.qin.week1test.mvp.model;

public interface IModel {
    void setModelData(String url,String name,String page,String count,IModelCallBack iModelCallBack);

    interface IModelCallBack{
        void onSuccess(Object data);
        void onFaild(Exception e);
    }
}
