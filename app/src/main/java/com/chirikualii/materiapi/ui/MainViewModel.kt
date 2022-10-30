package com.chirikualii.materiapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chirikualii.materiapi.data.remote.model.Movie
import com.chirikualii.materiapi.data.repository.MovieRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(val repo: MovieRepo) :ViewModel(){

    private val _listmovie = MutableLiveData<List<Movie>>()
    val listMovie :LiveData<List<Movie>> =_listmovie


    fun doGetPopularMovie(){
        viewModelScope.launch(Dispatchers.IO){
           val listData = repo.getPopularMovie()

            withContext(Dispatchers.Main){
                _listmovie.value = listData
            }
        }
    }
}