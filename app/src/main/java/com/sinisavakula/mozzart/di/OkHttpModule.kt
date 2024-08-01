package com.sinisavakula.mozzart.di

import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

val OkHttpModule = module {
    single(named("public")) {
        OkHttpClient.Builder()
            .build()
    }
}