package com.sinisavakula.mozzart.api

import com.sinisavakula.mozzart.model.Round
import retrofit2.http.GET

interface Api {
    @GET("1100/upcoming/20")
    suspend fun getNextRounds(): List<Round>
}