package com.qin.week1test.api;

import com.qin.week1test.bean.SearchBean;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiService {

    @GET
     Call<SearchBean> mSearch(@Url String url, @Query("keyword") String name,@Query("page") String page,@Query("count") String count);
}
