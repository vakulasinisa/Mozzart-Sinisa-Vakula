package com.sinisavakula.mozzart.model

import kotlinx.serialization.Serializable

@Serializable
data class WagerStatistics(
    val columns: Int,
    val wagers: Int,
    val addOn: List<AddOn>
)