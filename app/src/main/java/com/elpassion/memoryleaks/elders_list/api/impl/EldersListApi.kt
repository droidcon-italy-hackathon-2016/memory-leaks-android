package com.elpassion.memoryleaks.elders_list.api.impl

import com.elpassion.memoryleaks.model.Elder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import rx.Observable

interface EldersListApi {

    @GET("elders")
    fun call(): Observable<List<Elder>>

    companion object {
        fun getEldersListApiCall(): (() -> Observable<List<Elder>>) = {
            Observable.just(listOf(Elder(), Elder()))
            //getRetrofit().create(EldersListApi::class.java).call()
        }

        private fun getRetrofit() = Retrofit.Builder()
                .baseUrl("https://google.com")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}