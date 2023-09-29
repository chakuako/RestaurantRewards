package com.restaurant.rewards.domain.models

/**
 * Value object.
 */
data class PointsAwarded(
    val receiptId: String,
    val userId: UserId,
    val points: Int,
)