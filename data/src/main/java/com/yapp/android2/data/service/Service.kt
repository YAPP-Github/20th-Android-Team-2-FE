package com.yapp.android2.data.service

import com.yapp.android2.data.extensions.createInterceptors
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface Service {
    companion object {
        private const val BASE_URL = "https://61.79.96.183:8443/"
        const val HOST_NAME = "61.79.96.183"

        internal fun retroBuilder(vararg interceptor: Interceptor): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(createInterceptors(interceptor.toList()))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
