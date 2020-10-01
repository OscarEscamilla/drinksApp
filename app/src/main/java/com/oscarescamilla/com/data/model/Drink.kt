package com.oscarescamilla.com.data.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Drink(
    val image: String = "",
    val nombre: String = "",
    val descripcion: String = ""
): Parcelable