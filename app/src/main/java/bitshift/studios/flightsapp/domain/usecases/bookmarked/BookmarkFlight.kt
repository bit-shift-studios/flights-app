package bitshift.studios.flightsapp.domain.usecases.bookmarked

import bitshift.studios.flightsapp.data.db.bookmarked.entities.BookmarkedFlightEntity
import bitshift.studios.flightsapp.domain.repository.BookmarkedFlightsDataRepository

class BookmarkFlight(private val bookmarkedFlightsDataRepository: BookmarkedFlightsDataRepository) {
	suspend operator fun invoke(flight: BookmarkedFlightEntity) {
		bookmarkedFlightsDataRepository.addAirportToBookmarks(flight)
	}
}