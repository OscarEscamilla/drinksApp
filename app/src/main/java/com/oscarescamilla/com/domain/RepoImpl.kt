package com.oscarescamilla.com.domain

import com.oscarescamilla.com.data.DataSource
import com.oscarescamilla.com.data.model.Drink
import com.oscarescamilla.com.data.model.DrinkList
import com.oscarescamilla.com.vo.Resource

class RepoImpl(val dataSource: DataSource): Repo {


    // obtiene los datos del data source
    override suspend fun getDrinksList(nameDrink: String): Resource<List<Drink>> {
        return dataSource.getDrinksByName(nameDrink)
    }

}