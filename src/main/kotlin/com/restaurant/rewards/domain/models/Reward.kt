package com.restaurant.rewards.domain.models

data class Reward(
    val rewardId: String,
    val rewardType: RewardType,
    val partner: Partner,
    val cashValue: Double,
    val pointsCost: Int,
) {
    fun canAfford(pointsBalance: Int): Boolean {
        return pointsBalance >= pointsCost
    }
}