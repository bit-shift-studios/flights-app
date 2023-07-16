package bitshift.studios.flightsapp.presentation.screens.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.presentation.ui.components.FlightSearch
import bitshift.studios.flightsapp.presentation.ui.components.SearchBar
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
	viewModel: HomeScreenViewModel,
	onAirportItemClicked: (String) -> Unit
) {
	val uiState = viewModel.uiState.collectAsState().value
	val searchResults by uiState.searchResults.collectAsState(emptyList())
	val coroutineScope = rememberCoroutineScope()
	val isDarkTheme = isSystemInDarkTheme()

	Scaffold(
		topBar = {
			SearchBar(
				isDarkTheme = isDarkTheme,
				searchQuery = uiState.searchQuery,
				onSearchQueryChange = {
					coroutineScope.launch { viewModel.updateSearchQuery(it) }
				}
			)
		},
	) { padding ->
		FlightSearch(
			padding = padding,
			isDarkTheme = isDarkTheme,
			searchResults = searchResults,
			searchQuery = uiState.searchQuery,
			onAirportItemClicked = {
				onAirportItemClicked(it)
			}
		)
	}
}
