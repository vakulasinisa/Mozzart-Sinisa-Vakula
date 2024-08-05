package com.sinisavakula.mozzart.ui.results

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinisavakula.mozzart.ui.theme.MozzartSinisaVakulaTheme

@Composable
fun Results(
    viewModel: ResultsViewModel
) {
    val results by viewModel.results.collectAsState(initial = listOf())
    LazyColumn(modifier = Modifier.background(Color.Black).fillMaxSize().padding(vertical = 20.dp)) {
        items(results) { result ->
            ResultItem(result)
        }
    }
    if (results.isEmpty()) {
            Box(modifier = Modifier
                .background(Color.Black)
                .fillMaxSize())
    }

}

@Preview
@Composable
fun ResultsPreview() {
    MozzartSinisaVakulaTheme {
        Results(viewModel = ResultsViewModelPreview())
    }
}