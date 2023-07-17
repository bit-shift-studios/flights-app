package bitshift.studios.flightsapp.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import bitshift.studios.flightsapp.R
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.presentation.ui.theme.Main050
import bitshift.studios.flightsapp.presentation.ui.theme.Main300

@Composable
fun FlightSearch(
	modifier: Modifier = Modifier,
	padding: PaddingValues,
	isDarkTheme: Boolean,
	searchResults: List<AirportEntity>,
	searchQuery: String,
	onAirportItemClicked: (String) -> Unit
) {
	Box(
		modifier = modifier
			.fillMaxWidth()
			.padding(padding)
	) {
		Text(
			text = stringResource(id = R.string.matches),
			style = MaterialTheme.typography.labelLarge,
			color = if (isDarkTheme) Main050 else Main300,
			modifier = Modifier
				.padding(vertical = 8.dp, horizontal = 16.dp)
		)

		if (searchResults.isEmpty()) {
			NoResultsAnim(isDarkTheme = isDarkTheme)
		} else {
			LazyColumn(
				modifier = modifier
					.fillMaxWidth()
					.padding(top = 56.dp)
			) {
				items(items = searchResults, key = { it.id }) { airport ->
					MatchingAirportItem(
						airport = airport,
						searchQuery = searchQuery,
						isDarkTheme = isDarkTheme,
						onAirportItemClicked = { onAirportItemClicked(it) }
					)
				}
			}
		}
	}
}