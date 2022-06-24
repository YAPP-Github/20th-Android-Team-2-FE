package com.yapp.android2.data.service

import com.yapp.android2.domain.entity.base.Record
import com.yapp.android2.domain.entity.base.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecordService : Service {

    @GET("/api/savingRecords")
    suspend fun fetchRecords(
        @Query("recordMM") date: String
    ): ApiResponse<List<Record>>
}