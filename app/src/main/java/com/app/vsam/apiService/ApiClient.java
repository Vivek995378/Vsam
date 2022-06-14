package com.app.vsam.apiService;

import com.app.vsam.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiClient {

    @POST("user")
    Call<User> login(@Header("msg") String token);

}
