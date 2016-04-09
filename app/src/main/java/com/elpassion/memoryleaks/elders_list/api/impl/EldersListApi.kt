package com.elpassion.memoryleaks.elders_list.api.impl

import com.elpassion.memoryleaks.model.Elder
import retrofit2.http.GET
import rx.Observable

interface EldersListApi {

    @GET("elders")
    fun call(): Observable<List<Elder>>

    companion object {
        fun getEldersListApiCall(): (() -> Observable<List<Elder>>) = {
            Observable.just(listOf(Elder(), Elder()))
            //            RetrofitProvider.getRetrofit().create(EldersListApi::class.java).call()
        }
    }
}