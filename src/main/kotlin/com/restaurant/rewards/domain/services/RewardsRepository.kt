package com.restaurant.rewards.domain.services

import com.restaurant.rewards.domain.models.Reward
import com.restaurant.rewards.domain.models.UserId

interface RewardsRepository {
    fun getReward(rewardId: String): Reward
    fun claimReward(reward: Reward, userId: UserId)
}