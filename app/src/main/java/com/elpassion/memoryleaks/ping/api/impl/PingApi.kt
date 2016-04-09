package com.elpassion.memoryleaks.ping.api.impl

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import rx.Observable

interface PingApi {

    @GET("ping")
    fun call(): Observable<Unit>

    companion object {
        fun getPingApiCall(): (() -> Observable<Unit>) = {
            getRetrofit().create(PingApi::class.java).call()
        }

        private fun getRetrofit() = Retrofit.Builder()
                .baseUrl("https://google.com")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}
