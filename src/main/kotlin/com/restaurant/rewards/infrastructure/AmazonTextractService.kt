package com.restaurant.rewards.infrastructure

import com.restaurant.rewards.domain.models.Receipt
import com.restaurant.rewards.domain.services.OCRService

/**
 * The infrastructure layer deals with external concerns, such as databases,
 * external APIs, file systems, or messaging systems. It serves as a bridge
 * between the application layer and external resources.
 *
 * Services defined in the Domain layer are implemented here to keep
 * the domain layer as pure as possible from implementation details.
 */
class AmazonTextractService : OCRService {

    override fun scanReceipt(rawReceipt: Receipt): Receipt {
        // Instantiate the Amazon Textract client and call the service
        // to scan the receipt and extract the text from the image.
        TODO("Not yet implemented")
    }
}