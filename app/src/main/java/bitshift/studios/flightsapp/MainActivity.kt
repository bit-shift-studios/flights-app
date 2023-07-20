package bitshift.studios.flightsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import bitshift.studios.flightsapp.application.navigation.NavGraph
import bitshift.studios.flightsapp.presentation.ui.theme.FlightsAppTheme
import bitshift.studios.flightsapp.presentation.ui.theme.Main300
import bitshift.studios.flightsapp.presentation.ui.theme.Neutral050
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		installSplashScreen()
		super.onCreate(savedInstanceState)
		setContent {
			FlightsAppTheme {
				Surface(color = if (isSystemInDarkTheme()) Main300 else Neutral050) {
					val navHostController = rememberNavController()
					NavGraph(navHostController)
				}
			}
		}
	}
}
