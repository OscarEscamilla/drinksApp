package com.oscarescamilla.com.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Drink(

    @SerializedName("strDrink")
    val nombre: String = "",

    @SerializedName("strDrinkThumb")
    val image: String = "",

    @SerializedName("strInstructions")
    val descripcion: String = ""

): Parcelable


data class DrinkList(

    @SerializedName("drinks")
    val drinkList: List<Drink>
)