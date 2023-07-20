package bitshift.studios.flightsapp.data.repository

import bitshift.studios.flightsapp.data.db.bookmarked.BookmarkedFlightsDao
import bitshift.studios.flightsapp.data.db.bookmarked.entities.BookmarkedFlightEntity
import bitshift.studios.flightsapp.domain.repository.BookmarkedFlightsDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookmarkedFlightsDataRepositoryImpl @Inject constructor (
	private val bookmarkedFlightsDao: BookmarkedFlightsDao
) : BookmarkedFlightsDataRepository {
	override fun getBookmarkedAirports(): Flow<List<BookmarkedFlightEntity>> {
		return bookmarkedFlightsDao.getBookmarkedAirports()
	}

	override suspend fun isAirportBookmarked(code: String): Boolean {
		return bookmarkedFlightsDao.isAirportBookmarked(code)
	}

	override suspend fun addAirportToBookmarks(airport: BookmarkedFlightEntity) {
		return bookmarkedFlightsDao.addAirportToBookmarks(airport)
	}

	override suspend fun removeAirportFromBookmarks(airport: BookmarkedFlightEntity) {
		return bookmarkedFlightsDao.removeAirportFromBookmarks(airport)
	}
}