package bitshift.studios.flightsapp.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import bitshift.studios.flightsapp.R
import bitshift.studios.flightsapp.presentation.ui.theme.FlightsAppTheme
import bitshift.studios.flightsapp.presentation.ui.theme.Main050
import bitshift.studios.flightsapp.presentation.ui.theme.Main100
import bitshift.studios.flightsapp.presentation.ui.theme.Main250

@Composable
fun SearchBar(
	modifier: Modifier = Modifier,
	isDarkTheme: Boolean,
	searchQuery: String,
	onSearchQueryChange: (String) -> Unit
) {
	val (containerColor, textColor) = when (isDarkTheme) {
		true -> Main250 to Main050
		else -> Main050 to Main250
	}


	OutlinedTextField(
		value = searchQuery,
		onValueChange = onSearchQueryChange,
		singleLine = true,
		textStyle = MaterialTheme.typography.bodyLarge,
		leadingIcon = {
			Icon(
				painter = painterResource(id = R.drawable.icon_search),
				contentDescription = stringResource(id = R.string.description_search),
				tint = Main100
			)
		},
		placeholder = {
			Text(
				text = stringResource(id = R.string.search_flights),
				color = if (isDarkTheme) Main050.copy(alpha = 0.7F) else Main250.copy(alpha = 0.7F)
			)
		},
		shape = RoundedCornerShape(dimensionResource(id = R.dimen.size_xsmall)),
		colors = TextFieldDefaults.outlinedTextFieldColors(
			containerColor = containerColor,
			unfocusedBorderColor = containerColor,
			focusedBorderColor = containerColor,
			textColor = textColor
		),
		modifier = modifier
			.fillMaxWidth()
			.padding(dimensionResource(id = R.dimen.padding_medium))
	)
}

@Preview(
	showBackground = true,
	backgroundColor = 0xFFF3F9FC
)
@Composable
fun SearchBarLightPreview() {
	FlightsAppTheme {
		SearchBar(
			isDarkTheme = false,
			searchQuery = "",
			onSearchQueryChange = {  }
		)
	}
}

@Preview(
	showBackground = true,
	backgroundColor = 0xFF09121A
)
@Composable
fun SearchBarDarkPreview() {
	FlightsAppTheme {
		SearchBar(
			isDarkTheme = true,
			searchQuery = "",
			onSearchQueryChange = {  }
		)
	}
}
