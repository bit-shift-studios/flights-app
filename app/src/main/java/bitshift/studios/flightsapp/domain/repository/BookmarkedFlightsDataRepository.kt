package bitshift.studios.flightsapp.domain.repository

import bitshift.studios.flightsapp.data.db.bookmarked.entities.BookmarkedFlightEntity
import kotlinx.coroutines.flow.Flow

interface BookmarkedFlightsDataRepository {
	fun getBookmarkedAirports(): Flow<List<BookmarkedFlightEntity>>
	suspend fun isAirportBookmarked(code: String): Boolean
	suspend fun addAirportToBookmarks(airport: BookmarkedFlightEntity)
	suspend fun removeAirportFromBookmarks(airport: BookmarkedFlightEntity)
}