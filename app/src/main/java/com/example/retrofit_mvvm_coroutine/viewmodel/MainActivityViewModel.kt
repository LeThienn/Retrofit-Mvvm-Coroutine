package com.example.retrofit_mvvm_coroutine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_mvvm_coroutine.model.RecyclerList
import com.example.retrofit_mvvm_coroutine.network.RetroInstance
import com.example.retrofit_mvvm_coroutine.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    private var recyclerListLiveData: MutableLiveData<RecyclerList>

    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver(): MutableLiveData<RecyclerList>{
        return recyclerListLiveData
    }

    fun makeCallApi(){
        viewModelScope.launch(Dispatchers.IO) {
            // Dispatchers: sẽ quyết định thread nào mà coroutine sẽ chạy trên đó
            // Dispatchers.IO: chạy trên background thread của thread pool
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getDataFromApi("ny")
            recyclerListLiveData.postValue(response)
        }
    }
}