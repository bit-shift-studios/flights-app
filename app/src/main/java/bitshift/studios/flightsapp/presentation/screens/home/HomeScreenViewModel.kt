package bitshift.studios.flightsapp.presentation.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bitshift.studios.flightsapp.domain.repository.FlightDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

private const val TAG = "HOME"

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
	private val flightDataRepository: FlightDataRepository
) : ViewModel() {
	data class HomeScreenUIState(
		val searchQuery: String = ""
	)

	private val _homeScreenUIState: MutableStateFlow<HomeScreenUIState> = MutableStateFlow(HomeScreenUIState())
	val uiState: StateFlow<HomeScreenUIState> = _homeScreenUIState.asStateFlow()

	init {
		viewModelScope.launch {
			try {
				val test = withContext(Dispatchers.IO) {
					flightDataRepository.getAirportByCode("DUB")
				}

				test?.let {
					Log.d(TAG, it.name)
				}
			} catch (ioe: IOException) {
				error(ioe)
			}
		}
	}

	fun updateSearchQuery(newQuery: String) {
		_homeScreenUIState.update { state ->
			state.copy(searchQuery = newQuery)
		}
	}
}