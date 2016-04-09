package com.elpassion.memoryleaks.register.api.impl

import com.elpassion.memoryleaks.common.api.RetrofitProvider
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface RegisterApi {

    @GET("ping")
    fun call(@Query("name") name: String, @Query("token") token: String? = null): Observable<Unit>

    companion object {
        fun getRegisterElderApiCall(): ((String, String) -> Observable<Unit>) = { elderId, token ->
            RetrofitProvider.getRetrofit().create(RegisterApi::class.java).call(elderId, token)
        }

        fun getRegisterVisitorApiCall(): ((String) -> Observable<Unit>) = { elderId ->
            RetrofitProvider.getRetrofit().create(RegisterApi::class.java).call(elderId)
        }
    }
}