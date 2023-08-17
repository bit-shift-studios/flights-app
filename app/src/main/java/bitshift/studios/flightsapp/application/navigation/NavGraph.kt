package bitshift.studios.flightsapp.application.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import bitshift.studios.flightsapp.application.navigation.routes.Routes
import bitshift.studios.flightsapp.presentation.screens.flights.FlightsScreen
import bitshift.studios.flightsapp.presentation.screens.flights.viewmodels.FlightScreenViewModel
import bitshift.studios.flightsapp.presentation.screens.home.HomeScreen
import bitshift.studios.flightsapp.presentation.screens.home.viewmodels.HomeScreenViewModel

@Composable
fun NavGraph(navHostController: NavHostController) {

	NavHost(navController = navHostController, startDestination = Routes.home) {
		composable(route = Routes.home) {
			val viewModel = hiltViewModel<HomeScreenViewModel>()

			HomeScreen(
				viewModel = viewModel,
				onAirportItemClicked = { code ->
					viewModel.clearSearchQuery()
					navHostController.navigate(Routes.flights.plus("/$code"))
				}
			)
		}
		
		composable(route = Routes.flights.plus("/{code}")) { backStackEntry ->
			val flightCode = backStackEntry.arguments?.getString("code")!!
			val viewModel = hiltViewModel<FlightScreenViewModel>()

			viewModel.updateFlightCode(flightCode)

			FlightsScreen(
				viewModel = viewModel,
				onBackButtonClicked = {
					navHostController.popBackStack()
				},
				onBookmarkedFlight = {
					navHostController.navigate(Routes.home)
				}
			)
		}
	}
}