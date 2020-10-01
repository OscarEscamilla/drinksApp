package com.oscarescamilla.com.data

import com.oscarescamilla.com.data.model.Drink
import com.oscarescamilla.com.vo.Resource

class DataSource {


    private val generateDrinksList = listOf(
        Drink("https://www.cocinavital.mx/wp-content/uploads/2018/03/margarita_tradicional-e1582054510330.jpg", "Margarita", "Incluye vodka y azucar de mora"),
        Drink("https://culichitowns.com/wp-content/uploads/2019/07/drinks-Paloma-Negra.jpg", "Paloma", "Incluye Tequila Don Julio y fresca"),
        Drink("https://imagenes.milenio.com/UCsDhLHchmGv0yQWIcWDkHkhDas=/958x596/https://www.milenio.com/uploads/media/2019/12/01/ponche-frutas-navideno-bebida-tradicional_0_3_958_596.jpg", "Ponche", "Incluye Chabacano y caña")
    )

    fun getDrinkList(): Resource<List<Drink>>{
        return Resource.Success(generateDrinksList)
    }
}