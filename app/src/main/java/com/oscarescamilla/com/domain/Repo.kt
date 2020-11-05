package com.oscarescamilla.com.domain

import com.oscarescamilla.com.data.model.Drink
import com.oscarescamilla.com.vo.Resource

interface Repo {

    suspend fun getDrinksList(nameDrink: String): Resource<List<Drink>>

}