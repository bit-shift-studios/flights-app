package bitshift.studios.flightsapp.presentation.screens.home.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import bitshift.studios.flightsapp.data.db.bookmarked.entities.BookmarkedFlightEntity

@Composable
fun BookmarkedFlightsList(
	modifier: Modifier = Modifier,
	flights: List<BookmarkedFlightEntity>
) {
	LazyColumn {
		items(items = flights, key = { it.id }) { flight ->
			Text(text = "${flight.departureCode} to ${flight.destinationCode}")
		}
	}
}