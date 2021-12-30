package com.ortudev.sportsResults.data.server

import retrofit2.http.GET

interface F1Api {
    @GET("circuits")
    suspend fun getCircuits(): BaseResponse<CircuitResponse>
}