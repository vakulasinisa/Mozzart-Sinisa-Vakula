package com.sinisavakula.mozzart.model

import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
data class Result(
    val gameId: Int,
    val drawId: Long,
    val drawTime: Long,
    val status: String,
    val winningNumbers: WinningNumbers
)