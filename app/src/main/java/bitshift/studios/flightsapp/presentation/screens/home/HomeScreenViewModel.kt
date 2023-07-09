package bitshift.studios.flightsapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.domain.repository.FlightDataRepository
import bitshift.studios.flightsapp.domain.usecases.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

private const val TAG = "HOME"

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
	private val flightDataRepository: FlightDataRepository,
	private val useCases: AppUseCases
) : ViewModel() {
	data class HomeScreenUIState(
		val searchQuery: String = "",
		val searchResults: Flow<List<AirportEntity>> = emptyFlow()
	)

	private val _homeScreenUIState: MutableStateFlow<HomeScreenUIState> = MutableStateFlow(HomeScreenUIState())
	val uiState: StateFlow<HomeScreenUIState> = _homeScreenUIState.asStateFlow()

	fun updateSearchQuery(newQuery: String) {
		_homeScreenUIState.update { state ->
			val searchQueryResults = useCases.getAirportsMatching(newQuery)

			state.copy(
				searchQuery = newQuery,
				searchResults = searchQueryResults
			)
		}
	}
}