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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bitshift.studios.flightsapp.R
import bitshift.studios.flightsapp.presentation.ui.theme.FlightsAppTheme
import bitshift.studios.flightsapp.presentation.ui.theme.Main050
import bitshift.studios.flightsapp.presentation.ui.theme.Main100
import bitshift.studios.flightsapp.presentation.ui.theme.Main250
import bitshift.studios.flightsapp.presentation.ui.theme.Neutral050

@Composable
fun SearchBar(
	modifier: Modifier = Modifier,
	isDarkTheme: Boolean,
	searchQuery: String,
	onSearchQueryChange: (String) -> Unit
) {
	val containerColor = when(isDarkTheme) {
		true -> Main250
		else -> Main050
	}

	OutlinedTextField(
		value = searchQuery,
		onValueChange = onSearchQueryChange,
		singleLine = true,
		textStyle = MaterialTheme.typography.bodyLarge,
		leadingIcon = {
			Icon(
				painter = painterResource(id = R.drawable.icon_search),
				contentDescription = "search",
				tint = Main100
			)
		},
		placeholder = {
			Text(
				text = "Search flights",
				color = if (isDarkTheme) Main050.copy(alpha = 0.5F) else Main250.copy(alpha = 0.7F)
			)
		},
		shape = RoundedCornerShape(16.dp),
		colors = TextFieldDefaults.outlinedTextFieldColors(
			containerColor = containerColor,
			unfocusedBorderColor = containerColor,
			focusedBorderColor = containerColor,
			textColor = Neutral050
		),
		modifier = modifier
			.fillMaxWidth()
			.padding(16.dp)
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
