package com.sinisavakula.mozzart.di

import com.sinisavakula.mozzart.repositories.HomeRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single {
        HomeRepository(
            api = get()
        )
    }
}