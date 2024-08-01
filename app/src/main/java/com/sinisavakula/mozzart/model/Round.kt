@file:Suppress("PLUGIN_IS_NOT_ENABLED")

package com.sinisavakula.mozzart.model

import kotlinx.serialization.Serializable

@Serializable
data class Round(
    val id: String,
    val gameId: Int,
    val drawId: Int,
    val drawTime: String,
    val status: String,
    val drawBreak: Int,
    val visualDraw: Int,
    val pricePoints: PricePoint,
    val prizeCategories: List<PriceCategory>,
    val wagerStatistics: WagerStatistics
)