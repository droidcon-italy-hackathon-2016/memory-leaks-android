package com.elpassion.memoryleaks.register.api.impl

import com.elpassion.memoryleaks.common.provider.RetrofitProvider
import com.elpassion.memoryleaks.model.User
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable

interface RegisterApi {

    @POST("users")
    fun call(@Query("name") name: String, @Query("device_token") token: String? = null): Observable<User>

    companion object {
        fun getRegisterElderApiCall(): ((String, String) -> Observable<User>) = { elderId, token ->
            registerApi.call(elderId, token)
        }

        fun getRegisterVisitorApiCall(): ((String) -> Observable<User>) = { elderId ->
            registerApi.call(elderId)
        }

        private val registerApi by lazy { RetrofitProvider.getRetrofit().create(RegisterApi::class.java) }
    }
}