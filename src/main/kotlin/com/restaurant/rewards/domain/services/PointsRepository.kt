package com.restaurant.rewards.domain.services

import com.restaurant.rewards.domain.models.PointsAwarded
import com.restaurant.rewards.domain.models.UserId

interface PointsRepository {
    fun awardPoints(points: PointsAwarded)
    fun getUserBalance(userId: UserId): Int
    fun deductPoints(userId: UserId, points: Int)
}