package bitshift.studios.flightsapp.presentation.ui.utils

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object DarkRippleTheme : RippleTheme {
	@Composable
	override fun defaultColor(): Color = Color(0xFF4A5B6B)

	@Composable
	override fun rippleAlpha(): RippleAlpha = RippleAlpha(
		hoveredAlpha = 0.4f,
		focusedAlpha = 0.4f,
		draggedAlpha = 0.4f,
		pressedAlpha = 0.4f
	)
}

object LightRippleTheme : RippleTheme {
	@Composable
	override fun defaultColor(): Color = Color(0xFFB8CAD5)

	@Composable
	override fun rippleAlpha(): RippleAlpha = RippleAlpha(
		hoveredAlpha = 0.4f,
		focusedAlpha = 0.4f,
		draggedAlpha = 0.4f,
		pressedAlpha = 0.4f
	)
}