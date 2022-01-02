package com.ortudev.sportsResults.data.server.responses

data class CompetitionResponse(
    val id:Int,
    val name:String,
    val location:LocationResponse
)