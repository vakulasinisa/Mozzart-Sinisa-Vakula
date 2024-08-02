package com.sinisavakula.mozzart.ui.results

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.sinisavakula.mozzart.ui.theme.MozzartSinisaVakulaTheme

@Composable
fun Results(
    viewModel: ResultsViewModel
) {
    val results by viewModel.results.collectAsState(initial = listOf())
    LazyColumn {
        items(results) { result ->
            ResultItem(result)
        }
    }
}

@Preview
@Composable
fun ResultsPreview() {
    MozzartSinisaVakulaTheme {
        Results(viewModel = ResultsViewModelPreview())
    }
}