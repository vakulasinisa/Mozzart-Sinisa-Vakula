package com.sinisavakula.mozzart.model

import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
data class Round(
    val id: String? = null,
    val gameId: Int? = null,
    val drawId: Int? = null,
    val drawTime: Long = 0,
    val status: String? = null,
    val drawBreak: Int? = null,
    val visualDraw: Int? = null,
    val pricePoints: PricePoint? = null,
    val prizeCategories: List<PriceCategory>? = null,
    val wagerStatistics: WagerStatistics? = null
)