package com.sinisavakula.mozzart.di

import com.sinisavakula.mozzart.ui.home.HomeViewModel
import com.sinisavakula.mozzart.ui.home.HomeViewModelImpl
import com.sinisavakula.mozzart.ui.results.ResultsViewModel
import com.sinisavakula.mozzart.ui.results.ResultsViewModelImpl
import com.sinisavakula.mozzart.ui.round.RoundViewModel
import com.sinisavakula.mozzart.ui.round.RoundViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {

    viewModel<HomeViewModel> {
        HomeViewModelImpl(homeRepository = get())
    }

    viewModel<ResultsViewModel> {
        ResultsViewModelImpl(resultsRepository = get())
    }

    viewModel<RoundViewModel> {params ->
        RoundViewModelImpl(
            drawId = params[0],
            talonRepository = get()
        )
    }
}