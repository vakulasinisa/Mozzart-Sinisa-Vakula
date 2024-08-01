package com.sinisavakula.mozzart.repositories

import com.sinisavakula.mozzart.api.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeRepository(
    private val api: Api
) {
    suspend fun getNextRounds() = withContext(Dispatchers.IO) {
        api.getNextRounds()
    }
}