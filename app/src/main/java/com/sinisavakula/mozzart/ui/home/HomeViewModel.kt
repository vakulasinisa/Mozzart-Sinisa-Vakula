package com.sinisavakula.mozzart.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinisavakula.mozzart.model.Round
import com.sinisavakula.mozzart.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

abstract class HomeViewModel : ViewModel() {
    abstract val rounds: Flow<List<Round>>
    abstract fun getRounds()
}

class HomeViewModelImpl(
   val homeRepository: HomeRepository,
) : HomeViewModel() {
    override val rounds = MutableStateFlow(listOf<Round>())
    init{
        getRounds()
    }
    override fun getRounds(){
        viewModelScope.launch {
            rounds.emit(listOf())
            try {
                rounds.emit(homeRepository.getNextRounds())
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
            }
        }
    }
}

class HomeViewModelPreview : HomeViewModel() {
    override val rounds: Flow<List<Round>> = flowOf()
    override fun getRounds() {}
}