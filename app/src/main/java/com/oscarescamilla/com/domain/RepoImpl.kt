package com.oscarescamilla.com.domain

import com.oscarescamilla.com.data.DataSource
import com.oscarescamilla.com.data.model.Drink
import com.oscarescamilla.com.vo.Resource

class RepoImpl(val dataSource: DataSource): Repo {


    // obtiene los datos del data source
    override fun getDrinksList(): Resource<List<Drink>> {
        return dataSource.getDrinkList()
    }
}