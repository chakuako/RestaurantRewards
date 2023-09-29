package com.restaurant.rewards.domain.services

import com.restaurant.rewards.domain.models.Receipt

/**
 * Object Character Recognition (OCR)
 */
interface OCRService {
    /**
     * Performs OCR on the raw receipt given and returns the
     * Receipt object populated with the extracted data.
     */
    fun scanReceipt(rawReceipt: Receipt): Receipt
}