package bitshift.studios.flightsapp.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import bitshift.studios.flightsapp.R
import bitshift.studios.flightsapp.presentation.ui.theme.Main050
import bitshift.studios.flightsapp.presentation.ui.theme.Main100
import bitshift.studios.flightsapp.presentation.ui.theme.Main250
import bitshift.studios.flightsapp.presentation.ui.theme.Main300
import bitshift.studios.flightsapp.presentation.ui.theme.Neutral050

@Composable
fun FlightDestinationItem(
	modifier: Modifier = Modifier,
	number: Int,
	name: String,
	isDarkTheme: Boolean,
	isBookmarked: Boolean
) {
	Row(
		modifier = modifier
			.fillMaxWidth()
			.padding(horizontal = dimensionResource(id = R.dimen.size_16)),
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.Top
	) {
		Row(
			horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.size_12)),
			verticalAlignment = Alignment.Top,
			modifier = modifier.weight(5/6f)
		) {
			Text(
				text = number.toString(),
				style = MaterialTheme.typography.displayLarge,
				color = Main100,
				fontWeight = FontWeight.Bold
			)
			Text(
				text = name,
				style = MaterialTheme.typography.displayLarge,
				color = if (isDarkTheme) Neutral050 else Main300
			)
		}
		
		IconButton(
			onClick = { /*TODO*/ },
			modifier = modifier
				.padding(start = dimensionResource(id = R.dimen.size_24))
				.size(dimensionResource(id = R.dimen.size_24))
		) {
			val iconResID = if (isBookmarked) R.drawable.icon_bookmark_check else R.drawable.icon_bookmark_add
			Icon(
				painter = painterResource(id = iconResID), 
				contentDescription = stringResource(id = R.string.description_bookmark_airport),
				tint = when (isBookmarked) {
					true -> Main100
					false -> if (isDarkTheme) Main050 else Main250
				}
			)
		}
	}
}