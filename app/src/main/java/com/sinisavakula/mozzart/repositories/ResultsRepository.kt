package com.sinisavakula.mozzart.repositories

import com.sinisavakula.mozzart.api.Api
import com.sinisavakula.mozzart.misc.formatDateForApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ResultsRepository(
    private val api: Api
) {
    suspend fun getResults() = withContext(Dispatchers.IO) {
        val formattedDate = formatDateForApi()
        api.getResults(formattedDate, formattedDate)
    }
}