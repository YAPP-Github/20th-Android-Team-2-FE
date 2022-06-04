package com.yapp.android2.data.service

import com.yapp.android2.data.service.convert.BestFriendResponseConvertFactory
import retrofit2.Retrofit

interface Service {
    companion object {
        private const val BASE_URL = "http://61.79.96.183:8080/"

        internal fun retroBuilder(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(BestFriendResponseConvertFactory.create())
                .build()
        }
    }
}