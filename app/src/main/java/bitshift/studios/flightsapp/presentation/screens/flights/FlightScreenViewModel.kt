package bitshift.studios.flightsapp.presentation.screens.flights

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.domain.mappers.AirportToBookmarkedFlightMapper
import bitshift.studios.flightsapp.domain.usecases.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class FlightScreenUIState(
	val isLoading: Boolean = true,
	val flightCode: String = "",
	val flightList: List<AirportEntity> = emptyList(),
)

@HiltViewModel
class FlightScreenViewModel @Inject constructor(private val appUseCases: AppUseCases) : ViewModel() {

	private val _flightScreenUIState: MutableStateFlow<FlightScreenUIState> = MutableStateFlow(FlightScreenUIState())
	val flightScreenUIState: StateFlow<FlightScreenUIState> = _flightScreenUIState.asStateFlow()

	private val flightMapper = AirportToBookmarkedFlightMapper

	fun updateFlightCode(code: String) {
		_flightScreenUIState.update { state ->
			state.copy(flightCode = code)
		}
	}

	fun updateFlightList() {
		viewModelScope.launch {
			val code = _flightScreenUIState.value.flightCode

			_flightScreenUIState.update { state ->
				state.copy(
					isLoading = true
				)
			}

			delay(500)

			_flightScreenUIState.update { state ->
				state.copy(
					isLoading = false,
					flightList = appUseCases.getFlightsFromAirport(code)
				)
			}
		}
	}

	fun bookmarkFlight(airport: AirportEntity, destinationCode: String) {
		val bookmarkedFlight = flightMapper.mapAirportToBookmarkedFlight(airport, destinationCode)

		Log.d("BOOKMARKED", bookmarkedFlight.toString())

		viewModelScope.launch {
			appUseCases.bookmarkFlight(bookmarkedFlight)
		}
	}
}