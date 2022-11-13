package com.example.catfacts_tugas9

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("breeds")
    //getJokes
    fun getCat() : Call<ResponseCat>
}