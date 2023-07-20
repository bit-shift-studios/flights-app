package bitshift.studios.flightsapp.presentation.screens.flights

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import bitshift.studios.flightsapp.presentation.ui.components.FlightDisplay
import bitshift.studios.flightsapp.presentation.ui.components.FlightScreenAppBar
import bitshift.studios.flightsapp.presentation.ui.components.Loading

@Composable
fun FlightsScreen(
	viewModel: FlightScreenViewModel,
	onBackButtonClicked: () -> Unit
) {
	val uiState = viewModel.flightScreenUIState.collectAsState().value
	val isLoading = uiState.isLoading
	val flightList = uiState.flightList
	val isDarkTheme = isSystemInDarkTheme()

	Scaffold(
		topBar = {
			FlightScreenAppBar(
				isDarkTheme = isDarkTheme,
				flightCode = uiState.flightCode,
				onBackButtonClicked = onBackButtonClicked
			)
		}
	) { padding ->
		if (isLoading) {
			Loading()
			LaunchedEffect(Unit) { viewModel.updateFlightList() }
		} else {
			FlightDisplay(
				padding = padding,
				flightList = flightList
			)
		}
	}
}