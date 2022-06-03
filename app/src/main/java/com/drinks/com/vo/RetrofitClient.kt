package com.drinks.com.vo

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.drinks.com.domain.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// se crea como objeto para incializar solo una vez
object RetrofitClient {

    // inicializamos lazy para inicializar solo cuando se necesite
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())) // usar como converter a GSon
            .build()
            .create(WebService::class.java)
    }

}