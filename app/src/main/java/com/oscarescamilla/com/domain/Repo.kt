package com.oscarescamilla.com.domain

import com.oscarescamilla.com.data.model.Drink
import com.oscarescamilla.com.vo.Resource

interface Repo {
    fun getDrinksList(): Resource<List<Drink>>
}