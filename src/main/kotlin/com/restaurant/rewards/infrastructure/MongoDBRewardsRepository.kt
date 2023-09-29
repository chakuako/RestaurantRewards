package com.restaurant.rewards.infrastructure

import com.restaurant.rewards.domain.models.Reward
import com.restaurant.rewards.domain.models.UserId
import com.restaurant.rewards.domain.services.RewardsRepository

/**
 * The infrastructure layer deals with external concerns, such as databases,
 * external APIs, file systems, or messaging systems. It serves as a bridge
 * between the application layer and external resources.
 *
 * Services defined in the Domain layer are implemented here to keep
 * the domain layer as pure as possible from implementation details.
 */
class MongoDBRewardsRepository : RewardsRepository {

    override fun getReward(rewardId: String): Reward {
        TODO("Not yet implemented")
    }

    override fun claimReward(reward: Reward, userId: UserId) {
        TODO("Not yet implemented")
    }
}