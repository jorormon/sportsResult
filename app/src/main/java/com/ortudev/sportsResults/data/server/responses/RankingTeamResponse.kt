package com.ortudev.sportsResults.data.server.responses

data class RankingTeamResponse(
    val position:Int,
    val team:TeamResponse,
    val points:Int,
    val season:Int
)

