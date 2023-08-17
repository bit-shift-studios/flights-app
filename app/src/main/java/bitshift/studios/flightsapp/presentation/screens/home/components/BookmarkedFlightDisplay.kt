package bitshift.studios.flightsapp.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import bitshift.studios.flightsapp.data.db.bookmarked.entities.BookmarkedFlightEntity
import bitshift.studios.flightsapp.presentation.ui.theme.Main300
import bitshift.studios.flightsapp.presentation.ui.theme.Neutral050

@Composable
fun BookmarkedFlightDisplay(
	modifier: Modifier = Modifier,
	padding: PaddingValues,
	isDarkTheme: Boolean,
	flights: List<BookmarkedFlightEntity>
) {
	Box(
		modifier = modifier
			.fillMaxWidth()
			.padding(padding)
			.background(if (isDarkTheme) Main300 else Neutral050)
	) {
		BookmarkedFlightsList(flights = flights)
	}
}