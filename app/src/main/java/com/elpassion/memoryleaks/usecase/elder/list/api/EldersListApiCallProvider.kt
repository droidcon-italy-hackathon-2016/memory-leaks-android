package com.elpassion.memoryleaks.usecase.elder.list.api

import com.elpassion.memoryleaks.common.provider.RetrofitProvider
import com.elpassion.memoryleaks.model.Elders
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

object EldersListApiCallProvider {

    fun getEldersListApiCall() = { userId: String ->
        RetrofitProvider.getRetrofit().create(Api::class.java).call(userId)
    }

    private interface Api {

        @GET("relatives.json")
        fun call(@Query("user_id") userId: String): Observable<Elders>
    }
}