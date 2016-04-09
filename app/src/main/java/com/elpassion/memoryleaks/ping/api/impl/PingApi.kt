package com.elpassion.memoryleaks.ping.api.impl

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface PingApi {

    @GET("ping")
    fun call(@Query("elder_id") elderId: String): Observable<Unit>

    companion object {
        fun getPingApiCall(): ((String) -> Observable<Unit>) = { elderId ->
            getRetrofit().create(PingApi::class.java).call(elderId)
        }

        private fun getRetrofit() = Retrofit.Builder()
                .baseUrl("https://google.com")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}
