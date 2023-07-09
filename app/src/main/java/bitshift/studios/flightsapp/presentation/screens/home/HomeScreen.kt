package bitshift.studios.flightsapp.presentation.screens.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import bitshift.studios.flightsapp.R
import bitshift.studios.flightsapp.presentation.ui.components.MatchingAirportItem
import bitshift.studios.flightsapp.presentation.ui.components.SearchBar
import bitshift.studios.flightsapp.presentation.ui.theme.Main050
import bitshift.studios.flightsapp.presentation.ui.theme.Main300
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
	modifier: Modifier = Modifier,
	viewModel: HomeScreenViewModel
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
		LazyColumn(
			modifier = modifier
				.fillMaxWidth()
				.padding(padding)
				.padding(horizontal = 16.dp),
			verticalArrangement = Arrangement.spacedBy(24.dp)
		) {
			item {
				Text(
					text = stringResource(id = R.string.matches),
					style = MaterialTheme.typography.labelLarge,
					color = if (isDarkTheme) Main050 else Main300,
					modifier = Modifier
						.padding(vertical = 8.dp)
				)
			}

			items(items = searchResults) { airport ->
				MatchingAirportItem(
					airport = airport,
					searchQuery = uiState.searchQuery,
					isDarkTheme = isDarkTheme
				)
			}
		}
	}
}
