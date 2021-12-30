package com.ortudev.sportsResults.usecases

import com.ortudev.sportsResults.data.domain.Circuit
import com.ortudev.sportsResults.data.db.Circuit as CircuitDB
import com.ortudev.sportsResults.data.domain.F1Repository

class GetCircuits(private val repository:F1Repository) {
    suspend operator fun invoke():List<Circuit>{
       return repository.getCircuits().map(CircuitDB::toDomainCircuit)
    }
}