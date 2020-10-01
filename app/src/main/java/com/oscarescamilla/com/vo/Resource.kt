package com.oscarescamilla.com.vo

// tipo de dato generico T define los 3 estados
sealed class Resource<out T> {
    class Loading<out T>: Resource<T>()
    data class Success<out T>(val data: T): Resource<T>()
    data class Failure<out T>(val exeption: Exception): Resource<T>()
}