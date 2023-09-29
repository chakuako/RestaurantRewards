package com.restaurant.rewards.application

import com.restaurant.rewards.domain.errors.FraudulentReceiptException
import com.restaurant.rewards.domain.models.Receipt
import com.restaurant.rewards.domain.services.FraudCheckService
import com.restaurant.rewards.domain.services.OCRService
import com.restaurant.rewards.domain.services.ReceiptScanningService
import com.restaurant.rewards.domain.models.PointsAwarded
import com.restaurant.rewards.domain.services.PointsRepository

/**
 * Represents the workflow where the user scans and uploads
 * a receipt. Points are awarded accordingly and fraud check
 * is performed.
 *
 * The Application layer in DDD encapsulates the behavior and
 * workflows of the application. It coordinates the execution
 * of domain logic according to the application “use cases”.
 * You can think of each class in this layer as a "Workflow"
 * or "Activity" in the system.
 */
class ReceiptScanning (
    private val fraudCheckService: FraudCheckService,
    private val receiptScanningService: ReceiptScanningService,
    private val ocrService: OCRService,
    private val pointsRepository: PointsRepository,
) {

    fun processReceipt(rawReceipt: Receipt): PointsAwarded {
        // Step 1. Perform OCR on the raw receipt and extract data
        val receipt = ocrService.scanReceipt(rawReceipt)

        // Step 2. Check for fraud
        if (fraudCheckService.isFraudulent(receipt)) {
            throw FraudulentReceiptException()
        }

        // Step 3. Process receipt to determine points to be awarded
        val pointsAwarded = receiptScanningService.processReceipt(receipt)

        // Step 4. Award points to the user
        pointsRepository.awardPoints(pointsAwarded)

        // Step 5. Return response to the presentation layer
        return pointsAwarded
    }

}