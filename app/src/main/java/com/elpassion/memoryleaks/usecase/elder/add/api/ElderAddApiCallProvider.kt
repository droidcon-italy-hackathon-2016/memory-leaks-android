package com.elpassion.memoryleaks.usecase.elder.add.api

import com.elpassion.memoryleaks.common.provider.RetrofitProvider.getRetrofit
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable

object ElderAddApiCallProvider {

    fun getElderAddApiCall() = { elderId: String, childId: String, relation: String ->
        getRetrofit().create(Api::class.java).call(elderId, childId, relation)
    }

    private interface Api {
        @POST("/relatives")
        fun call(@Query("elder_id") elderId: String,
                 @Query("child_id") childId: String,
                 @Query("relation") relation: String): Observable<Unit>
    }
}