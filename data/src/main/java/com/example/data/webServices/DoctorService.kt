package com.example.data.webServices

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface DoctorService {

    @GET("doctors")
    abstract fun getDoctors(@Query("location") location: String,
                            @Query("limit") limit: Int,
                            @Query("name") name: String?,
                            @Query("first_name") first_name: String?,
                            @Query("last_name") last_name: String?,
                            @Query("query") query: String?,
                            @Query("specialty_uid") specialty_uid: String?,
                            @Query("insurance_uid") insurance_uid: String?,
                            @Query("practice_uid") practice_uid: String?,
                            @Query("gender") gender: String?,
                            @Query("sort") sort: String?,
                            @Query("skip") skip: Int): Call<String>
}