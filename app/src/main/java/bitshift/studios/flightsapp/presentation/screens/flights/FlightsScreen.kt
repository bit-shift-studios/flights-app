package bitshift.studios.flightsapp.presentation.screens.flights

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import bitshift.studios.flightsapp.R

@Composable
fun FlightsScreen(
	modifier: Modifier = Modifier,
	viewModel: FlightScreenViewModel
) {
	val uiState = viewModel.flightScreenUIState.collectAsState().value
	val flightList = uiState.flightList

	Scaffold { padding ->
		LazyColumn(
			modifier = modifier
				.padding(padding)
				.padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
		) {
			items(items = flightList, key = { it.id }) { airport ->
				Text(text = airport.name)
			}
		}
	}
}