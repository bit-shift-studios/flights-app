package bitshift.studios.flightsapp.presentation.screens.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bitshift.studios.flightsapp.presentation.ui.components.SearchBar

@Composable
fun HomeScreen(
	modifier: Modifier = Modifier,
	viewModel: HomeScreenViewModel
) {
	val uiState = viewModel.uiState.collectAsState().value
	val isDarkTheme = isSystemInDarkTheme()

	Scaffold(
		topBar = {
			SearchBar(isDarkTheme = isDarkTheme)
		},
	) { padding ->
		Column(modifier = modifier
			.padding(padding)
			.padding(horizontal = 16.dp)) {
			Text(text = "Home Screen")
		}
	}
}