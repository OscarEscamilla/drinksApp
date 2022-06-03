package com.drinks.com.data

import com.drinks.com.data.model.Drink
import com.drinks.com.data.model.DrinkList
import com.drinks.com.vo.Resource
import com.drinks.com.vo.RetrofitClient

class DataSource {


    private val generateDrinksList = listOf(
        Drink("https://www.cocinavital.mx/wp-content/uploads/2018/03/margarita_tradicional-e1582054510330.jpg", "Margarita", "Incluye vodka y azucar de mora"),
        Drink("https://culichitowns.com/wp-content/uploads/2019/07/drinks-Paloma-Negra.jpg", "Paloma", "Incluye Tequila Don Julio y fresca"),
        Drink("https://imagenes.milenio.com/UCsDhLHchmGv0yQWIcWDkHkhDas=/958x596/https://www.milenio.com/uploads/media/2019/12/01/ponche-frutas-navideno-bebida-tradicional_0_3_958_596.jpg", "Ponche", "Incluye Chabacano y caña")
    )

    // recibe como parametro la data declaeada en Resource
    fun getDrinkList(): Resource<List<Drink>> {
        return Resource.Success(generateDrinksList)
    }


    suspend fun getDrinksByName(nameDrink: String): Resource.Success<List<Drink>>{
        return Resource.Success(RetrofitClient.webService.getTragosByName(nameDrink).drinkList)
    }

}