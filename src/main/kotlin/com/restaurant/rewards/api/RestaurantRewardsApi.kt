package com.restaurant.rewards.api

import com.restaurant.rewards.api.dto.*
import com.restaurant.rewards.application.UserWallet
import com.restaurant.rewards.application.PointsRedemption
import com.restaurant.rewards.application.ReceiptScanning
import com.restaurant.rewards.domain.models.Receipt
import com.restaurant.rewards.domain.models.UserId
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

/**
 * The API / Presentation Layer in DDD Handles the user interface
 * and user interactions. Components here include user interfaces
 * web controllers, or user interface elements in the case of
 * mobile or web applications. This layer focuses on presenting
 * information and gathering user input.
 */
@Controller("/")
class RestaurantRewardsApi(
    private val receiptScanning: ReceiptScanning,
    private val userWallet: UserWallet,
    private val pointsRedemption: PointsRedemption,
) {

    @Post("/receipt")
    fun scanReceipt(request: ScanReceiptRequest): HttpResponse<ScanReceiptResponse> {

        // Validate user input
        if (request.userId == null || request.imageUrl == null) {
            return HttpResponse.badRequest()
        }

        // Translate the user input into domain objects to invoke the application layer
        val newReceipt = Receipt.new(request.userId!!, request.imageUrl!!)
        val pointsAwarded = receiptScanning.processReceipt(newReceipt)

        // Translate the response into a DTO object, never expose your domain
        // objects to the outside world. Always translate them into DTOs.
        // That will give you flexibility to change your domain objects without
        // affecting your outside consumers.
        return HttpResponse.ok(
            ScanReceiptResponse(
                pointsAwarded = pointsAwarded.points
            )
        )
    }

    @Get("/wallet")
    fun getUserWallet(request: GetUserWalletRequest): HttpResponse<GetUserWalletResponse> {

        // Validate user input
        if (request.userId == null) {
            return HttpResponse.badRequest()
        }

        // Call the application layer
        val wallet = userWallet.getUserWallet(UserId(request.userId))

        // Translate the response into a DTO object, never expose your domain objects
        return HttpResponse.ok(
            GetUserWalletResponse(
                userId = wallet.userId.toString(),
                points = wallet.points
            )
        )
    }

    @Post("/redeem")
    fun redeemPoints(request: RedeemPointsRequest): HttpResponse<RedeemPointsResponse> {

        // Validate user input
        if (request.userId == null || request.rewardId == null) {
            return HttpResponse.badRequest()
        }

        // Call the application layer
        val userId = UserId(request.userId!!)
        pointsRedemption.redeemPoints(userId, request.rewardId!!)

        // Translate the response into a DTO object, never expose your domain objects
        return HttpResponse.ok(
            RedeemPointsResponse(
                rewardId = userId.toString(),
                cashValue = 0.0,
            )
        )
    }
}