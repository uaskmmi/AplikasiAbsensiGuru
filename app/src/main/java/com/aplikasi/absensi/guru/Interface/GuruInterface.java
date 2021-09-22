package com.aplikasi.absensi.guru.Interface;

import com.aplikasi.absensi.guru.Model.GuruModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GuruInterface {

    @FormUrlEncoded
    @POST("/Absensi/guru/insertGuru.php")
    Call<GuruModel> insertGuru(
            @Field("NIP")int NIP,
            @Field("namaGuru")String namaGuru,
            @Field("passwordGuru")String passwordGuru
    );



}
