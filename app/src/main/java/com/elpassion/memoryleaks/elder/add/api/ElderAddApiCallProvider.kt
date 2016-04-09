package com.elpassion.memoryleaks.elder.add.api

import com.elpassion.memoryleaks.common.provider.RetrofitProvider.getRetrofit
import retrofit2.http.GET
import rx.Observable

object ElderAddApiCallProvider {

    fun getElderAddApiCall() = {
        getRetrofit().create(Api::class.java).call()
    }

    private interface Api {
        @GET("add")
        fun call(): Observable<Unit>
    }
}