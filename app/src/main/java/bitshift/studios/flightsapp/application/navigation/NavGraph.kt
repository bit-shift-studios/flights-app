package bitshift.studios.flightsapp.application.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import bitshift.studios.flightsapp.application.navigation.routes.Routes
import bitshift.studios.flightsapp.presentation.screens.home.HomeScreen
import bitshift.studios.flightsapp.presentation.screens.home.HomeScreenViewModel

@Composable
fun NavGraph(navHostController: NavHostController) {

	NavHost(navController = navHostController, startDestination = Routes.home) {
		composable(route = Routes.home) {
			val viewModel = hiltViewModel<HomeScreenViewModel>()
			HomeScreen(viewModel = viewModel)
		}
	}
}