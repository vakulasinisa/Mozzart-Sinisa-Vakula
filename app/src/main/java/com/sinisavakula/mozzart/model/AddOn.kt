package com.sinisavakula.mozzart.model

import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
data class AddOn(
    val amount: Double,
    val gameType: String
)