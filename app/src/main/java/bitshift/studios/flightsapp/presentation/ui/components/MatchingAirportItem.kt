package bitshift.studios.flightsapp.presentation.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import bitshift.studios.flightsapp.R
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.presentation.ui.theme.Main050
import bitshift.studios.flightsapp.presentation.ui.theme.Main100
import bitshift.studios.flightsapp.presentation.ui.theme.Main250
import bitshift.studios.flightsapp.presentation.ui.theme.SFProDisplay
import java.util.Locale

@Composable
fun MatchingAirportItem(
	modifier: Modifier = Modifier,
	airport: AirportEntity,
	searchQuery: String,
	isDarkTheme: Boolean
) {
	Row(
		verticalAlignment = Alignment.Top,
		horizontalArrangement = Arrangement.SpaceBetween,
		modifier = modifier
			.fillMaxWidth()
	) {
		Row(
			verticalAlignment = Alignment.Top,
			horizontalArrangement = Arrangement.spacedBy(16.dp),
			modifier = Modifier
				.weight(5/6f)
		) {

			val lowercaseFullText = airport.name.lowercase(Locale.getDefault())
			val lowercaseSearchQuery = searchQuery.lowercase(Locale.getDefault())

			val airportName = buildAnnotatedString {
				val startIndex = lowercaseFullText.indexOf(lowercaseSearchQuery)
				val endIndex = startIndex + lowercaseSearchQuery.length

				append(airport.name)

				if (startIndex != -1) {
					addStyle(
						style = SpanStyle(
							fontFamily = SFProDisplay,
							fontWeight = FontWeight.Bold
						),
						start = startIndex,
						end = endIndex
					)
				}
			}

			Text(
				text = airport.iataCode,
				color = Main100,
				style = MaterialTheme.typography.labelMedium,
				modifier = Modifier
					.width(50.dp)
			)

			Text(
				text = airportName,
				color = if (isDarkTheme) Main050 else Main250,
			)
		}

		Icon(
			painter = painterResource(R.drawable.icon_arrow_right),
			contentDescription = stringResource(id = R.string.description_checkout),
			tint = Main100,
			modifier = Modifier
				.padding(start = 16.dp)
				.width(40.dp)
				.border(1.dp, Main100, RoundedCornerShape(8.dp))
		)
	}
}