package com.restaurant.rewards.application

import com.restaurant.rewards.domain.errors.InsufficientPointsException
import com.restaurant.rewards.domain.models.Reward
import com.restaurant.rewards.domain.models.UserId
import com.restaurant.rewards.domain.services.PointsRepository
import com.restaurant.rewards.domain.services.RewardsRepository

/**
 * The Application layer in DDD encapsulates the behavior and
 * workflows of the application. It coordinates the execution
 * of domain logic according to the application “use cases”.
 * You can think of each class in this layer as a "Workflow"
 * or "Activity" in the system.
 */
class PointsRedemption(
    private val pointsRepository: PointsRepository,
    private val rewardsRepository: RewardsRepository,
) {

    fun redeemPoints(userId: UserId, rewardId: String): Reward {
        // Step 1. Get the current user balance
        val userBalance = pointsRepository.getUserBalance(userId)

        // Step 2. Get the desired reward
        val reward = rewardsRepository.getReward(rewardId)

        // Step 3. Check if the user can afford the reward
        if (reward.canAfford(userBalance)) {
            throw InsufficientPointsException()
        }

        // Step 4. Deduct points from the user balance
        pointsRepository.deductPoints(userId, reward.pointsCost)

        // Step 5. Claim the reward
        rewardsRepository.claimReward(reward, userId)

        // Step 6. Return it to the presentation layer
        return reward
    }

}