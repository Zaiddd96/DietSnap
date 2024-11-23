package com.example.dietsnap.data

data class RecipeResponse(
    val success: Boolean,
    val data: RecipeData,
    val message: String
)

data class RecipeData(
    val _id: String,
    val api_name: List<String>,
    val badge_indicator: String,
    val credits_url: String,
    val cuisine: String,
    val description: String,
    val generic_facts: List<String>,
    val health_rating: Int,
    val image: String,
    val image_url: String,
    val ingredients: List<Ingredient>,
    val itemtype: String,
    val name: String,
    val no_of_servings: Int,
    val nutrition_facts: String,
    val nutrition_info: String,
    val nutrition_info_scaled: List<NutritionInfoScaled>,
    val serving_sizes: List<ServingSize>,
    val similar_items: List<SimilarItem>,
    val type: String,
    val default_unit_serving: String
)

data class Ingredient(
    val ingid: String,
    val name: String,
    val value: Double
)

data class NutritionInfoScaled(
    val name: String,
    val value: Double,
    val units: String
)

data class ServingSize(
    val units: String,
    val name: String,
    val value: Double
)

data class SimilarItem(
    val _id: String,
    val name: String,
    val image: String
)
