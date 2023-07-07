package bitshift.studios.flightsapp.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import bitshift.studios.flightsapp.R

val SFProDisplay = FontFamily(
	Font(
		resId = R.font.sf_pro_display_bold,
		weight = FontWeight.Bold
	),

	Font(
		resId = R.font.sf_pro_display_regular,
		weight = FontWeight.Normal
	)
)

val Typography = Typography(
	labelSmall = TextStyle(
		fontFamily = SFProDisplay,
		fontWeight = FontWeight.Bold,
		fontSize = 12.sp,
		lineHeight = 14.sp,
		letterSpacing = 0.5.sp
	),

	bodyMedium = TextStyle(
		fontFamily = SFProDisplay,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp,
		lineHeight = 24.sp,
		letterSpacing = 0.5.sp
	),

	bodyLarge = TextStyle(
		fontFamily = SFProDisplay,
		fontWeight = FontWeight.Normal,
		fontSize = 18.sp,
		lineHeight = 24.sp,
		letterSpacing = 0.5.sp
	)
)