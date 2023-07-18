package bitshift.studios.flightsapp.presentation.screens.flights

import androidx.lifecycle.ViewModel
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.domain.usecases.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FlightScreenViewModel @Inject constructor(
	private val appUseCases: AppUseCases,
) : ViewModel() {
	data class FlightScreenUIState(
		val flightList: List<AirportEntity> = emptyList(),
		val flightCode: String = ""
	)

	private val _flightScreenUIState: MutableStateFlow<FlightScreenUIState> = MutableStateFlow(
		FlightScreenUIState()
	)

	val flightScreenUIState: StateFlow<FlightScreenUIState> = _flightScreenUIState.asStateFlow()

	fun updateFlightList(code: String) {
		_flightScreenUIState.update { state ->
			val flightList = appUseCases.getFlightsFromAirport(code)

			state.copy(
				flightList = flightList,
				flightCode = code
			)
		}
	}
}