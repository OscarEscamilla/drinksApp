package com.drinks.com.domain

import com.drinks.com.data.model.Drink
import com.drinks.com.vo.Resource

interface Repo {

    suspend fun getDrinksList(nameDrink: String): Resource<List<Drink>>

}