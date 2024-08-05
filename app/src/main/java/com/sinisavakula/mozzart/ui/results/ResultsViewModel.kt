package com.sinisavakula.mozzart.ui.results

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinisavakula.mozzart.model.Result
import com.sinisavakula.mozzart.model.WinningNumbers
import com.sinisavakula.mozzart.model.response.ResultsResponse
import com.sinisavakula.mozzart.repositories.ResultsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

abstract class ResultsViewModel : ViewModel() {
    abstract val results: Flow<List<Result>>
}

class ResultsViewModelImpl(
    val resultsRepository: ResultsRepository,
) : ResultsViewModel() {
    override val results = MutableStateFlow(listOf<Result>())

    init {
        getResults()
    }

    private fun getResults() {
        viewModelScope.launch {
            try {
                val response: ResultsResponse = resultsRepository.getResults()
                results.emit(response.content)
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
            }
        }
    }
}

class ResultsViewModelPreview : ResultsViewModel() {
    override val results: Flow<List<Result>> = flowOf(
        listOf(
            Result(
                drawId = 0,
                drawTime = 0,
                gameId = 0,
                status = "",
                winningNumbers = WinningNumbers(list = (1..20).toList())
            )
        )
    )
}