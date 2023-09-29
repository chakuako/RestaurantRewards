package com.restaurant.rewards.domain.models

/**
 * Entity class.
 */
data class User(
    val userId: UserId,
    val firstName: String,
    val lastName: String,
    val wallet: Wallet,
)