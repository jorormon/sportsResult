package com.ortudev.sportsResults.data.server.api

import com.ortudev.sportsResults.data.server.responses.BaseResponse
import com.ortudev.sportsResults.data.server.responses.CircuitResponse
import retrofit2.http.GET

interface F1Api {
    @GET("circuits")
    suspend fun getCircuits(): BaseResponse<CircuitResponse>
}