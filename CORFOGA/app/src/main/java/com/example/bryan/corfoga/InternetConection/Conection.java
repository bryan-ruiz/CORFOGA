package com.example.bryan.corfoga.InternetConection;

import com.example.bryan.corfoga.Class.Animal;
import com.example.bryan.corfoga.Class.Farm;
import com.example.bryan.corfoga.Class.Inspection;
import com.example.bryan.corfoga.Class.User;

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
    @GET("/api/login/{user}/{pass}")
    Call<User> getUser(@Path("user") String user, @Path("pass") String pass);
    @GET("/api/fincas/get/{region}")
    Call<List<Farm>> getFarmsFromRegion(@Path("region") int region);
    @GET("/api/animales/get/{farm}")
    Call<List<Animal>> getAnimalsFromFarm(@Path("farm") int farm);
    @GET("/api/inspecciones/get/{anno}/{animal}")
    Call<List<Inspection>> getInspectionsFromAnimal(@Path("anno") String anno, @Path("animal") int animal);
    @POST("/api/inspecciones/create")
    Call<String>addInspection(@Body Inspection inspection);
}
