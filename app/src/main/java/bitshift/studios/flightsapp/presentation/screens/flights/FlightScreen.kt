package bitshift.studios.flightsapp.presentation.screens.flights

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import bitshift.studios.flightsapp.presentation.ui.components.FlightDisplay
import bitshift.studios.flightsapp.presentation.ui.components.FlightScreenAppBar

@Composable
fun FlightsScreen(
	viewModel: FlightScreenViewModel,
	onBackButtonClicked: () -> Unit
) {
	val uiState = viewModel.flightScreenUIState.collectAsState().value
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
			FlightDisplay(
				padding = padding,
				flightList = flightList
			)
	}
}