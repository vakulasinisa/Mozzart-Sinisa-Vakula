package com.sinisavakula.mozzart.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sinisavakula.mozzart.ui.home.Home
import org.koin.androidx.compose.getViewModel

private const val ROUTE_HOME = "home"

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ROUTE_HOME) {
        composable(ROUTE_HOME) {
            Home(
                viewModel = getViewModel()
            )
        }
    }
}