package com.ortudev.sportsResults.data.domain

data class Circuit(val id:Int,val name:String,val image:String,val location: Location?, val length:String){

    fun loadFlag():String?{
       return location?.let{"https://countryflagsapi.com/png/${it.country.lowercase()}"}
    }
}
