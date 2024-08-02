package com.sinisavakula.mozzart.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sinisavakula.mozzart.ui.home.Home
import com.sinisavakula.mozzart.ui.round.RoundScreen
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

private const val ROUTE_HOME = "home"
const val ROUTE_ROUND = "round/{drawId}"

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    val navigateBack: () -> Unit = {
        navController.navigateUp()
    }
    NavHost(navController = navController, startDestination = ROUTE_HOME) {
        composable(ROUTE_HOME) {
            Home(
                viewModel = getViewModel(),
                resultsViewModel = getViewModel(),
                navigateToRound = { drawId ->
                    navController.navigate("round/$drawId")
                }
            )
        }
        composable(ROUTE_ROUND) { backStackEntry ->
            val drawId = backStackEntry.arguments?.getString("drawId")?.toIntOrNull()
            if (drawId != null) {
                RoundScreen(
                    viewModel = getViewModel { parametersOf(drawId) },
                    navigateBack = navigateBack)
            }
        }
    }
}