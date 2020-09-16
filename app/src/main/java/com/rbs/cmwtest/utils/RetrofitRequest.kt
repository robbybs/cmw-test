package com.rbs.cmwtest.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRequest {
    private const val BASE_URL = "http://dummy.restapiexample.com/api/v1/"

    private fun getApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService(): ApiRequest = getApi().create(ApiRequest::class.java)
}