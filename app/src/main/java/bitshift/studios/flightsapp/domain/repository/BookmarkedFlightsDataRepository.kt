package bitshift.studios.flightsapp.domain.repository

import bitshift.studios.flightsapp.data.db.bookmarked.entities.BookmarkedAirportEntity
import kotlinx.coroutines.flow.Flow

interface BookmarkedFlightsDataRepository {
	fun getBookmarkedAirports(): Flow<List<BookmarkedAirportEntity>>
	suspend fun isAirportBookmarked(): Boolean
	suspend fun addAirportToBookmarks(airport: BookmarkedAirportEntity)
	suspend fun removeAirportFromBookmarks(airport: BookmarkedAirportEntity)
}