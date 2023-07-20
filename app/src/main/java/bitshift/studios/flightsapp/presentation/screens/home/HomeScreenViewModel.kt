package bitshift.studios.flightsapp.presentation.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.domain.usecases.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeScreenUIState(
	val searchQuery: String = ""
)

private const val TAG = "AIR"

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val useCases: AppUseCases) : ViewModel() {

	private val _homeScreenUIState = MutableStateFlow(HomeScreenUIState())
	val uiState: StateFlow<HomeScreenUIState> = _homeScreenUIState.asStateFlow()

	private val _searchResults: MutableStateFlow<List<AirportEntity>> = MutableStateFlow(emptyList())
	val searchResults = _searchResults.asStateFlow()

	private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
	val isLoading = _isLoading.asStateFlow()

	@OptIn(ExperimentalCoroutinesApi::class)
	fun updateSearchQuery(newQuery: String) {
		viewModelScope.launch {
			_homeScreenUIState.update { state ->
				state.copy(
					searchQuery = newQuery
				)
			}
		}

		viewModelScope.launch {
			_isLoading.value = true

			useCases.getAirportsMatching(newQuery)
				.onStart { delay(1000) }
				.flatMapLatest { airports ->
					_isLoading.value = false
					flowOf(airports)
				}
				.catch { ioe ->
					Log.d(TAG, "Error fetching airports: $ioe")
				}
				.collect { airports ->
					_searchResults.value = airports
				}
		}
	}
}