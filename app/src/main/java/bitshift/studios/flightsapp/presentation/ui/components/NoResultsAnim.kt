package bitshift.studios.flightsapp.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bitshift.studios.flightsapp.R
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

	Column(
		modifier = modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center
	) {
		LottieAnimation(
			composition,
			iterations = Int.MAX_VALUE,
			modifier = Modifier.size(764.dp)
		)
	}
}