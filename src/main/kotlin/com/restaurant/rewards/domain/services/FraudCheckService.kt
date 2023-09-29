package com.restaurant.rewards.domain.services

import com.restaurant.rewards.domain.models.Receipt

class FraudCheckService {

    fun isFraudulent(receipt: Receipt): Boolean {
        return false
    }

}