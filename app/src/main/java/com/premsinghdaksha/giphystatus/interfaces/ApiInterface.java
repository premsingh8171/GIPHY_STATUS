package com.premsinghdaksha.giphystatus.interfaces;

import com.premsinghdaksha.giphystatus.model.ResponseDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
   // @FormUrlEncoded
    @GET("trending")
    Call<ResponseDTO> getdata(
            @Query(value = "api_key")  String key,
            @Query(value = "limit")  String value
            );
}


//?api_key=eLPy7CXqimAo9wqht5EKRcAujKGpzDsV&limit=25