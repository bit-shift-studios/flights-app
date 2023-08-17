package bitshift.studios.flightsapp.presentation.screens.home.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.domain.usecases.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeScreenUIState(
	val isLoading: Boolean = false,
	val searchQuery: String = "",
	val searchResults: List<AirportEntity> = emptyList()
)

private const val TAG = "VIEWMODEL"

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val useCases: AppUseCases) : ViewModel() {

	private val _homeScreenUIState = MutableStateFlow(HomeScreenUIState())
	val uiState: StateFlow<HomeScreenUIState> = _homeScreenUIState.asStateFlow()

	fun getBookmarkedFlights() = useCases.getBookmarkedFlights()

	fun clearSearchQuery() {
		_homeScreenUIState.update { state ->
			state.copy(searchQuery = "")
		}
	}

	fun updateSearchQuery(newQuery: String) {
		viewModelScope.launch {
			_homeScreenUIState.update { state ->
				state.copy(
					isLoading = true,
					searchQuery = newQuery
				)
			}

			delay(500)

			useCases.getAirportsMatching(newQuery)
				.catch { err ->
					Log.d(TAG, "Error getting matching airports: $err")
				}
				.collect { airports ->
					_homeScreenUIState.update { state ->
						state.copy(
							isLoading = false,
							searchResults = airports
						)
					}
				}
		}
	}
}