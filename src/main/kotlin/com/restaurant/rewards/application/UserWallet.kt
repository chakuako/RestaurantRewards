package com.restaurant.rewards.application

import com.restaurant.rewards.domain.models.UserId
import com.restaurant.rewards.domain.models.Wallet
import com.restaurant.rewards.domain.services.PointsRepository

/**
 * The Application layer in DDD encapsulates the behavior and
 * workflows of the application. It coordinates the execution
 * of domain logic according to the application “use cases”.
 * You can think of each class in this layer as a "Workflow"
 * or "Activity" in the system.
 */
class UserWallet(private val pointsRepository: PointsRepository) {

    fun getUserWallet(userId: UserId): Wallet {
        val points = pointsRepository.getUserBalance(userId)
        return Wallet(userId, points)
    }

}