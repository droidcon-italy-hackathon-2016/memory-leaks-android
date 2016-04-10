package com.elpassion.memoryleaks.usecase.ping.api

import com.elpassion.memoryleaks.common.provider.RetrofitProvider.getRetrofit
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable

object PingApiCallProvider {

    fun getPingApiCall(): ((String, String) -> Observable<Unit>) = { elderId, visitorId ->
        getRetrofit().create(Api::class.java).call(elderId, visitorId)
    }

    private interface Api {

        @POST("knock_knocks")
        fun call(@Query("elder_id") elderId: String, @Query("child_id") visitorId: String): Observable<Unit>
    }
}
