package com.sinisavakula.mozzart.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sinisavakula.mozzart.ui.common.WebViewScreen
import com.sinisavakula.mozzart.ui.results.Results
import com.sinisavakula.mozzart.ui.results.ResultsViewModel
import com.sinisavakula.mozzart.ui.results.ResultsViewModelPreview
import com.sinisavakula.mozzart.ui.round.RoundItem
import com.sinisavakula.mozzart.ui.theme.MozzartSinisaVakulaTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val HOME = "home"
private const val RESULTS = "results"
private const val DRAW = "draw"

@Composable
fun Home(
    viewModel: HomeViewModel,
    resultsViewModel: ResultsViewModel,
    navigateToRound: (Int?) -> Unit
) {

    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val selectedIndex = remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(selectedIndex.value) { newIndex ->
                selectedIndex.value = newIndex
                when (newIndex) {
                    0 -> navController.navigate(HOME)
                    1 -> navController.navigate(RESULTS)
                    2 -> {
                        navController.navigate(DRAW)
                        coroutineScope.launch {
                            delay(1000)
                            selectedIndex.value = 0
                            navController.navigate(HOME)
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HOME,
            Modifier.padding(innerPadding)
        ) {
            composable("home") {
                val rounds by viewModel.rounds.collectAsState(initial = listOf())
                Column(
                    modifier = Modifier
                        .background(Color.Black)
                ) {
                    HomeToolbar()
                    LazyColumn {
                        items(rounds) { round ->
                            RoundItem(round = round, onClick = { navigateToRound(round.drawId) })
                        }
                    }
                }
            }
            composable(RESULTS) {
                Results(viewModel = resultsViewModel)
            }
            composable(DRAW) {
                WebViewScreen(url = "https://mozzartbet.com/sr/lotto-animation/26#")
            }
        }
    }

}

@Preview
@Composable
fun HomePreview() {
    MozzartSinisaVakulaTheme {
        Home(
            viewModel = HomeViewModelPreview(),
            resultsViewModel = ResultsViewModelPreview(),
            navigateToRound = {}
        )
    }
}