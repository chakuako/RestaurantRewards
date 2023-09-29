package com.restaurant.rewards.domain.models

@JvmInline
value class UserId(
    private val value: String,
) {
   init {
         require(value.isNotBlank()) {
             "User ID must not be blank"
         }

        // Validate value is an email address
        require(value.contains("@")) {
            "User ID must be an email address"
        }
   }
}
