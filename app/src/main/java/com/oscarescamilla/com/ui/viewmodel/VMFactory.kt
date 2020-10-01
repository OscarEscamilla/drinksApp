package com.oscarescamilla.com.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oscarescamilla.com.data.model.Drink
import com.oscarescamilla.com.domain.Repo
import com.oscarescamilla.com.vo.Resource

class VMFactory(private val repo: Repo): ViewModelProvider.Factory {



    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }


}