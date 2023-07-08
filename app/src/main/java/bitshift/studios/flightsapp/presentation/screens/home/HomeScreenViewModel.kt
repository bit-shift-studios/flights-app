package bitshift.studios.flightsapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {
	data class HomeScreenUIState(
		val searchQuery: String = ""
	)

	private val _homeScreenUIState: MutableStateFlow<HomeScreenUIState> = MutableStateFlow(HomeScreenUIState())
	val uiState: StateFlow<HomeScreenUIState> = _homeScreenUIState.asStateFlow()

	fun updateSearchQuery(newQuery: String) {
		_homeScreenUIState.update { state ->
			state.copy(searchQuery = newQuery)
		}
	}
}