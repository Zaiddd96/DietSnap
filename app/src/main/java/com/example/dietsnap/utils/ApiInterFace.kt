package com.example.dietsnap.utils

import com.example.dietsnap.data.RecipeResponse
import retrofit2.http.GET

interface FoodInfoApi {
    @GET("food_info/")
    suspend fun getFoodInfo(): RecipeResponse
}