package com.oscarescamilla.com.domain

import com.oscarescamilla.com.data.model.Drink
import com.oscarescamilla.com.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName


// suspend: indica que esta funcion hace una llamada a aunj servidor

interface WebService {

    @GET("search.php?s=")
    suspend fun getTragosByName(@Query("nameDrink") nameDrink: String): DrinkList
}