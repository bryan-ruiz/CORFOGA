package com.example.bryan.corfoga.InternetConection;

import com.example.bryan.corfoga.Class.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface Conection {
    @GET("/server/animales/animal/{id}/{pin}")
    Call<User> getUser(@Path("userName") String userName, @Path("password") String password);

    /*@POST("/server-odonto/ConfigCita/InsertarCita/{carn}")
    Call<Boolean> setUserSelectedDate(@Body Cita cita, @Path("carn") String carn);*/
}
