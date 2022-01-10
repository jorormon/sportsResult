package com.ortudev.sportsResults.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortudev.sportsResults.data.domain.Circuit
import com.ortudev.sportsResults.data.domain.F1Repository
import com.ortudev.sportsResults.usecases.GetCircuits
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(private val repository: F1Repository): ViewModel() {

    private val _circuit = MutableLiveData<Circuit>()
    val circuit: LiveData<Circuit> = _circuit

    fun getInfoCircuit(circuitId:Int){
        viewModelScope.launch {
            _circuit.value = getCircuitById(circuitId)
        }
    }
    private suspend fun getCircuitById(circuitId: Int) = withContext(Dispatchers.IO){ GetCircuits(repository).byId(circuitId) }
}