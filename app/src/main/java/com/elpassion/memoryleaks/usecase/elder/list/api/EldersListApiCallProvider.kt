package com.elpassion.memoryleaks.usecase.elder.list.api

import com.elpassion.memoryleaks.common.provider.RetrofitProvider
import com.elpassion.memoryleaks.model.Elders
import retrofit2.http.GET
import rx.Observable

object EldersListApiCallProvider {

    fun getEldersListApiCall() = {
        RetrofitProvider.getRetrofit().create(Api::class.java).call()
    }

    private interface Api {

        @GET("relatives.json?user_id=93e27a28-65b4-481b-a468-53bc34224e03")
        fun call(): Observable<Elders>
    }
}