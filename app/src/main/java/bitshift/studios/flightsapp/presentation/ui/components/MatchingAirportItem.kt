package bitshift.studios.flightsapp.presentation.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import bitshift.studios.flightsapp.R
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.presentation.ui.theme.Main050
import bitshift.studios.flightsapp.presentation.ui.theme.Main100
import bitshift.studios.flightsapp.presentation.ui.theme.Main250
import bitshift.studios.flightsapp.presentation.ui.theme.SFProDisplay
import bitshift.studios.flightsapp.presentation.ui.utils.DarkRippleTheme
import bitshift.studios.flightsapp.presentation.ui.utils.LightRippleTheme
import java.util.Locale

@Composable
fun MatchingAirportItem(
	modifier: Modifier = Modifier,
	airport: AirportEntity,
	searchQuery: String,
	isDarkTheme: Boolean,
	onAirportItemClicked: (String) -> Unit
) {
	val rippleTheme = if (isDarkTheme) DarkRippleTheme else LightRippleTheme

	CompositionLocalProvider(LocalRippleTheme provides rippleTheme) {
		Row(
			verticalAlignment = Alignment.Top,
			horizontalArrangement = Arrangement.SpaceBetween,
			modifier = modifier
				.fillMaxWidth()
				.defaultMinSize(minHeight = 48.dp)
				.clickable {
					onAirportItemClicked(airport.iataCode)
				}
		) {
			Row(
				verticalAlignment = Alignment.Top,
				horizontalArrangement = Arrangement.spacedBy(16.dp),
				modifier = Modifier
					.weight(5/6f)
					.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
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
						.width(44.dp)
				)

				Text(
					text = airportName,
					maxLines = 1,
					overflow = TextOverflow.Ellipsis,
					color = if (isDarkTheme) Main050 else Main250,
				)
			}

			Icon(
				painter = painterResource(R.drawable.icon_arrow_right),
				contentDescription = stringResource(id = R.string.description_checkout),
				tint = Main100,
				modifier = Modifier
					.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
					.width(40.dp)
					.border(1.dp, Main100, RoundedCornerShape(8.dp))
			)
		}
	}
}