package com.drinks.com.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.drinks.com.data.model.Drink
import com.drinks.com.domain.Repo
import com.drinks.com.vo.Resource

class VMFactory(private val repo: Repo): ViewModelProvider.Factory {



    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }


}