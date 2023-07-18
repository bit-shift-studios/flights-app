package bitshift.studios.flightsapp.presentation.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import bitshift.studios.flightsapp.R
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity

@Composable
fun FlightDisplay(
	modifier: Modifier = Modifier,
	padding: PaddingValues,
	flightList: List<AirportEntity>
) {
	LazyColumn(
		modifier = modifier.padding(padding)
	) {
		items(items = flightList, key = { it.id }) { airport ->
			Text(
				text = airport.name,
				modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
			)
		}
	}
}