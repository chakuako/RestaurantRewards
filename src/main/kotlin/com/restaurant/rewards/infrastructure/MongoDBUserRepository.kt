package com.restaurant.rewards.infrastructure

import com.restaurant.rewards.domain.models.User
import com.restaurant.rewards.domain.services.UserRepository

/**
 * The infrastructure layer deals with external concerns, such as databases,
 * external APIs, file systems, or messaging systems. It serves as a bridge
 * between the application layer and external resources.
 *
 * Services defined in the Domain layer are implemented here to keep
 * the domain layer as pure as possible from implementation details.
 */
class MongoDBUserRepository : UserRepository {

    override fun getUserById(userId: String): User {
        TODO("Not yet implemented")
    }

    override fun saveUser(user: User) {
        TODO("Not yet implemented")
    }
}