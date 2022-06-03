package com.drinks.com.domain

import com.drinks.com.data.DataSource
import com.drinks.com.data.model.Drink
import com.drinks.com.data.model.DrinkList
import com.drinks.com.vo.Resource

class RepoImpl(val dataSource: DataSource): Repo {


    // obtiene los datos del data source
    override suspend fun getDrinksList(nameDrink: String): Resource<List<Drink>> {
        return dataSource.getDrinksByName(nameDrink)
    }

}