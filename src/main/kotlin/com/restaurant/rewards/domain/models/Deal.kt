package com.restaurant.rewards.domain.models

import java.util.Date

data class Deal(
    val dealId: String,
    val restaurant: Restaurant,
    val pointsMultiplier: Double,
    val startDate: Date,
    val endDate: Date,
)