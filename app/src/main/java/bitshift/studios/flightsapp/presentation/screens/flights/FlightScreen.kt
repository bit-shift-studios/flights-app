package bitshift.studios.flightsapp.presentation.screens.flights

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.presentation.ui.components.FlightDisplay
import bitshift.studios.flightsapp.presentation.ui.components.FlightScreenAppBar
import bitshift.studios.flightsapp.presentation.ui.components.Loading
import bitshift.studios.flightsapp.presentation.ui.theme.Main300
import bitshift.studios.flightsapp.presentation.ui.theme.Neutral050

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
		},
		containerColor = if (isDarkTheme) Main300 else Neutral050
	) { padding ->
		if (isLoading) {
			Loading()
			LaunchedEffect(Unit) { viewModel.updateFlightList() }
		} else {
			FlightDisplay(
				padding = padding,
				flightList = flightList,
				isDarkTheme = isDarkTheme,
				bookmarkFlight = { airportEntity: AirportEntity ->
					viewModel.bookmarkFlight(airportEntity, uiState.flightCode)
				}
			)
		}
	}
}