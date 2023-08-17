package bitshift.studios.flightsapp.presentation.screens.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import bitshift.studios.flightsapp.presentation.screens.home.components.BookmarkedFlightDisplay
import bitshift.studios.flightsapp.presentation.screens.home.components.FlightSearch
import bitshift.studios.flightsapp.presentation.screens.home.viewmodels.HomeScreenViewModel
import bitshift.studios.flightsapp.presentation.ui.core.SearchBar
import bitshift.studios.flightsapp.presentation.ui.theme.Main300
import bitshift.studios.flightsapp.presentation.ui.theme.Neutral050

@Composable
fun HomeScreen(
	viewModel: HomeScreenViewModel,
	onAirportItemClicked: (String) -> Unit
) {
	val uiState by viewModel.uiState.collectAsState()
	val flights = viewModel.getBookmarkedFlights().collectAsState(initial = emptyList()).value
	val isLoading = uiState.isLoading
	val searchResults = uiState.searchResults
	val isDarkTheme = isSystemInDarkTheme()

	Scaffold(
		topBar = {
			SearchBar(
				isDarkTheme = isDarkTheme,
				searchQuery = uiState.searchQuery,
				onSearchQueryChange = { viewModel.updateSearchQuery(it) }
			)
		},
		containerColor = if (isDarkTheme) Main300 else Neutral050
	) { padding ->
		if (uiState.searchQuery.isNotEmpty()) {
			FlightSearch(
				padding = padding,
				isDarkTheme = isDarkTheme,
				isLoading = isLoading,
				searchResults = searchResults,
				searchQuery = uiState.searchQuery,
				onAirportItemClicked = {
					onAirportItemClicked(it)
				}
			)
		} else {
			BookmarkedFlightDisplay(
				padding = padding,
				isDarkTheme = isDarkTheme,
				flights = flights
			)
		}
	}
}
