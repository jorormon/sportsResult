package com.ortudev.sportsResults.data.db

import com.ortudev.sportsResults.data.domain.Driver

data class Driver(val id:Int, val name:String){
    fun toDomainDriver():Driver{
        return Driver(name)
    }
}
