package com.restaurant.rewards.domain.models

import java.util.*

data class Receipt(
    val receiptId: String,
    val userId: UserId,
    val imageUrl: String,
    var restaurantId: String?,
    val date: Date?,
    val amount: Double?,
) {
    companion object {
        fun new(
            userId: String,
            imageUrl: String,
        ): Receipt {
            return Receipt(
                receiptId = UUID.randomUUID().toString(),
                userId = UserId(userId),
                imageUrl = imageUrl,
                restaurantId = null,
                date = null,
                amount = null,
            )
        }
    }
}
