package com.elpassion.memoryleaks.ping.api

import com.elpassion.memoryleaks.common.provider.RetrofitProvider.getRetrofit
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

object PingApiCallProvider {

    fun getPingApiCall(): ((String) -> Observable<Unit>) = { elderId ->
        getRetrofit().create(Api::class.java).call(elderId)
    }

    private interface Api {

        @GET("ping")
        fun call(@Query("elder_id") elderId: String): Observable<Unit>
    }
}
