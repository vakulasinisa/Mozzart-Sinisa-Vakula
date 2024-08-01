package com.sinisavakula.mozzart.di

import com.sinisavakula.mozzart.ui.home.HomeViewModel
import com.sinisavakula.mozzart.ui.home.HomeViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel<HomeViewModel> {
        HomeViewModelImpl(homeRepository = get())
    }
}