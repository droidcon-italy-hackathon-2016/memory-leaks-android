package com.elpassion.memoryleaks.elder.list.api

import com.elpassion.memoryleaks.common.provider.RetrofitProvider
import com.elpassion.memoryleaks.model.Elder
import retrofit2.http.GET
import rx.Observable

object EldersListApiCallProvider {

    fun getEldersListApiCall() = {
        RetrofitProvider.getRetrofit().create(Api::class.java).call()
    }

    private interface Api {

        @GET("elders")
        fun call(): Observable<List<Elder>>
    }
}