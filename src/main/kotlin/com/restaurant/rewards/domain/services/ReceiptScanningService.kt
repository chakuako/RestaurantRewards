package com.restaurant.rewards.domain.services

import com.restaurant.rewards.domain.models.PointsAwarded
import com.restaurant.rewards.domain.models.Receipt

class ReceiptScanningService {

    fun processReceipt(receipt: Receipt): PointsAwarded {
        /**
         * In a real application, we would have a lot more business logic
         * in this service. We would consider active Deals and other things
         * to determine the points to award for a given receipt. But for
         * the sake of example, we will just award 1 point per dollar spent.
         */
        val points = if (receipt.amount == null) {
            0
        } else {
            receipt.amount.toInt()
        }

        return PointsAwarded(
            receiptId = receipt.receiptId,
            userId = receipt.userId,
            points = points,
        )
    }

}