package com.elpassion.memoryleaks.common.provider

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    private val instance by lazy {
        Retrofit.Builder()
                .baseUrl("https://google.com")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getRetrofit(): Retrofit {
        return instance
    }
}
