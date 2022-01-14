package com.ortudev.sportsResults.data.server.api

import com.ortudev.sportsResults.data.server.responses.BaseResponse
import com.ortudev.sportsResults.data.server.responses.CircuitResponse
import com.ortudev.sportsResults.data.server.responses.DriverResponse
import com.ortudev.sportsResults.data.server.responses.RankingTeamResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface F1Api {
    @GET("circuits")
    suspend fun getCircuits(): BaseResponse<CircuitResponse>

    @GET("drivers")
    suspend fun getDrivers():BaseResponse<DriverResponse>

    @GET("ranking/teams")
    suspend fun getRankingTeams(@Query("season")season:String):BaseResponse<RankingTeamResponse>
}