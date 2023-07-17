package bitshift.studios.flightsapp.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bitshift.studios.flightsapp.R
import bitshift.studios.flightsapp.presentation.ui.theme.Main050
import bitshift.studios.flightsapp.presentation.ui.theme.Main300
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun NoResultsAnim(
	modifier: Modifier = Modifier,
	isDarkTheme: Boolean
) {
	val resource = if (isDarkTheme) R.raw.flights_dark else R.raw.flights_light
	val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(resource))

	LazyColumn(
		modifier = modifier.fillMaxSize(),
	) {
		item {
			LottieAnimation(
				composition,
				iterations = Int.MAX_VALUE,
				modifier = Modifier.size(512.dp),
				alignment = Alignment.Center
			)

			Text(
				text = stringResource(id = R.string.no_matches),
				style = MaterialTheme.typography.bodyLarge,
				color = if (isDarkTheme) Main050 else Main300,
				textAlign = TextAlign.Center,
				fontSize = 40.sp,
				lineHeight = 48.sp,
				modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 18.dp)
			)

			Text(
				text = stringResource(id = R.string.no_matches_description),
				style = MaterialTheme.typography.bodyLarge,
				color = if (isDarkTheme) Main050 else Main300,
				modifier = Modifier.padding(horizontal = 16.dp)
			)
		}
	}
}