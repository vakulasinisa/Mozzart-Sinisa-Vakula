package com.sinisavakula.mozzart.model

import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
data class PricePoint(
    val addOn: List<AddOn>,
    val amount: Double
)