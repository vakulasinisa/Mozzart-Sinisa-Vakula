package com.sinisavakula.mozzart.model.response

import com.sinisavakula.mozzart.model.Result
import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
data class ResultsResponse(
    val content: List<Result>
)