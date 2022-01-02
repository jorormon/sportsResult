package com.ortudev.sportsResults.data.server.responses

data class BaseResponse<out T>(

    val get:String,
    val parameters:Any,
    val errors:Any,
    val results:Int,
    val response:List<T>

)