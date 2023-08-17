package bitshift.studios.flightsapp.presentation.screens.flights.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import bitshift.studios.flightsapp.R
import bitshift.studios.flightsapp.presentation.ui.theme.Main050
import bitshift.studios.flightsapp.presentation.ui.theme.Main100
import bitshift.studios.flightsapp.presentation.ui.theme.Main250
import bitshift.studios.flightsapp.presentation.ui.theme.Main300
import bitshift.studios.flightsapp.presentation.ui.theme.Neutral050

@Composable
fun FlightScreenAppBar(
	modifier: Modifier = Modifier,
	isDarkTheme: Boolean,
	flightCode: String,
	onBackButtonClicked: () -> Unit
) {
	Row(
		modifier = modifier
			.padding(bottom = dimensionResource(id = R.dimen.size_16))
			.background(
				color = if (isDarkTheme) Main300 else Main050
			)
			.fillMaxWidth(),
		horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
		verticalAlignment = Alignment.CenterVertically
	) {
		IconButton(
			onClick = onBackButtonClicked,
			modifier = modifier
				.padding(
					start = dimensionResource(id = R.dimen.size_8),
					top = dimensionResource(id = R.dimen.size_8),
					bottom = dimensionResource(id = R.dimen.size_8)
				)
		) {
			Icon(
				painter = painterResource(id = R.drawable.icon_arrow_left),
				contentDescription = "back",
				modifier = modifier.size(dimensionResource(id = R.dimen.size_24)),
				tint = if (isDarkTheme) Neutral050 else Main250
			)
		}
		
		Row(
			modifier = modifier.padding(vertical = dimensionResource(id = R.dimen.size_8))
		) {
			Text(
				text = stringResource(id = R.string.flights_from),
				style = MaterialTheme.typography.labelLarge,
				color = if (isDarkTheme) Main050 else Main300,
				modifier = modifier.padding(end = 4.dp)
			)

			Text(
				text = flightCode,
				style = MaterialTheme.typography.labelLarge,
				color = Main100
			)
		}
	}
}