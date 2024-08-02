package com.sinisavakula.mozzart.di

import com.sinisavakula.mozzart.repositories.HomeRepository
import com.sinisavakula.mozzart.repositories.ResultsRepository
import com.sinisavakula.mozzart.repositories.TalonRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single {
        HomeRepository(
            api = get()
        )
    }
    single {
        ResultsRepository(
            api = get()
        )
    }
    single {
        TalonRepository(
            api = get()
        )
    }
}