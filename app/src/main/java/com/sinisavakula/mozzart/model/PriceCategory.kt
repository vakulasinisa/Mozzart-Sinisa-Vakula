package com.sinisavakula.mozzart.model

import kotlinx.serialization.Serializable

@Serializable
data class PriceCategory(
    val id: Int,
    val divident: Double,
    val winners: Int,
    val distributed: Double,
    val jackpot: Double,
    val fixed: Double,
    val categoryType: Int,
    val gameType: String
)