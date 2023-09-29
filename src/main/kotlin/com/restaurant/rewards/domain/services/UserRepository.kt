package com.restaurant.rewards.domain.services

import com.restaurant.rewards.domain.models.User

interface UserRepository {
    fun getUserById(userId: String): User
    fun saveUser(user: User)
}