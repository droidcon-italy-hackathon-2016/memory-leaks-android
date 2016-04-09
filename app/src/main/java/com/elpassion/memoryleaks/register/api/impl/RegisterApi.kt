package com.elpassion.memoryleaks.register.api.impl

import com.elpassion.memoryleaks.common.provider.RetrofitProvider
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface RegisterApi {

    @GET("ping")
    fun call(@Query("name") name: String, @Query("token") token: String? = null): Observable<Unit>

    companion object {
        fun getRegisterElderApiCall(): ((String, String) -> Observable<Unit>) = { elderId, token ->
            createRegisterApiImpl().call(elderId, token)
        }

        fun getRegisterVisitorApiCall(): ((String) -> Observable<Unit>) = { elderId ->
            createRegisterApiImpl().call(elderId)
        }

        private fun createRegisterApiImpl() = RetrofitProvider.getRetrofit().create(RegisterApi::class.java)
    }
}