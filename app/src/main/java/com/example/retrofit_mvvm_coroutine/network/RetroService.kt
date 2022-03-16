package com.example.retrofit_mvvm_coroutine.network

import com.example.retrofit_mvvm_coroutine.model.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    suspend fun getDataFromApi(
        @Query("q") query: String): RecyclerList

}