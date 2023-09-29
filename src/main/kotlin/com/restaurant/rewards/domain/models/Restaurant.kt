package com.restaurant.rewards.domain.models

data class Restaurant(
    val restaurantId: String,
    val name: String,
    val address: String,
    val city: String,
    val state: String,
    val zip: String,
)