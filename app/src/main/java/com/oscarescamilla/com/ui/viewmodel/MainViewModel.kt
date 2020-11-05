package com.oscarescamilla.com.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.oscarescamilla.com.domain.Repo
import com.oscarescamilla.com.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

// recibe la interfaz de repo por constructor
class MainViewModel(private val repo: Repo): ViewModel() {


    val fetchTragosList = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(repo.getDrinksList("margarita"))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }


}