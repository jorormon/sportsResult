package com.ortudev.sportsResults.ui.main

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

    var filter:Filter = Filter.Ascending

    init {
        onReloadCircuits()
    }

    fun onReloadCircuits(){
        viewModelScope.launch{
            _refreshing.value = true
            getFilteredItems()
            _refreshing.value = false
        }
    }
    private suspend fun getCircuits() = withContext(Dispatchers.IO){ GetCircuits(repository).invoke() }

    private fun getFilteredItems(filter:Filter = this.filter){
        viewModelScope.launch {
            _circuits.value = getCircuits().apply {
                filterItems(this,filter)
            }

        }
    }

    fun filterItems(filter: Filter){
        this.filter=filter
        _circuits.value = circuits.value?.let { list ->
           filterItems(list,filter)
        }
    }
    
    private fun filterItems(list:List<Circuit>,filter:Filter):List<Circuit>{
        return when(filter){
            Filter.Ascending -> list.sortedBy { it.name }
            Filter.Descending -> list.sortedByDescending { it.name }
        }
    }


}