package bitshift.studios.flightsapp.application.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import bitshift.studios.flightsapp.application.navigation.routes.Routes
import bitshift.studios.flightsapp.presentation.screens.home.HomeScreen

@Composable
fun NavGraph(navHostController: NavHostController) {

	NavHost(navController = navHostController, startDestination = Routes.home) {
		composable(route = Routes.home) {
			HomeScreen()
		}
	}
}