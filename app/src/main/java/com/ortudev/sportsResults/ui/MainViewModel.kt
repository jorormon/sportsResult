package com.ortudev.sportsResults.ui

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

class MainViewModel(private val repository: F1Repository):ViewModel() {

    private val _refreshing = MutableLiveData<Boolean>()
    val refreshing: LiveData<Boolean> = _refreshing

    private val _circuits = MutableLiveData<List<Circuit>>()
    val circuits : LiveData<List<Circuit>> = _circuits

    init {
        onReloadCircuits()
    }

    fun onReloadCircuits(){
        viewModelScope.launch{
            _refreshing.value = true
            _circuits.value = withContext(Dispatchers.IO){
                val x = GetCircuits(repository).invoke()
                x
            }
            _refreshing.value = false
        }
    }

}