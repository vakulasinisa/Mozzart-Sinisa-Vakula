package com.sinisavakula.mozzart.repositories

import com.sinisavakula.mozzart.api.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TalonRepository(
    private val api: Api
) {
    suspend fun getRound(drawId: Int) = withContext(Dispatchers.IO) {
        api.getRound(drawId)
    }
}