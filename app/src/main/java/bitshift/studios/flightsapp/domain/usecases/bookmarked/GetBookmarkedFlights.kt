package bitshift.studios.flightsapp.domain.usecases.bookmarked

import bitshift.studios.flightsapp.data.db.bookmarked.entities.BookmarkedFlightEntity
import bitshift.studios.flightsapp.domain.repository.BookmarkedFlightsDataRepository
import kotlinx.coroutines.flow.Flow

class GetBookmarkedFlights(private val bookmarkedFlightsDataRepository: BookmarkedFlightsDataRepository) {
	operator fun invoke(): Flow<List<BookmarkedFlightEntity>> {
		return bookmarkedFlightsDataRepository.getBookmarkedAirports()
	}
}