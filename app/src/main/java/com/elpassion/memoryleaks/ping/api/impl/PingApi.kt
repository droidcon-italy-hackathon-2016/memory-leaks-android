package com.elpassion.memoryleaks.ping.api.impl

import com.elpassion.memoryleaks.common.api.RetrofitProvider.getRetrofit
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
    }
}
