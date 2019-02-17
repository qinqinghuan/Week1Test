package com.qin.week1test.http;

import com.qin.week1test.api.Api;
import com.qin.week1test.api.ApiService;
import com.qin.week1test.bean.SearchBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    public static void doGet(String url, String name, String page, String count, final setRetrofit setRetrofit){
        //管理类
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //接口
        ApiService apiService=retrofit.create(ApiService.class);

        Call<SearchBean> searchBeanCall = apiService.mSearch(url, name, page, count);

        searchBeanCall.enqueue(new Callback<SearchBean>() {
            @Override
            public void onResponse(Call<SearchBean> call, Response<SearchBean> response) {

                setRetrofit.getData(response.body());
            }

            @Override
            public void onFailure(Call<SearchBean> call, Throwable t) {

            }
        });
    }
    public interface setRetrofit{
        void getData(Object data);
    }

}
