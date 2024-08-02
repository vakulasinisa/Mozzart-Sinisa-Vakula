package com.sinisavakula.mozzart.api

import com.sinisavakula.mozzart.model.Round
import com.sinisavakula.mozzart.model.response.ResultsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("1100/upcoming/20")
    suspend fun getNextRounds(): List<Round>

    @GET("1100/{drawId}")
    suspend fun getRound(@Path("drawId") drawId: Int): Round

    @GET("1100/draw-date/{fromDate}/{toDate}")
    suspend fun getResults(@Path("fromDate") fromDate: String, @Path("toDate") toDate: String): ResultsResponse
}